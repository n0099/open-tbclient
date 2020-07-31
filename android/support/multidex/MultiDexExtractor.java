package android.support.multidex;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
/* loaded from: classes8.dex */
final class MultiDexExtractor {
    private static final int BUFFER_SIZE = 16384;
    private static final String DEX_PREFIX = "classes";
    private static final String DEX_SUFFIX = ".dex";
    private static final String EXTRACTED_NAME_EXT = ".classes";
    private static final String EXTRACTED_SUFFIX = ".zip";
    private static final String KEY_CRC = "crc";
    private static final String KEY_DEX_CRC = "dex.crc.";
    private static final String KEY_DEX_NUMBER = "dex.number";
    private static final String KEY_DEX_TIME = "dex.time.";
    private static final String KEY_TIME_STAMP = "timestamp";
    private static final String LOCK_FILENAME = "MultiDex.lock";
    private static final int MAX_EXTRACT_ATTEMPTS = 3;
    private static final long NO_VALUE = -1;
    private static final String PREFS_FILE = "multidex.version";
    private static final String TAG = "MultiDex";

    MultiDexExtractor() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class ExtractedDex extends File {
        public long crc;

        public ExtractedDex(File file, String str) {
            super(file, str);
            this.crc = -1L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<? extends File> load(Context context, File file, File file2, String str, boolean z) throws IOException {
        File file3;
        List<ExtractedDex> performExtractions;
        Log.i(TAG, "MultiDexExtractor.load(" + file.getPath() + ", " + z + ", " + str + ")");
        long zipCrc = getZipCrc(file);
        RandomAccessFile randomAccessFile = new RandomAccessFile(new File(file2, LOCK_FILENAME), "rw");
        FileChannel fileChannel = null;
        FileLock fileLock = null;
        try {
            FileChannel channel = randomAccessFile.getChannel();
            try {
                Log.i(TAG, "Blocking on lock " + file3.getPath());
                FileLock lock = channel.lock();
                try {
                    Log.i(TAG, file3.getPath() + " locked");
                    if (!z && !isModified(context, file, zipCrc, str)) {
                        try {
                            performExtractions = loadExistingExtractions(context, file, file2, str);
                        } catch (IOException e) {
                            Log.w(TAG, "Failed to reload existing extracted secondary dex files, falling back to fresh extraction", e);
                            performExtractions = performExtractions(file, file2);
                            putStoredApkInfo(context, str, getTimeStamp(file), zipCrc, performExtractions);
                        }
                    } else {
                        Log.i(TAG, "Detected that extraction must be performed.");
                        performExtractions = performExtractions(file, file2);
                        putStoredApkInfo(context, str, getTimeStamp(file), zipCrc, performExtractions);
                    }
                    if (lock == null) {
                        e = null;
                    } else {
                        try {
                            lock.release();
                            e = null;
                        } catch (IOException e2) {
                            e = e2;
                            Log.e(TAG, "Failed to release lock on " + file3.getPath());
                        }
                    }
                    if (channel != null) {
                        closeQuietly(channel);
                    }
                    closeQuietly(randomAccessFile);
                    if (e != null) {
                        throw e;
                    }
                    Log.i(TAG, "load found " + performExtractions.size() + " secondary dex files");
                    return performExtractions;
                } catch (Throwable th) {
                    th = th;
                    fileLock = lock;
                    fileChannel = channel;
                    if (fileLock != null) {
                        try {
                            fileLock.release();
                        } catch (IOException e3) {
                            Log.e(TAG, "Failed to release lock on " + file3.getPath());
                        }
                    }
                    if (fileChannel != null) {
                        closeQuietly(fileChannel);
                    }
                    closeQuietly(randomAccessFile);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileChannel = channel;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private static List<ExtractedDex> loadExistingExtractions(Context context, File file, File file2, String str) throws IOException {
        Log.i(TAG, "loading existing secondary dex files");
        String str2 = file.getName() + EXTRACTED_NAME_EXT;
        SharedPreferences multiDexPreferences = getMultiDexPreferences(context);
        int i = multiDexPreferences.getInt(str + KEY_DEX_NUMBER, 1);
        ArrayList arrayList = new ArrayList(i - 1);
        for (int i2 = 2; i2 <= i; i2++) {
            ExtractedDex extractedDex = new ExtractedDex(file2, str2 + i2 + EXTRACTED_SUFFIX);
            if (extractedDex.isFile()) {
                extractedDex.crc = getZipCrc(extractedDex);
                long j = multiDexPreferences.getLong(str + KEY_DEX_CRC + i2, -1L);
                long j2 = multiDexPreferences.getLong(str + KEY_DEX_TIME + i2, -1L);
                long lastModified = extractedDex.lastModified();
                if (j2 != lastModified || j != extractedDex.crc) {
                    throw new IOException("Invalid extracted dex: " + extractedDex + " (key \"" + str + "\"), expected modification time: " + j2 + ", modification time: " + lastModified + ", expected crc: " + j + ", file crc: " + extractedDex.crc);
                }
                arrayList.add(extractedDex);
            } else {
                throw new IOException("Missing extracted secondary dex file '" + extractedDex.getPath() + "'");
            }
        }
        return arrayList;
    }

    private static boolean isModified(Context context, File file, long j, String str) {
        SharedPreferences multiDexPreferences = getMultiDexPreferences(context);
        return (multiDexPreferences.getLong(new StringBuilder().append(str).append("timestamp").toString(), -1L) == getTimeStamp(file) && multiDexPreferences.getLong(new StringBuilder().append(str).append(KEY_CRC).toString(), -1L) == j) ? false : true;
    }

    private static long getTimeStamp(File file) {
        long lastModified = file.lastModified();
        if (lastModified == -1) {
            return lastModified - 1;
        }
        return lastModified;
    }

    private static long getZipCrc(File file) throws IOException {
        long zipCrc = ZipUtil.getZipCrc(file);
        if (zipCrc == -1) {
            return zipCrc - 1;
        }
        return zipCrc;
    }

    private static List<ExtractedDex> performExtractions(File file, File file2) throws IOException {
        String str = file.getName() + EXTRACTED_NAME_EXT;
        prepareDexDir(file2, str);
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(file);
        try {
            ZipEntry entry = zipFile.getEntry(DEX_PREFIX + 2 + DEX_SUFFIX);
            int i = 2;
            while (entry != null) {
                ExtractedDex extractedDex = new ExtractedDex(file2, str + i + EXTRACTED_SUFFIX);
                arrayList.add(extractedDex);
                Log.i(TAG, "Extraction is needed for file " + extractedDex);
                boolean z = false;
                int i2 = 0;
                while (i2 < 3 && !z) {
                    int i3 = i2 + 1;
                    extract(zipFile, entry, extractedDex, str);
                    try {
                        extractedDex.crc = getZipCrc(extractedDex);
                        z = true;
                    } catch (IOException e) {
                        Log.w(TAG, "Failed to read crc from " + extractedDex.getAbsolutePath(), e);
                        z = false;
                    }
                    Log.i(TAG, "Extraction " + (z ? "succeeded" : "failed") + " - length " + extractedDex.getAbsolutePath() + ": " + extractedDex.length() + " - crc: " + extractedDex.crc);
                    if (!z) {
                        extractedDex.delete();
                        if (extractedDex.exists()) {
                            Log.w(TAG, "Failed to delete corrupted secondary dex '" + extractedDex.getPath() + "'");
                            i2 = i3;
                        }
                    }
                    i2 = i3;
                }
                if (!z) {
                    throw new IOException("Could not create zip file " + extractedDex.getAbsolutePath() + " for secondary dex (" + i + ")");
                }
                int i4 = i + 1;
                entry = zipFile.getEntry(DEX_PREFIX + i4 + DEX_SUFFIX);
                i = i4;
            }
            return arrayList;
        } finally {
            try {
                zipFile.close();
            } catch (IOException e2) {
                Log.w(TAG, "Failed to close resource", e2);
            }
        }
    }

    private static void putStoredApkInfo(Context context, String str, long j, long j2, List<ExtractedDex> list) {
        SharedPreferences.Editor edit = getMultiDexPreferences(context).edit();
        edit.putLong(str + "timestamp", j);
        edit.putLong(str + KEY_CRC, j2);
        edit.putInt(str + KEY_DEX_NUMBER, list.size() + 1);
        int i = 2;
        Iterator<ExtractedDex> it = list.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                ExtractedDex next = it.next();
                edit.putLong(str + KEY_DEX_CRC + i2, next.crc);
                edit.putLong(str + KEY_DEX_TIME + i2, next.lastModified());
                i = i2 + 1;
            } else {
                edit.commit();
                return;
            }
        }
    }

    private static SharedPreferences getMultiDexPreferences(Context context) {
        return context.getSharedPreferences(PREFS_FILE, Build.VERSION.SDK_INT < 11 ? 0 : 4);
    }

    private static void prepareDexDir(File file, final String str) {
        File[] listFiles = file.listFiles(new FileFilter() { // from class: android.support.multidex.MultiDexExtractor.1
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                String name = file2.getName();
                return (name.startsWith(str) || name.equals(MultiDexExtractor.LOCK_FILENAME)) ? false : true;
            }
        });
        if (listFiles == null) {
            Log.w(TAG, "Failed to list secondary dex dir content (" + file.getPath() + ").");
            return;
        }
        for (File file2 : listFiles) {
            Log.i(TAG, "Trying to delete old file " + file2.getPath() + " of size " + file2.length());
            if (!file2.delete()) {
                Log.w(TAG, "Failed to delete old file " + file2.getPath());
            } else {
                Log.i(TAG, "Deleted old file " + file2.getPath());
            }
        }
    }

    private static void extract(ZipFile zipFile, ZipEntry zipEntry, File file, String str) throws IOException, FileNotFoundException {
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File createTempFile = File.createTempFile("tmp-" + str, EXTRACTED_SUFFIX, file.getParentFile());
        Log.i(TAG, "Extracting " + createTempFile.getPath());
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(createTempFile)));
            ZipEntry zipEntry2 = new ZipEntry("classes.dex");
            zipEntry2.setTime(zipEntry.getTime());
            zipOutputStream.putNextEntry(zipEntry2);
            byte[] bArr = new byte[16384];
            for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                zipOutputStream.write(bArr, 0, read);
            }
            zipOutputStream.closeEntry();
            zipOutputStream.close();
            if (!createTempFile.setReadOnly()) {
                throw new IOException("Failed to mark readonly \"" + createTempFile.getAbsolutePath() + "\" (tmp of \"" + file.getAbsolutePath() + "\")");
            }
            Log.i(TAG, "Renaming to " + file.getPath());
            if (!createTempFile.renameTo(file)) {
                throw new IOException("Failed to rename \"" + createTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
            }
        } finally {
            closeQuietly(inputStream);
            createTempFile.delete();
        }
    }

    private static void closeQuietly(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e) {
            Log.w(TAG, "Failed to close resource", e);
        }
    }
}
