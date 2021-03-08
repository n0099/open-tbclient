package com.baidu.live.message;

import android.text.TextUtils;
import com.baidu.live.data.ae;
import com.baidu.live.data.i;
import com.baidu.live.data.l;
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
    private ArrayList<i> bcw;
    private ArrayList<l> bcx;
    private ArrayList<h> bhJ;
    private ae bww;
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
                com.baidu.live.d xf = com.baidu.live.d.xf();
                xf.putLong("ala_sdk_get_gift_list_req_time", (optLong * 1000) + System.currentTimeMillis());
            }
            this.scene_from = optJSONObject.optString("scene_from");
            if (n(optJSONObject.optJSONArray("list"))) {
                k(optJSONObject.optJSONArray("num_info"));
                aA(this.scene_from, jSONObject.toString());
                Y(optJSONObject.optJSONObject("contact_conf"));
            }
        }
    }

    private void Y(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bww = new ae();
            this.bww.iconUrl = jSONObject.optString("button_url");
            this.bww.aLa = jSONObject.optString("dialog_content");
            this.bww.dialogTitle = jSONObject.optString("dialog_title");
            this.bww.aLb = jSONObject.optString("dialog_content_copy");
        }
    }

    private boolean n(JSONArray jSONArray) {
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
                            com.baidu.live.gift.g gVar = new com.baidu.live.gift.g();
                            gVar.parseJson(optJSONObject2);
                            gVar.setSceneFrom(this.scene_from);
                            gVar.K(optJSONObject2.optJSONObject("long_press"));
                            arrayList2.add(gVar);
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
        return (this.bhJ == null || this.bhJ.isEmpty()) ? false : true;
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

    private void aA(String str, String str2) {
        if (str2 != null) {
            if (!TextUtils.isEmpty(str) && str.contains("audio")) {
                aj.gu(str2);
            } else {
                ac.gu(str2);
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

    public String getSceneFrom() {
        return this.scene_from;
    }

    public String HH() {
        return getOrginalMessage() instanceof f ? ((f) getOrginalMessage()).HH() : "";
    }

    public ae Ou() {
        return this.bww;
    }
}
