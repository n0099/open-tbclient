package com.baidu.platform.comapi.d;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.baidu.platform.comapi.util.SysOSUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
/* loaded from: classes3.dex */
public class b {
    public static final b a = new b();
    private c b = new c(com.baidu.platform.comapi.b.e(), "res.json");

    private b() {
    }

    private boolean a(AssetManager assetManager, byte[] bArr, String str, String str2) {
        InputStream inputStream;
        Throwable th;
        InputStream inputStream2;
        InputStream inputStream3 = null;
        try {
            if (TextUtils.isEmpty(str) || !str.endsWith(".dir")) {
                inputStream3 = assetManager.open(str);
                try {
                    File file = new File(str2);
                    File parentFile = file.getParentFile();
                    if (parentFile != null && !parentFile.isDirectory()) {
                        parentFile.mkdirs();
                    }
                    if (file.exists()) {
                        file.delete();
                    }
                    file.createNewFile();
                    a.a(inputStream3, new FileOutputStream(file), bArr);
                } catch (Exception e) {
                    inputStream2 = inputStream3;
                    a.a(inputStream2);
                    return false;
                } catch (Throwable th2) {
                    inputStream = inputStream3;
                    th = th2;
                    a.a(inputStream);
                    throw th;
                }
            } else {
                String substring = str.substring(0, str.indexOf(".dir"));
                String substring2 = str2.substring(0, str2.indexOf(".dir"));
                String[] list = assetManager.list(substring);
                if (list != null && list.length > 0) {
                    File file2 = new File(substring2);
                    if (file2.exists()) {
                        file2.delete();
                    }
                    file2.mkdirs();
                    for (String str3 : list) {
                        if (!TextUtils.isEmpty(str3)) {
                            a(assetManager, bArr, substring + "/" + str3, substring2 + "/" + str3);
                        }
                    }
                }
            }
            a.a(inputStream3);
            return true;
        } catch (Exception e2) {
            inputStream2 = null;
        } catch (Throwable th3) {
            inputStream = null;
            th = th3;
        }
    }

    private boolean a(File file, byte[] bArr) {
        FileInputStream fileInputStream;
        if (file == null || !file.exists() || bArr == null) {
            return true;
        }
        try {
            fileInputStream = new FileInputStream(file);
        } catch (IOException e) {
            fileInputStream = null;
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        try {
            byte[] bArr2 = new byte[fileInputStream.available()];
            fileInputStream.read(bArr2);
            if (Arrays.equals(bArr2, bArr)) {
                a.a(fileInputStream);
                return false;
            }
            a.a(fileInputStream);
            return true;
        } catch (IOException e2) {
            a.a(fileInputStream);
            return true;
        } catch (Throwable th2) {
            th = th2;
            a.a(fileInputStream);
            throw th;
        }
    }

    private String b() {
        String outputDirPath = SysOSUtil.getInstance().getOutputDirPath();
        File file = new File(outputDirPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        return outputDirPath;
    }

    private boolean b(File file, byte[] bArr) {
        FileOutputStream fileOutputStream;
        if (file == null || bArr == null) {
            return false;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            fileOutputStream = new FileOutputStream(file);
        } catch (Exception e) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileOutputStream.write(bArr);
            a.a(fileOutputStream);
            return true;
        } catch (Exception e2) {
            fileOutputStream2 = fileOutputStream;
            a.a(fileOutputStream2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            a.a(fileOutputStream2);
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x005c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a() {
        File file;
        boolean z;
        boolean z2;
        File file2;
        byte[] bArr = null;
        boolean z3 = true;
        Context e = com.baidu.platform.comapi.b.e();
        try {
            String b = b();
            file = new File(b, "/ver.dat");
            try {
                bArr = this.b.a();
                z = a(file, bArr);
                if (z) {
                    try {
                        AssetManager assets = e.getAssets();
                        String[] b2 = this.b.b();
                        byte[] bArr2 = new byte[65536];
                        int length = b2.length;
                        int i = 0;
                        while (i < length) {
                            String str = b2[i];
                            i++;
                            z3 = a(assets, bArr2, str, b + "/" + str);
                        }
                    } catch (RuntimeException e2) {
                        file2 = file;
                        z2 = z;
                        z = z2;
                        file = file2;
                        z3 = false;
                        if (z) {
                            return;
                        }
                        return;
                    } catch (Exception e3) {
                        z3 = false;
                        if (z) {
                        }
                    }
                }
            } catch (RuntimeException e4) {
                z2 = true;
                file2 = file;
            } catch (Exception e5) {
                z = true;
            }
        } catch (RuntimeException e6) {
            z2 = true;
            file2 = null;
        } catch (Exception e7) {
            file = null;
            z = true;
        }
        if (z || !z3) {
            return;
        }
        b(file, bArr);
    }
}
