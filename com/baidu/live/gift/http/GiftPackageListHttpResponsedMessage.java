package com.baidu.live.gift.http;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.data.f;
import com.baidu.live.data.g;
import com.baidu.live.gift.i;
import com.baidu.live.gift.message.a;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class GiftPackageListHttpResponsedMessage extends JsonHttpResponsedMessage {
    private ArrayList<f> aKD;
    private ArrayList<g> aKE;
    private JSONObject aNy;
    private ArrayList<i> aOR;
    private String scene_from;

    public GiftPackageListHttpResponsedMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_GAME_LIVE_LIST);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1021150) {
            E(jSONObject);
        }
    }

    public void E(JSONObject jSONObject) {
        this.aNy = jSONObject.optJSONObject("data");
        if (this.aNy != null) {
            this.scene_from = this.aNy.optString("scene_from");
            j(this.aNy.optJSONArray("list"));
            k(this.aNy.optJSONArray("num_info"));
        }
    }

    private void j(JSONArray jSONArray) {
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
                    f fVar = new f();
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
                            gVar.B(optJSONObject2);
                            if (gVar.aGH != null && gVar.aGH.aGO > 0) {
                                arrayList2.add(gVar);
                            }
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

    public ArrayList<i> AT() {
        return this.aOR;
    }

    public ArrayList<f> getCategoryList() {
        return this.aKD;
    }

    public ArrayList<g> AU() {
        return this.aKE;
    }

    public String AV() {
        return getOrginalMessage() instanceof a ? ((a) getOrginalMessage()).getLoc() : "";
    }
}
