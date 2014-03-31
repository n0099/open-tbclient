package com.baidu.tbadk.core.b;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.core.frameworkData.a {
    public a(Context context, String str) {
        super(context);
        d().putExtra("write_images_info", str);
        a(IntentAction.ActivityForResult);
    }
}
