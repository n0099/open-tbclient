package com.baidu.android.imsdk.media.request;

import android.content.Context;
import android.content.Intent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl;
import com.baidu.android.imsdk.chatmessage.IMediaSetSessionReadListener;
import com.baidu.android.imsdk.chatmessage.request.RequestContants;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.media.MediaSessionManager;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMMarkBCSessionReadedMsg extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMMarkBCSessionReadedMsg";
    public transient /* synthetic */ FieldHolder $fh;
    public long mBeginMsgId;
    public int mBusinessType;
    public int mCategory;
    public long mContacterPa;
    public long mContacterUk;
    public Context mContext;
    public int mIsStranger;
    public long mMaxMsgid;
    public int mSessionType;
    public int mType;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1901170977, "Lcom/baidu/android/imsdk/media/request/IMMarkBCSessionReadedMsg;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1901170977, "Lcom/baidu/android/imsdk/media/request/IMMarkBCSessionReadedMsg;");
        }
    }

    public IMMarkBCSessionReadedMsg(Context context, int i, long j, int i2, int i3, int i4, long j2, long j3, String str, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r4;
            Object[] objArr = {context, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j2), Long.valueOf(j3), str, Integer.valueOf(i5)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = context;
        initCommonParameter(context);
        setNeedReplay(true);
        setType(207);
        this.mCategory = i;
        this.mContacterUk = j;
        this.mBusinessType = i3;
        this.mSessionType = i4;
        this.mMaxMsgid = j3;
        this.mType = i2;
        this.mBeginMsgId = j2;
        setListenerKey(str);
        this.mIsStranger = i5;
    }

    public IMMarkBCSessionReadedMsg(Context context, int i, long j, int i2, int i3, long j2, long j3, String str, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {context, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), Long.valueOf(j3), str, Integer.valueOf(i4)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mContext = context;
        initCommonParameter(context);
        setNeedReplay(true);
        setType(207);
        this.mCategory = i;
        this.mContacterUk = j;
        this.mBusinessType = i2;
        this.mType = i3;
        this.mContacterPa = j2;
        this.mMaxMsgid = j3;
        setListenerKey(str);
        this.mIsStranger = i4;
    }

    private void buildAdvisoryBody() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("method", 207);
                jSONObject.put("appid", this.mAppid);
                jSONObject.put("uk", this.mUk);
                jSONObject.put("user_type", 0);
                jSONObject.put("contacter_uk", this.mContacterUk);
                jSONObject.put(RequestContants.EXTRA_CONTACTER_USER_TYPE, 0);
                jSONObject.put("business_type", this.mBusinessType);
                jSONObject.put("session_type", this.mSessionType);
                jSONObject.put("category", this.mCategory);
                jSONObject.put(Constants.EXTRA_BEGIN_MSGID, this.mBeginMsgId);
                jSONObject.put(Constants.EXTRA_CLIENT_MAX_MSGID, this.mMaxMsgid);
                jSONObject.put("app_version", Utility.getAppVersionName(this.mContext));
                jSONObject.put("sdk_version", IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
                jSONObject.put("origin_id", Utility.getTriggerId(this.mContext));
                this.mBody = jSONObject.toString();
                String str = TAG;
                LogUtils.d(str, "request body = " + this.mBody);
            } catch (JSONException e) {
                LogUtils.e(TAG, "Exception ", e);
            }
        }
    }

    private void buildBjhBody() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("method", 207);
                jSONObject.put("appid", this.mAppid);
                jSONObject.put("uk", this.mUk);
                jSONObject.put(Constants.EXTRA_PAUID_TYPE, MediaSessionManager.getInstance(this.mContext).getMeidaPaid());
                jSONObject.put("user_type", 1);
                if (this.mType != 1) {
                    jSONObject.put("contacter_uk", getContacterUk());
                    jSONObject.put(RequestContants.EXTRA_CONTACTER_USER_TYPE, getUserType(this.mBusinessType));
                    if (this.mContacterPa > 0) {
                        jSONObject.put(RequestContants.EXTRA_CONTACTER_PA_UID, this.mContacterPa);
                    }
                    jSONObject.put("business_type", getRequestBusinessType());
                    jSONObject.put("category", this.mCategory);
                    jSONObject.put(Constants.EXTRA_CLIENT_MAX_MSGID, this.mMaxMsgid);
                } else if (this.mIsStranger == 1) {
                    jSONObject.put("contacter_uk", 0);
                    jSONObject.put(RequestContants.EXTRA_CONTACTER_USER_TYPE, getUserType(this.mBusinessType));
                    jSONObject.put(RequestContants.EXTRA_CONTACTER_PA_UID, 0);
                    jSONObject.put("aggr_type", 12);
                    jSONObject.put("business_type", 3);
                    jSONObject.put("category", this.mCategory);
                    jSONObject.put(Constants.EXTRA_CLIENT_MAX_MSGID, this.mMaxMsgid);
                } else {
                    jSONObject.put("business_type", 0);
                }
                jSONObject.put("app_version", Utility.getAppVersionName(this.mContext));
                jSONObject.put("sdk_version", IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
                jSONObject.put("origin_id", Utility.getTriggerId(this.mContext));
                this.mBody = jSONObject.toString();
                String str = TAG;
                LogUtils.d(str, "request body = " + this.mBody);
            } catch (JSONException e) {
                LogUtils.e(TAG, "Exception ", e);
            }
        }
    }

    private long getContacterUk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            int i = this.mBusinessType;
            if (i != 3 && i != 2 && i != 1) {
                return 0L;
            }
            return this.mContacterUk;
        }
        return invokeV.longValue;
    }

    private int getRequestBusinessType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            int i = this.mBusinessType;
            if (i == 1) {
                return 3;
            }
            return i;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void buildBody() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.mBusinessType == 27) {
                buildAdvisoryBody();
            } else {
                buildBjhBody();
            }
        }
    }

    private int getUserType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, this, i)) == null) {
            if (AccountManagerImpl.getInstance(this.mContext).getMediaRole()) {
                if (i == 3 || i == 0) {
                    return 1;
                }
                return 0;
            }
            return 0;
        }
        return invokeI.intValue;
    }

    private void handleBjhSessionReadResult(JSONObject jSONObject, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65544, this, jSONObject, i) == null) {
            if (jSONObject != null) {
                i = jSONObject.optInt(PmsConstant.Statistic.STATISTIC_ERRCODE);
                if (i == 0) {
                    if (this.mType == 0) {
                        long j = this.mContacterPa;
                        if (j <= 0) {
                            j = this.mContacterUk;
                        }
                        MediaSessionManager.getInstance(this.mContext).handleMediaSessionRead(this.mCategory, j, this.mMaxMsgid);
                    } else if (this.mIsStranger == 1) {
                        MediaSessionManager.getInstance(this.mContext).handleMediaStrangerAllRead();
                    } else {
                        MediaSessionManager.getInstance(this.mContext).handleMediaAllRead();
                    }
                }
            } else if (i == 0) {
                i = 0;
            }
            IMListener removeListener = ListenerManager.getInstance().removeListener(getListenerKey());
            if (removeListener instanceof BIMValueCallBack) {
                ((BIMValueCallBack) removeListener).onResult(i, "", null);
            }
        }
    }

    private void handleBusinessSessionReadResult(int i, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(65545, this, i, str) == null) && this.mBusinessType == 27) {
            if (this.mType == 0) {
                ChatSessionManagerImpl.getInstance(this.mContext).onMarkBusinessSessionReadResult(i, str, this.mBusinessType, this.mSessionType, this.mCategory, this.mContacterUk, this.mMaxMsgid, getListenerKey());
                return;
            }
            ChatSessionManagerImpl.getInstance(this.mContext).setAllBusinessSessionRead(27);
            IMListener removeListener = ListenerManager.getInstance().removeListener(getListenerKey());
            if (removeListener instanceof IMediaSetSessionReadListener) {
                ((IMediaSetSessionReadListener) removeListener).onMediaSetSessionReadResult(i, str);
            } else if (removeListener instanceof BIMValueCallBack) {
                ((BIMValueCallBack) removeListener).onResult(i, str, null);
            }
        }
    }

    private void handleReadResult(int i, String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65546, this, i, str, jSONObject) == null) {
            if (this.mBusinessType == 27) {
                handleBusinessSessionReadResult(i, str);
            } else {
                handleBjhSessionReadResult(jSONObject, i);
            }
        }
    }

    public static IMMarkBCSessionReadedMsg newInstance(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, context, intent)) == null) {
            if (intent.hasExtra(Constants.EXTRA_BUSINESS_TYPE)) {
                int intExtra = intent.getIntExtra(Constants.EXTRA_BUSINESS_TYPE, 0);
                if (intExtra == 27) {
                    return new IMMarkBCSessionReadedMsg(context, intent.getIntExtra("category", 0), intent.getLongExtra("contacter", 0L), intent.getIntExtra("type", 0), intExtra, intent.getIntExtra("session_type", 0), intent.getLongExtra(Constants.EXTRA_BEGIN_MSGID, 0L), intent.getLongExtra(Constants.EXTRA_CLIENT_MAX_MSGID, 0L), intent.getStringExtra(Constants.EXTRA_LISTENER_ID), intent.getIntExtra(Constants.EXTRA_IS_STRANGER, 0));
                }
                return new IMMarkBCSessionReadedMsg(context, intent.getIntExtra("category", 0), intent.getLongExtra("contacter", 0L), intExtra, intent.getIntExtra("type", 0), intent.getLongExtra(Constants.EXTRA_PA_ID, 0L), intent.getLongExtra(Constants.EXTRA_CLIENT_MAX_MSGID, 0L), intent.getStringExtra(Constants.EXTRA_LISTENER_ID), intent.getIntExtra(Constants.EXTRA_IS_STRANGER, 0));
            }
            return null;
        }
        return (IMMarkBCSessionReadedMsg) invokeLL.objValue;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, jSONObject, i, str) == null) {
            String str2 = TAG;
            LogUtils.d(str2, "handleMessageResult result = " + jSONObject + ", errorCode = " + i);
            if (i == 0) {
                handleReadResult(i, str, jSONObject);
            } else if (i != 1004 && i != 1001 && i != 4001) {
                handleReadResult(i, str, jSONObject);
            } else {
                LoginManager.getInstance(context).triggleLogoutListener(i, str);
            }
            super.handleMessageResult(context, jSONObject, i, str);
        }
    }
}
