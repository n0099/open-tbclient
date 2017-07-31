package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public class SocketMessageTask extends MessageTask {
    private Class<? extends SocketResponsedMessage> mResponsedClass;
    private boolean sK;
    private boolean sL;
    private boolean sM;
    private DupLicateMode sN;

    /* loaded from: classes.dex */
    public enum DupLicateMode {
        NONE,
        REMOVE_ME,
        REMOVE_WAITING,
        REMOVE_ALL
    }

    public SocketMessageTask(int i) {
        super(i);
        this.sK = false;
        this.sL = false;
        this.sM = true;
        this.sN = DupLicateMode.NONE;
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.M(this.mCmd);
    }

    public void m(boolean z) {
        this.sK = z;
    }

    public boolean dJ() {
        return this.sK;
    }

    public boolean dK() {
        return this.sL;
    }

    public void n(boolean z) {
        this.sL = z;
    }

    public Class<? extends SocketResponsedMessage> getResponsedClass() {
        return this.mResponsedClass;
    }

    public void setResponsedClass(Class<? extends SocketResponsedMessage> cls) {
        this.mResponsedClass = cls;
    }

    public boolean dL() {
        return this.sM;
    }

    public void o(boolean z) {
        this.sM = z;
    }

    public DupLicateMode dM() {
        return this.sN;
    }

    public void a(DupLicateMode dupLicateMode) {
        this.sN = dupLicateMode;
    }
}
