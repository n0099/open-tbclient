package com.baidu.adp.framework;

import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.a.g;
import com.baidu.adp.framework.a.h;
import com.baidu.adp.framework.a.i;
import com.baidu.adp.framework.a.k;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.listener.MessageListener;
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
import com.baidu.tbadk.core.frameworkData.CmdConfig;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MessageManager {
    private static MessageManager sInstance = null;
    private k mController;
    private com.baidu.adp.framework.b.a mCustomManager;
    private com.baidu.adp.framework.b.b mHttpManager;
    private com.baidu.adp.framework.b.d mSocketManager;
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
        this.mSocketManager = new com.baidu.adp.framework.b.d(this);
        this.mCustomManager = new com.baidu.adp.framework.b.a(this);
        this.mController = new k();
        this.mUIHandler = new Handler(Looper.getMainLooper());
    }

    public com.baidu.adp.framework.b.d getSocketManager() {
        return this.mSocketManager;
    }

    private com.baidu.adp.framework.b.c<?, ?, ?, ?> getManager(int i) {
        FrameHelper.TYPE a = FrameHelper.a(i);
        if (a == FrameHelper.TYPE.HTTP) {
            return this.mHttpManager;
        }
        if (a == FrameHelper.TYPE.SOCKET) {
            return this.mSocketManager;
        }
        if (a == FrameHelper.TYPE.CUSTOM) {
            return this.mCustomManager;
        }
        BdLog.e("cmd invalid");
        return null;
    }

    public boolean sendMessage(Message<?> message) {
        if (message == null) {
            return false;
        }
        if (message instanceof HttpMessage) {
            com.baidu.adp.lib.debug.a.a("Request_Http", message);
            return this.mHttpManager.c((HttpMessage) message, null);
        } else if (message instanceof SocketMessage) {
            com.baidu.adp.lib.debug.a.a("Request_Socket", message);
            return this.mSocketManager.c((SocketMessage) message, null);
        } else if (message instanceof CustomMessage) {
            return this.mCustomManager.c((CustomMessage) message, null);
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
        if (this.mSocketManager.b() && (netMessage.getNetType() == NetMessage.NetType.AUTO || netMessage.getNetType() == NetMessage.NetType.SOCKET)) {
            com.baidu.adp.lib.debug.a.a("Request_Socket", netMessage);
            if (this.mSocketManager.c(netMessage.getSocketMessage(), null)) {
                return true;
            }
        }
        com.baidu.adp.lib.debug.a.a("Request_Http", netMessage);
        return this.mHttpManager.c(netMessage.getHttpMessage(), null);
    }

    public void sendMessage(Message<?> message, MessageTask messageTask) {
        if (message != null) {
            if ((message instanceof HttpMessage) && (messageTask instanceof HttpMessageTask)) {
                com.baidu.adp.lib.debug.a.a("Request_Http", message);
                this.mHttpManager.c((HttpMessage) message, (HttpMessageTask) messageTask);
            } else if ((message instanceof SocketMessage) && (messageTask instanceof SocketMessageTask)) {
                com.baidu.adp.lib.debug.a.a("Request_Socket", message);
                this.mSocketManager.c((SocketMessage) message, (SocketMessageTask) messageTask);
            } else if ((message instanceof CustomMessage) && (messageTask instanceof CustomMessageTask)) {
                this.mCustomManager.c((CustomMessage) message, (CustomMessageTask) messageTask);
            } else {
                BdLog.e("message and task invalid:" + message.getCmd());
            }
        }
    }

    public LinkedList<HttpMessage> findHttpMessage(int i) {
        return this.mHttpManager.b(i);
    }

    public LinkedList<SocketMessage> findSocketMessage(int i) {
        return this.mSocketManager.b(i);
    }

    public LinkedList<CustomMessage<?>> findCustomMessage(int i) {
        return this.mCustomManager.b(i);
    }

    /* JADX DEBUG: Type inference failed for r0v3. Raw type applied. Possible types: java.util.LinkedList<M>, java.util.LinkedList<? extends com.baidu.adp.framework.message.Message> */
    public LinkedList<? extends Message> findMessage(int i, int i2) {
        com.baidu.adp.framework.b.c<?, ?, ?, ?> manager = getManager(i);
        if (manager != null) {
            return manager.b(i, i2);
        }
        BdLog.e("cmd invalid");
        return null;
    }

    public void removeMessage(int i, int i2) {
        com.baidu.adp.framework.b.c<?, ?, ?, ?> manager = getManager(i);
        if (manager != null) {
            ruleRemovedMessage(manager.a(i, i2));
        } else {
            BdLog.e("cmd invalid");
        }
    }

    public void removeSocketMessage(int i) {
        ruleRemovedMessage(this.mSocketManager.a(i));
    }

    public void removeCustomMessage(int i) {
        ruleRemovedMessage(this.mCustomManager.a(i));
    }

    public void removeHttpMessage(int i) {
        ruleRemovedMessage(this.mHttpManager.a(i));
    }

    public void removeMessage(int i) {
        removeSocketMessage(i);
        removeCustomMessage(i);
        removeHttpMessage(i);
    }

    private void ruleRemovedMessage(LinkedList<?> linkedList) {
        if (linkedList != null) {
            Iterator<?> it = linkedList.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next != null && (next instanceof Message)) {
                    if (next instanceof HttpMessage) {
                        com.baidu.adp.lib.debug.a.a("Remove_Http", next);
                        this.mController.a((HttpMessage) next);
                    } else if (next instanceof SocketMessage) {
                        com.baidu.adp.lib.debug.a.a("Remove_Socket", next);
                        this.mController.a((SocketMessage) next);
                    } else if (next instanceof CustomMessage) {
                        com.baidu.adp.lib.debug.a.a("Remove_Custom", next);
                        this.mController.a((CustomMessage) next);
                    } else {
                        BdLog.e("message invalid" + ((Message) next).getCmd());
                    }
                }
            }
        }
    }

    public void abortResponsedMessage(ResponsedMessage<?> responsedMessage) {
        com.baidu.adp.framework.b.c<?, ?, ?, ?> manager;
        if (responsedMessage != null && (manager = getManager(responsedMessage.getCmd())) != null) {
            manager.a();
        }
    }

    public void registerTask(MessageTask messageTask) {
        if (messageTask != null) {
            com.baidu.adp.lib.util.k.b();
            if (messageTask instanceof HttpMessageTask) {
                this.mHttpManager.a((com.baidu.adp.framework.b.b) ((HttpMessageTask) messageTask));
            } else if (messageTask instanceof SocketMessageTask) {
                this.mSocketManager.a((com.baidu.adp.framework.b.d) ((SocketMessageTask) messageTask));
            } else if (messageTask instanceof CustomMessageTask) {
                this.mCustomManager.a((com.baidu.adp.framework.b.a) ((CustomMessageTask) messageTask));
            } else {
                BdLog.e("task invalid");
            }
        }
    }

    public MessageTask findTask(int i) {
        FrameHelper.TYPE a = FrameHelper.a(i);
        if (FrameHelper.TYPE.HTTP == a) {
            return this.mHttpManager.d(i);
        }
        if (FrameHelper.TYPE.SOCKET == a) {
            return this.mSocketManager.d(i);
        }
        if (FrameHelper.TYPE.CUSTOM != a) {
            return null;
        }
        return this.mCustomManager.d(i);
    }

    public void unRegisterTask(int i) {
        com.baidu.adp.lib.util.k.b();
        com.baidu.adp.framework.b.c<?, ?, ?, ?> manager = getManager(i);
        if (manager != null) {
            manager.c(i);
        }
    }

    public void registerListener(com.baidu.adp.framework.listener.a aVar) {
        if (aVar != null) {
            this.mHttpManager.a(0, aVar.a());
            this.mSocketManager.a(0, aVar.b());
        }
    }

    public void registerListener(int i, com.baidu.adp.framework.listener.a aVar) {
        if (aVar != null) {
            this.mHttpManager.a(i, aVar.a());
            this.mSocketManager.a(i, aVar.b());
        }
    }

    public void unRegisterListener(com.baidu.adp.framework.listener.a aVar) {
        if (aVar != null) {
            this.mHttpManager.a(aVar.a());
            this.mSocketManager.a(aVar.b());
        }
    }

    public void registerListenerFromBackground(final MessageListener<?> messageListener) {
        if (messageListener != null) {
            if (com.baidu.adp.lib.util.k.c()) {
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
            com.baidu.adp.lib.util.k.b();
            FrameHelper.TYPE a = FrameHelper.a(messageListener.getCmd());
            if (a == FrameHelper.TYPE.HTTP && (messageListener instanceof HttpMessageListener)) {
                this.mHttpManager.a(0, (HttpMessageListener) messageListener);
            } else if (a == FrameHelper.TYPE.SOCKET && (messageListener instanceof com.baidu.adp.framework.listener.b)) {
                this.mSocketManager.a(0, (com.baidu.adp.framework.listener.b) messageListener);
            } else if (a == FrameHelper.TYPE.CUSTOM && (messageListener instanceof CustomMessageListener)) {
                this.mCustomManager.a(0, (CustomMessageListener) messageListener);
            } else {
                BdLog.e("listener invalid" + messageListener.getCmd());
            }
        }
    }

    public void registerListener(int i, MessageListener<?> messageListener) {
        if (messageListener != null) {
            com.baidu.adp.lib.util.k.b();
            FrameHelper.TYPE a = FrameHelper.a(i);
            if (a == FrameHelper.TYPE.HTTP && (messageListener instanceof HttpMessageListener)) {
                this.mHttpManager.a(i, (HttpMessageListener) messageListener);
            } else if (a == FrameHelper.TYPE.SOCKET && (messageListener instanceof com.baidu.adp.framework.listener.b)) {
                this.mSocketManager.a(i, (com.baidu.adp.framework.listener.b) messageListener);
            } else if (a == FrameHelper.TYPE.CUSTOM && (messageListener instanceof CustomMessageListener)) {
                this.mCustomManager.a(i, (CustomMessageListener) messageListener);
            } else {
                BdLog.e("listener invalid" + i + "|" + messageListener.getCmd());
            }
        }
    }

    public void unRegisterListener(MessageListener<?> messageListener) {
        com.baidu.adp.lib.util.k.b();
        if (messageListener != null) {
            int cmd = messageListener.getCmd();
            if (cmd != 0) {
                com.baidu.adp.framework.b.c<?, ?, ?, ?> manager = getManager(cmd);
                if (manager != null) {
                    manager.a((MessageListener) messageListener);
                    return;
                }
                return;
            }
            this.mHttpManager.a(messageListener);
            this.mSocketManager.a(messageListener);
            this.mCustomManager.a(messageListener);
        }
    }

    public void unRegisterListener(int i) {
        this.mHttpManager.e(i);
        this.mSocketManager.e(i);
        this.mCustomManager.e(i);
    }

    public void registerStickyMode(int i) {
        com.baidu.adp.lib.util.k.b();
        com.baidu.adp.framework.b.c<?, ?, ?, ?> manager = getManager(i);
        if (manager != null) {
            manager.f(i);
        }
    }

    public void unRegisterStickyMode(int i) {
        com.baidu.adp.lib.util.k.b();
        com.baidu.adp.framework.b.c<?, ?, ?, ?> manager = getManager(i);
        if (manager != null) {
            manager.g(i);
        }
    }

    public void addMessageRule(h<?, ?> hVar) {
        com.baidu.adp.lib.util.k.b();
        this.mController.a(hVar);
    }

    public void removeMessageRule(h<?, ?> hVar) {
        com.baidu.adp.lib.util.k.b();
        this.mController.b(hVar);
    }

    public void addResponsedMessageRule(i<?> iVar) {
        com.baidu.adp.lib.util.k.b();
        this.mController.a(iVar);
    }

    public void removeResponsedMessageRule(i<?> iVar) {
        com.baidu.adp.lib.util.k.b();
        this.mController.b(iVar);
    }

    public void addRemovedMessageRule(g<?> gVar) {
        com.baidu.adp.lib.util.k.b();
        this.mController.a(gVar);
    }

    public void removeRemovedMessageRule(g<?> gVar) {
        com.baidu.adp.lib.util.k.b();
        this.mController.a(gVar);
    }

    public k getController() {
        return this.mController;
    }

    public void setOnMesssageCallback(com.baidu.adp.framework.c.d dVar) {
        this.mSocketManager.a(dVar);
    }

    public void setConnStateCallback(com.baidu.adp.lib.network.websocket.c cVar) {
        this.mSocketManager.a(cVar);
    }

    public void setSocketMessageBlock(boolean z) {
        this.mSocketManager.a(z);
    }

    protected boolean isQueueBlocked() {
        return this.mSocketManager.c();
    }

    public void dispatchResponsedMessage(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage == null) {
            BdLog.e("responsedMessage is null!!!");
            return;
        }
        int cmd = responsedMessage.getCmd();
        FrameHelper.TYPE a = FrameHelper.a(cmd);
        if (a == FrameHelper.TYPE.HTTP && (responsedMessage instanceof HttpResponsedMessage)) {
            com.baidu.adp.lib.debug.a.a("Response_Http", responsedMessage);
            this.mHttpManager.a((com.baidu.adp.framework.b.b) this.mController.a((HttpResponsedMessage) responsedMessage));
        } else if (a == FrameHelper.TYPE.SOCKET && (responsedMessage instanceof SocketResponsedMessage)) {
            com.baidu.adp.lib.debug.a.a("Response_Socket", responsedMessage);
            Message<?> orginalMessage = responsedMessage.getOrginalMessage();
            if (responsedMessage.getError() == -2003001 && orginalMessage != null && orginalMessage.getExtra() != null && (orginalMessage.getExtra() instanceof NetMessage)) {
                NetMessage netMessage = (NetMessage) orginalMessage.getExtra();
                if (netMessage.getHttpMessage() != null && ((netMessage.getNetType() == NetMessage.NetType.AUTO || netMessage.getNetType() == NetMessage.NetType.HTTP) && sendMessage(netMessage.getHttpMessage()))) {
                    this.mCustomManager.a((com.baidu.adp.framework.b.a) new CustomResponsedMessage(CmdConfig.CMD_DEBUGLOG_SPECIFIED, Integer.valueOf(responsedMessage.getCmd())));
                    return;
                }
            }
            this.mSocketManager.a((com.baidu.adp.framework.b.d) this.mController.a((SocketResponsedMessage) responsedMessage));
        } else if (a == FrameHelper.TYPE.CUSTOM && (responsedMessage instanceof CustomResponsedMessage)) {
            this.mCustomManager.a((com.baidu.adp.framework.b.a) this.mController.a((CustomResponsedMessage) responsedMessage));
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
}
