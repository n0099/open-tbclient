package com.baidu.live.data;

import com.baidu.ar.auth.FeatureCodes;
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class cm {
    public static cm aSk = new cm();
    public int aSg;
    public int aSh;
    public int aSi;
    public int aSj;
    public List<a> dataList;
    public int fps;

    static {
        aSk.fps = 15;
        aSk.aSg = 720;
        aSk.aSh = PlatformPlugin.DEFAULT_SYSTEM_UI;
        aSk.aSi = FeatureCodes.ADVANCE_BEAUTY;
        aSk.aSj = 1100;
        aSk.dataList = a.aSl;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fps = jSONObject.optInt("fps");
            this.aSg = jSONObject.optInt("video_w");
            this.aSh = jSONObject.optInt("video_h");
            this.aSi = jSONObject.optInt("max_bitrate");
            this.aSj = jSONObject.optInt("min_bitrate");
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
            this.dataList = a.aSl;
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        public static List<a> aSl = new ArrayList();
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
            aSl.add(aVar);
            aVar.x = 10;
            aVar.y = 152;
            aVar.width = 110;
            aVar.height = 196;
            aSl.add(aVar);
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
