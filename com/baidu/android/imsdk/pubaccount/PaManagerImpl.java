package com.baidu.android.imsdk.pubaccount;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import c.a.u.a;
import com.baidu.android.imsdk.CallBack;
import com.baidu.android.imsdk.GetChatObjectInfoForRecordHandler;
import com.baidu.android.imsdk.GetChatObjectInfoForRecordManager;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.UserSettingPaCmdMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.Dispatcher;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.IMSDK;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.internal.MessageFactory;
import com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager;
import com.baidu.android.imsdk.pubaccount.request.IMGetPaTypeRequest;
import com.baidu.android.imsdk.pubaccount.request.IMPaAcceptPushMsg;
import com.baidu.android.imsdk.pubaccount.request.IMPaClickQuickReply;
import com.baidu.android.imsdk.pubaccount.request.IMPaGetInfoListRequest;
import com.baidu.android.imsdk.pubaccount.request.IMPaGetInfoRequest;
import com.baidu.android.imsdk.pubaccount.request.IMPaGetOneInfoRequest;
import com.baidu.android.imsdk.pubaccount.request.IMPaGetQuickReplies;
import com.baidu.android.imsdk.pubaccount.request.IMPaSearchListMsg;
import com.baidu.android.imsdk.pubaccount.request.IMPaSubscribeMsg;
import com.baidu.android.imsdk.pubaccount.request.IMPaSubscribedListMsg;
import com.baidu.android.imsdk.pubaccount.request.IMPaSubscribedMsg;
import com.baidu.android.imsdk.pubaccount.request.IMPaUnsubscribeMsg;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
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
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class PaManagerImpl {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "PaManagerImpl";
    public static ArrayList<IAcceptMsgChangeListener> mAcceptMsgChangeListeners;
    public static Context mContext;
    public static volatile PaManagerImpl mInstance;
    public static ArrayList<IPaSubscriptionChangeListener> mPaSubscriptionChangeListeners;
    public static ArrayList<ISubscriptionChangeListener> mSubscriptionChangeListeners;
    public transient /* synthetic */ FieldHolder $fh;
    public Dispatcher.MsgListener listener;
    public Timer mTimer;
    public Dispatcher.MsgListener userSettingPaListener;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1937575895, "Lcom/baidu/android/imsdk/pubaccount/PaManagerImpl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1937575895, "Lcom/baidu/android/imsdk/pubaccount/PaManagerImpl;");
                return;
            }
        }
        mPaSubscriptionChangeListeners = new ArrayList<>();
        mSubscriptionChangeListeners = new ArrayList<>();
        mAcceptMsgChangeListeners = new ArrayList<>();
    }

    public PaManagerImpl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mTimer = null;
        this.userSettingPaListener = new Dispatcher.MsgListener(this) { // from class: com.baidu.android.imsdk.pubaccount.PaManagerImpl.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PaManagerImpl this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void sendPaSettingChangeBoradCast(int i4, long j2, boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(65538, this, new Object[]{Integer.valueOf(i4), Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
                    Intent intent = new Intent(IMConstants.PA_SETTING_CHANGE_ACTION);
                    intent.setPackage(PaManagerImpl.mContext.getPackageName());
                    intent.putExtra("type", i4);
                    intent.putExtra("paId", j2);
                    intent.putExtra("status", z);
                    PaManagerImpl.mContext.sendBroadcast(intent);
                }
            }

            @Override // com.baidu.android.imsdk.internal.Dispatcher.MsgListener
            public void dealMessage(int i4, ChatMsg chatMsg) {
                String str;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i4, chatMsg) == null) {
                    String str2 = PaManagerImpl.TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("dealpa setting chnge Message ");
                    if (chatMsg == null) {
                        str = null;
                    } else {
                        str = " msgs size is" + chatMsg.toString();
                    }
                    sb.append(str);
                    LogUtils.d(str2, sb.toString());
                    if (chatMsg == null) {
                        LogUtils.d(PaManagerImpl.TAG, "dealpa setting chnge Message is null!");
                    } else if (!(chatMsg instanceof UserSettingPaCmdMsg)) {
                        LogUtils.d(PaManagerImpl.TAG, "msg is not UserSettingPaCmdMsg!");
                    } else {
                        UserSettingPaCmdMsg userSettingPaCmdMsg = (UserSettingPaCmdMsg) chatMsg;
                        long paId = userSettingPaCmdMsg.getPaId();
                        boolean z = userSettingPaCmdMsg.getSyncStatus() == 1;
                        GetChatObjectInfoForRecordHandler getChatObjectInfoForRecordHandler = (GetChatObjectInfoForRecordHandler) GetChatObjectInfoForRecordManager.newInstance(PaManagerImpl.mContext, 0, paId, 1);
                        if (getChatObjectInfoForRecordHandler == null) {
                            return;
                        }
                        getChatObjectInfoForRecordHandler.getChatObjectInfo(paId, new CallBack(this, paId, z) { // from class: com.baidu.android.imsdk.pubaccount.PaManagerImpl.2.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass2 this$1;
                            public final /* synthetic */ boolean val$acception;
                            public final /* synthetic */ long val$paId;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                                    newInitContext2.initArgs = r2;
                                    Object[] objArr = {this, Long.valueOf(paId), Boolean.valueOf(z)};
                                    interceptable3.invokeUnInit(65536, newInitContext2);
                                    int i5 = newInitContext2.flag;
                                    if ((i5 & 1) != 0) {
                                        int i6 = i5 & 2;
                                        newInitContext2.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext2);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                                this.val$paId = paId;
                                this.val$acception = z;
                            }

                            @Override // com.baidu.android.imsdk.CallBack
                            public void onError(int i5, int i6, long j2) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i5), Integer.valueOf(i6), Long.valueOf(j2)}) == null) {
                                }
                            }

                            @Override // com.baidu.android.imsdk.CallBack
                            public void onSuccess(int i5, int i6, Object obj) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i5, i6, obj) == null) {
                                    if (i5 == 1) {
                                        PaInfoDBManager.getInstance(PaManagerImpl.mContext).acceptPaPush(this.val$paId, this.val$acception);
                                    }
                                    sendPaSettingChangeBoradCast(i5, this.val$paId, this.val$acception);
                                    synchronized (PaManagerImpl.mAcceptMsgChangeListeners) {
                                        Iterator it = PaManagerImpl.mAcceptMsgChangeListeners.iterator();
                                        while (it.hasNext()) {
                                            ((IAcceptMsgChangeListener) it.next()).onAcceptMsgChange(i5, this.val$paId, this.val$acception);
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            }

            @Override // com.baidu.android.imsdk.internal.Dispatcher.MsgListener
            public void dealMessage(int i4, ArrayList<ChatMsg> arrayList) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i4, arrayList) == null) {
                }
            }
        };
        Class<?>[] clsArr = {IMPaAcceptPushMsg.class, IMPaSearchListMsg.class, IMPaSubscribedListMsg.class, IMPaSubscribedMsg.class, IMPaSubscribeMsg.class, IMPaUnsubscribeMsg.class};
        int[] iArr = {105, 103, 104, 109, 100, 101};
        for (int i4 = 0; i4 < 6; i4++) {
            MessageFactory.getInstance().addType(iArr[i4], clsArr[i4]);
        }
        this.listener = new Dispatcher.MsgListener(this) { // from class: com.baidu.android.imsdk.pubaccount.PaManagerImpl.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PaManagerImpl this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.android.imsdk.internal.Dispatcher.MsgListener
            public void dealMessage(int i5, ChatMsg chatMsg) {
                String str;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i5, chatMsg) == null) {
                    String str2 = PaManagerImpl.TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("dealMessage ");
                    if (chatMsg == null) {
                        str = null;
                    } else {
                        str = " msgs size is" + chatMsg.toString();
                    }
                    sb.append(str);
                    LogUtils.d(str2, sb.toString());
                    if (chatMsg == null) {
                        return;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject(chatMsg.getMsgContent());
                        long optLong = jSONObject.optLong("pa_uid");
                        boolean optBoolean = jSONObject.optBoolean(IMConstants.SERVICE_TYPE_SUBSCRIPTION);
                        if (optBoolean) {
                            LogUtils.d(PaManagerImpl.TAG, "dealmessage subscription " + chatMsg.toString());
                            GetChatObjectInfoForRecordHandler getChatObjectInfoForRecordHandler = (GetChatObjectInfoForRecordHandler) GetChatObjectInfoForRecordManager.newInstance(PaManagerImpl.mContext, 0, optLong, 1);
                            if (getChatObjectInfoForRecordHandler == null) {
                                return;
                            }
                            getChatObjectInfoForRecordHandler.getChatObjectInfo(optLong, new CallBack(this, optLong, optBoolean) { // from class: com.baidu.android.imsdk.pubaccount.PaManagerImpl.1.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass1 this$1;
                                public final /* synthetic */ long val$paId;
                                public final /* synthetic */ boolean val$subscription;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                                        newInitContext2.initArgs = r2;
                                        Object[] objArr = {this, Long.valueOf(optLong), Boolean.valueOf(optBoolean)};
                                        interceptable3.invokeUnInit(65536, newInitContext2);
                                        int i6 = newInitContext2.flag;
                                        if ((i6 & 1) != 0) {
                                            int i7 = i6 & 2;
                                            newInitContext2.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext2);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                    this.val$paId = optLong;
                                    this.val$subscription = optBoolean;
                                }

                                @Override // com.baidu.android.imsdk.CallBack
                                public void onError(int i6, int i7, long j2) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i6), Integer.valueOf(i7), Long.valueOf(j2)}) == null) {
                                    }
                                }

                                @Override // com.baidu.android.imsdk.CallBack
                                public void onSuccess(int i6, int i7, Object obj) {
                                    Interceptable interceptable3 = $ic;
                                    if (!(interceptable3 == null || interceptable3.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i6, i7, obj) == null) || PaManagerImpl.mPaSubscriptionChangeListeners == null) {
                                        return;
                                    }
                                    Iterator it = PaManagerImpl.mPaSubscriptionChangeListeners.iterator();
                                    while (it.hasNext()) {
                                        IPaSubscriptionChangeListener iPaSubscriptionChangeListener = (IPaSubscriptionChangeListener) it.next();
                                        if (iPaSubscriptionChangeListener != null) {
                                            iPaSubscriptionChangeListener.onPaSubscriptionChangeResult(this.val$paId, this.val$subscription);
                                        }
                                    }
                                    synchronized (PaManagerImpl.mPaSubscriptionChangeListeners) {
                                        Iterator it2 = PaManagerImpl.mSubscriptionChangeListeners.iterator();
                                        while (it2.hasNext()) {
                                            ISubscriptionChangeListener iSubscriptionChangeListener = (ISubscriptionChangeListener) it2.next();
                                            if (iSubscriptionChangeListener != null) {
                                                iSubscriptionChangeListener.onSubscriptionResult(i6, this.val$paId, obj);
                                            }
                                        }
                                    }
                                }
                            });
                            this.this$0.getPaInfo(optLong, null);
                            return;
                        }
                        PaInfoDBManager.getInstance(PaManagerImpl.mContext).unSubscribePa(optLong);
                        if (PaManagerImpl.mPaSubscriptionChangeListeners != null) {
                            Iterator it = PaManagerImpl.mPaSubscriptionChangeListeners.iterator();
                            while (it.hasNext()) {
                                ((IPaSubscriptionChangeListener) it.next()).onPaSubscriptionChangeResult(optLong, optBoolean);
                            }
                            synchronized (PaManagerImpl.mPaSubscriptionChangeListeners) {
                                Iterator it2 = PaManagerImpl.mSubscriptionChangeListeners.iterator();
                                while (it2.hasNext()) {
                                    ISubscriptionChangeListener iSubscriptionChangeListener = (ISubscriptionChangeListener) it2.next();
                                    if (iSubscriptionChangeListener != null) {
                                        iSubscriptionChangeListener.onUnSubscriptionResult(optLong);
                                    }
                                }
                            }
                        }
                    } catch (JSONException e2) {
                        LogUtils.e(LogUtils.TAG, "json error dealMessage:", e2);
                        new IMTrack.CrashBuilder(PaManagerImpl.mContext).exception(Log.getStackTraceString(e2)).build();
                    }
                }
            }

            @Override // com.baidu.android.imsdk.internal.Dispatcher.MsgListener
            public void dealMessage(int i5, ArrayList<ChatMsg> arrayList) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i5, arrayList) == null) {
                }
            }
        };
        Dispatcher.Event event = new Dispatcher.Event();
        event.setCategory(2);
        event.setType(20);
        Dispatcher.registerListener(event, this.listener);
        Dispatcher.Event event2 = new Dispatcher.Event();
        event2.setCategory(2);
        event2.setType(23);
        Dispatcher.registerListener(event2, this.userSettingPaListener);
    }

    public static synchronized PaManagerImpl getInstance(Context context) {
        InterceptResult invokeL;
        PaManagerImpl paManagerImpl;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            synchronized (PaManagerImpl.class) {
                if (mInstance == null && mInstance == null) {
                    mContext = context.getApplicationContext();
                    mInstance = new PaManagerImpl();
                }
                paManagerImpl = mInstance;
            }
            return paManagerImpl;
        }
        return (PaManagerImpl) invokeL.objValue;
    }

    private void requestPaInfos(List<Long> list, long j2, long j3, GetPaInfoSliceListener getPaInfoSliceListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{list, Long.valueOf(j2), Long.valueOf(j3), getPaInfoSliceListener}) == null) {
            IMPaGetInfoListRequest iMPaGetInfoListRequest = new IMPaGetInfoListRequest(mContext, list, j2, j3, getPaInfoSliceListener);
            HttpHelper.executor(mContext, iMPaGetInfoListRequest, iMPaGetInfoListRequest);
        }
    }

    public void acceptPaPush(long j2, boolean z, IAcceptPaPushListener iAcceptPaPushListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z), iAcceptPaPushListener}) == null) {
            String addListener = ListenerManager.getInstance().addListener(iAcceptPaPushListener);
            if (AccountManager.isLogin(mContext)) {
                Intent creatMethodIntent = Utility.creatMethodIntent(mContext, 105);
                creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
                creatMethodIntent.putExtra(Constants.EXTRA_PA_ID, j2);
                creatMethodIntent.putExtra(Constants.EXTRA_PA_ACCEPT_PUSH, z);
                try {
                    a.g(mContext).f(mContext, creatMethodIntent);
                    return;
                } catch (Exception e2) {
                    ListenerManager.getInstance().removeListener(addListener);
                    onAcceptPaPushResult(addListener, 1003, Constants.ERROR_MSG_SERVICE_ERROR, j2);
                    LogUtils.e(TAG, "Exception ", e2);
                    return;
                }
            }
            onAcceptPaPushResult(addListener, 1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, j2);
        }
    }

    public void clickPaQuickReply(long j2, String str, long j3, IClickPaQuickReplyListener iClickPaQuickReplyListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), str, Long.valueOf(j3), iClickPaQuickReplyListener}) == null) {
            if (AccountManager.isLogin(mContext)) {
                IMPaClickQuickReply iMPaClickQuickReply = new IMPaClickQuickReply(mContext, j2, str, j3, ListenerManager.getInstance().addListener(iClickPaQuickReplyListener));
                HttpHelper.executor(mContext, iMPaClickQuickReply, iMPaClickQuickReply);
            } else if (iClickPaQuickReplyListener != null) {
                iClickPaQuickReplyListener.onClickQuickReply(1000);
            }
        }
    }

    public void delPaLocalInfosByPaType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            TaskManager.getInstance(mContext).submitForNetWork(new Runnable(this, i2) { // from class: com.baidu.android.imsdk.pubaccount.PaManagerImpl.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PaManagerImpl this$0;
                public final /* synthetic */ int val$paType;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$paType = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        String str = PaManagerImpl.TAG;
                        LogUtils.d(str, "---delPaLocalInfosByPaType---paType = " + this.val$paType);
                        ChatMessageDBManager.getInstance(PaManagerImpl.mContext).delPaLocalInfosByPaType(this.val$paType);
                    }
                }
            });
        }
    }

    public PaInfo getPaInfo(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j2)) == null) ? PaInfoDBManager.getInstance(mContext).queryPaInfo(j2) : (PaInfo) invokeJ.objValue;
    }

    public void getPaInfos(ArrayList<Long> arrayList, IGetPaInfosListener iGetPaInfosListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, arrayList, iGetPaInfosListener) == null) {
            if (!AccountManager.isLogin(mContext)) {
                if (iGetPaInfosListener != null) {
                    iGetPaInfosListener.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
                }
            } else if (arrayList != null && arrayList.size() != 0) {
                long appid = AccountManager.getAppid(mContext);
                long uk = IMSDK.getInstance(mContext).getUk();
                int size = arrayList.size() / 20;
                if (arrayList.size() % 20 > 0) {
                    size++;
                }
                GetPaInfoSliceListener getPaInfoSliceListener = new GetPaInfoSliceListener(iGetPaInfosListener, size);
                int i2 = 0;
                while (i2 < size) {
                    int i3 = i2 + 1;
                    int i4 = i3 * 20;
                    if (i4 > arrayList.size()) {
                        i4 = arrayList.size();
                    }
                    requestPaInfos(arrayList.subList(i2 * 20, i4), appid, uk, getPaInfoSliceListener);
                    i2 = i3;
                }
            } else {
                iGetPaInfosListener.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
            }
        }
    }

    public void getPaQuickReplies(long j2, IGetQuickReplyListener iGetQuickReplyListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048582, this, j2, iGetQuickReplyListener) == null) {
            if (!AccountManager.isLogin(mContext)) {
                if (iGetQuickReplyListener != null) {
                    iGetQuickReplyListener.onGetQuickReply(null, true);
                    return;
                }
                return;
            }
            PaInfo paInfo = getPaInfo(j2);
            QuickReply createQuickReply = QuickReply.createQuickReply(paInfo.getRepliesStr());
            if (createQuickReply != null && System.currentTimeMillis() < (createQuickReply.getRefreshTime() * 1000) + paInfo.getLastRefreshTime()) {
                if (createQuickReply.getStatus() == 0) {
                    iGetQuickReplyListener.onGetQuickReply(createQuickReply, true);
                    return;
                } else {
                    iGetQuickReplyListener.onGetQuickReply(null, true);
                    return;
                }
            }
            setPaQuickRelies(j2, "", System.currentTimeMillis());
            IMPaGetQuickReplies iMPaGetQuickReplies = new IMPaGetQuickReplies(mContext, j2, ListenerManager.getInstance().addListener(iGetQuickReplyListener));
            HttpHelper.executor(mContext, iMPaGetQuickReplies, iMPaGetQuickReplies);
        }
    }

    public String getPaThirdId(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j2)) == null) {
            PaInfo paInfo = PaManager.getPaInfo(mContext, j2);
            return paInfo != null ? paInfo.getThirdId() : "";
        }
        return (String) invokeJ.objValue;
    }

    public void getPaType(long j2, IGetPaTypeListener iGetPaTypeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2, iGetPaTypeListener) == null) {
            String str = TAG;
            LogUtils.d(str, "getPaType listener =" + iGetPaTypeListener);
            IMGetPaTypeRequest iMGetPaTypeRequest = new IMGetPaTypeRequest(mContext, ListenerManager.getInstance().addListener(iGetPaTypeListener), j2);
            HttpHelper.executor(mContext, iMGetPaTypeRequest, iMGetPaTypeRequest);
        }
    }

    public void isSubscribed(long j2, IIsSubscribedListener iIsSubscribedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048585, this, j2, iIsSubscribedListener) == null) {
            String addListener = ListenerManager.getInstance().addListener(iIsSubscribedListener);
            if (AccountManager.isLogin(mContext)) {
                Intent creatMethodIntent = Utility.creatMethodIntent(mContext, 109);
                creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
                creatMethodIntent.putExtra(Constants.EXTRA_PA_ID, j2);
                try {
                    a.g(mContext).f(mContext, creatMethodIntent);
                    return;
                } catch (Exception e2) {
                    ListenerManager.getInstance().removeListener(addListener);
                    onIsSubscribedResult(addListener, 1003, Constants.ERROR_MSG_SERVICE_ERROR, j2, false);
                    LogUtils.e(TAG, "Exception ", e2);
                    return;
                }
            }
            onIsSubscribedResult(addListener, 1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, j2, false);
        }
    }

    public void onAcceptPaPushResult(String str, int i2, String str2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{str, Integer.valueOf(i2), str2, Long.valueOf(j2)}) == null) {
            String str3 = TAG;
            LogUtils.d(str3, "onAcceptPaPushResult----errorCode: " + i2 + " msg: " + str2);
            IAcceptPaPushListener iAcceptPaPushListener = (IAcceptPaPushListener) ListenerManager.getInstance().removeListener(str);
            if (iAcceptPaPushListener != null) {
                iAcceptPaPushListener.onAcceptPaPushResult(i2, str2, j2);
            } else {
                LogUtils.d(TAG, "IAcceptPaPushListener is null");
            }
        }
    }

    public void onGetPaInfoResult(String str, int i2, String str2, PaInfo paInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048587, this, str, i2, str2, paInfo) == null) {
            String str3 = TAG;
            LogUtils.d(str3, "onGetPaInfoResult----errorCode: " + i2 + " msg: " + str2);
            IGetPaInfoListener iGetPaInfoListener = (IGetPaInfoListener) ListenerManager.getInstance().removeListener(str);
            if (iGetPaInfoListener != null) {
                iGetPaInfoListener.onGetPaInfoResult(i2, str2, paInfo);
            } else {
                LogUtils.d(TAG, "IGetPaInfoListener is null");
            }
        }
    }

    public void onGetPaTypeResult(String str, int i2, String str2, long j2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{str, Integer.valueOf(i2), str2, Long.valueOf(j2), Integer.valueOf(i3)}) == null) {
            String str3 = TAG;
            LogUtils.d(str3, "onGETPaTypeResult----errorCode: " + i2 + " msg: " + str2);
            IGetPaTypeListener iGetPaTypeListener = (IGetPaTypeListener) ListenerManager.getInstance().removeListener(str);
            if (iGetPaTypeListener != null) {
                iGetPaTypeListener.onGetPaType(i2, str2, j2, i3);
            } else {
                LogUtils.d(TAG, "IGetPaTypeListener is null!");
            }
        }
    }

    public void onIsSubscribedResult(String str, int i2, String str2, long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{str, Integer.valueOf(i2), str2, Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
            String str3 = TAG;
            LogUtils.d(str3, "onIsSubscribedResult----errorCode: " + i2 + " msg: " + str2);
            IIsSubscribedListener iIsSubscribedListener = (IIsSubscribedListener) ListenerManager.getInstance().removeListener(str);
            if (iIsSubscribedListener != null) {
                iIsSubscribedListener.onIsSubscribedResult(i2, str2, j2, z);
            } else {
                LogUtils.d(TAG, "IIsSubscribedListener is null");
            }
        }
    }

    public void onQueryScribedPaListResult(String str, int i2, String str2, List<PaInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048590, this, str, i2, str2, list) == null) {
            String str3 = TAG;
            LogUtils.d(str3, "onQueryScribedPaListResult----errorCode: " + i2 + " msg: " + str2);
            IQuerySubscribedPaListListener iQuerySubscribedPaListListener = (IQuerySubscribedPaListListener) ListenerManager.getInstance().removeListener(str);
            if (iQuerySubscribedPaListListener != null) {
                iQuerySubscribedPaListListener.onQuerySubscribedPaResult(i2, str2, list);
            } else {
                LogUtils.d(TAG, "IQuerySubscribePaListListener is null");
            }
        }
    }

    public void onSearchPaListResult(String str, int i2, String str2, List<PaInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048591, this, str, i2, str2, list) == null) {
            String str3 = TAG;
            LogUtils.d(str3, "onSearchPaResult----errorCode: " + i2 + " msg: " + str2);
            ISearchPaListListener iSearchPaListListener = (ISearchPaListListener) ListenerManager.getInstance().removeListener(str);
            if (iSearchPaListListener != null) {
                iSearchPaListListener.onSearchPaListResult(i2, str2, list);
            } else {
                LogUtils.d(TAG, "ISearchPaListListener is null");
            }
        }
    }

    public void onSubscribePaResult(String str, int i2, String str2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{str, Integer.valueOf(i2), str2, Long.valueOf(j2)}) == null) {
            String str3 = TAG;
            LogUtils.d(str3, "onSubscribePaResult----errorCode: " + i2 + " msg: " + str2);
            ISubscribePaListener iSubscribePaListener = (ISubscribePaListener) ListenerManager.getInstance().removeListener(str);
            if (iSubscribePaListener != null) {
                iSubscribePaListener.onSubsribePaResult(i2, str2, j2);
            } else {
                LogUtils.d(TAG, "ISubscribePaListener is null");
            }
        }
    }

    public void onUnsubscribePaResult(String str, int i2, String str2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{str, Integer.valueOf(i2), str2, Long.valueOf(j2)}) == null) {
            String str3 = TAG;
            LogUtils.d(str3, "onUnscribePaResult----errorCode: " + i2 + " msg: " + str2);
            ISubscribePaListener iSubscribePaListener = (ISubscribePaListener) ListenerManager.getInstance().removeListener(str);
            if (iSubscribePaListener != null) {
                iSubscribePaListener.onUnsubsribePaResult(i2, str2, j2);
            } else {
                LogUtils.d(TAG, "ISubscribePaListener is null");
            }
        }
    }

    public void queryPaInfoList(IQuerySubscribedPaListListener iQuerySubscribedPaListListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, iQuerySubscribedPaListListener) == null) || AccountManager.isCuidLogin(mContext)) {
            return;
        }
        String addListener = ListenerManager.getInstance().addListener(iQuerySubscribedPaListListener);
        AccountManager.getAppid(mContext);
        IMPaGetInfoRequest iMPaGetInfoRequest = new IMPaGetInfoRequest(mContext, addListener, AccountManager.getAppid(mContext), IMSDK.getInstance(mContext).getUk());
        HttpHelper.executor(mContext, iMPaGetInfoRequest, iMPaGetInfoRequest);
    }

    public void querySubscribedPaList(IQuerySubscribedPaListListener iQuerySubscribedPaListListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, iQuerySubscribedPaListListener) == null) {
            String addListener = ListenerManager.getInstance().addListener(iQuerySubscribedPaListListener);
            if (AccountManager.isLogin(mContext)) {
                Intent creatMethodIntent = Utility.creatMethodIntent(mContext, 104);
                creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
                try {
                    a.g(mContext).f(mContext, creatMethodIntent);
                    return;
                } catch (Exception e2) {
                    ListenerManager.getInstance().removeListener(addListener);
                    onQueryScribedPaListResult(addListener, 1003, Constants.ERROR_MSG_SERVICE_ERROR, null);
                    LogUtils.e(TAG, "Exception ", e2);
                    return;
                }
            }
            onQueryScribedPaListResult(addListener, 1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
        }
    }

    public List<PaInfo> querySubscribedPaListSync(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, context)) == null) {
            List<PaInfo> querySubscribedPaList = PaInfoDBManager.getInstance(mContext).querySubscribedPaList();
            ArrayList arrayList = new ArrayList();
            if (querySubscribedPaList != null) {
                for (PaInfo paInfo : querySubscribedPaList) {
                    if (paInfo.getTPL() == AccountManagerImpl.getInstance(mContext).getAppid()) {
                        arrayList.add(paInfo);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void registerAcceptChangeListener(IAcceptMsgChangeListener iAcceptMsgChangeListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, iAcceptMsgChangeListener) == null) || iAcceptMsgChangeListener == null) {
            return;
        }
        synchronized (mAcceptMsgChangeListeners) {
            if (!mAcceptMsgChangeListeners.contains(iAcceptMsgChangeListener)) {
                mAcceptMsgChangeListeners.add(iAcceptMsgChangeListener);
            }
        }
    }

    public void registerPaSubscriptionChangeListener(Context context, IPaSubscriptionChangeListener iPaSubscriptionChangeListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048598, this, context, iPaSubscriptionChangeListener) == null) || iPaSubscriptionChangeListener == null || mPaSubscriptionChangeListeners.contains(iPaSubscriptionChangeListener)) {
            return;
        }
        mPaSubscriptionChangeListeners.add(iPaSubscriptionChangeListener);
    }

    public void registerSubscriptionChangeListener(ISubscriptionChangeListener iSubscriptionChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, iSubscriptionChangeListener) == null) {
            synchronized (mSubscriptionChangeListeners) {
                mSubscriptionChangeListeners.add(iSubscriptionChangeListener);
            }
        }
    }

    public void searchPaList(String str, ISearchPaListListener iSearchPaListListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, str, iSearchPaListListener) == null) {
            String addListener = ListenerManager.getInstance().addListener(iSearchPaListListener);
            if (AccountManager.isLogin(mContext)) {
                Intent creatMethodIntent = Utility.creatMethodIntent(mContext, 103);
                creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
                creatMethodIntent.putExtra(Constants.EXTRA_PA_SEARCH_CONTENT, str);
                try {
                    a.g(mContext).f(mContext, creatMethodIntent);
                    return;
                } catch (Exception e2) {
                    ListenerManager.getInstance().removeListener(addListener);
                    onSearchPaListResult(addListener, 1003, Constants.ERROR_MSG_SERVICE_ERROR, null);
                    LogUtils.e(TAG, "Exception ", e2);
                    return;
                }
            }
            onSearchPaListResult(addListener, 1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
        }
    }

    public int setPaQuickRelies(long j2, String str, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048601, this, new Object[]{Long.valueOf(j2), str, Long.valueOf(j3)})) == null) ? PaInfoDBManager.getInstance(mContext).setPaQuickRelies(j2, str, j3) : invokeCommon.intValue;
    }

    public void subscribePa(long j2, ISubscribePaListener iSubscribePaListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048602, this, j2, iSubscribePaListener) == null) {
            String addListener = ListenerManager.getInstance().addListener(iSubscribePaListener);
            if (AccountManager.isLogin(mContext)) {
                getPaInfo(j2, new IGetPaInfoListener(this, addListener, j2) { // from class: com.baidu.android.imsdk.pubaccount.PaManagerImpl.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PaManagerImpl this$0;
                    public final /* synthetic */ String val$key;
                    public final /* synthetic */ long val$paId;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, addListener, Long.valueOf(j2)};
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
                        this.val$key = addListener;
                        this.val$paId = j2;
                    }

                    @Override // com.baidu.android.imsdk.pubaccount.IGetPaInfoListener
                    public void onGetPaInfoResult(int i2, String str, PaInfo paInfo) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i2, str, paInfo) == null) {
                            if (i2 == 0) {
                                Intent creatMethodIntent = Utility.creatMethodIntent(PaManagerImpl.mContext, 100);
                                creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, this.val$key);
                                creatMethodIntent.putExtra(Constants.EXTRA_PA_ID, this.val$paId);
                                creatMethodIntent.putExtra(Constants.EXTRA_PA_INFO, paInfo);
                                try {
                                    a.g(PaManagerImpl.mContext).f(PaManagerImpl.mContext, creatMethodIntent);
                                    return;
                                } catch (Exception e2) {
                                    ListenerManager.getInstance().removeListener(this.val$key);
                                    this.this$0.onSubscribePaResult(this.val$key, 1003, Constants.ERROR_MSG_SERVICE_ERROR, this.val$paId);
                                    LogUtils.e(PaManagerImpl.TAG, "Exception ", e2);
                                    return;
                                }
                            }
                            this.this$0.onSubscribePaResult(this.val$key, i2, str, this.val$paId);
                        }
                    }
                });
            } else {
                onSubscribePaResult(addListener, 1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, j2);
            }
        }
    }

    public void syncAllPainfo(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, context) == null) {
            if (this.mTimer == null) {
                this.mTimer = new Timer();
            }
            this.mTimer.schedule(new TimerTask(this) { // from class: com.baidu.android.imsdk.pubaccount.PaManagerImpl.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PaManagerImpl this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
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
                }

                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        int sDKVersionValue = IMConfigInternal.getInstance().getSDKVersionValue(PaManagerImpl.mContext);
                        String str = PaManagerImpl.TAG;
                        LogUtils.d(str, "syncpa sdkversion =  " + sDKVersionValue);
                        if (sDKVersionValue >= 2900036) {
                            ArrayList<Long> queryPaidList = PaInfoDBManager.getInstance(PaManagerImpl.mContext).queryPaidList();
                            if (queryPaidList == null || queryPaidList.size() == 0) {
                                LogUtils.e(PaManagerImpl.TAG, "syncpa syncAllPainfo paidlist is null");
                                return;
                            }
                            String str2 = PaManagerImpl.TAG;
                            LogUtils.d(str2, "syncAllPainfo> paidlist = " + queryPaidList.toString());
                            this.this$0.getPaInfos(queryPaidList, new IGetPaInfosListener(this) { // from class: com.baidu.android.imsdk.pubaccount.PaManagerImpl.5.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass5 this$1;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                }

                                @Override // com.baidu.android.imsdk.pubaccount.IGetPaInfosListener
                                public void onResult(int i2, String str3, ArrayList<PaInfo> arrayList) {
                                    Interceptable interceptable3 = $ic;
                                    if ((interceptable3 == null || interceptable3.invokeILL(1048576, this, i2, str3, arrayList) == null) && i2 == 0) {
                                        Iterator<PaInfo> it = arrayList.iterator();
                                        while (it.hasNext()) {
                                            PaInfo next = it.next();
                                            String str4 = PaManagerImpl.TAG;
                                            LogUtils.d(str4, "syncAllPainfo> paid=" + next.getPaId() + ", classtype=" + next.getClassType() + ", classtitle=" + next.getClassTitle() + ", classshow=" + next.getClassshow() + ", marktop=" + next.getMarkTop() + ", markTopTime=" + next.getMarkTopTime());
                                            PaInfoDBManager.getInstance(PaManagerImpl.mContext).subscribePa(next);
                                            ChatMessageDBManager.getInstance(PaManagerImpl.mContext).updateSessionClass(next);
                                        }
                                    }
                                }
                            });
                        }
                    }
                }
            }, 60000L);
        }
    }

    public void syncAndQueryAllPaInfo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            LogUtils.d(TAG, "syncAndQueryAllPaInfo begin");
            String str = Constants.KEY_PA_SUBSCRIBE_SYNC_TIME + AccountManager.getAppid(mContext) + AccountManager.getUid(mContext);
            if (Utility.readBooleanData(mContext, Constants.KEY_UPDATE_SWITCH_PA, true) && Utility.isNeedSync(mContext, str)) {
                Utility.writeLongData(mContext, str, System.currentTimeMillis() + Utility.getPaSyncDelay());
                syncAllPainfo(mContext);
            }
        }
    }

    public void unRegisterAcceptChangeListener(IAcceptMsgChangeListener iAcceptMsgChangeListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, iAcceptMsgChangeListener) == null) || iAcceptMsgChangeListener == null) {
            return;
        }
        synchronized (mAcceptMsgChangeListeners) {
            mAcceptMsgChangeListeners.remove(iAcceptMsgChangeListener);
        }
    }

    public void unregisterPaSubscriptionChangeListener(Context context, IPaSubscriptionChangeListener iPaSubscriptionChangeListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048606, this, context, iPaSubscriptionChangeListener) == null) && iPaSubscriptionChangeListener != null && mPaSubscriptionChangeListeners.contains(iPaSubscriptionChangeListener)) {
            mPaSubscriptionChangeListeners.remove(iPaSubscriptionChangeListener);
        }
    }

    public void unsubscribePa(long j2, ISubscribePaListener iSubscribePaListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048608, this, j2, iSubscribePaListener) == null) {
            String addListener = ListenerManager.getInstance().addListener(iSubscribePaListener);
            if (AccountManager.isLogin(mContext)) {
                Intent creatMethodIntent = Utility.creatMethodIntent(mContext, 101);
                creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
                creatMethodIntent.putExtra(Constants.EXTRA_PA_ID, j2);
                try {
                    a.g(mContext).f(mContext, creatMethodIntent);
                    return;
                } catch (Exception e2) {
                    ListenerManager.getInstance().removeListener(addListener);
                    onUnsubscribePaResult(addListener, 1003, Constants.ERROR_MSG_SERVICE_ERROR, j2);
                    LogUtils.e(TAG, "Exception ", e2);
                    return;
                }
            }
            onUnsubscribePaResult(addListener, 1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, j2);
        }
    }

    public void getPaInfo(long j2, IGetPaInfoListener iGetPaInfoListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048580, this, j2, iGetPaInfoListener) == null) {
            if (!AccountManager.isLogin(mContext)) {
                if (iGetPaInfoListener != null) {
                    iGetPaInfoListener.onGetPaInfoResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
                    return;
                }
                return;
            }
            String addListener = ListenerManager.getInstance().addListener(iGetPaInfoListener);
            long appid = AccountManager.getAppid(mContext);
            long uk = IMSDK.getInstance(mContext).getUk();
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(j2));
            IMPaGetOneInfoRequest iMPaGetOneInfoRequest = new IMPaGetOneInfoRequest(mContext, addListener, arrayList, appid, uk);
            HttpHelper.executor(mContext, iMPaGetOneInfoRequest, iMPaGetOneInfoRequest);
        }
    }

    public void unregisterPaSubscriptionChangeListener(ISubscriptionChangeListener iSubscriptionChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, iSubscriptionChangeListener) == null) {
            synchronized (mSubscriptionChangeListeners) {
                mSubscriptionChangeListeners.remove(iSubscriptionChangeListener);
            }
        }
    }
}
