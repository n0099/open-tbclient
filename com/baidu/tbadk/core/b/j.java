package com.baidu.tbadk.core.b;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
/* loaded from: classes.dex */
public class j extends com.baidu.tbadk.core.frameworkData.a {
    public j(Context context, String str) {
        super(context);
        d().putExtra("st_type", str);
    }

    public static String a(Bundle bundle) {
        return bundle.getString("st_type");
    }

    public static String a(Intent intent) {
        return intent.getStringExtra("st_type");
    }
}
