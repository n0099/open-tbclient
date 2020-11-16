package com.baidu.live.data;

import com.baidu.ar.auth.FeatureCodes;
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class cm {
    public static cm aQz = new cm();
    public int aQv;
    public int aQw;
    public int aQx;
    public int aQy;
    public List<a> dataList;
    public int fps;

    static {
        aQz.fps = 15;
        aQz.aQv = 720;
        aQz.aQw = PlatformPlugin.DEFAULT_SYSTEM_UI;
        aQz.aQx = FeatureCodes.ADVANCE_BEAUTY;
        aQz.aQy = 1100;
        aQz.dataList = a.aQA;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fps = jSONObject.optInt("fps");
            this.aQv = jSONObject.optInt("video_w");
            this.aQw = jSONObject.optInt("video_h");
            this.aQx = jSONObject.optInt("max_bitrate");
            this.aQy = jSONObject.optInt("min_bitrate");
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
            this.dataList = a.aQA;
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        public static List<a> aQA = new ArrayList();
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
            aQA.add(aVar);
            aVar.x = 10;
            aVar.y = 152;
            aVar.width = 110;
            aVar.height = 196;
            aQA.add(aVar);
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
