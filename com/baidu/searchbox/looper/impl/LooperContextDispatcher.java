package com.baidu.searchbox.looper.impl;

import android.content.Context;
import android.util.Printer;
import com.baidu.tieba.rlb;
import com.baidu.tieba.zlb;
/* loaded from: classes4.dex */
public class LooperContextDispatcher extends rlb {
    @Override // com.baidu.tieba.rlb
    public boolean displayNotification() {
        return LooperRuntime.getInstance().getLooperUIContext().displayNotification();
    }

    public void addLooperPrinter(Printer printer) {
        LooperRuntime.getInstance().getLooperNeedContext().addLooperPrinter(printer);
    }

    public void removeLooperPrinter(Printer printer) {
        LooperRuntime.getInstance().getLooperNeedContext().removeLooperPrinter(printer);
    }

    @Override // com.baidu.tieba.rlb, com.baidu.tieba.tlb
    public void onBlock(Context context, zlb zlbVar) {
        super.onBlock(context, zlbVar);
        LooperRuntime.getInstance().dispatchBlock(context, zlbVar);
    }
}
