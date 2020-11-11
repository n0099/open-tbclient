package com.baidu.live.gift.http;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.data.h;
import com.baidu.live.data.j;
import com.baidu.live.gift.g;
import com.baidu.live.gift.message.a;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class GiftPackageListHttpResponsedMessage extends JsonHttpResponsedMessage {
    private ArrayList<h> aZp;
    private ArrayList<j> aZq;
    private ArrayList<com.baidu.live.gift.h> bdT;
    private JSONObject bdU;
    private String scene_from;

    public GiftPackageListHttpResponsedMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_GAME_LIVE_LIST);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1021150) {
            M(jSONObject);
        }
    }

    public void M(JSONObject jSONObject) {
        this.bdU = jSONObject.optJSONObject("data");
        if (this.bdU != null) {
            this.scene_from = this.bdU.optString("scene_from");
            j(this.bdU.optJSONArray("list"));
            k(this.bdU.optJSONArray("num_info"));
        }
    }

    private void j(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            this.bdT = new ArrayList<>();
            this.aZp = new ArrayList<>();
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
                    h hVar = new h();
                    hVar.setCategoryId(optInt);
                    hVar.setCategoryName(optString);
                    hVar.k(arrayList);
                    hVar.bn(z);
                    this.aZp.add(hVar);
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("gift_list");
                if (optJSONArray2 != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                        JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i3);
                        if (optJSONObject2 != null) {
                            g gVar = new g();
                            gVar.parseJson(optJSONObject2);
                            gVar.setSceneFrom(this.scene_from);
                            gVar.G(optJSONObject2);
                            gVar.H(optJSONObject2.optJSONObject("long_press"));
                            if (gVar.aUI != null && gVar.aUI.aUV > 0) {
                                arrayList2.add(gVar);
                            }
                        }
                    }
                    com.baidu.live.gift.h hVar2 = new com.baidu.live.gift.h();
                    hVar2.setCategoryId(optInt);
                    hVar2.setCategoryName(optString);
                    hVar2.F(arrayList2);
                    hVar2.bn(z);
                    this.bdT.add(hVar2);
                }
            }
        }
    }

    private void k(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            this.aZq = new ArrayList<>();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    j jVar = new j();
                    jVar.parser(optJSONObject);
                    this.aZq.add(jVar);
                }
            }
        }
    }

    public String getSceneFrom() {
        return this.scene_from;
    }

    public ArrayList<com.baidu.live.gift.h> Jp() {
        return this.bdT;
    }

    public ArrayList<h> getCategoryList() {
        return this.aZp;
    }

    public ArrayList<j> Jq() {
        return this.aZq;
    }

    public String Jr() {
        return getOrginalMessage() instanceof a ? ((a) getOrginalMessage()).getLoc() : "";
    }
}
