package com.baidu.pass.biometrics.base.utils.thread;
/* loaded from: classes2.dex */
public interface IThreadPoolService {
    void run(TPRunnable tPRunnable);

    void runDelay(TPRunnable tPRunnable, long j);

    void runImport(TPRunnable tPRunnable);

    void runInUiThread(TPRunnable tPRunnable);

    void runInUiThreadDelay(TPRunnable tPRunnable, long j);
}
