package com.baidu.swan.apps.adlanding;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bAF;
    private int bAG;
    private String bAK;
    private int mVideoHeight;
    private String mVideoUrl;
    private int mVideoWidth;

    public d(String str, String str2, String str3, int i, int i2, int i3) {
        this.bAF = str;
        this.mVideoUrl = str2;
        this.bAK = str3;
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
        this.bAG = i3;
    }

    public com.baidu.swan.apps.media.c.c QV() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("showMuteBtn", true);
            jSONObject.put("showCenterPlayBtn", true);
            com.baidu.swan.apps.media.c.c cVar = new com.baidu.swan.apps.media.c.c();
            cVar.bYS = "SwanAdPlayer";
            cVar.bGI = "SwanAdPlayer";
            cVar.bZa = true;
            cVar.cdc = false;
            cVar.cdk = true;
            cVar.cdu = false;
            cVar.cdd = this.bAF;
            cVar.mSrc = this.mVideoUrl;
            cVar.bGJ = this.bAK;
            cVar.bGM = new com.baidu.swan.apps.model.a.a.a(0, 0, this.mVideoWidth, this.mVideoHeight);
            cVar.bGM.ea(true);
            cVar.cde = this.bAG;
            return com.baidu.swan.apps.media.c.c.a(jSONObject, cVar);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
