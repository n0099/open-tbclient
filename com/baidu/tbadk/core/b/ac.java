package com.baidu.tbadk.core.b;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public class ac extends com.baidu.tbadk.core.frameworkData.a {
    public ac(Context context, int i, WriteData writeData, boolean z) {
        super(context);
        a(12006);
        a(IntentAction.ActivityForResult);
        if (writeData != null) {
            d().putExtra("model", writeData);
            d().putExtra("is_ad", false);
        }
    }
}
