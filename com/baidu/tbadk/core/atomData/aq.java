package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
/* loaded from: classes.dex */
public class aq extends com.baidu.tbadk.core.frameworkData.a {
    public aq(Context context, int i) {
        super(context);
        setIntentAction(IntentAction.ActivityForResult);
        getIntent().putExtra(com.baidu.tbadk.core.frameworkData.a.GROUP_ID, i);
    }
}
