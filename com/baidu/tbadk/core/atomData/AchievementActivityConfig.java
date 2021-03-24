package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class AchievementActivityConfig extends IntentConfig {
    public static final String KEY_SHARE_URL = "key_share_url";
    public static final String KEY_URL = "key_url";

    public AchievementActivityConfig(Context context) {
        super(context);
    }

    public void setShareUrl(String str) {
        if (getIntent() != null) {
            getIntent().putExtra(KEY_SHARE_URL, str);
        }
    }

    public void setUrl(String str) {
        if (getIntent() != null) {
            getIntent().putExtra("key_url", str);
        }
    }
}
