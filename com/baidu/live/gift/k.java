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
    public int aUc;
    public int aUd;
    public int aUe;
    public int aUf;
    public int aUg;
    public int aUh;
    public int aUi;
    public int aUj;
    public int aUl;
    public List<PointF> aUk = new ArrayList();
    public Rect aUm = new Rect();
    public List<l> aUn = new ArrayList();

    public String Gb() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", String.valueOf(this.aUc));
            jSONObject2.put("height", String.valueOf(this.aUd));
            jSONObject.put("screen_size", jSONObject2);
            jSONObject.put("ani_type", String.valueOf(this.aUi));
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("x", String.valueOf(this.aUe));
            jSONObject3.put("y", String.valueOf(this.aUf));
            jSONObject3.put("width", String.valueOf(this.aUg));
            jSONObject3.put("height", String.valueOf(this.aUh));
            jSONObject.put("draw_rect", jSONObject3);
            jSONObject.put("point_count", this.aUl);
            JSONArray jSONArray = new JSONArray();
            DecimalFormat decimalFormat = new DecimalFormat(".0");
            for (int i = 0; i < this.aUk.size(); i++) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("x", decimalFormat.format(this.aUk.get(i).x));
                jSONObject4.put("y", decimalFormat.format(this.aUk.get(i).y));
                jSONArray.put(jSONObject4);
            }
            jSONObject.put("point_data", jSONArray);
            jSONObject.put("point_size", this.aUj);
            if (!ListUtils.isEmpty(this.aUn)) {
                JSONArray jSONArray2 = new JSONArray();
                for (int i2 = 0; i2 < this.aUn.size(); i2++) {
                    jSONArray2.put(new JSONObject(this.aUn.get(i2).Gb()));
                }
                jSONObject.put("point_des", jSONArray2);
            }
            return jSONObject.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean gD(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.aUi = JavaTypesHelper.toInt(jSONObject.optString("ani_type"), 0);
            this.aUj = jSONObject.optInt("point_size");
            JSONObject optJSONObject = jSONObject.optJSONObject("screen_size");
            this.aUc = JavaTypesHelper.toInt(optJSONObject.optString("width"), 0);
            this.aUd = JavaTypesHelper.toInt(optJSONObject.optString("height"), 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("draw_rect");
            this.aUe = JavaTypesHelper.toInt(optJSONObject2.optString("x"), 0);
            this.aUf = JavaTypesHelper.toInt(optJSONObject2.optString("y"), 0);
            this.aUg = JavaTypesHelper.toInt(optJSONObject2.optString("width"), 0);
            this.aUh = JavaTypesHelper.toInt(optJSONObject2.optString("height"), 0);
            this.aUm.left = this.aUe;
            this.aUm.top = this.aUf;
            this.aUm.right = this.aUg;
            this.aUm.bottom = this.aUh + this.aUf;
            this.aUl = JavaTypesHelper.toInt("point_count", 0);
            JSONArray optJSONArray = jSONObject.optJSONArray("point_data");
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                this.aUk.add(new PointF(JavaTypesHelper.toFloat(jSONObject2.optString("x"), 0.0f), JavaTypesHelper.toFloat(jSONObject2.optString("y"), 0.0f)));
            }
            if (this.aUk.size() > 0) {
                JSONArray optJSONArray2 = jSONObject.optJSONArray("point_des");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject jSONObject3 = optJSONArray2.getJSONObject(i2);
                        l lVar = new l();
                        lVar.gD(jSONObject3.toString());
                        if (this.aUn == null) {
                            this.aUn = new ArrayList();
                        }
                        this.aUn.add(lVar);
                    }
                }
                return isValid();
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public String Gc() {
        if (ListUtils.isEmpty(this.aUn)) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        SparseArray sparseArray = new SparseArray();
        for (int i = 0; i < this.aUn.size(); i++) {
            int giftId = this.aUn.get(i).getGiftId();
            int Gg = this.aUn.get(i).Gg();
            sparseArray.put(giftId, Integer.valueOf(sparseArray.get(giftId) != null ? ((Integer) sparseArray.get(giftId)).intValue() + Gg : Gg));
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
    /* renamed from: Gd */
    public k clone() {
        try {
            return (k) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean isValid() {
        return !ListUtils.isEmpty(this.aUk) && this.aUc > 0 && this.aUd > 0 && this.aUj > 0;
    }
}
