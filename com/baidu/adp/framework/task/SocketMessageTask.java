package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public class SocketMessageTask extends MessageTask {
    private Class<? extends SocketResponsedMessage> mResponsedClass;
    private boolean vA;
    private boolean vB;
    private DupLicateMode vC;
    private boolean vz;

    /* loaded from: classes.dex */
    public enum DupLicateMode {
        NONE,
        REMOVE_ME,
        REMOVE_WAITING,
        REMOVE_ALL
    }

    public SocketMessageTask(int i) {
        super(i);
        this.vz = false;
        this.vA = false;
        this.vB = true;
        this.vC = DupLicateMode.NONE;
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.D(this.mCmd);
    }

    public void n(boolean z) {
        this.vz = z;
    }

    public boolean fV() {
        return this.vz;
    }

    public boolean fW() {
        return this.vA;
    }

    public void o(boolean z) {
        this.vA = z;
    }

    public Class<? extends SocketResponsedMessage> getResponsedClass() {
        return this.mResponsedClass;
    }

    public void setResponsedClass(Class<? extends SocketResponsedMessage> cls) {
        this.mResponsedClass = cls;
    }

    public boolean fX() {
        return this.vB;
    }

    public void p(boolean z) {
        this.vB = z;
    }

    public DupLicateMode fY() {
        return this.vC;
    }

    public void a(DupLicateMode dupLicateMode) {
        this.vC = dupLicateMode;
    }
}
