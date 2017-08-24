package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.PbPresent;
import tbclient.PbPresentList;
/* loaded from: classes.dex */
public class as {
    private int Ye;
    private ArrayList<a> Yf;

    /* loaded from: classes.dex */
    public static class a {
        public String Xb;
        public int giftId;
        public String giftName;
        public int num;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Ye = jSONObject.optInt(IntentConfig.TOTAL, 0);
                JSONArray jSONArray = jSONObject.getJSONArray(IntentConfig.LIST);
                if (jSONArray != null && jSONArray.length() > 0) {
                    this.Yf = new ArrayList<>();
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        if (jSONObject2 != null) {
                            a aVar = new a();
                            aVar.giftId = jSONObject2.optInt("gift_id", 0);
                            aVar.giftName = jSONObject2.optString("gift_name");
                            aVar.Xb = jSONObject2.optString("thumbnail_url");
                            aVar.num = jSONObject2.optInt("num", 0);
                            this.Yf.add(aVar);
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(PbPresent pbPresent) {
        if (pbPresent != null) {
            this.Ye = pbPresent.total.intValue();
            if (pbPresent.list != null && pbPresent.list.size() > 0) {
                this.Yf = new ArrayList<>();
                for (PbPresentList pbPresentList : pbPresent.list) {
                    if (pbPresentList != null) {
                        a aVar = new a();
                        aVar.giftId = pbPresentList.gift_id.intValue();
                        aVar.giftName = pbPresentList.gift_name;
                        aVar.Xb = pbPresentList.thumbnail_url;
                        aVar.num = pbPresentList.num.intValue();
                        this.Yf.add(aVar);
                    }
                }
            }
        }
    }

    public int qG() {
        return this.Ye;
    }

    public void bN(int i) {
        this.Ye = i;
    }

    public ArrayList<a> qH() {
        return this.Yf;
    }

    public void g(ArrayList<a> arrayList) {
        this.Yf = arrayList;
    }
}
