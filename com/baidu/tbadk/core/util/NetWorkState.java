package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public class NetWorkState {
    public static ArrayList<StatisticsData> mStatisticsDatas = new ArrayList<>();
    public static AtomicInteger mErrorNums = new AtomicInteger(0);

    /* loaded from: classes3.dex */
    public static class StatisticsData {
        public int mMethod;
        public int mMode;
        public long mSize;
        public long mTime;
        public int mTimesNum;
    }

    public static int addErrorNumsAndGet(int i) {
        return mErrorNums.addAndGet(i);
    }

    public static synchronized void addStatisticsData(StatisticsData statisticsData) {
        synchronized (NetWorkState.class) {
            if (statisticsData == null) {
                return;
            }
            if (mStatisticsDatas.size() > 20) {
                return;
            }
            mStatisticsDatas.add(statisticsData);
        }
    }

    public static synchronized StatisticsData delStatisticsData() {
        synchronized (NetWorkState.class) {
            int size = mStatisticsDatas.size();
            if (size > 0) {
                return mStatisticsDatas.remove(size - 1);
            }
            return null;
        }
    }

    public static int getErrorNumsAndSet(int i) {
        return mErrorNums.getAndSet(i);
    }
}
