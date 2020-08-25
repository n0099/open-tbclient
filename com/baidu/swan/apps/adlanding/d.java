package com.baidu.swan.apps.adlanding;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bTA;
    private int bTB;
    private String bTJ;
    private int mVideoHeight;
    private String mVideoUrl;
    private int mVideoWidth;

    public d(String str, String str2, String str3, int i, int i2, int i3) {
        this.bTA = str;
        this.mVideoUrl = str2;
        this.bTJ = str3;
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
        this.bTB = i3;
    }

    public com.baidu.swan.apps.media.b.c abq() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("showMuteBtn", true);
            jSONObject.put("showCenterPlayBtn", true);
            com.baidu.swan.apps.media.b.c cVar = new com.baidu.swan.apps.media.b.c();
            cVar.cyk = "SwanAdPlayer";
            cVar.caT = "SwanAdPlayer";
            cVar.cyt = true;
            cVar.cCl = false;
            cVar.cCt = true;
            cVar.cCC = false;
            cVar.cCm = this.bTA;
            cVar.mSrc = this.mVideoUrl;
            cVar.caU = this.bTJ;
            cVar.caX = new com.baidu.swan.apps.model.a.a.a(0, 0, this.mVideoWidth, this.mVideoHeight);
            cVar.caX.eV(true);
            cVar.cCn = this.bTB;
            return com.baidu.swan.apps.media.b.c.a(jSONObject, cVar);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
