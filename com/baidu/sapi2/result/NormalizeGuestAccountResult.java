package com.baidu.sapi2.result;

import android.app.Activity;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class NormalizeGuestAccountResult extends SapiResult {
    public static final int ERROR_CODE_PARSE_XML = -601;
    public static final String ERROR_MSG_PARSE_XML = "xml解析失败";

    /* renamed from: a  reason: collision with root package name */
    private HashMap<String, Integer> f3486a = new HashMap<>(3);
    public Activity activity;
    private String b;
    public boolean isAccountMerge;

    public NormalizeGuestAccountResult() {
        this.f3486a.put("sms_upgrade", 1);
        this.f3486a.put("sms_upgrade_exist", 2);
        this.f3486a.put("pwd_upgrade", 3);
    }

    public void finishActivity() {
    }

    public int getNormalizeWay() {
        if (this.f3486a.containsKey(this.b)) {
            return this.f3486a.get(this.b).intValue();
        }
        return 0;
    }

    public void setNormalizeWay(String str) {
        this.b = str;
    }
}
