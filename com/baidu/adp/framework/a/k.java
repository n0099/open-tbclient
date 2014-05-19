package com.baidu.adp.framework.a;

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
public class k {
    private final LinkedList<f> a = new LinkedList<>();
    private final LinkedList<n> b = new LinkedList<>();
    private final LinkedList<c> c = new LinkedList<>();
    private final LinkedList<e> d = new LinkedList<>();
    private final LinkedList<m> e = new LinkedList<>();
    private final LinkedList<b> f = new LinkedList<>();
    private final LinkedList<d> g = new LinkedList<>();
    private final LinkedList<l> h = new LinkedList<>();
    private final LinkedList<a> i = new LinkedList<>();

    public void a(h<?, ?> hVar) {
        if (hVar != null) {
            com.baidu.adp.lib.util.h.b();
            if (hVar instanceof f) {
                FrameHelper.a(this.a, (f) hVar);
            } else if (hVar instanceof n) {
                FrameHelper.a(this.b, (n) hVar);
            } else if (hVar instanceof c) {
                FrameHelper.a(this.c, (c) hVar);
            } else {
                BdLog.e("rule invalid");
            }
        }
    }

    public void b(h<?, ?> hVar) {
        if (hVar != null) {
            com.baidu.adp.lib.util.h.b();
            if (hVar instanceof f) {
                this.a.remove(hVar);
            } else if (hVar instanceof n) {
                this.b.remove(hVar);
            } else if (hVar instanceof c) {
                this.c.remove(hVar);
            } else {
                BdLog.e("rule invalid");
            }
        }
    }

    public void a(g<?> gVar) {
        if (gVar != null) {
            com.baidu.adp.lib.util.h.b();
            if (gVar instanceof d) {
                FrameHelper.a(this.g, (d) gVar);
            } else if (gVar instanceof l) {
                FrameHelper.a(this.h, (l) gVar);
            } else if (gVar instanceof a) {
                FrameHelper.a(this.i, (a) gVar);
            } else {
                BdLog.e("rule invalid");
            }
        }
    }

    public void a(i<?> iVar) {
        if (iVar != null) {
            com.baidu.adp.lib.util.h.b();
            if (iVar instanceof e) {
                FrameHelper.a(this.d, (e) iVar);
            } else if (iVar instanceof m) {
                FrameHelper.a(this.e, (m) iVar);
            } else if (iVar instanceof b) {
                FrameHelper.a(this.f, (b) iVar);
            } else {
                BdLog.e("rule invalid");
            }
        }
    }

    public void b(i<?> iVar) {
        if (iVar != null) {
            com.baidu.adp.lib.util.h.b();
            if (iVar instanceof e) {
                this.d.remove(iVar);
            } else if (iVar instanceof m) {
                this.e.remove(iVar);
            } else if (iVar instanceof b) {
                this.f.remove(iVar);
            } else {
                BdLog.e("rule invalid");
            }
        }
    }

    public HttpMessage a(HttpMessage httpMessage) {
        return (HttpMessage) a(this.g, (LinkedList<d>) httpMessage);
    }

    public SocketMessage a(SocketMessage socketMessage) {
        return (SocketMessage) a(this.h, (LinkedList<l>) socketMessage);
    }

    public CustomMessage<?> a(CustomMessage customMessage) {
        return (CustomMessage) a(this.i, (LinkedList<a>) customMessage);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:17:0x0019 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v9, types: [com.baidu.adp.framework.message.Message] */
    private <M extends Message<?>, T extends MessageTask, R extends g<M>> M a(LinkedList<R> linkedList, M m) {
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
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v9, types: [com.baidu.adp.framework.message.Message] */
    private <M extends Message<?>, T extends MessageTask, R extends h<M, T>> M a(LinkedList<R> linkedList, M m, T t) {
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
                BdLog.e("rule error = " + e.getMessage());
                r0 = m2;
            }
            i++;
            m2 = r0;
        }
        return m2;
    }

    public HttpResponsedMessage a(HttpResponsedMessage httpResponsedMessage) {
        return (HttpResponsedMessage) a(this.d, (LinkedList<e>) httpResponsedMessage);
    }

    public SocketResponsedMessage a(SocketResponsedMessage socketResponsedMessage) {
        return (SocketResponsedMessage) a(this.e, (LinkedList<m>) socketResponsedMessage);
    }

    public CustomResponsedMessage<?> a(CustomResponsedMessage customResponsedMessage) {
        return (CustomResponsedMessage) a(this.f, (LinkedList<b>) customResponsedMessage);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:17:0x0019 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v9, types: [com.baidu.adp.framework.message.ResponsedMessage] */
    private <M extends ResponsedMessage<?>, R extends i<M>> M a(LinkedList<R> linkedList, M m) {
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
}
