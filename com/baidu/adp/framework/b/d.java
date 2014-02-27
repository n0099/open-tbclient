package com.baidu.adp.framework.b;

import com.baidu.adp.framework.controller.CustomResponsedRule;
import com.baidu.adp.framework.controller.CustomRule;
import com.baidu.adp.framework.controller.HttpResponsedRule;
import com.baidu.adp.framework.controller.HttpRule;
import com.baidu.adp.framework.controller.SocketResponsedRule;
import com.baidu.adp.framework.controller.SocketRule;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.e;
import com.baidu.adp.framework.message.f;
import com.baidu.adp.framework.message.g;
import com.baidu.adp.framework.message.h;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.framework.task.HttpMessageTask;
import java.util.LinkedList;
/* loaded from: classes.dex */
public final class d {
    private final LinkedList<HttpRule> a = new LinkedList<>();
    private final LinkedList<SocketRule> b = new LinkedList<>();
    private final LinkedList<CustomRule> c = new LinkedList<>();
    private final LinkedList<HttpResponsedRule> d = new LinkedList<>();
    private final LinkedList<SocketResponsedRule> e = new LinkedList<>();
    private final LinkedList<CustomResponsedRule> f = new LinkedList<>();

    public final HttpMessage a(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        return (HttpMessage) a(this.a, httpMessage, httpMessageTask);
    }

    public final g a(g gVar, com.baidu.adp.framework.task.c cVar) {
        return (g) a(this.b, gVar, cVar);
    }

    public final com.baidu.adp.framework.message.a<?> a(com.baidu.adp.framework.message.a aVar, CustomMessageTask customMessageTask) {
        return (com.baidu.adp.framework.message.a) a(this.c, aVar, customMessageTask);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:25:0x002b */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [com.baidu.adp.framework.message.e] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v9 */
    private static <M extends e<?>, T extends com.baidu.adp.framework.task.b, R extends a<M, T>> M a(LinkedList<R> linkedList, M m, T t) {
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
                r0 = (m2 == null || !(r.c() == 0 || r.c() == m2.d())) ? m2 : r.b();
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b("rule error = " + e.getMessage());
                r0 = m2;
            }
            i++;
            m2 = r0;
        }
        return m2;
    }

    public final com.baidu.adp.framework.message.c a(com.baidu.adp.framework.message.c cVar) {
        return (com.baidu.adp.framework.message.c) a(this.d, cVar);
    }

    public final h a(h hVar) {
        return (h) a(this.e, hVar);
    }

    public final com.baidu.adp.framework.message.b<?> a(com.baidu.adp.framework.message.b bVar) {
        return (com.baidu.adp.framework.message.b) a(this.f, bVar);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:25:0x002b */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [com.baidu.adp.framework.message.f] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v9 */
    private static <M extends f<?>, R extends b<M>> M a(LinkedList<R> linkedList, M m) {
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
                r0 = (m2 == null || !(r.c() == 0 || r.c() == m2.b())) ? m2 : r.b();
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b("rule error = " + e.getMessage());
                r0 = m2;
            }
            i++;
            m2 = r0;
        }
        return m2;
    }
}
