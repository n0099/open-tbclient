package com.baidu.live.message;

import android.text.TextUtils;
import com.baidu.live.data.h;
import com.baidu.live.data.j;
import com.baidu.live.data.z;
import com.baidu.live.gift.ac;
import com.baidu.live.gift.aj;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaSdkGetGiftListHttpResponseMessage extends JsonHttpResponsedMessage {
    private ArrayList<h> baW;
    private ArrayList<j> baX;
    private ArrayList<com.baidu.live.gift.h> bgi;
    private z brz;
    private String scene_from;

    public AlaSdkGetGiftListHttpResponseMessage() {
        super(1021120);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1021120) {
            a(jSONObject, false);
        }
    }

    public void a(JSONObject jSONObject, boolean z) {
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            long optLong = optJSONObject.optLong("sleep_time_span");
            if (!z) {
                com.baidu.live.d BM = com.baidu.live.d.BM();
                BM.putLong("ala_sdk_get_gift_list_req_time", (optLong * 1000) + System.currentTimeMillis());
            }
            this.scene_from = optJSONObject.optString("scene_from");
            if (n(optJSONObject.optJSONArray("list"))) {
                k(optJSONObject.optJSONArray("num_info"));
                aD(this.scene_from, jSONObject.toString());
                M(optJSONObject.optJSONObject("contact_conf"));
            }
        }
    }

    private void M(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.brz = new z();
            this.brz.iconUrl = jSONObject.optString("button_url");
            this.brz.aLh = jSONObject.optString("dialog_content");
            this.brz.dialogTitle = jSONObject.optString("dialog_title");
            this.brz.aLi = jSONObject.optString("dialog_content_copy");
        }
    }

    private boolean n(JSONArray jSONArray) {
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
                            com.baidu.live.gift.g gVar = new com.baidu.live.gift.g();
                            gVar.parseJson(optJSONObject2);
                            gVar.setSceneFrom(this.scene_from);
                            gVar.B(optJSONObject2.optJSONObject("long_press"));
                            arrayList2.add(gVar);
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
        return (this.bgi == null || this.bgi.isEmpty()) ? false : true;
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

    private void aD(String str, String str2) {
        if (str2 != null) {
            if (!TextUtils.isEmpty(str) && str.contains("audio")) {
                aj.hs(str2);
            } else {
                ac.hs(str2);
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

    public String getSceneFrom() {
        return this.scene_from;
    }

    public String KI() {
        return getOrginalMessage() instanceof f ? ((f) getOrginalMessage()).KI() : "";
    }

    public z PP() {
        return this.brz;
    }
}
