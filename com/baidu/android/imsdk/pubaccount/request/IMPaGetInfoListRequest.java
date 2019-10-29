package com.baidu.android.imsdk.pubaccount.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.pubaccount.IGetPaInfosListener;
import com.baidu.android.imsdk.pubaccount.PaInfo;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.pushservice.PushConstants;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class IMPaGetInfoListRequest extends PaBaseHttpRequest {
    private static final String TAG = IMPaGetInfoListRequest.class.getSimpleName();
    private long mAppid;
    private String mKey;
    private ArrayList<Long> mPaids;
    private long mUk;

    public IMPaGetInfoListRequest(Context context, String str, ArrayList<Long> arrayList, long j, long j2) {
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
        String md5 = getMd5("" + currentTimeMillis + bduss + this.mAppid);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", this.mAppid);
            jSONObject.put("uk", this.mUk);
            jSONObject.put("timestamp", currentTimeMillis);
            JSONArray jSONArray = new JSONArray();
            if (this.mPaids != null) {
                Iterator<Long> it = this.mPaids.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
            }
            jSONObject.put("pa_uids", jSONArray);
            jSONObject.put("is_https", true);
            jSONObject.put("sign", md5);
            jSONObject.put("account_type", AccountManagerImpl.getInstance(this.mContext).getLoginType());
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

    /* JADX WARN: Removed duplicated region for block: B:22:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSuccess(int i, byte[] bArr) {
        ArrayList<PaInfo> arrayList;
        JSONException e;
        int i2;
        String str;
        ArrayList<PaInfo> arrayList2;
        IGetPaInfosListener iGetPaInfosListener;
        String str2 = new String(bArr);
        LogUtils.d(TAG, "FXF  json is " + str2);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            i2 = jSONObject.getInt("error_code");
            str = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE, "");
            if (i2 != 0 || !jSONObject.has("response_params")) {
                arrayList = null;
            } else {
                JSONArray jSONArray = jSONObject.getJSONArray("response_params");
                arrayList = new ArrayList<>();
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
                            paInfo.setTPL(jSONObject2.optLong(TableDefine.PaSubscribeColumns.COLUMN_TPL, -1L));
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
                            paInfo.setMarkTopTime(jSONObject2.optLong("upmark_time"));
                            paInfo.setMarkTop(jSONObject2.optInt("is_upmark", 0));
                            String optString = jSONObject2.optString(TableDefine.PaSubscribeColumns.COLUMN_PA_EXT, "");
                            paInfo.setPaExt(optString);
                            if (!TextUtils.isEmpty(optString)) {
                                try {
                                    paInfo.setSubsetType(new JSONObject(optString).optInt("sub_pa_type", 0));
                                } catch (JSONException e2) {
                                    LogUtils.e(LogUtils.TAG, "IMPaGetInfoListRequest JSONException", e2);
                                }
                            }
                            arrayList.add(paInfo);
                        }
                    } catch (JSONException e3) {
                        e = e3;
                        LogUtils.e(LogUtils.TAG, "IMGetZhidaInfoRequest JSONException", e);
                        i2 = 1010;
                        str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
                        arrayList2 = arrayList;
                        iGetPaInfosListener = (IGetPaInfosListener) ListenerManager.getInstance().removeListener(this.mKey);
                        if (iGetPaInfosListener == null) {
                        }
                    }
                }
            }
            arrayList2 = arrayList;
        } catch (JSONException e4) {
            arrayList = null;
            e = e4;
        }
        iGetPaInfosListener = (IGetPaInfosListener) ListenerManager.getInstance().removeListener(this.mKey);
        if (iGetPaInfosListener == null) {
            iGetPaInfosListener.onResult(i2, str, arrayList2);
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
        IGetPaInfosListener iGetPaInfosListener = (IGetPaInfosListener) ListenerManager.getInstance().removeListener(this.mKey);
        if (iGetPaInfosListener != null) {
            iGetPaInfosListener.onResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, null);
        }
    }
}
