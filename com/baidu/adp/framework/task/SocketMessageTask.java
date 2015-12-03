package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public class SocketMessageTask extends MessageTask {
    private Class<? extends SocketResponsedMessage> mResponsedClass;
    private boolean qM;
    private boolean qN;
    private boolean qO;
    private DupLicateMode qP;

    /* loaded from: classes.dex */
    public enum DupLicateMode {
        NONE,
        REMOVE_ME,
        REMOVE_WAITING,
        REMOVE_ALL;

        /* JADX DEBUG: Replace access to removed values field (qQ) with 'values()' method */
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
        this.qM = false;
        this.qN = false;
        this.qO = true;
        this.qP = DupLicateMode.NONE;
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.w(this.mCmd);
    }

    public void i(boolean z) {
        this.qM = z;
    }

    public boolean fa() {
        return this.qM;
    }

    public boolean fb() {
        return this.qN;
    }

    public void j(boolean z) {
        this.qN = z;
    }

    public Class<? extends SocketResponsedMessage> getResponsedClass() {
        return this.mResponsedClass;
    }

    public void setResponsedClass(Class<? extends SocketResponsedMessage> cls) {
        this.mResponsedClass = cls;
    }

    public boolean fc() {
        return this.qO;
    }

    public void k(boolean z) {
        this.qO = z;
    }

    public DupLicateMode fd() {
        return this.qP;
    }

    public void a(DupLicateMode dupLicateMode) {
        this.qP = dupLicateMode;
    }
}
