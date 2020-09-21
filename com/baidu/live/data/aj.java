package com.baidu.live.data;

import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class aj {
    public int aJb;
    public ArrayList<ai> aJc;

    public void parserJson(JSONObject jSONObject) {
        this.aJb = jSONObject.optInt("received");
        this.aJc = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("task_list");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    ai aiVar = new ai();
                    aiVar.parseJson(optJSONObject);
                    this.aJc.add(aiVar);
                }
            }
        }
    }

    public boolean Df() {
        if (!ListUtils.isEmpty(this.aJc)) {
            Iterator<ai> it = this.aJc.iterator();
            while (it.hasNext()) {
                if (it.next().De()) {
                    return true;
                }
            }
        }
        return false;
    }

    public ai Dg() {
        if (!ListUtils.isEmpty(this.aJc)) {
            Iterator<ai> it = this.aJc.iterator();
            while (it.hasNext()) {
                ai next = it.next();
                if (next.Dc()) {
                    return next;
                }
            }
        }
        return null;
    }
}
