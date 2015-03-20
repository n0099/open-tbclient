package com.baidu.location;

import android.os.Build;
import android.os.Handler;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends t {
    private static d c9 = null;
    Handler da;
    String dd = null;
    String dc = null;
    String db = null;

    private d() {
        this.da = null;
        this.da = new Handler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Z() {
        if (this.db == null || new File(c.m276long() + File.separator + this.db).exists()) {
            return true;
        }
        return m281for("http://" + this.dd + "/" + this.db, this.db);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa() {
        if (this.dc == null) {
            return;
        }
        File file = new File(c.m276long() + File.separator + this.dc);
        if (file.exists() || !m281for("http://" + this.dd + "/" + this.dc, this.dc)) {
            return;
        }
        File file2 = new File(c.m276long() + File.separator + f.replaceFileName);
        if (file2.exists()) {
            file2.delete();
        }
        try {
            m283if(file, file2);
        } catch (Exception e) {
            file2.delete();
        }
    }

    private Handler ab() {
        return this.da;
    }

    public static d ac() {
        if (c9 == null) {
            c9 = new d();
        }
        return c9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.location.d$3] */
    public void ad() {
        if (this.dd != null && au.ca()) {
            new Thread() { // from class: com.baidu.location.d.3
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    if (d.this.Z()) {
                        d.this.aa();
                    }
                }
            }.start();
        }
    }

    /* renamed from: for  reason: not valid java name */
    private static boolean m281for(String str, String str2) {
        File file = new File(c.m276long() + File.separator + "tmp");
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
            file.renameTo(new File(c.m276long() + File.separator + str2));
            return true;
        } catch (Exception e) {
            file.delete();
            return false;
        }
    }

    /* renamed from: if  reason: not valid java name */
    public static void m283if(File file, File file2) {
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
            } catch (Throwable th) {
                th = th;
                bufferedOutputStream = null;
                bufferedInputStream2 = bufferedInputStream;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedOutputStream = null;
        }
        try {
            byte[] bArr = new byte[a0.O];
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                bufferedOutputStream.write(bArr, 0, read);
            }
            bufferedOutputStream.flush();
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream2 = bufferedInputStream;
            if (bufferedInputStream2 != null) {
                bufferedInputStream2.close();
            }
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            throw th;
        }
    }

    @Override // com.baidu.location.t
    void X() {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&sdk=");
        stringBuffer.append(5.01f);
        stringBuffer.append("&fw=");
        stringBuffer.append(f.getFrameVersion());
        stringBuffer.append("&suit=");
        stringBuffer.append(2);
        if (a2.cC().jj == null) {
            stringBuffer.append("&im=");
            stringBuffer.append(a2.cC().jf);
        } else {
            stringBuffer.append("&cu=");
            stringBuffer.append(a2.cC().jj);
        }
        stringBuffer.append("&mb=");
        stringBuffer.append(Build.MODEL);
        stringBuffer.append("&sv=");
        String str = Build.VERSION.RELEASE;
        if (str != null && str.length() > 10) {
            str = str.substring(0, 10);
        }
        stringBuffer.append(str);
        stringBuffer.append("&pack=");
        stringBuffer.append(a2.jc);
        this.cX = c.m277new() + "?&it=" + Jni.m(stringBuffer.toString());
    }

    public void ae() {
        if (System.currentTimeMillis() - e.m284if().m285do() > 172800000) {
            ab().postDelayed(new Runnable() { // from class: com.baidu.location.d.1
                @Override // java.lang.Runnable
                public void run() {
                    if (au.ca()) {
                        d.this.U();
                    }
                }
            }, 10000L);
        }
    }

    @Override // com.baidu.location.t
    /* renamed from: do */
    void mo112do(boolean z) {
        if (z) {
            try {
                JSONObject jSONObject = new JSONObject(EntityUtils.toString(this.cY, "utf-8"));
                if ("up".equals(jSONObject.getString("res"))) {
                    this.dd = jSONObject.getString("upath");
                    if (jSONObject.has("u1")) {
                        this.dc = jSONObject.getString("u1");
                    }
                    if (jSONObject.has("u2")) {
                        this.db = jSONObject.getString("u2");
                    }
                    ab().post(new Runnable() { // from class: com.baidu.location.d.2
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.ad();
                        }
                    });
                }
            } catch (Exception e) {
            }
        }
        e.m284if().m286do(System.currentTimeMillis());
    }
}
