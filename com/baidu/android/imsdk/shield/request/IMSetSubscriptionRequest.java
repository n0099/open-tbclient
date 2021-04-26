package com.baidu.android.imsdk.shield.request;

import android.content.Context;
import android.util.Pair;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.shield.ISetSubscriptionListener;
import com.baidu.android.imsdk.utils.LogUtils;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMSetSubscriptionRequest extends IMSubscriptionBaseRequest {
    public static final String TAG = "IMSetSubscriptionRequest";
    public int mCategory;

    public IMSetSubscriptionRequest(Context context, int i2, long j, List<Long> list, List<String> list2, String str, String str2) {
        super(context, j, list, list2, str2, str);
        this.mCategory = i2;
    }

    @Override // com.baidu.android.imsdk.shield.request.IMSubscriptionBaseRequest
    public String getHostUrlParam() {
        return this.mCategory == 1 ? TableDefine.PaSubscribeColumns.COLUMN_SUBSCRIBE : "unsubscribe";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i2, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i2, bArr, th);
        LogUtils.d(TAG, "IMSetSubscriptionRequest onFailure :" + transErrorCode.first + " errmsg = " + ((String) transErrorCode.second));
        IMListener removeListener = ListenerManager.getInstance().removeListener(this.mKey);
        if (removeListener == null || !(removeListener instanceof ISetSubscriptionListener)) {
            return;
        }
        ((ISetSubscriptionListener) removeListener).onResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second);
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i2, byte[] bArr) {
        int i3;
        String str;
        String str2 = new String(bArr);
        LogUtils.d(TAG, "IMSetSubscriptionRequest onSuccess :" + str2);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            i3 = jSONObject.getInt("error_code");
            str = jSONObject.optString("error_msg", "");
        } catch (Exception e2) {
            LogUtils.e(TAG, "JSONException", e2);
            i3 = 1010;
            str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
        }
        IMListener removeListener = ListenerManager.getInstance().removeListener(this.mKey);
        if (removeListener == null || !(removeListener instanceof ISetSubscriptionListener)) {
            return;
        }
        ((ISetSubscriptionListener) removeListener).onResult(i3, str);
    }
}
