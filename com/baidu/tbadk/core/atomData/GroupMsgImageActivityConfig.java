package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes3.dex */
public class GroupMsgImageActivityConfig extends AbsMsgImageActivityConfig {
    public GroupMsgImageActivityConfig(Context context, String str, long j, boolean z, String str2) {
        super(context);
        Intent intent = getIntent();
        intent.putExtra(AbsMsgImageActivityConfig.CURRENT_URL, str);
        intent.putExtra("id", String.valueOf(j));
        intent.putExtra(AbsMsgImageActivityConfig.ID_UNIQUE, str2);
        intent.putExtra("isSingle", z);
    }

    public GroupMsgImageActivityConfig(Context context, String str, long j, boolean z, String str2, String str3) {
        super(context);
        Intent intent = getIntent();
        intent.putExtra(AbsMsgImageActivityConfig.CURRENT_URL, str);
        intent.putExtra("id", String.valueOf(j));
        intent.putExtra(AbsMsgImageActivityConfig.ID_UNIQUE, str2);
        intent.putExtra("isSingle", z);
        intent.putExtra(AbsMsgImageActivityConfig.ASSIST_URL, str3);
    }
}
