package com.baidu.live.data;

import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class x {
    public int atO;
    public ArrayList<w> atP;

    public void parserJson(JSONObject jSONObject) {
        this.atO = jSONObject.optInt("received");
        this.atP = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("task_list");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    w wVar = new w();
                    wVar.parseJson(optJSONObject);
                    this.atP.add(wVar);
                }
            }
        }
    }

    public boolean uX() {
        if (!ListUtils.isEmpty(this.atP)) {
            Iterator<w> it = this.atP.iterator();
            while (it.hasNext()) {
                if (it.next().uW()) {
                    return true;
                }
            }
        }
        return false;
    }

    public w uY() {
        if (!ListUtils.isEmpty(this.atP)) {
            Iterator<w> it = this.atP.iterator();
            while (it.hasNext()) {
                w next = it.next();
                if (next.uU()) {
                    return next;
                }
            }
        }
        return null;
    }
}
