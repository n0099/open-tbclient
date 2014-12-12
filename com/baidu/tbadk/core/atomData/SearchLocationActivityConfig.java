package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.a;
/* loaded from: classes.dex */
public class SearchLocationActivityConfig extends a {
    public SearchLocationActivityConfig(Context context, int i) {
        super(context);
        getIntent().putExtra(a.REQUEST_CODE, i);
    }
}
