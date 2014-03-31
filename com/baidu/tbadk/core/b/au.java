package com.baidu.tbadk.core.b;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public class au extends com.baidu.tbadk.core.frameworkData.a {
    public au(Context context, WriteData writeData, int i) {
        super(context);
        a(12006);
        a(IntentAction.ActivityForResult);
        if (writeData != null) {
            d().putExtra("model", writeData);
        }
    }
}
