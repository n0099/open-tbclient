package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public class SocketMessageTask extends MessageTask {
    private Class<? extends SocketResponsedMessage> mResponsedClass;
    private boolean pu;
    private boolean pv;
    private boolean pw;
    private DupLicateMode px;

    /* loaded from: classes.dex */
    public enum DupLicateMode {
        NONE,
        REMOVE_ME,
        REMOVE_WAITING,
        REMOVE_ALL
    }

    public SocketMessageTask(int i) {
        super(i);
        this.pu = false;
        this.pv = false;
        this.pw = true;
        this.px = DupLicateMode.NONE;
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.C(this.mCmd);
    }

    public void n(boolean z) {
        this.pu = z;
    }

    public boolean dh() {
        return this.pu;
    }

    public boolean di() {
        return this.pv;
    }

    public void o(boolean z) {
        this.pv = z;
    }

    public Class<? extends SocketResponsedMessage> getResponsedClass() {
        return this.mResponsedClass;
    }

    public void setResponsedClass(Class<? extends SocketResponsedMessage> cls) {
        this.mResponsedClass = cls;
    }

    public boolean dj() {
        return this.pw;
    }

    public void p(boolean z) {
        this.pw = z;
    }

    public DupLicateMode dk() {
        return this.px;
    }

    public void a(DupLicateMode dupLicateMode) {
        this.px = dupLicateMode;
    }
}
