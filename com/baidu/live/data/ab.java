package com.baidu.live.data;

import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ab {
    public int ayR;
    public ArrayList<aa> ayS;

    public void parserJson(JSONObject jSONObject) {
        this.ayR = jSONObject.optInt("received");
        this.ayS = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("task_list");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    aa aaVar = new aa();
                    aaVar.parseJson(optJSONObject);
                    this.ayS.add(aaVar);
                }
            }
        }
    }

    public boolean wm() {
        if (!ListUtils.isEmpty(this.ayS)) {
            Iterator<aa> it = this.ayS.iterator();
            while (it.hasNext()) {
                if (it.next().wl()) {
                    return true;
                }
            }
        }
        return false;
    }

    public aa wn() {
        if (!ListUtils.isEmpty(this.ayS)) {
            Iterator<aa> it = this.ayS.iterator();
            while (it.hasNext()) {
                aa next = it.next();
                if (next.wj()) {
                    return next;
                }
            }
        }
        return null;
    }
}
