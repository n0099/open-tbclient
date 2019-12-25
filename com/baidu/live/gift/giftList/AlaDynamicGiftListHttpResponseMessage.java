package com.baidu.live.gift.giftList;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.c;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.utils.k;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AlaDynamicGiftListHttpResponseMessage extends JsonHttpResponsedMessage {
    private ArrayList<com.baidu.live.gift.b> ajK;

    public AlaDynamicGiftListHttpResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1021089) {
            super.decodeLogicInBackGround(i, jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.ajK = r(optJSONObject);
                if (this.ajK.size() <= 0) {
                    com.baidu.live.gift.b.a.sI();
                    c.oI().putString("dynamic_cache_data_list", "");
                    return;
                }
                dp(c.oI().getSharedPreferences().getString("dynamic_cache_data_list", ""));
                c.oI().putString("dynamic_cache_data_list", optJSONObject.toString());
                sF();
            }
        }
    }

    private void dp(String str) {
        ArrayList<com.baidu.live.gift.b> arrayList;
        if (!TextUtils.isEmpty(str)) {
            try {
                arrayList = r(new JSONObject(str));
            } catch (Exception e) {
                arrayList = null;
            }
            if (arrayList != null && !ListUtils.isEmpty(arrayList)) {
                ArrayList arrayList2 = new ArrayList();
                for (int i = 0; i < arrayList.size(); i++) {
                    if (!a(arrayList.get(i))) {
                        arrayList2.add(arrayList.get(i));
                    }
                }
                for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                    com.baidu.live.gift.b bVar = (com.baidu.live.gift.b) arrayList2.get(i2);
                    if (bVar != null && bVar.ads != null && !TextUtils.isEmpty(bVar.ads.zipName)) {
                        com.baidu.live.gift.b.a.ds(bVar.ads.zipName);
                    }
                }
            }
        }
    }

    private void sF() {
        if (!BdNetTypeUtil.isMobileNet() || !k.yr()) {
            for (int i = 0; i < this.ajK.size(); i++) {
                com.baidu.live.gift.b bVar = this.ajK.get(i);
                if (bVar.ads != null && bVar.ads.qn()) {
                    com.baidu.live.gift.b.a.b(bVar.giftId, bVar.ads.zipDownloadUrl, bVar.ads.zipName, bVar.ads.zipMD5, false);
                }
            }
        }
    }

    private boolean a(com.baidu.live.gift.b bVar) {
        if (bVar == null || bVar.ads == null || StringUtils.isNull(bVar.ads.zipMD5)) {
            return false;
        }
        for (int i = 0; i < this.ajK.size(); i++) {
            if (this.ajK.get(i).ads.zipMD5.equals(bVar.ads.zipMD5)) {
                return true;
            }
        }
        return false;
    }

    private ArrayList<com.baidu.live.gift.b> r(JSONObject jSONObject) throws Exception {
        ArrayList<com.baidu.live.gift.b> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("dynamic_gift_list");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                com.baidu.live.gift.b bVar = new com.baidu.live.gift.b();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    bVar.parseJson(optJSONObject);
                    arrayList.add(bVar);
                }
            }
        }
        return arrayList;
    }

    public ArrayList<com.baidu.live.gift.b> sG() {
        return this.ajK;
    }
}
