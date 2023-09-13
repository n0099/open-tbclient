package androidx.asynclayoutinflater.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.core.util.Pools;
import java.util.concurrent.ArrayBlockingQueue;
/* loaded from: classes.dex */
public final class AsyncLayoutInflater {
    public static final String TAG = "AsyncLayoutInflater";
    public LayoutInflater mInflater;
    public Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: androidx.asynclayoutinflater.view.AsyncLayoutInflater.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InflateRequest inflateRequest = (InflateRequest) message.obj;
            if (inflateRequest.f1026view == null) {
                inflateRequest.f1026view = AsyncLayoutInflater.this.mInflater.inflate(inflateRequest.resid, inflateRequest.parent, false);
            }
            inflateRequest.callback.onInflateFinished(inflateRequest.f1026view, inflateRequest.resid, inflateRequest.parent);
            AsyncLayoutInflater.this.mInflateThread.releaseRequest(inflateRequest);
            return true;
        }
    };
    public Handler mHandler = new Handler(this.mHandlerCallback);
    public InflateThread mInflateThread = InflateThread.getInstance();

    /* loaded from: classes.dex */
    public static class InflateRequest {
        public OnInflateFinishedListener callback;
        public AsyncLayoutInflater inflater;
        public ViewGroup parent;
        public int resid;

        /* renamed from: view  reason: collision with root package name */
        public View f1026view;
    }

    /* loaded from: classes.dex */
    public interface OnInflateFinishedListener {
        void onInflateFinished(@NonNull View view2, @LayoutRes int i, @Nullable ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class InflateThread extends Thread {
        public static final InflateThread sInstance;
        public ArrayBlockingQueue<InflateRequest> mQueue = new ArrayBlockingQueue<>(10);
        public Pools.SynchronizedPool<InflateRequest> mRequestPool = new Pools.SynchronizedPool<>(10);

        static {
            InflateThread inflateThread = new InflateThread();
            sInstance = inflateThread;
            inflateThread.start();
        }

        public static InflateThread getInstance() {
            return sInstance;
        }

        public InflateRequest obtainRequest() {
            InflateRequest acquire = this.mRequestPool.acquire();
            if (acquire == null) {
                return new InflateRequest();
            }
            return acquire;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                runInner();
            }
        }

        public void runInner() {
            try {
                InflateRequest take = this.mQueue.take();
                try {
                    take.f1026view = take.inflater.mInflater.inflate(take.resid, take.parent, false);
                } catch (RuntimeException e) {
                    Log.w(AsyncLayoutInflater.TAG, "Failed to inflate resource in the background! Retrying on the UI thread", e);
                }
                Message.obtain(take.inflater.mHandler, 0, take).sendToTarget();
            } catch (InterruptedException e2) {
                Log.w(AsyncLayoutInflater.TAG, e2);
            }
        }

        public void enqueue(InflateRequest inflateRequest) {
            try {
                this.mQueue.put(inflateRequest);
            } catch (InterruptedException e) {
                throw new RuntimeException("Failed to enqueue async inflate request", e);
            }
        }

        public void releaseRequest(InflateRequest inflateRequest) {
            inflateRequest.callback = null;
            inflateRequest.inflater = null;
            inflateRequest.parent = null;
            inflateRequest.resid = 0;
            inflateRequest.f1026view = null;
            this.mRequestPool.release(inflateRequest);
        }
    }

    public AsyncLayoutInflater(@NonNull Context context) {
        this.mInflater = new BasicInflater(context);
    }

    /* loaded from: classes.dex */
    public static class BasicInflater extends LayoutInflater {
        public static final String[] sClassPrefixList = {"android.widget.", "android.webkit.", "android.app."};

        public BasicInflater(Context context) {
            super(context);
        }

        @Override // android.view.LayoutInflater
        public LayoutInflater cloneInContext(Context context) {
            return new BasicInflater(context);
        }

        @Override // android.view.LayoutInflater
        public View onCreateView(String str, AttributeSet attributeSet) throws ClassNotFoundException {
            View createView;
            for (String str2 : sClassPrefixList) {
                try {
                    createView = createView(str, str2, attributeSet);
                } catch (ClassNotFoundException unused) {
                }
                if (createView != null) {
                    return createView;
                }
            }
            return super.onCreateView(str, attributeSet);
        }
    }

    @UiThread
    public void inflate(@LayoutRes int i, @Nullable ViewGroup viewGroup, @NonNull OnInflateFinishedListener onInflateFinishedListener) {
        if (onInflateFinishedListener != null) {
            InflateRequest obtainRequest = this.mInflateThread.obtainRequest();
            obtainRequest.inflater = this;
            obtainRequest.resid = i;
            obtainRequest.parent = viewGroup;
            obtainRequest.callback = onInflateFinishedListener;
            this.mInflateThread.enqueue(obtainRequest);
            return;
        }
        throw new NullPointerException("callback argument may not be null!");
    }
}
