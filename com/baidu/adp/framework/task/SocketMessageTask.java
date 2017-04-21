package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public class SocketMessageTask extends MessageTask {
    private Class<? extends SocketResponsedMessage> mResponsedClass;
    private boolean rd;
    private boolean re;
    private boolean rf;
    private DupLicateMode rg;

    /* loaded from: classes.dex */
    public enum DupLicateMode {
        NONE,
        REMOVE_ME,
        REMOVE_WAITING,
        REMOVE_ALL;

        /* JADX DEBUG: Replace access to removed values field (rh) with 'values()' method */
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
        this.rd = false;
        this.re = false;
        this.rf = true;
        this.rg = DupLicateMode.NONE;
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.J(this.mCmd);
    }

    public void m(boolean z) {
        this.rd = z;
    }

    public boolean dz() {
        return this.rd;
    }

    public boolean dA() {
        return this.re;
    }

    public void n(boolean z) {
        this.re = z;
    }

    public Class<? extends SocketResponsedMessage> getResponsedClass() {
        return this.mResponsedClass;
    }

    public void setResponsedClass(Class<? extends SocketResponsedMessage> cls) {
        this.mResponsedClass = cls;
    }

    public boolean dB() {
        return this.rf;
    }

    public void o(boolean z) {
        this.rf = z;
    }

    public DupLicateMode dC() {
        return this.rg;
    }

    public void a(DupLicateMode dupLicateMode) {
        this.rg = dupLicateMode;
    }
}
