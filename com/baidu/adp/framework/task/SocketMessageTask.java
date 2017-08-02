package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public class SocketMessageTask extends MessageTask {
    private Class<? extends SocketResponsedMessage> mResponsedClass;
    private boolean re;
    private boolean rf;
    private boolean rg;
    private DupLicateMode rh;

    /* loaded from: classes.dex */
    public enum DupLicateMode {
        NONE,
        REMOVE_ME,
        REMOVE_WAITING,
        REMOVE_ALL
    }

    public SocketMessageTask(int i) {
        super(i);
        this.re = false;
        this.rf = false;
        this.rg = true;
        this.rh = DupLicateMode.NONE;
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.J(this.mCmd);
    }

    public void m(boolean z) {
        this.re = z;
    }

    public boolean dy() {
        return this.re;
    }

    public boolean dz() {
        return this.rf;
    }

    public void n(boolean z) {
        this.rf = z;
    }

    public Class<? extends SocketResponsedMessage> getResponsedClass() {
        return this.mResponsedClass;
    }

    public void setResponsedClass(Class<? extends SocketResponsedMessage> cls) {
        this.mResponsedClass = cls;
    }

    public boolean dA() {
        return this.rg;
    }

    public void o(boolean z) {
        this.rg = z;
    }

    public DupLicateMode dB() {
        return this.rh;
    }

    public void a(DupLicateMode dupLicateMode) {
        this.rh = dupLicateMode;
    }
}
