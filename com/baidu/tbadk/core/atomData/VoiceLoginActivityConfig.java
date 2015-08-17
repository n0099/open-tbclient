package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class VoiceLoginActivityConfig extends IntentConfig {
    public static final String UID = "uid";

    public VoiceLoginActivityConfig(Context context, String str) {
        super(context);
        getIntent().putExtra("uid", str);
    }
}
