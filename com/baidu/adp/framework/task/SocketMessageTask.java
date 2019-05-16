package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public class SocketMessageTask extends MessageTask {
    private Class<? extends SocketResponsedMessage> mResponsedClass;
    private boolean wp;
    private boolean wq;
    private boolean wr;
    private DupLicateMode ws;

    /* loaded from: classes.dex */
    public enum DupLicateMode {
        NONE,
        REMOVE_ME,
        REMOVE_WAITING,
        REMOVE_ALL
    }

    public SocketMessageTask(int i) {
        super(i);
        this.wp = false;
        this.wq = false;
        this.wr = true;
        this.ws = DupLicateMode.NONE;
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.D(this.mCmd);
    }

    public void D(boolean z) {
        this.wp = z;
    }

    public boolean gl() {
        return this.wp;
    }

    public boolean gm() {
        return this.wq;
    }

    public void E(boolean z) {
        this.wq = z;
    }

    public Class<? extends SocketResponsedMessage> getResponsedClass() {
        return this.mResponsedClass;
    }

    public void setResponsedClass(Class<? extends SocketResponsedMessage> cls) {
        this.mResponsedClass = cls;
    }

    public boolean gn() {
        return this.wr;
    }

    public void F(boolean z) {
        this.wr = z;
    }

    public DupLicateMode go() {
        return this.ws;
    }

    public void a(DupLicateMode dupLicateMode) {
        this.ws = dupLicateMode;
    }
}
