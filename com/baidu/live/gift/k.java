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
    public int aYE;
    public int aYF;
    public int aYG;
    public int aYH;
    public int aYI;
    public int aYJ;
    public int aYK;
    public int aYL;
    public int aYN;
    public List<PointF> aYM = new ArrayList();
    public Rect aYO = new Rect();
    public List<l> aYP = new ArrayList();

    public String EP() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", String.valueOf(this.aYE));
            jSONObject2.put("height", String.valueOf(this.aYF));
            jSONObject.put("screen_size", jSONObject2);
            jSONObject.put("ani_type", String.valueOf(this.aYK));
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(Config.EVENT_HEAT_X, String.valueOf(this.aYG));
            jSONObject3.put("y", String.valueOf(this.aYH));
            jSONObject3.put("width", String.valueOf(this.aYI));
            jSONObject3.put("height", String.valueOf(this.aYJ));
            jSONObject.put("draw_rect", jSONObject3);
            jSONObject.put("point_count", this.aYN);
            JSONArray jSONArray = new JSONArray();
            DecimalFormat decimalFormat = new DecimalFormat(".0");
            for (int i = 0; i < this.aYM.size(); i++) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(Config.EVENT_HEAT_X, decimalFormat.format(this.aYM.get(i).x));
                jSONObject4.put("y", decimalFormat.format(this.aYM.get(i).y));
                jSONArray.put(jSONObject4);
            }
            jSONObject.put("point_data", jSONArray);
            jSONObject.put("point_size", this.aYL);
            if (!ListUtils.isEmpty(this.aYP)) {
                JSONArray jSONArray2 = new JSONArray();
                for (int i2 = 0; i2 < this.aYP.size(); i2++) {
                    jSONArray2.put(new JSONObject(this.aYP.get(i2).EP()));
                }
                jSONObject.put("point_des", jSONArray2);
            }
            return jSONObject.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean fY(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.aYK = JavaTypesHelper.toInt(jSONObject.optString("ani_type"), 0);
            this.aYL = jSONObject.optInt("point_size");
            JSONObject optJSONObject = jSONObject.optJSONObject("screen_size");
            this.aYE = JavaTypesHelper.toInt(optJSONObject.optString("width"), 0);
            this.aYF = JavaTypesHelper.toInt(optJSONObject.optString("height"), 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("draw_rect");
            this.aYG = JavaTypesHelper.toInt(optJSONObject2.optString(Config.EVENT_HEAT_X), 0);
            this.aYH = JavaTypesHelper.toInt(optJSONObject2.optString("y"), 0);
            this.aYI = JavaTypesHelper.toInt(optJSONObject2.optString("width"), 0);
            this.aYJ = JavaTypesHelper.toInt(optJSONObject2.optString("height"), 0);
            this.aYO.left = this.aYG;
            this.aYO.top = this.aYH;
            this.aYO.right = this.aYI;
            this.aYO.bottom = this.aYJ + this.aYH;
            this.aYN = JavaTypesHelper.toInt("point_count", 0);
            JSONArray optJSONArray = jSONObject.optJSONArray("point_data");
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                this.aYM.add(new PointF(JavaTypesHelper.toFloat(jSONObject2.optString(Config.EVENT_HEAT_X), 0.0f), JavaTypesHelper.toFloat(jSONObject2.optString("y"), 0.0f)));
            }
            if (this.aYM.size() > 0) {
                JSONArray optJSONArray2 = jSONObject.optJSONArray("point_des");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject jSONObject3 = optJSONArray2.getJSONObject(i2);
                        l lVar = new l();
                        lVar.fY(jSONObject3.toString());
                        if (this.aYP == null) {
                            this.aYP = new ArrayList();
                        }
                        this.aYP.add(lVar);
                    }
                }
                return isValid();
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public String EQ() {
        if (ListUtils.isEmpty(this.aYP)) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        SparseArray sparseArray = new SparseArray();
        for (int i = 0; i < this.aYP.size(); i++) {
            int giftId = this.aYP.get(i).getGiftId();
            int EU = this.aYP.get(i).EU();
            sparseArray.put(giftId, Integer.valueOf(sparseArray.get(giftId) != null ? ((Integer) sparseArray.get(giftId)).intValue() + EU : EU));
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
    /* renamed from: ER */
    public k clone() {
        try {
            return (k) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean isValid() {
        return !ListUtils.isEmpty(this.aYM) && this.aYE > 0 && this.aYF > 0 && this.aYL > 0;
    }
}
