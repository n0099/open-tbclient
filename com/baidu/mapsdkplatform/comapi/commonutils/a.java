package com.baidu.mapsdkplatform.comapi.commonutils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
/* loaded from: classes8.dex */
public class a {
    private static final boolean a;

    static {
        a = Build.VERSION.SDK_INT >= 8;
    }

    public static Bitmap a(String str, Context context) {
        try {
            InputStream open = context.getAssets().open(str);
            if (open != null) {
                return BitmapFactory.decodeStream(open);
            }
            return null;
        } catch (Exception e) {
            return BitmapFactory.decodeFile(b("assets/" + str, str, context));
        }
    }

    private static void a(InputStream inputStream, FileOutputStream fileOutputStream) throws IOException {
        byte[] bArr = new byte[4096];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    fileOutputStream.flush();
                    try {
                        inputStream.close();
                        try {
                            fileOutputStream.close();
                            return;
                        } catch (IOException e) {
                            return;
                        }
                    } catch (IOException e2) {
                        return;
                    }
                }
                fileOutputStream.write(bArr, 0, read);
            } catch (Throwable th) {
                try {
                    inputStream.close();
                    try {
                        fileOutputStream.close();
                        throw th;
                    } catch (IOException e3) {
                        return;
                    }
                } catch (IOException e4) {
                    return;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0095 A[Catch: IOException -> 0x0099, TRY_LEAVE, TryCatch #0 {IOException -> 0x0099, blocks: (B:30:0x0090, B:32:0x0095), top: B:47:0x0090 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(String str, String str2, Context context) {
        InputStream inputStream;
        Throwable th;
        FileOutputStream fileOutputStream;
        InputStream inputStream2;
        FileOutputStream fileOutputStream2 = null;
        try {
            inputStream = context.getAssets().open(str);
            if (inputStream != null) {
                try {
                    byte[] bArr = new byte[inputStream.available()];
                    inputStream.read(bArr);
                    File file = new File(context.getFilesDir().getAbsolutePath() + "/" + str2);
                    if (file.exists()) {
                        file.delete();
                    }
                    file.createNewFile();
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        fileOutputStream.write(bArr);
                        fileOutputStream.close();
                    } catch (Exception e) {
                        fileOutputStream2 = fileOutputStream;
                        inputStream2 = inputStream;
                        try {
                            b("assets/" + str, str2, context);
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                    return;
                                }
                            }
                            if (fileOutputStream2 != null) {
                                fileOutputStream2.close();
                                return;
                            }
                            return;
                        } catch (Throwable th2) {
                            inputStream = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            th = th2;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                    throw th;
                                }
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (inputStream != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        throw th;
                    }
                } catch (Exception e4) {
                    inputStream2 = inputStream;
                } catch (Throwable th4) {
                    fileOutputStream = null;
                    th = th4;
                }
            } else {
                fileOutputStream = null;
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                    return;
                }
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        } catch (Exception e6) {
            inputStream2 = null;
        } catch (Throwable th5) {
            inputStream = null;
            th = th5;
            fileOutputStream = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00c4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String b(String str, String str2, Context context) {
        ZipFile zipFile;
        File file;
        File file2;
        ZipEntry entry;
        ZipFile zipFile2 = null;
        StringBuilder sb = new StringBuilder(context.getFilesDir().getAbsolutePath());
        try {
            zipFile = new ZipFile(a ? context.getPackageCodePath() : "");
        } catch (Exception e) {
            e = e;
        } catch (Throwable th) {
            th = th;
            zipFile = null;
        }
        try {
            int lastIndexOf = str2.lastIndexOf("/");
            if (lastIndexOf > 0) {
                file = new File(context.getFilesDir().getAbsolutePath());
                file2 = new File(file.getAbsolutePath() + "/" + str2.substring(0, lastIndexOf), str2.substring(lastIndexOf + 1, str2.length()));
            } else {
                file = new File(context.getFilesDir(), "assets");
                file2 = new File(file.getAbsolutePath(), str2);
            }
            file.mkdirs();
            entry = zipFile.getEntry(str);
        } catch (Exception e2) {
            e = e2;
            zipFile2 = zipFile;
            try {
                Log.e(a.class.getSimpleName(), "copyAssetsError", e);
                if (zipFile2 != null) {
                    try {
                        zipFile2.close();
                    } catch (IOException e3) {
                    }
                }
                return sb.toString();
            } catch (Throwable th2) {
                th = th2;
                zipFile = zipFile2;
                if (zipFile != null) {
                    try {
                        zipFile.close();
                    } catch (IOException e4) {
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (zipFile != null) {
            }
            throw th;
        }
        if (entry == null) {
            if (zipFile != null) {
                try {
                    zipFile.close();
                } catch (IOException e5) {
                }
            }
            return null;
        }
        a(zipFile.getInputStream(entry), new FileOutputStream(file2));
        sb.append("/").append(str);
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (IOException e6) {
            }
        }
        return sb.toString();
    }
}
