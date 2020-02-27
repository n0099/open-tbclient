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
    public int ahj;
    public int ahk;
    public int ahl;
    public int ahm;
    public int ahn;
    public int aho;
    public int ahp;
    public int ahq;
    public int ahs;
    public List<PointF> ahr = new ArrayList();
    public Rect aht = new Rect();
    public List<m> ahu = new ArrayList();

    public String so() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", String.valueOf(this.ahj));
            jSONObject2.put("height", String.valueOf(this.ahk));
            jSONObject.put("screen_size", jSONObject2);
            jSONObject.put("ani_type", String.valueOf(this.ahp));
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(Config.EVENT_HEAT_X, String.valueOf(this.ahl));
            jSONObject3.put("y", String.valueOf(this.ahm));
            jSONObject3.put("width", String.valueOf(this.ahn));
            jSONObject3.put("height", String.valueOf(this.aho));
            jSONObject.put("draw_rect", jSONObject3);
            jSONObject.put("point_count", this.ahs);
            JSONArray jSONArray = new JSONArray();
            DecimalFormat decimalFormat = new DecimalFormat(".0");
            for (int i = 0; i < this.ahr.size(); i++) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(Config.EVENT_HEAT_X, decimalFormat.format(this.ahr.get(i).x));
                jSONObject4.put("y", decimalFormat.format(this.ahr.get(i).y));
                jSONArray.put(jSONObject4);
            }
            jSONObject.put("point_data", jSONArray);
            jSONObject.put("point_size", this.ahq);
            if (!ListUtils.isEmpty(this.ahu)) {
                JSONArray jSONArray2 = new JSONArray();
                for (int i2 = 0; i2 < this.ahu.size(); i2++) {
                    jSONArray2.put(new JSONObject(this.ahu.get(i2).so()));
                }
                jSONObject.put("point_des", jSONArray2);
            }
            return jSONObject.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean di(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.ahp = JavaTypesHelper.toInt(jSONObject.optString("ani_type"), 0);
            this.ahq = jSONObject.optInt("point_size");
            JSONObject optJSONObject = jSONObject.optJSONObject("screen_size");
            this.ahj = JavaTypesHelper.toInt(optJSONObject.optString("width"), 0);
            this.ahk = JavaTypesHelper.toInt(optJSONObject.optString("height"), 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("draw_rect");
            this.ahl = JavaTypesHelper.toInt(optJSONObject2.optString(Config.EVENT_HEAT_X), 0);
            this.ahm = JavaTypesHelper.toInt(optJSONObject2.optString("y"), 0);
            this.ahn = JavaTypesHelper.toInt(optJSONObject2.optString("width"), 0);
            this.aho = JavaTypesHelper.toInt(optJSONObject2.optString("height"), 0);
            this.aht.left = this.ahl;
            this.aht.top = this.ahm;
            this.aht.right = this.ahn;
            this.aht.bottom = this.aho + this.ahm;
            this.ahs = JavaTypesHelper.toInt("point_count", 0);
            JSONArray optJSONArray = jSONObject.optJSONArray("point_data");
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                this.ahr.add(new PointF(JavaTypesHelper.toFloat(jSONObject2.optString(Config.EVENT_HEAT_X), 0.0f), JavaTypesHelper.toFloat(jSONObject2.optString("y"), 0.0f)));
            }
            if (this.ahr.size() > 0) {
                JSONArray optJSONArray2 = jSONObject.optJSONArray("point_des");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject jSONObject3 = optJSONArray2.getJSONObject(i2);
                        m mVar = new m();
                        mVar.di(jSONObject3.toString());
                        if (this.ahu == null) {
                            this.ahu = new ArrayList();
                        }
                        this.ahu.add(mVar);
                    }
                }
                return isValid();
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public String sp() {
        if (ListUtils.isEmpty(this.ahu)) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        SparseArray sparseArray = new SparseArray();
        for (int i = 0; i < this.ahu.size(); i++) {
            int giftId = this.ahu.get(i).getGiftId();
            int st = this.ahu.get(i).st();
            sparseArray.put(giftId, Integer.valueOf(sparseArray.get(giftId) != null ? ((Integer) sparseArray.get(giftId)).intValue() + st : st));
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
    /* renamed from: sq */
    public l clone() {
        try {
            return (l) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean isValid() {
        return !ListUtils.isEmpty(this.ahr) && this.ahj > 0 && this.ahk > 0 && this.ahq > 0;
    }
}
