package com.baidu.searchbox.dns.transmit.task;

import android.os.Process;
/* loaded from: classes3.dex */
public abstract class AsyncTask implements Runnable {
    public final String mName;
    public final Dispatcher mTaskDispatcher;

    public abstract String getTaskType();

    public abstract void onCancel();

    public abstract void onExecute();

    public Object tag() {
        return this;
    }

    public AsyncTask() {
        this.mName = "searchbox task: " + getTaskType();
        this.mTaskDispatcher = SimpleDispatcherHolder.getDispatcher();
    }

    public void cancel() {
        Dispatcher dispatcher = this.mTaskDispatcher;
        if (dispatcher != null) {
            dispatcher.cancelTask(this);
        }
    }

    public Dispatcher getTaskDispatcher() {
        return this.mTaskDispatcher;
    }

    @Override // java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.mName);
        try {
            onExecute();
            this.mTaskDispatcher.finished(this);
        } finally {
            Thread.currentThread().setName(name);
        }
    }

    public void start() {
        Dispatcher dispatcher = this.mTaskDispatcher;
        if (dispatcher != null) {
            dispatcher.enqueue(this);
        }
    }

    public AsyncTask(Dispatcher dispatcher) {
        this.mName = "searchbox task: " + getTaskType();
        this.mTaskDispatcher = dispatcher;
    }

    public AsyncTask(Dispatcher dispatcher, String str) {
        this.mName = str;
        this.mTaskDispatcher = dispatcher;
    }

    public AsyncTask(String str) {
        this.mName = str;
        this.mTaskDispatcher = SimpleDispatcherHolder.getDispatcher();
    }
}
