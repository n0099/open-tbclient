package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.a;
/* loaded from: classes.dex */
public class PersonPostActivityConfig extends a {
    private static final String KEY_PORTRAIT_URL = "key_portrait_url";
    private static final String KEY_SEX = "key_sex";
    private static final String KEY_UID = "key_uid";

    public PersonPostActivityConfig(Context context, String str, int i, String str2) {
        super(context);
        getIntent().putExtra("key_uid", str);
        getIntent().putExtra("key_sex", i);
        getIntent().putExtra(KEY_PORTRAIT_URL, str2);
    }
}
