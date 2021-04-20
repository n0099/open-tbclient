package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public class SocketMessageTask extends MessageTask {

    /* renamed from: a  reason: collision with root package name */
    public boolean f2164a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f2165b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f2166c;

    /* renamed from: d  reason: collision with root package name */
    public Class<? extends SocketResponsedMessage> f2167d;

    /* renamed from: e  reason: collision with root package name */
    public DupLicateMode f2168e;

    /* loaded from: classes.dex */
    public enum DupLicateMode {
        NONE,
        REMOVE_ME,
        REMOVE_WAITING,
        REMOVE_ALL
    }

    public SocketMessageTask(int i) {
        super(i);
        this.f2164a = false;
        this.f2165b = false;
        this.f2166c = true;
        this.f2168e = DupLicateMode.NONE;
    }

    public DupLicateMode a() {
        return this.f2168e;
    }

    public boolean b() {
        return this.f2164a;
    }

    public boolean c() {
        return this.f2165b;
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.c(this.mCmd);
    }

    public boolean d() {
        return this.f2166c;
    }

    public void e(boolean z) {
        this.f2166c = z;
    }

    public void f(DupLicateMode dupLicateMode) {
        this.f2168e = dupLicateMode;
    }

    public void g(boolean z) {
        this.f2164a = z;
    }

    public Class<? extends SocketResponsedMessage> getResponsedClass() {
        return this.f2167d;
    }

    public void h(boolean z) {
        this.f2165b = z;
    }

    public void setResponsedClass(Class<? extends SocketResponsedMessage> cls) {
        this.f2167d = cls;
    }
}
