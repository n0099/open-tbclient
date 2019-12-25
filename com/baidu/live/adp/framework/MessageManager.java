package com.baidu.live.adp.framework;

import android.os.Handler;
import android.os.Looper;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.FrameHelper;
import com.baidu.live.adp.framework.client.socket.SocketClient;
import com.baidu.live.adp.framework.client.socket.SocketConfig;
import com.baidu.live.adp.framework.client.socket.SocketLog;
import com.baidu.live.adp.framework.controller.MessageRemovedRule;
import com.baidu.live.adp.framework.controller.MessageRule;
import com.baidu.live.adp.framework.controller.ResponsedMessageRule;
import com.baidu.live.adp.framework.controller.RuleController;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.listener.MessageListener;
import com.baidu.live.adp.framework.listener.NetMessageListener;
import com.baidu.live.adp.framework.listener.NotFindTaskListener;
import com.baidu.live.adp.framework.listener.SocketMessageListener;
import com.baidu.live.adp.framework.manager.CustomManager;
import com.baidu.live.adp.framework.manager.HttpManager;
import com.baidu.live.adp.framework.manager.Manager;
import com.baidu.live.adp.framework.manager.SocketManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.message.Message;
import com.baidu.live.adp.framework.message.NetMessage;
import com.baidu.live.adp.framework.message.ResponsedMessage;
import com.baidu.live.adp.framework.message.SocketMessage;
import com.baidu.live.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.adp.framework.task.MessageTask;
import com.baidu.live.adp.framework.task.SocketMessageTask;
import com.baidu.live.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class MessageManager {
    private static final String MODULE_NAME = "msgmgr";
    private static MessageManager sInstance = null;
    private RuleController mController;
    private CustomManager mCustomManager;
    private HttpManager mHttpManager;
    private SocketManager mSocketManager;
    private Handler mUIHandler;
    private int mSocketMsgCWSendFailedCnt = 0;
    private int mHttpMsgCWSendFailedCnt = 0;

    public static MessageManager getInstance() {
        if (sInstance == null) {
            synchronized (MessageManager.class) {
                if (sInstance == null) {
                    sInstance = new MessageManager();
                }
            }
        }
        return sInstance;
    }

    private MessageManager() {
        this.mHttpManager = null;
        this.mSocketManager = null;
        this.mCustomManager = null;
        this.mController = null;
        this.mUIHandler = null;
        this.mHttpManager = new HttpManager(this);
        this.mSocketManager = new SocketManager(this);
        this.mCustomManager = new CustomManager(this);
        this.mController = new RuleController();
        this.mUIHandler = new Handler(Looper.getMainLooper());
    }

    public SocketClient getSocketClient() {
        return this.mSocketManager.getSocketClient();
    }

    private Manager<?, ?, ?, ?> getManager(int i) {
        FrameHelper.TYPE messageType = FrameHelper.getMessageType(i);
        if (messageType == FrameHelper.TYPE.HTTP) {
            return this.mHttpManager;
        }
        if (messageType == FrameHelper.TYPE.SOCKET) {
            return this.mSocketManager;
        }
        if (messageType == FrameHelper.TYPE.CUSTOM) {
            return this.mCustomManager;
        }
        BdLog.e("cmd invalid");
        return null;
    }

    public boolean sendMessage(Message<?> message) {
        if (message == null) {
            return false;
        }
        message.setStartTime(System.currentTimeMillis());
        if (message instanceof HttpMessage) {
            return this.mHttpManager.dispatchMessage((HttpMessage) message, null);
        }
        if (message instanceof SocketMessage) {
            return this.mSocketManager.dispatchMessage((SocketMessage) message, null);
        }
        if (message instanceof CustomMessage) {
            return this.mCustomManager.dispatchMessage((CustomMessage) message, null);
        }
        BdLog.e("message invalid" + CmdConvertManager.getInstance().getNameByCmd(message.getCmd()));
        return false;
    }

    public void sendMessageFromBackground(final Message<?> message) {
        if (message != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.baidu.live.adp.framework.MessageManager.1
                @Override // java.lang.Runnable
                public void run() {
                    MessageManager.this.sendMessage(message);
                }
            });
        }
    }

    public boolean sendMessage(NetMessage netMessage) {
        if (netMessage == null) {
            return false;
        }
        if (netMessage.getNetType() == NetMessage.NetType.SOCKET) {
            return sendMessage(netMessage.getSocketMessage());
        }
        if (netMessage.getNetType() == NetMessage.NetType.HTTP) {
            return sendMessage(netMessage.getHttpMessage());
        }
        boolean isValid = getSocketClient().isValid();
        if (!isValid) {
            netMessage.setSocketErrNo(1);
        }
        if (isValid && sendMessage(netMessage.getSocketMessage())) {
            SocketLog.debug(MODULE_NAME, netMessage.getSocketMessage(), 0, "sendMessage", 0, "socket");
            return true;
        }
        SocketLog.debug(MODULE_NAME, netMessage.getSocketMessage(), 0, "sendMessage", 0, "https");
        return sendMessage(netMessage.getHttpMessage());
    }

    public boolean sendMessage(NetMessage netMessage, SocketMessageTask socketMessageTask, HttpMessageTask httpMessageTask) {
        if (netMessage == null) {
            return false;
        }
        if (netMessage.getNetType() == NetMessage.NetType.SOCKET) {
            return sendMessage(netMessage.getSocketMessage(), socketMessageTask);
        }
        if (netMessage.getNetType() == NetMessage.NetType.HTTP) {
            return sendMessage(netMessage.getHttpMessage(), httpMessageTask);
        }
        boolean isValid = getSocketClient().isValid();
        if (!isValid) {
            netMessage.setSocketErrNo(1);
        }
        if (isValid && sendMessage(netMessage.getSocketMessage(), socketMessageTask)) {
            SocketLog.debug(MODULE_NAME, netMessage.getSocketMessage(), 0, "sendMessage", 0, "socket");
            return true;
        }
        SocketLog.debug(MODULE_NAME, netMessage.getSocketMessage(), 0, "sendMessage", 0, "https");
        return sendMessage(netMessage.getHttpMessage(), httpMessageTask);
    }

    public boolean sendMessage(Message<?> message, MessageTask messageTask) {
        if (message == null) {
            return false;
        }
        if ((message instanceof HttpMessage) && (messageTask instanceof HttpMessageTask)) {
            return this.mHttpManager.dispatchMessage((HttpMessage) message, (HttpMessageTask) messageTask);
        }
        if ((message instanceof SocketMessage) && (messageTask instanceof SocketMessageTask)) {
            return this.mSocketManager.dispatchMessage((SocketMessage) message, (SocketMessageTask) messageTask);
        }
        if ((message instanceof CustomMessage) && (messageTask instanceof CustomMessageTask)) {
            return this.mCustomManager.dispatchMessage((CustomMessage) message, (CustomMessageTask) messageTask);
        }
        BdLog.e("message and task invalid:" + CmdConvertManager.getInstance().getNameByCmd(message.getCmd()));
        return false;
    }

    public LinkedList<HttpMessage> findHttpMessage(BdUniqueId bdUniqueId) {
        return this.mHttpManager.findMessage(bdUniqueId);
    }

    public LinkedList<SocketMessage> findSocketMessage(BdUniqueId bdUniqueId) {
        return this.mSocketManager.findMessage(bdUniqueId);
    }

    public LinkedList<CustomMessage<?>> findCustomMessage(BdUniqueId bdUniqueId) {
        return this.mCustomManager.findMessage(bdUniqueId);
    }

    /* JADX DEBUG: Type inference failed for r0v3. Raw type applied. Possible types: java.util.LinkedList<?>, java.util.LinkedList<? extends com.baidu.live.adp.framework.message.Message> */
    public LinkedList<? extends Message> findMessage(int i, BdUniqueId bdUniqueId) {
        Manager<?, ?, ?, ?> manager = getManager(i);
        if (manager != null) {
            return manager.findMessage(i, bdUniqueId);
        }
        BdLog.e("cmd invalid");
        return null;
    }

    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        Manager<?, ?, ?, ?> manager = getManager(i);
        if (manager != null) {
            manager.removeMessage(i, bdUniqueId);
            this.mController.ruleRemoveMessage(i, bdUniqueId);
            return;
        }
        BdLog.e("cmd invalid");
    }

    public void removeSocketMessage(BdUniqueId bdUniqueId) {
        this.mSocketManager.removeMessage(bdUniqueId);
        this.mController.ruleRemoveMessage(bdUniqueId);
    }

    public void removeCustomMessage(BdUniqueId bdUniqueId) {
        this.mCustomManager.removeMessage(bdUniqueId);
        this.mController.ruleRemoveMessage(bdUniqueId);
    }

    public void removeHttpMessage(BdUniqueId bdUniqueId) {
        this.mHttpManager.removeMessage(bdUniqueId);
        this.mController.ruleRemoveMessage(bdUniqueId);
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        removeSocketMessage(bdUniqueId);
        removeCustomMessage(bdUniqueId);
        removeHttpMessage(bdUniqueId);
    }

    public void abortResponsedMessage(ResponsedMessage<?> responsedMessage) {
        Manager<?, ?, ?, ?> manager;
        if (responsedMessage != null && (manager = getManager(responsedMessage.getCmd())) != null) {
            manager.abort();
        }
    }

    public void registerTask(MessageTask messageTask) {
        if (messageTask != null) {
            BdUtilHelper.checkMainThread();
            if (messageTask instanceof HttpMessageTask) {
                this.mHttpManager.registerTask((HttpMessageTask) messageTask);
            } else if (messageTask instanceof SocketMessageTask) {
                this.mSocketManager.registerTask((SocketMessageTask) messageTask);
            } else if (messageTask instanceof CustomMessageTask) {
                this.mCustomManager.registerTask((CustomMessageTask) messageTask);
            } else {
                BdLog.e("task invalid");
            }
        }
    }

    public MessageTask findTask(int i) {
        FrameHelper.TYPE messageType = FrameHelper.getMessageType(i);
        if (FrameHelper.TYPE.HTTP == messageType) {
            return this.mHttpManager.findTask(i);
        }
        if (FrameHelper.TYPE.SOCKET == messageType) {
            return this.mSocketManager.findTask(i);
        }
        if (FrameHelper.TYPE.CUSTOM != messageType) {
            return null;
        }
        return this.mCustomManager.findTask(i);
    }

    public ArrayList<HttpMessageTask> findHttpTasks() {
        return this.mHttpManager.findTasks();
    }

    public ArrayList<CustomMessageTask> findCustomTasks() {
        return this.mCustomManager.findTasks();
    }

    public ArrayList<SocketMessageTask> findSocketTasks() {
        return this.mSocketManager.findTasks();
    }

    public void unRegisterTask(int i) {
        BdUtilHelper.checkMainThread();
        Manager<?, ?, ?, ?> manager = getManager(i);
        if (manager != null) {
            manager.unRegisterTask(i);
        }
    }

    public void registerListener(final NetMessageListener netMessageListener) {
        if (netMessageListener != null) {
            if (BdUtilHelper.isMainThread()) {
                this.mHttpManager.registerListener(0, netMessageListener.getHttpMessageListener());
                this.mSocketManager.registerListener(0, netMessageListener.getSocketMessageListener());
                return;
            }
            this.mUIHandler.post(new Runnable() { // from class: com.baidu.live.adp.framework.MessageManager.2
                @Override // java.lang.Runnable
                public void run() {
                    MessageManager.this.mHttpManager.registerListener(0, netMessageListener.getHttpMessageListener());
                    MessageManager.this.mSocketManager.registerListener(0, netMessageListener.getSocketMessageListener());
                }
            });
        }
    }

    public void registerListener(final int i, final NetMessageListener netMessageListener) {
        if (netMessageListener != null) {
            if (BdUtilHelper.isMainThread()) {
                this.mHttpManager.registerListener(i, netMessageListener.getHttpMessageListener());
                this.mSocketManager.registerListener(i, netMessageListener.getSocketMessageListener());
                return;
            }
            this.mUIHandler.post(new Runnable() { // from class: com.baidu.live.adp.framework.MessageManager.3
                @Override // java.lang.Runnable
                public void run() {
                    MessageManager.this.mHttpManager.registerListener(i, netMessageListener.getHttpMessageListener());
                    MessageManager.this.mSocketManager.registerListener(i, netMessageListener.getSocketMessageListener());
                }
            });
        }
    }

    public void unRegisterListener(final NetMessageListener netMessageListener) {
        if (netMessageListener != null) {
            if (BdUtilHelper.isMainThread()) {
                this.mHttpManager.unRegisterListener(netMessageListener.getHttpMessageListener());
                this.mSocketManager.unRegisterListener(netMessageListener.getSocketMessageListener());
                return;
            }
            this.mUIHandler.post(new Runnable() { // from class: com.baidu.live.adp.framework.MessageManager.4
                @Override // java.lang.Runnable
                public void run() {
                    MessageManager.this.mHttpManager.unRegisterListener(netMessageListener.getHttpMessageListener());
                    MessageManager.this.mSocketManager.unRegisterListener(netMessageListener.getSocketMessageListener());
                }
            });
        }
    }

    public void registerListenerFromBackground(final MessageListener<?> messageListener) {
        if (messageListener != null) {
            if (BdUtilHelper.isMainThread()) {
                registerListener(messageListener);
            } else {
                this.mUIHandler.post(new Runnable() { // from class: com.baidu.live.adp.framework.MessageManager.5
                    @Override // java.lang.Runnable
                    public void run() {
                        MessageManager.this.registerListener(messageListener);
                    }
                });
            }
        }
    }

    public void registerListener(final MessageListener<?> messageListener) {
        if (messageListener != null) {
            if (BdUtilHelper.isMainThread()) {
                registerListenerInternal(messageListener);
            } else {
                this.mUIHandler.post(new Runnable() { // from class: com.baidu.live.adp.framework.MessageManager.6
                    @Override // java.lang.Runnable
                    public void run() {
                        MessageManager.this.registerListenerInternal(messageListener);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerListenerInternal(MessageListener<?> messageListener) {
        if (messageListener != null) {
            BdUtilHelper.checkMainThread();
            FrameHelper.TYPE messageType = FrameHelper.getMessageType(messageListener.getCmd());
            if (messageType == FrameHelper.TYPE.HTTP && (messageListener instanceof HttpMessageListener)) {
                this.mHttpManager.registerListener(0, (HttpMessageListener) messageListener);
            } else if (messageType == FrameHelper.TYPE.SOCKET && (messageListener instanceof SocketMessageListener)) {
                this.mSocketManager.registerListener(0, (SocketMessageListener) messageListener);
            } else if (messageType == FrameHelper.TYPE.CUSTOM && (messageListener instanceof CustomMessageListener)) {
                this.mCustomManager.registerListener(0, (CustomMessageListener) messageListener);
            } else {
                BdLog.e("listener invalid" + CmdConvertManager.getInstance().getNameByCmd(messageListener.getCmd()));
            }
        }
    }

    public void registerListener(final int i, final MessageListener<?> messageListener) {
        if (messageListener != null) {
            if (BdUtilHelper.isMainThread()) {
                registerListenerInternal(i, messageListener);
            } else {
                this.mUIHandler.post(new Runnable() { // from class: com.baidu.live.adp.framework.MessageManager.7
                    @Override // java.lang.Runnable
                    public void run() {
                        MessageManager.this.registerListenerInternal(i, messageListener);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerListenerInternal(int i, MessageListener<?> messageListener) {
        if (messageListener != null) {
            BdUtilHelper.checkMainThread();
            FrameHelper.TYPE messageType = FrameHelper.getMessageType(i);
            if (messageType == FrameHelper.TYPE.HTTP && (messageListener instanceof HttpMessageListener)) {
                this.mHttpManager.registerListener(i, (HttpMessageListener) messageListener);
            } else if (messageType == FrameHelper.TYPE.SOCKET && (messageListener instanceof SocketMessageListener)) {
                this.mSocketManager.registerListener(i, (SocketMessageListener) messageListener);
            } else if (messageType == FrameHelper.TYPE.CUSTOM && (messageListener instanceof CustomMessageListener)) {
                this.mCustomManager.registerListener(i, (CustomMessageListener) messageListener);
            } else {
                BdLog.e("listener invalid" + CmdConvertManager.getInstance().getNameByCmd(i) + "|" + CmdConvertManager.getInstance().getNameByCmd(messageListener.getCmd()));
            }
        }
    }

    public void unRegisterListener(final MessageListener<?> messageListener) {
        if (messageListener != null) {
            if (BdUtilHelper.isMainThread()) {
                unRegisterListenerInternal(messageListener);
            } else {
                this.mUIHandler.post(new Runnable() { // from class: com.baidu.live.adp.framework.MessageManager.8
                    @Override // java.lang.Runnable
                    public void run() {
                        MessageManager.this.unRegisterListenerInternal(messageListener);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unRegisterListenerInternal(MessageListener<?> messageListener) {
        if (messageListener != null) {
            BdUtilHelper.checkMainThread();
            int cmd = messageListener.getCmd();
            if (cmd != 0) {
                Manager<?, ?, ?, ?> manager = getManager(cmd);
                if (manager != null) {
                    manager.unRegisterListener(messageListener);
                    return;
                }
                return;
            }
            this.mHttpManager.unRegisterListener(messageListener);
            this.mSocketManager.unRegisterListener(messageListener);
            this.mCustomManager.unRegisterListener(messageListener);
        }
    }

    public void unRegisterListener(final BdUniqueId bdUniqueId) {
        if (BdUtilHelper.isMainThread()) {
            unRegisterListenerInternal(bdUniqueId);
        } else {
            this.mUIHandler.post(new Runnable() { // from class: com.baidu.live.adp.framework.MessageManager.9
                @Override // java.lang.Runnable
                public void run() {
                    MessageManager.this.unRegisterListenerInternal(bdUniqueId);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unRegisterListenerInternal(BdUniqueId bdUniqueId) {
        this.mHttpManager.unRegisterListener(bdUniqueId);
        this.mSocketManager.unRegisterListener(bdUniqueId);
        this.mCustomManager.unRegisterListener(bdUniqueId);
    }

    public void registerStickyMode(int i) {
        BdUtilHelper.checkMainThread();
        Manager<?, ?, ?, ?> manager = getManager(i);
        if (manager != null) {
            manager.registerStickyMode(i);
        }
    }

    public void unRegisterStickyMode(int i) {
        BdUtilHelper.checkMainThread();
        Manager<?, ?, ?, ?> manager = getManager(i);
        if (manager != null) {
            manager.unRegisterStickyMode(i);
        }
    }

    public void addMessageRule(final MessageRule<?, ?> messageRule) {
        if (BdUtilHelper.isMainThread()) {
            this.mController.addMessageRule(messageRule);
        } else {
            this.mUIHandler.post(new Runnable() { // from class: com.baidu.live.adp.framework.MessageManager.10
                @Override // java.lang.Runnable
                public void run() {
                    MessageManager.this.mController.addMessageRule(messageRule);
                }
            });
        }
    }

    public void removeMessageRule(final MessageRule<?, ?> messageRule) {
        if (BdUtilHelper.isMainThread()) {
            this.mController.removeMessageRule(messageRule);
        } else {
            this.mUIHandler.post(new Runnable() { // from class: com.baidu.live.adp.framework.MessageManager.11
                @Override // java.lang.Runnable
                public void run() {
                    MessageManager.this.mController.removeMessageRule(messageRule);
                }
            });
        }
    }

    public void addResponsedMessageRule(final ResponsedMessageRule<?> responsedMessageRule) {
        if (BdUtilHelper.isMainThread()) {
            this.mController.addResponsedRule(responsedMessageRule);
        } else {
            this.mUIHandler.post(new Runnable() { // from class: com.baidu.live.adp.framework.MessageManager.12
                @Override // java.lang.Runnable
                public void run() {
                    MessageManager.this.mController.addResponsedRule(responsedMessageRule);
                }
            });
        }
    }

    public void removeResponsedMessageRule(final ResponsedMessageRule<?> responsedMessageRule) {
        if (BdUtilHelper.isMainThread()) {
            this.mController.removeMessageRule(responsedMessageRule);
        } else {
            this.mUIHandler.post(new Runnable() { // from class: com.baidu.live.adp.framework.MessageManager.13
                @Override // java.lang.Runnable
                public void run() {
                    MessageManager.this.mController.removeMessageRule(responsedMessageRule);
                }
            });
        }
    }

    public void addRemovedMessageRule(final MessageRemovedRule messageRemovedRule) {
        if (BdUtilHelper.isMainThread()) {
            this.mController.addMessageRemovedRule(messageRemovedRule);
        } else {
            this.mUIHandler.post(new Runnable() { // from class: com.baidu.live.adp.framework.MessageManager.14
                @Override // java.lang.Runnable
                public void run() {
                    MessageManager.this.mController.addMessageRemovedRule(messageRemovedRule);
                }
            });
        }
    }

    public void removeRemovedMessageRule(final MessageRemovedRule messageRemovedRule) {
        if (BdUtilHelper.isMainThread()) {
            this.mController.removeMessageRemovedRule(messageRemovedRule);
        } else {
            this.mUIHandler.post(new Runnable() { // from class: com.baidu.live.adp.framework.MessageManager.15
                @Override // java.lang.Runnable
                public void run() {
                    MessageManager.this.mController.removeMessageRemovedRule(messageRemovedRule);
                }
            });
        }
    }

    public void dispatchResponsedMessage(final ResponsedMessage<?> responsedMessage) {
        int cmd;
        if (responsedMessage == null) {
            BdLog.e("responsedMessage is null!!!");
        } else if (!BdUtilHelper.isMainThread()) {
            this.mUIHandler.post(new Runnable() { // from class: com.baidu.live.adp.framework.MessageManager.16
                @Override // java.lang.Runnable
                public void run() {
                    MessageManager.this.dispatchResponsedMessage(responsedMessage);
                }
            });
        } else {
            FrameHelper.TYPE messageType = FrameHelper.getMessageType(responsedMessage.getCmd());
            if (messageType == FrameHelper.TYPE.HTTP && (responsedMessage instanceof HttpResponsedMessage)) {
                if (responsedMessage.getError() != 0) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        this.mHttpMsgCWSendFailedCnt++;
                        if (this.mHttpMsgCWSendFailedCnt >= 3) {
                            BdStatisticsManager.getInstance().alert(BdStatsConstant.AlertTypeKey.ALERT_HTTP, "errCode=" + responsedMessage.getError() + responsedMessage.getErrorString());
                        }
                    }
                } else {
                    this.mHttpMsgCWSendFailedCnt = 0;
                }
                this.mHttpManager.dispatchResponsedMessage(this.mController.rule((HttpResponsedMessage) responsedMessage));
            } else if (messageType == FrameHelper.TYPE.SOCKET && (responsedMessage instanceof SocketResponsedMessage)) {
                if (responsedMessage.getError() != 0) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        this.mSocketMsgCWSendFailedCnt++;
                        if (this.mSocketMsgCWSendFailedCnt >= 3) {
                            BdStatisticsManager.getInstance().alert(BdStatsConstant.AlertTypeKey.ALERT_IM, "errCode=" + responsedMessage.getError() + responsedMessage.getErrorString());
                        }
                    }
                } else {
                    this.mSocketMsgCWSendFailedCnt = 0;
                }
                Message<?> orginalMessage = responsedMessage.getOrginalMessage();
                if (orginalMessage != null && orginalMessage.getExtra() != null && (orginalMessage.getExtra() instanceof NetMessage)) {
                    NetMessage netMessage = (NetMessage) orginalMessage.getExtra();
                    if (netMessage.getHttpMessage() != null && netMessage.getNetType() == NetMessage.NetType.AUTO) {
                        NetMessage.SwitchToHttpStrategy switchToHttpStrategy = netMessage.getSwitchToHttpStrategy();
                        if ((switchToHttpStrategy != null ? switchToHttpStrategy.checkToSwitchHttp((SocketResponsedMessage) responsedMessage) : false) || responsedMessage.getError() == SocketConfig.QUEUE_TIME_OUT) {
                            int i = 5;
                            if (responsedMessage.getError() == SocketConfig.QUEUE_TIME_OUT) {
                                netMessage.setSocketCostTime(System.currentTimeMillis() - orginalMessage.getStartTime());
                            } else if (responsedMessage.getError() == 110004) {
                                i = 8;
                            } else if (responsedMessage.getError() == 110005) {
                                i = 9;
                            }
                            netMessage.setSocketErrNo(i);
                            if (netMessage.getSocketMessage() != null) {
                                netMessage.getHttpMessage().setSquencedId(netMessage.getSocketMessage().getSquencedId());
                            }
                            if (sendMessage(netMessage.getHttpMessage())) {
                                this.mCustomManager.dispatchResponsedMessage(new CustomResponsedMessage(MessageConfig.NET_AUTO_SOCKET_FAIL, Integer.valueOf(responsedMessage.getCmd())));
                                return;
                            }
                        }
                    }
                }
                this.mSocketManager.dispatchResponsedMessage(this.mController.rule((SocketResponsedMessage) responsedMessage));
            } else if (messageType == FrameHelper.TYPE.CUSTOM && (responsedMessage instanceof CustomResponsedMessage)) {
                this.mCustomManager.dispatchResponsedMessage(this.mController.rule((CustomResponsedMessage) responsedMessage));
            } else {
                BdLog.e("responsedMessage invalid:CMD=" + CmdConvertManager.getInstance().getNameByCmd(cmd) + " Class=" + responsedMessage.getClass().getName());
            }
        }
    }

    @Deprecated
    public void dispatchResponsedMessageToUI(ResponsedMessage<?> responsedMessage) {
        dispatchResponsedMessage(responsedMessage);
    }

    public void setNotFindTaskListener(NotFindTaskListener<Message<?>> notFindTaskListener) {
        Manager.setNotFindTaskListener(notFindTaskListener);
    }

    public <T> CustomResponsedMessage<T> runTask(int i, Class<T> cls) {
        return runTask(i, cls, null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.live.adp.framework.manager.CustomManager */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> CustomResponsedMessage<T> runTask(int i, Class<T> cls, Object obj) {
        CustomMessage customMessage;
        if (obj == null) {
            customMessage = null;
        } else {
            CustomMessage customMessage2 = new CustomMessage(i);
            customMessage2.setData(obj);
            customMessage = customMessage2;
        }
        return this.mCustomManager.runTask(customMessage, this.mCustomManager.findTask(i), cls);
    }

    public <T> CustomResponsedMessage<T> runTask(CustomMessageTask customMessageTask, Class<T> cls) {
        return this.mCustomManager.runTask(null, customMessageTask, cls);
    }

    public <T> CustomResponsedMessage<T> runTask(CustomMessage<?> customMessage, Class<T> cls) {
        if (customMessage == null) {
            return null;
        }
        return this.mCustomManager.runTask(customMessage, this.mCustomManager.findTask(customMessage.getCmd()), cls);
    }

    public RuleController getController() {
        return this.mController;
    }
}
