package com.baidu.android.imrtc.msg;

import android.content.Context;
import android.content.Intent;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imrtc.BIMRtcInfo;
import com.baidu.android.imrtc.BIMRtcManager;
import com.baidu.android.imrtc.send.BIMAnswerRtcInfo;
import com.baidu.android.imrtc.send.BIMCloseRoomRtcInfo;
import com.baidu.android.imrtc.send.BIMFetchSignalRtcInfo;
import com.baidu.android.imrtc.send.BIMFetchStateRtcInfo;
import com.baidu.android.imrtc.send.BIMInviteRtcInfo;
import com.baidu.android.imrtc.upload.BIMRtcTrack;
import com.baidu.android.imrtc.utils.IMJni;
import com.baidu.android.imrtc.utils.IStatusListener;
import com.baidu.android.imrtc.utils.LogUtils;
import com.baidu.android.imrtc.utils.RtcConstants;
import com.baidu.android.imrtc.utils.RtcUtility;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.utils.ZeusInitConfigUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class BIMRtcSendMsg extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMRtcSendMsg";
    public transient /* synthetic */ FieldHolder $fh;
    public int mAction;
    public Context mContext;
    public long mImUk;
    public String mRoomId;
    public long mRtcAppID;
    public String mRtcInfo;
    public int mSdkVersion;
    public IStatusListener mStatusListener;

    public BIMRtcSendMsg(Context context, int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), str, str2};
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
        this.mRtcInfo = str2;
        this.mAction = i2;
        this.mRoomId = str;
    }

    public static BIMRtcSendMsg newInstance(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, intent)) == null) {
            return new BIMRtcSendMsg(context, intent.getIntExtra(RtcConstants.EXTRA_RTC_ACTION_ID, -1), intent.getStringExtra("rtc_room_id"), intent.getStringExtra(RtcConstants.EXTRA_RTC_INFO), intent.getStringExtra(Constants.EXTRA_LISTENER_ID));
        }
        return (BIMRtcSendMsg) invokeLL.objValue;
    }

    private String trackRequestExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("app_id", RtcUtility.getAppId(this.mContext));
                jSONObject.put("rtc_room_id", this.mRoomId);
                jSONObject.put("my_uk", Utility.getUK(this.mContext));
                jSONObject.put("other_uks", "");
                jSONObject.put("cseq_id", RtcConstants.IM_RTC_SDK_SEQ_ID.get());
                jSONObject.put("sseq_id", RtcConstants.IM_RTC_SERVER_SEQ_ID);
                jSONObject.put(ShaderParams.VALUE_TYPE_STEP, "c_send_response");
                jSONObject.put("ext", "-1");
                return jSONObject.toString();
            } catch (Exception unused) {
                return "c_send_response trackRequestExt Exception";
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void buildBody() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mBody = generateBody().toString();
        }
    }

    public JSONObject generateBody() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("method", 230);
                jSONObject.put("appid", this.mRtcAppID);
                jSONObject.put("msg_key", "");
                jSONObject.put("app_version", RtcUtility.getAppVersionName(this.mContext));
                jSONObject.put(ZeusInitConfigUtils.PREF_KEY_SDK_VERSION, this.mSdkVersion);
                jSONObject.put("signal_sdk_version", RtcConstants.RTC_VERSION);
                jSONObject.put("uk", this.mImUk);
                jSONObject.put("third_userid", IMJni.transBDUID(Utility.readUid(this.mContext)));
                jSONObject.put("action", this.mAction);
                jSONObject.put("rtc_room_id", this.mRoomId);
                jSONObject.put(RtcConstants.EXTRA_RTC_INFO, this.mRtcInfo);
                LogUtils.i(TAG, "IMRtcSendMsg body :" + jSONObject.toString());
            } catch (JSONException e2) {
                LogUtils.e(TAG, "IMRtcSendMsg Exception ", e2);
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(Constants.METHOD_SEND_USER_MSG, this, context, jSONObject, i2, str) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("error :");
            sb.append(i2);
            sb.append(", msg :");
            sb.append(str);
            sb.append(", objStr :");
            sb.append(jSONObject != null ? jSONObject.toString() : StringUtil.NULL_STRING);
            LogUtils.w(TAG, sb.toString());
            if (this.mAction != 100) {
                BIMRtcTrack.RequestBuilder method = new BIMRtcTrack.RequestBuilder(this.mContext).method("230");
                method.requestId("" + this.mAction).requestTime(System.currentTimeMillis()).responseTime(System.nanoTime()).errorCode(i2).aliasId(501210L).ext(trackRequestExt()).build();
            }
            String str2 = null;
            if (i2 == 0 && jSONObject != null) {
                str2 = jSONObject.optString(PmsConstant.Statistic.STATISTIC_ERRMSG);
                if (jSONObject.has(RtcConstants.EXTRA_RTC_INFO)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(jSONObject.optString(RtcConstants.EXTRA_RTC_INFO));
                        if (this.mAction == 100 || this.mAction == 92 || this.mAction == 84) {
                            long optLong = jSONObject2.optLong("heartbeat_duration");
                            if (optLong > 0) {
                                RtcConstants.RTC_HEART_BEAT_TIME = optLong * 1000;
                            }
                            int optInt = jSONObject2.optInt("heartbeat_retry_times");
                            if (optInt > 0) {
                                RtcConstants.RTC_HEART_BEAT_RETRY_TIME = optInt;
                            }
                            RtcConstants.RTC_HEART_BEAT_STATUS = jSONObject2.optInt("user_status", 0);
                            long optLong2 = jSONObject2.optLong("ftrace_upload_duration");
                            if (optLong2 > 0) {
                                RtcConstants.RTC_TRACK_UPLOAD_DURATION = optLong2 * 1000;
                            }
                        }
                        long optLong3 = jSONObject2.optLong("server_seqid");
                        if (optLong3 > 0) {
                            RtcConstants.IM_RTC_SERVER_SEQ_ID = optLong3;
                        }
                    } catch (Exception unused) {
                        LogUtils.e(TAG, "rtc_info Exception");
                    }
                }
            }
            super.handleMessageResult(context, jSONObject, i2, str);
            onResult(i2, str2);
        }
    }

    public void onResult(int i2, String str) {
        BIMRtcInfo bIMInviteRtcInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, str) == null) {
            int i3 = this.mAction;
            if (i3 == 80) {
                bIMInviteRtcInfo = new BIMInviteRtcInfo(this.mContext);
            } else if (i3 == 84) {
                bIMInviteRtcInfo = new BIMAnswerRtcInfo();
            } else if (i3 == 88) {
                bIMInviteRtcInfo = new BIMCloseRoomRtcInfo();
            } else if (i3 == 90) {
                bIMInviteRtcInfo = new BIMFetchStateRtcInfo(str);
            } else if (i3 != 91) {
                bIMInviteRtcInfo = new BIMRtcInfo();
            } else {
                bIMInviteRtcInfo = new BIMFetchSignalRtcInfo();
            }
            BIMRtcManager bIMRtcManager = BIMRtcManager.getInstance(this.mContext);
            int i4 = this.mAction;
            bIMRtcManager.onRtcRequestResult(i4, bIMInviteRtcInfo.toRtcInfo(i4, this.mRoomId, this.mRtcInfo), i2, str, this.mListenerKey);
        }
    }

    public void setListener(IStatusListener iStatusListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iStatusListener) == null) {
            this.mStatusListener = iStatusListener;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BIMRtcSendMsg(Context context, int i2, String str, String str2, String str3) {
        this(context, i2, str, str2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), str, str2, str3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], ((Integer) objArr2[1]).intValue(), (String) objArr2[2], (String) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        initCommonParameter(context);
        this.mListenerKey = str3;
        setNeedReplay(true);
        setType(230);
        this.mRtcAppID = this.mAppid;
        this.mSdkVersion = IMConfigInternal.getInstance().getSDKVersionValue(this.mContext);
        this.mImUk = Utility.getUK(this.mContext);
    }
}
