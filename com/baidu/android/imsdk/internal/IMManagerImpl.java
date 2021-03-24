package com.baidu.android.imsdk.internal;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.Utility;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class IMManagerImpl {
    public static volatile IMManagerImpl mInstance;
    public static Object mLock = new Object();
    public static Context sContext;

    public IMManagerImpl() {
        loadClasses();
    }

    private List<Integer> getIndex() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0);
        int i = 1;
        arrayList.add(1);
        for (int i2 = 0; i2 <= 29; i2++) {
            if ((536870937 & i) != 0) {
                arrayList.add(Integer.valueOf(i2 + 2));
            }
            i <<= 1;
        }
        return arrayList;
    }

    public static IMManagerImpl getInstance(Context context) {
        if (mInstance == null) {
            synchronized (mLock) {
                if (mInstance == null) {
                    sContext = context;
                    mInstance = new IMManagerImpl();
                }
            }
        }
        return mInstance;
    }

    public static String getVersion() {
        return String.valueOf(IMConfigInternal.getInstance().getSDKVersionValue(sContext));
    }

    private boolean isKickOffMsg(ChatMsg chatMsg) {
        return chatMsg.getMsgType() == 3 && chatMsg.getNotifyCmd() == 50;
    }

    private void loadClassForName(String str) {
        Method method;
        try {
            Class<?> cls = Class.forName(str);
            if (cls == null || (method = cls.getMethod("init", Context.class)) == null) {
                return;
            }
            method.invoke(cls, sContext);
        } catch (Exception e2) {
            new IMTrack.CrashBuilder(sContext).exception(Log.getStackTraceString(e2)).build();
        }
    }

    private void loadClasses() {
        List<Integer> index = getIndex();
        if (index == null) {
            return;
        }
        String[] strArr = {"com.baidu.android.imsdk.account.AccountManager", "com.baidu.android.imsdk.chatmessage.ChatMsgManager", "com.baidu.android.imsdk.chatuser.ChatUserManager", "com.baidu.android.imsdk.friend.FriendManager", "com.baidu.android.imsdk.group.GroupManager", "com.baidu.android.imsdk.pubaccount.PaManager"};
        for (int i = 0; i < index.size() && index.get(i).intValue() < 6; i++) {
            loadClassForName(strArr[index.get(i).intValue()]);
        }
    }

    public ChatMsg checkKickOffMsg(ArrayList<ChatMsg> arrayList) {
        if (arrayList == null) {
            return null;
        }
        Iterator<ChatMsg> it = arrayList.iterator();
        while (it.hasNext()) {
            ChatMsg next = it.next();
            if (isKickOffMsg(next)) {
                return next;
            }
        }
        return null;
    }

    public boolean setProductLine(int i) {
        return IMConfigInternal.getInstance().setProductLine(sContext, i);
    }

    public void start(Context context) {
        Utility.startIMService(context);
    }

    public void stop(Context context) {
    }
}
