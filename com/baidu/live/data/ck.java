package com.baidu.live.data;

import com.baidu.ar.auth.FeatureCodes;
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ck {
    public static ck aRi = new ck();
    public int aRe;
    public int aRf;
    public int aRg;
    public int aRh;
    public List<a> dataList;
    public int fps;

    static {
        aRi.fps = 15;
        aRi.aRe = 720;
        aRi.aRf = PlatformPlugin.DEFAULT_SYSTEM_UI;
        aRi.aRg = FeatureCodes.ADVANCE_BEAUTY;
        aRi.aRh = 1100;
        aRi.dataList = a.aRj;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fps = jSONObject.optInt("fps");
            this.aRe = jSONObject.optInt("video_w");
            this.aRf = jSONObject.optInt("video_h");
            this.aRg = jSONObject.optInt("max_bitrate");
            this.aRh = jSONObject.optInt("min_bitrate");
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
            this.dataList = a.aRj;
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        public static List<a> aRj = new ArrayList();
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
            aRj.add(aVar);
            aVar.x = 10;
            aVar.y = 152;
            aVar.width = 110;
            aVar.height = 196;
            aRj.add(aVar);
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
