package com.baidu.tbadk.core.atomData;

import android.content.Context;
/* loaded from: classes2.dex */
public class PersonalMsgImageActivityConfig extends AbsMsgImageActivityConfig {
    public PersonalMsgImageActivityConfig(Context context, String str, long j, String str2) {
        super(context);
        getIntent().putExtra(AbsMsgImageActivityConfig.CURRENT_URL, str);
        getIntent().putExtra("id", String.valueOf(j));
        getIntent().putExtra(AbsMsgImageActivityConfig.ID_UNIQUE, str2);
    }
}
