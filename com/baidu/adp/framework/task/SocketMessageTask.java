package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public class SocketMessageTask extends MessageTask {
    private Class<? extends SocketResponsedMessage> mResponsedClass;
    private boolean qD;
    private boolean qE;
    private boolean qF;
    private DupLicateMode qG;

    /* loaded from: classes.dex */
    public enum DupLicateMode {
        NONE,
        REMOVE_ME,
        REMOVE_WAITING,
        REMOVE_ALL
    }

    public SocketMessageTask(int i) {
        super(i);
        this.qD = false;
        this.qE = false;
        this.qF = true;
        this.qG = DupLicateMode.NONE;
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.J(this.mCmd);
    }

    public void m(boolean z) {
        this.qD = z;
    }

    public boolean dz() {
        return this.qD;
    }

    public boolean dA() {
        return this.qE;
    }

    public void n(boolean z) {
        this.qE = z;
    }

    public Class<? extends SocketResponsedMessage> getResponsedClass() {
        return this.mResponsedClass;
    }

    public void setResponsedClass(Class<? extends SocketResponsedMessage> cls) {
        this.mResponsedClass = cls;
    }

    public boolean dB() {
        return this.qF;
    }

    public void o(boolean z) {
        this.qF = z;
    }

    public DupLicateMode dC() {
        return this.qG;
    }

    public void a(DupLicateMode dupLicateMode) {
        this.qG = dupLicateMode;
    }
}
