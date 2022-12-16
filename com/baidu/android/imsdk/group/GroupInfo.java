package com.baidu.android.imsdk.group;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import com.baidu.android.imsdk.utils.PinYinUtils;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GroupInfo implements Parcelable, NoProGuard, PinYinUtils.PinYinObject {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<GroupInfo> CREATOR;
    public static final String TAG = "GroupInfo";
    public transient /* synthetic */ FieldHolder $fh;
    public int brief;
    public int mActiveState;
    public int mAuditState;
    public long mBduid;
    public long mCreateTime;
    public String mDescription;
    public int mDisturb;
    public int mGroupCapacity;
    public String mGroupId;
    public String mGroupName;
    public String mGroupNotice;
    public String mGroupNoticeAuthorBduk;
    public long mGroupNoticePublishTime;
    public int mGroupVerify;
    public int mHasNotice;
    public String mHeadUrl;
    public String mHomePage;
    public long mInfoVersion;
    public long mLocalInfoVersion;
    public long mLocalMembersVersion;
    public int mMarkTop;
    public long mMarkTopTime;
    public int mMaxAdminCount;
    public long mMembersVersion;
    public String mNoticeExt;
    public int mNum;
    public String mPinYin;
    public String mSettingInfo;
    public int mSubType;
    public int mType;
    public long mUk;
    public String mWelcomeContent;
    public int mWelcomeDisplayRangeSwitch;
    public String mWelcomeJsonTxt;
    public String mWelcomeOperatorBdUk;
    public long mWelcomeOperatorTimeSeconds;
    public int state;

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(734867013, "Lcom/baidu/android/imsdk/group/GroupInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(734867013, "Lcom/baidu/android/imsdk/group/GroupInfo;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<GroupInfo>() { // from class: com.baidu.android.imsdk.group.GroupInfo.1
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
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public GroupInfo createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                    return new GroupInfo(parcel);
                }
                return (GroupInfo) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public GroupInfo[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                    return new GroupInfo[i];
                }
                return (GroupInfo[]) invokeI.objValue;
            }
        };
    }

    public int getActiveState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mActiveState;
        }
        return invokeV.intValue;
    }

    public int getAuditState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mAuditState;
        }
        return invokeV.intValue;
    }

    public int getBrief() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.brief;
        }
        return invokeV.intValue;
    }

    public long getBuid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mBduid;
        }
        return invokeV.longValue;
    }

    public long getCreateTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mCreateTime;
        }
        return invokeV.longValue;
    }

    public String getDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mDescription;
        }
        return (String) invokeV.objValue;
    }

    public int getDisturb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mDisturb;
        }
        return invokeV.intValue;
    }

    public int getGroupCapacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mGroupCapacity;
        }
        return invokeV.intValue;
    }

    public String getGroupId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mGroupId;
        }
        return (String) invokeV.objValue;
    }

    public String getGroupName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mGroupName;
        }
        return (String) invokeV.objValue;
    }

    public String getGroupNotice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mGroupNotice;
        }
        return (String) invokeV.objValue;
    }

    public long getGroupNoticePublishTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mGroupNoticePublishTime;
        }
        return invokeV.longValue;
    }

    public int getGroupVerify() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mGroupVerify;
        }
        return invokeV.intValue;
    }

    public int getHasGroupNotice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.mHasNotice;
        }
        return invokeV.intValue;
    }

    public String getHeadUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.mHeadUrl;
        }
        return (String) invokeV.objValue;
    }

    public String getHomePage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.mHomePage;
        }
        return (String) invokeV.objValue;
    }

    public long getInfoVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.mInfoVersion;
        }
        return invokeV.longValue;
    }

    public long getLocalInfoVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.mLocalInfoVersion;
        }
        return invokeV.longValue;
    }

    public long getLocalMembersVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.mLocalMembersVersion;
        }
        return invokeV.longValue;
    }

    public int getMarkTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.mMarkTop;
        }
        return invokeV.intValue;
    }

    public long getMarkTopTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.mMarkTopTime;
        }
        return invokeV.longValue;
    }

    public int getMaxAdminCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.mMaxAdminCount;
        }
        return invokeV.intValue;
    }

    public long getMembersVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.mMembersVersion;
        }
        return invokeV.longValue;
    }

    public String getNoticeAuthorBduk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.mGroupNoticeAuthorBduk;
        }
        return (String) invokeV.objValue;
    }

    public String getNoticeExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.mNoticeExt;
        }
        return (String) invokeV.objValue;
    }

    public int getNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.mNum;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.android.imsdk.utils.PinYinUtils.PinYinObject
    public String getPy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            if (TextUtils.isEmpty(this.mPinYin)) {
                this.mPinYin = PinYinUtils.getPy(this.mGroupName);
            }
            return this.mPinYin;
        }
        return (String) invokeV.objValue;
    }

    public String getSettingInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.mSettingInfo;
        }
        return (String) invokeV.objValue;
    }

    public int getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.state;
        }
        return invokeV.intValue;
    }

    public int getSubType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.mSubType;
        }
        return invokeV.intValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.mType;
        }
        return invokeV.intValue;
    }

    public long getUk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.mUk;
        }
        return invokeV.longValue;
    }

    public String getWelcomeContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.mWelcomeContent;
        }
        return (String) invokeV.objValue;
    }

    public int getWelcomeDisplayRangeSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.mWelcomeDisplayRangeSwitch;
        }
        return invokeV.intValue;
    }

    public String getWelcomeJsonTxt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.mWelcomeJsonTxt;
        }
        return (String) invokeV.objValue;
    }

    public String getWelcomeOperatorBdUk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.mWelcomeOperatorBdUk;
        }
        return (String) invokeV.objValue;
    }

    public long getWelcomeOperatorTimeSeconds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.mWelcomeOperatorTimeSeconds;
        }
        return invokeV.longValue;
    }

    public GroupInfo(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mGroupName = "";
        this.mDescription = "";
        this.mType = 0;
        this.mGroupId = parcel.readString();
        this.mGroupName = parcel.readString();
        this.mDescription = parcel.readString();
        this.mDisturb = parcel.readInt();
        this.state = parcel.readInt();
        this.mType = parcel.readInt();
        this.mNum = parcel.readInt();
        this.mCreateTime = parcel.readLong();
        this.mBduid = parcel.readLong();
        this.mUk = parcel.readLong();
        this.mActiveState = parcel.readInt();
        this.mMembersVersion = parcel.readLong();
        this.brief = parcel.readInt();
        this.mMarkTop = parcel.readInt();
        this.mMarkTopTime = parcel.readLong();
        this.mGroupNotice = parcel.readString();
        this.mGroupCapacity = parcel.readInt();
        this.mGroupVerify = parcel.readInt();
        this.mLocalMembersVersion = parcel.readLong();
        this.mLocalInfoVersion = parcel.readLong();
        this.mInfoVersion = parcel.readLong();
        this.mMaxAdminCount = parcel.readInt();
        this.mSubType = parcel.readInt();
        this.mSettingInfo = parcel.readString();
        this.mHomePage = parcel.readString();
        this.mAuditState = parcel.readInt();
        this.mNoticeExt = parcel.readString();
        this.mHasNotice = parcel.readInt();
        this.mWelcomeJsonTxt = parcel.readString();
        this.mWelcomeContent = parcel.readString();
        this.mWelcomeOperatorBdUk = parcel.readString();
        this.mWelcomeOperatorTimeSeconds = parcel.readLong();
        this.mWelcomeDisplayRangeSwitch = parcel.readInt();
    }

    public GroupInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mGroupName = "";
        this.mDescription = "";
        this.mType = 0;
        this.mGroupId = str;
    }

    private void parseGroupNoticeExt() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65539, this) != null) || TextUtils.isEmpty(this.mNoticeExt)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.mNoticeExt);
            this.mGroupNoticeAuthorBduk = jSONObject.optString("operator");
            this.mGroupNoticePublishTime = jSONObject.optLong("operation_time", 0L);
        } catch (JSONException e) {
            LogUtils.d(TAG, e.toString());
        }
    }

    private void parseWelcomeJson() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) != null) || TextUtils.isEmpty(this.mWelcomeJsonTxt)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.mWelcomeJsonTxt);
            this.mWelcomeContent = jSONObject.optString("content", "");
            this.mWelcomeDisplayRangeSwitch = jSONObject.optInt("operation_type", 0);
            this.mWelcomeOperatorBdUk = jSONObject.optString("operator", "");
            this.mWelcomeOperatorTimeSeconds = jSONObject.optLong("operation_time", 0L);
        } catch (JSONException e) {
            if (Constants.isDebugMode()) {
                Log.d(TAG, "parse welcome json exception," + e.toString());
            }
        }
    }

    public void setActiveState(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i) == null) {
            this.mActiveState = i;
        }
    }

    public void setAuditState(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i) == null) {
            this.mAuditState = i;
        }
    }

    public void setBrief(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i) == null) {
            this.brief = i;
        }
    }

    public void setBuid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048617, this, j) == null) {
            this.mBduid = j;
        }
    }

    public void setCreateTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048618, this, j) == null) {
            this.mCreateTime = j;
        }
    }

    public void setDescription(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, str) == null) {
            this.mDescription = str;
        }
    }

    public void setDisturb(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048620, this, i) == null) {
            this.mDisturb = i;
        }
    }

    public void setGroupCapacity(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i) == null) {
            this.mGroupCapacity = i;
        }
    }

    public void setGroupName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            this.mGroupName = str;
        }
    }

    public void setGroupNotice(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, str) == null) {
            this.mGroupNotice = str;
        }
    }

    public void setGroupVerify(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048624, this, i) == null) {
            this.mGroupVerify = i;
        }
    }

    public void setHasNotice(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i) == null) {
            this.mHasNotice = i;
        }
    }

    public void setHeadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, str) == null) {
            this.mHeadUrl = str;
        }
    }

    public void setHomePage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, str) == null) {
            this.mHomePage = str;
        }
    }

    public void setInfoVersion(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048628, this, j) == null) {
            this.mInfoVersion = j;
        }
    }

    public void setLocalInfoVersion(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048629, this, j) == null) {
            this.mLocalInfoVersion = j;
        }
    }

    public void setLocalMembersVersion(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048630, this, j) == null) {
            this.mLocalMembersVersion = j;
        }
    }

    public void setMarkTop(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048631, this, i) == null) {
            this.mMarkTop = i;
        }
    }

    public void setMarkTopTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048632, this, j) == null) {
            this.mMarkTopTime = j;
        }
    }

    public void setMaxAdminCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048633, this, i) == null) {
            this.mMaxAdminCount = i;
        }
    }

    public void setMembersVersion(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048634, this, j) == null) {
            this.mMembersVersion = j;
        }
    }

    public void setNoticeExt(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, str) == null) {
            this.mNoticeExt = str;
            parseGroupNoticeExt();
        }
    }

    public void setNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048636, this, i) == null) {
            this.mNum = i;
        }
    }

    public void setSettingInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, str) == null) {
            this.mSettingInfo = str;
        }
    }

    public void setState(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048638, this, i) == null) {
            this.state = i;
        }
    }

    public void setSubType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048639, this, i) == null) {
            this.mSubType = i;
        }
    }

    public void setType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048640, this, i) == null) {
            this.mType = i;
        }
    }

    public void setUk(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048641, this, j) == null) {
            this.mUk = j;
        }
    }

    public void setWelcomeDisplayRangeSwitch(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048642, this, i) == null) {
            this.mWelcomeDisplayRangeSwitch = i;
        }
    }

    public void setWelcomeJsonTxt(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, str) == null) {
            this.mWelcomeJsonTxt = str;
            parseWelcomeJson();
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            return "GroupInfo [mGroupId=" + this.mGroupId + ", mGroupName=" + this.mGroupName + ", mDescription=" + this.mDescription + ", mType=" + this.mType + ", mPinYin=" + this.mPinYin + ", mCreateTime=" + this.mCreateTime + ", mBduid=" + this.mBduid + ", mUk=" + this.mUk + ", mNum=" + this.mNum + ", mGroupCapacity=" + this.mGroupCapacity + ", mMembersVersion=" + this.mMembersVersion + ", mDisturb=" + this.mDisturb + ", state=" + this.state + ", activeState=" + this.mActiveState + " marktop = " + this.mMarkTop + " martTime = " + this.mMarkTopTime + ", mAuditState=" + this.mAuditState + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048645, this, parcel, i) == null) {
            parcel.writeString(this.mGroupId);
            parcel.writeString(this.mGroupName);
            parcel.writeString(this.mDescription);
            parcel.writeInt(this.mDisturb);
            parcel.writeInt(this.state);
            parcel.writeInt(this.mType);
            parcel.writeInt(this.mNum);
            parcel.writeLong(this.mCreateTime);
            parcel.writeLong(this.mBduid);
            parcel.writeLong(this.mUk);
            parcel.writeInt(this.mActiveState);
            parcel.writeLong(this.mMembersVersion);
            parcel.writeInt(this.brief);
            parcel.writeInt(this.mMarkTop);
            parcel.writeLong(this.mMarkTopTime);
            parcel.writeString(this.mGroupNotice);
            parcel.writeInt(this.mGroupCapacity);
            parcel.writeInt(this.mGroupVerify);
            parcel.writeLong(this.mLocalMembersVersion);
            parcel.writeLong(this.mLocalInfoVersion);
            parcel.writeLong(this.mInfoVersion);
            parcel.writeInt(this.mMaxAdminCount);
            parcel.writeInt(this.mSubType);
            parcel.writeString(this.mSettingInfo);
            parcel.writeString(this.mHomePage);
            parcel.writeInt(this.mAuditState);
            parcel.writeString(this.mNoticeExt);
            parcel.writeInt(this.mHasNotice);
            parcel.writeString(this.mWelcomeJsonTxt);
            parcel.writeString(this.mWelcomeContent);
            parcel.writeString(this.mWelcomeOperatorBdUk);
            parcel.writeLong(this.mWelcomeOperatorTimeSeconds);
            parcel.writeInt(this.mWelcomeDisplayRangeSwitch);
        }
    }
}
