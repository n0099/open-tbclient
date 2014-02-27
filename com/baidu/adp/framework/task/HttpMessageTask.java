package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.e.e;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallelType;
/* loaded from: classes.dex */
public final class HttpMessageTask extends b {
    private e e;
    private Class<? extends com.baidu.adp.framework.message.c> f;
    private String g;
    private HTTP_METHOD h;
    private boolean i;
    private boolean j;
    private BdAsyncTaskParallelType k;

    /* loaded from: classes.dex */
    public enum HTTP_METHOD {
        GET,
        POST;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static HTTP_METHOD[] valuesCustom() {
            HTTP_METHOD[] valuesCustom = values();
            int length = valuesCustom.length;
            HTTP_METHOD[] http_methodArr = new HTTP_METHOD[length];
            System.arraycopy(valuesCustom, 0, http_methodArr, 0, length);
            return http_methodArr;
        }
    }

    public final String a() {
        return this.g;
    }

    public final HTTP_METHOD c() {
        return this.h;
    }

    public final boolean d() {
        return this.i;
    }

    public final boolean e() {
        return this.j;
    }

    public final Class<? extends com.baidu.adp.framework.message.c> f() {
        return this.f;
    }

    @Override // com.baidu.adp.framework.task.b
    public final boolean b() {
        return FrameHelper.b(this.a);
    }

    public final e g() {
        return this.e;
    }

    public final void a(e eVar) {
        this.e = eVar;
    }

    public final BdAsyncTaskParallelType h() {
        return this.k;
    }
}
