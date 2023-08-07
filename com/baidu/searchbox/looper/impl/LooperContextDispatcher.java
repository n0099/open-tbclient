package com.baidu.searchbox.looper.impl;

import android.content.Context;
import android.util.Printer;
import com.baidu.tieba.clb;
import com.baidu.tieba.ukb;
/* loaded from: classes4.dex */
public class LooperContextDispatcher extends ukb {
    @Override // com.baidu.tieba.ukb
    public boolean displayNotification() {
        return LooperRuntime.getInstance().getLooperUIContext().displayNotification();
    }

    public void addLooperPrinter(Printer printer) {
        LooperRuntime.getInstance().getLooperNeedContext().addLooperPrinter(printer);
    }

    public void removeLooperPrinter(Printer printer) {
        LooperRuntime.getInstance().getLooperNeedContext().removeLooperPrinter(printer);
    }

    @Override // com.baidu.tieba.ukb, com.baidu.tieba.wkb
    public void onBlock(Context context, clb clbVar) {
        super.onBlock(context, clbVar);
        LooperRuntime.getInstance().dispatchBlock(context, clbVar);
    }
}
