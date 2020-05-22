package com.baidu.android.imsdk.chatuser.request;

import android.content.Context;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.chatuser.ChatUser;
import com.baidu.android.imsdk.chatuser.IGetUserIdentityListener;
import com.baidu.android.imsdk.chatuser.db.ChatUserDBManager;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.IMConfigInternal;
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
public class IMGetUserIdentityRequest extends IMUserBaseHttpRequest {
    public static final String TAG = "IMGetUserIdentityRequest";
    private List<Long> mBduids = new ArrayList();
    private IGetUserIdentityListener mListener;

    public IMGetUserIdentityRequest(Context context, List<Long> list, IGetUserIdentityListener iGetUserIdentityListener) {
        this.mBduids.addAll(list);
        this.mContext = context;
        this.mListener = iGetUserIdentityListener;
    }

    @Override // com.baidu.android.imsdk.chatuser.request.IMUserBaseHttpRequest, com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        if (getHostUrl() == null) {
            return null;
        }
        return getHostUrl() + "rest/3.0/im/get_user_info";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        String md5 = getMd5("" + IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext) + currentTimeMillis);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_version", AccountManagerImpl.getInstance(this.mContext).getAppVersion());
            jSONObject.put(SapiContext.KEY_SDK_VERSION, IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
            jSONObject.put("cuid", Utility.getDeviceId(this.mContext));
            jSONObject.put(HttpConstants.DEVICE_TYPE, 2);
            jSONObject.put("appid", AccountManager.getAppid(this.mContext));
            jSONObject.put("timestamp", currentTimeMillis);
            jSONObject.put("sign", md5);
            JSONArray jSONArray = new JSONArray();
            if (this.mBduids != null && this.mBduids.size() > 0) {
                for (Long l : this.mBduids) {
                    long longValue = l.longValue();
                    if (longValue > 0) {
                        jSONArray.put(longValue);
                    }
                }
            }
            jSONObject.put("bd_uids", jSONArray);
        } catch (JSONException e) {
            LogUtils.e(TAG, "Exception ", e);
        }
        return jSONObject.toString().getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return HttpHelper.CONTENT_JSON;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        if (this.mListener != null) {
            this.mListener.onGetUserIdentityResult(i, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSuccess(int i, byte[] bArr) {
        JSONException jSONException;
        int i2;
        ArrayList arrayList;
        JSONArray optJSONArray;
        String str = new String(bArr);
        LogUtils.d(TAG, "onSuccess content = " + str);
        ArrayList arrayList2 = null;
        int i3 = 0;
        try {
            JSONObject jSONObject = new JSONObject(str);
            i3 = jSONObject.optInt("error_code");
            if (i3 != 0 || (optJSONArray = jSONObject.optJSONArray("user_list")) == null || optJSONArray.length() <= 0) {
                arrayList = null;
            } else {
                arrayList = new ArrayList();
                int i4 = 0;
                while (true) {
                    try {
                        int i5 = i4;
                        if (i5 >= optJSONArray.length()) {
                            break;
                        }
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i5);
                        long optLong = jSONObject2.optLong("bd_uid");
                        long optLong2 = jSONObject2.optLong("uk", 0L);
                        String optString = jSONObject2.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
                        String optString2 = jSONObject2.optString("display_name");
                        jSONObject2.optString("vip");
                        String optString3 = jSONObject2.optString("v_portrait");
                        String optString4 = jSONObject2.optString("identity");
                        int optInt = jSONObject2.optInt("relation_follow");
                        int optInt2 = jSONObject2.optInt("relation_phone");
                        int optInt3 = jSONObject2.optInt(TableDefine.UserInfoColumns.COLUMN_HAS_SPECIAL_IDENTITY);
                        String optString5 = jSONObject2.optString(TableDefine.UserInfoColumns.COLUMN_SPECIAL_IDENTITY);
                        ChatUser chatUser = new ChatUser(optLong2, optLong, optString2, optString);
                        chatUser.setVipId(jSONObject2.optString("vip"));
                        chatUser.setIdentity(optString4);
                        chatUser.setSubscribe(optInt);
                        chatUser.setPhoneRelation(optInt2);
                        chatUser.setHasSpecialIdentity(optInt3);
                        chatUser.setSpecialIdentity(optString5);
                        chatUser.setVPortrait(optString3);
                        chatUser.setUserExt(jSONObject2.optString(TableDefine.UserInfoColumns.COLUMN_USER_EXT, ""));
                        ChatUser chatUser2 = ChatUserDBManager.getInstance(this.mContext).getChatUser(optLong2);
                        if (chatUser2 != null) {
                            chatUser.setMarkTop(chatUser2.getMarkTop());
                            chatUser.setMarkTopTime(chatUser2.getMarkTopTime());
                            chatUser.setShield(chatUser2.getShield());
                            chatUser.setShieldTime(chatUser2.getShieldTime());
                        }
                        arrayList.add(chatUser);
                        i4 = i5 + 1;
                    } catch (JSONException e) {
                        jSONException = e;
                        arrayList2 = arrayList;
                        i2 = i3;
                        LogUtils.e(TAG, "Exception ", jSONException);
                        if (this.mListener == null) {
                        }
                    }
                }
            }
            arrayList2 = arrayList;
            i2 = i3;
        } catch (JSONException e2) {
            jSONException = e2;
            i2 = i3;
        }
        if (this.mListener == null) {
            this.mListener.onGetUserIdentityResult(i2, arrayList2);
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getMethod() {
        return "POST";
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return false;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public int getConnectTimeout() {
        return 5000;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public int getReadTimeout() {
        return 5000;
    }
}
