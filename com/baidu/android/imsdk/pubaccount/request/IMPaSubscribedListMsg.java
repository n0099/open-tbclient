package com.baidu.android.imsdk.pubaccount.request;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.baidu.android.imsdk.pubaccount.PaInfo;
import com.baidu.android.imsdk.pubaccount.PaManagerImpl;
import com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMPaSubscribedListMsg extends Message {
    public Context mContext;

    public IMPaSubscribedListMsg(Context context) {
        this.mContext = context;
        initCommonParameter(context);
        setNeedReplay(true);
        setType(104);
    }

    private void localSyncSubscribedPaList(Context context, List<PaInfo> list) {
        if (list == null) {
            return;
        }
        if (list.size() == 0) {
            PaInfoDBManager.getInstance(context).deleteAllSubscribedPa();
            return;
        }
        List<PaInfo> querySubscribedPaList = PaInfoDBManager.getInstance(context).querySubscribedPaList();
        ArrayList arrayList = new ArrayList();
        for (PaInfo paInfo : list) {
            boolean z = false;
            if (querySubscribedPaList != null) {
                Iterator<PaInfo> it = querySubscribedPaList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PaInfo next = it.next();
                    if (paInfo.getPaId() == next.getPaId()) {
                        querySubscribedPaList.remove(next);
                        PaInfoDBManager.getInstance(context).acceptPaPush(paInfo.getPaId(), paInfo.isAcceptPush());
                        z = true;
                        break;
                    }
                }
            }
            if (!z) {
                arrayList.add(paInfo);
            }
        }
        if (querySubscribedPaList != null) {
            for (PaInfo paInfo2 : querySubscribedPaList) {
                PaInfoDBManager.getInstance(context).unSubscribePa(paInfo2.getPaId());
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            PaInfoDBManager.getInstance(context).subscribePa((PaInfo) it2.next());
        }
    }

    public static IMPaSubscribedListMsg newInstance(Context context, Intent intent) {
        return new IMPaSubscribedListMsg(context);
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void buildBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", 104);
            jSONObject.put("appid", this.mAppid);
            jSONObject.put("uk", this.mUk);
            this.mBody = jSONObject.toString();
        } catch (JSONException e2) {
            LogUtils.e(LogUtils.TAG, "buildBody:", e2);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
        }
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i2, String str) {
        List<PaInfo> list = null;
        if (i2 == 0) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("pa_info_list");
                if (optJSONArray != null) {
                    ArrayList arrayList = new ArrayList();
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        try {
                            JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                            long optLong = jSONObject2.optLong("pa_uid");
                            String optString = jSONObject2.optString("pa_nickname");
                            String optString2 = jSONObject2.optString("pa_avatar");
                            boolean optBoolean = jSONObject2.optBoolean("is_accept_msg");
                            String optString3 = jSONObject2.optString("pa_url");
                            PaInfo paInfo = new PaInfo();
                            paInfo.setPaId(optLong);
                            paInfo.setNickName(optString);
                            paInfo.setAvatar(optString2);
                            paInfo.setAcceptPush(optBoolean);
                            paInfo.setUrl(optString3);
                            paInfo.setDetail(jSONObject2.optString("detail_description"));
                            paInfo.setTPL(jSONObject2.optLong("tpl", -1L));
                            paInfo.setStatus(jSONObject2.optInt("status"));
                            arrayList.add(paInfo);
                        } catch (Exception e2) {
                            e = e2;
                            list = arrayList;
                            LogUtils.e(LogUtils.TAG, "handleMessageResult:", e);
                            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                            super.handleMessageResult(context, jSONObject, i2, str);
                            PaManagerImpl.getInstance(context).onQueryScribedPaListResult(getListenerKey(), i2, str, list);
                        }
                    }
                    localSyncSubscribedPaList(context, arrayList);
                    list = arrayList;
                }
            } catch (Exception e3) {
                e = e3;
            }
        } else if (1001 == i2) {
            try {
                str = "query from local db";
                list = PaInfoDBManager.getInstance(context).querySubscribedPaList();
                i2 = 0;
            } catch (Exception e4) {
                e = e4;
                i2 = 0;
                LogUtils.e(LogUtils.TAG, "handleMessageResult:", e);
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                super.handleMessageResult(context, jSONObject, i2, str);
                PaManagerImpl.getInstance(context).onQueryScribedPaListResult(getListenerKey(), i2, str, list);
            }
        }
        super.handleMessageResult(context, jSONObject, i2, str);
        PaManagerImpl.getInstance(context).onQueryScribedPaListResult(getListenerKey(), i2, str, list);
    }
}
