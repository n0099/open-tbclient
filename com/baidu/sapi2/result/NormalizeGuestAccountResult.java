package com.baidu.sapi2.result;

import android.app.Activity;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class NormalizeGuestAccountResult extends SapiResult {
    public static final int ERROR_CODE_PARSE_XML = -601;
    public static final String ERROR_MSG_PARSE_XML = "xml解析失败";
    private HashMap<String, Integer> a = new HashMap<>(3);
    public Activity activity;
    private String b;
    public boolean isAccountMerge;

    public NormalizeGuestAccountResult() {
        this.a.put("sms_upgrade", 1);
        this.a.put("sms_upgrade_exist", 2);
        this.a.put("pwd_upgrade", 3);
    }

    public void finishActivity() {
    }

    public int getNormalizeWay() {
        if (this.a.containsKey(this.b)) {
            return this.a.get(this.b).intValue();
        }
        return 0;
    }

    public void setNormalizeWay(String str) {
        this.b = str;
    }
}
