package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public class SocketMessageTask extends MessageTask {
    private Class<? extends SocketResponsedMessage> mResponsedClass;
    private boolean qP;
    private boolean qQ;
    private boolean qR;
    private DupLicateMode qS;

    /* loaded from: classes.dex */
    public enum DupLicateMode {
        NONE,
        REMOVE_ME,
        REMOVE_WAITING,
        REMOVE_ALL;

        /* JADX DEBUG: Replace access to removed values field (qT) with 'values()' method */
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
        this.qP = false;
        this.qQ = false;
        this.qR = true;
        this.qS = DupLicateMode.NONE;
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.t(this.mCmd);
    }

    public void i(boolean z) {
        this.qP = z;
    }

    public boolean fg() {
        return this.qP;
    }

    public boolean fh() {
        return this.qQ;
    }

    public void j(boolean z) {
        this.qQ = z;
    }

    public Class<? extends SocketResponsedMessage> getResponsedClass() {
        return this.mResponsedClass;
    }

    public void setResponsedClass(Class<? extends SocketResponsedMessage> cls) {
        this.mResponsedClass = cls;
    }

    public boolean fi() {
        return this.qR;
    }

    public void k(boolean z) {
        this.qR = z;
    }

    public DupLicateMode fj() {
        return this.qS;
    }

    public void a(DupLicateMode dupLicateMode) {
        this.qS = dupLicateMode;
    }
}
