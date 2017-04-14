package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public class SocketMessageTask extends MessageTask {
    private Class<? extends SocketResponsedMessage> mResponsedClass;
    private boolean qY;
    private boolean qZ;
    private boolean ra;
    private DupLicateMode rb;

    /* loaded from: classes.dex */
    public enum DupLicateMode {
        NONE,
        REMOVE_ME,
        REMOVE_WAITING,
        REMOVE_ALL;

        /* JADX DEBUG: Replace access to removed values field (rc) with 'values()' method */
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
        this.qY = false;
        this.qZ = false;
        this.ra = true;
        this.rb = DupLicateMode.NONE;
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.J(this.mCmd);
    }

    public void m(boolean z) {
        this.qY = z;
    }

    public boolean dy() {
        return this.qY;
    }

    public boolean dz() {
        return this.qZ;
    }

    public void n(boolean z) {
        this.qZ = z;
    }

    public Class<? extends SocketResponsedMessage> getResponsedClass() {
        return this.mResponsedClass;
    }

    public void setResponsedClass(Class<? extends SocketResponsedMessage> cls) {
        this.mResponsedClass = cls;
    }

    public boolean dA() {
        return this.ra;
    }

    public void o(boolean z) {
        this.ra = z;
    }

    public DupLicateMode dB() {
        return this.rb;
    }

    public void a(DupLicateMode dupLicateMode) {
        this.rb = dupLicateMode;
    }
}
