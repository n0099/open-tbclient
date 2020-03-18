package com.baidu.live.data;

import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class v {
    public int abo;
    public ArrayList<u> abp;

    public void parserJson(JSONObject jSONObject) {
        this.abo = jSONObject.optInt("received");
        this.abp = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("task_list");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    u uVar = new u();
                    uVar.parseJson(optJSONObject);
                    this.abp.add(uVar);
                }
            }
        }
    }

    public boolean qH() {
        if (!ListUtils.isEmpty(this.abp)) {
            Iterator<u> it = this.abp.iterator();
            while (it.hasNext()) {
                if (it.next().qG()) {
                    return true;
                }
            }
        }
        return false;
    }

    public u qI() {
        if (!ListUtils.isEmpty(this.abp)) {
            Iterator<u> it = this.abp.iterator();
            while (it.hasNext()) {
                u next = it.next();
                if (next.qE()) {
                    return next;
                }
            }
        }
        return null;
    }
}
