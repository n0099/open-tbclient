package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes2.dex */
public class LocalVideoSelectConfig extends IntentConfig {
    public LocalVideoSelectConfig(Context context, String str, String str2) {
        super(context);
        getIntent().putExtra("forum_id", str);
        getIntent().putExtra("forum_name", str2);
    }
}
