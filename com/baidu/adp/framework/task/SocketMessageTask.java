package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public class SocketMessageTask extends MessageTask {
    private Class<? extends SocketResponsedMessage> mResponsedClass;
    private boolean yI;
    private boolean yJ;
    private boolean yK;
    private DupLicateMode yL;

    /* loaded from: classes.dex */
    public enum DupLicateMode {
        NONE,
        REMOVE_ME,
        REMOVE_WAITING,
        REMOVE_ALL
    }

    public SocketMessageTask(int i) {
        super(i);
        this.yI = false;
        this.yJ = false;
        this.yK = true;
        this.yL = DupLicateMode.NONE;
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.ac(this.mCmd);
    }

    public void L(boolean z) {
        this.yI = z;
    }

    public boolean ht() {
        return this.yI;
    }

    public boolean hu() {
        return this.yJ;
    }

    public void M(boolean z) {
        this.yJ = z;
    }

    public Class<? extends SocketResponsedMessage> getResponsedClass() {
        return this.mResponsedClass;
    }

    public void setResponsedClass(Class<? extends SocketResponsedMessage> cls) {
        this.mResponsedClass = cls;
    }

    public boolean hv() {
        return this.yK;
    }

    public void N(boolean z) {
        this.yK = z;
    }

    public DupLicateMode hw() {
        return this.yL;
    }

    public void a(DupLicateMode dupLicateMode) {
        this.yL = dupLicateMode;
    }
}
