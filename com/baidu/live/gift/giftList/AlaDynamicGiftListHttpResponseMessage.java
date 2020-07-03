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
    private ArrayList<com.baidu.live.gift.b> aNx;
    private JSONObject aNy;

    public AlaDynamicGiftListHttpResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1021089) {
            super.decodeLogicInBackGround(i, jSONObject);
            this.aNy = jSONObject.optJSONObject("data");
            if (this.aNy != null) {
                this.aNx = D(this.aNy);
                if (this.aNx.size() <= 0) {
                    com.baidu.live.gift.b.a.AF();
                    com.baidu.live.c.vf().putString("dynamic_cache_data_list", "");
                    return;
                }
                fj(com.baidu.live.c.vf().getSharedPreferences().getString("dynamic_cache_data_list", ""));
                com.baidu.live.c.vf().putString("dynamic_cache_data_list", this.aNy.toString());
                AC();
            }
        }
    }

    private void fj(String str) {
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
                    if (bVar != null && bVar.aGe != null && !TextUtils.isEmpty(bVar.aGe.zipName)) {
                        com.baidu.live.gift.b.a.fn(bVar.aGe.zipName);
                    }
                }
            }
        }
    }

    private void AC() {
        if (!BdNetTypeUtil.isMobileNet() || !k.Jk()) {
            for (int i = 0; i < this.aNx.size(); i++) {
                com.baidu.live.gift.b bVar = this.aNx.get(i);
                if (bVar.aGe != null && bVar.aGe.xu()) {
                    com.baidu.live.gift.b.a.a(bVar, false);
                }
            }
        }
    }

    private boolean a(com.baidu.live.gift.b bVar) {
        if (bVar == null || bVar.aGe == null) {
            return false;
        }
        if (TextUtils.isEmpty(bVar.aGe.videoMd5) && TextUtils.isEmpty(bVar.aGe.zipMD5)) {
            return false;
        }
        for (int i = 0; i < this.aNx.size(); i++) {
            com.baidu.live.gift.b bVar2 = this.aNx.get(i);
            if ((!TextUtils.isEmpty(bVar2.aGe.videoMd5) && bVar2.aGe.videoMd5.equals(bVar.aGe.videoMd5)) || (!TextUtils.isEmpty(bVar2.aGe.zipMD5) && bVar2.aGe.zipMD5.equals(bVar.aGe.zipMD5))) {
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

    public ArrayList<com.baidu.live.gift.b> AD() {
        return this.aNx;
    }

    public boolean xn() {
        if (getOrginalMessage() instanceof a) {
            return ((a) getOrginalMessage()).isHost();
        }
        return false;
    }
}
