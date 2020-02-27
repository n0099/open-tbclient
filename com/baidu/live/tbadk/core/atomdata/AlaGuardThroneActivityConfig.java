package com.baidu.live.tbadk.core.atomdata;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.IntentAction;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes3.dex */
public class AlaGuardThroneActivityConfig extends IntentConfig {
    public static final String GUARD_THRONE_ANCHOR_ID = "GUARD_THRONE_ANCHOR_ID";
    public static final String GUARD_THRONE_GIFT_ID = "GUARD_THRONE_GIFT_ID";
    public static final String GUARD_THRONE_IS_HOST = "GUARD_THRONE_IS_HOST";
    public static final String GUARD_THRONE_LIVE_ID = "GUARD_THRONE_LIVE_ID";
    public static final String GUARD_THRONE_TAB_ID = "GUARD_THRONE_TAB_ID";

    public AlaGuardThroneActivityConfig(Context context, String str, String str2, String str3, int i, boolean z) {
        super(context);
        getIntent().putExtra(GUARD_THRONE_LIVE_ID, str);
        getIntent().putExtra(GUARD_THRONE_ANCHOR_ID, str2);
        getIntent().putExtra(GUARD_THRONE_GIFT_ID, str3);
        getIntent().putExtra(GUARD_THRONE_TAB_ID, i);
        getIntent().putExtra(GUARD_THRONE_IS_HOST, z);
        setIntentAction(IntentAction.Activity);
    }
}
