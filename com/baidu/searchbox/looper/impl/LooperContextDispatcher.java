package com.baidu.searchbox.looper.impl;

import android.content.Context;
import android.util.Printer;
import com.github.a.a.a.a;
import com.github.a.a.b;
/* loaded from: classes4.dex */
public class LooperContextDispatcher extends b {
    public void addLooperPrinter(Printer printer) {
        LooperRuntime.getInstance().getLooperNeedContext().addLooperPrinter(printer);
    }

    public void removeLooperPrinter(Printer printer) {
        LooperRuntime.getInstance().getLooperNeedContext().removeLooperPrinter(printer);
    }

    @Override // com.github.a.a.b
    public boolean displayNotification() {
        return LooperRuntime.getInstance().getLooperUIContext().displayNotification();
    }

    @Override // com.github.a.a.b, com.github.a.a.d
    public void onBlock(Context context, a aVar) {
        super.onBlock(context, aVar);
        LooperRuntime.getInstance().dispatchBlock(context, aVar);
    }
}
