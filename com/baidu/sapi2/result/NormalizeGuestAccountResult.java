package com.baidu.sapi2.result;

import android.app.Activity;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class NormalizeGuestAccountResult extends SapiResult {
    public static final int ERROR_CODE_PARSE_XML = -601;
    public static final String ERROR_MSG_PARSE_XML = "xml解析失败";

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, Integer> f11310a;
    public Activity activity;

    /* renamed from: b  reason: collision with root package name */
    public String f11311b;
    public boolean isAccountMerge;

    public NormalizeGuestAccountResult() {
        HashMap<String, Integer> hashMap = new HashMap<>(3);
        this.f11310a = hashMap;
        hashMap.put("sms_upgrade", 1);
        this.f11310a.put("sms_upgrade_exist", 2);
        this.f11310a.put("pwd_upgrade", 3);
    }

    public void finishActivity() {
    }

    public int getNormalizeWay() {
        if (this.f11310a.containsKey(this.f11311b)) {
            return this.f11310a.get(this.f11311b).intValue();
        }
        return 0;
    }

    public void setNormalizeWay(String str) {
        this.f11311b = str;
    }
}
