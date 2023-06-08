package com.baidu.searchbox.looper.impl;

import android.content.Context;
import android.util.Printer;
import com.baidu.tieba.l6b;
import com.baidu.tieba.t6b;
/* loaded from: classes4.dex */
public class LooperContextDispatcher extends l6b {
    @Override // com.baidu.tieba.l6b
    public boolean displayNotification() {
        return LooperRuntime.getInstance().getLooperUIContext().displayNotification();
    }

    public void addLooperPrinter(Printer printer) {
        LooperRuntime.getInstance().getLooperNeedContext().addLooperPrinter(printer);
    }

    public void removeLooperPrinter(Printer printer) {
        LooperRuntime.getInstance().getLooperNeedContext().removeLooperPrinter(printer);
    }

    @Override // com.baidu.tieba.l6b, com.baidu.tieba.n6b
    public void onBlock(Context context, t6b t6bVar) {
        super.onBlock(context, t6bVar);
        LooperRuntime.getInstance().dispatchBlock(context, t6bVar);
    }
}
