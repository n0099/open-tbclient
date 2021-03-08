package com.baidu.mobads.g;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.mobads.g.g;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class i extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f2391a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(g gVar, Looper looper) {
        super(looper);
        this.f2391a = gVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        IXAdLogger iXAdLogger;
        boolean z;
        Context context;
        IXAdLogger iXAdLogger2;
        boolean z2;
        boolean o;
        String string = message.getData().getString("CODE");
        e eVar = (e) message.getData().getParcelable("APK_INFO");
        if ("OK".equals(string)) {
            String e = eVar.e();
            context = this.f2391a.l;
            b bVar = new b(e, context, eVar);
            try {
                if (this.f2391a.g != g.f) {
                    this.f2391a.a(bVar);
                    g gVar = this.f2391a;
                    bVar.a(g.f());
                    this.f2391a.a(true);
                } else {
                    bVar.a();
                    bVar.a(g.f());
                    if (g.b != null) {
                        g.b.f2385a = eVar.b();
                    }
                    this.f2391a.j();
                    z2 = this.f2391a.n;
                    if (z2) {
                        this.f2391a.n = false;
                        g gVar2 = this.f2391a;
                        o = this.f2391a.o();
                        gVar2.a(o, "load remote file just downloaded");
                    }
                }
                return;
            } catch (g.a e2) {
                this.f2391a.a(false);
                iXAdLogger2 = this.f2391a.m;
                iXAdLogger2.d("XAdApkLoader", "download apk file failed: " + e2.toString());
                return;
            } finally {
                bVar.delete();
            }
        }
        iXAdLogger = this.f2391a.m;
        iXAdLogger.d("XAdApkLoader", "mOnApkDownloadCompleted: download failed, code: " + string);
        this.f2391a.a(false);
        z = this.f2391a.n;
        if (z) {
            this.f2391a.n = false;
            this.f2391a.a(false, "Refused to download remote for version...");
        }
    }
}
