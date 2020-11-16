package com.baidu.swan.apps.adlanding;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String cuH;
    private int cuI;
    private String cuQ;
    private int mVideoHeight;
    private String mVideoUrl;
    private int mVideoWidth;

    public d(String str, String str2, String str3, int i, int i2, int i3) {
        this.cuH = str;
        this.mVideoUrl = str2;
        this.cuQ = str3;
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
        this.cuI = i3;
    }

    public com.baidu.swan.apps.media.b.c aix() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("showMuteBtn", true);
            jSONObject.put("showCenterPlayBtn", true);
            com.baidu.swan.apps.media.b.c cVar = new com.baidu.swan.apps.media.b.c();
            cVar.cZa = "SwanAdPlayer";
            cVar.cCa = "SwanAdPlayer";
            cVar.cZj = true;
            cVar.ddd = false;
            cVar.ddl = true;
            cVar.ddv = false;
            cVar.dde = this.cuH;
            cVar.mSrc = this.mVideoUrl;
            cVar.cCb = this.cuQ;
            cVar.cCe = new com.baidu.swan.apps.model.a.a.a(0, 0, this.mVideoWidth, this.mVideoHeight);
            cVar.cCe.fP(true);
            cVar.ddf = this.cuI;
            return com.baidu.swan.apps.media.b.c.a(jSONObject, cVar);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
