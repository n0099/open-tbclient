package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class PhotoLiveHeadlineActivityConfig extends IntentConfig {
    public static final int FROM_FRS = 1;
    public static final int FROM_PB = 2;

    public PhotoLiveHeadlineActivityConfig(Context context) {
        super(context);
    }

    public PhotoLiveHeadlineActivityConfig createConfig(String str, String str2, int i) {
        return createConfig(str, str2, i, null, null);
    }

    public PhotoLiveHeadlineActivityConfig createConfig(String str, String str2, int i, String str3, String str4) {
        Intent intent = getIntent();
        intent.putExtra("forum_id", str);
        intent.putExtra("thread_id", str2);
        intent.putExtra("from", i);
        intent.putExtra("user_id", str3);
        intent.putExtra(IntentConfig.PORTRAIT, str4);
        return this;
    }
}
