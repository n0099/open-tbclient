package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.util.Pair;
import androidx.core.app.NotificationCompat;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.chatmessage.IFetchMsgByIdExtendListener;
import com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.internal.MessageParser;
import com.baidu.android.imsdk.request.MessageExt;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.utils.BaseHttpRequest;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.searchbox.download.util.MigrateStatisticUtils;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMNewFetchMsgRequest extends BaseHttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMNewFetchMsgRequest";
    public transient /* synthetic */ FieldHolder $fh;
    public Long mAppid;
    public long mBeginid;
    public int mCategory;
    public long mContacter;
    public int mCount;
    public long mEndid;
    public int mFromAction;
    public boolean mIsChatRoom;
    public boolean mIsReliable;
    public String mKey;
    public final int mLoginType;
    public long mUk;

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "application/json" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "POST" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public IMNewFetchMsgRequest(Context context, String str, long j, long j2, long j3, int i, int i2, long j4, long j5, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r4;
            Object[] objArr = {context, str, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j4), Long.valueOf(j5), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
        this.mAppid = Long.valueOf(j);
        this.mUk = j2;
        this.mContacter = j3;
        this.mCategory = i;
        this.mCount = i2;
        this.mBeginid = j4;
        this.mEndid = j5;
        this.mKey = str;
        this.mIsReliable = z;
        this.mLoginType = AccountManagerImpl.getInstance(this.mContext).getLoginType();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return BaseHttpRequest.getHostUrl(this.mContext) + "rest/3.0/im/fetch_mcast_msg_client";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() {
        InterceptResult invokeV;
        JSONObject json;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appid", Utility.readAppId(this.mContext));
                jSONObject.put("mcast_id", this.mContacter);
                jSONObject.put(Constants.EXTRA_BEGIN_MSGID, this.mBeginid);
                jSONObject.put(Constants.EXTRA_END_MSGID, this.mEndid);
                jSONObject.put("count", this.mCount);
                jSONObject.put("category", this.mCategory);
                jSONObject.put("mcast_id", this.mContacter);
                jSONObject.put("mcast_id", this.mContacter);
                jSONObject.put("app_version", Utility.getAppVersionName(this.mContext));
                jSONObject.put("sdk_version", IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
                jSONObject.put("device_id", Utility.getDeviceId(this.mContext));
                jSONObject.put(HttpConstants.DEVICE_TYPE, 2);
                if (this.mIsChatRoom) {
                    jSONObject.put("from_action", this.mFromAction);
                }
                if (4 == this.mCategory && (json = MessageExt.getInstance().toJson()) != null && json.length() > 0) {
                    jSONObject.put(MigrateStatisticUtils.EXT_INFO, URLEncoder.encode(json.toString()));
                }
                jSONObject.put("timestamp", System.currentTimeMillis() / 1000);
                jSONObject.put("account_type", this.mLoginType);
                if (this.mLoginType == 6) {
                    jSONObject.put("token", AccountManagerImpl.getInstance(this.mContext).getToken());
                }
                jSONObject.put("sign", generateSign(jSONObject));
            } catch (NoSuchAlgorithmException | JSONException e) {
                LogUtils.d(TAG, "getRequestParameter error：" + e.toString());
            }
            LogUtils.d(TAG, "IMEnterChatRoomRequest getRequestParameter:" + jSONObject);
            return jSONObject.toString().getBytes();
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048580, this, i, bArr, th) == null) {
            Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
            LogUtils.d(TAG, "  errorCode: " + transErrorCode.first);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0109  */
    /* JADX WARN: Type inference failed for: r7v1, types: [T, java.lang.Long] */
    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSuccess(int i, byte[] bArr) {
        boolean z;
        String str;
        int i2;
        boolean z2;
        int i3;
        IMListener removeListener;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i, bArr) == null) {
            String str2 = "";
            String str3 = new String(bArr);
            LogUtils.d(TAG, GlideException.IndentedAppendable.INDENT + str3);
            ArrayList<ChatMsg> arrayList = new ArrayList<>();
            Type type = new Type();
            type.t = 0L;
            int i5 = 0;
            try {
                JSONObject jSONObject = new JSONObject(str3);
                int i6 = jSONObject.getInt(PmsConstant.Statistic.STATISTIC_ERRCODE);
                str = jSONObject.optString(PmsConstant.Statistic.STATISTIC_ERRMSG, "");
                str2 = jSONObject.optString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, "0");
                z = jSONObject.optBoolean("has_more", false);
                if (i6 == 0) {
                    try {
                        if (jSONObject.has(NotificationCompat.CarExtender.KEY_MESSAGES)) {
                            JSONArray jSONArray = jSONObject.getJSONArray(NotificationCompat.CarExtender.KEY_MESSAGES);
                            if (jSONArray != null) {
                                i4 = jSONArray.length();
                            } else {
                                i4 = 0;
                            }
                            try {
                                arrayList = MessageParser.parserMessage(this.mContext, jSONArray, type, true, false);
                                i5 = i4;
                            } catch (Exception e) {
                                e = e;
                                i5 = i4;
                                LogUtils.e(TAG, "JSONException", e);
                                str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
                                i2 = i5;
                                z2 = z;
                                i3 = 1010;
                                LogUtils.d(TAG, "requestid : " + str2 + " , resultCode: " + i3 + " , resultMsg : " + str);
                                if (this.mIsReliable) {
                                    LogUtils.d(TAG, "短连接回ack begin");
                                    TaskManager.getInstance(this.mContext).submitForNetWork(new Runnable(this, arrayList) { // from class: com.baidu.android.imsdk.chatmessage.request.IMNewFetchMsgRequest.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ IMNewFetchMsgRequest this$0;
                                        public final /* synthetic */ ArrayList val$finalMsgs;

                                        {
                                            Interceptable interceptable2 = $ic;
                                            if (interceptable2 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this, arrayList};
                                                interceptable2.invokeUnInit(65536, newInitContext);
                                                int i7 = newInitContext.flag;
                                                if ((i7 & 1) != 0) {
                                                    int i8 = i7 & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable2.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.this$0 = this;
                                            this.val$finalMsgs = arrayList;
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            Interceptable interceptable2 = $ic;
                                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                                IMAckRequest iMAckRequest = new IMAckRequest(this.this$0.mContext, this.this$0.mKey, this.this$0.mUk, this.this$0.mContacter, this.this$0.mCategory, this.this$0.mCount, this.this$0.mBeginid, this.this$0.mEndid, this.this$0.mIsReliable, this.val$finalMsgs);
                                                HttpHelper.executor(this.this$0.mContext, iMAckRequest, iMAckRequest);
                                            }
                                        }
                                    });
                                }
                                removeListener = ListenerManager.getInstance().removeListener(this.mKey);
                                if (!(removeListener instanceof IFetchMsgByIdExtendListener)) {
                                }
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                    }
                }
                i3 = i6;
                i2 = i5;
                z2 = z;
            } catch (Exception e3) {
                e = e3;
                z = false;
            }
            LogUtils.d(TAG, "requestid : " + str2 + " , resultCode: " + i3 + " , resultMsg : " + str);
            if (this.mIsReliable && arrayList.size() > 0) {
                LogUtils.d(TAG, "短连接回ack begin");
                TaskManager.getInstance(this.mContext).submitForNetWork(new Runnable(this, arrayList) { // from class: com.baidu.android.imsdk.chatmessage.request.IMNewFetchMsgRequest.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ IMNewFetchMsgRequest this$0;
                    public final /* synthetic */ ArrayList val$finalMsgs;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = objArr;
                            Object[] objArr = {this, arrayList};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i7 = newInitContext.flag;
                            if ((i7 & 1) != 0) {
                                int i8 = i7 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$finalMsgs = arrayList;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            IMAckRequest iMAckRequest = new IMAckRequest(this.this$0.mContext, this.this$0.mKey, this.this$0.mUk, this.this$0.mContacter, this.this$0.mCategory, this.this$0.mCount, this.this$0.mBeginid, this.this$0.mEndid, this.this$0.mIsReliable, this.val$finalMsgs);
                            HttpHelper.executor(this.this$0.mContext, iMAckRequest, iMAckRequest);
                        }
                    }
                });
            }
            removeListener = ListenerManager.getInstance().removeListener(this.mKey);
            if (!(removeListener instanceof IFetchMsgByIdExtendListener)) {
                ((IFetchMsgByIdExtendListener) removeListener).onFetchMsgByIdResult(i3, str, "0", this.mCategory, this.mContacter, this.mBeginid, this.mEndid, this.mCount, i2, ((Long) type.t).longValue(), arrayList, z2);
                LogUtils.d(TAG, "IFetchMsgByIdExtendListener.onFetchMsgByIdResult");
            } else if (removeListener instanceof IFetchMsgByIdListener) {
                IFetchMsgByIdListener iFetchMsgByIdListener = (IFetchMsgByIdListener) removeListener;
                if (this.mIsChatRoom) {
                    iFetchMsgByIdListener.onFetchMsgByIdResult(i3, str, "0", this.mCategory, this.mContacter, this.mBeginid, this.mEndid, this.mCount, i2, ((Long) type.t).longValue(), MessageParser.parseChatRoomMsg(this.mContext, arrayList));
                } else {
                    iFetchMsgByIdListener.onFetchMsgByIdResult(i3, str, "0", this.mCategory, this.mContacter, this.mBeginid, this.mEndid, this.mCount, i2, ((Long) type.t).longValue(), arrayList);
                }
                LogUtils.d(TAG, "IFetchMsgByIdListener.onFetchMsgByIdResult");
            }
        }
    }

    public void setIsChatRoom(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            this.mIsChatRoom = z;
            this.mFromAction = i;
        }
    }
}
