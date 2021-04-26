package com.baidu.sapi2.result;

import android.app.Activity;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class NormalizeGuestAccountResult extends SapiResult {
    public static final int ERROR_CODE_PARSE_XML = -601;
    public static final String ERROR_MSG_PARSE_XML = "xml解析失败";
    public Activity activity;
    public boolean isAccountMerge;
    public String normalizeWay;
    public HashMap<String, Integer> normalizeWayMap;

    public NormalizeGuestAccountResult() {
        HashMap<String, Integer> hashMap = new HashMap<>(3);
        this.normalizeWayMap = hashMap;
        hashMap.put("sms_upgrade", 1);
        this.normalizeWayMap.put("sms_upgrade_exist", 2);
        this.normalizeWayMap.put("pwd_upgrade", 3);
    }

    public void finishActivity() {
    }

    public int getNormalizeWay() {
        if (this.normalizeWayMap.containsKey(this.normalizeWay)) {
            return this.normalizeWayMap.get(this.normalizeWay).intValue();
        }
        return 0;
    }

    public void setNormalizeWay(String str) {
        this.normalizeWay = str;
    }
}
