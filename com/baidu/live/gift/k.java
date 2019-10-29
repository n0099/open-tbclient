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
    public int Xh;
    public int Xi;
    public int Xj;
    public int Xk;
    public int Xl;
    public int Xm;
    public int Xn;
    public int Xo;
    public int Xq;
    public List<PointF> Xp = new ArrayList();
    public Rect Xr = new Rect();

    public String pD() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", String.valueOf(this.Xh));
            jSONObject2.put("height", String.valueOf(this.Xi));
            jSONObject.put("screen_size", jSONObject2);
            jSONObject.put("ani_type", String.valueOf(this.Xn));
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(Config.EVENT_HEAT_X, String.valueOf(this.Xj));
            jSONObject3.put("y", String.valueOf(this.Xk));
            jSONObject3.put("width", String.valueOf(this.Xl));
            jSONObject3.put("height", String.valueOf(this.Xm));
            jSONObject.put("draw_rect", jSONObject3);
            jSONObject.put("point_count", this.Xq);
            JSONArray jSONArray = new JSONArray();
            DecimalFormat decimalFormat = new DecimalFormat(".0");
            for (int i = 0; i < this.Xp.size(); i++) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(Config.EVENT_HEAT_X, decimalFormat.format(this.Xp.get(i).x));
                jSONObject4.put("y", decimalFormat.format(this.Xp.get(i).y));
                jSONArray.put(jSONObject4);
            }
            jSONObject.put("point_data", jSONArray);
            jSONObject.put("point_size", this.Xo);
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
            this.Xn = JavaTypesHelper.toInt(jSONObject.optString("ani_type"), 0);
            this.Xo = jSONObject.optInt("point_size");
            JSONObject optJSONObject = jSONObject.optJSONObject("screen_size");
            this.Xh = JavaTypesHelper.toInt(optJSONObject.optString("width"), 0);
            this.Xi = JavaTypesHelper.toInt(optJSONObject.optString("height"), 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("draw_rect");
            this.Xj = JavaTypesHelper.toInt(optJSONObject2.optString(Config.EVENT_HEAT_X), 0);
            this.Xk = JavaTypesHelper.toInt(optJSONObject2.optString("y"), 0);
            this.Xl = JavaTypesHelper.toInt(optJSONObject2.optString("width"), 0);
            this.Xm = JavaTypesHelper.toInt(optJSONObject2.optString("height"), 0);
            this.Xr.left = this.Xj;
            this.Xr.top = this.Xk;
            this.Xr.right = this.Xl;
            this.Xr.bottom = this.Xm + this.Xk;
            this.Xq = JavaTypesHelper.toInt("point_count", 0);
            JSONArray optJSONArray = jSONObject.optJSONArray("point_data");
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                this.Xp.add(new PointF(JavaTypesHelper.toFloat(jSONObject2.optString(Config.EVENT_HEAT_X), 0.0f), JavaTypesHelper.toFloat(jSONObject2.optString("y"), 0.0f)));
            }
            if (this.Xp.size() > 0) {
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
        return !ListUtils.isEmpty(this.Xp) && this.Xh > 0 && this.Xi > 0 && this.Xo > 0;
    }
}
