package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class MyBookrackActivityConfig extends IntentConfig {
    public static final String BOOK_TOWN_URL = "book_town_url";
    public static final String TAB_ID = "tab_id";
    public static final int TAB_MY_FOLLOW = 0;

    public MyBookrackActivityConfig(Context context, int i, String str) {
        super(context);
        getIntent().putExtra("tab_id", i);
        getIntent().putExtra(BOOK_TOWN_URL, str);
    }
}
