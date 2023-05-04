package com.baidu.searchbox.looper.impl;

import android.content.Context;
import android.util.Printer;
import com.baidu.tieba.fwa;
import com.baidu.tieba.xva;
/* loaded from: classes2.dex */
public class LooperContextDispatcher extends xva {
    @Override // com.baidu.tieba.xva
    public boolean displayNotification() {
        return LooperRuntime.getInstance().getLooperUIContext().displayNotification();
    }

    public void addLooperPrinter(Printer printer) {
        LooperRuntime.getInstance().getLooperNeedContext().addLooperPrinter(printer);
    }

    public void removeLooperPrinter(Printer printer) {
        LooperRuntime.getInstance().getLooperNeedContext().removeLooperPrinter(printer);
    }

    @Override // com.baidu.tieba.xva, com.baidu.tieba.zva
    public void onBlock(Context context, fwa fwaVar) {
        super.onBlock(context, fwaVar);
        LooperRuntime.getInstance().dispatchBlock(context, fwaVar);
    }
}
