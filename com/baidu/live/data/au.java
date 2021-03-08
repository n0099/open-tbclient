package com.baidu.live.data;

import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class au {
    public int aPp;
    public ArrayList<at> aPq;
    public int aPw;
    public int aPy;
    public boolean aPr = false;
    public String aPs = "";
    public boolean aPt = false;
    public String aPu = "";
    public int aPv = 0;
    public int aPx = 0;

    public void parserJson(JSONObject jSONObject) {
        this.aPp = jSONObject.optInt("received");
        this.aPq = new ArrayList<>();
        this.aPr = jSONObject.optInt("petal_task_switch", 0) == 1;
        this.aPt = jSONObject.optInt("redpacket_task_switch", 0) == 1;
        this.aPs = jSONObject.optString("task_url");
        this.aPu = jSONObject.optString("task_pendant_url");
        JSONArray optJSONArray = jSONObject.optJSONArray("task_list");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    at atVar = new at();
                    atVar.parseJson(optJSONObject);
                    a(atVar);
                    this.aPq.add(atVar);
                }
            }
        }
    }

    private void a(at atVar) {
        if (atVar.aPi == 8) {
            if (atVar.aPm != null) {
                this.aPv = atVar.aPm.aPz;
            }
            this.aPw = atVar.status;
        }
        if (atVar.aPi == 1 && atVar.aPm != null) {
            if (atVar.aPm != null) {
                this.aPx = atVar.aPm.aPz;
            }
            this.aPy = atVar.status;
        }
    }

    public boolean Cu() {
        if (!ListUtils.isEmpty(this.aPq)) {
            Iterator<at> it = this.aPq.iterator();
            while (it.hasNext()) {
                if (it.next().Ct()) {
                    return true;
                }
            }
        }
        return false;
    }

    public at Cv() {
        if (!ListUtils.isEmpty(this.aPq)) {
            Iterator<at> it = this.aPq.iterator();
            while (it.hasNext()) {
                at next = it.next();
                if (next.Cr()) {
                    return next;
                }
            }
        }
        return null;
    }
}
