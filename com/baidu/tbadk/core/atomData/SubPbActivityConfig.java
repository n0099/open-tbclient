package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.c;
/* loaded from: classes.dex */
public class SubPbActivityConfig extends c {
    public static final String KEY_IS_JUMP_FROM_PB = "is_jump_from_pb";
    public static final String KEY_POST_ID = "post_id";
    public static final String KEY_REPLAY_NAME = "replay_name";
    public static final String KEY_REPLAY_POST_ID = "replay_post_id";
    public static final String KEY_SHOW_KEYBOARD = "show_keyboard";
    public static final String KEY_ST_TYPE = "st_type";
    public static final String KEY_THREAD_ID = "thread_id";
    public static final String KEY_USER_IDENTITY = "user_identity";

    public SubPbActivityConfig(Context context) {
        super(context);
    }

    public SubPbActivityConfig createSubPbActivityConfig(String str, String str2, String str3, boolean z) {
        return createSubPbActivityConfig(str, str2, str3, z, null, false);
    }

    public SubPbActivityConfig createSubPbActivityConfig(String str, String str2, String str3, boolean z, String str4, boolean z2) {
        return createSubPbActivityConfig(str, str2, str3, z, str4, z2, null, 0);
    }

    public SubPbActivityConfig createSubPbActivityConfig(String str, String str2, String str3, boolean z, String str4, boolean z2, String str5, int i) {
        Intent intent = getIntent();
        intent.putExtra("thread_id", str);
        intent.putExtra("post_id", str2);
        intent.putExtra("st_type", str3);
        intent.putExtra(KEY_IS_JUMP_FROM_PB, z);
        intent.putExtra(KEY_SHOW_KEYBOARD, z2);
        intent.putExtra(KEY_REPLAY_NAME, str4);
        intent.putExtra(KEY_REPLAY_POST_ID, str5);
        intent.putExtra(KEY_USER_IDENTITY, i);
        return this;
    }
}
