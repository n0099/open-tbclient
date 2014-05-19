package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.os.Build;
import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class ae extends com.baidu.tbadk.core.frameworkData.a {
    public ae(Context context, int i) {
        super(context);
        setIntentAction(IntentAction.ActivityForResult);
        GroupData groupData = new GroupData();
        groupData.setGroupId(i);
        getIntent().putExtra("gid", i);
        getIntent().putExtra("group", groupData);
        getIntent().putExtra(com.baidu.tbadk.core.frameworkData.a.FORUM_NAME, "");
        setIntentAction(IntentAction.ActivityForResult);
    }

    public ae(Context context, int i, String str) {
        super(context);
        GroupData groupData = new GroupData();
        groupData.setGroupId(i);
        getIntent().putExtra("gid", i);
        getIntent().putExtra("group", groupData);
        getIntent().putExtra(com.baidu.tbadk.core.frameworkData.a.FORUM_NAME, str);
    }

    @Override // com.baidu.tbadk.core.frameworkData.a
    public boolean isValid() {
        if (Build.VERSION.SDK_INT >= 9) {
            return true;
        }
        UtilHelper.showToast(getContext(), getContext().getString(com.baidu.tieba.u.live_error_system_not_support));
        return false;
    }
}
