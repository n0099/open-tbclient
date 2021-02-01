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
/* loaded from: classes11.dex */
public class k implements Cloneable {
    public int aXe;
    public int aXf;
    public int aXg;
    public int aXh;
    public int aXi;
    public int aXj;
    public int aXk;
    public int aXl;
    public int aXn;
    public List<PointF> aXm = new ArrayList();
    public Rect aXo = new Rect();
    public List<l> aXp = new ArrayList();

    public String EM() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", String.valueOf(this.aXe));
            jSONObject2.put("height", String.valueOf(this.aXf));
            jSONObject.put("screen_size", jSONObject2);
            jSONObject.put("ani_type", String.valueOf(this.aXk));
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(Config.EVENT_HEAT_X, String.valueOf(this.aXg));
            jSONObject3.put("y", String.valueOf(this.aXh));
            jSONObject3.put("width", String.valueOf(this.aXi));
            jSONObject3.put("height", String.valueOf(this.aXj));
            jSONObject.put("draw_rect", jSONObject3);
            jSONObject.put("point_count", this.aXn);
            JSONArray jSONArray = new JSONArray();
            DecimalFormat decimalFormat = new DecimalFormat(".0");
            for (int i = 0; i < this.aXm.size(); i++) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(Config.EVENT_HEAT_X, decimalFormat.format(this.aXm.get(i).x));
                jSONObject4.put("y", decimalFormat.format(this.aXm.get(i).y));
                jSONArray.put(jSONObject4);
            }
            jSONObject.put("point_data", jSONArray);
            jSONObject.put("point_size", this.aXl);
            if (!ListUtils.isEmpty(this.aXp)) {
                JSONArray jSONArray2 = new JSONArray();
                for (int i2 = 0; i2 < this.aXp.size(); i2++) {
                    jSONArray2.put(new JSONObject(this.aXp.get(i2).EM()));
                }
                jSONObject.put("point_des", jSONArray2);
            }
            return jSONObject.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean fS(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.aXk = JavaTypesHelper.toInt(jSONObject.optString("ani_type"), 0);
            this.aXl = jSONObject.optInt("point_size");
            JSONObject optJSONObject = jSONObject.optJSONObject("screen_size");
            this.aXe = JavaTypesHelper.toInt(optJSONObject.optString("width"), 0);
            this.aXf = JavaTypesHelper.toInt(optJSONObject.optString("height"), 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("draw_rect");
            this.aXg = JavaTypesHelper.toInt(optJSONObject2.optString(Config.EVENT_HEAT_X), 0);
            this.aXh = JavaTypesHelper.toInt(optJSONObject2.optString("y"), 0);
            this.aXi = JavaTypesHelper.toInt(optJSONObject2.optString("width"), 0);
            this.aXj = JavaTypesHelper.toInt(optJSONObject2.optString("height"), 0);
            this.aXo.left = this.aXg;
            this.aXo.top = this.aXh;
            this.aXo.right = this.aXi;
            this.aXo.bottom = this.aXj + this.aXh;
            this.aXn = JavaTypesHelper.toInt("point_count", 0);
            JSONArray optJSONArray = jSONObject.optJSONArray("point_data");
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                this.aXm.add(new PointF(JavaTypesHelper.toFloat(jSONObject2.optString(Config.EVENT_HEAT_X), 0.0f), JavaTypesHelper.toFloat(jSONObject2.optString("y"), 0.0f)));
            }
            if (this.aXm.size() > 0) {
                JSONArray optJSONArray2 = jSONObject.optJSONArray("point_des");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject jSONObject3 = optJSONArray2.getJSONObject(i2);
                        l lVar = new l();
                        lVar.fS(jSONObject3.toString());
                        if (this.aXp == null) {
                            this.aXp = new ArrayList();
                        }
                        this.aXp.add(lVar);
                    }
                }
                return isValid();
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public String EN() {
        if (ListUtils.isEmpty(this.aXp)) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        SparseArray sparseArray = new SparseArray();
        for (int i = 0; i < this.aXp.size(); i++) {
            int giftId = this.aXp.get(i).getGiftId();
            int ER = this.aXp.get(i).ER();
            sparseArray.put(giftId, Integer.valueOf(sparseArray.get(giftId) != null ? ((Integer) sparseArray.get(giftId)).intValue() + ER : ER));
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
    /* renamed from: EO */
    public k clone() {
        try {
            return (k) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean isValid() {
        return !ListUtils.isEmpty(this.aXm) && this.aXe > 0 && this.aXf > 0 && this.aXl > 0;
    }
}
