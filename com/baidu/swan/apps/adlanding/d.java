package com.baidu.swan.apps.adlanding;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String cwA;
    private String cwr;
    private int cws;
    private int mVideoHeight;
    private String mVideoUrl;
    private int mVideoWidth;

    public d(String str, String str2, String str3, int i, int i2, int i3) {
        this.cwr = str;
        this.mVideoUrl = str2;
        this.cwA = str3;
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
        this.cws = i3;
    }

    public com.baidu.swan.apps.media.b.c ajf() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("showMuteBtn", true);
            jSONObject.put("showCenterPlayBtn", true);
            com.baidu.swan.apps.media.b.c cVar = new com.baidu.swan.apps.media.b.c();
            cVar.daK = "SwanAdPlayer";
            cVar.cDK = "SwanAdPlayer";
            cVar.daT = true;
            cVar.deM = false;
            cVar.deU = true;
            cVar.dfd = false;
            cVar.deN = this.cwr;
            cVar.mSrc = this.mVideoUrl;
            cVar.cDL = this.cwA;
            cVar.cDO = new com.baidu.swan.apps.model.a.a.a(0, 0, this.mVideoWidth, this.mVideoHeight);
            cVar.cDO.fM(true);
            cVar.deO = this.cws;
            return com.baidu.swan.apps.media.b.c.a(jSONObject, cVar);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
