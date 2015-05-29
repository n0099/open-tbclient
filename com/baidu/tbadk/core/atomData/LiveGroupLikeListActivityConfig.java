package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.c;
/* loaded from: classes.dex */
public class LiveGroupLikeListActivityConfig extends c {
    public static final String LIKERS = "likers";

    public LiveGroupLikeListActivityConfig(Context context, String str, int i, int i2) {
        super(context);
        getIntent().putExtra("group_name", str);
        getIntent().putExtra("group_id", i);
        getIntent().putExtra(LIKERS, i2);
    }
}
