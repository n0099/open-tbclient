package com.baidu.searchbox.bddownload.core;
/* loaded from: classes2.dex */
public abstract class NamedRunnable implements Runnable {
    public final String name;

    public abstract void execute() throws InterruptedException;

    public abstract void finished();

    public abstract void interrupted(InterruptedException interruptedException);

    public NamedRunnable(String str) {
        this.name = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.name);
        try {
            try {
                execute();
            } catch (InterruptedException e) {
                interrupted(e);
            }
        } finally {
            Thread.currentThread().setName(name);
            finished();
        }
    }
}
