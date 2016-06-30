package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public class SocketMessageTask extends MessageTask {
    private boolean gP;
    private boolean gQ;
    private boolean gR;
    private DupLicateMode gS;
    private Class<? extends SocketResponsedMessage> mResponsedClass;

    /* loaded from: classes.dex */
    public enum DupLicateMode {
        NONE,
        REMOVE_ME,
        REMOVE_WAITING,
        REMOVE_ALL;

        /* JADX DEBUG: Replace access to removed values field (gT) with 'values()' method */
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
        this.gP = false;
        this.gQ = false;
        this.gR = true;
        this.gS = DupLicateMode.NONE;
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.u(this.mCmd);
    }

    public void h(boolean z) {
        this.gP = z;
    }

    public boolean by() {
        return this.gP;
    }

    public boolean bz() {
        return this.gQ;
    }

    public void i(boolean z) {
        this.gQ = z;
    }

    public Class<? extends SocketResponsedMessage> getResponsedClass() {
        return this.mResponsedClass;
    }

    public void setResponsedClass(Class<? extends SocketResponsedMessage> cls) {
        this.mResponsedClass = cls;
    }

    public boolean bA() {
        return this.gR;
    }

    public void j(boolean z) {
        this.gR = z;
    }

    public DupLicateMode bB() {
        return this.gS;
    }

    public void a(DupLicateMode dupLicateMode) {
        this.gS = dupLicateMode;
    }
}
