package com.baidu.searchbox.looper.impl;

import android.content.Context;
import android.util.Printer;
import com.baidu.tieba.bca;
import com.baidu.tieba.tba;
/* loaded from: classes2.dex */
public class LooperContextDispatcher extends tba {
    @Override // com.baidu.tieba.tba
    public boolean displayNotification() {
        return LooperRuntime.getInstance().getLooperUIContext().displayNotification();
    }

    public void addLooperPrinter(Printer printer) {
        LooperRuntime.getInstance().getLooperNeedContext().addLooperPrinter(printer);
    }

    public void removeLooperPrinter(Printer printer) {
        LooperRuntime.getInstance().getLooperNeedContext().removeLooperPrinter(printer);
    }

    @Override // com.baidu.tieba.tba, com.baidu.tieba.vba
    public void onBlock(Context context, bca bcaVar) {
        super.onBlock(context, bcaVar);
        LooperRuntime.getInstance().dispatchBlock(context, bcaVar);
    }
}
