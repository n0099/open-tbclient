package com.baidu.searchbox.dns.transmit;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.dns.util.DnsUtil;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class DnsTransmitTaskManager {
    public static volatile DnsTransmitTaskManager taskManager;
    public final Object taskLock;
    public HashMap<String, DnsTransmitTask> taskMap;

    /* loaded from: classes3.dex */
    public static class Holder {
        public static DnsTransmitTaskManager INSTANCE = new DnsTransmitTaskManager();
    }

    public DnsTransmitTaskManager() {
        this.taskLock = new Object();
        this.taskMap = new HashMap<>(10);
    }

    public static DnsTransmitTaskManager getInstance() {
        return Holder.INSTANCE;
    }

    public void removeTask(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.taskLock) {
                this.taskMap.remove(str);
            }
            if (DnsUtil.DEBUG) {
                Log.d(DnsUtil.TAG, " remove dns transmit task: " + str);
            }
        }
    }

    public void addTask(String str, DnsTransmitTask dnsTransmitTask) {
        if (!TextUtils.isEmpty(str) && dnsTransmitTask != null) {
            synchronized (this.taskLock) {
                this.taskMap.put(str, dnsTransmitTask);
            }
            if (DnsUtil.DEBUG) {
                Log.d(DnsUtil.TAG, " add dns transmit task: " + str);
            }
        }
    }

    public DnsTransmitTask getTask(String str, boolean z, int i) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.taskLock) {
                if (this.taskMap.get(str) == null) {
                    if (DnsUtil.DEBUG) {
                        Log.d(DnsUtil.TAG, " creat dns transmit task isBatch: " + z + " host: " + str);
                    }
                    return new DnsTransmitTask(z, str, i);
                }
                return null;
            }
        }
        return null;
    }
}
