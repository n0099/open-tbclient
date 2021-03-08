package com.baidu.minivideo.arface.c;

import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.minivideo.arface.e;
import com.baidu.sapi2.SapiContext;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class a {
    private static e cmE;

    /* renamed from: com.baidu.minivideo.arface.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0266a {
        public int cmF;
        public long cmG;
        public String cmH;
        public String cmI;
        public String cmJ;
        public String cmK;
        public int fps;
    }

    public static void b(e eVar) {
        cmE = eVar;
    }

    public static void report(String str, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt(SapiContext.KEY_SDK_VERSION, Integer.valueOf(com.baidu.minivideo.arface.b.getVersion()));
            if (jSONObject2 != null && jSONObject2.length() > 0) {
                jSONObject2.put(AlaRecorderLog.KEY_DEBUG_INFO, jSONObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (cmE != null) {
            cmE.report(str, jSONObject2);
        }
    }
}
