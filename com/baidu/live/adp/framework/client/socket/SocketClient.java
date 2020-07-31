package com.baidu.live.adp.framework.client.socket;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.client.Client;
import com.baidu.live.adp.framework.client.socket.MessageUnPackTask;
import com.baidu.live.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.live.adp.framework.client.socket.link.ConnStateCallback;
import com.baidu.live.adp.framework.message.SocketMessage;
import com.baidu.live.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.adp.framework.task.SocketMessageTask;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes4.dex */
public class SocketClient extends Client<SocketMessage, SocketMessageTask> implements ConnStateCallback {
    private static final String MODULE_NAME = "queue";
    private int mCWProtobufParseErrCnt;
    private ConnStateCallback mConnStateCallback;
    private boolean mIsBlock;
    private long mLastReceDataTime;
    private IPingManager mPingManager;
    private final LinkedList<SenderData> mTimeOutQueue;
    private MessageUnPackTask.ISingleRunnableCallback mUnPackCallback;
    private final LinkedList<SenderData> mWaitSendQueue;
    private final LinkedList<SenderData> mWaitingAckQueue;

    public SocketClient(MessageManager messageManager) {
        super(messageManager);
        this.mUnPackCallback = null;
        this.mWaitingAckQueue = new LinkedList<>();
        this.mWaitSendQueue = new LinkedList<>();
        this.mTimeOutQueue = new LinkedList<>();
        this.mConnStateCallback = null;
        this.mIsBlock = true;
        this.mPingManager = null;
        this.mLastReceDataTime = 0L;
        this.mCWProtobufParseErrCnt = 0;
        BdSocketLinkService.setConnStateCallBack(this);
        this.mUnPackCallback = new MessageUnPackTask.ISingleRunnableCallback() { // from class: com.baidu.live.adp.framework.client.socket.SocketClient.1
            @Override // com.baidu.live.adp.framework.client.socket.MessageUnPackTask.ISingleRunnableCallback
            public void onReturnDataInUI(MessageUnPackTask.UnpackData unpackData) {
                SocketClient.this.onReceiveMessage(unpackData);
            }
        };
    }

