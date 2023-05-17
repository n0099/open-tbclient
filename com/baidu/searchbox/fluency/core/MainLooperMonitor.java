package com.baidu.searchbox.fluency.core;

import android.os.Build;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Printer;
import androidx.annotation.CallSuper;
import com.baidu.searchbox.fluency.utils.Logcat;
import com.baidu.searchbox.fluency.utils.ReflectHelper;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 #2\u00020\u0001:\u0003#$%B\u0007¢\u0006\u0004\b\"\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0011\u0010\u0004J\u0015\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R&\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0018j\b\u0012\u0004\u0012\u00020\r`\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!¨\u0006&"}, d2 = {"Lcom/baidu/searchbox/fluency/core/MainLooperMonitor;", "android/os/MessageQueue$IdleHandler", "", "addIdleHandler", "()V", "", "dispatchBegin", "", "log", "dispatchMsg", "(ZLjava/lang/String;)V", "queueIdle", "()Z", "Lcom/baidu/searchbox/fluency/core/MainLooperMonitor$LopperDispatchListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, MiPushClient.COMMAND_REGISTER, "(Lcom/baidu/searchbox/fluency/core/MainLooperMonitor$LopperDispatchListener;)V", "resetPrinter", MiPushClient.COMMAND_UNREGISTER, "isReflectPrinterError", "Z", "", "lastCheckPrinterTime", "J", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "listeners", "Ljava/util/HashSet;", "Landroid/os/Looper;", "mainLooper", "Landroid/os/Looper;", "Landroid/util/Printer;", "printer", "Landroid/util/Printer;", "<init>", "Companion", "LooperPrinter", "LopperDispatchListener", "lib-fps_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class MainLooperMonitor implements MessageQueue.IdleHandler {
    public static final long CHECK_DURATION = 60000;
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "MainLooperMonitor";
    public boolean isReflectPrinterError;
    public long lastCheckPrinterTime;
    public HashSet<LopperDispatchListener> listeners = new HashSet<>();
    public final Looper mainLooper;
    public Printer printer;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/fluency/core/MainLooperMonitor$Companion;", "", "CHECK_DURATION", "J", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "lib-fps_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/fluency/core/MainLooperMonitor$LooperPrinter;", "Landroid/util/Printer;", "", "x", "", "println", "(Ljava/lang/String;)V", "originPrinter", "Landroid/util/Printer;", "<init>", "(Lcom/baidu/searchbox/fluency/core/MainLooperMonitor;Landroid/util/Printer;)V", "lib-fps_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public final class LooperPrinter implements Printer {
        public final Printer originPrinter;

        public LooperPrinter(Printer printer) {
            this.originPrinter = printer;
        }

        @Override // android.util.Printer
        public void println(String str) {
            boolean z;
            Printer printer = this.originPrinter;
            if (printer != null) {
                printer.println(str);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Intrinsics.checkNotNull(str);
            boolean z2 = false;
            if (str.charAt(0) != '>' && str.charAt(0) != '<') {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                MainLooperMonitor mainLooperMonitor = MainLooperMonitor.this;
                if (str.charAt(0) == '>') {
                    z2 = true;
                }
                mainLooperMonitor.dispatchMsg(z2, str);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b&\u0018\u0000B\u0007¢\u0006\u0004\b\u0012\u0010\u0003J\u000f\u0010\u0002\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0004\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0004\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\f\u0010\u000bJ\r\u0010\r\u001a\u00020\u0001¢\u0006\u0004\b\r\u0010\u0003R\"\u0010\u000e\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/fluency/core/MainLooperMonitor$LopperDispatchListener;", "", "dispatchEnd", "()V", "dispatchStart", "", "isEnable", "()Z", "", "log", "onDispatchEnd", "(Ljava/lang/String;)V", "onDispatchStart", "resetDispatchListener", "isHasDispatchStart", "Z", "setHasDispatchStart", "(Z)V", "<init>", "lib-fps_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public static abstract class LopperDispatchListener {
        public boolean isHasDispatchStart;

        public void dispatchEnd() {
        }

        public void dispatchStart() {
        }

        public boolean isEnable() {
            return false;
        }

        public final boolean isHasDispatchStart() {
            return this.isHasDispatchStart;
        }

        public final void resetDispatchListener() {
            this.isHasDispatchStart = false;
        }

        @CallSuper
        public final void onDispatchEnd(String log) {
            Intrinsics.checkNotNullParameter(log, "log");
            this.isHasDispatchStart = false;
            dispatchEnd();
        }

        @CallSuper
        public final void onDispatchStart(String log) {
            Intrinsics.checkNotNullParameter(log, "log");
            this.isHasDispatchStart = true;
            dispatchStart();
        }

        public final void setHasDispatchStart(boolean z) {
            this.isHasDispatchStart = z;
        }
    }

    public MainLooperMonitor() {
        Looper mainLooper = Looper.getMainLooper();
        Intrinsics.checkNotNullExpressionValue(mainLooper, "Looper.getMainLooper()");
        this.mainLooper = mainLooper;
        resetPrinter();
        addIdleHandler();
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        if (SystemClock.uptimeMillis() - this.lastCheckPrinterTime >= 60000) {
            Logcat.INSTANCE.d(TAG, "[queueIdle] check printer!");
            resetPrinter();
            this.lastCheckPrinterTime = SystemClock.uptimeMillis();
            return true;
        }
        return true;
    }

    private final void addIdleHandler() {
        if (Build.VERSION.SDK_INT >= 23) {
            this.mainLooper.getQueue().addIdleHandler(this);
            return;
        }
        try {
            MessageQueue messageQueue = (MessageQueue) ReflectHelper.INSTANCE.get(this.mainLooper.getClass(), "mQueue", this.mainLooper);
            if (messageQueue != null) {
                messageQueue.addIdleHandler(this);
            }
        } catch (Exception e) {
            Logcat logcat = Logcat.INSTANCE;
            logcat.e(TAG, "[addIdleHandler] " + e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatchMsg(boolean z, String str) {
        Iterator<LopperDispatchListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            LopperDispatchListener next = it.next();
            if (next.isEnable()) {
                if (z) {
                    if (!next.isHasDispatchStart()) {
                        next.onDispatchStart(str);
                    }
                } else if (next.isHasDispatchStart()) {
                    next.onDispatchEnd(str);
                }
            } else if (!z && next.isHasDispatchStart()) {
                next.dispatchEnd();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void resetPrinter() {
        Printer printer;
        Exception e;
        Printer printer2 = null;
        try {
        } catch (Exception e2) {
            printer = null;
            e = e2;
        }
        if (!this.isReflectPrinterError) {
            printer = (Printer) ReflectHelper.INSTANCE.get(this.mainLooper.getClass(), "mLogging", this.mainLooper);
            try {
                if (Intrinsics.areEqual(printer, this.printer) && this.printer != null) {
                    Logcat.INSTANCE.d(TAG, "[resetPrinter] same printer, do nothing!");
                    return;
                }
            } catch (Exception e3) {
                e = e3;
                this.isReflectPrinterError = true;
                Logcat.INSTANCE.e(TAG, "[resetPrinter] " + e);
                printer2 = printer;
                if (this.printer != null) {
                }
                LooperPrinter looperPrinter = new LooperPrinter(printer2);
                this.printer = looperPrinter;
                this.mainLooper.setMessageLogging(looperPrinter);
            }
            printer2 = printer;
        }
        if (this.printer != null) {
            Logcat.INSTANCE.d(TAG, "[resetPrinter] replace printer!");
        }
        LooperPrinter looperPrinter2 = new LooperPrinter(printer2);
        this.printer = looperPrinter2;
        this.mainLooper.setMessageLogging(looperPrinter2);
    }

    public final void register(LopperDispatchListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.add(listener);
    }

    public final void unregister(LopperDispatchListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.remove(listener);
    }
}
