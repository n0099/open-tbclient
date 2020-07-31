package com.baidu.mobads.g;

import android.content.SharedPreferences;
import android.util.Log;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
/* loaded from: classes20.dex */
class m implements IOAdEventListener {
    final /* synthetic */ double a;
    final /* synthetic */ l b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, double d) {
        this.b = lVar;
        this.a = d;
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
        this.b.a.b.o();
        if ("URLLoader.Load.Complete".equals(iOAdEvent.getType())) {
            this.b.a.b.k = new e((String) iOAdEvent.getData().get("message"));
            double a = com.baidu.mobads.a.b.a();
            l = this.b.a.b.l();
            float f = l.getFloat("__badApkVersion__8.8146", 0.0f);
            eVar = this.b.a.b.k;
            Boolean valueOf = Boolean.valueOf(((float) eVar.b()) == f);
            eVar2 = this.b.a.b.k;
            if (a <= eVar2.b()) {
                double floor = Math.floor(a);
                eVar7 = this.b.a.b.k;
            }
            z3 = false;
            Boolean valueOf2 = Boolean.valueOf(z3);
            Log.i("XAdApkLoader", "try to download apk badVer=" + f + ", isBad=" + valueOf + ", compatible=" + valueOf2);
            double d = this.a;
            eVar3 = this.b.a.b.k;
            if (d < eVar3.b()) {
                eVar4 = this.b.a.b.k;
                if (eVar4 != null) {
                    eVar5 = this.b.a.b.k;
                    if (eVar5.a().booleanValue() && valueOf2.booleanValue() && !valueOf.booleanValue()) {
                        g gVar = this.b.a.b;
                        eVar6 = this.b.a.b.k;
                        gVar.a(eVar6);
                        return;
                    }
                }
            }
            z2 = this.b.a.b.n;
            if (z2) {
                this.b.a.b.n = false;
                this.b.a.b.a(false, "Refused to download remote for version...");
                return;
            }
            return;
        }
        z = this.b.a.b.n;
        if (z) {
            this.b.a.b.n = false;
            this.b.a.b.a(false, "remote update Network access failed");
        }
    }
}
