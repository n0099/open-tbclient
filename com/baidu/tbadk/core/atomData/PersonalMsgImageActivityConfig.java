package com.baidu.tbadk.core.atomData;

import android.content.Context;
/* loaded from: classes3.dex */
public class PersonalMsgImageActivityConfig extends AbsMsgImageActivityConfig {
    public PersonalMsgImageActivityConfig(Context context, String str, long j, String str2) {
        super(context);
        getIntent().putExtra("current_url", str);
        getIntent().putExtra("id", String.valueOf(j));
        getIntent().putExtra("uniqueid", str2);
    }
}
