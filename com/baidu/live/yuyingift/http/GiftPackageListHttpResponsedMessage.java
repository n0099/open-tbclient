package com.baidu.live.yuyingift.http;

import com.baidu.live.data.h;
import com.baidu.live.data.j;
import com.baidu.live.gift.g;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.yuyingift.message.a;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class GiftPackageListHttpResponsedMessage extends JsonHttpResponsedMessage {
    private ArrayList<h> baW;
    private ArrayList<j> baX;
    private ArrayList<com.baidu.live.gift.h> bgi;
    private JSONObject bgj;
    private String scene_from;

    public GiftPackageListHttpResponsedMessage() {
        super(1031065);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031065) {
            G(jSONObject);
        }
    }

    public void G(JSONObject jSONObject) {
        this.bgj = jSONObject.optJSONObject("data");
        if (this.bgj != null) {
            this.scene_from = this.bgj.optString("scene_from");
            j(this.bgj.optJSONArray("list"));
            k(this.bgj.optJSONArray("num_info"));
        }
    }

    private void j(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            this.bgi = new ArrayList<>();
            this.baW = new ArrayList<>();
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
                    hVar.bx(z);
                    this.baW.add(hVar);
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
                            gVar.A(optJSONObject2);
                            if (gVar.aVZ != null && gVar.aVZ.aWo > 0) {
                                arrayList2.add(gVar);
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

    public ArrayList<com.baidu.live.gift.h> KG() {
        return this.bgi;
    }

    public ArrayList<h> getCategoryList() {
        return this.baW;
    }

    public ArrayList<j> KH() {
        return this.baX;
    }

    public String KI() {
        return getOrginalMessage() instanceof a ? ((a) getOrginalMessage()).getLoc() : "";
    }
}
