package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public class SocketMessageTask extends MessageTask {
    private Class<? extends SocketResponsedMessage> mResponsedClass;
    private boolean wo;
    private boolean wp;
    private boolean wq;
    private DupLicateMode wr;

    /* loaded from: classes.dex */
    public enum DupLicateMode {
        NONE,
        REMOVE_ME,
        REMOVE_WAITING,
        REMOVE_ALL
    }

    public SocketMessageTask(int i) {
        super(i);
        this.wo = false;
        this.wp = false;
        this.wq = true;
        this.wr = DupLicateMode.NONE;
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.D(this.mCmd);
    }

    public void D(boolean z) {
        this.wo = z;
    }

    public boolean gl() {
        return this.wo;
    }

    public boolean gm() {
        return this.wp;
    }

    public void E(boolean z) {
        this.wp = z;
    }

    public Class<? extends SocketResponsedMessage> getResponsedClass() {
        return this.mResponsedClass;
    }

    public void setResponsedClass(Class<? extends SocketResponsedMessage> cls) {
        this.mResponsedClass = cls;
    }

    public boolean gn() {
        return this.wq;
    }

    public void F(boolean z) {
        this.wq = z;
    }

    public DupLicateMode go() {
        return this.wr;
    }

    public void a(DupLicateMode dupLicateMode) {
        this.wr = dupLicateMode;
    }
}
