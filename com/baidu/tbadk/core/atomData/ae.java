package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
public class ae extends com.baidu.tbadk.core.frameworkData.a {
    public ae(Context context) {
        super(context);
    }

    public ae a(String str, String str2, String str3) {
        Intent intent = getIntent();
        intent.putExtra(com.baidu.tbadk.core.frameworkData.a.THREAD_ID, str);
        intent.putExtra("forum", str2);
        intent.putExtra("title", str3);
        return this;
    }
}
