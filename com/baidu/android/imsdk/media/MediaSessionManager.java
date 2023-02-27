package com.baidu.android.imsdk.media;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.ChatObject;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.account.TodoAfterLogin;
import com.baidu.android.imsdk.account.TodoBeforeLogout;
import com.baidu.android.imsdk.chatmessage.ChatMsgManager;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.chatmessage.request.params.FetchMsgParam;
import com.baidu.android.imsdk.chatmessage.response.FetchMsgResponse;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.internal.BaseManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.media.bean.GetSessionResult;
import com.baidu.android.imsdk.media.bean.SessionParam;
import com.baidu.android.imsdk.media.db.MediaMessageDBManager;
import com.baidu.android.imsdk.media.listener.BIMValuesCallBack;
import com.baidu.android.imsdk.pubaccount.PaInfo;
import com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager;
import com.baidu.android.imsdk.ubc.ScreenUbc;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.tieba.q80;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class MediaSessionManager extends BaseManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "MediaSessionManager";
    public static volatile MediaSessionManager mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public BIMValueCallBack<FetchMsgResponse> dispatchMsgCallBack;
    public volatile long mClientCredibleSortTime;
    public long mClientMaxSortTime;
    public Context mContext;
    public long mCurrentPaid;
    public volatile boolean mFetchHasMore;
    public int mMediaTotalUnread;
    public int mStrangerUnread;

    public MediaSessionManager(Context context) {
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
        this.mMediaTotalUnread = 0;
        this.mStrangerUnread = 0;
        this.mClientMaxSortTime = 0L;
        this.mClientCredibleSortTime = Long.MAX_VALUE;
        this.mFetchHasMore = true;
        this.dispatchMsgCallBack = new BIMValueCallBack<FetchMsgResponse>(this) { // from class: com.baidu.android.imsdk.media.MediaSessionManager.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaSessionManager this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.android.imsdk.group.BIMValueCallBack
            public void onResult(int i3, String str, FetchMsgResponse fetchMsgResponse) {
                Collection collection;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeILL(1048576, this, i3, str, fetchMsgResponse) == null) && i3 == 0) {
                    if (fetchMsgResponse == null) {
                        collection = new ArrayList();
                    } else {
                        collection = fetchMsgResponse.msgs;
                    }
                    ChatMsgManagerImpl.getInstance(this.this$0.mContext).broadcastMessage(new ArrayList<>(collection), false);
                }
            }
        };
        if (this.mContext == null) {
            this.mContext = context.getApplicationContext();
            registerListeners();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fetchNotifyStrangerList(SessionParam sessionParam) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65546, this, sessionParam) != null) || sessionParam == null) {
            return;
        }
        sessionParam.mode = 2;
        getChatSessionFromServer(sessionParam, new BIMValuesCallBack<GetSessionResult, SessionParam>(this) { // from class: com.baidu.android.imsdk.media.MediaSessionManager.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaSessionManager this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.android.imsdk.media.listener.BIMValuesCallBack
            public void onResult(int i, String str, GetSessionResult getSessionResult, SessionParam sessionParam2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, getSessionResult, sessionParam2}) != null) {
                    return;
                }
                this.this$0.fetchNotifyNewMsg(getSessionResult.sessionList);
            }
        });
    }

    public static MediaSessionManager getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            if (mInstance == null) {
                synchronized (MediaSessionManager.class) {
                    if (mInstance == null) {
                        mInstance = new MediaSessionManager(context);
                    }
                }
            }
            return mInstance;
        }
        return (MediaSessionManager) invokeL.objValue;
    }

    public void setMediaPaid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048590, this, j) == null) {
            this.mCurrentPaid = j;
        }
    }

    public void setMediaTotalUnread(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048591, this, i) == null) && i >= 0) {
            this.mMediaTotalUnread = i;
        }
    }

    public void setStrangerUnread(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048593, this, i) == null) && i >= 0) {
            this.mStrangerUnread = i;
        }
    }

    private void cacheSortTime(List<ChatSession> list, int i) {
        long j;
        long j2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(65542, this, list, i) != null) || i != 1) {
            return;
        }
        long j3 = 0;
        if (list != null && list.size() > 0) {
            j = Long.MAX_VALUE;
            j2 = Long.MAX_VALUE;
            for (ChatSession chatSession : list) {
                long sortTime = chatSession.getSortTime();
                j3 = Math.max(sortTime, j3);
                if (chatSession.getMarkTop() == 1) {
                    j = Math.min(sortTime, j);
                } else {
                    j2 = Math.min(sortTime, j2);
                }
            }
        } else {
            j = Long.MAX_VALUE;
            j2 = Long.MAX_VALUE;
        }
        if (j2 < Long.MAX_VALUE) {
            j = j2;
        }
        this.mClientCredibleSortTime = Math.min(this.mClientCredibleSortTime, j);
        this.mClientMaxSortTime = Math.max(this.mClientMaxSortTime, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLoginInfo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.mClientCredibleSortTime = Long.MAX_VALUE;
            this.mFetchHasMore = true;
            this.mClientMaxSortTime = 0L;
            this.mCurrentPaid = 0L;
            this.mMediaTotalUnread = 0;
            this.mStrangerUnread = 0;
            ChatSessionManagerImpl.getInstance(this.mContext).setBusiSessionTotalUnread(27, 0);
            ChatSessionManagerImpl.getInstance(this.mContext).writeServerUnreadnum(0, false);
        }
    }

    private void doNewMsgNotify() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            SessionParam notifyRequestParam = SessionParam.getNotifyRequestParam(this.mContext);
            getChatSessionFromServer(notifyRequestParam, new BIMValuesCallBack<GetSessionResult, SessionParam>(this, notifyRequestParam) { // from class: com.baidu.android.imsdk.media.MediaSessionManager.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionManager this$0;
                public final /* synthetic */ SessionParam val$param;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, notifyRequestParam};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$param = notifyRequestParam;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.android.imsdk.media.listener.BIMValuesCallBack
                public void onResult(int i, String str, GetSessionResult getSessionResult, SessionParam sessionParam) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, getSessionResult, sessionParam}) == null) && i == 0 && getSessionResult != null && getSessionResult.sessionList.size() > 0) {
                        Iterator<ChatSession> it = getSessionResult.sessionList.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            ChatSession next = it.next();
                            if (next.getIsStranger() == 1 && next.getSessionFrom() == 2) {
                                this.this$0.fetchNotifyStrangerList(this.val$param);
                                break;
                            }
                        }
                        this.this$0.fetchNotifyNewMsg(getSessionResult.sessionList);
                    }
                }
            });
        }
    }

    private void registerListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            AccountManagerImpl.getInstance(this.mContext).registerToDoAfterLoginListener(new TodoAfterLogin(this) { // from class: com.baidu.android.imsdk.media.MediaSessionManager.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionManager this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.android.imsdk.account.TodoAfterLogin
                public void todo(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                        SessionParam listRequestParam = SessionParam.getListRequestParam();
                        listRequestParam.reason = 0;
                        this.this$0.getSessionListForLogin(5, listRequestParam);
                    }
                }
            });
            AccountManagerImpl.getInstance(this.mContext).registerToDoBeforeLogoutListener(new TodoBeforeLogout(this) { // from class: com.baidu.android.imsdk.media.MediaSessionManager.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionManager this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.android.imsdk.account.TodoBeforeLogout
                public void todo() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                        return;
                    }
                    this.this$0.clearLoginInfo();
                }
            });
        }
    }

    public int getAdvisoryUnread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return ChatSessionManagerImpl.getInstance(this.mContext).getBusiSessionTotalUnread(27);
        }
        return invokeV.intValue;
    }

    public long getClientMaxSortTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mClientMaxSortTime + 1;
        }
        return invokeV.longValue;
    }

    public int getMediaTotalUnread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mMediaTotalUnread + ChatMessageDBManager.getInstance(this.mContext).getNewMsgCount(SessionParam.MEDIA_UNREAD_NUM_CHAT_TYPES, 0L);
        }
        return invokeV.intValue;
    }

    public long getMeidaPaid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mCurrentPaid;
        }
        return invokeV.longValue;
    }

    public int getStrangerUnread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mStrangerUnread;
        }
        return invokeV.intValue;
    }

    public void handleMediaStrangerAllRead() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            setStrangerUnread(0);
            MediaMessageDBManager.getInstance(this.mContext).setAllStrangersRead();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fetchNotifyNewMsg(List<ChatSession> list) {
        boolean z;
        long paid;
        long j;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65545, this, list) == null) && list != null && list.size() != 0) {
            for (ChatSession chatSession : list) {
                long contacter = chatSession.getContacter();
                if (chatSession.getPaid() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    j = contacter;
                    paid = 0;
                } else {
                    paid = chatSession.getPaid();
                    j = 0;
                }
                FetchMsgParam.FetchMsgParamConstruct fetchMsgParamConstruct = new FetchMsgParam.FetchMsgParamConstruct(this) { // from class: com.baidu.android.imsdk.media.MediaSessionManager.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MediaSessionManager this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // com.baidu.android.imsdk.chatmessage.request.params.FetchMsgParam.FetchMsgParamConstruct
                    public void construct(FetchMsgParam fetchMsgParam) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, fetchMsgParam) == null) {
                            fetchMsgParam.setTriggerReason(2);
                            BIMManager.fetchMsg(this.this$0.mContext, fetchMsgParam);
                        }
                    }
                };
                long maxMsgid = MediaMessageDBManager.getInstance(this.mContext).getMaxMsgid();
                if (z) {
                    FetchMsgParam.newInstanceByPa(this.mContext, maxMsgid, Long.MAX_VALUE, 20, chatSession.getCategory(), paid, "", this.dispatchMsgCallBack, fetchMsgParamConstruct);
                } else {
                    FetchMsgParam.newInstanceByUk(this.mContext, maxMsgid, Long.MAX_VALUE, 20, chatSession.getCategory(), j, "", this.dispatchMsgCallBack, fetchMsgParamConstruct);
                }
            }
        }
    }

    public void handleMediaNotify(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, jSONObject) == null) {
            int optInt = jSONObject.optInt("type", -1);
            JSONObject optJSONObject = jSONObject.optJSONObject("content");
            optJSONObject.optLong("contacter_bduid", -1L);
            int optInt2 = optJSONObject.optInt("contacter_type", -1);
            long optLong = optJSONObject.optLong("contacter_pauid", -1L);
            optJSONObject.optString("contacter_third_id", "");
            long optLong2 = optJSONObject.optLong("contacter_uk");
            long optLong3 = optJSONObject.optLong("msgid", -1L);
            if (optInt == 2) {
                doNewMsgNotify();
            } else if (optInt == 1) {
                if (optInt2 == -1) {
                    handleMediaAllRead();
                } else {
                    handleMediaSessionRead(0, optLong2, Long.MAX_VALUE);
                }
            } else if (optInt == 3) {
                MediaMessageDBManager.getInstance(this.mContext).delMsgs(0, optLong2, new long[]{optLong3});
            } else if (optInt == 4) {
                handleMediaDeleteSession(0, optLong2, optLong, 0, 0, 0);
            }
        }
    }

    private SessionParam getNextRequestParam(int i, int i2, int i3, int i4, List<ChatSession> list) {
        InterceptResult invokeCommon;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), list})) == null) {
            if (list != null && list.size() > i) {
                list = list.subList(0, i);
            }
            if (list != null && list.size() > 0) {
                j = list.get(list.size() - 1).getSortTime() - 1;
            } else {
                j = 0;
            }
            return SessionParam.getListNextParam(i3, i2, j, i4);
        }
        return (SessionParam) invokeCommon.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getSessionListForLogin(int i, SessionParam sessionParam) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(65549, this, i, sessionParam) == null) && !AccountManager.isCuidLogin(this.mContext) && AccountManager.getMediaRole(this.mContext) && i > 0 && sessionParam != null) {
            LogUtils.d("MediaSessionManager", "getSessionListForLogin count = " + i);
            getChatSessionFromServer(sessionParam, new BIMValuesCallBack<GetSessionResult, SessionParam>(this, i) { // from class: com.baidu.android.imsdk.media.MediaSessionManager.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionManager this$0;
                public final /* synthetic */ int val$count;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$count = i;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.android.imsdk.media.listener.BIMValuesCallBack
                public void onResult(int i2, String str, GetSessionResult getSessionResult, SessionParam sessionParam2) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, getSessionResult, sessionParam2}) == null) && i2 == 0 && getSessionResult != null && getSessionResult.hasMore) {
                        this.this$0.getSessionListForLogin(this.val$count - 1, sessionParam2);
                    }
                }
            });
        }
    }

    private GetSessionResult getSessionResult(int i, int i2, boolean z, List<ChatSession> list) {
        InterceptResult invokeCommon;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), list})) == null) {
            GetSessionResult getSessionResult = new GetSessionResult();
            int i3 = 0;
            if (list == null) {
                size = 0;
            } else {
                size = list.size();
            }
            if (i != 0) {
                if (size > i2) {
                    z = true;
                } else {
                    z = false;
                }
            }
            getSessionResult.hasMore = z;
            if (list != null && list.size() > i2) {
                getSessionResult.sessionList = list.subList(0, i2);
            } else {
                getSessionResult.sessionList = list;
            }
            getSessionResult.totalUnread = getInstance(this.mContext).getMediaTotalUnread();
            getSessionResult.dotUnread = getInstance(this.mContext).getStrangerUnread();
            int advisoryUnread = getInstance(this.mContext).getAdvisoryUnread();
            int totalUnReadMsgCountByAdvisory = ChatMsgManager.getTotalUnReadMsgCountByAdvisory(this.mContext, 0L);
            if (advisoryUnread > 0) {
                getSessionResult.consultUnread = advisoryUnread;
            } else {
                if (totalUnReadMsgCountByAdvisory > 0) {
                    i3 = -1;
                }
                getSessionResult.consultUnread = i3;
            }
            return getSessionResult;
        }
        return (GetSessionResult) invokeCommon.objValue;
    }

    private void onStorageSessions(List<ChatSession> list, int i, boolean z, boolean z2, long j, long j2) {
        int i2;
        long j3;
        long j4;
        long j5;
        long j6;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65551, this, new Object[]{list, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), Long.valueOf(j), Long.valueOf(j2)}) == null) && list != null && list.size() != 0) {
            ArrayList<ChatSession> arrayList = new ArrayList();
            ArrayList<ChatSession> arrayList2 = new ArrayList();
            Iterator<ChatSession> it = list.iterator();
            while (true) {
                i2 = 1;
                if (!it.hasNext()) {
                    break;
                }
                ChatSession next = it.next();
                if (next.getMarkTop() == 1) {
                    arrayList.add(next);
                } else {
                    arrayList2.add(next);
                }
            }
            if (arrayList.size() > 0) {
                if (z2) {
                    j6 = Long.MAX_VALUE;
                    for (ChatSession chatSession : arrayList) {
                        if (j6 > chatSession.getSortTime()) {
                            j6 = chatSession.getSortTime();
                        }
                    }
                } else {
                    j6 = j;
                }
                j3 = j2;
                MediaMessageDBManager.getInstance(this.mContext).clearChatSessionMarkTop(j6, j3);
                MediaMessageDBManager.getInstance(this.mContext).updateSessionList(arrayList, i);
            } else {
                j3 = j2;
            }
            if (arrayList2.size() > 0) {
                if (z) {
                    long j7 = Long.MAX_VALUE;
                    for (ChatSession chatSession2 : arrayList2) {
                        if (j7 > chatSession2.getSortTime()) {
                            j7 = chatSession2.getSortTime();
                        }
                    }
                    j4 = j7;
                } else {
                    j4 = j;
                }
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                for (ChatSession chatSession3 : arrayList2) {
                    if (i == i2 && Utility.isValidAggSession(chatSession3.getClassType(), chatSession3.getClassShow())) {
                        arrayList4.add(Integer.valueOf(chatSession3.getClassType()));
                    } else if (chatSession3.getContacter() > 0) {
                        arrayList3.add(Long.valueOf(chatSession3.getContacter()));
                    }
                    i2 = 1;
                }
                if (arrayList.size() > 0) {
                    j5 = Long.MAX_VALUE;
                } else {
                    j5 = j3;
                }
                MediaMessageDBManager.getInstance(this.mContext).delUselessChatSession(j4, j5, arrayList3, arrayList4, i);
                MediaMessageDBManager.getInstance(this.mContext).updateSessionList(arrayList2, i);
            }
        }
    }

    private boolean shouldDelSendToUser(@NonNull SessionParam sessionParam) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        ChatSession chatRecord;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, this, sessionParam)) == null) {
            if (sessionParam.category == 9 || sessionParam.businessType == 27) {
                return false;
            }
            int i = 1;
            if (sessionParam.classType > 0 && sessionParam.type == 0) {
                return true;
            }
            ChatSession chatRecord2 = ChatMessageDBManager.getInstance(this.mContext).getChatRecord(sessionParam.category, sessionParam.contacterId);
            if (chatRecord2 != null && !sessionParam.allChatTypes.contains(Integer.valueOf(chatRecord2.getChatType()))) {
                z = true;
            } else {
                z = false;
            }
            if (chatRecord2 != null && Utility.isValidAggSession(chatRecord2.getClassType(), chatRecord2.getClassShow()) && sessionParam.type == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z || z2) {
                return true;
            }
            if (sessionParam.classType > 0 && sessionParam.type == 1) {
                chatRecord = MediaMessageDBManager.getInstance(this.mContext).getMediaChatSessionByClassType(sessionParam.classType);
            } else if (sessionParam.isStranger == 1 && sessionParam.type == 1) {
                chatRecord = MediaMessageDBManager.getInstance(this.mContext).getMediaStrangerFolderSession();
            } else if (sessionParam.category == 1) {
                chatRecord = MediaMessageDBManager.getInstance(this.mContext).getChatRecord(sessionParam.category, sessionParam.contacterId);
                if (chatRecord == null) {
                    return true;
                }
            } else {
                chatRecord = MediaMessageDBManager.getInstance(this.mContext).getChatRecord(sessionParam.category, sessionParam.contacterId);
            }
            if (chatRecord != null) {
                sessionParam.contacterPaid = chatRecord.getPaid();
                sessionParam.clientMaxMsgid = chatRecord.getLastMsgId();
                if (sessionParam.contacterPaid <= 0) {
                    i = 0;
                }
                sessionParam.contacterUserType = i;
                sessionParam.businessType = chatRecord.getBusinessType();
                sessionParam.isStranger = chatRecord.getIsStranger();
                sessionParam.contacterImUk = chatRecord.getContacterImuk();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private boolean shouldReadSendToUser(@NonNull SessionParam sessionParam) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, this, sessionParam)) == null) {
            if (sessionParam.businessType != 27 && sessionParam.category != 9) {
                if (sessionParam.isStranger == 1) {
                    z = true;
                } else {
                    z = false;
                }
                if (sessionParam.category == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (sessionParam.classType > 0 && sessionParam.type == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (sessionParam.classType > 0 && sessionParam.type == 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (!z && (z2 || z3 || z4)) {
                    return true;
                }
                ChatSession chatRecord = ChatMessageDBManager.getInstance(this.mContext).getChatRecord(sessionParam.category, sessionParam.contacterId);
                if (chatRecord != null && !SessionParam.MEDIA_CHAT_TYPES.contains(Integer.valueOf(chatRecord.getChatType()))) {
                    return true;
                }
                ChatSession chatRecord2 = MediaMessageDBManager.getInstance(this.mContext).getChatRecord(sessionParam.category, sessionParam.contacterId);
                if (chatRecord2 != null) {
                    long lastMsgId = chatRecord2.getLastMsgId();
                    sessionParam.clientMaxMsgid = lastMsgId;
                    if (lastMsgId < 0) {
                        sessionParam.clientMaxMsgid = Long.MAX_VALUE;
                    }
                    if (sessionParam.contacterPaid > 0) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    sessionParam.contacterUserType = i;
                    sessionParam.businessType = chatRecord2.getBusinessType();
                    if (sessionParam.type == 1 && sessionParam.isStranger == 1) {
                        sessionParam.contacterPaid = 0L;
                        sessionParam.contacterImUk = 0L;
                    } else {
                        sessionParam.contacterPaid = chatRecord2.getPaid();
                        sessionParam.contacterImUk = chatRecord2.getContacterImuk();
                    }
                } else {
                    sessionParam.clientMaxMsgid = Long.MAX_VALUE;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void deleteSession(@NonNull SessionParam sessionParam, BIMValueCallBack<Object> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, sessionParam, bIMValueCallBack) == null) {
            if (shouldDelSendToUser(sessionParam)) {
                ChatSessionManagerImpl.getInstance(this.mContext).deleteSession(sessionParam, bIMValueCallBack);
                return;
            }
            String addListener = ListenerManager.getInstance().addListener(bIMValueCallBack);
            Intent creatMethodIntent = Utility.creatMethodIntent(this.mContext, Constants.METHOD_IM_DEL_BUSINESS_SESSION_MSG);
            creatMethodIntent.putExtra("contacter", sessionParam.contacterImUk);
            creatMethodIntent.putExtra(Constants.EXTRA_BUSINESS_TYPE, sessionParam.businessType);
            creatMethodIntent.putExtra("category", sessionParam.category);
            creatMethodIntent.putExtra(Constants.EXTRA_CLIENT_MAX_MSGID, sessionParam.clientMaxMsgid);
            creatMethodIntent.putExtra(Constants.EXTRA_PA_ID, sessionParam.contacterPaid);
            creatMethodIntent.putExtra(Constants.EXTRA_CLASS_TYPE, sessionParam.classType);
            creatMethodIntent.putExtra(Constants.EXTRA_IS_STRANGER, sessionParam.isStranger);
            creatMethodIntent.putExtra("type", sessionParam.type);
            if (!TextUtils.isEmpty(addListener)) {
                creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
            }
            try {
                q80.e(this.mContext).d(this.mContext, creatMethodIntent);
            } catch (Exception e) {
                LogUtils.e("MediaSessionManager", "setServerBCMsgRead Exception ", e);
                if (bIMValueCallBack != null) {
                    bIMValueCallBack.onResult(1003, Constants.ERROR_MSG_SERVICE_ERROR, null);
                }
            }
        }
    }

    public void getChatSessionFromServer(SessionParam sessionParam, BIMValuesCallBack<GetSessionResult, SessionParam> bIMValuesCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, sessionParam, bIMValuesCallBack) == null) {
            LogUtils.d("MediaSessionManager", "getChatSessionFromServer start");
            if (sessionParam == null) {
                if (bIMValuesCallBack != null) {
                    bIMValuesCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, GetSessionResult.getFailResult(), null);
                    return;
                }
                return;
            }
            String addListener = ListenerManager.getInstance().addListener(bIMValuesCallBack);
            Intent creatMethodIntent = Utility.creatMethodIntent(this.mContext, 206);
            creatMethodIntent.putExtra(Constants.EXTRA_BUSINESS_TYPE, sessionParam.businessType);
            creatMethodIntent.putExtra(Constants.EXTRA_BEGIN_MSGID, sessionParam.sortUpdateTimeBegin);
            creatMethodIntent.putExtra(Constants.EXTRA_END_MSGID, sessionParam.sortUpdateTimeEnd);
            creatMethodIntent.putExtra("count", sessionParam.count);
            creatMethodIntent.putExtra(Constants.EXTRA_FETCH_SESSION_MODE, sessionParam.mode);
            creatMethodIntent.putExtra("session_type", sessionParam.sessionType);
            creatMethodIntent.putExtra(Constants.EXTRA_FETCH_SESSION_TOP, sessionParam.needTop);
            creatMethodIntent.putExtra(Constants.EXTRA_TRIGGER_REASON, sessionParam.reason);
            creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
            creatMethodIntent.putExtra(Constants.EXTRA_SCREEN_KEY, sessionParam.screenKey);
            q80.e(this.mContext).d(this.mContext, creatMethodIntent);
        }
    }

    public void getChatSession(SessionParam sessionParam, BIMValuesCallBack<GetSessionResult, SessionParam> bIMValuesCallBack, @NonNull ScreenUbc.MethodInfo methodInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, sessionParam, bIMValuesCallBack, methodInfo) == null) {
            LogUtils.d("MediaSessionManager", "getChatSession info :" + methodInfo.toString());
            if (sessionParam == null) {
                if (bIMValuesCallBack != null) {
                    bIMValuesCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, GetSessionResult.getFailResult(), null);
                }
            } else if (sessionParam.reason == 3 && sessionParam.mode == 1 && this.mClientMaxSortTime >= this.mClientCredibleSortTime) {
                List<ChatSession> mediaSessionList = MediaMessageDBManager.getInstance(this.mContext).getMediaSessionList(Math.max(sessionParam.sortUpdateTimeBegin, this.mClientCredibleSortTime), sessionParam.sortUpdateTimeEnd, sessionParam.count + 1, sessionParam.mode, sessionParam.needTop);
                Utility.addEventList(methodInfo.eventList, "getMediaSessionList");
                LogUtils.d("MediaSessionManager", "getChatSessionFromDb start");
                if (mediaSessionList != null && mediaSessionList.size() > sessionParam.count) {
                    LogUtils.d("MediaSessionManager", "getChatSessionFromDb size = " + mediaSessionList.size());
                    bIMValuesCallBack.onResult(0, Constants.ERROR_MSG_SUCCESS, getSessionResult(0, sessionParam.count, true, mediaSessionList), getNextRequestParam(sessionParam.count, sessionParam.mode, sessionParam.businessType, mediaSessionList.get(mediaSessionList.size() - 1).getMarkTop(), mediaSessionList));
                    methodInfo.errCode = 0;
                    methodInfo.errMsg = Constants.ERROR_MSG_SUCCESS;
                    methodInfo.endTime = System.currentTimeMillis();
                    ScreenUbc.onEvent(this.mContext, sessionParam.screenKey, methodInfo);
                } else if (!this.mFetchHasMore) {
                    LogUtils.d("MediaSessionManager", "getChatSession mFetchHasMore = false, call back");
                    bIMValuesCallBack.onResult(0, Constants.ERROR_MSG_SUCCESS, getSessionResult(0, sessionParam.count, false, mediaSessionList), getNextRequestParam(sessionParam.count, sessionParam.mode, sessionParam.businessType, 0, mediaSessionList));
                    methodInfo.errCode = 0;
                    methodInfo.errMsg = Constants.ERROR_MSG_SUCCESS;
                    methodInfo.endTime = System.currentTimeMillis();
                    ScreenUbc.onEvent(this.mContext, sessionParam.screenKey, methodInfo);
                } else {
                    getChatSessionFromServer(sessionParam, bIMValuesCallBack);
                }
            } else {
                Utility.addEventList(methodInfo.eventList, "getChatSessionFromServer");
                getChatSessionFromServer(sessionParam, bIMValuesCallBack);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleFetchSessionListResult(int i, List<ChatSession> list, int i2, boolean z, int i3, int i4, String str, long j, long j2, int i5, int i6, int i7) {
        IMListener iMListener;
        int i8;
        IMListener iMListener2;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), list, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), Integer.valueOf(i4), str, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)}) == null) {
            IMListener removeListener = ListenerManager.getInstance().removeListener(str);
            if (i == 0 && list != null && list.size() > 0) {
                cacheSortTime(list, i4);
                if (i3 == 2) {
                    MediaMessageDBManager.getInstance(this.mContext).updateSessionListFromServer(list, i4, 4);
                } else if (i3 == 0 || i3 == 3) {
                    MediaSessionManager mediaSessionManager = getInstance(this.mContext);
                    if (i2 == 1) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    i8 = 2;
                    iMListener = removeListener;
                    mediaSessionManager.onStorageSessions(list, i4, z, z2, j, j2);
                    if (i3 == i8 && i3 != 3) {
                        if (i3 == 0) {
                            IMListener iMListener3 = iMListener;
                            if (iMListener3 instanceof BIMValuesCallBack) {
                                SessionParam sessionParam = null;
                                if (i == 0) {
                                    this.mFetchHasMore = z;
                                    sessionParam = SessionParam.getListNextParam(i7, i4, this.mClientCredibleSortTime - 1, i2);
                                    sessionParam.reason = 0;
                                }
                                ((BIMValuesCallBack) iMListener3).onResult(i, "", getSessionResult(i, i5, z, list), sessionParam);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    iMListener2 = iMListener;
                    List<ChatSession> mediaSessionList = MediaMessageDBManager.getInstance(this.mContext).getMediaSessionList(j, j2, i5 + 1, i4, i6);
                    if (!(iMListener2 instanceof BIMValuesCallBack)) {
                        ((BIMValuesCallBack) iMListener2).onResult(0, Constants.ERROR_MSG_SUCCESS, getSessionResult(i, i5, z, mediaSessionList), getNextRequestParam(i5, i4, i7, i2, mediaSessionList));
                        return;
                    }
                    return;
                }
            }
            iMListener = removeListener;
            i8 = 2;
            if (i3 == i8) {
            }
            iMListener2 = iMListener;
            List<ChatSession> mediaSessionList2 = MediaMessageDBManager.getInstance(this.mContext).getMediaSessionList(j, j2, i5 + 1, i4, i6);
            if (!(iMListener2 instanceof BIMValuesCallBack)) {
            }
        }
    }

    public void handleMediaAllRead() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            List<Integer> unreadChatTypesByAllClassType = ChatSessionManagerImpl.getInstance(this.mContext).getUnreadChatTypesByAllClassType();
            ArrayList arrayList = new ArrayList();
            if (unreadChatTypesByAllClassType != null) {
                arrayList.addAll(unreadChatTypesByAllClassType);
            }
            arrayList.add(57);
            ChatMsgManager.setMsgReadByChatTpyes(this.mContext, arrayList, 0L);
            MediaMessageDBManager.getInstance(this.mContext).updateAllSessionRead();
            ChatSessionManagerImpl.getInstance(this.mContext).setAllBusinessSessionRead(27);
            getInstance(this.mContext).setMediaTotalUnread(0);
            getInstance(this.mContext).setStrangerUnread(0);
            List<PaInfo> queryPaInfoByExt = PaInfoDBManager.getInstance(this.mContext).queryPaInfoByExt(String.valueOf(27));
            if (queryPaInfoByExt != null && !queryPaInfoByExt.isEmpty()) {
                ArrayList arrayList2 = new ArrayList();
                for (PaInfo paInfo : queryPaInfoByExt) {
                    arrayList2.add(Long.valueOf(paInfo.getPaId()));
                }
                ChatMessageDBManager.getInstance(this.mContext).setMsgReadByContacterIds(arrayList2, 0L);
            }
        }
    }

    public void handleMediaDeleteSession(int i, long j, long j2, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            if (i2 > 0 && i3 == 1) {
                MediaMessageDBManager.getInstance(this.mContext).delChatRecordByClassType(i2);
                BIMManager.removeSessionByClasstype(this.mContext, i2);
            } else if (i4 == 1 && i3 == 1) {
                getInstance(this.mContext).setStrangerUnread(0);
                MediaMessageDBManager.getInstance(this.mContext).delAllStrangerSession();
            } else {
                ChatSession chatRecord = MediaMessageDBManager.getInstance(this.mContext).getChatRecord(i, j);
                if (chatRecord == null) {
                    return;
                }
                if (chatRecord.getIsStranger() == 1) {
                    getInstance(this.mContext).setStrangerUnread((int) (getInstance(this.mContext).getStrangerUnread() - chatRecord.getNewMsgSum()));
                } else {
                    getInstance(this.mContext).setMediaTotalUnread((int) (this.mMediaTotalUnread - chatRecord.getNewMsgSum()));
                }
                if (i == 1) {
                    ChatMessageDBManager.getInstance(this.mContext).deleteAllMsg(new ChatObject(this.mContext, 1, j));
                } else if (i != 9) {
                    if (j2 > 0) {
                        j = j2;
                    }
                    MediaMessageDBManager.getInstance(this.mContext).deleteAllMsgs(new ChatObject(this.mContext, i, j));
                }
            }
        }
    }

    public void handleMediaSessionRead(int i, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)}) == null) {
            ChatSession mediaChatSession = MediaMessageDBManager.getInstance(this.mContext).getMediaChatSession(i, j);
            if (mediaChatSession == null) {
                getChatSessionFromServer(SessionParam.getNotifyRequestParam(this.mContext), null);
                return;
            }
            int allMsgReadWithMsgid = MediaMessageDBManager.getInstance(this.mContext).setAllMsgReadWithMsgid(i, j, j2);
            if (mediaChatSession.getIsStranger() != 1) {
                getInstance(this.mContext).setMediaTotalUnread((int) (this.mMediaTotalUnread - (mediaChatSession.getNewMsgSum() - allMsgReadWithMsgid)));
                return;
            }
            int strangerUnread = (int) (getInstance(this.mContext).getStrangerUnread() - (mediaChatSession.getNewMsgSum() - allMsgReadWithMsgid));
            getInstance(this.mContext).setStrangerUnread(strangerUnread);
            MediaMessageDBManager.getInstance(this.mContext).updateStrangerFolderUnreadNum(strangerUnread);
        }
    }

    public void setSessionRead(@NonNull SessionParam sessionParam, BIMValueCallBack<Object> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, sessionParam, bIMValueCallBack) == null) {
            if (shouldReadSendToUser(sessionParam)) {
                ChatSessionManagerImpl.getInstance(this.mContext).setSessionRead(sessionParam, bIMValueCallBack);
                return;
            }
            String addListener = ListenerManager.getInstance().addListener(bIMValueCallBack);
            Intent creatMethodIntent = Utility.creatMethodIntent(this.mContext, 207);
            creatMethodIntent.putExtra("category", sessionParam.category);
            creatMethodIntent.putExtra("contacter", sessionParam.contacterImUk);
            creatMethodIntent.putExtra(Constants.EXTRA_CLIENT_MAX_MSGID, sessionParam.clientMaxMsgid);
            creatMethodIntent.putExtra(Constants.EXTRA_BEGIN_MSGID, sessionParam.beginMsgid);
            creatMethodIntent.putExtra(Constants.EXTRA_PA_ID, sessionParam.contacterPaid);
            creatMethodIntent.putExtra("type", sessionParam.type);
            creatMethodIntent.putExtra(Constants.EXTRA_IS_STRANGER, sessionParam.isStranger);
            if (!TextUtils.isEmpty(addListener)) {
                creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
            }
            creatMethodIntent.putExtra(Constants.EXTRA_BUSINESS_TYPE, sessionParam.businessType);
            int i = sessionParam.sessionType;
            if (i >= 0) {
                creatMethodIntent.putExtra("session_type", i);
            }
            try {
                q80.e(this.mContext).d(this.mContext, creatMethodIntent);
            } catch (Exception e) {
                LogUtils.e("MediaSessionManager", "setServerBCMsgRead Exception ", e);
                if (bIMValueCallBack != null) {
                    bIMValueCallBack.onResult(1003, Constants.ERROR_MSG_SERVICE_ERROR, null);
                }
            }
        }
    }

    public void updateStrangerFolderCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            LogUtils.d("MediaSessionManager", "updateStrangerFolderCount count = " + i);
            getInstance(this.mContext).setStrangerUnread(this.mStrangerUnread + i);
            getInstance(this.mContext).setMediaTotalUnread(this.mMediaTotalUnread - i);
        }
    }
}
