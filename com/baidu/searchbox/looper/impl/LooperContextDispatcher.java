package com.baidu.searchbox.looper.impl;

import android.content.Context;
import android.util.Printer;
import com.baidu.tieba.b3c;
import com.baidu.tieba.j3c;
/* loaded from: classes4.dex */
public class LooperContextDispatcher extends b3c {
    @Override // com.baidu.tieba.b3c
    public boolean displayNotification() {
        return LooperRuntime.getInstance().getLooperUIContext().displayNotification();
    }

    public void addLooperPrinter(Printer printer) {
        LooperRuntime.getInstance().getLooperNeedContext().addLooperPrinter(printer);
    }

    public void removeLooperPrinter(Printer printer) {
        LooperRuntime.getInstance().getLooperNeedContext().removeLooperPrinter(printer);
    }

    @Override // com.baidu.tieba.b3c, com.baidu.tieba.d3c
    public void onBlock(Context context, j3c j3cVar) {
        super.onBlock(context, j3cVar);
        LooperRuntime.getInstance().dispatchBlock(context, j3cVar);
    }
}
