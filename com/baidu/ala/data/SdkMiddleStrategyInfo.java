package com.baidu.ala.data;

import com.baidu.ar.gesture.GestureAR;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class SdkMiddleStrategyInfo {
    public DisplayStrategy displayStrategy;
    public int score;
    public StrategyExtra strategyExtra;
    public long ts;

    public void fromJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ts = jSONObject.optLong("ts");
            this.score = jSONObject.optInt(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE);
            this.displayStrategy = new DisplayStrategy();
            JSONObject optJSONObject = jSONObject.optJSONObject("display_strategy");
            if (optJSONObject != null) {
                this.displayStrategy.fromJson(optJSONObject);
            }
            this.strategyExtra = new StrategyExtra();
            JSONObject optJSONObject2 = jSONObject.optJSONObject("ext");
            if (optJSONObject2 != null) {
                this.strategyExtra.fromJson(optJSONObject2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class DisplayStrategy {
        public String attention;
        public int imageNum;
        public int mark;
        public String title;
        public int type;

        public void fromJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.mark = jSONObject.optInt("mark");
                this.type = jSONObject.optInt("type");
                this.imageNum = jSONObject.optInt("image_num");
                this.title = jSONObject.optString("title");
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class StrategyExtra {
        public int click;
        public String ctr_fea;
        public String fe;
        public double gbdt_score;
        public int mark;
        public String mthid;
        public long public_time;
        public int q_ratio;
        public String rec_src;
        public int show;
        public int source;
        public String source_from;
        public int vertical_type;

        public void fromJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.mthid = jSONObject.optString("mthid");
                this.q_ratio = jSONObject.optInt("q_ratio");
                this.click = jSONObject.optInt("click");
                this.show = jSONObject.optInt("show");
                this.source = jSONObject.optInt("source");
                this.vertical_type = jSONObject.optInt("vertical_type");
                this.ctr_fea = jSONObject.optString("ctr_fea");
                this.source_from = jSONObject.optString("source_from");
                this.gbdt_score = jSONObject.optDouble("gbdt_score");
                this.mark = jSONObject.optInt("mark");
                this.public_time = jSONObject.optInt("public_time");
                this.rec_src = jSONObject.optString("rec_src");
                this.fe = jSONObject.optString("fe");
            }
        }
    }
}
