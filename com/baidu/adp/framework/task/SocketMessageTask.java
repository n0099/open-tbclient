package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public class SocketMessageTask extends MessageTask {
    private Class<? extends SocketResponsedMessage> mResponsedClass;
    private boolean qB;
    private boolean qC;
    private boolean qD;
    private DupLicateMode qE;

    /* loaded from: classes.dex */
    public enum DupLicateMode {
        NONE,
        REMOVE_ME,
        REMOVE_WAITING,
        REMOVE_ALL
    }

    public SocketMessageTask(int i) {
        super(i);
        this.qB = false;
        this.qC = false;
        this.qD = true;
        this.qE = DupLicateMode.NONE;
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.J(this.mCmd);
    }

    public void m(boolean z) {
        this.qB = z;
    }

    public boolean dz() {
        return this.qB;
    }

    public boolean dA() {
        return this.qC;
    }

    public void n(boolean z) {
        this.qC = z;
    }

    public Class<? extends SocketResponsedMessage> getResponsedClass() {
        return this.mResponsedClass;
    }

    public void setResponsedClass(Class<? extends SocketResponsedMessage> cls) {
        this.mResponsedClass = cls;
    }

    public boolean dB() {
        return this.qD;
    }

    public void o(boolean z) {
        this.qD = z;
    }

    public DupLicateMode dC() {
        return this.qE;
    }

    public void a(DupLicateMode dupLicateMode) {
        this.qE = dupLicateMode;
    }
}
