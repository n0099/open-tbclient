package com.baidu.adp.framework;

import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.a.f;
import com.baidu.adp.framework.a.g;
import com.baidu.adp.framework.a.i;
import com.baidu.adp.framework.b.d;
import com.baidu.adp.framework.client.socket.j;
import com.baidu.adp.framework.client.socket.l;
import com.baidu.adp.framework.client.socket.m;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.listener.e;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.framework.task.MessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.n;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MessageManager {
    private static final String MODULE_NAME = "msgmgr";
    private static MessageManager sInstance = null;
    private i mController;
    private com.baidu.adp.framework.b.a mCustomManager;
    private com.baidu.adp.framework.b.b mHttpManager;
    private d mSocketManager;
    private Handler mUIHandler;

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
        this.mHttpManager = new com.baidu.adp.framework.b.b(this);
        this.mSocketManager = new d(this);
        this.mCustomManager = new com.baidu.adp.framework.b.a(this);
        this.mController = new i();
        this.mUIHandler = new Handler(Looper.getMainLooper());
    }

    public j getSocketClient() {
        return this.mSocketManager.getSocketClient();
    }

    private com.baidu.adp.framework.b.c<?, ?, ?, ?> getManager(int i) {
        FrameHelper.TYPE q = FrameHelper.q(i);
        if (q == FrameHelper.TYPE.HTTP) {
            return this.mHttpManager;
        }
        if (q == FrameHelper.TYPE.SOCKET) {
            return this.mSocketManager;
        }
        if (q == FrameHelper.TYPE.CUSTOM) {
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
            com.baidu.adp.a.a.b.d("Request_Http", message);
            return this.mHttpManager.d((HttpMessage) message, null);
        } else if (message instanceof SocketMessage) {
            com.baidu.adp.a.a.b.d("Request_Socket", message);
            return this.mSocketManager.d((SocketMessage) message, null);
        } else if (message instanceof CustomMessage) {
            return this.mCustomManager.d((CustomMessage) message, null);
        } else {
            BdLog.e("message invalid" + message.getCmd());
            return false;
        }
    }

    public void sendMessageFromBackground(final Message<?> message) {
        if (message != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.baidu.adp.framework.MessageManager.1
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
        if (getSocketClient().isValid() && sendMessage(netMessage.getSocketMessage())) {
            m.a(MODULE_NAME, netMessage.getSocketMessage(), 0, "sendMessage", 0, "socket");
            return true;
        }
        m.a(MODULE_NAME, netMessage.getSocketMessage(), 0, "sendMessage", 0, "https");
        return sendMessage(netMessage.getHttpMessage());
    }

    public void sendMessage(Message<?> message, MessageTask messageTask) {
        if (message != null) {
            if ((message instanceof HttpMessage) && (messageTask instanceof HttpMessageTask)) {
                com.baidu.adp.a.a.b.d("Request_Http", message);
                this.mHttpManager.d((HttpMessage) message, (HttpMessageTask) messageTask);
            } else if ((message instanceof SocketMessage) && (messageTask instanceof SocketMessageTask)) {
                com.baidu.adp.a.a.b.d("Request_Socket", message);
                this.mSocketManager.d((SocketMessage) message, (SocketMessageTask) messageTask);
            } else if ((message instanceof CustomMessage) && (messageTask instanceof CustomMessageTask)) {
                this.mCustomManager.d((CustomMessage) message, (CustomMessageTask) messageTask);
            } else {
                BdLog.e("message and task invalid:" + message.getCmd());
            }
        }
    }

    public LinkedList<HttpMessage> findHttpMessage(BdUniqueId bdUniqueId) {
        return this.mHttpManager.a(bdUniqueId);
    }

    public LinkedList<SocketMessage> findSocketMessage(BdUniqueId bdUniqueId) {
        return this.mSocketManager.a(bdUniqueId);
    }

    public LinkedList<CustomMessage<?>> findCustomMessage(BdUniqueId bdUniqueId) {
        return this.mCustomManager.a(bdUniqueId);
    }

    /* JADX DEBUG: Type inference failed for r0v3. Raw type applied. Possible types: java.util.LinkedList<?>, java.util.LinkedList<? extends com.baidu.adp.framework.message.Message> */
    public LinkedList<? extends Message> findMessage(int i, BdUniqueId bdUniqueId) {
        com.baidu.adp.framework.b.c<?, ?, ?, ?> manager = getManager(i);
        if (manager != null) {
            return manager.findMessage(i, bdUniqueId);
        }
        BdLog.e("cmd invalid");
        return null;
    }

    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        com.baidu.adp.framework.b.c<?, ?, ?, ?> manager = getManager(i);
        if (manager != null) {
            manager.removeMessage(i, bdUniqueId);
            this.mController.c(i, bdUniqueId);
            return;
        }
        BdLog.e("cmd invalid");
    }

    public void removeSocketMessage(BdUniqueId bdUniqueId) {
        this.mSocketManager.removeMessage(bdUniqueId);
        this.mController.c(bdUniqueId);
    }

    public void removeCustomMessage(BdUniqueId bdUniqueId) {
        this.mCustomManager.removeMessage(bdUniqueId);
        this.mController.c(bdUniqueId);
    }

    public void removeHttpMessage(BdUniqueId bdUniqueId) {
        this.mHttpManager.removeMessage(bdUniqueId);
        this.mController.c(bdUniqueId);
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        removeSocketMessage(bdUniqueId);
        removeCustomMessage(bdUniqueId);
        removeHttpMessage(bdUniqueId);
    }

    public void abortResponsedMessage(ResponsedMessage<?> responsedMessage) {
        com.baidu.adp.framework.b.c<?, ?, ?, ?> manager;
        if (responsedMessage != null && (manager = getManager(responsedMessage.getCmd())) != null) {
            manager.abort();
        }
    }

    public void registerTask(MessageTask messageTask) {
        if (messageTask != null) {
            n.iV();
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
        FrameHelper.TYPE q = FrameHelper.q(i);
        if (FrameHelper.TYPE.HTTP == q) {
            return this.mHttpManager.findTask(i);
        }
        if (FrameHelper.TYPE.SOCKET == q) {
            return this.mSocketManager.findTask(i);
        }
        if (FrameHelper.TYPE.CUSTOM != q) {
            return null;
        }
        return this.mCustomManager.findTask(i);
    }

    public void unRegisterTask(int i) {
        n.iV();
        com.baidu.adp.framework.b.c<?, ?, ?, ?> manager = getManager(i);
        if (manager != null) {
            manager.unRegisterTask(i);
        }
    }

    public void registerListener(com.baidu.adp.framework.listener.a aVar) {
        if (aVar != null) {
            this.mHttpManager.registerListener(0, aVar.eO());
            this.mSocketManager.registerListener(0, aVar.eP());
        }
    }

    public void registerListener(int i, com.baidu.adp.framework.listener.a aVar) {
        if (aVar != null) {
            this.mHttpManager.registerListener(i, aVar.eO());
            this.mSocketManager.registerListener(i, aVar.eP());
        }
    }

    public void unRegisterListener(com.baidu.adp.framework.listener.a aVar) {
        if (aVar != null) {
            this.mHttpManager.unRegisterListener(aVar.eO());
            this.mSocketManager.unRegisterListener(aVar.eP());
        }
    }

    public void registerListenerFromBackground(final MessageListener<?> messageListener) {
        if (messageListener != null) {
            if (n.iW()) {
                registerListener(messageListener);
            } else {
                this.mUIHandler.post(new Runnable() { // from class: com.baidu.adp.framework.MessageManager.2
                    @Override // java.lang.Runnable
                    public void run() {
                        MessageManager.this.registerListener(messageListener);
                    }
                });
            }
        }
    }

    public void registerListener(MessageListener<?> messageListener) {
        if (messageListener != null) {
            n.iV();
            FrameHelper.TYPE q = FrameHelper.q(messageListener.getCmd());
            if (q == FrameHelper.TYPE.HTTP && (messageListener instanceof HttpMessageListener)) {
                this.mHttpManager.registerListener(0, (HttpMessageListener) messageListener);
            } else if (q == FrameHelper.TYPE.SOCKET && (messageListener instanceof e)) {
                this.mSocketManager.registerListener(0, (e) messageListener);
            } else if (q == FrameHelper.TYPE.CUSTOM && (messageListener instanceof CustomMessageListener)) {
                this.mCustomManager.registerListener(0, (CustomMessageListener) messageListener);
            } else {
                BdLog.e("listener invalid" + messageListener.getCmd());
            }
        }
    }

    public void registerListener(int i, MessageListener<?> messageListener) {
        if (messageListener != null) {
            n.iV();
            FrameHelper.TYPE q = FrameHelper.q(i);
            if (q == FrameHelper.TYPE.HTTP && (messageListener instanceof HttpMessageListener)) {
                this.mHttpManager.registerListener(i, (HttpMessageListener) messageListener);
            } else if (q == FrameHelper.TYPE.SOCKET && (messageListener instanceof e)) {
                this.mSocketManager.registerListener(i, (e) messageListener);
            } else if (q == FrameHelper.TYPE.CUSTOM && (messageListener instanceof CustomMessageListener)) {
                this.mCustomManager.registerListener(i, (CustomMessageListener) messageListener);
            } else {
                BdLog.e("listener invalid" + i + "|" + messageListener.getCmd());
            }
        }
    }

    public void unRegisterListener(MessageListener<?> messageListener) {
        n.iV();
        if (messageListener != null) {
            int cmd = messageListener.getCmd();
            if (cmd != 0) {
                com.baidu.adp.framework.b.c<?, ?, ?, ?> manager = getManager(cmd);
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

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        this.mHttpManager.unRegisterListener(bdUniqueId);
        this.mSocketManager.unRegisterListener(bdUniqueId);
        this.mCustomManager.unRegisterListener(bdUniqueId);
    }

    public void registerStickyMode(int i) {
        n.iV();
        com.baidu.adp.framework.b.c<?, ?, ?, ?> manager = getManager(i);
        if (manager != null) {
            manager.registerStickyMode(i);
        }
    }

    public void unRegisterStickyMode(int i) {
        n.iV();
        com.baidu.adp.framework.b.c<?, ?, ?, ?> manager = getManager(i);
        if (manager != null) {
            manager.unRegisterStickyMode(i);
        }
    }

    public void addMessageRule(f<?, ?> fVar) {
        n.iV();
        this.mController.addMessageRule(fVar);
    }

    public void removeMessageRule(f<?, ?> fVar) {
        n.iV();
        this.mController.removeMessageRule(fVar);
    }

    public void addResponsedMessageRule(g<?> gVar) {
        n.iV();
        this.mController.a(gVar);
    }

    public void removeResponsedMessageRule(g<?> gVar) {
        n.iV();
        this.mController.b(gVar);
    }

    public void addRemovedMessageRule(com.baidu.adp.framework.a.e eVar) {
        n.iV();
        this.mController.a(eVar);
    }

    public void removeRemovedMessageRule(com.baidu.adp.framework.a.e eVar) {
        n.iV();
        this.mController.b(eVar);
    }

    public i getController() {
        return this.mController;
    }

    public void dispatchResponsedMessage(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage == null) {
            BdLog.e("responsedMessage is null!!!");
            return;
        }
        int cmd = responsedMessage.getCmd();
        FrameHelper.TYPE q = FrameHelper.q(cmd);
        if (q == FrameHelper.TYPE.HTTP && (responsedMessage instanceof HttpResponsedMessage)) {
            com.baidu.adp.a.a.b.d("Response_Http", responsedMessage);
            this.mHttpManager.dispatchResponsedMessage(this.mController.a((HttpResponsedMessage) responsedMessage));
        } else if (q == FrameHelper.TYPE.SOCKET && (responsedMessage instanceof SocketResponsedMessage)) {
            com.baidu.adp.a.a.b.d("Response_Socket", responsedMessage);
            Message<?> orginalMessage = responsedMessage.getOrginalMessage();
            if (responsedMessage.getError() == l.pe && orginalMessage != null && orginalMessage.getExtra() != null && (orginalMessage.getExtra() instanceof NetMessage)) {
                NetMessage netMessage = (NetMessage) orginalMessage.getExtra();
                if (netMessage.getHttpMessage() != null && ((netMessage.getNetType() == NetMessage.NetType.AUTO || netMessage.getNetType() == NetMessage.NetType.HTTP) && sendMessage(netMessage.getHttpMessage()))) {
                    this.mCustomManager.dispatchResponsedMessage(new CustomResponsedMessage(2000999, Integer.valueOf(responsedMessage.getCmd())));
                    return;
                }
            }
            this.mSocketManager.dispatchResponsedMessage(this.mController.c((SocketResponsedMessage) responsedMessage));
        } else if (q == FrameHelper.TYPE.CUSTOM && (responsedMessage instanceof CustomResponsedMessage)) {
            this.mCustomManager.dispatchResponsedMessage(this.mController.b((CustomResponsedMessage) responsedMessage));
        } else {
            BdLog.e("responsedMessage invalid:CMD=" + cmd + " Class=" + responsedMessage.getClass().getName());
        }
    }

    public void dispatchResponsedMessageToUI(final ResponsedMessage<?> responsedMessage) {
        this.mUIHandler.post(new Runnable() { // from class: com.baidu.adp.framework.MessageManager.3
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.this.dispatchResponsedMessage(responsedMessage);
            }
        });
    }

    public void setNotFindTaskListener(com.baidu.adp.framework.listener.d<Message<?>> dVar) {
        com.baidu.adp.framework.b.c.setNotFindTaskListener(dVar);
    }

    public <T> CustomResponsedMessage<T> runTask(int i, Class<T> cls) {
        return runTask(i, cls, null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.adp.framework.b.a */
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
        return this.mCustomManager.a(customMessage, this.mCustomManager.findTask(i), cls);
    }

    public <T> CustomResponsedMessage<T> runTask(CustomMessageTask customMessageTask, Class<T> cls) {
        return this.mCustomManager.a(null, customMessageTask, cls);
    }

    public <T> CustomResponsedMessage<T> runTask(CustomMessage<?> customMessage, Class<T> cls) {
        if (customMessage == null) {
            return null;
        }
        return this.mCustomManager.a(customMessage, this.mCustomManager.findTask(customMessage.getCmd()), cls);
    }
}
