package com.baidu.swan.apps.t.b;

import android.content.Context;
import android.support.annotation.Nullable;
import com.baidu.searchbox.aperf.bosuploader.BaseUrlManager;
import com.baidu.swan.apps.adaptation.a.r;
/* loaded from: classes25.dex */
public abstract class a implements r {
    @Override // com.baidu.swan.apps.adaptation.a.r
    public String akB() {
        return String.format("%s/pms", "https://ossapi.baidu.com");
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ajU() {
        return com.baidu.swan.apps.t.a.azM().getHostName();
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public int akD() {
        return 2;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String akE() {
        return String.format("%s/ma/landingpage?t=service_agreement_m", "https://ossapi.baidu.com");
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String akF() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/navigate", BaseUrlManager.ONLINE_URL));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public boolean ajD() {
        return isDebug();
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public boolean isDebug() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public void aky() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public void akz() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String bY(Context context) {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String akA() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ajG() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ajR() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ajS() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ajT() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public boolean akC() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    @Nullable
    public String ajV() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String akG() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String akH() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String akI() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String kW(String str) {
        return com.baidu.swan.apps.i.c.processCommonParams(str);
    }
}
