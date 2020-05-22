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
    private ArrayList<f> aHZ;
    private ArrayList<g> aIa;
    private JSONObject aKS;
    private ArrayList<i> aMl;
    private String scene_from;

    public GiftPackageListHttpResponsedMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_GAME_LIVE_LIST);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1021150) {
            C(jSONObject);
        }
    }

    public void C(JSONObject jSONObject) {
        this.aKS = jSONObject.optJSONObject("data");
        if (this.aKS != null) {
            this.scene_from = this.aKS.optString("scene_from");
            j(this.aKS.optJSONArray("list"));
            k(this.aKS.optJSONArray("num_info"));
        }
    }

    private void j(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            this.aMl = new ArrayList<>();
            this.aHZ = new ArrayList<>();
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
                    this.aHZ.add(fVar);
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
                            gVar.z(optJSONObject2);
                            if (gVar.aEl != null && gVar.aEl.aEs > 0) {
                                arrayList2.add(gVar);
                            }
                        }
                    }
                    i iVar = new i();
                    iVar.setCategoryId(optInt);
                    iVar.setCategoryName(optString);
                    iVar.v(arrayList2);
                    iVar.aY(z);
                    this.aMl.add(iVar);
                }
            }
        }
    }

    private void k(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            this.aIa = new ArrayList<>();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    g gVar = new g();
                    gVar.parser(optJSONObject);
                    this.aIa.add(gVar);
                }
            }
        }
    }

    public ArrayList<i> At() {
        return this.aMl;
    }

    public ArrayList<f> getCategoryList() {
        return this.aHZ;
    }

    public ArrayList<g> Au() {
        return this.aIa;
    }

    public String Av() {
        return getOrginalMessage() instanceof a ? ((a) getOrginalMessage()).getLoc() : "";
    }
}
