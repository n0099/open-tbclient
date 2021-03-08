package com.baidu.live.gift.http;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.data.i;
import com.baidu.live.data.l;
import com.baidu.live.gift.aa;
import com.baidu.live.gift.h;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class GiftPackageListHttpResponsedMessage extends JsonHttpResponsedMessage {
    private List<l> aZz;
    private ArrayList<i> bcw;
    private ArrayList<l> bcx;
    private ArrayList<h> bhJ;
    private JSONObject bhK;
    private int flag;
    private String scene_from;

    public GiftPackageListHttpResponsedMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_GAME_LIVE_LIST);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1021150) {
            P(jSONObject);
        }
    }

    public void P(JSONObject jSONObject) {
        this.bhK = jSONObject.optJSONObject("data");
        if (this.bhK != null) {
            this.scene_from = this.bhK.optString("scene_from");
            this.flag = this.bhK.optInt(FrsActivityConfig.FLAG);
            j(this.bhK.optJSONArray("list"));
            k(this.bhK.optJSONArray("num_info"));
            l(this.bhK.optJSONArray("fragment_num_info"));
        }
    }

    private void j(JSONArray jSONArray) {
        JSONObject optJSONObject;
        if (jSONArray != null && jSONArray.length() > 0) {
            this.bhJ = new ArrayList<>();
            this.bcw = new ArrayList<>();
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
                    i iVar = new i();
                    iVar.setCategoryId(optInt);
                    iVar.setCategoryName(optString);
                    iVar.f(arrayList);
                    iVar.bs(z);
                    this.bcw.add(iVar);
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
                            aaVar.J(optJSONObject);
                            aaVar.K(optJSONObject.optJSONObject("long_press"));
                            JSONArray optJSONArray3 = optJSONObject3.optJSONArray("fragment_info");
                            if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                                aaVar.aZB = new ArrayList();
                                for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                                    aa.a aVar = new aa.a();
                                    aVar.parseJson(optJSONArray3.optJSONObject(i4));
                                    aaVar.aZB.add(aVar);
                                }
                            }
                            if (aaVar.Fn()) {
                                if (aaVar.aZB != null && !aaVar.aZB.isEmpty()) {
                                    arrayList2.add(aaVar);
                                }
                            } else if (aaVar.aXx != null && aaVar.aXx.aXM > 0) {
                                arrayList2.add(aaVar);
                            }
                        }
                    }
                    h hVar = new h();
                    hVar.setCategoryId(optInt);
                    hVar.setCategoryName(optString);
                    hVar.G(arrayList2);
                    hVar.bs(z);
                    this.bhJ.add(hVar);
                }
            }
        }
    }

    private void k(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            this.bcx = new ArrayList<>();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    l lVar = new l();
                    lVar.parser(optJSONObject);
                    this.bcx.add(lVar);
                }
            }
        }
    }

    private void l(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            this.aZz = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    l lVar = new l();
                    lVar.parser(optJSONObject);
                    this.aZz.add(lVar);
                }
            }
        }
    }

    public String getSceneFrom() {
        return this.scene_from;
    }

    public ArrayList<h> HF() {
        return this.bhJ;
    }

    public ArrayList<i> getCategoryList() {
        return this.bcw;
    }

    public ArrayList<l> HG() {
        return this.bcx;
    }

    public List<l> Fk() {
        return this.aZz;
    }

    public String HH() {
        return getOrginalMessage() instanceof com.baidu.live.gift.message.a ? ((com.baidu.live.gift.message.a) getOrginalMessage()).getLoc() : "";
    }

    public int getFlag() {
        return this.flag;
    }
}
