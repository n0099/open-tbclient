package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class XiaoyingPlayerConfig extends IntentConfig {
    public static final String EXTRA_URL = "extra_url";

    public XiaoyingPlayerConfig(Context context, String str) {
        super(context);
        getIntent().putExtra(EXTRA_URL, str);
    }
}
