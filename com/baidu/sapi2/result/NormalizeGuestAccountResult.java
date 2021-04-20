package com.baidu.sapi2.result;

import android.app.Activity;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class NormalizeGuestAccountResult extends SapiResult {
    public static final int ERROR_CODE_PARSE_XML = -601;
    public static final String ERROR_MSG_PARSE_XML = "xml解析失败";

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, Integer> f10894a;
    public Activity activity;

    /* renamed from: b  reason: collision with root package name */
    public String f10895b;
    public boolean isAccountMerge;

    public NormalizeGuestAccountResult() {
        HashMap<String, Integer> hashMap = new HashMap<>(3);
        this.f10894a = hashMap;
        hashMap.put("sms_upgrade", 1);
        this.f10894a.put("sms_upgrade_exist", 2);
        this.f10894a.put("pwd_upgrade", 3);
    }

    public void finishActivity() {
    }

    public int getNormalizeWay() {
        if (this.f10894a.containsKey(this.f10895b)) {
            return this.f10894a.get(this.f10895b).intValue();
        }
        return 0;
    }

    public void setNormalizeWay(String str) {
        this.f10895b = str;
    }
}
