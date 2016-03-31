package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class GraffitiTabActivityConfig extends IntentConfig {
    public static final String KEY_FORUM_ID = "forum_id";
    public static final String KEY_GRAFFITI_FILENAME = "graffiti_filename";
    public static final String KEY_THREAD_ID = "thread_id";

    public GraffitiTabActivityConfig(Context context, String str, String str2, String str3) {
        super(context);
        if (!StringUtils.isNull(str)) {
            getIntent().putExtra("thread_id", str);
        }
        if (!StringUtils.isNull(str2)) {
            getIntent().putExtra("forum_id", str2);
        }
        if (!StringUtils.isNull(str3)) {
            getIntent().putExtra(KEY_GRAFFITI_FILENAME, str3);
        }
    }
}
