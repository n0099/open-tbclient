package com.baidu.live.data;

import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class an {
    public int aNN;
    public ArrayList<am> aNO;

    public void parserJson(JSONObject jSONObject) {
        this.aNN = jSONObject.optInt("received");
        this.aNO = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("task_list");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    am amVar = new am();
                    amVar.parseJson(optJSONObject);
                    this.aNO.add(amVar);
                }
            }
        }
    }

    public boolean EH() {
        if (!ListUtils.isEmpty(this.aNO)) {
            Iterator<am> it = this.aNO.iterator();
            while (it.hasNext()) {
                if (it.next().EG()) {
                    return true;
                }
            }
        }
        return false;
    }

    public am EI() {
        if (!ListUtils.isEmpty(this.aNO)) {
            Iterator<am> it = this.aNO.iterator();
            while (it.hasNext()) {
                am next = it.next();
                if (next.EE()) {
                    return next;
                }
            }
        }
        return null;
    }
}
