package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
/* loaded from: classes.dex */
public final class CustomMessageTask extends b {
    private a<?> e;
    private TASK_TYPE f;
    private boolean g;

    /* loaded from: classes.dex */
    public enum TASK_TYPE {
        SYNCHRONIZED,
        ASYNCHRONIZED;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static TASK_TYPE[] valuesCustom() {
            TASK_TYPE[] valuesCustom = values();
            int length = valuesCustom.length;
            TASK_TYPE[] task_typeArr = new TASK_TYPE[length];
            System.arraycopy(valuesCustom, 0, task_typeArr, 0, length);
            return task_typeArr;
        }
    }

    public CustomMessageTask(int i, a<?> aVar) {
        super(i);
        this.e = null;
        this.f = TASK_TYPE.ASYNCHRONIZED;
        this.g = false;
        this.e = aVar;
    }

    public final a<?> a() {
        return this.e;
    }

    @Override // com.baidu.adp.framework.task.b
    public final boolean b() {
        return FrameHelper.d(this.a);
    }

    public final TASK_TYPE c() {
        return this.f;
    }

    public final void a(TASK_TYPE task_type) {
        this.f = task_type;
    }

    public final boolean d() {
        return this.g;
    }
}
