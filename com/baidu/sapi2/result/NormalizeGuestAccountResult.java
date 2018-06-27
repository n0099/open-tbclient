package com.baidu.sapi2.result;

import android.app.Activity;
/* loaded from: classes.dex */
public class NormalizeGuestAccountResult extends SapiResult {
    public static final int ERROR_CODE_PARSE_XML = -601;
    public static final String ERROR_MSG_PARSE_XML = "xml解析失败";
    public Activity activity;
    public boolean isAccountMerge;

    public void finishActivity() {
    }
}
