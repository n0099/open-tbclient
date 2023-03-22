package com.baidu.searchbox.looper.impl;

import android.content.Context;
import android.util.Printer;
import com.baidu.tieba.cia;
import com.baidu.tieba.kia;
/* loaded from: classes2.dex */
public class LooperContextDispatcher extends cia {
    @Override // com.baidu.tieba.cia
    public boolean displayNotification() {
        return LooperRuntime.getInstance().getLooperUIContext().displayNotification();
    }

    public void addLooperPrinter(Printer printer) {
        LooperRuntime.getInstance().getLooperNeedContext().addLooperPrinter(printer);
    }

    public void removeLooperPrinter(Printer printer) {
        LooperRuntime.getInstance().getLooperNeedContext().removeLooperPrinter(printer);
    }

    @Override // com.baidu.tieba.cia, com.baidu.tieba.eia
    public void onBlock(Context context, kia kiaVar) {
        super.onBlock(context, kiaVar);
        LooperRuntime.getInstance().dispatchBlock(context, kiaVar);
    }
}
