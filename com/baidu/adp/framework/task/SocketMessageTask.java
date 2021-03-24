package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public class SocketMessageTask extends MessageTask {

    /* renamed from: a  reason: collision with root package name */
    public boolean f2128a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f2129b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f2130c;

    /* renamed from: d  reason: collision with root package name */
    public Class<? extends SocketResponsedMessage> f2131d;

    /* renamed from: e  reason: collision with root package name */
    public DupLicateMode f2132e;

    /* loaded from: classes.dex */
    public enum DupLicateMode {
        NONE,
        REMOVE_ME,
        REMOVE_WAITING,
        REMOVE_ALL
    }

    public SocketMessageTask(int i) {
        super(i);
        this.f2128a = false;
        this.f2129b = false;
        this.f2130c = true;
        this.f2132e = DupLicateMode.NONE;
    }

    public DupLicateMode a() {
        return this.f2132e;
    }

    public boolean b() {
        return this.f2128a;
    }

    public boolean c() {
        return this.f2129b;
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.c(this.mCmd);
    }

    public boolean d() {
        return this.f2130c;
    }

    public void e(boolean z) {
        this.f2130c = z;
    }

    public void f(DupLicateMode dupLicateMode) {
        this.f2132e = dupLicateMode;
    }

    public void g(boolean z) {
        this.f2128a = z;
    }

    public Class<? extends SocketResponsedMessage> getResponsedClass() {
        return this.f2131d;
    }

    public void h(boolean z) {
        this.f2129b = z;
    }

    public void setResponsedClass(Class<? extends SocketResponsedMessage> cls) {
        this.f2131d = cls;
    }
}
