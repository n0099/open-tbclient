package com.baidu.searchbox.looper.impl;

import android.content.Context;
import android.util.Printer;
import com.baidu.tieba.cdb;
import com.baidu.tieba.ucb;
/* loaded from: classes4.dex */
public class LooperContextDispatcher extends ucb {
    @Override // com.baidu.tieba.ucb
    public boolean displayNotification() {
        return LooperRuntime.getInstance().getLooperUIContext().displayNotification();
    }

    public void addLooperPrinter(Printer printer) {
        LooperRuntime.getInstance().getLooperNeedContext().addLooperPrinter(printer);
    }

    public void removeLooperPrinter(Printer printer) {
        LooperRuntime.getInstance().getLooperNeedContext().removeLooperPrinter(printer);
    }

    @Override // com.baidu.tieba.ucb, com.baidu.tieba.wcb
    public void onBlock(Context context, cdb cdbVar) {
        super.onBlock(context, cdbVar);
        LooperRuntime.getInstance().dispatchBlock(context, cdbVar);
    }
}
