package com.baidu.cyberplayer.sdk.statistics;

import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class DpStatDataList {
    public ArrayList<DpStatItem> mList = new ArrayList<>();
    public int mType;

    public DpStatDataList(int i) {
        this.mType = i;
    }

    public void add(DpStatItem dpStatItem) {
        this.mList.add(dpStatItem);
    }

    public void clear() {
        ArrayList<DpStatItem> arrayList = this.mList;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    public void release() {
        if (this.mList != null) {
            this.mList = null;
        }
    }

    public int type() {
        return this.mType;
    }

    public JSONObject toJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return jSONObject;
        }
        int i = this.mType;
        if (i != 24321 && i != 24323 && i != 24322 && i != 20488) {
            jSONObject.put("type", i);
        }
        int size = this.mList.size();
        for (int i2 = 0; i2 < size; i2++) {
            DpStatItem dpStatItem = this.mList.get(i2);
            if (dpStatItem != null) {
                jSONObject.put(dpStatItem.getKey(), dpStatItem.getValue());
            }
        }
        return jSONObject;
    }
}
