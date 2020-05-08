package com.baidu.android.imsdk.group.request;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.db.DBGroupTableManager;
import com.baidu.android.imsdk.db.DBOperation;
import com.baidu.android.imsdk.db.DBOperationFactory;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.group.GroupInfoSyncManagerImpl;
import com.baidu.android.imsdk.group.db.GroupInfoDAOImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class IMQueryGroupListRequest extends GroupBaseHttpRequest {
    private static final String TAG = IMQueryGroupListRequest.class.getSimpleName();
    private long mAppid;
    private String mBuid;
    private String mKey;

    /* loaded from: classes3.dex */
    class Mytask extends TaskManager.Task {
        public Mytask(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.android.imsdk.task.TaskManager.Task, java.lang.Runnable
        public void run() {
            int i;
            String str;
            ArrayList arrayList = new ArrayList();
            try {
                JSONObject jSONObject = new JSONObject(this.mJson);
                i = jSONObject.getInt("error_code");
                str = jSONObject.optString("error_msg", "");
                if (i == 0 && jSONObject.has("response_params")) {
                    JSONArray jSONArray = jSONObject.getJSONObject("response_params").getJSONArray("groups");
                    DBOperation newDb = DBOperationFactory.getNewDb(IMQueryGroupListRequest.this.mContext);
                    if (newDb != null) {
                        DBGroupTableManager dBGroupTableManager = (DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY);
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            String valueOf = String.valueOf(Long.valueOf(jSONArray.optLong(i2)));
                            arrayList.add(valueOf);
                            if (!dBGroupTableManager.isExistGroupTable(IMQueryGroupListRequest.this.mContext, valueOf)) {
                                GroupInfoDAOImpl.createGroup(IMQueryGroupListRequest.this.mContext, valueOf);
                                GroupInfoSyncManagerImpl.addSyncGroupInfo(valueOf);
                            }
                        }
                        GroupInfoSyncManagerImpl.activeSyncAllGroup(IMQueryGroupListRequest.this.mContext);
                        GroupInfoSyncManagerImpl.syncAllGroupListDone(IMQueryGroupListRequest.this.mContext);
                    }
                }
            } catch (JSONException e) {
                LogUtils.e(LogUtils.TAG, "IMCreateGroupRequest JSONException", e);
                new IMTrack.CrashBuilder(IMQueryGroupListRequest.this.mContext).exception(Log.getStackTraceString(e)).build();
                i = 1010;
                str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
            }
            IMListener removeListener = ListenerManager.getInstance().removeListener(IMQueryGroupListRequest.this.mKey);
            if (removeListener == null || !(removeListener instanceof BIMValueCallBack)) {
                LogUtils.e(IMQueryGroupListRequest.TAG, "query group list fail, listener is null");
            } else {
                ((BIMValueCallBack) removeListener).onResult(i, str, arrayList);
            }
        }
    }

    public IMQueryGroupListRequest(Context context, String str, long j) {
        this.mContext = context;
        this.mAppid = j;
        this.mKey = str;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        String bduss = IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        StringBuilder sb = new StringBuilder();
        sb.append("method=get_joined_groups");
        sb.append("&appid=").append(this.mAppid);
        sb.append("&timestamp=").append(currentTimeMillis);
        sb.append("&sign=").append(getMd5("" + currentTimeMillis + bduss + this.mAppid));
        return sb.toString().getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return false;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        String str = new String(bArr);
        LogUtils.d(TAG, "json is " + str);
        TaskManager.getInstance(this.mContext).submitForNetWork(new Mytask(this.mKey, str));
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
        IMListener removeListener = ListenerManager.getInstance().removeListener(this.mKey);
        if (removeListener != null && (removeListener instanceof BIMValueCallBack)) {
            ((BIMValueCallBack) removeListener).onResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, null);
        }
    }
}
