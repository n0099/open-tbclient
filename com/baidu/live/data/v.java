package com.baidu.live.data;

import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class v {
    public int abe;
    public ArrayList<u> abf;

    public void parserJson(JSONObject jSONObject) {
        this.abe = jSONObject.optInt("received");
        this.abf = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("task_list");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    u uVar = new u();
                    uVar.parseJson(optJSONObject);
                    this.abf.add(uVar);
                }
            }
        }
    }

    public boolean qC() {
        if (!ListUtils.isEmpty(this.abf)) {
            Iterator<u> it = this.abf.iterator();
            while (it.hasNext()) {
                if (it.next().qB()) {
                    return true;
                }
            }
        }
        return false;
    }

    public u qD() {
        if (!ListUtils.isEmpty(this.abf)) {
            Iterator<u> it = this.abf.iterator();
            while (it.hasNext()) {
                u next = it.next();
                if (next.qz()) {
                    return next;
                }
            }
        }
        return null;
    }
}
