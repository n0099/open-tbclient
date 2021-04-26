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
import com.bumptech.glide.load.engine.GlideException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMQueryMemberRequest extends GroupBaseHttpRequest {
    public static final String TAG = "IMQueryMemberRequest";
    public long mAppid;
    public ArrayList<String> mBuids;
    public String mGroupId;
    public String mKey;
    public int mSaveToDB;

    /* loaded from: classes.dex */
    public class Mytask extends TaskManager.Task {
        public Mytask(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.android.imsdk.task.TaskManager.Task, java.lang.Runnable
        public void run() {
            int i2;
            String str;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            try {
                JSONObject jSONObject = new JSONObject(this.mJson);
                i2 = jSONObject.getInt("error_code");
                str = jSONObject.optString("error_msg", "");
                if (i2 == 0 && jSONObject.has("response_params")) {
                    JSONArray jSONArray = jSONObject.getJSONObject("response_params").getJSONArray("members");
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                        long optLong = jSONObject2.optLong("bd_uid");
                        int optInt = jSONObject2.optInt("role");
                        long optLong2 = jSONObject2.optLong(DBTableDefine.GroupMemberColumns.COLUMN_JOIN_TIME);
                        long optLong3 = jSONObject2.optLong("uk");
                        String optString = jSONObject2.optString("name");
                        int optInt2 = jSONObject2.optInt("status", 0);
                        if (optInt2 != 0 && optInt2 != 2) {
                            arrayList2.add(String.valueOf(optLong));
                        }
                        GroupMember groupMember = new GroupMember(String.valueOf(IMQueryMemberRequest.this.mGroupId), optLong3, "", optLong, optInt, optLong2);
                        groupMember.setNickName(optString);
                        arrayList.add(groupMember);
                    }
                    if (IMQueryMemberRequest.this.mSaveToDB == 1) {
                        String str2 = IMQueryMemberRequest.TAG;
                        LogUtils.d(str2, " query " + IMQueryMemberRequest.this.mGroupId + "member save to db " + arrayList.size());
                        String str3 = IMQueryMemberRequest.TAG;
                        LogUtils.d(str3, " query " + IMQueryMemberRequest.this.mGroupId + "member add: " + arrayList.toString());
                        GroupInfoDAOImpl.addMemberToGroup(IMQueryMemberRequest.this.mContext, String.valueOf(IMQueryMemberRequest.this.mGroupId), arrayList);
                    }
                    ArrayList<Long> groupMemberId = GroupInfoDAOImpl.getGroupMemberId(IMQueryMemberRequest.this.mContext, IMQueryMemberRequest.this.mGroupId);
                    ArrayList arrayList3 = new ArrayList();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        arrayList3.add(Long.valueOf(((GroupMember) it.next()).getBduid()));
                    }
                    if (IMQueryMemberRequest.this.mBuids == null && groupMemberId != null && !groupMemberId.isEmpty()) {
                        String str4 = IMQueryMemberRequest.TAG;
                        LogUtils.d(str4, " bidAtGroup " + IMQueryMemberRequest.this.mGroupId + GlideException.IndentedAppendable.INDENT + groupMemberId.size());
                        Iterator<Long> it2 = groupMemberId.iterator();
                        while (it2.hasNext()) {
                            long longValue = it2.next().longValue();
                            if (!arrayList3.contains(Long.valueOf(longValue))) {
                                arrayList2.add(String.valueOf(longValue));
                            }
                        }
                    }
                    if (arrayList2.size() > 0) {
                        String str5 = IMQueryMemberRequest.TAG;
                        LogUtils.d(str5, "delete member " + IMQueryMemberRequest.this.mGroupId + " member as server deleted" + arrayList2.size());
                        String str6 = IMQueryMemberRequest.TAG;
                        LogUtils.d(str6, "delete member " + IMQueryMemberRequest.this.mGroupId + " members: " + arrayList2.toString());
                        GroupInfoDAOImpl.delGroupMember(IMQueryMemberRequest.this.mContext, IMQueryMemberRequest.this.mGroupId, arrayList2);
                    }
                }
            } catch (JSONException e2) {
                LogUtils.e(LogUtils.TAG, "IMCreateGroupRequest JSONException", e2);
                i2 = 1010;
                new IMTrack.CrashBuilder(IMQueryMemberRequest.this.mContext).exception(Log.getStackTraceString(e2)).build();
                str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
            }
            IMListener removeListener = ListenerManager.getInstance().removeListener(IMQueryMemberRequest.this.mKey);
            if (removeListener == null || !(removeListener instanceof BIMValueCallBack)) {
                return;
            }
            ((BIMValueCallBack) removeListener).onResult(i2, str, arrayList);
        }
    }

    public IMQueryMemberRequest(Context context, String str, long j, String str2, ArrayList<String> arrayList, int i2) {
        this.mSaveToDB = 0;
        this.mContext = context;
        this.mAppid = j;
        this.mKey = str;
        this.mBuids = arrayList;
        this.mGroupId = str2;
        this.mSaveToDB = i2;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return "application/x-www-form-urlencoded";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        String bduss = IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        StringBuilder sb = new StringBuilder();
        sb.append("method=get_members");
        sb.append("&appid=");
        sb.append(this.mAppid);
        sb.append("&group_id=");
        sb.append(this.mGroupId);
        sb.append("&timestamp=");
        sb.append(currentTimeMillis);
        ArrayList<String> arrayList = this.mBuids;
        if (arrayList != null && arrayList.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = this.mBuids.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            sb.append("&members=");
            sb.append(jSONArray.toString());
        }
        sb.append("&sign=");
        sb.append(getMd5("" + currentTimeMillis + bduss + this.mAppid));
        return sb.toString().getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i2, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i2, bArr, th);
        IMListener removeListener = ListenerManager.getInstance().removeListener(this.mKey);
        if (removeListener == null || !(removeListener instanceof BIMValueCallBack)) {
            return;
        }
        ((BIMValueCallBack) removeListener).onResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, null);
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i2, byte[] bArr) {
        String str = new String(bArr);
        String str2 = TAG;
        LogUtils.d(str2, "json is groupid " + this.mGroupId + str);
        TaskManager.getInstance(this.mContext).submitForNetWork(new Mytask(this.mKey, str));
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return false;
    }
}
