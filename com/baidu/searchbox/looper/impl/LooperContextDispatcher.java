package com.baidu.searchbox.looper.impl;

import android.content.Context;
import android.util.Printer;
import d.g.b.a.b;
import d.g.b.a.j.a;
/* loaded from: classes2.dex */
public class LooperContextDispatcher extends b {
    public void addLooperPrinter(Printer printer) {
        LooperRuntime.getInstance().getLooperNeedContext().addLooperPrinter(printer);
    }

    @Override // d.g.b.a.b
    public boolean displayNotification() {
        return LooperRuntime.getInstance().getLooperUIContext().displayNotification();
    }

    @Override // d.g.b.a.b, d.g.b.a.d
    public void onBlock(Context context, a aVar) {
        super.onBlock(context, aVar);
        LooperRuntime.getInstance().dispatchBlock(context, aVar);
    }

    public void removeLooperPrinter(Printer printer) {
        LooperRuntime.getInstance().getLooperNeedContext().removeLooperPrinter(printer);
    }
}
