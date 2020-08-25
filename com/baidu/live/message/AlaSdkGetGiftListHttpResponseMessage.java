package com.baidu.live.message;

import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.live.data.g;
import com.baidu.live.data.t;
import com.baidu.live.gift.h;
import com.baidu.live.gift.i;
import com.baidu.live.tbadk.core.dbcache.DBKVCacheManager;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AlaSdkGetGiftListHttpResponseMessage extends JsonHttpResponsedMessage {
    private ArrayList<com.baidu.live.data.f> aRm;
    private ArrayList<g> aRn;
    private ArrayList<i> aVy;
    private t beF;
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
                com.baidu.live.c AD = com.baidu.live.c.AD();
                AD.putLong("ala_sdk_get_gift_list_req_time", (optLong * 1000) + System.currentTimeMillis());
            }
            this.scene_from = optJSONObject.optString("scene_from");
            if (m(optJSONObject.optJSONArray("list"))) {
                k(optJSONObject.optJSONArray("num_info"));
                aw(this.scene_from, jSONObject.toString());
                K(optJSONObject.optJSONObject("contact_conf"));
            }
        }
    }

    private void K(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.beF = new t();
            this.beF.iconUrl = jSONObject.optString("button_url");
            this.beF.aEu = jSONObject.optString("dialog_content");
            this.beF.dialogTitle = jSONObject.optString("dialog_title");
            this.beF.aEv = jSONObject.optString("dialog_content_copy");
        }
    }

    private boolean m(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            this.aVy = new ArrayList<>();
            this.aRm = new ArrayList<>();
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
                    com.baidu.live.data.f fVar = new com.baidu.live.data.f();
                    fVar.setCategoryId(optInt);
                    fVar.setCategoryName(optString);
                    fVar.k(arrayList);
                    fVar.bg(z);
                    this.aRm.add(fVar);
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
                    iVar.C(arrayList2);
                    iVar.bg(z);
                    this.aVy.add(iVar);
                }
            }
        }
        return (this.aVy == null || this.aVy.isEmpty()) ? false : true;
    }

    private void k(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            this.aRn = new ArrayList<>();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    g gVar = new g();
                    gVar.parser(optJSONObject);
                    this.aRn.add(gVar);
                }
            }
        }
    }

    private void aw(String str, String str2) {
        BdKVCache<String> stringCacheWithSapce;
        if (str2 != null && (stringCacheWithSapce = DBKVCacheManager.getInstance().getStringCacheWithSapce(DBKVCacheManager.ALA_GIFT_LIST_CACHE_KEY)) != null) {
            stringCacheWithSapce.asyncSet(h.e(str, 0L), str2, h.aNB);
        }
    }

    public ArrayList<i> GY() {
        return this.aVy;
    }

    public ArrayList<com.baidu.live.data.f> getCategoryList() {
        return this.aRm;
    }

    public ArrayList<g> GZ() {
        return this.aRn;
    }

    public String getSceneFrom() {
        return this.scene_from;
    }

    public String Ha() {
        return getOrginalMessage() instanceof e ? ((e) getOrginalMessage()).Ha() : "";
    }

    public t LF() {
        return this.beF;
    }
}
