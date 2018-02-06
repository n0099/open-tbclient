package com.baidu.sapi2.shell.result;

import android.app.Activity;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.utils.enums.AccountType;
/* loaded from: classes2.dex */
public class WebAuthResult extends SapiResult {
    public AccountType accountType = AccountType.UNKNOWN;
    public Activity activity;
}
