package com.baidu.searchbox.looper.impl;

import android.content.Context;
import android.util.Printer;
import com.baidu.tieba.eya;
import com.baidu.tieba.wxa;
/* loaded from: classes3.dex */
public class LooperContextDispatcher extends wxa {
    @Override // com.baidu.tieba.wxa
    public boolean displayNotification() {
        return LooperRuntime.getInstance().getLooperUIContext().displayNotification();
    }

    public void addLooperPrinter(Printer printer) {
        LooperRuntime.getInstance().getLooperNeedContext().addLooperPrinter(printer);
    }

    public void removeLooperPrinter(Printer printer) {
        LooperRuntime.getInstance().getLooperNeedContext().removeLooperPrinter(printer);
    }

    @Override // com.baidu.tieba.wxa, com.baidu.tieba.yxa
    public void onBlock(Context context, eya eyaVar) {
        super.onBlock(context, eyaVar);
        LooperRuntime.getInstance().dispatchBlock(context, eyaVar);
    }
}
