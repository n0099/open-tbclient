package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class SquareForumListActivityConfig extends IntentConfig {
    public static final String KEY_PAGE_TYPE = "forum_list_type";
    public static final int PAGE_TYPE_HOT = 1;
    public static final int PAGE_TYPE_NEW = 2;

    public SquareForumListActivityConfig(Context context, int i2) {
        super(context);
        getIntent().putExtra(KEY_PAGE_TYPE, i2);
    }
}
