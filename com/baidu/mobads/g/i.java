package com.baidu.mobads.g;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.mobads.g.g;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public class i extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f3335a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(g gVar, Looper looper) {
        super(looper);
        this.f3335a = gVar;
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
            context = this.f3335a.l;
            b bVar = new b(e, context, eVar);
            try {
                if (this.f3335a.g != g.f) {
                    this.f3335a.a(bVar);
                    g gVar = this.f3335a;
                    bVar.a(g.f());
                    this.f3335a.a(true);
                } else {
                    bVar.a();
                    bVar.a(g.f());
                    if (g.f3334b != null) {
                        g.f3334b.f3324a = eVar.b();
                    }
                    this.f3335a.k();
                    z2 = this.f3335a.n;
                    if (z2) {
                        this.f3335a.n = false;
                        g gVar2 = this.f3335a;
                        p = this.f3335a.p();
                        gVar2.a(p, "load remote file just downloaded");
                    }
                }
                return;
            } catch (g.a e2) {
                this.f3335a.a(false);
                iXAdLogger2 = this.f3335a.m;
                iXAdLogger2.e("XAdApkLoader", "download apk file failed: " + e2.toString());
                return;
            } finally {
                bVar.delete();
            }
        }
        iXAdLogger = this.f3335a.m;
        iXAdLogger.e("XAdApkLoader", "mOnApkDownloadCompleted: download failed, code: " + string);
        this.f3335a.a(false);
        z = this.f3335a.n;
        if (z) {
            this.f3335a.n = false;
            this.f3335a.a(false, "Refused to download remote for version...");
        }
    }
}
