package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public class SocketMessageTask extends MessageTask {
    private DupLicateMode Ir;
    private boolean mCanRetry;
    private boolean mNeedAck;
    private boolean mNeedCompress;
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
        this.mNeedAck = false;
        this.mNeedCompress = false;
        this.mCanRetry = true;
        this.Ir = DupLicateMode.NONE;
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.checkSocketCmd(this.mCmd);
    }

    public void setNeedAck(boolean z) {
        this.mNeedAck = z;
    }

    public boolean getNeedAck() {
        return this.mNeedAck;
    }

    public boolean getNeedCompress() {
        return this.mNeedCompress;
    }

    public void setNeedCompress(boolean z) {
        this.mNeedCompress = z;
    }

    public Class<? extends SocketResponsedMessage> getResponsedClass() {
        return this.mResponsedClass;
    }

    public void setResponsedClass(Class<? extends SocketResponsedMessage> cls) {
        this.mResponsedClass = cls;
    }

    public boolean isCanRetry() {
        return this.mCanRetry;
    }

    public void setCanRetry(boolean z) {
        this.mCanRetry = z;
    }

    public DupLicateMode kd() {
        return this.Ir;
    }

    public void a(DupLicateMode dupLicateMode) {
        this.Ir = dupLicateMode;
    }
}
