package com.baidu.searchbox.retrieve.timer;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class FetchTimerList {
    public final List<String> mJobList = new ArrayList();

    /* loaded from: classes4.dex */
    public static class Inner {
        public static final FetchTimerList INSTANCE = new FetchTimerList();
    }

    public static FetchTimerList getInstance() {
        return Inner.INSTANCE;
    }

    public synchronized void addJob(String str) {
        this.mJobList.add(str);
    }

    public boolean hasJob(String str) {
        return this.mJobList.contains(str);
    }

    public synchronized void removeJob(String str) {
        this.mJobList.remove(str);
    }
}
