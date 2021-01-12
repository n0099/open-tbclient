package com.baidu.live.adp.framework.controller;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.FrameHelper;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.message.Message;
import com.baidu.live.adp.framework.message.ResponsedMessage;
import com.baidu.live.adp.framework.message.SocketMessage;
import com.baidu.live.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.adp.framework.task.MessageTask;
import com.baidu.live.adp.framework.task.SocketMessageTask;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import java.util.LinkedList;
/* loaded from: classes10.dex */
public class RuleController {
    private final LinkedList<HttpRule> mHttpMessageRules = new LinkedList<>();
    private final LinkedList<SocketRule> mSocketMessageRules = new LinkedList<>();
    private final LinkedList<CustomRule> mCustomMessageRules = new LinkedList<>();
    private final LinkedList<HttpResponsedRule> mHttpResponsedRules = new LinkedList<>();
    private final LinkedList<SocketResponsedRule> mSocketResponsedRules = new LinkedList<>();
    private final LinkedList<CustomResponsedRule> mCustomResponsedRules = new LinkedList<>();
    private final LinkedList<MessageRemovedRule> mRemovedRules = new LinkedList<>();

    public void addMessageRule(MessageRule<?, ?> messageRule) {
        if (messageRule != null) {
            BdUtilHelper.checkMainThread();
            if (messageRule instanceof HttpRule) {
                FrameHelper.insert(this.mHttpMessageRules, (HttpRule) messageRule);
            } else if (messageRule instanceof SocketRule) {
                FrameHelper.insert(this.mSocketMessageRules, (SocketRule) messageRule);
            } else if (messageRule instanceof CustomRule) {
                FrameHelper.insert(this.mCustomMessageRules, (CustomRule) messageRule);
            } else {
                BdLog.e("rule invalid");
            }
        }
    }

    public void removeMessageRule(MessageRule<?, ?> messageRule) {
        if (messageRule != null) {
            BdUtilHelper.checkMainThread();
            if (messageRule instanceof HttpRule) {
                this.mHttpMessageRules.remove(messageRule);
            } else if (messageRule instanceof SocketRule) {
                this.mSocketMessageRules.remove(messageRule);
            } else if (messageRule instanceof CustomRule) {
                this.mCustomMessageRules.remove(messageRule);
            } else {
                BdLog.e("rule invalid");
            }
        }
    }

    public void addResponsedRule(ResponsedMessageRule<?> responsedMessageRule) {
        if (responsedMessageRule != null) {
            BdUtilHelper.checkMainThread();
            if (responsedMessageRule instanceof HttpResponsedRule) {
                FrameHelper.insert(this.mHttpResponsedRules, (HttpResponsedRule) responsedMessageRule);
            } else if (responsedMessageRule instanceof SocketResponsedRule) {
                FrameHelper.insert(this.mSocketResponsedRules, (SocketResponsedRule) responsedMessageRule);
            } else if (responsedMessageRule instanceof CustomResponsedRule) {
                FrameHelper.insert(this.mCustomResponsedRules, (CustomResponsedRule) responsedMessageRule);
            } else {
                BdLog.e("rule invalid");
            }
        }
    }

    public void removeMessageRule(ResponsedMessageRule<?> responsedMessageRule) {
        if (responsedMessageRule != null) {
            BdUtilHelper.checkMainThread();
            if (responsedMessageRule instanceof HttpResponsedRule) {
                this.mHttpResponsedRules.remove(responsedMessageRule);
            } else if (responsedMessageRule instanceof SocketResponsedRule) {
                this.mSocketResponsedRules.remove(responsedMessageRule);
            } else if (responsedMessageRule instanceof CustomResponsedRule) {
                this.mCustomResponsedRules.remove(responsedMessageRule);
            } else {
                BdLog.e("rule invalid");
            }
        }
    }

    public HttpMessage rule(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        return (HttpMessage) rule(this.mHttpMessageRules, httpMessage, httpMessageTask);
    }

    public SocketMessage rule(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        return (SocketMessage) rule(this.mSocketMessageRules, socketMessage, socketMessageTask);
    }

    public CustomMessage<?> rule(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
        return (CustomMessage) rule(this.mCustomMessageRules, customMessage, customMessageTask);
    }

    private <M extends Message<?>, T extends MessageTask> M rule(LinkedList<? extends MessageRule<M, T>> linkedList, M m, T t) {
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

    public HttpResponsedMessage rule(HttpResponsedMessage httpResponsedMessage) {
        return (HttpResponsedMessage) rule(this.mHttpResponsedRules, (LinkedList<HttpResponsedRule>) httpResponsedMessage);
    }

    public SocketResponsedMessage rule(SocketResponsedMessage socketResponsedMessage) {
        return (SocketResponsedMessage) rule(this.mSocketResponsedRules, (LinkedList<SocketResponsedRule>) socketResponsedMessage);
    }

    public CustomResponsedMessage<?> rule(CustomResponsedMessage<?> customResponsedMessage) {
        return (CustomResponsedMessage) rule((LinkedList<? extends ResponsedMessageRule<LinkedList<CustomResponsedRule>>>) this.mCustomResponsedRules, (LinkedList<CustomResponsedRule>) customResponsedMessage);
    }

    private <M extends ResponsedMessage<?>> M rule(LinkedList<? extends ResponsedMessageRule<M>> linkedList, M m) {
        M m2;
        if (linkedList == null) {
            return null;
        }
        int size = linkedList.size();
        int i = 0;
        M m3 = m;
        while (i < size && m3 != null) {
            try {
                m2 = linkedList.get(i).rule(m3);
            } catch (Exception e) {
                BdLog.e("rule error = " + e.getMessage());
                m2 = m3;
            }
            i++;
            m3 = m2;
        }
        return m3;
    }

    public void addMessageRemovedRule(MessageRemovedRule messageRemovedRule) {
        this.mRemovedRules.add(messageRemovedRule);
    }

    public void removeMessageRemovedRule(MessageRemovedRule messageRemovedRule) {
        this.mRemovedRules.remove(messageRemovedRule);
    }

    public void ruleRemoveMessage(int i, BdUniqueId bdUniqueId) {
        int size = this.mRemovedRules.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mRemovedRules.get(i2).process(i, bdUniqueId);
        }
    }

    public void ruleRemoveMessage(BdUniqueId bdUniqueId) {
        int size = this.mRemovedRules.size();
        for (int i = 0; i < size; i++) {
            this.mRemovedRules.get(i).process(bdUniqueId);
        }
    }
}
