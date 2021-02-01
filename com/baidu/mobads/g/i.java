package com.baidu.mobads.g;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.mobads.g.g;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class i extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f3347a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(g gVar, Looper looper) {
        super(looper);
        this.f3347a = gVar;
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
            context = this.f3347a.l;
            b bVar = new b(e, context, eVar);
            try {
                if (this.f3347a.g != g.f) {
                    this.f3347a.a(bVar);
                    g gVar = this.f3347a;
                    bVar.a(g.f());
                    this.f3347a.a(true);
                } else {
                    bVar.a();
                    bVar.a(g.f());
                    if (g.f3346b != null) {
                        g.f3346b.f3336a = eVar.b();
                    }
                    this.f3347a.j();
                    z2 = this.f3347a.n;
                    if (z2) {
                        this.f3347a.n = false;
                        g gVar2 = this.f3347a;
                        o = this.f3347a.o();
                        gVar2.a(o, "load remote file just downloaded");
                    }
                }
                return;
            } catch (g.a e2) {
                this.f3347a.a(false);
                iXAdLogger2 = this.f3347a.m;
                iXAdLogger2.d("XAdApkLoader", "download apk file failed: " + e2.toString());
                return;
            } finally {
                bVar.delete();
            }
        }
        iXAdLogger = this.f3347a.m;
        iXAdLogger.d("XAdApkLoader", "mOnApkDownloadCompleted: download failed, code: " + string);
        this.f3347a.a(false);
        z = this.f3347a.n;
        if (z) {
            this.f3347a.n = false;
            this.f3347a.a(false, "Refused to download remote for version...");
        }
    }
}
