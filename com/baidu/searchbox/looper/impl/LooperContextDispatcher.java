package com.baidu.searchbox.looper.impl;

import android.content.Context;
import android.util.Printer;
import com.baidu.tieba.mrb;
import com.baidu.tieba.urb;
/* loaded from: classes4.dex */
public class LooperContextDispatcher extends mrb {
    @Override // com.baidu.tieba.mrb
    public boolean displayNotification() {
        return LooperRuntime.getInstance().getLooperUIContext().displayNotification();
    }

    public void addLooperPrinter(Printer printer) {
        LooperRuntime.getInstance().getLooperNeedContext().addLooperPrinter(printer);
    }

    public void removeLooperPrinter(Printer printer) {
        LooperRuntime.getInstance().getLooperNeedContext().removeLooperPrinter(printer);
    }

    @Override // com.baidu.tieba.mrb, com.baidu.tieba.orb
    public void onBlock(Context context, urb urbVar) {
        super.onBlock(context, urbVar);
        LooperRuntime.getInstance().dispatchBlock(context, urbVar);
    }
}
