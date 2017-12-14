package com.baidu.sofire;

import android.annotation.TargetApi;
import android.app.job.JobService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
@TargetApi(21)
/* loaded from: classes.dex */
public class a extends JobService {
    private static final ExecutorService Qe = Executors.newCachedThreadPool();
}
