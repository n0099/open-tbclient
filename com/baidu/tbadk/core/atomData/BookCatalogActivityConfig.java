package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class BookCatalogActivityConfig extends IntentConfig {
    public static final String BOOK_ID = "book_id";
    public static final String BOOK_NAME = "book_name";
    public static final String BOOK_TYPE = "book_type";

    public BookCatalogActivityConfig(Context context, String str, int i2, String str2) {
        super(context);
        getIntent().putExtra("book_id", str);
        getIntent().putExtra("book_type", i2);
        getIntent().putExtra(BOOK_NAME, str2);
    }
}
