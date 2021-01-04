package com.baidu.ar.h;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes6.dex */
public final class i {
    private static String yb = null;

    /* JADX WARN: Removed duplicated region for block: B:31:0x0030 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static File a(Bitmap bitmap, File file, int i) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, i, fileOutputStream);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return file;
                }
            } catch (Throwable th) {
                th = th;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            if (fileOutputStream != null) {
            }
            throw th;
        }
        return file;
    }

    public static String a(String str, Bitmap bitmap, int i) {
        if (TextUtils.isEmpty(str) || bitmap == null) {
            return str;
        }
        File file = new File(str);
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdir();
        }
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
            a(bitmap, file, i);
            return file.getPath();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void a(final File file, final File file2, boolean z) {
        if (file.exists()) {
            if (z) {
                new AsyncTask<Void, Void, Void>() { // from class: com.baidu.ar.h.i.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // android.os.AsyncTask
                    public Void doInBackground(Void... voidArr) {
                        i.a(file, file2, false);
                        return null;
                    }
                }.execute(new Void[0]);
                return;
            }
            b(file2);
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length <= 0) {
                return;
            }
            for (File file3 : listFiles) {
                if (file3.isFile()) {
                    a(file3, new File(file2, file3.getName()), (Boolean) true);
                } else {
                    a(file3, new File(file2, file3.getName()), false);
                }
            }
        }
    }

    public static boolean a(File file, File file2, Boolean bool) {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        if (file != null && file.exists() && file.isFile() && file.canRead()) {
            if (!file2.getParentFile().exists()) {
                file2.getParentFile().mkdirs();
            }
            if (file2.exists() && bool.booleanValue()) {
                file2.delete();
            }
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Exception e) {
                e = e;
                fileOutputStream = null;
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
                fileInputStream = null;
            }
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    try {
                        k.a(fileInputStream, fileOutputStream);
                        fileOutputStream.flush();
                        k.closeQuietly(fileInputStream);
                        k.closeQuietly(fileOutputStream);
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        k.closeQuietly(fileInputStream);
                        k.closeQuietly(fileOutputStream);
                        return true;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    k.closeQuietly(fileInputStream);
                    k.closeQuietly(fileOutputStream);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                k.closeQuietly(fileInputStream);
                k.closeQuietly(fileOutputStream);
                throw th;
            }
            return true;
        }
        return false;
    }

    public static void b(File file) {
        if (!file.exists()) {
            file.mkdirs();
        } else if (file.isFile()) {
            file.delete();
            file.mkdirs();
        }
    }

    public static void c(File file) {
        File parentFile;
        if (file == null || (parentFile = file.getParentFile()) == null || parentFile.exists()) {
            return;
        }
        parentFile.mkdirs();
    }

    public static boolean d(File file) {
        if (file != null && file.exists()) {
            return file.delete();
        }
        return false;
    }

    public static FileOutputStream e(File file) {
        d(file);
        c(file);
        file.createNewFile();
        return new FileOutputStream(file);
    }

    public static String f(File file) {
        Throwable th;
        FileInputStream fileInputStream;
        String str = null;
        try {
            if (g(file)) {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        str = k.a(fileInputStream);
                        k.closeQuietly(fileInputStream);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (IOException e2) {
                        e = e2;
                        e.printStackTrace();
                        k.closeQuietly(fileInputStream);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        return str;
                    }
                } catch (IOException e4) {
                    e = e4;
                    fileInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = null;
                    k.closeQuietly(fileInputStream);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
            return str;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static boolean g(File file) {
        return file != null && file.exists() && file.isFile();
    }
}
