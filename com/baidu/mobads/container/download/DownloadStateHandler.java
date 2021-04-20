package com.baidu.mobads.container.download;

import android.text.TextUtils;
import com.baidu.mobads.container.components.command.IDownloadStateChangeListener;
import java.lang.ref.WeakReference;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class DownloadStateHandler {
    public static volatile DownloadStateHandler mObserverManager;
    public HashMap<String, WeakReference<IDownloadStateChangeListener>> mDownloadListeners = new HashMap<>();

    public static DownloadStateHandler getInstance() {
        if (mObserverManager == null) {
            synchronized (DownloadStateHandler.class) {
                if (mObserverManager == null) {
                    mObserverManager = new DownloadStateHandler();
                }
            }
        }
        return mObserverManager;
    }

    public void addDownloadListener(String str, IDownloadStateChangeListener iDownloadStateChangeListener) {
        if (TextUtils.isEmpty(str) || iDownloadStateChangeListener == null) {
            return;
        }
        this.mDownloadListeners.put(str, new WeakReference<>(iDownloadStateChangeListener));
    }

    public HashMap<String, WeakReference<IDownloadStateChangeListener>> getDownloadListener() {
        return this.mDownloadListeners;
    }

    public void removeDownloadListener(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mDownloadListeners.remove(str);
    }
}
