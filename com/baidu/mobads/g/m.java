package com.baidu.mobads.g;

import android.content.SharedPreferences;
import android.util.Log;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
/* loaded from: classes3.dex */
class m implements IOAdEventListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ double f3378a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ l f3379b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, double d) {
        this.f3379b = lVar;
        this.f3378a = d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x008b, code lost:
        if (r4 == java.lang.Math.floor(r6.b())) goto L10;
     */
    @Override // com.baidu.mobads.openad.interfaces.event.IOAdEventListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run(IOAdEvent iOAdEvent) {
        boolean z;
        SharedPreferences l;
        e eVar;
        e eVar2;
        e eVar3;
        boolean z2;
        e eVar4;
        e eVar5;
        e eVar6;
        e eVar7;
        boolean z3 = true;
        this.f3379b.f3377a.f3376b.o();
        if ("URLLoader.Load.Complete".equals(iOAdEvent.getType())) {
            this.f3379b.f3377a.f3376b.k = new e((String) iOAdEvent.getData().get("message"));
            double a2 = com.baidu.mobads.a.b.a();
            l = this.f3379b.f3377a.f3376b.l();
            float f = l.getFloat("__badApkVersion__8.8146", 0.0f);
            eVar = this.f3379b.f3377a.f3376b.k;
            Boolean valueOf = Boolean.valueOf(((float) eVar.b()) == f);
            eVar2 = this.f3379b.f3377a.f3376b.k;
            if (a2 <= eVar2.b()) {
                double floor = Math.floor(a2);
                eVar7 = this.f3379b.f3377a.f3376b.k;
            }
            z3 = false;
            Boolean valueOf2 = Boolean.valueOf(z3);
            Log.i("XAdApkLoader", "try to download apk badVer=" + f + ", isBad=" + valueOf + ", compatible=" + valueOf2);
            double d = this.f3378a;
            eVar3 = this.f3379b.f3377a.f3376b.k;
            if (d < eVar3.b()) {
                eVar4 = this.f3379b.f3377a.f3376b.k;
                if (eVar4 != null) {
                    eVar5 = this.f3379b.f3377a.f3376b.k;
                    if (eVar5.a().booleanValue() && valueOf2.booleanValue() && !valueOf.booleanValue()) {
                        g gVar = this.f3379b.f3377a.f3376b;
                        eVar6 = this.f3379b.f3377a.f3376b.k;
                        gVar.a(eVar6);
                        return;
                    }
                }
            }
            z2 = this.f3379b.f3377a.f3376b.n;
            if (z2) {
                this.f3379b.f3377a.f3376b.n = false;
                this.f3379b.f3377a.f3376b.a(false, "Refused to download remote for version...");
                return;
            }
            return;
        }
        z = this.f3379b.f3377a.f3376b.n;
        if (z) {
            this.f3379b.f3377a.f3376b.n = false;
            this.f3379b.f3377a.f3376b.a(false, "remote update Network access failed");
        }
    }
}
