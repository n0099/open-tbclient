package com.baidu.live.gift.http;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.data.g;
import com.baidu.live.data.i;
import com.baidu.live.gift.message.a;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class GiftPackageListHttpResponsedMessage extends JsonHttpResponsedMessage {
    private ArrayList<g> aWC;
    private ArrayList<i> aWD;
    private JSONObject aZJ;
    private ArrayList<com.baidu.live.gift.i> bbn;
    private String scene_from;

    public GiftPackageListHttpResponsedMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_GAME_LIVE_LIST);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1021150) {
            H(jSONObject);
        }
    }

    public void H(JSONObject jSONObject) {
        this.aZJ = jSONObject.optJSONObject("data");
        if (this.aZJ != null) {
            this.scene_from = this.aZJ.optString("scene_from");
            j(this.aZJ.optJSONArray("list"));
            k(this.aZJ.optJSONArray("num_info"));
        }
    }

    private void j(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            this.bbn = new ArrayList<>();
            this.aWC = new ArrayList<>();
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
                    gVar.bl(z);
                    this.aWC.add(gVar);
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
                            gVar2.D(optJSONObject2);
                            gVar2.E(optJSONObject2.optJSONObject("long_press"));
                            if (gVar2.aSt != null && gVar2.aSt.aSG > 0) {
                                arrayList2.add(gVar2);
                            }
                        }
                    }
                    com.baidu.live.gift.i iVar = new com.baidu.live.gift.i();
                    iVar.setCategoryId(optInt);
                    iVar.setCategoryName(optString);
                    iVar.G(arrayList2);
                    iVar.bl(z);
                    this.bbn.add(iVar);
                }
            }
        }
    }

    private void k(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            this.aWD = new ArrayList<>();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    i iVar = new i();
                    iVar.parser(optJSONObject);
                    this.aWD.add(iVar);
                }
            }
        }
    }

    public String getSceneFrom() {
        return this.scene_from;
    }

    public ArrayList<com.baidu.live.gift.i> Iv() {
        return this.bbn;
    }

    public ArrayList<g> getCategoryList() {
        return this.aWC;
    }

    public ArrayList<i> Iw() {
        return this.aWD;
    }

    public String Ix() {
        return getOrginalMessage() instanceof a ? ((a) getOrginalMessage()).getLoc() : "";
    }
}
