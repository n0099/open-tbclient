package com.baidu.live.data;

import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.mobstat.Config;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class cw {
    public static cw aSO = new cw();
    public int aSK;
    public int aSL;
    public int aSM;
    public int aSN;
    public List<a> dataList;
    public int fps;
    public int maxBitrate;

    static {
        aSO.fps = 15;
        aSO.aSK = 720;
        aSO.aSL = 1280;
        aSO.maxBitrate = FeatureCodes.ADVANCE_BEAUTY;
        aSO.aSM = 1100;
        aSO.aSN = 3;
        aSO.dataList = a.aSP;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fps = jSONObject.optInt(AlaRecorderLog.KEY_CANERA_START_FPS);
            this.aSK = jSONObject.optInt("video_w");
            this.aSL = jSONObject.optInt("video_h");
            this.maxBitrate = jSONObject.optInt("max_bitrate");
            this.aSM = jSONObject.optInt("min_bitrate");
            this.aSN = jSONObject.optInt("yy_publish_codec_mode_android", aSO.aSN);
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
            this.dataList = a.aSP;
        }
    }

    /* loaded from: classes11.dex */
    public static class a {
        public static List<a> aSP = new ArrayList();
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
            aSP.add(aVar);
            aVar.x = 10;
            aVar.y = 152;
            aVar.width = 110;
            aVar.height = 196;
            aSP.add(aVar);
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
