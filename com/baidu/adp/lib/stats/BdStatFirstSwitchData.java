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
                    if (optJSONObject3 == null || !q(optJSONObject3.optString("min"), optJSONObject3.optString("max"))) {
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

    private boolean q(String str, String str2) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        String ep = f.eq().ep();
        if (com.baidu.adp.lib.util.k.isEmpty(ep)) {
            return false;
        }
        int[] aj = aj(ep);
        int[] aj2 = aj(str);
        int[] aj3 = aj(str2);
        if (aj != null) {
            if (aj2 != null) {
                z = aj[0] > aj2[0] || (aj[0] == aj2[0] && (aj[1] > aj2[1] || (aj[1] == aj2[1] && aj[2] >= aj2[2])));
            } else {
                z = false;
            }
            if (aj3 != null) {
                z2 = aj3[0] > aj[0] || (aj3[0] == aj[0] && (aj3[1] > aj[1] || (aj3[1] == aj[1] && aj3[2] >= aj[2])));
            } else {
                z2 = false;
            }
            if (aj2 != null && aj3 != null) {
                if (!z || !z2) {
                    z3 = false;
                }
                return z3;
            } else if (aj2 == null || aj3 != null) {
                if (aj2 != null || aj3 == null) {
                    return false;
                }
                return z2;
            } else {
                return z;
            }
        }
        return false;
    }

    private int[] aj(String str) {
        String[] split;
        if (com.baidu.adp.lib.util.k.isEmpty(str) || (split = str.split("\\.")) == null || split.length <= 0) {
            return null;
        }
        int[] iArr = new int[3];
        iArr[0] = com.baidu.adp.lib.g.c.toInt(split[0], -1);
        iArr[1] = split.length > 1 ? com.baidu.adp.lib.g.c.toInt(split[1], -1) : -1;
        iArr[2] = split.length > 2 ? com.baidu.adp.lib.g.c.toInt(split[2], -1) : -1;
        return iArr;
    }
}
