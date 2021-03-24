package com.baidu.searchbox.bddownload.core;
/* loaded from: classes2.dex */
public abstract class NamedRunnable implements Runnable {
    public final String name;

    public NamedRunnable(String str) {
        this.name = str;
    }

    public abstract void execute() throws InterruptedException;

    public abstract void finished();

    public abstract void interrupted(InterruptedException interruptedException);

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.name);
        try {
            try {
                execute();
            } catch (InterruptedException e2) {
                interrupted(e2);
            }
        } finally {
            Thread.currentThread().setName(name);
            finished();
        }
    }
}
