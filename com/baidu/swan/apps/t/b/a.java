package com.baidu.swan.apps.t.b;

import android.content.Context;
import android.support.annotation.Nullable;
import com.baidu.swan.apps.adaptation.a.r;
/* loaded from: classes10.dex */
public abstract class a implements r {
    @Override // com.baidu.swan.apps.adaptation.a.r
    public String adH() {
        return String.format("%s/pms", "https://ossapi.baidu.com");
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ada() {
        return com.baidu.swan.apps.t.a.asS().getHostName();
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public int adJ() {
        return 2;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String adK() {
        return String.format("%s/ma/landingpage?t=service_agreement_m", "https://ossapi.baidu.com");
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String adL() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/navigate", "https://mbd.baidu.com"));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public boolean acJ() {
        return isDebug();
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public boolean isDebug() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public void adE() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public void adF() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String bs(Context context) {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String adG() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String acM() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String acX() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String acY() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String acZ() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public boolean adI() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    @Nullable
    public String adb() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String adM() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String adN() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String adO() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String jN(String str) {
        return com.baidu.swan.apps.i.c.processCommonParams(str);
    }
}
