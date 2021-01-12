package com.baidu.swan.gamecenter.appmanager.a;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends com.baidu.swan.gamecenter.c.a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public a() {
        super("getDownloadConfig");
    }

    @Override // com.baidu.swan.gamecenter.c.a
    public com.baidu.swan.apps.api.c.b b(JSONObject jSONObject, com.baidu.swan.apps.o.b bVar) {
        if (jSONObject == null) {
            bVar.onFail(202, "params may be error");
        } else {
            if (jSONObject.has("wifiResumeDownloadFlag")) {
                com.baidu.swan.gamecenter.appmanager.download.b.aSX().hS(jSONObject.optBoolean("wifiResumeDownloadFlag", true));
            }
            if (jSONObject.has("install_guide_switch")) {
                com.baidu.swan.gamecenter.appmanager.install.a.hT(jSONObject.optBoolean("install_guide_switch"));
            }
            if (jSONObject.has("install_guide_count")) {
                com.baidu.swan.gamecenter.appmanager.install.a.kP(jSONObject.optInt("install_guide_count"));
            }
            bVar.aI(null);
        }
        return null;
    }
}
