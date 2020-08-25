package com.baidu.android.imsdk.pubaccount.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.pubaccount.IGetPaInfoListener;
import com.baidu.android.imsdk.pubaccount.PaInfo;
import com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.sapi2.SapiContext;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class IMPaGetOneInfoRequest extends PaBaseHttpRequest {
    private static final String TAG = "IMPaGetOneInfoRequest";
    private long mAppid;
    private String mKey;
    private ArrayList<Long> mPaids;
    private long mUk;

    public IMPaGetOneInfoRequest(Context context, String str, ArrayList<Long> arrayList, long j, long j2) {
        this.mContext = context;
        this.mAppid = j;
        this.mKey = str;
        this.mUk = j2;
        this.mPaids = arrayList;
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
                Iterator<Long> it = this.mPaids.iterator();
                while (it.hasNext()) {
                    Long next = it.next();
                    if (next.longValue() > 0) {
                        jSONArray.put(next);
                    }
                }
            }
            jSONObject.put("pa_uids", jSONArray);
            jSONObject.put("is_https", true);
            jSONObject.put("sign", md5);
            jSONObject.put("app_version", AccountManagerImpl.getInstance(this.mContext).getAppVersion());
            jSONObject.put(SapiContext.KEY_SDK_VERSION, IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
            jSONObject.put("cuid", Utility.getDeviceId(this.mContext));
            jSONObject.put(HttpConstants.DEVICE_TYPE, 2);
        } catch (JSONException e) {
            LogUtils.e(TAG, "Exception ", e);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
        }
        return jSONObject.toString().getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return HttpHelper.CONTENT_JSON;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSuccess(int i, byte[] bArr) {
        JSONException jSONException;
        ArrayList arrayList;
        int i2;
        String str;
        ArrayList arrayList2;
        IGetPaInfoListener iGetPaInfoListener;
        JSONObject jSONObject;
        ArrayList arrayList3;
        try {
            jSONObject = new JSONObject(new String(bArr));
            i2 = jSONObject.getInt("error_code");
            str = jSONObject.optString("error_msg", "");
        } catch (JSONException e) {
            jSONException = e;
            arrayList = null;
        }
        if (i2 == 0) {
            if (jSONObject.has("response_params")) {
                JSONArray jSONArray = jSONObject.getJSONArray("response_params");
                ArrayList arrayList4 = new ArrayList();
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    try {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
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
                            String optString = jSONObject2.optString(TableDefine.PaSubscribeColumns.COLUMN_PA_EXT, "");
                            paInfo.setPaExt(optString);
                            if (!TextUtils.isEmpty(optString)) {
                                try {
                                    paInfo.setSubsetType(new JSONObject(optString).optInt("sub_pa_type", 0));
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
                            arrayList4.add(paInfo);
                        }
                    } catch (JSONException e3) {
                        jSONException = e3;
                        arrayList = arrayList4;
                        LogUtils.e(LogUtils.TAG, "IMGetZhidaInfoRequest JSONException", jSONException);
                        new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(jSONException)).build();
                        i2 = 1010;
                        str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
                        arrayList2 = arrayList;
                        iGetPaInfoListener = (IGetPaInfoListener) ListenerManager.getInstance().removeListener(this.mKey);
                        if (iGetPaInfoListener != null) {
                        }
                    }
                }
                Iterator it = arrayList4.iterator();
                while (it.hasNext()) {
                    PaInfoDBManager.getInstance(this.mContext).subscribePa((PaInfo) it.next());
                }
                arrayList3 = arrayList4;
                arrayList2 = arrayList3;
                iGetPaInfoListener = (IGetPaInfoListener) ListenerManager.getInstance().removeListener(this.mKey);
                if (iGetPaInfoListener != null) {
                    PaInfo paInfo2 = (arrayList2 == null || arrayList2.size() <= 0) ? null : (PaInfo) arrayList2.get(0);
                    if (paInfo2 != null) {
                        iGetPaInfoListener.onGetPaInfoResult(i2, str, PaInfoDBManager.getInstance(this.mContext).queryPaInfo(paInfo2.getPaId()));
                        return;
                    } else {
                        onRequestReturn(Integer.valueOf(i2), str, iGetPaInfoListener);
                        return;
                    }
                }
                return;
            }
        } else {
            LogUtils.e(TAG, "error code :" + i2 + "===errorMsg:" + str);
        }
        arrayList3 = null;
        arrayList2 = arrayList3;
        iGetPaInfoListener = (IGetPaInfoListener) ListenerManager.getInstance().removeListener(this.mKey);
        if (iGetPaInfoListener != null) {
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
        onRequestReturn((Integer) transErrorCode.first, (String) transErrorCode.second, (IGetPaInfoListener) ListenerManager.getInstance().removeListener(this.mKey));
    }

    private void onRequestReturn(Integer num, String str, IGetPaInfoListener iGetPaInfoListener) {
        if (this.mPaids != null && this.mPaids.size() > 0) {
            PaInfo queryPaInfo = PaInfoDBManager.getInstance(this.mContext).queryPaInfo(this.mPaids.get(0).longValue());
            if (iGetPaInfoListener != null) {
                if (queryPaInfo != null) {
                    iGetPaInfoListener.onGetPaInfoResult(0, Constants.ERROR_MSG_SUCCESS, queryPaInfo);
                } else {
                    iGetPaInfoListener.onGetPaInfoResult(num.intValue(), str, null);
                }
            }
        }
    }
}
