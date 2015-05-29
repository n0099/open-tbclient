package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.c;
/* loaded from: classes.dex */
public class BlackMembersListActivityConfig extends c {
    public BlackMembersListActivityConfig(Context context, String str) {
        super(context);
        getIntent().putExtra("group_id", str);
    }
}
