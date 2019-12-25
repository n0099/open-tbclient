package com.baidu.swan.apps.adlanding;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String aWZ;
    private int aXa;
    private String aXf;
    private int mVideoHeight;
    private String mVideoUrl;
    private int mVideoWidth;

    public d(String str, String str2, String str3, int i, int i2, int i3) {
        this.aWZ = str;
        this.mVideoUrl = str2;
        this.aXf = str3;
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
        this.aXa = i3;
    }

    public com.baidu.swan.apps.media.c.c Gt() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("showMuteBtn", true);
            jSONObject.put("showCenterPlayBtn", true);
            com.baidu.swan.apps.media.c.c cVar = new com.baidu.swan.apps.media.c.c();
            cVar.bvC = "SwanAdPlayer";
            cVar.bdh = "SwanAdPlayer";
            cVar.bvK = true;
            cVar.bzn = false;
            cVar.bzw = true;
            cVar.bzF = false;
            cVar.bzo = this.aWZ;
            cVar.mSrc = this.mVideoUrl;
            cVar.bdi = this.aXf;
            cVar.bdl = new com.baidu.swan.apps.model.a.a.a(0, 0, this.mVideoWidth, this.mVideoHeight);
            cVar.bdl.cR(true);
            cVar.bzp = this.aXa;
            return com.baidu.swan.apps.media.c.c.a(jSONObject, cVar);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
