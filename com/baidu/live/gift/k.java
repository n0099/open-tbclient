package com.baidu.live.gift;

import android.graphics.PointF;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.log.LogConfig;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class k implements Cloneable {
    public int aVN;
    public int aVO;
    public int aVP;
    public int aVQ;
    public int aVR;
    public int aVS;
    public int aVT;
    public int aVU;
    public int aVW;
    public List<PointF> aVV = new ArrayList();
    public Rect aVX = new Rect();
    public List<l> aVY = new ArrayList();

    public String GK() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", String.valueOf(this.aVN));
            jSONObject2.put("height", String.valueOf(this.aVO));
            jSONObject.put("screen_size", jSONObject2);
            jSONObject.put("ani_type", String.valueOf(this.aVT));
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("x", String.valueOf(this.aVP));
            jSONObject3.put("y", String.valueOf(this.aVQ));
            jSONObject3.put("width", String.valueOf(this.aVR));
            jSONObject3.put("height", String.valueOf(this.aVS));
            jSONObject.put("draw_rect", jSONObject3);
            jSONObject.put("point_count", this.aVW);
            JSONArray jSONArray = new JSONArray();
            DecimalFormat decimalFormat = new DecimalFormat(".0");
            for (int i = 0; i < this.aVV.size(); i++) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("x", decimalFormat.format(this.aVV.get(i).x));
                jSONObject4.put("y", decimalFormat.format(this.aVV.get(i).y));
                jSONArray.put(jSONObject4);
            }
            jSONObject.put("point_data", jSONArray);
            jSONObject.put("point_size", this.aVU);
            if (!ListUtils.isEmpty(this.aVY)) {
                JSONArray jSONArray2 = new JSONArray();
                for (int i2 = 0; i2 < this.aVY.size(); i2++) {
                    jSONArray2.put(new JSONObject(this.aVY.get(i2).GK()));
                }
                jSONObject.put("point_des", jSONArray2);
            }
            return jSONObject.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean gJ(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.aVT = JavaTypesHelper.toInt(jSONObject.optString("ani_type"), 0);
            this.aVU = jSONObject.optInt("point_size");
            JSONObject optJSONObject = jSONObject.optJSONObject("screen_size");
            this.aVN = JavaTypesHelper.toInt(optJSONObject.optString("width"), 0);
            this.aVO = JavaTypesHelper.toInt(optJSONObject.optString("height"), 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("draw_rect");
            this.aVP = JavaTypesHelper.toInt(optJSONObject2.optString("x"), 0);
            this.aVQ = JavaTypesHelper.toInt(optJSONObject2.optString("y"), 0);
            this.aVR = JavaTypesHelper.toInt(optJSONObject2.optString("width"), 0);
            this.aVS = JavaTypesHelper.toInt(optJSONObject2.optString("height"), 0);
            this.aVX.left = this.aVP;
            this.aVX.top = this.aVQ;
            this.aVX.right = this.aVR;
            this.aVX.bottom = this.aVS + this.aVQ;
            this.aVW = JavaTypesHelper.toInt("point_count", 0);
            JSONArray optJSONArray = jSONObject.optJSONArray("point_data");
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                this.aVV.add(new PointF(JavaTypesHelper.toFloat(jSONObject2.optString("x"), 0.0f), JavaTypesHelper.toFloat(jSONObject2.optString("y"), 0.0f)));
            }
            if (this.aVV.size() > 0) {
                JSONArray optJSONArray2 = jSONObject.optJSONArray("point_des");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject jSONObject3 = optJSONArray2.getJSONObject(i2);
                        l lVar = new l();
                        lVar.gJ(jSONObject3.toString());
                        if (this.aVY == null) {
                            this.aVY = new ArrayList();
                        }
                        this.aVY.add(lVar);
                    }
                }
                return isValid();
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public String GL() {
        if (ListUtils.isEmpty(this.aVY)) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        SparseArray sparseArray = new SparseArray();
        for (int i = 0; i < this.aVY.size(); i++) {
            int giftId = this.aVY.get(i).getGiftId();
            int GP = this.aVY.get(i).GP();
            sparseArray.put(giftId, Integer.valueOf(sparseArray.get(giftId) != null ? ((Integer) sparseArray.get(giftId)).intValue() + GP : GP));
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
    /* renamed from: GM */
    public k clone() {
        try {
            return (k) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean isValid() {
        return !ListUtils.isEmpty(this.aVV) && this.aVN > 0 && this.aVO > 0 && this.aVU > 0;
    }
}
