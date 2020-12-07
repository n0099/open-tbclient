package com.baidu.swan.apps.adlanding;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private int cBA;
    private String cBI;
    private String cBz;
    private int mVideoHeight;
    private String mVideoUrl;
    private int mVideoWidth;

    public d(String str, String str2, String str3, int i, int i2, int i3) {
        this.cBz = str;
        this.mVideoUrl = str2;
        this.cBI = str3;
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
        this.cBA = i3;
    }

    public com.baidu.swan.apps.media.b.c alF() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("showMuteBtn", true);
            jSONObject.put("showCenterPlayBtn", true);
            com.baidu.swan.apps.media.b.c cVar = new com.baidu.swan.apps.media.b.c();
            cVar.dga = "SwanAdPlayer";
            cVar.cIV = "SwanAdPlayer";
            cVar.dgj = true;
            cVar.dkd = false;
            cVar.dkl = true;
            cVar.dku = false;
            cVar.dke = this.cBz;
            cVar.mSrc = this.mVideoUrl;
            cVar.cIW = this.cBI;
            cVar.cIZ = new com.baidu.swan.apps.model.a.a.a(0, 0, this.mVideoWidth, this.mVideoHeight);
            cVar.cIZ.ge(true);
            cVar.dkf = this.cBA;
            return com.baidu.swan.apps.media.b.c.a(jSONObject, cVar);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
