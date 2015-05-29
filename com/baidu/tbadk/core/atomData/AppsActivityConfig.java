package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.c;
/* loaded from: classes.dex */
public class AppsActivityConfig extends c {
    public AppsActivityConfig(Context context, String str) {
        super(context);
        getIntent().putExtra(ImageViewerConfig.URL, str);
    }
}
