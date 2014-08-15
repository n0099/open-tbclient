package com.baidu.adp.framework.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.framework.task.MessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.util.BdLog;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class i {
    private final LinkedList<d> a = new LinkedList<>();
    private final LinkedList<k> b = new LinkedList<>();
    private final LinkedList<b> c = new LinkedList<>();
    private final LinkedList<c> d = new LinkedList<>();
    private final LinkedList<j> e = new LinkedList<>();
    private final LinkedList<a> f = new LinkedList<>();
    private final LinkedList<e> g = new LinkedList<>();

    public void a(f<?, ?> fVar) {
        if (fVar != null) {
            com.baidu.adp.lib.util.j.a();
            if (fVar instanceof d) {
                FrameHelper.a(this.a, (d) fVar);
            } else if (fVar instanceof k) {
                FrameHelper.a(this.b, (k) fVar);
            } else if (fVar instanceof b) {
                FrameHelper.a(this.c, (b) fVar);
            } else {
                BdLog.e("rule invalid");
            }
        }
    }

    public void b(f<?, ?> fVar) {
        if (fVar != null) {
            com.baidu.adp.lib.util.j.a();
            if (fVar instanceof d) {
                this.a.remove(fVar);
            } else if (fVar instanceof k) {
                this.b.remove(fVar);
            } else if (fVar instanceof b) {
                this.c.remove(fVar);
            } else {
                BdLog.e("rule invalid");
            }
        }
    }

    public void a(g<?> gVar) {
        if (gVar != null) {
            com.baidu.adp.lib.util.j.a();
            if (gVar instanceof c) {
                FrameHelper.a(this.d, (c) gVar);
            } else if (gVar instanceof j) {
                FrameHelper.a(this.e, (j) gVar);
            } else if (gVar instanceof a) {
                FrameHelper.a(this.f, (a) gVar);
            } else {
                BdLog.e("rule invalid");
            }
        }
    }

    public void b(g<?> gVar) {
        if (gVar != null) {
            com.baidu.adp.lib.util.j.a();
            if (gVar instanceof c) {
                this.d.remove(gVar);
            } else if (gVar instanceof j) {
                this.e.remove(gVar);
            } else if (gVar instanceof a) {
                this.f.remove(gVar);
            } else {
                BdLog.e("rule invalid");
            }
        }
    }

    public HttpMessage a(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        return (HttpMessage) a(this.a, httpMessage, httpMessageTask);
    }

    public SocketMessage a(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        return (SocketMessage) a(this.b, socketMessage, socketMessageTask);
    }

    public CustomMessage<?> a(CustomMessage customMessage, CustomMessageTask customMessageTask) {
        return (CustomMessage) a(this.c, customMessage, customMessageTask);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:17:0x0019 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.baidu.adp.framework.message.Message] */
    private <M extends Message<?>, T extends MessageTask, R extends f<M, T>> M a(LinkedList<R> linkedList, M m, T t) {
        ?? r0;
        if (linkedList == null) {
            return null;
        }
        int size = linkedList.size();
        int i = 0;
        M m2 = m;
        while (i < size && m2 != null) {
            try {
                r0 = linkedList.get(i).b(m2, t);
            } catch (Exception e) {
                BdLog.e(e);
                r0 = m2;
            }
            i++;
            m2 = r0;
        }
        return m2;
    }

    public HttpResponsedMessage a(HttpResponsedMessage httpResponsedMessage) {
        return (HttpResponsedMessage) a(this.d, (LinkedList<c>) httpResponsedMessage);
    }

    public SocketResponsedMessage a(SocketResponsedMessage socketResponsedMessage) {
        return (SocketResponsedMessage) a(this.e, (LinkedList<j>) socketResponsedMessage);
    }

    public CustomResponsedMessage<?> a(CustomResponsedMessage customResponsedMessage) {
        return (CustomResponsedMessage) a(this.f, (LinkedList<a>) customResponsedMessage);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:17:0x0019 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v9, types: [com.baidu.adp.framework.message.ResponsedMessage] */
    private <M extends ResponsedMessage<?>, R extends g<M>> M a(LinkedList<R> linkedList, M m) {
        ?? r0;
        if (linkedList == null) {
            return null;
        }
        int size = linkedList.size();
        int i = 0;
        M m2 = m;
        while (i < size && m2 != null) {
            try {
                r0 = linkedList.get(i).b(m2);
            } catch (Exception e) {
                BdLog.e("rule error = " + e.getMessage());
                r0 = m2;
            }
            i++;
            m2 = r0;
        }
        return m2;
    }

    public void a(e eVar) {
        this.g.add(eVar);
    }

    public void b(e eVar) {
        this.g.remove(eVar);
    }

    public void a(int i, BdUniqueId bdUniqueId) {
        int size = this.g.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.g.get(i2).a(i, bdUniqueId);
        }
    }

    public void a(BdUniqueId bdUniqueId) {
        int size = this.g.size();
        for (int i = 0; i < size; i++) {
            this.g.get(i).a(bdUniqueId);
        }
    }
}
