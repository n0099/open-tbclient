package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class SingleForumBroadcastFeedActivityConfig extends IntentConfig {
    public static final String KEY_SOURCE = "key_source";
    public static final String KEY_UID = "key_uid";
    public static final byte SOURCE_OFFICIAL_FEED = 1;
    public static final byte SOURCE_OTHER = 3;
    public static final byte SOURCE_PUSH = 2;

    public SingleForumBroadcastFeedActivityConfig(Context context, String str, String str2) {
        super(context);
        Intent intent = getIntent();
        intent.putExtra("key_uid", str);
        intent.putExtra("forum_name", str2);
    }

    public void setSource(byte b2) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra(KEY_SOURCE, b2);
        }
    }
}
