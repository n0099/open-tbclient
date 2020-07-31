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
/* loaded from: classes4.dex */
public class GiftPackageListHttpResponsedMessage extends JsonHttpResponsedMessage {
    private ArrayList<f> aLZ;
    private ArrayList<g> aMa;
    private JSONObject aOT;
    private ArrayList<i> aQk;
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
        this.aOT = jSONObject.optJSONObject("data");
        if (this.aOT != null) {
            this.scene_from = this.aOT.optString("scene_from");
            j(this.aOT.optJSONArray("list"));
            k(this.aOT.optJSONArray("num_info"));
        }
    }

    private void j(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            this.aQk = new ArrayList<>();
            this.aLZ = new ArrayList<>();
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
                    fVar.bb(z);
                    this.aLZ.add(fVar);
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
                            if (gVar.aIc != null && gVar.aIc.aIj > 0) {
                                arrayList2.add(gVar);
                            }
                        }
                    }
                    i iVar = new i();
                    iVar.setCategoryId(optInt);
                    iVar.setCategoryName(optString);
                    iVar.B(arrayList2);
                    iVar.bb(z);
                    this.aQk.add(iVar);
                }
            }
        }
    }

    private void k(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            this.aMa = new ArrayList<>();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    g gVar = new g();
                    gVar.parser(optJSONObject);
                    this.aMa.add(gVar);
                }
            }
        }
    }

    public ArrayList<i> Bv() {
        return this.aQk;
    }

    public ArrayList<f> getCategoryList() {
        return this.aLZ;
    }

    public ArrayList<g> Bw() {
        return this.aMa;
    }

    public String Bx() {
        return getOrginalMessage() instanceof a ? ((a) getOrginalMessage()).getLoc() : "";
    }
}
