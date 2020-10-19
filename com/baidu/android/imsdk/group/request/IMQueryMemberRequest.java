package com.baidu.android.imsdk.group.request;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.group.GroupMember;
import com.baidu.android.imsdk.group.db.GroupInfoDAOImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class IMQueryMemberRequest extends GroupBaseHttpRequest {
    private static final String TAG = IMQueryMemberRequest.class.getSimpleName();
    private long mAppid;
    private ArrayList<String> mBuids;
    private String mGroupId;
    private String mKey;
    private int mSaveToDB;

    /* loaded from: classes5.dex */
    class Mytask extends TaskManager.Task {
        public Mytask(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.android.imsdk.task.TaskManager.Task, java.lang.Runnable
        public void run() {
            int i;
            String str;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            try {
                JSONObject jSONObject = new JSONObject(this.mJson);
                int i2 = jSONObject.getInt("error_code");
                String optString = jSONObject.optString("error_msg", "");
                if (i2 == 0 && jSONObject.has("response_params")) {
                    JSONArray jSONArray = jSONObject.getJSONObject("response_params").getJSONArray("members");
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                        long optLong = jSONObject2.optLong("bd_uid");
                        int optInt = jSONObject2.optInt("role");
                        long optLong2 = jSONObject2.optLong(DBTableDefine.GroupMemberColumns.COLUMN_JOIN_TIME);
                        long optLong3 = jSONObject2.optLong("uk");
                        String optString2 = jSONObject2.optString("name");
                        int optInt2 = jSONObject2.optInt("status", 0);
                        if (optInt2 == 0 || optInt2 == 2) {
                            GroupMember groupMember = new GroupMember(String.valueOf(IMQueryMemberRequest.this.mGroupId), optLong3, "", optLong, optInt, optLong2);
                            groupMember.setNickName(optString2);
                            arrayList.add(groupMember);
                        } else {
                            arrayList2.add(String.valueOf(optLong));
                        }
                    }
                    if (IMQueryMemberRequest.this.mSaveToDB == 1) {
                        LogUtils.d(IMQueryMemberRequest.TAG, " query " + IMQueryMemberRequest.this.mGroupId + "member save to db " + arrayList.size());
                        LogUtils.d(IMQueryMemberRequest.TAG, " query " + IMQueryMemberRequest.this.mGroupId + "member add: " + arrayList.toString());
                        GroupInfoDAOImpl.addMemberToGroup(IMQueryMemberRequest.this.mContext, String.valueOf(IMQueryMemberRequest.this.mGroupId), arrayList);
                    }
                    ArrayList<Long> groupMemberId = GroupInfoDAOImpl.getGroupMemberId(IMQueryMemberRequest.this.mContext, IMQueryMemberRequest.this.mGroupId);
                    ArrayList arrayList3 = new ArrayList();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        arrayList3.add(Long.valueOf(((GroupMember) it.next()).getBduid()));
                    }
                    if (IMQueryMemberRequest.this.mBuids == null && groupMemberId != null && !groupMemberId.isEmpty()) {
                        LogUtils.d(IMQueryMemberRequest.TAG, " bidAtGroup " + IMQueryMemberRequest.this.mGroupId + "  " + groupMemberId.size());
                        Iterator<Long> it2 = groupMemberId.iterator();
                        while (it2.hasNext()) {
                            long longValue = it2.next().longValue();
                            if (!arrayList3.contains(Long.valueOf(longValue))) {
                                arrayList2.add(String.valueOf(longValue));
                            }
                        }
                    }
                    if (arrayList2.size() > 0) {
                        LogUtils.d(IMQueryMemberRequest.TAG, "delete member " + IMQueryMemberRequest.this.mGroupId + " member as server deleted" + arrayList2.size());
                        LogUtils.d(IMQueryMemberRequest.TAG, "delete member " + IMQueryMemberRequest.this.mGroupId + " members: " + arrayList2.toString());
                        GroupInfoDAOImpl.delGroupMember(IMQueryMemberRequest.this.mContext, IMQueryMemberRequest.this.mGroupId, arrayList2);
                    }
                }
                str = optString;
                i = i2;
            } catch (JSONException e) {
                LogUtils.e(LogUtils.TAG, "IMCreateGroupRequest JSONException", e);
                new IMTrack.CrashBuilder(IMQueryMemberRequest.this.mContext).exception(Log.getStackTraceString(e)).build();
                i = 1010;
                str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
            }
            IMListener removeListener = ListenerManager.getInstance().removeListener(IMQueryMemberRequest.this.mKey);
            if (removeListener != null && (removeListener instanceof BIMValueCallBack)) {
                ((BIMValueCallBack) removeListener).onResult(i, str, arrayList);
            }
        }
    }

    public IMQueryMemberRequest(Context context, String str, long j, String str2, ArrayList<String> arrayList, int i) {
        this.mSaveToDB = 0;
        this.mContext = context;
        this.mAppid = j;
        this.mKey = str;
        this.mBuids = arrayList;
        this.mGroupId = str2;
        this.mSaveToDB = i;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        String bduss = IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        StringBuilder sb = new StringBuilder();
        sb.append("method=get_members");
        sb.append("&appid=").append(this.mAppid);
        sb.append("&group_id=").append(this.mGroupId);
        sb.append("&timestamp=").append(currentTimeMillis);
        if (this.mBuids != null && this.mBuids.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = this.mBuids.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            sb.append("&members=").append(jSONArray.toString());
        }
        sb.append("&sign=").append(getMd5("" + currentTimeMillis + bduss + this.mAppid));
        return sb.toString().getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return "application/x-www-form-urlencoded";
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return false;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        String str = new String(bArr);
        LogUtils.d(TAG, "json is groupid " + this.mGroupId + str);
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
