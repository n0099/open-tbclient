package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
/* loaded from: classes.dex */
public class bl extends com.baidu.tbadk.core.frameworkData.a {
    public bl(Context context, String str) {
        super(context);
        getIntent().putExtra("name", str);
    }

    public bl(Context context, String str, int i) {
        this(context, str);
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i);
    }
}
