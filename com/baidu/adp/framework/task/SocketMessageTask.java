package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public class SocketMessageTask extends MessageTask {
    private Class<? extends SocketResponsedMessage> mResponsedClass;
    private boolean yE;
    private boolean yF;
    private boolean yG;
    private DupLicateMode yH;

    /* loaded from: classes.dex */
    public enum DupLicateMode {
        NONE,
        REMOVE_ME,
        REMOVE_WAITING,
        REMOVE_ALL
    }

    public SocketMessageTask(int i) {
        super(i);
        this.yE = false;
        this.yF = false;
        this.yG = true;
        this.yH = DupLicateMode.NONE;
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.K(this.mCmd);
    }

    public void L(boolean z) {
        this.yE = z;
    }

    public boolean hr() {
        return this.yE;
    }

    public boolean hs() {
        return this.yF;
    }

    public void M(boolean z) {
        this.yF = z;
    }

    public Class<? extends SocketResponsedMessage> getResponsedClass() {
        return this.mResponsedClass;
    }

    public void setResponsedClass(Class<? extends SocketResponsedMessage> cls) {
        this.mResponsedClass = cls;
    }

    public boolean ht() {
        return this.yG;
    }

    public void N(boolean z) {
        this.yG = z;
    }

    public DupLicateMode hu() {
        return this.yH;
    }

    public void a(DupLicateMode dupLicateMode) {
        this.yH = dupLicateMode;
    }
}
