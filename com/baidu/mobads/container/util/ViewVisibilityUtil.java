package com.baidu.mobads.container.util;

import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class ViewVisibilityUtil implements Handler.Callback {
    public static final int INTERVAL_MILLIS = 500;
    public static final int MSG_CHECK_VIEW_STATE = 1;
    public static final int PERCENT_VISIBLE = 50;
    public static final int STATE_INVISIBLE = 0;
    public static final int STATE_REMOVED = -1;
    public static final int STATE_VISIBLE = 1;
    public static HandlerThread mHandlerThread = new HandlerThread("mobads-msg-thread");
    public static ViewVisibilityUtil mInstance;
    public Handler mUiHandler;
    public Handler mVisibleMonitor;
    public ConcurrentHashMap<WeakReference<View>, WeakReference<OnViewVisibleChangedListener>> mTotalViewHashMap = new ConcurrentHashMap<>();
    public ConcurrentHashMap<WeakReference<View>, Integer> mViewStateHashMap = new ConcurrentHashMap<>();

    /* loaded from: classes2.dex */
    public interface OnViewVisibleChangedListener {
        void onViewVisibleChange(boolean z);
    }

    private void checkViewState() {
        Iterator<Map.Entry<WeakReference<View>, WeakReference<OnViewVisibleChangedListener>>> it = this.mTotalViewHashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<WeakReference<View>, WeakReference<OnViewVisibleChangedListener>> next = it.next();
            WeakReference<View> key = next.getKey();
            Integer num = this.mViewStateHashMap.get(key);
            View view = key.get();
            if (view != null && num != null && num.intValue() != -1) {
                OnViewVisibleChangedListener onViewVisibleChangedListener = next.getValue().get();
                if (onViewVisibleChangedListener != null) {
                    if (isVisible(view)) {
                        Integer put = this.mViewStateHashMap.put(key, 1);
                        if (put == null) {
                            RemoteXAdLogger.getInstance().i("View init state gets lost.");
                        } else if (put.intValue() == 0) {
                            postListenerOnUiThread(onViewVisibleChangedListener, true);
                        }
                    } else {
                        Integer put2 = this.mViewStateHashMap.put(key, 0);
                        if (put2 == null) {
                            RemoteXAdLogger.getInstance().i("View init state gets lost.");
                        } else if (put2.intValue() == 1) {
                            postListenerOnUiThread(onViewVisibleChangedListener, false);
                        }
                    }
                }
            } else {
                it.remove();
                this.mViewStateHashMap.remove(key);
            }
        }
        if (this.mTotalViewHashMap.size() > 0) {
            this.mVisibleMonitor.sendEmptyMessageDelayed(1, 500L);
        }
    }

    public static ViewVisibilityUtil getInstance() {
        if (mInstance == null) {
            synchronized (ViewVisibilityUtil.class) {
                if (mInstance == null) {
                    ViewVisibilityUtil viewVisibilityUtil = new ViewVisibilityUtil();
                    mInstance = viewVisibilityUtil;
                    viewVisibilityUtil.initMonitor();
                }
            }
        }
        return mInstance;
    }

    private void initMonitor() {
        if (this.mVisibleMonitor == null) {
            if (!mHandlerThread.isAlive()) {
                mHandlerThread.start();
            }
            this.mVisibleMonitor = new Handler(mHandlerThread.getLooper(), this);
        }
        if (this.mUiHandler == null) {
            this.mUiHandler = new Handler(Looper.getMainLooper());
        }
    }

    public static boolean isVisible(View view) {
        if (view == null || !view.isShown()) {
            return false;
        }
        Rect rect = new Rect();
        if (view.getGlobalVisibleRect(rect)) {
            long height = rect.height() * rect.width();
            long height2 = view.getHeight() * view.getWidth();
            return height2 > 0 && height * 100 >= height2 * 50;
        }
        return false;
    }

    private void postListenerOnUiThread(final OnViewVisibleChangedListener onViewVisibleChangedListener, final boolean z) {
        if (onViewVisibleChangedListener != null) {
            this.mUiHandler.post(new Runnable() { // from class: com.baidu.mobads.container.util.ViewVisibilityUtil.1
                @Override // java.lang.Runnable
                public void run() {
                    onViewVisibleChangedListener.onViewVisibleChange(z);
                }
            });
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            mInstance.checkViewState();
            return false;
        }
        return false;
    }

    public void registerView(View view, OnViewVisibleChangedListener onViewVisibleChangedListener) {
        if (view == null || onViewVisibleChangedListener == null) {
            return;
        }
        if (this.mVisibleMonitor.hasMessages(1)) {
            this.mVisibleMonitor.removeMessages(1);
        }
        WeakReference<View> weakReference = new WeakReference<>(view);
        this.mTotalViewHashMap.put(weakReference, new WeakReference<>(onViewVisibleChangedListener));
        this.mViewStateHashMap.put(weakReference, 0);
        this.mVisibleMonitor.sendEmptyMessage(1);
    }

    public void release() {
        this.mTotalViewHashMap.clear();
        this.mViewStateHashMap.clear();
    }

    public void unregisterView(View view) {
        if (view != null) {
            if (this.mVisibleMonitor.hasMessages(1)) {
                this.mVisibleMonitor.removeMessages(1);
            }
            for (Map.Entry<WeakReference<View>, Integer> entry : this.mViewStateHashMap.entrySet()) {
                WeakReference<View> key = entry.getKey();
                if (key.get() == view) {
                    this.mViewStateHashMap.put(key, -1);
                }
            }
            this.mVisibleMonitor.sendEmptyMessage(1);
        }
    }
}
