package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public class SocketMessageTask extends b {
    private boolean e;
    private boolean f;
    private boolean g;
    private DupLicateMode h;
    private Class<? extends SocketResponsedMessage> i;

    /* loaded from: classes.dex */
    public enum DupLicateMode {
        NONE,
        REMOVE_ME,
        REMOVE_WAITING;

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
        this.e = false;
        this.f = false;
        this.g = false;
        this.h = DupLicateMode.NONE;
    }

    @Override // com.baidu.adp.framework.task.b
    public final boolean b() {
        return FrameHelper.c(this.a) || FrameHelper.b(this.a);
    }

    public final void a(boolean z) {
        this.e = true;
    }

    public final boolean a() {
        return this.e;
    }

    public final boolean c() {
        return this.f;
    }

    public final void b(boolean z) {
        this.f = z;
    }

    public final Class<? extends SocketResponsedMessage> d() {
        return this.i;
    }

    public final void a(Class<? extends SocketResponsedMessage> cls) {
        this.i = cls;
    }

    public final boolean e() {
        return this.g;
    }

    public final void c(boolean z) {
        this.g = true;
    }

    public final DupLicateMode f() {
        return this.h;
    }

    public final void a(DupLicateMode dupLicateMode) {
        this.h = dupLicateMode;
    }
}
