package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
/* loaded from: classes.dex */
public class au extends com.baidu.tbadk.core.frameworkData.a {
    public au(Context context, int i) {
        super(context);
        getIntent().putExtra("member_type", i);
    }

    public au(Context context, int i, String str) {
        super(context);
        getIntent().putExtra("member_type", i);
        getIntent().putExtra(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, str);
    }

    public au(Context context, boolean z, int i, String str) {
        super(context);
        if (str != null) {
            getIntent().putExtra(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, str);
        }
        if (z) {
            setIntentAction(IntentAction.ActivityForResult);
            setRequestCode(i);
        }
    }
}
