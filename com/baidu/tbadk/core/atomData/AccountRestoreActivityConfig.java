package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.util.PageType;
/* loaded from: classes3.dex */
public class AccountRestoreActivityConfig extends IntentConfig {
    public static final String PAGE_TYPE = "page_type";

    public AccountRestoreActivityConfig(Context context, PageType pageType) {
        super(context);
        getIntent().putExtra("page_type", pageType.toString());
    }
}
