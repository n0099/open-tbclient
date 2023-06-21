package com.baidu.searchbox.looper.impl;

import android.content.Context;
import android.util.Printer;
import com.baidu.tieba.e8b;
import com.baidu.tieba.m8b;
/* loaded from: classes4.dex */
public class LooperContextDispatcher extends e8b {
    @Override // com.baidu.tieba.e8b
    public boolean displayNotification() {
        return LooperRuntime.getInstance().getLooperUIContext().displayNotification();
    }

    public void addLooperPrinter(Printer printer) {
        LooperRuntime.getInstance().getLooperNeedContext().addLooperPrinter(printer);
    }

    public void removeLooperPrinter(Printer printer) {
        LooperRuntime.getInstance().getLooperNeedContext().removeLooperPrinter(printer);
    }

    @Override // com.baidu.tieba.e8b, com.baidu.tieba.g8b
    public void onBlock(Context context, m8b m8bVar) {
        super.onBlock(context, m8bVar);
        LooperRuntime.getInstance().dispatchBlock(context, m8bVar);
    }
}
