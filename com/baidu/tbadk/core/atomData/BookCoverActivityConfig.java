package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class BookCoverActivityConfig extends IntentConfig {
    public static final String BOOK_ID = "book_id";

    public BookCoverActivityConfig(Context context, String str) {
        super(context);
        getIntent().putExtra("book_id", str);
    }
}
