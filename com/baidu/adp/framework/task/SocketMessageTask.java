package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public class SocketMessageTask extends MessageTask {
    private boolean fr;
    private boolean fs;
    private boolean ft;
    private DupLicateMode fu;
    private Class<? extends SocketResponsedMessage> mResponsedClass;

    /* loaded from: classes.dex */
    public enum DupLicateMode {
        NONE,
        REMOVE_ME,
        REMOVE_WAITING,
        REMOVE_ALL;

        /* JADX DEBUG: Replace access to removed values field (fv) with 'values()' method */
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
        this.fr = false;
        this.fs = false;
        this.ft = true;
        this.fu = DupLicateMode.NONE;
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.r(this.mCmd);
    }

    public void i(boolean z) {
        this.fr = z;
    }

    public boolean bD() {
        return this.fr;
    }

    public boolean bE() {
        return this.fs;
    }

    public void j(boolean z) {
        this.fs = z;
    }

    public Class<? extends SocketResponsedMessage> getResponsedClass() {
        return this.mResponsedClass;
    }

    public void setResponsedClass(Class<? extends SocketResponsedMessage> cls) {
        this.mResponsedClass = cls;
    }

    public boolean bF() {
        return this.ft;
    }

    public void k(boolean z) {
        this.ft = z;
    }

    public DupLicateMode bG() {
        return this.fu;
    }

    public void a(DupLicateMode dupLicateMode) {
        this.fu = dupLicateMode;
    }
}
