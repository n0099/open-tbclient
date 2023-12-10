package com.baidu.searchbox.looper.impl;

import android.content.Context;
import android.util.Printer;
import com.baidu.tieba.f8c;
import com.baidu.tieba.x7c;
/* loaded from: classes4.dex */
public class LooperContextDispatcher extends x7c {
    @Override // com.baidu.tieba.x7c
    public boolean displayNotification() {
        return LooperRuntime.getInstance().getLooperUIContext().displayNotification();
    }

    public void addLooperPrinter(Printer printer) {
        LooperRuntime.getInstance().getLooperNeedContext().addLooperPrinter(printer);
    }

    public void removeLooperPrinter(Printer printer) {
        LooperRuntime.getInstance().getLooperNeedContext().removeLooperPrinter(printer);
    }

    @Override // com.baidu.tieba.x7c, com.baidu.tieba.z7c
    public void onBlock(Context context, f8c f8cVar) {
        super.onBlock(context, f8cVar);
        LooperRuntime.getInstance().dispatchBlock(context, f8cVar);
    }
}
