package com.baidu.crabsdk.sender;

import android.content.Context;
import com.baidu.searchbox.ui.CoolPraiseGuideLottieView;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class q implements Runnable {
    final /* synthetic */ Context aqr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(Context context) {
        this.aqr = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00b9 A[Catch: Exception -> 0x00bd, TRY_LEAVE, TryCatch #3 {Exception -> 0x00bd, blocks: (B:34:0x00b4, B:36:0x00b9), top: B:51:0x00b4, outer: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00b4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        DataOutputStream dataOutputStream;
        HttpURLConnection httpURLConnection;
        String vw;
        HttpURLConnection httpURLConnection2;
        HttpURLConnection httpURLConnection3 = null;
        r2 = null;
        DataOutputStream dataOutputStream2 = null;
        try {
            try {
                vw = g.vw();
                com.baidu.crabsdk.c.a.v("sync json is " + vw);
                httpURLConnection2 = (HttpURLConnection) new URL(com.baidu.crabsdk.a.c()).openConnection();
                try {
                    httpURLConnection2.setRequestMethod("POST");
                    httpURLConnection2.setDoInput(true);
                    httpURLConnection2.setDoOutput(true);
                    httpURLConnection2.setUseCaches(false);
                    httpURLConnection2.setInstanceFollowRedirects(true);
                    httpURLConnection2.setRequestProperty("User-Agent", g.a("sync", (String) null));
                    httpURLConnection2.setConnectTimeout(CoolPraiseGuideLottieView.ANIM_DURATION);
                    httpURLConnection2.setReadTimeout(CoolPraiseGuideLottieView.ANIM_DURATION);
                    dataOutputStream = new DataOutputStream(httpURLConnection2.getOutputStream());
                } catch (Exception e) {
                    httpURLConnection = httpURLConnection2;
                    e = e;
                } catch (Throwable th) {
                    dataOutputStream = null;
                    httpURLConnection3 = httpURLConnection2;
                    th = th;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        } catch (Exception e3) {
            e = e3;
            httpURLConnection = null;
        } catch (Throwable th2) {
            th = th2;
            dataOutputStream = null;
        }
        try {
            dataOutputStream.writeBytes(vw);
            dataOutputStream.flush();
            dataOutputStream.close();
            if (httpURLConnection2.getResponseCode() == 200) {
                com.baidu.crabsdk.b.n.clear();
                com.baidu.crabsdk.c.a.dC("#### ^@^ sync ok!");
            } else {
                com.baidu.crabsdk.c.a.dC("#### T^T sync failed!");
            }
            httpURLConnection2.disconnect();
            try {
                dataOutputStream.close();
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        } catch (Exception e5) {
            dataOutputStream2 = dataOutputStream;
            e = e5;
            httpURLConnection = httpURLConnection2;
            try {
                com.baidu.crabsdk.c.a.a("sync connect to server error!", e);
                if (dataOutputStream2 != null) {
                    try {
                        dataOutputStream2.close();
                    } catch (Exception e6) {
                        e6.printStackTrace();
                        return;
                    }
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            } catch (Throwable th3) {
                th = th3;
                dataOutputStream = dataOutputStream2;
                httpURLConnection3 = httpURLConnection;
                if (dataOutputStream != null) {
                    try {
                        dataOutputStream.close();
                    } catch (Exception e7) {
                        e7.printStackTrace();
                        throw th;
                    }
                }
                if (httpURLConnection3 != null) {
                    httpURLConnection3.disconnect();
                }
                throw th;
            }
        } catch (Throwable th4) {
            httpURLConnection3 = httpURLConnection2;
            th = th4;
            if (dataOutputStream != null) {
            }
            if (httpURLConnection3 != null) {
            }
            throw th;
        }
    }
}
