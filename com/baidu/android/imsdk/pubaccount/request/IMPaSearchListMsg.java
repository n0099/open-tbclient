package com.baidu.android.imsdk.pubaccount.request;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.pubaccount.PaInfo;
import com.baidu.android.imsdk.pubaccount.PaManagerImpl;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class IMPaSearchListMsg extends Message {
    private Context mContext;
    private String mSearchContent;

    public IMPaSearchListMsg(Context context, String str) {
        this.mContext = context;
        initCommonParameter(context);
        this.mSearchContent = str;
        setNeedReplay(true);
        setType(103);
    }

    @Override // com.baidu.android.imsdk.request.Message
    protected void buildBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", 103);
            jSONObject.put("appid", this.mAppid);
            jSONObject.put("uk", this.mUk);
            jSONObject.put("content", this.mSearchContent);
            this.mBody = jSONObject.toString();
        } catch (JSONException e) {
            LogUtils.e(LogUtils.TAG, "buildBody:", e);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
        }
    }

    public static IMPaSearchListMsg newInstance(Context context, Intent intent) {
        if (intent.hasExtra(Constants.EXTRA_PA_SEARCH_CONTENT)) {
            return new IMPaSearchListMsg(context, intent.getStringExtra(Constants.EXTRA_PA_SEARCH_CONTENT));
        }
        return null;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i, String str) throws JSONException {
        ArrayList arrayList;
        Exception e;
        JSONArray optJSONArray;
        if (i == 0) {
            try {
                optJSONArray = jSONObject.optJSONArray("pa_list");
            } catch (Exception e2) {
                arrayList = null;
                e = e2;
            }
            if (optJSONArray != null && optJSONArray.length() > 0) {
                arrayList = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    try {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                        PaInfo paInfo = new PaInfo();
                        paInfo.setPaId(jSONObject2.optLong("pa_uid"));
                        paInfo.setNickName(jSONObject2.optString("pa_nickname"));
                        paInfo.setAvatar(jSONObject2.optString("pa_avatar"));
                        paInfo.setDescription("");
                        paInfo.setUrl(jSONObject2.optString("pa_url"));
                        paInfo.setAcceptPush(true);
                        paInfo.setStatus(jSONObject2.optInt("status"));
                        arrayList.add(paInfo);
                    } catch (Exception e3) {
                        e = e3;
                        LogUtils.e(LogUtils.TAG, "handleMessageResult:", e);
                        new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e)).build();
                        PaManagerImpl.getInstance(context).onSearchPaListResult(getListenerKey(), i, str, arrayList);
                    }
                }
                PaManagerImpl.getInstance(context).onSearchPaListResult(getListenerKey(), i, str, arrayList);
            }
        }
        arrayList = null;
        PaManagerImpl.getInstance(context).onSearchPaListResult(getListenerKey(), i, str, arrayList);
    }
}
