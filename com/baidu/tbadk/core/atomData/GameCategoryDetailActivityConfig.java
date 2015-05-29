package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.c;
/* loaded from: classes.dex */
public class GameCategoryDetailActivityConfig extends c {
    public static final String CATEGORY_ID = "category_id";
    public static final String CATEGORY_TITLE = "category_title";

    public GameCategoryDetailActivityConfig(Context context, int i, String str) {
        super(context);
        getIntent().putExtra(CATEGORY_ID, i);
        getIntent().putExtra(CATEGORY_TITLE, str);
    }
}
