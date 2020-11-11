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
/* loaded from: classes18.dex */
public class IMPaSubscribedListMsg extends Message {
    private Context mContext;

    public IMPaSubscribedListMsg(Context context) {
        this.mContext = context;
        initCommonParameter(context);
        setNeedReplay(true);
        setType(104);
    }

    public static IMPaSubscribedListMsg newInstance(Context context, Intent intent) {
        return new IMPaSubscribedListMsg(context);
    }

    @Override // com.baidu.android.imsdk.request.Message
    protected void buildBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", 104);
            jSONObject.put("appid", this.mAppid);
            jSONObject.put("uk", this.mUk);
            this.mBody = jSONObject.toString();
        } catch (JSONException e) {
            LogUtils.e(LogUtils.TAG, "buildBody:", e);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:27:0x0001 */
    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i, String str) {
        List<PaInfo> list;
        Exception e;
        List<PaInfo> list2 = null;
        list2 = null;
        list2 = null;
        try {
        } catch (Exception e2) {
            list = list2;
            e = e2;
        }
        if (i == 0) {
            JSONArray optJSONArray = jSONObject.optJSONArray("pa_info_list");
            if (optJSONArray == null) {
                list = null;
            } else {
                list = new ArrayList<>();
                int i2 = 0;
                while (i2 < optJSONArray.length()) {
                    try {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
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
                        list.add(paInfo);
                        i2++;
                    } catch (Exception e3) {
                        e = e3;
                        LogUtils.e(LogUtils.TAG, "handleMessageResult:", e);
                        new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                        PaManagerImpl.getInstance(context).onQueryScribedPaListResult(getListenerKey(), i, str, list);
                    }
                }
                localSyncSubscribedPaList(context, list);
                list2 = i2;
            }
        } else if (1001 != i) {
            list = null;
            PaManagerImpl.getInstance(context).onQueryScribedPaListResult(getListenerKey(), i, str, list);
        } else {
            i = 0;
            str = "query from local db";
            list = PaInfoDBManager.getInstance(context).querySubscribedPaList();
        }
        PaManagerImpl.getInstance(context).onQueryScribedPaListResult(getListenerKey(), i, str, list);
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
            if (querySubscribedPaList != null) {
                for (PaInfo paInfo3 : querySubscribedPaList) {
                    PaInfoDBManager.getInstance(context).unSubscribePa(paInfo3.getPaId());
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                PaInfoDBManager.getInstance(context).subscribePa((PaInfo) it.next());
            }
        }
    }
}
