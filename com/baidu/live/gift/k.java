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
    public int aXh;
    public int aXi;
    public int aXj;
    public int aXk;
    public int aXl;
    public int aXm;
    public int aXn;
    public int aXo;
    public int aXq;
    public List<PointF> aXp = new ArrayList();
    public Rect aXr = new Rect();
    public List<l> aXs = new ArrayList();

    public String HQ() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", String.valueOf(this.aXh));
            jSONObject2.put("height", String.valueOf(this.aXi));
            jSONObject.put("screen_size", jSONObject2);
            jSONObject.put("ani_type", String.valueOf(this.aXn));
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("x", String.valueOf(this.aXj));
            jSONObject3.put("y", String.valueOf(this.aXk));
            jSONObject3.put("width", String.valueOf(this.aXl));
            jSONObject3.put("height", String.valueOf(this.aXm));
            jSONObject.put("draw_rect", jSONObject3);
            jSONObject.put("point_count", this.aXq);
            JSONArray jSONArray = new JSONArray();
            DecimalFormat decimalFormat = new DecimalFormat(".0");
            for (int i = 0; i < this.aXp.size(); i++) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("x", decimalFormat.format(this.aXp.get(i).x));
                jSONObject4.put("y", decimalFormat.format(this.aXp.get(i).y));
                jSONArray.put(jSONObject4);
            }
            jSONObject.put("point_data", jSONArray);
            jSONObject.put("point_size", this.aXo);
            if (!ListUtils.isEmpty(this.aXs)) {
                JSONArray jSONArray2 = new JSONArray();
                for (int i2 = 0; i2 < this.aXs.size(); i2++) {
                    jSONArray2.put(new JSONObject(this.aXs.get(i2).HQ()));
                }
                jSONObject.put("point_des", jSONArray2);
            }
            return jSONObject.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean gY(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.aXn = JavaTypesHelper.toInt(jSONObject.optString("ani_type"), 0);
            this.aXo = jSONObject.optInt("point_size");
            JSONObject optJSONObject = jSONObject.optJSONObject("screen_size");
            this.aXh = JavaTypesHelper.toInt(optJSONObject.optString("width"), 0);
            this.aXi = JavaTypesHelper.toInt(optJSONObject.optString("height"), 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("draw_rect");
            this.aXj = JavaTypesHelper.toInt(optJSONObject2.optString("x"), 0);
            this.aXk = JavaTypesHelper.toInt(optJSONObject2.optString("y"), 0);
            this.aXl = JavaTypesHelper.toInt(optJSONObject2.optString("width"), 0);
            this.aXm = JavaTypesHelper.toInt(optJSONObject2.optString("height"), 0);
            this.aXr.left = this.aXj;
            this.aXr.top = this.aXk;
            this.aXr.right = this.aXl;
            this.aXr.bottom = this.aXm + this.aXk;
            this.aXq = JavaTypesHelper.toInt("point_count", 0);
            JSONArray optJSONArray = jSONObject.optJSONArray("point_data");
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                this.aXp.add(new PointF(JavaTypesHelper.toFloat(jSONObject2.optString("x"), 0.0f), JavaTypesHelper.toFloat(jSONObject2.optString("y"), 0.0f)));
            }
            if (this.aXp.size() > 0) {
                JSONArray optJSONArray2 = jSONObject.optJSONArray("point_des");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject jSONObject3 = optJSONArray2.getJSONObject(i2);
                        l lVar = new l();
                        lVar.gY(jSONObject3.toString());
                        if (this.aXs == null) {
                            this.aXs = new ArrayList();
                        }
                        this.aXs.add(lVar);
                    }
                }
                return isValid();
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public String HR() {
        if (ListUtils.isEmpty(this.aXs)) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        SparseArray sparseArray = new SparseArray();
        for (int i = 0; i < this.aXs.size(); i++) {
            int giftId = this.aXs.get(i).getGiftId();
            int HV = this.aXs.get(i).HV();
            sparseArray.put(giftId, Integer.valueOf(sparseArray.get(giftId) != null ? ((Integer) sparseArray.get(giftId)).intValue() + HV : HV));
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
    /* renamed from: HS */
    public k clone() {
        try {
            return (k) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean isValid() {
        return !ListUtils.isEmpty(this.aXp) && this.aXh > 0 && this.aXi > 0 && this.aXo > 0;
    }
}
