package aegon.chrome.net;

import java.util.concurrent.Executor;
/* loaded from: classes4.dex */
public abstract class RequestFinishedInfo {

    /* loaded from: classes4.dex */
    public static abstract class Listener {
        public final Executor mExecutor;

        public Listener(Executor executor) {
            if (executor == null) {
                throw new IllegalStateException("Executor must not be null");
            }
            this.mExecutor = executor;
        }

        public Executor getExecutor() {
            return this.mExecutor;
        }

        public abstract void onRequestFinished(RequestFinishedInfo requestFinishedInfo);
    }

    /* loaded from: classes4.dex */
    public static abstract class Metrics {
    }
}
