package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public class SocketMessageTask extends MessageTask {

    /* renamed from: a  reason: collision with root package name */
    public boolean f2129a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f2130b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f2131c;

    /* renamed from: d  reason: collision with root package name */
    public Class<? extends SocketResponsedMessage> f2132d;

    /* renamed from: e  reason: collision with root package name */
    public DupLicateMode f2133e;

    /* loaded from: classes.dex */
    public enum DupLicateMode {
        NONE,
        REMOVE_ME,
        REMOVE_WAITING,
        REMOVE_ALL
    }

    public SocketMessageTask(int i) {
        super(i);
        this.f2129a = false;
        this.f2130b = false;
        this.f2131c = true;
        this.f2133e = DupLicateMode.NONE;
    }

    public DupLicateMode a() {
        return this.f2133e;
    }

    public boolean b() {
        return this.f2129a;
    }

    public boolean c() {
        return this.f2130b;
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.c(this.mCmd);
    }

    public boolean d() {
        return this.f2131c;
    }

    public void e(boolean z) {
        this.f2131c = z;
    }

    public void f(DupLicateMode dupLicateMode) {
        this.f2133e = dupLicateMode;
    }

    public void g(boolean z) {
        this.f2129a = z;
    }

    public Class<? extends SocketResponsedMessage> getResponsedClass() {
        return this.f2132d;
    }

    public void h(boolean z) {
        this.f2130b = z;
    }

    public void setResponsedClass(Class<? extends SocketResponsedMessage> cls) {
        this.f2132d = cls;
    }
}
