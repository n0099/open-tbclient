package com.baidu.android.imsdk.conversation;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.BIMConversation;
import com.baidu.android.imsdk.BIMConversationStudio;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.IMReceiver;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.android.imsdk.account.TodoAfterLogin;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.TextMsg;
import com.baidu.android.imsdk.chatmessage.request.IMAckRequest;
import com.baidu.android.imsdk.chatmessage.request.Type;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.Heartbeat;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.android.imsdk.internal.IMSDK;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.internal.MessageFactory;
import com.baidu.android.imsdk.internal.MessageParser;
import com.baidu.android.imsdk.mcast.IMJoinCastMsg;
import com.baidu.android.imsdk.mcast.IMQuitCastMsg;
import com.baidu.android.imsdk.mcast.IMSendQuizOptMsg;
import com.baidu.android.imsdk.mcast.IMcastSetListener;
import com.baidu.android.imsdk.mcast.McastConfig;
import com.baidu.android.imsdk.request.MessageExt;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.Utils;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.RequsetNetworkUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.j60;
import com.repackage.t60;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ConversationStudioManImpl {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ACK_INTERVAL_TIME = 3000;
    public static final int ACK_MAX_COUNT = 1;
    public static long BEGIN_JOIN = 1;
    public static long DEFAULT = -1;
    public static final int RELIABLE_MAX_COUNT = 2;
    public static final int SHORT_ACK_COUNT = 15;
    public static final int SHORT_ACK_INTERVAL_TIME = 10000;
    public static final String TAG = "ConversationStudioManImpl";
    public static int mCastHeartBeatTime = 3000;
    public static Context mContext;
    public static BroadcastReceiver mNetChangedReceiver;
    public static volatile AtomicBoolean mOpenPingRequest;
    public static volatile Runnable mPingRunnable;
    public static Random mRandom;
    public static McastHeartbeat mcastHeartbeat;
    public static volatile ConversationStudioManImpl sInstance;
    public static Object syncObject;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isRegisterNetReceiver;
    public final ArrayList<ChatMsg> mAckChatMsgList;
    public final List<Long> mAckMcastList;
    public Runnable mAckRunnable;
    public AtomicBoolean mAcking;
    public long mBeginMsgCastId;
    public long mBeginReliableCastId;
    public Map<Long, FetchConversationStudio> mFetchRunnables;
    public Runnable mHttpAckRunnable;
    public long mJoinMsgCastId;
    public long mJoinReliableCastId;
    public long mJoinStatus;
    public long mMaxMsgId;
    public long mReliableMaxMsgId;
    public final List<Long> mReliableMcastList;
    public long mReliableMsgCount;
    public long mRelieableJoinStatus;

    /* loaded from: classes.dex */
    public interface HeartbeatOperation {
        void cancelHearbeat();

        void startHeartbeat();
    }

    /* loaded from: classes.dex */
    public class McastHeartbeat implements HeartbeatOperation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Runnable startHeartBeatTask;
        public final /* synthetic */ ConversationStudioManImpl this$0;

        public McastHeartbeat(ConversationStudioManImpl conversationStudioManImpl) {
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
            this.startHeartBeatTask = new Runnable(this) { // from class: com.baidu.android.imsdk.conversation.ConversationStudioManImpl.McastHeartbeat.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ McastHeartbeat this$1;

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
                    this.this$1 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (j60.e) {
                                return;
                            }
                            Intent intent = new Intent(ConversationStudioManImpl.mContext, j60.class);
                            intent.putExtra(Constants.EXTRA_ALARM_ALERT, "OK");
                            intent.setPackage(ConversationStudioManImpl.mContext.getPackageName());
                            j60.g(ConversationStudioManImpl.mContext).f(ConversationStudioManImpl.mContext, intent);
                        } catch (Exception e) {
                            if (e instanceof SecurityException) {
                                LogUtils.e(ConversationStudioManImpl.TAG, "box SecurityException!!", e);
                            } else {
                                LogUtils.e(ConversationStudioManImpl.TAG, "box heartbeat error!!", e);
                            }
                        }
                    }
                }
            };
        }

        @Override // com.baidu.android.imsdk.conversation.ConversationStudioManImpl.HeartbeatOperation
        public void cancelHearbeat() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    j60.c.removeCallbacks(this.startHeartBeatTask);
                } catch (Exception e) {
                    LogUtils.e(ConversationStudioManImpl.TAG, e.getMessage());
                }
            }
        }

        @Override // com.baidu.android.imsdk.conversation.ConversationStudioManImpl.HeartbeatOperation
        public void startHeartbeat() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                try {
                    j60.c.removeCallbacks(this.startHeartBeatTask);
                    j60.c.postDelayed(this.startHeartBeatTask, ConversationStudioManImpl.mCastHeartBeatTime);
                } catch (Exception e) {
                    LogUtils.e(ConversationStudioManImpl.TAG, e.getMessage());
                }
            }
        }
    }

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
        mPingRunnable = new Runnable() { // from class: com.baidu.android.imsdk.conversation.ConversationStudioManImpl.4
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
                    j60.c.removeCallbacks(ConversationStudioManImpl.mPingRunnable);
                    LogUtils.d(ConversationStudioManImpl.TAG, "pingRequest customPingIntervalMs :" + ConversationStudioManImpl.mCastHeartBeatTime);
                    if (RequsetNetworkUtils.isNetworkAvailable(ConversationStudioManImpl.mContext)) {
                        BIMManager.pingRequest();
                    }
                    j60.c.postDelayed(ConversationStudioManImpl.mPingRunnable, ConversationStudioManImpl.mCastHeartBeatTime);
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
        this.isRegisterNetReceiver = false;
        this.mMaxMsgId = 0L;
        this.mReliableMsgCount = 0L;
        this.mReliableMaxMsgId = 0L;
        long j = DEFAULT;
        this.mRelieableJoinStatus = j;
        this.mJoinStatus = j;
        this.mReliableMcastList = new ArrayList();
        this.mAckMcastList = new ArrayList();
        this.mAckChatMsgList = new ArrayList<>();
        this.mAcking = new AtomicBoolean(false);
        this.mFetchRunnables = new ConcurrentHashMap();
        this.mAckRunnable = new Runnable(this) { // from class: com.baidu.android.imsdk.conversation.ConversationStudioManImpl.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ConversationStudioManImpl this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
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

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.this$0.mAckChatMsgList.size() > 0 && this.this$0.getConnectState()) {
                        synchronized (this.this$0.mAckChatMsgList) {
                            try {
                                LogUtils.d(ConversationStudioManImpl.TAG, "mAckRunnable ~~~");
                                LogUtils.e(ConversationStudioManImpl.TAG, "ack mAckChatMsgList.size :" + this.this$0.mAckChatMsgList.size());
                                ArrayList arrayList = new ArrayList(this.this$0.mAckChatMsgList);
                                j60.c.removeCallbacks(this.this$0.mAckRunnable);
                                MessageParser.handleAck(ConversationStudioManImpl.mContext, arrayList, false);
                                this.this$0.mAckChatMsgList.clear();
                                j60.c.postDelayed(this.this$0.mAckRunnable, 3000L);
                            } catch (Exception e) {
                                LogUtils.e(ConversationStudioManImpl.TAG, "ackRunnable Exception :", e);
                                j60.c.removeCallbacks(this.this$0.mAckRunnable);
                                this.this$0.mAckChatMsgList.clear();
                                j60.c.postDelayed(this.this$0.mAckRunnable, 3000L);
                            }
                        }
                        return;
                    }
                    LogUtils.d(ConversationStudioManImpl.TAG, "mAcking reset false");
                    this.this$0.mAcking.set(false);
                }
            }
        };
        this.mHttpAckRunnable = new Runnable(this) { // from class: com.baidu.android.imsdk.conversation.ConversationStudioManImpl.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ConversationStudioManImpl this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
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

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.this$0.mAckChatMsgList.size() <= 0 || this.this$0.getConnectState() || !RequsetNetworkUtils.isNetworkAvailable(ConversationStudioManImpl.mContext)) {
                        j60.c.removeCallbacks(this.this$0.mHttpAckRunnable);
                        j60.c.postDelayed(this.this$0.mHttpAckRunnable, 10000L);
                        return;
                    }
                    synchronized (this.this$0.mAckChatMsgList) {
                        LogUtils.d(ConversationStudioManImpl.TAG, "mHttpAckRunnable");
                        LogUtils.e(ConversationStudioManImpl.TAG, "ack mAckChatMsgList.size :" + this.this$0.mAckChatMsgList.size());
                        j60.c.removeCallbacks(this.this$0.mHttpAckRunnable);
                        for (List list : Utils.splitList(new ArrayList(this.this$0.mAckChatMsgList), 15)) {
                            ArrayList arrayList = (ArrayList) list;
                            long contacter = ((ChatMsg) arrayList.get(0)).getContacter();
                            int category = ((ChatMsg) arrayList.get(0)).getCategory();
                            LogUtils.d(ConversationStudioManImpl.TAG, "contacter:" + contacter + ",category:" + category);
                            StringBuilder sb = new StringBuilder();
                            sb.append("onePage.size:");
                            sb.append(arrayList.size());
                            LogUtils.d(ConversationStudioManImpl.TAG, sb.toString());
                            TaskManager.getInstance(ConversationStudioManImpl.mContext).submitForNetWork(new Runnable(this, contacter, category, arrayList) { // from class: com.baidu.android.imsdk.conversation.ConversationStudioManImpl.3.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass3 this$1;
                                public final /* synthetic */ int val$category;
                                public final /* synthetic */ long val$contacter;
                                public final /* synthetic */ ArrayList val$onePage;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                                        newInitContext2.initArgs = r2;
                                        Object[] objArr = {this, Long.valueOf(contacter), Integer.valueOf(category), arrayList};
                                        interceptable3.invokeUnInit(65536, newInitContext2);
                                        int i3 = newInitContext2.flag;
                                        if ((i3 & 1) != 0) {
                                            int i4 = i3 & 2;
                                            newInitContext2.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext2);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                    this.val$contacter = contacter;
                                    this.val$category = category;
                                    this.val$onePage = arrayList;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        IMAckRequest iMAckRequest = new IMAckRequest(ConversationStudioManImpl.mContext, "", Utility.getUK(ConversationStudioManImpl.mContext), this.val$contacter, this.val$category, 0, 0L, 0L, false, this.val$onePage);
                                        HttpHelper.executor(ConversationStudioManImpl.mContext, iMAckRequest, iMAckRequest);
                                    }
                                }
                            });
                        }
                        this.this$0.mAckChatMsgList.clear();
                        j60.c.postDelayed(this.this$0.mHttpAckRunnable, 10000L);
                    }
                }
            }
        };
        initStudio();
        j60.c.removeCallbacks(this.mHttpAckRunnable);
        j60.c.postDelayed(this.mHttpAckRunnable, 10000L);
    }

    public static ConversationStudioManImpl getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
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

    private void initStudio() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            clear();
            mRandom = new Random();
            Class<?>[] clsArr = {IMJoinCastMsg.class, IMQuitCastMsg.class, IMSendQuizOptMsg.class};
            int[] iArr = {201, 202, 210};
            for (int i = 0; i < 3; i++) {
                MessageFactory.getInstance().addType(iArr[i], clsArr[i]);
            }
            AccountManager.registerToDoAfterLoginListener(mContext, new McastTodoAfterLogin(this));
        }
    }

    private void registerNetChangedReceiver() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65546, this) == null) || j60.e) {
            return;
        }
        try {
            if (mNetChangedReceiver == null && mContext != null) {
                mNetChangedReceiver = new IMReceiver();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                intentFilter.addAction(McastConfig.ACTION_NETWORK_STATE_CHANGED);
                intentFilter.addAction(McastConfig.ACTION_WIFI_STATE_CHANGED);
                mContext.registerReceiver(mNetChangedReceiver, intentFilter);
                this.isRegisterNetReceiver = true;
                LogUtils.d(TAG, " registerNetChangedReceiver ok !");
            }
        } catch (Exception e) {
            LogUtils.e(TAG, "Exception ", e);
        }
    }

    public static void resetHeartBeat(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65547, null, i) == null) || j60.e) {
            return;
        }
        Heartbeat.ALARM_TIMEOUT = i;
        LogUtils.d(TAG, "reset heartbeat time to = " + Heartbeat.ALARM_TIMEOUT);
        IMSDK.getInstance(mContext).mHeartbeatOperator.cancelHearbeat();
        IMSDK.getInstance(mContext).mHeartbeatOperator.startHeartbeat();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Long] */
    private void toAck(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, jSONArray) == null) {
            Type type = new Type();
            type.t = 0L;
            ArrayList<ChatMsg> parserMessage = MessageParser.parserMessage(mContext, jSONArray, type, false, false);
            synchronized (this.mAckChatMsgList) {
                Iterator<ChatMsg> it = parserMessage.iterator();
                while (it.hasNext()) {
                    this.mAckChatMsgList.add(it.next());
                }
            }
            LogUtils.d(TAG, "mAckChatMsgList size:" + this.mAckChatMsgList.size());
            if (this.mAcking.get()) {
                return;
            }
            LogUtils.d(TAG, "begin ack");
            this.mAcking.set(true);
            j60.c.removeCallbacks(this.mAckRunnable);
            j60.c.postDelayed(this.mAckRunnable, 3000L);
        }
    }

    private void unRegisterNetChangedReceiver() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65549, this) == null) || j60.e) {
            return;
        }
        try {
            if (this.isRegisterNetReceiver && mContext != null) {
                mContext.unregisterReceiver(mNetChangedReceiver);
                this.isRegisterNetReceiver = false;
                LogUtils.d(TAG, " unRegisterNetChangedReceiver ok !");
            }
        } catch (Exception e) {
            LogUtils.e(TAG, "Exception ", e);
        }
    }

    public void addAckCastId(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048576, this, j) == null) || j <= 0) {
            return;
        }
        synchronized (this.mAckMcastList) {
            if (!this.mAckMcastList.contains(Long.valueOf(j))) {
                this.mAckMcastList.add(Long.valueOf(j));
            }
        }
    }

    public void addFetchCastId(long j, FetchConversationStudio fetchConversationStudio) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j, fetchConversationStudio) == null) || j <= 0 || this.mFetchRunnables.containsKey(Long.valueOf(j))) {
            return;
        }
        this.mFetchRunnables.put(Long.valueOf(j), fetchConversationStudio);
    }

    public void addReliableCastId(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) || j <= 0) {
            return;
        }
        synchronized (this.mReliableMcastList) {
            if (!this.mReliableMcastList.contains(Long.valueOf(j))) {
                this.mReliableMcastList.add(Long.valueOf(j));
            }
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
                    j60.g(mContext).f(mContext, createMcastMethodIntent);
                    IMTrack.RequestBuilder requestBuilder = new IMTrack.RequestBuilder(mContext);
                    requestBuilder.requestId("" + j).requestTime(System.currentTimeMillis()).ext("service enqueue join").aliasId(501112L).build();
                    return;
                } catch (Exception e) {
                    ListenerManager.getInstance().removeListener(addListener);
                    onJoinCastResult(addListener, 1003, Constants.ERROR_MSG_SERVICE_ERROR, j);
                    LogUtils.e(TAG, "Exception ", e);
                    return;
                }
            }
            if (LoginManager.getInstance(mContext).getCurrentState() == LoginManager.LoginState.NOT_LOGIN || !getConnectState()) {
                TaskManager.getInstance(mContext).submitForNetWork(new Runnable(this) { // from class: com.baidu.android.imsdk.conversation.ConversationStudioManImpl.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ConversationStudioManImpl this$0;

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

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            LoginManager.getInstance(ConversationStudioManImpl.mContext).triggleLogoutListener(4001, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
                        }
                    }
                });
            }
            onJoinCastResult(addListener, 1001, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, j);
        }
    }

    public void cancelMcastQuickHeartBeat() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (j60.e && mOpenPingRequest.get()) {
                mOpenPingRequest.set(false);
                pingRequest(false, 0L);
                return;
            }
            McastHeartbeat mcastHeartbeat2 = mcastHeartbeat;
            if (mcastHeartbeat2 != null) {
                mcastHeartbeat2.cancelHearbeat();
                mcastHeartbeat = null;
                LogUtils.d(TAG, "mcast quick heart beat canceled! ");
            }
            resetHeartBeat(60000);
        }
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            clearReliableCastList();
            clearFetchRunnable();
            Handler handler = j60.c;
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
                    j60.g(mContext).f(mContext, createMcastMethodIntent);
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

    public boolean getConnectState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (j60.e) {
                return t60.b() == 0;
            }
            return IMConnection.getInstance(mContext).isConnected();
        }
        return invokeV.booleanValue;
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
                        if (BIMManager.CATEGORY.STUDIO == category) {
                            return new BIMConversationStudio(mContext, category, str, z, new ChatSession(value, longValue, longValue, null), str2, i);
                        }
                        return null;
                    } catch (Exception e) {
                        LogUtils.e(TAG, "Id is not long value", e);
                        new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e)).build();
                        return null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return (BIMConversation) invokeCommon.objValue;
    }

    public long getJoinedCastId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mJoinReliableCastId : invokeV.longValue;
    }

    public long getMaxReliableMsgId(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048591, this, j)) == null) ? !isReliable(j) ? j : this.mReliableMaxMsgId : invokeJ.longValue;
    }

    public long getReliableMsgCount(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048592, this, j)) == null) ? !isReliable(j) ? j : this.mReliableMsgCount : invokeJ.longValue;
    }

    public void handleMessage(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, jSONObject) == null) {
            JSONArray jSONArray = new JSONArray();
            long j = 0;
            JSONArray jSONArray2 = null;
            if (jSONObject != null) {
                try {
                    j = jSONObject.optLong("mcast_id");
                    jSONArray2 = jSONObject.getJSONArray(NotificationCompat.CarExtender.KEY_MESSAGES);
                } catch (JSONException unused) {
                    LogUtils.e(TAG, "McastmanagerImpl handleMessage parse json error");
                    return;
                }
            }
            boolean isReliable = isReliable(j);
            if (isReliable && jSONArray2 != null && jSONArray2.length() > 0) {
                this.mMaxMsgId = ((Long) jSONArray2.getJSONObject(0).get("msgid")).longValue();
            }
            MessageExt.getInstance().setCastId(Long.valueOf(j));
            MessageExt.getInstance().setLocalTimestamp(Long.valueOf(System.currentTimeMillis()));
            ArrayList arrayList = new ArrayList();
            if (jSONArray2 != null) {
                for (int i = 0; i < jSONArray2.length(); i++) {
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i);
                    if (jSONObject2.optLong("origin_id") != Utility.getTriggerId(mContext)) {
                        jSONArray.put(jSONObject2);
                    } else {
                        LogUtils.d(TAG, "filter self message");
                    }
                    if (isReliable) {
                        long longValue = ((Long) jSONObject2.get("msgid")).longValue();
                        if (this.mMaxMsgId < longValue) {
                            this.mMaxMsgId = longValue;
                        }
                    }
                    arrayList.add(Long.valueOf(((Long) jSONObject2.get("msgid")).longValue()));
                }
            }
            if (isReliable) {
                LogUtils.e(TAG, "handleMessage push reliable castId :" + j + ", max :" + this.mMaxMsgId);
                FetchConversationStudio fetchConversationStudio = this.mFetchRunnables.get(Long.valueOf(j));
                if (fetchConversationStudio == null) {
                    fetchConversationStudio = new FetchConversationStudio(mContext, j);
                    addFetchCastId(j, fetchConversationStudio);
                }
                fetchConversationStudio.toFetch(this.mMaxMsgId);
            } else if (jSONArray.length() != 0) {
                MessageExt.getInstance().setLastCallbackMsgId((Long) Collections.max(arrayList));
                ChatMsgManagerImpl chatMsgManagerImpl = ChatMsgManagerImpl.getInstance(mContext);
                chatMsgManagerImpl.deliverMcastMessage(j + "", jSONArray);
                if (isAck(j)) {
                    LogUtils.d(TAG, "toAck");
                    toAck(jSONArray);
                }
            }
        }
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

    public void onJoinCastResult(String str, int i, String str2, long j) {
        String str3;
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
                    } else {
                        this.mJoinMsgCastId = j;
                        this.mJoinStatus = i;
                    }
                    registerNetChangedReceiver();
                } else if (isReliable(j)) {
                    this.mJoinReliableCastId = -1000L;
                    this.mRelieableJoinStatus = i;
                } else {
                    this.mJoinMsgCastId = -1000L;
                    this.mJoinStatus = i;
                }
                str3 = "join callback ok";
            } else {
                LogUtils.d(TAG, "IMcastSetistener is null");
                str3 = "join callback fail";
            }
            IMTrack.RequestBuilder requestBuilder = new IMTrack.RequestBuilder(mContext);
            requestBuilder.requestId("" + j).requestTime(System.currentTimeMillis()).ext(str3).errorCode(i).aliasId(501113L).build();
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
            unRegisterNetChangedReceiver();
            cancelMcastQuickHeartBeat();
        }
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

    public void pingRequest(boolean z, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) {
            if (z) {
                j60.c.removeCallbacks(mPingRunnable);
                j60.c.postDelayed(mPingRunnable, j);
            } else {
                j60.c.removeCallbacks(mPingRunnable);
            }
            LogUtils.d(TAG, "pingRequest show :" + z + ", customPingIntervalMs :" + j);
        }
    }

    public void removeAckCastId(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048600, this, j) == null) || j <= 0) {
            return;
        }
        synchronized (this.mAckMcastList) {
            this.mAckMcastList.remove(Long.valueOf(j));
        }
    }

    public void removeFetchCastId(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048601, this, j) == null) || j <= 0) {
            return;
        }
        this.mFetchRunnables.remove(Long.valueOf(j));
    }

    public void removeReliableCastId(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048602, this, j) == null) || j <= 0) {
            return;
        }
        synchronized (this.mReliableMcastList) {
            this.mReliableMcastList.remove(Long.valueOf(j));
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
                    j60.g(mContext).f(mContext, createMcastMethodIntent);
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

    public void setMcastQuickHeartBeat() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if (j60.e && !mOpenPingRequest.get()) {
                mOpenPingRequest.set(true);
                pingRequest(true, mCastHeartBeatTime);
                return;
            }
            mCastHeartBeatTime = mRandom.nextInt(3000) + 3000;
            LogUtils.d(TAG, "mcast now quick heart beat = " + mCastHeartBeatTime);
            if (mcastHeartbeat == null) {
                McastHeartbeat mcastHeartbeat2 = new McastHeartbeat(this);
                mcastHeartbeat = mcastHeartbeat2;
                mcastHeartbeat2.startHeartbeat();
            }
        }
    }
}
