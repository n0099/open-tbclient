package com.baidu.android.imsdk.internal;

import android.content.Context;
import android.util.Pair;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.utils.LogUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class Dispatcher {
    public static final int ALL = 0;
    public static final int NORMAL = -1;
    public static final int NORMAL_CATEGORY = -1;
    public static final String TAG = "Dispatcher";
    public static Map<Pair<Integer, Long>, ArrayList<MsgListener>> listenerMap = Collections.synchronizedMap(new HashMap());
    public static List<MsgListener> allMsgListeners = Collections.synchronizedList(new ArrayList());
    public static List<MsgListener> normalALL = Collections.synchronizedList(new ArrayList());

    /* loaded from: classes.dex */
    public static class Event {
        public int category;
        public long contacter;
        public int type;

        public int getCategory() {
            return this.category;
        }

        public long getContacter() {
            return this.contacter;
        }

        public int getType() {
            return this.type;
        }

        public void setCategory(int i2) {
            this.category = i2;
        }

        public void setContacter(long j) {
            this.contacter = j;
        }

        public void setType(int i2) {
            this.type = i2;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class MsgListener {
        public int type = 0;

        public abstract void dealMessage(int i2, ChatMsg chatMsg);

        public abstract void dealMessage(int i2, ArrayList<ChatMsg> arrayList);

        public int getType() {
            return this.type;
        }

        public void setType(int i2) {
            this.type = i2;
        }
    }

    public static void dispatchMesageToCentain(int i2, ArrayList<ChatMsg> arrayList) {
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("start dispatchMesageToCentain");
        sb.append(arrayList == null ? StringUtil.NULL_STRING : Integer.valueOf(arrayList.size()));
        LogUtils.d(str, sb.toString());
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
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
            dispatchMesageToCentainType(i2, listenerMap.get(entry.getKey()), (ArrayList) hashMap.get(entry.getKey()));
        }
    }

    public static void dispatchMesageToCentainType(int i2, ArrayList<MsgListener> arrayList, ArrayList<ChatMsg> arrayList2) {
        String str;
        String str2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("start dispatchMesageToCentain");
        if (arrayList2 == null) {
            str = " is null";
        } else {
            str = "size is" + arrayList2.size();
        }
        sb.append(str);
        LogUtils.d(str2, sb.toString());
        if (arrayList2 == null || arrayList2.size() == 0) {
            return;
        }
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
                    next.dealMessage(i2, next2);
                }
            }
            if (arrayList2.get(0).getCategory() == 0 || arrayList2.get(0).getCategory() == 1) {
                next.dealMessage(i2, arrayList2);
            }
        }
    }

    public static void dispatchMessage(Context context, int i2, ArrayList<ChatMsg> arrayList) {
        List<MsgListener> list;
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("start dispatchMessage ");
        sb.append(arrayList == null ? StringUtil.NULL_STRING : Integer.valueOf(arrayList.size()));
        LogUtils.d(str, sb.toString());
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        List<MsgListener> list2 = allMsgListeners;
        if (list2 != null && list2.size() > 0) {
            for (MsgListener msgListener : allMsgListeners) {
                LogUtils.d(TAG, "deal allMsgListeners message");
                msgListener.dealMessage(i2, arrayList);
            }
        }
        ArrayList<ChatMsg> arrayList2 = new ArrayList<>();
        long j = 0;
        Iterator<ChatMsg> it = arrayList.iterator();
        while (it.hasNext()) {
            ChatMsg next = it.next();
            if (next.getCategory() != 0 && next.getCategory() != 1) {
                if (next.getCategory() == 2 && j < next.getMsgId()) {
                    j = next.getMsgId();
                }
            } else {
                arrayList2.add(next);
            }
        }
        String str2 = TAG;
        LogUtils.d(str2, "normalAll dispatcher : msgs2.size() : " + arrayList2.size());
        if (arrayList2.size() > 0 && (list = normalALL) != null && list.size() > 0) {
            for (MsgListener msgListener2 : normalALL) {
                msgListener2.dealMessage(i2, arrayList2);
            }
        }
        dispatchMesageToCentain(i2, arrayList);
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
}
