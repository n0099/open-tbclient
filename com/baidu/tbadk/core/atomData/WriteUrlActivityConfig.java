package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class WriteUrlActivityConfig extends IntentConfig {
    public WriteUrlActivityConfig(Activity activity, String str, String str2, String str3) {
        super(activity);
        if (getIntent() != null) {
            getIntent().putExtra("forum_id", str);
            getIntent().putExtra("forum_name", str2);
            getIntent().putExtra("KEY_CALL_FROM", str3);
        }
    }
}
