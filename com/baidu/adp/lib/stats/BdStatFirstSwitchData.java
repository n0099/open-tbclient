package com.baidu.adp.lib.stats;

import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class BdStatFirstSwitchData implements Serializable {
    private static final long serialVersionUID = 305089173029776844L;
    private BdStatCommonSwitchData common = new BdStatCommonSwitchData();
    private ArrayList<BdStatSecondSwitchData> children = new ArrayList<>();

    public BdStatCommonSwitchData getCommon() {
        return this.common;
    }

    public void setCommon(BdStatCommonSwitchData bdStatCommonSwitchData) {
        this.common = bdStatCommonSwitchData;
    }

    public ArrayList<BdStatSecondSwitchData> getChildren() {
        return this.children;
    }

    public void setChildren(ArrayList<BdStatSecondSwitchData> arrayList) {
        this.children = arrayList;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.common.parserJson(jSONObject.optJSONObject("common"));
                JSONArray optJSONArray = jSONObject.optJSONArray("children");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        BdStatSecondSwitchData bdStatSecondSwitchData = new BdStatSecondSwitchData();
                        bdStatSecondSwitchData.parserJson(optJSONArray.optJSONObject(i));
                        this.children.add(bdStatSecondSwitchData);
                    }
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.a(getClass(), "parserJson", e);
            }
        }
    }
}
