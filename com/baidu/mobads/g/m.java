package com.baidu.mobads.g;

import android.content.SharedPreferences;
import com.baidu.mobads.constants.XAdSDKProxyVersion;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
/* loaded from: classes2.dex */
public class m implements IOAdEventListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ double f8292a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ g f8293b;

    public m(g gVar, double d2) {
        this.f8293b = gVar;
        this.f8292a = d2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0072, code lost:
        if (r2 == java.lang.Math.floor(r5.b())) goto L10;
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
        this.f8293b.n();
        if ("URLLoader.Load.Complete".equals(iOAdEvent.getType())) {
            this.f8293b.k = new e((String) iOAdEvent.getData().get("message"));
            double version = XAdSDKProxyVersion.getVersion();
            k = this.f8293b.k();
            float f2 = k.getFloat("__badApkVersion__8.8448", 0.0f);
            eVar = this.f8293b.k;
            boolean z3 = true;
            Boolean valueOf = Boolean.valueOf(((float) eVar.b()) == f2);
            eVar2 = this.f8293b.k;
            if (version <= eVar2.b()) {
                double floor = Math.floor(version);
                eVar7 = this.f8293b.k;
            }
            z3 = false;
            Boolean valueOf2 = Boolean.valueOf(z3);
            iXAdLogger = this.f8293b.m;
            iXAdLogger.d("XAdApkLoader", "try to download apk badVer=" + f2 + ", isBad=" + valueOf + ", compatible=" + valueOf2);
            double d2 = this.f8292a;
            eVar3 = this.f8293b.k;
            if (d2 < eVar3.b()) {
                eVar4 = this.f8293b.k;
                if (eVar4 != null) {
                    eVar5 = this.f8293b.k;
                    if (eVar5.a().booleanValue() && valueOf2.booleanValue() && !valueOf.booleanValue()) {
                        g gVar = this.f8293b;
                        eVar6 = gVar.k;
                        gVar.a(eVar6);
                        return;
                    }
                }
            }
            z2 = this.f8293b.n;
            if (z2) {
                this.f8293b.n = false;
                this.f8293b.a(false, "Refused to download remote for version...");
                return;
            }
            return;
        }
        z = this.f8293b.n;
        if (z) {
            this.f8293b.n = false;
            this.f8293b.a(false, "remote update Network access failed");
        }
    }
}
