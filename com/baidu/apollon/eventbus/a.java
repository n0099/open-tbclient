package com.baidu.apollon.eventbus;

import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.taskmanager.TaskManager;
/* loaded from: classes.dex */
public class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final e f3595a = new e();

    /* renamed from: b  reason: collision with root package name */
    public final b f3596b;

    public a(b bVar) {
        this.f3596b = bVar;
    }

    public void a(g gVar, EventBus.Event event) {
        this.f3595a.a(d.a(gVar, event));
        TaskManager taskManager = TaskManager.getInstance("EBTaskManager");
        taskManager.getClass();
        taskManager.a(new TaskManager.c(0L, 0L, false, "AsyncPost_" + System.currentTimeMillis(), this), "AsyncPost");
    }

    @Override // java.lang.Runnable
    public void run() {
        d a2 = this.f3595a.a();
        if (a2 != null) {
            this.f3596b.a(a2);
            return;
        }
        throw new IllegalStateException("No pending post available");
    }
}
