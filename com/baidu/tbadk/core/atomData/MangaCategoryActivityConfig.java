package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class MangaCategoryActivityConfig extends IntentConfig {
    public static final String CATEGORY_ID = "category_id";
    public static final String CATEGORY_NAME = "category_name";

    public MangaCategoryActivityConfig(Context context) {
        super(context);
    }

    public MangaCategoryActivityConfig(Context context, int i, String str) {
        super(context);
        getIntent().putExtra("category_id", i);
        getIntent().putExtra(CATEGORY_NAME, str);
    }
}
