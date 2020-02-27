package com.baidu.ala.atomdata;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class AlaPrivilegeListActivityConfig extends IntentConfig {
    public static final String EFFECT_NUM = "effect_num";
    public static final String MARK_NUM = "mark_num";
    public static final String USER_ID = "user_id";

    public AlaPrivilegeListActivityConfig(Context context, String str, long j, long j2) {
        super(context);
        getIntent().putExtra("user_id", str);
        getIntent().putExtra(MARK_NUM, j);
        getIntent().putExtra(EFFECT_NUM, j2);
    }
}
