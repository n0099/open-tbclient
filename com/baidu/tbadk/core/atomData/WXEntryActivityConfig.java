package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class WXEntryActivityConfig extends IntentConfig {
    public static final String ACTION_WX_SHARE_RESULT = "com.baidu.tieba.share.wx.result";
    public static final String KEY_RESULT_WX_SHARE = "key_share_wx";
    public static final String WX_SHARE_CANCLE = "wx_share_cancle";
    public static final String WX_SHARE_FAIL = "wx_share_fail";
    public static final String WX_SHARE_SUCCESS = "wx_share_success";

    public WXEntryActivityConfig(Context context, int i2) {
        super(context);
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i2);
    }
}
