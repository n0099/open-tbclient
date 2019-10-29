package com.baidu.live.gift.http;

import com.baidu.live.gift.a.a;
import com.baidu.live.gift.a.b;
import com.baidu.live.gift.g;
import com.baidu.live.gift.h;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class GiftPackageListHttpResponsedMessage extends JsonHttpResponsedMessage {
    private ArrayList<a> Zf;
    private ArrayList<b> Zg;
    private ArrayList<h> aci;
    private String scene_from;

    public GiftPackageListHttpResponsedMessage() {
        super(1021150);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1021150) {
            v(jSONObject);
        }
    }

    public void v(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            this.scene_from = optJSONObject.optString("scene_from");
            j(optJSONObject.optJSONArray("list"));
            k(optJSONObject.optJSONArray("num_info"));
        }
    }

    private void j(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            this.aci = new ArrayList<>();
            this.Zf = new ArrayList<>();
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
                    a aVar = new a();
                    aVar.setCategoryId(optInt);
                    aVar.setCategoryName(optString);
                    aVar.g(arrayList);
                    aVar.ah(z);
                    this.Zf.add(aVar);
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
                            gVar.t(optJSONObject2);
                            if (gVar.WH != null && gVar.WH.WL > 0) {
                                arrayList2.add(gVar);
                            }
                        }
                    }
                    h hVar = new h();
                    hVar.setCategoryId(optInt);
                    hVar.setCategoryName(optString);
                    hVar.s(arrayList2);
                    hVar.ah(z);
                    this.aci.add(hVar);
                }
            }
        }
    }

    private void k(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            this.Zg = new ArrayList<>();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    b bVar = new b();
                    bVar.parser(optJSONObject);
                    this.Zg.add(bVar);
                }
            }
        }
    }

    public ArrayList<h> qX() {
        return this.aci;
    }

    public ArrayList<a> getCategoryList() {
        return this.Zf;
    }

    public ArrayList<b> qY() {
        return this.Zg;
    }
}
