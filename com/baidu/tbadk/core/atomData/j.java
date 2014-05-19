package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
public class j extends com.baidu.tbadk.core.frameworkData.a {
    public j(Context context, String str, boolean z, String str2) {
        super(context);
        Intent intent = getIntent();
        intent.putExtra(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, str2);
        intent.putExtra(com.baidu.tbadk.core.frameworkData.a.PKG_ID, str);
        intent.putExtra(com.baidu.tbadk.core.frameworkData.a.IS_DOWNLOADING, z);
    }
}
