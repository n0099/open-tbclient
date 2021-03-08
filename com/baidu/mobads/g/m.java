package com.baidu.mobads.g;

import android.content.SharedPreferences;
import com.baidu.mobads.constants.XAdSDKProxyVersion;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class m implements IOAdEventListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ double f2395a;
    final /* synthetic */ g b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(g gVar, double d) {
        this.b = gVar;
        this.f2395a = d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0073, code lost:
        if (r4 == java.lang.Math.floor(r6.b())) goto L10;
     */
    @Override // com.baidu.mobads.openad.interfaces.event.IOAdEventListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run(IOAdEvent iOAdEvent) {
        boolean z;
        SharedPreferences k;
        e eVar;
        e eVar2;
        IXAdLogger iXAdLogger;
        e eVar3;
        boolean z2;
        e eVar4;
        e eVar5;
        e eVar6;
        e eVar7;
        boolean z3 = true;
        this.b.n();
        if ("URLLoader.Load.Complete".equals(iOAdEvent.getType())) {
            this.b.k = new e((String) iOAdEvent.getData().get("message"));
            double version = XAdSDKProxyVersion.getVersion();
            k = this.b.k();
            float f = k.getFloat("__badApkVersion__8.8451", 0.0f);
            eVar = this.b.k;
            Boolean valueOf = Boolean.valueOf(((float) eVar.b()) == f);
            eVar2 = this.b.k;
            if (version <= eVar2.b()) {
                double floor = Math.floor(version);
                eVar7 = this.b.k;
            }
            z3 = false;
            Boolean valueOf2 = Boolean.valueOf(z3);
            iXAdLogger = this.b.m;
            iXAdLogger.d("XAdApkLoader", "try to download apk badVer=" + f + ", isBad=" + valueOf + ", compatible=" + valueOf2);
            double d = this.f2395a;
            eVar3 = this.b.k;
            if (d < eVar3.b()) {
                eVar4 = this.b.k;
                if (eVar4 != null) {
                    eVar5 = this.b.k;
                    if (eVar5.a().booleanValue() && valueOf2.booleanValue() && !valueOf.booleanValue()) {
                        g gVar = this.b;
                        eVar6 = this.b.k;
                        gVar.a(eVar6);
                        return;
                    }
                }
            }
            z2 = this.b.n;
            if (z2) {
                this.b.n = false;
                this.b.a(false, "Refused to download remote for version...");
                return;
            }
            return;
        }
        z = this.b.n;
        if (z) {
            this.b.n = false;
            this.b.a(false, "remote update Network access failed");
        }
    }
}
