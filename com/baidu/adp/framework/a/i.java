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
import com.baidu.adp.lib.util.l;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class i {
    private final LinkedList<d> pL = new LinkedList<>();
    private final LinkedList<k> pM = new LinkedList<>();
    private final LinkedList<b> pN = new LinkedList<>();
    private final LinkedList<c> pO = new LinkedList<>();
    private final LinkedList<j> pP = new LinkedList<>();
    private final LinkedList<a> pQ = new LinkedList<>();
    private final LinkedList<e> pR = new LinkedList<>();

    public void addMessageRule(f<?, ?> fVar) {
        if (fVar != null) {
            l.hw();
            if (fVar instanceof d) {
                FrameHelper.a(this.pL, (d) fVar);
            } else if (fVar instanceof k) {
                FrameHelper.a(this.pM, (k) fVar);
            } else if (fVar instanceof b) {
                FrameHelper.a(this.pN, (b) fVar);
            } else {
                BdLog.e("rule invalid");
            }
        }
    }

    public void removeMessageRule(f<?, ?> fVar) {
        if (fVar != null) {
            l.hw();
            if (fVar instanceof d) {
                this.pL.remove(fVar);
            } else if (fVar instanceof k) {
                this.pM.remove(fVar);
            } else if (fVar instanceof b) {
                this.pN.remove(fVar);
            } else {
                BdLog.e("rule invalid");
            }
        }
    }

    public void a(g<?> gVar) {
        if (gVar != null) {
            l.hw();
            if (gVar instanceof c) {
                FrameHelper.a(this.pO, (c) gVar);
            } else if (gVar instanceof j) {
                FrameHelper.a(this.pP, (j) gVar);
            } else if (gVar instanceof a) {
                FrameHelper.a(this.pQ, (a) gVar);
            } else {
                BdLog.e("rule invalid");
            }
        }
    }

    public void b(g<?> gVar) {
        if (gVar != null) {
            l.hw();
            if (gVar instanceof c) {
                this.pO.remove(gVar);
            } else if (gVar instanceof j) {
                this.pP.remove(gVar);
            } else if (gVar instanceof a) {
                this.pQ.remove(gVar);
            } else {
                BdLog.e("rule invalid");
            }
        }
    }

    public HttpMessage b(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        return (HttpMessage) a(this.pL, httpMessage, httpMessageTask);
    }

    public SocketMessage b(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        return (SocketMessage) a(this.pM, socketMessage, socketMessageTask);
    }

    public CustomMessage<?> b(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
        return (CustomMessage) a(this.pN, customMessage, customMessageTask);
    }

    private <M extends Message<?>, T extends MessageTask> M a(LinkedList<? extends f<M, T>> linkedList, M m, T t) {
        M m2;
        if (linkedList == null) {
            return null;
        }
        int size = linkedList.size();
        int i = 0;
        M m3 = m;
        while (i < size && m3 != null) {
            try {
                m2 = linkedList.get(i).rule(m3, t);
            } catch (Exception e) {
                BdLog.e(e);
                m2 = m3;
            }
            i++;
            m3 = m2;
        }
        return m3;
    }

    public HttpResponsedMessage a(HttpResponsedMessage httpResponsedMessage) {
        return (HttpResponsedMessage) a(this.pO, httpResponsedMessage);
    }

    public SocketResponsedMessage c(SocketResponsedMessage socketResponsedMessage) {
        return (SocketResponsedMessage) a(this.pP, socketResponsedMessage);
    }

    public CustomResponsedMessage<?> b(CustomResponsedMessage<?> customResponsedMessage) {
        return (CustomResponsedMessage) a(this.pQ, customResponsedMessage);
    }

    private <M extends ResponsedMessage<?>> M a(LinkedList<? extends g<M>> linkedList, M m) {
        M m2;
        if (linkedList == null) {
            return null;
        }
        int size = linkedList.size();
        int i = 0;
        M m3 = m;
        while (i < size && m3 != null) {
            try {
                m2 = linkedList.get(i).b(m3);
            } catch (Exception e) {
                BdLog.e("rule error = " + e.getMessage());
                m2 = m3;
            }
            i++;
            m3 = m2;
        }
        return m3;
    }

    public void a(e eVar) {
        this.pR.add(eVar);
    }

    public void b(e eVar) {
        this.pR.remove(eVar);
    }

    public void c(int i, BdUniqueId bdUniqueId) {
        int size = this.pR.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.pR.get(i2).b(i, bdUniqueId);
        }
    }

    public void c(BdUniqueId bdUniqueId) {
        int size = this.pR.size();
        for (int i = 0; i < size; i++) {
            this.pR.get(i).b(bdUniqueId);
        }
    }
}
