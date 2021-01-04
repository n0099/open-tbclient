package com.baidu.live.data;

import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class aq {
    public int aPG;
    public ArrayList<ap> aPH;
    public int aPN;
    public int aPP;
    public boolean aPI = false;
    public String aPJ = "";
    public boolean aPK = false;
    public String aPL = "";
    public int aPM = 0;
    public int aPO = 0;

    public void parserJson(JSONObject jSONObject) {
        this.aPG = jSONObject.optInt("received");
        this.aPH = new ArrayList<>();
        this.aPI = jSONObject.optInt("petal_task_switch", 0) == 1;
        this.aPK = jSONObject.optInt("redpacket_task_switch", 0) == 1;
        this.aPJ = jSONObject.optString("task_url");
        this.aPL = jSONObject.optString("task_pendant_url");
        JSONArray optJSONArray = jSONObject.optJSONArray("task_list");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    ap apVar = new ap();
                    apVar.parseJson(optJSONObject);
                    a(apVar);
                    this.aPH.add(apVar);
                }
            }
        }
    }

    private void a(ap apVar) {
        if (apVar.aPz == 8) {
            if (apVar.aPD != null) {
                this.aPM = apVar.aPD.aPQ;
            }
            this.aPN = apVar.status;
        }
        if (apVar.aPz == 1 && apVar.aPD != null) {
            if (apVar.aPD != null) {
                this.aPO = apVar.aPD.aPQ;
            }
            this.aPP = apVar.status;
        }
    }

    public boolean EZ() {
        if (!ListUtils.isEmpty(this.aPH)) {
            Iterator<ap> it = this.aPH.iterator();
            while (it.hasNext()) {
                if (it.next().EY()) {
                    return true;
                }
            }
        }
        return false;
    }

    public ap Fa() {
        if (!ListUtils.isEmpty(this.aPH)) {
            Iterator<ap> it = this.aPH.iterator();
            while (it.hasNext()) {
                ap next = it.next();
                if (next.EW()) {
                    return next;
                }
            }
        }
        return null;
    }
}
