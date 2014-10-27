package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.a;
/* loaded from: classes.dex */
public class SingleMentionActivityConfig extends a {
    public static final String KEY_IS_SHOW_CHAT = "is_show_chat";
    private static Class<?> sMentionClass;
    private static boolean sShowChat;

    public SingleMentionActivityConfig(Context context, int i) {
        this(context, i, false);
    }

    public SingleMentionActivityConfig(Context context, boolean z) {
        this(context, 16, z);
    }

    public SingleMentionActivityConfig(Context context) {
        this(context, 16);
    }

    public SingleMentionActivityConfig(Context context, int i, boolean z) {
        super(context);
        getIntent().putExtra("showBack", true);
        getIntent().putExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, i);
        getIntent().addFlags(268435456);
        getIntent().putExtra(KEY_IS_SHOW_CHAT, z);
        sShowChat = z;
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

    public static boolean isShowChat() {
        return sShowChat;
    }
}
