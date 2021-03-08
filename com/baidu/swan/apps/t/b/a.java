package com.baidu.swan.apps.t.b;

import android.content.Context;
import androidx.annotation.Nullable;
import com.baidu.searchbox.aperf.bosuploader.BaseUrlManager;
import com.baidu.swan.apps.adaptation.a.r;
/* loaded from: classes8.dex */
public abstract class a implements r {
    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ait() {
        return String.format("%s/pms", "https://ossapi.baidu.com");
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ahK() {
        return com.baidu.swan.apps.t.a.axL().getHostName();
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public int aiv() {
        return 2;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aiw() {
        return String.format("%s/ma/landingpage?t=service_agreement_m", "https://ossapi.baidu.com");
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aix() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/navigate", BaseUrlManager.ONLINE_URL));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public boolean aht() {
        return isDebug();
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public boolean isDebug() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public void aiq() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public void air() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String cc(Context context) {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ais() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ahw() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ahH() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ahI() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ahJ() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public boolean aiu() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    @Nullable
    public String ahL() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aiy() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aiz() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aiA() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String kd(String str) {
        return com.baidu.swan.apps.i.c.processCommonParams(str);
    }
}
