package com.baidu.live.data;

import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class aj {
    public int aMg;
    public ArrayList<ai> aMh;

    public void parserJson(JSONObject jSONObject) {
        this.aMg = jSONObject.optInt("received");
        this.aMh = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("task_list");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    ai aiVar = new ai();
                    aiVar.parseJson(optJSONObject);
                    this.aMh.add(aiVar);
                }
            }
        }
    }

    public boolean Ec() {
        if (!ListUtils.isEmpty(this.aMh)) {
            Iterator<ai> it = this.aMh.iterator();
            while (it.hasNext()) {
                if (it.next().Eb()) {
                    return true;
                }
            }
        }
        return false;
    }

    public ai Ed() {
        if (!ListUtils.isEmpty(this.aMh)) {
            Iterator<ai> it = this.aMh.iterator();
            while (it.hasNext()) {
                ai next = it.next();
                if (next.DZ()) {
                    return next;
                }
            }
        }
        return null;
    }
}
