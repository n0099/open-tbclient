package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ba;
/* loaded from: classes.dex */
public class VideoListActivityConfig extends IntentConfig {
    public static final String KEY_FORUM_ID = "KEY_FORUM_ID";
    public static final String KEY_SOURCE = "KEY_SOURCE";
    public static final String KEY_SOURCE_FRS = "frs";
    public static final String KEY_SOURCE_FRS_FIVE = "floor5";
    public static final String KEY_SOURCE_FRS_HEAD = "headvideo";
    public static final String KEY_SOURCE_HOME = "index";
    public static final String KEY_SOURCE_PB = "pb";
    public static final String KEY_THREAD_ID = "KEY_THREAD_ID";
    private Context mContext;

    public VideoListActivityConfig(Context context) {
        super(context);
        this.mContext = context;
    }

    public VideoListActivityConfig createNormalCfg(String str, String str2, String str3) {
        if (str2 != null) {
            Intent intent = getIntent();
            intent.putExtra(KEY_FORUM_ID, str);
            intent.putExtra(KEY_THREAD_ID, str2);
            if (!ba.isEmpty(str3)) {
                intent.putExtra(KEY_SOURCE, str3);
            }
            if (!(this.mContext instanceof Activity)) {
                intent.addFlags(268435456);
            }
        }
        return this;
    }
}
