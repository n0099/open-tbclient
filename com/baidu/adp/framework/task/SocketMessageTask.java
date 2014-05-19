package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public class SocketMessageTask extends MessageTask {
    private boolean a;
    private boolean b;
    private boolean c;
    private boolean d;
    private DupLicateMode e;
    private Class<? extends SocketResponsedMessage> f;

    /* loaded from: classes.dex */
    public enum DupLicateMode {
        NONE,
        REMOVE_ME,
        REMOVE_WAITING,
        REMOVE_ALL;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
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
        this.a = false;
        this.b = false;
        this.c = false;
        this.d = true;
        this.e = DupLicateMode.NONE;
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.c(this.mCmd);
    }

    public void a(boolean z) {
        this.a = z;
    }

    public boolean a() {
        return this.a;
    }

    public boolean b() {
        return this.b;
    }

    public void b(boolean z) {
        this.b = z;
    }

    public Class<? extends SocketResponsedMessage> c() {
        return this.f;
    }

    public void a(Class<? extends SocketResponsedMessage> cls) {
        this.f = cls;
    }

    public boolean d() {
        return this.c;
    }

    public void c(boolean z) {
        this.c = z;
    }

    public DupLicateMode e() {
        return this.e;
    }

    public void a(DupLicateMode dupLicateMode) {
        this.e = dupLicateMode;
    }

    public boolean f() {
        return this.d;
    }

    public void d(boolean z) {
        this.d = z;
    }
}
