package com.baidu.ar.h;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes.dex */
public final class i {
    public static String yb;

    public static File a(Bitmap bitmap, File file, int i) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            bitmap.compress(Bitmap.CompressFormat.JPEG, i, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            if (fileOutputStream2 != null) {
                fileOutputStream2.flush();
                fileOutputStream2.close();
            }
            return file;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
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
                    a(file3, new File(file2, file3.getName()), Boolean.TRUE);
                } else {
                    a(file3, new File(file2, file3.getName()), false);
                }
            }
        }
    }

    public static boolean a(File file, File file2, Boolean bool) {
        FileOutputStream fileOutputStream;
        if (file != null && file.exists() && file.isFile() && file.canRead()) {
            if (!file2.getParentFile().exists()) {
                file2.getParentFile().mkdirs();
            }
            if (file2.exists() && bool.booleanValue()) {
                file2.delete();
            }
            FileInputStream fileInputStream = null;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    fileOutputStream = new FileOutputStream(file2);
                    try {
                        k.a(fileInputStream2, fileOutputStream);
                        fileOutputStream.flush();
                        k.closeQuietly(fileInputStream2);
                    } catch (Exception e) {
                        e = e;
                        fileInputStream = fileInputStream2;
                        try {
                            e.printStackTrace();
                            k.closeQuietly(fileInputStream);
                            k.closeQuietly(fileOutputStream);
                            return true;
                        } catch (Throwable th) {
                            th = th;
                            k.closeQuietly(fileInputStream);
                            k.closeQuietly(fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        k.closeQuietly(fileInputStream);
                        k.closeQuietly(fileOutputStream);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = null;
                }
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
            }
            k.closeQuietly(fileOutputStream);
            return true;
        }
        return false;
    }

    public static void b(File file) {
        if (file.exists()) {
            if (!file.isFile()) {
                return;
            }
            file.delete();
        }
        file.mkdirs();
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

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean] */
    public static String f(File file) {
        FileInputStream fileInputStream;
        ?? g = g(file);
        FileInputStream fileInputStream2 = null;
        try {
            if (g != 0) {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        String a = k.a(fileInputStream);
                        k.closeQuietly(fileInputStream);
                        try {
                            fileInputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return a;
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
                        return null;
                    }
                } catch (IOException e4) {
                    e = e4;
                    fileInputStream = null;
                } catch (Throwable th) {
                    th = th;
                    k.closeQuietly(fileInputStream2);
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = g;
        }
    }

    public static boolean g(File file) {
        return file != null && file.exists() && file.isFile();
    }
}
