package com.baidu.swan.apps.adlanding;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bNn;
    private int bNo;
    private String bNv;
    private int mVideoHeight;
    private String mVideoUrl;
    private int mVideoWidth;

    public d(String str, String str2, String str3, int i, int i2, int i3) {
        this.bNn = str;
        this.mVideoUrl = str2;
        this.bNv = str3;
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
        this.bNo = i3;
    }

    public com.baidu.swan.apps.media.b.c UF() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("showMuteBtn", true);
            jSONObject.put("showCenterPlayBtn", true);
            com.baidu.swan.apps.media.b.c cVar = new com.baidu.swan.apps.media.b.c();
            cVar.cop = "SwanAdPlayer";
            cVar.bUt = "SwanAdPlayer";
            cVar.coy = true;
            cVar.csx = false;
            cVar.csF = true;
            cVar.csO = false;
            cVar.csy = this.bNn;
            cVar.mSrc = this.mVideoUrl;
            cVar.bUu = this.bNv;
            cVar.bUx = new com.baidu.swan.apps.model.a.a.a(0, 0, this.mVideoWidth, this.mVideoHeight);
            cVar.bUx.ew(true);
            cVar.csz = this.bNo;
            return com.baidu.swan.apps.media.b.c.a(jSONObject, cVar);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
