package com.baidu.live.data;

import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class aq {
    public int aKT;
    public ArrayList<ap> aKU;
    public int aLa;
    public int aLc;
    public boolean aKV = false;
    public String aKW = "";
    public boolean aKX = false;
    public String aKY = "";
    public int aKZ = 0;
    public int aLb = 0;

    public void parserJson(JSONObject jSONObject) {
        this.aKT = jSONObject.optInt("received");
        this.aKU = new ArrayList<>();
        this.aKV = jSONObject.optInt("petal_task_switch", 0) == 1;
        this.aKX = jSONObject.optInt("redpacket_task_switch", 0) == 1;
        this.aKW = jSONObject.optString("task_url");
        this.aKY = jSONObject.optString("task_pendant_url");
        JSONArray optJSONArray = jSONObject.optJSONArray("task_list");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    ap apVar = new ap();
                    apVar.parseJson(optJSONObject);
                    a(apVar);
                    this.aKU.add(apVar);
                }
            }
        }
    }

    private void a(ap apVar) {
        if (apVar.aKM == 8) {
            if (apVar.aKQ != null) {
                this.aKZ = apVar.aKQ.aLd;
            }
            this.aLa = apVar.status;
        }
        if (apVar.aKM == 1 && apVar.aKQ != null) {
            if (apVar.aKQ != null) {
                this.aLb = apVar.aKQ.aLd;
            }
            this.aLc = apVar.status;
        }
    }

    public boolean Be() {
        if (!ListUtils.isEmpty(this.aKU)) {
            Iterator<ap> it = this.aKU.iterator();
            while (it.hasNext()) {
                if (it.next().Bd()) {
                    return true;
                }
            }
        }
        return false;
    }

    public ap Bf() {
        if (!ListUtils.isEmpty(this.aKU)) {
            Iterator<ap> it = this.aKU.iterator();
            while (it.hasNext()) {
                ap next = it.next();
                if (next.Bb()) {
                    return next;
                }
            }
        }
        return null;
    }
}
