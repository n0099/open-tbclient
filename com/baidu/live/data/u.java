package com.baidu.live.data;

import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class u {
    public int Zl;
    public ArrayList<t> Zm;

    public void parserJson(JSONObject jSONObject) {
        this.Zl = jSONObject.optInt("received");
        this.Zm = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("task_list");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    t tVar = new t();
                    tVar.parseJson(optJSONObject);
                    this.Zm.add(tVar);
                }
            }
        }
    }

    public boolean pR() {
        if (!ListUtils.isEmpty(this.Zm)) {
            Iterator<t> it = this.Zm.iterator();
            while (it.hasNext()) {
                if (it.next().pQ()) {
                    return true;
                }
            }
        }
        return false;
    }

    public t pS() {
        if (!ListUtils.isEmpty(this.Zm)) {
            Iterator<t> it = this.Zm.iterator();
            while (it.hasNext()) {
                t next = it.next();
                if (next.pO()) {
                    return next;
                }
            }
        }
        return null;
    }
}
