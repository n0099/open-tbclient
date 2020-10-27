package com.baidu.live.data;

import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class am {
    public int aML;
    public ArrayList<al> aMM;

    public void parserJson(JSONObject jSONObject) {
        this.aML = jSONObject.optInt("received");
        this.aMM = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("task_list");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    al alVar = new al();
                    alVar.parseJson(optJSONObject);
                    this.aMM.add(alVar);
                }
            }
        }
    }

    public boolean El() {
        if (!ListUtils.isEmpty(this.aMM)) {
            Iterator<al> it = this.aMM.iterator();
            while (it.hasNext()) {
                if (it.next().Ek()) {
                    return true;
                }
            }
        }
        return false;
    }

    public al Em() {
        if (!ListUtils.isEmpty(this.aMM)) {
            Iterator<al> it = this.aMM.iterator();
            while (it.hasNext()) {
                al next = it.next();
                if (next.Ei()) {
                    return next;
                }
            }
        }
        return null;
    }
}
