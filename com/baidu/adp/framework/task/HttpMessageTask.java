package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.e.f;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallelType;
/* loaded from: classes.dex */
public class HttpMessageTask extends b {
    private f e;
    private Class<? extends HttpResponsedMessage> f;
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

    public HttpMessageTask(int i, String str) {
        super(i);
        this.e = null;
        this.g = null;
        this.h = HTTP_METHOD.POST;
        this.i = true;
        this.j = false;
        this.k = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.g = str;
        this.d = 1;
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

    public final void a(boolean z) {
        this.i = true;
    }

    public final boolean e() {
        return this.j;
    }

    public final Class<? extends HttpResponsedMessage> f() {
        return this.f;
    }

    public final void a(Class<? extends HttpResponsedMessage> cls) {
        this.f = cls;
    }

    @Override // com.baidu.adp.framework.task.b
    public final boolean b() {
        return FrameHelper.c(this.a) || FrameHelper.b(this.a);
    }

    public final f g() {
        return this.e;
    }

    public final void a(f fVar) {
        this.e = fVar;
    }

    public final BdAsyncTaskParallelType h() {
        return this.k;
    }
}
