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
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f7631a;

    static {
        f7631a = Build.VERSION.SDK_INT >= 8;
    }

    public static Bitmap a(String str, Context context) {
        try {
            InputStream open = context.getAssets().open(str);
            if (open != null) {
                return BitmapFactory.decodeStream(open);
            }
            return null;
        } catch (Exception unused) {
            return BitmapFactory.decodeFile(b("assets/" + str, str, context));
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    public static void a(InputStream inputStream, FileOutputStream fileOutputStream) throws IOException {
        byte[] bArr = new byte[4096];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            } finally {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
                try {
                    fileOutputStream.close();
                } catch (IOException unused2) {
                }
            }
        }
        fileOutputStream.flush();
        try {
            fileOutputStream.close();
        } catch (IOException unused3) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0097 A[Catch: IOException -> 0x0093, TRY_LEAVE, TryCatch #2 {IOException -> 0x0093, blocks: (B:37:0x008f, B:41:0x0097), top: B:46:0x008f }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(String str, String str2, Context context) {
        FileOutputStream fileOutputStream;
        byte[] bArr;
        InputStream inputStream = null;
        FileOutputStream fileOutputStream2 = null;
        inputStream = null;
        try {
            try {
                InputStream open = context.getAssets().open(str);
                if (open != null) {
                    try {
                        bArr = new byte[open.available()];
                        open.read(bArr);
                        File file = new File(context.getFilesDir().getAbsolutePath() + "/" + str2);
                        if (file.exists()) {
                            file.delete();
                        }
                        file.createNewFile();
                        fileOutputStream = new FileOutputStream(file);
                    } catch (Exception unused) {
                        fileOutputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = null;
                    }
                    try {
                        fileOutputStream.write(bArr);
                        fileOutputStream.close();
                        fileOutputStream2 = fileOutputStream;
                    } catch (Exception unused2) {
                        inputStream = open;
                        try {
                            b("assets/" + str, str2, context);
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                                return;
                            }
                            return;
                        } catch (Throwable th2) {
                            th = th2;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
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
                        inputStream = open;
                        if (inputStream != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        throw th;
                    }
                }
                if (open != null) {
                    open.close();
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        } catch (Exception unused3) {
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
    }

    public static String b(String str, String str2, Context context) {
        ZipFile zipFile;
        File file;
        File file2;
        ZipEntry entry;
        StringBuilder sb = new StringBuilder(context.getFilesDir().getAbsolutePath());
        ZipFile zipFile2 = null;
        try {
            try {
                try {
                    zipFile = new ZipFile(f7631a ? context.getPackageCodePath() : "");
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException unused) {
        }
        try {
            int lastIndexOf = str2.lastIndexOf("/");
            if (lastIndexOf > 0) {
                file = new File(context.getFilesDir().getAbsolutePath());
                String substring = str2.substring(0, lastIndexOf);
                String substring2 = str2.substring(lastIndexOf + 1, str2.length());
                file2 = new File(file.getAbsolutePath() + "/" + substring, substring2);
            } else {
                file = new File(context.getFilesDir(), "assets");
                file2 = new File(file.getAbsolutePath(), str2);
            }
            file.mkdirs();
            entry = zipFile.getEntry(str);
        } catch (Exception e3) {
            e = e3;
            zipFile2 = zipFile;
            Log.e(a.class.getSimpleName(), "copyAssetsError", e);
            if (zipFile2 != null) {
                zipFile2.close();
            }
            return sb.toString();
        } catch (Throwable th2) {
            th = th2;
            zipFile2 = zipFile;
            if (zipFile2 != null) {
                try {
                    zipFile2.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
        if (entry == null) {
            try {
                zipFile.close();
            } catch (IOException unused3) {
            }
            return null;
        }
        a(zipFile.getInputStream(entry), new FileOutputStream(file2));
        sb.append("/");
        sb.append(str);
        zipFile.close();
        return sb.toString();
    }
}
