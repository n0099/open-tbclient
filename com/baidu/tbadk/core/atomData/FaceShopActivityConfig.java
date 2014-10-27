package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.frameworkData.a;
/* loaded from: classes.dex */
public class FaceShopActivityConfig extends a {
    public FaceShopActivityConfig(Context context, String str) {
        super(context);
        getIntent().putExtra("st_type", str);
    }

    public static String getST_TYPE(Bundle bundle) {
        return bundle.getString("st_type");
    }

    public static String getST_TYPE(Intent intent) {
        return intent.getStringExtra("st_type");
    }
}
