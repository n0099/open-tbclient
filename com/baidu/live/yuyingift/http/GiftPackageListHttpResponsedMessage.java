package com.baidu.live.yuyingift.http;

import com.baidu.live.data.i;
import com.baidu.live.data.l;
import com.baidu.live.gift.g;
import com.baidu.live.gift.h;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.yuyingift.message.a;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class GiftPackageListHttpResponsedMessage extends JsonHttpResponsedMessage {
    private ArrayList<i> bcw;
    private ArrayList<l> bcx;
    private ArrayList<h> bhJ;
    private JSONObject bhK;
    private String scene_from;

    public GiftPackageListHttpResponsedMessage() {
        super(1031065);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031065) {
            P(jSONObject);
        }
    }

    public void P(JSONObject jSONObject) {
        this.bhK = jSONObject.optJSONObject("data");
        if (this.bhK != null) {
            this.scene_from = this.bhK.optString("scene_from");
            j(this.bhK.optJSONArray("list"));
            k(this.bhK.optJSONArray("num_info"));
        }
    }

    private void j(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            this.bhJ = new ArrayList<>();
            this.bcw = new ArrayList<>();
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
                    iVar.f(arrayList);
                    iVar.bs(z);
                    this.bcw.add(iVar);
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
                            gVar.J(optJSONObject2);
                            if (gVar.aXx != null && gVar.aXx.aXM > 0) {
                                arrayList2.add(gVar);
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

    public ArrayList<h> HF() {
        return this.bhJ;
    }

    public ArrayList<i> getCategoryList() {
        return this.bcw;
    }

    public ArrayList<l> HG() {
        return this.bcx;
    }

    public String HH() {
        return getOrginalMessage() instanceof a ? ((a) getOrginalMessage()).getLoc() : "";
    }
}
