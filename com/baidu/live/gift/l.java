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
    public int aFl;
    public int aFm;
    public int aFn;
    public int aFo;
    public int aFp;
    public int aFq;
    public int aFr;
    public int aFs;
    public int aFu;
    public List<PointF> aFt = new ArrayList();
    public Rect aFv = new Rect();
    public List<m> aFw = new ArrayList();

    public String yc() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", String.valueOf(this.aFl));
            jSONObject2.put("height", String.valueOf(this.aFm));
            jSONObject.put("screen_size", jSONObject2);
            jSONObject.put("ani_type", String.valueOf(this.aFr));
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(Config.EVENT_HEAT_X, String.valueOf(this.aFn));
            jSONObject3.put("y", String.valueOf(this.aFo));
            jSONObject3.put("width", String.valueOf(this.aFp));
            jSONObject3.put("height", String.valueOf(this.aFq));
            jSONObject.put("draw_rect", jSONObject3);
            jSONObject.put("point_count", this.aFu);
            JSONArray jSONArray = new JSONArray();
            DecimalFormat decimalFormat = new DecimalFormat(".0");
            for (int i = 0; i < this.aFt.size(); i++) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(Config.EVENT_HEAT_X, decimalFormat.format(this.aFt.get(i).x));
                jSONObject4.put("y", decimalFormat.format(this.aFt.get(i).y));
                jSONArray.put(jSONObject4);
            }
            jSONObject.put("point_data", jSONArray);
            jSONObject.put("point_size", this.aFs);
            if (!ListUtils.isEmpty(this.aFw)) {
                JSONArray jSONArray2 = new JSONArray();
                for (int i2 = 0; i2 < this.aFw.size(); i2++) {
                    jSONArray2.put(new JSONObject(this.aFw.get(i2).yc()));
                }
                jSONObject.put("point_des", jSONArray2);
            }
            return jSONObject.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean eF(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.aFr = JavaTypesHelper.toInt(jSONObject.optString("ani_type"), 0);
            this.aFs = jSONObject.optInt("point_size");
            JSONObject optJSONObject = jSONObject.optJSONObject("screen_size");
            this.aFl = JavaTypesHelper.toInt(optJSONObject.optString("width"), 0);
            this.aFm = JavaTypesHelper.toInt(optJSONObject.optString("height"), 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("draw_rect");
            this.aFn = JavaTypesHelper.toInt(optJSONObject2.optString(Config.EVENT_HEAT_X), 0);
            this.aFo = JavaTypesHelper.toInt(optJSONObject2.optString("y"), 0);
            this.aFp = JavaTypesHelper.toInt(optJSONObject2.optString("width"), 0);
            this.aFq = JavaTypesHelper.toInt(optJSONObject2.optString("height"), 0);
            this.aFv.left = this.aFn;
            this.aFv.top = this.aFo;
            this.aFv.right = this.aFp;
            this.aFv.bottom = this.aFq + this.aFo;
            this.aFu = JavaTypesHelper.toInt("point_count", 0);
            JSONArray optJSONArray = jSONObject.optJSONArray("point_data");
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                this.aFt.add(new PointF(JavaTypesHelper.toFloat(jSONObject2.optString(Config.EVENT_HEAT_X), 0.0f), JavaTypesHelper.toFloat(jSONObject2.optString("y"), 0.0f)));
            }
            if (this.aFt.size() > 0) {
                JSONArray optJSONArray2 = jSONObject.optJSONArray("point_des");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject jSONObject3 = optJSONArray2.getJSONObject(i2);
                        m mVar = new m();
                        mVar.eF(jSONObject3.toString());
                        if (this.aFw == null) {
                            this.aFw = new ArrayList();
                        }
                        this.aFw.add(mVar);
                    }
                }
                return isValid();
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public String yd() {
        if (ListUtils.isEmpty(this.aFw)) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        SparseArray sparseArray = new SparseArray();
        for (int i = 0; i < this.aFw.size(); i++) {
            int giftId = this.aFw.get(i).getGiftId();
            int yh = this.aFw.get(i).yh();
            sparseArray.put(giftId, Integer.valueOf(sparseArray.get(giftId) != null ? ((Integer) sparseArray.get(giftId)).intValue() + yh : yh));
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
    /* renamed from: ye */
    public l clone() {
        try {
            return (l) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean isValid() {
        return !ListUtils.isEmpty(this.aFt) && this.aFl > 0 && this.aFm > 0 && this.aFs > 0;
    }
}
