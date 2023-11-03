package com.baidu.android.imsdk.chatmessage.messages;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.chatmessage.IChatRoomEnterListener;
import com.baidu.android.imsdk.chatmessage.ISendMessageStatusListener;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.chatmessage.request.IMEmojiReplyListListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.searchbox.player.utils.BasicVideoParserKt;
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
/* loaded from: classes.dex */
public abstract class ChatMsg implements Parcelable, NoProGuard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MSG_FORM_OTHER_DEVICE = 2;
    public static final int MSG_FROM_SAME_DEVICE = 1;
    public static final String TAG = "ChatMsg";
    public static final int VERSION = 1;
    public static AtomicInteger mOpenCounter;
    public static Random mRandom;
    public transient /* synthetic */ FieldHolder $fh;
    public long contacterUk;
    public List<IMEmojiReplyListListener.IMEmojiItem> emojiList;
    public long expiresTime;
    public int hasReaction;
    public String interActiveAction;
    public int interActiveSource;
    public boolean isMediaRoleMsg;
    public long mAppId;
    public int mArrayIndex;
    public List<IChatRoomEnterListener.AtUserInfo> mAtUsers;
    public List<Long> mAtuks;
    public int mAutoRiskControlStatus;
    public String mBizExt;
    public int mBlockType;
    public int mBusinessType;
    public List<Long> mCastids;
    public int mCategory;
    public String mChatRoomContentExt;
    public int mChatType;
    public long mContacter;
    public int mContacterIsRead;
    public int mDeviceFlag;
    public long mDialogueId;
    public String mEventList;
    public String mExtJson;
    public String mExtLog;
    public String mExtTransInfo;
    public String mExtraContent;
    public int mFetchTriggerReason;
    public long mFromUser;
    public boolean mIsClicked;
    public int mIsRead;
    public boolean mIsZhida;
    public String mListenerKey;
    public String mLocalUrl;
    public int mLogicDel;
    public long mMinSdkVersion;
    public long mMsgId;
    public String mMsgKey;
    public String mNickName;
    public int mNotifyCmd;
    public long mNotifyId;
    public String mOriginPa;
    public int mOriginPaType;
    public long mPaid;
    public String mPortrait;
    public String mPreviewDesc;
    public IChatRoomEnterListener.ReMsgInfo mReMsgInfo;
    public int mReSend;
    public int mRemainNum;
    public String mRepliedName;
    public String mResourceId;
    public long mRowId;
    public long mSdkSendTime;
    public int mSendMsgType;
    public int mSendNum;
    public int mSendScene;
    public long mSendTime;
    public int mSendType;
    public String mServiceType;
    public int mSessionType;
    public String mSource;
    public int mStatus;
    public int mSubChatType;
    public IChatRoomEnterListener.TaskInfo mTaskInfo;
    public int mTemplateType;
    public int mTemplateVersion;
    public long mTime;
    public String mTips;
    public int mTipsCode;
    public long mTriggerReasonn;
    public int mType;
    public String mZone;
    public String mjsonContent;
    public String mjsonContentExtra;
    public String mjsonStarExtra;
    public String sendMsgId;
    public String senderUid;
    public String toBduid;

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public String getAdvisoryDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "" : (String) invokeV.objValue;
    }

    public String getAdvisoryMsgControl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "" : (String) invokeV.objValue;
    }

    public abstract String getRecommendDescription();

    public final int getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    public abstract boolean parseJsonString();

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

    public long getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mAppId;
        }
        return invokeV.longValue;
    }

    public List<IChatRoomEnterListener.AtUserInfo> getAtUserList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mAtUsers;
        }
        return (List) invokeV.objValue;
    }

    public List<Long> getAtUsers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mAtuks;
        }
        return (List) invokeV.objValue;
    }

    public int getAutoRiskControlStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mAutoRiskControlStatus;
        }
        return invokeV.intValue;
    }

    public String getBizExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mBizExt;
        }
        return (String) invokeV.objValue;
    }

    public int getBlockType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mBlockType;
        }
        return invokeV.intValue;
    }

    public int getBusinessType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mBusinessType;
        }
        return invokeV.intValue;
    }

    public List<Long> getCastids() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mCastids;
        }
        return (List) invokeV.objValue;
    }

    public int getCategory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mCategory;
        }
        return invokeV.intValue;
    }

    public String getChatRoomContentExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mChatRoomContentExt;
        }
        return (String) invokeV.objValue;
    }

    public int getChatType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.mChatType;
        }
        return invokeV.intValue;
    }

    public int getClickedState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.mIsClicked ? 1 : 0;
        }
        return invokeV.intValue;
    }

    public long getContacter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.mContacter;
        }
        return invokeV.longValue;
    }

    public String getContacterId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.mCategory == 0) {
                return this.senderUid;
            }
            return String.valueOf(this.mContacter);
        }
        return (String) invokeV.objValue;
    }

    public int getContacterIsRead() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.mContacterIsRead;
        }
        return invokeV.intValue;
    }

    public long getContacterUk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.contacterUk;
        }
        return invokeV.longValue;
    }

    public String getContentExtra() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.mjsonContentExtra;
        }
        return (String) invokeV.objValue;
    }

    public final int getDeviceFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.mDeviceFlag;
        }
        return invokeV.intValue;
    }

    public long getDialogueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.mDialogueId;
        }
        return invokeV.longValue;
    }

    public List<IMEmojiReplyListListener.IMEmojiItem> getEmojiList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.emojiList;
        }
        return (List) invokeV.objValue;
    }

    public String getEventList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.mEventList;
        }
        return (String) invokeV.objValue;
    }

    public long getExpiresTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.expiresTime;
        }
        return invokeV.longValue;
    }

    public String getExtLog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.mExtLog;
        }
        return (String) invokeV.objValue;
    }

    public String getExtTransInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.mExtTransInfo;
        }
        return (String) invokeV.objValue;
    }

    public String getExtraContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.mExtraContent;
        }
        return (String) invokeV.objValue;
    }

    public int getFetchTriggerReason() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.mFetchTriggerReason;
        }
        return invokeV.intValue;
    }

    public long getFromUser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.mFromUser;
        }
        return invokeV.longValue;
    }

    public String getInterActiveAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.interActiveAction;
        }
        return (String) invokeV.objValue;
    }

    public int getInterActiveSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.interActiveSource;
        }
        return invokeV.intValue;
    }

    public String getJsonContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.mjsonContent;
        }
        return (String) invokeV.objValue;
    }

    public String getLocalUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.mLocalUrl;
        }
        return (String) invokeV.objValue;
    }

    public int getLogicDel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.mLogicDel;
        }
        return invokeV.intValue;
    }

    public long getMinSdkVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.mMinSdkVersion;
        }
        return invokeV.longValue;
    }

    public String getMsgContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.mjsonContent;
        }
        return (String) invokeV.objValue;
    }

    public long getMsgId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.mMsgId;
        }
        return invokeV.longValue;
    }

    public String getMsgKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.mMsgKey;
        }
        return (String) invokeV.objValue;
    }

    public long getMsgTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return this.mTime;
        }
        return invokeV.longValue;
    }

    public int getMsgType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return this.mType;
        }
        return invokeV.intValue;
    }

    public String getNickName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.mNickName;
        }
        return (String) invokeV.objValue;
    }

    public int getNotifyCmd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return this.mNotifyCmd;
        }
        return invokeV.intValue;
    }

    public long getNotifyId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return this.mNotifyId;
        }
        return invokeV.longValue;
    }

    public String getOriginPa() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return this.mOriginPa;
        }
        return (String) invokeV.objValue;
    }

    public int getOriginPaType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return this.mOriginPaType;
        }
        return invokeV.intValue;
    }

    public long getPaid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return this.mPaid;
        }
        return invokeV.longValue;
    }

    public String getPortrait() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return this.mPortrait;
        }
        return (String) invokeV.objValue;
    }

    public String getPreviewDesc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            return this.mPreviewDesc;
        }
        return (String) invokeV.objValue;
    }

    public IChatRoomEnterListener.ReMsgInfo getReMsgInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return this.mReMsgInfo;
        }
        return (IChatRoomEnterListener.ReMsgInfo) invokeV.objValue;
    }

    public final int getRealMsgType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            return this.mType;
        }
        return invokeV.intValue;
    }

    public int getRemainNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return this.mRemainNum;
        }
        return invokeV.intValue;
    }

    public String getRepliedName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return this.mRepliedName;
        }
        return (String) invokeV.objValue;
    }

    public String getResourceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return this.mResourceId;
        }
        return (String) invokeV.objValue;
    }

    public long getRowId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return this.mRowId;
        }
        return invokeV.longValue;
    }

    public long getSdkSendMsgTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            return this.mSdkSendTime;
        }
        return invokeV.longValue;
    }

    public String getSendMsgId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            return this.sendMsgId;
        }
        return (String) invokeV.objValue;
    }

    public long getSendMsgTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            return this.mSendTime;
        }
        return invokeV.longValue;
    }

    public int getSendMsgType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            return this.mSendMsgType;
        }
        return invokeV.intValue;
    }

    public int getSendNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            return this.mSendNum;
        }
        return invokeV.intValue;
    }

    public int getSendScene() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            return this.mSendScene;
        }
        return invokeV.intValue;
    }

    public int getSendType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            return this.mSendType;
        }
        return invokeV.intValue;
    }

    public String getSenderUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            return this.senderUid;
        }
        return (String) invokeV.objValue;
    }

    public String getServiceType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            return this.mServiceType;
        }
        return (String) invokeV.objValue;
    }

    public int getSessionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            return this.mSessionType;
        }
        return invokeV.intValue;
    }

    public String getSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            return this.mSource;
        }
        return (String) invokeV.objValue;
    }

    public String getStarContentExtra() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            return this.mjsonStarExtra;
        }
        return (String) invokeV.objValue;
    }

    public int getStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            return this.mStatus;
        }
        return invokeV.intValue;
    }

    public int getSubChatType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
            return this.mSubChatType;
        }
        return invokeV.intValue;
    }

    public IChatRoomEnterListener.TaskInfo getTaskInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            return this.mTaskInfo;
        }
        return (IChatRoomEnterListener.TaskInfo) invokeV.objValue;
    }

    public int getTemplateType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            return this.mTemplateType;
        }
        return invokeV.intValue;
    }

    public int getTemplateVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            return this.mTemplateVersion;
        }
        return invokeV.intValue;
    }

    public String getTips() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            return this.mTips;
        }
        return (String) invokeV.objValue;
    }

    public int getTipsCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            return this.mTipsCode;
        }
        return invokeV.intValue;
    }

    public String getToBduid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            return this.toBduid;
        }
        return (String) invokeV.objValue;
    }

    public long getTriggerReasonn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            return this.mTriggerReasonn;
        }
        return invokeV.longValue;
    }

    public String getZone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            return this.mZone;
        }
        return (String) invokeV.objValue;
    }

    public String getmExtJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            return this.mExtJson;
        }
        return (String) invokeV.objValue;
    }

    public boolean hasReaction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            if (this.hasReaction == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isClicked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            return this.mIsClicked;
        }
        return invokeV.booleanValue;
    }

    public boolean isContacterRead() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
            if (this.mContacterIsRead == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isMediaRoleMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) {
            return this.isMediaRoleMsg;
        }
        return invokeV.booleanValue;
    }

    public boolean isMsgRead() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) {
            if (this.mIsRead == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isMsgSendSuccess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) {
            if (this.mStatus == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isNotifyMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            int i = this.mType;
            if (i >= 1001 && i <= 1017) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isReSend() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) {
            if (this.mReSend == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean isSameDevice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            if (this.mDeviceFlag == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isZhida() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) {
            return this.mIsZhida;
        }
        return invokeV.booleanValue;
    }

    public void setReSend() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048729, this) == null) {
            this.mReSend = 1;
        }
    }

    public ChatMsg() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mIsRead = 0;
        this.mMsgId = 0L;
        this.mTime = 0L;
        this.mSendTime = 0L;
        this.mSdkSendTime = 0L;
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
        this.mExtTransInfo = "";
        this.mExtLog = "";
        this.mChatType = -1;
        this.mSubChatType = -1;
        this.mDeviceFlag = 1;
        this.mAtuks = null;
        this.mCastids = null;
        this.expiresTime = 0L;
        this.interActiveAction = "";
        this.interActiveSource = -1;
        this.isMediaRoleMsg = false;
        this.mTipsCode = 0;
        this.mTips = "";
        this.mTemplateType = 0;
        this.mContacterIsRead = 0;
        this.mDialogueId = 0L;
        this.mBusinessType = 0;
        this.mResourceId = null;
        this.mRemainNum = -1;
        this.mSendNum = -1;
        this.mSessionType = 0;
        this.mSendType = 0;
        this.mSendScene = 0;
        this.mLogicDel = 0;
        this.mOriginPaType = -1;
        this.mBizExt = "";
        this.mZone = "";
        this.mSource = "";
        this.mFetchTriggerReason = 0;
        this.mSendMsgType = 0;
        this.mChatRoomContentExt = "";
        this.mTaskInfo = null;
        this.sendMsgId = generateSendMsgId();
    }

    public boolean parseCommon() {
        InterceptResult invokeV;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) {
            LogUtils.d(TAG, "parseCommon " + this.mContacter + " ---->: " + this.mjsonContent);
            if (!TextUtils.isEmpty(this.mjsonContent)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.mjsonContent);
                    if (jSONObject.has("ext") && (optJSONObject = jSONObject.optJSONObject("ext")) != null) {
                        this.mExtJson = optJSONObject.toString();
                        if (optJSONObject.has("push_exts")) {
                            JSONObject jSONObject2 = optJSONObject.getJSONObject("push_exts");
                            if (jSONObject2.has(BasicVideoParserKt.EXT_LOG)) {
                                setExtLog(jSONObject2.optString(BasicVideoParserKt.EXT_LOG));
                            }
                        }
                        this.mBlockType = optJSONObject.optInt("block_type");
                    }
                    if (jSONObject.has("extra")) {
                        this.mjsonContentExtra = jSONObject.optString("extra");
                    }
                    if (jSONObject.has("stargroupext")) {
                        this.mjsonStarExtra = jSONObject.optString("stargroupext");
                    }
                    if (jSONObject.has(BasicVideoParserKt.EXT_LOG)) {
                        setExtLog(jSONObject.optString(BasicVideoParserKt.EXT_LOG));
                    }
                    setSenderUid(jSONObject.optString("buid"));
                    return true;
                } catch (JSONException e) {
                    LogUtils.e(TAG, "parseJsonString", e);
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean parseExt() {
        InterceptResult invokeV;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) {
            LogUtils.d(TAG, "parseExt");
            if (!TextUtils.isEmpty(this.mjsonContent)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.mjsonContent);
                    if (jSONObject.has("ext")) {
                        JSONObject optJSONObject2 = jSONObject.optJSONObject("ext");
                        if (optJSONObject2 != null) {
                            this.mExtJson = optJSONObject2.toString();
                            if (optJSONObject2.has("push_exts") && (optJSONObject = optJSONObject2.optJSONObject("push_exts")) != null && optJSONObject.has(BasicVideoParserKt.EXT_LOG)) {
                                setExtLog(optJSONObject.optString(BasicVideoParserKt.EXT_LOG));
                            }
                            this.mExtTransInfo = optJSONObject2.optString(IMConstants.SHARE_EXT_TRANS_INFO);
                            this.mBlockType = optJSONObject2.optInt("block_type");
                        }
                        parsePreviewDesc();
                    }
                    JSONObject optJSONObject3 = jSONObject.optJSONObject("biz_ext");
                    if (optJSONObject3 != null) {
                        this.mBizExt = optJSONObject3.toString();
                    }
                    if (jSONObject.has("extra")) {
                        this.mjsonContentExtra = jSONObject.optString("extra");
                    }
                    if (jSONObject.has("stargroupext")) {
                        this.mjsonStarExtra = jSONObject.optString("stargroupext");
                    }
                    if (jSONObject.has(BasicVideoParserKt.EXT_LOG)) {
                        setExtLog(jSONObject.optString(BasicVideoParserKt.EXT_LOG));
                    }
                    if (jSONObject.has(Constants.EXTRA_TRIGGER_REASON)) {
                        setTriggerReasonn(jSONObject.optLong(Constants.EXTRA_TRIGGER_REASON));
                    }
                    return true;
                } catch (JSONException e) {
                    LogUtils.e(TAG, "parseJsonString", e);
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public ChatMsg(Parcel parcel) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mIsRead = 0;
        this.mMsgId = 0L;
        this.mTime = 0L;
        this.mSendTime = 0L;
        this.mSdkSendTime = 0L;
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
        this.mExtTransInfo = "";
        this.mExtLog = "";
        this.mChatType = -1;
        this.mSubChatType = -1;
        this.mDeviceFlag = 1;
        this.mAtuks = null;
        this.mCastids = null;
        this.expiresTime = 0L;
        this.interActiveAction = "";
        this.interActiveSource = -1;
        this.isMediaRoleMsg = false;
        this.mTipsCode = 0;
        this.mTips = "";
        this.mTemplateType = 0;
        this.mContacterIsRead = 0;
        this.mDialogueId = 0L;
        this.mBusinessType = 0;
        this.mResourceId = null;
        this.mRemainNum = -1;
        this.mSendNum = -1;
        this.mSessionType = 0;
        this.mSendType = 0;
        this.mSendScene = 0;
        this.mLogicDel = 0;
        this.mOriginPaType = -1;
        this.mBizExt = "";
        this.mZone = "";
        this.mSource = "";
        this.mFetchTriggerReason = 0;
        this.mSendMsgType = 0;
        this.mChatRoomContentExt = "";
        this.mTaskInfo = null;
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
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.mIsZhida = z;
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
        this.interActiveAction = parcel.readString();
        this.interActiveSource = parcel.readInt();
        this.mServiceType = parcel.readString();
        this.mTipsCode = parcel.readInt();
        this.mTips = parcel.readString();
        this.mTemplateType = parcel.readInt();
        this.mContacterIsRead = parcel.readInt();
        this.mDialogueId = parcel.readLong();
        this.mBusinessType = parcel.readInt();
        this.mResourceId = parcel.readString();
        this.mRemainNum = parcel.readInt();
        this.mSendNum = parcel.readInt();
        this.mSessionType = parcel.readInt();
        this.mSendScene = parcel.readInt();
        this.mSendType = parcel.readInt();
        this.mLogicDel = parcel.readInt();
        this.mOriginPa = parcel.readString();
        this.mOriginPaType = parcel.readInt();
        this.mPreviewDesc = parcel.readString();
        this.mBizExt = parcel.readString();
        this.mRepliedName = parcel.readString();
        this.mSource = parcel.readString();
        this.mBlockType = parcel.readInt();
        this.mAutoRiskControlStatus = parcel.readInt();
    }

    private boolean abandonByCuid(String str, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, str, context)) == null) {
            if (!TextUtils.isEmpty(str) && context != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("to_cuid")) {
                        String optString = jSONObject.optString("to_cuid");
                        if (!TextUtils.equals(optString.substring(0, optString.lastIndexOf("|")), Utility.getDeviceId(context).substring(0, optString.lastIndexOf("|")))) {
                            LogUtils.d(TAG, "CUID is not equal, will abandon this message!");
                            return true;
                        }
                    }
                } catch (Exception e) {
                    LogUtils.e(TAG, "msgExt exception ", e);
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    private void contentAddBizExt() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) && !TextUtils.isEmpty(this.mBizExt) && !TextUtils.isEmpty(this.mjsonContent)) {
            try {
                JSONObject jSONObject = new JSONObject(this.mjsonContent);
                jSONObject.put("biz_ext", new JSONObject(this.mBizExt));
                this.mjsonContent = jSONObject.toString();
            } catch (JSONException e) {
                LogUtils.d(TAG, "setMsgContent exception：" + e.getMessage());
            }
        }
    }

    public String getExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
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

    public String toJsonString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048758, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("content", getJsonContent());
                jSONObject.put("msgid", getMsgId());
                jSONObject.put("type", getMsgType());
                jSONObject.put("time", getMsgTime());
                jSONObject.put("status", getStatus());
                jSONObject.put("error", getTipsCode());
            } catch (JSONException e) {
                LogUtils.e(TAG, "toJsonString exception ", e);
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }

    private synchronized String generateSendMsgId() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            synchronized (this) {
                str = System.currentTimeMillis() + "" + mOpenCounter.incrementAndGet();
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    private void parsePreviewDesc() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65544, this) == null) && !TextUtils.isEmpty(this.mExtJson)) {
            try {
                JSONObject optJSONObject = new JSONObject(this.mExtJson).optJSONObject("session_exts");
                if (optJSONObject != null) {
                    this.mPreviewDesc = optJSONObject.optString("desc");
                }
            } catch (JSONException e) {
                LogUtils.d(TAG, e.toString());
            }
        }
    }

    public int getGroupType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            if (!TextUtils.isEmpty(this.mExtJson)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.mExtJson);
                    if (jSONObject.has("group_type")) {
                        return jSONObject.getInt("group_type");
                    }
                    if (jSONObject.has("sub_app_identity") && jSONObject.getInt("sub_app_identity") == 57) {
                        return 3;
                    }
                    return 1;
                } catch (JSONException unused) {
                    return 1;
                }
            }
            return 1;
        }
        return invokeV.intValue;
    }

    public boolean isDumiMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) {
            if (!TextUtils.isEmpty(this.mExtJson)) {
                try {
                    if (new JSONObject(this.mExtJson).optInt("sub_app_identity", -1) == 100) {
                        return true;
                    }
                    return false;
                } catch (JSONException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isGalleryMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) {
            if (!TextUtils.isEmpty(this.mExtJson)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.mExtJson);
                    if (jSONObject.optInt("sub_app_identity", -1) != 7) {
                        if (jSONObject.optInt("sub_app_identity", -1) == 16) {
                            return true;
                        }
                        return false;
                    }
                    return true;
                } catch (JSONException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isStarMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) {
            if (!TextUtils.isEmpty(this.mExtJson)) {
                try {
                    if (new JSONObject(this.mExtJson).optInt("sub_app_identity", -1) == 4) {
                        return true;
                    }
                    return false;
                } catch (JSONException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String toJsonStringForChatRoom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048759, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("content", getContentExtra());
                jSONObject.put("msgid", getMsgId());
                jSONObject.put("time", getMsgTime());
            } catch (JSONException e) {
                LogUtils.e(TAG, "ChatRoom toJsonString exception ", e);
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }

    public static byte[] long2bytes(long j, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{Long.valueOf(j), Integer.valueOf(i)})) == null) {
            byte[] bArr = new byte[i];
            for (int i2 = i - 1; i2 >= 0; i2--) {
                bArr[i2] = (byte) (255 & j);
                j >>= 8;
            }
            return bArr;
        }
        return (byte[]) invokeCommon.objValue;
    }

    private void notifyMsgStatus(int i) {
        ISendMessageStatusListener iSendMessageStatusListener;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(65543, this, i) != null) || this.mListenerKey == null) {
            return;
        }
        if ((i == 0 || i == 2) && (iSendMessageStatusListener = (ISendMessageStatusListener) ListenerManager.getInstance().removeListener(this.mListenerKey)) != null) {
            iSendMessageStatusListener.onSendStatus(i, this);
        }
    }

    public boolean isSelf(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048672, this, context)) == null) {
            if (this.mFromUser == Utility.getUK(context)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void markClicked(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048675, this, context) == null) {
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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

    public void setAppId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048680, this, j) == null) {
            this.mAppId = j;
        }
    }

    public void setAtUserList(List<IChatRoomEnterListener.AtUserInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048681, this, list) == null) {
            this.mAtUsers = list;
        }
    }

    public void setAtUsers(List<Long> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048682, this, list) == null) {
            this.mAtuks = list;
            if (list != null && list.size() > 0) {
                LogUtils.d(TAG, " setAtUsers " + this.mAtuks);
            }
        }
    }

    public void setAutoRiskControlStatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048683, this, i) == null) {
            this.mAutoRiskControlStatus = i;
        }
    }

    public void setBizExt(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048684, this, str) == null) {
            this.mBizExt = str;
            contentAddBizExt();
        }
    }

    public void setBusinessType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048685, this, i) == null) {
            this.mBusinessType = i;
        }
    }

    public void setCastid(List<Long> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048686, this, list) == null) {
            this.mCastids = list;
        }
    }

    public void setCategory(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048687, this, i) == null) {
            this.mCategory = i;
        }
    }

    public void setChatRoomContentExt(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048688, this, str) == null) {
            this.mChatRoomContentExt = str;
        }
    }

    public void setChatType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048689, this, i) == null) {
            this.mChatType = i;
        }
    }

    public void setContacter(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048690, this, j) == null) {
            this.mContacter = j;
        }
    }

    public void setContacterBduid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048691, this, str) == null) {
            this.toBduid = str;
        }
    }

    public void setContacterIsRead(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048692, this, i) == null) {
            this.mContacterIsRead = i;
        }
    }

    public void setContacterUk(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048693, this, j) == null) {
            this.contacterUk = j;
        }
    }

    public void setContentExtra(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048694, this, str) == null) {
            this.mjsonContentExtra = str;
        }
    }

    public final void setDeviceFlag(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048695, this, i) == null) {
            this.mDeviceFlag = i;
        }
    }

    public void setDialogueId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048696, this, j) == null) {
            this.mDialogueId = j;
        }
    }

    public void setEmojiList(List<IMEmojiReplyListListener.IMEmojiItem> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048697, this, list) == null) {
            this.emojiList = list;
        }
    }

    public void setEventList(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048698, this, str) == null) {
            this.mEventList = str;
        }
    }

    public void setExpiresTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048699, this, j) == null) {
            this.expiresTime = j;
        }
    }

    public void setExtLog(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048700, this, str) == null) {
            this.mExtLog = str;
        }
    }

    public void setExtraContent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048701, this, str) == null) {
            this.mExtraContent = str;
        }
    }

    public void setFetchTriggerReason(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048702, this, i) == null) {
            this.mFetchTriggerReason = i;
        }
    }

    public void setFromUser(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048703, this, j) == null) {
            this.mFromUser = j;
        }
    }

    public void setHasReaction(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048704, this, i) == null) {
            this.hasReaction = i;
        }
    }

    public void setInterActiveAction(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048705, this, str) == null) {
            this.interActiveAction = str;
        }
    }

    public void setInterActiveSource(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048706, this, i) == null) {
            this.interActiveSource = i;
        }
    }

    public void setIsClicked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048707, this, z) == null) {
            this.mIsClicked = z;
        }
    }

    public void setIsZhida(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048708, this, z) == null) {
            this.mIsZhida = z;
        }
    }

    public void setListenerKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048709, this, str) == null) {
            this.mListenerKey = str;
        }
    }

    public void setLocalUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048710, this, str) == null) {
            this.mLocalUrl = str;
        }
    }

    public void setLogicDel(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048711, this, i) == null) {
            this.mLogicDel = i;
        }
    }

    public void setMediaRoleMsg(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048712, this, z) == null) {
            this.isMediaRoleMsg = z;
        }
    }

    public void setMinSdkVersion(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048713, this, j) == null) {
            this.mMinSdkVersion = j;
        }
    }

    public boolean setMsgContent(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048714, this, str)) == null) {
            this.mjsonContent = str;
            contentAddBizExt();
            if (parseJsonString() && parseExt()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean setMsgContentFromServer(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048715, this, str)) == null) {
            this.mjsonContent = str;
            if (parseJsonString() && parseCommon()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setMsgId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048716, this, j) == null) {
            this.mMsgId = j;
        }
    }

    public void setMsgKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048717, this, str) == null) {
            this.mMsgKey = str;
        }
    }

    public void setMsgReaded(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048718, this, i) == null) {
            this.mIsRead = i;
        }
    }

    public void setMsgTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048719, this, j) == null) {
            this.mTime = j;
        }
    }

    public void setMsgType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048720, this, i) == null) {
            this.mType = i;
        }
    }

    public void setNickName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048721, this, str) == null) {
            this.mNickName = str;
        }
    }

    public void setNotifyCmd(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048722, this, i) == null) {
            this.mNotifyCmd = i;
        }
    }

    public void setNotifyId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048723, this, j) == null) {
            this.mNotifyId = j;
        }
    }

    public void setOriginPa(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048724, this, str) == null) {
            this.mOriginPa = str;
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.mOriginPaType = new JSONObject(str).optInt(Constants.EXTRA_PA_TYPE, -1);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setPaid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048725, this, j) == null) {
            this.mPaid = j;
        }
    }

    public void setPortrait(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048726, this, str) == null) {
            this.mPortrait = str;
        }
    }

    public void setPreviewDesc(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048727, this, str) == null) {
            this.mPreviewDesc = str;
        }
    }

    public void setReMsgInfo(IChatRoomEnterListener.ReMsgInfo reMsgInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048728, this, reMsgInfo) == null) {
            this.mReMsgInfo = reMsgInfo;
        }
    }

    public void setRemainNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048730, this, i) == null) {
            this.mRemainNum = i;
        }
    }

    public void setRepliedName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048731, this, str) == null) {
            this.mRepliedName = str;
        }
    }

    public void setResourceId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048732, this, str) == null) {
            this.mResourceId = str;
        }
    }

    public void setRowId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048733, this, j) == null) {
            this.mRowId = j;
        }
    }

    public void setSdkSendMsgTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048734, this, j) == null) {
            this.mSdkSendTime = j;
        }
    }

    public void setSendMessageStatusListener(ISendMessageStatusListener iSendMessageStatusListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048735, this, iSendMessageStatusListener) == null) {
            this.mListenerKey = ListenerManager.getInstance().addListener(iSendMessageStatusListener);
        }
    }

    public void setSendMsgId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048736, this, str) == null) {
            this.sendMsgId = str;
        }
    }

    public void setSendMsgTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048737, this, j) == null) {
            this.mSendTime = j;
        }
    }

    public void setSendMsgType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048738, this, i) == null) {
            this.mSendMsgType = i;
        }
    }

    public void setSendNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048739, this, i) == null) {
            this.mSendNum = i;
        }
    }

    public void setSendScene(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048740, this, i) == null) {
            this.mSendScene = i;
        }
    }

    public void setSendType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048741, this, i) == null) {
            this.mSendType = i;
        }
    }

    public void setServiceType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048743, this, str) == null) {
            this.mServiceType = str;
        }
    }

    public void setSessionType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048744, this, i) == null) {
            this.mSessionType = i;
        }
    }

    public void setSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048745, this, str) == null) {
            this.mSource = str;
        }
    }

    public void setStarContentExtra(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048746, this, str) == null) {
            this.mjsonStarExtra = str;
        }
    }

    public void setStatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048747, this, i) == null) {
            this.mStatus = i;
            notifyMsgStatus(i);
        }
    }

    public void setSubChatType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048748, this, i) == null) {
            this.mSubChatType = i;
        }
    }

    public void setTaskInfo(IChatRoomEnterListener.TaskInfo taskInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048749, this, taskInfo) == null) {
            this.mTaskInfo = taskInfo;
        }
    }

    public void setTemplateType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048750, this, i) == null) {
            this.mTemplateType = i;
        }
    }

    public void setTemplateVersion(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048751, this, i) == null) {
            this.mTemplateVersion = i;
        }
    }

    public void setTips(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048752, this, str) == null) {
            this.mTips = str;
        }
    }

    public void setTipsCode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048753, this, i) == null) {
            this.mTipsCode = i;
        }
    }

    public void setTriggerReasonn(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048754, this, j) == null) {
            this.mTriggerReasonn = j;
        }
    }

    public void setZone(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048755, this, str) == null) {
            this.mZone = str;
        }
    }

    public void setmExtJson(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048756, this, str) == null) {
            this.mExtJson = str;
        }
    }

    public static String removeZero(String str) {
        InterceptResult invokeL;
        int lastIndexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if (str == null || str.length() == 0 || (lastIndexOf = str.lastIndexOf(48)) == str.length() - 1) {
                return "";
            }
            return str.substring(lastIndexOf + 1);
        }
        return (String) invokeL.objValue;
    }

    public void setSenderUid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048742, this, str) == null) {
            try {
                Long.valueOf(str);
                this.senderUid = str;
            } catch (NumberFormatException unused) {
                LogUtils.e(TAG, "setSenderUid " + str + " , mType : " + this.mType);
                this.senderUid = "0";
            }
        }
    }

    public void createMsgKey(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, context) != null) || context == null) {
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

    public boolean shouldAbandonMsg(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048757, this, context)) == null) {
            String ext = getExt();
            boolean abandonByCuid = abandonByCuid(ext, context);
            if (abandonByCuid) {
                return abandonByCuid;
            }
            int i = this.mType;
            if ((i == 0 || i == 20) && !TextUtils.isEmpty(ext)) {
                try {
                    JSONObject jSONObject = new JSONObject(ext);
                    if (jSONObject.has("sub_app_identity")) {
                        if (jSONObject.optInt("sub_app_identity") == 6) {
                            return true;
                        }
                        return false;
                    }
                    return false;
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public JSONObject getMsgString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
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
        return (JSONObject) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00c6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getSendMsgContent() {
        InterceptResult invokeV;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            try {
                if ((this.mChatType == 7 || this.mChatType == 16 || this.mChatType == 25 || this.mType == 18) && !TextUtils.isEmpty(this.mExtraContent)) {
                    jSONObject2 = new JSONObject(this.mExtraContent);
                } else if (this.mjsonContent != null) {
                    jSONObject2 = new JSONObject(this.mjsonContent);
                } else {
                    jSONObject2 = new JSONObject();
                }
            } catch (Exception e) {
                e = e;
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
                    jSONObject3.put(Constants.EXTRA_SUB_PA_TYPE, 21);
                }
                jSONObject2.put("ext", jSONObject3);
                if (!TextUtils.isEmpty(this.mjsonContentExtra)) {
                    jSONObject2.put("extra", this.mjsonContentExtra);
                }
                if (!TextUtils.isEmpty(this.mBizExt)) {
                    jSONObject2.put("biz_ext", new JSONObject(this.mBizExt));
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
            if (jSONObject2 != null) {
                return null;
            }
            return jSONObject2.toString();
        }
        return (String) invokeV.objValue;
    }

    public void parseForwardmessage(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048678, this, i) == null) {
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
                    JSONObject optJSONObject = jSONObject.optJSONObject("biz_ext");
                    if (optJSONObject != null) {
                        jSONObject.put("biz_ext", optJSONObject);
                    }
                    this.mjsonContent = jSONObject.toString();
                } catch (JSONException e) {
                    LogUtils.e(TAG, "getMsgContent Json", e);
                }
            }
            parseExt();
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048760, this)) == null) {
            return "ChatMsg{mjsonContent='" + this.mjsonContent + "', mjsonContentExtra='" + this.mjsonContentExtra + "', mExtraContent='" + this.mExtraContent + "', mIsRead=" + this.mIsRead + ", mMsgId=" + this.mMsgId + ", mTime=" + this.mTime + ", mFromUser=" + this.mFromUser + ", mType=" + this.mType + ", mAppId=" + this.mAppId + ", mStatus=" + this.mStatus + ", mRowId=" + this.mRowId + ", mArrayIndex=" + this.mArrayIndex + ", mCategory=" + this.mCategory + ", mContacter=" + this.mContacter + ", mMinSdkVersion=" + this.mMinSdkVersion + ", mTriggerReasonn=" + this.mTriggerReasonn + ", mNotifyCmd=" + this.mNotifyCmd + ", mReSend=" + this.mReSend + ", mLocalUrl='" + this.mLocalUrl + "', mMsgKey='" + this.mMsgKey + "', mIsZhida=" + this.mIsZhida + ", mIsClicked=" + this.mIsClicked + ", mPaid=" + this.mPaid + ", mExtJson='" + this.mExtJson + "', mExtLog='" + this.mExtLog + "', mChatType=" + this.mChatType + ", mSubChatType=" + this.mSubChatType + ", mDeviceFlag=" + this.mDeviceFlag + ", mListenerKey='" + this.mListenerKey + "', sendMsgId='" + this.sendMsgId + "', senderUid='" + this.senderUid + "', toBduid='" + this.toBduid + "', mAtuks=" + this.mAtuks + ", mCastids=" + this.mCastids + ", mjsonStarExtra='" + this.mjsonStarExtra + "', expiresTime=" + this.expiresTime + ", interActiveAction='" + this.interActiveAction + "', interActiveSource=" + this.interActiveSource + ", mServiceType='" + this.mServiceType + "', isMediaRoleMsg=" + this.isMediaRoleMsg + ", mTipsCode=" + this.mTipsCode + ", mTips='" + this.mTips + "', mTemplateType=" + this.mTemplateType + ", mContacterIsRead=" + this.mContacterIsRead + ", mDialogueId=" + this.mDialogueId + ", mBusinessType=" + this.mBusinessType + ", mResourceId='" + this.mResourceId + "', mRemainNum=" + this.mRemainNum + ", mSendNum=" + this.mSendNum + ", mSessionType=" + this.mSessionType + ", mSendType=" + this.mSendType + ", mSendScene=" + this.mSendScene + ", mLogicDel=" + this.mLogicDel + ", mNickName='" + this.mNickName + "', mPortrait='" + this.mPortrait + "', contacterUk=" + this.contacterUk + ", eventList=" + this.mEventList + ", mBizExt=" + this.mBizExt + ", mSource=" + this.mSource + ", mChatRoomContentExt=" + this.mChatRoomContentExt + '}';
        }
        return (String) invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048761, this, parcel, i) == null) {
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
            parcel.writeString(this.interActiveAction);
            parcel.writeInt(this.interActiveSource);
            parcel.writeString(this.mServiceType);
            parcel.writeInt(this.mTipsCode);
            parcel.writeString(this.mTips);
            parcel.writeInt(this.mTemplateType);
            parcel.writeInt(this.mContacterIsRead);
            parcel.writeLong(this.mDialogueId);
            parcel.writeInt(this.mBusinessType);
            parcel.writeString(this.mResourceId);
            parcel.writeInt(this.mRemainNum);
            parcel.writeInt(this.mSendNum);
            parcel.writeInt(this.mSessionType);
            parcel.writeInt(this.mSendScene);
            parcel.writeInt(this.mSendType);
            parcel.writeInt(this.mLogicDel);
            parcel.writeString(this.mOriginPa);
            parcel.writeInt(this.mOriginPaType);
            parcel.writeString(this.mPreviewDesc);
            parcel.writeString(this.mBizExt);
            parcel.writeString(this.mRepliedName);
            parcel.writeString(this.mSource);
            parcel.writeInt(this.mBlockType);
            parcel.writeInt(this.mAutoRiskControlStatus);
        }
    }
}
