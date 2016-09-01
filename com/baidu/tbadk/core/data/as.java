package com.baidu.tbadk.core.data;

import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.tbadk.switchs.EcommSwitchStatic;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class as {
    public List<a> Sp;
    public int Sq;
    public long Sr;
    public String Ss;
    public boolean St;
    public boolean Su = false;
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
        public String Sv;
        public String Sw;
    }

    public void j(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject != null || EcommSwitchStatic.GL()) {
            this.id = jSONObject.optLong("product_id");
            this.title = jSONObject.optString(VrPlayerActivityConfig.TITLE);
            this.info = jSONObject.optString("intro");
            this.unitPrice = ((float) jSONObject.optLong("unit_price")) / 100.0f;
            this.Sq = jSONObject.optInt("stock");
            this.shipFee = ((float) jSONObject.optLong("ship_fee")) / 100.0f;
            this.sales = jSONObject.optLong("sales");
            this.status = jSONObject.optInt("status");
            this.Sr = jSONObject.optInt("category_id");
            this.Ss = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
            if (jSONObject.has("is_display")) {
                this.isDisplay = jSONObject.optInt("is_display", 0) == 1;
                this.Su = this.isDisplay;
            }
            this.Sp = new ArrayList();
            if (jSONObject.has("img") && !jSONObject.isNull("img") && (optJSONArray = jSONObject.optJSONArray("img")) != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    a aVar = new a();
                    aVar.Sv = optJSONObject.optString("small_pic");
                    aVar.Sw = optJSONObject.optString("big_pic");
                    this.Sp.add(aVar);
                }
            }
        }
    }
}
