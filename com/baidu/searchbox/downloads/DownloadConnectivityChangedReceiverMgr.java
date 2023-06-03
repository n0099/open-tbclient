package com.baidu.searchbox.downloads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.android.common.logging.Log;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.ui.animview.praise.NetworkMonitor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public final class DownloadConnectivityChangedReceiverMgr {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final int KEY_STEP = 1;
    public static final String TAG = "DownloadConnectivityChangedReceiverMgr";
    @SuppressLint({"StaticFieldLeak"})
    public static DownloadConnectivityChangedReceiverMgr mInstance;
    public DownloadConnectivityChangedReceiver mReceiver = null;
    public Boolean mIsRegisted = Boolean.FALSE;
    public Context mContext = AppRuntime.getAppContext();
    public Map<String, Integer> mListenersMap = new ConcurrentHashMap();

    public static DownloadConnectivityChangedReceiverMgr getInstance() {
        if (mInstance == null) {
            mInstance = new DownloadConnectivityChangedReceiverMgr();
        }
        return mInstance;
    }

    private void unregisterDownloadConnectivityChangedReceiver() {
        DownloadConnectivityChangedReceiver downloadConnectivityChangedReceiver;
        if (DEBUG) {
            Log.v(TAG, "unregisterDownloadConnectivityChangedReceiver START");
        }
        if (this.mIsRegisted.booleanValue() && (downloadConnectivityChangedReceiver = this.mReceiver) != null) {
            this.mContext.unregisterReceiver(downloadConnectivityChangedReceiver);
            this.mReceiver = null;
            this.mIsRegisted = Boolean.FALSE;
            if (DEBUG) {
                Log.v(TAG, "unregisterDownloadConnectivityChangedReceiver SUCCESS");
            }
        }
    }

    private void addKey(String str) {
        if (this.mListenersMap == null && DEBUG) {
            Log.e(TAG, "DownloadConnectivityChangedReceiverMgr didn't initialized");
        }
        if (str != null) {
            if (TextUtils.isEmpty(str) && DEBUG) {
                Log.w(TAG, "attention: empty string has been used as input of method addKey()");
            }
            if (this.mListenersMap.containsKey(str)) {
                this.mListenersMap.put(str, Integer.valueOf(this.mListenersMap.get(str).intValue() + 1));
                return;
            }
            this.mListenersMap.put(str, 1);
        }
    }

    private void decreaseKey(String str) {
        if (this.mListenersMap == null && DEBUG) {
            Log.e(TAG, "DownloadConnectivityChangedReceiverMgr didn't initialized");
        }
        if (str != null) {
            if (TextUtils.isEmpty(str) && DEBUG) {
                Log.w(TAG, "attention: empty string has been used as input of method stopKey()");
            }
            if (this.mListenersMap.containsKey(str)) {
                int intValue = this.mListenersMap.get(str).intValue();
                if (intValue < 2) {
                    this.mListenersMap.remove(str);
                } else {
                    this.mListenersMap.put(str, Integer.valueOf(intValue - 1));
                }
            }
        }
    }

    private void registerDownloadConnectivityChangedReceiver() {
        if (DEBUG) {
            Log.v(TAG, "registerDownloadConnectivityChangedReceiver START");
        }
        if (!this.mIsRegisted.booleanValue()) {
            if (this.mReceiver == null) {
                this.mReceiver = new DownloadConnectivityChangedReceiver();
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(NetworkMonitor.NET_CHANGE_ACTION);
            this.mContext.registerReceiver(this.mReceiver, intentFilter);
            this.mIsRegisted = Boolean.TRUE;
            if (DEBUG) {
                Log.v(TAG, "registerDownloadConnectivityChangedReceiver SUCCESS");
            }
        }
    }

    public Boolean hasKeyListened(String str) {
        Map<String, Integer> map = this.mListenersMap;
        if (map == null) {
            if (DEBUG) {
                Log.e(TAG, "DownloadConnectivityChangedReceiverMgr didn't initialized");
            }
            return Boolean.FALSE;
        } else if (str != null && map.containsKey(str)) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    @DebugTrace
    public void startListen(String str) {
        addKey(str);
        if (!this.mIsRegisted.booleanValue() && !this.mListenersMap.isEmpty()) {
            registerDownloadConnectivityChangedReceiver();
        }
    }

    public void stopListen(String str) {
        decreaseKey(str);
        if (this.mIsRegisted.booleanValue() && this.mListenersMap.isEmpty()) {
            unregisterDownloadConnectivityChangedReceiver();
        }
    }
}
