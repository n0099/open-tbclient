package com.baidu.apollon.eventbus;

import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.taskmanager.TaskManager;
/* loaded from: classes2.dex */
public class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final e f3594a = new e();

    /* renamed from: b  reason: collision with root package name */
    public final b f3595b;

    public a(b bVar) {
        this.f3595b = bVar;
    }

    public void a(g gVar, EventBus.Event event) {
        this.f3594a.a(d.a(gVar, event));
        TaskManager taskManager = TaskManager.getInstance("EBTaskManager");
        taskManager.getClass();
        taskManager.a(new TaskManager.c(0L, 0L, false, "AsyncPost_" + System.currentTimeMillis(), this), "AsyncPost");
    }

    @Override // java.lang.Runnable
    public void run() {
        d a2 = this.f3594a.a();
        if (a2 != null) {
            this.f3595b.a(a2);
            return;
        }
        throw new IllegalStateException("No pending post available");
    }
}
