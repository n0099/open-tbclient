package com.baidu.loginshare;

import android.util.Log;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    private static final int b = 5000;
    private static final String c = "appcommunicate";
    final /* synthetic */ b a;
    private String d;
    private boolean e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(b bVar, boolean z, String str) {
        this.a = bVar;
        this.d = null;
        this.e = true;
        this.e = z;
        this.d = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Boolean a() {
        HttpURLConnection httpURLConnection;
        String str;
        String str2;
        Boolean bool;
        String str3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(h.o()).openConnection();
            try {
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.setReadTimeout(b);
                httpURLConnection2.setConnectTimeout(b);
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
                    String string = new JSONObject(new String(bArr)).getString(c);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    str3 = this.a.c;
                    Log.d(str3, "net check duration = " + (currentTimeMillis2 - currentTimeMillis));
                    bool = "0".equals(string) ? new Boolean(false) : new Boolean(true);
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                }
            } catch (Exception e) {
                httpURLConnection = httpURLConnection2;
                e = e;
                try {
                    str = this.a.c;
                    Log.d(str, "net check exception = " + e.toString());
                    long currentTimeMillis3 = System.currentTimeMillis();
                    str2 = this.a.c;
                    Log.d(str2, "net check duration = " + (currentTimeMillis3 - currentTimeMillis));
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
        a aVar;
        a aVar2;
        j jVar;
        j jVar2;
        j jVar3;
        ArrayList arrayList;
        ArrayList arrayList2;
        com.baidu.share.b bVar;
        com.baidu.share.b bVar2;
        c cVar;
        ArrayList arrayList3;
        ArrayList arrayList4;
        boolean booleanValue = bool.booleanValue();
        long currentTimeMillis = System.currentTimeMillis();
        aVar = this.a.g;
        aVar.a(booleanValue);
        aVar2 = this.a.g;
        aVar2.a(currentTimeMillis);
        jVar = this.a.d;
        jVar.a(h.p(), new StringBuilder(String.valueOf(currentTimeMillis)).toString());
        jVar2 = this.a.d;
        jVar2.a(h.m(), booleanValue ? this.a.k : this.a.l);
        jVar3 = this.a.d;
        jVar3.a();
        com.baidu.share.c cVar2 = null;
        arrayList = this.a.r;
        synchronized (arrayList) {
            arrayList2 = this.a.r;
            int size = arrayList2.size();
            if (size > 0) {
                arrayList3 = this.a.r;
                cVar2 = (com.baidu.share.c) arrayList3.get(size - 1);
                arrayList4 = this.a.r;
                arrayList4.clear();
            }
        }
        if (cVar2 != null) {
            bVar = this.a.b;
            if (bVar != null) {
                bVar2 = this.a.b;
                if (bVar2.a(cVar2) && this.e) {
                    cVar = this.a.f;
                    cVar.a(1, this.d);
                }
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.q = true;
        a(a());
        this.a.q = false;
    }
}
