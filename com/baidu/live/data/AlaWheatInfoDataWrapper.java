package com.baidu.live.data;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaWheatInfoDataWrapper implements Serializable, Cloneable {
    private List<AlaWheatInfoData> anchorWheatLists;
    private List<AlaWheatInfoData> hostWheatLists;

    public AlaWheatInfoDataWrapper(String str) {
        try {
            if (this.hostWheatLists == null) {
                this.hostWheatLists = new ArrayList();
            }
            if (this.anchorWheatLists == null) {
                this.anchorWheatLists = new ArrayList();
            }
            this.hostWheatLists.clear();
            this.anchorWheatLists.clear();
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != null) {
                JSONArray jSONArray = jSONObject.getJSONArray("host");
                if (jSONArray != null && jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        AlaWheatInfoData alaWheatInfoData = new AlaWheatInfoData();
                        alaWheatInfoData.parseJson((JSONObject) jSONArray.opt(i));
                        if (!TextUtils.isEmpty(alaWheatInfoData.uk)) {
                            this.hostWheatLists.add(alaWheatInfoData);
                        } else {
                            this.hostWheatLists.add(null);
                        }
                    }
                }
                JSONArray jSONArray2 = jSONObject.getJSONArray("anchor");
                if (jSONArray2 != null && jSONArray2.length() > 0) {
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        AlaWheatInfoData alaWheatInfoData2 = new AlaWheatInfoData();
                        alaWheatInfoData2.parseJson((JSONObject) jSONArray2.opt(i2));
                        if (!TextUtils.isEmpty(alaWheatInfoData2.uk)) {
                            this.anchorWheatLists.add(alaWheatInfoData2);
                        } else {
                            this.anchorWheatLists.add(null);
                        }
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void parseJson(String str) throws Exception {
    }

    public List<AlaWheatInfoData> getHostWheatLists() {
        return this.hostWheatLists;
    }

    public List<AlaWheatInfoData> getAnchorWheatLists() {
        return this.anchorWheatLists;
    }
}
