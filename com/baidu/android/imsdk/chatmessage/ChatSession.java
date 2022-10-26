package com.baidu.android.imsdk.chatmessage;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class ChatSession implements Parcelable, NoProGuard, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public int mBusinessType;
    public int mCategory;
    public String mCertification;
    public int mChatType;
    public String mClassAvatar;
    public int mClassShow;
    public String mClassTitle;
    public int mClassType;
    public int mCollectionType;
    public long mContacter;
    public long mContacterId;
    public String mExt;
    public String mGameHistory;
    public String mIconUrl;
    public int mIsClicked;
    public String mLastMsg;
    public String mLastMsgName;
    public long mLastMsgTime;
    public long mLastMsgUid;
    public long mLastOpenTime;
    public int mMarkTop;
    public long mMarkTopTime;
    public String mName;
    public int mNewFansAtMsgSum;
    public long mNewMsgSum;
    public String mNickName;
    public long mPaid;
    public int mSessionFrom;
    public int mShield;
    public long mShieldTime;
    public int mShow;
    public int mState;
    public String mVipId;
    public int mWeight;
    public String vPortrait;

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public ChatSession getChatRecord() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this : (ChatSession) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2012306460, "Lcom/baidu/android/imsdk/chatmessage/ChatSession;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2012306460, "Lcom/baidu/android/imsdk/chatmessage/ChatSession;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator() { // from class: com.baidu.android.imsdk.chatmessage.ChatSession.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            public ChatSession createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                    return new ChatSession(parcel);
                }
                return (ChatSession) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            public ChatSession[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                    return new ChatSession[i];
                }
                return (ChatSession[]) invokeI.objValue;
            }
        };
    }

    public void clearExt() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && !TextUtils.isEmpty(this.mExt)) {
            this.mExt = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public ChatSession m27clone() throws CloneNotSupportedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return (ChatSession) super.clone();
        }
        return (ChatSession) invokeV.objValue;
    }

    public int getBusinessType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mBusinessType;
        }
        return invokeV.intValue;
    }

    public int getCategory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mCategory;
        }
        return invokeV.intValue;
    }

    public String getCertification() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mCertification;
        }
        return (String) invokeV.objValue;
    }

    public int getChatType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mChatType;
        }
        return invokeV.intValue;
    }

    public String getClassAvatar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mClassAvatar;
        }
        return (String) invokeV.objValue;
    }

    public int getClassShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mClassShow;
        }
        return invokeV.intValue;
    }

    public String getClassTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mClassTitle;
        }
        return (String) invokeV.objValue;
    }

    public int getClassType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mClassType;
        }
        return invokeV.intValue;
    }

    public int getCollectionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.mCollectionType;
        }
        return invokeV.intValue;
    }

    public long getContacter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.mContacter;
        }
        return invokeV.longValue;
    }

    public long getContacterId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.mContacterId;
        }
        return invokeV.longValue;
    }

    public String getExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.mExt;
        }
        return (String) invokeV.objValue;
    }

    public String getGameHistory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.mGameHistory;
        }
        return (String) invokeV.objValue;
    }

    public String getIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.mIconUrl;
        }
        return (String) invokeV.objValue;
    }

    public int getIsClicked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.mIsClicked;
        }
        return invokeV.intValue;
    }

    public String getLastMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.mLastMsg;
        }
        return (String) invokeV.objValue;
    }

    public String getLastMsgName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.mLastMsgName;
        }
        return (String) invokeV.objValue;
    }

    public long getLastMsgTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.mLastMsgTime;
        }
        return invokeV.longValue;
    }

    public long getLastMsgUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.mLastMsgUid;
        }
        return invokeV.longValue;
    }

    public long getLastOpenTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.mLastOpenTime;
        }
        return invokeV.longValue;
    }

    public int getMarkTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.mMarkTop;
        }
        return invokeV.intValue;
    }

    public long getMarkTopTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.mMarkTopTime;
        }
        return invokeV.longValue;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.mName;
        }
        return (String) invokeV.objValue;
    }

    public int getNewFansAtMsgSum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.mNewFansAtMsgSum;
        }
        return invokeV.intValue;
    }

    public long getNewMsgSum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.mNewMsgSum;
        }
        return invokeV.longValue;
    }

    public String getNickName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.mNickName;
        }
        return (String) invokeV.objValue;
    }

    public long getPaid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.mPaid;
        }
        return invokeV.longValue;
    }

    public int getSessionFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.mSessionFrom;
        }
        return invokeV.intValue;
    }

    public int getShield() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.mShield;
        }
        return invokeV.intValue;
    }

    public long getShieldTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.mShieldTime;
        }
        return invokeV.longValue;
    }

    public int getShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.mShow;
        }
        return invokeV.intValue;
    }

    public int getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.mState;
        }
        return invokeV.intValue;
    }

    public String getVPortrait() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.vPortrait;
        }
        return (String) invokeV.objValue;
    }

    public String getVipId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.mVipId;
        }
        return (String) invokeV.objValue;
    }

    public int getWeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.mWeight;
        }
        return invokeV.intValue;
    }

    public boolean isRed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            if (this.mIsClicked == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            if (this.mShow == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public ChatSession() {
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
        this.mCategory = -1;
        this.mContacter = -1L;
        this.mContacterId = -1L;
        this.mName = null;
        this.mLastMsg = null;
        this.mLastMsgTime = -1L;
        this.mLastOpenTime = -1L;
        this.mNewMsgSum = 0L;
        this.mWeight = 0;
        this.mShow = 1;
        this.mCollectionType = -1;
        this.mChatType = -1;
        this.mIconUrl = null;
        this.mState = -1;
        this.mPaid = -1L;
        this.mClassType = -1;
        this.mClassTitle = null;
        this.mClassAvatar = null;
        this.mClassShow = 1;
        this.mMarkTop = 0;
        this.mMarkTopTime = 0L;
        this.mNickName = null;
        this.mGameHistory = "";
        this.mExt = "";
        this.vPortrait = "";
        this.mCertification = "";
        this.mVipId = "";
        this.mShield = 0;
        this.mShieldTime = 0L;
        this.mSessionFrom = 0;
        this.mBusinessType = -1;
        this.mLastMsgUid = 0L;
        this.mLastMsgName = "";
        this.mNewFansAtMsgSum = 0;
    }

    public ChatSession(int i, long j, long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mCategory = -1;
        this.mContacter = -1L;
        this.mContacterId = -1L;
        this.mName = null;
        this.mLastMsg = null;
        this.mLastMsgTime = -1L;
        this.mLastOpenTime = -1L;
        this.mNewMsgSum = 0L;
        this.mWeight = 0;
        this.mShow = 1;
        this.mCollectionType = -1;
        this.mChatType = -1;
        this.mIconUrl = null;
        this.mState = -1;
        this.mPaid = -1L;
        this.mClassType = -1;
        this.mClassTitle = null;
        this.mClassAvatar = null;
        this.mClassShow = 1;
        this.mMarkTop = 0;
        this.mMarkTopTime = 0L;
        this.mNickName = null;
        this.mGameHistory = "";
        this.mExt = "";
        this.vPortrait = "";
        this.mCertification = "";
        this.mVipId = "";
        this.mShield = 0;
        this.mShieldTime = 0L;
        this.mSessionFrom = 0;
        this.mBusinessType = -1;
        this.mLastMsgUid = 0L;
        this.mLastMsgName = "";
        this.mNewFansAtMsgSum = 0;
        this.mContacter = j;
        this.mName = str;
        this.mCategory = i;
        this.mContacterId = j2;
    }

    public ChatSession(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mCategory = -1;
        this.mContacter = -1L;
        this.mContacterId = -1L;
        this.mName = null;
        this.mLastMsg = null;
        this.mLastMsgTime = -1L;
        this.mLastOpenTime = -1L;
        this.mNewMsgSum = 0L;
        this.mWeight = 0;
        this.mShow = 1;
        this.mCollectionType = -1;
        this.mChatType = -1;
        this.mIconUrl = null;
        this.mState = -1;
        this.mPaid = -1L;
        this.mClassType = -1;
        this.mClassTitle = null;
        this.mClassAvatar = null;
        this.mClassShow = 1;
        this.mMarkTop = 0;
        this.mMarkTopTime = 0L;
        this.mNickName = null;
        this.mGameHistory = "";
        this.mExt = "";
        this.vPortrait = "";
        this.mCertification = "";
        this.mVipId = "";
        this.mShield = 0;
        this.mShieldTime = 0L;
        this.mSessionFrom = 0;
        this.mBusinessType = -1;
        this.mLastMsgUid = 0L;
        this.mLastMsgName = "";
        this.mNewFansAtMsgSum = 0;
        this.mCategory = parcel.readInt();
        this.mContacter = parcel.readLong();
        this.mContacterId = parcel.readLong();
        this.mName = parcel.readString();
        this.mLastMsg = parcel.readString();
        this.mLastMsgTime = parcel.readLong();
        this.mLastOpenTime = parcel.readLong();
        this.mNewMsgSum = parcel.readLong();
        this.mWeight = parcel.readInt();
        this.mShow = parcel.readInt();
        this.mCollectionType = parcel.readInt();
        this.mChatType = parcel.readInt();
        this.mIconUrl = parcel.readString();
        this.mState = parcel.readInt();
        this.mPaid = parcel.readLong();
        this.mIsClicked = parcel.readInt();
        this.mClassType = parcel.readInt();
        this.mClassTitle = parcel.readString();
        this.mClassAvatar = parcel.readString();
        this.mClassShow = parcel.readInt();
        this.mMarkTop = parcel.readInt();
        this.mMarkTopTime = parcel.readLong();
        this.mNickName = parcel.readString();
        this.mGameHistory = parcel.readString();
        this.mExt = parcel.readString();
        this.vPortrait = parcel.readString();
        this.mCertification = parcel.readString();
        this.mVipId = parcel.readString();
        this.mShield = parcel.readInt();
        this.mShieldTime = parcel.readLong();
        this.mSessionFrom = parcel.readInt();
        this.mLastMsgUid = parcel.readLong();
        this.mLastMsgName = parcel.readString();
        this.mNewFansAtMsgSum = parcel.readInt();
    }

    public void addExt(String str, String str2) {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    if (TextUtils.isEmpty(this.mExt)) {
                        jSONObject = new JSONObject();
                    } else {
                        jSONObject = new JSONObject(this.mExt);
                    }
                    jSONObject.put(str, str2);
                    this.mExt = jSONObject.toString();
                }
            } catch (Exception e) {
                LogUtils.e("ChatSession", "addExt", e);
            }
        }
    }

    public void setBusinessType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i) == null) {
            this.mBusinessType = i;
        }
    }

    public void setCertification(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, str) == null) {
            this.mCertification = str;
        }
    }

    public void setChatType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i) == null) {
            this.mChatType = i;
        }
    }

    public void setClassAvatar(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            this.mClassAvatar = str;
        }
    }

    public void setClassShow(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i) == null) {
            this.mClassShow = i;
        }
    }

    public void setClassTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, str) == null) {
            this.mClassTitle = str;
        }
    }

    public void setClassType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i) == null) {
            this.mClassType = i;
        }
    }

    public void setCollectionType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048626, this, i) == null) {
            this.mCollectionType = i;
        }
    }

    public void setContacter(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048627, this, j) == null) {
            this.mContacter = j;
        }
    }

    public void setExt(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, str) == null) {
            this.mExt = str;
        }
    }

    public void setGameHistory(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, str) == null) {
            this.mGameHistory = str;
        }
    }

    public void setIconUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, str) == null) {
            this.mIconUrl = str;
        }
    }

    public void setIsClicked(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048631, this, i) == null) {
            this.mIsClicked = i;
        }
    }

    public void setLastMsg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, str) == null) {
            this.mLastMsg = str;
        }
    }

    public void setLastMsgName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, str) == null) {
            this.mLastMsgName = str;
        }
    }

    public void setLastMsgTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048634, this, j) == null) {
            this.mLastMsgTime = j;
        }
    }

    public void setLastMsgUid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048635, this, j) == null) {
            this.mLastMsgUid = j;
        }
    }

    public void setLastOpenTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048636, this, j) == null) {
            this.mLastOpenTime = j;
        }
    }

    public void setMarkTop(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048637, this, i) == null) {
            this.mMarkTop = i;
        }
    }

    public void setMarkTopTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048638, this, j) == null) {
            this.mMarkTopTime = j;
        }
    }

    public void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, str) == null) {
            this.mName = str;
        }
    }

    public void setNewFansAtMsgSum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048640, this, i) == null) {
            this.mNewFansAtMsgSum = i;
        }
    }

    public void setNewMsgSum(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048641, this, j) == null) {
            this.mNewMsgSum = j;
        }
    }

    public void setNickName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, str) == null) {
            this.mNickName = str;
        }
    }

    public void setPaid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048643, this, j) == null) {
            this.mPaid = j;
        }
    }

    public void setSessionFrom(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048644, this, i) == null) {
            this.mSessionFrom = i;
        }
    }

    public void setShield(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048645, this, i) == null) {
            this.mShield = i;
        }
    }

    public void setShieldTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048646, this, j) == null) {
            this.mShieldTime = j;
        }
    }

    public void setShow(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048647, this, i) == null) {
            this.mShow = i;
        }
    }

    public void setState(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048648, this, i) == null) {
            this.mState = i;
        }
    }

    public void setVPortrait(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, str) == null) {
            this.vPortrait = str;
        }
    }

    public void setVipId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, str) == null) {
            this.mVipId = str;
        }
    }

    public void setWeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048651, this, i) == null) {
            this.mWeight = i;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("ChatSession [");
            sb.append(" category=");
            sb.append(this.mCategory);
            sb.append(" ,");
            sb.append(" name=");
            sb.append(this.mName);
            sb.append(" ,");
            sb.append(" unReadMsgCount=");
            sb.append(this.mNewMsgSum);
            sb.append(" ,");
            sb.append(" contacter=");
            sb.append(this.mContacter);
            sb.append(" ,");
            sb.append(" contacterId=");
            sb.append(this.mContacterId);
            sb.append(" ,");
            sb.append(" content=");
            sb.append(this.mLastMsg);
            sb.append(" ,");
            if (Long.valueOf(this.mLastMsgTime).toString().length() == 10) {
                sb.append(" time=");
                sb.append(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date(this.mLastMsgTime * 1000)));
                sb.append(" ,");
            } else {
                sb.append(" time=");
                sb.append(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date(this.mLastMsgTime)));
                sb.append(" ,");
            }
            sb.append(" chatType=");
            sb.append(this.mChatType);
            sb.append(" ,");
            sb.append(" mPaid=");
            sb.append(this.mPaid);
            sb.append(" ,");
            sb.append(" lastMsg=");
            sb.append(this.mLastMsg);
            sb.append(" ,");
            sb.append(" mMarkTop=");
            sb.append(this.mMarkTop);
            sb.append(" ,");
            sb.append(" mMarkTopTime=");
            sb.append(this.mMarkTopTime);
            sb.append(" ,");
            sb.append(" icon=");
            sb.append(this.mIconUrl);
            sb.append(" ,");
            sb.append(" mExt=");
            sb.append(this.mExt);
            sb.append(" ,");
            sb.append(" mShield=");
            sb.append(this.mShield);
            sb.append(" ,");
            sb.append(" mShieldTime=");
            sb.append(this.mShieldTime);
            sb.append(" ,");
            sb.append(" vPortrait=");
            sb.append(this.vPortrait);
            sb.append(" ,");
            sb.append(" mVipId=");
            sb.append(this.mVipId);
            sb.append(" ,");
            sb.append(" mCertification=");
            sb.append(this.mCertification);
            sb.append(" ,");
            sb.append(" mNickName=");
            sb.append(this.mNickName);
            sb.append(" ,");
            sb.append(" mLastMsgUid=");
            sb.append(this.mLastMsgUid);
            sb.append(" ,");
            sb.append(" mLastMsgName=");
            sb.append(this.mLastMsgName);
            sb.append(" ,");
            sb.append(" mNewFansAtMsgSum=");
            sb.append(this.mNewFansAtMsgSum);
            sb.append(" ,");
            sb.append(" mSessionFrom=");
            sb.append(this.mSessionFrom);
            sb.append(PreferencesUtil.RIGHT_MOUNT);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048653, this, parcel, i) == null) {
            parcel.writeInt(this.mCategory);
            parcel.writeLong(this.mContacter);
            parcel.writeLong(this.mContacterId);
            parcel.writeString(this.mName);
            parcel.writeString(this.mLastMsg);
            parcel.writeLong(this.mLastMsgTime);
            parcel.writeLong(this.mLastOpenTime);
            parcel.writeLong(this.mNewMsgSum);
            parcel.writeInt(this.mWeight);
            parcel.writeInt(this.mShow);
            parcel.writeInt(this.mCollectionType);
            parcel.writeInt(this.mChatType);
            parcel.writeString(this.mIconUrl);
            parcel.writeInt(this.mState);
            parcel.writeLong(this.mPaid);
            parcel.writeInt(this.mIsClicked);
            parcel.writeInt(this.mClassType);
            parcel.writeString(this.mClassTitle);
            parcel.writeString(this.mClassAvatar);
            parcel.writeInt(this.mClassShow);
            parcel.writeInt(this.mMarkTop);
            parcel.writeLong(this.mMarkTopTime);
            parcel.writeString(this.mNickName);
            parcel.writeString(this.mGameHistory);
            parcel.writeString(this.mExt);
            parcel.writeString(this.vPortrait);
            parcel.writeString(this.mCertification);
            parcel.writeString(this.mVipId);
            parcel.writeInt(this.mShield);
            parcel.writeLong(this.mShieldTime);
            parcel.writeInt(this.mSessionFrom);
            parcel.writeLong(this.mLastMsgUid);
            parcel.writeString(this.mLastMsgName);
            parcel.writeInt(this.mNewFansAtMsgSum);
        }
    }
}
