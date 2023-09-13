package com.baidu.searchbox.looper.impl;

import android.content.Context;
import android.util.Printer;
import com.baidu.tieba.lub;
import com.baidu.tieba.tub;
/* loaded from: classes4.dex */
public class LooperContextDispatcher extends lub {
    @Override // com.baidu.tieba.lub
    public boolean displayNotification() {
        return LooperRuntime.getInstance().getLooperUIContext().displayNotification();
    }

    public void addLooperPrinter(Printer printer) {
        LooperRuntime.getInstance().getLooperNeedContext().addLooperPrinter(printer);
    }

    public void removeLooperPrinter(Printer printer) {
        LooperRuntime.getInstance().getLooperNeedContext().removeLooperPrinter(printer);
    }

    @Override // com.baidu.tieba.lub, com.baidu.tieba.nub
    public void onBlock(Context context, tub tubVar) {
        super.onBlock(context, tubVar);
        LooperRuntime.getInstance().dispatchBlock(context, tubVar);
    }
}
