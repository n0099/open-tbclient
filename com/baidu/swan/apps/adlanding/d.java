package com.baidu.swan.apps.adlanding;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String cDZ;
    private int cEa;
    private String cEi;
    private int mVideoHeight;
    private String mVideoUrl;
    private int mVideoWidth;

    public d(String str, String str2, String str3, int i, int i2, int i3) {
        this.cDZ = str;
        this.mVideoUrl = str2;
        this.cEi = str3;
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
        this.cEa = i3;
    }

    public com.baidu.swan.apps.media.b.c aju() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("showMuteBtn", true);
            jSONObject.put("showCenterPlayBtn", true);
            com.baidu.swan.apps.media.b.c cVar = new com.baidu.swan.apps.media.b.c();
            cVar.diq = "SwanAdPlayer";
            cVar.cLq = "SwanAdPlayer";
            cVar.diB = true;
            cVar.mMute = false;
            cVar.dmF = true;
            cVar.dmO = false;
            cVar.dmx = this.cDZ;
            cVar.mSrc = this.mVideoUrl;
            cVar.cLr = this.cEi;
            cVar.cLu = new com.baidu.swan.apps.model.a.a.a(0, 0, this.mVideoWidth, this.mVideoHeight);
            cVar.cLu.gl(true);
            cVar.dmy = this.cEa;
            return com.baidu.swan.apps.media.b.c.a(jSONObject, cVar);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
