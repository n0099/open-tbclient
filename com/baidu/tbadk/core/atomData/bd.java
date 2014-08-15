package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
public class bd extends com.baidu.tbadk.core.frameworkData.a {
    public bd(Context context, String str, int i) {
        super(context);
        Intent intent = getIntent();
        intent.putExtra("key_uid", str);
        intent.putExtra("key_sex", i);
    }

    public bd(Context context, String str, int i, int i2) {
        super(context);
        Intent intent = getIntent();
        intent.putExtra("key_uid", str);
        intent.putExtra("key_sex", i);
        intent.putExtra("key_current_tab", i2);
    }
}
