package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public class SocketMessageTask extends MessageTask {
    private Class<? extends SocketResponsedMessage> mResponsedClass;
    private boolean yF;
    private boolean yG;
    private boolean yH;
    private DupLicateMode yI;

    /* loaded from: classes.dex */
    public enum DupLicateMode {
        NONE,
        REMOVE_ME,
        REMOVE_WAITING,
        REMOVE_ALL
    }

    public SocketMessageTask(int i) {
        super(i);
        this.yF = false;
        this.yG = false;
        this.yH = true;
        this.yI = DupLicateMode.NONE;
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.L(this.mCmd);
    }

    public void x(boolean z) {
        this.yF = z;
    }

    public boolean hu() {
        return this.yF;
    }

    public boolean hv() {
        return this.yG;
    }

    public void y(boolean z) {
        this.yG = z;
    }

    public Class<? extends SocketResponsedMessage> getResponsedClass() {
        return this.mResponsedClass;
    }

    public void setResponsedClass(Class<? extends SocketResponsedMessage> cls) {
        this.mResponsedClass = cls;
    }

    public boolean hw() {
        return this.yH;
    }

    public void z(boolean z) {
        this.yH = z;
    }

    public DupLicateMode hx() {
        return this.yI;
    }

    public void a(DupLicateMode dupLicateMode) {
        this.yI = dupLicateMode;
    }
}
