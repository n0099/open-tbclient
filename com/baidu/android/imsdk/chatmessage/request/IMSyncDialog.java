package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl;
import com.baidu.android.imsdk.chatmessage.sync.DialogRecord;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMSyncDialog extends Message {
    public static final String TAG = IMDelMsg.class.getSimpleName();
    public Context mContext;
    public long mMaxMsgid;

    public IMSyncDialog(Context context, long j) {
        this.mMaxMsgid = 0L;
        this.mContext = context;
        initCommonParameter(context);
        setNeedReplay(true);
        setType(94);
        this.mMaxMsgid = j;
    }

    public static IMSyncDialog newInstance(Context context, Intent intent) {
        return new IMSyncDialog(context, intent.getLongExtra(Constants.EXTRA_CLIENT_MAX_MSGID, 0L));
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void buildBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", 94);
            jSONObject.put("appid", this.mAppid);
            jSONObject.put("uk", this.mUk);
            jSONObject.put("msgid", this.mMaxMsgid);
            this.mBody = jSONObject.toString();
        } catch (JSONException e2) {
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
            LogUtils.e(TAG, e2.getMessage(), e2);
        }
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i2, String str) {
        ArrayList arrayList = new ArrayList();
        long j = -1;
        if (i2 == 0 && jSONObject != null) {
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("dialogue");
                int length = jSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                    long j2 = jSONObject2.getLong("contacter");
                    int i4 = jSONObject2.getInt("category");
                    long j3 = jSONObject2.getJSONObject(TableDefine.SessionColumns.COLUMN_LAST_MSG).getLong("msgid");
                    DialogRecord dialogRecord = new DialogRecord();
                    dialogRecord.setCategory(i4);
                    dialogRecord.setContacter(j2);
                    dialogRecord.setDialogueMsgid(j3);
                    arrayList.add(dialogRecord);
                    if (j < j3) {
                        j = j3;
                    }
                }
            } catch (Exception e2) {
                LogUtils.e(TAG, "handle IMSyncMsg exception :", e2);
            }
        }
        super.handleMessageResult(context, jSONObject, i2, str);
        ChatSessionManagerImpl.getInstance(this.mContext).onSyncDialogResult(i2, str, getListenerKey(), j, arrayList);
    }
}
