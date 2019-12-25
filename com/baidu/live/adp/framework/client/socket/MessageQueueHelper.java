package com.baidu.live.adp.framework.client.socket;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.message.SocketMessage;
import java.util.Iterator;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class MessageQueueHelper {
    MessageQueueHelper() {
    }

    public static boolean instertMessage(SenderData senderData, LinkedList<SenderData> linkedList) {
        int insertIndex;
        if (senderData == null || linkedList == null || (insertIndex = getInsertIndex(senderData, linkedList)) < 0 || insertIndex > linkedList.size()) {
            return false;
        }
        linkedList.add(insertIndex, senderData);
        return true;
    }

    public static boolean instertMessage(LinkedList<SenderData> linkedList, LinkedList<SenderData> linkedList2) {
        if (linkedList == null || linkedList2 == null || linkedList2.size() <= 0) {
            return false;
        }
        while (true) {
            SenderData poll = linkedList2.poll();
            if (poll != null) {
                instertMessage(poll, linkedList);
            } else {
                return true;
            }
        }
    }

    public static int size(LinkedList<SenderData> linkedList) {
        if (linkedList == null) {
            return 0;
        }
        return linkedList.size();
    }

    public static SenderData removeCantRetry(LinkedList<SenderData> linkedList) {
        if (linkedList == null) {
            return null;
        }
        Iterator<SenderData> it = linkedList.iterator();
        while (it.hasNext()) {
            SenderData next = it.next();
            if (next != null && !next.canRetry()) {
                it.remove();
                return next;
            }
        }
        return null;
    }

    public static boolean removeMessage(SenderData senderData, LinkedList<SenderData> linkedList) {
        if (senderData == null || linkedList == null) {
            return false;
        }
        return linkedList.remove(senderData);
    }

    public static SenderData removeMessage(SocketMessage socketMessage, LinkedList<SenderData> linkedList) {
        if (socketMessage == null || linkedList == null) {
            return null;
        }
        Iterator<SenderData> it = linkedList.iterator();
        while (it.hasNext()) {
            SenderData next = it.next();
            if (next != null && next.getMessage() == socketMessage) {
                linkedList.remove(next);
                return next;
            }
        }
        return null;
    }

    public static int getInsertIndex(SenderData senderData, LinkedList<SenderData> linkedList) {
        if (senderData == null || linkedList == null) {
            return -1;
        }
        int size = linkedList.size();
        int i = 0;
        while (i < size && linkedList.get(i).getPriority() <= senderData.getPriority()) {
            i++;
        }
        return i;
    }

    public static SenderData getHeaderData(LinkedList<SenderData> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            return null;
        }
        return linkedList.peek();
    }

    public static SenderData removeHeaderData(LinkedList<SenderData> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            return null;
        }
        return linkedList.poll();
    }

    public static boolean moveData(LinkedList<SenderData> linkedList, LinkedList<SenderData> linkedList2, SenderData senderData) {
        if (senderData == null || linkedList == null || linkedList2 == null) {
            return false;
        }
        if (linkedList.remove(senderData)) {
            linkedList2.add(senderData);
            return true;
        }
        return false;
    }

    public static boolean contains(LinkedList<SenderData> linkedList, int i) {
        if (linkedList == null) {
            return false;
        }
        Iterator<SenderData> it = linkedList.iterator();
        while (it.hasNext()) {
            SenderData next = it.next();
            if (next != null && next.getMessage() != null && next.getMessage().getCmd() == i) {
                return true;
            }
        }
        return false;
    }

    public static boolean addConnectRetry(LinkedList<SenderData> linkedList) {
        if (linkedList == null) {
            return false;
        }
        Iterator<SenderData> it = linkedList.iterator();
        while (it.hasNext()) {
            SenderData next = it.next();
            if (next != null && next.canRetry()) {
                next.addRetryConnectTimes();
                if (next.getRetryConnectTimes() >= next.getMaxRetryCount()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void clearTimeOut(LinkedList<SenderData> linkedList) {
        if (linkedList != null) {
            Iterator<SenderData> it = linkedList.iterator();
            while (it.hasNext()) {
                SenderData next = it.next();
                if (next != null) {
                    next.clearTimeOutTimer();
                }
            }
        }
    }

    public static SenderData removeMessageBySequence(int i, LinkedList<SenderData> linkedList) {
        if (linkedList == null) {
            return null;
        }
        Iterator<SenderData> it = linkedList.iterator();
        while (it.hasNext()) {
            SenderData next = it.next();
            if (next != null && next.getSequenceId() == i) {
                it.remove();
                next.onRemove();
                return next;
            }
        }
        return null;
    }

    public static boolean findMessageByDuplicate(LinkedList<SenderData> linkedList, int i) {
        SocketMessage message;
        Iterator<SenderData> it = linkedList.iterator();
        while (it.hasNext()) {
            SenderData next = it.next();
            if (next != null && (message = next.getMessage()) != null && message.getCmd() == i) {
                return true;
            }
        }
        return false;
    }

    public static void removeMessageByDuplicate(LinkedList<SenderData> linkedList, int i) {
        SocketMessage message;
        Iterator<SenderData> it = linkedList.iterator();
        while (it.hasNext()) {
            SenderData next = it.next();
            if (next != null && (message = next.getMessage()) != null && message.getCmd() == i) {
                it.remove();
            }
        }
    }

    public static boolean findMessage(LinkedList<SenderData> linkedList, IFindProcess iFindProcess, int i) {
        SocketMessage message;
        if (iFindProcess == null) {
            return false;
        }
        Iterator<SenderData> it = linkedList.iterator();
        while (it.hasNext()) {
            SenderData next = it.next();
            if (next != null && (message = next.getMessage()) != null && message.getCmd() == i && iFindProcess.onFindMessage(message)) {
                return true;
            }
        }
        return false;
    }

    public static boolean findMessage(LinkedList<SenderData> linkedList, int i, BdUniqueId bdUniqueId) {
        SocketMessage message;
        Iterator<SenderData> it = linkedList.iterator();
        while (it.hasNext()) {
            SenderData next = it.next();
            if (next != null && (message = next.getMessage()) != null && ((i != 0 && message.getTag() == bdUniqueId && i == message.getCmd()) || (i == 0 && bdUniqueId != null && message.getTag() == bdUniqueId))) {
                return true;
            }
        }
        return false;
    }

    public static void removeMessage(LinkedList<SenderData> linkedList, int i, BdUniqueId bdUniqueId) {
        SocketMessage message;
        if (linkedList != null) {
            Iterator<SenderData> it = linkedList.iterator();
            while (it.hasNext()) {
                SenderData next = it.next();
                if (next != null && (message = next.getMessage()) != null && ((i != 0 && message.getTag() == bdUniqueId && i == message.getCmd()) || (i == 0 && bdUniqueId != null && message.getTag() == bdUniqueId))) {
                    it.remove();
                    next.onRemove();
                }
            }
        }
    }

    public static int getMessageNum(LinkedList<SenderData> linkedList, int i, BdUniqueId bdUniqueId) {
        SocketMessage message;
        if (linkedList == null) {
            return 0;
        }
        Iterator<SenderData> it = linkedList.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            SenderData next = it.next();
            if (next != null && (message = next.getMessage()) != null) {
                if ((i != 0 && message.getTag() == bdUniqueId && i == message.getCmd()) || (i == 0 && bdUniqueId != null && message.getTag() == bdUniqueId)) {
                    i2++;
                }
                i2 = i2;
            }
        }
        return i2;
    }
}
