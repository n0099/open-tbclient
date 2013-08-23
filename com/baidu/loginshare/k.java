package com.baidu.loginshare;

import android.util.Log;
import com.baidu.share.ShareAssistant;
import com.baidu.share.ShareModel;
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

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f792a;
    private String d;
    private boolean e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(b bVar, boolean z, String str) {
        this.f792a = bVar;
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
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(g.o()).openConnection();
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
                    str3 = this.f792a.c;
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
                    str = this.f792a.c;
                    Log.d(str, "net check exception = " + e.toString());
                    long currentTimeMillis3 = System.currentTimeMillis();
                    str2 = this.f792a.c;
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
        i iVar;
        i iVar2;
        i iVar3;
        ArrayList arrayList;
        ArrayList arrayList2;
        ShareAssistant shareAssistant;
        ShareAssistant shareAssistant2;
        c cVar;
        ArrayList arrayList3;
        ArrayList arrayList4;
        boolean booleanValue = bool.booleanValue();
        long currentTimeMillis = System.currentTimeMillis();
        aVar = this.f792a.g;
        aVar.a(booleanValue);
        aVar2 = this.f792a.g;
        aVar2.a(currentTimeMillis);
        iVar = this.f792a.d;
        iVar.a(g.p(), new StringBuilder(String.valueOf(currentTimeMillis)).toString());
        iVar2 = this.f792a.d;
        iVar2.a(g.m(), booleanValue ? this.f792a.k : this.f792a.l);
        iVar3 = this.f792a.d;
        iVar3.a();
        ShareModel shareModel = null;
        arrayList = this.f792a.r;
        synchronized (arrayList) {
            arrayList2 = this.f792a.r;
            int size = arrayList2.size();
            if (size > 0) {
                arrayList3 = this.f792a.r;
                shareModel = (ShareModel) arrayList3.get(size - 1);
                arrayList4 = this.f792a.r;
                arrayList4.clear();
            }
        }
        if (shareModel != null) {
            shareAssistant = this.f792a.b;
            if (shareAssistant != null) {
                shareAssistant2 = this.f792a.b;
                if (shareAssistant2.share(shareModel) && this.e) {
                    cVar = this.f792a.f;
                    cVar.a(1, this.d);
                }
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f792a.q = true;
        a(a());
        this.f792a.q = false;
    }
}
