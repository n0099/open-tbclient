package com.baidu.live.data;

import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class q {
    public int Si;
    public ArrayList<p> Sj;

    public void parserJson(JSONObject jSONObject) {
        this.Si = jSONObject.optInt("received");
        this.Sj = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("task_list");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    p pVar = new p();
                    pVar.parseJson(optJSONObject);
                    this.Sj.add(pVar);
                }
            }
        }
    }

    public boolean os() {
        if (!ListUtils.isEmpty(this.Sj)) {
            Iterator<p> it = this.Sj.iterator();
            while (it.hasNext()) {
                if (it.next().or()) {
                    return true;
                }
            }
        }
        return false;
    }

    public p ot() {
        if (!ListUtils.isEmpty(this.Sj)) {
            Iterator<p> it = this.Sj.iterator();
            while (it.hasNext()) {
                p next = it.next();
                if (next.op()) {
                    return next;
                }
            }
        }
        return null;
    }
}
