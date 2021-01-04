package com.baidu.crabsdk.sender;

import android.content.Context;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class q implements Runnable {
    final /* synthetic */ Context arJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(Context context) {
        this.arJ = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00b8 A[Catch: Exception -> 0x00bc, TRY_LEAVE, TryCatch #3 {Exception -> 0x00bc, blocks: (B:34:0x00b3, B:36:0x00b8), top: B:53:0x00b3, outer: #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00b3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        Throwable th;
        HttpURLConnection httpURLConnection;
        DataOutputStream dataOutputStream;
        Exception e;
        try {
            try {
                String uD = g.uD();
                com.baidu.crabsdk.c.a.v("sync json is " + uD);
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(com.baidu.crabsdk.a.c()).openConnection();
                try {
                    httpURLConnection2.setRequestMethod("POST");
                    httpURLConnection2.setDoInput(true);
                    httpURLConnection2.setDoOutput(true);
                    httpURLConnection2.setUseCaches(false);
                    httpURLConnection2.setInstanceFollowRedirects(true);
                    httpURLConnection2.setRequestProperty("User-Agent", g.a("sync", (String) null));
                    httpURLConnection2.setConnectTimeout(8000);
                    httpURLConnection2.setReadTimeout(8000);
                    dataOutputStream = new DataOutputStream(httpURLConnection2.getOutputStream());
                } catch (Exception e2) {
                    e = e2;
                    httpURLConnection = httpURLConnection2;
                    dataOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    httpURLConnection = httpURLConnection2;
                    dataOutputStream = null;
                }
                try {
                    dataOutputStream.writeBytes(uD);
                    dataOutputStream.flush();
                    dataOutputStream.close();
                    if (httpURLConnection2.getResponseCode() == 200) {
                        com.baidu.crabsdk.b.n.clear();
                        com.baidu.crabsdk.c.a.dx("#### ^@^ sync ok!");
                    } else {
                        com.baidu.crabsdk.c.a.dx("#### T^T sync failed!");
                    }
                    httpURLConnection2.disconnect();
                    try {
                        dataOutputStream.close();
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                } catch (Exception e4) {
                    e = e4;
                    httpURLConnection = httpURLConnection2;
                    try {
                        com.baidu.crabsdk.c.a.a("sync connect to server error!", e);
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.close();
                            } catch (Exception e5) {
                                e5.printStackTrace();
                                return;
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.close();
                            } catch (Exception e6) {
                                e6.printStackTrace();
                                throw th;
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    httpURLConnection = httpURLConnection2;
                    if (dataOutputStream != null) {
                    }
                    if (httpURLConnection != null) {
                    }
                    throw th;
                }
            } catch (Exception e7) {
                e7.printStackTrace();
            }
        } catch (Exception e8) {
            e = e8;
            httpURLConnection = null;
            dataOutputStream = null;
        } catch (Throwable th5) {
            th = th5;
            httpURLConnection = null;
            dataOutputStream = null;
        }
    }
}
