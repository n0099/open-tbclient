package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.a;
/* loaded from: classes.dex */
public class SingleSquareActivityConfig extends a {
    public static final String BACK_SPECIAL = "back_special";
    public static final String START_FROM = "start_from";

    public SingleSquareActivityConfig(Context context) {
        super(context);
    }

    public SingleSquareActivityConfig(Context context, String str, boolean z) {
        super(context);
        getIntent().putExtra("start_from", str);
        getIntent().putExtra("back_special", z);
    }
}
