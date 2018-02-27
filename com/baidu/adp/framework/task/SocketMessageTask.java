package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public class SocketMessageTask extends MessageTask {
    private boolean aeV;
    private boolean aeW;
    private boolean aeX;
    private DupLicateMode aeY;
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
        this.aeV = false;
        this.aeW = false;
        this.aeX = true;
        this.aeY = DupLicateMode.NONE;
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.cC(this.mCmd);
    }

    public void V(boolean z) {
        this.aeV = z;
    }

    public boolean ld() {
        return this.aeV;
    }

    public boolean le() {
        return this.aeW;
    }

    public void W(boolean z) {
        this.aeW = z;
    }

    public Class<? extends SocketResponsedMessage> getResponsedClass() {
        return this.mResponsedClass;
    }

    public void setResponsedClass(Class<? extends SocketResponsedMessage> cls) {
        this.mResponsedClass = cls;
    }

    public boolean lf() {
        return this.aeX;
    }

    public void X(boolean z) {
        this.aeX = z;
    }

    public DupLicateMode lg() {
        return this.aeY;
    }

    public void a(DupLicateMode dupLicateMode) {
        this.aeY = dupLicateMode;
    }
}
