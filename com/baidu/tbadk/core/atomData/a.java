package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.core.frameworkData.a {
    public a(Context context, String str) {
        super(context);
        getIntent().putExtra("write_images_info", str);
        setIntentAction(IntentAction.ActivityForResult);
    }
}
