package com.baidu.live.yuyingift.http;

import com.baidu.live.data.i;
import com.baidu.live.data.k;
import com.baidu.live.gift.g;
import com.baidu.live.gift.h;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.yuyingift.message.a;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class GiftPackageListHttpResponsedMessage extends JsonHttpResponsedMessage {
    private ArrayList<i> bcD;
    private ArrayList<k> bcE;
    private ArrayList<h> bhQ;
    private JSONObject bhR;
    private String scene_from;

    public GiftPackageListHttpResponsedMessage() {
        super(1031065);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031065) {
            N(jSONObject);
        }
    }

    public void N(JSONObject jSONObject) {
        this.bhR = jSONObject.optJSONObject("data");
        if (this.bhR != null) {
            this.scene_from = this.bhR.optString("scene_from");
            j(this.bhR.optJSONArray("list"));
            k(this.bhR.optJSONArray("num_info"));
        }
    }

    private void j(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            this.bhQ = new ArrayList<>();
            this.bcD = new ArrayList<>();
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
                    i iVar = new i();
                    iVar.setCategoryId(optInt);
                    iVar.setCategoryName(optString);
                    iVar.k(arrayList);
                    iVar.bu(z);
                    this.bcD.add(iVar);
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
                            gVar.H(optJSONObject2);
                            if (gVar.aXF != null && gVar.aXF.aXU > 0) {
                                arrayList2.add(gVar);
                            }
                        }
                    }
                    h hVar = new h();
                    hVar.setCategoryId(optInt);
                    hVar.setCategoryName(optString);
                    hVar.G(arrayList2);
                    hVar.bu(z);
                    this.bhQ.add(hVar);
                }
            }
        }
    }

    private void k(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            this.bcE = new ArrayList<>();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    k kVar = new k();
                    kVar.parser(optJSONObject);
                    this.bcE.add(kVar);
                }
            }
        }
    }

    public ArrayList<h> Kh() {
        return this.bhQ;
    }

    public ArrayList<i> getCategoryList() {
        return this.bcD;
    }

    public ArrayList<k> Ki() {
        return this.bcE;
    }

    public String Kj() {
        return getOrginalMessage() instanceof a ? ((a) getOrginalMessage()).getLoc() : "";
    }
}
