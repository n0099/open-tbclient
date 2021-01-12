package com.baidu.live.gift;

import android.graphics.PointF;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.mobstat.Config;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class k implements Cloneable {
    public int aTZ;
    public int aUa;
    public int aUb;
    public int aUc;
    public int aUd;
    public int aUe;
    public int aUf;
    public int aUg;
    public int aUi;
    public List<PointF> aUh = new ArrayList();
    public Rect aUj = new Rect();
    public List<l> aUk = new ArrayList();

    public String Dw() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", String.valueOf(this.aTZ));
            jSONObject2.put("height", String.valueOf(this.aUa));
            jSONObject.put("screen_size", jSONObject2);
            jSONObject.put("ani_type", String.valueOf(this.aUf));
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(Config.EVENT_HEAT_X, String.valueOf(this.aUb));
            jSONObject3.put("y", String.valueOf(this.aUc));
            jSONObject3.put("width", String.valueOf(this.aUd));
            jSONObject3.put("height", String.valueOf(this.aUe));
            jSONObject.put("draw_rect", jSONObject3);
            jSONObject.put("point_count", this.aUi);
            JSONArray jSONArray = new JSONArray();
            DecimalFormat decimalFormat = new DecimalFormat(".0");
            for (int i = 0; i < this.aUh.size(); i++) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(Config.EVENT_HEAT_X, decimalFormat.format(this.aUh.get(i).x));
                jSONObject4.put("y", decimalFormat.format(this.aUh.get(i).y));
                jSONArray.put(jSONObject4);
            }
            jSONObject.put("point_data", jSONArray);
            jSONObject.put("point_size", this.aUg);
            if (!ListUtils.isEmpty(this.aUk)) {
                JSONArray jSONArray2 = new JSONArray();
                for (int i2 = 0; i2 < this.aUk.size(); i2++) {
                    jSONArray2.put(new JSONObject(this.aUk.get(i2).Dw()));
                }
                jSONObject.put("point_des", jSONArray2);
            }
            return jSONObject.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean fx(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.aUf = JavaTypesHelper.toInt(jSONObject.optString("ani_type"), 0);
            this.aUg = jSONObject.optInt("point_size");
            JSONObject optJSONObject = jSONObject.optJSONObject("screen_size");
            this.aTZ = JavaTypesHelper.toInt(optJSONObject.optString("width"), 0);
            this.aUa = JavaTypesHelper.toInt(optJSONObject.optString("height"), 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("draw_rect");
            this.aUb = JavaTypesHelper.toInt(optJSONObject2.optString(Config.EVENT_HEAT_X), 0);
            this.aUc = JavaTypesHelper.toInt(optJSONObject2.optString("y"), 0);
            this.aUd = JavaTypesHelper.toInt(optJSONObject2.optString("width"), 0);
            this.aUe = JavaTypesHelper.toInt(optJSONObject2.optString("height"), 0);
            this.aUj.left = this.aUb;
            this.aUj.top = this.aUc;
            this.aUj.right = this.aUd;
            this.aUj.bottom = this.aUe + this.aUc;
            this.aUi = JavaTypesHelper.toInt("point_count", 0);
            JSONArray optJSONArray = jSONObject.optJSONArray("point_data");
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                this.aUh.add(new PointF(JavaTypesHelper.toFloat(jSONObject2.optString(Config.EVENT_HEAT_X), 0.0f), JavaTypesHelper.toFloat(jSONObject2.optString("y"), 0.0f)));
            }
            if (this.aUh.size() > 0) {
                JSONArray optJSONArray2 = jSONObject.optJSONArray("point_des");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject jSONObject3 = optJSONArray2.getJSONObject(i2);
                        l lVar = new l();
                        lVar.fx(jSONObject3.toString());
                        if (this.aUk == null) {
                            this.aUk = new ArrayList();
                        }
                        this.aUk.add(lVar);
                    }
                }
                return isValid();
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public String Dx() {
        if (ListUtils.isEmpty(this.aUk)) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        SparseArray sparseArray = new SparseArray();
        for (int i = 0; i < this.aUk.size(); i++) {
            int giftId = this.aUk.get(i).getGiftId();
            int DB = this.aUk.get(i).DB();
            sparseArray.put(giftId, Integer.valueOf(sparseArray.get(giftId) != null ? ((Integer) sparseArray.get(giftId)).intValue() + DB : DB));
        }
        if (sparseArray.size() > 0) {
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(LogConfig.LOG_GIFT_ID, sparseArray.keyAt(i2));
                    jSONObject.put("num", sparseArray.valueAt(i2));
                    jSONArray.put(jSONObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return jSONArray.toString();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: Dy */
    public k clone() {
        try {
            return (k) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean isValid() {
        return !ListUtils.isEmpty(this.aUh) && this.aTZ > 0 && this.aUa > 0 && this.aUg > 0;
    }
}
