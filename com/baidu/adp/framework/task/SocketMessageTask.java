package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public class SocketMessageTask extends MessageTask {

    /* renamed from: a  reason: collision with root package name */
    public boolean f2133a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f2134b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f2135c;

    /* renamed from: d  reason: collision with root package name */
    public Class<? extends SocketResponsedMessage> f2136d;

    /* renamed from: e  reason: collision with root package name */
    public DupLicateMode f2137e;

    /* loaded from: classes.dex */
    public enum DupLicateMode {
        NONE,
        REMOVE_ME,
        REMOVE_WAITING,
        REMOVE_ALL
    }

    public SocketMessageTask(int i2) {
        super(i2);
        this.f2133a = false;
        this.f2134b = false;
        this.f2135c = true;
        this.f2137e = DupLicateMode.NONE;
    }

    public DupLicateMode a() {
        return this.f2137e;
    }

    public boolean b() {
        return this.f2133a;
    }

    public boolean c() {
        return this.f2134b;
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.c(this.mCmd);
    }

    public boolean d() {
        return this.f2135c;
    }

    public void e(boolean z) {
        this.f2135c = z;
    }

    public void f(DupLicateMode dupLicateMode) {
        this.f2137e = dupLicateMode;
    }

    public void g(boolean z) {
        this.f2133a = z;
    }

    public Class<? extends SocketResponsedMessage> getResponsedClass() {
        return this.f2136d;
    }

    public void h(boolean z) {
        this.f2134b = z;
    }

    public void setResponsedClass(Class<? extends SocketResponsedMessage> cls) {
        this.f2136d = cls;
    }
}
