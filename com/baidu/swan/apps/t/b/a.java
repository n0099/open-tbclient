package com.baidu.swan.apps.t.b;

import android.content.Context;
import androidx.annotation.Nullable;
import com.baidu.searchbox.aperf.bosuploader.BaseUrlManager;
import com.baidu.swan.apps.adaptation.a.r;
/* loaded from: classes9.dex */
public abstract class a implements r {
    @Override // com.baidu.swan.apps.adaptation.a.r
    public String alL() {
        return String.format("%s/pms", "https://ossapi.baidu.com");
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String alc() {
        return com.baidu.swan.apps.t.a.aBd().getHostName();
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public int alN() {
        return 2;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String alO() {
        return String.format("%s/ma/landingpage?t=service_agreement_m", "https://ossapi.baidu.com");
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String alP() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/navigate", BaseUrlManager.ONLINE_URL));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public boolean akL() {
        return isDebug();
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public boolean isDebug() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public void alI() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public void alJ() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String cf(Context context) {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String alK() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String akO() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String akZ() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ala() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String alb() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public boolean alM() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    @Nullable
    public String ald() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String alQ() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String alR() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String alS() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String kP(String str) {
        return com.baidu.swan.apps.i.c.processCommonParams(str);
    }
}
