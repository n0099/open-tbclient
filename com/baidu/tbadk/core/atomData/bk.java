package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
/* loaded from: classes.dex */
public class bk extends com.baidu.tbadk.core.frameworkData.a {
    public bk(Context context, String str) {
        super(context);
        getIntent().putExtra("name", str);
    }

    public bk(Context context, String str, int i) {
        this(context, str);
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i);
    }
}
