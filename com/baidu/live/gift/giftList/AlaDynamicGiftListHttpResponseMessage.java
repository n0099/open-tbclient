package com.baidu.live.gift.giftList;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.utils.k;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaDynamicGiftListHttpResponseMessage extends JsonHttpResponsedMessage {
    private ArrayList<com.baidu.live.gift.b> aKR;
    private JSONObject aKS;

    public AlaDynamicGiftListHttpResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1021089) {
            super.decodeLogicInBackGround(i, jSONObject);
            this.aKS = jSONObject.optJSONObject("data");
            if (this.aKS != null) {
                this.aKR = B(this.aKS);
                if (this.aKR.size() <= 0) {
                    com.baidu.live.gift.b.a.Af();
                    com.baidu.live.c.uN().putString("dynamic_cache_data_list", "");
                    return;
                }
                fd(com.baidu.live.c.uN().getSharedPreferences().getString("dynamic_cache_data_list", ""));
                com.baidu.live.c.uN().putString("dynamic_cache_data_list", this.aKS.toString());
                Ac();
            }
        }
    }

    private void fd(String str) {
        ArrayList<com.baidu.live.gift.b> arrayList;
        if (!TextUtils.isEmpty(str)) {
            try {
                arrayList = B(new JSONObject(str));
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
                    if (bVar != null && bVar.aDI != null && !TextUtils.isEmpty(bVar.aDI.zipName)) {
                        com.baidu.live.gift.b.a.fh(bVar.aDI.zipName);
                    }
                }
            }
        }
    }

    private void Ac() {
        if (!BdNetTypeUtil.isMobileNet() || !k.HX()) {
            for (int i = 0; i < this.aKR.size(); i++) {
                com.baidu.live.gift.b bVar = this.aKR.get(i);
                if (bVar.aDI != null && bVar.aDI.wT()) {
                    com.baidu.live.gift.b.a.a(bVar, false);
                }
            }
        }
    }

    private boolean a(com.baidu.live.gift.b bVar) {
        if (bVar == null || bVar.aDI == null) {
            return false;
        }
        if (TextUtils.isEmpty(bVar.aDI.videoMd5) && TextUtils.isEmpty(bVar.aDI.zipMD5)) {
            return false;
        }
        for (int i = 0; i < this.aKR.size(); i++) {
            com.baidu.live.gift.b bVar2 = this.aKR.get(i);
            if ((!TextUtils.isEmpty(bVar2.aDI.videoMd5) && bVar2.aDI.videoMd5.equals(bVar.aDI.videoMd5)) || (!TextUtils.isEmpty(bVar2.aDI.zipMD5) && bVar2.aDI.zipMD5.equals(bVar.aDI.zipMD5))) {
                return true;
            }
        }
        return false;
    }

    private ArrayList<com.baidu.live.gift.b> B(JSONObject jSONObject) throws Exception {
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

    public ArrayList<com.baidu.live.gift.b> Ad() {
        return this.aKR;
    }

    public boolean wQ() {
        if (getOrginalMessage() instanceof a) {
            return ((a) getOrginalMessage()).isHost();
        }
        return false;
    }
}
