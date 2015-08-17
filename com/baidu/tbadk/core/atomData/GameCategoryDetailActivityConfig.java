package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class GameCategoryDetailActivityConfig extends IntentConfig {
    public static final String CATEGORY_ID = "category_id";
    public static final String CATEGORY_TITLE = "category_title";

    public GameCategoryDetailActivityConfig(Context context, int i, String str) {
        super(context);
        getIntent().putExtra(CATEGORY_ID, i);
        getIntent().putExtra(CATEGORY_TITLE, str);
    }
}
