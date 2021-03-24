package com.baidu.mobads.g;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.mobads.g.g;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
/* loaded from: classes2.dex */
public class i extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g f8286a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(g gVar, Looper looper) {
        super(looper);
        this.f8286a = gVar;
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
            String e2 = eVar.e();
            context = this.f8286a.l;
            b bVar = new b(e2, context, eVar);
            try {
                try {
                    if (this.f8286a.f8284g != g.f8283f) {
                        this.f8286a.a(bVar);
                        bVar.a(g.f());
                        this.f8286a.a(true);
                    } else {
                        bVar.a();
                        bVar.a(g.f());
                        if (g.f8279b != null) {
                            g.f8279b.f8249a = eVar.b();
                        }
                        this.f8286a.j();
                        z2 = this.f8286a.n;
                        if (z2) {
                            this.f8286a.n = false;
                            g gVar = this.f8286a;
                            o = this.f8286a.o();
                            gVar.a(o, "load remote file just downloaded");
                        }
                    }
                } catch (g.a e3) {
                    this.f8286a.a(false);
                    iXAdLogger2 = this.f8286a.m;
                    iXAdLogger2.d("XAdApkLoader", "download apk file failed: " + e3.toString());
                }
                return;
            } finally {
                bVar.delete();
            }
        }
        iXAdLogger = this.f8286a.m;
        iXAdLogger.d("XAdApkLoader", "mOnApkDownloadCompleted: download failed, code: " + string);
        this.f8286a.a(false);
        z = this.f8286a.n;
        if (z) {
            this.f8286a.n = false;
            this.f8286a.a(false, "Refused to download remote for version...");
        }
    }
}
