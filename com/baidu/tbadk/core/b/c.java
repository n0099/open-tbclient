package com.baidu.tbadk.core.b;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
/* loaded from: classes.dex */
public class c extends com.baidu.tbadk.core.frameworkData.a {
    public c(Context context, int i, boolean z) {
        super(context);
        a(i);
        a(IntentAction.ActivityForResult);
        d().putExtra("is_need_multiple", z);
        if (i == 12011) {
            d().putExtra("keyboard", false);
        }
    }
}
