package com.baidu.swan.apps.adlanding;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String aXR;
    private int aXS;
    private String aXX;
    private int mVideoHeight;
    private String mVideoUrl;
    private int mVideoWidth;

    public d(String str, String str2, String str3, int i, int i2, int i3) {
        this.aXR = str;
        this.mVideoUrl = str2;
        this.aXX = str3;
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
        this.aXS = i3;
    }

    public com.baidu.swan.apps.media.c.c GP() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("showMuteBtn", true);
            jSONObject.put("showCenterPlayBtn", true);
            com.baidu.swan.apps.media.c.c cVar = new com.baidu.swan.apps.media.c.c();
            cVar.bwp = "SwanAdPlayer";
            cVar.bdV = "SwanAdPlayer";
            cVar.bwx = true;
            cVar.bAa = false;
            cVar.bAj = true;
            cVar.bAs = false;
            cVar.bAb = this.aXR;
            cVar.mSrc = this.mVideoUrl;
            cVar.bdW = this.aXX;
            cVar.bdZ = new com.baidu.swan.apps.model.a.a.a(0, 0, this.mVideoWidth, this.mVideoHeight);
            cVar.bdZ.cW(true);
            cVar.bAc = this.aXS;
            return com.baidu.swan.apps.media.c.c.a(jSONObject, cVar);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
