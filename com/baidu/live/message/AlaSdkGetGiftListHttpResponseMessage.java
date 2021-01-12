package com.baidu.live.message;

import android.text.TextUtils;
import com.baidu.live.data.aa;
import com.baidu.live.data.i;
import com.baidu.live.data.k;
import com.baidu.live.gift.ac;
import com.baidu.live.gift.aj;
import com.baidu.live.gift.h;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaSdkGetGiftListHttpResponseMessage extends JsonHttpResponsedMessage {
    private ArrayList<i> aXP;
    private ArrayList<k> aXQ;
    private ArrayList<h> bcZ;
    private aa brt;
    private String scene_from;

    public AlaSdkGetGiftListHttpResponseMessage() {
        super(1021120);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1021120) {
            c(jSONObject, false);
        }
    }

    public void c(JSONObject jSONObject, boolean z) {
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            long optLong = optJSONObject.optLong("sleep_time_span");
            if (!z) {
                com.baidu.live.d xf = com.baidu.live.d.xf();
                xf.putLong("ala_sdk_get_gift_list_req_time", (optLong * 1000) + System.currentTimeMillis());
            }
            this.scene_from = optJSONObject.optString("scene_from");
            if (n(optJSONObject.optJSONArray("list"))) {
                k(optJSONObject.optJSONArray("num_info"));
                aA(this.scene_from, jSONObject.toString());
                U(optJSONObject.optJSONObject("contact_conf"));
            }
        }
    }

    private void U(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.brt = new aa();
            this.brt.iconUrl = jSONObject.optString("button_url");
            this.brt.aGW = jSONObject.optString("dialog_content");
            this.brt.dialogTitle = jSONObject.optString("dialog_title");
            this.brt.aGX = jSONObject.optString("dialog_content_copy");
        }
    }

    private boolean n(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            this.bcZ = new ArrayList<>();
            this.aXP = new ArrayList<>();
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
                    iVar.bq(z);
                    this.aXP.add(iVar);
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
                            gVar.I(optJSONObject2.optJSONObject("long_press"));
                            arrayList2.add(gVar);
                        }
                    }
                    h hVar = new h();
                    hVar.setCategoryId(optInt);
                    hVar.setCategoryName(optString);
                    hVar.G(arrayList2);
                    hVar.bq(z);
                    this.bcZ.add(hVar);
                }
            }
        }
        return (this.bcZ == null || this.bcZ.isEmpty()) ? false : true;
    }

    private void k(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            this.aXQ = new ArrayList<>();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    k kVar = new k();
                    kVar.parser(optJSONObject);
                    this.aXQ.add(kVar);
                }
            }
        }
    }

    private void aA(String str, String str2) {
        if (str2 != null) {
            if (!TextUtils.isEmpty(str) && str.contains("audio")) {
                aj.fR(str2);
            } else {
                ac.fR(str2);
            }
        }
    }

    public ArrayList<h> Gm() {
        return this.bcZ;
    }

    public ArrayList<i> getCategoryList() {
        return this.aXP;
    }

    public ArrayList<k> Gn() {
        return this.aXQ;
    }

    public String getSceneFrom() {
        return this.scene_from;
    }

    public String Go() {
        return getOrginalMessage() instanceof f ? ((f) getOrginalMessage()).Go() : "";
    }

    public aa MT() {
        return this.brt;
    }
}
