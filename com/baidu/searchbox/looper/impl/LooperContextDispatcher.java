package com.baidu.searchbox.looper.impl;

import android.content.Context;
import android.util.Printer;
import com.baidu.tieba.g6b;
import com.baidu.tieba.o6b;
/* loaded from: classes4.dex */
public class LooperContextDispatcher extends g6b {
    @Override // com.baidu.tieba.g6b
    public boolean displayNotification() {
        return LooperRuntime.getInstance().getLooperUIContext().displayNotification();
    }

    public void addLooperPrinter(Printer printer) {
        LooperRuntime.getInstance().getLooperNeedContext().addLooperPrinter(printer);
    }

    public void removeLooperPrinter(Printer printer) {
        LooperRuntime.getInstance().getLooperNeedContext().removeLooperPrinter(printer);
    }

    @Override // com.baidu.tieba.g6b, com.baidu.tieba.i6b
    public void onBlock(Context context, o6b o6bVar) {
        super.onBlock(context, o6bVar);
        LooperRuntime.getInstance().dispatchBlock(context, o6bVar);
    }
}
