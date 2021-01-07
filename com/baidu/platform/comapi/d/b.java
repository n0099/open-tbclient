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

    /* renamed from: a  reason: collision with root package name */
    public static final b f4235a = new b();

    /* renamed from: b  reason: collision with root package name */
    private c f4236b = new c(com.baidu.platform.comapi.b.e(), "res.json");

    private b() {
    }

    private boolean a(AssetManager assetManager, byte[] bArr, String str, String str2) {
        InputStream inputStream = null;
        try {
            if (TextUtils.isEmpty(str) || !str.endsWith(".dir")) {
                inputStream = assetManager.open(str);
                File file = new File(str2);
                File parentFile = file.getParentFile();
                if (parentFile != null && !parentFile.isDirectory()) {
                    parentFile.mkdirs();
                }
                if (file.exists()) {
                    file.delete();
                }
                file.createNewFile();
                a.a(inputStream, new FileOutputStream(file), bArr);
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
            a.a(inputStream);
            return true;
        } catch (Exception e) {
            a.a(null);
            return false;
        } catch (Throwable th) {
            a.a(null);
            throw th;
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

    public void a() {
        File file;
        byte[] bArr;
        boolean z;
        String[] b2;
        boolean z2 = true;
        boolean z3 = false;
        Context e = com.baidu.platform.comapi.b.e();
        try {
            String b3 = b();
            file = new File(b3, "/ver.dat");
            try {
                byte[] a2 = this.f4236b.a();
                try {
                    z = a(file, a2);
                    if (z) {
                        try {
                            AssetManager assets = e.getAssets();
                            byte[] bArr2 = new byte[65536];
                            for (String str : this.f4236b.b()) {
                                z2 = a(assets, bArr2, str, b3 + "/" + str);
                            }
                        } catch (RuntimeException e2) {
                            bArr = a2;
                            z2 = z;
                            z = z2;
                            if (z) {
                                return;
                            }
                            return;
                        } catch (Exception e3) {
                            bArr = a2;
                        }
                    }
                    bArr = a2;
                    z3 = z2;
                } catch (RuntimeException e4) {
                    bArr = a2;
                } catch (Exception e5) {
                    bArr = a2;
                    z = true;
                }
            } catch (RuntimeException e6) {
                bArr = null;
            } catch (Exception e7) {
                bArr = null;
                z = true;
            }
        } catch (RuntimeException e8) {
            file = null;
            bArr = null;
        } catch (Exception e9) {
            file = null;
            bArr = null;
            z = true;
        }
        if (z || !z3) {
            return;
        }
        b(file, bArr);
    }
}
