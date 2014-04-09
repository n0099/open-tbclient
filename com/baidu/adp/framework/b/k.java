package com.baidu.adp.framework.b;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import java.util.LinkedList;
/* loaded from: classes.dex */
public final class k {
    private final LinkedList<f> a = new LinkedList<>();
    private final LinkedList<n> b = new LinkedList<>();
    private final LinkedList<c> c = new LinkedList<>();
    private final LinkedList<e> d = new LinkedList<>();
    private final LinkedList<m> e = new LinkedList<>();
    private final LinkedList<b> f = new LinkedList<>();
    private final LinkedList<d> g = new LinkedList<>();
    private final LinkedList<l> h = new LinkedList<>();
    private final LinkedList<a> i = new LinkedList<>();

    public final void a(h<?, ?> hVar) {
        if (hVar != null) {
            com.baidu.adp.lib.util.i.b();
            if (hVar instanceof f) {
                FrameHelper.a(this.a, (f) hVar);
            } else if (hVar instanceof n) {
                FrameHelper.a(this.b, (n) hVar);
            } else if (hVar instanceof c) {
                FrameHelper.a(this.c, (c) hVar);
            } else {
                com.baidu.adp.lib.util.f.b("rule invalid");
            }
        }
    }

    public final void a(g<?> gVar) {
        if (gVar != null) {
            com.baidu.adp.lib.util.i.b();
            if (gVar instanceof d) {
                FrameHelper.a(this.g, (d) gVar);
            } else if (gVar instanceof l) {
                FrameHelper.a(this.h, (l) gVar);
            } else if (gVar instanceof a) {
                FrameHelper.a(this.i, (a) gVar);
            } else {
                com.baidu.adp.lib.util.f.b("rule invalid");
            }
        }
    }

    public final void a(i<?> iVar) {
        if (iVar != null) {
            com.baidu.adp.lib.util.i.b();
            if (iVar instanceof e) {
                FrameHelper.a(this.d, (e) iVar);
            } else if (iVar instanceof m) {
                FrameHelper.a(this.e, (m) iVar);
            } else if (iVar instanceof b) {
                FrameHelper.a(this.f, (b) iVar);
            } else {
                com.baidu.adp.lib.util.f.b("rule invalid");
            }
        }
    }

    public final HttpMessage a(HttpMessage httpMessage) {
        return (HttpMessage) a(this.g, httpMessage);
    }

    public final com.baidu.adp.framework.message.g a(com.baidu.adp.framework.message.g gVar) {
        return (com.baidu.adp.framework.message.g) a(this.h, gVar);
    }

    public final com.baidu.adp.framework.message.a<?> a(com.baidu.adp.framework.message.a aVar) {
        return (com.baidu.adp.framework.message.a) a(this.i, aVar);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:25:0x002b */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [com.baidu.adp.framework.message.d] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v9 */
    private static <M extends com.baidu.adp.framework.message.d<?>, T extends com.baidu.adp.framework.task.b, R extends g<M>> M a(LinkedList<R> linkedList, M m) {
        ?? r0;
        if (linkedList == null) {
            return null;
        }
        int size = linkedList.size();
        int i = 0;
        M m2 = m;
        while (i < size && m2 != null) {
            try {
                R r = linkedList.get(i);
                r0 = (m2 == null || !(r.b() == 0 || r.b() == m2.e())) ? m2 : r.a(m2);
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("rule error = " + e.getMessage());
                r0 = m2;
            }
            i++;
            m2 = r0;
        }
        return m2;
    }

    public final HttpMessage a(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        return (HttpMessage) a(this.a, httpMessage, httpMessageTask);
    }

    public final com.baidu.adp.framework.message.g a(com.baidu.adp.framework.message.g gVar, SocketMessageTask socketMessageTask) {
        return (com.baidu.adp.framework.message.g) a(this.b, gVar, socketMessageTask);
    }

    public final com.baidu.adp.framework.message.a<?> a(com.baidu.adp.framework.message.a aVar, CustomMessageTask customMessageTask) {
        return (com.baidu.adp.framework.message.a) a(this.c, aVar, customMessageTask);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:25:0x002b */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [com.baidu.adp.framework.message.d] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v9 */
    private static <M extends com.baidu.adp.framework.message.d<?>, T extends com.baidu.adp.framework.task.b, R extends h<M, T>> M a(LinkedList<R> linkedList, M m, T t) {
        ?? r0;
        if (linkedList == null) {
            return null;
        }
        int size = linkedList.size();
        int i = 0;
        M m2 = m;
        while (i < size && m2 != null) {
            try {
                R r = linkedList.get(i);
                r0 = (m2 == null || !(r.b() == 0 || r.b() == m2.e())) ? m2 : r.a(m2, t);
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("rule error = " + e.getMessage());
                r0 = m2;
            }
            i++;
            m2 = r0;
        }
        return m2;
    }

    public final HttpResponsedMessage a(HttpResponsedMessage httpResponsedMessage) {
        return (HttpResponsedMessage) a(this.d, httpResponsedMessage);
    }

    public final SocketResponsedMessage a(SocketResponsedMessage socketResponsedMessage) {
        return (SocketResponsedMessage) a(this.e, socketResponsedMessage);
    }

    public final CustomResponsedMessage<?> a(CustomResponsedMessage customResponsedMessage) {
        return (CustomResponsedMessage) a(this.f, customResponsedMessage);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:25:0x002b */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [com.baidu.adp.framework.message.f] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v9 */
    private static <M extends com.baidu.adp.framework.message.f<?>, R extends i<M>> M a(LinkedList<R> linkedList, M m) {
        ?? r0;
        if (linkedList == null) {
            return null;
        }
        int size = linkedList.size();
        int i = 0;
        M m2 = m;
        while (i < size && m2 != null) {
            try {
                R r = linkedList.get(i);
                r0 = (m2 == null || !(r.b() == 0 || r.b() == m2.g())) ? m2 : r.a(m2);
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("rule error = " + e.getMessage());
                r0 = m2;
            }
            i++;
            m2 = r0;
        }
        return m2;
    }
}
