package com.baidu.mobads.g;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.mobads.g.g;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class i extends Handler {
    final /* synthetic */ g a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(g gVar, Looper looper) {
        super(looper);
        this.a = gVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        IXAdLogger iXAdLogger;
        boolean z;
        Context context;
        IXAdLogger iXAdLogger2;
        boolean z2;
        boolean p;
        String string = message.getData().getString("CODE");
        e eVar = (e) message.getData().getParcelable("APK_INFO");
        if ("OK".equals(string)) {
            String e = eVar.e();
            context = this.a.l;
            b bVar = new b(e, context, eVar);
            try {
                if (this.a.g != g.f) {
                    this.a.a(bVar);
                    g gVar = this.a;
                    bVar.a(g.f());
                    this.a.a(true);
                } else {
                    bVar.a();
                    bVar.a(g.f());
                    if (g.b != null) {
                        g.b.a = eVar.b();
                    }
                    this.a.k();
                    z2 = this.a.n;
                    if (z2) {
                        this.a.n = false;
                        g gVar2 = this.a;
                        p = this.a.p();
                        gVar2.a(p, "load remote file just downloaded");
                    }
                }
                return;
            } catch (g.a e2) {
                this.a.a(false);
                iXAdLogger2 = this.a.m;
                iXAdLogger2.e("XAdApkLoader", "download apk file failed: " + e2.toString());
                return;
            } finally {
                bVar.delete();
            }
        }
        iXAdLogger = this.a.m;
        iXAdLogger.e("XAdApkLoader", "mOnApkDownloadCompleted: download failed, code: " + string);
        this.a.a(false);
        z = this.a.n;
        if (z) {
            this.a.n = false;
            this.a.a(false, "Refused to download remote for version...");
        }
    }
}
