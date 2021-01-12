package com.baidu.android.imsdk.chatmessage.messages;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.chatmessage.ISendMessageStatusListener;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.log.LogConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class ChatMsg implements Parcelable, NoProGuard {
    public static final int MSG_FORM_OTHER_DEVICE = 2;
    public static final int MSG_FROM_SAME_DEVICE = 1;
    private static final String TAG = "ChatMsg";
    private static final int VERSION = 1;
    private static AtomicInteger mOpenCounter = new AtomicInteger(1);
    private static Random mRandom = null;
    private long expiresTime;
    private boolean isMediaRoleMsg;
    private long mAppId;
    private int mArrayIndex;
    private List<Long> mAtuks;
    private List<Long> mCastids;
    private int mCategory;
    private int mChatType;
    private long mContacter;
    private int mDeviceFlag;
    private String mExtJson;
    private String mExtLog;
    private String mExtraContent;
    private long mFromUser;
    private boolean mIsClicked;
    private int mIsRead;
    private boolean mIsZhida;
    public String mListenerKey;
    private String mLocalUrl;
    private long mMinSdkVersion;
    private long mMsgId;
    private String mMsgKey;
    private int mNotifyCmd;
    private long mPaid;
    private int mReSend;
    private long mRowId;
    private String mServiceType;
    private int mStatus;
    private int mSubChatType;
    private int mTemplateType;
    private long mTime;
    private String mTips;
    private int mTipsCode;
    private long mTriggerReasonn;
    private int mType;
    protected String mjsonContent;
    protected String mjsonContentExtra;
    protected String mjsonStarExtra;
    private String sendMsgId;
    private String senderUid;
    private String toBduid;

    public abstract String getRecommendDescription();

    protected abstract boolean parseJsonString();

    public ChatMsg() {
        this.mIsRead = 0;
        this.mMsgId = 0L;
        this.mTime = 0L;
        this.mFromUser = 0L;
        this.mType = 0;
        this.mAppId = 0L;
        this.mStatus = 1;
        this.mRowId = -1L;
        this.mArrayIndex = 0;
        this.mCategory = -1;
        this.mContacter = -1L;
        this.mMinSdkVersion = -1L;
        this.mTriggerReasonn = -1L;
        this.mNotifyCmd = -1;
        this.mReSend = 0;
        this.mLocalUrl = "";
        this.mMsgKey = "";
        this.mIsZhida = false;
        this.mIsClicked = false;
        this.mPaid = -1L;
        this.mExtJson = "";
        this.mExtLog = "";
        this.mChatType = -1;
        this.mSubChatType = -1;
        this.mDeviceFlag = 1;
        this.mAtuks = null;
        this.mCastids = null;
        this.expiresTime = 0L;
        this.isMediaRoleMsg = false;
        this.mTipsCode = 0;
        this.mTips = "";
        this.mTemplateType = 0;
        this.sendMsgId = generateSendMsgId();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ChatMsg(Parcel parcel) {
        this.mIsRead = 0;
        this.mMsgId = 0L;
        this.mTime = 0L;
        this.mFromUser = 0L;
        this.mType = 0;
        this.mAppId = 0L;
        this.mStatus = 1;
        this.mRowId = -1L;
        this.mArrayIndex = 0;
        this.mCategory = -1;
        this.mContacter = -1L;
        this.mMinSdkVersion = -1L;
        this.mTriggerReasonn = -1L;
        this.mNotifyCmd = -1;
        this.mReSend = 0;
        this.mLocalUrl = "";
        this.mMsgKey = "";
        this.mIsZhida = false;
        this.mIsClicked = false;
        this.mPaid = -1L;
        this.mExtJson = "";
        this.mExtLog = "";
        this.mChatType = -1;
        this.mSubChatType = -1;
        this.mDeviceFlag = 1;
        this.mAtuks = null;
        this.mCastids = null;
        this.expiresTime = 0L;
        this.isMediaRoleMsg = false;
        this.mTipsCode = 0;
        this.mTips = "";
        this.mTemplateType = 0;
        this.mMsgId = parcel.readLong();
        this.mTime = parcel.readLong();
        this.mFromUser = parcel.readLong();
        this.mCategory = parcel.readInt();
        this.mType = parcel.readInt();
        this.mIsRead = parcel.readInt();
        this.mStatus = parcel.readInt();
        this.mjsonContent = parcel.readString();
        this.mjsonContentExtra = parcel.readString();
        this.mExtraContent = parcel.readString();
        this.mRowId = parcel.readLong();
        this.mArrayIndex = parcel.readInt();
        this.mCategory = parcel.readInt();
        this.mContacter = parcel.readLong();
        this.mNotifyCmd = parcel.readInt();
        this.mReSend = parcel.readInt();
        this.mLocalUrl = parcel.readString();
        this.mIsZhida = parcel.readInt() == 1;
        this.mIsClicked = parcel.readInt() == 1;
        this.mPaid = parcel.readLong();
        this.mExtJson = parcel.readString();
        this.mExtLog = parcel.readString();
        this.mChatType = parcel.readInt();
        this.mSubChatType = parcel.readInt();
        this.mDeviceFlag = parcel.readInt();
        this.mListenerKey = parcel.readString();
        this.sendMsgId = parcel.readString();
        this.senderUid = parcel.readString();
        this.toBduid = parcel.readString();
        this.mMinSdkVersion = parcel.readLong();
        this.mTriggerReasonn = parcel.readLong();
        this.mjsonStarExtra = parcel.readString();
        this.mMsgKey = parcel.readString();
        this.mAtuks = new ArrayList();
        parcel.readList(this.mAtuks, Long.class.getClassLoader());
        this.mCastids = new ArrayList();
        parcel.readList(this.mCastids, Long.class.getClassLoader());
        this.expiresTime = parcel.readLong();
        this.mServiceType = parcel.readString();
        this.mTipsCode = parcel.readInt();
        this.mTips = parcel.readString();
        this.mTemplateType = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int getVersion() {
        return 1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mMsgId);
        parcel.writeLong(this.mTime);
        parcel.writeLong(this.mFromUser);
        parcel.writeInt(this.mCategory);
        parcel.writeInt(this.mType);
        parcel.writeInt(this.mIsRead);
        parcel.writeInt(this.mStatus);
        parcel.writeString(this.mjsonContent);
        parcel.writeString(this.mjsonContentExtra);
        parcel.writeString(this.mExtraContent);
        parcel.writeLong(this.mRowId);
        parcel.writeInt(this.mArrayIndex);
        parcel.writeInt(this.mCategory);
        parcel.writeLong(this.mContacter);
        parcel.writeInt(this.mNotifyCmd);
        parcel.writeInt(this.mReSend);
        parcel.writeString(this.mLocalUrl);
        parcel.writeInt(this.mIsZhida ? 1 : 0);
        parcel.writeInt(this.mIsClicked ? 1 : 0);
        parcel.writeLong(this.mPaid);
        parcel.writeString(this.mExtJson);
        parcel.writeString(this.mExtLog);
        parcel.writeInt(this.mChatType);
        parcel.writeInt(this.mSubChatType);
        parcel.writeInt(this.mDeviceFlag);
        parcel.writeString(this.mListenerKey);
        parcel.writeString(this.sendMsgId);
        parcel.writeString(this.senderUid);
        parcel.writeString(this.toBduid);
        parcel.writeLong(this.mMinSdkVersion);
        parcel.writeLong(this.mTriggerReasonn);
        parcel.writeString(this.mjsonStarExtra);
        parcel.writeString(this.mMsgKey);
        parcel.writeList(this.mAtuks);
        parcel.writeList(this.mCastids);
        parcel.writeLong(this.expiresTime);
        parcel.writeString(this.mServiceType);
        parcel.writeInt(this.mTipsCode);
        parcel.writeString(this.mTips);
        parcel.writeInt(this.mTemplateType);
    }

    public void setReSend() {
        this.mReSend = 1;
    }

    public boolean isReSend() {
        return this.mReSend == 1;
    }

    public String getSenderUid() {
        return this.senderUid;
    }

    public String getToBduid() {
        return this.toBduid;
    }

    public void setSenderUid(String str) {
        try {
            Long.valueOf(str);
            this.senderUid = str;
        } catch (NumberFormatException e) {
            LogUtils.e(TAG, "setSenderUid " + str + " , mType : " + this.mType);
            this.senderUid = "0";
        }
    }

    public void setContacterBduid(String str) {
        this.toBduid = str;
    }

    public String getContacterId() {
        return this.mCategory == 0 ? this.senderUid : String.valueOf(this.mContacter);
    }

    public long getFromUser() {
        return this.mFromUser;
    }

    public void setFromUser(long j) {
        this.mFromUser = j;
    }

    public boolean setMsgContent(String str) {
        this.mjsonContent = str;
        return parseJsonString() && parseExt();
    }

    public boolean setMsgContentFromServer(String str) {
        this.mjsonContent = str;
        return parseJsonString() && parseCommon();
    }

    protected boolean parseExt() {
        LogUtils.d(TAG, "parseExt");
        if (TextUtils.isEmpty(this.mjsonContent)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.mjsonContent);
            if (jSONObject.has("ext")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("ext");
                this.mExtJson = jSONObject2.toString();
                if (jSONObject2.has("push_exts")) {
                    JSONObject jSONObject3 = jSONObject2.getJSONObject("push_exts");
                    if (jSONObject3.has(LogConfig.LOG_EXT_LOG)) {
                        setExtLog(jSONObject3.optString(LogConfig.LOG_EXT_LOG));
                    }
                }
            }
            if (jSONObject.has("extra")) {
                this.mjsonContentExtra = jSONObject.optString("extra");
            }
            if (jSONObject.has("stargroupext")) {
                this.mjsonStarExtra = jSONObject.optString("stargroupext");
            }
            if (jSONObject.has(LogConfig.LOG_EXT_LOG)) {
                setExtLog(jSONObject.optString(LogConfig.LOG_EXT_LOG));
            }
            if (jSONObject.has(Constants.EXTRA_TRIGGER_REASON)) {
                setTriggerReasonn(jSONObject.optLong(Constants.EXTRA_TRIGGER_REASON));
            }
            return true;
        } catch (JSONException e) {
            LogUtils.e(TAG, "parseJsonString", e);
            return false;
        }
    }

    protected boolean parseCommon() {
        LogUtils.d(TAG, "parseCommon " + this.mContacter + " ---->: " + this.mjsonContent);
        if (TextUtils.isEmpty(this.mjsonContent)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.mjsonContent);
            if (jSONObject.has("ext")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("ext");
                this.mExtJson = jSONObject2.toString();
                if (jSONObject2.has("push_exts")) {
                    JSONObject jSONObject3 = jSONObject2.getJSONObject("push_exts");
                    if (jSONObject3.has(LogConfig.LOG_EXT_LOG)) {
                        setExtLog(jSONObject3.optString(LogConfig.LOG_EXT_LOG));
                    }
                }
            }
            if (jSONObject.has("extra")) {
                this.mjsonContentExtra = jSONObject.optString("extra");
            }
            if (jSONObject.has("stargroupext")) {
                this.mjsonStarExtra = jSONObject.optString("stargroupext");
            }
            if (jSONObject.has(LogConfig.LOG_EXT_LOG)) {
                setExtLog(jSONObject.optString(LogConfig.LOG_EXT_LOG));
            }
            setSenderUid(jSONObject.optString("buid"));
            return true;
        } catch (JSONException e) {
            LogUtils.e(TAG, "parseJsonString", e);
            return false;
        }
    }

    public String getExt() {
        if (TextUtils.isEmpty(this.mExtJson)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("notify", 1);
                this.mExtJson = jSONObject.toString();
            } catch (JSONException e) {
                LogUtils.i(TAG, "put notify JSONException!");
            }
        }
        if (isMsgRead()) {
            try {
                JSONObject jSONObject2 = new JSONObject(this.mExtJson);
                jSONObject2.put("notify", 0);
                this.mExtJson = jSONObject2.toString();
            } catch (JSONException e2) {
                LogUtils.i(TAG, "put notify JSONException!");
            }
        }
        return this.mExtJson;
    }

    public boolean isStarMessage() {
        if (TextUtils.isEmpty(this.mExtJson)) {
            return false;
        }
        try {
            if (new JSONObject(this.mExtJson).optInt("sub_app_identity", -1) != 4) {
                return false;
            }
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isNotifyMessage() {
        if ((this.mType < 1001 || this.mType > 1012) && this.mType != 2010) {
            return false;
        }
        return true;
    }

    public boolean isDumiMessage() {
        if (TextUtils.isEmpty(this.mExtJson)) {
            return false;
        }
        try {
            if (new JSONObject(this.mExtJson).optInt("sub_app_identity", -1) != 100) {
                return false;
            }
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isGalleryMsg() {
        if (TextUtils.isEmpty(this.mExtJson)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.mExtJson);
            if (jSONObject.optInt("sub_app_identity", -1) != 7) {
                if (jSONObject.optInt("sub_app_identity", -1) != 16) {
                    return false;
                }
            }
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void setmExtJson(String str) {
        this.mExtJson = str;
    }

    public String getmExtJson() {
        return this.mExtJson;
    }

    public String getContentExtra() {
        return this.mjsonContentExtra;
    }

    public void setContentExtra(String str) {
        this.mjsonContentExtra = str;
    }

    public String getStarContentExtra() {
        return this.mjsonStarExtra;
    }

    public void setStarContentExtra(String str) {
        this.mjsonStarExtra = str;
    }

    public String getMsgContent() {
        return this.mjsonContent;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0092 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getSendMsgContent() {
        JSONObject jSONObject;
        try {
            if ((this.mChatType == 7 || this.mChatType == 16 || this.mChatType == 25 || this.mType == 18) && !TextUtils.isEmpty(this.mExtraContent)) {
                jSONObject = new JSONObject(this.mExtraContent);
            } else if (this.mjsonContent != null) {
                jSONObject = new JSONObject(this.mjsonContent);
            } else {
                jSONObject = new JSONObject();
            }
        } catch (Exception e) {
            e = e;
            jSONObject = null;
        }
        try {
            jSONObject.put("buid", this.senderUid);
            if (this.mChatType == 0) {
                jSONObject.put("tobuid", this.toBduid);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("sub_app_identity", String.valueOf(this.mChatType));
            if (this.mMinSdkVersion > -1) {
                jSONObject2.put("min_sdk_version", this.mMinSdkVersion);
            }
            if (this.mSubChatType == 21) {
                jSONObject2.put("sub_pa_type", 21);
            }
            jSONObject.put("ext", jSONObject2);
            if (!TextUtils.isEmpty(this.mjsonContentExtra)) {
                jSONObject.put("extra", this.mjsonContentExtra);
            }
            if (!TextUtils.isEmpty(this.mjsonStarExtra)) {
                jSONObject.put("stargroupext", this.mjsonStarExtra);
            }
        } catch (Exception e2) {
            e = e2;
            LogUtils.e(TAG, "getMsgContent Json", e);
            if (jSONObject != null) {
            }
        }
        if (jSONObject != null) {
            return null;
        }
        return jSONObject.toString();
    }

    public JSONObject getMsgString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("category", this.mCategory);
            jSONObject.put("contacter", this.mContacter);
            jSONObject.put("create_time", getMsgTime());
            jSONObject.put("from_user", this.mFromUser);
            jSONObject.put("is_read", this.mIsRead);
            jSONObject.put("msg_key", this.mMsgKey);
            jSONObject.put("msgid", this.mMsgId);
            jSONObject.put("priority", 15);
            jSONObject.put("type", this.mType);
            JSONObject jSONObject2 = new JSONObject(getSendMsgContent());
            if (jSONObject2.has("text")) {
                Object obj = jSONObject2.get("text");
                if (obj instanceof String) {
                    jSONObject2.put("text", new JSONObject((String) obj));
                }
            }
            jSONObject.put("content", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public void parseForwardmessage(int i) {
        if (this.mjsonContent != null) {
            try {
                JSONObject jSONObject = new JSONObject(this.mjsonContent);
                jSONObject.put("buid", this.senderUid);
                if (this.mChatType == 0) {
                    jSONObject.put("tobuid", this.toBduid);
                }
                JSONObject jSONObject2 = new JSONObject();
                if (jSONObject.has("ext")) {
                    jSONObject2 = new JSONObject(jSONObject.optString("ext"));
                }
                jSONObject2.put("sub_app_identity", String.valueOf(this.mChatType));
                if (this.mMinSdkVersion > -1) {
                    jSONObject2.put("min_sdk_version", this.mMinSdkVersion);
                }
                jSONObject.put("ext", jSONObject2);
                if (!TextUtils.isEmpty(this.mjsonContentExtra)) {
                    jSONObject.put("extra", this.mjsonContentExtra);
                }
                if (!TextUtils.isEmpty(this.mjsonStarExtra)) {
                    jSONObject.put("stargroupext", this.mjsonStarExtra);
                }
                this.mjsonContent = jSONObject.toString();
            } catch (JSONException e) {
                LogUtils.e(TAG, "getMsgContent Json", e);
            }
        }
        parseExt();
    }

    public void setMsgType(int i) {
        this.mType = i;
    }

    public int getMsgType() {
        return this.mType;
    }

    public boolean isMsgRead() {
        return this.mIsRead == 1;
    }

    public void setMsgReaded(int i) {
        this.mIsRead = i;
    }

    public void setMsgId(long j) {
        this.mMsgId = j;
    }

    public long getMsgId() {
        return this.mMsgId;
    }

    public String getSendMsgId() {
        return this.sendMsgId;
    }

    public void setSendMsgId(String str) {
        this.sendMsgId = str;
    }

    public long getMsgTime() {
        return this.mTime;
    }

    public void setMsgTime(long j) {
        this.mTime = j;
    }

    public void setAppId(long j) {
        this.mAppId = j;
    }

    public boolean isMsgSendSuccess() {
        return this.mStatus == 0;
    }

    public String getJsonContent() {
        return this.mjsonContent;
    }

    public void setStatus(int i) {
        this.mStatus = i;
        notifyMsgStatus(i);
    }

    public void setSendMessageStatusListener(ISendMessageStatusListener iSendMessageStatusListener) {
        this.mListenerKey = ListenerManager.getInstance().addListener(iSendMessageStatusListener);
    }

    private void notifyMsgStatus(int i) {
        ISendMessageStatusListener iSendMessageStatusListener;
        if (this.mListenerKey != null) {
            if ((i == 0 || i == 2) && (iSendMessageStatusListener = (ISendMessageStatusListener) ListenerManager.getInstance().removeListener(this.mListenerKey)) != null) {
                iSendMessageStatusListener.onSendStatus(i, this);
            }
        }
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setListenerKey(String str) {
        this.mListenerKey = str;
    }

    public void setRowId(long j) {
        this.mRowId = j;
    }

    public long getRowId() {
        return this.mRowId;
    }

    public long getPaid() {
        return this.mPaid;
    }

    public void setPaid(long j) {
        this.mPaid = j;
    }

    public int getCategory() {
        return this.mCategory;
    }

    public void setCategory(int i) {
        this.mCategory = i;
    }

    public long getContacter() {
        return this.mContacter;
    }

    public void setContacter(long j) {
        this.mContacter = j;
    }

    public int getNotifyCmd() {
        return this.mNotifyCmd;
    }

    public void setNotifyCmd(int i) {
        this.mNotifyCmd = i;
    }

    public String getLocalUrl() {
        return this.mLocalUrl;
    }

    public void setLocalUrl(String str) {
        this.mLocalUrl = str;
    }

    public String getExtraContent() {
        return this.mExtraContent;
    }

    public void setExtraContent(String str) {
        this.mExtraContent = str;
    }

    public String toString() {
        return " ChatMsg:[ type=" + this.mType + " , category=" + this.mCategory + " , fromid=" + this.mFromUser + " , senduid=" + this.senderUid + " , contacterId=" + this.mContacter + ", json=" + this.mjsonContent + " , msgId=" + this.mMsgId + " , sendmsgid = " + this.sendMsgId + ", isread=" + this.mIsRead + " , time=" + this.mTime + " , triggerReasonn=" + this.mTriggerReasonn + "]";
    }

    public long getAppId() {
        return this.mAppId;
    }

    public String getMsgKey() {
        return this.mMsgKey;
    }

    public void setMsgKey(String str) {
        this.mMsgKey = str;
    }

    public void setIsZhida(boolean z) {
        this.mIsZhida = z;
    }

    public boolean isZhida() {
        return this.mIsZhida;
    }

    public void setIsClicked(boolean z) {
        this.mIsClicked = z;
    }

    public void markClicked(final Context context) {
        setIsClicked(true);
        TaskManager.getInstance(context).submitForLocalOperation(new Runnable() { // from class: com.baidu.android.imsdk.chatmessage.messages.ChatMsg.1
            @Override // java.lang.Runnable
            public void run() {
                ChatMessageDBManager.getInstance(context).markMsgClicked(ChatMsg.this);
            }
        });
    }

    public boolean isClicked() {
        return this.mIsClicked;
    }

    public int getChatType() {
        return this.mChatType;
    }

    public void setChatType(int i) {
        this.mChatType = i;
    }

    public int getSubChatType() {
        return this.mSubChatType;
    }

    public void setSubChatType(int i) {
        this.mSubChatType = i;
    }

    public int getClickedState() {
        return this.mIsClicked ? 1 : 0;
    }

    public boolean isSelf(Context context) {
        return this.mFromUser == Utility.getUK(context);
    }

    public final int getRealMsgType() {
        return this.mType;
    }

    public final boolean isSameDevice() {
        return this.mDeviceFlag == 1;
    }

    public final void setDeviceFlag(int i) {
        this.mDeviceFlag = i;
    }

    public final int getDeviceFlag() {
        return this.mDeviceFlag;
    }

    public void createMsgKey(Context context) {
        if (context != null) {
            if (mRandom == null) {
                synchronized (ChatMsg.class) {
                    if (mRandom == null) {
                        mRandom = new Random(System.currentTimeMillis());
                    }
                }
            }
            this.mMsgKey = Utility.byte2Hex(long2bytes(((System.currentTimeMillis() & 1048575) << 20) + ((Utility.getTriggerId(context) & 1023) << 10) + (mRandom.nextInt(1024) & 1023), 5));
        }
    }

    public void setAtUsers(List<Long> list) {
        this.mAtuks = list;
        if (this.mAtuks != null && this.mAtuks.size() > 0) {
            LogUtils.d(TAG, " setAtUsers " + this.mAtuks);
        }
    }

    public List<Long> getAtUsers() {
        return this.mAtuks;
    }

    public void setCastid(List<Long> list) {
        this.mCastids = list;
    }

    public List<Long> getCastids() {
        return this.mCastids;
    }

    public String getExtLog() {
        return this.mExtLog;
    }

    public void setExtLog(String str) {
        this.mExtLog = str;
    }

    private static byte[] long2bytes(long j, int i) {
        byte[] bArr = new byte[i];
        for (int i2 = i - 1; i2 >= 0; i2--) {
            bArr[i2] = (byte) (255 & j);
            j >>= 8;
        }
        return bArr;
    }

    private static String removeZero(String str) {
        int lastIndexOf;
        if (str == null || str.length() == 0 || (lastIndexOf = str.lastIndexOf(48)) == str.length() - 1) {
            return "";
        }
        return str.substring(lastIndexOf + 1);
    }

    private synchronized String generateSendMsgId() {
        return System.currentTimeMillis() + "" + mOpenCounter.incrementAndGet();
    }

    public long getMinSdkVersion() {
        return this.mMinSdkVersion;
    }

    public void setMinSdkVersion(long j) {
        this.mMinSdkVersion = j;
    }

    public long getTriggerReasonn() {
        return this.mTriggerReasonn;
    }

    public void setTriggerReasonn(long j) {
        this.mTriggerReasonn = j;
    }

    public long getExpiresTime() {
        return this.expiresTime;
    }

    public void setExpiresTime(long j) {
        this.expiresTime = j;
    }

    public String getServiceType() {
        return this.mServiceType;
    }

    public void setServiceType(String str) {
        this.mServiceType = str;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x006d -> B:19:0x006a). Please submit an issue!!! */
    public boolean shouldAbandonMsg(Context context) {
        if (this.mType == 0 || this.mType == 20) {
            String ext = getExt();
            if (!TextUtils.isEmpty(ext)) {
                try {
                    JSONObject jSONObject = new JSONObject(ext);
                    if (jSONObject.has("to_cuid")) {
                        String optString = jSONObject.optString("to_cuid");
                        if (!TextUtils.equals(optString.substring(0, optString.lastIndexOf("|")), Utility.getDeviceId(context).substring(0, optString.lastIndexOf("|")))) {
                            LogUtils.d(TAG, "CUID is not equal, will abandon this message!");
                            return true;
                        }
                    }
                    if (jSONObject.has("sub_app_identity") && jSONObject.optInt("sub_app_identity") == 6) {
                        return true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    public boolean isMediaRoleMsg() {
        return this.isMediaRoleMsg;
    }

    public void setMediaRoleMsg(boolean z) {
        this.isMediaRoleMsg = z;
    }

    public int getTipsCode() {
        return this.mTipsCode;
    }

    public String getTips() {
        return this.mTips;
    }

    public void setTipsCode(int i) {
        this.mTipsCode = i;
    }

    public void setTips(String str) {
        this.mTips = str;
    }

    public void setTemplateType(int i) {
        this.mTemplateType = i;
    }

    public int getTemplateType() {
        return this.mTemplateType;
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("content", getJsonContent());
            jSONObject.put("msgid", getMsgId());
            jSONObject.put("type", getMsgType());
            jSONObject.put("time", getMsgTime());
            jSONObject.put("status", getStatus());
            jSONObject.put(BdStatsConstant.StatsType.ERROR, getTipsCode());
        } catch (JSONException e) {
            LogUtils.e(TAG, "toJsonString exception ", e);
        }
        return jSONObject.toString();
    }
}
