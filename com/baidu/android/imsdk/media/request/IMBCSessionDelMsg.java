package com.baidu.android.imsdk.media.request;

import android.content.Context;
import android.content.Intent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMBCSessionDelMsg extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMBCSessionDelMsg";
    public transient /* synthetic */ FieldHolder $fh;
    public int mBusinessType;
    public int mCategory;
    public int mClassType;
    public long mClientMaxMsgId;
    public long mContacterPaid;
    public long mContacterUK;
    public Context mContext;
    public int mIsStranger;
    public int mSessionType;
    public int mType;

    private int getUserType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65542, this, i)) == null) ? (i == 1 || i == 27 || i == 2) ? 0 : 1 : invokeI.intValue;
    }

    public IMBCSessionDelMsg(Context context, long j, long j2, int i, int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
        initCommonParameter(context);
        setType(Constants.METHOD_IM_DEL_BUSINESS_SESSION_MSG);
        this.mContacterUK = j;
        this.mClientMaxMsgId = j2;
        this.mSessionType = i;
        this.mBusinessType = i2;
        this.mCategory = i3;
        setListenerKey(str);
        setNeedReplay(true);
    }

    public IMBCSessionDelMsg(Context context, long j, long j2, int i, int i2, long j3, int i3, int i4, int i5, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str};
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
        setType(Constants.METHOD_IM_DEL_BUSINESS_SESSION_MSG);
        setListenerKey(str);
        this.mContacterUK = j;
        this.mClientMaxMsgId = j2;
        this.mBusinessType = i;
        this.mCategory = i2;
        this.mContacterPaid = j3;
        this.mClassType = i3;
        this.mIsStranger = i4;
        this.mType = i5;
    }

    private void buildAdvisoryBody() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("method", Constants.METHOD_IM_DEL_BUSINESS_SESSION_MSG);
                jSONObject.put("appid", this.mAppid);
                jSONObject.put("uk", this.mUk);
                jSONObject.put("to", this.mContacterUK);
                jSONObject.put("user_type", 0);
                jSONObject.put("business_type", this.mBusinessType);
                jSONObject.put("session_type", this.mSessionType);
                jSONObject.put("category", 9);
                jSONObject.put("app_version", Utility.getAppVersionName(this.mContext));
                jSONObject.put("sdk_version", IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
                jSONObject.put(Constants.EXTRA_CLIENT_MAX_MSGID, this.mClientMaxMsgId);
                this.mBody = jSONObject.toString();
                LogUtils.d(TAG, "咨询发送删除消息 body = " + this.mBody);
            } catch (JSONException e) {
                LogUtils.e(TAG, "Exception ", e);
            }
        }
    }

    private void buildBjhBody() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("method", Constants.METHOD_IM_DEL_BUSINESS_SESSION_MSG);
                jSONObject.put("appid", this.mAppid);
                jSONObject.put("uk", this.mUk);
                jSONObject.put(Constants.EXTRA_PAUID_TYPE, MediaSessionManager.getInstance(this.mContext).getMeidaPaid());
                jSONObject.put("user_type", 1);
                jSONObject.put("contacter_uk", getContacterUk());
                jSONObject.put(RequestContants.EXTRA_CONTACTER_USER_TYPE, getUserType(this.mBusinessType));
                if (this.mContacterPaid > 0) {
                    jSONObject.put(RequestContants.EXTRA_CONTACTER_PA_UID, this.mContacterPaid);
                }
                jSONObject.put("business_type", getRequestBusinessType());
                jSONObject.put("category", this.mCategory);
                jSONObject.put(Constants.EXTRA_CLIENT_MAX_MSGID, this.mClientMaxMsgId);
                jSONObject.put("origin_id", Utility.getTriggerId(this.mContext));
                if (this.mBusinessType == 2) {
                    jSONObject.put("group_type", 3);
                }
                if (this.mIsStranger == 1 && this.mType == 1) {
                    jSONObject.put("aggr_type", 12);
                }
                jSONObject.put("sdk_version", IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
                jSONObject.put("app_version", AccountManagerImpl.getInstance(this.mContext).getAppVersion());
                this.mBody = jSONObject.toString();
                LogUtils.d(TAG, "百家号发送删除消息 body = " + this.mBody);
            } catch (JSONException e) {
                LogUtils.e(TAG, "Exception ", e);
            }
        }
    }

    private long getContacterUk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            int i = this.mBusinessType;
            if (i != 3 && i != 2 && i != 1) {
                return 0L;
            }
            return this.mContacterUK;
        }
        return invokeV.longValue;
    }

    private int getRequestBusinessType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
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

    private void handleAdvisoryDelResult(JSONObject jSONObject, String str) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, this, jSONObject, str) == null) {
            if (jSONObject != null) {
                i = jSONObject.optInt(PmsConstant.Statistic.STATISTIC_ERRCODE);
            } else {
                i = 0;
            }
            if (i == 0) {
                ChatSessionManagerImpl.getInstance(this.mContext).onDelBusinessSessionResult(i, str, this.mBusinessType, this.mSessionType, this.mCategory, this.mContacterUK, getListenerKey());
            } else {
                LogUtils.e(TAG, " invoke error ");
            }
        }
    }

    private void handleBusinessSessionDelResult(JSONObject jSONObject, String str) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, this, jSONObject, str) == null) {
            if (jSONObject != null) {
                i = jSONObject.optInt(PmsConstant.Statistic.STATISTIC_ERRCODE);
                if (i == 0) {
                    long j = this.mContacterPaid;
                    if (j <= 0) {
                        j = this.mContacterUK;
                    }
                    MediaSessionManager.getInstance(this.mContext).handleMediaDeleteSession(this.mCategory, j, this.mContacterPaid, this.mClassType, this.mType, this.mIsStranger);
                }
            } else {
                i = 0;
            }
            IMListener removeListener = ListenerManager.getInstance().removeListener(getListenerKey());
            if (removeListener instanceof BIMValueCallBack) {
                ((BIMValueCallBack) removeListener).onResult(i, str, null);
            }
        }
    }

    private void handleDelResult(JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, this, jSONObject, str) == null) {
            if (this.mBusinessType == 27) {
                handleAdvisoryDelResult(jSONObject, str);
            } else {
                handleBusinessSessionDelResult(jSONObject, str);
            }
        }
    }

    public static IMBCSessionDelMsg newInstance(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, context, intent)) == null) {
            if (intent.hasExtra(Constants.EXTRA_BUSINESS_TYPE)) {
                int intExtra = intent.getIntExtra(Constants.EXTRA_BUSINESS_TYPE, -1);
                if (intExtra == 27) {
                    return new IMBCSessionDelMsg(context, intent.getLongExtra("contacter", -1L), intent.getLongExtra(Constants.EXTRA_CLIENT_MAX_MSGID, -1L), intent.getIntExtra("session_type", -1), intExtra, intent.getIntExtra("category", 0), intent.getStringExtra(Constants.EXTRA_LISTENER_ID));
                }
                return new IMBCSessionDelMsg(context, intent.getLongExtra("contacter", 0L), intent.getLongExtra(Constants.EXTRA_CLIENT_MAX_MSGID, 0L), intExtra, intent.getIntExtra("category", 0), intent.getLongExtra(Constants.EXTRA_PA_ID, 0L), intent.getIntExtra(Constants.EXTRA_CLASS_TYPE, 0), intent.getIntExtra(Constants.EXTRA_IS_STRANGER, 0), intent.getIntExtra("type", 0), intent.getStringExtra(Constants.EXTRA_LISTENER_ID));
            }
            return null;
        }
        return (IMBCSessionDelMsg) invokeLL.objValue;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, jSONObject, i, str) == null) {
            if (i == 0) {
                handleDelResult(jSONObject, str);
            } else if (i != 1004 && i != 1001 && i != 4001) {
                handleDelResult(jSONObject, str);
            } else {
                LoginManager.getInstance(context).triggleLogoutListener(i, str);
            }
            super.handleMessageResult(context, jSONObject, i, str);
        }
    }
}
