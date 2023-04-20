package com.baidu.searchbox.looper.impl;

import android.content.Context;
import android.util.Printer;
import com.baidu.tieba.bsa;
import com.baidu.tieba.jsa;
/* loaded from: classes2.dex */
public class LooperContextDispatcher extends bsa {
    @Override // com.baidu.tieba.bsa
    public boolean displayNotification() {
        return LooperRuntime.getInstance().getLooperUIContext().displayNotification();
    }

    public void addLooperPrinter(Printer printer) {
        LooperRuntime.getInstance().getLooperNeedContext().addLooperPrinter(printer);
    }

    public void removeLooperPrinter(Printer printer) {
        LooperRuntime.getInstance().getLooperNeedContext().removeLooperPrinter(printer);
    }

    @Override // com.baidu.tieba.bsa, com.baidu.tieba.dsa
    public void onBlock(Context context, jsa jsaVar) {
        super.onBlock(context, jsaVar);
        LooperRuntime.getInstance().dispatchBlock(context, jsaVar);
    }
}
