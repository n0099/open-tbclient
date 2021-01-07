package com.baidu.swan.apps.t.b;

import android.content.Context;
import androidx.annotation.Nullable;
import com.baidu.searchbox.aperf.bosuploader.BaseUrlManager;
import com.baidu.swan.apps.adaptation.a.r;
/* loaded from: classes9.dex */
public abstract class a implements r {
    @Override // com.baidu.swan.apps.adaptation.a.r
    public String alM() {
        return String.format("%s/pms", "https://ossapi.baidu.com");
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ald() {
        return com.baidu.swan.apps.t.a.aBe().getHostName();
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public int alO() {
        return 2;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String alP() {
        return String.format("%s/ma/landingpage?t=service_agreement_m", "https://ossapi.baidu.com");
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String alQ() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/navigate", BaseUrlManager.ONLINE_URL));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public boolean akM() {
        return isDebug();
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public boolean isDebug() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public void alJ() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public void alK() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String cf(Context context) {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String alL() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String akP() {
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
    public String alc() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public boolean alN() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    @Nullable
    public String ale() {
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
    public String alT() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String kP(String str) {
        return com.baidu.swan.apps.i.c.processCommonParams(str);
    }
}
