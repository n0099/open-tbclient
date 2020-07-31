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
/* loaded from: classes4.dex */
public class l implements Cloneable {
    public int aJc;
    public int aJd;
    public int aJe;
    public int aJf;
    public int aJg;
    public int aJh;
    public int aJi;
    public int aJj;
    public int aJl;
    public List<PointF> aJk = new ArrayList();
    public Rect aJm = new Rect();
    public List<m> aJn = new ArrayList();

    public String ze() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", String.valueOf(this.aJc));
            jSONObject2.put("height", String.valueOf(this.aJd));
            jSONObject.put("screen_size", jSONObject2);
            jSONObject.put("ani_type", String.valueOf(this.aJi));
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(Config.EVENT_HEAT_X, String.valueOf(this.aJe));
            jSONObject3.put("y", String.valueOf(this.aJf));
            jSONObject3.put("width", String.valueOf(this.aJg));
            jSONObject3.put("height", String.valueOf(this.aJh));
            jSONObject.put("draw_rect", jSONObject3);
            jSONObject.put("point_count", this.aJl);
            JSONArray jSONArray = new JSONArray();
            DecimalFormat decimalFormat = new DecimalFormat(".0");
            for (int i = 0; i < this.aJk.size(); i++) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(Config.EVENT_HEAT_X, decimalFormat.format(this.aJk.get(i).x));
                jSONObject4.put("y", decimalFormat.format(this.aJk.get(i).y));
                jSONArray.put(jSONObject4);
            }
            jSONObject.put("point_data", jSONArray);
            jSONObject.put("point_size", this.aJj);
            if (!ListUtils.isEmpty(this.aJn)) {
                JSONArray jSONArray2 = new JSONArray();
                for (int i2 = 0; i2 < this.aJn.size(); i2++) {
                    jSONArray2.put(new JSONObject(this.aJn.get(i2).ze()));
                }
                jSONObject.put("point_des", jSONArray2);
            }
            return jSONObject.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean eK(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.aJi = JavaTypesHelper.toInt(jSONObject.optString("ani_type"), 0);
            this.aJj = jSONObject.optInt("point_size");
            JSONObject optJSONObject = jSONObject.optJSONObject("screen_size");
            this.aJc = JavaTypesHelper.toInt(optJSONObject.optString("width"), 0);
            this.aJd = JavaTypesHelper.toInt(optJSONObject.optString("height"), 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("draw_rect");
            this.aJe = JavaTypesHelper.toInt(optJSONObject2.optString(Config.EVENT_HEAT_X), 0);
            this.aJf = JavaTypesHelper.toInt(optJSONObject2.optString("y"), 0);
            this.aJg = JavaTypesHelper.toInt(optJSONObject2.optString("width"), 0);
            this.aJh = JavaTypesHelper.toInt(optJSONObject2.optString("height"), 0);
            this.aJm.left = this.aJe;
            this.aJm.top = this.aJf;
            this.aJm.right = this.aJg;
            this.aJm.bottom = this.aJh + this.aJf;
            this.aJl = JavaTypesHelper.toInt("point_count", 0);
            JSONArray optJSONArray = jSONObject.optJSONArray("point_data");
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                this.aJk.add(new PointF(JavaTypesHelper.toFloat(jSONObject2.optString(Config.EVENT_HEAT_X), 0.0f), JavaTypesHelper.toFloat(jSONObject2.optString("y"), 0.0f)));
            }
            if (this.aJk.size() > 0) {
                JSONArray optJSONArray2 = jSONObject.optJSONArray("point_des");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject jSONObject3 = optJSONArray2.getJSONObject(i2);
                        m mVar = new m();
                        mVar.eK(jSONObject3.toString());
                        if (this.aJn == null) {
                            this.aJn = new ArrayList();
                        }
                        this.aJn.add(mVar);
                    }
                }
                return isValid();
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public String zf() {
        if (ListUtils.isEmpty(this.aJn)) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        SparseArray sparseArray = new SparseArray();
        for (int i = 0; i < this.aJn.size(); i++) {
            int giftId = this.aJn.get(i).getGiftId();
            int zj = this.aJn.get(i).zj();
            sparseArray.put(giftId, Integer.valueOf(sparseArray.get(giftId) != null ? ((Integer) sparseArray.get(giftId)).intValue() + zj : zj));
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
    /* renamed from: zg */
    public l clone() {
        try {
            return (l) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean isValid() {
        return !ListUtils.isEmpty(this.aJk) && this.aJc > 0 && this.aJd > 0 && this.aJj > 0;
    }
}
