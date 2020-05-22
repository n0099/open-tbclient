package com.baidu.android.imsdk.shield.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.shield.IGetDisturbListListener;
import com.baidu.android.imsdk.shield.ShieldAndTopManager;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.sapi2.SapiContext;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class IMGetShieldAndTopListRequest extends IMSettingBaseHttpRequest {
    private static final String TAG = "IMGetShieldAndTopListRequest";
    private int mFilterType;
    private String mKey;
    private int mSubBusiness;

    public IMGetShieldAndTopListRequest(Context context, String str, int i, int i2) {
        this.mContext = context;
        this.mKey = str;
        this.mSubBusiness = i;
        this.mFilterType = i2;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        try {
            long appid = AccountManager.getAppid(this.mContext);
            long uk = AccountManager.getUK(this.mContext);
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appid", appid);
            jSONObject.put("cuid", Utility.getDeviceId(this.mContext));
            jSONObject.put("app_version", Utility.getAppVersionName(this.mContext));
            jSONObject.put(SapiContext.KEY_SDK_VERSION, "" + IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
            jSONObject.put(HttpConstants.DEVICE_TYPE, 2);
            jSONObject.put("uk", uk);
            jSONObject.put("sub_business", this.mSubBusiness);
            jSONObject.put("timestamp", currentTimeMillis);
            jSONObject.put("business_filter", this.mFilterType);
            jSONObject.put("sign", getMd5("" + currentTimeMillis + uk + appid));
            LogUtils.d(TAG, "IMGetShieldAndTopListRequest msg :" + jSONObject.toString());
            return jSONObject.toString().getBytes();
        } catch (Exception e) {
            return null;
        }
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return HttpHelper.CONTENT_JSON;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        int i2;
        String str;
        String str2 = new String(bArr);
        LogUtils.d(TAG, "IMGetShieldAndTopListRequest onSuccess :" + str2);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str2);
            i2 = jSONObject.getInt("error_code");
            str = jSONObject.optString("error_msg", "");
            JSONArray optJSONArray = jSONObject.optJSONArray("uks");
            if (optJSONArray != null) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    generateUser(arrayList, (JSONObject) optJSONArray.opt(i3), 0, i3);
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("pa_uids");
            if (optJSONArray2 != null) {
                for (int i4 = 0; i4 < optJSONArray2.length(); i4++) {
                    generateUser(arrayList2, (JSONObject) optJSONArray2.opt(i4), 1, i4);
                }
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("group_ids");
            if (optJSONArray3 != null) {
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    if (i6 >= optJSONArray3.length()) {
                        break;
                    }
                    generateUser(arrayList3, (JSONObject) optJSONArray3.opt(i6), 2, i6);
                    i5 = i6 + 1;
                }
            }
        } catch (JSONException e) {
            LogUtils.e(TAG, "JSONException", e);
            i2 = 1010;
            str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
        }
        LogUtils.e(TAG, "mSubBusiness :" + this.mSubBusiness + ", user :" + arrayList.size() + ", Pa :" + arrayList2.size() + ", mFilterType :" + this.mFilterType);
        if (this.mSubBusiness == 1) {
            if (this.mFilterType == 1 || this.mFilterType == 0) {
                ShieldAndTopManager.getInstance(this.mContext).onMsgShieldListResult(i2, str, arrayList, arrayList2, this.mKey);
            } else if (this.mFilterType == 2) {
                ShieldAndTopManager.getInstance(this.mContext).onNotifyShieldListResult(i2, str, arrayList2, this.mKey);
            }
        } else if (this.mSubBusiness == 2) {
            if (this.mFilterType == 1) {
                ShieldAndTopManager.getInstance(this.mContext).onMsgMarkTopListResult(i2, str, arrayList, arrayList2);
            }
        } else if (this.mSubBusiness == 3 && this.mFilterType == 1 && !TextUtils.isEmpty(this.mKey)) {
            ((IGetDisturbListListener) ListenerManager.getInstance().removeListener(this.mKey)).onDisturbList(i, str, str2);
        }
    }

    private void generateUser(List<ChatSession> list, JSONObject jSONObject, int i, int i2) {
        ChatSession chatSession = new ChatSession();
        chatSession.setContacter(jSONObject.optLong("uk", -1L));
        long optLong = jSONObject.optLong("timestamp", -1L);
        if (this.mSubBusiness == 2) {
            chatSession.setMarkTopTime(optLong);
            chatSession.setMarkTop(1);
        } else if (this.mSubBusiness == 1) {
            chatSession.setShieldTime(optLong);
            chatSession.setShield(1);
        } else if (this.mSubBusiness == 3) {
            LogUtils.d(TAG, "generateUser mSubBusiness = 3");
        }
        chatSession.setChatType(i);
        list.add(chatSession);
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
        LogUtils.d(TAG, "IMGetShieldAndTopListRequest onFailure :" + transErrorCode.first);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (this.mSubBusiness == 1) {
            if (this.mFilterType == 1 || this.mFilterType == 0) {
                ShieldAndTopManager.getInstance(this.mContext).onMsgShieldListResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, arrayList, arrayList2, this.mKey);
            } else if (this.mFilterType == 2) {
                ShieldAndTopManager.getInstance(this.mContext).onNotifyShieldListResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, arrayList2, this.mKey);
            }
        } else if (this.mSubBusiness == 2) {
            if (this.mFilterType == 1) {
                ShieldAndTopManager.getInstance(this.mContext).onMsgMarkTopListResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, arrayList, arrayList2);
            }
        } else if (this.mSubBusiness == 3 && this.mFilterType == 1 && !TextUtils.isEmpty(this.mKey)) {
            ((IGetDisturbListListener) ListenerManager.getInstance().removeListener(this.mKey)).onDisturbList(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, bArr == null ? null : new String(bArr));
        }
    }

    @Override // com.baidu.android.imsdk.shield.request.IMSettingBaseHttpRequest
    public String getHostUrlParam() {
        return "get_subbusiness_contacter_list";
    }
}
