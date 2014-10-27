package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.a;
/* loaded from: classes.dex */
public class BackupBlackMembersListActivityConfig extends a {
    public BackupBlackMembersListActivityConfig(Context context, String str) {
        super(context);
        getIntent().putExtra("group_id", str);
    }
}
