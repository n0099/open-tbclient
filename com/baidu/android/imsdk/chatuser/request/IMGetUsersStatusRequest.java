package com.baidu.android.imsdk.chatuser.request;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.baidu.android.imsdk.chatuser.ChatUserManagerImpl;
import com.baidu.android.imsdk.chatuser.UserStatus;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class IMGetUsersStatusRequest extends Message {
    private Context mContext;
    private int mReSendCount = 0;
    private JSONArray mToUsers;

    public IMGetUsersStatusRequest(Context context, JSONArray jSONArray) {
        initCommonParameter(context);
        this.mContext = context;
        this.mToUsers = jSONArray;
        setNeedReplay(true);
        setType(21);
    }

    @Override // com.baidu.android.imsdk.request.Message
    protected void buildBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", getType());
            jSONObject.put("appid", this.mAppid);
            jSONObject.put("uk", this.mUk);
            jSONObject.put("to_users", this.mToUsers);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("rpc_retry_time", this.mReSendCount);
            jSONObject.put("rpc", jSONObject2.toString());
            this.mBody = jSONObject.toString();
        } catch (JSONException e) {
            LogUtils.e(getClass().getSimpleName(), "Exception ", e);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
        }
    }

    public static IMGetUsersStatusRequest newInstance(Context context, Intent intent) {
        if (intent.hasExtra(Constants.EXTRA_LISTENER_ID)) {
            ArrayList arrayList = (ArrayList) intent.getExtras().getSerializable(Constants.EXTRA_UIDS);
            if (arrayList == null || arrayList.size() < 1) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            if (arrayList != null && arrayList.size() > 0) {
                for (int i = 0; i < arrayList.size(); i++) {
                    jSONArray.put(arrayList.get(i));
                }
            }
            IMGetUsersStatusRequest iMGetUsersStatusRequest = new IMGetUsersStatusRequest(context, jSONArray);
            iMGetUsersStatusRequest.setListenerKey(intent.getStringExtra(Constants.EXTRA_LISTENER_ID));
            return iMGetUsersStatusRequest;
        }
        return null;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i, String str) throws JSONException {
        JSONArray jSONArray;
        if (i != 0) {
            if (this.mReSendCount >= 3) {
                setNeedReSend(false);
            } else {
                this.mReSendCount++;
                setNeedReSend(true);
                return;
            }
        }
        ArrayList<UserStatus> arrayList = null;
        if (i == 0 && jSONObject.has("user_status") && (jSONArray = jSONObject.getJSONArray("user_status")) != null && jSONArray.length() > 0) {
            ArrayList<UserStatus> arrayList2 = new ArrayList<>();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= jSONArray.length()) {
                    break;
                }
                JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                if (jSONObject2.has("uid") && jSONObject2.has("status")) {
                    long j = jSONObject2.getLong("uid");
                    int i4 = jSONObject2.getInt("status");
                    long j2 = 0;
                    if (jSONObject2.has("last_operate_time")) {
                        j2 = jSONObject2.getLong("last_operate_time");
                    }
                    arrayList2.add(new UserStatus(j, i4 == 1, j2));
                }
                i2 = i3 + 1;
            }
            arrayList = arrayList2;
        }
        if (arrayList != null && arrayList.size() > 0) {
            ChatUserManagerImpl.getInstance(context).onGetUsersStatusResult(getListenerKey(), i, str, arrayList);
        } else {
            ChatUserManagerImpl.getInstance(context).onGetUsersStatusResult(getListenerKey(), 1005, Constants.ERROR_MSG_PARAMETER_ERROR, arrayList);
        }
    }
}
