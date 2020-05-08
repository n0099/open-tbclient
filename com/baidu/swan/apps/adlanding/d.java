package com.baidu.swan.apps.adlanding;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bAK;
    private int bAL;
    private String bAP;
    private int mVideoHeight;
    private String mVideoUrl;
    private int mVideoWidth;

    public d(String str, String str2, String str3, int i, int i2, int i3) {
        this.bAK = str;
        this.mVideoUrl = str2;
        this.bAP = str3;
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
        this.bAL = i3;
    }

    public com.baidu.swan.apps.media.c.c QU() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("showMuteBtn", true);
            jSONObject.put("showCenterPlayBtn", true);
            com.baidu.swan.apps.media.c.c cVar = new com.baidu.swan.apps.media.c.c();
            cVar.bYY = "SwanAdPlayer";
            cVar.bGN = "SwanAdPlayer";
            cVar.bZg = true;
            cVar.cdi = false;
            cVar.cdr = true;
            cVar.cdA = false;
            cVar.cdj = this.bAK;
            cVar.mSrc = this.mVideoUrl;
            cVar.bGO = this.bAP;
            cVar.bGR = new com.baidu.swan.apps.model.a.a.a(0, 0, this.mVideoWidth, this.mVideoHeight);
            cVar.bGR.ea(true);
            cVar.cdk = this.bAL;
            return com.baidu.swan.apps.media.c.c.a(jSONObject, cVar);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
