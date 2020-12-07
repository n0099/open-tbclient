package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class ad {
    private static ArrayList<a> mStatisticsDatas = new ArrayList<>();
    public static AtomicInteger mErrorNums = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public int mMethod;
        public int mMode;
        public long mSize;
        public long mTime;
        public int mTimesNum;
    }

    public static int getErrorNumsAndSet(int i) {
        return mErrorNums.getAndSet(i);
    }

    public static int addErrorNumsAndGet(int i) {
        return mErrorNums.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (ad.class) {
            if (aVar != null) {
                if (mStatisticsDatas.size() <= 20) {
                    mStatisticsDatas.add(aVar);
                }
            }
        }
    }

    public static synchronized a btA() {
        a remove;
        synchronized (ad.class) {
            int size = mStatisticsDatas.size();
            remove = size > 0 ? mStatisticsDatas.remove(size - 1) : null;
        }
        return remove;
    }
}
