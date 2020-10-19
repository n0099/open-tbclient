package android.support.v4.app;

import android.os.AsyncTask;
import android.support.v4.app.JobIntentService;
import com.baidu.android.imsdk.utils.LogUtils;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public abstract class ABIMService extends JobIntentService {
    private static final String TAG = "ABIMService";
    SafeCommandProcessor curProcessor;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.v4.app.JobIntentService
    public JobIntentService.GenericWorkItem dequeueWork() {
        try {
            return super.dequeueWork();
        } catch (SecurityException e) {
            LogUtils.e(TAG, "dequeueWork exception :", e);
            return null;
        }
    }

    @Override // android.support.v4.app.JobIntentService
    boolean doStopCurrentWork() {
        if (this.curProcessor != null) {
            this.curProcessor.cancel(this.mInterruptIfStopped);
        }
        this.mStopped = true;
        return onStopCurrentWork();
    }

    @Override // android.support.v4.app.JobIntentService
    void ensureProcessorRunningLocked(boolean z) {
        try {
            if (this.curProcessor == null) {
                this.curProcessor = new SafeCommandProcessor();
                if (this.mCompatWorkEnqueuer != null && z) {
                    this.mCompatWorkEnqueuer.serviceProcessingStarted();
                }
                this.curProcessor.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            }
        } catch (Throwable th) {
            LogUtils.e(TAG, "ensureProcessorRunningLocked exception :", th);
        }
    }

    @Override // android.support.v4.app.JobIntentService
    void processorFinished() {
        if (this.mCompatQueue != null) {
            try {
                ArrayList<JobIntentService.CompatWorkItem> arrayList = this.mCompatQueue;
                synchronized (this.mCompatQueue) {
                    this.curProcessor = null;
                    if (this.mCompatQueue != null && this.mCompatQueue.size() > 0) {
                        ensureProcessorRunningLocked(false);
                    } else if (!this.mDestroyed) {
                        this.mCompatWorkEnqueuer.serviceProcessingFinished();
                    }
                }
            } catch (Throwable th) {
                LogUtils.e(TAG, "processorFinished exception :", th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public final class SafeCommandProcessor extends AsyncTask<Void, Void, Void> {
        SafeCommandProcessor() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Void doInBackground(Void... voidArr) {
            while (true) {
                JobIntentService.GenericWorkItem dequeueWork = ABIMService.this.dequeueWork();
                if (dequeueWork != null) {
                    try {
                        ABIMService.this.onHandleWork(dequeueWork.getIntent());
                        dequeueWork.complete();
                    } catch (Throwable th) {
                        LogUtils.e(ABIMService.TAG, "doInBackground exception :", th);
                    }
                } else {
                    return null;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onCancelled(Void r2) {
            ABIMService.this.processorFinished();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Void r2) {
            ABIMService.this.processorFinished();
        }
    }
}
