package com.baidu.live.data;

import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ac {
    public int aCv;
    public ArrayList<ab> aCw;

    public void parserJson(JSONObject jSONObject) {
        this.aCv = jSONObject.optInt("received");
        this.aCw = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("task_list");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    ab abVar = new ab();
                    abVar.parseJson(optJSONObject);
                    this.aCw.add(abVar);
                }
            }
        }
    }

    public boolean xm() {
        if (!ListUtils.isEmpty(this.aCw)) {
            Iterator<ab> it = this.aCw.iterator();
            while (it.hasNext()) {
                if (it.next().xl()) {
                    return true;
                }
            }
        }
        return false;
    }

    public ab xn() {
        if (!ListUtils.isEmpty(this.aCw)) {
            Iterator<ab> it = this.aCw.iterator();
            while (it.hasNext()) {
                ab next = it.next();
                if (next.xj()) {
                    return next;
                }
            }
        }
        return null;
    }
}
