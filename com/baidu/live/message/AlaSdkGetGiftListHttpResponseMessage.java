package com.baidu.live.message;

import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.live.data.g;
import com.baidu.live.data.s;
import com.baidu.live.gift.h;
import com.baidu.live.gift.i;
import com.baidu.live.tbadk.core.dbcache.DBKVCacheManager;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaSdkGetGiftListHttpResponseMessage extends JsonHttpResponsedMessage {
    private ArrayList<com.baidu.live.data.f> aKD;
    private ArrayList<g> aKE;
    private ArrayList<i> aOR;
    private s aZn;
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
                com.baidu.live.c vf = com.baidu.live.c.vf();
                vf.putLong("ala_sdk_get_gift_list_req_time", (optLong * 1000) + System.currentTimeMillis());
            }
            this.scene_from = optJSONObject.optString("scene_from");
            if (m(optJSONObject.optJSONArray("list"))) {
                k(optJSONObject.optJSONArray("num_info"));
                at(this.scene_from, jSONObject.toString());
                I(optJSONObject.optJSONObject("contact_conf"));
            }
        }
    }

    private void I(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aZn = new s();
            this.aZn.iconUrl = jSONObject.optString("button_url");
            this.aZn.axX = jSONObject.optString("dialog_content");
            this.aZn.dialogTitle = jSONObject.optString("dialog_title");
            this.aZn.axY = jSONObject.optString("dialog_content_copy");
        }
    }

    private boolean m(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            this.aOR = new ArrayList<>();
            this.aKD = new ArrayList<>();
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
                    fVar.f(arrayList);
                    fVar.aY(z);
                    this.aKD.add(fVar);
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
                    iVar.z(arrayList2);
                    iVar.aY(z);
                    this.aOR.add(iVar);
                }
            }
        }
        return (this.aOR == null || this.aOR.isEmpty()) ? false : true;
    }

    private void k(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            this.aKE = new ArrayList<>();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    g gVar = new g();
                    gVar.parser(optJSONObject);
                    this.aKE.add(gVar);
                }
            }
        }
    }

    private void at(String str, String str2) {
        BdKVCache<String> stringCacheWithSapce;
        if (str2 != null && (stringCacheWithSapce = DBKVCacheManager.getInstance().getStringCacheWithSapce(DBKVCacheManager.ALA_GIFT_LIST_CACHE_KEY)) != null) {
            stringCacheWithSapce.asyncSet(h.f(str, 0L), str2, h.aGV);
        }
    }

    public ArrayList<i> AT() {
        return this.aOR;
    }

    public ArrayList<com.baidu.live.data.f> getCategoryList() {
        return this.aKD;
    }

    public ArrayList<g> AU() {
        return this.aKE;
    }

    public String getSceneFrom() {
        return this.scene_from;
    }

    public String AV() {
        return getOrginalMessage() instanceof e ? ((e) getOrginalMessage()).AV() : "";
    }

    public s FX() {
        return this.aZn;
    }
}
