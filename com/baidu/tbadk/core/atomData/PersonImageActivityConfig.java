package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.a;
/* loaded from: classes.dex */
public class PersonImageActivityConfig extends a {
    public PersonImageActivityConfig(Context context, String str) {
        super(context);
        getIntent().putExtra("curImgUrl", str);
    }
}
