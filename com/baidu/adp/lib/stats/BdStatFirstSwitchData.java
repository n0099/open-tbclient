package com.baidu.adp.lib.stats;

import com.baidu.adp.lib.util.BdLog;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class BdStatFirstSwitchData implements Serializable {
    private static final long serialVersionUID = 305089173029776844L;
    private BdStatCommonSwitchData common = new BdStatCommonSwitchData();
    private ArrayList<BdStatSecondSwitchData> children = new ArrayList<>();

    public BdStatCommonSwitchData getCommon() {
        return this.common;
    }

    public void setCommon(BdStatCommonSwitchData bdStatCommonSwitchData) {
        this.common = bdStatCommonSwitchData;
    }

    public ArrayList<BdStatSecondSwitchData> getChildren() {
        return this.children;
    }

    public void setChildren(ArrayList<BdStatSecondSwitchData> arrayList) {
        this.children = arrayList;
    }

    public void parserJson(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            try {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                int length = jSONArray.length();
                int i = 1;
                while (i < length) {
                    JSONObject optJSONObject2 = jSONArray.optJSONObject(i);
                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject("version");
                    if (optJSONObject3 == null || !m(optJSONObject3.optString("min"), optJSONObject3.optString("max"))) {
                        optJSONObject2 = optJSONObject;
                    }
                    i++;
                    optJSONObject = optJSONObject2;
                }
                this.common.parserJson(optJSONObject.optJSONObject("common"));
                JSONArray optJSONArray = optJSONObject.optJSONArray("children");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        BdStatSecondSwitchData bdStatSecondSwitchData = new BdStatSecondSwitchData();
                        bdStatSecondSwitchData.parserJson(optJSONArray.optJSONObject(i2));
                        this.children.add(bdStatSecondSwitchData);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    private boolean m(String str, String str2) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        String eq = f.er().eq();
        if (com.baidu.adp.lib.util.l.aA(eq)) {
            return false;
        }
        int[] af = af(eq);
        int[] af2 = af(str);
        int[] af3 = af(str2);
        if (af != null) {
            if (af2 != null) {
                z = af[0] > af2[0] || (af[0] == af2[0] && (af[1] > af2[1] || (af[1] == af2[1] && af[2] >= af2[2])));
            } else {
                z = false;
            }
            if (af3 != null) {
                z2 = af3[0] > af[0] || (af3[0] == af[0] && (af3[1] > af[1] || (af3[1] == af[1] && af3[2] >= af[2])));
            } else {
                z2 = false;
            }
            if (af2 != null && af3 != null) {
                if (!z || !z2) {
                    z3 = false;
                }
                return z3;
            } else if (af2 == null || af3 != null) {
                if (af2 != null || af3 == null) {
                    return false;
                }
                return z2;
            } else {
                return z;
            }
        }
        return false;
    }

    private int[] af(String str) {
        String[] split;
        if (com.baidu.adp.lib.util.l.aA(str) || (split = str.split("\\.")) == null || split.length <= 0) {
            return null;
        }
        int[] iArr = new int[3];
        iArr[0] = com.baidu.adp.lib.g.c.f(split[0], -1);
        iArr[1] = split.length > 1 ? com.baidu.adp.lib.g.c.f(split[1], -1) : -1;
        iArr[2] = split.length > 2 ? com.baidu.adp.lib.g.c.f(split[2], -1) : -1;
        return iArr;
    }
}
