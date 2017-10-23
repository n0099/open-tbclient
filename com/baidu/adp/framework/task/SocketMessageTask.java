package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public class SocketMessageTask extends MessageTask {
    private Class<? extends SocketResponsedMessage> mResponsedClass;
    private boolean qC;
    private boolean qD;
    private boolean qE;
    private DupLicateMode qF;

    /* loaded from: classes.dex */
    public enum DupLicateMode {
        NONE,
        REMOVE_ME,
        REMOVE_WAITING,
        REMOVE_ALL
    }

    public SocketMessageTask(int i) {
        super(i);
        this.qC = false;
        this.qD = false;
        this.qE = true;
        this.qF = DupLicateMode.NONE;
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.J(this.mCmd);
    }

    public void m(boolean z) {
        this.qC = z;
    }

    public boolean dz() {
        return this.qC;
    }

    public boolean dA() {
        return this.qD;
    }

    public void n(boolean z) {
        this.qD = z;
    }

    public Class<? extends SocketResponsedMessage> getResponsedClass() {
        return this.mResponsedClass;
    }

    public void setResponsedClass(Class<? extends SocketResponsedMessage> cls) {
        this.mResponsedClass = cls;
    }

    public boolean dB() {
        return this.qE;
    }

    public void o(boolean z) {
        this.qE = z;
    }

    public DupLicateMode dC() {
        return this.qF;
    }

    public void a(DupLicateMode dupLicateMode) {
        this.qF = dupLicateMode;
    }
}
