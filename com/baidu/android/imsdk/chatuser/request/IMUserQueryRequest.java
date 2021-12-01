package com.baidu.android.imsdk.chatuser.request;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.chatuser.ChatUser;
import com.baidu.android.imsdk.chatuser.ChatUserManagerImpl;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.group.GroupInfo;
import com.baidu.android.imsdk.group.db.GroupInfoDAOImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class IMUserQueryRequest extends IMUserBaseHttpRequest {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long mAppid;
    public String mKey;

    public IMUserQueryRequest(Context context, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j2)};
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
        this.mAppid = j2;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "application/x-www-form-urlencoded" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return ("method=read_contacter_setting&appid=" + this.mAppid).getBytes();
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i2, byte[] bArr, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, bArr, th) == null) {
            String str = bArr != null ? new String(bArr) : "";
            if (th == null && i2 != 1005 && i2 != 1000) {
                str = "http response is error! response code:" + i2;
                i2 = 1011;
            }
            ChatUserManagerImpl.getInstance(this.mContext).onQueryResult(i2, str, null, this.mKey);
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i2, byte[] bArr) {
        int i3;
        String str;
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, bArr) == null) {
            String str2 = new String(bArr);
            LogUtils.d("", "IMUserQueryRequest  " + str2);
            LinkedList linkedList = new LinkedList();
            ArrayList arrayList = new ArrayList();
            try {
                JSONObject jSONObject = new JSONObject(str2);
                if (jSONObject.has("response_params")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("response_params");
                    i3 = jSONObject2.getInt("error_code");
                    JSONArray jSONArray2 = jSONObject2.getJSONArray("contacters");
                    int i4 = 0;
                    while (i4 < jSONArray2.length()) {
                        JSONObject jSONObject3 = jSONArray2.getJSONObject(i4);
                        long optLong = jSONObject3.optLong("contacter");
                        int optInt = jSONObject3.optInt("contacter_type");
                        int optInt2 = jSONObject3.optInt("do_not_disturb");
                        int optInt3 = jSONObject3.optInt(TableDefine.UserInfoColumns.COLUMN_BLACKLIST);
                        if (optInt == 0) {
                            jSONArray = jSONArray2;
                            ChatUser chatUser = new ChatUser(optLong, 0L, null, null);
                            chatUser.setDisturb(optInt2);
                            chatUser.setBlack(optInt3);
                            chatUser.setUserExt(jSONObject3.optString(TableDefine.UserInfoColumns.COLUMN_USER_EXT, ""));
                            linkedList.add(chatUser);
                        } else {
                            jSONArray = jSONArray2;
                            if (1 == optInt) {
                                GroupInfo groupInfo = new GroupInfo(String.valueOf(optLong));
                                groupInfo.setDisturb(optInt2);
                                arrayList.add(groupInfo);
                            }
                        }
                        i4++;
                        jSONArray2 = jSONArray;
                    }
                    str = Constants.ERROR_MSG_SUCCESS;
                } else {
                    i3 = jSONObject.getInt("error_code");
                    str = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG, "");
                }
            } catch (JSONException e2) {
                LogUtils.e("IMUserQueryRequest", "JSONException", e2);
                i3 = 1010;
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
            }
            GroupInfoDAOImpl.setAllStarDisturbDefault(this.mContext);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                GroupInfo groupInfo2 = (GroupInfo) it.next();
                GroupInfoDAOImpl.setGroupDisturb(this.mContext, groupInfo2.getGroupId(), groupInfo2.getDisturb());
            }
            ChatUserManagerImpl.getInstance(this.mContext).onQueryResult(i3, str, linkedList, this.mKey);
        }
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (AccountManager.isCuidLogin(this.mContext)) {
                onFailure(1000, "Account not login! pls login first!, uid login required".getBytes(), null);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public IMUserQueryRequest(Context context, long j2, String str) {
        this(context, j2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j2), str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], ((Long) objArr2[1]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mKey = str;
    }
}
