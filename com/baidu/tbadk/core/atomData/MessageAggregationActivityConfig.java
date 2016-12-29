package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class MessageAggregationActivityConfig extends IntentConfig {
    private static Class<?> sMentionClass;

    public MessageAggregationActivityConfig(Context context, int i) {
        this(context, i, false);
    }

    public MessageAggregationActivityConfig(Context context) {
        this(context, 16);
    }

    public MessageAggregationActivityConfig(Context context, int i, boolean z) {
        super(context);
        getIntent().putExtra("showBack", true);
        getIntent().putExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, i);
        getIntent().addFlags(268435456);
        MentionActivityConfig.newJumpIn = true;
        MentionActivityConfig.jumpInTab = i;
    }

    public static void setMentionActivityClass(Class<?> cls) {
        sMentionClass = cls;
    }

    public static Class<?> getMentionActivityClass() {
        return sMentionClass;
    }

    public static String getMentionActivityClassName() {
        if (sMentionClass == null) {
            return null;
        }
        return sMentionClass.getName();
    }
}
