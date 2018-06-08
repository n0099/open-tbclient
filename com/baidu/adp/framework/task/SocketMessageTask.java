package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public class SocketMessageTask extends MessageTask {
    private Class<? extends SocketResponsedMessage> mResponsedClass;
    private boolean vJ;
    private boolean vK;
    private boolean vL;
    private DupLicateMode vM;

    /* loaded from: classes.dex */
    public enum DupLicateMode {
        NONE,
        REMOVE_ME,
        REMOVE_WAITING,
        REMOVE_ALL
    }

    public SocketMessageTask(int i) {
        super(i);
        this.vJ = false;
        this.vK = false;
        this.vL = true;
        this.vM = DupLicateMode.NONE;
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.D(this.mCmd);
    }

    public void p(boolean z) {
        this.vJ = z;
    }

    public boolean fW() {
        return this.vJ;
    }

    public boolean fX() {
        return this.vK;
    }

    public void q(boolean z) {
        this.vK = z;
    }

    public Class<? extends SocketResponsedMessage> getResponsedClass() {
        return this.mResponsedClass;
    }

    public void setResponsedClass(Class<? extends SocketResponsedMessage> cls) {
        this.mResponsedClass = cls;
    }

    public boolean fY() {
        return this.vL;
    }

    public void s(boolean z) {
        this.vL = z;
    }

    public DupLicateMode fZ() {
        return this.vM;
    }

    public void a(DupLicateMode dupLicateMode) {
        this.vM = dupLicateMode;
    }
}
