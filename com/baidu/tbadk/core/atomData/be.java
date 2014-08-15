package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
public class be extends com.baidu.tbadk.core.frameworkData.a {
    public be(Context context, String str, int i) {
        super(context);
        Intent intent = getIntent();
        intent.putExtra("key_uid", str);
        intent.putExtra("key_sex", i);
    }

    public be(Context context, String str, int i, int i2) {
        super(context);
        Intent intent = getIntent();
        intent.putExtra("key_uid", str);
        intent.putExtra("key_sex", i);
        intent.putExtra("key_current_tab", i2);
    }
}
