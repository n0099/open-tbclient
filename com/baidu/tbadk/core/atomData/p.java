package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
/* loaded from: classes.dex */
public class p extends com.baidu.tbadk.core.frameworkData.a {
    public p(Context context, String str) {
        super(context);
        getIntent().putExtra(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, str);
    }

    public static String a(Bundle bundle) {
        return bundle.getString(com.baidu.tbadk.core.frameworkData.a.ST_TYPE);
    }

    public static String a(Intent intent) {
        return intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.ST_TYPE);
    }
}
