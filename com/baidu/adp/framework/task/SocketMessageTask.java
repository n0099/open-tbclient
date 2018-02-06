package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public class SocketMessageTask extends MessageTask {
    private boolean afb;
    private boolean afc;
    private boolean afd;
    private DupLicateMode afe;
    private Class<? extends SocketResponsedMessage> mResponsedClass;

    /* loaded from: classes.dex */
    public enum DupLicateMode {
        NONE,
        REMOVE_ME,
        REMOVE_WAITING,
        REMOVE_ALL
    }

    public SocketMessageTask(int i) {
        super(i);
        this.afb = false;
        this.afc = false;
        this.afd = true;
        this.afe = DupLicateMode.NONE;
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.cC(this.mCmd);
    }

    public void V(boolean z) {
        this.afb = z;
    }

    public boolean ld() {
        return this.afb;
    }

    public boolean le() {
        return this.afc;
    }

    public void W(boolean z) {
        this.afc = z;
    }

    public Class<? extends SocketResponsedMessage> getResponsedClass() {
        return this.mResponsedClass;
    }

    public void setResponsedClass(Class<? extends SocketResponsedMessage> cls) {
        this.mResponsedClass = cls;
    }

    public boolean lf() {
        return this.afd;
    }

    public void X(boolean z) {
        this.afd = z;
    }

    public DupLicateMode lg() {
        return this.afe;
    }

    public void a(DupLicateMode dupLicateMode) {
        this.afe = dupLicateMode;
    }
}
