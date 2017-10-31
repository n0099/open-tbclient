package com.baidu.sofire;

import android.app.job.JobService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public class a extends JobService {
    private static final ExecutorService PJ = Executors.newCachedThreadPool();
}
