package com.baidu.location.a;

import android.os.Build;
import android.os.Handler;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.location.Jni;
import com.baidu.tbadk.TbConfig;
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
/* loaded from: classes.dex */
public class g extends com.baidu.location.h.f {
    private static g HZ = null;
    String a = null;
    String b = null;
    String c = null;
    String d = null;
    int e = 1;
    Handler f;

    private g() {
        this.f = null;
        this.f = new Handler();
    }

    public static boolean a(String str, String str2) {
        File file = new File(com.baidu.location.h.i.g() + File.separator + "tmp");
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
            if (file.length() < 10240) {
                file.delete();
                return false;
            }
            file.renameTo(new File(com.baidu.location.h.i.g() + File.separator + str2));
            return true;
        } catch (Exception e) {
            file.delete();
            return false;
        }
    }

    public static void c(File file, File file2) throws IOException {
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

    private Handler f() {
        return this.f;
    }

    private void g() {
        try {
            File file = new File(com.baidu.location.h.h.a + "/grtcf.dat");
            if (!file.exists()) {
                File file2 = new File(com.baidu.location.h.h.a);
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
            } else {
                randomAccessFile2.writeInt(0);
            }
            randomAccessFile2.close();
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.a != null && com.baidu.location.f.k.ng().g()) {
            new o(this).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i() {
        if (this.c == null || new File(com.baidu.location.h.i.g() + File.separator + this.c).exists()) {
            return true;
        }
        return a("http://" + this.a + "/" + this.c, this.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.b == null) {
            return;
        }
        File file = new File(com.baidu.location.h.i.g() + File.separator + this.b);
        if (file.exists() || !a("http://" + this.a + "/" + this.b, this.b)) {
            return;
        }
        String a = com.baidu.location.h.i.a(file);
        if (this.d == null || a == null || !this.d.equals(a)) {
            return;
        }
        File file2 = new File(com.baidu.location.h.i.g() + File.separator + com.baidu.location.f.replaceFileName);
        if (file2.exists()) {
            file2.delete();
        }
        try {
            c(file, file2);
        } catch (Exception e) {
            file2.delete();
        }
    }

    public static g mo() {
        if (HZ == null) {
            HZ = new g();
        }
        return HZ;
    }

    @Override // com.baidu.location.h.f
    public void a() {
        String str;
        int i = 0;
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&sdk=");
        stringBuffer.append(6.23f);
        stringBuffer.append("&fw=");
        stringBuffer.append(com.baidu.location.f.getFrameVersion());
        stringBuffer.append("&suit=");
        stringBuffer.append(2);
        if (com.baidu.location.h.c.nh().b == null) {
            stringBuffer.append("&im=");
            stringBuffer.append(com.baidu.location.h.c.nh().a);
        } else {
            stringBuffer.append("&cu=");
            stringBuffer.append(com.baidu.location.h.c.nh().b);
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
        stringBuffer.append(com.baidu.location.h.c.c);
        this.h = com.baidu.location.h.i.d() + "?&it=" + Jni.en1(stringBuffer.toString());
    }

    @Override // com.baidu.location.h.f
    public void a(boolean z) {
        if (z) {
            try {
                JSONObject jSONObject = new JSONObject(this.j);
                if ("up".equals(jSONObject.getString("res"))) {
                    this.a = jSONObject.getString("upath");
                    if (jSONObject.has("u1")) {
                        this.b = jSONObject.getString("u1");
                    }
                    if (jSONObject.has("u2")) {
                        this.c = jSONObject.getString("u2");
                    }
                    if (jSONObject.has("u1_md5")) {
                        this.d = jSONObject.getString("u1_md5");
                    }
                    f().post(new n(this));
                }
                if (jSONObject.has("ison")) {
                    this.e = jSONObject.getInt("ison");
                }
                g();
            } catch (Exception e) {
            }
        }
        com.baidu.location.h.d.ni().a(System.currentTimeMillis());
    }

    public void c() {
        if (System.currentTimeMillis() - com.baidu.location.h.d.ni().b() > 86400000) {
            f().postDelayed(new l(this), 10000L);
            f().postDelayed(new m(this), TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }
}
