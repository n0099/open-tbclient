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
/* loaded from: classes3.dex */
public class l implements Cloneable {
    public int aAa;
    public int aAc;
    public int azT;
    public int azU;
    public int azV;
    public int azW;
    public int azX;
    public int azY;
    public int azZ;
    public List<PointF> aAb = new ArrayList();
    public Rect aAd = new Rect();
    public List<m> aAe = new ArrayList();

    public String wL() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", String.valueOf(this.azT));
            jSONObject2.put("height", String.valueOf(this.azU));
            jSONObject.put("screen_size", jSONObject2);
            jSONObject.put("ani_type", String.valueOf(this.azZ));
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(Config.EVENT_HEAT_X, String.valueOf(this.azV));
            jSONObject3.put("y", String.valueOf(this.azW));
            jSONObject3.put("width", String.valueOf(this.azX));
            jSONObject3.put("height", String.valueOf(this.azY));
            jSONObject.put("draw_rect", jSONObject3);
            jSONObject.put("point_count", this.aAc);
            JSONArray jSONArray = new JSONArray();
            DecimalFormat decimalFormat = new DecimalFormat(".0");
            for (int i = 0; i < this.aAb.size(); i++) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(Config.EVENT_HEAT_X, decimalFormat.format(this.aAb.get(i).x));
                jSONObject4.put("y", decimalFormat.format(this.aAb.get(i).y));
                jSONArray.put(jSONObject4);
            }
            jSONObject.put("point_data", jSONArray);
            jSONObject.put("point_size", this.aAa);
            if (!ListUtils.isEmpty(this.aAe)) {
                JSONArray jSONArray2 = new JSONArray();
                for (int i2 = 0; i2 < this.aAe.size(); i2++) {
                    jSONArray2.put(new JSONObject(this.aAe.get(i2).wL()));
                }
                jSONObject.put("point_des", jSONArray2);
            }
            return jSONObject.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean dY(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.azZ = JavaTypesHelper.toInt(jSONObject.optString("ani_type"), 0);
            this.aAa = jSONObject.optInt("point_size");
            JSONObject optJSONObject = jSONObject.optJSONObject("screen_size");
            this.azT = JavaTypesHelper.toInt(optJSONObject.optString("width"), 0);
            this.azU = JavaTypesHelper.toInt(optJSONObject.optString("height"), 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("draw_rect");
            this.azV = JavaTypesHelper.toInt(optJSONObject2.optString(Config.EVENT_HEAT_X), 0);
            this.azW = JavaTypesHelper.toInt(optJSONObject2.optString("y"), 0);
            this.azX = JavaTypesHelper.toInt(optJSONObject2.optString("width"), 0);
            this.azY = JavaTypesHelper.toInt(optJSONObject2.optString("height"), 0);
            this.aAd.left = this.azV;
            this.aAd.top = this.azW;
            this.aAd.right = this.azX;
            this.aAd.bottom = this.azY + this.azW;
            this.aAc = JavaTypesHelper.toInt("point_count", 0);
            JSONArray optJSONArray = jSONObject.optJSONArray("point_data");
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                this.aAb.add(new PointF(JavaTypesHelper.toFloat(jSONObject2.optString(Config.EVENT_HEAT_X), 0.0f), JavaTypesHelper.toFloat(jSONObject2.optString("y"), 0.0f)));
            }
            if (this.aAb.size() > 0) {
                JSONArray optJSONArray2 = jSONObject.optJSONArray("point_des");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject jSONObject3 = optJSONArray2.getJSONObject(i2);
                        m mVar = new m();
                        mVar.dY(jSONObject3.toString());
                        if (this.aAe == null) {
                            this.aAe = new ArrayList();
                        }
                        this.aAe.add(mVar);
                    }
                }
                return isValid();
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public String wM() {
        if (ListUtils.isEmpty(this.aAe)) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        SparseArray sparseArray = new SparseArray();
        for (int i = 0; i < this.aAe.size(); i++) {
            int giftId = this.aAe.get(i).getGiftId();
            int wQ = this.aAe.get(i).wQ();
            sparseArray.put(giftId, Integer.valueOf(sparseArray.get(giftId) != null ? ((Integer) sparseArray.get(giftId)).intValue() + wQ : wQ));
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
    /* renamed from: wN */
    public l clone() {
        try {
            return (l) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean isValid() {
        return !ListUtils.isEmpty(this.aAb) && this.azT > 0 && this.azU > 0 && this.aAa > 0;
    }
}
