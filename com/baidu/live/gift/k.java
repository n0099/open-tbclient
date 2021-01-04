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
/* loaded from: classes11.dex */
public class k implements Cloneable {
    public int aYM;
    public int aYN;
    public int aYO;
    public int aYP;
    public int aYQ;
    public int aYR;
    public int aYS;
    public int aYT;
    public int aYV;
    public List<PointF> aYU = new ArrayList();
    public Rect aYW = new Rect();
    public List<l> aYX = new ArrayList();

    public String Hr() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", String.valueOf(this.aYM));
            jSONObject2.put("height", String.valueOf(this.aYN));
            jSONObject.put("screen_size", jSONObject2);
            jSONObject.put("ani_type", String.valueOf(this.aYS));
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("x", String.valueOf(this.aYO));
            jSONObject3.put("y", String.valueOf(this.aYP));
            jSONObject3.put("width", String.valueOf(this.aYQ));
            jSONObject3.put("height", String.valueOf(this.aYR));
            jSONObject.put("draw_rect", jSONObject3);
            jSONObject.put("point_count", this.aYV);
            JSONArray jSONArray = new JSONArray();
            DecimalFormat decimalFormat = new DecimalFormat(".0");
            for (int i = 0; i < this.aYU.size(); i++) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("x", decimalFormat.format(this.aYU.get(i).x));
                jSONObject4.put("y", decimalFormat.format(this.aYU.get(i).y));
                jSONArray.put(jSONObject4);
            }
            jSONObject.put("point_data", jSONArray);
            jSONObject.put("point_size", this.aYT);
            if (!ListUtils.isEmpty(this.aYX)) {
                JSONArray jSONArray2 = new JSONArray();
                for (int i2 = 0; i2 < this.aYX.size(); i2++) {
                    jSONArray2.put(new JSONObject(this.aYX.get(i2).Hr()));
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
            this.aYS = JavaTypesHelper.toInt(jSONObject.optString("ani_type"), 0);
            this.aYT = jSONObject.optInt("point_size");
            JSONObject optJSONObject = jSONObject.optJSONObject("screen_size");
            this.aYM = JavaTypesHelper.toInt(optJSONObject.optString("width"), 0);
            this.aYN = JavaTypesHelper.toInt(optJSONObject.optString("height"), 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("draw_rect");
            this.aYO = JavaTypesHelper.toInt(optJSONObject2.optString("x"), 0);
            this.aYP = JavaTypesHelper.toInt(optJSONObject2.optString("y"), 0);
            this.aYQ = JavaTypesHelper.toInt(optJSONObject2.optString("width"), 0);
            this.aYR = JavaTypesHelper.toInt(optJSONObject2.optString("height"), 0);
            this.aYW.left = this.aYO;
            this.aYW.top = this.aYP;
            this.aYW.right = this.aYQ;
            this.aYW.bottom = this.aYR + this.aYP;
            this.aYV = JavaTypesHelper.toInt("point_count", 0);
            JSONArray optJSONArray = jSONObject.optJSONArray("point_data");
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                this.aYU.add(new PointF(JavaTypesHelper.toFloat(jSONObject2.optString("x"), 0.0f), JavaTypesHelper.toFloat(jSONObject2.optString("y"), 0.0f)));
            }
            if (this.aYU.size() > 0) {
                JSONArray optJSONArray2 = jSONObject.optJSONArray("point_des");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject jSONObject3 = optJSONArray2.getJSONObject(i2);
                        l lVar = new l();
                        lVar.gJ(jSONObject3.toString());
                        if (this.aYX == null) {
                            this.aYX = new ArrayList();
                        }
                        this.aYX.add(lVar);
                    }
                }
                return isValid();
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public String Hs() {
        if (ListUtils.isEmpty(this.aYX)) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        SparseArray sparseArray = new SparseArray();
        for (int i = 0; i < this.aYX.size(); i++) {
            int giftId = this.aYX.get(i).getGiftId();
            int Hw = this.aYX.get(i).Hw();
            sparseArray.put(giftId, Integer.valueOf(sparseArray.get(giftId) != null ? ((Integer) sparseArray.get(giftId)).intValue() + Hw : Hw));
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
    /* renamed from: Ht */
    public k clone() {
        try {
            return (k) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean isValid() {
        return !ListUtils.isEmpty(this.aYU) && this.aYM > 0 && this.aYN > 0 && this.aYT > 0;
    }
}
