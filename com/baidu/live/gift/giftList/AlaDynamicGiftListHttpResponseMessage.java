package com.baidu.live.gift.giftList;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AlaDynamicGiftListHttpResponseMessage extends JsonHttpResponsedMessage {
    private ArrayList<com.baidu.live.gift.b> acd;

    public AlaDynamicGiftListHttpResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1021089) {
            super.decodeLogicInBackGround(i, jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.acd = u(optJSONObject);
                if (this.acd.size() <= 0) {
                    com.baidu.live.gift.b.a.ra();
                    com.baidu.live.c.np().putString("dynamic_cache_data_list", "");
                    return;
                }
                cx(com.baidu.live.c.np().getSharedPreferences().getString("dynamic_cache_data_list", ""));
                com.baidu.live.c.np().putString("dynamic_cache_data_list", optJSONObject.toString());
                qV();
            }
        }
    }

    private void cx(String str) {
        ArrayList<com.baidu.live.gift.b> arrayList;
        if (!TextUtils.isEmpty(str)) {
            try {
                arrayList = u(new JSONObject(str));
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
                    if (bVar != null && bVar.Wk != null && !TextUtils.isEmpty(bVar.Wk.zipName)) {
                        com.baidu.live.gift.b.a.cA(bVar.Wk.zipName);
                    }
                }
            }
        }
    }

    private void qV() {
        for (int i = 0; i < this.acd.size(); i++) {
            com.baidu.live.gift.b bVar = this.acd.get(i);
            if (bVar.Wk != null) {
                com.baidu.live.gift.b.a.b(bVar.giftId, bVar.Wk.zipDownloadUrl, bVar.Wk.zipName, bVar.Wk.zipMD5, false);
            }
        }
    }

    private boolean a(com.baidu.live.gift.b bVar) {
        if (bVar == null || bVar.Wk == null || StringUtils.isNull(bVar.Wk.zipMD5)) {
            return false;
        }
        for (int i = 0; i < this.acd.size(); i++) {
            if (this.acd.get(i).Wk.zipMD5.equals(bVar.Wk.zipMD5)) {
                return true;
            }
        }
        return false;
    }

    private ArrayList<com.baidu.live.gift.b> u(JSONObject jSONObject) throws Exception {
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

    public ArrayList<com.baidu.live.gift.b> qW() {
        return this.acd;
    }
}
