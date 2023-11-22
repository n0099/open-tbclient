package com.baidu.searchbox.looper.impl;

import android.content.Context;
import android.util.Printer;
import com.baidu.tieba.c3c;
import com.baidu.tieba.k3c;
/* loaded from: classes4.dex */
public class LooperContextDispatcher extends c3c {
    @Override // com.baidu.tieba.c3c
    public boolean displayNotification() {
        return LooperRuntime.getInstance().getLooperUIContext().displayNotification();
    }

    public void addLooperPrinter(Printer printer) {
        LooperRuntime.getInstance().getLooperNeedContext().addLooperPrinter(printer);
    }

    public void removeLooperPrinter(Printer printer) {
        LooperRuntime.getInstance().getLooperNeedContext().removeLooperPrinter(printer);
    }

    @Override // com.baidu.tieba.c3c, com.baidu.tieba.e3c
    public void onBlock(Context context, k3c k3cVar) {
        super.onBlock(context, k3cVar);
        LooperRuntime.getInstance().dispatchBlock(context, k3cVar);
    }
}
