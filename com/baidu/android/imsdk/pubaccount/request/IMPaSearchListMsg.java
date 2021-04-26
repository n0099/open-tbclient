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
/* loaded from: classes.dex */
public class IMPaSearchListMsg extends Message {
    public Context mContext;
    public String mSearchContent;

    public IMPaSearchListMsg(Context context, String str) {
        this.mContext = context;
        initCommonParameter(context);
        this.mSearchContent = str;
        setNeedReplay(true);
        setType(103);
    }

    public static IMPaSearchListMsg newInstance(Context context, Intent intent) {
        if (intent.hasExtra(Constants.EXTRA_PA_SEARCH_CONTENT)) {
            return new IMPaSearchListMsg(context, intent.getStringExtra(Constants.EXTRA_PA_SEARCH_CONTENT));
        }
        return null;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void buildBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", 103);
            jSONObject.put("appid", this.mAppid);
            jSONObject.put("uk", this.mUk);
            jSONObject.put("content", this.mSearchContent);
            this.mBody = jSONObject.toString();
        } catch (JSONException e2) {
            LogUtils.e(LogUtils.TAG, "buildBody:", e2);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
        }
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i2, String str) {
        ArrayList arrayList;
        Exception e2;
        ArrayList arrayList2 = null;
        if (i2 == 0) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("pa_list");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    arrayList = new ArrayList();
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        try {
                            JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
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
                            e2 = e3;
                            LogUtils.e(LogUtils.TAG, "handleMessageResult:", e2);
                            new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e2)).build();
                            super.handleMessageResult(context, jSONObject, i2, str);
                            PaManagerImpl.getInstance(context).onSearchPaListResult(getListenerKey(), i2, str, arrayList);
                        }
                    }
                    arrayList2 = arrayList;
                }
            } catch (Exception e4) {
                arrayList = null;
                e2 = e4;
            }
        }
        arrayList = arrayList2;
        super.handleMessageResult(context, jSONObject, i2, str);
        PaManagerImpl.getInstance(context).onSearchPaListResult(getListenerKey(), i2, str, arrayList);
    }
}
