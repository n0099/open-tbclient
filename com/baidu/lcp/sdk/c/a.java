package com.baidu.lcp.sdk.c;

import android.content.Context;
import com.baidu.lcp.sdk.d.d;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class a {
    private static a avR;
    private Context context;
    private ThreadPoolExecutor service;
    private ExecutorService singleThreadService;
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final int CORE_POOL_SIZE = Math.max(2, Math.min(CPU_COUNT - 1, 4));
    private static final int MAXIMUM_POOL_SIZE = (CPU_COUNT * 2) + 1;

    private a(Context context) {
        this.service = null;
        this.singleThreadService = null;
        this.context = context;
        this.service = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.service.allowCoreThreadTimeOut(true);
        this.singleThreadService = Executors.newSingleThreadExecutor();
    }

    public static a aF(Context context) {
        if (context == null) {
            return null;
        }
        if (avR == null) {
            synchronized (a.class) {
                if (avR == null) {
                    avR = new a(context);
                }
            }
        }
        return avR;
    }

    public void submitForNetWork(Runnable runnable) {
        try {
            this.service.submit(runnable);
        } catch (Throwable th) {
            d.e("TaskManager", "Exception ", th);
        }
    }
}
