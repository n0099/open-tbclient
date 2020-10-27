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
    public int aUA;
    public int aUB;
    public int aUC;
    public int aUE;
    public int aUv;
    public int aUw;
    public int aUx;
    public int aUy;
    public int aUz;
    public List<PointF> aUD = new ArrayList();
    public Rect aUF = new Rect();
    public List<m> aUG = new ArrayList();

    public String Gj() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", String.valueOf(this.aUv));
            jSONObject2.put("height", String.valueOf(this.aUw));
            jSONObject.put("screen_size", jSONObject2);
            jSONObject.put("ani_type", String.valueOf(this.aUB));
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("x", String.valueOf(this.aUx));
            jSONObject3.put("y", String.valueOf(this.aUy));
            jSONObject3.put("width", String.valueOf(this.aUz));
            jSONObject3.put("height", String.valueOf(this.aUA));
            jSONObject.put("draw_rect", jSONObject3);
            jSONObject.put("point_count", this.aUE);
            JSONArray jSONArray = new JSONArray();
            DecimalFormat decimalFormat = new DecimalFormat(".0");
            for (int i = 0; i < this.aUD.size(); i++) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("x", decimalFormat.format(this.aUD.get(i).x));
                jSONObject4.put("y", decimalFormat.format(this.aUD.get(i).y));
                jSONArray.put(jSONObject4);
            }
            jSONObject.put("point_data", jSONArray);
            jSONObject.put("point_size", this.aUC);
            if (!ListUtils.isEmpty(this.aUG)) {
                JSONArray jSONArray2 = new JSONArray();
                for (int i2 = 0; i2 < this.aUG.size(); i2++) {
                    jSONArray2.put(new JSONObject(this.aUG.get(i2).Gj()));
                }
                jSONObject.put("point_des", jSONArray2);
            }
            return jSONObject.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean gE(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.aUB = JavaTypesHelper.toInt(jSONObject.optString("ani_type"), 0);
            this.aUC = jSONObject.optInt("point_size");
            JSONObject optJSONObject = jSONObject.optJSONObject("screen_size");
            this.aUv = JavaTypesHelper.toInt(optJSONObject.optString("width"), 0);
            this.aUw = JavaTypesHelper.toInt(optJSONObject.optString("height"), 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("draw_rect");
            this.aUx = JavaTypesHelper.toInt(optJSONObject2.optString("x"), 0);
            this.aUy = JavaTypesHelper.toInt(optJSONObject2.optString("y"), 0);
            this.aUz = JavaTypesHelper.toInt(optJSONObject2.optString("width"), 0);
            this.aUA = JavaTypesHelper.toInt(optJSONObject2.optString("height"), 0);
            this.aUF.left = this.aUx;
            this.aUF.top = this.aUy;
            this.aUF.right = this.aUz;
            this.aUF.bottom = this.aUA + this.aUy;
            this.aUE = JavaTypesHelper.toInt("point_count", 0);
            JSONArray optJSONArray = jSONObject.optJSONArray("point_data");
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                this.aUD.add(new PointF(JavaTypesHelper.toFloat(jSONObject2.optString("x"), 0.0f), JavaTypesHelper.toFloat(jSONObject2.optString("y"), 0.0f)));
            }
            if (this.aUD.size() > 0) {
                JSONArray optJSONArray2 = jSONObject.optJSONArray("point_des");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject jSONObject3 = optJSONArray2.getJSONObject(i2);
                        m mVar = new m();
                        mVar.gE(jSONObject3.toString());
                        if (this.aUG == null) {
                            this.aUG = new ArrayList();
                        }
                        this.aUG.add(mVar);
                    }
                }
                return isValid();
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public String Gk() {
        if (ListUtils.isEmpty(this.aUG)) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        SparseArray sparseArray = new SparseArray();
        for (int i = 0; i < this.aUG.size(); i++) {
            int giftId = this.aUG.get(i).getGiftId();
            int Go = this.aUG.get(i).Go();
            sparseArray.put(giftId, Integer.valueOf(sparseArray.get(giftId) != null ? ((Integer) sparseArray.get(giftId)).intValue() + Go : Go));
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
    /* renamed from: Gl */
    public l clone() {
        try {
            return (l) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean isValid() {
        return !ListUtils.isEmpty(this.aUD) && this.aUv > 0 && this.aUw > 0 && this.aUC > 0;
    }
}
