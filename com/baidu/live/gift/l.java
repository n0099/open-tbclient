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
    public int azN;
    public int azO;
    public int azP;
    public int azQ;
    public int azR;
    public int azS;
    public int azT;
    public int azU;
    public int azW;
    public List<PointF> azV = new ArrayList();
    public Rect azX = new Rect();
    public List<m> azY = new ArrayList();

    public String wM() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", String.valueOf(this.azN));
            jSONObject2.put("height", String.valueOf(this.azO));
            jSONObject.put("screen_size", jSONObject2);
            jSONObject.put("ani_type", String.valueOf(this.azT));
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(Config.EVENT_HEAT_X, String.valueOf(this.azP));
            jSONObject3.put("y", String.valueOf(this.azQ));
            jSONObject3.put("width", String.valueOf(this.azR));
            jSONObject3.put("height", String.valueOf(this.azS));
            jSONObject.put("draw_rect", jSONObject3);
            jSONObject.put("point_count", this.azW);
            JSONArray jSONArray = new JSONArray();
            DecimalFormat decimalFormat = new DecimalFormat(".0");
            for (int i = 0; i < this.azV.size(); i++) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(Config.EVENT_HEAT_X, decimalFormat.format(this.azV.get(i).x));
                jSONObject4.put("y", decimalFormat.format(this.azV.get(i).y));
                jSONArray.put(jSONObject4);
            }
            jSONObject.put("point_data", jSONArray);
            jSONObject.put("point_size", this.azU);
            if (!ListUtils.isEmpty(this.azY)) {
                JSONArray jSONArray2 = new JSONArray();
                for (int i2 = 0; i2 < this.azY.size(); i2++) {
                    jSONArray2.put(new JSONObject(this.azY.get(i2).wM()));
                }
                jSONObject.put("point_des", jSONArray2);
            }
            return jSONObject.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean dY(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.azT = JavaTypesHelper.toInt(jSONObject.optString("ani_type"), 0);
            this.azU = jSONObject.optInt("point_size");
            JSONObject optJSONObject = jSONObject.optJSONObject("screen_size");
            this.azN = JavaTypesHelper.toInt(optJSONObject.optString("width"), 0);
            this.azO = JavaTypesHelper.toInt(optJSONObject.optString("height"), 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("draw_rect");
            this.azP = JavaTypesHelper.toInt(optJSONObject2.optString(Config.EVENT_HEAT_X), 0);
            this.azQ = JavaTypesHelper.toInt(optJSONObject2.optString("y"), 0);
            this.azR = JavaTypesHelper.toInt(optJSONObject2.optString("width"), 0);
            this.azS = JavaTypesHelper.toInt(optJSONObject2.optString("height"), 0);
            this.azX.left = this.azP;
            this.azX.top = this.azQ;
            this.azX.right = this.azR;
            this.azX.bottom = this.azS + this.azQ;
            this.azW = JavaTypesHelper.toInt("point_count", 0);
            JSONArray optJSONArray = jSONObject.optJSONArray("point_data");
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                this.azV.add(new PointF(JavaTypesHelper.toFloat(jSONObject2.optString(Config.EVENT_HEAT_X), 0.0f), JavaTypesHelper.toFloat(jSONObject2.optString("y"), 0.0f)));
            }
            if (this.azV.size() > 0) {
                JSONArray optJSONArray2 = jSONObject.optJSONArray("point_des");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject jSONObject3 = optJSONArray2.getJSONObject(i2);
                        m mVar = new m();
                        mVar.dY(jSONObject3.toString());
                        if (this.azY == null) {
                            this.azY = new ArrayList();
                        }
                        this.azY.add(mVar);
                    }
                }
                return isValid();
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public String wN() {
        if (ListUtils.isEmpty(this.azY)) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        SparseArray sparseArray = new SparseArray();
        for (int i = 0; i < this.azY.size(); i++) {
            int giftId = this.azY.get(i).getGiftId();
            int wR = this.azY.get(i).wR();
            sparseArray.put(giftId, Integer.valueOf(sparseArray.get(giftId) != null ? ((Integer) sparseArray.get(giftId)).intValue() + wR : wR));
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
    /* renamed from: wO */
    public l clone() {
        try {
            return (l) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean isValid() {
        return !ListUtils.isEmpty(this.azV) && this.azN > 0 && this.azO > 0 && this.azU > 0;
    }
}
