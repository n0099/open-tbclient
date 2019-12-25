package com.baidu.live.adp.framework.task;

import com.baidu.live.adp.framework.FrameHelper;
import com.baidu.live.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes2.dex */
public class SocketMessageTask extends MessageTask {
    public static final int PRIORITY_HIGH = -1;
    public static final int PRIORITY_LOW = 1;
    public static final int PRIORITY_NORMAL = 0;
    public static final int PRIORITY_SUPER_HIGH = -3;
    public static final int PRIORITY_VERY_HIGH = -2;
    private boolean mCanRetry;
    private DupLicateMode mDupLicateMode;
    private boolean mNeedAck;
    private boolean mNeedCompress;
    private Class<? extends SocketResponsedMessage> mResponsedClass;

    /* loaded from: classes2.dex */
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
        this.mDupLicateMode = DupLicateMode.NONE;
    }

    @Override // com.baidu.live.adp.framework.task.MessageTask
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

    public DupLicateMode getDupLicateMode() {
        return this.mDupLicateMode;
    }

    public void setDupLicateMode(DupLicateMode dupLicateMode) {
        this.mDupLicateMode = dupLicateMode;
    }
}
