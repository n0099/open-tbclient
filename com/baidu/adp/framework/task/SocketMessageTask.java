package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public class SocketMessageTask extends MessageTask {
    private Class<? extends SocketResponsedMessage> mResponsedClass;
    private boolean vH;
    private boolean vI;
    private boolean vJ;
    private DupLicateMode vK;

    /* loaded from: classes.dex */
    public enum DupLicateMode {
        NONE,
        REMOVE_ME,
        REMOVE_WAITING,
        REMOVE_ALL
    }

    public SocketMessageTask(int i) {
        super(i);
        this.vH = false;
        this.vI = false;
        this.vJ = true;
        this.vK = DupLicateMode.NONE;
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.D(this.mCmd);
    }

    public void p(boolean z) {
        this.vH = z;
    }

    public boolean fW() {
        return this.vH;
    }

    public boolean fX() {
        return this.vI;
    }

    public void q(boolean z) {
        this.vI = z;
    }

    public Class<? extends SocketResponsedMessage> getResponsedClass() {
        return this.mResponsedClass;
    }

    public void setResponsedClass(Class<? extends SocketResponsedMessage> cls) {
        this.mResponsedClass = cls;
    }

    public boolean fY() {
        return this.vJ;
    }

    public void s(boolean z) {
        this.vJ = z;
    }

    public DupLicateMode fZ() {
        return this.vK;
    }

    public void a(DupLicateMode dupLicateMode) {
        this.vK = dupLicateMode;
    }
}
