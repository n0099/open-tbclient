package com.baidu.loginshare;

import android.util.Log;
import com.baidu.share.ShareModel;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
/* loaded from: classes.dex */
final class i implements Runnable {
    private static final int a = 5000;
    private static final String b = "appcommunicate";
    private String c;
    private boolean d;
    private /* synthetic */ f e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(f fVar, boolean z, String str) {
        this.e = fVar;
        this.c = null;
        this.d = true;
        this.d = z;
        this.c = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Boolean a() {
        HttpURLConnection httpURLConnection;
        Boolean bool;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(Keystore.n()).openConnection();
            try {
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.setReadTimeout(5000);
                httpURLConnection2.setConnectTimeout(5000);
                httpURLConnection2.setRequestMethod("GET");
                httpURLConnection2.connect();
                if (httpURLConnection2.getResponseCode() != 200) {
                    bool = new Boolean(true);
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                } else {
                    InputStream inputStream = httpURLConnection2.getInputStream();
                    byte[] bArr = new byte[inputStream.available()];
                    inputStream.read(bArr);
                    inputStream.close();
                    httpURLConnection2.disconnect();
                    String string = new JSONObject(new String(bArr)).getString(b);
                    Log.d(this.e.c, "net check duration = " + (System.currentTimeMillis() - currentTimeMillis));
                    bool = "0".equals(string) ? new Boolean(false) : new Boolean(true);
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                }
            } catch (Exception e) {
                httpURLConnection = httpURLConnection2;
                e = e;
                try {
                    Log.d(this.e.c, "net check exception = " + e.toString());
                    Log.d(this.e.c, "net check duration = " + (System.currentTimeMillis() - currentTimeMillis));
                    bool = new Boolean(true);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return bool;
                } catch (Throwable th) {
                    th = th;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                httpURLConnection = httpURLConnection2;
                th = th2;
                if (httpURLConnection != null) {
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            httpURLConnection = null;
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
        }
        return bool;
    }

    private void a(Boolean bool) {
        boolean booleanValue = bool.booleanValue();
        long currentTimeMillis = System.currentTimeMillis();
        this.e.g.a = booleanValue;
        this.e.g.b = currentTimeMillis;
        this.e.d.a(Keystore.o(), new StringBuilder(String.valueOf(currentTimeMillis)).toString());
        this.e.d.a(Keystore.l(), booleanValue ? this.e.k : this.e.l);
        this.e.d.a();
        ShareModel shareModel = null;
        synchronized (this.e.o) {
            int size = this.e.o.size();
            if (size > 0) {
                shareModel = (ShareModel) this.e.o.get(size - 1);
                this.e.o.clear();
            }
        }
        if (shareModel != null && this.e.b.share(shareModel) && this.d) {
            this.e.f.a(1, this.c);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.e.n = true;
        boolean booleanValue = a().booleanValue();
        long currentTimeMillis = System.currentTimeMillis();
        this.e.g.a = booleanValue;
        this.e.g.b = currentTimeMillis;
        this.e.d.a(Keystore.o(), new StringBuilder(String.valueOf(currentTimeMillis)).toString());
        this.e.d.a(Keystore.l(), booleanValue ? this.e.k : this.e.l);
        this.e.d.a();
        ShareModel shareModel = null;
        synchronized (this.e.o) {
            int size = this.e.o.size();
            if (size > 0) {
                shareModel = (ShareModel) this.e.o.get(size - 1);
                this.e.o.clear();
            }
        }
        if (shareModel != null && this.e.b.share(shareModel) && this.d) {
            this.e.f.a(1, this.c);
        }
        this.e.n = false;
    }
}
