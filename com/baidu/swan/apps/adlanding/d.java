package com.baidu.swan.apps.adlanding;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bcr;
    private int bcs;
    private String bcw;
    private int mVideoHeight;
    private String mVideoUrl;
    private int mVideoWidth;

    public d(String str, String str2, String str3, int i, int i2, int i3) {
        this.bcr = str;
        this.mVideoUrl = str2;
        this.bcw = str3;
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
        this.bcs = i3;
    }

    public com.baidu.swan.apps.media.c.c Jj() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("showMuteBtn", true);
            jSONObject.put("showCenterPlayBtn", true);
            com.baidu.swan.apps.media.c.c cVar = new com.baidu.swan.apps.media.c.c();
            cVar.bAL = "SwanAdPlayer";
            cVar.biA = "SwanAdPlayer";
            cVar.bAT = true;
            cVar.bEt = false;
            cVar.bEC = true;
            cVar.bEL = false;
            cVar.bEu = this.bcr;
            cVar.mSrc = this.mVideoUrl;
            cVar.biB = this.bcw;
            cVar.biE = new com.baidu.swan.apps.model.a.a.a(0, 0, this.mVideoWidth, this.mVideoHeight);
            cVar.biE.de(true);
            cVar.bEv = this.bcs;
            return com.baidu.swan.apps.media.c.c.a(jSONObject, cVar);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
