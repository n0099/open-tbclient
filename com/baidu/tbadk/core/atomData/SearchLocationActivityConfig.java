package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.c;
/* loaded from: classes.dex */
public class SearchLocationActivityConfig extends c {
    public SearchLocationActivityConfig(Context context, int i) {
        super(context);
        getIntent().putExtra(c.REQUEST_CODE, i);
    }
}
