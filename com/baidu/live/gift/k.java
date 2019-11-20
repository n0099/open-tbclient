package com.baidu.live.gift;

import android.graphics.PointF;
import android.graphics.Rect;
import android.text.TextUtils;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.mobstat.Config;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class k implements Cloneable {
    public int WP;
    public int WQ;
    public int WR;
    public int WS;
    public int WT;
    public int WU;
    public int WV;
    public int WW;
    public int WY;
    public List<PointF> WX = new ArrayList();
    public Rect WZ = new Rect();

    public String pD() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", String.valueOf(this.WP));
            jSONObject2.put("height", String.valueOf(this.WQ));
            jSONObject.put("screen_size", jSONObject2);
            jSONObject.put("ani_type", String.valueOf(this.WV));
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(Config.EVENT_HEAT_X, String.valueOf(this.WR));
            jSONObject3.put("y", String.valueOf(this.WS));
            jSONObject3.put("width", String.valueOf(this.WT));
            jSONObject3.put("height", String.valueOf(this.WU));
            jSONObject.put("draw_rect", jSONObject3);
            jSONObject.put("point_count", this.WY);
            JSONArray jSONArray = new JSONArray();
            DecimalFormat decimalFormat = new DecimalFormat(".0");
            for (int i = 0; i < this.WX.size(); i++) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(Config.EVENT_HEAT_X, decimalFormat.format(this.WX.get(i).x));
                jSONObject4.put("y", decimalFormat.format(this.WX.get(i).y));
                jSONArray.put(jSONObject4);
            }
            jSONObject.put("point_data", jSONArray);
            jSONObject.put("point_size", this.WW);
            return jSONObject.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean cg(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.WV = JavaTypesHelper.toInt(jSONObject.optString("ani_type"), 0);
            this.WW = jSONObject.optInt("point_size");
            JSONObject optJSONObject = jSONObject.optJSONObject("screen_size");
            this.WP = JavaTypesHelper.toInt(optJSONObject.optString("width"), 0);
            this.WQ = JavaTypesHelper.toInt(optJSONObject.optString("height"), 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("draw_rect");
            this.WR = JavaTypesHelper.toInt(optJSONObject2.optString(Config.EVENT_HEAT_X), 0);
            this.WS = JavaTypesHelper.toInt(optJSONObject2.optString("y"), 0);
            this.WT = JavaTypesHelper.toInt(optJSONObject2.optString("width"), 0);
            this.WU = JavaTypesHelper.toInt(optJSONObject2.optString("height"), 0);
            this.WZ.left = this.WR;
            this.WZ.top = this.WS;
            this.WZ.right = this.WT;
            this.WZ.bottom = this.WU + this.WS;
            this.WY = JavaTypesHelper.toInt("point_count", 0);
            JSONArray optJSONArray = jSONObject.optJSONArray("point_data");
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                this.WX.add(new PointF(JavaTypesHelper.toFloat(jSONObject2.optString(Config.EVENT_HEAT_X), 0.0f), JavaTypesHelper.toFloat(jSONObject2.optString("y"), 0.0f)));
            }
            if (this.WX.size() > 0) {
                return isValid();
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: pE */
    public k clone() {
        try {
            return (k) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean isValid() {
        return !ListUtils.isEmpty(this.WX) && this.WP > 0 && this.WQ > 0 && this.WW > 0;
    }
}
