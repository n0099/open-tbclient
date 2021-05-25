package com.baidu.android.imsdk.group.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.chatuser.ChatUser;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.group.GroupSortUserList;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMGetFansGroupInviteMember extends FansGroupBaseHttpRequest {
    public static final String TAG = "IMGetFansGroupInviteMember";
    public String mGroupId;
    public String mKey;

    public IMGetFansGroupInviteMember(Context context, String str, String str2) {
        this.mContext = context;
        this.mGroupId = str;
        this.mKey = str2;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return "application/x-www-form-urlencoded";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        return ("method=get_invite_members&group_id=" + this.mGroupId + getCommonParams()).getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i2, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i2, bArr, th);
        LogUtils.d(TAG, "onFailure result = " + new String(bArr));
        IMListener removeListener = ListenerManager.getInstance().removeListener(this.mKey);
        if (removeListener instanceof BIMValueCallBack) {
            ((BIMValueCallBack) removeListener).onResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSuccess(int i2, byte[] bArr) {
        String str;
        int i3;
        IMListener removeListener;
        String str2 = new String(bArr);
        LogUtils.d(TAG, "onSuccess result = " + str2);
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        try {
            JSONObject jSONObject = new JSONObject(str2);
            i3 = jSONObject.optInt("error_code");
            str = jSONObject.optString("error_msg");
            if (i3 == 0 && jSONObject.has("response_params")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("response_params");
                int optInt = jSONObject2.optInt("server_sort", 0);
                try {
                    if (jSONObject2.has("members")) {
                        JSONArray jSONArray = jSONObject2.getJSONArray("members");
                        while (i4 < jSONArray.length()) {
                            JSONObject jSONObject3 = jSONArray.getJSONObject(i4);
                            long j = jSONObject3.getLong("bd_uid");
                            String optString = jSONObject3.optString("display_name");
                            String optString2 = jSONObject3.optString("group_name");
                            ChatUser chatUser = new ChatUser(0L, j, TextUtils.isEmpty(optString2) ? optString : optString2, jSONObject3.optString("avatar"));
                            chatUser.setGroupStatus(jSONObject3.optInt("group_status"));
                            arrayList.add(chatUser);
                            i4++;
                        }
                    }
                    i4 = optInt;
                } catch (JSONException e2) {
                    e = e2;
                    i4 = optInt;
                    LogUtils.e(TAG, "IMGetFansGroupInviteMember JSONException", e);
                    i3 = 1010;
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                    str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
                    removeListener = ListenerManager.getInstance().removeListener(this.mKey);
                    if (removeListener instanceof BIMValueCallBack) {
                    }
                }
            }
        } catch (JSONException e3) {
            e = e3;
        }
        removeListener = ListenerManager.getInstance().removeListener(this.mKey);
        if (removeListener instanceof BIMValueCallBack) {
            return;
        }
        ((BIMValueCallBack) removeListener).onResult(i3, str, new GroupSortUserList(arrayList, i4));
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return false;
    }
}
