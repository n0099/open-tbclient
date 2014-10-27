package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.a;
/* loaded from: classes.dex */
public class FacePackageDetailActivityConfig extends a {
    public FacePackageDetailActivityConfig(Context context, String str, boolean z, String str2) {
        super(context);
        Intent intent = getIntent();
        intent.putExtra("st_type", str2);
        intent.putExtra(a.PKG_ID, str);
        intent.putExtra(a.IS_DOWNLOADING, z);
    }
}
