package com.baidu.swan.apps.adlanding;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String chS;
    private int chT;
    private String cib;
    private int mVideoHeight;
    private String mVideoUrl;
    private int mVideoWidth;

    public d(String str, String str2, String str3, int i, int i2, int i3) {
        this.chS = str;
        this.mVideoUrl = str2;
        this.cib = str3;
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
        this.chT = i3;
    }

    public com.baidu.swan.apps.media.b.c aeL() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("showMuteBtn", true);
            jSONObject.put("showCenterPlayBtn", true);
            com.baidu.swan.apps.media.b.c cVar = new com.baidu.swan.apps.media.b.c();
            cVar.cMu = "SwanAdPlayer";
            cVar.cpp = "SwanAdPlayer";
            cVar.cMD = true;
            cVar.cQt = false;
            cVar.cQB = true;
            cVar.cQK = false;
            cVar.cQu = this.chS;
            cVar.mSrc = this.mVideoUrl;
            cVar.cpq = this.cib;
            cVar.cpt = new com.baidu.swan.apps.model.a.a.a(0, 0, this.mVideoWidth, this.mVideoHeight);
            cVar.cpt.fq(true);
            cVar.cQv = this.chT;
            return com.baidu.swan.apps.media.b.c.a(jSONObject, cVar);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
