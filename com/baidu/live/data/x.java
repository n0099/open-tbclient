package com.baidu.live.data;

import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class x {
    public int atI;
    public ArrayList<w> atJ;

    public void parserJson(JSONObject jSONObject) {
        this.atI = jSONObject.optInt("received");
        this.atJ = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("task_list");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    w wVar = new w();
                    wVar.parseJson(optJSONObject);
                    this.atJ.add(wVar);
                }
            }
        }
    }

    public boolean uY() {
        if (!ListUtils.isEmpty(this.atJ)) {
            Iterator<w> it = this.atJ.iterator();
            while (it.hasNext()) {
                if (it.next().uX()) {
                    return true;
                }
            }
        }
        return false;
    }

    public w uZ() {
        if (!ListUtils.isEmpty(this.atJ)) {
            Iterator<w> it = this.atJ.iterator();
            while (it.hasNext()) {
                w next = it.next();
                if (next.uV()) {
                    return next;
                }
            }
        }
        return null;
    }
}
