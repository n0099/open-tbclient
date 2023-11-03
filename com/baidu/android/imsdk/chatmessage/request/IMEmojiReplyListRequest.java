package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import com.baidu.android.imsdk.chatmessage.request.IMEmojiReplyListListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.utils.BaseHttpRequest;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMEmojiReplyListRequest extends BaseHttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMEmojiReplyListRequest";
    public transient /* synthetic */ FieldHolder $fh;
    public final int emojiPackageId;
    public final IMEmojiReplyListListener emojiReplyListListener;
    public final ArrayList<Long> msgIdList;
    public final long roomId;

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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public IMEmojiReplyListRequest(Context context, long j, int i, ArrayList<Long> arrayList, IMEmojiReplyListListener iMEmojiReplyListListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j), Integer.valueOf(i), arrayList, iMEmojiReplyListListener};
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
        this.roomId = j;
        this.msgIdList = arrayList;
        this.emojiPackageId = i;
        this.emojiReplyListListener = iMEmojiReplyListListener;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return BaseHttpRequest.getHostUrl(this.mContext) + "rest/3.0/im/chatroom/reaction_list";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appid", Utility.readAppId(this.mContext));
                jSONObject.put("app_version", Utility.getAppVersionName(this.mContext));
                jSONObject.put("sdk_version", IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
                jSONObject.put("device_id", Utility.getDeviceId(this.mContext));
                jSONObject.put("room_id", this.roomId);
                jSONObject.put(Constants.EXTRA_EMOJI_PACKAGE_ID, this.emojiPackageId);
                jSONObject.put("timestamp", System.currentTimeMillis() / 1000);
                jSONObject.put("sign", generateSign(jSONObject));
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < this.msgIdList.size(); i++) {
                    jSONArray.put(this.msgIdList.get(i));
                }
                jSONObject.put("msgids", jSONArray);
            } catch (JSONException e) {
                LogUtils.d("IMEmojiReplyListRequest", "getRequestParameter error：" + e.getMessage());
            }
            LogUtils.d("IMEmojiReplyListRequest", "getRequestParameter:" + jSONObject);
            return jSONObject.toString().getBytes();
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048580, this, i, bArr, th) == null) {
            IMEmojiReplyListListener.IMEmojiReplyListResponse iMEmojiReplyListResponse = new IMEmojiReplyListListener.IMEmojiReplyListResponse();
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr));
                LogUtils.d("IMEmojiReplyListRequest", "errorCode：" + i + ", resultContent: " + jSONObject);
                str = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG);
            } catch (Exception e) {
                LogUtils.e("IMEmojiReplyListRequest", "onFailure errorCode：" + i + ", exception : " + e.toString());
                str = "";
            }
            IMEmojiReplyListListener iMEmojiReplyListListener = this.emojiReplyListListener;
            if (iMEmojiReplyListListener != null) {
                iMEmojiReplyListListener.onResult(i, str, this.emojiPackageId, iMEmojiReplyListResponse);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSuccess(int i, byte[] bArr) {
        int i2;
        int i3;
        String str;
        IMEmojiReplyListListener iMEmojiReplyListListener;
        JSONObject jSONObject;
        StringBuilder sb;
        int i4;
        int i5;
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i, bArr) == null) {
            IMEmojiReplyListListener.IMEmojiReplyListResponse iMEmojiReplyListResponse = new IMEmojiReplyListListener.IMEmojiReplyListResponse();
            int i6 = -1;
            try {
                jSONObject = new JSONObject(new String(bArr));
                sb = new StringBuilder();
                sb.append("errorCode：");
                i2 = i;
            } catch (Exception e) {
                e = e;
                i2 = i;
            }
            try {
                sb.append(i2);
                sb.append(", resultContent: ");
                sb.append(jSONObject);
                LogUtils.d("IMEmojiReplyListRequest", sb.toString());
                i3 = jSONObject.optInt("error_code");
                try {
                    str = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG);
                    if (i3 == 0) {
                        i6 = jSONObject.optInt("emoji_packge_id", this.emojiPackageId);
                        try {
                            if (jSONObject.has("result")) {
                                JSONObject jSONObject2 = new JSONObject(jSONObject.optString("result"));
                                LogUtils.d("IMEmojiReplyListRequest", " result :" + jSONObject2 + ", msg:" + this.msgIdList.get(0));
                                int i7 = 0;
                                while (i7 < this.msgIdList.size()) {
                                    long longValue = this.msgIdList.get(i7).longValue();
                                    String valueOf = String.valueOf(longValue);
                                    if (jSONObject2.has(valueOf)) {
                                        ArrayList<IMEmojiReplyListListener.IMEmojiItem> arrayList = new ArrayList<>();
                                        JSONArray optJSONArray = jSONObject2.optJSONArray(valueOf);
                                        if (optJSONArray != null) {
                                            LogUtils.d("IMEmojiReplyListRequest", " array :" + optJSONArray);
                                            int i8 = 0;
                                            while (i8 < optJSONArray.length()) {
                                                IMEmojiReplyListListener.IMEmojiItem iMEmojiItem = new IMEmojiReplyListListener.IMEmojiItem();
                                                JSONObject jSONObject3 = optJSONArray.getJSONObject(i8);
                                                if (jSONObject3 != null) {
                                                    StringBuilder sb2 = new StringBuilder();
                                                    i5 = i6;
                                                    try {
                                                        sb2.append(" msgEmojiObj :");
                                                        sb2.append(jSONObject3);
                                                        LogUtils.d("IMEmojiReplyListRequest", sb2.toString());
                                                        jSONArray = optJSONArray;
                                                        iMEmojiItem.msgId = jSONObject3.optLong("msgid");
                                                        iMEmojiItem.msgKey = jSONObject3.optString("msgkey");
                                                        iMEmojiItem.emojiContent = jSONObject3.optString("emoji_content");
                                                        iMEmojiItem.allNum = jSONObject3.optInt("reactions_num");
                                                        iMEmojiItem.minSortTimeUs = jSONObject3.optLong("sort_time_us_min");
                                                        iMEmojiItem.hasReacted = jSONObject3.optInt("has_reacted");
                                                        arrayList.add(iMEmojiItem);
                                                        continue;
                                                    } catch (Exception e2) {
                                                        e = e2;
                                                        i6 = i5;
                                                        LogUtils.e("IMEmojiReplyListRequest", "onSuccess errorCode：" + i3 + ", exception : " + e);
                                                        i3 = 1010;
                                                        str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
                                                        iMEmojiReplyListListener = this.emojiReplyListListener;
                                                        if (iMEmojiReplyListListener != null) {
                                                        }
                                                    }
                                                } else {
                                                    i5 = i6;
                                                    jSONArray = optJSONArray;
                                                    continue;
                                                }
                                                i8++;
                                                i6 = i5;
                                                optJSONArray = jSONArray;
                                            }
                                        }
                                        i4 = i6;
                                        iMEmojiReplyListResponse.emojiReplyMap.put(Long.valueOf(longValue), arrayList);
                                    } else {
                                        i4 = i6;
                                    }
                                    i7++;
                                    i6 = i4;
                                }
                            }
                            i6 = i6;
                        } catch (Exception e3) {
                            e = e3;
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                }
            } catch (Exception e5) {
                e = e5;
                i3 = i2;
                LogUtils.e("IMEmojiReplyListRequest", "onSuccess errorCode：" + i3 + ", exception : " + e);
                i3 = 1010;
                str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
                iMEmojiReplyListListener = this.emojiReplyListListener;
                if (iMEmojiReplyListListener != null) {
                }
            }
            iMEmojiReplyListListener = this.emojiReplyListListener;
            if (iMEmojiReplyListListener != null) {
                iMEmojiReplyListListener.onResult(i3, str, i6, iMEmojiReplyListResponse);
            }
        }
    }
}
