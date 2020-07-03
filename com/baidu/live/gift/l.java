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
    public int aHH;
    public int aHI;
    public int aHJ;
    public int aHK;
    public int aHL;
    public int aHM;
    public int aHN;
    public int aHO;
    public int aHQ;
    public List<PointF> aHP = new ArrayList();
    public Rect aHR = new Rect();
    public List<m> aHS = new ArrayList();

    public String yC() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", String.valueOf(this.aHH));
            jSONObject2.put("height", String.valueOf(this.aHI));
            jSONObject.put("screen_size", jSONObject2);
            jSONObject.put("ani_type", String.valueOf(this.aHN));
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(Config.EVENT_HEAT_X, String.valueOf(this.aHJ));
            jSONObject3.put("y", String.valueOf(this.aHK));
            jSONObject3.put("width", String.valueOf(this.aHL));
            jSONObject3.put("height", String.valueOf(this.aHM));
            jSONObject.put("draw_rect", jSONObject3);
            jSONObject.put("point_count", this.aHQ);
            JSONArray jSONArray = new JSONArray();
            DecimalFormat decimalFormat = new DecimalFormat(".0");
            for (int i = 0; i < this.aHP.size(); i++) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(Config.EVENT_HEAT_X, decimalFormat.format(this.aHP.get(i).x));
                jSONObject4.put("y", decimalFormat.format(this.aHP.get(i).y));
                jSONArray.put(jSONObject4);
            }
            jSONObject.put("point_data", jSONArray);
            jSONObject.put("point_size", this.aHO);
            if (!ListUtils.isEmpty(this.aHS)) {
                JSONArray jSONArray2 = new JSONArray();
                for (int i2 = 0; i2 < this.aHS.size(); i2++) {
                    jSONArray2.put(new JSONObject(this.aHS.get(i2).yC()));
                }
                jSONObject.put("point_des", jSONArray2);
            }
            return jSONObject.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean eL(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.aHN = JavaTypesHelper.toInt(jSONObject.optString("ani_type"), 0);
            this.aHO = jSONObject.optInt("point_size");
            JSONObject optJSONObject = jSONObject.optJSONObject("screen_size");
            this.aHH = JavaTypesHelper.toInt(optJSONObject.optString("width"), 0);
            this.aHI = JavaTypesHelper.toInt(optJSONObject.optString("height"), 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("draw_rect");
            this.aHJ = JavaTypesHelper.toInt(optJSONObject2.optString(Config.EVENT_HEAT_X), 0);
            this.aHK = JavaTypesHelper.toInt(optJSONObject2.optString("y"), 0);
            this.aHL = JavaTypesHelper.toInt(optJSONObject2.optString("width"), 0);
            this.aHM = JavaTypesHelper.toInt(optJSONObject2.optString("height"), 0);
            this.aHR.left = this.aHJ;
            this.aHR.top = this.aHK;
            this.aHR.right = this.aHL;
            this.aHR.bottom = this.aHM + this.aHK;
            this.aHQ = JavaTypesHelper.toInt("point_count", 0);
            JSONArray optJSONArray = jSONObject.optJSONArray("point_data");
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                this.aHP.add(new PointF(JavaTypesHelper.toFloat(jSONObject2.optString(Config.EVENT_HEAT_X), 0.0f), JavaTypesHelper.toFloat(jSONObject2.optString("y"), 0.0f)));
            }
            if (this.aHP.size() > 0) {
                JSONArray optJSONArray2 = jSONObject.optJSONArray("point_des");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject jSONObject3 = optJSONArray2.getJSONObject(i2);
                        m mVar = new m();
                        mVar.eL(jSONObject3.toString());
                        if (this.aHS == null) {
                            this.aHS = new ArrayList();
                        }
                        this.aHS.add(mVar);
                    }
                }
                return isValid();
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public String yD() {
        if (ListUtils.isEmpty(this.aHS)) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        SparseArray sparseArray = new SparseArray();
        for (int i = 0; i < this.aHS.size(); i++) {
            int giftId = this.aHS.get(i).getGiftId();
            int yH = this.aHS.get(i).yH();
            sparseArray.put(giftId, Integer.valueOf(sparseArray.get(giftId) != null ? ((Integer) sparseArray.get(giftId)).intValue() + yH : yH));
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
    /* renamed from: yE */
    public l clone() {
        try {
            return (l) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean isValid() {
        return !ListUtils.isEmpty(this.aHP) && this.aHH > 0 && this.aHI > 0 && this.aHO > 0;
    }
}
