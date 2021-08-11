package com.baidu.android.imsdk.chatuser.db;

import android.content.Context;
import com.baidu.android.imsdk.ChatObject;
import com.baidu.android.imsdk.ChatObjectCache;
import com.baidu.android.imsdk.chatuser.ChatUser;
import com.baidu.android.imsdk.chatuser.IpInfo;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.UKCache;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class IMUserManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMUserManager";
    public static IMUserManager mInstance;
    public static UKCache sBuidCache;
    public static ChatObjectCache sChatObjectCache;
    public static UKCache sUkCache;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-88420887, "Lcom/baidu/android/imsdk/chatuser/db/IMUserManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-88420887, "Lcom/baidu/android/imsdk/chatuser/db/IMUserManager;");
        }
    }

    public IMUserManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = null;
        this.mContext = context;
        sChatObjectCache = ChatObjectCache.getInstance();
        sUkCache = new UKCache(500);
        sBuidCache = new UKCache(500);
    }

    private ChatObject createChatObject(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65538, this, j2)) == null) ? new ChatObject(this.mContext, 0, j2) : (ChatObject) invokeJ.objValue;
    }

    public static IMUserManager getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            synchronized (IMUserManager.class) {
                if (mInstance == null) {
                    mInstance = new IMUserManager(context);
                }
            }
            return mInstance;
        }
        return (IMUserManager) invokeL.objValue;
    }

    public long getBuidByUK(long j2) {
        InterceptResult invokeJ;
        ChatUser chatUser;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) {
            Long l = sBuidCache.get(j2);
            if (l == null && (chatUser = ChatUserDBManager.getInstance(this.mContext).getChatUser(j2)) != null && chatUser.getBuid() >= 0 && chatUser.getUk() >= 0) {
                l = Long.valueOf(chatUser.getBuid());
                sChatObjectCache.put(createChatObject(j2), chatUser);
                sUkCache.put(l, Long.valueOf(j2));
                sBuidCache.put(Long.valueOf(j2), l);
            }
            if (l == null || l.longValue() <= -1) {
                return -1L;
            }
            return l.longValue();
        }
        return invokeJ.longValue;
    }

    public ChatUser getChatUser(long j2) {
        InterceptResult invokeJ;
        ChatUser chatUser;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
            ChatObject createChatObject = createChatObject(j2);
            if (isUserExist(j2)) {
                synchronized (IMUserManager.class) {
                    chatUser = (ChatUser) sChatObjectCache.get(createChatObject);
                }
                return chatUser;
            }
            ChatUser chatUser2 = ChatUserDBManager.getInstance(this.mContext).getChatUser(j2);
            synchronized (IMUserManager.class) {
                if (chatUser2 != null) {
                    sChatObjectCache.put(createChatObject, chatUser2);
                    sUkCache.put(Long.valueOf(chatUser2.getBuid()), Long.valueOf(j2));
                    sBuidCache.put(Long.valueOf(j2), Long.valueOf(chatUser2.getBuid()));
                }
            }
            return chatUser2;
        }
        return (ChatUser) invokeJ.objValue;
    }

    public long getUKbyBuid(long j2) {
        InterceptResult invokeJ;
        ChatUser chatUserByBuid;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) {
            Long l = sUkCache.get(j2);
            if (l == null && (chatUserByBuid = ChatUserDBManager.getInstance(this.mContext).getChatUserByBuid(j2)) != null && chatUserByBuid.getBuid() >= 0 && chatUserByBuid.getUk() >= 0) {
                l = Long.valueOf(chatUserByBuid.getUk());
                sChatObjectCache.put(createChatObject(l.longValue()), chatUserByBuid);
                sUkCache.put(Long.valueOf(j2), l);
                sBuidCache.put(l, Long.valueOf(j2));
            }
            if (l == null || l.longValue() <= -1) {
                return -1L;
            }
            return l.longValue();
        }
        return invokeJ.longValue;
    }

    public synchronized ArrayList<ChatUser> getUserBatch(List<Long> list) {
        InterceptResult invokeL;
        ArrayList<ChatUser> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            synchronized (this) {
                arrayList = new ArrayList<>();
                if (list != null) {
                    for (Long l : list) {
                        arrayList.add(getChatUser(l.longValue()));
                    }
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public boolean isUserExist(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j2)) == null) {
            ChatObject createChatObject = createChatObject(j2);
            synchronized (IMUserManager.class) {
                if (sChatObjectCache.get(createChatObject) != null) {
                    return true;
                }
                ChatUser chatUser = ChatUserDBManager.getInstance(this.mContext).getChatUser(j2);
                if (chatUser != null) {
                    synchronized (IMUserManager.class) {
                        if (chatUser.getBuid() > 0) {
                            sChatObjectCache.put(createChatObject, chatUser);
                            sUkCache.put(Long.valueOf(chatUser.getBuid()), Long.valueOf(j2));
                            sBuidCache.put(Long.valueOf(j2), Long.valueOf(chatUser.getBuid()));
                            return true;
                        }
                        ChatUserDBManager.getInstance(this.mContext).deleteChatUser(j2);
                        sChatObjectCache.remove(createChatObject);
                        return false;
                    }
                }
                return false;
            }
        }
        return invokeJ.booleanValue;
    }

    public void removeChatObject(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) {
            ChatObject createChatObject = createChatObject(j2);
            ChatObjectCache chatObjectCache = sChatObjectCache;
            if (chatObjectCache == null || chatObjectCache.get(createChatObject) == null) {
                return;
            }
            LogUtils.e(TAG, "removeChatObject uk = " + j2);
            sChatObjectCache.remove(createChatObject);
        }
    }

    public void updateUser(ChatUser chatUser) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, chatUser) == null) || chatUser == null) {
            return;
        }
        ChatObject createChatObject = createChatObject(chatUser.getUk());
        if (ChatUserDBManager.getInstance(this.mContext).updateUser(chatUser) > 0) {
            synchronized (IMUserManager.class) {
                sChatObjectCache.put(createChatObject, chatUser);
                sUkCache.put(Long.valueOf(chatUser.getBuid()), Long.valueOf(chatUser.getUk()));
                sBuidCache.put(Long.valueOf(chatUser.getUk()), Long.valueOf(chatUser.getBuid()));
            }
        }
    }

    public synchronized boolean updateUserIpInfo(ArrayList<IpInfo> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, arrayList)) == null) {
            synchronized (this) {
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
        return invokeL.booleanValue;
    }
}
