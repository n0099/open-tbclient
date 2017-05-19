package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.PbPresent;
import tbclient.PbPresentList;
/* loaded from: classes.dex */
public class ar {
    private int Wu;
    private ArrayList<a> Wv;

    /* loaded from: classes.dex */
    public static class a {
        public String Vz;
        public int giftId;
        public String giftName;
        public int num;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Wu = jSONObject.optInt(IntentConfig.TOTAL, 0);
                JSONArray jSONArray = jSONObject.getJSONArray(IntentConfig.LIST);
                if (jSONArray != null && jSONArray.length() > 0) {
                    this.Wv = new ArrayList<>();
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        if (jSONObject2 != null) {
                            a aVar = new a();
                            aVar.giftId = jSONObject2.optInt("gift_id", 0);
                            aVar.giftName = jSONObject2.optString("gift_name");
                            aVar.Vz = jSONObject2.optString("thumbnail_url");
                            aVar.num = jSONObject2.optInt("num", 0);
                            this.Wv.add(aVar);
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
            this.Wu = pbPresent.total.intValue();
            if (pbPresent.list != null && pbPresent.list.size() > 0) {
                this.Wv = new ArrayList<>();
                for (PbPresentList pbPresentList : pbPresent.list) {
                    if (pbPresentList != null) {
                        a aVar = new a();
                        aVar.giftId = pbPresentList.gift_id.intValue();
                        aVar.giftName = pbPresentList.gift_name;
                        aVar.Vz = pbPresentList.thumbnail_url;
                        aVar.num = pbPresentList.num.intValue();
                        this.Wv.add(aVar);
                    }
                }
            }
        }
    }

    public int qz() {
        return this.Wu;
    }

    public void bL(int i) {
        this.Wu = i;
    }

    public ArrayList<a> qA() {
        return this.Wv;
    }

    public void g(ArrayList<a> arrayList) {
        this.Wv = arrayList;
    }
}
