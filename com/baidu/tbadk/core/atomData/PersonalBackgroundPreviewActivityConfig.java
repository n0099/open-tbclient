package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class PersonalBackgroundPreviewActivityConfig extends IntentConfig {
    public static final String INUSE = "inuse";
    public static final String PROPID = "propid";

    public PersonalBackgroundPreviewActivityConfig(Context context, int i, int i2) {
        super(context);
        Intent intent = getIntent();
        intent.putExtra(PROPID, i);
        intent.putExtra(INUSE, i2);
    }
}
