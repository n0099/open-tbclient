package com.baidu.cyberplayer.sdk.statistics;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class DpStatPlaySession {
    public DpStatDataList mPlayCommonList = new DpStatDataList(DpStatConstants.SESSION_TYPE_PLAY_COMMON);
    public List<DpStatPlayAction> mActionList = new ArrayList();

    public void clear() {
        DpStatDataList dpStatDataList = this.mPlayCommonList;
        if (dpStatDataList != null) {
            dpStatDataList.clear();
        }
        List<DpStatPlayAction> list = this.mActionList;
        if (list != null) {
            list.clear();
        }
    }

    public void release() {
        DpStatDataList dpStatDataList = this.mPlayCommonList;
        if (dpStatDataList != null) {
            dpStatDataList.release();
            this.mPlayCommonList = null;
        }
        if (this.mActionList != null) {
            this.mActionList = null;
        }
    }

    public void add(int i, String str, String str2) {
        DpStatDataList dpStatDataList = this.mPlayCommonList;
        if (dpStatDataList != null && i == 24322) {
            dpStatDataList.add(new DpStatItem(i, str, str2));
        } else if (this.mActionList != null) {
            DpStatItem dpStatItem = new DpStatItem(i, str, str2);
            for (int i2 = 0; i2 < this.mActionList.size(); i2++) {
                DpStatPlayAction dpStatPlayAction = this.mActionList.get(i2);
                if (dpStatPlayAction.type() == i) {
                    dpStatPlayAction.add(dpStatItem);
                    return;
                }
            }
            DpStatPlayAction dpStatPlayAction2 = new DpStatPlayAction(i);
            dpStatPlayAction2.add(dpStatItem);
            this.mActionList.add(dpStatPlayAction2);
        }
    }

    public JSONObject toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        DpStatDataList dpStatDataList = this.mPlayCommonList;
        if (dpStatDataList != null) {
            dpStatDataList.toJson(jSONObject);
        }
        if (this.mActionList != null) {
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < this.mActionList.size(); i++) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("type", this.mActionList.get(i).type());
                if (this.mActionList.get(i).toJson(jSONObject2) != null) {
                    jSONArray.put(jSONObject2);
                }
            }
            if (jSONArray.length() > 0) {
                jSONObject.put("data", jSONArray);
            }
        }
        return jSONObject;
    }
}
