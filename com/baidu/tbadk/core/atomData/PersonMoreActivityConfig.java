package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.os.Bundle;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class PersonMoreActivityConfig extends IntentConfig {
    public static final String BOOK_SHELF = "book_shelf";
    public static final String CONSUME_RECORD = "consume_recode";
    public static final String FUN = "fun";
    public static final String FUN_NAME = "娱乐";
    public static final String LOVE_BEAN = "love_bean";
    public static final String LOVE_BEAN_NAME = "爱豆榜";
    public static final String URL_BUNDLE = "url_bundle";

    public PersonMoreActivityConfig(Context context, Bundle bundle) {
        super(context);
        getIntent().putExtra(URL_BUNDLE, bundle);
    }
}
