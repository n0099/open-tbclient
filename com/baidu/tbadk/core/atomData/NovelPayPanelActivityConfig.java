package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class NovelPayPanelActivityConfig extends IntentConfig {
    public static final String BOOK_ID = "book_id";
    public static final String BOOK_TYPE = "book_type";
    public static final String FROM_READER_SDK = "reader_sdk";
    public static final String PAGE_ID = "page_id";
    public static final String PAY_TYPE = "pay_type";
    public static final int PAY_TYPE_BUY = 1;
    public static final int PAY_TYPE_EXCHANGE = 2;

    public NovelPayPanelActivityConfig(Context context, int i, String str, int i2) {
        super(context);
        getIntent().putExtra("book_type", i);
        getIntent().putExtra("book_id", str);
        getIntent().putExtra("page_id", i2);
    }

    public void setForm(String str) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra("from", str);
        }
    }

    public void setPayType(int i) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra("pay_type", i);
        }
    }
}
