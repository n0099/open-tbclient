package com.baidu.tbadk.core.data;

import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import com.baidu.tbadk.switchs.EcommSwitchStatic;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class al {
    public List<a> Ph;
    public int Pi;
    public long Pj;
    public String Pk;
    public boolean Pl;
    public boolean Pm = false;
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
        public String Pn;
        public String Po;
    }

    public void h(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject != null || EcommSwitchStatic.Fq()) {
            this.id = jSONObject.optLong("product_id");
            this.title = jSONObject.optString("title");
            this.info = jSONObject.optString("intro");
            this.unitPrice = ((float) jSONObject.optLong("unit_price")) / 100.0f;
            this.Pi = jSONObject.optInt("stock");
            this.shipFee = ((float) jSONObject.optLong("ship_fee")) / 100.0f;
            this.sales = jSONObject.optLong("sales");
            this.status = jSONObject.optInt("status");
            this.Pj = jSONObject.optInt("category_id");
            this.Pk = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
            if (jSONObject.has("is_display")) {
                this.isDisplay = jSONObject.optInt("is_display", 0) == 1;
                this.Pm = this.isDisplay;
            }
            this.Ph = new ArrayList();
            if (jSONObject.has("img") && !jSONObject.isNull("img") && (optJSONArray = jSONObject.optJSONArray("img")) != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    a aVar = new a();
                    aVar.Pn = optJSONObject.optString("small_pic");
                    aVar.Po = optJSONObject.optString("big_pic");
                    this.Ph.add(aVar);
                }
            }
        }
    }
}
