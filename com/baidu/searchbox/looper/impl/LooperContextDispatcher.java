package com.baidu.searchbox.looper.impl;

import android.content.Context;
import android.util.Printer;
import com.baidu.tieba.bsa;
import com.baidu.tieba.tra;
/* loaded from: classes2.dex */
public class LooperContextDispatcher extends tra {
    @Override // com.baidu.tieba.tra
    public boolean displayNotification() {
        return LooperRuntime.getInstance().getLooperUIContext().displayNotification();
    }

    public void addLooperPrinter(Printer printer) {
        LooperRuntime.getInstance().getLooperNeedContext().addLooperPrinter(printer);
    }

    public void removeLooperPrinter(Printer printer) {
        LooperRuntime.getInstance().getLooperNeedContext().removeLooperPrinter(printer);
    }

    @Override // com.baidu.tieba.tra, com.baidu.tieba.vra
    public void onBlock(Context context, bsa bsaVar) {
        super.onBlock(context, bsaVar);
        LooperRuntime.getInstance().dispatchBlock(context, bsaVar);
    }
}
