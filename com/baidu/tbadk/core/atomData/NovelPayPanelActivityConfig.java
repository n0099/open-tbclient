package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class NovelPayPanelActivityConfig extends IntentConfig {
    public static final String BOOK_ID = "book_id";
    public static final String BOOK_TYPE = "book_type";
    public static final String PAGE_ID = "page_id";

    public NovelPayPanelActivityConfig(Context context, int i, String str, int i2) {
        super(context);
        getIntent().putExtra("book_type", i);
        getIntent().putExtra("book_id", str);
        getIntent().putExtra("page_id", i2);
    }
}
