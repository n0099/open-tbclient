package com.baidu.e.a.a;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.baidu.minivideo.plugin.capture.Application;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes13.dex */
public class c {
    public static boolean delete(File file) {
        if (file == null) {
            return false;
        }
        deleteNotCheck(file);
        return !file.exists();
    }

    private static void deleteNotCheck(File file) {
        if (file.isFile()) {
            file.delete();
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length == 0) {
            file.delete();
            return;
        }
        for (File file2 : listFiles) {
            deleteNotCheck(file2);
            file.delete();
        }
    }

    public static boolean isSDMounted() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static boolean copyFile(String str, String str2) {
        try {
            return d(new FileInputStream(str), str2);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    public static boolean d(InputStream inputStream, String str) {
        boolean z = false;
        try {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(str);
                byte[] bArr = new byte[1444];
                int i = 0;
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    i += read;
                    System.out.println(i);
                    fileOutputStream.write(bArr, 0, read);
                }
                z = true;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            }
            return z;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static boolean pm() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static boolean d(long j, boolean z) {
        long blockSize;
        long availableBlocks;
        if (z) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            blockSize = statFs.getBlockSize();
            availableBlocks = statFs.getAvailableBlocks();
        } else {
            StatFs statFs2 = new StatFs(Environment.getDataDirectory().getPath());
            blockSize = statFs2.getBlockSize();
            availableBlocks = statFs2.getAvailableBlocks();
        }
        return availableBlocks * blockSize > j;
    }

    public static FileOutputStream cG(String str) throws IOException {
        File file = new File(str);
        if (file.exists()) {
            if (file.isDirectory()) {
                throw new IOException("File '" + file + "' exists but is a directory");
            }
            if (!file.canWrite()) {
                throw new IOException("File '" + file + "' cannot be written to");
            }
        } else {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                throw new IOException("File '" + file + "' could not be created");
            }
            file.createNewFile();
        }
        return new FileOutputStream(file);
    }

    public static void ensureParent(File file) {
        File parentFile;
        if (file != null && (parentFile = file.getParentFile()) != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [617=4] */
    public static boolean P(String str, String str2) {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = cH(str);
            try {
                try {
                    fileOutputStream = cG(str2);
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            fileOutputStream.flush();
                            d.close(fileOutputStream);
                            d.close(fileInputStream);
                            return true;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    d.close(fileOutputStream);
                    d.close(fileInputStream);
                    return false;
                }
            } catch (Throwable th) {
                th = th;
                d.close(fileOutputStream);
                d.close(fileInputStream);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            d.close(fileOutputStream);
            d.close(fileInputStream);
            throw th;
        }
    }

    public static FileInputStream cH(String str) throws IOException {
        File file = new File(str);
        if (file.exists()) {
            if (file.isDirectory()) {
                throw new IOException("File '" + file + "' exists but is a directory");
            }
            if (!file.canRead()) {
                throw new IOException("File '" + file + "' cannot be read");
            }
            return new FileInputStream(file);
        }
        throw new FileNotFoundException("File '" + file + "' does not exist");
    }

    public static boolean b(String str, File file) {
        boolean z = false;
        InputStream cI = cI(str);
        try {
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            d.close(cI);
        }
        if (cI != null) {
            d.copyStream(cI, file);
            z = true;
        }
        return z;
    }

    public static InputStream cI(String str) {
        try {
            return Application.get().getAssets().open(str);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean R(Context context, String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.delete();
        }
        return true;
    }

    public static long cJ(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return file.length();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0L;
    }
}
