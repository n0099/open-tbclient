package com.baidu.swan.apps.adlanding;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String cGp;
    private int cGq;
    private String cGy;
    private int mVideoHeight;
    private String mVideoUrl;
    private int mVideoWidth;

    public d(String str, String str2, String str3, int i, int i2, int i3) {
        this.cGp = str;
        this.mVideoUrl = str2;
        this.cGy = str3;
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
        this.cGq = i3;
    }

    public com.baidu.swan.apps.media.b.c amQ() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("showMuteBtn", true);
            jSONObject.put("showCenterPlayBtn", true);
            com.baidu.swan.apps.media.b.c cVar = new com.baidu.swan.apps.media.b.c();
            cVar.dkT = "SwanAdPlayer";
            cVar.cNO = "SwanAdPlayer";
            cVar.dlc = true;
            cVar.mMute = false;
            cVar.dpk = true;
            cVar.dpu = false;
            cVar.dpd = this.cGp;
            cVar.mSrc = this.mVideoUrl;
            cVar.cNP = this.cGy;
            cVar.cNS = new com.baidu.swan.apps.model.a.a.a(0, 0, this.mVideoWidth, this.mVideoHeight);
            cVar.cNS.gn(true);
            cVar.dpe = this.cGq;
            return com.baidu.swan.apps.media.b.c.a(jSONObject, cVar);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
