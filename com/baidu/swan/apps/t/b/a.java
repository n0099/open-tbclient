package com.baidu.swan.apps.t.b;

import android.content.Context;
import androidx.annotation.Nullable;
import com.baidu.searchbox.aperf.bosuploader.BaseUrlManager;
import com.baidu.swan.apps.adaptation.a.r;
/* loaded from: classes8.dex */
public abstract class a implements r {
    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ahS() {
        return String.format("%s/pms", "https://ossapi.baidu.com");
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ahj() {
        return com.baidu.swan.apps.t.a.axk().getHostName();
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public int ahU() {
        return 2;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ahV() {
        return String.format("%s/ma/landingpage?t=service_agreement_m", "https://ossapi.baidu.com");
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ahW() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/navigate", BaseUrlManager.ONLINE_URL));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public boolean agS() {
        return isDebug();
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public boolean isDebug() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public void ahP() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public void ahQ() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ce(Context context) {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ahR() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String agV() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ahg() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ahh() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ahi() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public boolean ahT() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    @Nullable
    public String ahk() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ahX() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ahY() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ahZ() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String jE(String str) {
        return com.baidu.swan.apps.i.c.processCommonParams(str);
    }
}
