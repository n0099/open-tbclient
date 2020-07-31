package com.baidu.ar.f;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes11.dex */
public final class g {
    private static String wN = null;

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
                new AsyncTask<Void, Void, Void>() { // from class: com.baidu.ar.f.g.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // android.os.AsyncTask
                    public Void doInBackground(Void... voidArr) {
                        g.a(file, file2, false);
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

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: java.io.FileOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    public static boolean a(File file, File file2, Boolean bool) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream3 = null;
        if (file != null && file.exists() && file.isFile() && file.canRead()) {
            if (!file2.getParentFile().exists()) {
                file2.getParentFile().mkdirs();
            }
            if (file2.exists() && bool.booleanValue()) {
                file2.delete();
            }
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
            } catch (Exception e2) {
                e = e2;
                fileInputStream2 = null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
            }
            try {
                i.a(fileInputStream, fileOutputStream);
                fileOutputStream.flush();
                i.closeQuietly(fileInputStream);
                i.closeQuietly(fileOutputStream);
            } catch (Exception e3) {
                e = e3;
                fileInputStream3 = fileInputStream;
                fileInputStream2 = fileOutputStream;
                try {
                    e.printStackTrace();
                    i.closeQuietly(fileInputStream3);
                    i.closeQuietly(fileInputStream2);
                    return true;
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = fileInputStream3;
                    fileInputStream3 = fileInputStream2;
                    i.closeQuietly(fileInputStream);
                    i.closeQuietly(fileInputStream3);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                fileInputStream3 = fileOutputStream;
                i.closeQuietly(fileInputStream);
                i.closeQuietly(fileInputStream3);
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
        FileInputStream fileInputStream;
        String str = null;
        try {
            if (g(file)) {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        str = i.a(fileInputStream);
                        i.closeQuietly(fileInputStream);
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
                        i.closeQuietly(fileInputStream);
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
                } catch (Throwable th) {
                    fileInputStream = null;
                    th = th;
                    i.closeQuietly(fileInputStream);
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
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean g(File file) {
        return file != null && file.exists() && file.isFile();
    }
}
