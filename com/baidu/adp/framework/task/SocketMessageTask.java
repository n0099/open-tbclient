package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public class SocketMessageTask extends MessageTask {

    /* renamed from: a  reason: collision with root package name */
    public boolean f2146a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f2147b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f2148c;

    /* renamed from: d  reason: collision with root package name */
    public Class<? extends SocketResponsedMessage> f2149d;

    /* renamed from: e  reason: collision with root package name */
    public DupLicateMode f2150e;

    /* loaded from: classes.dex */
    public enum DupLicateMode {
        NONE,
        REMOVE_ME,
        REMOVE_WAITING,
        REMOVE_ALL
    }

    public SocketMessageTask(int i2) {
        super(i2);
        this.f2146a = false;
        this.f2147b = false;
        this.f2148c = true;
        this.f2150e = DupLicateMode.NONE;
    }

    public DupLicateMode a() {
        return this.f2150e;
    }

    public boolean b() {
        return this.f2146a;
    }

    public boolean c() {
        return this.f2147b;
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.c(this.mCmd);
    }

    public boolean d() {
        return this.f2148c;
    }

    public void e(boolean z) {
        this.f2148c = z;
    }

    public void f(DupLicateMode dupLicateMode) {
        this.f2150e = dupLicateMode;
    }

    public void g(boolean z) {
        this.f2146a = z;
    }

    public Class<? extends SocketResponsedMessage> getResponsedClass() {
        return this.f2149d;
    }

    public void h(boolean z) {
        this.f2147b = z;
    }

    public void setResponsedClass(Class<? extends SocketResponsedMessage> cls) {
        this.f2149d = cls;
    }
}
