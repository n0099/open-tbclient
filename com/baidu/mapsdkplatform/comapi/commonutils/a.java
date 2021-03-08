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
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f2204a;

    static {
        f2204a = Build.VERSION.SDK_INT >= 8;
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

    /* JADX WARN: Not initialized variable reg: 0, insn: 0x00a4: MOVE  (r4 I:??[OBJECT, ARRAY]) = (r0 I:??[OBJECT, ARRAY]), block:B:39:0x00a3 */
    public static void a(String str, String str2, Context context) {
        Throwable th;
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        FileOutputStream fileOutputStream2;
        FileOutputStream fileOutputStream3;
        try {
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
                        fileOutputStream2 = new FileOutputStream(file);
                        try {
                            fileOutputStream2.write(bArr);
                            fileOutputStream2.close();
                        } catch (Exception e) {
                            b("assets/" + str, str2, context);
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
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
                        }
                    } catch (Exception e3) {
                        fileOutputStream2 = null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = null;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                                throw th;
                            }
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        throw th;
                    }
                } else {
                    fileOutputStream2 = null;
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                        return;
                    }
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = fileOutputStream3;
            }
        } catch (Exception e6) {
            fileOutputStream2 = null;
            inputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            inputStream = null;
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
            zipFile = new ZipFile(f2204a ? context.getPackageCodePath() : "");
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
