package com.baidu.searchbox.dns.transmit.task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public abstract class Dispatcher {
    public ExecutorService executorService;
    public int maxRequests = 15;
    public int maxRequestsPerType = 1;
    public final Queue<AsyncTask> readyAsyncTasks = getReadyDeque();
    public final Queue<AsyncTask> runningAsyncTasks = getRunningDeque();

    public abstract Queue<AsyncTask> getReadyDeque();

    public abstract Queue<AsyncTask> getRunningDeque();

    public String getTaskThreadName() {
        return "Searchbox Dispatcher #";
    }

    public void cancelAll() {
        cancelAllReadyTasks();
        cancelAllRunningTasks();
    }

    public void cancelAllReadyTasks() {
        cancelTasks(this.readyAsyncTasks);
    }

    public void cancelAllRunningTasks() {
        cancelTasks(this.runningAsyncTasks);
        promoteTasks();
    }

    public synchronized ExecutorService executorService() {
        if (this.executorService == null) {
            this.executorService = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory(getTaskThreadName(), false));
        }
        return this.executorService;
    }

    public synchronized int getMaxRequests() {
        return this.maxRequests;
    }

    public synchronized int getMaxRequestsPerType() {
        return this.maxRequestsPerType;
    }

    public synchronized List<AsyncTask> readyTasks() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (AsyncTask asyncTask : this.readyAsyncTasks) {
            arrayList.add(asyncTask);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public synchronized int readyTasksCount() {
        return this.readyAsyncTasks.size();
    }

    public synchronized List<AsyncTask> runningTasks() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (AsyncTask asyncTask : this.runningAsyncTasks) {
            arrayList.add(asyncTask);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public synchronized int runningTasksCount() {
        return this.runningAsyncTasks.size();
    }

    private synchronized boolean cancelTask(AsyncTask asyncTask, Queue<AsyncTask> queue) {
        if (asyncTask != null && queue != null) {
            if (queue.size() > 0) {
                Iterator<AsyncTask> it = queue.iterator();
                while (it.hasNext()) {
                    if (asyncTask.tag().equals(it.next().tag())) {
                        asyncTask.onCancel();
                        it.remove();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private synchronized void cancelTasks(Queue<AsyncTask> queue) {
        if (queue != null) {
            if (queue.size() > 0) {
                Iterator<AsyncTask> it = queue.iterator();
                while (it.hasNext()) {
                    it.next().onCancel();
                    it.remove();
                }
            }
        }
    }

    private int runningTasksForType(AsyncTask asyncTask) {
        int i = 0;
        for (AsyncTask asyncTask2 : this.runningAsyncTasks) {
            if (asyncTask2.getTaskType().equals(asyncTask.getTaskType())) {
                i++;
            }
        }
        return i;
    }

    public boolean cancelTask(AsyncTask asyncTask) {
        boolean z;
        if (!cancelTask(asyncTask, this.readyAsyncTasks) && !cancelTask(asyncTask, this.runningAsyncTasks)) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            promoteTasks();
        }
        return z;
    }

    public synchronized void enqueue(AsyncTask asyncTask) {
        if (this.runningAsyncTasks.size() < this.maxRequests && runningTasksForType(asyncTask) < this.maxRequestsPerType) {
            this.runningAsyncTasks.add(asyncTask);
            executorService().execute(asyncTask);
        } else {
            this.readyAsyncTasks.add(asyncTask);
        }
    }

    public synchronized void finished(AsyncTask asyncTask) {
        this.runningAsyncTasks.remove(asyncTask);
        promoteTasks();
    }

    public synchronized void setMaxRequests(int i) {
        if (i >= 1) {
            this.maxRequests = i;
            promoteTasks();
        } else {
            throw new IllegalArgumentException("max < 1: " + i);
        }
    }

    public synchronized void setMaxRequestsPerType(int i) {
        if (i >= 1) {
            this.maxRequestsPerType = i;
            promoteTasks();
        } else {
            throw new IllegalArgumentException("max < 1: " + i);
        }
    }

    private synchronized void promoteTasks() {
        if (this.runningAsyncTasks.size() >= this.maxRequests) {
            return;
        }
        if (this.readyAsyncTasks.isEmpty()) {
            return;
        }
        Iterator<AsyncTask> it = this.readyAsyncTasks.iterator();
        while (it.hasNext()) {
            AsyncTask next = it.next();
            if (runningTasksForType(next) < this.maxRequestsPerType) {
                it.remove();
                this.runningAsyncTasks.add(next);
                executorService().execute(next);
            }
            if (this.runningAsyncTasks.size() >= this.maxRequests) {
                return;
            }
        }
    }

    private ThreadFactory threadFactory(final String str, final boolean z) {
        return new ThreadFactory() { // from class: com.baidu.searchbox.dns.transmit.task.Dispatcher.1
            public final AtomicInteger mCount = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, str + this.mCount.getAndIncrement());
                thread.setDaemon(z);
                return thread;
            }
        };
    }
}
