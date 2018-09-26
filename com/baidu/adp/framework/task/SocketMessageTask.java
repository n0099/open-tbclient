package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public class SocketMessageTask extends MessageTask {
    private Class<? extends SocketResponsedMessage> mResponsedClass;
    private boolean xT;
    private boolean xU;
    private boolean xV;
    private DupLicateMode xW;

    /* loaded from: classes.dex */
    public enum DupLicateMode {
        NONE,
        REMOVE_ME,
        REMOVE_WAITING,
        REMOVE_ALL
    }

    public SocketMessageTask(int i) {
        super(i);
        this.xT = false;
        this.xU = false;
        this.xV = true;
        this.xW = DupLicateMode.NONE;
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.L(this.mCmd);
    }

    public void x(boolean z) {
        this.xT = z;
    }

    public boolean hd() {
        return this.xT;
    }

    public boolean he() {
        return this.xU;
    }

    public void y(boolean z) {
        this.xU = z;
    }

    public Class<? extends SocketResponsedMessage> getResponsedClass() {
        return this.mResponsedClass;
    }

    public void setResponsedClass(Class<? extends SocketResponsedMessage> cls) {
        this.mResponsedClass = cls;
    }

    public boolean hf() {
        return this.xV;
    }

    public void z(boolean z) {
        this.xV = z;
    }

    public DupLicateMode hg() {
        return this.xW;
    }

    public void a(DupLicateMode dupLicateMode) {
        this.xW = dupLicateMode;
    }
}
