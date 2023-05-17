package com.baidu.searchbox.dns.transmit.task;
/* loaded from: classes3.dex */
public abstract class PriorityAsyncTask extends AsyncTask implements Comparable<PriorityAsyncTask> {
    public static final int DEFAULT_PRIORITY = 0;
    public int mPriority;

    public PriorityAsyncTask() {
        this(PriorityDispatcherHolder.getDispatcher());
    }

    public PriorityAsyncTask(int i) {
        this(PriorityDispatcherHolder.getDispatcher(), i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(PriorityAsyncTask priorityAsyncTask) {
        if (equals(priorityAsyncTask)) {
            return 0;
        }
        if (priorityAsyncTask == null) {
            return -1;
        }
        int i = this.mPriority;
        int i2 = priorityAsyncTask.mPriority;
        if (i == i2) {
            return 0;
        }
        if (i > i2) {
            return -1;
        }
        return 1;
    }

    public PriorityAsyncTask(int i, String str) {
        this(PriorityDispatcherHolder.getDispatcher(), i, str);
    }

    public PriorityAsyncTask(Dispatcher dispatcher) {
        super(dispatcher);
        this.mPriority = 0;
    }

    public PriorityAsyncTask(Dispatcher dispatcher, int i) {
        super(dispatcher);
        this.mPriority = i;
    }

    public PriorityAsyncTask(Dispatcher dispatcher, int i, String str) {
        super(dispatcher, str);
        this.mPriority = i;
    }

    public PriorityAsyncTask(Dispatcher dispatcher, String str) {
        super(dispatcher, str);
        this.mPriority = 0;
    }

    public PriorityAsyncTask(String str) {
        this(PriorityDispatcherHolder.getDispatcher(), str);
    }
}
