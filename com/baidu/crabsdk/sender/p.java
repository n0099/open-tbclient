package com.baidu.crabsdk.sender;

import android.content.Context;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class p implements Runnable {
    final /* synthetic */ Context acD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(Context context) {
        this.acD = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00b6 A[Catch: Exception -> 0x00ba, TRY_LEAVE, TryCatch #4 {Exception -> 0x00ba, blocks: (B:34:0x00b1, B:36:0x00b6), top: B:53:0x00b1, outer: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00b1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        DataOutputStream dataOutputStream;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2 = null;
        r1 = null;
        DataOutputStream dataOutputStream2 = null;
        try {
            try {
                String sb = g.sb();
                com.baidu.crabsdk.c.a.v("sync json is " + sb);
                httpURLConnection = (HttpURLConnection) new URL(com.baidu.crabsdk.a.c()).openConnection();
                try {
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setInstanceFollowRedirects(true);
                    httpURLConnection.setRequestProperty("User-Agent", g.a("sync", (String) null));
                    httpURLConnection.setConnectTimeout(3000);
                    httpURLConnection.setReadTimeout(3000);
                    dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    try {
                        dataOutputStream.writeBytes(sb);
                        dataOutputStream.flush();
                        dataOutputStream.close();
                        if (httpURLConnection.getResponseCode() == 200) {
                            com.baidu.crabsdk.b.m.clear();
                            com.baidu.crabsdk.c.a.cv("#### ^@^ sync ok!");
                        } else {
                            com.baidu.crabsdk.c.a.cv("#### T^T sync failed!");
                        }
                        httpURLConnection.disconnect();
                        try {
                            dataOutputStream.close();
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        dataOutputStream2 = dataOutputStream;
                        try {
                            com.baidu.crabsdk.c.a.cv("sync connect to server error!");
                            if (dataOutputStream2 != null) {
                                try {
                                    dataOutputStream2.close();
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                    return;
                                }
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                        } catch (Throwable th) {
                            dataOutputStream = dataOutputStream2;
                            httpURLConnection2 = httpURLConnection;
                            th = th;
                            if (dataOutputStream != null) {
                                try {
                                    dataOutputStream.close();
                                } catch (Exception e4) {
                                    e4.printStackTrace();
                                    throw th;
                                }
                            }
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        httpURLConnection2 = httpURLConnection;
                        th = th2;
                        if (dataOutputStream != null) {
                        }
                        if (httpURLConnection2 != null) {
                        }
                        throw th;
                    }
                } catch (Exception e5) {
                } catch (Throwable th3) {
                    dataOutputStream = null;
                    httpURLConnection2 = httpURLConnection;
                    th = th3;
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        } catch (Exception e7) {
            httpURLConnection = null;
        } catch (Throwable th4) {
            th = th4;
            dataOutputStream = null;
        }
    }
}
