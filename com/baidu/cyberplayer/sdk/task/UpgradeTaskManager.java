package com.baidu.cyberplayer.sdk.task;

import android.os.Handler;
import android.os.Looper;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberTaskExcutor;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.Utils;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
@Keep
/* loaded from: classes3.dex */
public class UpgradeTaskManager {
    public static final int DEFAULT_MAX_RETRY_NUM = 3;
    public static final int DEFAULT_RETRY_STEP = 5000;
    public static final String TAG = "UpgradeTaskManager";
    public static volatile UpgradeTaskManager sInstance;
    public ConcurrentSkipListSet<String> mTaskSet = new ConcurrentSkipListSet<>();
    public ConcurrentHashMap<String, Integer> mErrorTaskMap = new ConcurrentHashMap<>();
    public Handler mMainHandler = new Handler(Looper.getMainLooper());

    public static UpgradeTaskManager getInstance() {
        if (sInstance == null) {
            synchronized (UpgradeTaskManager.class) {
                if (sInstance == null) {
                    sInstance = new UpgradeTaskManager();
                }
            }
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getDelayTime(String str) {
        long intValue;
        int cfgIntValue = CyberCfgManager.getInstance().getCfgIntValue("upgrade_max_retry_num", 3);
        int cfgIntValue2 = CyberCfgManager.getInstance().getCfgIntValue("upgrade_retry_step", 5000);
        if (!Utils.isNetWorkCanUse()) {
            return cfgIntValue2;
        }
        Integer num = this.mErrorTaskMap.get(str);
        if (num == null) {
            num = 0;
        }
        ConcurrentHashMap<String, Integer> concurrentHashMap = this.mErrorTaskMap;
        Integer valueOf = Integer.valueOf(num.intValue() + 1);
        concurrentHashMap.put(str, valueOf);
        if (valueOf.intValue() > cfgIntValue) {
            intValue = -1;
        } else {
            intValue = valueOf.intValue() * cfgIntValue2;
        }
        CyberLog.d(TAG, str + " retry num:" + valueOf + " delay:" + intValue);
        return intValue;
    }

    public synchronized boolean submitTask(final Task task) {
        if (task == null) {
            CyberLog.e(TAG, "task is null");
            return false;
        }
        final String name = task.getName();
        if (this.mTaskSet.contains(name)) {
            CyberLog.d(TAG, "duplicate task:" + name);
            return false;
        }
        CyberLog.d(TAG, "submitTask:" + name);
        CyberTaskExcutor.getInstance().executeSingleThread(new Runnable() { // from class: com.baidu.cyberplayer.sdk.task.UpgradeTaskManager.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    task.run();
                    UpgradeTaskManager.this.mErrorTaskMap.remove(name);
                    UpgradeTaskManager.this.mTaskSet.remove(name);
                } catch (Exception e) {
                    CyberLog.d(UpgradeTaskManager.TAG, "task exception:" + e);
                    long delayTime = UpgradeTaskManager.this.getDelayTime(name);
                    UpgradeTaskManager.this.mTaskSet.remove(name);
                    if (delayTime > 0) {
                        UpgradeTaskManager.this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.cyberplayer.sdk.task.UpgradeTaskManager.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                UpgradeTaskManager.this.submitTask(task);
                            }
                        }, delayTime);
                    }
                }
            }
        });
        this.mTaskSet.add(name);
        CyberLog.d(TAG, "task num:" + this.mTaskSet.size());
        Iterator<String> it = this.mTaskSet.iterator();
        while (it.hasNext()) {
            CyberLog.d(TAG, "    " + it.next());
        }
        return true;
    }
}
