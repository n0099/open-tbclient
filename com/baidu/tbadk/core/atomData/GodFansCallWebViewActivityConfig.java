package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
/* loaded from: classes.dex */
public class GodFansCallWebViewActivityConfig extends TbWebViewActivityConfig {
    public static final String IS_REFRESH = "result_refresh";
    private static String JUMP_URL = "http://c.tieba.baidu.com/mo/q/god/fansCall";

    public GodFansCallWebViewActivityConfig(Context context, String str, int i) {
        super(context, "", JUMP_URL + TbWebViewActivityConfig.JUMP_PARAMS + "&tid=" + str, false);
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
    }
}
