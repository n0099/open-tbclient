package com.baidu.android.imsdk.chatuser.request;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.baidu.android.imsdk.chatuser.ChatUserManagerImpl;
import com.baidu.android.imsdk.chatuser.IpInfo;
import com.baidu.android.imsdk.chatuser.db.IMUserManager;
import com.baidu.android.imsdk.db.DBManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.MsgUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMGetUserIpLocation extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMGetUserIpLocation";
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public int mReSendCount;
    public ArrayList mUids;
    public int msgtype;

    public IMGetUserIpLocation(Context context, ArrayList arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, arrayList};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.msgtype = 0;
        this.mReSendCount = 0;
        this.mContext = context;
        this.mUids = arrayList;
        initCommonParameter(context);
        setNeedReplay(true);
        setType(91);
    }

    public static IMGetUserIpLocation newInstance(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, intent)) == null) {
            ArrayList arrayList = (ArrayList) intent.getExtras().getSerializable(Constants.EXTRA_UIDS);
            int intExtra = intent.getIntExtra(Constants.EXTRA_SAVE_TO_DB, 0);
            if (arrayList != null && arrayList.size() > 0) {
                IMGetUserIpLocation iMGetUserIpLocation = new IMGetUserIpLocation(context, arrayList);
                iMGetUserIpLocation.setMsgtype(intExtra);
                JSONObject jSONObject = new JSONObject();
                if (intExtra == 1) {
                    try {
                        jSONObject.put("type", intExtra);
                    } catch (JSONException e) {
                        LogUtils.e(TAG, "Exception ", e);
                        new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e)).build();
                    }
                    Message.saveCmdMessage(context, iMGetUserIpLocation, jSONObject.toString(), iMGetUserIpLocation.getPriority());
                    return iMGetUserIpLocation;
                }
                return iMGetUserIpLocation;
            }
            return null;
        }
        return (IMGetUserIpLocation) invokeLL.objValue;
    }

    private void updateDB(Context context, ArrayList arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, context, arrayList) == null) {
            IMUserManager.getInstance(context).updateUserIpInfo(arrayList);
        }
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void buildBody() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("method", 91);
                jSONObject.put("appid", this.mAppid);
                jSONObject.put("uk", this.mUk);
                jSONObject.put("to_users", MsgUtility.listToJsonArray(this.mUids));
                this.mBody = jSONObject.toString();
            } catch (JSONException e) {
                LogUtils.e(TAG, "Exception ", e);
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
            }
        }
    }

    public int getMsgType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.msgtype;
        }
        return invokeV.intValue;
    }

    public ArrayList getToUsers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mUids;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048579, this, context, jSONObject, i, str) == null) {
            if (getMsgType() == 1) {
                if (i != 0) {
                    int i2 = this.mReSendCount;
                    if (i2 >= 3) {
                        setNeedReSend(false);
                        DBManager.getInstance(context).deleteCmdMsg(getUUID());
                    } else {
                        this.mReSendCount = i2 + 1;
                        setNeedReSend(true);
                        return;
                    }
                } else {
                    DBManager.getInstance(context).deleteCmdMsg(getUUID());
                    setNeedReSend(false);
                }
            }
            ArrayList arrayList = null;
            if (i == 0) {
                try {
                    if (jSONObject.has("location")) {
                        ArrayList arrayList2 = new ArrayList();
                        try {
                            JSONArray jSONArray = (JSONArray) jSONObject.opt("location");
                            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                                JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                                IpInfo ipInfo = new IpInfo();
                                ipInfo.setUid(jSONObject2.optLong("uid"));
                                ipInfo.setIp(jSONObject2.optString("ip"));
                                ipInfo.setIsp(jSONObject2.optString("isp"));
                                ipInfo.setCountry(jSONObject2.optString("country"));
                                ipInfo.setProv(jSONObject2.optString("prov"));
                                ipInfo.setCity(jSONObject2.optString("city"));
                                ipInfo.setCounty(jSONObject2.optString("county"));
                                arrayList2.add(ipInfo);
                            }
                            updateDB(context, arrayList2);
                            arrayList = arrayList2;
                        } catch (Exception e) {
                            e = e;
                            arrayList = arrayList2;
                            LogUtils.e(TAG, "IMGetUserIpLocation handleMessageResult :", e);
                            super.handleMessageResult(context, jSONObject, i, str);
                            ChatUserManagerImpl.getInstance(context).onGetUserIpResult(context, getMsgType(), this.mListenerKey, i, str, this.mUids, arrayList);
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            }
            super.handleMessageResult(context, jSONObject, i, str);
            ChatUserManagerImpl.getInstance(context).onGetUserIpResult(context, getMsgType(), this.mListenerKey, i, str, this.mUids, arrayList);
        }
    }

    public void setMsgtype(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.msgtype = i;
        }
    }
}
