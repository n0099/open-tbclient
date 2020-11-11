package com.baidu.android.imsdk.internal;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes18.dex */
public class IMManagerImpl {
    private static volatile IMManagerImpl mInstance;
    private static Object mLock = new Object();
    private static Context sContext;

    private IMManagerImpl() {
        loadClasses();
    }

    public static String getVersion() {
        return String.valueOf(IMConfigInternal.getInstance().getSDKVersionValue(sContext));
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

    public void start(Context context) {
        Utility.startIMService(context);
    }

    public void stop(Context context) {
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

    private boolean isKickOffMsg(ChatMsg chatMsg) {
        return chatMsg.getMsgType() == 3 && chatMsg.getNotifyCmd() == 50;
    }

    public boolean setProductLine(int i) {
        return IMConfigInternal.getInstance().setProductLine(sContext, i);
    }

    private void loadClasses() {
        int i = 0;
        List<Integer> index = getIndex();
        if (index == null) {
            return;
        }
        String[] strArr = {"com.baidu.android.imsdk.account.AccountManager", "com.baidu.android.imsdk.chatmessage.ChatMsgManager", "com.baidu.android.imsdk.chatuser.ChatUserManager", "com.baidu.android.imsdk.friend.FriendManager", "com.baidu.android.imsdk.group.GroupManager", "com.baidu.android.imsdk.pubaccount.PaManager"};
        while (true) {
            int i2 = i;
            if (i2 < index.size() && index.get(i2).intValue() < strArr.length) {
                loadClassForName(strArr[index.get(i2).intValue()]);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private List<Integer> getIndex() {
        int i = 1;
        ArrayList arrayList = new ArrayList();
        arrayList.add(0);
        arrayList.add(1);
        for (int i2 = 0; i2 <= 29; i2++) {
            if ((536870937 & i) != 0) {
                arrayList.add(Integer.valueOf(i2 + 2));
            }
            i <<= 1;
        }
        return arrayList;
    }

    private void loadClassForName(String str) {
        Method method;
        try {
            Class<?> cls = Class.forName(str);
            if (cls != null && (method = cls.getMethod(OneKeyLoginSdkCall.l, Context.class)) != null) {
                method.invoke(cls, sContext);
            }
        } catch (Exception e) {
            new IMTrack.CrashBuilder(sContext).exception(Log.getStackTraceString(e)).build();
        }
    }
}
