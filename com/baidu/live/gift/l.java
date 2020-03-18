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
    public int ahA;
    public int ahC;
    public int aht;
    public int ahu;
    public int ahv;
    public int ahw;
    public int ahx;
    public int ahy;
    public int ahz;
    public List<PointF> ahB = new ArrayList();
    public Rect ahD = new Rect();
    public List<m> ahE = new ArrayList();

    public String st() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", String.valueOf(this.aht));
            jSONObject2.put("height", String.valueOf(this.ahu));
            jSONObject.put("screen_size", jSONObject2);
            jSONObject.put("ani_type", String.valueOf(this.ahz));
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(Config.EVENT_HEAT_X, String.valueOf(this.ahv));
            jSONObject3.put("y", String.valueOf(this.ahw));
            jSONObject3.put("width", String.valueOf(this.ahx));
            jSONObject3.put("height", String.valueOf(this.ahy));
            jSONObject.put("draw_rect", jSONObject3);
            jSONObject.put("point_count", this.ahC);
            JSONArray jSONArray = new JSONArray();
            DecimalFormat decimalFormat = new DecimalFormat(".0");
            for (int i = 0; i < this.ahB.size(); i++) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(Config.EVENT_HEAT_X, decimalFormat.format(this.ahB.get(i).x));
                jSONObject4.put("y", decimalFormat.format(this.ahB.get(i).y));
                jSONArray.put(jSONObject4);
            }
            jSONObject.put("point_data", jSONArray);
            jSONObject.put("point_size", this.ahA);
            if (!ListUtils.isEmpty(this.ahE)) {
                JSONArray jSONArray2 = new JSONArray();
                for (int i2 = 0; i2 < this.ahE.size(); i2++) {
                    jSONArray2.put(new JSONObject(this.ahE.get(i2).st()));
                }
                jSONObject.put("point_des", jSONArray2);
            }
            return jSONObject.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean dh(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.ahz = JavaTypesHelper.toInt(jSONObject.optString("ani_type"), 0);
            this.ahA = jSONObject.optInt("point_size");
            JSONObject optJSONObject = jSONObject.optJSONObject("screen_size");
            this.aht = JavaTypesHelper.toInt(optJSONObject.optString("width"), 0);
            this.ahu = JavaTypesHelper.toInt(optJSONObject.optString("height"), 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("draw_rect");
            this.ahv = JavaTypesHelper.toInt(optJSONObject2.optString(Config.EVENT_HEAT_X), 0);
            this.ahw = JavaTypesHelper.toInt(optJSONObject2.optString("y"), 0);
            this.ahx = JavaTypesHelper.toInt(optJSONObject2.optString("width"), 0);
            this.ahy = JavaTypesHelper.toInt(optJSONObject2.optString("height"), 0);
            this.ahD.left = this.ahv;
            this.ahD.top = this.ahw;
            this.ahD.right = this.ahx;
            this.ahD.bottom = this.ahy + this.ahw;
            this.ahC = JavaTypesHelper.toInt("point_count", 0);
            JSONArray optJSONArray = jSONObject.optJSONArray("point_data");
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                this.ahB.add(new PointF(JavaTypesHelper.toFloat(jSONObject2.optString(Config.EVENT_HEAT_X), 0.0f), JavaTypesHelper.toFloat(jSONObject2.optString("y"), 0.0f)));
            }
            if (this.ahB.size() > 0) {
                JSONArray optJSONArray2 = jSONObject.optJSONArray("point_des");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject jSONObject3 = optJSONArray2.getJSONObject(i2);
                        m mVar = new m();
                        mVar.dh(jSONObject3.toString());
                        if (this.ahE == null) {
                            this.ahE = new ArrayList();
                        }
                        this.ahE.add(mVar);
                    }
                }
                return isValid();
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public String su() {
        if (ListUtils.isEmpty(this.ahE)) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        SparseArray sparseArray = new SparseArray();
        for (int i = 0; i < this.ahE.size(); i++) {
            int giftId = this.ahE.get(i).getGiftId();
            int sy = this.ahE.get(i).sy();
            sparseArray.put(giftId, Integer.valueOf(sparseArray.get(giftId) != null ? ((Integer) sparseArray.get(giftId)).intValue() + sy : sy));
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
    /* renamed from: sv */
    public l clone() {
        try {
            return (l) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean isValid() {
        return !ListUtils.isEmpty(this.ahB) && this.aht > 0 && this.ahu > 0 && this.ahA > 0;
    }
}
