package com.baidu.swan.apps.adlanding;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String cqC;
    private String cqt;
    private int cqu;
    private int mVideoHeight;
    private String mVideoUrl;
    private int mVideoWidth;

    public d(String str, String str2, String str3, int i, int i2, int i3) {
        this.cqt = str;
        this.mVideoUrl = str2;
        this.cqC = str3;
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
        this.cqu = i3;
    }

    public com.baidu.swan.apps.media.b.c agF() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("showMuteBtn", true);
            jSONObject.put("showCenterPlayBtn", true);
            com.baidu.swan.apps.media.b.c cVar = new com.baidu.swan.apps.media.b.c();
            cVar.cUQ = "SwanAdPlayer";
            cVar.cxR = "SwanAdPlayer";
            cVar.cUZ = true;
            cVar.cYP = false;
            cVar.cYX = true;
            cVar.cZg = false;
            cVar.cYQ = this.cqt;
            cVar.mSrc = this.mVideoUrl;
            cVar.cxS = this.cqC;
            cVar.cxV = new com.baidu.swan.apps.model.a.a.a(0, 0, this.mVideoWidth, this.mVideoHeight);
            cVar.cxV.fD(true);
            cVar.cYR = this.cqu;
            return com.baidu.swan.apps.media.b.c.a(jSONObject, cVar);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
