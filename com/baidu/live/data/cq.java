package com.baidu.live.data;

import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.mobstat.Config;
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class cq {
    public static cq aPL = new cq();
    public int aPI;
    public int aPJ;
    public int aPK;
    public List<a> dataList;
    public int fps;
    public int maxBitrate;

    static {
        aPL.fps = 15;
        aPL.aPI = 720;
        aPL.aPJ = PlatformPlugin.DEFAULT_SYSTEM_UI;
        aPL.maxBitrate = FeatureCodes.ADVANCE_BEAUTY;
        aPL.aPK = 1100;
        aPL.dataList = a.aPM;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fps = jSONObject.optInt(AlaRecorderLog.KEY_CANERA_START_FPS);
            this.aPI = jSONObject.optInt("video_w");
            this.aPJ = jSONObject.optInt("video_h");
            this.maxBitrate = jSONObject.optInt("max_bitrate");
            this.aPK = jSONObject.optInt("min_bitrate");
            JSONArray optJSONArray = jSONObject.optJSONArray("list");
            if (optJSONArray != null && optJSONArray.length() == 2) {
                this.dataList = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        a aVar = new a();
                        aVar.parserJson(optJSONObject);
                        this.dataList.add(aVar);
                    }
                }
                return;
            }
            this.dataList = a.aPM;
        }
    }

    /* loaded from: classes10.dex */
    public static class a {
        public static List<a> aPM = new ArrayList();
        public int height;
        public int width;
        public int x;
        public int y;

        static {
            a aVar = new a();
            aVar.x = 0;
            aVar.y = 0;
            aVar.width = 720;
            aVar.height = PlatformPlugin.DEFAULT_SYSTEM_UI;
            aPM.add(aVar);
            aVar.x = 10;
            aVar.y = 152;
            aVar.width = 110;
            aVar.height = 196;
            aPM.add(aVar);
        }

        public void parserJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.x = jSONObject.optInt(Config.EVENT_HEAT_X);
                this.y = jSONObject.optInt("y");
                this.width = jSONObject.optInt("width");
                this.height = jSONObject.optInt("height");
            }
        }
    }
}
