package com.baidu.android.imsdk.chatuser.db;

import android.content.Context;
import com.baidu.android.imsdk.ChatObject;
import com.baidu.android.imsdk.ChatObjectCache;
import com.baidu.android.imsdk.chatuser.ChatUser;
import com.baidu.android.imsdk.chatuser.IpInfo;
import com.baidu.android.imsdk.internal.UKCache;
import com.baidu.android.imsdk.utils.LogUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class IMUserManager {
    public static final String TAG = "IMUserManager";
    public static IMUserManager mInstance;
    public static UKCache sBuidCache;
    public static ChatObjectCache sChatObjectCache;
    public static UKCache sUkCache;
    public Context mContext;

    public IMUserManager(Context context) {
        this.mContext = null;
        this.mContext = context;
        sChatObjectCache = ChatObjectCache.getInstance();
        sUkCache = new UKCache(500);
        sBuidCache = new UKCache(500);
    }

    private ChatObject createChatObject(long j) {
        return new ChatObject(this.mContext, 0, j);
    }

    public static IMUserManager getInstance(Context context) {
        synchronized (IMUserManager.class) {
            if (mInstance == null) {
                mInstance = new IMUserManager(context);
            }
        }
        return mInstance;
    }

    public long getBuidByUK(long j) {
        ChatUser chatUser;
        Long l = sBuidCache.get(j);
        if (l == null && (chatUser = ChatUserDBManager.getInstance(this.mContext).getChatUser(j)) != null && chatUser.getBuid() >= 0 && chatUser.getUk() >= 0) {
            l = Long.valueOf(chatUser.getBuid());
            sChatObjectCache.put(createChatObject(j), chatUser);
            sUkCache.put(l, Long.valueOf(j));
            sBuidCache.put(Long.valueOf(j), l);
        }
        if (l == null || l.longValue() <= -1) {
            return -1L;
        }
        return l.longValue();
    }

    public ChatUser getChatUser(long j) {
        ChatUser chatUser;
        ChatObject createChatObject = createChatObject(j);
        if (isUserExist(j)) {
            synchronized (IMUserManager.class) {
                chatUser = (ChatUser) sChatObjectCache.get(createChatObject);
            }
            return chatUser;
        }
        ChatUser chatUser2 = ChatUserDBManager.getInstance(this.mContext).getChatUser(j);
        synchronized (IMUserManager.class) {
            if (chatUser2 != null) {
                sChatObjectCache.put(createChatObject, chatUser2);
                sUkCache.put(Long.valueOf(chatUser2.getBuid()), Long.valueOf(j));
                sBuidCache.put(Long.valueOf(j), Long.valueOf(chatUser2.getBuid()));
            }
        }
        return chatUser2;
    }

    public long getUKbyBuid(long j) {
        ChatUser chatUserByBuid;
        Long l = sUkCache.get(j);
        if (l == null && (chatUserByBuid = ChatUserDBManager.getInstance(this.mContext).getChatUserByBuid(j)) != null && chatUserByBuid.getBuid() >= 0 && chatUserByBuid.getUk() >= 0) {
            l = Long.valueOf(chatUserByBuid.getUk());
            sChatObjectCache.put(createChatObject(l.longValue()), chatUserByBuid);
            sUkCache.put(Long.valueOf(j), l);
            sBuidCache.put(l, Long.valueOf(j));
        }
        if (l == null || l.longValue() <= -1) {
            return -1L;
        }
        return l.longValue();
    }

    public synchronized ArrayList<ChatUser> getUserBatch(List<Long> list) {
        ArrayList<ChatUser> arrayList;
        arrayList = new ArrayList<>();
        if (list != null) {
            for (Long l : list) {
                arrayList.add(getChatUser(l.longValue()));
            }
        }
        return arrayList;
    }

    public boolean isUserExist(long j) {
        ChatObject createChatObject = createChatObject(j);
        synchronized (IMUserManager.class) {
            if (sChatObjectCache.get(createChatObject) != null) {
                return true;
            }
            ChatUser chatUser = ChatUserDBManager.getInstance(this.mContext).getChatUser(j);
            if (chatUser != null) {
                synchronized (IMUserManager.class) {
                    if (chatUser.getBuid() > 0) {
                        sChatObjectCache.put(createChatObject, chatUser);
                        sUkCache.put(Long.valueOf(chatUser.getBuid()), Long.valueOf(j));
                        sBuidCache.put(Long.valueOf(j), Long.valueOf(chatUser.getBuid()));
                        return true;
                    }
                    ChatUserDBManager.getInstance(this.mContext).deleteChatUser(j);
                    sChatObjectCache.remove(createChatObject);
                    return false;
                }
            }
            return false;
        }
    }

    public void removeChatObject(long j) {
        ChatObject createChatObject = createChatObject(j);
        ChatObjectCache chatObjectCache = sChatObjectCache;
        if (chatObjectCache == null || chatObjectCache.get(createChatObject) == null) {
            return;
        }
        LogUtils.e(TAG, "removeChatObject uk = " + j);
        sChatObjectCache.remove(createChatObject);
    }

    public void updateUser(ChatUser chatUser) {
        if (chatUser != null) {
            ChatObject createChatObject = createChatObject(chatUser.getUk());
            if (ChatUserDBManager.getInstance(this.mContext).updateUser(chatUser) > 0) {
                synchronized (IMUserManager.class) {
                    sChatObjectCache.put(createChatObject, chatUser);
                    sUkCache.put(Long.valueOf(chatUser.getBuid()), Long.valueOf(chatUser.getUk()));
                    sBuidCache.put(Long.valueOf(chatUser.getUk()), Long.valueOf(chatUser.getBuid()));
                }
            }
        }
    }

    public synchronized boolean updateUserIpInfo(ArrayList<IpInfo> arrayList) {
        if (arrayList != null) {
            if (ChatUserDBManager.getInstance(this.mContext).updateUserIpInfo(arrayList) >= 0) {
                Iterator<IpInfo> it = arrayList.iterator();
                while (it.hasNext()) {
                    IpInfo next = it.next();
                    ChatObject createChatObject = createChatObject(next.getUid());
                    ChatUser chatUser = (ChatUser) sChatObjectCache.get(createChatObject);
                    if (chatUser != null) {
                        chatUser.setIpInfo(next);
                        chatUser.setIsIpLocationExist(0);
                        sChatObjectCache.put(createChatObject, chatUser);
                        sUkCache.put(Long.valueOf(chatUser.getBuid()), Long.valueOf(chatUser.getUk()));
                        sBuidCache.put(Long.valueOf(chatUser.getUk()), Long.valueOf(chatUser.getBuid()));
                    }
                }
                return true;
            }
        }
        return false;
    }
}
