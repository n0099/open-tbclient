package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public class SocketMessageTask extends MessageTask {
    private Class<? extends SocketResponsedMessage> mResponsedClass;
    private boolean sN;
    private boolean sO;
    private boolean sP;
    private DupLicateMode sQ;

    /* loaded from: classes.dex */
    public enum DupLicateMode {
        NONE,
        REMOVE_ME,
        REMOVE_WAITING,
        REMOVE_ALL
    }

    public SocketMessageTask(int i) {
        super(i);
        this.sN = false;
        this.sO = false;
        this.sP = true;
        this.sQ = DupLicateMode.NONE;
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.M(this.mCmd);
    }

    public void m(boolean z) {
        this.sN = z;
    }

    public boolean dJ() {
        return this.sN;
    }

    public boolean dK() {
        return this.sO;
    }

    public void n(boolean z) {
        this.sO = z;
    }

    public Class<? extends SocketResponsedMessage> getResponsedClass() {
        return this.mResponsedClass;
    }

    public void setResponsedClass(Class<? extends SocketResponsedMessage> cls) {
        this.mResponsedClass = cls;
    }

    public boolean dL() {
        return this.sP;
    }

    public void o(boolean z) {
        this.sP = z;
    }

    public DupLicateMode dM() {
        return this.sQ;
    }

    public void a(DupLicateMode dupLicateMode) {
        this.sQ = dupLicateMode;
    }
}
