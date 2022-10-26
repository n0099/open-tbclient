package com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import com.airbnb.lottie.utils.Logger;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
/* loaded from: classes.dex */
public class LottieTask {
    public static Executor EXECUTOR = Executors.newCachedThreadPool();
    public final Set failureListeners;
    public final Handler handler;
    public volatile LottieResult result;
    public final Set successListeners;

    /* loaded from: classes.dex */
    public class LottieFutureTask extends FutureTask {
        public LottieFutureTask(Callable callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        public void done() {
            if (isCancelled()) {
                return;
            }
            try {
                LottieTask.this.setResult((LottieResult) get());
            } catch (InterruptedException | ExecutionException e) {
                LottieTask.this.setResult(new LottieResult(e));
            }
        }
    }

    private void notifyListeners() {
        this.handler.post(new Runnable() { // from class: com.airbnb.lottie.LottieTask.1
            @Override // java.lang.Runnable
            public void run() {
                if (LottieTask.this.result != null) {
                    LottieResult lottieResult = LottieTask.this.result;
                    if (lottieResult.getValue() != null) {
                        LottieTask.this.notifySuccessListeners(lottieResult.getValue());
                    } else {
                        LottieTask.this.notifyFailureListeners(lottieResult.getException());
                    }
                }
            }
        });
    }

    public LottieTask(Callable callable) {
        this(callable, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void notifyFailureListeners(Throwable th) {
        ArrayList<LottieListener> arrayList = new ArrayList(this.failureListeners);
        if (arrayList.isEmpty()) {
            Logger.warning("Lottie encountered an error but no failure listener was added:", th);
            return;
        }
        for (LottieListener lottieListener : arrayList) {
            lottieListener.onResult(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void notifySuccessListeners(Object obj) {
        for (LottieListener lottieListener : new ArrayList(this.successListeners)) {
            lottieListener.onResult(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResult(LottieResult lottieResult) {
        if (this.result == null) {
            this.result = lottieResult;
            notifyListeners();
            return;
        }
        throw new IllegalStateException("A task may only be set once.");
    }

    public synchronized LottieTask addFailureListener(LottieListener lottieListener) {
        if (this.result != null && this.result.getException() != null) {
            lottieListener.onResult(this.result.getException());
        }
        this.failureListeners.add(lottieListener);
        return this;
    }

    public synchronized LottieTask addListener(LottieListener lottieListener) {
        if (this.result != null && this.result.getValue() != null) {
            lottieListener.onResult(this.result.getValue());
        }
        this.successListeners.add(lottieListener);
        return this;
    }

    public synchronized LottieTask removeFailureListener(LottieListener lottieListener) {
        this.failureListeners.remove(lottieListener);
        return this;
    }

    public synchronized LottieTask removeListener(LottieListener lottieListener) {
        this.successListeners.remove(lottieListener);
        return this;
    }

    public LottieTask(Callable callable, boolean z) {
        this.successListeners = new LinkedHashSet(1);
        this.failureListeners = new LinkedHashSet(1);
        this.handler = new Handler(Looper.getMainLooper());
        this.result = null;
        if (z) {
            try {
                setResult((LottieResult) callable.call());
                return;
            } catch (Throwable th) {
                setResult(new LottieResult(th));
                return;
            }
        }
        EXECUTOR.execute(new LottieFutureTask(callable));
    }
}
