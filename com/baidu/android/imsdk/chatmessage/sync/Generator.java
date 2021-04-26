package com.baidu.android.imsdk.chatmessage.sync;

import android.content.Context;
/* loaded from: classes.dex */
public class Generator {
    public static final int SYNC_ALL_MESSAGE = 5;
    public static final int SYNC_CHAT_MESSAGE = 0;
    public static final int SYNC_GROUP_MESSAGE = 6;
    public static final int SYNC_NOTIFY_MESSAGE = 1;

    public static SyncStrategy generate(Context context, int i2) {
        if (i2 != 5) {
            return null;
        }
        return SyncAllMessage.getInstance(context);
    }
}
