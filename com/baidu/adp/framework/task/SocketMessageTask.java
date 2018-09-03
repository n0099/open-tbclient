package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public class SocketMessageTask extends MessageTask {
    private Class<? extends SocketResponsedMessage> mResponsedClass;
    private boolean vA;
    private boolean vB;
    private boolean vC;
    private DupLicateMode vD;

    /* loaded from: classes.dex */
    public enum DupLicateMode {
        NONE,
        REMOVE_ME,
        REMOVE_WAITING,
        REMOVE_ALL
    }

    public SocketMessageTask(int i) {
        super(i);
        this.vA = false;
        this.vB = false;
        this.vC = true;
        this.vD = DupLicateMode.NONE;
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.D(this.mCmd);
    }

    public void n(boolean z) {
        this.vA = z;
    }

    public boolean fV() {
        return this.vA;
    }

    public boolean fW() {
        return this.vB;
    }

    public void o(boolean z) {
        this.vB = z;
    }

    public Class<? extends SocketResponsedMessage> getResponsedClass() {
        return this.mResponsedClass;
    }

    public void setResponsedClass(Class<? extends SocketResponsedMessage> cls) {
        this.mResponsedClass = cls;
    }

    public boolean fX() {
        return this.vC;
    }

    public void p(boolean z) {
        this.vC = z;
    }

    public DupLicateMode fY() {
        return this.vD;
    }

    public void a(DupLicateMode dupLicateMode) {
        this.vD = dupLicateMode;
    }
}
