package com.baidu.live.data;

import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class an {
    public int aMc;
    public ArrayList<am> aMd;

    public void parserJson(JSONObject jSONObject) {
        this.aMc = jSONObject.optInt("received");
        this.aMd = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("task_list");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    am amVar = new am();
                    amVar.parseJson(optJSONObject);
                    this.aMd.add(amVar);
                }
            }
        }
    }

    public boolean DY() {
        if (!ListUtils.isEmpty(this.aMd)) {
            Iterator<am> it = this.aMd.iterator();
            while (it.hasNext()) {
                if (it.next().DX()) {
                    return true;
                }
            }
        }
        return false;
    }

    public am DZ() {
        if (!ListUtils.isEmpty(this.aMd)) {
            Iterator<am> it = this.aMd.iterator();
            while (it.hasNext()) {
                am next = it.next();
                if (next.DV()) {
                    return next;
                }
            }
        }
        return null;
    }
}
