package com.baidu.live.message;

import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.live.gift.i;
import com.baidu.live.tbadk.core.dbcache.DBKVCacheManager;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaSdkGetGiftListHttpResponseMessage extends JsonHttpResponsedMessage {
    private ArrayList<com.baidu.live.data.d> ajO;
    private ArrayList<com.baidu.live.data.e> ajP;
    private ArrayList<i> aof;
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
                com.baidu.live.c pw = com.baidu.live.c.pw();
                pw.putLong("ala_sdk_get_gift_list_req_time", (optLong * 1000) + System.currentTimeMillis());
            }
            this.scene_from = optJSONObject.optString("scene_from");
            if (m(optJSONObject.optJSONArray("list"))) {
                k(optJSONObject.optJSONArray("num_info"));
                aa(this.scene_from, jSONObject.toString());
            }
        }
    }

    private boolean m(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            this.aof = new ArrayList<>();
            this.ajO = new ArrayList<>();
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
                    com.baidu.live.data.d dVar = new com.baidu.live.data.d();
                    dVar.setCategoryId(optInt);
                    dVar.setCategoryName(optString);
                    dVar.f(arrayList);
                    dVar.aw(z);
                    this.ajO.add(dVar);
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("gift_list");
                if (optJSONArray2 != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                        JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i3);
                        if (optJSONObject2 != null) {
                            com.baidu.live.gift.g gVar = new com.baidu.live.gift.g();
                            gVar.parseJson(optJSONObject2);
                            gVar.setSceneFrom(this.scene_from);
                            arrayList2.add(gVar);
                        }
                    }
                    i iVar = new i();
                    iVar.setCategoryId(optInt);
                    iVar.setCategoryName(optString);
                    iVar.r(arrayList2);
                    iVar.aw(z);
                    this.aof.add(iVar);
                }
            }
        }
        return (this.aof == null || this.aof.isEmpty()) ? false : true;
    }

    private void k(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            this.ajP = new ArrayList<>();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    com.baidu.live.data.e eVar = new com.baidu.live.data.e();
                    eVar.parser(optJSONObject);
                    this.ajP.add(eVar);
                }
            }
        }
    }

    private void aa(String str, String str2) {
        BdKVCache<String> stringCacheWithSapce;
        if (str2 != null && (stringCacheWithSapce = DBKVCacheManager.getInstance().getStringCacheWithSapce(DBKVCacheManager.ALA_GIFT_LIST_CACHE_KEY)) != null) {
            stringCacheWithSapce.asyncSet(com.baidu.live.gift.h.f(str, 0L), str2, com.baidu.live.gift.h.agL);
        }
    }

    public ArrayList<i> uL() {
        return this.aof;
    }

    public ArrayList<com.baidu.live.data.d> getCategoryList() {
        return this.ajO;
    }

    public ArrayList<com.baidu.live.data.e> uM() {
        return this.ajP;
    }

    public String getSceneFrom() {
        return this.scene_from;
    }
}
