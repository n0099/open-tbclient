package com.baidu.swan.d;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
/* loaded from: classes11.dex */
public final class c {
    private static String sCacheDir = null;
    private static int INVALID_INDEX = -1;
    private static int ONE_INCREAMENT = 1;

    public static boolean isExistFile(String str) {
        return !TextUtils.isEmpty(str) && new File(str).exists();
    }

    public static boolean deleteFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            return deleteFile(file);
        }
        return false;
    }

    public static boolean deleteFile(File file) {
        if (file == null) {
            return false;
        }
        boolean z = true;
        if (file.exists()) {
            if (file.isFile()) {
                z = true & file.delete();
            } else if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        z &= deleteFile(file2);
                    }
                }
                z &= file.delete();
            }
        }
        return z;
    }

    public static boolean saveFile(String str, File file) {
        if (TextUtils.isEmpty(str) || file.exists()) {
            return false;
        }
        saveFileCommon(str.getBytes(), file);
        return true;
    }

    public static void saveFileCommon(byte[] bArr, File file) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        saveToFile(byteArrayInputStream, file);
        closeSafely(byteArrayInputStream);
    }

    public static void saveToFile(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                try {
                    copyStream(inputStream, fileOutputStream);
                    closeSafely(fileOutputStream);
                } catch (FileNotFoundException e) {
                    e = e;
                    e.printStackTrace();
                    closeSafely(fileOutputStream);
                }
            } catch (Throwable th) {
                th = th;
                closeSafely(fileOutputStream);
                throw th;
            }
        } catch (FileNotFoundException e2) {
            e = e2;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            closeSafely(fileOutputStream);
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [395=4] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.OutputStream, java.io.Closeable, java.io.FileOutputStream] */
    public static long copyFile(File file, File file2) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        ?? fileOutputStream;
        FileInputStream fileInputStream3 = null;
        long j = 0;
        if (file != null && file2 != null && file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    fileOutputStream = new FileOutputStream(file2);
                } catch (Exception e) {
                    e = e;
                    fileInputStream2 = null;
                    fileInputStream3 = fileInputStream;
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    j = copyStream(fileInputStream, fileOutputStream);
                    closeSafely(fileInputStream);
                    closeSafely(fileOutputStream);
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream3 = fileInputStream;
                    fileInputStream2 = fileOutputStream;
                    try {
                        e.printStackTrace();
                        closeSafely(fileInputStream3);
                        closeSafely(fileInputStream2);
                        return j;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream3;
                        fileInputStream3 = fileInputStream2;
                        closeSafely(fileInputStream);
                        closeSafely(fileInputStream3);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream3 = fileOutputStream;
                    closeSafely(fileInputStream);
                    closeSafely(fileInputStream3);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                fileInputStream2 = null;
            } catch (Throwable th4) {
                th = th4;
                fileInputStream = null;
            }
        }
        return j;
    }

    public static void i(File file, File file2) {
        String[] list;
        if (file != null && file2 != null && (list = file.list()) != null && list.length != 0) {
            ensureDirectoryExist(file2);
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    File file3 = new File(file, str);
                    File file4 = new File(file2, str);
                    if (file3.isDirectory()) {
                        i(file3, file4);
                    }
                    if (file3.isFile()) {
                        createNewFileSafely(file4);
                        copyFile(file3, file4);
                    }
                }
            }
        }
    }

    public static long copyStream(InputStream inputStream, OutputStream outputStream) {
        if (inputStream == null || outputStream == null) {
            return 0L;
        }
        try {
            byte[] bArr = new byte[3072];
            long j = 0;
            while (true) {
                int read = inputStream.read(bArr);
                if (read > 0) {
                    outputStream.write(bArr, 0, read);
                    j += read;
                } else {
                    outputStream.flush();
                    return j;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static String readFileData(File file) {
        try {
            return readInputStream(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            return "";
        }
    }

    public static boolean cache(Context context, String str, String str2, int i) {
        return cache(context, str, str2.getBytes(), i);
    }

    public static boolean cache(Context context, String str, byte[] bArr, int i) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    fileOutputStream = context.openFileOutput(str, i);
                    fileOutputStream.write(bArr);
                    fileOutputStream.flush();
                    closeSafely(fileOutputStream);
                    return true;
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    closeSafely(fileOutputStream);
                    return false;
                }
            } catch (IOException e2) {
                e2.printStackTrace();
                closeSafely(fileOutputStream);
                return false;
            }
        } catch (Throwable th) {
            closeSafely(fileOutputStream);
            throw th;
        }
    }

    public static String readCacheData(Context context, String str) {
        try {
            return readInputStream(context.openFileInput(str));
        } catch (FileNotFoundException e) {
            return "";
        }
    }

    private static String readInputStream(FileInputStream fileInputStream) {
        if (fileInputStream == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    return sb.toString();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        } finally {
            closeSafely(fileInputStream);
        }
    }

    public static boolean rf(String str) {
        return !TextUtils.isEmpty(str) && safeDeleteFile(new File(str));
    }

    public static boolean safeDeleteFile(File file) {
        boolean deleteFile;
        if (file != null) {
            try {
                if (file.exists()) {
                    String absolutePath = file.getAbsolutePath();
                    File file2 = new File(absolutePath);
                    File file3 = new File(absolutePath + System.currentTimeMillis() + ".tmp");
                    if (file2.renameTo(file3)) {
                        deleteFile = deleteFile(file3);
                    } else {
                        deleteFile = deleteFile(file);
                    }
                    return deleteFile;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        deleteFile = true;
        return deleteFile;
    }

    public static boolean createNewFileSafely(File file) {
        if (file == null || file.exists()) {
            return false;
        }
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        try {
            return file.createNewFile();
        } catch (IOException e) {
            return false;
        }
    }

    public static boolean unzipFile(String str, String str2) {
        return ci(str, str2) == null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1046=4] */
    public static Exception ci(String str, String str2) {
        ZipFile zipFile;
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream2;
        BufferedInputStream bufferedInputStream2;
        BufferedOutputStream bufferedOutputStream3;
        ZipFile zipFile2 = null;
        System.currentTimeMillis();
        if (str == null) {
            return new Exception("srcFileName is null");
        }
        if (str2 == null) {
            str2 = new File(str).getParent();
        }
        try {
            zipFile = new ZipFile(str);
            try {
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                bufferedOutputStream = null;
                bufferedInputStream = null;
                while (entries.hasMoreElements()) {
                    try {
                        ZipEntry nextElement = entries.nextElement();
                        if (!TextUtils.isEmpty(nextElement.getName()) && !rh(nextElement.getName())) {
                            File file = new File(str2 + "/" + nextElement.getName());
                            if (!nextElement.isDirectory()) {
                                if (!file.exists()) {
                                    createNewFileSafely(file);
                                }
                                BufferedInputStream bufferedInputStream3 = new BufferedInputStream(zipFile.getInputStream(nextElement));
                                try {
                                    bufferedOutputStream3 = new BufferedOutputStream(new FileOutputStream(file), 2048);
                                } catch (IOException e) {
                                    e = e;
                                    zipFile2 = zipFile;
                                    bufferedOutputStream2 = bufferedOutputStream;
                                    bufferedInputStream2 = bufferedInputStream3;
                                } catch (Throwable th) {
                                    th = th;
                                    bufferedInputStream = bufferedInputStream3;
                                }
                                try {
                                    byte[] bArr = new byte[2048];
                                    while (true) {
                                        int read = bufferedInputStream3.read(bArr, 0, 2048);
                                        if (read == -1) {
                                            break;
                                        }
                                        bufferedOutputStream3.write(bArr, 0, read);
                                    }
                                    closeSafely(bufferedInputStream3);
                                    closeSafely(bufferedOutputStream3);
                                    bufferedOutputStream = bufferedOutputStream3;
                                    bufferedInputStream = bufferedInputStream3;
                                } catch (IOException e2) {
                                    e = e2;
                                    zipFile2 = zipFile;
                                    bufferedInputStream2 = bufferedInputStream3;
                                    bufferedOutputStream2 = bufferedOutputStream3;
                                    try {
                                        e.printStackTrace();
                                        closeSafely(bufferedOutputStream2);
                                        closeSafely(bufferedInputStream2);
                                        closeSafely(zipFile2);
                                        System.currentTimeMillis();
                                        return e;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        bufferedInputStream = bufferedInputStream2;
                                        bufferedOutputStream = bufferedOutputStream2;
                                        zipFile = zipFile2;
                                        closeSafely(bufferedOutputStream);
                                        closeSafely(bufferedInputStream);
                                        closeSafely(zipFile);
                                        System.currentTimeMillis();
                                        throw th;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    bufferedOutputStream = bufferedOutputStream3;
                                    bufferedInputStream = bufferedInputStream3;
                                    closeSafely(bufferedOutputStream);
                                    closeSafely(bufferedInputStream);
                                    closeSafely(zipFile);
                                    System.currentTimeMillis();
                                    throw th;
                                }
                            } else if (!file.exists()) {
                                file.mkdirs();
                            }
                        }
                    } catch (IOException e3) {
                        e = e3;
                        zipFile2 = zipFile;
                        bufferedOutputStream2 = bufferedOutputStream;
                        bufferedInputStream2 = bufferedInputStream;
                    } catch (Throwable th4) {
                        th = th4;
                    }
                }
                closeSafely(bufferedOutputStream);
                closeSafely(bufferedInputStream);
                closeSafely(zipFile);
                System.currentTimeMillis();
                return null;
            } catch (IOException e4) {
                e = e4;
                bufferedInputStream2 = null;
                zipFile2 = zipFile;
                bufferedOutputStream2 = null;
            } catch (Throwable th5) {
                th = th5;
                bufferedOutputStream = null;
                bufferedInputStream = null;
            }
        } catch (IOException e5) {
            e = e5;
            bufferedOutputStream2 = null;
            bufferedInputStream2 = null;
        } catch (Throwable th6) {
            th = th6;
            zipFile = null;
            bufferedOutputStream = null;
            bufferedInputStream = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1116=4] */
    public static boolean cj(String str, String str2) {
        ZipInputStream zipInputStream;
        InputStream inputStream;
        InputStream inputStream2;
        BufferedOutputStream bufferedOutputStream;
        ZipInputStream zipInputStream2 = null;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            inputStream = AppRuntime.getAppContext().getAssets().open(str);
            try {
                zipInputStream = new ZipInputStream(inputStream);
            } catch (IOException e) {
                inputStream2 = inputStream;
            } catch (Throwable th) {
                th = th;
                zipInputStream = null;
            }
        } catch (IOException e2) {
            inputStream2 = null;
        } catch (Throwable th2) {
            th = th2;
            zipInputStream = null;
            inputStream = null;
        }
        try {
            byte[] bArr = new byte[1024];
            BufferedOutputStream bufferedOutputStream2 = null;
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    closeSafely(inputStream);
                    closeSafely(zipInputStream);
                    return true;
                } else if (!TextUtils.isEmpty(nextEntry.getName()) && !rh(nextEntry.getName())) {
                    File file2 = new File(str2 + File.separator + nextEntry.getName());
                    if (nextEntry.isDirectory()) {
                        if (!file2.exists()) {
                            file2.mkdir();
                        }
                    } else if (file2.exists()) {
                        continue;
                    } else {
                        createNewFileSafely(file2);
                        try {
                            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2), 2048);
                            while (true) {
                                try {
                                    int read = zipInputStream.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    bufferedOutputStream.write(bArr, 0, read);
                                } catch (Throwable th3) {
                                    th = th3;
                                    closeSafely(bufferedOutputStream);
                                    throw th;
                                }
                            }
                            closeSafely(bufferedOutputStream);
                            bufferedOutputStream2 = bufferedOutputStream;
                        } catch (Throwable th4) {
                            th = th4;
                            bufferedOutputStream = bufferedOutputStream2;
                        }
                    }
                }
            }
        } catch (IOException e3) {
            zipInputStream2 = zipInputStream;
            inputStream2 = inputStream;
            closeSafely(inputStream2);
            closeSafely(zipInputStream2);
            return false;
        } catch (Throwable th5) {
            th = th5;
            closeSafely(inputStream);
            closeSafely(zipInputStream);
            throw th;
        }
    }

    public static String getFileNameFromPath(String str) {
        if (TextUtils.isEmpty(str) || str.endsWith(File.separator)) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(File.separator);
        int length = str.length();
        if (lastIndexOf != INVALID_INDEX && length > lastIndexOf) {
            return str.substring(lastIndexOf + ONE_INCREAMENT, length);
        }
        return str;
    }

    public static String rg(String str) {
        int lastIndexOf;
        String fileNameFromPath = getFileNameFromPath(str);
        if (TextUtils.isEmpty(fileNameFromPath) || (lastIndexOf = fileNameFromPath.lastIndexOf(".")) == INVALID_INDEX || lastIndexOf == fileNameFromPath.length() - 1) {
            return "";
        }
        return fileNameFromPath.substring(lastIndexOf + 1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1275=4] */
    @Nullable
    public static String readAssetData(Context context, String str) {
        InputStream inputStream;
        Throwable th;
        BufferedReader bufferedReader;
        String str2 = null;
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                inputStream = context.getAssets().open(str);
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                } catch (IOException e) {
                    bufferedReader = null;
                } catch (Throwable th2) {
                    bufferedReader = null;
                    th = th2;
                }
            } catch (IOException e2) {
                bufferedReader = null;
                inputStream = null;
            } catch (Throwable th3) {
                inputStream = null;
                th = th3;
                bufferedReader = null;
            }
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                }
                str2 = sb.toString();
                closeSafely(inputStream);
                closeSafely(bufferedReader);
            } catch (IOException e3) {
                closeSafely(inputStream);
                closeSafely(bufferedReader);
                return str2;
            } catch (Throwable th4) {
                th = th4;
                closeSafely(inputStream);
                closeSafely(bufferedReader);
                throw th;
            }
        }
        return str2;
    }

    public static boolean ensureDirectoryExist(File file) {
        if (file == null) {
            return false;
        }
        if (!file.exists()) {
            try {
                file.mkdirs();
            } catch (SecurityException e) {
                return false;
            }
        }
        return true;
    }

    public static void closeSafely(@Nullable Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean rh(String str) {
        return str.contains("../");
    }

    public static boolean z(File file) {
        return file != null && file.exists() && file.isFile();
    }

    public static List<String> A(File file) {
        try {
            return a(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            return new ArrayList();
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION] complete} */
    private static List<String> a(FileInputStream fileInputStream) {
        ArrayList arrayList = new ArrayList();
        try {
            if (fileInputStream != null) {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            arrayList.add(readLine);
                        } else {
                            try {
                                break;
                            } catch (IOException e) {
                            }
                        }
                    }
                    fileInputStream.close();
                } catch (IOException e2) {
                    arrayList = new ArrayList();
                }
            }
            return arrayList;
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e3) {
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1533=4] */
    public static void a(@NonNull List<String> list, @NonNull File file) {
        FileWriter fileWriter;
        Throwable th;
        if (!file.exists()) {
            return;
        }
        FileWriter fileWriter2 = null;
        try {
            fileWriter = new FileWriter(file);
            for (int i = 0; i < list.size(); i++) {
                try {
                    fileWriter.write(list.get(i));
                    if (i != list.size() - 1) {
                        fileWriter.write("\n");
                    }
                } catch (IOException e) {
                    fileWriter2 = fileWriter;
                    if (fileWriter2 != null) {
                        try {
                            fileWriter2.close();
                            return;
                        } catch (IOException e2) {
                            return;
                        }
                    }
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (IOException e3) {
                        }
                    }
                    throw th;
                }
            }
            fileWriter.flush();
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e4) {
                }
            }
        } catch (IOException e5) {
        } catch (Throwable th3) {
            fileWriter = null;
            th = th3;
        }
    }

    public static long ri(String str) {
        long j = -1;
        if (!TextUtils.isEmpty(str)) {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                mediaMetadataRetriever.setDataSource(str);
                String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
                if (!TextUtils.isEmpty(extractMetadata)) {
                    j = Long.parseLong(extractMetadata);
                }
            } catch (Exception e) {
            } finally {
                mediaMetadataRetriever.release();
            }
        }
        return j;
    }
}
