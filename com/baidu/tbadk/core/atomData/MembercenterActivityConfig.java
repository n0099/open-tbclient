package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class MembercenterActivityConfig extends IntentConfig {
    public static final String KEY_URL = "key_url";

    public MembercenterActivityConfig(Context context) {
        super(context);
    }

    public void setUrl(String str) {
        getIntent().putExtra(KEY_URL, str);
    }
}
