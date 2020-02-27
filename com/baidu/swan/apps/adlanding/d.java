package com.baidu.swan.apps.adlanding;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bcc;
    private int bcd;
    private String bch;
    private int mVideoHeight;
    private String mVideoUrl;
    private int mVideoWidth;

    public d(String str, String str2, String str3, int i, int i2, int i3) {
        this.bcc = str;
        this.mVideoUrl = str2;
        this.bch = str3;
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
        this.bcd = i3;
    }

    public com.baidu.swan.apps.media.c.c Je() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("showMuteBtn", true);
            jSONObject.put("showCenterPlayBtn", true);
            com.baidu.swan.apps.media.c.c cVar = new com.baidu.swan.apps.media.c.c();
            cVar.bAy = "SwanAdPlayer";
            cVar.bik = "SwanAdPlayer";
            cVar.bAG = true;
            cVar.bEg = false;
            cVar.bEp = true;
            cVar.bEy = false;
            cVar.bEh = this.bcc;
            cVar.mSrc = this.mVideoUrl;
            cVar.bil = this.bch;
            cVar.bip = new com.baidu.swan.apps.model.a.a.a(0, 0, this.mVideoWidth, this.mVideoHeight);
            cVar.bip.dd(true);
            cVar.bEi = this.bcd;
            return com.baidu.swan.apps.media.c.c.a(jSONObject, cVar);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
