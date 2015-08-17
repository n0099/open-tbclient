package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.util.PageType;
/* loaded from: classes.dex */
public class AccountRestoreActivityConfig extends IntentConfig {
    private static final String PAGE_TYPE = "page_type";

    public AccountRestoreActivityConfig(Context context, PageType pageType) {
        super(context);
        getIntent().putExtra(PAGE_TYPE, pageType.toString());
    }
}
