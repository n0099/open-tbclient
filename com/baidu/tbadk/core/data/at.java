package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.PbPresent;
import tbclient.PbPresentList;
/* loaded from: classes.dex */
public class at {
    private int Wp;
    private ArrayList<a> Wq;

    /* loaded from: classes.dex */
    public static class a {
        public String Vm;
        public int giftId;
        public String giftName;
        public int num;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Wp = jSONObject.optInt(IntentConfig.TOTAL, 0);
                JSONArray jSONArray = jSONObject.getJSONArray(IntentConfig.LIST);
                if (jSONArray != null && jSONArray.length() > 0) {
                    this.Wq = new ArrayList<>();
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        if (jSONObject2 != null) {
                            a aVar = new a();
                            aVar.giftId = jSONObject2.optInt("gift_id", 0);
                            aVar.giftName = jSONObject2.optString("gift_name");
                            aVar.Vm = jSONObject2.optString("thumbnail_url");
                            aVar.num = jSONObject2.optInt("num", 0);
                            this.Wq.add(aVar);
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
            this.Wp = pbPresent.total.intValue();
            if (pbPresent.list != null && pbPresent.list.size() > 0) {
                this.Wq = new ArrayList<>();
                for (PbPresentList pbPresentList : pbPresent.list) {
                    if (pbPresentList != null) {
                        a aVar = new a();
                        aVar.giftId = pbPresentList.gift_id.intValue();
                        aVar.giftName = pbPresentList.gift_name;
                        aVar.Vm = pbPresentList.thumbnail_url;
                        aVar.num = pbPresentList.num.intValue();
                        this.Wq.add(aVar);
                    }
                }
            }
        }
    }

    public int qs() {
        return this.Wp;
    }

    public void bM(int i) {
        this.Wp = i;
    }

    public ArrayList<a> qt() {
        return this.Wq;
    }

    public void g(ArrayList<a> arrayList) {
        this.Wq = arrayList;
    }
}
