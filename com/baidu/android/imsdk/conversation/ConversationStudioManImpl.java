package com.baidu.android.imsdk.conversation;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.BIMConversation;
import com.baidu.android.imsdk.BIMConversationStudio;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.android.imsdk.account.TodoAfterLogin;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.TextMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.internal.MessageFactory;
import com.baidu.android.imsdk.internal.MessageParser;
import com.baidu.android.imsdk.mcast.IMJoinCastMsg;
import com.baidu.android.imsdk.mcast.IMQuitCastMsg;
import com.baidu.android.imsdk.mcast.IMSendQuizOptMsg;
import com.baidu.android.imsdk.mcast.IMcastSetListener;
import com.baidu.android.imsdk.request.MessageExt;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.RequsetNetworkUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.tieba.h70;
import com.baidu.tieba.q70;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ConversationStudioManImpl {
    public static /* synthetic */ Interceptable $ic = null;
    public static long BEGIN_JOIN = 1;
    public static long DEFAULT = -1;
    public static final String TAG = "ConversationStudioManImpl";
    public static int mCastHeartBeatTime = 3000;
    public static Context mContext;
    public static volatile AtomicBoolean mOpenPingRequest;
    public static volatile Runnable mPingRunnable;
    public static volatile ConversationStudioManImpl sInstance;
    public static Object syncObject;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<Long> mAckMcastList;
    public long mBeginMsgCastId;
    public long mBeginReliableCastId;
    public Map<Long, FetchConversationStudio> mFetchRunnables;
    public long mJoinMsgCastId;
    public long mJoinReliableCastId;
    public long mJoinStatus;
    public long mMaxMsgId;
    public long mReliableMaxMsgId;
    public final List<Long> mReliableMcastList;
    public long mReliableMsgCount;
    public long mRelieableJoinStatus;

    /* loaded from: classes.dex */
    public class McastTodoAfterLogin implements TodoAfterLogin {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConversationStudioManImpl this$0;

        public McastTodoAfterLogin(ConversationStudioManImpl conversationStudioManImpl) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {conversationStudioManImpl};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = conversationStudioManImpl;
        }

        @Override // com.baidu.android.imsdk.account.TodoAfterLogin
        public void todo(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                ChatMessageDBManager.getInstance(ConversationStudioManImpl.mContext).deleteExpiredReliableMsgs();
                ChatMessageDBManager.getInstance(ConversationStudioManImpl.mContext).deleteStudioUsePaMsgs();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(586152703, "Lcom/baidu/android/imsdk/conversation/ConversationStudioManImpl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(586152703, "Lcom/baidu/android/imsdk/conversation/ConversationStudioManImpl;");
                return;
            }
        }
        syncObject = new Object();
        mOpenPingRequest = new AtomicBoolean(false);
        mPingRunnable = new Runnable() { // from class: com.baidu.android.imsdk.conversation.ConversationStudioManImpl.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    h70.c.removeCallbacks(ConversationStudioManImpl.mPingRunnable);
                    if (RequsetNetworkUtils.isNetworkAvailable(ConversationStudioManImpl.mContext)) {
                        BIMManager.pingRequest();
                    }
                    h70.c.postDelayed(ConversationStudioManImpl.mPingRunnable, ConversationStudioManImpl.mCastHeartBeatTime);
                }
            }
        };
    }

    public ConversationStudioManImpl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mMaxMsgId = 0L;
        this.mReliableMsgCount = 0L;
        this.mReliableMaxMsgId = 0L;
        long j = DEFAULT;
        this.mRelieableJoinStatus = j;
        this.mJoinStatus = j;
        this.mReliableMcastList = new ArrayList();
        this.mAckMcastList = new ArrayList();
        this.mFetchRunnables = new ConcurrentHashMap();
        initStudio();
    }

    private void initStudio() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            clear();
            Class<?>[] clsArr = {IMJoinCastMsg.class, IMQuitCastMsg.class, IMSendQuizOptMsg.class};
            int[] iArr = {201, 202, 210};
            for (int i = 0; i < 3; i++) {
                MessageFactory.getInstance().addType(iArr[i], clsArr[i]);
            }
            AccountManager.registerToDoAfterLoginListener(mContext, new McastTodoAfterLogin(this));
        }
    }

    public void cancelMcastQuickHeartBeat() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && mOpenPingRequest.get()) {
            mOpenPingRequest.set(false);
            pingRequest(false, 0L);
        }
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            clearReliableCastList();
            clearFetchRunnable();
            Handler handler = h70.c;
            if (handler != null) {
                handler.removeCallbacks(mPingRunnable);
            }
        }
    }

    public void clearAckCastList() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            synchronized (this.mAckMcastList) {
                this.mAckMcastList.clear();
            }
        }
    }

    public void clearFetchRunnable() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.mFetchRunnables.clear();
        }
    }

    public void clearReliableCastList() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            LogUtils.d(TAG, "clearReliableCastList delete List");
            synchronized (this.mReliableMcastList) {
                this.mReliableMcastList.clear();
            }
        }
    }

    public boolean getConnectState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (q70.b() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public long getJoinedCastId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.mJoinReliableCastId;
        }
        return invokeV.longValue;
    }

    public void setMcastQuickHeartBeat() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && !mOpenPingRequest.get()) {
            mOpenPingRequest.set(true);
            pingRequest(true, mCastHeartBeatTime);
        }
    }

    public static ConversationStudioManImpl getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (sInstance == null) {
                synchronized (ConversationStudioManImpl.class) {
                    if (sInstance == null) {
                        mContext = context.getApplicationContext();
                        sInstance = new ConversationStudioManImpl();
                    }
                }
            }
            return sInstance;
        }
        return (ConversationStudioManImpl) invokeL.objValue;
    }

    public void addReliableCastId(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) != null) || j <= 0) {
            return;
        }
        synchronized (this.mReliableMcastList) {
            if (!this.mReliableMcastList.contains(Long.valueOf(j))) {
                this.mReliableMcastList.add(Long.valueOf(j));
            }
        }
    }

    private void toAck(JSONArray jSONArray, long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, this, new Object[]{jSONArray, Long.valueOf(j), str}) == null) {
            TaskManager.getInstance(mContext).submitForNetWork(new Runnable(this, jSONArray, j, str) { // from class: com.baidu.android.imsdk.conversation.ConversationStudioManImpl.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ConversationStudioManImpl this$0;
                public final /* synthetic */ String val$eventList;
                public final /* synthetic */ long val$notifyId;
                public final /* synthetic */ JSONArray val$otherarray;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, jSONArray, Long.valueOf(j), str};
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
                    this.val$otherarray = jSONArray;
                    this.val$notifyId = j;
                    this.val$eventList = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        MessageParser.handleAckArray(ConversationStudioManImpl.mContext, this.val$otherarray, -1L, this.val$notifyId, this.val$eventList);
                    }
                }
            });
        }
    }

    public void addAckCastId(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeJ(1048576, this, j) != null) || j <= 0) {
            return;
        }
        synchronized (this.mAckMcastList) {
            if (!this.mAckMcastList.contains(Long.valueOf(j))) {
                this.mAckMcastList.add(Long.valueOf(j));
            }
        }
    }

    public long getMaxReliableMsgId(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048591, this, j)) == null) {
            if (!isReliable(j)) {
                return j;
            }
            return this.mReliableMaxMsgId;
        }
        return invokeJ.longValue;
    }

    public long getReliableMsgCount(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048592, this, j)) == null) {
            if (!isReliable(j)) {
                return j;
            }
            return this.mReliableMsgCount;
        }
        return invokeJ.longValue;
    }

    public boolean isAck(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048594, this, j)) == null) {
            if (j <= 0) {
                return false;
            }
            return this.mAckMcastList.contains(Long.valueOf(j));
        }
        return invokeJ.booleanValue;
    }

    public boolean isReliable(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048595, this, j)) == null) {
            if (j <= 0) {
                return false;
            }
            return this.mReliableMcastList.contains(Long.valueOf(j));
        }
        return invokeJ.booleanValue;
    }

    public void removeAckCastId(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeJ(1048600, this, j) != null) || j <= 0) {
            return;
        }
        synchronized (this.mAckMcastList) {
            this.mAckMcastList.remove(Long.valueOf(j));
        }
    }

    public void removeFetchCastId(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeJ(1048601, this, j) != null) || j <= 0) {
            return;
        }
        this.mFetchRunnables.remove(Long.valueOf(j));
    }

    public void removeReliableCastId(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeJ(1048602, this, j) != null) || j <= 0) {
            return;
        }
        synchronized (this.mReliableMcastList) {
            this.mReliableMcastList.remove(Long.valueOf(j));
        }
    }

    public void addFetchCastId(long j, FetchConversationStudio fetchConversationStudio) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j, fetchConversationStudio) == null) && j > 0 && !this.mFetchRunnables.containsKey(Long.valueOf(j))) {
            this.mFetchRunnables.put(Long.valueOf(j), fetchConversationStudio);
        }
    }

    public void beginWithCompletion(long j, boolean z, IMcastSetListener iMcastSetListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z), iMcastSetListener}) == null) {
            if (z) {
                addReliableCastId(j);
                this.mBeginReliableCastId = j;
                this.mReliableMaxMsgId = 0L;
                this.mReliableMsgCount = 0L;
                this.mRelieableJoinStatus = BEGIN_JOIN;
            } else {
                this.mBeginMsgCastId = j;
                this.mJoinStatus = BEGIN_JOIN;
            }
            this.mJoinReliableCastId = 0L;
            this.mJoinMsgCastId = 0L;
            String addListener = ListenerManager.getInstance().addListener(iMcastSetListener);
            if (LoginManager.getInstance(mContext).isIMLogined()) {
                Intent createMcastMethodIntent = Utility.createMcastMethodIntent(mContext, 201);
                createMcastMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
                createMcastMethodIntent.putExtra("mcast_id", j);
                createMcastMethodIntent.putExtra(Constants.EXTRA_OPT_EXT, z);
                try {
                    h70.e(mContext).d(mContext, createMcastMethodIntent);
                    return;
                } catch (Exception e) {
                    ListenerManager.getInstance().removeListener(addListener);
                    onJoinCastResult(addListener, 1003, Constants.ERROR_MSG_SERVICE_ERROR, j);
                    LogUtils.e(TAG, "Exception ", e);
                    return;
                }
            }
            LoginManager.getInstance(mContext).triggleLogoutListener(4001, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            onJoinCastResult(addListener, 1001, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, j);
        }
    }

    public void deliverCastReliableMsg(long j, @NonNull ArrayList<ChatMsg> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048585, this, j, arrayList) == null) {
            ArrayList arrayList2 = new ArrayList();
            JSONArray jSONArray = new JSONArray();
            try {
                Iterator<ChatMsg> it = arrayList.iterator();
                while (it.hasNext()) {
                    ChatMsg next = it.next();
                    if (j == ((TextMsg) next).getCastId()) {
                        jSONArray.put(new JSONObject(next.getMsgContent()));
                        arrayList2.add(Long.valueOf(next.getMsgId()));
                    }
                }
            } catch (JSONException e) {
                LogUtils.e(TAG, "Exception ", e);
            }
            if (jSONArray.length() <= 0) {
                return;
            }
            this.mReliableMsgCount += arrayList2.size();
            LogUtils.d(TAG, "reliableMsgCount :" + this.mReliableMsgCount + ", DeliverCastReliableMsg :" + arrayList2.toString());
            MessageExt.getInstance().setLastCallbackMsgId((Long) Collections.max(arrayList2));
            ChatMsgManagerImpl.getInstance(mContext).deliverReliableMcastMessage(j + "", jSONArray, arrayList2);
        }
    }

    public void endWithCompletion(long j, IMcastSetListener iMcastSetListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048586, this, j, iMcastSetListener) == null) {
            String addListener = ListenerManager.getInstance().addListener(iMcastSetListener);
            if (isReliable(j)) {
                this.mBeginReliableCastId = 0L;
                this.mReliableMsgCount = 0L;
                this.mReliableMaxMsgId = 0L;
            } else {
                this.mBeginMsgCastId = 0L;
            }
            if (AccountManager.isLogin(mContext)) {
                Intent createMcastMethodIntent = Utility.createMcastMethodIntent(mContext, 202);
                createMcastMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
                createMcastMethodIntent.putExtra("mcast_id", j);
                try {
                    h70.e(mContext).d(mContext, createMcastMethodIntent);
                    return;
                } catch (Exception e) {
                    ListenerManager.getInstance().removeListener(addListener);
                    onQuitCastResult(addListener, 1003, Constants.ERROR_MSG_SERVICE_ERROR, j);
                    LogUtils.e(TAG, "Exception ", e);
                    return;
                }
            }
            onQuitCastResult(addListener, 1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, j);
        }
    }

    public String getAllCastIdList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("begin:");
            sb.append(this.mBeginMsgCastId);
            sb.append(",");
            sb.append(this.mBeginReliableCastId);
            sb.append(",joined:");
            sb.append(this.mJoinMsgCastId);
            sb.append(",");
            sb.append(this.mJoinReliableCastId);
            sb.append(",JoinStatus:");
            sb.append(this.mJoinStatus);
            sb.append(",reliableJoinStatus:");
            sb.append(this.mRelieableJoinStatus);
            sb.append(",reliableMaxMsgId:");
            sb.append(Utility.getReliableMaxMsgId(mContext, this.mJoinReliableCastId));
            sb.append(",imLoginStatus:");
            sb.append(LoginManager.getInstance(mContext).isIMLogined());
            sb.append(",lcpStatus:");
            sb.append(getConnectState());
            sb.append(",socketStatus:");
            sb.append(getConnectState());
            LogUtils.d(TAG, "getAllCastIdList:" + sb.toString());
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public BIMConversation getConversation(BIMManager.CATEGORY category, String str, boolean z, String str2, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{category, str, Boolean.valueOf(z), str2, Integer.valueOf(i)})) == null) {
            if (TextUtils.isEmpty(str)) {
                LogUtils.e(TAG, "id should not be empty");
                return null;
            }
            synchronized (syncObject) {
                try {
                    try {
                        long longValue = Long.valueOf(str).longValue();
                        int value = category.getValue();
                        if (BIMManager.CATEGORY.STUDIO != category) {
                            return null;
                        }
                        return new BIMConversationStudio(mContext, category, str, z, new ChatSession(value, longValue, longValue, null), str2, i);
                    } catch (Exception e) {
                        LogUtils.e(TAG, "Id is not long value", e);
                        return null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return (BIMConversation) invokeCommon.objValue;
    }

    public void onSendQuizOptsResult(String str, int i, String str2, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{str, Integer.valueOf(i), str2, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            LogUtils.d(TAG, "sendQuizOpts----errorCode: " + i + " msg: " + str2);
            IMcastSetListener iMcastSetListener = (IMcastSetListener) ListenerManager.getInstance().removeListener(str);
            if (iMcastSetListener != null) {
                iMcastSetListener.onResult(i, j, j2);
            } else {
                LogUtils.d(TAG, "IMcastSetistener is null");
            }
        }
    }

    public void handleMessage(JSONObject jSONObject, String str) {
        JSONArray jSONArray;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, jSONObject, str) == null) {
            JSONArray jSONArray2 = new JSONArray();
            long j2 = 0;
            JSONArray jSONArray3 = null;
            if (jSONObject != null) {
                try {
                    j2 = jSONObject.optLong("mcast_id");
                    jSONArray3 = jSONObject.getJSONArray(NotificationCompat.CarExtender.KEY_MESSAGES);
                } catch (JSONException unused) {
                    LogUtils.e(TAG, "ConversationStudioManImpl handleMessage parse json error");
                    return;
                }
            }
            boolean isReliable = isReliable(j2);
            int i = 0;
            if (isReliable && jSONArray3 != null && jSONArray3.length() > 0) {
                this.mMaxMsgId = ((Long) jSONArray3.getJSONObject(0).get("msgid")).longValue();
            }
            MessageExt.getInstance().setCastId(Long.valueOf(j2));
            MessageExt.getInstance().setLocalTimestamp(Long.valueOf(System.currentTimeMillis()));
            ArrayList arrayList = new ArrayList();
            if (jSONArray3 != null) {
                while (i < jSONArray3.length()) {
                    JSONObject jSONObject2 = jSONArray3.getJSONObject(i);
                    if (jSONObject2.optLong("origin_id") != Utility.getTriggerId(mContext)) {
                        jSONArray2.put(jSONObject2);
                    } else {
                        LogUtils.d(TAG, "filter self message");
                    }
                    if (isReliable) {
                        long longValue = ((Long) jSONObject2.get("msgid")).longValue();
                        jSONArray = jSONArray2;
                        j = j2;
                        if (this.mMaxMsgId < longValue) {
                            this.mMaxMsgId = longValue;
                        }
                    } else {
                        jSONArray = jSONArray2;
                        j = j2;
                    }
                    arrayList.add(Long.valueOf(((Long) jSONObject2.get("msgid")).longValue()));
                    i++;
                    jSONArray2 = jSONArray;
                    j2 = j;
                }
            }
            JSONArray jSONArray4 = jSONArray2;
            long j3 = j2;
            long j4 = -1;
            if (jSONObject != null && jSONObject.has(Constants.EXTRA_NOTIFY_ID)) {
                try {
                    j4 = jSONObject.getLong(Constants.EXTRA_NOTIFY_ID);
                } catch (JSONException e) {
                    LogUtils.i(TAG, "notifyId JSONException:" + e.getMessage());
                }
            }
            if (isReliable) {
                LogUtils.e(TAG, "handleMessage push reliable castId :" + j3 + ", max :" + this.mMaxMsgId);
                FetchConversationStudio fetchConversationStudio = this.mFetchRunnables.get(Long.valueOf(j3));
                if (fetchConversationStudio == null) {
                    fetchConversationStudio = new FetchConversationStudio(mContext, j3);
                    addFetchCastId(j3, fetchConversationStudio);
                }
                fetchConversationStudio.toFetch(this.mMaxMsgId);
            } else if (jSONArray4.length() == 0) {
            } else {
                MessageExt.getInstance().setLastCallbackMsgId((Long) Collections.max(arrayList));
                ChatMsgManagerImpl chatMsgManagerImpl = ChatMsgManagerImpl.getInstance(mContext);
                chatMsgManagerImpl.deliverMcastMessage(j3 + "", jSONArray4);
                if (isAck(j3)) {
                    LogUtils.d(TAG, "toAck");
                    toAck(jSONArray4, j4, str);
                }
            }
        }
    }

    public void onJoinCastResult(String str, int i, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{str, Integer.valueOf(i), str2, Long.valueOf(j)}) == null) {
            IMcastSetListener iMcastSetListener = (IMcastSetListener) ListenerManager.getInstance().removeListener(str);
            LogUtils.d(TAG, "onJoinCastResult----errorCode: " + i + " msg: " + str2 + ", castId :" + j + ", listener :" + iMcastSetListener);
            if (iMcastSetListener != null) {
                mOpenPingRequest.set(false);
                setMcastQuickHeartBeat();
                iMcastSetListener.onResult(i, j, -1L);
                if (i == 0) {
                    if (isReliable(j)) {
                        this.mJoinReliableCastId = j;
                        this.mRelieableJoinStatus = i;
                        FetchConversationStudio fetchConversationStudio = this.mFetchRunnables.get(Long.valueOf(j));
                        if (fetchConversationStudio == null) {
                            fetchConversationStudio = new FetchConversationStudio(mContext, j);
                            addFetchCastId(j, fetchConversationStudio);
                        }
                        fetchConversationStudio.fetchCastMsgByMsgId();
                        return;
                    }
                    this.mJoinMsgCastId = j;
                    this.mJoinStatus = i;
                    return;
                } else if (isReliable(j)) {
                    this.mJoinReliableCastId = -1000L;
                    this.mRelieableJoinStatus = i;
                    return;
                } else {
                    this.mJoinMsgCastId = -1000L;
                    this.mJoinStatus = i;
                    return;
                }
            }
            LogUtils.d(TAG, "IMcastSetistener is null");
        }
    }

    public void onQuitCastResult(String str, int i, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{str, Integer.valueOf(i), str2, Long.valueOf(j)}) == null) {
            LogUtils.d(TAG, "onQuitCastResult----errorCode: " + i + " msg: " + str2);
            IMcastSetListener iMcastSetListener = (IMcastSetListener) ListenerManager.getInstance().removeListener(str);
            if (iMcastSetListener != null) {
                iMcastSetListener.onResult(i, j, -1L);
            } else {
                LogUtils.d(TAG, "IMcastSetistener is null");
            }
            cancelMcastQuickHeartBeat();
        }
    }

    public void pingRequest(boolean z, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) {
            if (z) {
                h70.c.removeCallbacks(mPingRunnable);
                h70.c.postDelayed(mPingRunnable, j);
                return;
            }
            h70.c.removeCallbacks(mPingRunnable);
        }
    }

    public void sendQuizOpts(long j, long j2, int i, String str, IMcastSetListener iMcastSetListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), str, iMcastSetListener}) == null) {
            String addListener = ListenerManager.getInstance().addListener(iMcastSetListener);
            if (AccountManager.isLogin(mContext)) {
                Intent createMcastMethodIntent = Utility.createMcastMethodIntent(mContext, 210);
                createMcastMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
                createMcastMethodIntent.putExtra("mcast_id", j2);
                createMcastMethodIntent.putExtra("room_id", j);
                createMcastMethodIntent.putExtra(Constants.EXTRA_OPT_CODE, i);
                createMcastMethodIntent.putExtra(Constants.EXTRA_OPT_EXT, str);
                try {
                    h70.e(mContext).d(mContext, createMcastMethodIntent);
                    return;
                } catch (Exception e) {
                    ListenerManager.getInstance().removeListener(addListener);
                    onSendQuizOptsResult(addListener, 1003, Constants.ERROR_MSG_SERVICE_ERROR, j2, j);
                    LogUtils.e(TAG, "Exception ", e);
                    return;
                }
            }
            onSendQuizOptsResult(addListener, 1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, j2, j);
        }
    }
}
