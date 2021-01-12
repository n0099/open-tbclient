package com.baidu.swan.apps.adlanding;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String cBD;
    private int cBE;
    private String cBM;
    private int mVideoHeight;
    private String mVideoUrl;
    private int mVideoWidth;

    public d(String str, String str2, String str3, int i, int i2, int i3) {
        this.cBD = str;
        this.mVideoUrl = str2;
        this.cBM = str3;
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
        this.cBE = i3;
    }

    public com.baidu.swan.apps.media.b.c aiW() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("showMuteBtn", true);
            jSONObject.put("showCenterPlayBtn", true);
            com.baidu.swan.apps.media.b.c cVar = new com.baidu.swan.apps.media.b.c();
            cVar.dge = "SwanAdPlayer";
            cVar.cJc = "SwanAdPlayer";
            cVar.dgn = true;
            cVar.mMute = false;
            cVar.dkv = true;
            cVar.dkE = false;
            cVar.dko = this.cBD;
            cVar.mSrc = this.mVideoUrl;
            cVar.cJd = this.cBM;
            cVar.cJg = new com.baidu.swan.apps.model.a.a.a(0, 0, this.mVideoWidth, this.mVideoHeight);
            cVar.cJg.gj(true);
            cVar.dkp = this.cBE;
            return com.baidu.swan.apps.media.b.c.a(jSONObject, cVar);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
