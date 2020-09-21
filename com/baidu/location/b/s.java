package com.baidu.location.b;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.down.utils.Constants;
import com.baidu.location.Jni;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.sapi2.utils.SapiUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class s extends com.baidu.location.e.f {
    private static s q = null;
    String a = null;
    String b = null;
    String c = null;
    String d = null;
    int e = 1;
    Handler f;

    private s() {
        this.f = null;
        this.f = new Handler();
    }

    public static void a(File file, File file2) throws IOException {
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                try {
                    byte[] bArr = new byte[5120];
                    while (true) {
                        int read = bufferedInputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        bufferedOutputStream.write(bArr, 0, read);
                    }
                    bufferedOutputStream.flush();
                    file.delete();
                    if (bufferedInputStream2 != null) {
                        bufferedInputStream2.close();
                    }
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedInputStream = bufferedInputStream2;
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream = null;
                bufferedInputStream = bufferedInputStream2;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream = null;
        }
    }

    public static boolean a(String str, String str2) {
        File file = new File(com.baidu.location.e.l.j() + File.separator + "tmp");
        if (file.exists()) {
            file.delete();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[4096];
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(httpsURLConnection.getInputStream());
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            httpsURLConnection.disconnect();
            fileOutputStream.close();
            bufferedInputStream.close();
            if (file.length() < Constants.TEST_SPEED_THRESHOLD_DEFAULT) {
                file.delete();
                return false;
            }
            file.renameTo(new File(com.baidu.location.e.l.j() + File.separator + str2));
            return true;
        } catch (Exception e) {
            file.delete();
            return false;
        }
    }

    public static s b() {
        if (q == null) {
            q = new s();
        }
        return q;
    }

    private Handler d() {
        return this.f;
    }

    private void e() {
        try {
            File file = new File(com.baidu.location.e.l.j() + "/grtcfrsa.dat");
            if (!file.exists()) {
                File file2 = new File(com.baidu.location.e.k.a);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                if (!file.createNewFile()) {
                    return;
                }
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(2L);
                randomAccessFile.writeInt(0);
                randomAccessFile.seek(8L);
                byte[] bytes = "1980_01_01:0".getBytes();
                randomAccessFile.writeInt(bytes.length);
                randomAccessFile.write(bytes);
                randomAccessFile.seek(200L);
                randomAccessFile.writeBoolean(false);
                randomAccessFile.seek(800L);
                randomAccessFile.writeBoolean(false);
                randomAccessFile.close();
            }
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rw");
            randomAccessFile2.seek(200L);
            randomAccessFile2.writeBoolean(true);
            if (this.e == 1) {
                randomAccessFile2.writeBoolean(true);
            } else {
                randomAccessFile2.writeBoolean(false);
            }
            if (this.d != null) {
                byte[] bytes2 = this.d.getBytes();
                randomAccessFile2.writeInt(bytes2.length);
                randomAccessFile2.write(bytes2);
            } else if (Math.abs(com.baidu.location.f.getFrameVersion() - 9.02f) < 1.0E-8f) {
                randomAccessFile2.writeInt(0);
            }
            randomAccessFile2.close();
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.a == null) {
            return;
        }
        new w(this).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        if (this.c == null) {
            return true;
        }
        if (this.c.contains("../")) {
            return false;
        }
        if (new File(com.baidu.location.e.l.j() + File.separator + this.c).exists()) {
            return true;
        }
        return a(SapiUtils.COOKIE_HTTPS_URL_PREFIX + this.a + "/" + this.c, this.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.b == null || this.b.contains("../")) {
            return;
        }
        File file = new File(com.baidu.location.e.l.j() + File.separator + this.b);
        if (file.exists() || !a(SapiUtils.COOKIE_HTTPS_URL_PREFIX + this.a + "/" + this.b, this.b)) {
            return;
        }
        String a = com.baidu.location.e.l.a(file, "SHA-256");
        if (this.d == null || a == null || !com.baidu.location.e.l.b(a, this.d, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCiP7BS5IjEOzrKGR9/Ww9oSDhdX1ir26VOsYjT1T6tk2XumRpkHRwZbrucDcNnvSB4QsqiEJnvTSRi7YMbh2H9sLMkcvHlMV5jAErNvnuskWfcvf7T2mq7EUZI/Hf4oVZhHV0hQJRFVdTcjWI6q2uaaKM3VMh+roDesiE7CR2biQIDAQAB")) {
            return;
        }
        File file2 = new File(com.baidu.location.e.l.j() + File.separator + com.baidu.location.f.replaceFileName);
        if (file2.exists()) {
            file2.delete();
        }
        try {
            a(file, file2);
        } catch (Exception e) {
            file2.delete();
        }
    }

    @Override // com.baidu.location.e.f
    @SuppressLint({"NewApi"})
    public void a() {
        String str;
        int i = 0;
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&sdk=");
        stringBuffer.append(9.02f);
        stringBuffer.append("&fw=");
        stringBuffer.append(com.baidu.location.f.getFrameVersion());
        stringBuffer.append("&suit=");
        stringBuffer.append(2);
        if (com.baidu.location.e.b.a().c == null) {
            stringBuffer.append("&im=");
            stringBuffer.append(com.baidu.location.e.b.a().a);
        } else {
            stringBuffer.append("&cu=");
            stringBuffer.append(com.baidu.location.e.b.a().c);
        }
        stringBuffer.append("&mb=");
        stringBuffer.append(Build.MODEL);
        stringBuffer.append("&sv=");
        String str2 = Build.VERSION.RELEASE;
        if (str2 != null && str2.length() > 10) {
            str2 = str2.substring(0, 10);
        }
        stringBuffer.append(str2);
        try {
            if (Build.VERSION.SDK_INT > 20) {
                String[] strArr = Build.SUPPORTED_ABIS;
                str = null;
                while (i < strArr.length) {
                    str = i == 0 ? strArr[i] + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : str + strArr[i] + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR;
                    i++;
                }
            } else {
                str = Build.CPU_ABI2;
            }
        } catch (Error e) {
            str = null;
        } catch (Exception e2) {
            str = null;
        }
        if (str != null) {
            stringBuffer.append("&cpuabi=");
            stringBuffer.append(str);
        }
        stringBuffer.append("&pack=");
        stringBuffer.append(com.baidu.location.e.b.e);
        this.h = com.baidu.location.e.l.f() + "?&it=" + Jni.en1(stringBuffer.toString());
    }

    @Override // com.baidu.location.e.f
    public void a(boolean z) {
        if (z) {
            try {
                JSONObject jSONObject = new JSONObject(this.j);
                if (MapBundleKey.OfflineMapKey.OFFLINE_UPDATE.equals(jSONObject.getString("res"))) {
                    if (jSONObject.has("upath")) {
                        this.a = jSONObject.getString("upath");
                    }
                    if (jSONObject.has("u1")) {
                        this.b = jSONObject.getString("u1");
                    }
                    if (jSONObject.has("u2")) {
                        this.c = jSONObject.getString("u2");
                    }
                    if (jSONObject.has("u1_rsa")) {
                        this.d = jSONObject.getString("u1_rsa");
                    }
                    d().post(new v(this));
                }
                if (jSONObject.has("ison")) {
                    this.e = jSONObject.getInt("ison");
                }
                e();
            } catch (Exception e) {
            }
        }
    }

    public void c() {
        if (System.currentTimeMillis() - com.baidu.location.e.d.a().b() > 86400000) {
            com.baidu.location.e.d.a().a(System.currentTimeMillis());
            d().postDelayed(new t(this), 10000 + 0);
            d().postDelayed(new u(this), 0 + 5000);
        }
    }
}
