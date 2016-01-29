package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.os.Build;
import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class LiveRoomChatActivityConfig extends IntentConfig {
    public static final String FROM = "from";
    public static final String FROM_NOTIFY = "from_notify";

    public LiveRoomChatActivityConfig(Context context, int i) {
        super(context);
        setIntentAction(IntentAction.ActivityForResult);
        GroupData groupData = new GroupData();
        groupData.setGroupId(i);
        getIntent().putExtra("gid", i);
        getIntent().putExtra("group", groupData);
        getIntent().putExtra("forum_name", "");
        setIntentAction(IntentAction.ActivityForResult);
    }

    public LiveRoomChatActivityConfig(Context context, int i, String str) {
        super(context);
        GroupData groupData = new GroupData();
        groupData.setGroupId(i);
        getIntent().putExtra("gid", i);
        getIntent().putExtra("group", groupData);
        getIntent().putExtra("forum_name", str);
    }

    @Override // com.baidu.tbadk.core.frameworkData.IntentConfig
    public boolean isValid() {
        if (Build.VERSION.SDK_INT >= 9) {
            return true;
        }
        UtilHelper.showToast(getContext(), getContext().getString(t.j.live_error_system_not_support));
        return false;
    }
}
