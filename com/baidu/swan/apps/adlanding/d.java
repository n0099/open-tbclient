package com.baidu.swan.apps.adlanding;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bTE;
    private int bTF;
    private String bTN;
    private int mVideoHeight;
    private String mVideoUrl;
    private int mVideoWidth;

    public d(String str, String str2, String str3, int i, int i2, int i3) {
        this.bTE = str;
        this.mVideoUrl = str2;
        this.bTN = str3;
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
        this.bTF = i3;
    }

    public com.baidu.swan.apps.media.b.c abq() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("showMuteBtn", true);
            jSONObject.put("showCenterPlayBtn", true);
            com.baidu.swan.apps.media.b.c cVar = new com.baidu.swan.apps.media.b.c();
            cVar.cyo = "SwanAdPlayer";
            cVar.caX = "SwanAdPlayer";
            cVar.cyx = true;
            cVar.cCp = false;
            cVar.cCx = true;
            cVar.cCG = false;
            cVar.cCq = this.bTE;
            cVar.mSrc = this.mVideoUrl;
            cVar.caY = this.bTN;
            cVar.cbb = new com.baidu.swan.apps.model.a.a.a(0, 0, this.mVideoWidth, this.mVideoHeight);
            cVar.cbb.eW(true);
            cVar.cCr = this.bTF;
            return com.baidu.swan.apps.media.b.c.a(jSONObject, cVar);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
