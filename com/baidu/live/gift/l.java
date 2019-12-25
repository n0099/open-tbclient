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
/* loaded from: classes2.dex */
public class l implements Cloneable {
    public int aeA;
    public int aeC;
    public int aet;
    public int aeu;
    public int aev;
    public int aew;
    public int aex;
    public int aey;
    public int aez;
    public List<PointF> aeB = new ArrayList();
    public Rect aeD = new Rect();
    public List<m> aeE = new ArrayList();

    public String rb() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", String.valueOf(this.aet));
            jSONObject2.put("height", String.valueOf(this.aeu));
            jSONObject.put("screen_size", jSONObject2);
            jSONObject.put("ani_type", String.valueOf(this.aez));
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(Config.EVENT_HEAT_X, String.valueOf(this.aev));
            jSONObject3.put("y", String.valueOf(this.aew));
            jSONObject3.put("width", String.valueOf(this.aex));
            jSONObject3.put("height", String.valueOf(this.aey));
            jSONObject.put("draw_rect", jSONObject3);
            jSONObject.put("point_count", this.aeC);
            JSONArray jSONArray = new JSONArray();
            DecimalFormat decimalFormat = new DecimalFormat(".0");
            for (int i = 0; i < this.aeB.size(); i++) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(Config.EVENT_HEAT_X, decimalFormat.format(this.aeB.get(i).x));
                jSONObject4.put("y", decimalFormat.format(this.aeB.get(i).y));
                jSONArray.put(jSONObject4);
            }
            jSONObject.put("point_data", jSONArray);
            jSONObject.put("point_size", this.aeA);
            if (!ListUtils.isEmpty(this.aeE)) {
                JSONArray jSONArray2 = new JSONArray();
                for (int i2 = 0; i2 < this.aeE.size(); i2++) {
                    jSONArray2.put(new JSONObject(this.aeE.get(i2).rb()));
                }
                jSONObject.put("point_des", jSONArray2);
            }
            return jSONObject.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean cX(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.aez = JavaTypesHelper.toInt(jSONObject.optString("ani_type"), 0);
            this.aeA = jSONObject.optInt("point_size");
            JSONObject optJSONObject = jSONObject.optJSONObject("screen_size");
            this.aet = JavaTypesHelper.toInt(optJSONObject.optString("width"), 0);
            this.aeu = JavaTypesHelper.toInt(optJSONObject.optString("height"), 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("draw_rect");
            this.aev = JavaTypesHelper.toInt(optJSONObject2.optString(Config.EVENT_HEAT_X), 0);
            this.aew = JavaTypesHelper.toInt(optJSONObject2.optString("y"), 0);
            this.aex = JavaTypesHelper.toInt(optJSONObject2.optString("width"), 0);
            this.aey = JavaTypesHelper.toInt(optJSONObject2.optString("height"), 0);
            this.aeD.left = this.aev;
            this.aeD.top = this.aew;
            this.aeD.right = this.aex;
            this.aeD.bottom = this.aey + this.aew;
            this.aeC = JavaTypesHelper.toInt("point_count", 0);
            JSONArray optJSONArray = jSONObject.optJSONArray("point_data");
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                this.aeB.add(new PointF(JavaTypesHelper.toFloat(jSONObject2.optString(Config.EVENT_HEAT_X), 0.0f), JavaTypesHelper.toFloat(jSONObject2.optString("y"), 0.0f)));
            }
            if (this.aeB.size() > 0) {
                JSONArray optJSONArray2 = jSONObject.optJSONArray("point_des");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject jSONObject3 = optJSONArray2.getJSONObject(i2);
                        m mVar = new m();
                        mVar.cX(jSONObject3.toString());
                        if (this.aeE == null) {
                            this.aeE = new ArrayList();
                        }
                        this.aeE.add(mVar);
                    }
                }
                return isValid();
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public String rc() {
        if (ListUtils.isEmpty(this.aeE)) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        SparseArray sparseArray = new SparseArray();
        for (int i = 0; i < this.aeE.size(); i++) {
            int giftId = this.aeE.get(i).getGiftId();
            int rg = this.aeE.get(i).rg();
            sparseArray.put(giftId, Integer.valueOf(sparseArray.get(giftId) != null ? ((Integer) sparseArray.get(giftId)).intValue() + rg : rg));
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
    /* renamed from: rd */
    public l clone() {
        try {
            return (l) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean isValid() {
        return !ListUtils.isEmpty(this.aeB) && this.aet > 0 && this.aeu > 0 && this.aeA > 0;
    }
}
