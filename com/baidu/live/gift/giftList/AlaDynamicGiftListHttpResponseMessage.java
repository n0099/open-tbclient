package com.baidu.live.gift.giftList;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.c;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.utils.k;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaDynamicGiftListHttpResponseMessage extends JsonHttpResponsedMessage {
    private ArrayList<com.baidu.live.gift.b> amQ;

    public AlaDynamicGiftListHttpResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1021089) {
            super.decodeLogicInBackGround(i, jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.amQ = r(optJSONObject);
                if (this.amQ.size() <= 0) {
                    com.baidu.live.gift.b.a.ux();
                    c.pw().putString("dynamic_cache_data_list", "");
                    return;
                }
                dA(c.pw().getSharedPreferences().getString("dynamic_cache_data_list", ""));
                c.pw().putString("dynamic_cache_data_list", optJSONObject.toString());
                uu();
            }
        }
    }

    private void dA(String str) {
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
                    if (bVar != null && bVar.afT != null && !TextUtils.isEmpty(bVar.afT.zipName)) {
                        com.baidu.live.gift.b.a.dF(bVar.afT.zipName);
                    }
                }
            }
        }
    }

    private void uu() {
        if (!BdNetTypeUtil.isMobileNet() || !k.Bh()) {
            for (int i = 0; i < this.amQ.size(); i++) {
                com.baidu.live.gift.b bVar = this.amQ.get(i);
                if (bVar.afT != null && bVar.afT.rm()) {
                    com.baidu.live.gift.b.a.a(bVar, false);
                }
            }
        }
    }

    private boolean a(com.baidu.live.gift.b bVar) {
        if (bVar == null || bVar.afT == null) {
            return false;
        }
        if (TextUtils.isEmpty(bVar.afT.videoMd5) && TextUtils.isEmpty(bVar.afT.zipMD5)) {
            return false;
        }
        for (int i = 0; i < this.amQ.size(); i++) {
            com.baidu.live.gift.b bVar2 = this.amQ.get(i);
            if ((!TextUtils.isEmpty(bVar2.afT.videoMd5) && bVar2.afT.videoMd5.equals(bVar.afT.videoMd5)) || (!TextUtils.isEmpty(bVar2.afT.zipMD5) && bVar2.afT.zipMD5.equals(bVar.afT.zipMD5))) {
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

    public ArrayList<com.baidu.live.gift.b> uv() {
        return this.amQ;
    }
}
