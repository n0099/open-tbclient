package com.baidu.android.util.logs;

import android.os.Looper;
import android.util.Printer;
import com.baidu.android.util.concurrent.UiThreadUtil;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class MainLooperPrinter implements Printer {
    private static volatile MainLooperPrinter sInstance;
    private List<Printer> mPrinterList = new ArrayList(3);

    private MainLooperPrinter() {
    }

    public static MainLooperPrinter getInstance() {
        if (sInstance == null) {
            synchronized (MainLooperPrinter.class) {
                if (sInstance == null) {
                    sInstance = new MainLooperPrinter();
                }
            }
        }
        return sInstance;
    }

    @Override // android.util.Printer
    public void println(String str) {
        for (Printer printer : this.mPrinterList) {
            if (printer != null) {
                printer.println(str);
            }
        }
    }

    public void addPrinter(final Printer printer) {
        if (UiThreadUtil.isOnUiThread()) {
            addPrinterInternal(printer);
        } else {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.android.util.logs.MainLooperPrinter.1
                @Override // java.lang.Runnable
                public void run() {
                    MainLooperPrinter.this.addPrinterInternal(printer);
                }
            });
        }
    }

    public void removePrinter(final Printer printer) {
        if (UiThreadUtil.isOnUiThread()) {
            removePrinterInternal(printer);
        } else {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.android.util.logs.MainLooperPrinter.2
                @Override // java.lang.Runnable
                public void run() {
                    MainLooperPrinter.this.removePrinterInternal(printer);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPrinterInternal(Printer printer) {
        if (printer != null && !this.mPrinterList.contains(printer)) {
            this.mPrinterList.add(printer);
            if (this.mPrinterList.size() == 1) {
                Looper.getMainLooper().setMessageLogging(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removePrinterInternal(Printer printer) {
        if (printer != null) {
            this.mPrinterList.remove(printer);
            if (this.mPrinterList.size() <= 0) {
                Looper.getMainLooper().setMessageLogging(null);
            }
        }
    }
}
