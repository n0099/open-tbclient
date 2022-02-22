package com.baidu.android.imsdk.mcast;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.baidu.android.imsdk.conversation.ConversationStudioManImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class IMQuitCastMsg extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMQuitCastMsg";
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public String mMsgKey;
    public long mRowId;
    public long mToUser;

    public IMQuitCastMsg(Context context, long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j2), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
        initCommonParameter(context);
        this.mMsgKey = str;
        this.mToUser = j2;
        setNeedReplay(true);
        setType(202);
    }

    public static IMQuitCastMsg newInstance(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, intent)) == null) {
            if (intent.hasExtra("mcast_id")) {
                return new IMQuitCastMsg(context, intent.getLongExtra("mcast_id", -1L), intent.getStringExtra(Constants.EXTRA_LISTENER_ID));
            }
            return null;
        }
        return (IMQuitCastMsg) invokeLL.objValue;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void buildBody() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("method", 202);
                jSONObject.put("mcast_id", this.mToUser);
                jSONObject.put("appid", this.mAppid);
                jSONObject.put("uk", this.mUk);
                jSONObject.put("origin_id", Utility.getTriggerId(this.mContext));
                jSONObject.put("msg_key", this.mMsgKey);
                jSONObject.put("sdk_version", IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
                this.mBody = jSONObject.toString();
            } catch (JSONException e2) {
                LogUtils.e(IMQuitCastMsg.class.getSimpleName(), "Exception ", e2);
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
            }
        }
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, jSONObject, i2, str) == null) {
            long j2 = -1;
            if (i2 == 0) {
                try {
                    if (jSONObject.has("msg")) {
                        jSONObject.getString("msg");
                    }
                    if (jSONObject.has("mcast_id")) {
                        j2 = jSONObject.getLong("mcast_id");
                    } else {
                        i2 = 1015;
                        str = Constants.ERROR_MSG_SERVER_INTERNAL_ERROR;
                    }
                    if (j2 > 0) {
                        LogUtils.d(TAG, "quit 直播间，castid信息：" + j2);
                    }
                } catch (Exception e2) {
                    LogUtils.e(TAG, "handle IMQuitCastMsg exception :", e2);
                }
            }
            int i3 = i2;
            String str2 = str;
            super.handleMessageResult(context, jSONObject, i3, str2);
            LogUtils.d(TAG, "errorCode:" + i3 + "  strMsg" + str2);
            ConversationStudioManImpl.getInstance(this.mContext).onQuitCastResult(getListenerKey(), i3, str2, j2);
        }
    }
}
