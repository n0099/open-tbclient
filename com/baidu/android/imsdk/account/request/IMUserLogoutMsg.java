package com.baidu.android.imsdk.account.request;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class IMUserLogoutMsg extends Message {
    private int mClearAfterLogout;
    private Context mContext;
    private String mDeviceId;

    public IMUserLogoutMsg(Context context) {
        this.mContext = context;
        initCommonParameter(context);
        this.mDeviceId = Utility.getIMDeviceId(context);
        setNeedReplay(true);
        setType(52);
    }

    @Override // com.baidu.android.imsdk.request.Message
    protected void buildBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", 52);
            jSONObject.put("appid", this.mAppid);
            jSONObject.put("uk", this.mUk);
            jSONObject.put("device_id", this.mDeviceId);
            this.mBody = jSONObject.toString();
        } catch (JSONException e) {
            LogUtils.e(getClass().getSimpleName(), "Exception ", e);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
        }
    }

    public static IMUserLogoutMsg newInstance(Context context, Intent intent) {
        new IMUserLogoutMsg(context).setClearAfterLogout(intent.getIntExtra(Constants.EXTRA_CLEAR_AFTER_LOGOUT, 0));
        return new IMUserLogoutMsg(context);
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i, String str) {
        Utility.logout(context, getListenerKey());
    }

    private void setClearAfterLogout(int i) {
        this.mClearAfterLogout = i;
    }
}
