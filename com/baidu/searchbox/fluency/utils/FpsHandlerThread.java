package com.baidu.searchbox.fluency.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\u0003R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/fluency/utils/FpsHandlerThread;", "Landroid/os/Handler;", "getDefaultHandler", "()Landroid/os/Handler;", "Landroid/os/HandlerThread;", "getDefaultHandlerThread", "()Landroid/os/HandlerThread;", "getDefaultMainHandler", "", "FPS_THREAD_NAME", "Ljava/lang/String;", "TAG", "defaultHandler", "Landroid/os/Handler;", "defaultHandlerThread", "Landroid/os/HandlerThread;", "defaultMainHandler", "<init>", "()V", "lib-fps_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class FpsHandlerThread {
    public static final String FPS_THREAD_NAME = "seachbox_fps_thread";
    public static final String TAG = "FpsHandlerThread";
    public static Handler defaultHandler;
    public static HandlerThread defaultHandlerThread;
    public static final FpsHandlerThread INSTANCE = new FpsHandlerThread();
    public static Handler defaultMainHandler = new Handler(Looper.getMainLooper());

    public final Handler getDefaultHandler() {
        if (defaultHandler == null) {
            getDefaultHandlerThread();
        }
        Handler handler = defaultHandler;
        Intrinsics.checkNotNull(handler);
        return handler;
    }

    public final HandlerThread getDefaultHandlerThread() {
        if (defaultHandlerThread == null) {
            HandlerThread handlerThread = new HandlerThread(FPS_THREAD_NAME);
            defaultHandlerThread = handlerThread;
            Intrinsics.checkNotNull(handlerThread);
            handlerThread.start();
            HandlerThread handlerThread2 = defaultHandlerThread;
            Intrinsics.checkNotNull(handlerThread2);
            defaultHandler = new Handler(handlerThread2.getLooper());
        }
        HandlerThread handlerThread3 = defaultHandlerThread;
        Intrinsics.checkNotNull(handlerThread3);
        return handlerThread3;
    }

    public final Handler getDefaultMainHandler() {
        return defaultMainHandler;
    }
}
