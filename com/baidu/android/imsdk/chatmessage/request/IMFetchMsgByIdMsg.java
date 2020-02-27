package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.TextMsg;
import com.baidu.android.imsdk.group.GroupMessageManagerImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.MessageParser;
import com.baidu.android.imsdk.mcast.McastManagerImpl;
import com.baidu.android.imsdk.pubaccount.PaManagerImpl;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.sapi2.SapiContext;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class IMFetchMsgByIdMsg extends Message {
    private static final String TAG = "IMFetchMsgByIdMsg";
    private long mBeginId;
    private int mCategory;
    private long mContacter;
    private Context mContext;
    private int mCount;
    private long mEndId;
    private int mFetchNum;
    private int mJumpToRecent = -1;
    private long mTriggerReason;

    public IMFetchMsgByIdMsg(Context context, long j, long j2, int i, int i2, long j3, int i3, int i4) {
        this.mFetchNum = 0;
        initCommonParameter(context);
        this.mBeginId = j;
        this.mEndId = j2;
        this.mCount = i;
        this.mCategory = i2;
        this.mContacter = j3;
        this.mTriggerReason = i3;
        this.mFetchNum = i4;
        this.mContext = context;
        setNeedReplay(true);
        setType(93);
    }

    @Override // com.baidu.android.imsdk.request.Message
    protected void buildBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", 93);
            jSONObject.put("appid", this.mAppid);
            jSONObject.put("uk", this.mUk);
            jSONObject.put(Constants.EXTRA_BEGIN_MSGID, this.mBeginId);
            jSONObject.put(Constants.EXTRA_END_MSGID, this.mEndId);
            jSONObject.put("count", this.mCount);
            if (this.mContacter >= 0) {
                jSONObject.put("to", this.mContacter);
            }
            if (this.mCategory >= 0) {
                jSONObject.put("category", this.mCategory);
            }
            if (this.mJumpToRecent != -1) {
                jSONObject.put(Constants.KEY_JUMP_TO_RECENT_MSG, this.mJumpToRecent);
            }
            if (this.mJumpToRecent == 1) {
                jSONObject.put("most_recent_msg_num", this.mCount);
            }
            if (this.mTriggerReason == 2) {
                jSONObject.put("origin_id", Utility.getTriggerId(this.mContext));
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("rpc_retry_time", this.mFetchNum);
            jSONObject.put("rpc", jSONObject2.toString());
            jSONObject.put(SapiContext.KEY_SDK_VERSION, IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
            this.mBody = jSONObject.toString();
        } catch (JSONException e) {
            LogUtils.e(TAG, "Exception ", e);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
        }
    }

    public static IMFetchMsgByIdMsg newInstance(Context context, Intent intent) {
        if (intent.hasExtra("contacter") && intent.hasExtra("count") && intent.hasExtra(Constants.EXTRA_TRIGGER_REASON)) {
            int intExtra = intent.getIntExtra("category", -1);
            long longExtra = intent.getLongExtra("contacter", -1L);
            int intExtra2 = intent.getIntExtra("count", -1);
            long longExtra2 = intent.getLongExtra(Constants.EXTRA_BEGIN_MSGID, -1L);
            long longExtra3 = intent.getLongExtra(Constants.EXTRA_END_MSGID, -1L);
            int intExtra3 = intent.getIntExtra(Constants.EXTRA_TRIGGER_REASON, -1);
            int intExtra4 = intent.getIntExtra(Constants.EXTRA_JUMP_MSG, -1);
            int intExtra5 = intent.getIntExtra(Constants.EXTRA_RETRY_TIME, 0);
            if (longExtra2 >= 0 && longExtra3 >= 0 && intExtra3 >= 0) {
                IMFetchMsgByIdMsg iMFetchMsgByIdMsg = new IMFetchMsgByIdMsg(context, longExtra2, longExtra3, intExtra2, intExtra, longExtra, intExtra3, intExtra5);
                iMFetchMsgByIdMsg.setJumpToNewMsg(intExtra4);
                return iMFetchMsgByIdMsg;
            }
        }
        return null;
    }

    public long getContacter() {
        return this.mContacter;
    }

    public int getCategory() {
        return this.mCategory;
    }

    public int getCount() {
        return this.mCount;
    }

    public void setJumpToNewMsg(int i) {
        this.mJumpToRecent = i;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void onMsgSending(Context context) {
        setSendingState(context);
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i, String str) {
        LogUtils.d(TAG, "fetch handleMessageResult err : " + i + ", msg :" + str);
        TaskManager.getInstance(this.mContext).submitForNetWork(new FetchTask(context, jSONObject, i, str));
    }

    /* loaded from: classes3.dex */
    private class FetchTask extends TaskManager.Task {
        private Context mContext;
        private int mErrorCode;
        private JSONObject mObj;
        private String mStrMsg;

        protected FetchTask(Context context, JSONObject jSONObject, int i, String str) {
            this.mContext = context;
            this.mObj = jSONObject;
            this.mErrorCode = i;
            this.mStrMsg = str;
        }

        /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Long] */
        @Override // com.baidu.android.imsdk.task.TaskManager.Task, java.lang.Runnable
        public void run() {
            int i;
            ArrayList<ChatMsg> arrayList = null;
            int i2 = 0;
            boolean z = false;
            Type type = new Type();
            type.t = 0L;
            if (this.mErrorCode == 0) {
                if (this.mObj.has("messages")) {
                    JSONArray jSONArray = null;
                    try {
                        z = this.mObj.optBoolean("has_more", false);
                        jSONArray = this.mObj.getJSONArray("messages");
                        i2 = jSONArray.length();
                        LogUtils.d(IMFetchMsgByIdMsg.TAG, "fetch message result hasMore = " + z + " realMsgCount = " + i2 + " count = " + IMFetchMsgByIdMsg.this.mCount);
                        i = i2;
                    } catch (JSONException e) {
                        LogUtils.e(IMFetchMsgByIdMsg.TAG, "Exception ", e);
                        new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                        i = i2;
                    }
                    if (z) {
                        i = Math.abs(IMFetchMsgByIdMsg.this.mCount);
                        LogUtils.d(IMFetchMsgByIdMsg.TAG, "fetch message set realMsgCount = " + IMFetchMsgByIdMsg.this.mCount);
                    }
                    int i3 = i;
                    ArrayList<ChatMsg> parserMessage = MessageParser.parserMessage(this.mContext, jSONArray, type, true, true);
                    if (parserMessage != null && parserMessage.size() != 0) {
                        if (1 == IMFetchMsgByIdMsg.this.mCategory) {
                            parserMessage.get(0).getContacter();
                            parserMessage = GroupMessageManagerImpl.getInstance(this.mContext).addMsgs(parserMessage, true);
                        } else if (4 == IMFetchMsgByIdMsg.this.mCategory) {
                            LogUtils.d(IMFetchMsgByIdMsg.TAG, " fetch cast message , size " + parserMessage.size());
                            ArrayList arrayList2 = new ArrayList();
                            ArrayList arrayList3 = new ArrayList();
                            Iterator<ChatMsg> it = parserMessage.iterator();
                            while (it.hasNext()) {
                                ChatMsg next = it.next();
                                if (McastManagerImpl.getInstance(this.mContext).isReliable(((TextMsg) next).getCastId()).booleanValue()) {
                                    arrayList2.add((TextMsg) next);
                                    arrayList3.add(Long.valueOf(next.getMsgId()));
                                }
                            }
                            LogUtils.d(IMFetchMsgByIdMsg.TAG, " fetch reliableMsgs cast message , size " + arrayList2.size() + ", ids :" + arrayList3.toString());
                            if (arrayList2.size() > 0) {
                                parserMessage = ChatMessageDBManager.getInstance(this.mContext).addCastReliableMsgs(arrayList2);
                                McastManagerImpl.getInstance(this.mContext).deliverCastReliableMsg(((TextMsg) parserMessage.get(0)).getCastId(), parserMessage);
                                new IMTrack.RequestBuilder(this.mContext).method(arrayList3.toString()).requestId("" + ((TextMsg) parserMessage.get(0)).getCastId()).requestTime(System.currentTimeMillis()).ext("fetch msgIs size :" + arrayList3.size()).aliasId(501103L).build();
                            }
                        } else {
                            parserMessage = ChatMessageDBManager.getInstance(this.mContext).addMsgs(this.mContext, parserMessage, true, IMFetchMsgByIdMsg.this.mTriggerReason);
                            PaManagerImpl.getInstance(this.mContext).syncAndQueryAllPaInfo();
                        }
                    }
                    i2 = i3;
                    arrayList = parserMessage;
                }
            } else if (this.mErrorCode == 4001) {
                LoginManager.getInstance(this.mContext).triggleLogoutListener(this.mErrorCode, this.mStrMsg);
            }
            ChatMsgManagerImpl.getInstance(this.mContext).onFetchMsgByIdResult(this.mContext, this.mErrorCode, this.mStrMsg, IMFetchMsgByIdMsg.this.mCategory, IMFetchMsgByIdMsg.this.mContacter, IMFetchMsgByIdMsg.this.mBeginId, IMFetchMsgByIdMsg.this.mEndId, IMFetchMsgByIdMsg.this.mCount, i2, ((Long) type.t).longValue(), IMFetchMsgByIdMsg.this.getUUID(), arrayList, IMFetchMsgByIdMsg.this.getListenerKey());
        }
    }
}
