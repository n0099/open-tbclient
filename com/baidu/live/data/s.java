package com.baidu.live.data;

import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class s {
    public int YX;
    public ArrayList<r> YY;

    public void parserJson(JSONObject jSONObject) {
        this.YX = jSONObject.optInt("received");
        this.YY = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("task_list");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    r rVar = new r();
                    rVar.parseJson(optJSONObject);
                    this.YY.add(rVar);
                }
            }
        }
    }

    public boolean pN() {
        if (!ListUtils.isEmpty(this.YY)) {
            Iterator<r> it = this.YY.iterator();
            while (it.hasNext()) {
                if (it.next().pM()) {
                    return true;
                }
            }
        }
        return false;
    }

    public r pO() {
        if (!ListUtils.isEmpty(this.YY)) {
            Iterator<r> it = this.YY.iterator();
            while (it.hasNext()) {
                r next = it.next();
                if (next.pK()) {
                    return next;
                }
            }
        }
        return null;
    }
}
