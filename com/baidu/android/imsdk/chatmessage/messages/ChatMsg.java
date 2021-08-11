package com.baidu.android.imsdk.chatmessage.messages;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.ISendMessageStatusListener;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class ChatMsg implements Parcelable, NoProGuard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MSG_FORM_OTHER_DEVICE = 2;
    public static final int MSG_FROM_SAME_DEVICE = 1;
    public static final String TAG = "ChatMsg";
    public static final int VERSION = 1;
    public static AtomicInteger mOpenCounter;
    public static Random mRandom;
    public transient /* synthetic */ FieldHolder $fh;
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1875257778, "Lcom/baidu/android/imsdk/chatmessage/messages/ChatMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1875257778, "Lcom/baidu/android/imsdk/chatmessage/messages/ChatMsg;");
                return;
            }
        }
        mOpenCounter = new AtomicInteger(1);
        mRandom = null;
    }

    public ChatMsg() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
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
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            synchronized (this) {
                str = System.currentTimeMillis() + "" + mOpenCounter.incrementAndGet();
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public static byte[] long2bytes(long j2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)})) == null) {
            byte[] bArr = new byte[i2];
            for (int i3 = i2 - 1; i3 >= 0; i3--) {
                bArr[i3] = (byte) (255 & j2);
                j2 >>= 8;
            }
            return bArr;
        }
        return (byte[]) invokeCommon.objValue;
    }

    private void notifyMsgStatus(int i2) {
        ISendMessageStatusListener iSendMessageStatusListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(AdIconUtil.AD_TEXT_ID, this, i2) == null) || this.mListenerKey == null) {
            return;
        }
        if ((i2 == 0 || i2 == 2) && (iSendMessageStatusListener = (ISendMessageStatusListener) ListenerManager.getInstance().removeListener(this.mListenerKey)) != null) {
            iSendMessageStatusListener.onSendStatus(i2, this);
        }
    }

    public static String removeZero(String str) {
        InterceptResult invokeL;
        int lastIndexOf;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) ? (str == null || str.length() == 0 || (lastIndexOf = str.lastIndexOf(48)) == str.length() + (-1)) ? "" : str.substring(lastIndexOf + 1) : (String) invokeL.objValue;
    }

    public void createMsgKey(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, context) == null) || context == null) {
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
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public long getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mAppId : invokeV.longValue;
    }

    public List<Long> getAtUsers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mAtuks : (List) invokeV.objValue;
    }

    public List<Long> getCastids() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mCastids : (List) invokeV.objValue;
    }

    public int getCategory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mCategory : invokeV.intValue;
    }

    public int getChatType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mChatType : invokeV.intValue;
    }

    public int getClickedState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mIsClicked ? 1 : 0 : invokeV.intValue;
    }

    public long getContacter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mContacter : invokeV.longValue;
    }

    public String getContacterId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.mCategory == 0) {
                return this.senderUid;
            }
            return String.valueOf(this.mContacter);
        }
        return (String) invokeV.objValue;
    }

    public String getContentExtra() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mjsonContentExtra : (String) invokeV.objValue;
    }

    public final int getDeviceFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mDeviceFlag : invokeV.intValue;
    }

    public long getExpiresTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.expiresTime : invokeV.longValue;
    }

    public String getExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
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
        return (String) invokeV.objValue;
    }

    public String getExtLog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mExtLog : (String) invokeV.objValue;
    }

    public String getExtraContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mExtraContent : (String) invokeV.objValue;
    }

    public long getFromUser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mFromUser : invokeV.longValue;
    }

    public int getGroupType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
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
        return invokeV.intValue;
    }

    public String getJsonContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mjsonContent : (String) invokeV.objValue;
    }

    public String getLocalUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mLocalUrl : (String) invokeV.objValue;
    }

    public long getMinSdkVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mMinSdkVersion : invokeV.longValue;
    }

    public String getMsgContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.mjsonContent : (String) invokeV.objValue;
    }

    public long getMsgId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.mMsgId : invokeV.longValue;
    }

    public String getMsgKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.mMsgKey : (String) invokeV.objValue;
    }

    public JSONObject getMsgString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
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
        return (JSONObject) invokeV.objValue;
    }

    public long getMsgTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.mTime : invokeV.longValue;
    }

    public int getMsgType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.mType : invokeV.intValue;
    }

    public int getNotifyCmd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.mNotifyCmd : invokeV.intValue;
    }

    public long getPaid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.mPaid : invokeV.longValue;
    }

    public final int getRealMsgType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.mType : invokeV.intValue;
    }

    public abstract String getRecommendDescription();

    public long getRowId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.mRowId : invokeV.longValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00ae A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getSendMsgContent() {
        InterceptResult invokeV;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            try {
                if ((this.mChatType == 7 || this.mChatType == 16 || this.mChatType == 25 || this.mType == 18) && !TextUtils.isEmpty(this.mExtraContent)) {
                    jSONObject2 = new JSONObject(this.mExtraContent);
                } else if (this.mjsonContent != null) {
                    jSONObject2 = new JSONObject(this.mjsonContent);
                } else {
                    jSONObject2 = new JSONObject();
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
                } catch (Exception e2) {
                    jSONObject = jSONObject2;
                    e = e2;
                    LogUtils.e(TAG, "getMsgContent Json", e);
                    jSONObject2 = jSONObject;
                    if (jSONObject2 != null) {
                    }
                }
            } catch (Exception e3) {
                e = e3;
                jSONObject = null;
            }
            if (jSONObject2 != null) {
                return null;
            }
            return jSONObject2.toString();
        }
        return (String) invokeV.objValue;
    }

    public String getSendMsgId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.sendMsgId : (String) invokeV.objValue;
    }

    public String getSenderUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.senderUid : (String) invokeV.objValue;
    }

    public String getServiceType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.mServiceType : (String) invokeV.objValue;
    }

    public String getStarContentExtra() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.mjsonStarExtra : (String) invokeV.objValue;
    }

    public int getStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.mStatus : invokeV.intValue;
    }

    public int getSubChatType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.mSubChatType : invokeV.intValue;
    }

    public int getTemplateType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.mTemplateType : invokeV.intValue;
    }

    public String getTips() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.mTips : (String) invokeV.objValue;
    }

    public int getTipsCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.mTipsCode : invokeV.intValue;
    }

    public String getToBduid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.toBduid : (String) invokeV.objValue;
    }

    public long getTriggerReasonn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.mTriggerReasonn : invokeV.longValue;
    }

    public final int getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    public String getmExtJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.mExtJson : (String) invokeV.objValue;
    }

    public boolean isClicked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.mIsClicked : invokeV.booleanValue;
    }

    public boolean isDumiMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
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
        return invokeV.booleanValue;
    }

    public boolean isGalleryMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
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
        return invokeV.booleanValue;
    }

    public boolean isMediaRoleMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.isMediaRoleMsg : invokeV.booleanValue;
    }

    public boolean isMsgRead() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.mIsRead == 1 : invokeV.booleanValue;
    }

    public boolean isMsgSendSuccess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.mStatus == 0 : invokeV.booleanValue;
    }

    public boolean isNotifyMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            int i2 = this.mType;
            return (i2 >= 1001 && i2 <= 1014) || this.mType == 2010;
        }
        return invokeV.booleanValue;
    }

    public boolean isReSend() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.mReSend == 1 : invokeV.booleanValue;
    }

    public final boolean isSameDevice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.mDeviceFlag == 1 : invokeV.booleanValue;
    }

    public boolean isSelf(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048631, this, context)) == null) ? this.mFromUser == Utility.getUK(context) : invokeL.booleanValue;
    }

    public boolean isStarMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
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
        return invokeV.booleanValue;
    }

    public boolean isZhida() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.mIsZhida : invokeV.booleanValue;
    }

    public void markClicked(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, context) == null) {
            setIsClicked(true);
            TaskManager.getInstance(context).submitForLocalOperation(new Runnable(this, context) { // from class: com.baidu.android.imsdk.chatmessage.messages.ChatMsg.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ChatMsg this$0;
                public final /* synthetic */ Context val$context;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$context = context;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ChatMessageDBManager.getInstance(this.val$context).markMsgClicked(this.this$0);
                    }
                }
            });
        }
    }

    public boolean parseCommon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
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
        return invokeV.booleanValue;
    }

    public boolean parseExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
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
        return invokeV.booleanValue;
    }

    public void parseForwardmessage(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048637, this, i2) == null) {
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
    }

    public abstract boolean parseJsonString();

    public void setAppId(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048639, this, j2) == null) {
            this.mAppId = j2;
        }
    }

    public void setAtUsers(List<Long> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, list) == null) {
            this.mAtuks = list;
            if (list == null || list.size() <= 0) {
                return;
            }
            LogUtils.d(TAG, " setAtUsers " + this.mAtuks);
        }
    }

    public void setCastid(List<Long> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, list) == null) {
            this.mCastids = list;
        }
    }

    public void setCategory(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048642, this, i2) == null) {
            this.mCategory = i2;
        }
    }

    public void setChatType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048643, this, i2) == null) {
            this.mChatType = i2;
        }
    }

    public void setContacter(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048644, this, j2) == null) {
            this.mContacter = j2;
        }
    }

    public void setContacterBduid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, str) == null) {
            this.toBduid = str;
        }
    }

    public void setContentExtra(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, str) == null) {
            this.mjsonContentExtra = str;
        }
    }

    public final void setDeviceFlag(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048647, this, i2) == null) {
            this.mDeviceFlag = i2;
        }
    }

    public void setExpiresTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048648, this, j2) == null) {
            this.expiresTime = j2;
        }
    }

    public void setExtLog(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, str) == null) {
            this.mExtLog = str;
        }
    }

    public void setExtraContent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, str) == null) {
            this.mExtraContent = str;
        }
    }

    public void setFromUser(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048651, this, j2) == null) {
            this.mFromUser = j2;
        }
    }

    public void setIsClicked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048652, this, z) == null) {
            this.mIsClicked = z;
        }
    }

    public void setIsZhida(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048653, this, z) == null) {
            this.mIsZhida = z;
        }
    }

    public void setListenerKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, str) == null) {
            this.mListenerKey = str;
        }
    }

    public void setLocalUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, str) == null) {
            this.mLocalUrl = str;
        }
    }

    public void setMediaRoleMsg(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048656, this, z) == null) {
            this.isMediaRoleMsg = z;
        }
    }

    public void setMinSdkVersion(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048657, this, j2) == null) {
            this.mMinSdkVersion = j2;
        }
    }

    public boolean setMsgContent(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048658, this, str)) == null) {
            this.mjsonContent = str;
            return parseJsonString() && parseExt();
        }
        return invokeL.booleanValue;
    }

    public boolean setMsgContentFromServer(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048659, this, str)) == null) {
            this.mjsonContent = str;
            return parseJsonString() && parseCommon();
        }
        return invokeL.booleanValue;
    }

    public void setMsgId(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048660, this, j2) == null) {
            this.mMsgId = j2;
        }
    }

    public void setMsgKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048661, this, str) == null) {
            this.mMsgKey = str;
        }
    }

    public void setMsgReaded(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048662, this, i2) == null) {
            this.mIsRead = i2;
        }
    }

    public void setMsgTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048663, this, j2) == null) {
            this.mTime = j2;
        }
    }

    public void setMsgType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048664, this, i2) == null) {
            this.mType = i2;
        }
    }

    public void setNotifyCmd(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048665, this, i2) == null) {
            this.mNotifyCmd = i2;
        }
    }

    public void setPaid(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048666, this, j2) == null) {
            this.mPaid = j2;
        }
    }

    public void setReSend() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048667, this) == null) {
            this.mReSend = 1;
        }
    }

    public void setRowId(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048668, this, j2) == null) {
            this.mRowId = j2;
        }
    }

    public void setSendMessageStatusListener(ISendMessageStatusListener iSendMessageStatusListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048669, this, iSendMessageStatusListener) == null) {
            this.mListenerKey = ListenerManager.getInstance().addListener(iSendMessageStatusListener);
        }
    }

    public void setSendMsgId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048670, this, str) == null) {
            this.sendMsgId = str;
        }
    }

    public void setSenderUid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048671, this, str) == null) {
            try {
                Long.valueOf(str);
                this.senderUid = str;
            } catch (NumberFormatException unused) {
                LogUtils.e(TAG, "setSenderUid " + str + " , mType : " + this.mType);
                this.senderUid = "0";
            }
        }
    }

    public void setServiceType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048672, this, str) == null) {
            this.mServiceType = str;
        }
    }

    public void setStarContentExtra(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048673, this, str) == null) {
            this.mjsonStarExtra = str;
        }
    }

    public void setStatus(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048674, this, i2) == null) {
            this.mStatus = i2;
            notifyMsgStatus(i2);
        }
    }

    public void setSubChatType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048675, this, i2) == null) {
            this.mSubChatType = i2;
        }
    }

    public void setTemplateType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048676, this, i2) == null) {
            this.mTemplateType = i2;
        }
    }

    public void setTips(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048677, this, str) == null) {
            this.mTips = str;
        }
    }

    public void setTipsCode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048678, this, i2) == null) {
            this.mTipsCode = i2;
        }
    }

    public void setTriggerReasonn(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048679, this, j2) == null) {
            this.mTriggerReasonn = j2;
        }
    }

    public void setmExtJson(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048680, this, str) == null) {
            this.mExtJson = str;
        }
    }

    public boolean shouldAbandonMsg(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048681, this, context)) == null) {
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
        return invokeL.booleanValue;
    }

    public String toJsonString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) {
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
        return (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) {
            return " ChatMsg:[ type=" + this.mType + " , category=" + this.mCategory + " , fromid=" + this.mFromUser + " , senduid=" + this.senderUid + " , contacterId=" + this.mContacter + ", json=" + this.mjsonContent + " , msgId=" + this.mMsgId + " , sendmsgid = " + this.sendMsgId + ", isread=" + this.mIsRead + " , time=" + this.mTime + " , triggerReasonn=" + this.mTriggerReasonn + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048684, this, parcel, i2) == null) {
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
    }

    public ChatMsg(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
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
