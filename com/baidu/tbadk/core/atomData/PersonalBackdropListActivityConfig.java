package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class PersonalBackdropListActivityConfig extends IntentConfig {
    public PersonalBackdropListActivityConfig(Context context) {
        super(context);
    }

    public PersonalBackdropListActivityConfig(Context context, boolean z) {
        super(context);
        getIntent().putExtra("member_buy_show", z);
    }
}
