package androidx.multidex;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.util.f;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
/* loaded from: classes.dex */
public final class MultiDexExtractor implements Closeable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BUFFER_SIZE = 16384;
    public static final String DEX_PREFIX = "classes";
    public static final String DEX_SUFFIX = ".dex";
    public static final String EXTRACTED_NAME_EXT = ".classes";
    public static final String EXTRACTED_SUFFIX = ".zip";
    public static final String KEY_CRC = "crc";
    public static final String KEY_DEX_CRC = "dex.crc.";
    public static final String KEY_DEX_NUMBER = "dex.number";
    public static final String KEY_DEX_TIME = "dex.time.";
    public static final String KEY_TIME_STAMP = "timestamp";
    public static final String LOCK_FILENAME = "MultiDex.lock";
    public static final int MAX_EXTRACT_ATTEMPTS = 3;
    public static final long NO_VALUE = -1;
    public static final String PREFS_FILE = "multidex.version";
    public static final String TAG = "MultiDex";
    public transient /* synthetic */ FieldHolder $fh;
    public final FileLock cacheLock;
    public final File dexDir;
    public final FileChannel lockChannel;
    public final RandomAccessFile lockRaf;
    public final File sourceApk;
    public final long sourceCrc;

    /* loaded from: classes.dex */
    public static class ExtractedDex extends File {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long crc;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ExtractedDex(File file, String str) {
            super(file, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {file, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((File) objArr2[0], (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.crc = -1L;
        }
    }

    public MultiDexExtractor(File file, File file2) throws IOException {
        File file3;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file, file2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        String str = "MultiDexExtractor(" + file.getPath() + StringUtil.ARRAY_ELEMENT_SEPARATOR + file2.getPath() + SmallTailInfo.EMOTION_SUFFIX;
        this.sourceApk = file;
        this.dexDir = file2;
        this.sourceCrc = getZipCrc(file);
        RandomAccessFile randomAccessFile = new RandomAccessFile(new File(file2, LOCK_FILENAME), "rw");
        this.lockRaf = randomAccessFile;
        try {
            this.lockChannel = randomAccessFile.getChannel();
            try {
                String str2 = "Blocking on lock " + file3.getPath();
                this.cacheLock = this.lockChannel.lock();
                String str3 = file3.getPath() + " locked";
            } catch (IOException e2) {
                e = e2;
                closeQuietly(this.lockChannel);
                throw e;
            } catch (Error e3) {
                e = e3;
                closeQuietly(this.lockChannel);
                throw e;
            } catch (RuntimeException e4) {
                e = e4;
                closeQuietly(this.lockChannel);
                throw e;
            }
        } catch (IOException | Error | RuntimeException e5) {
            closeQuietly(this.lockRaf);
            throw e5;
        }
    }

    private void clearDexDir() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            File[] listFiles = this.dexDir.listFiles(new FileFilter(this) { // from class: androidx.multidex.MultiDexExtractor.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MultiDexExtractor this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, file)) == null) ? !file.getName().equals(MultiDexExtractor.LOCK_FILENAME) : invokeL.booleanValue;
                }
            });
            if (listFiles == null) {
                String str = "Failed to list secondary dex dir content (" + this.dexDir.getPath() + ").";
                return;
            }
            for (File file : listFiles) {
                String str2 = "Trying to delete old file " + file.getPath() + " of size " + file.length();
                if (file.delete()) {
                    String str3 = "Deleted old file " + file.getPath();
                } else {
                    String str4 = "Failed to delete old file " + file.getPath();
                }
            }
        }
    }

    public static void closeQuietly(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, closeable) == null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void extract(ZipFile zipFile, ZipEntry zipEntry, File file, String str) throws IOException, FileNotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65539, null, zipFile, zipEntry, file, str) == null) {
            InputStream inputStream = zipFile.getInputStream(zipEntry);
            File createTempFile = File.createTempFile("tmp-" + str, ".zip", file.getParentFile());
            String str2 = "Extracting " + createTempFile.getPath();
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
                if (createTempFile.setReadOnly()) {
                    String str3 = "Renaming to " + file.getPath();
                    if (createTempFile.renameTo(file)) {
                        return;
                    }
                    throw new IOException("Failed to rename \"" + createTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
                }
                throw new IOException("Failed to mark readonly \"" + createTempFile.getAbsolutePath() + "\" (tmp of \"" + file.getAbsolutePath() + "\")");
            } finally {
                closeQuietly(inputStream);
                createTempFile.delete();
            }
        }
    }

    public static SharedPreferences getMultiDexPreferences(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            return context.getSharedPreferences("multidex.version", Build.VERSION.SDK_INT < 11 ? 0 : 4);
        }
        return (SharedPreferences) invokeL.objValue;
    }

    public static long getTimeStamp(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, file)) == null) {
            long lastModified = file.lastModified();
            return lastModified == -1 ? lastModified - 1 : lastModified;
        }
        return invokeL.longValue;
    }

    public static long getZipCrc(File file) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, file)) == null) {
            long zipCrc = ZipUtil.getZipCrc(file);
            return zipCrc == -1 ? zipCrc - 1 : zipCrc;
        }
        return invokeL.longValue;
    }

    public static boolean isModified(Context context, File file, long j2, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{context, file, Long.valueOf(j2), str})) == null) {
            SharedPreferences multiDexPreferences = getMultiDexPreferences(context);
            if (multiDexPreferences.getLong(str + "timestamp", -1L) == getTimeStamp(file)) {
                if (multiDexPreferences.getLong(str + KEY_CRC, -1L) == j2) {
                    return false;
                }
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    private List<ExtractedDex> loadExistingExtractions(Context context, String str) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, this, context, str)) == null) {
            String str2 = this.sourceApk.getName() + ".classes";
            SharedPreferences multiDexPreferences = getMultiDexPreferences(context);
            int i2 = multiDexPreferences.getInt(str + "dex.number", 1);
            ArrayList arrayList = new ArrayList(i2 + (-1));
            int i3 = 2;
            while (i3 <= i2) {
                ExtractedDex extractedDex = new ExtractedDex(this.dexDir, str2 + i3 + ".zip");
                if (extractedDex.isFile()) {
                    extractedDex.crc = getZipCrc(extractedDex);
                    long j2 = multiDexPreferences.getLong(str + KEY_DEX_CRC + i3, -1L);
                    long j3 = multiDexPreferences.getLong(str + KEY_DEX_TIME + i3, -1L);
                    long lastModified = extractedDex.lastModified();
                    if (j3 == lastModified) {
                        String str3 = str2;
                        SharedPreferences sharedPreferences = multiDexPreferences;
                        if (j2 == extractedDex.crc) {
                            arrayList.add(extractedDex);
                            i3++;
                            multiDexPreferences = sharedPreferences;
                            str2 = str3;
                        }
                    }
                    throw new IOException("Invalid extracted dex: " + extractedDex + " (key \"" + str + "\"), expected modification time: " + j3 + ", modification time: " + lastModified + ", expected crc: " + j2 + ", file crc: " + extractedDex.crc);
                }
                throw new IOException("Missing extracted secondary dex file '" + extractedDex.getPath() + "'");
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    private List<ExtractedDex> performExtractions() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            String str = this.sourceApk.getName() + ".classes";
            clearDexDir();
            ArrayList arrayList = new ArrayList();
            ZipFile zipFile = new ZipFile(this.sourceApk);
            int i2 = 2;
            try {
                ZipEntry entry = zipFile.getEntry(DEX_PREFIX + "2.dex");
                while (entry != null) {
                    ExtractedDex extractedDex = new ExtractedDex(this.dexDir, str + i2 + ".zip");
                    arrayList.add(extractedDex);
                    String str2 = "Extraction is needed for file " + extractedDex;
                    int i3 = 0;
                    boolean z = false;
                    while (i3 < 3 && !z) {
                        i3++;
                        extract(zipFile, entry, extractedDex, str);
                        try {
                            extractedDex.crc = getZipCrc(extractedDex);
                            z = true;
                        } catch (IOException unused) {
                            String str3 = "Failed to read crc from " + extractedDex.getAbsolutePath();
                            z = false;
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("Extraction ");
                        sb.append(z ? "succeeded" : f.f30928j);
                        sb.append(" '");
                        sb.append(extractedDex.getAbsolutePath());
                        sb.append("': length ");
                        sb.append(extractedDex.length());
                        sb.append(" - crc: ");
                        sb.append(extractedDex.crc);
                        sb.toString();
                        if (!z) {
                            extractedDex.delete();
                            if (extractedDex.exists()) {
                                String str4 = "Failed to delete corrupted secondary dex '" + extractedDex.getPath() + "'";
                            }
                        }
                    }
                    if (z) {
                        i2++;
                        entry = zipFile.getEntry(DEX_PREFIX + i2 + ".dex");
                    } else {
                        throw new IOException("Could not create zip file " + extractedDex.getAbsolutePath() + " for secondary dex (" + i2 + SmallTailInfo.EMOTION_SUFFIX);
                    }
                }
                return arrayList;
            } finally {
                try {
                    zipFile.close();
                } catch (IOException unused2) {
                }
            }
        }
        return (List) invokeV.objValue;
    }

    public static void putStoredApkInfo(Context context, String str, long j2, long j3, List<ExtractedDex> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{context, str, Long.valueOf(j2), Long.valueOf(j3), list}) == null) {
            SharedPreferences.Editor edit = getMultiDexPreferences(context).edit();
            edit.putLong(str + "timestamp", j2);
            edit.putLong(str + KEY_CRC, j3);
            edit.putInt(str + "dex.number", list.size() + 1);
            int i2 = 2;
            for (ExtractedDex extractedDex : list) {
                edit.putLong(str + KEY_DEX_CRC + i2, extractedDex.crc);
                edit.putLong(str + KEY_DEX_TIME + i2, extractedDex.lastModified());
                i2++;
            }
            edit.commit();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.cacheLock.release();
            this.lockChannel.close();
            this.lockRaf.close();
        }
    }

    public List<? extends File> load(Context context, String str, boolean z) throws IOException {
        InterceptResult invokeLLZ;
        List<ExtractedDex> performExtractions;
        List<ExtractedDex> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, z)) == null) {
            String str2 = "MultiDexExtractor.load(" + this.sourceApk.getPath() + StringUtil.ARRAY_ELEMENT_SEPARATOR + z + StringUtil.ARRAY_ELEMENT_SEPARATOR + str + SmallTailInfo.EMOTION_SUFFIX;
            if (this.cacheLock.isValid()) {
                if (!z && !isModified(context, this.sourceApk, this.sourceCrc, str)) {
                    try {
                        list = loadExistingExtractions(context, str);
                    } catch (IOException unused) {
                        performExtractions = performExtractions();
                        putStoredApkInfo(context, str, getTimeStamp(this.sourceApk), this.sourceCrc, performExtractions);
                    }
                    String str3 = "load found " + list.size() + " secondary dex files";
                    return list;
                }
                performExtractions = performExtractions();
                putStoredApkInfo(context, str, getTimeStamp(this.sourceApk), this.sourceCrc, performExtractions);
                list = performExtractions;
                String str32 = "load found " + list.size() + " secondary dex files";
                return list;
            }
            throw new IllegalStateException("MultiDexExtractor was closed");
        }
        return (List) invokeLLZ.objValue;
    }
}
