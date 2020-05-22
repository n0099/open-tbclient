package com.baidu.swan.apps.adlanding;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private int bIA;
    private String bIH;
    private String bIz;
    private int mVideoHeight;
    private String mVideoUrl;
    private int mVideoWidth;

    public d(String str, String str2, String str3, int i, int i2, int i3) {
        this.bIz = str;
        this.mVideoUrl = str2;
        this.bIH = str3;
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
        this.bIA = i3;
    }

    public com.baidu.swan.apps.media.b.c Tz() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("showMuteBtn", true);
            jSONObject.put("showCenterPlayBtn", true);
            com.baidu.swan.apps.media.b.c cVar = new com.baidu.swan.apps.media.b.c();
            cVar.cjA = "SwanAdPlayer";
            cVar.bPF = "SwanAdPlayer";
            cVar.cjJ = true;
            cVar.cnK = false;
            cVar.cnS = true;
            cVar.cob = false;
            cVar.cnL = this.bIz;
            cVar.mSrc = this.mVideoUrl;
            cVar.bPG = this.bIH;
            cVar.bPJ = new com.baidu.swan.apps.model.a.a.a(0, 0, this.mVideoWidth, this.mVideoHeight);
            cVar.bPJ.er(true);
            cVar.cnM = this.bIA;
            return com.baidu.swan.apps.media.b.c.a(jSONObject, cVar);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
