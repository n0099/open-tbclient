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
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class ChatMsg implements Parcelable, NoProGuard {
    public static final int MSG_FORM_OTHER_DEVICE = 2;
    public static final int MSG_FROM_SAME_DEVICE = 1;
    public static final String TAG = "ChatMsg";
    public static final int VERSION = 1;
    public static AtomicInteger mOpenCounter = new AtomicInteger(1);
    public static Random mRandom = null;
    public long expiresTime;
    public boolean isMediaRoleMsg;
    public long mAppId;
    public int mArrayIndex;
    public List<Long> mAtuks;
    public List<Long> mCastids;
    public int mCategory;
    public int mChatType;
    public long mContacter;
    public int mDeviceFlag;
    public String mExtJson;
    public String mExtLog;
    public String mExtraContent;
    public long mFromUser;
    public boolean mIsClicked;
    public int mIsRead;
    public boolean mIsZhida;
    public String mListenerKey;
    public String mLocalUrl;
    public long mMinSdkVersion;
    public long mMsgId;
    public String mMsgKey;
    public int mNotifyCmd;
    public long mPaid;
    public int mReSend;
    public long mRowId;
    public String mServiceType;
    public int mStatus;
    public int mSubChatType;
    public int mTemplateType;
    public long mTime;
    public String mTips;
    public int mTipsCode;
    public long mTriggerReasonn;
    public int mType;
    public String mjsonContent;
    public String mjsonContentExtra;
    public String mjsonStarExtra;
    public String sendMsgId;
    public String senderUid;
    public String toBduid;

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

    private synchronized String generateSendMsgId() {
        return System.currentTimeMillis() + "" + mOpenCounter.incrementAndGet();
    }

    public static byte[] long2bytes(long j, int i2) {
        byte[] bArr = new byte[i2];
        for (int i3 = i2 - 1; i3 >= 0; i3--) {
            bArr[i3] = (byte) (255 & j);
            j >>= 8;
        }
        return bArr;
    }

    private void notifyMsgStatus(int i2) {
        ISendMessageStatusListener iSendMessageStatusListener;
        if (this.mListenerKey == null) {
            return;
        }
        if ((i2 == 0 || i2 == 2) && (iSendMessageStatusListener = (ISendMessageStatusListener) ListenerManager.getInstance().removeListener(this.mListenerKey)) != null) {
            iSendMessageStatusListener.onSendStatus(i2, this);
        }
    }

    public static String removeZero(String str) {
        int lastIndexOf;
        return (str == null || str.length() == 0 || (lastIndexOf = str.lastIndexOf(48)) == str.length() + (-1)) ? "" : str.substring(lastIndexOf + 1);
    }

    public void createMsgKey(Context context) {
        if (context == null) {
            return;
        }
        if (mRandom == null) {
            synchronized (ChatMsg.class) {
                if (mRandom == null) {
                    mRandom = new Random(System.currentTimeMillis());
                }
            }
        }
        this.mMsgKey = Utility.byte2Hex(long2bytes(((System.currentTimeMillis() & 1048575) << 20) + ((Utility.getTriggerId(context) & 1023) << 10) + (mRandom.nextInt(1024) & 1023), 5));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getAppId() {
        return this.mAppId;
    }

    public List<Long> getAtUsers() {
        return this.mAtuks;
    }

    public List<Long> getCastids() {
        return this.mCastids;
    }

    public int getCategory() {
        return this.mCategory;
    }

    public int getChatType() {
        return this.mChatType;
    }

    public int getClickedState() {
        return this.mIsClicked ? 1 : 0;
    }

    public long getContacter() {
        return this.mContacter;
    }

    public String getContacterId() {
        if (this.mCategory == 0) {
            return this.senderUid;
        }
        return String.valueOf(this.mContacter);
    }

    public String getContentExtra() {
        return this.mjsonContentExtra;
    }

    public final int getDeviceFlag() {
        return this.mDeviceFlag;
    }

    public long getExpiresTime() {
        return this.expiresTime;
    }

    public String getExt() {
        if (TextUtils.isEmpty(this.mExtJson)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("notify", 1);
                this.mExtJson = jSONObject.toString();
            } catch (JSONException unused) {
                LogUtils.i(TAG, "put notify JSONException!");
            }
        }
        if (isMsgRead()) {
            try {
                JSONObject jSONObject2 = new JSONObject(this.mExtJson);
                jSONObject2.put("notify", 0);
                this.mExtJson = jSONObject2.toString();
            } catch (JSONException unused2) {
                LogUtils.i(TAG, "put notify JSONException!");
            }
        }
        return this.mExtJson;
    }

    public String getExtLog() {
        return this.mExtLog;
    }

    public String getExtraContent() {
        return this.mExtraContent;
    }

    public long getFromUser() {
        return this.mFromUser;
    }

    public int getGroupType() {
        if (TextUtils.isEmpty(this.mExtJson)) {
            return 1;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.mExtJson);
            if (jSONObject.has("group_type")) {
                return jSONObject.getInt("group_type");
            }
            return (jSONObject.has("sub_app_identity") && jSONObject.getInt("sub_app_identity") == 57) ? 3 : 1;
        } catch (JSONException unused) {
            return 1;
        }
    }

    public String getJsonContent() {
        return this.mjsonContent;
    }

    public String getLocalUrl() {
        return this.mLocalUrl;
    }

    public long getMinSdkVersion() {
        return this.mMinSdkVersion;
    }

    public String getMsgContent() {
        return this.mjsonContent;
    }

    public long getMsgId() {
        return this.mMsgId;
    }

    public String getMsgKey() {
        return this.mMsgKey;
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
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public long getMsgTime() {
        return this.mTime;
    }

    public int getMsgType() {
        return this.mType;
    }

    public int getNotifyCmd() {
        return this.mNotifyCmd;
    }

    public long getPaid() {
        return this.mPaid;
    }

    public final int getRealMsgType() {
        return this.mType;
    }

    public abstract String getRecommendDescription();

    public long getRowId() {
        return this.mRowId;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00aa A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getSendMsgContent() {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        try {
            if ((this.mChatType == 7 || this.mChatType == 16 || this.mChatType == 25 || this.mType == 18) && !TextUtils.isEmpty(this.mExtraContent)) {
                jSONObject2 = new JSONObject(this.mExtraContent);
            } else if (this.mjsonContent != null) {
                jSONObject2 = new JSONObject(this.mjsonContent);
            } else {
                jSONObject2 = new JSONObject();
            }
        } catch (Exception e2) {
            e = e2;
            jSONObject = null;
        }
        try {
            jSONObject2.put("buid", this.senderUid);
            if (this.mChatType == 0) {
                jSONObject2.put("tobuid", this.toBduid);
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("sub_app_identity", String.valueOf(this.mChatType));
            if (this.mMinSdkVersion > -1) {
                jSONObject3.put("min_sdk_version", this.mMinSdkVersion);
            }
            if (this.mSubChatType == 21) {
                jSONObject3.put("sub_pa_type", 21);
            }
            jSONObject2.put("ext", jSONObject3);
            if (!TextUtils.isEmpty(this.mjsonContentExtra)) {
                jSONObject2.put("extra", this.mjsonContentExtra);
            }
            if (!TextUtils.isEmpty(this.mjsonStarExtra)) {
                jSONObject2.put("stargroupext", this.mjsonStarExtra);
            }
        } catch (Exception e3) {
            jSONObject = jSONObject2;
            e = e3;
            LogUtils.e(TAG, "getMsgContent Json", e);
            jSONObject2 = jSONObject;
            if (jSONObject2 != null) {
            }
        }
        if (jSONObject2 != null) {
            return null;
        }
        return jSONObject2.toString();
    }

    public String getSendMsgId() {
        return this.sendMsgId;
    }

    public String getSenderUid() {
        return this.senderUid;
    }

    public String getServiceType() {
        return this.mServiceType;
    }

    public String getStarContentExtra() {
        return this.mjsonStarExtra;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public int getSubChatType() {
        return this.mSubChatType;
    }

    public int getTemplateType() {
        return this.mTemplateType;
    }

    public String getTips() {
        return this.mTips;
    }

    public int getTipsCode() {
        return this.mTipsCode;
    }

    public String getToBduid() {
        return this.toBduid;
    }

    public long getTriggerReasonn() {
        return this.mTriggerReasonn;
    }

    public final int getVersion() {
        return 1;
    }

    public String getmExtJson() {
        return this.mExtJson;
    }

    public boolean isClicked() {
        return this.mIsClicked;
    }

    public boolean isDumiMessage() {
        if (TextUtils.isEmpty(this.mExtJson)) {
            return false;
        }
        try {
            return new JSONObject(this.mExtJson).optInt("sub_app_identity", -1) == 100;
        } catch (JSONException e2) {
            e2.printStackTrace();
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
                return jSONObject.optInt("sub_app_identity", -1) == 16;
            }
            return true;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public boolean isMediaRoleMsg() {
        return this.isMediaRoleMsg;
    }

    public boolean isMsgRead() {
        return this.mIsRead == 1;
    }

    public boolean isMsgSendSuccess() {
        return this.mStatus == 0;
    }

    public boolean isNotifyMessage() {
        int i2 = this.mType;
        return (i2 >= 1001 && i2 <= 1014) || this.mType == 2010;
    }

    public boolean isReSend() {
        return this.mReSend == 1;
    }

    public final boolean isSameDevice() {
        return this.mDeviceFlag == 1;
    }

    public boolean isSelf(Context context) {
        return this.mFromUser == Utility.getUK(context);
    }

    public boolean isStarMessage() {
        if (TextUtils.isEmpty(this.mExtJson)) {
            return false;
        }
        try {
            return new JSONObject(this.mExtJson).optInt("sub_app_identity", -1) == 4;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public boolean isZhida() {
        return this.mIsZhida;
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

    public boolean parseCommon() {
        LogUtils.d(TAG, "parseCommon " + this.mContacter + " ---->: " + this.mjsonContent);
        if (!TextUtils.isEmpty(this.mjsonContent)) {
            try {
                JSONObject jSONObject = new JSONObject(this.mjsonContent);
                if (jSONObject.has("ext")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("ext");
                    this.mExtJson = jSONObject2.toString();
                    if (jSONObject2.has("push_exts")) {
                        JSONObject jSONObject3 = jSONObject2.getJSONObject("push_exts");
                        if (jSONObject3.has("ext_log")) {
                            setExtLog(jSONObject3.optString("ext_log"));
                        }
                    }
                }
                if (jSONObject.has("extra")) {
                    this.mjsonContentExtra = jSONObject.optString("extra");
                }
                if (jSONObject.has("stargroupext")) {
                    this.mjsonStarExtra = jSONObject.optString("stargroupext");
                }
                if (jSONObject.has("ext_log")) {
                    setExtLog(jSONObject.optString("ext_log"));
                }
                setSenderUid(jSONObject.optString("buid"));
                return true;
            } catch (JSONException e2) {
                LogUtils.e(TAG, "parseJsonString", e2);
            }
        }
        return false;
    }

    public boolean parseExt() {
        LogUtils.d(TAG, "parseExt");
        if (!TextUtils.isEmpty(this.mjsonContent)) {
            try {
                JSONObject jSONObject = new JSONObject(this.mjsonContent);
                if (jSONObject.has("ext")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("ext");
                    this.mExtJson = jSONObject2.toString();
                    if (jSONObject2.has("push_exts")) {
                        JSONObject jSONObject3 = jSONObject2.getJSONObject("push_exts");
                        if (jSONObject3.has("ext_log")) {
                            setExtLog(jSONObject3.optString("ext_log"));
                        }
                    }
                }
                if (jSONObject.has("extra")) {
                    this.mjsonContentExtra = jSONObject.optString("extra");
                }
                if (jSONObject.has("stargroupext")) {
                    this.mjsonStarExtra = jSONObject.optString("stargroupext");
                }
                if (jSONObject.has("ext_log")) {
                    setExtLog(jSONObject.optString("ext_log"));
                }
                if (jSONObject.has(Constants.EXTRA_TRIGGER_REASON)) {
                    setTriggerReasonn(jSONObject.optLong(Constants.EXTRA_TRIGGER_REASON));
                }
                return true;
            } catch (JSONException e2) {
                LogUtils.e(TAG, "parseJsonString", e2);
            }
        }
        return false;
    }

    public void parseForwardmessage(int i2) {
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
            } catch (JSONException e2) {
                LogUtils.e(TAG, "getMsgContent Json", e2);
            }
        }
        parseExt();
    }

    public abstract boolean parseJsonString();

    public void setAppId(long j) {
        this.mAppId = j;
    }

    public void setAtUsers(List<Long> list) {
        this.mAtuks = list;
        if (list == null || list.size() <= 0) {
            return;
        }
        LogUtils.d(TAG, " setAtUsers " + this.mAtuks);
    }

    public void setCastid(List<Long> list) {
        this.mCastids = list;
    }

    public void setCategory(int i2) {
        this.mCategory = i2;
    }

    public void setChatType(int i2) {
        this.mChatType = i2;
    }

    public void setContacter(long j) {
        this.mContacter = j;
    }

    public void setContacterBduid(String str) {
        this.toBduid = str;
    }

    public void setContentExtra(String str) {
        this.mjsonContentExtra = str;
    }

    public final void setDeviceFlag(int i2) {
        this.mDeviceFlag = i2;
    }

    public void setExpiresTime(long j) {
        this.expiresTime = j;
    }

    public void setExtLog(String str) {
        this.mExtLog = str;
    }

    public void setExtraContent(String str) {
        this.mExtraContent = str;
    }

    public void setFromUser(long j) {
        this.mFromUser = j;
    }

    public void setIsClicked(boolean z) {
        this.mIsClicked = z;
    }

    public void setIsZhida(boolean z) {
        this.mIsZhida = z;
    }

    public void setListenerKey(String str) {
        this.mListenerKey = str;
    }

    public void setLocalUrl(String str) {
        this.mLocalUrl = str;
    }

    public void setMediaRoleMsg(boolean z) {
        this.isMediaRoleMsg = z;
    }

    public void setMinSdkVersion(long j) {
        this.mMinSdkVersion = j;
    }

    public boolean setMsgContent(String str) {
        this.mjsonContent = str;
        return parseJsonString() && parseExt();
    }

    public boolean setMsgContentFromServer(String str) {
        this.mjsonContent = str;
        return parseJsonString() && parseCommon();
    }

    public void setMsgId(long j) {
        this.mMsgId = j;
    }

    public void setMsgKey(String str) {
        this.mMsgKey = str;
    }

    public void setMsgReaded(int i2) {
        this.mIsRead = i2;
    }

    public void setMsgTime(long j) {
        this.mTime = j;
    }

    public void setMsgType(int i2) {
        this.mType = i2;
    }

    public void setNotifyCmd(int i2) {
        this.mNotifyCmd = i2;
    }

    public void setPaid(long j) {
        this.mPaid = j;
    }

    public void setReSend() {
        this.mReSend = 1;
    }

    public void setRowId(long j) {
        this.mRowId = j;
    }

    public void setSendMessageStatusListener(ISendMessageStatusListener iSendMessageStatusListener) {
        this.mListenerKey = ListenerManager.getInstance().addListener(iSendMessageStatusListener);
    }

    public void setSendMsgId(String str) {
        this.sendMsgId = str;
    }

    public void setSenderUid(String str) {
        try {
            Long.valueOf(str);
            this.senderUid = str;
        } catch (NumberFormatException unused) {
            LogUtils.e(TAG, "setSenderUid " + str + " , mType : " + this.mType);
            this.senderUid = "0";
        }
    }

    public void setServiceType(String str) {
        this.mServiceType = str;
    }

    public void setStarContentExtra(String str) {
        this.mjsonStarExtra = str;
    }

    public void setStatus(int i2) {
        this.mStatus = i2;
        notifyMsgStatus(i2);
    }

    public void setSubChatType(int i2) {
        this.mSubChatType = i2;
    }

    public void setTemplateType(int i2) {
        this.mTemplateType = i2;
    }

    public void setTips(String str) {
        this.mTips = str;
    }

    public void setTipsCode(int i2) {
        this.mTipsCode = i2;
    }

    public void setTriggerReasonn(long j) {
        this.mTriggerReasonn = j;
    }

    public void setmExtJson(String str) {
        this.mExtJson = str;
    }

    public boolean shouldAbandonMsg(Context context) {
        int i2 = this.mType;
        if (i2 == 0 || i2 == 20) {
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
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return false;
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("content", getJsonContent());
            jSONObject.put("msgid", getMsgId());
            jSONObject.put("type", getMsgType());
            jSONObject.put("time", getMsgTime());
            jSONObject.put("status", getStatus());
            jSONObject.put("error", getTipsCode());
        } catch (JSONException e2) {
            LogUtils.e(TAG, "toJsonString exception ", e2);
        }
        return jSONObject.toString();
    }

    public String toString() {
        return " ChatMsg:[ type=" + this.mType + " , category=" + this.mCategory + " , fromid=" + this.mFromUser + " , senduid=" + this.senderUid + " , contacterId=" + this.mContacter + ", json=" + this.mjsonContent + " , msgId=" + this.mMsgId + " , sendmsgid = " + this.sendMsgId + ", isread=" + this.mIsRead + " , time=" + this.mTime + " , triggerReasonn=" + this.mTriggerReasonn + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
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
        ArrayList arrayList = new ArrayList();
        this.mAtuks = arrayList;
        parcel.readList(arrayList, Long.class.getClassLoader());
        ArrayList arrayList2 = new ArrayList();
        this.mCastids = arrayList2;
        parcel.readList(arrayList2, Long.class.getClassLoader());
        this.expiresTime = parcel.readLong();
        this.mServiceType = parcel.readString();
        this.mTipsCode = parcel.readInt();
        this.mTips = parcel.readString();
        this.mTemplateType = parcel.readInt();
    }
}
