package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class EcommEnsureOrderActivityConfig extends IntentConfig {
    public static final String FORUM_NAME = "forum_name";
    public static final String PRODUCT_ID = "product_id";
    public static final String THREAD_ID = "thread_id";

    public EcommEnsureOrderActivityConfig(Context context, long j, String str) {
        super(context);
        getIntent().putExtra("product_id", j);
        getIntent().putExtra("thread_id", str);
    }

    public void setForumName(String str) {
        getIntent().putExtra("forum_name", str);
    }
}
