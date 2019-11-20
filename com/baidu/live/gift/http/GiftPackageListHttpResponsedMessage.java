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
    private ArrayList<a> YN;
    private ArrayList<b> YO;
    private ArrayList<h> abQ;
    private String scene_from;

    public GiftPackageListHttpResponsedMessage() {
        super(1021150);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1021150) {
            w(jSONObject);
        }
    }

    public void w(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            this.scene_from = optJSONObject.optString("scene_from");
            j(optJSONObject.optJSONArray("list"));
            k(optJSONObject.optJSONArray("num_info"));
        }
    }

    private void j(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            this.abQ = new ArrayList<>();
            this.YN = new ArrayList<>();
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
                    this.YN.add(aVar);
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
                            gVar.u(optJSONObject2);
                            if (gVar.Wo != null && gVar.Wo.Ws > 0) {
                                arrayList2.add(gVar);
                            }
                        }
                    }
                    h hVar = new h();
                    hVar.setCategoryId(optInt);
                    hVar.setCategoryName(optString);
                    hVar.s(arrayList2);
                    hVar.ah(z);
                    this.abQ.add(hVar);
                }
            }
        }
    }

    private void k(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            this.YO = new ArrayList<>();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    b bVar = new b();
                    bVar.parser(optJSONObject);
                    this.YO.add(bVar);
                }
            }
        }
    }

    public ArrayList<h> qY() {
        return this.abQ;
    }

    public ArrayList<a> getCategoryList() {
        return this.YN;
    }

    public ArrayList<b> qZ() {
        return this.YO;
    }
}
