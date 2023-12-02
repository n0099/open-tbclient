package com.baidu.searchbox.looper.impl;

import android.content.Context;
import android.util.Printer;
import com.baidu.tieba.e8c;
import com.baidu.tieba.w7c;
/* loaded from: classes4.dex */
public class LooperContextDispatcher extends w7c {
    @Override // com.baidu.tieba.w7c
    public boolean displayNotification() {
        return LooperRuntime.getInstance().getLooperUIContext().displayNotification();
    }

    public void addLooperPrinter(Printer printer) {
        LooperRuntime.getInstance().getLooperNeedContext().addLooperPrinter(printer);
    }

    public void removeLooperPrinter(Printer printer) {
        LooperRuntime.getInstance().getLooperNeedContext().removeLooperPrinter(printer);
    }

    @Override // com.baidu.tieba.w7c, com.baidu.tieba.y7c
    public void onBlock(Context context, e8c e8cVar) {
        super.onBlock(context, e8cVar);
        LooperRuntime.getInstance().dispatchBlock(context, e8cVar);
    }
}
