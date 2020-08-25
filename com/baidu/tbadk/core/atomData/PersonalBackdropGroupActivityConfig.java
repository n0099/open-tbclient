package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes2.dex */
public class PersonalBackdropGroupActivityConfig extends IntentConfig {
    public PersonalBackdropGroupActivityConfig(Context context) {
        super(context);
    }

    public PersonalBackdropGroupActivityConfig(Context context, boolean z) {
        super(context);
        getIntent().putExtra("member_buy_show", z);
    }
}
