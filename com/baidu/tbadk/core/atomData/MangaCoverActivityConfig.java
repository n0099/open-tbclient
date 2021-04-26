package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class MangaCoverActivityConfig extends IntentConfig {
    public static final String FORUM_ID = "forum_id";
    public static final String FROM = "from";
    public static final int FROM_CATEGORY = 3;
    public static final int FROM_FRS_BOOK_HEADER = 5;
    public static final int FROM_FRS_HEAD_SDK = 4;
    public static final int FROM_FRS_SHLEF = 1;
    public static final int FROM_MY_SHELF = 2;

    public MangaCoverActivityConfig(Context context) {
        super(context);
    }

    public void setFrom(int i2) {
        getIntent().putExtra("from", i2);
    }

    public MangaCoverActivityConfig(Context context, long j) {
        super(context);
        getIntent().putExtra("forum_id", j);
    }
}
