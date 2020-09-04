package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class MessageCenterActivityConfig extends IntentConfig {
    public static final String SELECTED_TAB_ID = "selected_tab_id";
    public static final int TAB_ID_CHAT = 2;
    public static final int TAB_ID_MESSAGE = 1;
    public static final int TAB_ID_NOTIFICATION = 3;
    public static final int TAB_ID_UNKNOWN = -1;

    public MessageCenterActivityConfig(Context context) {
        super(context);
    }

    public MessageCenterActivityConfig(Context context, int i) {
        super(context);
        getIntent().putExtra(SELECTED_TAB_ID, i);
    }
}
