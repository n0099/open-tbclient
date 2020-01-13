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
    private ArrayList<com.baidu.live.gift.b> aku;

    public AlaDynamicGiftListHttpResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1021089) {
            super.decodeLogicInBackGround(i, jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.aku = r(optJSONObject);
                if (this.aku.size() <= 0) {
                    com.baidu.live.gift.b.a.sY();
                    c.oJ().putString("dynamic_cache_data_list", "");
                    return;
                }
                dr(c.oJ().getSharedPreferences().getString("dynamic_cache_data_list", ""));
                c.oJ().putString("dynamic_cache_data_list", optJSONObject.toString());
                sV();
            }
        }
    }

    private void dr(String str) {
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
                    if (bVar != null && bVar.adH != null && !TextUtils.isEmpty(bVar.adH.zipName)) {
                        com.baidu.live.gift.b.a.du(bVar.adH.zipName);
                    }
                }
            }
        }
    }

    private void sV() {
        if (!BdNetTypeUtil.isMobileNet() || !k.yH()) {
            for (int i = 0; i < this.aku.size(); i++) {
                com.baidu.live.gift.b bVar = this.aku.get(i);
                if (bVar.adH != null && bVar.adH.qu()) {
                    com.baidu.live.gift.b.a.b(bVar.giftId, bVar.adH.zipDownloadUrl, bVar.adH.zipName, bVar.adH.zipMD5, false);
                }
            }
        }
    }

    private boolean a(com.baidu.live.gift.b bVar) {
        if (bVar == null || bVar.adH == null || StringUtils.isNull(bVar.adH.zipMD5)) {
            return false;
        }
        for (int i = 0; i < this.aku.size(); i++) {
            if (this.aku.get(i).adH.zipMD5.equals(bVar.adH.zipMD5)) {
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

    public ArrayList<com.baidu.live.gift.b> sW() {
        return this.aku;
    }
}
