package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class MentionActivityConfig extends IntentConfig {
    public static final int CHAT_MESSAGE_ACTIVITY = 2;
    public static final String KEY_GO_TO_PAGE = "GoToPage";
    public static final String KEY_INTENT_NOTIFICATION_ID = "NotifiIdKey";
    public static final int MAIN_TAB_MEMCENTER = 1;
    public static final int NOTIFY_MESSAGE_NONE = -1;
    public static int jumpInTab = -1;
    public static boolean newJumpIn;

    public MentionActivityConfig(Context context) {
        super(context);
    }
}
