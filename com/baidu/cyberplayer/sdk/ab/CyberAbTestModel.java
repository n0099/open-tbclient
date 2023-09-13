package com.baidu.cyberplayer.sdk.ab;

import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.Utils;
import com.baidu.cyberplayer.sdk.context.ICyberMediaAbTest;
import com.baidu.cyberplayer.sdk.utils.NumberUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class CyberAbTestModel {
    public Map<String, String> mAbs;
    public String mKey;
    public String mOriginJson;

    public CyberAbTestModel(String str, String str2) {
        this.mKey = str;
        this.mOriginJson = str2;
        this.mAbs = Utils.JSONToMap(str2);
    }

    public int getIntValue(String str, int i) {
        return NumberUtils.parseIntSafely(getStringValue(str, i + ""), i);
    }

    public String getStringValue(String str, String str2) {
        Map<String, String> map = this.mAbs;
        if (map != null && !TextUtils.isEmpty(map.get(str))) {
            return this.mAbs.get(str);
        }
        return str2;
    }

    public static CyberAbTestModel createAbModel(String str) {
        ICyberMediaAbTest abTestInterface;
        if (CyberPlayerManager.getCyberMediaContext() == null || (abTestInterface = CyberPlayerManager.getCyberMediaContext().getAbTestInterface()) == null) {
            return null;
        }
        return new CyberAbTestModel(str, abTestInterface.getSwitch(str, ""));
    }

    public Map<String, String> getAllKV() {
        HashMap hashMap = new HashMap();
        if (this.mAbs.size() > 0) {
            hashMap.putAll(this.mAbs);
        }
        return hashMap;
    }

    public String getKey() {
        return this.mKey;
    }

    public String getOriginJson() {
        return this.mOriginJson;
    }
}
