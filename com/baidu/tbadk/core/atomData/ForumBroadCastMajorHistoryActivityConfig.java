package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class ForumBroadCastMajorHistoryActivityConfig extends IntentConfig {
    public ForumBroadCastMajorHistoryActivityConfig(Context context, String str, String str2) {
        super(context);
        getIntent().putExtra("forum_id", str);
        getIntent().putExtra("forum_name", str2);
    }

    public ForumBroadCastMajorHistoryActivityConfig(Context context, String str, String str2, String str3) {
        super(context);
        getIntent().putExtra("forum_id", str);
        getIntent().putExtra("forum_name", str2);
        getIntent().putExtra("from", str3);
    }
}
