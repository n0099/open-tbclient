package com.baidu.sapi2.result;

import android.app.Activity;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class NormalizeGuestAccountResult extends SapiResult {
    public static final int ERROR_CODE_PARSE_XML = -601;
    public static final String ERROR_MSG_PARSE_XML = "xml解析失败";

    /* renamed from: a  reason: collision with root package name */
    private HashMap<String, Integer> f5014a = new HashMap<>(3);
    public Activity activity;

    /* renamed from: b  reason: collision with root package name */
    private String f5015b;
    public boolean isAccountMerge;

    public NormalizeGuestAccountResult() {
        this.f5014a.put("sms_upgrade", 1);
        this.f5014a.put("sms_upgrade_exist", 2);
        this.f5014a.put("pwd_upgrade", 3);
    }

    public void finishActivity() {
    }

    public int getNormalizeWay() {
        if (this.f5014a.containsKey(this.f5015b)) {
            return this.f5014a.get(this.f5015b).intValue();
        }
        return 0;
    }

    public void setNormalizeWay(String str) {
        this.f5015b = str;
    }
}
