package com.baidu.cyberplayer.sdk.statistics;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class DpStatPlayAction {
    public final int actionType;
    public DpStatDataList mBaseList = new DpStatDataList(DpStatConstants.SESSION_TYPE_PLAY_COMMON);
    public List<DpStatDataList> mSubDataList = new ArrayList();

    public DpStatPlayAction(int i) {
        this.actionType = i;
    }

    public void add(DpStatItem dpStatItem) {
        this.mBaseList.add(dpStatItem);
    }

    public void clear() {
        DpStatDataList dpStatDataList = this.mBaseList;
        if (dpStatDataList != null) {
            dpStatDataList.clear();
        }
        List<DpStatDataList> list = this.mSubDataList;
        if (list != null) {
            list.clear();
        }
    }

    public void release() {
        DpStatDataList dpStatDataList = this.mBaseList;
        if (dpStatDataList != null) {
            dpStatDataList.release();
        }
        if (this.mSubDataList != null) {
            this.mSubDataList = null;
        }
    }

    public int type() {
        return this.actionType;
    }

    public JSONObject toJson(JSONObject jSONObject) throws JSONException {
        this.mBaseList.toJson(jSONObject);
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < this.mSubDataList.size(); i++) {
            JSONObject jSONObject2 = new JSONObject();
            if (this.mSubDataList.get(i).toJson(jSONObject2) != null) {
                jSONArray.put(jSONObject2);
            }
        }
        if (jSONArray.length() != 0) {
            jSONObject.put("data", jSONArray);
        }
        return jSONObject;
    }
}
