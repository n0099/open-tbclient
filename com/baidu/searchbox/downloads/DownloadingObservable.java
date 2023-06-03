package com.baidu.searchbox.downloads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.baidu.android.common.DataObservable;
import com.baidu.android.common.IDataObservable;
import com.baidu.android.common.IHomeTabNews;
import com.baidu.android.common.logging.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.download.ioc.IDownloadApp;
import com.baidu.searchbox.downloads.manage.SearchBoxDownloadManager;
import com.baidu.tbadk.core.data.SmallTailInfo;
/* loaded from: classes3.dex */
public class DownloadingObservable implements IDataObservable, IHomeTabNews {
    public static final String KEY_READ = "key_read_downloadingobservable";
    public Context mContext;
    public BroadcastReceiver mDownloadFinishReceiver;
    public BroadcastReceiver mDownloadReceiver;
    public int mDownloadingCount = 0;
    public DataObservable mObservable;

    public DownloadingObservable(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        registerDownloadBeginReceiver(applicationContext);
        registerDownloadCompleteReceiver(this.mContext);
    }

    private void registerDownloadBeginReceiver(Context context) {
        this.mDownloadReceiver = new BroadcastReceiver() { // from class: com.baidu.searchbox.downloads.DownloadingObservable.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if (AppConfig.isDebug()) {
                    Log.d("DownloadManager", "DownloadingObservable.DownlaodBeginReceiver(" + intent.toString() + SmallTailInfo.EMOTION_SUFFIX);
                }
                if (TextUtils.equals(intent.getAction(), DownloadConstants.ACTION_DOWNLOAD_BEGIN) && DownloadingObservable.this.mObservable != null) {
                    if (AppConfig.isDebug()) {
                        Log.d("DownloadManager", "DownloadingObservable.startDownloading(): notifyObservers()");
                    }
                    DownloadingObservable.this.mObservable.notifyObservers(intent);
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(DownloadConstants.ACTION_DOWNLOAD_BEGIN);
        context.registerReceiver(this.mDownloadReceiver, intentFilter);
    }

    private void registerDownloadCompleteReceiver(Context context) {
        this.mDownloadFinishReceiver = new BroadcastReceiver() { // from class: com.baidu.searchbox.downloads.DownloadingObservable.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if (AppConfig.isDebug()) {
                    Log.d("DownloadManager", "DownloadingObservable.DownloadCompleteReceiver(" + intent.toString() + SmallTailInfo.EMOTION_SUFFIX);
                }
                if (TextUtils.equals(intent.getAction(), DownloadConstants.ACTION_DOWNLOAD_COMPLETE)) {
                    if (DownloadingObservable.this.mObservable != null) {
                        if (AppConfig.isDebug()) {
                            Log.d("DownloadManager", "DownloadingObservable.finishDownloading(): notifyObservers()");
                        }
                        DownloadingObservable.this.mObservable.notifyObservers(intent);
                    }
                    if (AppConfig.isDebug()) {
                        Log.d("DownloadManager", "DownloadingObservable.finishDownloading()-> notify UnreadObservable's Observers");
                    }
                    IDownloadApp.Impl.get().notifySearchBoxDownloadControlObservers();
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(DownloadConstants.ACTION_DOWNLOAD_COMPLETE);
        context.registerReceiver(this.mDownloadFinishReceiver, intentFilter);
    }

    @Override // com.baidu.android.common.IHomeTabNews
    public boolean hasRead(Context context) {
        boolean z = PreferenceManager.getDefaultSharedPreferences(context).getBoolean(KEY_READ, true);
        if (AppConfig.isDebug()) {
            Log.w(IDataObservable.TAG, "DownloadingObservable.hasRead()=" + z);
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int queryDownloadingCount() {
        long currentTimeMillis = System.currentTimeMillis();
        int unfinishedDownloadCount = SearchBoxDownloadManager.getInstance(AppRuntime.getAppContext()).getUnfinishedDownloadCount();
        long currentTimeMillis2 = System.currentTimeMillis();
        if (AppConfig.isDebug()) {
            Log.d("DownloadManager", "DownloadingObserverale.queryDownloadingCount() cost " + (currentTimeMillis2 - currentTimeMillis) + " ms, count=" + unfinishedDownloadCount);
        }
        return unfinishedDownloadCount;
    }

    @Override // com.baidu.android.common.IDataObservable
    public DataObservable getDataObservable() {
        if (this.mObservable == null) {
            synchronized (DownloadingObservable.class) {
                if (this.mObservable == null) {
                    this.mObservable = new DataObservable() { // from class: com.baidu.searchbox.downloads.DownloadingObservable.3
                        @Override // com.baidu.android.common.DataObservable, java.util.Observable
                        public void notifyObservers(Object obj) {
                            int queryDownloadingCount = DownloadingObservable.this.queryDownloadingCount();
                            if (queryDownloadingCount > DownloadingObservable.this.mDownloadingCount) {
                                DownloadingObservable downloadingObservable = DownloadingObservable.this;
                                downloadingObservable.setHasRead(downloadingObservable.mContext, false);
                            } else {
                                DownloadingObservable downloadingObservable2 = DownloadingObservable.this;
                                downloadingObservable2.setHasRead(downloadingObservable2.mContext, true);
                            }
                            DownloadingObservable.this.mDownloadingCount = queryDownloadingCount;
                            setChanged();
                            if (countObservers() > 0) {
                                super.notifyObservers(obj);
                            }
                        }
                    };
                    this.mDownloadingCount = queryDownloadingCount();
                }
            }
        }
        return this.mObservable;
    }

    @Override // com.baidu.android.common.IDataObservable
    public int queryUpdatesCount() {
        if (AppConfig.isDebug()) {
            Log.d("DownloadManager", "DownloadingObservable.queryUpdatesCount(): mDownloadingCount==" + this.mDownloadingCount);
        }
        return this.mDownloadingCount;
    }

    public void release() {
        BroadcastReceiver broadcastReceiver = this.mDownloadReceiver;
        if (broadcastReceiver != null) {
            this.mContext.unregisterReceiver(broadcastReceiver);
            this.mDownloadReceiver = null;
        }
        BroadcastReceiver broadcastReceiver2 = this.mDownloadFinishReceiver;
        if (broadcastReceiver2 != null) {
            this.mContext.unregisterReceiver(broadcastReceiver2);
            this.mDownloadFinishReceiver = null;
        }
        DataObservable dataObservable = this.mObservable;
        if (dataObservable != null) {
            dataObservable.deleteObservers();
            this.mObservable = null;
        }
    }

    @Override // com.baidu.android.common.IDataObservable
    public void retractUpdates() {
        if (AppConfig.isDebug()) {
            Log.d("DownloadManager", "DownloadingObservable.retractUpdates(): mDownloadingCount==" + this.mDownloadingCount + " =(0)");
        }
        this.mDownloadingCount = 0;
    }

    @Override // com.baidu.android.common.IHomeTabNews
    public void setHasRead(Context context, boolean z) {
        if (AppConfig.isDebug()) {
            Log.w("DownloadManager", "DownloadingObservable.setHasRead(" + z + SmallTailInfo.EMOTION_SUFFIX);
        }
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean(KEY_READ, z).apply();
    }
}
