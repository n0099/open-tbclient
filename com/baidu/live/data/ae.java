package com.baidu.live.data;

import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ae {
    public int aHF;
    public ArrayList<ad> aHG;

    public void parserJson(JSONObject jSONObject) {
        this.aHF = jSONObject.optInt("received");
        this.aHG = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("task_list");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    ad adVar = new ad();
                    adVar.parseJson(optJSONObject);
                    this.aHG.add(adVar);
                }
            }
        }
    }

    public boolean CP() {
        if (!ListUtils.isEmpty(this.aHG)) {
            Iterator<ad> it = this.aHG.iterator();
            while (it.hasNext()) {
                if (it.next().CO()) {
                    return true;
                }
            }
        }
        return false;
    }

    public ad CQ() {
        if (!ListUtils.isEmpty(this.aHG)) {
            Iterator<ad> it = this.aHG.iterator();
            while (it.hasNext()) {
                ad next = it.next();
                if (next.CM()) {
                    return next;
                }
            }
        }
        return null;
    }
}
