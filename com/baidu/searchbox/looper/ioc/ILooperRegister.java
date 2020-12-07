package com.baidu.searchbox.looper.ioc;

import android.content.Context;
import com.baidu.searchbox.looper.impl.LooperBlock;
/* loaded from: classes12.dex */
public abstract class ILooperRegister {
    public abstract boolean checkEnable();

    public abstract void onBlock(Context context, LooperBlock looperBlock);
}
