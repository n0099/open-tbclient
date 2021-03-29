package com.baidu.adp.framework;

import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.cmdRouter.CmdRouter;
import com.baidu.adp.framework.cmdRouter.MultiDexHelper;
import com.baidu.adp.framework.cmdRouter.MultiValueMap;
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
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.FieldBuilder;
import d.b.b.c.e.c.h;
import d.b.b.c.f.e;
import d.b.b.c.f.f;
import d.b.b.c.f.g;
import d.b.b.c.f.i;
import d.b.b.c.h.a;
import d.b.b.c.h.b;
import d.b.b.c.h.c;
import d.b.b.c.h.d;
import d.b.b.e.p.j;
import d.b.b.e.p.l;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class MessageManager {
    public static final String MODULE_NAME = "msgmgr";
    public static MessageManager sInstance;
    public i mController;
    public a mCustomManager;
    public b mHttpManager;
    public d mSocketManager;
    public Handler mUIHandler;
    public int mSocketMsgCWSendFailedCnt = 0;
    public int mHttpMsgCWSendFailedCnt = 0;

    public MessageManager() {
        this.mHttpManager = null;
        this.mSocketManager = null;
        this.mCustomManager = null;
        this.mController = null;
        this.mUIHandler = null;
        this.mHttpManager = new b(this);
        this.mSocketManager = new d(this);
        this.mCustomManager = new a(this);
        this.mController = new i();
        this.mUIHandler = new Handler(Looper.getMainLooper());
    }

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

    private c<?, ?, ?, ?> getManager(int i) {
        FrameHelper.TYPE e2 = FrameHelper.e(i);
        if (e2 == FrameHelper.TYPE.HTTP) {
            return this.mHttpManager;
        }
        if (e2 == FrameHelper.TYPE.SOCKET) {
            return this.mSocketManager;
        }
        if (e2 == FrameHelper.TYPE.CUSTOM) {
            return this.mCustomManager;
        }
        BdLog.e("cmd invalid");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerListenerInternal(MessageListener<?> messageListener) {
        if (messageListener == null) {
            return;
        }
        FrameHelper.TYPE e2 = FrameHelper.e(messageListener.getCmd());
        if (e2 == FrameHelper.TYPE.HTTP && (messageListener instanceof HttpMessageListener)) {
            this.mHttpManager.m(0, (HttpMessageListener) messageListener);
        } else if (e2 == FrameHelper.TYPE.SOCKET && (messageListener instanceof d.b.b.c.g.c)) {
            this.mSocketManager.m(0, (d.b.b.c.g.c) messageListener);
        } else if (e2 == FrameHelper.TYPE.CUSTOM && (messageListener instanceof CustomMessageListener)) {
            this.mCustomManager.m(0, (CustomMessageListener) messageListener);
        } else {
            BdLog.e("listener invalid" + d.b.b.c.a.a().b(messageListener.getCmd()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unRegisterListenerInternal(MessageListener<?> messageListener) {
        if (messageListener == null) {
            return;
        }
        int cmd = messageListener.getCmd();
        if (cmd != 0) {
            c<?, ?, ?, ?> manager = getManager(cmd);
            if (manager != null) {
                manager.s(messageListener);
                return;
            }
            return;
        }
        this.mHttpManager.s(messageListener);
        this.mSocketManager.s(messageListener);
        this.mCustomManager.s(messageListener);
    }

    public void abortResponsedMessage(ResponsedMessage<?> responsedMessage) {
        c<?, ?, ?, ?> manager;
        if (responsedMessage == null || (manager = getManager(responsedMessage.getCmd())) == null) {
            return;
        }
        manager.a();
    }

    public void addMessageRule(final f<?, ?> fVar) {
        if (l.B()) {
            this.mController.b(fVar);
        } else {
            this.mUIHandler.post(new Runnable() { // from class: com.baidu.adp.framework.MessageManager.10
                @Override // java.lang.Runnable
                public void run() {
                    MessageManager.this.mController.b(fVar);
                }
            });
        }
    }

    public void addRemovedMessageRule(final e eVar) {
        if (l.B()) {
            this.mController.a(eVar);
        } else {
            this.mUIHandler.post(new Runnable() { // from class: com.baidu.adp.framework.MessageManager.14
                @Override // java.lang.Runnable
                public void run() {
                    MessageManager.this.mController.a(eVar);
                }
            });
        }
    }

    public void addResponsedMessageRule(final g<?> gVar) {
        if (l.B()) {
            this.mController.c(gVar);
        } else {
            this.mUIHandler.post(new Runnable() { // from class: com.baidu.adp.framework.MessageManager.12
                @Override // java.lang.Runnable
                public void run() {
                    MessageManager.this.mController.c(gVar);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0290  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void dispatchResponsedMessage(final ResponsedMessage<?> responsedMessage) {
        if (responsedMessage == null) {
            BdLog.e("responsedMessage is null!!!");
        } else if (!l.B()) {
            this.mUIHandler.post(new Runnable() { // from class: com.baidu.adp.framework.MessageManager.16
                @Override // java.lang.Runnable
                public void run() {
                    MessageManager.this.dispatchResponsedMessage(responsedMessage);
                }
            });
        } else {
            int cmd = responsedMessage.getCmd();
            FrameHelper.TYPE e2 = FrameHelper.e(cmd);
            if (e2 == FrameHelper.TYPE.HTTP && (responsedMessage instanceof HttpResponsedMessage)) {
                d.b.b.b.a.a.h("Response_Http", responsedMessage);
                if (responsedMessage.getError() != 0) {
                    if (j.z()) {
                        this.mHttpMsgCWSendFailedCnt++;
                        if (this.mHttpMsgCWSendFailedCnt >= d.b.b.e.n.k.a.o().q("alert_http", 3)) {
                            BdStatisticsManager.getInstance().alert("alert_http", "errCode=" + responsedMessage.getError() + responsedMessage.getErrorString());
                        }
                    }
                } else {
                    this.mHttpMsgCWSendFailedCnt = 0;
                }
                this.mHttpManager.d(this.mController.j((HttpResponsedMessage) responsedMessage));
            } else if (e2 == FrameHelper.TYPE.SOCKET && (responsedMessage instanceof SocketResponsedMessage)) {
                d.b.b.b.a.a.h("Response_Socket", responsedMessage);
                if (responsedMessage.getError() != 0) {
                    if (j.z()) {
                        this.mSocketMsgCWSendFailedCnt++;
                        if (this.mSocketMsgCWSendFailedCnt >= d.b.b.e.n.k.a.o().q("alert_im", 3)) {
                            BdStatisticsManager.getInstance().alert("alert_im", "errCode=" + responsedMessage.getError() + responsedMessage.getErrorString());
                        }
                    }
                } else {
                    this.mSocketMsgCWSendFailedCnt = 0;
                }
                Message<?> orginalMessage = responsedMessage.getOrginalMessage();
                if (orginalMessage != null && orginalMessage.getExtra() != null && (orginalMessage.getExtra() instanceof NetMessage)) {
                    NetMessage netMessage = (NetMessage) orginalMessage.getExtra();
                    if (netMessage.getHttpMessage() != null && netMessage.getNetType() == NetMessage.NetType.AUTO) {
                        NetMessage.a switchToHttpStrategy = netMessage.getSwitchToHttpStrategy();
                        if ((switchToHttpStrategy != null ? switchToHttpStrategy.checkToSwitchHttp((SocketResponsedMessage) responsedMessage) : false) || responsedMessage.getError() == h.m) {
                            int i = 5;
                            if (responsedMessage.getError() == h.m) {
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
                            HttpMessage httpMessage = netMessage.getHttpMessage();
                            if (httpMessage != null && i == 9) {
                                httpMessage.addHeader("Retry-Count", "1");
                            }
                            if (sendMessage(httpMessage)) {
                                this.mCustomManager.d(new CustomResponsedMessage(2000999, Integer.valueOf(responsedMessage.getCmd())));
                                return;
                            }
                        }
                    }
                }
                this.mSocketManager.d(this.mController.n((SocketResponsedMessage) responsedMessage));
            } else if (e2 == FrameHelper.TYPE.CUSTOM && (responsedMessage instanceof CustomResponsedMessage)) {
                final CustomResponsedMessage<?> h2 = this.mController.h((CustomResponsedMessage) responsedMessage);
                if (CmdRouter.cmdMaps.containsKey(cmd + "")) {
                    try {
                        if (cmd == 2002001) {
                            List<String> values = CmdRouter.cmdMaps.getValues(h2.getCmd() + "");
                            String cls = h2.getData().getClass().toString();
                            String substring = cls.substring(cls.lastIndexOf(".") + 1);
                            for (String str : values) {
                                if (CmdRouter.configMaps.getValues(str).get(0).contains(substring)) {
                                    Class.forName(str);
                                    CmdRouter.configMaps.getValues(str).get(0).remove(substring);
                                }
                            }
                        } else {
                            boolean z = false;
                            for (String str2 : CmdRouter.cmdMaps.getValues(cmd + "")) {
                                try {
                                    System.currentTimeMillis();
                                    z = MultiDexHelper.task != null && MultiDexHelper.task.loadingClass(str2);
                                    Class.forName(str2);
                                } catch (Throwable th) {
                                    th = th;
                                    r6 = z;
                                    BdLog.e(th);
                                    if (!r6) {
                                    }
                                }
                            }
                            CmdRouter.cmdMaps.remove(cmd + "");
                            r6 = z;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                if (!r6) {
                    this.mUIHandler.postDelayed(new Runnable() { // from class: com.baidu.adp.framework.MessageManager.17
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.this.mCustomManager.d((CustomResponsedMessage) h2);
                        }
                    }, 1L);
                } else {
                    this.mCustomManager.d(h2);
                }
            } else {
                BdLog.e("responsedMessage invalid:CMD=" + d.b.b.c.a.a().b(cmd) + " Class=" + responsedMessage.getClass().getName());
            }
        }
    }

    @Deprecated
    public void dispatchResponsedMessageToUI(ResponsedMessage<?> responsedMessage) {
        dispatchResponsedMessage(responsedMessage);
    }

    public LinkedList<CustomMessage<?>> findCustomMessage(BdUniqueId bdUniqueId) {
        return this.mCustomManager.v(bdUniqueId);
    }

    public ArrayList<CustomMessageTask> findCustomTasks() {
        return this.mCustomManager.i();
    }

    public LinkedList<HttpMessage> findHttpMessage(BdUniqueId bdUniqueId) {
        return this.mHttpManager.v(bdUniqueId);
    }

    public ArrayList<HttpMessageTask> findHttpTasks() {
        return this.mHttpManager.i();
    }

    /* JADX DEBUG: Type inference failed for r2v3. Raw type applied. Possible types: java.util.LinkedList<?>, java.util.LinkedList<? extends com.baidu.adp.framework.message.Message> */
    public LinkedList<? extends Message> findMessage(int i, BdUniqueId bdUniqueId) {
        c<?, ?, ?, ?> manager = getManager(i);
        if (manager != null) {
            return manager.e(i, bdUniqueId);
        }
        BdLog.e("cmd invalid");
        return null;
    }

    public LinkedList<SocketMessage> findSocketMessage(BdUniqueId bdUniqueId) {
        return this.mSocketManager.v(bdUniqueId);
    }

    public ArrayList<SocketMessageTask> findSocketTasks() {
        return this.mSocketManager.i();
    }

    public MessageTask findTask(int i) {
        FrameHelper.TYPE e2 = FrameHelper.e(i);
        if (FrameHelper.TYPE.HTTP == e2) {
            return this.mHttpManager.g(i);
        }
        if (FrameHelper.TYPE.SOCKET == e2) {
            return this.mSocketManager.g(i);
        }
        if (FrameHelper.TYPE.CUSTOM == e2) {
            try {
                MultiValueMap<String, String> multiValueMap = CmdRouter.cmdMaps;
                List<String> values = multiValueMap.getValues(i + "");
                if (values != null && values.size() > 0) {
                    for (String str : values) {
                        Class.forName(str);
                    }
                    MultiValueMap<String, String> multiValueMap2 = CmdRouter.cmdMaps;
                    multiValueMap2.remove(i + "");
                }
            } catch (Throwable th) {
                BdLog.e(th);
            }
            return this.mCustomManager.g(i);
        }
        return null;
    }

    public i getController() {
        return this.mController;
    }

    public d.b.b.c.e.c.g getSocketClient() {
        return this.mSocketManager.w();
    }

    public void registerListener(final d.b.b.c.g.a aVar) {
        if (aVar == null) {
            return;
        }
        if (l.B()) {
            this.mHttpManager.m(0, aVar.getHttpMessageListener());
            this.mSocketManager.m(0, aVar.getSocketMessageListener());
            return;
        }
        this.mUIHandler.post(new Runnable() { // from class: com.baidu.adp.framework.MessageManager.2
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.this.mHttpManager.m(0, aVar.getHttpMessageListener());
                MessageManager.this.mSocketManager.m(0, aVar.getSocketMessageListener());
            }
        });
    }

    public void registerListenerFromBackground(final MessageListener<?> messageListener) {
        if (messageListener == null) {
            return;
        }
        if (l.B()) {
            registerListener(messageListener);
        } else {
            this.mUIHandler.post(new Runnable() { // from class: com.baidu.adp.framework.MessageManager.5
                @Override // java.lang.Runnable
                public void run() {
                    MessageManager.this.registerListener(messageListener);
                }
            });
        }
    }

    public void registerStickyMode(int i) {
        c<?, ?, ?, ?> manager = getManager(i);
        if (manager != null) {
            manager.n(i);
        }
    }

    public void registerTask(MessageTask messageTask) {
        if (messageTask == null) {
            return;
        }
        if (messageTask instanceof HttpMessageTask) {
            this.mHttpManager.o((HttpMessageTask) messageTask);
        } else if (messageTask instanceof SocketMessageTask) {
            this.mSocketManager.o((SocketMessageTask) messageTask);
        } else if (messageTask instanceof CustomMessageTask) {
            this.mCustomManager.o((CustomMessageTask) messageTask);
        } else {
            BdLog.e("task invalid");
        }
    }

    public void removeCustomMessage(BdUniqueId bdUniqueId) {
        this.mCustomManager.x(bdUniqueId);
        this.mController.p(bdUniqueId);
    }

    public void removeHttpMessage(BdUniqueId bdUniqueId) {
        this.mHttpManager.x(bdUniqueId);
        this.mController.p(bdUniqueId);
    }

    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        c<?, ?, ?, ?> manager = getManager(i);
        if (manager != null) {
            manager.h(i, bdUniqueId);
            this.mController.o(i, bdUniqueId);
            return;
        }
        BdLog.e("cmd invalid");
    }

    public void removeMessageRule(final f<?, ?> fVar) {
        if (l.B()) {
            this.mController.e(fVar);
        } else {
            this.mUIHandler.post(new Runnable() { // from class: com.baidu.adp.framework.MessageManager.11
                @Override // java.lang.Runnable
                public void run() {
                    MessageManager.this.mController.e(fVar);
                }
            });
        }
    }

    public void removeRemovedMessageRule(final e eVar) {
        if (l.B()) {
            this.mController.d(eVar);
        } else {
            this.mUIHandler.post(new Runnable() { // from class: com.baidu.adp.framework.MessageManager.15
                @Override // java.lang.Runnable
                public void run() {
                    MessageManager.this.mController.d(eVar);
                }
            });
        }
    }

    public void removeResponsedMessageRule(final g<?> gVar) {
        if (l.B()) {
            this.mController.f(gVar);
        } else {
            this.mUIHandler.post(new Runnable() { // from class: com.baidu.adp.framework.MessageManager.13
                @Override // java.lang.Runnable
                public void run() {
                    MessageManager.this.mController.f(gVar);
                }
            });
        }
    }

    public void removeSocketMessage(BdUniqueId bdUniqueId) {
        this.mSocketManager.y(bdUniqueId);
        this.mController.p(bdUniqueId);
    }

    public <T> CustomResponsedMessage<T> runTask(int i, Class<T> cls) {
        return runTask(i, cls, null);
    }

    public boolean sendMessage(Message<?> message) {
        if (message == null) {
            return false;
        }
        message.setStartTime(System.currentTimeMillis());
        if (message instanceof HttpMessage) {
            d.b.b.b.a.a.h("Request_Http", message);
            return this.mHttpManager.c((HttpMessage) message, null);
        } else if (message instanceof SocketMessage) {
            d.b.b.b.a.a.h("Request_Socket", message);
            return this.mSocketManager.c((SocketMessage) message, null);
        } else if (!(message instanceof CustomMessage)) {
            BdLog.e("message invalid" + d.b.b.c.a.a().b(message.getCmd()));
            return false;
        } else {
            CustomMessage customMessage = (CustomMessage) message;
            if (customMessage.getData() != null) {
                MultiValueMap<String, String> multiValueMap = CmdRouter.cmdMaps;
                if (multiValueMap.containsKey(message.getCmd() + "")) {
                    try {
                        if (message.getCmd() == 2002001) {
                            MultiValueMap<String, String> multiValueMap2 = CmdRouter.cmdMaps;
                            List<String> values = multiValueMap2.getValues(message.getCmd() + "");
                            String cls = ((CustomMessage) message).getData().getClass().toString();
                            String substring = cls.substring(cls.lastIndexOf(".") + 1);
                            for (String str : values) {
                                if (CmdRouter.configMaps.getValues(str).get(0).contains(substring)) {
                                    Class.forName(str);
                                    CmdRouter.configMaps.getValues(str).get(0).remove(substring);
                                }
                            }
                        } else {
                            MultiValueMap<String, String> multiValueMap3 = CmdRouter.cmdMaps;
                            for (String str2 : multiValueMap3.getValues(message.getCmd() + "")) {
                                System.currentTimeMillis();
                                Class.forName(str2);
                            }
                            MultiValueMap<String, String> multiValueMap4 = CmdRouter.cmdMaps;
                            multiValueMap4.remove(message.getCmd() + "");
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }
            return this.mCustomManager.c(customMessage, null);
        }
    }

    public void sendMessageFromBackground(final Message<?> message) {
        if (message == null) {
            return;
        }
        this.mUIHandler.post(new Runnable() { // from class: com.baidu.adp.framework.MessageManager.1
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.this.sendMessage(message);
            }
        });
    }

    public void setNotFindTaskListener(d.b.b.c.g.b<Message<?>> bVar) {
        c.p(bVar);
    }

    public void unRegisterListener(final d.b.b.c.g.a aVar) {
        if (aVar == null) {
            return;
        }
        if (l.B()) {
            this.mHttpManager.s(aVar.getHttpMessageListener());
            this.mSocketManager.s(aVar.getSocketMessageListener());
            return;
        }
        this.mUIHandler.post(new Runnable() { // from class: com.baidu.adp.framework.MessageManager.4
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.this.mHttpManager.s(aVar.getHttpMessageListener());
                MessageManager.this.mSocketManager.s(aVar.getSocketMessageListener());
            }
        });
    }

    public void unRegisterStickyMode(int i) {
        l.d();
        c<?, ?, ?, ?> manager = getManager(i);
        if (manager != null) {
            manager.t(i);
        }
    }

    public void unRegisterTask(int i) {
        c<?, ?, ?, ?> manager = getManager(i);
        if (manager != null) {
            manager.u(i);
        }
    }

    public <T> CustomResponsedMessage<T> runTask(int i, Class<T> cls, Object obj) {
        CustomMessage<?> customMessage;
        if (obj != null) {
            customMessage = new CustomMessage<>(i);
            customMessage.setData(obj);
        } else {
            customMessage = null;
        }
        MultiValueMap<String, String> multiValueMap = CmdRouter.cmdMaps;
        if (multiValueMap.containsKey(i + "")) {
            try {
                if (i == 2002001) {
                    MultiValueMap<String, String> multiValueMap2 = CmdRouter.cmdMaps;
                    List<String> values = multiValueMap2.getValues(i + "");
                    String cls2 = customMessage.getData().getClass().toString();
                    String substring = cls2.substring(cls2.lastIndexOf(".") + 1);
                    for (String str : values) {
                        if (CmdRouter.configMaps.getValues(str).get(0).contains(substring)) {
                            Class.forName(str);
                            CmdRouter.configMaps.getValues(str).get(0).remove(substring);
                        }
                    }
                } else {
                    MultiValueMap<String, String> multiValueMap3 = CmdRouter.cmdMaps;
                    for (String str2 : multiValueMap3.getValues(i + "")) {
                        System.currentTimeMillis();
                        Class.forName(str2);
                    }
                    MultiValueMap<String, String> multiValueMap4 = CmdRouter.cmdMaps;
                    multiValueMap4.remove(i + "");
                }
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
        a aVar = this.mCustomManager;
        return aVar.y(customMessage, aVar.g(i), cls);
    }

    public void registerListener(final int i, final d.b.b.c.g.a aVar) {
        if (aVar == null) {
            return;
        }
        if (l.B()) {
            this.mHttpManager.m(i, aVar.getHttpMessageListener());
            this.mSocketManager.m(i, aVar.getSocketMessageListener());
            return;
        }
        this.mUIHandler.post(new Runnable() { // from class: com.baidu.adp.framework.MessageManager.3
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.this.mHttpManager.m(i, aVar.getHttpMessageListener());
                MessageManager.this.mSocketManager.m(i, aVar.getSocketMessageListener());
            }
        });
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        removeSocketMessage(bdUniqueId);
        removeCustomMessage(bdUniqueId);
        removeHttpMessage(bdUniqueId);
    }

    public void unRegisterListener(final MessageListener<?> messageListener) {
        if (messageListener == null) {
            return;
        }
        if (l.B()) {
            unRegisterListenerInternal(messageListener);
        } else {
            this.mUIHandler.post(new Runnable() { // from class: com.baidu.adp.framework.MessageManager.8
                @Override // java.lang.Runnable
                public void run() {
                    MessageManager.this.unRegisterListenerInternal(messageListener);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unRegisterListenerInternal(BdUniqueId bdUniqueId) {
        this.mHttpManager.r(bdUniqueId);
        this.mSocketManager.r(bdUniqueId);
        this.mCustomManager.r(bdUniqueId);
    }

    public void unRegisterListener(final BdUniqueId bdUniqueId) {
        if (l.B()) {
            unRegisterListenerInternal(bdUniqueId);
        } else {
            this.mUIHandler.post(new Runnable() { // from class: com.baidu.adp.framework.MessageManager.9
                @Override // java.lang.Runnable
                public void run() {
                    MessageManager.this.unRegisterListenerInternal(bdUniqueId);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerListenerInternal(int i, MessageListener<?> messageListener) {
        if (messageListener == null) {
            return;
        }
        FrameHelper.TYPE e2 = FrameHelper.e(i);
        if (e2 == FrameHelper.TYPE.HTTP && (messageListener instanceof HttpMessageListener)) {
            this.mHttpManager.m(i, (HttpMessageListener) messageListener);
        } else if (e2 == FrameHelper.TYPE.SOCKET && (messageListener instanceof d.b.b.c.g.c)) {
            this.mSocketManager.m(i, (d.b.b.c.g.c) messageListener);
        } else if (e2 == FrameHelper.TYPE.CUSTOM && (messageListener instanceof CustomMessageListener)) {
            this.mCustomManager.m(i, (CustomMessageListener) messageListener);
        } else {
            BdLog.e("listener invalid" + d.b.b.c.a.a().b(i) + FieldBuilder.SE + d.b.b.c.a.a().b(messageListener.getCmd()));
        }
    }

    public void registerListener(final MessageListener<?> messageListener) {
        if (messageListener == null) {
            return;
        }
        if (l.B()) {
            registerListenerInternal(messageListener);
        } else {
            this.mUIHandler.post(new Runnable() { // from class: com.baidu.adp.framework.MessageManager.6
                @Override // java.lang.Runnable
                public void run() {
                    MessageManager.this.registerListenerInternal(messageListener);
                }
            });
        }
    }

    public void registerListener(final int i, final MessageListener<?> messageListener) {
        if (messageListener == null) {
            return;
        }
        if (l.B()) {
            registerListenerInternal(i, messageListener);
        } else {
            this.mUIHandler.post(new Runnable() { // from class: com.baidu.adp.framework.MessageManager.7
                @Override // java.lang.Runnable
                public void run() {
                    MessageManager.this.registerListenerInternal(i, messageListener);
                }
            });
        }
    }

    public <T> CustomResponsedMessage<T> runTask(CustomMessageTask customMessageTask, Class<T> cls) {
        return this.mCustomManager.y(null, customMessageTask, cls);
    }

    public <T> CustomResponsedMessage<T> runTask(CustomMessage<?> customMessage, Class<T> cls) {
        if (customMessage == null) {
            return null;
        }
        a aVar = this.mCustomManager;
        return aVar.y(customMessage, aVar.g(customMessage.getCmd()), cls);
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
        boolean v = getSocketClient().v();
        if (!v) {
            netMessage.setSocketErrNo(1);
        }
        if (v && sendMessage(netMessage.getSocketMessage())) {
            d.b.b.c.e.c.i.c(MODULE_NAME, netMessage.getSocketMessage(), 0, "sendMessage", 0, "socket");
            return true;
        }
        d.b.b.c.e.c.i.c(MODULE_NAME, netMessage.getSocketMessage(), 0, "sendMessage", 0, "https");
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
        boolean v = getSocketClient().v();
        if (!v) {
            netMessage.setSocketErrNo(1);
        }
        if (v && sendMessage(netMessage.getSocketMessage(), socketMessageTask)) {
            d.b.b.c.e.c.i.c(MODULE_NAME, netMessage.getSocketMessage(), 0, "sendMessage", 0, "socket");
            return true;
        }
        d.b.b.c.e.c.i.c(MODULE_NAME, netMessage.getSocketMessage(), 0, "sendMessage", 0, "https");
        return sendMessage(netMessage.getHttpMessage(), httpMessageTask);
    }

    public boolean sendMessage(Message<?> message, MessageTask messageTask) {
        if (message == null) {
            return false;
        }
        if ((message instanceof HttpMessage) && (messageTask instanceof HttpMessageTask)) {
            d.b.b.b.a.a.h("Request_Http", message);
            return this.mHttpManager.c((HttpMessage) message, (HttpMessageTask) messageTask);
        } else if ((message instanceof SocketMessage) && (messageTask instanceof SocketMessageTask)) {
            d.b.b.b.a.a.h("Request_Socket", message);
            return this.mSocketManager.c((SocketMessage) message, (SocketMessageTask) messageTask);
        } else if ((message instanceof CustomMessage) && (messageTask instanceof CustomMessageTask)) {
            return this.mCustomManager.c((CustomMessage) message, (CustomMessageTask) messageTask);
        } else {
            BdLog.e("message and task invalid:" + d.b.b.c.a.a().b(message.getCmd()));
            return false;
        }
    }
}
