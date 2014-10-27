package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public class SocketMessageTask extends MessageTask {
    private boolean dj;
    private boolean dk;
    private boolean dl;
    private DupLicateMode dm;
    private Class<? extends SocketResponsedMessage> mResponsedClass;

    /* loaded from: classes.dex */
    public enum DupLicateMode {
        NONE,
        REMOVE_ME,
        REMOVE_WAITING,
        REMOVE_ALL;

        /* JADX DEBUG: Replace access to removed values field (dn) with 'values()' method */
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
        this.dj = false;
        this.dk = false;
        this.dl = true;
        this.dm = DupLicateMode.NONE;
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.f(this.mCmd);
    }

    public void e(boolean z) {
        this.dj = z;
    }

    public boolean be() {
        return this.dj;
    }

    public boolean bf() {
        return this.dk;
    }

    public void f(boolean z) {
        this.dk = z;
    }

    public Class<? extends SocketResponsedMessage> getResponsedClass() {
        return this.mResponsedClass;
    }

    public void setResponsedClass(Class<? extends SocketResponsedMessage> cls) {
        this.mResponsedClass = cls;
    }

    public boolean bg() {
        return this.dl;
    }

    public void g(boolean z) {
        this.dl = z;
    }

    public DupLicateMode bh() {
        return this.dm;
    }

    public void a(DupLicateMode dupLicateMode) {
        this.dm = dupLicateMode;
    }
}
