package com.baidu.clientupdate;

import com.baidu.util.LogUtil;
import java.net.HttpURLConnection;
import java.net.URL;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public class c extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ClientUpdater f1324a;

    public c(ClientUpdater clientUpdater) {
        this.f1324a = clientUpdater;
        setName("SDK_ClientUpdater_thread");
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x00bd */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:0x00ca */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:0x00d1 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:40:0x0062 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:44:0x0062 */
    /* JADX WARN: Can't wrap try/catch for region: R(13:3|(2:5|(11:7|8|9|10|11|12|13|14|(1:16)|17|18))|47|8|9|10|11|12|13|14|(0)|17|18) */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0096, code lost:
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0097, code lost:
        com.baidu.util.LogUtil.logE("ClientUpdater", "SSLHandshakeException caught!!!! ");
        r6.f1324a.c();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00a5, code lost:
        if (r0 != 0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00a7, code lost:
        r0.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00ac, code lost:
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00ad, code lost:
        r6.f1324a.a(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00bd, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00be, code lost:
        r6.f1324a.a(r0);
        r1 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00c3, code lost:
        if (r1 != null) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00c5, code lost:
        r1.disconnect();
        r1 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00cc, code lost:
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00cd, code lost:
        r1 = r0;
        r0 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:?, code lost:
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0087  */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v17, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r0v20, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v15, types: [com.baidu.clientupdate.ClientUpdater] */
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
        String str2;
        boolean z2;
        com.baidu.clientupdate.c.a aVar4;
        HttpURLConnection httpURLConnection = null;
        HttpURLConnection httpURLConnection2 = null;
        aVar = this.f1324a.n;
        if (aVar == null) {
            return;
        }
        z = this.f1324a.d;
        try {
            try {
                if (!z) {
                    z2 = this.f1324a.k;
                    if (!z2) {
                        aVar4 = this.f1324a.n;
                        aVar4.b(false);
                        this.f1324a.k = false;
                        ClientUpdater clientUpdater = this.f1324a;
                        aVar3 = this.f1324a.n;
                        clientUpdater.c = aVar3.b("/lcmanage/index.php?r=InterfaceAction&method=upgrade&contype=client&clientv=3.0");
                        r0 = "ClientUpdater";
                        StringBuilder append = new StringBuilder().append("更新检查请求的完整参数： ");
                        str = this.f1324a.c;
                        LogUtil.logE("ClientUpdater", append.append(str).toString());
                        StringBuilder sb = new StringBuilder();
                        str2 = this.f1324a.c;
                        r0 = (HttpURLConnection) new URL(str2).openConnection();
                        r0.setConnectTimeout(5000);
                        r0.setReadTimeout(5000);
                        r0.connect();
                        ?? r1 = this.f1324a;
                        r1.a(r0, null, sb);
                        httpURLConnection = r1;
                        if (r0 != 0) {
                            r0.disconnect();
                            httpURLConnection = r1;
                        }
                        return;
                    }
                }
                str2 = this.f1324a.c;
                r0 = (HttpURLConnection) new URL(str2).openConnection();
                r0.setConnectTimeout(5000);
                r0.setReadTimeout(5000);
                r0.connect();
                ?? r12 = this.f1324a;
                r12.a(r0, null, sb);
                httpURLConnection = r12;
                if (r0 != 0) {
                }
                return;
            } catch (Throwable th) {
                httpURLConnection = r0;
                th = th;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        aVar2 = this.f1324a.n;
        aVar2.b(true);
        this.f1324a.k = false;
        ClientUpdater clientUpdater2 = this.f1324a;
        aVar3 = this.f1324a.n;
        clientUpdater2.c = aVar3.b("/lcmanage/index.php?r=InterfaceAction&method=upgrade&contype=client&clientv=3.0");
        r0 = "ClientUpdater";
        StringBuilder append2 = new StringBuilder().append("更新检查请求的完整参数： ");
        str = this.f1324a.c;
        LogUtil.logE("ClientUpdater", append2.append(str).toString());
        StringBuilder sb2 = new StringBuilder();
    }
}
