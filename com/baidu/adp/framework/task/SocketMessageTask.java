package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public class SocketMessageTask extends MessageTask {
    private Class<? extends SocketResponsedMessage> mResponsedClass;
    private boolean qK;
    private boolean qL;
    private boolean qM;
    private DupLicateMode qN;

    /* loaded from: classes.dex */
    public enum DupLicateMode {
        NONE,
        REMOVE_ME,
        REMOVE_WAITING,
        REMOVE_ALL;

        /* JADX DEBUG: Replace access to removed values field (qO) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static DupLicateMode[] valuesCustom() {
            DupLicateMode[] valuesCustom = values();
            int length = valuesCustom.length;
            DupLicateMode[] dupLicateModeArr = new DupLicateMode[length];
            System.arraycopy(valuesCustom, 0, dupLicateModeArr, 0, length);
            return dupLicateModeArr;
        }
    }

    public SocketMessageTask(int i) {
        super(i);
        this.qK = false;
        this.qL = false;
        this.qM = true;
        this.qN = DupLicateMode.NONE;
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.s(this.mCmd);
    }

    public void i(boolean z) {
        this.qK = z;
    }

    public boolean fb() {
        return this.qK;
    }

    public boolean fc() {
        return this.qL;
    }

    public void j(boolean z) {
        this.qL = z;
    }

    public Class<? extends SocketResponsedMessage> getResponsedClass() {
        return this.mResponsedClass;
    }

    public void setResponsedClass(Class<? extends SocketResponsedMessage> cls) {
        this.mResponsedClass = cls;
    }

    public boolean fd() {
        return this.qM;
    }

    public void k(boolean z) {
        this.qM = z;
    }

    public DupLicateMode fe() {
        return this.qN;
    }

    public void a(DupLicateMode dupLicateMode) {
        this.qN = dupLicateMode;
    }
}
