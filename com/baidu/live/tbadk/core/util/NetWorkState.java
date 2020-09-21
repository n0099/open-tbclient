package com.baidu.live.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes4.dex */
public class NetWorkState {
    private static ArrayList<StatisticsData> mStatisticsDatas = new ArrayList<>();
    public static AtomicInteger mErrorNums = new AtomicInteger(0);

    /* loaded from: classes4.dex */
    public static class StatisticsData {
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

    public static synchronized void addStatisticsData(StatisticsData statisticsData) {
        synchronized (NetWorkState.class) {
            if (statisticsData != null) {
                if (mStatisticsDatas.size() <= 20) {
                    mStatisticsDatas.add(statisticsData);
                }
            }
        }
    }

    public static synchronized StatisticsData delStatisticsData() {
        StatisticsData remove;
        synchronized (NetWorkState.class) {
            int size = mStatisticsDatas.size();
            remove = size > 0 ? mStatisticsDatas.remove(size - 1) : null;
        }
        return remove;
    }
}
