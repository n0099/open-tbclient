package com.baidu.adp.framework.b;

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
    private final LinkedList<d> mHttpMessageRules = new LinkedList<>();
    private final LinkedList<k> mSocketMessageRules = new LinkedList<>();
    private final LinkedList<b> mCustomMessageRules = new LinkedList<>();
    private final LinkedList<c> mHttpResponsedRules = new LinkedList<>();
    private final LinkedList<j> mSocketResponsedRules = new LinkedList<>();
    private final LinkedList<a> mCustomResponsedRules = new LinkedList<>();
    private final LinkedList<e> mRemovedRules = new LinkedList<>();

    public void addMessageRule(f<?, ?> fVar) {
        if (fVar != null) {
            l.checkMainThread();
            if (fVar instanceof d) {
                FrameHelper.a(this.mHttpMessageRules, (d) fVar);
            } else if (fVar instanceof k) {
                FrameHelper.a(this.mSocketMessageRules, (k) fVar);
            } else if (fVar instanceof b) {
                FrameHelper.a(this.mCustomMessageRules, (b) fVar);
            } else {
                BdLog.e("rule invalid");
            }
        }
    }

    public void removeMessageRule(f<?, ?> fVar) {
        if (fVar != null) {
            l.checkMainThread();
            if (fVar instanceof d) {
                this.mHttpMessageRules.remove(fVar);
            } else if (fVar instanceof k) {
                this.mSocketMessageRules.remove(fVar);
            } else if (fVar instanceof b) {
                this.mCustomMessageRules.remove(fVar);
            } else {
                BdLog.e("rule invalid");
            }
        }
    }

    public void a(g<?> gVar) {
        if (gVar != null) {
            l.checkMainThread();
            if (gVar instanceof c) {
                FrameHelper.a(this.mHttpResponsedRules, (c) gVar);
            } else if (gVar instanceof j) {
                FrameHelper.a(this.mSocketResponsedRules, (j) gVar);
            } else if (gVar instanceof a) {
                FrameHelper.a(this.mCustomResponsedRules, (a) gVar);
            } else {
                BdLog.e("rule invalid");
            }
        }
    }

    public void b(g<?> gVar) {
        if (gVar != null) {
            l.checkMainThread();
            if (gVar instanceof c) {
                this.mHttpResponsedRules.remove(gVar);
            } else if (gVar instanceof j) {
                this.mSocketResponsedRules.remove(gVar);
            } else if (gVar instanceof a) {
                this.mCustomResponsedRules.remove(gVar);
            } else {
                BdLog.e("rule invalid");
            }
        }
    }

    public HttpMessage b(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        return (HttpMessage) a(this.mHttpMessageRules, httpMessage, httpMessageTask);
    }

    public SocketMessage b(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        return (SocketMessage) a(this.mSocketMessageRules, socketMessage, socketMessageTask);
    }

    public CustomMessage<?> b(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
        return (CustomMessage) a(this.mCustomMessageRules, customMessage, customMessageTask);
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
        return (HttpResponsedMessage) a(this.mHttpResponsedRules, httpResponsedMessage);
    }

    public SocketResponsedMessage c(SocketResponsedMessage socketResponsedMessage) {
        return (SocketResponsedMessage) a(this.mSocketResponsedRules, socketResponsedMessage);
    }

    public CustomResponsedMessage<?> b(CustomResponsedMessage<?> customResponsedMessage) {
        return (CustomResponsedMessage) a(this.mCustomResponsedRules, customResponsedMessage);
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
        this.mRemovedRules.add(eVar);
    }

    public void b(e eVar) {
        this.mRemovedRules.remove(eVar);
    }

    public void c(int i, BdUniqueId bdUniqueId) {
        int size = this.mRemovedRules.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mRemovedRules.get(i2).b(i, bdUniqueId);
        }
    }

    public void c(BdUniqueId bdUniqueId) {
        int size = this.mRemovedRules.size();
        for (int i = 0; i < size; i++) {
            this.mRemovedRules.get(i).b(bdUniqueId);
        }
    }
}
