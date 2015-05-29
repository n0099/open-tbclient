package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.c;
/* loaded from: classes.dex */
public class SquareSearchActivityConfig extends c {
    public static final String BACK_SPECIAL = "back_special";
    public static final String FROM = "start_from";

    public SquareSearchActivityConfig(Context context, String str, boolean z) {
        super(context);
        getIntent().putExtra("start_from", str);
        getIntent().putExtra("back_special", z);
    }
}
