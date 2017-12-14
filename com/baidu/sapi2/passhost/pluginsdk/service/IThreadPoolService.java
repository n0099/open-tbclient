package com.baidu.sapi2.passhost.pluginsdk.service;
/* loaded from: classes.dex */
public interface IThreadPoolService {
    void run(TPRunnable tPRunnable);

    void runDelay(TPRunnable tPRunnable, long j);

    void runImport(TPRunnable tPRunnable);

    void runInUiThread(TPRunnable tPRunnable);

    void runInUiThreadDelay(TPRunnable tPRunnable, long j);
}
