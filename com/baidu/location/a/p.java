package com.baidu.location.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import com.baidu.down.utils.Constants;
import com.baidu.location.Jni;
import com.facebook.common.util.UriUtil;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class p extends com.baidu.location.d.e {
    public static p q;

    /* renamed from: a  reason: collision with root package name */
    public String f6834a = null;

    /* renamed from: b  reason: collision with root package name */
    public String f6835b = null;

    /* renamed from: c  reason: collision with root package name */
    public String f6836c = null;

    /* renamed from: d  reason: collision with root package name */
    public String f6837d = null;

    /* renamed from: e  reason: collision with root package name */
    public int f6838e = 1;

    /* renamed from: f  reason: collision with root package name */
    public Handler f6839f;

    public p() {
        this.f6839f = null;
        this.f6839f = new Handler();
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
                            bufferedOutputStream.flush();
                            file.delete();
                            bufferedInputStream2.close();
                            bufferedOutputStream.close();
                            return;
                        }
                        bufferedOutputStream.write(bArr, 0, read);
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
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || activeNetworkInfo.getType() != 0) {
                return false;
            }
            String a2 = com.baidu.location.b.d.a(com.baidu.location.b.b.a().e());
            if (a2.equals(com.baidu.apollon.statistics.g.f3962b)) {
                return true;
            }
            return a2.equals("4G");
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean a(String str, String str2) {
        File file = new File(com.baidu.location.d.j.h() + File.separator + "tmp");
        if (file.exists()) {
            file.delete();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[4096];
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            httpURLConnection.disconnect();
            fileOutputStream.close();
            bufferedInputStream.close();
            if (file.length() < Constants.TEST_SPEED_THRESHOLD_DEFAULT) {
                file.delete();
                return false;
            }
            file.renameTo(new File(com.baidu.location.d.j.h() + File.separator + str2));
            return true;
        } catch (Exception unused) {
            file.delete();
            return false;
        }
    }

    public static p b() {
        if (q == null) {
            q = new p();
        }
        return q;
    }

    private Handler f() {
        return this.f6839f;
    }

    private void g() {
        try {
            File file = new File(com.baidu.location.d.j.h() + "/grtcfrsa.dat");
            if (!file.exists()) {
                File file2 = new File(com.baidu.location.d.i.f6983a);
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
            if (this.f6838e == 1) {
                randomAccessFile2.writeBoolean(true);
            } else {
                randomAccessFile2.writeBoolean(false);
            }
            if (this.f6837d != null) {
                byte[] bytes2 = this.f6837d.getBytes();
                randomAccessFile2.writeInt(bytes2.length);
                randomAccessFile2.write(bytes2);
            } else if (Math.abs(com.baidu.location.f.getFrameVersion() - 7.63f) < 1.0E-8f) {
                randomAccessFile2.writeInt(0);
            }
            randomAccessFile2.close();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.f6834a == null) {
            return;
        }
        new t(this).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i() {
        if (this.f6836c == null) {
            return true;
        }
        if (new File(com.baidu.location.d.j.h() + File.separator + this.f6836c).exists()) {
            return true;
        }
        return a("http://" + this.f6834a + "/" + this.f6836c, this.f6836c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.f6835b == null) {
            return;
        }
        File file = new File(com.baidu.location.d.j.h() + File.separator + this.f6835b);
        if (file.exists()) {
            return;
        }
        if (a("http://" + this.f6834a + "/" + this.f6835b, this.f6835b)) {
            String a2 = com.baidu.location.d.j.a(file, "SHA-256");
            String str = this.f6837d;
            if (str == null || a2 == null || !com.baidu.location.d.j.b(a2, str, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCiP7BS5IjEOzrKGR9/Ww9oSDhdX1ir26VOsYjT1T6tk2XumRpkHRwZbrucDcNnvSB4QsqiEJnvTSRi7YMbh2H9sLMkcvHlMV5jAErNvnuskWfcvf7T2mq7EUZI/Hf4oVZhHV0hQJRFVdTcjWI6q2uaaKM3VMh+roDesiE7CR2biQIDAQAB")) {
                return;
            }
            File file2 = new File(com.baidu.location.d.j.h() + File.separator + com.baidu.location.f.replaceFileName);
            if (file2.exists()) {
                file2.delete();
            }
            try {
                a(file, file2);
            } catch (Exception unused) {
                file2.delete();
            }
        }
    }

    @Override // com.baidu.location.d.e
    @SuppressLint({"NewApi"})
    public void a() {
        String str;
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&sdk=");
        stringBuffer.append(7.63f);
        stringBuffer.append("&fw=");
        stringBuffer.append(com.baidu.location.f.getFrameVersion());
        stringBuffer.append("&suit=");
        stringBuffer.append(2);
        if (com.baidu.location.d.b.a().f6951b == null) {
            stringBuffer.append("&im=");
            str = com.baidu.location.d.b.a().f6950a;
        } else {
            stringBuffer.append("&cu=");
            str = com.baidu.location.d.b.a().f6951b;
        }
        stringBuffer.append(str);
        stringBuffer.append("&mb=");
        stringBuffer.append(Build.MODEL);
        stringBuffer.append("&sv=");
        String str2 = Build.VERSION.RELEASE;
        if (str2 != null && str2.length() > 10) {
            str2 = str2.substring(0, 10);
        }
        stringBuffer.append(str2);
        String str3 = null;
        try {
            if (Build.VERSION.SDK_INT > 20) {
                String[] strArr = Build.SUPPORTED_ABIS;
                String str4 = null;
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    str4 = i2 == 0 ? strArr[i2] + ";" : str4 + strArr[i2] + ";";
                }
                str3 = str4;
            } else {
                str3 = Build.CPU_ABI2;
            }
        } catch (Error | Exception unused) {
        }
        if (str3 != null) {
            stringBuffer.append("&cpuabi=");
            stringBuffer.append(str3);
        }
        stringBuffer.append("&pack=");
        stringBuffer.append(com.baidu.location.d.b.f6944d);
        this.f6975h = com.baidu.location.d.j.d() + "?&it=" + Jni.en1(stringBuffer.toString());
    }

    @Override // com.baidu.location.d.e
    public void a(boolean z) {
        if (z) {
            try {
                JSONObject jSONObject = new JSONObject(this.j);
                if ("up".equals(jSONObject.getString(UriUtil.LOCAL_RESOURCE_SCHEME))) {
                    this.f6834a = jSONObject.getString("upath");
                    if (jSONObject.has("u1")) {
                        this.f6835b = jSONObject.getString("u1");
                    }
                    if (jSONObject.has("u2")) {
                        this.f6836c = jSONObject.getString("u2");
                    }
                    if (jSONObject.has("u1_rsa")) {
                        this.f6837d = jSONObject.getString("u1_rsa");
                    }
                    f().post(new s(this));
                }
                if (jSONObject.has("ison")) {
                    this.f6838e = jSONObject.getInt("ison");
                }
                g();
            } catch (Exception unused) {
            }
        }
        com.baidu.location.d.c.a().a(System.currentTimeMillis());
    }

    public void c() {
        if (System.currentTimeMillis() - com.baidu.location.d.c.a().b() > 86400000) {
            f().postDelayed(new q(this), 10000L);
            f().postDelayed(new r(this), 5000L);
        }
    }
}
