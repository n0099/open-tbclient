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
    private ArrayList<com.baidu.live.gift.b> abL;

    public AlaDynamicGiftListHttpResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1021089) {
            super.decodeLogicInBackGround(i, jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.abL = v(optJSONObject);
                if (this.abL.size() <= 0) {
                    com.baidu.live.gift.b.a.rb();
                    com.baidu.live.c.np().putString("dynamic_cache_data_list", "");
                    return;
                }
                cx(com.baidu.live.c.np().getSharedPreferences().getString("dynamic_cache_data_list", ""));
                com.baidu.live.c.np().putString("dynamic_cache_data_list", optJSONObject.toString());
                qW();
            }
        }
    }

    private void cx(String str) {
        ArrayList<com.baidu.live.gift.b> arrayList;
        if (!TextUtils.isEmpty(str)) {
            try {
                arrayList = v(new JSONObject(str));
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
                    if (bVar != null && bVar.VR != null && !TextUtils.isEmpty(bVar.VR.zipName)) {
                        com.baidu.live.gift.b.a.cA(bVar.VR.zipName);
                    }
                }
            }
        }
    }

    private void qW() {
        for (int i = 0; i < this.abL.size(); i++) {
            com.baidu.live.gift.b bVar = this.abL.get(i);
            if (bVar.VR != null) {
                com.baidu.live.gift.b.a.b(bVar.giftId, bVar.VR.zipDownloadUrl, bVar.VR.zipName, bVar.VR.zipMD5, false);
            }
        }
    }

    private boolean a(com.baidu.live.gift.b bVar) {
        if (bVar == null || bVar.VR == null || StringUtils.isNull(bVar.VR.zipMD5)) {
            return false;
        }
        for (int i = 0; i < this.abL.size(); i++) {
            if (this.abL.get(i).VR.zipMD5.equals(bVar.VR.zipMD5)) {
                return true;
            }
        }
        return false;
    }

    private ArrayList<com.baidu.live.gift.b> v(JSONObject jSONObject) throws Exception {
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

    public ArrayList<com.baidu.live.gift.b> qX() {
        return this.abL;
    }
}
