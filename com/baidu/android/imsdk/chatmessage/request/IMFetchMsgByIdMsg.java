package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.TextMsg;
import com.baidu.android.imsdk.conversation.ConversationStudioManImpl;
import com.baidu.android.imsdk.group.GroupMessageManagerImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.MessageParser;
import com.baidu.android.imsdk.pubaccount.PaManagerImpl;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.request.MessageExt;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class IMFetchMsgByIdMsg extends Message {
    public static final String TAG = "IMFetchMsgByIdMsg";
    public static final Map<Long, Boolean> reliableListFirst = new ConcurrentHashMap();
    public long mBeginId;
    public int mCategory;
    public long mContacter;
    public Context mContext;
    public int mCount;
    public long mEndId;
    public int mFetchNum;
    public int mJumpToRecent = -1;
    public JSONObject mMessageExt;
    public long mTriggerReason;

    /* loaded from: classes2.dex */
    public class FetchTask extends TaskManager.Task {
        public Context mContext;
        public int mErrorCode;
        public JSONObject mObj;
        public String mStrMsg;

        public FetchTask(Context context, JSONObject jSONObject, int i, String str) {
            this.mContext = context;
            this.mObj = jSONObject;
            this.mErrorCode = i;
            this.mStrMsg = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x007f  */
        /* JADX WARN: Type inference failed for: r0v0, types: [T, java.lang.Long] */
        @Override // com.baidu.android.imsdk.task.TaskManager.Task, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            ArrayList<ChatMsg> arrayList;
            int i;
            int i2;
            boolean z;
            ArrayList<ChatMsg> parserMessage;
            ArrayList<ChatMsg> addMsgs;
            final ArrayList<ChatMsg> arrayList2;
            Type type = new Type();
            type.t = 0L;
            JSONArray jSONArray = null;
            if (this.mErrorCode == 0 && this.mObj.has(NotificationCompat.CarExtender.KEY_MESSAGES)) {
                try {
                    z = this.mObj.optBoolean("has_more", false);
                    try {
                        jSONArray = this.mObj.getJSONArray(NotificationCompat.CarExtender.KEY_MESSAGES);
                        i2 = jSONArray.length();
                        try {
                            LogUtils.d(IMFetchMsgByIdMsg.TAG, "fetch message result hasMore = " + z + " realMsgCount = " + i2 + " count = " + IMFetchMsgByIdMsg.this.mCount);
                        } catch (JSONException e2) {
                            e = e2;
                            LogUtils.e(IMFetchMsgByIdMsg.TAG, "Exception ", e);
                            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                            if (z) {
                            }
                            parserMessage = MessageParser.parserMessage(this.mContext, jSONArray, type, true, true);
                            if (parserMessage != null) {
                            }
                            i = i2;
                            arrayList = parserMessage;
                            ChatMsgManagerImpl.getInstance(this.mContext).onFetchMsgByIdResult(this.mContext, this.mErrorCode, this.mStrMsg, IMFetchMsgByIdMsg.this.mCategory, IMFetchMsgByIdMsg.this.mContacter, IMFetchMsgByIdMsg.this.mBeginId, IMFetchMsgByIdMsg.this.mEndId, IMFetchMsgByIdMsg.this.mCount, i, ((Long) type.t).longValue(), IMFetchMsgByIdMsg.this.getUUID(), arrayList, IMFetchMsgByIdMsg.this.getListenerKey());
                        }
                    } catch (JSONException e3) {
                        e = e3;
                        i2 = 0;
                    }
                } catch (JSONException e4) {
                    e = e4;
                    i2 = 0;
                    z = false;
                }
                if (z) {
                    i2 = Math.abs(IMFetchMsgByIdMsg.this.mCount);
                    LogUtils.d(IMFetchMsgByIdMsg.TAG, "fetch message set realMsgCount = " + IMFetchMsgByIdMsg.this.mCount);
                }
                parserMessage = MessageParser.parserMessage(this.mContext, jSONArray, type, true, true);
                if (parserMessage != null || parserMessage.size() == 0) {
                    i = i2;
                    arrayList = parserMessage;
                } else {
                    if (1 != IMFetchMsgByIdMsg.this.mCategory) {
                        if (4 == IMFetchMsgByIdMsg.this.mCategory) {
                            LogUtils.d(IMFetchMsgByIdMsg.TAG, " fetch cast message , size " + parserMessage.size());
                            Long valueOf = Long.valueOf(((TextMsg) parserMessage.get(0)).getCastId());
                            MessageExt.getInstance().setCastId(valueOf);
                            ArrayList arrayList3 = new ArrayList();
                            ArrayList arrayList4 = new ArrayList();
                            Iterator<ChatMsg> it = parserMessage.iterator();
                            while (it.hasNext()) {
                                ChatMsg next = it.next();
                                TextMsg textMsg = (TextMsg) next;
                                if (ConversationStudioManImpl.getInstance(this.mContext).isReliable(textMsg.getCastId())) {
                                    arrayList3.add(textMsg);
                                    arrayList4.add(Long.valueOf(next.getMsgId()));
                                }
                            }
                            LogUtils.d(IMFetchMsgByIdMsg.TAG, " fetch reliableMsgs cast message , size " + arrayList3.size() + ", ids :" + arrayList4.toString());
                            if (arrayList3.size() > 0) {
                                ArrayList arrayList5 = new ArrayList();
                                arrayList2 = ChatMessageDBManager.getInstance(this.mContext).addCastReliableMsgs(arrayList3, arrayList5);
                                if (arrayList5.size() > 0) {
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        jSONObject.put(Constants.RELIABLE_MSGID, Collections.max(arrayList5));
                                        jSONObject.put(Constants.RELIABLE_CASTID, ((TextMsg) arrayList2.get(0)).getCastId());
                                        jSONObject.put(Constants.RELIABLE_UPDATTIME, System.currentTimeMillis());
                                        Utility.setReliableMaxMsg(this.mContext, jSONObject);
                                    } catch (JSONException e5) {
                                        e5.printStackTrace();
                                    }
                                }
                                long castId = ((TextMsg) arrayList2.get(0)).getCastId();
                                ConversationStudioManImpl.getInstance(this.mContext).deliverCastReliableMsg(castId, arrayList2);
                                if (!IMFetchMsgByIdMsg.reliableListFirst.containsKey(Long.valueOf(castId))) {
                                    IMFetchMsgByIdMsg.reliableListFirst.put(Long.valueOf(castId), Boolean.FALSE);
                                }
                                if (IMFetchMsgByIdMsg.reliableListFirst.containsKey(Long.valueOf(castId)) && !IMFetchMsgByIdMsg.reliableListFirst.get(Long.valueOf(castId)).booleanValue()) {
                                    IMFetchMsgByIdMsg.reliableListFirst.put(Long.valueOf(castId), Boolean.TRUE);
                                    TaskManager.getInstance(this.mContext).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.chatmessage.request.IMFetchMsgByIdMsg.FetchTask.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            LogUtils.d(IMFetchMsgByIdMsg.TAG, "可靠消息第一次拉礼物消息，多回一次ack：" + arrayList2.toString());
                                            MessageParser.handleAck(FetchTask.this.mContext, arrayList2, false);
                                        }
                                    });
                                }
                            } else {
                                arrayList2 = parserMessage;
                            }
                            MessageExt.getInstance().setdBLatestMsgId(Utility.getReliableMaxMsgId(this.mContext, valueOf.longValue()));
                            MessageExt.getInstance().setLocalTimestamp(Long.valueOf(System.currentTimeMillis()));
                            i = i2;
                            arrayList = arrayList2;
                        } else {
                            addMsgs = ChatMessageDBManager.getInstance(this.mContext).addMsgs(this.mContext, parserMessage, true, IMFetchMsgByIdMsg.this.mTriggerReason);
                            PaManagerImpl.getInstance(this.mContext).syncAndQueryAllPaInfo();
                        }
                    } else {
                        parserMessage.get(0).getContacter();
                        addMsgs = GroupMessageManagerImpl.getInstance(this.mContext).addMsgs(parserMessage, true);
                    }
                    arrayList = addMsgs;
                    i = i2;
                }
            } else {
                arrayList = null;
                i = 0;
            }
            ChatMsgManagerImpl.getInstance(this.mContext).onFetchMsgByIdResult(this.mContext, this.mErrorCode, this.mStrMsg, IMFetchMsgByIdMsg.this.mCategory, IMFetchMsgByIdMsg.this.mContacter, IMFetchMsgByIdMsg.this.mBeginId, IMFetchMsgByIdMsg.this.mEndId, IMFetchMsgByIdMsg.this.mCount, i, ((Long) type.t).longValue(), IMFetchMsgByIdMsg.this.getUUID(), arrayList, IMFetchMsgByIdMsg.this.getListenerKey());
        }
    }

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
        this.mMessageExt = new JSONObject();
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
            if (longExtra2 < 0 || longExtra3 < 0 || intExtra3 < 0) {
                return null;
            }
            IMFetchMsgByIdMsg iMFetchMsgByIdMsg = new IMFetchMsgByIdMsg(context, longExtra2, longExtra3, intExtra2, intExtra, longExtra, intExtra3, intExtra5);
            iMFetchMsgByIdMsg.setJumpToNewMsg(intExtra4);
            return iMFetchMsgByIdMsg;
        }
        return null;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void buildBody() {
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
            jSONObject.put("sdk_version", IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
            if (4 == this.mCategory) {
                JSONObject json = MessageExt.getInstance().toJson();
                this.mMessageExt = json;
                if (json != null && json.length() > 0) {
                    jSONObject.put("ext_info", this.mMessageExt.toString());
                }
            }
            this.mBody = jSONObject.toString();
            LogUtils.d(TAG, "长连接拉消息的消息body" + this.mBody);
        } catch (JSONException e2) {
            LogUtils.e(TAG, "Exception ", e2);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
        }
    }

    public int getCategory() {
        return this.mCategory;
    }

    public long getContacter() {
        return this.mContacter;
    }

    public int getCount() {
        return this.mCount;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i, String str) {
        LogUtils.d(TAG, "fetch handleMessageResult err : " + i + ", msg :" + str);
        super.handleMessageResult(context, jSONObject, i, str);
        TaskManager.getInstance(this.mContext).submitForNetWork(new FetchTask(context, jSONObject, i, str));
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void onMsgSending(Context context) {
        setSendingState(context);
    }

    public void setJumpToNewMsg(int i) {
        this.mJumpToRecent = i;
    }
}
