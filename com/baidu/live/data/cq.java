package com.baidu.live.data;

import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.ar.auth.FeatureCodes;
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class cq {
    public static cq aUy = new cq();
    public int aUv;
    public int aUw;
    public int aUx;
    public List<a> dataList;
    public int fps;
    public int maxBitrate;

    static {
        aUy.fps = 15;
        aUy.aUv = 720;
        aUy.aUw = PlatformPlugin.DEFAULT_SYSTEM_UI;
        aUy.maxBitrate = FeatureCodes.ADVANCE_BEAUTY;
        aUy.aUx = 1100;
        aUy.dataList = a.aUz;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fps = jSONObject.optInt(AlaRecorderLog.KEY_CANERA_START_FPS);
            this.aUv = jSONObject.optInt("video_w");
            this.aUw = jSONObject.optInt("video_h");
            this.maxBitrate = jSONObject.optInt("max_bitrate");
            this.aUx = jSONObject.optInt("min_bitrate");
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
            this.dataList = a.aUz;
        }
    }

    /* loaded from: classes11.dex */
    public static class a {
        public static List<a> aUz = new ArrayList();
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
            aUz.add(aVar);
            aVar.x = 10;
            aVar.y = 152;
            aVar.width = 110;
            aVar.height = 196;
            aUz.add(aVar);
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
