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
    private final LinkedList<d> rR = new LinkedList<>();
    private final LinkedList<k> rS = new LinkedList<>();
    private final LinkedList<b> rT = new LinkedList<>();
    private final LinkedList<c> rU = new LinkedList<>();
    private final LinkedList<j> rV = new LinkedList<>();
    private final LinkedList<a> rW = new LinkedList<>();
    private final LinkedList<e> rX = new LinkedList<>();

    public void addMessageRule(f<?, ?> fVar) {
        if (fVar != null) {
            com.baidu.adp.lib.util.k.hG();
            if (fVar instanceof d) {
                FrameHelper.a(this.rR, (d) fVar);
            } else if (fVar instanceof k) {
                FrameHelper.a(this.rS, (k) fVar);
            } else if (fVar instanceof b) {
                FrameHelper.a(this.rT, (b) fVar);
            } else {
                BdLog.e("rule invalid");
            }
        }
    }

    public void removeMessageRule(f<?, ?> fVar) {
        if (fVar != null) {
            com.baidu.adp.lib.util.k.hG();
            if (fVar instanceof d) {
                this.rR.remove(fVar);
            } else if (fVar instanceof k) {
                this.rS.remove(fVar);
            } else if (fVar instanceof b) {
                this.rT.remove(fVar);
            } else {
                BdLog.e("rule invalid");
            }
        }
    }

    public void a(g<?> gVar) {
        if (gVar != null) {
            com.baidu.adp.lib.util.k.hG();
            if (gVar instanceof c) {
                FrameHelper.a(this.rU, (c) gVar);
            } else if (gVar instanceof j) {
                FrameHelper.a(this.rV, (j) gVar);
            } else if (gVar instanceof a) {
                FrameHelper.a(this.rW, (a) gVar);
            } else {
                BdLog.e("rule invalid");
            }
        }
    }

    public void b(g<?> gVar) {
        if (gVar != null) {
            com.baidu.adp.lib.util.k.hG();
            if (gVar instanceof c) {
                this.rU.remove(gVar);
            } else if (gVar instanceof j) {
                this.rV.remove(gVar);
            } else if (gVar instanceof a) {
                this.rW.remove(gVar);
            } else {
                BdLog.e("rule invalid");
            }
        }
    }

    public HttpMessage b(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        return (HttpMessage) a(this.rR, httpMessage, httpMessageTask);
    }

    public SocketMessage b(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        return (SocketMessage) a(this.rS, socketMessage, socketMessageTask);
    }

    public CustomMessage<?> b(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
        return (CustomMessage) a(this.rT, customMessage, customMessageTask);
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
        return (HttpResponsedMessage) a(this.rU, httpResponsedMessage);
    }

    public SocketResponsedMessage c(SocketResponsedMessage socketResponsedMessage) {
        return (SocketResponsedMessage) a(this.rV, socketResponsedMessage);
    }

    public CustomResponsedMessage<?> b(CustomResponsedMessage<?> customResponsedMessage) {
        return (CustomResponsedMessage) a(this.rW, customResponsedMessage);
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
        this.rX.add(eVar);
    }

    public void b(e eVar) {
        this.rX.remove(eVar);
    }

    public void c(int i, BdUniqueId bdUniqueId) {
        int size = this.rX.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.rX.get(i2).b(i, bdUniqueId);
        }
    }

    public void c(BdUniqueId bdUniqueId) {
        int size = this.rX.size();
        for (int i = 0; i < size; i++) {
            this.rX.get(i).b(bdUniqueId);
        }
    }
}
