package com.baidu.android.imsdk.group.request;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMQueryMemberPauidRequest extends FansGroupBaseHttpRequest {
    public static final String TAG = "IMQueryMemberPauidRequest";
    public String mKey;
    public List<Long> mUids;

    /* loaded from: classes.dex */
    public static class UserId {
        public long mBduid;
        public long mPauid;
        public long mUk;

        public UserId(long j, long j2, long j3) {
            this.mBduid = 0L;
            this.mPauid = 0L;
            this.mUk = 0L;
            this.mBduid = j;
            this.mPauid = j2;
            this.mUk = j3;
        }

        public long getBduid() {
            return this.mBduid;
        }

        public long getPauid() {
            return this.mPauid;
        }

        public long getUk() {
            return this.mUk;
        }
    }

    public IMQueryMemberPauidRequest(Context context, List<Long> list, String str) {
        this.mContext = context;
        this.mUids = list;
        this.mKey = str;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return "application/x-www-form-urlencoded";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        StringBuilder sb = new StringBuilder();
        sb.append("method=get_user_ids");
        JSONArray jSONArray = new JSONArray();
        List<Long> list = this.mUids;
        if (list != null && list.size() > 0) {
            for (Long l : this.mUids) {
                jSONArray.put(Utility.transBDUID(String.valueOf(l.longValue())));
            }
        }
        sb.append("&members=");
        sb.append(jSONArray.toString());
        sb.append(getCommonParams());
        return sb.toString().getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i2, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i2, bArr, th);
        IMListener removeListener = ListenerManager.getInstance().removeListener(this.mKey);
        if (removeListener instanceof BIMValueCallBack) {
            ((BIMValueCallBack) removeListener).onResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, null);
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i2, byte[] bArr) {
        String str;
        int i3;
        String str2 = new String(bArr);
        LogUtils.d(TAG, "json is " + str2);
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str2);
            i3 = jSONObject.getInt("error_code");
            str = jSONObject.optString("error_msg", "");
            JSONArray optJSONArray = jSONObject.optJSONObject("response_params").optJSONArray("members");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i4);
                    arrayList.add(new UserId(jSONObject2.getLong("bduid"), jSONObject2.getLong("pauid"), jSONObject2.getLong("uk")));
                }
            }
        } catch (JSONException e2) {
            LogUtils.e(LogUtils.TAG, "IMQueryMemberPauidRequest JSONException", e2);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
            str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
            i3 = 1010;
        }
        IMListener removeListener = ListenerManager.getInstance().removeListener(this.mKey);
        if (removeListener instanceof BIMValueCallBack) {
            ((BIMValueCallBack) removeListener).onResult(i3, str, arrayList);
        }
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return false;
    }
}
