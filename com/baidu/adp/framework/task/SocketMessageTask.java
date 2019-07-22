package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public class SocketMessageTask extends MessageTask {
    private Class<? extends SocketResponsedMessage> mResponsedClass;
    private boolean wr;
    private boolean ws;
    private boolean wt;
    private DupLicateMode wu;

    /* loaded from: classes.dex */
    public enum DupLicateMode {
        NONE,
        REMOVE_ME,
        REMOVE_WAITING,
        REMOVE_ALL
    }

    public SocketMessageTask(int i) {
        super(i);
        this.wr = false;
        this.ws = false;
        this.wt = true;
        this.wu = DupLicateMode.NONE;
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.D(this.mCmd);
    }

    public void D(boolean z) {
        this.wr = z;
    }

    public boolean gu() {
        return this.wr;
    }

    public boolean gv() {
        return this.ws;
    }

    public void E(boolean z) {
        this.ws = z;
    }

    public Class<? extends SocketResponsedMessage> getResponsedClass() {
        return this.mResponsedClass;
    }

    public void setResponsedClass(Class<? extends SocketResponsedMessage> cls) {
        this.mResponsedClass = cls;
    }

    public boolean gw() {
        return this.wt;
    }

    public void F(boolean z) {
        this.wt = z;
    }

    public DupLicateMode gx() {
        return this.wu;
    }

    public void a(DupLicateMode dupLicateMode) {
        this.wu = dupLicateMode;
    }
}
