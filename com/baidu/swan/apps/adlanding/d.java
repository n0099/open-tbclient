package com.baidu.swan.apps.adlanding;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private int cFA;
    private String cFI;
    private String cFz;
    private int mVideoHeight;
    private String mVideoUrl;
    private int mVideoWidth;

    public d(String str, String str2, String str3, int i, int i2, int i3) {
        this.cFz = str;
        this.mVideoUrl = str2;
        this.cFI = str3;
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
        this.cFA = i3;
    }

    public com.baidu.swan.apps.media.b.c ajx() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("showMuteBtn", true);
            jSONObject.put("showCenterPlayBtn", true);
            com.baidu.swan.apps.media.b.c cVar = new com.baidu.swan.apps.media.b.c();
            cVar.djT = "SwanAdPlayer";
            cVar.cMQ = "SwanAdPlayer";
            cVar.dkc = true;
            cVar.mMute = false;
            cVar.doi = true;
            cVar.dor = false;
            cVar.dnZ = this.cFz;
            cVar.mSrc = this.mVideoUrl;
            cVar.cMR = this.cFI;
            cVar.cMU = new com.baidu.swan.apps.model.a.a.a(0, 0, this.mVideoWidth, this.mVideoHeight);
            cVar.cMU.gl(true);
            cVar.doa = this.cFA;
            return com.baidu.swan.apps.media.b.c.a(jSONObject, cVar);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
