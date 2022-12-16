package com.baidu.android.imsdk.media.update;

import android.content.Context;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.media.listener.ISessionUpdateManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class DefaultUpdateManager implements ISessionUpdateManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<Integer> mediaChatTypes;
    public List<Integer> mediaFilterUserChatTypes;
    public Context sContext;

    public DefaultUpdateManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mediaFilterUserChatTypes = Arrays.asList(0, 3, 57, 7, 16, 21, 4);
        this.mediaChatTypes = Arrays.asList(19, 29, 57, 60, 58);
        this.sContext = context;
    }

    @Override // com.baidu.android.imsdk.media.listener.ISessionUpdateManager
    public List<ChatSession> filterMediaSessionUpdate(int i, int i2, List<ChatSession> list) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i, i2, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (list != null && list.size() != 0 && i == 1) {
                if (!AccountManager.getMediaRole(this.sContext)) {
                    return arrayList;
                }
                return list;
            }
            return arrayList;
        }
        return (List) invokeIIL.objValue;
    }

    @Override // com.baidu.android.imsdk.media.listener.ISessionUpdateManager
    public List<ChatSession> filterNotifyAggVirtualSession(int i, int i2, List<ChatSession> list) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (list != null && list.size() != 0 && !AccountManager.getMediaRole(this.sContext)) {
                for (ChatSession chatSession : list) {
                    if (chatSession.getIsStranger() != 1) {
                        if (chatSession.getClassType() > 0 && chatSession.getSessionFrom() == 2) {
                            return new ArrayList();
                        }
                        if (chatSession.getClassType() > 0) {
                            arrayList.add(chatSession);
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeIIL.objValue;
    }

    @Override // com.baidu.android.imsdk.media.listener.ISessionUpdateManager
    public List<ChatSession> filterSendToMediaSession(int i, int i2, List<ChatSession> list) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048579, this, i, i2, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (AccountManager.getMediaRole(this.sContext) && list != null && list.size() != 0 && i == 0) {
                for (ChatSession chatSession : list) {
                    if (this.mediaChatTypes.contains(Integer.valueOf(chatSession.getChatType()))) {
                        arrayList.add(chatSession);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeIIL.objValue;
    }

    @Override // com.baidu.android.imsdk.media.listener.ISessionUpdateManager
    public List<ChatSession> filterUserSessionUpdate(int i, int i2, List<ChatSession> list) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048580, this, i, i2, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (list != null && list.size() != 0 && i == 0) {
                if (AccountManager.getMediaRole(this.sContext)) {
                    for (ChatSession chatSession : list) {
                        if (!this.mediaFilterUserChatTypes.contains(Integer.valueOf(chatSession.getChatType()))) {
                            arrayList.add(chatSession);
                        }
                    }
                    return arrayList;
                }
                return list;
            }
            return arrayList;
        }
        return (List) invokeIIL.objValue;
    }

    @Override // com.baidu.android.imsdk.media.listener.ISessionUpdateManager
    public List<ChatSession> filterNotifyStrangerFolder(int i, int i2, List<ChatSession> list) {
        InterceptResult invokeIIL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (list != null && list.size() != 0) {
                boolean z2 = false;
                if (i == 0 && !AccountManager.getMediaRole(this.sContext)) {
                    z = true;
                } else {
                    z = false;
                }
                if (i == 1 && AccountManager.getMediaRole(this.sContext)) {
                    z2 = true;
                }
                if (!z && !z2) {
                    return arrayList;
                }
                if (i2 == 8) {
                    arrayList.addAll(list);
                    return arrayList;
                }
                for (ChatSession chatSession : list) {
                    if (chatSession.getIsStranger() == 1 && chatSession.getSessionFrom() == 2) {
                        return new ArrayList();
                    }
                    if (chatSession.getIsStranger() == 1) {
                        arrayList.add(chatSession);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeIIL.objValue;
    }
}
