package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class SupplementSignActivityConfig extends TbWebViewActivityConfig {
    public static String CONTINUOUS_SIGN_ALL_DAYS = "continuous_sign_all_days";
    public static String SUPPLEMENT_SIGN_DAYS = "supplement_sign_days";
    public static String SIGN_BONUS_POINT = "signBonusPoint";
    public static String FORUM_ID = "forum_id";
    public static String JUMP_URL = "http://tieba.baidu.com/mo/q/resign/index";

    public SupplementSignActivityConfig(Context context, int i, int i2) {
        super(context, context.getResources().getString(n.j.resign), String.valueOf(JUMP_URL) + "?forum_id=" + i + "&_client_version=" + TbConfig.getVersion(), true, true, true);
        getIntent().putExtra(FORUM_ID, i);
        setRequestCode(i2);
        setIntentAction(IntentAction.ActivityForResult);
    }
}
