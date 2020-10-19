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
    public int aTA;
    public int aTB;
    public int aTC;
    public int aTD;
    public int aTE;
    public int aTF;
    public int aTG;
    public int aTI;
    public int aTz;
    public List<PointF> aTH = new ArrayList();
    public Rect aTJ = new Rect();
    public List<m> aTK = new ArrayList();

    public String FU() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", String.valueOf(this.aTz));
            jSONObject2.put("height", String.valueOf(this.aTA));
            jSONObject.put("screen_size", jSONObject2);
            jSONObject.put("ani_type", String.valueOf(this.aTF));
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("x", String.valueOf(this.aTB));
            jSONObject3.put("y", String.valueOf(this.aTC));
            jSONObject3.put("width", String.valueOf(this.aTD));
            jSONObject3.put("height", String.valueOf(this.aTE));
            jSONObject.put("draw_rect", jSONObject3);
            jSONObject.put("point_count", this.aTI);
            JSONArray jSONArray = new JSONArray();
            DecimalFormat decimalFormat = new DecimalFormat(".0");
            for (int i = 0; i < this.aTH.size(); i++) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("x", decimalFormat.format(this.aTH.get(i).x));
                jSONObject4.put("y", decimalFormat.format(this.aTH.get(i).y));
                jSONArray.put(jSONObject4);
            }
            jSONObject.put("point_data", jSONArray);
            jSONObject.put("point_size", this.aTG);
            if (!ListUtils.isEmpty(this.aTK)) {
                JSONArray jSONArray2 = new JSONArray();
                for (int i2 = 0; i2 < this.aTK.size(); i2++) {
                    jSONArray2.put(new JSONObject(this.aTK.get(i2).FU()));
                }
                jSONObject.put("point_des", jSONArray2);
            }
            return jSONObject.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean gA(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.aTF = JavaTypesHelper.toInt(jSONObject.optString("ani_type"), 0);
            this.aTG = jSONObject.optInt("point_size");
            JSONObject optJSONObject = jSONObject.optJSONObject("screen_size");
            this.aTz = JavaTypesHelper.toInt(optJSONObject.optString("width"), 0);
            this.aTA = JavaTypesHelper.toInt(optJSONObject.optString("height"), 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("draw_rect");
            this.aTB = JavaTypesHelper.toInt(optJSONObject2.optString("x"), 0);
            this.aTC = JavaTypesHelper.toInt(optJSONObject2.optString("y"), 0);
            this.aTD = JavaTypesHelper.toInt(optJSONObject2.optString("width"), 0);
            this.aTE = JavaTypesHelper.toInt(optJSONObject2.optString("height"), 0);
            this.aTJ.left = this.aTB;
            this.aTJ.top = this.aTC;
            this.aTJ.right = this.aTD;
            this.aTJ.bottom = this.aTE + this.aTC;
            this.aTI = JavaTypesHelper.toInt("point_count", 0);
            JSONArray optJSONArray = jSONObject.optJSONArray("point_data");
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                this.aTH.add(new PointF(JavaTypesHelper.toFloat(jSONObject2.optString("x"), 0.0f), JavaTypesHelper.toFloat(jSONObject2.optString("y"), 0.0f)));
            }
            if (this.aTH.size() > 0) {
                JSONArray optJSONArray2 = jSONObject.optJSONArray("point_des");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject jSONObject3 = optJSONArray2.getJSONObject(i2);
                        m mVar = new m();
                        mVar.gA(jSONObject3.toString());
                        if (this.aTK == null) {
                            this.aTK = new ArrayList();
                        }
                        this.aTK.add(mVar);
                    }
                }
                return isValid();
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public String FV() {
        if (ListUtils.isEmpty(this.aTK)) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        SparseArray sparseArray = new SparseArray();
        for (int i = 0; i < this.aTK.size(); i++) {
            int giftId = this.aTK.get(i).getGiftId();
            int FZ = this.aTK.get(i).FZ();
            sparseArray.put(giftId, Integer.valueOf(sparseArray.get(giftId) != null ? ((Integer) sparseArray.get(giftId)).intValue() + FZ : FZ));
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
    /* renamed from: FW */
    public l clone() {
        try {
            return (l) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean isValid() {
        return !ListUtils.isEmpty(this.aTH) && this.aTz > 0 && this.aTA > 0 && this.aTG > 0;
    }
}
