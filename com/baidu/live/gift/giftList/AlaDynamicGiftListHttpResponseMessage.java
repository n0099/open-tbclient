package com.baidu.live.gift.giftList;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.utils.k;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaDynamicGiftListHttpResponseMessage extends JsonHttpResponsedMessage {
    private ArrayList<com.baidu.live.gift.b> aOS;
    private JSONObject aOT;

    public AlaDynamicGiftListHttpResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1021089) {
            super.decodeLogicInBackGround(i, jSONObject);
            this.aOT = jSONObject.optJSONObject("data");
            if (this.aOT != null) {
                this.aOS = D(this.aOT);
                if (this.aOS.size() <= 0) {
                    com.baidu.live.gift.b.a.Bh();
                    com.baidu.live.c.vf().putString("dynamic_cache_data_list", "");
                    return;
                }
                fi(com.baidu.live.c.vf().getSharedPreferences().getString("dynamic_cache_data_list", ""));
                com.baidu.live.c.vf().putString("dynamic_cache_data_list", this.aOT.toString());
                Be();
            }
        }
    }

    private void fi(String str) {
        ArrayList<com.baidu.live.gift.b> arrayList;
        if (!TextUtils.isEmpty(str)) {
            try {
                arrayList = D(new JSONObject(str));
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
                    if (bVar != null && bVar.aHz != null && !TextUtils.isEmpty(bVar.aHz.zipName)) {
                        com.baidu.live.gift.b.a.fm(bVar.aHz.zipName);
                    }
                }
            }
        }
    }

    private void Be() {
        if (!BdNetTypeUtil.isMobileNet() || !k.Jr()) {
            for (int i = 0; i < this.aOS.size(); i++) {
                com.baidu.live.gift.b bVar = this.aOS.get(i);
                if (bVar.aHz != null && bVar.aHz.xW()) {
                    com.baidu.live.gift.b.a.a(bVar, false);
                }
            }
        }
    }

    private boolean a(com.baidu.live.gift.b bVar) {
        if (bVar == null || bVar.aHz == null) {
            return false;
        }
        if (TextUtils.isEmpty(bVar.aHz.videoMd5) && TextUtils.isEmpty(bVar.aHz.zipMD5)) {
            return false;
        }
        for (int i = 0; i < this.aOS.size(); i++) {
            com.baidu.live.gift.b bVar2 = this.aOS.get(i);
            if ((!TextUtils.isEmpty(bVar2.aHz.videoMd5) && bVar2.aHz.videoMd5.equals(bVar.aHz.videoMd5)) || (!TextUtils.isEmpty(bVar2.aHz.zipMD5) && bVar2.aHz.zipMD5.equals(bVar.aHz.zipMD5))) {
                return true;
            }
        }
        return false;
    }

    private ArrayList<com.baidu.live.gift.b> D(JSONObject jSONObject) throws Exception {
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

    public ArrayList<com.baidu.live.gift.b> Bf() {
        return this.aOS;
    }

    public boolean xQ() {
        if (getOrginalMessage() instanceof a) {
            return ((a) getOrginalMessage()).isHost();
        }
        return false;
    }
}
