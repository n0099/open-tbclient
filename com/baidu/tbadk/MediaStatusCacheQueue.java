package com.baidu.tbadk;

import android.util.SparseArray;
import com.baidu.tbadk.core.util.ao;
/* loaded from: classes.dex */
public class MediaStatusCacheQueue {
    private SparseArray<String> mQueue;

    private MediaStatusCacheQueue() {
        this.mQueue = new SparseArray<>();
    }

    public static MediaStatusCacheQueue getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public void insertData(int i, String str) {
        if (!ao.isEmpty(str)) {
            String str2 = this.mQueue.get(i);
            if (str2 != null) {
                str = str2 + str;
            }
            this.mQueue.put(i, str);
        }
    }

    public void removeData(int i) {
        this.mQueue.remove(i);
    }

    public String toString() {
        StringBuilder append = new StringBuilder("Current Players : \n").append("count :").append(this.mQueue.size()).append("\n");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mQueue.size()) {
                append.append(this.mQueue.valueAt(i2));
                append.append("\n");
                i = i2 + 1;
            } else {
                return append.toString();
            }
        }
    }

    /* loaded from: classes.dex */
    private static final class InstanceHolder {
        static final MediaStatusCacheQueue INSTANCE = new MediaStatusCacheQueue();

        private InstanceHolder() {
        }
    }
}
