package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public class SocketMessageTask extends MessageTask {
    private Class<? extends SocketResponsedMessage> mResponsedClass;
    private boolean qT;
    private boolean qU;
    private boolean qV;
    private DupLicateMode qW;

    /* loaded from: classes.dex */
    public enum DupLicateMode {
        NONE,
        REMOVE_ME,
        REMOVE_WAITING,
        REMOVE_ALL;

        /* JADX DEBUG: Replace access to removed values field (qX) with 'values()' method */
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
        this.qT = false;
        this.qU = false;
        this.qV = true;
        this.qW = DupLicateMode.NONE;
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.G(this.mCmd);
    }

    public void i(boolean z) {
        this.qT = z;
    }

    public boolean fh() {
        return this.qT;
    }

    public boolean fj() {
        return this.qU;
    }

    public void j(boolean z) {
        this.qU = z;
    }

    public Class<? extends SocketResponsedMessage> getResponsedClass() {
        return this.mResponsedClass;
    }

    public void setResponsedClass(Class<? extends SocketResponsedMessage> cls) {
        this.mResponsedClass = cls;
    }

    public boolean fk() {
        return this.qV;
    }

    public void k(boolean z) {
        this.qV = z;
    }

    public DupLicateMode fl() {
        return this.qW;
    }

    public void a(DupLicateMode dupLicateMode) {
        this.qW = dupLicateMode;
    }
}
