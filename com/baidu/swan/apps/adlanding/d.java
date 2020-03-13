package com.baidu.swan.apps.adlanding;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bce;
    private int bcf;
    private String bcj;
    private int mVideoHeight;
    private String mVideoUrl;
    private int mVideoWidth;

    public d(String str, String str2, String str3, int i, int i2, int i3) {
        this.bce = str;
        this.mVideoUrl = str2;
        this.bcj = str3;
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
        this.bcf = i3;
    }

    public com.baidu.swan.apps.media.c.c Jg() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("showMuteBtn", true);
            jSONObject.put("showCenterPlayBtn", true);
            com.baidu.swan.apps.media.c.c cVar = new com.baidu.swan.apps.media.c.c();
            cVar.bAA = "SwanAdPlayer";
            cVar.bim = "SwanAdPlayer";
            cVar.bAI = true;
            cVar.bEi = false;
            cVar.bEr = true;
            cVar.bEA = false;
            cVar.bEj = this.bce;
            cVar.mSrc = this.mVideoUrl;
            cVar.bin = this.bcj;
            cVar.bir = new com.baidu.swan.apps.model.a.a.a(0, 0, this.mVideoWidth, this.mVideoHeight);
            cVar.bir.dd(true);
            cVar.bEk = this.bcf;
            return com.baidu.swan.apps.media.c.c.a(jSONObject, cVar);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
