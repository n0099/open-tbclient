package com.baidu.live.gift.giftList;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.utils.k;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AlaDynamicGiftListHttpResponseMessage extends JsonHttpResponsedMessage {
    private ArrayList<com.baidu.live.gift.b> aUg;
    private JSONObject aUh;

    public AlaDynamicGiftListHttpResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1021089) {
            super.decodeLogicInBackGround(i, jSONObject);
            this.aUh = jSONObject.optJSONObject("data");
            if (this.aUh != null) {
                this.aUg = F(this.aUh);
                if (this.aUg.size() <= 0) {
                    com.baidu.live.gift.b.a.GK();
                    com.baidu.live.c.AD().putString("dynamic_cache_data_list", "");
                    return;
                }
                gD(com.baidu.live.c.AD().getSharedPreferences().getString("dynamic_cache_data_list", ""));
                com.baidu.live.c.AD().putString("dynamic_cache_data_list", this.aUh.toString());
                GH();
            }
        }
    }

    private void gD(String str) {
        ArrayList<com.baidu.live.gift.b> arrayList;
        if (!TextUtils.isEmpty(str)) {
            try {
                arrayList = F(new JSONObject(str));
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
                    if (bVar != null && bVar.aMJ != null && !TextUtils.isEmpty(bVar.aMJ.zipName)) {
                        com.baidu.live.gift.b.a.gH(bVar.aMJ.zipName);
                    }
                }
            }
        }
    }

    private void GH() {
        if (!BdNetTypeUtil.isMobileNet() || !k.Pj()) {
            for (int i = 0; i < this.aUg.size(); i++) {
                com.baidu.live.gift.b bVar = this.aUg.get(i);
                if (bVar.aMJ != null && bVar.aMJ.Dz()) {
                    com.baidu.live.gift.b.a.a(bVar, false);
                }
            }
        }
    }

    private boolean a(com.baidu.live.gift.b bVar) {
        if (bVar == null || bVar.aMJ == null) {
            return false;
        }
        if (TextUtils.isEmpty(bVar.aMJ.videoMd5) && TextUtils.isEmpty(bVar.aMJ.zipMD5)) {
            return false;
        }
        for (int i = 0; i < this.aUg.size(); i++) {
            com.baidu.live.gift.b bVar2 = this.aUg.get(i);
            if ((!TextUtils.isEmpty(bVar2.aMJ.videoMd5) && bVar2.aMJ.videoMd5.equals(bVar.aMJ.videoMd5)) || (!TextUtils.isEmpty(bVar2.aMJ.zipMD5) && bVar2.aMJ.zipMD5.equals(bVar.aMJ.zipMD5))) {
                return true;
            }
        }
        return false;
    }

    private ArrayList<com.baidu.live.gift.b> F(JSONObject jSONObject) throws Exception {
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

    public ArrayList<com.baidu.live.gift.b> GI() {
        return this.aUg;
    }

    public boolean Dt() {
        if (getOrginalMessage() instanceof a) {
            return ((a) getOrginalMessage()).isHost();
        }
        return false;
    }
}
