package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public class SocketMessageTask extends MessageTask {
    private boolean fp;
    private boolean fq;
    private boolean fr;
    private DupLicateMode fs;
    private Class<? extends SocketResponsedMessage> mResponsedClass;

    /* loaded from: classes.dex */
    public enum DupLicateMode {
        NONE,
        REMOVE_ME,
        REMOVE_WAITING,
        REMOVE_ALL;

        /* JADX DEBUG: Replace access to removed values field (ft) with 'values()' method */
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
        this.fp = false;
        this.fq = false;
        this.fr = true;
        this.fs = DupLicateMode.NONE;
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.r(this.mCmd);
    }

    public void i(boolean z) {
        this.fp = z;
    }

    public boolean bF() {
        return this.fp;
    }

    public boolean bG() {
        return this.fq;
    }

    public void j(boolean z) {
        this.fq = z;
    }

    public Class<? extends SocketResponsedMessage> getResponsedClass() {
        return this.mResponsedClass;
    }

    public void setResponsedClass(Class<? extends SocketResponsedMessage> cls) {
        this.mResponsedClass = cls;
    }

    public boolean bH() {
        return this.fr;
    }

    public void k(boolean z) {
        this.fr = z;
    }

    public DupLicateMode bI() {
        return this.fs;
    }

    public void a(DupLicateMode dupLicateMode) {
        this.fs = dupLicateMode;
    }
}
