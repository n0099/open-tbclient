package com.baidu.live.data;

import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.ar.auth.FeatureCodes;
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class co {
    public static co aTB = new co();
    public int aTA;
    public int aTx;
    public int aTy;
    public int aTz;
    public List<a> dataList;
    public int fps;

    static {
        aTB.fps = 15;
        aTB.aTx = 720;
        aTB.aTy = PlatformPlugin.DEFAULT_SYSTEM_UI;
        aTB.aTz = FeatureCodes.ADVANCE_BEAUTY;
        aTB.aTA = 1100;
        aTB.dataList = a.aTC;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fps = jSONObject.optInt(AlaRecorderLog.KEY_CANERA_START_FPS);
            this.aTx = jSONObject.optInt("video_w");
            this.aTy = jSONObject.optInt("video_h");
            this.aTz = jSONObject.optInt("max_bitrate");
            this.aTA = jSONObject.optInt("min_bitrate");
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
            this.dataList = a.aTC;
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        public static List<a> aTC = new ArrayList();
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
            aTC.add(aVar);
            aVar.x = 10;
            aVar.y = 152;
            aVar.width = 110;
            aVar.height = 196;
            aTC.add(aVar);
        }

        public void parserJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.x = jSONObject.optInt("x");
                this.y = jSONObject.optInt("y");
                this.width = jSONObject.optInt("width");
                this.height = jSONObject.optInt("height");
            }
        }
    }
}
