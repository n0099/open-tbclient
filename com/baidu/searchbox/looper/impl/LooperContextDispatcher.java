package com.baidu.searchbox.looper.impl;

import android.content.Context;
import android.util.Printer;
import com.baidu.tieba.krb;
import com.baidu.tieba.srb;
/* loaded from: classes4.dex */
public class LooperContextDispatcher extends krb {
    @Override // com.baidu.tieba.krb
    public boolean displayNotification() {
        return LooperRuntime.getInstance().getLooperUIContext().displayNotification();
    }

    public void addLooperPrinter(Printer printer) {
        LooperRuntime.getInstance().getLooperNeedContext().addLooperPrinter(printer);
    }

    public void removeLooperPrinter(Printer printer) {
        LooperRuntime.getInstance().getLooperNeedContext().removeLooperPrinter(printer);
    }

    @Override // com.baidu.tieba.krb, com.baidu.tieba.mrb
    public void onBlock(Context context, srb srbVar) {
        super.onBlock(context, srbVar);
        LooperRuntime.getInstance().dispatchBlock(context, srbVar);
    }
}
