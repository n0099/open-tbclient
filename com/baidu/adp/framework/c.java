package com.baidu.adp.framework;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.f;
import com.baidu.adp.framework.message.g;
import com.baidu.adp.framework.message.h;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.util.BdUtilHelper;
/* loaded from: classes.dex */
public class c {
    private static c a = null;
    private com.baidu.adp.framework.d.b b;
    private com.baidu.adp.framework.d.d c;
    private com.baidu.adp.framework.d.a d;
    private com.baidu.adp.framework.b.d e;

    public static c a() {
        if (a == null) {
            synchronized (c.class) {
                if (a == null) {
                    a = new c();
                }
            }
        }
        return a;
    }

    private c() {
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.b = new com.baidu.adp.framework.d.b(this);
        this.c = new com.baidu.adp.framework.d.d(this);
        this.d = new com.baidu.adp.framework.d.a(this);
        this.e = new com.baidu.adp.framework.b.d();
    }

    public final boolean a(com.baidu.adp.framework.message.e<?> eVar) {
        if (eVar == null) {
            return false;
        }
        if (eVar instanceof HttpMessage) {
            return this.b.c((HttpMessage) eVar, null);
        }
        if (eVar instanceof g) {
            return this.c.c((g) eVar, null);
        }
        if (eVar instanceof com.baidu.adp.framework.message.a) {
            return this.d.c((com.baidu.adp.framework.message.a) eVar, null);
        }
        com.baidu.adp.lib.util.e.b("message invalid");
        return false;
    }

    public final void a(int i) {
        this.c.a(i);
        this.d.a(i);
        this.b.a(i);
    }

    public final void a(com.baidu.adp.framework.task.b bVar) {
        if (bVar != null) {
            BdUtilHelper.b();
            if (bVar instanceof HttpMessageTask) {
                this.b.a((com.baidu.adp.framework.d.b) ((HttpMessageTask) bVar));
            } else if (bVar instanceof com.baidu.adp.framework.task.c) {
                this.c.a((com.baidu.adp.framework.d.d) ((com.baidu.adp.framework.task.c) bVar));
            } else if (bVar instanceof CustomMessageTask) {
                this.d.a((com.baidu.adp.framework.d.a) ((CustomMessageTask) bVar));
            } else {
                com.baidu.adp.lib.util.e.b("task invalid");
            }
        }
    }

    public final com.baidu.adp.framework.task.b b(int i) {
        FrameHelper.TYPE a2 = FrameHelper.a(i);
        if (FrameHelper.TYPE.HTTP == a2) {
            return this.b.b(i);
        }
        if (FrameHelper.TYPE.SOCKET == a2) {
            return this.c.b(i);
        }
        if (FrameHelper.TYPE.CUSTOM != a2) {
            return null;
        }
        return this.d.b(i);
    }

    public final void a(com.baidu.adp.framework.c.c<?> cVar) {
        if (cVar != null) {
            BdUtilHelper.b();
            FrameHelper.TYPE a2 = FrameHelper.a(cVar.b());
            if (a2 == FrameHelper.TYPE.HTTP && (cVar instanceof com.baidu.adp.framework.c.b)) {
                this.b.a(0, (com.baidu.adp.framework.c.b) cVar);
            } else if (a2 == FrameHelper.TYPE.SOCKET && (cVar instanceof com.baidu.adp.framework.c.d)) {
                this.c.a(0, (com.baidu.adp.framework.c.d) cVar);
            } else if (a2 == FrameHelper.TYPE.CUSTOM && (cVar instanceof com.baidu.adp.framework.c.a)) {
                this.d.a(0, (com.baidu.adp.framework.c.a) cVar);
            } else {
                com.baidu.adp.lib.util.e.b("listener invalid");
            }
        }
    }

    public final void c(int i) {
        this.b.c(i);
        this.c.c(i);
        this.d.c(i);
    }

    public final com.baidu.adp.framework.b.d b() {
        return this.e;
    }

    public final void a(f<?> fVar) {
        if (fVar != null) {
            FrameHelper.TYPE a2 = FrameHelper.a(fVar.b());
            if (a2 == FrameHelper.TYPE.HTTP && (fVar instanceof com.baidu.adp.framework.message.c)) {
                this.b.a((com.baidu.adp.framework.d.b) this.e.a((com.baidu.adp.framework.message.c) fVar));
            } else if (a2 == FrameHelper.TYPE.SOCKET && (fVar instanceof h)) {
                this.c.a((com.baidu.adp.framework.d.d) this.e.a((h) fVar));
            } else if (a2 == FrameHelper.TYPE.CUSTOM && (fVar instanceof com.baidu.adp.framework.message.b)) {
                this.d.a((com.baidu.adp.framework.d.a) this.e.a((com.baidu.adp.framework.message.b) fVar));
            } else {
                com.baidu.adp.lib.util.e.b("responsedMessage invalid");
            }
        }
    }
}
