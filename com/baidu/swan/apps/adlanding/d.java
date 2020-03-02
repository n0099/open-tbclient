package com.baidu.swan.apps.adlanding;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bcd;
    private int bce;
    private String bci;
    private int mVideoHeight;
    private String mVideoUrl;
    private int mVideoWidth;

    public d(String str, String str2, String str3, int i, int i2, int i3) {
        this.bcd = str;
        this.mVideoUrl = str2;
        this.bci = str3;
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
        this.bce = i3;
    }

    public com.baidu.swan.apps.media.c.c Jg() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("showMuteBtn", true);
            jSONObject.put("showCenterPlayBtn", true);
            com.baidu.swan.apps.media.c.c cVar = new com.baidu.swan.apps.media.c.c();
            cVar.bAz = "SwanAdPlayer";
            cVar.bil = "SwanAdPlayer";
            cVar.bAH = true;
            cVar.bEh = false;
            cVar.bEq = true;
            cVar.bEz = false;
            cVar.bEi = this.bcd;
            cVar.mSrc = this.mVideoUrl;
            cVar.bim = this.bci;
            cVar.biq = new com.baidu.swan.apps.model.a.a.a(0, 0, this.mVideoWidth, this.mVideoHeight);
            cVar.biq.dd(true);
            cVar.bEj = this.bce;
            return com.baidu.swan.apps.media.c.c.a(jSONObject, cVar);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
