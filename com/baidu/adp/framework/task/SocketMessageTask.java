package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public class SocketMessageTask extends MessageTask {
    private boolean jE;
    private boolean jF;
    private boolean jG;
    private DupLicateMode jH;
    private Class<? extends SocketResponsedMessage> mResponsedClass;

    /* loaded from: classes.dex */
    public enum DupLicateMode {
        NONE,
        REMOVE_ME,
        REMOVE_WAITING,
        REMOVE_ALL;

        /* JADX DEBUG: Replace access to removed values field (jI) with 'values()' method */
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
        this.jE = false;
        this.jF = false;
        this.jG = true;
        this.jH = DupLicateMode.NONE;
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.L(this.mCmd);
    }

    public void l(boolean z) {
        this.jE = z;
    }

    public boolean cq() {
        return this.jE;
    }

    public boolean cr() {
        return this.jF;
    }

    public void m(boolean z) {
        this.jF = z;
    }

    public Class<? extends SocketResponsedMessage> getResponsedClass() {
        return this.mResponsedClass;
    }

    public void setResponsedClass(Class<? extends SocketResponsedMessage> cls) {
        this.mResponsedClass = cls;
    }

    public boolean cs() {
        return this.jG;
    }

    public void n(boolean z) {
        this.jG = z;
    }

    public DupLicateMode ct() {
        return this.jH;
    }

    public void a(DupLicateMode dupLicateMode) {
        this.jH = dupLicateMode;
    }
}
