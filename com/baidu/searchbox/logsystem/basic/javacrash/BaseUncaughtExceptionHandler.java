package com.baidu.searchbox.logsystem.basic.javacrash;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.java.Supplier;
import com.baidu.searchbox.logsystem.basic.LogSystemServiceUtil;
import com.baidu.searchbox.logsystem.basic.eventhandler.DefaultProcessEventSceneHandler;
import com.baidu.searchbox.logsystem.basic.eventhandler.OOMEventSceneSceneHandler;
import com.baidu.searchbox.logsystem.basic.eventhandler.RssOOMEventSceneSceneHandler;
import com.baidu.searchbox.logsystem.basic.eventhandler.VssOOMEventSceneSceneHandler;
import com.baidu.searchbox.logsystem.javacrash.ProcessExceptionListener;
import com.baidu.searchbox.logsystem.logsys.LogExtra;
import com.baidu.searchbox.logsystem.logsys.LogType;
import com.baidu.searchbox.logsystem.logsys.eventscene.handler.ForwardingProcessEventSceneHandler;
import com.baidu.searchbox.logsystem.logsys.eventscene.handler.ProcessEventSceneHandler;
import java.io.File;
import java.util.List;
/* loaded from: classes2.dex */
public class BaseUncaughtExceptionHandler extends BUncaughtExceptionHandler {
    public final Supplier<List<ProcessEventSceneHandler>> mSupplier;

    public BaseUncaughtExceptionHandler(@NonNull Context context, @Nullable List<ProcessExceptionListener> list, @Nullable Supplier<List<ProcessEventSceneHandler>> supplier) {
        super(context, list);
        this.mSupplier = supplier;
    }

    @Override // com.baidu.searchbox.logsystem.basic.javacrash.BUncaughtExceptionHandler
    public final ForwardingProcessEventSceneHandler getForwardingHandler() {
        ForwardingProcessEventSceneHandler forwardingProcessEventSceneHandler = new ForwardingProcessEventSceneHandler();
        forwardingProcessEventSceneHandler.addEventHandleCallback(new DefaultProcessEventSceneHandler());
        forwardingProcessEventSceneHandler.addEventHandleCallback(new VssOOMEventSceneSceneHandler());
        forwardingProcessEventSceneHandler.addEventHandleCallback(new OOMEventSceneSceneHandler());
        forwardingProcessEventSceneHandler.addEventHandleCallback(new RssOOMEventSceneSceneHandler());
        Supplier<List<ProcessEventSceneHandler>> supplier = this.mSupplier;
        if (supplier != null) {
            forwardingProcessEventSceneHandler.addEventHandleCallback(supplier.get());
        }
        return forwardingProcessEventSceneHandler;
    }

    @Override // com.baidu.searchbox.logsystem.basic.javacrash.BUncaughtExceptionHandler
    public void onReport(@NonNull Context context, @NonNull String str, @Nullable File file, @Nullable LogExtra logExtra) {
        LogSystemServiceUtil.startLogHandlerService(context, LogType.JAVA_CRASH, str, file, logExtra);
    }

    public BaseUncaughtExceptionHandler(@Nullable Context context) {
        this(context, null, null);
    }

    public BaseUncaughtExceptionHandler(@NonNull Context context, @Nullable Supplier<List<ProcessEventSceneHandler>> supplier) {
        this(context, null, supplier);
    }
}
