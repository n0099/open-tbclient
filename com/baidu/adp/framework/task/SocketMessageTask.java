package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public class SocketMessageTask extends MessageTask {
    private Class<? extends SocketResponsedMessage> mResponsedClass;
    private boolean qN;
    private boolean qO;
    private boolean qP;
    private DupLicateMode qQ;

    /* loaded from: classes.dex */
    public enum DupLicateMode {
        NONE,
        REMOVE_ME,
        REMOVE_WAITING,
        REMOVE_ALL;

        /* JADX DEBUG: Replace access to removed values field (qR) with 'values()' method */
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
        this.qN = false;
        this.qO = false;
        this.qP = true;
        this.qQ = DupLicateMode.NONE;
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.w(this.mCmd);
    }

    public void i(boolean z) {
        this.qN = z;
    }

    public boolean fa() {
        return this.qN;
    }

    public boolean fb() {
        return this.qO;
    }

    public void j(boolean z) {
        this.qO = z;
    }

    public Class<? extends SocketResponsedMessage> getResponsedClass() {
        return this.mResponsedClass;
    }

    public void setResponsedClass(Class<? extends SocketResponsedMessage> cls) {
        this.mResponsedClass = cls;
    }

    public boolean fc() {
        return this.qP;
    }

    public void k(boolean z) {
        this.qP = z;
    }

    public DupLicateMode fd() {
        return this.qQ;
    }

    public void a(DupLicateMode dupLicateMode) {
        this.qQ = dupLicateMode;
    }
}
