package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public class SocketMessageTask extends MessageTask {
    private Class<? extends SocketResponsedMessage> mResponsedClass;
    private boolean rA;
    private boolean rB;
    private boolean rC;
    private DupLicateMode rD;

    /* loaded from: classes.dex */
    public enum DupLicateMode {
        NONE,
        REMOVE_ME,
        REMOVE_WAITING,
        REMOVE_ALL;

        /* JADX DEBUG: Replace access to removed values field (rE) with 'values()' method */
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
        this.rA = false;
        this.rB = false;
        this.rC = true;
        this.rD = DupLicateMode.NONE;
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.L(this.mCmd);
    }

    public void m(boolean z) {
        this.rA = z;
    }

    public boolean dz() {
        return this.rA;
    }

    public boolean dA() {
        return this.rB;
    }

    public void n(boolean z) {
        this.rB = z;
    }

    public Class<? extends SocketResponsedMessage> getResponsedClass() {
        return this.mResponsedClass;
    }

    public void setResponsedClass(Class<? extends SocketResponsedMessage> cls) {
        this.mResponsedClass = cls;
    }

    public boolean dB() {
        return this.rC;
    }

    public void o(boolean z) {
        this.rC = z;
    }

    public DupLicateMode dC() {
        return this.rD;
    }

    public void a(DupLicateMode dupLicateMode) {
        this.rD = dupLicateMode;
    }
}
