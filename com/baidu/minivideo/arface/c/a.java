package com.baidu.minivideo.arface.c;

import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.minivideo.arface.e;
import com.baidu.sapi2.SapiContext;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a {
    private static e cld;

    /* renamed from: com.baidu.minivideo.arface.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0260a {
        public int cle;
        public long clf;
        public String clg;
        public String clh;
        public String cli;
        public String clj;
        public int fps;
    }

    public static void b(e eVar) {
        cld = eVar;
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
        if (cld != null) {
            cld.report(str, jSONObject2);
        }
    }
}
