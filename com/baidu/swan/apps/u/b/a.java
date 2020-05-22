package com.baidu.swan.apps.u.b;

import android.content.Context;
import android.support.annotation.Nullable;
import com.baidu.swan.apps.adaptation.a.q;
/* loaded from: classes11.dex */
public abstract class a implements q {
    @Override // com.baidu.swan.apps.adaptation.a.q
    public String SH() {
        return String.format("%s/pms", "https://ossapi.baidu.com");
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String Se() {
        return com.baidu.swan.apps.u.a.afB().getHostName();
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public int SJ() {
        return 2;
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String SK() {
        return String.format("%s/ma/landingpage?t=service_agreement_m", "https://ossapi.baidu.com");
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String SL() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/ma/navigate", "https://mbd.baidu.com"));
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public boolean RN() {
        return isDebug();
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public boolean isDebug() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String SC() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String SD() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public void SE() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public void SF() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String be(Context context) {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String SG() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String RQ() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String Sb() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String Sc() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String Sd() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public boolean SI() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    @Nullable
    public String Sf() {
        return null;
    }
}
