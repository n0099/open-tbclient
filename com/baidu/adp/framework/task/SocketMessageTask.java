package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public class SocketMessageTask extends MessageTask {
    private boolean afd;
    private boolean afe;
    private boolean aff;
    private DupLicateMode afg;
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
        this.afd = false;
        this.afe = false;
        this.aff = true;
        this.afg = DupLicateMode.NONE;
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.cC(this.mCmd);
    }

    public void T(boolean z) {
        this.afd = z;
    }

    public boolean ld() {
        return this.afd;
    }

    public boolean le() {
        return this.afe;
    }

    public void U(boolean z) {
        this.afe = z;
    }

    public Class<? extends SocketResponsedMessage> getResponsedClass() {
        return this.mResponsedClass;
    }

    public void setResponsedClass(Class<? extends SocketResponsedMessage> cls) {
        this.mResponsedClass = cls;
    }

    public boolean lf() {
        return this.aff;
    }

    public void V(boolean z) {
        this.aff = z;
    }

    public DupLicateMode lg() {
        return this.afg;
    }

    public void a(DupLicateMode dupLicateMode) {
        this.afg = dupLicateMode;
    }
}
