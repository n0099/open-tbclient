package com.baidu.clientupdate;

import com.baidu.util.LogUtil;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.SSLHandshakeException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class c extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ClientUpdater f1361a;

    public c(ClientUpdater clientUpdater) {
        this.f1361a = clientUpdater;
        setName("SDK_ClientUpdater_thread");
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:41:0x00d6 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:43:0x0062 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v16, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r0v19, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.String] */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        com.baidu.clientupdate.c.a aVar;
        boolean z;
        com.baidu.clientupdate.c.a aVar2;
        com.baidu.clientupdate.c.a aVar3;
        ?? r0;
        String str;
        Throwable th;
        HttpURLConnection httpURLConnection;
        Exception exc;
        String str2;
        boolean z2;
        com.baidu.clientupdate.c.a aVar4;
        aVar = this.f1361a.n;
        if (aVar == null) {
            return;
        }
        z = this.f1361a.d;
        try {
            try {
                try {
                    if (!z) {
                        z2 = this.f1361a.k;
                        if (!z2) {
                            aVar4 = this.f1361a.n;
                            aVar4.b(false);
                            this.f1361a.k = false;
                            ClientUpdater clientUpdater = this.f1361a;
                            aVar3 = this.f1361a.n;
                            clientUpdater.c = aVar3.b("/lcmanage/index.php?r=InterfaceAction&method=upgrade&contype=client&clientv=3.0");
                            r0 = "ClientUpdater";
                            StringBuilder append = new StringBuilder().append("更新检查请求的完整参数： ");
                            str = this.f1361a.c;
                            LogUtil.logE("ClientUpdater", append.append(str).toString());
                            StringBuilder sb = new StringBuilder();
                            str2 = this.f1361a.c;
                            r0 = (HttpURLConnection) new URL(str2).openConnection();
                            r0.setConnectTimeout(5000);
                            r0.setReadTimeout(5000);
                            r0.connect();
                            this.f1361a.a(r0, null, sb);
                            if (r0 == 0) {
                                r0.disconnect();
                                return;
                            }
                            return;
                        }
                    }
                    r0.setConnectTimeout(5000);
                    r0.setReadTimeout(5000);
                    r0.connect();
                    this.f1361a.a(r0, null, sb);
                    if (r0 == 0) {
                    }
                } catch (SSLHandshakeException e) {
                    try {
                        LogUtil.logE("ClientUpdater", "SSLHandshakeException caught!!!! ");
                        this.f1361a.c();
                    } catch (Exception e2) {
                        this.f1361a.a(e2);
                    }
                    if (r0 != 0) {
                        r0.disconnect();
                        return;
                    }
                    return;
                } catch (Exception e3) {
                    exc = e3;
                    httpURLConnection = r0;
                    try {
                        this.f1361a.a(exc);
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                            return;
                        }
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        if (httpURLConnection != null) {
                        }
                        throw th;
                    }
                }
                str2 = this.f1361a.c;
                r0 = (HttpURLConnection) new URL(str2).openConnection();
            } catch (Throwable th3) {
                th = th3;
                httpURLConnection = r0;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (SSLHandshakeException e4) {
            r0 = 0;
        } catch (Exception e5) {
            exc = e5;
            httpURLConnection = null;
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection = null;
            if (httpURLConnection != null) {
            }
            throw th;
        }
        aVar2 = this.f1361a.n;
        aVar2.b(true);
        this.f1361a.k = false;
        ClientUpdater clientUpdater2 = this.f1361a;
        aVar3 = this.f1361a.n;
        clientUpdater2.c = aVar3.b("/lcmanage/index.php?r=InterfaceAction&method=upgrade&contype=client&clientv=3.0");
        r0 = "ClientUpdater";
        StringBuilder append2 = new StringBuilder().append("更新检查请求的完整参数： ");
        str = this.f1361a.c;
        LogUtil.logE("ClientUpdater", append2.append(str).toString());
        StringBuilder sb2 = new StringBuilder();
    }
}
