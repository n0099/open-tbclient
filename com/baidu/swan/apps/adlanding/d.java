package com.baidu.swan.apps.adlanding;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bVE;
    private int bVF;
    private String bVN;
    private int mVideoHeight;
    private String mVideoUrl;
    private int mVideoWidth;

    public d(String str, String str2, String str3, int i, int i2, int i3) {
        this.bVE = str;
        this.mVideoUrl = str2;
        this.bVN = str3;
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
        this.bVF = i3;
    }

    public com.baidu.swan.apps.media.b.c abZ() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("showMuteBtn", true);
            jSONObject.put("showCenterPlayBtn", true);
            com.baidu.swan.apps.media.b.c cVar = new com.baidu.swan.apps.media.b.c();
            cVar.cAp = "SwanAdPlayer";
            cVar.ccZ = "SwanAdPlayer";
            cVar.cAy = true;
            cVar.cEp = false;
            cVar.cEx = true;
            cVar.cEG = false;
            cVar.cEq = this.bVE;
            cVar.mSrc = this.mVideoUrl;
            cVar.cda = this.bVN;
            cVar.cdd = new com.baidu.swan.apps.model.a.a.a(0, 0, this.mVideoWidth, this.mVideoHeight);
            cVar.cdd.eU(true);
            cVar.cEr = this.bVF;
            return com.baidu.swan.apps.media.b.c.a(jSONObject, cVar);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
