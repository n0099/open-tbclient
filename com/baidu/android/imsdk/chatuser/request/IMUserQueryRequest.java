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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class IMUserQueryRequest extends IMUserBaseHttpRequest {
    private long mAppid;
    private String mKey;

    public IMUserQueryRequest(Context context, long j) {
        this.mContext = context;
        this.mAppid = j;
    }

    public IMUserQueryRequest(Context context, long j, String str) {
        this(context, j);
        this.mKey = str;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() {
        StringBuilder sb = new StringBuilder();
        sb.append("method=read_contacter_setting");
        sb.append("&appid=").append(this.mAppid);
        return sb.toString().getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return "application/x-www-form-urlencoded";
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        if (AccountManager.isCuidLogin(this.mContext)) {
            onFailure(1000, "Account not login! pls login first!, uid login required".getBytes(), null);
            return true;
        }
        return false;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        int i2;
        String str;
        String str2 = new String(bArr);
        LogUtils.d("", "IMUserQueryRequest  " + str2);
        String str3 = Constants.ERROR_MSG_SUCCESS;
        LinkedList linkedList = new LinkedList();
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str2);
            if (jSONObject.has("response_params")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("response_params");
                int i3 = jSONObject2.getInt("error_code");
                JSONArray jSONArray = jSONObject2.getJSONArray("contacters");
                for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                    JSONObject jSONObject3 = jSONArray.getJSONObject(i4);
                    long optLong = jSONObject3.optLong("contacter");
                    int optInt = jSONObject3.optInt("contacter_type");
                    int optInt2 = jSONObject3.optInt("do_not_disturb");
                    int optInt3 = jSONObject3.optInt(TableDefine.UserInfoColumns.COLUMN_BLACKLIST);
                    if (optInt == 0) {
                        ChatUser chatUser = new ChatUser(optLong, 0L, null, null);
                        chatUser.setDisturb(optInt2);
                        chatUser.setBlack(optInt3);
                        chatUser.setUserExt(jSONObject3.optString(TableDefine.UserInfoColumns.COLUMN_USER_EXT, ""));
                        linkedList.add(chatUser);
                    } else if (1 == optInt) {
                        GroupInfo groupInfo = new GroupInfo(String.valueOf(optLong));
                        groupInfo.setDisturb(optInt2);
                        arrayList.add(groupInfo);
                    }
                }
                i2 = i3;
            } else {
                i2 = jSONObject.getInt("error_code");
                str3 = jSONObject.optString("error_msg", "");
            }
            str = str3;
        } catch (JSONException e) {
            LogUtils.e("IMUserQueryRequest", "JSONException", e);
            i2 = 1010;
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
            str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
        }
        GroupInfoDAOImpl.setAllStarDisturbDefault(this.mContext);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            GroupInfo groupInfo2 = (GroupInfo) it.next();
            GroupInfoDAOImpl.setGroupDisturb(this.mContext, groupInfo2.getGroupId(), groupInfo2.getDisturb());
        }
        ChatUserManagerImpl.getInstance(this.mContext).onQueryResult(i2, str, linkedList, this.mKey);
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        String str = "";
        if (bArr != null) {
            str = new String(bArr);
        }
        if (th == null && i != 1005 && i != 1000) {
            str = "http response is error! response code:" + i;
            i = 1011;
        }
        ChatUserManagerImpl.getInstance(this.mContext).onQueryResult(i, str, null, this.mKey);
    }
}
