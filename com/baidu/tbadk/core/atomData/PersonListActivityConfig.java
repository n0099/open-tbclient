package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.c;
/* loaded from: classes.dex */
public class PersonListActivityConfig extends c {
    public static final String FOLLOW = "follow";

    public PersonListActivityConfig(Context context, boolean z, String str, int i) {
        super(context);
        getIntent().putExtra(FOLLOW, z);
        getIntent().putExtra("user_id", str);
        getIntent().putExtra(c.USER_SEX, i);
    }
}
