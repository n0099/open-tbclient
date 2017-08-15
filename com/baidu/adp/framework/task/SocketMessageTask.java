package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public class SocketMessageTask extends MessageTask {
    private Class<? extends SocketResponsedMessage> mResponsedClass;
    private boolean sM;
    private boolean sN;
    private boolean sO;
    private DupLicateMode sP;

    /* loaded from: classes.dex */
    public enum DupLicateMode {
        NONE,
        REMOVE_ME,
        REMOVE_WAITING,
        REMOVE_ALL
    }

    public SocketMessageTask(int i) {
        super(i);
        this.sM = false;
        this.sN = false;
        this.sO = true;
        this.sP = DupLicateMode.NONE;
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.M(this.mCmd);
    }

    public void m(boolean z) {
        this.sM = z;
    }

    public boolean dJ() {
        return this.sM;
    }

    public boolean dK() {
        return this.sN;
    }

    public void n(boolean z) {
        this.sN = z;
    }

    public Class<? extends SocketResponsedMessage> getResponsedClass() {
        return this.mResponsedClass;
    }

    public void setResponsedClass(Class<? extends SocketResponsedMessage> cls) {
        this.mResponsedClass = cls;
    }

    public boolean dL() {
        return this.sO;
    }

    public void o(boolean z) {
        this.sO = z;
    }

    public DupLicateMode dM() {
        return this.sP;
    }

    public void a(DupLicateMode dupLicateMode) {
        this.sP = dupLicateMode;
    }
}
