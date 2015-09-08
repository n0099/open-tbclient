package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class PhotoLiveHotListActivityConfig extends IntentConfig {
    public PhotoLiveHotListActivityConfig(Context context) {
        super(context);
    }

    public PhotoLiveHotListActivityConfig createConfig(String str, String str2) {
        Intent intent = getIntent();
        intent.putExtra("forum_id", str);
        intent.putExtra("thread_id", str2);
        return this;
    }
}
