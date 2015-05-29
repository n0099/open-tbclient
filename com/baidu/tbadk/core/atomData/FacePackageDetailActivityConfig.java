package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.c;
/* loaded from: classes.dex */
public class FacePackageDetailActivityConfig extends c {
    public FacePackageDetailActivityConfig(Context context, String str, boolean z, String str2) {
        super(context);
        Intent intent = getIntent();
        intent.putExtra("st_type", str2);
        intent.putExtra(c.PKG_ID, str);
        intent.putExtra(c.IS_DOWNLOADING, z);
    }
}
