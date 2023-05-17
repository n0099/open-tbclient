package com.baidu.searchbox.looper.impl;

import android.content.Context;
import android.util.Printer;
import com.baidu.tieba.dya;
import com.baidu.tieba.vxa;
/* loaded from: classes3.dex */
public class LooperContextDispatcher extends vxa {
    @Override // com.baidu.tieba.vxa
    public boolean displayNotification() {
        return LooperRuntime.getInstance().getLooperUIContext().displayNotification();
    }

    public void addLooperPrinter(Printer printer) {
        LooperRuntime.getInstance().getLooperNeedContext().addLooperPrinter(printer);
    }

    public void removeLooperPrinter(Printer printer) {
        LooperRuntime.getInstance().getLooperNeedContext().removeLooperPrinter(printer);
    }

    @Override // com.baidu.tieba.vxa, com.baidu.tieba.xxa
    public void onBlock(Context context, dya dyaVar) {
        super.onBlock(context, dyaVar);
        LooperRuntime.getInstance().dispatchBlock(context, dyaVar);
    }
}
