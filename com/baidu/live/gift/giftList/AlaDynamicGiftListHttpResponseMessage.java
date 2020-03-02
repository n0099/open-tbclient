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
    private ArrayList<com.baidu.live.gift.b> amF;

    public AlaDynamicGiftListHttpResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1021089) {
            super.decodeLogicInBackGround(i, jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.amF = r(optJSONObject);
                if (this.amF.size() <= 0) {
                    com.baidu.live.gift.b.a.us();
                    c.pr().putString("dynamic_cache_data_list", "");
                    return;
                }
                dB(c.pr().getSharedPreferences().getString("dynamic_cache_data_list", ""));
                c.pr().putString("dynamic_cache_data_list", optJSONObject.toString());
                up();
            }
        }
    }

    private void dB(String str) {
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
                    if (bVar != null && bVar.afJ != null && !TextUtils.isEmpty(bVar.afJ.zipName)) {
                        com.baidu.live.gift.b.a.dG(bVar.afJ.zipName);
                    }
                }
            }
        }
    }

    private void up() {
        if (!BdNetTypeUtil.isMobileNet() || !k.Ba()) {
            for (int i = 0; i < this.amF.size(); i++) {
                com.baidu.live.gift.b bVar = this.amF.get(i);
                if (bVar.afJ != null && bVar.afJ.rh()) {
                    com.baidu.live.gift.b.a.a(bVar, false);
                }
            }
        }
    }

    private boolean a(com.baidu.live.gift.b bVar) {
        if (bVar == null || bVar.afJ == null) {
            return false;
        }
        if (TextUtils.isEmpty(bVar.afJ.videoMd5) && TextUtils.isEmpty(bVar.afJ.zipMD5)) {
            return false;
        }
        for (int i = 0; i < this.amF.size(); i++) {
            com.baidu.live.gift.b bVar2 = this.amF.get(i);
            if ((!TextUtils.isEmpty(bVar2.afJ.videoMd5) && bVar2.afJ.videoMd5.equals(bVar.afJ.videoMd5)) || (!TextUtils.isEmpty(bVar2.afJ.zipMD5) && bVar2.afJ.zipMD5.equals(bVar.afJ.zipMD5))) {
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

    public ArrayList<com.baidu.live.gift.b> uq() {
        return this.amF;
    }
}
