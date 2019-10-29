package com.baidu.android.imsdk.chatuser.request;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.baidu.android.imsdk.chatuser.ChatUser;
import com.baidu.android.imsdk.chatuser.ChatUserManagerImpl;
import com.baidu.android.imsdk.chatuser.Utility;
import com.baidu.android.imsdk.chatuser.db.IMUserManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.live.tbadk.core.data.ConstantData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class IMGetUsersProfileByBaiduUidBatch extends Message {
    private ArrayList<Long> mBuidsArrayList;
    private Context mContext;
    private JSONArray mFetchedUidsJson;
    private boolean mIsSync;
    private ArrayList<Long> mFetchedUidsList = new ArrayList<>();
    private ArrayList<Long> mExistUidList = new ArrayList<>();

    public boolean needFetch(Context context) {
        this.mExistUidList.clear();
        this.mFetchedUidsList.clear();
        if (this.mBuidsArrayList != null && this.mBuidsArrayList.size() != 0) {
            Iterator<Long> it = this.mBuidsArrayList.iterator();
            while (it.hasNext()) {
                Long next = it.next();
                if (this.mIsSync) {
                    this.mFetchedUidsList.add(next);
                } else {
                    long uKbyBuid = IMUserManager.getInstance(context).getUKbyBuid(next.longValue());
                    if (uKbyBuid > 0) {
                        if (IMUserManager.getInstance(context).isUserExist(uKbyBuid)) {
                            this.mExistUidList.add(next);
                        } else {
                            this.mFetchedUidsList.add(next);
                        }
                    } else {
                        this.mFetchedUidsList.add(next);
                    }
                }
            }
        }
        return this.mFetchedUidsList.size() != 0;
    }

    public IMGetUsersProfileByBaiduUidBatch(Context context, ArrayList<Long> arrayList, boolean z) {
        this.mIsSync = false;
        this.mContext = context;
        initCommonParameter(context);
        this.mBuidsArrayList = arrayList;
        setNeedReplay(true);
        setType(Constants.METHOD_IM_GET_USERS_PROFILE_BATCH_BY_BAIDU_UID);
        this.mIsSync = z;
    }

    public static IMGetUsersProfileByBaiduUidBatch newInstance(Context context, Intent intent) {
        if (intent.hasExtra(Constants.EXTRA_BAIDU_UIDS)) {
            IMGetUsersProfileByBaiduUidBatch iMGetUsersProfileByBaiduUidBatch = new IMGetUsersProfileByBaiduUidBatch(context, (ArrayList) intent.getExtras().getSerializable(Constants.EXTRA_BAIDU_UIDS), intent.getBooleanExtra(Constants.EXTRA_USERS_SYNC, false));
            if (iMGetUsersProfileByBaiduUidBatch.needFetch(context)) {
                iMGetUsersProfileByBaiduUidBatch.handle(context);
                return iMGetUsersProfileByBaiduUidBatch;
            }
            iMGetUsersProfileByBaiduUidBatch.setListenerKey(intent.getStringExtra(Constants.EXTRA_LISTENER_ID));
            iMGetUsersProfileByBaiduUidBatch.handle(context);
            return null;
        }
        return null;
    }

    public void handle(Context context) {
        if (this.mFetchedUidsList.size() == 0) {
            handleMessageResult(context, null, 0, "sucess");
        } else {
            this.mFetchedUidsJson = listToJsonArray(this.mFetchedUidsList);
        }
    }

    @Override // com.baidu.android.imsdk.request.Message
    protected void buildBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", Constants.METHOD_IM_GET_USERS_PROFILE_BATCH_BY_BAIDU_UID);
            jSONObject.put("appid", this.mAppid);
            jSONObject.put("uk", this.mUk);
            jSONObject.put("to_users", this.mFetchedUidsJson);
            jSONObject.put("is_https", true);
            this.mBody = jSONObject.toString();
        } catch (JSONException e) {
            LogUtils.e(getClass().getSimpleName(), "Exception ", e);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
        }
    }

    private static JSONArray listToJsonArray(List<Long> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                jSONArray.put(list.get(i));
            }
        }
        return jSONArray;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i, String str) {
        ArrayList<ChatUser> arrayList = new ArrayList<>();
        if (i == 0) {
            if (jSONObject != null && jSONObject.has(ConstantData.VideoLocationType.PERSON_PROFILE)) {
                try {
                    JSONArray jSONArray = jSONObject.getJSONArray(ConstantData.VideoLocationType.PERSON_PROFILE);
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        ChatUser contructChatUserFormUid = Utility.contructChatUserFormUid(jSONArray.getJSONObject(i2));
                        IMUserManager.getInstance(context).updateUser(contructChatUserFormUid);
                        arrayList.add(contructChatUserFormUid);
                    }
                } catch (Exception e) {
                    LogUtils.e(LogUtils.TAG, "handleMessageResult:", e);
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                }
                ChatUserManagerImpl.getInstance(context).syncUsersAttr();
            }
            addUserProfileBatch(context, arrayList);
        }
        LogUtils.d("IMGetUsersProfileByBaiduUidBatch", "handleMessageResult----errorCode: " + i + " msg: " + str + "users:" + arrayList.toString());
        ChatUserManagerImpl.getInstance(context).onGetUsersProfileBatchResult(getListenerKey(), i, str, this.mBuidsArrayList, arrayList);
    }

    private void addUserProfileBatch(Context context, ArrayList<ChatUser> arrayList) {
        Iterator<Long> it = this.mExistUidList.iterator();
        while (it.hasNext()) {
            arrayList.add(IMUserManager.getInstance(context).getChatUser(IMUserManager.getInstance(context).getUKbyBuid(it.next().longValue())));
        }
    }
}
