package com.baidu.cyberplayer.sdk.task;

import android.os.Handler;
import android.os.Looper;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberTaskExcutor;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.q;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
@Keep
/* loaded from: classes3.dex */
public class UpgradeTaskManager {
    public static volatile UpgradeTaskManager a;
    public ConcurrentSkipListSet<String> b = new ConcurrentSkipListSet<>();
    public ConcurrentHashMap<String, Integer> d = new ConcurrentHashMap<>();
    public Handler c = new Handler(Looper.getMainLooper());

    public static UpgradeTaskManager getInstance() {
        if (a == null) {
            synchronized (UpgradeTaskManager.class) {
                if (a == null) {
                    a = new UpgradeTaskManager();
                }
            }
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long a(String str) {
        long intValue;
        int cfgIntValue = CyberCfgManager.getInstance().getCfgIntValue("upgrade_max_retry_num", 3);
        int cfgIntValue2 = CyberCfgManager.getInstance().getCfgIntValue("upgrade_retry_step", 5000);
        if (!q.j()) {
            return cfgIntValue2;
        }
        Integer num = this.d.get(str);
        if (num == null) {
            num = 0;
        }
        ConcurrentHashMap<String, Integer> concurrentHashMap = this.d;
        Integer valueOf = Integer.valueOf(num.intValue() + 1);
        concurrentHashMap.put(str, valueOf);
        if (valueOf.intValue() > cfgIntValue) {
            intValue = -1;
        } else {
            intValue = valueOf.intValue() * cfgIntValue2;
        }
        CyberLog.d("UpgradeTaskManager", str + " retry num:" + valueOf + " delay:" + intValue);
        return intValue;
    }

    public synchronized boolean submitTask(final Task task) {
        if (task == null) {
            CyberLog.e("UpgradeTaskManager", "task is null");
            return false;
        }
        final String name = task.getName();
        if (this.b.contains(name)) {
            CyberLog.d("UpgradeTaskManager", "duplicate task:" + name);
            return false;
        }
        CyberLog.d("UpgradeTaskManager", "submitTask:" + name);
        CyberTaskExcutor.getInstance().executeSingleThread(new Runnable() { // from class: com.baidu.cyberplayer.sdk.task.UpgradeTaskManager.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    task.run();
                    UpgradeTaskManager.this.d.remove(name);
                    UpgradeTaskManager.this.b.remove(name);
                } catch (Exception e) {
                    CyberLog.d("UpgradeTaskManager", "task exception:" + e);
                    long a2 = UpgradeTaskManager.this.a(name);
                    UpgradeTaskManager.this.b.remove(name);
                    if (a2 > 0) {
                        UpgradeTaskManager.this.c.postDelayed(new Runnable() { // from class: com.baidu.cyberplayer.sdk.task.UpgradeTaskManager.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                UpgradeTaskManager.this.submitTask(task);
                            }
                        }, a2);
                    }
                }
            }
        });
        this.b.add(name);
        CyberLog.d("UpgradeTaskManager", "task num:" + this.b.size());
        Iterator<String> it = this.b.iterator();
        while (it.hasNext()) {
            CyberLog.d("UpgradeTaskManager", "    " + it.next());
        }
        return true;
    }
}
