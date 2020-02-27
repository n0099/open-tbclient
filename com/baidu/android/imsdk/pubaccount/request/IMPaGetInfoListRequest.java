package com.baidu.android.imsdk.pubaccount.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.pubaccount.GetPaInfoSliceListener;
import com.baidu.android.imsdk.pubaccount.PaInfo;
import com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.sapi2.SapiContext;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class IMPaGetInfoListRequest extends PaBaseHttpRequest {
    private static final String TAG = IMPaGetInfoListRequest.class.getSimpleName();
    private long mAppid;
    private List<Long> mPaids;
    private long mUk;
    private GetPaInfoSliceListener sliceListener;

    public IMPaGetInfoListRequest(Context context, List<Long> list, long j, long j2, GetPaInfoSliceListener getPaInfoSliceListener) {
        this.mContext = context;
        this.mAppid = j;
        this.mUk = j2;
        this.mPaids = list;
        this.sliceListener = getPaInfoSliceListener;
    }

    @Override // com.baidu.android.imsdk.pubaccount.request.PaBaseHttpRequest, com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        if (getHostUrl() == null) {
            return null;
        }
        return getHostUrl() + "rest/3.0/im/box?method=all_pa_detail_list";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getMethod() {
        return "POST";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        String bduss = IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        Object md5 = getMd5("" + currentTimeMillis + bduss + this.mAppid);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", this.mAppid);
            jSONObject.put("uk", this.mUk);
            jSONObject.put("timestamp", currentTimeMillis);
            JSONArray jSONArray = new JSONArray();
            if (this.mPaids != null) {
                for (Long l : this.mPaids) {
                    if (l.longValue() > 0) {
                        jSONArray.put(l);
                    }
                }
            }
            jSONObject.put("pa_uids", jSONArray);
            jSONObject.put("is_https", true);
            jSONObject.put("sign", md5);
            jSONObject.put("account_type", AccountManagerImpl.getInstance(this.mContext).getLoginType());
            jSONObject.put("app_version", AccountManagerImpl.getInstance(this.mContext).getAppVersion());
            jSONObject.put(SapiContext.KEY_SDK_VERSION, IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
            jSONObject.put("device_type", 2);
            jSONObject.put("cuid", Utility.getDeviceId(this.mContext));
            if (AccountManager.isCuidLogin(this.mContext)) {
                jSONObject.put("token", AccountManager.getToken(this.mContext));
            }
        } catch (JSONException e) {
            LogUtils.e(TAG, "Exception ", e);
        }
        return jSONObject.toString().getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSuccess(int i, byte[] bArr) {
        ArrayList arrayList;
        JSONException e;
        int i2;
        String str;
        String str2 = new String(bArr);
        LogUtils.d(TAG, "FXF  json is " + str2);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            int i3 = jSONObject.getInt("error_code");
            String optString = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE, "");
            if (i3 != 0 || !jSONObject.has("response_params")) {
                arrayList = null;
            } else {
                JSONArray jSONArray = jSONObject.getJSONArray("response_params");
                arrayList = new ArrayList();
                for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                    try {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i4);
                        if (jSONObject2.optInt("pa_type") != 16) {
                            PaInfo paInfo = new PaInfo();
                            paInfo.setPaId(jSONObject2.optLong("pa_uid"));
                            paInfo.setNickName(jSONObject2.optString("pa_nickname"));
                            paInfo.setUsername(jSONObject2.optString("pa_username"));
                            paInfo.setAvatar(jSONObject2.optString("pa_avatar"));
                            paInfo.setDescription(jSONObject2.optString("description"));
                            paInfo.setDetail(jSONObject2.optString("detail_description"));
                            paInfo.setTPL(jSONObject2.optLong("tpl", -1L));
                            paInfo.setAcceptPush(jSONObject2.optBoolean("is_accept_msg"));
                            paInfo.setUrl(jSONObject2.optString("pa_url"));
                            paInfo.setSubcribeTime(jSONObject2.optLong("create_time"));
                            paInfo.setDisturb(jSONObject2.optInt("do_not_disturb"));
                            paInfo.setSubtype(jSONObject2.optInt("pa_type"));
                            paInfo.setClassType(jSONObject2.optInt("pa_classtype", 0));
                            paInfo.setClasstitle(jSONObject2.optString("pa_classtitle"));
                            paInfo.setClassAvatar(jSONObject2.optString("pa_classavatar"));
                            paInfo.setClassshow(jSONObject2.optInt("pa_classshow", 0));
                            paInfo.setStatus(jSONObject2.optInt("status", 0));
                            String optString2 = jSONObject2.optString(TableDefine.PaSubscribeColumns.COLUMN_PA_EXT, "");
                            paInfo.setPaExt(optString2);
                            if (!TextUtils.isEmpty(optString2)) {
                                try {
                                    paInfo.setSubsetType(new JSONObject(optString2).optInt("sub_pa_type", 0));
                                } catch (JSONException e2) {
                                    LogUtils.e(LogUtils.TAG, "IMPaGetInfoListRequest JSONException", e2);
                                }
                            }
                            paInfo.setVipId(jSONObject2.optString("vip"));
                            paInfo.setVPortrait(jSONObject2.optString("v_portrait", ""));
                            paInfo.setHasIdentity(jSONObject2.optInt(TableDefine.PaSubscribeColumns.COLUMN_HAS_IDENTITY, 0));
                            paInfo.setIdentity(jSONObject2.optString("identity", ""));
                            paInfo.setThirdExt(jSONObject2.optString(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT, ""));
                            PaInfo queryPaInfo = PaInfoDBManager.getInstance(this.mContext).queryPaInfo(paInfo.getPaId());
                            if (queryPaInfo != null) {
                                paInfo.setMarkTop(queryPaInfo.getMarkTop());
                                paInfo.setMarkTopTime(queryPaInfo.getMarkTopTime());
                                paInfo.setShield(queryPaInfo.getShield());
                                paInfo.setShieldTime(queryPaInfo.getShieldTime());
                            }
                            arrayList.add(paInfo);
                        }
                    } catch (JSONException e3) {
                        e = e3;
                        LogUtils.e(LogUtils.TAG, "IMGetZhidaInfoRequest JSONException", e);
                        i2 = 1010;
                        str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
                        if (this.sliceListener == null) {
                        }
                    }
                }
            }
            str = optString;
            i2 = i3;
        } catch (JSONException e4) {
            arrayList = null;
            e = e4;
        }
        if (this.sliceListener == null) {
            this.sliceListener.onResult(i2, str, arrayList);
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
        if (this.sliceListener != null) {
            this.sliceListener.onResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, null);
        }
    }
}
