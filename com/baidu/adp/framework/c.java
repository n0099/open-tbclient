package com.baidu.adp.framework;

import android.os.Handler;
import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.b.i;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.message.g;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.framework.task.HttpMessageTask;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class c {
    private static c a = null;
    private com.baidu.adp.framework.d.b b;
    private com.baidu.adp.framework.d.d c;
    private com.baidu.adp.framework.d.a d;
    private i e;
    private Handler f;

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
        this.f = null;
        this.b = new com.baidu.adp.framework.d.b(this);
        this.c = new com.baidu.adp.framework.d.d(this);
        this.d = new com.baidu.adp.framework.d.a(this);
        this.e = new i();
        this.f = new Handler();
    }

    private com.baidu.adp.framework.d.c<?, ?, ?, ?> g(int i) {
        FrameHelper.TYPE a2 = FrameHelper.a(i);
        if (a2 == FrameHelper.TYPE.HTTP) {
            return this.b;
        }
        if (a2 == FrameHelper.TYPE.SOCKET) {
            return this.c;
        }
        if (a2 == FrameHelper.TYPE.CUSTOM) {
            return this.d;
        }
        com.baidu.adp.lib.util.f.b("cmd invalid");
        return null;
    }

    public final boolean a(com.baidu.adp.framework.message.d<?> dVar) {
        if (dVar == null) {
            return false;
        }
        if (dVar instanceof HttpMessage) {
            com.baidu.adp.lib.debug.a.a("Request_Http", dVar);
            return this.b.c((HttpMessage) dVar, null);
        } else if (dVar instanceof g) {
            com.baidu.adp.lib.debug.a.a("Request_Socket", dVar);
            return this.c.c((g) dVar, null);
        } else if (dVar instanceof com.baidu.adp.framework.message.a) {
            return this.d.c((com.baidu.adp.framework.message.a) dVar, null);
        } else {
            com.baidu.adp.lib.util.f.b("message invalid" + dVar.e());
            return false;
        }
    }

    public final boolean a(com.baidu.adp.framework.message.e eVar) {
        if (eVar == null) {
            return false;
        }
        if (this.c.a()) {
            com.baidu.adp.lib.debug.a.a("Request_Socket", eVar);
            if (this.c.c(eVar.b(), null)) {
                return true;
            }
        }
        com.baidu.adp.lib.debug.a.a("Request_Http", eVar);
        return this.b.c(eVar.a(), null);
    }

    /* JADX DEBUG: Type inference failed for r0v3. Raw type applied. Possible types: java.util.LinkedList<M>, java.util.LinkedList<? extends com.baidu.adp.framework.message.d> */
    public final LinkedList<? extends com.baidu.adp.framework.message.d> a(int i, int i2) {
        com.baidu.adp.framework.d.c<?, ?, ?, ?> g = g(i);
        if (g != null) {
            return g.b(i, i2);
        }
        com.baidu.adp.lib.util.f.b("cmd invalid");
        return null;
    }

    public final void b(int i, int i2) {
        com.baidu.adp.framework.d.c<?, ?, ?, ?> g = g(i);
        if (g != null) {
            a((LinkedList<?>) g.a(i, i2));
        } else {
            com.baidu.adp.lib.util.f.b("cmd invalid");
        }
    }

    public final void a(int i) {
        a(this.d.a(i));
    }

    public final void b(int i) {
        a(this.b.a(i));
    }

    public final void c(int i) {
        a(this.c.a(i));
        a(i);
        b(i);
    }

    private void a(LinkedList<?> linkedList) {
        if (linkedList != null) {
            Iterator<?> it = linkedList.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next != null && (next instanceof com.baidu.adp.framework.message.d)) {
                    if (next instanceof HttpMessage) {
                        com.baidu.adp.lib.debug.a.a("Remove_Http", next);
                        this.e.a((HttpMessage) next);
                    } else if (next instanceof g) {
                        com.baidu.adp.lib.debug.a.a("Remove_Socket", next);
                        this.e.a((g) next);
                    } else if (next instanceof com.baidu.adp.framework.message.a) {
                        com.baidu.adp.lib.debug.a.a("Remove_Custom", next);
                        this.e.a((com.baidu.adp.framework.message.a) next);
                    } else {
                        com.baidu.adp.lib.util.f.b("message invalid" + ((com.baidu.adp.framework.message.d) next).e());
                    }
                }
            }
        }
    }

    public final void a(com.baidu.adp.framework.task.b bVar) {
        if (bVar != null) {
            com.baidu.adp.lib.util.i.b();
            if (bVar instanceof HttpMessageTask) {
                this.b.a((com.baidu.adp.framework.d.b) ((HttpMessageTask) bVar));
            } else if (bVar instanceof com.baidu.adp.framework.task.c) {
                this.c.a((com.baidu.adp.framework.d.d) ((com.baidu.adp.framework.task.c) bVar));
            } else if (bVar instanceof CustomMessageTask) {
                this.d.a((com.baidu.adp.framework.d.a) ((CustomMessageTask) bVar));
            } else {
                com.baidu.adp.lib.util.f.b("task invalid");
            }
        }
    }

    public final com.baidu.adp.framework.task.b d(int i) {
        FrameHelper.TYPE a2 = FrameHelper.a(i);
        if (FrameHelper.TYPE.HTTP == a2) {
            return this.b.c(i);
        }
        if (FrameHelper.TYPE.SOCKET == a2) {
            return this.c.c(i);
        }
        if (FrameHelper.TYPE.CUSTOM != a2) {
            return null;
        }
        return this.d.c(i);
    }

    public final void e(int i) {
        com.baidu.adp.lib.util.i.b();
        com.baidu.adp.framework.d.c<?, ?, ?, ?> g = g(i);
        if (g != null) {
            g.b(i);
        }
    }

    public final void a(com.baidu.adp.framework.c.d dVar) {
        if (dVar != null) {
            this.b.a(0, dVar.a());
            this.c.a(0, dVar.b());
        }
    }

    public final void a(int i, com.baidu.adp.framework.c.d dVar) {
        if (dVar != null) {
            this.b.a(i, dVar.a());
            this.c.a(i, dVar.b());
        }
    }

    public final void a(com.baidu.adp.framework.c.c<?> cVar) {
        if (cVar != null) {
            com.baidu.adp.lib.util.i.b();
            FrameHelper.TYPE a2 = FrameHelper.a(cVar.b());
            if (a2 == FrameHelper.TYPE.HTTP && (cVar instanceof com.baidu.adp.framework.c.b)) {
                this.b.a(0, (com.baidu.adp.framework.c.b) cVar);
            } else if (a2 == FrameHelper.TYPE.SOCKET && (cVar instanceof com.baidu.adp.framework.c.g)) {
                this.c.a(0, (com.baidu.adp.framework.c.g) cVar);
            } else if (a2 == FrameHelper.TYPE.CUSTOM && (cVar instanceof com.baidu.adp.framework.c.a)) {
                this.d.a(0, (com.baidu.adp.framework.c.a) cVar);
            } else {
                com.baidu.adp.lib.util.f.b("listener invalid" + cVar.b());
            }
        }
    }

    public final void a(int i, com.baidu.adp.framework.c.c<?> cVar) {
        if (cVar != null) {
            com.baidu.adp.lib.util.i.b();
            FrameHelper.TYPE a2 = FrameHelper.a(i);
            if (a2 == FrameHelper.TYPE.HTTP && (cVar instanceof com.baidu.adp.framework.c.b)) {
                this.b.a(i, (com.baidu.adp.framework.c.b) cVar);
            } else if (a2 == FrameHelper.TYPE.SOCKET && (cVar instanceof com.baidu.adp.framework.c.g)) {
                this.c.a(i, (com.baidu.adp.framework.c.g) cVar);
            } else if (a2 == FrameHelper.TYPE.CUSTOM && (cVar instanceof com.baidu.adp.framework.c.a)) {
                this.d.a(i, (com.baidu.adp.framework.c.a) cVar);
            } else {
                com.baidu.adp.lib.util.f.b("listener invalid" + i + "|" + cVar.b());
            }
        }
    }

    public final void b(com.baidu.adp.framework.c.c<?> cVar) {
        com.baidu.adp.lib.util.i.b();
        if (cVar != null) {
            int b = cVar.b();
            if (b != 0) {
                com.baidu.adp.framework.d.c<?, ?, ?, ?> g = g(b);
                if (g != null) {
                    g.a((com.baidu.adp.framework.c.c) cVar);
                    return;
                }
                return;
            }
            this.b.a(cVar);
            this.c.a(cVar);
            this.d.a(cVar);
        }
    }

    public final void f(int i) {
        this.b.d(i);
        this.c.d(i);
        this.d.d(i);
    }

    public final void a(com.baidu.adp.framework.b.f<?, ?> fVar) {
        com.baidu.adp.lib.util.i.b();
        this.e.a(fVar);
    }

    public final void a(com.baidu.adp.framework.b.g<?> gVar) {
        com.baidu.adp.lib.util.i.b();
        this.e.a(gVar);
    }

    public final i b() {
        return this.e;
    }

    public final void a(com.baidu.adp.lib.network.websocket.c cVar) {
        this.c.a(cVar);
    }

    public final void a(boolean z) {
        this.c.a(z);
    }

    public final void a(com.baidu.adp.framework.message.f<?> fVar) {
        if (fVar != null) {
            int g = fVar.g();
            FrameHelper.TYPE a2 = FrameHelper.a(g);
            if (a2 == FrameHelper.TYPE.HTTP && (fVar instanceof HttpResponsedMessage)) {
                com.baidu.adp.lib.debug.a.a("Response_Http", fVar);
                this.b.a((com.baidu.adp.framework.d.b) this.e.a((HttpResponsedMessage) fVar));
            } else if (a2 == FrameHelper.TYPE.SOCKET && (fVar instanceof SocketResponsedMessage)) {
                com.baidu.adp.lib.debug.a.a("Response_Socket", fVar);
                com.baidu.adp.framework.message.d<?> h = fVar.h();
                if (fVar.e() != 0 && h != null && h.g() != null && (h.g() instanceof com.baidu.adp.framework.message.e)) {
                    com.baidu.adp.framework.message.e eVar = (com.baidu.adp.framework.message.e) h.g();
                    if (eVar.a() != null) {
                        eVar.a().b((Object) null);
                        if (a(eVar.a())) {
                            return;
                        }
                    }
                }
                this.c.a((com.baidu.adp.framework.d.d) this.e.a((SocketResponsedMessage) fVar));
            } else if (a2 == FrameHelper.TYPE.CUSTOM && (fVar instanceof CustomResponsedMessage)) {
                this.d.a((com.baidu.adp.framework.d.a) this.e.a((CustomResponsedMessage) fVar));
            } else {
                com.baidu.adp.lib.util.f.b("responsedMessage invalid:CMD=" + g + " Class=" + fVar.getClass().getName());
            }
        }
    }

    public final void b(com.baidu.adp.framework.message.f<?> fVar) {
        this.f.post(new d(this, fVar));
    }
}
