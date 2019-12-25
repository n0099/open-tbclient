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
/* loaded from: classes2.dex */
public class IMGetUsersProfileBatch extends Message {
    private Context mContext;
    private JSONArray mFetchedUidsJson;
    private ArrayList<Long> usersIdArrayList;
    private ArrayList<Long> mFetchedUidsList = new ArrayList<>();
    private ArrayList<Long> mExistUidList = new ArrayList<>();

    public boolean needFetch(Context context) {
        this.mExistUidList.clear();
        this.mFetchedUidsList.clear();
        if (this.usersIdArrayList != null && this.usersIdArrayList.size() != 0) {
            Iterator<Long> it = this.usersIdArrayList.iterator();
            while (it.hasNext()) {
                Long next = it.next();
                if (IMUserManager.getInstance(context).isUserExist(next.longValue())) {
                    this.mExistUidList.add(next);
                } else {
                    this.mFetchedUidsList.add(next);
                }
            }
        }
        return this.mFetchedUidsList.size() != 0;
    }

    public IMGetUsersProfileBatch(Context context, ArrayList<Long> arrayList) {
        this.mContext = context;
        initCommonParameter(context);
        this.usersIdArrayList = arrayList;
        setNeedReplay(true);
        setType(71);
        handle(context);
    }

    public static IMGetUsersProfileBatch newInstance(Context context, Intent intent) {
        if (intent.hasExtra(Constants.EXTRA_UIDS)) {
            IMGetUsersProfileBatch iMGetUsersProfileBatch = new IMGetUsersProfileBatch(context, (ArrayList) intent.getExtras().getSerializable(Constants.EXTRA_UIDS));
            if (iMGetUsersProfileBatch.needFetch(context)) {
                iMGetUsersProfileBatch.handle(context);
                return iMGetUsersProfileBatch;
            }
            iMGetUsersProfileBatch.setListenerKey(intent.getStringExtra(Constants.EXTRA_LISTENER_ID));
            iMGetUsersProfileBatch.handle(context);
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
            jSONObject.put("method", 71);
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
                        ChatUser contructChatUser = Utility.contructChatUser(jSONArray.getJSONObject(i2));
                        IMUserManager.getInstance(context).updateUser(contructChatUser);
                        arrayList.add(contructChatUser);
                    }
                } catch (Exception e) {
                    LogUtils.e(LogUtils.TAG, "handleMessageResult:", e);
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                }
            }
            addUserProfileBatch(context, arrayList);
        }
        ChatUserManagerImpl.getInstance(context).onGetUsersProfileBatchResult(getListenerKey(), i, str, this.usersIdArrayList, arrayList);
    }

    private void addUserProfileBatch(Context context, ArrayList<ChatUser> arrayList) {
        Iterator<Long> it = this.mExistUidList.iterator();
        while (it.hasNext()) {
            arrayList.add(IMUserManager.getInstance(context).getChatUser(it.next().longValue()));
        }
    }
}
