package com.baidu.swan.apps.t.b;

import android.content.Context;
import android.support.annotation.Nullable;
import com.baidu.swan.apps.adaptation.a.r;
/* loaded from: classes10.dex */
public abstract class a implements r {
    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aib() {
        return String.format("%s/pms", "https://ossapi.baidu.com");
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ahu() {
        return com.baidu.swan.apps.t.a.axm().getHostName();
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public int aid() {
        return 2;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aie() {
        return String.format("%s/ma/landingpage?t=service_agreement_m", "https://ossapi.baidu.com");
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aif() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/navigate", "https://mbd.baidu.com"));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public boolean ahd() {
        return isDebug();
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public boolean isDebug() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public void ahY() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public void ahZ() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String bs(Context context) {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aia() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ahg() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ahr() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ahs() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aht() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public boolean aic() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    @Nullable
    public String ahv() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aig() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aih() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aii() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String kv(String str) {
        return com.baidu.swan.apps.i.c.processCommonParams(str);
    }
}
