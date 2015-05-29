package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.c;
/* loaded from: classes.dex */
public class PersonFriendActivityConfig extends c {
    public static final String KEY_CURRENT_TAB = "key_current_tab";
    public static final String KEY_SEX = "key_sex";
    public static final String KEY_UID = "key_uid";

    public PersonFriendActivityConfig(Context context, String str, int i) {
        super(context);
        Intent intent = getIntent();
        intent.putExtra("key_uid", str);
        intent.putExtra("key_sex", i);
    }

    public PersonFriendActivityConfig(Context context, String str, int i, int i2) {
        super(context);
        Intent intent = getIntent();
        intent.putExtra("key_uid", str);
        intent.putExtra("key_sex", i);
        intent.putExtra("key_current_tab", i2);
    }
}
