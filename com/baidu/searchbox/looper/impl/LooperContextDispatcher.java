package com.baidu.searchbox.looper.impl;

import android.content.Context;
import android.util.Printer;
import com.baidu.tieba.dlb;
import com.baidu.tieba.vkb;
/* loaded from: classes4.dex */
public class LooperContextDispatcher extends vkb {
    @Override // com.baidu.tieba.vkb
    public boolean displayNotification() {
        return LooperRuntime.getInstance().getLooperUIContext().displayNotification();
    }

    public void addLooperPrinter(Printer printer) {
        LooperRuntime.getInstance().getLooperNeedContext().addLooperPrinter(printer);
    }

    public void removeLooperPrinter(Printer printer) {
        LooperRuntime.getInstance().getLooperNeedContext().removeLooperPrinter(printer);
    }

    @Override // com.baidu.tieba.vkb, com.baidu.tieba.xkb
    public void onBlock(Context context, dlb dlbVar) {
        super.onBlock(context, dlbVar);
        LooperRuntime.getInstance().dispatchBlock(context, dlbVar);
    }
}
