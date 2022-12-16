package com.baidu.android.imsdk.pubaccount;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
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
public class PaInfo implements Parcelable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<PaInfo> CREATOR;
    public static final String TAG = "PaInfo";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean acceptPush;
    public String avatar;
    public int bjhType;
    public int businessType;
    public String classavatar;
    public int classshow;
    public String classtitle;
    public int classtype;
    public String description;
    public String detail;
    public int disturb;
    public long mBduid;
    public String mBlockInfo;
    public int mHasIdentity;
    public String mIdentity;
    public long mImUk;
    public long mLastRefreshTime;
    public int mMapType;
    public boolean mMsgNotify;
    public int mRejectMenu;
    public String mRepliesStr;
    public String mSchema;
    public int mShield;
    public int mShieldMsg;
    public long mShieldTime;
    public int mSubscribe;
    public String mThirdExt;
    public String mVipId;
    public int markTop;
    public long markTopTime;
    public String name;
    public String nickName;
    public String paExt;
    public long paId;
    public int status;
    public long subcribeTime;
    public int subsetType;
    public int subtype;
    public long tpl;
    public String url;
    public String vPortrait;

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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(761306116, "Lcom/baidu/android/imsdk/pubaccount/PaInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(761306116, "Lcom/baidu/android/imsdk/pubaccount/PaInfo;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<PaInfo>() { // from class: com.baidu.android.imsdk.pubaccount.PaInfo.1
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
            public PaInfo createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && (invokeL = interceptable2.invokeL(1048576, this, parcel)) != null) {
                    return (PaInfo) invokeL.objValue;
                }
                return PaInfo.readFromParcel(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public PaInfo[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                    return new PaInfo[i];
                }
                return (PaInfo[]) invokeI.objValue;
            }
        };
    }

    public String getAvatar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.avatar;
        }
        return (String) invokeV.objValue;
    }

    public long getBduid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mBduid;
        }
        return invokeV.longValue;
    }

    public int getBjhType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.bjhType;
        }
        return invokeV.intValue;
    }

    public String getBlockInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mBlockInfo;
        }
        return (String) invokeV.objValue;
    }

    public int getBusinessType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.businessType;
        }
        return invokeV.intValue;
    }

    public String getClassTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.classtitle;
        }
        return (String) invokeV.objValue;
    }

    public int getClassType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.classtype;
        }
        return invokeV.intValue;
    }

    public String getClassavatar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.classavatar;
        }
        return (String) invokeV.objValue;
    }

    public int getClassshow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.classshow;
        }
        return invokeV.intValue;
    }

    public String getDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.description;
        }
        return (String) invokeV.objValue;
    }

    public String getDetail() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.detail;
        }
        return (String) invokeV.objValue;
    }

    public int getDisturb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.disturb;
        }
        return invokeV.intValue;
    }

    public int getHasIdentity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mHasIdentity;
        }
        return invokeV.intValue;
    }

    public String getIdentity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.mIdentity;
        }
        return (String) invokeV.objValue;
    }

    public long getImUk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.mImUk;
        }
        return invokeV.longValue;
    }

    public long getLastRefreshTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.mLastRefreshTime;
        }
        return invokeV.longValue;
    }

    public int getMapType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.mMapType;
        }
        return invokeV.intValue;
    }

    public int getMarkTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.markTop;
        }
        return invokeV.intValue;
    }

    public long getMarkTopTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.markTopTime;
        }
        return invokeV.longValue;
    }

    public String getNickName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.nickName;
        }
        return (String) invokeV.objValue;
    }

    public String getPaExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.paExt;
        }
        return (String) invokeV.objValue;
    }

    public long getPaId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.paId;
        }
        return invokeV.longValue;
    }

    public int getRejectMenu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.mRejectMenu;
        }
        return invokeV.intValue;
    }

    public String getRepliesStr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.mRepliesStr;
        }
        return (String) invokeV.objValue;
    }

    public int getShield() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.mShield;
        }
        return invokeV.intValue;
    }

    public int getShieldMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.mShieldMsg;
        }
        return invokeV.intValue;
    }

    public long getShieldTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.mShieldTime;
        }
        return invokeV.longValue;
    }

    public int getStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.status;
        }
        return invokeV.intValue;
    }

    public long getSubcribeTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.subcribeTime;
        }
        return invokeV.longValue;
    }

    public int getSubscribe() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.mSubscribe;
        }
        return invokeV.intValue;
    }

    public int getSubsetType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.subsetType;
        }
        return invokeV.intValue;
    }

    public int getSubtype() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.subtype;
        }
        return invokeV.intValue;
    }

    public long getTPL() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.tpl;
        }
        return invokeV.longValue;
    }

    public String getThirdExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.mThirdExt;
        }
        return (String) invokeV.objValue;
    }

    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.url;
        }
        return (String) invokeV.objValue;
    }

    public String getUsername() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.name;
        }
        return (String) invokeV.objValue;
    }

    public String getVPortrait() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.vPortrait;
        }
        return (String) invokeV.objValue;
    }

    public String getVipId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.mVipId;
        }
        return (String) invokeV.objValue;
    }

    public boolean isAcceptPush() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.acceptPush;
        }
        return invokeV.booleanValue;
    }

    public boolean isMsgNotify() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.mMsgNotify;
        }
        return invokeV.booleanValue;
    }

    public PaInfo() {
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
        this.subsetType = 0;
        this.mShieldMsg = 0;
        this.mLastRefreshTime = -1L;
        this.mVipId = "";
        this.vPortrait = "";
        this.mHasIdentity = 0;
        this.mShield = 0;
        this.mShieldTime = 0L;
        this.mIdentity = "";
        this.mSubscribe = 0;
        this.mThirdExt = "";
        this.mSchema = "";
    }

    public String getSchema() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (TextUtils.isEmpty(this.mSchema) && !TextUtils.isEmpty(this.mThirdExt)) {
                try {
                    this.mSchema = new JSONObject(this.mThirdExt).optString(DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE, "");
                } catch (Exception unused) {
                    LogUtils.d(TAG, "getSchema JsonException");
                }
            }
            return this.mSchema;
        }
        return (String) invokeV.objValue;
    }

    public String getThirdId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            if (!TextUtils.isEmpty(this.mThirdExt)) {
                try {
                    return new JSONObject(this.mThirdExt).optString("third_id", "");
                } catch (Exception unused) {
                    LogUtils.d(TAG, "getThirdId JsonException");
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    private void setBjhType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i) == null) {
            this.bjhType = i;
        }
    }

    public void setAcceptPush(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.acceptPush = z;
        }
    }

    public void setAvatar(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, str) == null) {
            this.avatar = str;
        }
    }

    public void setBduid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048621, this, j) == null) {
            this.mBduid = j;
        }
    }

    public void setBlockInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            this.mBlockInfo = str;
        }
    }

    public void setBusinessType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i) == null) {
            this.businessType = i;
        }
    }

    public void setClassAvatar(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, str) == null) {
            this.classavatar = str;
        }
    }

    public void setClassType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i) == null) {
            this.classtype = i;
        }
    }

    public void setClassshow(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048626, this, i) == null) {
            this.classshow = i;
        }
    }

    public void setClasstitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, str) == null) {
            this.classtitle = str;
        }
    }

    public void setDescription(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, str) == null) {
            this.description = str;
        }
    }

    public void setDetail(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, str) == null) {
            this.detail = str;
        }
    }

    public void setDisturb(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048630, this, i) == null) {
            this.disturb = i;
        }
    }

    public void setHasIdentity(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048631, this, i) == null) {
            this.mHasIdentity = i;
        }
    }

    public void setIdentity(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, str) == null) {
            this.mIdentity = str;
        }
    }

    public void setImUk(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048633, this, j) == null) {
            this.mImUk = j;
        }
    }

    public void setLastRefreshTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048634, this, j) == null) {
            this.mLastRefreshTime = j;
        }
    }

    public void setMapType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048635, this, i) == null) {
            this.mMapType = i;
        }
    }

    public void setMarkTop(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048636, this, i) == null) {
            this.markTop = i;
        }
    }

    public void setMarkTopTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048637, this, j) == null) {
            this.markTopTime = j;
        }
    }

    public void setMsgNotify(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048638, this, z) == null) {
            this.mMsgNotify = z;
        }
    }

    public void setNickName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, str) == null) {
            this.nickName = str;
        }
    }

    public void setPaExt(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, str) == null) {
            this.paExt = str;
            if (!TextUtils.isEmpty(str)) {
                try {
                    setBjhType(new JSONObject(str).optInt("bjh_type", 0));
                } catch (JSONException unused) {
                    LogUtils.d(TAG, "setPaExt JsonException");
                }
            }
        }
    }

    public void setPaId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048641, this, j) == null) {
            this.paId = j;
        }
    }

    public void setRejectMenu(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048642, this, i) == null) {
            this.mRejectMenu = i;
        }
    }

    public void setRepliesStr(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, str) == null) {
            this.mRepliesStr = str;
        }
    }

    public void setSchema(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, str) == null) {
            this.mSchema = str;
        }
    }

    public void setShield(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048645, this, i) == null) {
            this.mShield = i;
        }
    }

    public void setShieldMsg(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048646, this, i) == null) {
            this.mShieldMsg = i;
        }
    }

    public void setShieldTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048647, this, j) == null) {
            this.mShieldTime = j;
        }
    }

    public void setStatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048648, this, i) == null) {
            this.status = i;
        }
    }

    public void setSubcribeTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048649, this, j) == null) {
            this.subcribeTime = j;
        }
    }

    public void setSubscribe(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048650, this, i) == null) {
            this.mSubscribe = i;
        }
    }

    public void setSubsetType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048651, this, i) == null) {
            this.subsetType = i;
        }
    }

    public void setSubtype(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048652, this, i) == null) {
            this.subtype = i;
        }
    }

    public void setTPL(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048653, this, j) == null) {
            this.tpl = j;
        }
    }

    public void setThirdExt(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, str) == null) {
            this.mThirdExt = str;
            if (!TextUtils.isEmpty(str)) {
                try {
                    setSchema(new JSONObject(str).optString(DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE, ""));
                } catch (Exception unused) {
                    LogUtils.d(TAG, "setThirdExt JSONException");
                }
            }
        }
    }

    public void setUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, str) == null) {
            this.url = str;
        }
    }

    public void setUsername(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048656, this, str) == null) {
            this.name = str;
        }
    }

    public void setVPortrait(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048657, this, str) == null) {
            this.vPortrait = str;
        }
    }

    public void setVipId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048658, this, str) == null) {
            this.mVipId = str;
        }
    }

    public static PaInfo readFromParcel(Parcel parcel) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, parcel)) == null) {
            PaInfo paInfo = new PaInfo();
            paInfo.setPaId(parcel.readLong());
            paInfo.setNickName(parcel.readString());
            paInfo.setAvatar(parcel.readString());
            boolean z2 = false;
            if (parcel.readInt() == 1) {
                z = true;
            } else {
                z = false;
            }
            paInfo.setAcceptPush(z);
            paInfo.setDescription(parcel.readString());
            paInfo.setUrl(parcel.readString());
            paInfo.setSubcribeTime(parcel.readLong());
            paInfo.setDetail(parcel.readString());
            paInfo.setUsername(parcel.readString());
            paInfo.setTPL(parcel.readLong());
            paInfo.setDisturb(parcel.readInt());
            paInfo.setSubtype(parcel.readInt());
            paInfo.setClassType(parcel.readInt());
            paInfo.setClasstitle(parcel.readString());
            paInfo.setClassAvatar(parcel.readString());
            paInfo.setStatus(parcel.readInt());
            if (parcel.readInt() == 1) {
                z2 = true;
            }
            paInfo.setMsgNotify(z2);
            paInfo.setMarkTop(parcel.readInt());
            paInfo.setMarkTopTime(parcel.readLong());
            paInfo.setRepliesStr(parcel.readString());
            paInfo.setLastRefreshTime(parcel.readLong());
            paInfo.setSubsetType(parcel.readInt());
            paInfo.setShieldMsg(parcel.readInt());
            paInfo.setPaExt(parcel.readString());
            paInfo.setVPortrait(parcel.readString());
            paInfo.setVipId(parcel.readString());
            paInfo.setHasIdentity(parcel.readInt());
            paInfo.setShield(parcel.readInt());
            paInfo.setShieldTime(parcel.readLong());
            paInfo.setIdentity(parcel.readString());
            paInfo.setSubscribe(parcel.readInt());
            paInfo.setThirdExt(parcel.readString());
            paInfo.setSchema(parcel.readString());
            paInfo.setRejectMenu(parcel.readInt());
            paInfo.setBjhType(parcel.readInt());
            paInfo.setImUk(parcel.readLong());
            paInfo.setBduid(parcel.readLong());
            paInfo.setMapType(parcel.readInt());
            return paInfo;
        }
        return (PaInfo) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            return "PaInfo [pdId=" + this.paId + " nickName=" + this.nickName + " disturb= " + this.disturb + " description=" + this.description + " acceptPush=" + this.acceptPush + " url=" + this.url + " subscribeTime" + this.subcribeTime + " classtype= " + this.classtype + "  classtitle= " + this.classtitle + " markTop= " + this.markTop + " markTopTime= " + this.markTopTime + "  classavatar= " + this.classavatar + " mMsgNotify= " + this.mMsgNotify + " mRepliesStr= " + this.mRepliesStr + " mLastRefreshTime= " + this.mLastRefreshTime + " subsetType= " + this.subsetType + " paExt= " + this.paExt + " vPortrait= " + this.vPortrait + " mHasIdentity= " + this.mHasIdentity + " mShield= " + this.mShield + " mShieldTime " + this.mShieldTime + " mIdentity= " + this.mIdentity + " mVipId= " + this.mVipId + ", schema=" + this.mSchema + ", mMapType=" + this.mMapType + ", schema=" + this.mSchema + "， mShieldMsg=" + this.mShieldMsg + ", mSubscribe=" + this.mSubscribe + ", mThirdExt=" + this.mThirdExt + ", mRejectMenu=" + this.mRejectMenu + "  ]";
        }
        return (String) invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048660, this, parcel, i) == null) {
            parcel.writeLong(this.paId);
            parcel.writeString(this.nickName);
            parcel.writeString(this.avatar);
            parcel.writeInt(this.acceptPush ? 1 : 0);
            parcel.writeString(this.description);
            parcel.writeString(this.url);
            parcel.writeLong(this.subcribeTime);
            parcel.writeString(this.detail);
            parcel.writeString(this.name);
            parcel.writeLong(this.tpl);
            parcel.writeInt(this.disturb);
            parcel.writeInt(this.subtype);
            parcel.writeInt(this.classtype);
            parcel.writeString(this.classtitle);
            parcel.writeString(this.classavatar);
            parcel.writeInt(this.status);
            parcel.writeInt(this.mMsgNotify ? 1 : 0);
            parcel.writeInt(this.markTop);
            parcel.writeLong(this.markTopTime);
            parcel.writeString(this.mRepliesStr);
            parcel.writeLong(this.mLastRefreshTime);
            parcel.writeInt(this.subsetType);
            parcel.writeInt(this.mShieldMsg);
            parcel.writeString(this.paExt);
            parcel.writeString(this.vPortrait);
            parcel.writeString(this.mVipId);
            parcel.writeInt(this.mHasIdentity);
            parcel.writeInt(this.mShield);
            parcel.writeLong(this.mShieldTime);
            parcel.writeString(this.mIdentity);
            parcel.writeInt(this.mSubscribe);
            parcel.writeString(this.mThirdExt);
            parcel.writeString(this.mSchema);
            parcel.writeInt(this.mRejectMenu);
            parcel.writeInt(this.bjhType);
            parcel.writeLong(this.mImUk);
            parcel.writeLong(this.mBduid);
            parcel.writeInt(this.mMapType);
        }
    }
}
