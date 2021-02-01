package com.baidu.live.data;

import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class au {
    public int aNP;
    public ArrayList<at> aNQ;
    public int aNW;
    public int aNY;
    public boolean aNR = false;
    public String aNS = "";
    public boolean aNT = false;
    public String aNU = "";
    public int aNV = 0;
    public int aNX = 0;

    public void parserJson(JSONObject jSONObject) {
        this.aNP = jSONObject.optInt("received");
        this.aNQ = new ArrayList<>();
        this.aNR = jSONObject.optInt("petal_task_switch", 0) == 1;
        this.aNT = jSONObject.optInt("redpacket_task_switch", 0) == 1;
        this.aNS = jSONObject.optString("task_url");
        this.aNU = jSONObject.optString("task_pendant_url");
        JSONArray optJSONArray = jSONObject.optJSONArray("task_list");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    at atVar = new at();
                    atVar.parseJson(optJSONObject);
                    a(atVar);
                    this.aNQ.add(atVar);
                }
            }
        }
    }

    private void a(at atVar) {
        if (atVar.aNI == 8) {
            if (atVar.aNM != null) {
                this.aNV = atVar.aNM.aNZ;
            }
            this.aNW = atVar.status;
        }
        if (atVar.aNI == 1 && atVar.aNM != null) {
            if (atVar.aNM != null) {
                this.aNX = atVar.aNM.aNZ;
            }
            this.aNY = atVar.status;
        }
    }

    public boolean Cr() {
        if (!ListUtils.isEmpty(this.aNQ)) {
            Iterator<at> it = this.aNQ.iterator();
            while (it.hasNext()) {
                if (it.next().Cq()) {
                    return true;
                }
            }
        }
        return false;
    }

    public at Cs() {
        if (!ListUtils.isEmpty(this.aNQ)) {
            Iterator<at> it = this.aNQ.iterator();
            while (it.hasNext()) {
                at next = it.next();
                if (next.Co()) {
                    return next;
                }
            }
        }
        return null;
    }
}
