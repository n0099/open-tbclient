package com.baidu.android.imsdk.internal;

import android.content.Context;
import android.util.Pair;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.utils.LogUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class Dispatcher {
    public static final int ALL = 0;
    public static final int NORMAL = -1;
    public static final int NORMAL_CATEGORY = -1;
    public static final String TAG = Dispatcher.class.getSimpleName();
    private static Map<Pair<Integer, Long>, ArrayList<MsgListener>> listenerMap = Collections.synchronizedMap(new HashMap());
    private static List<MsgListener> allMsgListeners = Collections.synchronizedList(new ArrayList());
    private static List<MsgListener> normalALL = Collections.synchronizedList(new ArrayList());

    /* loaded from: classes5.dex */
    public static abstract class MsgListener {
        int type = 0;

        public abstract void dealMessage(int i, ChatMsg chatMsg);

        public abstract void dealMessage(int i, ArrayList<ChatMsg> arrayList);

        public int getType() {
            return this.type;
        }

        public void setType(int i) {
            this.type = i;
        }
    }

    /* loaded from: classes5.dex */
    public static class Event {
        private int category;
        private long contacter;
        private int type;

        public int getType() {
            return this.type;
        }

        public void setType(int i) {
            this.type = i;
        }

        public int getCategory() {
            return this.category;
        }

        public void setCategory(int i) {
            this.category = i;
        }

        public long getContacter() {
            return this.contacter;
        }

        public void setContacter(long j) {
            this.contacter = j;
        }
    }

    public static void registerListener(Event event, MsgListener msgListener) {
        if (event.getType() == 0) {
            allMsgListeners.add(msgListener);
        } else if (event.getCategory() == -1 && event.getType() == -1) {
            normalALL.add(msgListener);
        } else {
            msgListener.setType(event.getType());
            ArrayList<MsgListener> arrayList = listenerMap.get(new Pair(Integer.valueOf(event.getCategory()), Long.valueOf(event.getContacter())));
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                arrayList.add(msgListener);
            } else {
                arrayList.add(msgListener);
            }
            listenerMap.put(new Pair<>(Integer.valueOf(event.getCategory()), Long.valueOf(event.getContacter())), arrayList);
        }
    }

    public static void dispatchMessage(Context context, int i, ArrayList<ChatMsg> arrayList) {
        LogUtils.d(TAG, "start dispatchMessage " + (arrayList == null ? "null" : Integer.valueOf(arrayList.size())));
        if (arrayList != null && arrayList.size() != 0) {
            if (allMsgListeners != null && allMsgListeners.size() > 0) {
                for (MsgListener msgListener : allMsgListeners) {
                    LogUtils.d(TAG, "deal allMsgListeners message");
                    msgListener.dealMessage(i, arrayList);
                }
            }
            ArrayList<ChatMsg> arrayList2 = new ArrayList<>();
            long j = 0;
            Iterator<ChatMsg> it = arrayList.iterator();
            while (true) {
                long j2 = j;
                if (!it.hasNext()) {
                    break;
                }
                ChatMsg next = it.next();
                if (next.getCategory() == 0 || next.getCategory() == 1) {
                    arrayList2.add(next);
                } else if (next.getCategory() == 2 && j2 < next.getMsgId()) {
                    j2 = next.getMsgId();
                }
                j = j2;
            }
            LogUtils.d(TAG, "normalAll dispatcher : msgs2.size() : " + arrayList2.size());
            if (arrayList2.size() > 0 && normalALL != null && normalALL.size() > 0) {
                for (MsgListener msgListener2 : normalALL) {
                    msgListener2.dealMessage(i, arrayList2);
                }
            }
            dispatchMesageToCentain(i, arrayList);
        }
    }

    public static void dispatchMesageToCentain(int i, ArrayList<ChatMsg> arrayList) {
        LogUtils.d(TAG, "start dispatchMesageToCentain" + (arrayList == null ? "null" : Integer.valueOf(arrayList.size())));
        if (arrayList != null && arrayList.size() != 0) {
            HashMap hashMap = new HashMap();
            Iterator<ChatMsg> it = arrayList.iterator();
            while (it.hasNext()) {
                ChatMsg next = it.next();
                ArrayList arrayList2 = (ArrayList) hashMap.get(new Pair(Integer.valueOf(next.getCategory()), Long.valueOf(next.getContacter())));
                if (arrayList2 != null) {
                    arrayList2.add(next);
                } else {
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(next);
                    hashMap.put(new Pair(Integer.valueOf(next.getCategory()), Long.valueOf(next.getContacter())), arrayList3);
                }
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                dispatchMesageToCentainType(i, listenerMap.get(entry.getKey()), (ArrayList) hashMap.get(entry.getKey()));
            }
        }
    }

    public static void dispatchMesageToCentainType(int i, ArrayList<MsgListener> arrayList, ArrayList<ChatMsg> arrayList2) {
        LogUtils.d(TAG, "start dispatchMesageToCentain" + (arrayList2 == null ? " is null" : "size is" + arrayList2.size()));
        if (arrayList2 != null && arrayList2.size() != 0) {
            if (arrayList == null) {
                LogUtils.d(TAG, ": dispatchMesageToCentain listeners = null");
                return;
            }
            Iterator<MsgListener> it = arrayList.iterator();
            while (it.hasNext()) {
                MsgListener next = it.next();
                Iterator<ChatMsg> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    ChatMsg next2 = it2.next();
                    if (next2.getCategory() != 0 && next2.getCategory() != 1 && next2.getNotifyCmd() == next.getType()) {
                        next.dealMessage(i, next2);
                    }
                }
                if (arrayList2.get(0).getCategory() == 0 || arrayList2.get(0).getCategory() == 1) {
                    next.dealMessage(i, arrayList2);
                }
            }
        }
    }
}
