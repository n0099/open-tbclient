package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class FacePackageDetailActivityConfig extends IntentConfig {
    public FacePackageDetailActivityConfig(Context context, String str, boolean z, String str2) {
        super(context);
        Intent intent = getIntent();
        intent.putExtra("st_type", str2);
        intent.putExtra(IntentConfig.PKG_ID, str);
        intent.putExtra(IntentConfig.IS_DOWNLOADING, z);
    }
}
