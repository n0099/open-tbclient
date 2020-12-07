package com.baidu.live.data;

import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ao {
    public int aOZ;
    public ArrayList<an> aPa;

    public void parserJson(JSONObject jSONObject) {
        this.aOZ = jSONObject.optInt("received");
        this.aPa = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("task_list");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    an anVar = new an();
                    anVar.parseJson(optJSONObject);
                    this.aPa.add(anVar);
                }
            }
        }
    }

    public boolean FJ() {
        if (!ListUtils.isEmpty(this.aPa)) {
            Iterator<an> it = this.aPa.iterator();
            while (it.hasNext()) {
                if (it.next().FI()) {
                    return true;
                }
            }
        }
        return false;
    }

    public an FK() {
        if (!ListUtils.isEmpty(this.aPa)) {
            Iterator<an> it = this.aPa.iterator();
            while (it.hasNext()) {
                an next = it.next();
                if (next.FG()) {
                    return next;
                }
            }
        }
        return null;
    }
}
