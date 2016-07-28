package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public class SocketMessageTask extends MessageTask {
    private boolean hs;
    private boolean ht;
    private boolean hu;
    private DupLicateMode hv;
    private Class<? extends SocketResponsedMessage> mResponsedClass;

    /* loaded from: classes.dex */
    public enum DupLicateMode {
        NONE,
        REMOVE_ME,
        REMOVE_WAITING,
        REMOVE_ALL;

        /* JADX DEBUG: Replace access to removed values field (hw) with 'values()' method */
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
        this.hs = false;
        this.ht = false;
        this.hu = true;
        this.hv = DupLicateMode.NONE;
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.x(this.mCmd);
    }

    public void j(boolean z) {
        this.hs = z;
    }

    public boolean bx() {
        return this.hs;
    }

    public boolean by() {
        return this.ht;
    }

    public void k(boolean z) {
        this.ht = z;
    }

    public Class<? extends SocketResponsedMessage> getResponsedClass() {
        return this.mResponsedClass;
    }

    public void setResponsedClass(Class<? extends SocketResponsedMessage> cls) {
        this.mResponsedClass = cls;
    }

    public boolean bz() {
        return this.hu;
    }

    public void l(boolean z) {
        this.hu = z;
    }

    public DupLicateMode bA() {
        return this.hv;
    }

    public void a(DupLicateMode dupLicateMode) {
        this.hv = dupLicateMode;
    }
}
