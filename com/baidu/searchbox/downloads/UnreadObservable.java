package com.baidu.searchbox.downloads;

import android.content.Context;
import android.preference.PreferenceManager;
import com.baidu.android.common.DataObservable;
import com.baidu.android.common.IDataObservable;
import com.baidu.android.common.IHomeTabNews;
import com.baidu.android.common.logging.Log;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.downloads.manage.SearchBoxDownloadManager;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.tbadk.core.data.SmallTailInfo;
/* loaded from: classes3.dex */
public class UnreadObservable implements IDataObservable, IHomeTabNews {
    public static final String KEY_READ = "key_read_unreadobservable";
    public Context mContext;
    public DataObservable mObservable;
    public int mUnreadCount = 0;

    /* loaded from: classes3.dex */
    public interface Callback {
        void callback(int i);
    }

    /* renamed from: com.baidu.searchbox.downloads.UnreadObservable$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 extends DataObservable {
        public AnonymousClass1() {
        }

        @Override // com.baidu.android.common.DataObservable, java.util.Observable
        public void notifyObservers(final Object obj) {
            UnreadObservable.this.queryUnreadCount(new Callback() { // from class: com.baidu.searchbox.downloads.UnreadObservable.1.1
                @Override // com.baidu.searchbox.downloads.UnreadObservable.Callback
                public void callback(int i) {
                    if (i > UnreadObservable.this.mUnreadCount) {
                        UnreadObservable unreadObservable = UnreadObservable.this;
                        unreadObservable.setHasRead(unreadObservable.mContext, false);
                    } else {
                        UnreadObservable unreadObservable2 = UnreadObservable.this;
                        unreadObservable2.setHasRead(unreadObservable2.mContext, true);
                    }
                    if (i != UnreadObservable.this.mUnreadCount) {
                        UnreadObservable.this.mUnreadCount = i;
                        AnonymousClass1.this.setChanged();
                        if (AnonymousClass1.this.countObservers() > 0) {
                            AnonymousClass1.this.notifyObserversSuper(obj);
                        }
                    }
                }
            });
        }

        public void notifyObserversSuper(Object obj) {
            super.notifyObservers(obj);
        }
    }

    public UnreadObservable(Context context) {
        this.mContext = context.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void queryUnreadCount(final Callback callback) {
        ExecutorUtilsExt.postOnSerial(new Runnable() { // from class: com.baidu.searchbox.downloads.UnreadObservable.3
            @Override // java.lang.Runnable
            public void run() {
                final int newTotalCount = SearchBoxDownloadManager.getInstance(AppRuntime.getAppContext()).getNewTotalCount();
                UiThreadUtils.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.downloads.UnreadObservable.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Callback callback2 = callback;
                        if (callback2 != null) {
                            callback2.callback(newTotalCount);
                        }
                    }
                });
            }
        }, "queryUnreadCount");
    }

    @Override // com.baidu.android.common.IHomeTabNews
    public boolean hasRead(Context context) {
        boolean z = PreferenceManager.getDefaultSharedPreferences(context).getBoolean(KEY_READ, true);
        if (AppConfig.isDebug()) {
            Log.w(IDataObservable.TAG, "UnreadObservable.hasRead()=" + z);
        }
        return z;
    }

    @Override // com.baidu.android.common.IDataObservable
    public DataObservable getDataObservable() {
        if (this.mObservable == null) {
            synchronized (DownloadingObservable.class) {
                if (this.mObservable == null) {
                    this.mObservable = new AnonymousClass1();
                    queryUnreadCount(new Callback() { // from class: com.baidu.searchbox.downloads.UnreadObservable.2
                        @Override // com.baidu.searchbox.downloads.UnreadObservable.Callback
                        public void callback(int i) {
                            UnreadObservable.this.mUnreadCount = i;
                        }
                    });
                }
            }
        }
        return this.mObservable;
    }

    @Override // com.baidu.android.common.IDataObservable
    public int queryUpdatesCount() {
        if (AppConfig.isDebug()) {
            Log.d("DownloadManager", "UnreadObserverale.queryUpdatesCount(): mUnreadCount==" + this.mUnreadCount);
        }
        return this.mUnreadCount;
    }

    public void release() {
        DataObservable dataObservable = this.mObservable;
        if (dataObservable != null) {
            dataObservable.deleteObservers();
            this.mObservable = null;
        }
    }

    @Override // com.baidu.android.common.IDataObservable
    public void retractUpdates() {
        if (AppConfig.isDebug()) {
            Log.d("DownloadManager", "UnreadObservable.retractUpdates(): mUnreadCount==" + this.mUnreadCount + " =(0)");
        }
        this.mUnreadCount = 0;
    }

    @Override // com.baidu.android.common.IHomeTabNews
    public void setHasRead(Context context, boolean z) {
        if (AppConfig.isDebug()) {
            Log.w("DownloadManager", "UnreadObservable.setHasRead(" + z + SmallTailInfo.EMOTION_SUFFIX);
        }
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean(KEY_READ, z).apply();
    }
}
