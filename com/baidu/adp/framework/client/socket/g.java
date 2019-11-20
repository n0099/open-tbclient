package com.baidu.adp.framework.client.socket;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.coder.CoderException;
import com.baidu.adp.framework.client.socket.d;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.lib.webSocket.k;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.framework.client.a<SocketMessage, SocketMessageTask> implements com.baidu.adp.framework.client.socket.link.a {
    private d.a lA;
    private com.baidu.adp.framework.client.socket.link.a lB;
    private b lC;
    private int mCWProtobufParseErrCnt;
    private boolean mIsBlock;
    private long mLastReceDataTime;
    private final LinkedList<e> mTimeOutQueue;
    private final LinkedList<e> mWaitSendQueue;
    private final LinkedList<e> mWaitingAckQueue;

    public g(MessageManager messageManager) {
        super(messageManager);
        this.lA = null;
        this.mWaitingAckQueue = new LinkedList<>();
        this.mWaitSendQueue = new LinkedList<>();
        this.mTimeOutQueue = new LinkedList<>();
        this.lB = null;
        this.mIsBlock = true;
        this.lC = null;
        this.mLastReceDataTime = 0L;
        this.mCWProtobufParseErrCnt = 0;
        BdSocketLinkService.setConnStateCallBack(this);
        this.lA = new d.a() { // from class: com.baidu.adp.framework.client.socket.g.1
            @Override // com.baidu.adp.framework.client.socket.d.a
            public void a(d.b bVar) {
                g.this.b(bVar);
            }
        };
    }

    public boolean a(SocketMessage socketMessage) {
        if (socketMessage != null && (socketMessage instanceof a)) {
            a aVar = (a) socketMessage;
            if (c.a(this.mWaitSendQueue, aVar, socketMessage.getCmd()) || c.a(this.mWaitingAckQueue, aVar, socketMessage.getCmd()) || c.a(this.mTimeOutQueue, aVar, socketMessage.getCmd())) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b
    public void a(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        l.checkMainThread();
        if (socketMessage != null && socketMessageTask != null) {
            if (a(socketMessage, socketMessageTask.eL())) {
                i.a("queue", socketMessage, 0, "sendMessage", h.QUEUE_SEND_ERROR_DUPLICATE, "duplicate message be removed");
                return;
            }
            e eVar = new e(socketMessage, socketMessageTask, this);
            if (BdSocketLinkService.hasAbsoluteClose()) {
                i.a("queue", socketMessage, 0, "sendMessage", h.QUEUE_SEND_ERROR_MANUAL_CLOSE, "user manual close socket");
                eVar.onSendError(h.QUEUE_SEND_ERROR_MANUAL_CLOSE);
            } else if (!BdSocketLinkService.isAvailable()) {
                i.a("queue", socketMessage, 0, "sendMessage", h.QUEUE_SEND_ERROR_MANUAL_BLOCK, "isManualBlock message be removed");
                eVar.onSendError(h.QUEUE_SEND_ERROR_MANUAL_BLOCK);
            } else {
                i.a("queue", socketMessage, 0, "sendMessage", 0, "socketclient: send message");
                c.a(eVar, this.mWaitSendQueue);
                sendNext();
            }
        }
    }

    private boolean a(SocketMessage socketMessage, SocketMessageTask.DupLicateMode dupLicateMode) {
        if (socketMessage != null) {
            int cmd = socketMessage.getCmd();
            switch (dupLicateMode) {
                case REMOVE_ALL:
                    c.removeMessageByDuplicate(this.mWaitSendQueue, cmd);
                    c.removeMessageByDuplicate(this.mWaitingAckQueue, cmd);
                    c.removeMessageByDuplicate(this.mTimeOutQueue, cmd);
                    break;
                case REMOVE_WAITING:
                    c.removeMessageByDuplicate(this.mWaitSendQueue, cmd);
                    break;
                case REMOVE_ME:
                    if (c.findMessageByDuplicate(this.mWaitSendQueue, cmd) || c.findMessageByDuplicate(this.mWaitingAckQueue, cmd) || c.findMessageByDuplicate(this.mTimeOutQueue, cmd)) {
                        return true;
                    }
                    break;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(d.b bVar) {
        if (bVar != null) {
            if (bVar.ls != null) {
                a(bVar.ls, h.CODEC_UNPACK_FAILED, null);
                return;
            }
            SocketResponsedMessage socketResponsedMessage = bVar.lr;
            if (socketResponsedMessage != null) {
                i.a("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", 0, "unpack succ");
                b(socketResponsedMessage);
            }
        }
    }

    public void b(e eVar) {
        if (eVar != null && eVar.canRetry() && eVar.getRetrySendTimes() < eVar.getMaxRetryCount()) {
            c.a(this.mWaitingAckQueue, this.mTimeOutQueue, eVar);
            if (this.lC != null) {
                this.lC.sendPing(true, "timeout seq = " + eVar.getSequenceId());
            }
            i.a("queue", eVar.ez(), eVar.getSequenceId(), "onSendTimeOut", h.QUEUE_SEND_TIME_OUT, String.valueOf(eVar.getRetrySendTimes()));
            return;
        }
        e(eVar);
        a(eVar, h.QUEUE_TIME_OUT, null);
        sendNext();
    }

    public void a(int i, e eVar) {
        int i2;
        if (i == 2) {
            if (eVar.ey() != null) {
                i2 = eVar.ey().getErrorCode();
            } else {
                i2 = h.CODEC_UNKOWN_ERROR;
            }
        } else {
            i2 = h.QUEUE_SEND_ERROR;
        }
        String errorMsg = h.toErrorMsg(i2);
        e(eVar);
        a(eVar, i2, errorMsg);
    }

    public void c(e eVar) {
    }

    public void d(e eVar) {
        if (eVar != null) {
            if (eVar.isNeedAck()) {
                eVar.addRetrySendTimes();
                c.a(this.mWaitSendQueue, this.mWaitingAckQueue, eVar);
                return;
            }
            c.b(eVar, this.mWaitSendQueue);
        }
    }

    protected void a(e eVar, int i, String str) {
        SocketResponsedMessage socketResponsedMessage = null;
        if (eVar != null && eVar.ez() != null) {
            int cmd = eVar.ez().getCmd();
            int sequenceId = eVar.getSequenceId();
            i.a("queue", eVar.ez(), sequenceId, "onMessageSendFail", i, str + " retryTime-" + eVar.getRetrySendTimes());
            SocketMessageTask eA = eVar != null ? eVar.eA() : null;
            SocketMessageTask socketMessageTask = eA == null ? (SocketMessageTask) this.lb.findTask(cmd) : eA;
            if (socketMessageTask != null && socketMessageTask.getResponsedClass() != null) {
                try {
                    socketResponsedMessage = socketMessageTask.getResponsedClass().newInstance();
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    try {
                        socketResponsedMessage = socketMessageTask.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(cmd));
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                }
            }
            if (socketResponsedMessage != null) {
                socketResponsedMessage.setError(i);
                if (str == null) {
                    socketResponsedMessage.setErrorString(h.toErrorMsg(i));
                } else {
                    socketResponsedMessage.setErrorString(str);
                }
                socketResponsedMessage.setOrginalMessage(eVar.ez());
                i.a("queue", eVar.ez(), sequenceId, "onMessageSendFail", i, "onMessageSendFail class = " + socketResponsedMessage.getClass().getName());
                this.lb.dispatchResponsedMessage(socketResponsedMessage);
            }
        }
    }

    private void sendNext() {
        e d = c.d(this.mWaitSendQueue);
        if (d != null) {
            if (BdSocketLinkService.isClose()) {
                i.a("queue", d.ez(), 0, "sendNext", h.QUEUE_SEND_CURRENTSOCKETCLOSE, "");
                BdSocketLinkService.startService(false, "send message");
            } else if (!this.mIsBlock || d.getPriority() <= -3) {
                BdSocketLinkService.sendMessage(d);
            }
        }
    }

    private void b(SocketResponsedMessage socketResponsedMessage) {
        this.lb.dispatchResponsedMessage(socketResponsedMessage);
    }

    private void e(e eVar) {
        if (eVar != null) {
            eVar.onRemove();
            c.b(eVar, this.mWaitingAckQueue);
            c.b(eVar, this.mWaitSendQueue);
            c.b(eVar, this.mTimeOutQueue);
        }
    }

    private void clearMessageQueue(LinkedList<e> linkedList) {
        while (true) {
            e e = c.e(linkedList);
            if (e != null) {
                e.onRemove();
                a(e, h.QUEUE_SEND_ERROR_CLEAR, null);
            } else {
                return;
            }
        }
    }

    public void clearAllMessageQueue() {
        clearMessageQueue(this.mWaitingAckQueue);
        clearMessageQueue(this.mWaitSendQueue);
        clearMessageQueue(this.mTimeOutQueue);
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public boolean onClose(int i, String str) {
        if (this.lB != null) {
            this.lB.onClose(i, str);
        }
        if (this.lC != null) {
            this.lC.stopPing();
        }
        if (!l.isNetOk() || c.addConnectRetry(this.mTimeOutQueue) || c.addConnectRetry(this.mWaitSendQueue) || c.addConnectRetry(this.mWaitingAckQueue) || !BdSocketLinkService.isAvailable()) {
            clearAllMessageQueue();
            return false;
        }
        c.clearTimeOut(this.mWaitingAckQueue);
        c.instertMessage(this.mWaitSendQueue, this.mTimeOutQueue);
        c.instertMessage(this.mWaitSendQueue, this.mWaitingAckQueue);
        while (true) {
            e c = c.c(this.mWaitSendQueue);
            if (c == null) {
                break;
            }
            c.onRemove();
            a(c, h.QUEUE_SEND_ERROR_CLEAR, null);
        }
        if (c.size(this.mWaitSendQueue) > 0) {
            i.debug("queue", 0, 0, "onClose", h.QUEUE_SEND_HAVE_RETRY_MESSAGE, "have retry message, MessageQueue:reconnect");
            BdSocketLinkService.startService(false, "have retry message");
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void onConnected(Map<String, String> map) {
        f.eB().setSequenceId(map);
        if (this.lC != null) {
            this.lC.resetPing();
        }
        this.mIsBlock = true;
        i.debug("queue", 0, 0, "onConnected", h.QUEUE_SEND_SET_BLOCK, "Queue blocked");
        if (this.lB != null) {
            this.lB.onConnected(map);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void a(k.a aVar) {
        byte[] bArr;
        if (aVar != null && (bArr = aVar.ss) != null) {
            this.mLastReceDataTime = System.currentTimeMillis();
            try {
                com.baidu.adp.framework.client.socket.coder.c g = com.baidu.adp.framework.client.socket.coder.b.eD().g(bArr);
                this.mCWProtobufParseErrCnt = 0;
                int command = g.lG.getCommand();
                int sequenceID = g.lG.getSequenceID();
                i.debug("queue", command, sequenceID, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
                e i = i(command, sequenceID);
                if (i != null) {
                    i.firstByteReachTime = aVar.firstByteReachTime;
                    i.allDataReadTime = aVar.allDataReadTime;
                }
                if (this.lC != null) {
                    if (g.lG.getCommand() == this.lC.getCmd() && c.instertMessage(this.mWaitSendQueue, this.mTimeOutQueue)) {
                        sendNext();
                    }
                    this.lC.resetPing();
                }
                if (sequenceID == 0 || (i != null && i.getCmd() == command)) {
                    new d(g, i, this.lA, sequenceID).execute(new String[0]);
                } else if (i != null) {
                    a(i, h.QUEUE_RECE_CMD_NOT_MATCH, null);
                }
                if (this.lB != null) {
                    this.lB.a(aVar);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(MessageConfig.SOCKET_RECEIVE_MSG));
            } catch (CoderException e) {
                int maxAlertCount = com.baidu.adp.lib.stats.switchs.a.gG().getMaxAlertCount(BdStatsConstant.AlertTypeKey.ALERT_PROTOBUF, 2);
                int i2 = this.mCWProtobufParseErrCnt + 1;
                this.mCWProtobufParseErrCnt = i2;
                if (i2 >= maxAlertCount) {
                    BdStatisticsManager.getInstance().alert(BdStatsConstant.AlertTypeKey.ALERT_PROTOBUF, "protbuf");
                }
                i.debug("queue", 0, 0, "onBinaryMesssage", h.CODEC_UNPACK_HEAD_FAILED, "onBinaryMesssage decodeHeader error");
            }
        }
    }

    private e i(int i, int i2) {
        e eVar = null;
        if (i2 != 0) {
            e a = c.a(i2, this.mWaitingAckQueue);
            if (a == null && (a = c.a(i2, this.mTimeOutQueue)) == null) {
                eVar = c.a(i2, this.mWaitSendQueue);
                if (eVar == null) {
                    i.debug("queue", i, i2, "findSenderData", h.QUEUE_SEND_NOT_FIND_ORIGINAL_DATA, "original message removed , responsedMessage not dispatchMessage");
                }
            } else {
                eVar = a;
            }
            i.debug("queue", i, i2, "findSenderData", h.QUEUE_SEND_FIND_ORIGINAL_DATA, "received ack message");
        }
        return eVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
        sendNext();
        if (this.lB != null) {
            this.lB.a(cVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void onTextMessage(String str) {
        if (this.lB != null) {
            this.lB.onTextMessage(str);
        }
    }

    public void a(com.baidu.adp.framework.client.socket.link.a aVar) {
        this.lB = aVar;
    }

    public void unBlockMessageQueue() {
        boolean z = this.mIsBlock;
        this.mIsBlock = false;
        i.debug("queue", 0, 0, "unBlockMessageQueue", h.QUEUE_SEND_REALEASE_BLOCK, "Queue block has release");
        if (z) {
            sendNext();
        }
    }

    public void a(b bVar) {
        this.lC = bVar;
    }

    public boolean isValid() {
        return BdSocketLinkService.isOpen() && !this.mIsBlock && BdSocketLinkService.isAvailable();
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        removeMessage(0, bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        c.b(this.mWaitingAckQueue, i, bdUniqueId);
        c.b(this.mWaitSendQueue, i, bdUniqueId);
        c.b(this.mTimeOutQueue, i, bdUniqueId);
    }

    public LinkedList<SocketMessage> a(BdUniqueId bdUniqueId) {
        return null;
    }

    @Override // com.baidu.adp.framework.b
    public LinkedList<SocketMessage> findMessage(int i, BdUniqueId bdUniqueId) {
        return null;
    }

    public boolean a(int i, BdUniqueId bdUniqueId) {
        return c.a(this.mWaitSendQueue, i, bdUniqueId) || c.a(this.mWaitingAckQueue, i, bdUniqueId) || c.a(this.mTimeOutQueue, i, bdUniqueId);
    }

    public long getLastReceDataTime() {
        return this.mLastReceDataTime;
    }

    public int getProcessingResponsedMessageNum() {
        return BdAsyncTask.getTaskNum(d.ex());
    }

    public int getProcessingResponsedMessageNum(int i) {
        return BdAsyncTask.getTaskNum(String.valueOf(i), d.ex());
    }

    public b eC() {
        return this.lC;
    }
}
