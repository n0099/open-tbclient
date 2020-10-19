package com.baidu.live.data;

import com.baidu.ar.auth.FeatureCodes;
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class cf {
    public static cf aQx = new cf();
    public int aQt;
    public int aQu;
    public int aQv;
    public int aQw;
    public List<a> dataList;
    public int fps;

    static {
        aQx.fps = 15;
        aQx.aQt = 720;
        aQx.aQu = PlatformPlugin.DEFAULT_SYSTEM_UI;
        aQx.aQv = FeatureCodes.ADVANCE_BEAUTY;
        aQx.aQw = 1100;
        aQx.dataList = a.aQy;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fps = jSONObject.optInt("fps");
            this.aQt = jSONObject.optInt("video_w");
            this.aQu = jSONObject.optInt("video_h");
            this.aQv = jSONObject.optInt("max_bitrate");
            this.aQw = jSONObject.optInt("min_bitrate");
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
            this.dataList = a.aQy;
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        public static List<a> aQy = new ArrayList();
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
            aQy.add(aVar);
            aVar.x = 10;
            aVar.y = 152;
            aVar.width = 110;
            aVar.height = 196;
            aQy.add(aVar);
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
