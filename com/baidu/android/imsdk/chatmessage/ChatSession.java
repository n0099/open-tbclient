package com.baidu.android.imsdk.chatmessage;

import android.annotation.SuppressLint;
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
/* loaded from: classes9.dex */
public final class ChatSession implements Parcelable, NoProGuard, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<ChatSession> CREATOR;
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
        CREATOR = new Parcelable.Creator<ChatSession>() { // from class: com.baidu.android.imsdk.chatmessage.ChatSession.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ChatSession createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new ChatSession(parcel) : (ChatSession) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ChatSession[] newArray(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? new ChatSession[i2] : (ChatSession[]) invokeI.objValue;
            }
        };
    }

    public ChatSession(int i2, long j2, long j3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
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
        this.mContacter = j2;
        this.mName = str;
        this.mCategory = i2;
        this.mContacterId = j3;
    }

    public void addExt(String str, String str2) {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    return;
                }
                if (TextUtils.isEmpty(this.mExt)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(this.mExt);
                }
                jSONObject.put(str, str2);
                this.mExt = jSONObject.toString();
            } catch (Exception e2) {
                LogUtils.e("ChatSession", "addExt", e2);
            }
        }
    }

    public void clearExt() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || TextUtils.isEmpty(this.mExt)) {
            return;
        }
        this.mExt = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public int getBusinessType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mBusinessType : invokeV.intValue;
    }

    public int getCategory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mCategory : invokeV.intValue;
    }

    public String getCertification() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mCertification : (String) invokeV.objValue;
    }

    public ChatSession getChatRecord() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this : (ChatSession) invokeV.objValue;
    }

    public int getChatType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mChatType : invokeV.intValue;
    }

    public String getClassAvatar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mClassAvatar : (String) invokeV.objValue;
    }

    public int getClassShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mClassShow : invokeV.intValue;
    }

    public String getClassTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mClassTitle : (String) invokeV.objValue;
    }

    public int getClassType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mClassType : invokeV.intValue;
    }

    public int getCollectionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mCollectionType : invokeV.intValue;
    }

    public long getContacter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mContacter : invokeV.longValue;
    }

    public long getContacterId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mContacterId : invokeV.longValue;
    }

    public String getExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mExt : (String) invokeV.objValue;
    }

    public String getGameHistory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mGameHistory : (String) invokeV.objValue;
    }

    public String getIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mIconUrl : (String) invokeV.objValue;
    }

    public int getIsClicked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mIsClicked : invokeV.intValue;
    }

    public String getLastMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.mLastMsg : (String) invokeV.objValue;
    }

    public String getLastMsgName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.mLastMsgName : (String) invokeV.objValue;
    }

    public long getLastMsgTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.mLastMsgTime : invokeV.longValue;
    }

    public long getLastMsgUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.mLastMsgUid : invokeV.longValue;
    }

    public long getLastOpenTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.mLastOpenTime : invokeV.longValue;
    }

    public int getMarkTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.mMarkTop : invokeV.intValue;
    }

    public long getMarkTopTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.mMarkTopTime : invokeV.longValue;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.mName : (String) invokeV.objValue;
    }

    public int getNewFansAtMsgSum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.mNewFansAtMsgSum : invokeV.intValue;
    }

    public long getNewMsgSum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.mNewMsgSum : invokeV.longValue;
    }

    public String getNickName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.mNickName : (String) invokeV.objValue;
    }

    public long getPaid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.mPaid : invokeV.longValue;
    }

    public int getSessionFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.mSessionFrom : invokeV.intValue;
    }

    public int getShield() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.mShield : invokeV.intValue;
    }

    public long getShieldTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.mShieldTime : invokeV.longValue;
    }

    public int getShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.mShow : invokeV.intValue;
    }

    public int getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.mState : invokeV.intValue;
    }

    public String getVPortrait() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.vPortrait : (String) invokeV.objValue;
    }

    public String getVipId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.mVipId : (String) invokeV.objValue;
    }

    public int getWeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.mWeight : invokeV.intValue;
    }

    public boolean isRed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.mIsClicked == 0 : invokeV.booleanValue;
    }

    public boolean isShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.mShow == 1 : invokeV.booleanValue;
    }

    public void setBusinessType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i2) == null) {
            this.mBusinessType = i2;
        }
    }

    public void setCertification(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, str) == null) {
            this.mCertification = str;
        }
    }

    public void setChatType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i2) == null) {
            this.mChatType = i2;
        }
    }

    public void setClassAvatar(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            this.mClassAvatar = str;
        }
    }

    public void setClassShow(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i2) == null) {
            this.mClassShow = i2;
        }
    }

    public void setClassTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, str) == null) {
            this.mClassTitle = str;
        }
    }

    public void setClassType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i2) == null) {
            this.mClassType = i2;
        }
    }

    public void setCollectionType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048626, this, i2) == null) {
            this.mCollectionType = i2;
        }
    }

    public void setContacter(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048627, this, j2) == null) {
            this.mContacter = j2;
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

    public void setIsClicked(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048631, this, i2) == null) {
            this.mIsClicked = i2;
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

    public void setLastMsgTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048634, this, j2) == null) {
            this.mLastMsgTime = j2;
        }
    }

    public void setLastMsgUid(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048635, this, j2) == null) {
            this.mLastMsgUid = j2;
        }
    }

    public void setLastOpenTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048636, this, j2) == null) {
            this.mLastOpenTime = j2;
        }
    }

    public void setMarkTop(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048637, this, i2) == null) {
            this.mMarkTop = i2;
        }
    }

    public void setMarkTopTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048638, this, j2) == null) {
            this.mMarkTopTime = j2;
        }
    }

    public void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, str) == null) {
            this.mName = str;
        }
    }

    public void setNewFansAtMsgSum(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048640, this, i2) == null) {
            this.mNewFansAtMsgSum = i2;
        }
    }

    public void setNewMsgSum(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048641, this, j2) == null) {
            this.mNewMsgSum = j2;
        }
    }

    public void setNickName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, str) == null) {
            this.mNickName = str;
        }
    }

    public void setPaid(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048643, this, j2) == null) {
            this.mPaid = j2;
        }
    }

    public void setSessionFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048644, this, i2) == null) {
            this.mSessionFrom = i2;
        }
    }

    public void setShield(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048645, this, i2) == null) {
            this.mShield = i2;
        }
    }

    public void setShieldTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048646, this, j2) == null) {
            this.mShieldTime = j2;
        }
    }

    public void setShow(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048647, this, i2) == null) {
            this.mShow = i2;
        }
    }

    public void setState(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048648, this, i2) == null) {
            this.mState = i2;
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

    public void setWeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048651, this, i2) == null) {
            this.mWeight = i2;
        }
    }

    @SuppressLint({"SimpleDateFormat"})
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
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048653, this, parcel, i2) == null) {
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

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public ChatSession m31clone() throws CloneNotSupportedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (ChatSession) super.clone() : (ChatSession) invokeV.objValue;
    }

    public ChatSession() {
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

    public ChatSession(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
}
