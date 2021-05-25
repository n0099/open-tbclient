package com.baidu.clientupdate;

import com.baidu.util.LogUtil;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.SSLHandshakeException;
/* loaded from: classes.dex */
public class c extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClientUpdater f4580a;

    public c(ClientUpdater clientUpdater) {
        this.f4580a = clientUpdater;
        setName("SDK_ClientUpdater_thread");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:5|(4:(2:7|(8:9|10|11|12|13|14|15|(2:17|18)(1:19)))|14|15|(0)(0))|45|10|11|12|13) */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0094, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0096, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b9, code lost:
        r2.disconnect();
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b6 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b9  */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        com.baidu.clientupdate.c.a aVar;
        boolean z;
        com.baidu.clientupdate.c.a aVar2;
        com.baidu.clientupdate.c.a aVar3;
        String str;
        HttpURLConnection httpURLConnection;
        String str2;
        HttpURLConnection httpURLConnection2;
        boolean z2;
        com.baidu.clientupdate.c.a aVar4;
        aVar = this.f4580a.n;
        if (aVar == null) {
            return;
        }
        z = this.f4580a.f4549d;
        try {
            if (!z) {
                z2 = this.f4580a.k;
                if (!z2) {
                    aVar4 = this.f4580a.n;
                    aVar4.b(false);
                    this.f4580a.k = false;
                    ClientUpdater clientUpdater = this.f4580a;
                    aVar3 = clientUpdater.n;
                    clientUpdater.f4548c = aVar3.b("/lcmanage/index.php?r=InterfaceAction&method=upgrade&contype=client&clientv=3.0");
                    StringBuilder sb = new StringBuilder();
                    sb.append("更新检查请求的完整参数： ");
                    str = this.f4580a.f4548c;
                    sb.append(str);
                    LogUtil.logE("ClientUpdater", sb.toString());
                    StringBuilder sb2 = new StringBuilder();
                    httpURLConnection = null;
                    str2 = this.f4580a.f4548c;
                    httpURLConnection2 = (HttpURLConnection) new URL(str2).openConnection();
                    httpURLConnection2.setConnectTimeout(5000);
                    httpURLConnection2.setReadTimeout(5000);
                    httpURLConnection2.connect();
                    this.f4580a.a(httpURLConnection2, null, sb2);
                    if (httpURLConnection2 == null) {
                        httpURLConnection2.disconnect();
                        return;
                    }
                    return;
                }
            }
            httpURLConnection2.setConnectTimeout(5000);
            httpURLConnection2.setReadTimeout(5000);
            httpURLConnection2.connect();
            this.f4580a.a(httpURLConnection2, null, sb2);
            if (httpURLConnection2 == null) {
            }
        } catch (SSLHandshakeException unused) {
            httpURLConnection = httpURLConnection2;
            try {
                LogUtil.logE("ClientUpdater", "SSLHandshakeException caught!!!! ");
                this.f4580a.c();
            } catch (Exception e2) {
                this.f4580a.a(e2);
            }
            if (httpURLConnection == null) {
                return;
            }
            httpURLConnection.disconnect();
            return;
        } catch (Exception e3) {
            e = e3;
            httpURLConnection = httpURLConnection2;
            this.f4580a.a(e);
            if (httpURLConnection == null) {
                return;
            }
            httpURLConnection.disconnect();
            return;
        } catch (Throwable th) {
            th = th;
            httpURLConnection = httpURLConnection2;
            if (httpURLConnection != null) {
            }
            throw th;
        }
        aVar2 = this.f4580a.n;
        aVar2.b(true);
        this.f4580a.k = false;
        ClientUpdater clientUpdater2 = this.f4580a;
        aVar3 = clientUpdater2.n;
        clientUpdater2.f4548c = aVar3.b("/lcmanage/index.php?r=InterfaceAction&method=upgrade&contype=client&clientv=3.0");
        StringBuilder sb3 = new StringBuilder();
        sb3.append("更新检查请求的完整参数： ");
        str = this.f4580a.f4548c;
        sb3.append(str);
        LogUtil.logE("ClientUpdater", sb3.toString());
        StringBuilder sb22 = new StringBuilder();
        httpURLConnection = null;
        str2 = this.f4580a.f4548c;
        httpURLConnection2 = (HttpURLConnection) new URL(str2).openConnection();
    }
}
