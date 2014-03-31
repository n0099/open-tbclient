package com.baidu.adp.framework.b;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.controller.CustomRemovedRule;
import com.baidu.adp.framework.controller.HttpRemovedRule;
import com.baidu.adp.framework.controller.SocketRemovedRule;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.framework.task.HttpMessageTask;
import java.util.LinkedList;
/* loaded from: classes.dex */
public final class i {
    private final LinkedList<d> a = new LinkedList<>();
    private final LinkedList<k> b = new LinkedList<>();
    private final LinkedList<b> c = new LinkedList<>();
    private final LinkedList<c> d = new LinkedList<>();
    private final LinkedList<j> e = new LinkedList<>();
    private final LinkedList<a> f = new LinkedList<>();
    private final LinkedList<HttpRemovedRule> g = new LinkedList<>();
    private final LinkedList<SocketRemovedRule> h = new LinkedList<>();
    private final LinkedList<CustomRemovedRule> i = new LinkedList<>();

    public final void a(f<?, ?> fVar) {
        if (fVar != null) {
            com.baidu.adp.lib.util.i.b();
            if (fVar instanceof d) {
                FrameHelper.a(this.a, (d) fVar);
            } else if (fVar instanceof k) {
                FrameHelper.a(this.b, (k) fVar);
            } else if (fVar instanceof b) {
                FrameHelper.a(this.c, (b) fVar);
            } else {
                com.baidu.adp.lib.util.f.b("rule invalid");
            }
        }
    }

    public final void a(g<?> gVar) {
        if (gVar != null) {
            com.baidu.adp.lib.util.i.b();
            if (gVar instanceof c) {
                FrameHelper.a(this.d, (c) gVar);
            } else if (gVar instanceof j) {
                FrameHelper.a(this.e, (j) gVar);
            } else if (gVar instanceof a) {
                FrameHelper.a(this.f, (a) gVar);
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
    private static <M extends com.baidu.adp.framework.message.d<?>, T extends com.baidu.adp.framework.task.b, R extends e<M>> M a(LinkedList<R> linkedList, M m) {
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
                r0 = (m2 == null || !(r.c() == 0 || r.c() == m2.e())) ? m2 : r.b();
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

    public final com.baidu.adp.framework.message.g a(com.baidu.adp.framework.message.g gVar, com.baidu.adp.framework.task.c cVar) {
        return (com.baidu.adp.framework.message.g) a(this.b, gVar, cVar);
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
    private static <M extends com.baidu.adp.framework.message.d<?>, T extends com.baidu.adp.framework.task.b, R extends f<M, T>> M a(LinkedList<R> linkedList, M m, T t) {
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
                r0 = (m2 == null || !(r.c() == 0 || r.c() == m2.e())) ? m2 : r.a(m2, t);
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
    private static <M extends com.baidu.adp.framework.message.f<?>, R extends g<M>> M a(LinkedList<R> linkedList, M m) {
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
                r0 = (m2 == null || !(r.c() == 0 || r.c() == m2.g())) ? m2 : r.a(m2);
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
