package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class SubPbActivityConfig extends IntentConfig {
    public static final String KEY_ANTI = "anti";
    public static final String KEY_IS_JUMP_FROM_PB = "is_jump_from_pb";
    public static final String KEY_POST_ID = "post_id";
    public static final String KEY_REPLAY_NAME = "replay_name";
    public static final String KEY_REPLAY_POST_ID = "replay_post_id";
    public static final String KEY_SHOW_KEYBOARD = "show_keyboard";
    public static final String KEY_ST_TYPE = "st_type";
    public static final String KEY_TAIL = "post_tail";
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
        return createSubPbActivityConfig(str, str2, str3, z, str4, z2, str5, i, null);
    }

    public SubPbActivityConfig createSubPbActivityConfig(String str, String str2, String str3, boolean z, String str4, boolean z2, String str5, int i, SmallTailInfo smallTailInfo) {
        return createSubPbActivityConfig(str, str2, str3, z, str4, z2, str5, i, null, null);
    }

    public SubPbActivityConfig createSubPbActivityConfig(String str, String str2, String str3, boolean z, String str4, boolean z2, String str5, int i, SmallTailInfo smallTailInfo, AntiData antiData) {
        Intent intent = getIntent();
        intent.putExtra("thread_id", str);
        intent.putExtra("post_id", str2);
        intent.putExtra("st_type", str3);
        intent.putExtra("is_jump_from_pb", z);
        intent.putExtra("show_keyboard", z2);
        intent.putExtra(KEY_REPLAY_NAME, str4);
        intent.putExtra(KEY_REPLAY_POST_ID, str5);
        intent.putExtra(KEY_USER_IDENTITY, i);
        intent.putExtra(KEY_TAIL, smallTailInfo);
        intent.putExtra(KEY_ANTI, antiData);
        return this;
    }
}