    public boolean findMessage(SocketMessage socketMessage) {
        if (socketMessage != null && (socketMessage instanceof IFindProcess)) {
            IFindProcess iFindProcess = (IFindProcess) socketMessage;
            if (MessageQueueHelper.findMessage(this.mWaitSendQueue, iFindProcess, socketMessage.getCmd()) || MessageQueueHelper.findMessage(this.mWaitingAckQueue, iFindProcess, socketMessage.getCmd()) || MessageQueueHelper.findMessage(this.mTimeOutQueue, iFindProcess, socketMessage.getCmd())) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.adp.framework.client.Client, com.baidu.live.adp.framework.IMessageProcess
    public void sendMessage(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        BdUtilHelper.checkMainThread();
        if (socketMessage != null && socketMessageTask != null) {
            if (duplicateProcess(socketMessage, socketMessageTask.getDupLicateMode())) {
                SocketLog.debug(MODULE_NAME, socketMessage, 0, "sendMessage", SocketConfig.QUEUE_SEND_ERROR_DUPLICATE, "duplicate message be removed");
                return;
            }
            SenderData senderData = new SenderData(socketMessage, socketMessageTask, this);
            if (BdSocketLinkService.hasAbsoluteClose()) {
                SocketLog.debug(MODULE_NAME, socketMessage, 0, "sendMessage", SocketConfig.QUEUE_SEND_ERROR_MANUAL_CLOSE, "user manual close socket");
                senderData.onSendError(SocketConfig.QUEUE_SEND_ERROR_MANUAL_CLOSE);
            } else if (!BdSocketLinkService.isAvailable()) {
                SocketLog.debug(MODULE_NAME, socketMessage, 0, "sendMessage", SocketConfig.QUEUE_SEND_ERROR_MANUAL_BLOCK, "isManualBlock message be removed");
                senderData.onSendError(SocketConfig.QUEUE_SEND_ERROR_MANUAL_BLOCK);
            } else {
                SocketLog.debug(MODULE_NAME, socketMessage, 0, "sendMessage", 0, "socketclient: send message");
                MessageQueueHelper.instertMessage(senderData, this.mWaitSendQueue);
                sendNext();
            }
        }
    }

    private boolean duplicateProcess(SocketMessage socketMessage, SocketMessageTask.DupLicateMode dupLicateMode) {
        if (socketMessage != null) {
            int cmd = socketMessage.getCmd();
            switch (dupLicateMode) {
                case REMOVE_ALL:
                    MessageQueueHelper.removeMessageByDuplicate(this.mWaitSendQueue, cmd);
                    MessageQueueHelper.removeMessageByDuplicate(this.mWaitingAckQueue, cmd);
                    MessageQueueHelper.removeMessageByDuplicate(this.mTimeOutQueue, cmd);
                    break;
                case REMOVE_WAITING:
                    MessageQueueHelper.removeMessageByDuplicate(this.mWaitSendQueue, cmd);
                    break;
                case REMOVE_ME:
                    if (MessageQueueHelper.findMessageByDuplicate(this.mWaitSendQueue, cmd) || MessageQueueHelper.findMessageByDuplicate(this.mWaitingAckQueue, cmd) || MessageQueueHelper.findMessageByDuplicate(this.mTimeOutQueue, cmd)) {
                        return true;
                    }
                    break;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onReceiveMessage(MessageUnPackTask.UnpackData unpackData) {
        if (unpackData != null) {
            if (unpackData.mSenderData != null) {
                onMessageSendFail(unpackData.mSenderData, SocketConfig.CODEC_UNPACK_FAILED, null);
                return;
            }
            SocketResponsedMessage socketResponsedMessage = unpackData.mMessages;
            if (socketResponsedMessage != null) {
                SocketLog.debug(MODULE_NAME, socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", 0, "unpack succ");
                dispatchMessage(socketResponsedMessage);
            }
        }
    }

    public void onSendTimeOut(SenderData senderData) {
        if (senderData != null && senderData.canRetry() && senderData.getRetrySendTimes() < senderData.getMaxRetryCount()) {
            MessageQueueHelper.moveData(this.mWaitingAckQueue, this.mTimeOutQueue, senderData);
            if (this.mPingManager != null) {
                this.mPingManager.sendPing(true, "timeout seq = " + senderData.getSequenceId());
            }
            SocketLog.debug(MODULE_NAME, senderData.getMessage(), senderData.getSequenceId(), "onSendTimeOut", SocketConfig.QUEUE_SEND_TIME_OUT, String.valueOf(senderData.getRetrySendTimes()));
            return;
        }
        removeMessage(senderData);
        onMessageSendFail(senderData, SocketConfig.QUEUE_TIME_OUT, null);
        sendNext();
    }

    public void onSendError(int i, SenderData senderData) {
        int i2;
        if (i == 2) {
            if (senderData.getSocketErrorData() != null) {
                i2 = senderData.getSocketErrorData().getErrorCode();
            } else {
                i2 = SocketConfig.CODEC_UNKOWN_ERROR;
            }
        } else {
            i2 = SocketConfig.QUEUE_SEND_ERROR;
        }
        String errorMsg = SocketConfig.toErrorMsg(i2);
        removeMessage(senderData);
        onMessageSendFail(senderData, i2, errorMsg);
    }

    public void onSendFinish(SenderData senderData) {
    }

    public void onSendStart(SenderData senderData) {
        if (senderData != null) {
            if (senderData.isNeedAck()) {
                senderData.addRetrySendTimes();
                MessageQueueHelper.moveData(this.mWaitSendQueue, this.mWaitingAckQueue, senderData);
                return;
            }
            MessageQueueHelper.removeMessage(senderData, this.mWaitSendQueue);
        }
    }

    protected void onMessageSendFail(SenderData senderData, int i, String str) {
        SocketResponsedMessage socketResponsedMessage = null;
        if (senderData != null && senderData.getMessage() != null) {
            int cmd = senderData.getMessage().getCmd();
            int sequenceId = senderData.getSequenceId();
            SocketLog.debug(MODULE_NAME, senderData.getMessage(), sequenceId, "onMessageSendFail", i, str + " retryTime-" + senderData.getRetrySendTimes());
            SocketMessageTask task = senderData != null ? senderData.getTask() : null;
            SocketMessageTask socketMessageTask = task == null ? (SocketMessageTask) this.mMessageManager.findTask(cmd) : task;
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
                    socketResponsedMessage.setErrorString(SocketConfig.toErrorMsg(i));
                } else {
                    socketResponsedMessage.setErrorString(str);
                }
                socketResponsedMessage.setOrginalMessage(senderData.getMessage());
                SocketLog.debug(MODULE_NAME, senderData.getMessage(), sequenceId, "onMessageSendFail", i, "onMessageSendFail class = " + socketResponsedMessage.getClass().getName());
                this.mMessageManager.dispatchResponsedMessage(socketResponsedMessage);
            }
        }
    }

    private void sendNext() {
        SenderData headerData = MessageQueueHelper.getHeaderData(this.mWaitSendQueue);
        if (headerData != null) {
            if (BdSocketLinkService.isClose()) {
                SocketLog.debug(MODULE_NAME, headerData.getMessage(), 0, "sendNext", SocketConfig.QUEUE_SEND_CURRENTSOCKETCLOSE, "");
                BdSocketLinkService.startService(false, "send message");
            } else if (!this.mIsBlock || headerData.getPriority() <= -3) {
                BdSocketLinkService.sendMessage(headerData);
            }
        }
    }

    private void dispatchMessage(SocketResponsedMessage socketResponsedMessage) {
        this.mMessageManager.dispatchResponsedMessage(socketResponsedMessage);
    }

    private void removeMessage(SenderData senderData) {
        if (senderData != null) {
            senderData.onRemove();
            MessageQueueHelper.removeMessage(senderData, this.mWaitingAckQueue);
            MessageQueueHelper.removeMessage(senderData, this.mWaitSendQueue);
            MessageQueueHelper.removeMessage(senderData, this.mTimeOutQueue);
        }
    }

    private void clearMessageQueue(LinkedList<SenderData> linkedList) {
        while (true) {
            SenderData removeHeaderData = MessageQueueHelper.removeHeaderData(linkedList);
            if (removeHeaderData != null) {
                removeHeaderData.onRemove();
                onMessageSendFail(removeHeaderData, SocketConfig.QUEUE_SEND_ERROR_CLEAR, null);
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

    @Override // com.baidu.live.adp.framework.client.socket.link.ConnStateCallback
    public boolean onClose(int i, String str) {
        if (this.mConnStateCallback != null) {
            this.mConnStateCallback.onClose(i, str);
        }
        if (this.mPingManager != null) {
            this.mPingManager.stopPing();
        }
        if (!BdUtilHelper.isNetOk() || MessageQueueHelper.addConnectRetry(this.mTimeOutQueue) || MessageQueueHelper.addConnectRetry(this.mWaitSendQueue) || MessageQueueHelper.addConnectRetry(this.mWaitingAckQueue) || !BdSocketLinkService.isAvailable()) {
            clearAllMessageQueue();
            return false;
        }
        MessageQueueHelper.clearTimeOut(this.mWaitingAckQueue);
        MessageQueueHelper.instertMessage(this.mWaitSendQueue, this.mTimeOutQueue);
        MessageQueueHelper.instertMessage(this.mWaitSendQueue, this.mWaitingAckQueue);
        while (true) {
            SenderData removeCantRetry = MessageQueueHelper.removeCantRetry(this.mWaitSendQueue);
            if (removeCantRetry == null) {
                break;
            }
            removeCantRetry.onRemove();
            onMessageSendFail(removeCantRetry, SocketConfig.QUEUE_SEND_ERROR_CLEAR, null);
        }
        if (MessageQueueHelper.size(this.mWaitSendQueue) > 0) {
            SocketLog.debug(MODULE_NAME, 0, 0, "onClose", SocketConfig.QUEUE_SEND_HAVE_RETRY_MESSAGE, "have retry message, MessageQueue:reconnect");
            BdSocketLinkService.startService(false, "have retry message");
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.adp.framework.client.socket.link.ConnStateCallback
    public void onConnected(Map<String, String> map) {
        SequenceManager.getInstance().setSequenceId(map);
        if (this.mPingManager != null) {
            this.mPingManager.resetPing();
        }
        this.mIsBlock = true;
        SocketLog.debug(MODULE_NAME, 0, 0, "onConnected", SocketConfig.QUEUE_SEND_SET_BLOCK, "Queue blocked");
        if (this.mConnStateCallback != null) {
            this.mConnStateCallback.onConnected(map);
        }
    }

    private SenderData findSenderData(int i, int i2) {
        SenderData senderData = null;
        if (i2 != 0) {
            SenderData removeMessageBySequence = MessageQueueHelper.removeMessageBySequence(i2, this.mWaitingAckQueue);
            if (removeMessageBySequence == null && (removeMessageBySequence = MessageQueueHelper.removeMessageBySequence(i2, this.mTimeOutQueue)) == null) {
                senderData = MessageQueueHelper.removeMessageBySequence(i2, this.mWaitSendQueue);
                if (senderData == null) {
                    SocketLog.debug(MODULE_NAME, i, i2, "findSenderData", SocketConfig.QUEUE_SEND_NOT_FIND_ORIGINAL_DATA, "original message removed , responsedMessage not dispatchMessage");
                }
            } else {
                senderData = removeMessageBySequence;
            }
            SocketLog.debug(MODULE_NAME, i, i2, "findSenderData", SocketConfig.QUEUE_SEND_FIND_ORIGINAL_DATA, "received ack message");
        }
        return senderData;
    }

    @Override // com.baidu.live.adp.framework.client.socket.link.ConnStateCallback
    public void onTextMessage(String str) {
        if (this.mConnStateCallback != null) {
            this.mConnStateCallback.onTextMessage(str);
        }
    }

    public ConnStateCallback getConnStateCallback() {
        return this.mConnStateCallback;
    }

    public void setConnStateCallback(ConnStateCallback connStateCallback) {
        this.mConnStateCallback = connStateCallback;
    }

    public void removeWaitingMessage(SocketMessage socketMessage) {
        MessageQueueHelper.removeMessage(socketMessage, this.mWaitSendQueue);
    }

    public void unBlockMessageQueue() {
        boolean z = this.mIsBlock;
        this.mIsBlock = false;
        SocketLog.debug(MODULE_NAME, 0, 0, "unBlockMessageQueue", SocketConfig.QUEUE_SEND_REALEASE_BLOCK, "Queue block has release");
        if (z) {
            sendNext();
        }
    }

    public void setPingManager(IPingManager iPingManager) {
        this.mPingManager = iPingManager;
    }

    public boolean isValid() {
        return BdSocketLinkService.isOpen() && !this.mIsBlock && BdSocketLinkService.isAvailable();
    }

    @Override // com.baidu.live.adp.framework.IMessageProcess
    public void removeMessage(BdUniqueId bdUniqueId) {
        removeMessage(0, bdUniqueId);
    }

    @Override // com.baidu.live.adp.framework.IMessageProcess
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        MessageQueueHelper.removeMessage(this.mWaitingAckQueue, i, bdUniqueId);
        MessageQueueHelper.removeMessage(this.mWaitSendQueue, i, bdUniqueId);
        MessageQueueHelper.removeMessage(this.mTimeOutQueue, i, bdUniqueId);
    }

    @Override // com.baidu.live.adp.framework.IMessageProcess
    public void removeWaitingMessage(BdUniqueId bdUniqueId) {
        removeWaitingMessage(0, bdUniqueId);
    }

    @Override // com.baidu.live.adp.framework.IMessageProcess
    public void removeWaitingMessage(int i, BdUniqueId bdUniqueId) {
        MessageQueueHelper.removeMessage(this.mWaitSendQueue, i, bdUniqueId);
    }

    @Override // com.baidu.live.adp.framework.IMessageProcess
    public LinkedList<SocketMessage> findMessage(BdUniqueId bdUniqueId) {
        return null;
    }

    @Override // com.baidu.live.adp.framework.IMessageProcess
    public LinkedList<SocketMessage> findMessage(int i, BdUniqueId bdUniqueId) {
        return null;
    }

    @Override // com.baidu.live.adp.framework.IMessageProcess
    public boolean haveMessage(int i, BdUniqueId bdUniqueId) {
        return MessageQueueHelper.findMessage(this.mWaitSendQueue, i, bdUniqueId) || MessageQueueHelper.findMessage(this.mWaitingAckQueue, i, bdUniqueId) || MessageQueueHelper.findMessage(this.mTimeOutQueue, i, bdUniqueId);
    }

    @Override // com.baidu.live.adp.framework.IMessageProcess
    public boolean haveMessage(BdUniqueId bdUniqueId) {
        return haveMessage(0, bdUniqueId);
    }

    @Override // com.baidu.live.adp.framework.IMessageProcess
    public int getMessageNum(BdUniqueId bdUniqueId) {
        return getMessageNum(0, bdUniqueId);
    }

    @Override // com.baidu.live.adp.framework.IMessageProcess
    public int getMessageNum(int i, BdUniqueId bdUniqueId) {
        return MessageQueueHelper.getMessageNum(this.mWaitSendQueue, i, bdUniqueId) + MessageQueueHelper.getMessageNum(this.mWaitingAckQueue, i, bdUniqueId) + MessageQueueHelper.getMessageNum(this.mTimeOutQueue, i, bdUniqueId);
    }

    public long getLastReceDataTime() {
        return this.mLastReceDataTime;
    }

    public int getProcessingResponsedMessageNum() {
        return BdAsyncTask.getTaskNum(MessageUnPackTask.getTags());
    }

    public int getProcessingResponsedMessageNum(int i) {
        return BdAsyncTask.getTaskNum(String.valueOf(i), MessageUnPackTask.getTags());
    }

    public IPingManager getPingManager() {
        return this.mPingManager;
    }
}
