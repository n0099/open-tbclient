package com.baidu.swan.apps.t.b;

import android.content.Context;
import androidx.annotation.Nullable;
import com.baidu.searchbox.aperf.bosuploader.BaseUrlManager;
import com.baidu.swan.apps.adaptation.a.r;
/* loaded from: classes9.dex */
public abstract class a implements r {
    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aiq() {
        return String.format("%s/pms", "https://ossapi.baidu.com");
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ahH() {
        return com.baidu.swan.apps.t.a.axI().getHostName();
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public int ais() {
        return 2;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ait() {
        return String.format("%s/ma/landingpage?t=service_agreement_m", "https://ossapi.baidu.com");
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aiu() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/navigate", BaseUrlManager.ONLINE_URL));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public boolean ahq() {
        return isDebug();
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public boolean isDebug() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public void ain() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public void aio() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String cd(Context context) {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aip() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aht() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ahE() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ahF() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ahG() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public boolean air() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    @Nullable
    public String ahI() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aiv() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aiw() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aix() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String jW(String str) {
        return com.baidu.swan.apps.i.c.processCommonParams(str);
    }
}
