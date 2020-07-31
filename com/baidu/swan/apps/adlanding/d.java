package com.baidu.swan.apps.adlanding;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bOc;
    private int bOd;
    private String bOl;
    private int mVideoHeight;
    private String mVideoUrl;
    private int mVideoWidth;

    public d(String str, String str2, String str3, int i, int i2, int i3) {
        this.bOc = str;
        this.mVideoUrl = str2;
        this.bOl = str3;
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
        this.bOd = i3;
    }

    public com.baidu.swan.apps.media.b.c Vk() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("showMuteBtn", true);
            jSONObject.put("showCenterPlayBtn", true);
            com.baidu.swan.apps.media.b.c cVar = new com.baidu.swan.apps.media.b.c();
            cVar.cqu = "SwanAdPlayer";
            cVar.bVl = "SwanAdPlayer";
            cVar.cqD = true;
            cVar.cuB = false;
            cVar.cuJ = true;
            cVar.cuS = false;
            cVar.cuC = this.bOc;
            cVar.mSrc = this.mVideoUrl;
            cVar.bVm = this.bOl;
            cVar.bVp = new com.baidu.swan.apps.model.a.a.a(0, 0, this.mVideoWidth, this.mVideoHeight);
            cVar.bVp.eE(true);
            cVar.cuD = this.bOd;
            return com.baidu.swan.apps.media.b.c.a(jSONObject, cVar);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
