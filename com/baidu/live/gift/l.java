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
/* loaded from: classes7.dex */
public class l implements Cloneable {
    public int aOp;
    public int aOq;
    public int aOr;
    public int aOs;
    public int aOt;
    public int aOu;
    public int aOv;
    public int aOw;
    public int aOy;
    public List<PointF> aOx = new ArrayList();
    public Rect aOz = new Rect();
    public List<m> aOA = new ArrayList();

    public String EH() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", String.valueOf(this.aOp));
            jSONObject2.put("height", String.valueOf(this.aOq));
            jSONObject.put("screen_size", jSONObject2);
            jSONObject.put("ani_type", String.valueOf(this.aOv));
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("x", String.valueOf(this.aOr));
            jSONObject3.put("y", String.valueOf(this.aOs));
            jSONObject3.put("width", String.valueOf(this.aOt));
            jSONObject3.put("height", String.valueOf(this.aOu));
            jSONObject.put("draw_rect", jSONObject3);
            jSONObject.put("point_count", this.aOy);
            JSONArray jSONArray = new JSONArray();
            DecimalFormat decimalFormat = new DecimalFormat(".0");
            for (int i = 0; i < this.aOx.size(); i++) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("x", decimalFormat.format(this.aOx.get(i).x));
                jSONObject4.put("y", decimalFormat.format(this.aOx.get(i).y));
                jSONArray.put(jSONObject4);
            }
            jSONObject.put("point_data", jSONArray);
            jSONObject.put("point_size", this.aOw);
            if (!ListUtils.isEmpty(this.aOA)) {
                JSONArray jSONArray2 = new JSONArray();
                for (int i2 = 0; i2 < this.aOA.size(); i2++) {
                    jSONArray2.put(new JSONObject(this.aOA.get(i2).EH()));
                }
                jSONObject.put("point_des", jSONArray2);
            }
            return jSONObject.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean gf(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.aOv = JavaTypesHelper.toInt(jSONObject.optString("ani_type"), 0);
            this.aOw = jSONObject.optInt("point_size");
            JSONObject optJSONObject = jSONObject.optJSONObject("screen_size");
            this.aOp = JavaTypesHelper.toInt(optJSONObject.optString("width"), 0);
            this.aOq = JavaTypesHelper.toInt(optJSONObject.optString("height"), 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("draw_rect");
            this.aOr = JavaTypesHelper.toInt(optJSONObject2.optString("x"), 0);
            this.aOs = JavaTypesHelper.toInt(optJSONObject2.optString("y"), 0);
            this.aOt = JavaTypesHelper.toInt(optJSONObject2.optString("width"), 0);
            this.aOu = JavaTypesHelper.toInt(optJSONObject2.optString("height"), 0);
            this.aOz.left = this.aOr;
            this.aOz.top = this.aOs;
            this.aOz.right = this.aOt;
            this.aOz.bottom = this.aOu + this.aOs;
            this.aOy = JavaTypesHelper.toInt("point_count", 0);
            JSONArray optJSONArray = jSONObject.optJSONArray("point_data");
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                this.aOx.add(new PointF(JavaTypesHelper.toFloat(jSONObject2.optString("x"), 0.0f), JavaTypesHelper.toFloat(jSONObject2.optString("y"), 0.0f)));
            }
            if (this.aOx.size() > 0) {
                JSONArray optJSONArray2 = jSONObject.optJSONArray("point_des");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject jSONObject3 = optJSONArray2.getJSONObject(i2);
                        m mVar = new m();
                        mVar.gf(jSONObject3.toString());
                        if (this.aOA == null) {
                            this.aOA = new ArrayList();
                        }
                        this.aOA.add(mVar);
                    }
                }
                return isValid();
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public String EI() {
        if (ListUtils.isEmpty(this.aOA)) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        SparseArray sparseArray = new SparseArray();
        for (int i = 0; i < this.aOA.size(); i++) {
            int giftId = this.aOA.get(i).getGiftId();
            int EM = this.aOA.get(i).EM();
            sparseArray.put(giftId, Integer.valueOf(sparseArray.get(giftId) != null ? ((Integer) sparseArray.get(giftId)).intValue() + EM : EM));
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
    /* renamed from: EJ */
    public l clone() {
        try {
            return (l) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean isValid() {
        return !ListUtils.isEmpty(this.aOx) && this.aOp > 0 && this.aOq > 0 && this.aOw > 0;
    }
}
