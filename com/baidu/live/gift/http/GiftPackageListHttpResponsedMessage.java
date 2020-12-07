package com.baidu.live.gift.http;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.data.h;
import com.baidu.live.data.j;
import com.baidu.live.gift.aa;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class GiftPackageListHttpResponsedMessage extends JsonHttpResponsedMessage {
    private List<j> aXZ;
    private ArrayList<h> baW;
    private ArrayList<j> baX;
    private ArrayList<com.baidu.live.gift.h> bgi;
    private JSONObject bgj;
    private int flag;
    private String scene_from;

    public GiftPackageListHttpResponsedMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_GAME_LIVE_LIST);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1021150) {
            G(jSONObject);
        }
    }

    public void G(JSONObject jSONObject) {
        this.bgj = jSONObject.optJSONObject("data");
        if (this.bgj != null) {
            this.scene_from = this.bgj.optString("scene_from");
            this.flag = this.bgj.optInt(FrsActivityConfig.FLAG);
            j(this.bgj.optJSONArray("list"));
            k(this.bgj.optJSONArray("num_info"));
            l(this.bgj.optJSONArray("fragment_num_info"));
        }
    }

    private void j(JSONArray jSONArray) {
        JSONObject optJSONObject;
        if (jSONArray != null && jSONArray.length() > 0) {
            this.bgi = new ArrayList<>();
            this.baW = new ArrayList<>();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject2 = jSONArray.optJSONObject(i);
                int optInt = optJSONObject2.optInt("category_id");
                String optString = optJSONObject2.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
                boolean z = optJSONObject2.optInt("is_privilege") == 1;
                JSONArray optJSONArray = optJSONObject2.optJSONArray("gift_ids");
                if (optJSONArray != null) {
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        arrayList.add(Integer.valueOf(optJSONArray.optInt(i2)));
                    }
                    h hVar = new h();
                    hVar.setCategoryId(optInt);
                    hVar.setCategoryName(optString);
                    hVar.k(arrayList);
                    hVar.bx(z);
                    this.baW.add(hVar);
                }
                JSONArray optJSONArray2 = optJSONObject2.optJSONArray("gift_list");
                if (optJSONArray2 != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                        JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i3);
                        if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("gift_info")) != null) {
                            aa aaVar = new aa();
                            aaVar.parseJson(optJSONObject);
                            aaVar.setSceneFrom(this.scene_from);
                            aaVar.A(optJSONObject);
                            aaVar.B(optJSONObject.optJSONObject("long_press"));
                            JSONArray optJSONArray3 = optJSONObject3.optJSONArray("fragment_info");
                            if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                                aaVar.aYb = new ArrayList();
                                for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                                    aa.a aVar = new aa.a();
                                    aVar.parseJson(optJSONArray3.optJSONObject(i4));
                                    aaVar.aYb.add(aVar);
                                }
                            }
                            if (aaVar.Io()) {
                                if (aaVar.aYb != null && !aaVar.aYb.isEmpty()) {
                                    arrayList2.add(aaVar);
                                }
                            } else if (aaVar.aVZ != null && aaVar.aVZ.aWo > 0) {
                                arrayList2.add(aaVar);
                            }
                        }
                    }
                    com.baidu.live.gift.h hVar2 = new com.baidu.live.gift.h();
                    hVar2.setCategoryId(optInt);
                    hVar2.setCategoryName(optString);
                    hVar2.G(arrayList2);
                    hVar2.bx(z);
                    this.bgi.add(hVar2);
                }
            }
        }
    }

    private void k(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            this.baX = new ArrayList<>();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    j jVar = new j();
                    jVar.parser(optJSONObject);
                    this.baX.add(jVar);
                }
            }
        }
    }

    private void l(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            this.aXZ = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    j jVar = new j();
                    jVar.parser(optJSONObject);
                    this.aXZ.add(jVar);
                }
            }
        }
    }

    public String getSceneFrom() {
        return this.scene_from;
    }

    public ArrayList<com.baidu.live.gift.h> KG() {
        return this.bgi;
    }

    public ArrayList<h> getCategoryList() {
        return this.baW;
    }

    public ArrayList<j> KH() {
        return this.baX;
    }

    public List<j> Il() {
        return this.aXZ;
    }

    public String KI() {
        return getOrginalMessage() instanceof com.baidu.live.gift.message.a ? ((com.baidu.live.gift.message.a) getOrginalMessage()).getLoc() : "";
    }

    public int getFlag() {
        return this.flag;
    }
}
