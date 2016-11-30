package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public class SocketMessageTask extends MessageTask {
    private boolean jL;
    private boolean jM;
    private boolean jN;
    private DupLicateMode jO;
    private Class<? extends SocketResponsedMessage> mResponsedClass;

    /* loaded from: classes.dex */
    public enum DupLicateMode {
        NONE,
        REMOVE_ME,
        REMOVE_WAITING,
        REMOVE_ALL;

        /* JADX DEBUG: Replace access to removed values field (jP) with 'values()' method */
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
        this.jL = false;
        this.jM = false;
        this.jN = true;
        this.jO = DupLicateMode.NONE;
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.K(this.mCmd);
    }

    public void l(boolean z) {
        this.jL = z;
    }

    public boolean cs() {
        return this.jL;
    }

    public boolean ct() {
        return this.jM;
    }

    public void m(boolean z) {
        this.jM = z;
    }

    public Class<? extends SocketResponsedMessage> getResponsedClass() {
        return this.mResponsedClass;
    }

    public void setResponsedClass(Class<? extends SocketResponsedMessage> cls) {
        this.mResponsedClass = cls;
    }

    public boolean cu() {
        return this.jN;
    }

    public void n(boolean z) {
        this.jN = z;
    }

    public DupLicateMode cv() {
        return this.jO;
    }

    public void a(DupLicateMode dupLicateMode) {
        this.jO = dupLicateMode;
    }
}
