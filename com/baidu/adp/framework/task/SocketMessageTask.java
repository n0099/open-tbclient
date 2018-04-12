package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public class SocketMessageTask extends MessageTask {
    private Class<? extends SocketResponsedMessage> mResponsedClass;
    private boolean pv;
    private boolean pw;
    private boolean px;
    private DupLicateMode py;

    /* loaded from: classes.dex */
    public enum DupLicateMode {
        NONE,
        REMOVE_ME,
        REMOVE_WAITING,
        REMOVE_ALL
    }

    public SocketMessageTask(int i) {
        super(i);
        this.pv = false;
        this.pw = false;
        this.px = true;
        this.py = DupLicateMode.NONE;
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.C(this.mCmd);
    }

    public void n(boolean z) {
        this.pv = z;
    }

    public boolean dh() {
        return this.pv;
    }

    public boolean di() {
        return this.pw;
    }

    public void o(boolean z) {
        this.pw = z;
    }

    public Class<? extends SocketResponsedMessage> getResponsedClass() {
        return this.mResponsedClass;
    }

    public void setResponsedClass(Class<? extends SocketResponsedMessage> cls) {
        this.mResponsedClass = cls;
    }

    public boolean dj() {
        return this.px;
    }

    public void p(boolean z) {
        this.px = z;
    }

    public DupLicateMode dk() {
        return this.py;
    }

    public void a(DupLicateMode dupLicateMode) {
        this.py = dupLicateMode;
    }
}
