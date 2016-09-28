package com.baidu.tbadk.core.data;

import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.tbadk.switchs.EcommSwitchStatic;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class au {
    public boolean SA;
    public boolean SB = false;
    public List<a> Sv;
    public int Sw;
    public String Sx;
    public long Sy;
    public String Sz;
    public long id;
    public String info;
    public boolean isDisplay;
    public long sales;
    public float shipFee;
    public int status;
    public String title;
    public float unitPrice;

    /* loaded from: classes.dex */
    public static final class a {
        public String SC;
        public String SD;
    }

    public void j(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject != null || EcommSwitchStatic.GK()) {
            this.id = jSONObject.optLong("product_id");
            this.title = jSONObject.optString(VrPlayerActivityConfig.TITLE);
            this.info = jSONObject.optString("intro");
            this.unitPrice = ((float) jSONObject.optLong("unit_price")) / 100.0f;
            this.Sw = jSONObject.optInt("stock");
            this.shipFee = ((float) jSONObject.optLong("ship_fee")) / 100.0f;
            this.sales = jSONObject.optLong("sales");
            this.status = jSONObject.optInt("status");
            this.Sx = jSONObject.optString("reason");
            this.Sy = jSONObject.optInt("category_id");
            this.Sz = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
            if (jSONObject.has("is_display")) {
                this.isDisplay = jSONObject.optInt("is_display", 0) == 1;
                this.SB = this.isDisplay;
            }
            this.Sv = new ArrayList();
            if (jSONObject.has("img") && !jSONObject.isNull("img") && (optJSONArray = jSONObject.optJSONArray("img")) != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    a aVar = new a();
                    aVar.SC = optJSONObject.optString("small_pic");
                    aVar.SD = optJSONObject.optString("big_pic");
                    this.Sv.add(aVar);
                }
            }
        }
    }
}
