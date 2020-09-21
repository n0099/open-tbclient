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
public class l implements Cloneable {
    public int aQo;
    public int aQp;
    public int aQq;
    public int aQr;
    public int aQs;
    public int aQt;
    public int aQu;
    public int aQv;
    public int aQx;
    public List<PointF> aQw = new ArrayList();
    public Rect aQy = new Rect();
    public List<m> aQz = new ArrayList();

    public String EY() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", String.valueOf(this.aQo));
            jSONObject2.put("height", String.valueOf(this.aQp));
            jSONObject.put("screen_size", jSONObject2);
            jSONObject.put("ani_type", String.valueOf(this.aQu));
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("x", String.valueOf(this.aQq));
            jSONObject3.put("y", String.valueOf(this.aQr));
            jSONObject3.put("width", String.valueOf(this.aQs));
            jSONObject3.put("height", String.valueOf(this.aQt));
            jSONObject.put("draw_rect", jSONObject3);
            jSONObject.put("point_count", this.aQx);
            JSONArray jSONArray = new JSONArray();
            DecimalFormat decimalFormat = new DecimalFormat(".0");
            for (int i = 0; i < this.aQw.size(); i++) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("x", decimalFormat.format(this.aQw.get(i).x));
                jSONObject4.put("y", decimalFormat.format(this.aQw.get(i).y));
                jSONArray.put(jSONObject4);
            }
            jSONObject.put("point_data", jSONArray);
            jSONObject.put("point_size", this.aQv);
            if (!ListUtils.isEmpty(this.aQz)) {
                JSONArray jSONArray2 = new JSONArray();
                for (int i2 = 0; i2 < this.aQz.size(); i2++) {
                    jSONArray2.put(new JSONObject(this.aQz.get(i2).EY()));
                }
                jSONObject.put("point_des", jSONArray2);
            }
            return jSONObject.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean gl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.aQu = JavaTypesHelper.toInt(jSONObject.optString("ani_type"), 0);
            this.aQv = jSONObject.optInt("point_size");
            JSONObject optJSONObject = jSONObject.optJSONObject("screen_size");
            this.aQo = JavaTypesHelper.toInt(optJSONObject.optString("width"), 0);
            this.aQp = JavaTypesHelper.toInt(optJSONObject.optString("height"), 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("draw_rect");
            this.aQq = JavaTypesHelper.toInt(optJSONObject2.optString("x"), 0);
            this.aQr = JavaTypesHelper.toInt(optJSONObject2.optString("y"), 0);
            this.aQs = JavaTypesHelper.toInt(optJSONObject2.optString("width"), 0);
            this.aQt = JavaTypesHelper.toInt(optJSONObject2.optString("height"), 0);
            this.aQy.left = this.aQq;
            this.aQy.top = this.aQr;
            this.aQy.right = this.aQs;
            this.aQy.bottom = this.aQt + this.aQr;
            this.aQx = JavaTypesHelper.toInt("point_count", 0);
            JSONArray optJSONArray = jSONObject.optJSONArray("point_data");
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                this.aQw.add(new PointF(JavaTypesHelper.toFloat(jSONObject2.optString("x"), 0.0f), JavaTypesHelper.toFloat(jSONObject2.optString("y"), 0.0f)));
            }
            if (this.aQw.size() > 0) {
                JSONArray optJSONArray2 = jSONObject.optJSONArray("point_des");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject jSONObject3 = optJSONArray2.getJSONObject(i2);
                        m mVar = new m();
                        mVar.gl(jSONObject3.toString());
                        if (this.aQz == null) {
                            this.aQz = new ArrayList();
                        }
                        this.aQz.add(mVar);
                    }
                }
                return isValid();
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public String EZ() {
        if (ListUtils.isEmpty(this.aQz)) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        SparseArray sparseArray = new SparseArray();
        for (int i = 0; i < this.aQz.size(); i++) {
            int giftId = this.aQz.get(i).getGiftId();
            int Fd = this.aQz.get(i).Fd();
            sparseArray.put(giftId, Integer.valueOf(sparseArray.get(giftId) != null ? ((Integer) sparseArray.get(giftId)).intValue() + Fd : Fd));
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
    /* renamed from: Fa */
    public l clone() {
        try {
            return (l) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean isValid() {
        return !ListUtils.isEmpty(this.aQw) && this.aQo > 0 && this.aQp > 0 && this.aQv > 0;
    }
}
