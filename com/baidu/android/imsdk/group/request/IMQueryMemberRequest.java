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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMQueryMemberRequest extends GroupBaseHttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMQueryMemberRequest";
    public transient /* synthetic */ FieldHolder $fh;
    public long mAppid;
    public ArrayList<String> mBuids;
    public String mGroupId;
    public String mKey;
    public int mSaveToDB;

    /* loaded from: classes.dex */
    public class Mytask extends TaskManager.Task {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IMQueryMemberRequest this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Mytask(IMQueryMemberRequest iMQueryMemberRequest, String str, String str2) {
            super(str, str2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iMQueryMemberRequest, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = iMQueryMemberRequest;
        }

        @Override // com.baidu.android.imsdk.task.TaskManager.Task, java.lang.Runnable
        public void run() {
            int i2;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
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
                            GroupMember groupMember = new GroupMember(String.valueOf(this.this$0.mGroupId), optLong3, "", optLong, optInt, optLong2);
                            groupMember.setNickName(optString);
                            arrayList.add(groupMember);
                        }
                        if (this.this$0.mSaveToDB == 1) {
                            String str2 = IMQueryMemberRequest.TAG;
                            LogUtils.d(str2, " query " + this.this$0.mGroupId + "member save to db " + arrayList.size());
                            String str3 = IMQueryMemberRequest.TAG;
                            LogUtils.d(str3, " query " + this.this$0.mGroupId + "member add: " + arrayList.toString());
                            GroupInfoDAOImpl.addMemberToGroup(this.this$0.mContext, String.valueOf(this.this$0.mGroupId), arrayList);
                        }
                        ArrayList<Long> groupMemberId = GroupInfoDAOImpl.getGroupMemberId(this.this$0.mContext, this.this$0.mGroupId);
                        ArrayList arrayList3 = new ArrayList();
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            arrayList3.add(Long.valueOf(((GroupMember) it.next()).getBduid()));
                        }
                        if (this.this$0.mBuids == null && groupMemberId != null && !groupMemberId.isEmpty()) {
                            String str4 = IMQueryMemberRequest.TAG;
                            LogUtils.d(str4, " bidAtGroup " + this.this$0.mGroupId + GlideException.IndentedAppendable.INDENT + groupMemberId.size());
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
                            LogUtils.d(str5, "delete member " + this.this$0.mGroupId + " member as server deleted" + arrayList2.size());
                            String str6 = IMQueryMemberRequest.TAG;
                            LogUtils.d(str6, "delete member " + this.this$0.mGroupId + " members: " + arrayList2.toString());
                            GroupInfoDAOImpl.delGroupMember(this.this$0.mContext, this.this$0.mGroupId, arrayList2);
                        }
                    }
                } catch (JSONException e2) {
                    LogUtils.e(LogUtils.TAG, "IMCreateGroupRequest JSONException", e2);
                    i2 = 1010;
                    new IMTrack.CrashBuilder(this.this$0.mContext).exception(Log.getStackTraceString(e2)).build();
                    str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
                }
                IMListener removeListener = ListenerManager.getInstance().removeListener(this.this$0.mKey);
                if (removeListener == null || !(removeListener instanceof BIMValueCallBack)) {
                    return;
                }
                ((BIMValueCallBack) removeListener).onResult(i2, str, arrayList);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2119695757, "Lcom/baidu/android/imsdk/group/request/IMQueryMemberRequest;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2119695757, "Lcom/baidu/android/imsdk/group/request/IMQueryMemberRequest;");
        }
    }

    public IMQueryMemberRequest(Context context, String str, long j, String str2, ArrayList<String> arrayList, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Long.valueOf(j), str2, arrayList, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
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
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "application/x-www-form-urlencoded" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
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
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i2, byte[] bArr, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, bArr, th) == null) {
            Pair<Integer, String> transErrorCode = transErrorCode(i2, bArr, th);
            IMListener removeListener = ListenerManager.getInstance().removeListener(this.mKey);
            if (removeListener == null || !(removeListener instanceof BIMValueCallBack)) {
                return;
            }
            ((BIMValueCallBack) removeListener).onResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, null);
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i2, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, bArr) == null) {
            String str = new String(bArr);
            String str2 = TAG;
            LogUtils.d(str2, "json is groupid " + this.mGroupId + str);
            TaskManager.getInstance(this.mContext).submitForNetWork(new Mytask(this, this.mKey, str));
        }
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }
}
