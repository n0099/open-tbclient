package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.tbadk.switchs.EcommSwitchStatic;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class DealInfoIMData implements Serializable {
    private static final long serialVersionUID = 8595970557328727522L;
    public int count;
    public String orderId;
    public long productId;
    public float shipFee;
    public String title;
    public float totalCost;
    public String url;

    public static DealInfoIMData parseData(String str) {
        if (str == null || (TextUtils.isEmpty(str) && !EcommSwitchStatic.Fr())) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            DealInfoIMData dealInfoIMData = new DealInfoIMData();
            dealInfoIMData.productId = jSONObject.getLong("productId");
            dealInfoIMData.title = jSONObject.getString("title");
            dealInfoIMData.shipFee = (float) jSONObject.getDouble("shipFee");
            dealInfoIMData.url = jSONObject.getString("url");
            dealInfoIMData.count = jSONObject.getInt("count");
            dealInfoIMData.totalCost = (float) jSONObject.getDouble("totalCost");
            dealInfoIMData.orderId = jSONObject.getString("orderId");
            return dealInfoIMData;
        } catch (Exception e) {
            return null;
        }
    }

    public String toJSONString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("productId", this.productId);
            jSONObject.put("title", this.title);
            jSONObject.put("shipFee", this.shipFee);
            jSONObject.put("url", this.url);
            jSONObject.put("count", this.count);
            jSONObject.put("totalCost", this.totalCost);
            jSONObject.put("orderId", this.orderId);
            return jSONObject.toString();
        } catch (Exception e) {
            return null;
        }
    }
}
