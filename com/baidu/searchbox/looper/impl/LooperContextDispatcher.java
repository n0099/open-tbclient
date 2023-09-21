package com.baidu.searchbox.looper.impl;

import android.content.Context;
import android.util.Printer;
import com.baidu.tieba.dwb;
import com.baidu.tieba.lwb;
/* loaded from: classes4.dex */
public class LooperContextDispatcher extends dwb {
    @Override // com.baidu.tieba.dwb
    public boolean displayNotification() {
        return LooperRuntime.getInstance().getLooperUIContext().displayNotification();
    }

    public void addLooperPrinter(Printer printer) {
        LooperRuntime.getInstance().getLooperNeedContext().addLooperPrinter(printer);
    }

    public void removeLooperPrinter(Printer printer) {
        LooperRuntime.getInstance().getLooperNeedContext().removeLooperPrinter(printer);
    }

    @Override // com.baidu.tieba.dwb, com.baidu.tieba.fwb
    public void onBlock(Context context, lwb lwbVar) {
        super.onBlock(context, lwbVar);
        LooperRuntime.getInstance().dispatchBlock(context, lwbVar);
    }
}
