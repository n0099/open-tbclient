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
    public int afc;
    public int afd;
    public int afe;
    public int aff;
    public int afg;
    public int afh;
    public int afi;
    public int afj;
    public int afl;
    public List<PointF> afk = new ArrayList();
    public Rect afm = new Rect();
    public List<m> afn = new ArrayList();

    public String rn() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", String.valueOf(this.afc));
            jSONObject2.put("height", String.valueOf(this.afd));
            jSONObject.put("screen_size", jSONObject2);
            jSONObject.put("ani_type", String.valueOf(this.afi));
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(Config.EVENT_HEAT_X, String.valueOf(this.afe));
            jSONObject3.put("y", String.valueOf(this.aff));
            jSONObject3.put("width", String.valueOf(this.afg));
            jSONObject3.put("height", String.valueOf(this.afh));
            jSONObject.put("draw_rect", jSONObject3);
            jSONObject.put("point_count", this.afl);
            JSONArray jSONArray = new JSONArray();
            DecimalFormat decimalFormat = new DecimalFormat(".0");
            for (int i = 0; i < this.afk.size(); i++) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(Config.EVENT_HEAT_X, decimalFormat.format(this.afk.get(i).x));
                jSONObject4.put("y", decimalFormat.format(this.afk.get(i).y));
                jSONArray.put(jSONObject4);
            }
            jSONObject.put("point_data", jSONArray);
            jSONObject.put("point_size", this.afj);
            if (!ListUtils.isEmpty(this.afn)) {
                JSONArray jSONArray2 = new JSONArray();
                for (int i2 = 0; i2 < this.afn.size(); i2++) {
                    jSONArray2.put(new JSONObject(this.afn.get(i2).rn()));
                }
                jSONObject.put("point_des", jSONArray2);
            }
            return jSONObject.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean cZ(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.afi = JavaTypesHelper.toInt(jSONObject.optString("ani_type"), 0);
            this.afj = jSONObject.optInt("point_size");
            JSONObject optJSONObject = jSONObject.optJSONObject("screen_size");
            this.afc = JavaTypesHelper.toInt(optJSONObject.optString("width"), 0);
            this.afd = JavaTypesHelper.toInt(optJSONObject.optString("height"), 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("draw_rect");
            this.afe = JavaTypesHelper.toInt(optJSONObject2.optString(Config.EVENT_HEAT_X), 0);
            this.aff = JavaTypesHelper.toInt(optJSONObject2.optString("y"), 0);
            this.afg = JavaTypesHelper.toInt(optJSONObject2.optString("width"), 0);
            this.afh = JavaTypesHelper.toInt(optJSONObject2.optString("height"), 0);
            this.afm.left = this.afe;
            this.afm.top = this.aff;
            this.afm.right = this.afg;
            this.afm.bottom = this.afh + this.aff;
            this.afl = JavaTypesHelper.toInt("point_count", 0);
            JSONArray optJSONArray = jSONObject.optJSONArray("point_data");
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                this.afk.add(new PointF(JavaTypesHelper.toFloat(jSONObject2.optString(Config.EVENT_HEAT_X), 0.0f), JavaTypesHelper.toFloat(jSONObject2.optString("y"), 0.0f)));
            }
            if (this.afk.size() > 0) {
                JSONArray optJSONArray2 = jSONObject.optJSONArray("point_des");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject jSONObject3 = optJSONArray2.getJSONObject(i2);
                        m mVar = new m();
                        mVar.cZ(jSONObject3.toString());
                        if (this.afn == null) {
                            this.afn = new ArrayList();
                        }
                        this.afn.add(mVar);
                    }
                }
                return isValid();
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public String ro() {
        if (ListUtils.isEmpty(this.afn)) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        SparseArray sparseArray = new SparseArray();
        for (int i = 0; i < this.afn.size(); i++) {
            int giftId = this.afn.get(i).getGiftId();
            int rs = this.afn.get(i).rs();
            sparseArray.put(giftId, Integer.valueOf(sparseArray.get(giftId) != null ? ((Integer) sparseArray.get(giftId)).intValue() + rs : rs));
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
    /* renamed from: rp */
    public l clone() {
        try {
            return (l) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean isValid() {
        return !ListUtils.isEmpty(this.afk) && this.afc > 0 && this.afd > 0 && this.afj > 0;
    }
}
