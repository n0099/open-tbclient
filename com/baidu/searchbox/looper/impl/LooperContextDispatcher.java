package com.baidu.searchbox.looper.impl;

import android.content.Context;
import android.util.Printer;
import com.baidu.tieba.aqb;
import com.baidu.tieba.iqb;
/* loaded from: classes4.dex */
public class LooperContextDispatcher extends aqb {
    @Override // com.baidu.tieba.aqb
    public boolean displayNotification() {
        return LooperRuntime.getInstance().getLooperUIContext().displayNotification();
    }

    public void addLooperPrinter(Printer printer) {
        LooperRuntime.getInstance().getLooperNeedContext().addLooperPrinter(printer);
    }

    public void removeLooperPrinter(Printer printer) {
        LooperRuntime.getInstance().getLooperNeedContext().removeLooperPrinter(printer);
    }

    @Override // com.baidu.tieba.aqb, com.baidu.tieba.cqb
    public void onBlock(Context context, iqb iqbVar) {
        super.onBlock(context, iqbVar);
        LooperRuntime.getInstance().dispatchBlock(context, iqbVar);
    }
}
