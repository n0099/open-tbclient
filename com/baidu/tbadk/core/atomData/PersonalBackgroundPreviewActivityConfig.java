package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class PersonalBackgroundPreviewActivityConfig extends IntentConfig {
    public static final int FROM_BACKGROUND_ALL = 0;
    public static final int FROM_BACKGROUND_GROUP = 1;
    public static final String INUSE = "inuse";
    public static final String PROPID = "propid";

    public PersonalBackgroundPreviewActivityConfig(Context context, int i2, int i3) {
        super(context);
        Intent intent = getIntent();
        intent.putExtra(PROPID, i2);
        intent.putExtra(INUSE, i3);
    }

    public void setFrom(int i2) {
        getIntent().putExtra("from", i2);
    }
}
