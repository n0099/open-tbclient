package com.baidu.android.imsdk.pubaccount.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.pubaccount.PaInfo;
import com.baidu.android.imsdk.pubaccount.PaManagerImpl;
import com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.pushservice.PushConstants;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class IMPaGetInfoRequest extends PaBaseHttpRequest {
    private static final String TAG = IMPaGetInfoRequest.class.getSimpleName();
    private long mAppid;
    private String mKey;
    private long mUk;

    public IMPaGetInfoRequest(Context context, String str, long j, long j2) {
        this.mContext = context;
        this.mAppid = j;
        this.mKey = str;
        this.mUk = j2;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        String bduss = IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        StringBuilder sb = new StringBuilder();
        sb.append("method=pa_detail_list");
        sb.append("&appid=").append(this.mAppid);
        sb.append("&timestamp=").append(currentTimeMillis);
        sb.append("&uk=").append(this.mUk);
        sb.append("&sdk_version=").append(IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
        sb.append("&sign=").append(getMd5("" + currentTimeMillis + bduss + this.mAppid));
        sb.append("&is_https=").append(true);
        sb.append("&account_type=").append(AccountManagerImpl.getInstance(this.mContext).getLoginType());
        if (AccountManager.isCuidLogin(this.mContext)) {
            sb.append("&token");
            sb.append(AccountManager.getToken(this.mContext));
        }
        return sb.toString().getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return false;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        JSONException jSONException;
        List<PaInfo> list;
        int i2;
        String str;
        String str2 = new String(bArr);
        LogUtils.d(TAG, "FXF  json is " + str2);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            int i3 = jSONObject.getInt("error_code");
            String optString = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE, "");
            if (i3 == 0) {
                if (!jSONObject.has("response_params")) {
                    list = null;
                    str = optString;
                } else {
                    JSONArray jSONArray = jSONObject.getJSONArray("response_params");
                    list = new ArrayList<>();
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
                                paInfo.setSubtype(jSONObject2.optInt("pa_type"));
                                paInfo.setClassType(jSONObject2.optInt("pa_classtype", 0));
                                paInfo.setClasstitle(jSONObject2.optString("pa_classtitle"));
                                paInfo.setClassAvatar(jSONObject2.optString("pa_classavatar"));
                                paInfo.setClassshow(jSONObject2.optInt("pa_classshow", 0));
                                paInfo.setStatus(jSONObject2.optInt("status", 0));
                                paInfo.setMarkTopTime(jSONObject2.optLong("upmark_time"));
                                paInfo.setMarkTop(jSONObject2.optInt("is_upmark", 0));
                                String optString2 = jSONObject2.optString(TableDefine.PaSubscribeColumns.COLUMN_PA_EXT, "");
                                paInfo.setPaExt(optString2);
                                if (!TextUtils.isEmpty(optString2)) {
                                    try {
                                        paInfo.setSubsetType(new JSONObject(optString2).optInt("sub_pa_type", 0));
                                    } catch (JSONException e) {
                                        LogUtils.e(LogUtils.TAG, "IMPaGetInfoListRequest JSONException", e);
                                    }
                                }
                                list.add(paInfo);
                            }
                        } catch (JSONException e2) {
                            jSONException = e2;
                            LogUtils.e(LogUtils.TAG, "IMGetZhidaInfoRequest JSONException", jSONException);
                            i2 = 1010;
                            str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
                            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(jSONException)).build();
                            PaManagerImpl.getInstance(this.mContext).onQueryScribedPaListResult(this.mKey, i2, str, list);
                        }
                    }
                    localSyncSubscribedPaList(this.mContext, list);
                    str = optString;
                }
            } else {
                list = PaInfoDBManager.getInstance(this.mContext).querySubscribedPaList();
                str = "query from local db";
            }
            i2 = i3;
        } catch (JSONException e3) {
            jSONException = e3;
            list = null;
        }
        PaManagerImpl.getInstance(this.mContext).onQueryScribedPaListResult(this.mKey, i2, str, list);
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
        PaManagerImpl.getInstance(this.mContext).onQueryScribedPaListResult(this.mKey, ((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, null);
    }

    private void localSyncSubscribedPaList(Context context, List<PaInfo> list) {
        boolean z;
        if (list != null) {
            if (list.size() == 0) {
                PaInfoDBManager.getInstance(context).deleteAllSubscribedPa();
                return;
            }
            List<PaInfo> querySubscribedPaList = PaInfoDBManager.getInstance(context).querySubscribedPaList();
            ArrayList arrayList = new ArrayList();
            for (PaInfo paInfo : list) {
                if (querySubscribedPaList != null) {
                    for (PaInfo paInfo2 : querySubscribedPaList) {
                        if (paInfo.getPaId() == paInfo2.getPaId()) {
                            querySubscribedPaList.remove(paInfo2);
                            PaInfoDBManager.getInstance(context).acceptPaPush(paInfo.getPaId(), paInfo.isAcceptPush());
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                if (!z) {
                    arrayList.add(paInfo);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                PaInfo paInfo3 = (PaInfo) it.next();
                LogUtils.d(TAG, "FXF  add to db " + paInfo3.toString());
                PaInfoDBManager.getInstance(context).subscribePa(paInfo3);
            }
        }
    }
}
