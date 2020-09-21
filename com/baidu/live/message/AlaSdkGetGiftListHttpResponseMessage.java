package com.baidu.live.message;

import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.live.data.g;
import com.baidu.live.data.i;
import com.baidu.live.data.w;
import com.baidu.live.gift.h;
import com.baidu.live.tbadk.core.dbcache.DBKVCacheManager;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaSdkGetGiftListHttpResponseMessage extends JsonHttpResponsedMessage {
    private ArrayList<g> aTr;
    private ArrayList<i> aTs;
    private ArrayList<com.baidu.live.gift.i> aXT;
    private w bhx;
    private String scene_from;

    public AlaSdkGetGiftListHttpResponseMessage() {
        super(1021120);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1021120) {
            a(jSONObject, false);
        }
    }

    public void a(JSONObject jSONObject, boolean z) {
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            long optLong = optJSONObject.optLong("sleep_time_span");
            if (!z) {
                com.baidu.live.c AR = com.baidu.live.c.AR();
                AR.putLong("ala_sdk_get_gift_list_req_time", (optLong * 1000) + System.currentTimeMillis());
            }
            this.scene_from = optJSONObject.optString("scene_from");
            if (m(optJSONObject.optJSONArray("list"))) {
                k(optJSONObject.optJSONArray("num_info"));
                aw(this.scene_from, jSONObject.toString());
                M(optJSONObject.optJSONObject("contact_conf"));
            }
        }
    }

    private void M(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bhx = new w();
            this.bhx.iconUrl = jSONObject.optString("button_url");
            this.bhx.aFB = jSONObject.optString("dialog_content");
            this.bhx.dialogTitle = jSONObject.optString("dialog_title");
            this.bhx.aFC = jSONObject.optString("dialog_content_copy");
        }
    }

    private boolean m(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            this.aXT = new ArrayList<>();
            this.aTr = new ArrayList<>();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                int optInt = optJSONObject.optInt("category_id");
                String optString = optJSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
                boolean z = optJSONObject.optInt("is_privilege") == 1;
                JSONArray optJSONArray = optJSONObject.optJSONArray("gift_ids");
                if (optJSONArray != null) {
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        arrayList.add(Integer.valueOf(optJSONArray.optInt(i2)));
                    }
                    g gVar = new g();
                    gVar.setCategoryId(optInt);
                    gVar.setCategoryName(optString);
                    gVar.k(arrayList);
                    gVar.bh(z);
                    this.aTr.add(gVar);
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("gift_list");
                if (optJSONArray2 != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                        JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i3);
                        if (optJSONObject2 != null) {
                            com.baidu.live.gift.g gVar2 = new com.baidu.live.gift.g();
                            gVar2.parseJson(optJSONObject2);
                            gVar2.setSceneFrom(this.scene_from);
                            gVar2.E(optJSONObject2.optJSONObject("long_press"));
                            arrayList2.add(gVar2);
                        }
                    }
                    com.baidu.live.gift.i iVar = new com.baidu.live.gift.i();
                    iVar.setCategoryId(optInt);
                    iVar.setCategoryName(optString);
                    iVar.E(arrayList2);
                    iVar.bh(z);
                    this.aXT.add(iVar);
                }
            }
        }
        return (this.aXT == null || this.aXT.isEmpty()) ? false : true;
    }

    private void k(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            this.aTs = new ArrayList<>();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    i iVar = new i();
                    iVar.parser(optJSONObject);
                    this.aTs.add(iVar);
                }
            }
        }
    }

    private void aw(String str, String str2) {
        if (str2 != null) {
            com.baidu.live.gift.w.gz(str2);
            BdKVCache<String> stringCacheWithSapce = DBKVCacheManager.getInstance().getStringCacheWithSapce(DBKVCacheManager.ALA_GIFT_LIST_CACHE_KEY);
            if (stringCacheWithSapce != null) {
                stringCacheWithSapce.asyncSet(h.e(str, 0L), str2, h.aPB);
            }
        }
    }

    public ArrayList<com.baidu.live.gift.i> Hy() {
        return this.aXT;
    }

    public ArrayList<g> getCategoryList() {
        return this.aTr;
    }

    public ArrayList<i> Hz() {
        return this.aTs;
    }

    public String getSceneFrom() {
        return this.scene_from;
    }

    public String HA() {
        return getOrginalMessage() instanceof e ? ((e) getOrginalMessage()).HA() : "";
    }

    public w Mg() {
        return this.bhx;
    }
}
