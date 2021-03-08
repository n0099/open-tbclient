package com.baidu.live.data;

import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.mobstat.Config;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class cw {
    public static cw aUo = new cw();
    public int aUk;
    public int aUl;
    public int aUm;
    public int aUn;
    public List<a> dataList;
    public int fps;
    public int maxBitrate;

    static {
        aUo.fps = 15;
        aUo.aUk = 720;
        aUo.aUl = 1280;
        aUo.maxBitrate = FeatureCodes.ADVANCE_BEAUTY;
        aUo.aUm = 1100;
        aUo.aUn = 3;
        aUo.dataList = a.aUp;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fps = jSONObject.optInt(AlaRecorderLog.KEY_CANERA_START_FPS);
            this.aUk = jSONObject.optInt("video_w");
            this.aUl = jSONObject.optInt("video_h");
            this.maxBitrate = jSONObject.optInt("max_bitrate");
            this.aUm = jSONObject.optInt("min_bitrate");
            this.aUn = jSONObject.optInt("yy_publish_codec_mode_android", aUo.aUn);
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
            this.dataList = a.aUp;
        }
    }

    /* loaded from: classes10.dex */
    public static class a {
        public static List<a> aUp = new ArrayList();
        public int height;
        public int width;
        public int x;
        public int y;

        static {
            a aVar = new a();
            aVar.x = 0;
            aVar.y = 0;
            aVar.width = 720;
            aVar.height = 1280;
            aUp.add(aVar);
            aVar.x = 10;
            aVar.y = 152;
            aVar.width = 110;
            aVar.height = 196;
            aUp.add(aVar);
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
