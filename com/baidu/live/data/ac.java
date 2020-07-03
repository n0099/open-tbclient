package com.baidu.live.data;

import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ac {
    public int aBi;
    public ArrayList<ab> aBj;

    public void parserJson(JSONObject jSONObject) {
        this.aBi = jSONObject.optInt("received");
        this.aBj = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("task_list");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    ab abVar = new ab();
                    abVar.parseJson(optJSONObject);
                    this.aBj.add(abVar);
                }
            }
        }
    }

    public boolean wK() {
        if (!ListUtils.isEmpty(this.aBj)) {
            Iterator<ab> it = this.aBj.iterator();
            while (it.hasNext()) {
                if (it.next().wJ()) {
                    return true;
                }
            }
        }
        return false;
    }

    public ab wL() {
        if (!ListUtils.isEmpty(this.aBj)) {
            Iterator<ab> it = this.aBj.iterator();
            while (it.hasNext()) {
                ab next = it.next();
                if (next.wH()) {
                    return next;
                }
            }
        }
        return null;
    }
}
