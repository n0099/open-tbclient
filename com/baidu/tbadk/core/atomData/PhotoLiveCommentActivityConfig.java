package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class PhotoLiveCommentActivityConfig extends IntentConfig {
    public static final String FROM_PHOTO_LIVE = "from_photo_live";
    public static final String KEY_FLOOR_NUM = "floor_num";
    public static final String KEY_IS_JUMP_FROM_PB = "is_jump_from_pb";
    public static final String KEY_POST_ID = "post_id";
    public static final String KEY_PULL_COMMENT_PER_SEC = "pull_comment_per_sec";
    public static final String KEY_SHOW_KEYBOARD = "show_keyboard";
    public static final String KEY_ST_TYPE = "st_type";
    public static final String KEY_THREAD_ID = "thread_id";

    public PhotoLiveCommentActivityConfig(Context context) {
        super(context);
    }

    public PhotoLiveCommentActivityConfig createPhotoLiveCommentActivityConfig(String str, String str2, String str3, int i, boolean z, boolean z2) {
        return createPhotoLiveCommentActivityConfig(str, str2, str3, i, z, z2, -1);
    }

    public PhotoLiveCommentActivityConfig createPhotoLiveCommentActivityConfig(String str, String str2, String str3, int i, boolean z, boolean z2, int i2) {
        Intent intent = getIntent();
        intent.putExtra("thread_id", str);
        intent.putExtra("post_id", str2);
        intent.putExtra("st_type", str3);
        intent.putExtra("floor_num", i);
        intent.putExtra("show_keyboard", z);
        intent.putExtra("is_jump_from_pb", z2);
        intent.putExtra(KEY_PULL_COMMENT_PER_SEC, i2);
        return this;
    }
}
