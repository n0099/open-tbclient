package com.baidu.swan.apps.statistic.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int cyL = 35;
    private JSONObject cOy;
    private boolean cyN = false;

    public d() {
        this.mSource = "NA";
    }

    public d hp(int i) {
        this.mType = String.valueOf(i);
        return this;
    }

    public d f(@NonNull com.baidu.swan.apps.an.a aVar) {
        this.mType = String.valueOf(aVar.avT());
        bV("detail", aVar.avS().toString());
        return this;
    }

    public d fA(boolean z) {
        this.cyN = z;
        return this;
    }

    public d pu(String str) {
        this.mFrom = str;
        return this;
    }

    public d pv(String str) {
        this.mAppId = str;
        return this;
    }

    public d pw(String str) {
        this.mSource = str;
        return this;
    }

    public d px(String str) {
        this.mPage = str;
        return this;
    }

    public d bV(String str, String str2) {
        if (str != null && str2 != null) {
            if (this.cOy == null) {
                this.cOy = new JSONObject();
            }
            try {
                this.cOy.put(str, str2);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return this;
    }

    public d a(com.baidu.swan.apps.u.c.e eVar) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(eVar.ajg())) {
                this.mSource = eVar.ajg();
            }
            if (!TextUtils.isEmpty(eVar.getAppId())) {
                this.mAppId = eVar.getAppId();
            }
            if (!TextUtils.isEmpty(eVar.aji())) {
                this.mScheme = eVar.aji();
            }
            if (!TextUtils.isEmpty(eVar.getPage())) {
                this.cOJ = eVar.getPage();
            }
        }
        return this;
    }

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.cOz == null) {
            this.cOz = new JSONObject();
        }
        try {
            if (this.cOy != null) {
                if (this.cyN) {
                    String m27if = al.m27if(cyL);
                    if (!TextUtils.isEmpty(m27if)) {
                        this.cOy.put("stacktrace", m27if);
                    }
                }
                this.cOz.put("info", this.cOy);
            }
            ExtensionCore adR = com.baidu.swan.apps.core.turbo.d.adw().adR();
            if (adR != null) {
                this.cOz.put("extension_ver", adR.extensionCoreVersionName);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
