package com.baidu.swan.pms.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.e84;
import com.repackage.f84;
/* loaded from: classes2.dex */
public class PMSAppInfo implements Parcelable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<PMSAppInfo> CREATOR;
    public static final long DEFAULT_SWAN_APP_PKG_MAX_AGE = 432000;
    public static final int ORIENTATION_LANDSCAPE = 1;
    public static final int ORIENTATION_PORTRAIT = 0;
    public static final int ORIENTATION_UNKNOWN = -1;
    public static final int STATUS_NO_ERROR = 0;
    public static final int UN_FORBIDDEN = 0;
    public static final int WEB_PERMIT_DOWNGRADE_ALLOW = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public int appCategory;
    public String appId;
    public String appKey;
    public String appName;
    public long appSign;
    public int appStatus;
    public String bearInfo;
    public String brandsInfo;
    public long createTime;
    public int csProtocolVersion;
    public int customerService;
    public String description;
    public String domainConfig;
    public String domains;
    public int globalNotice;
    public int globalPrivate;
    public String iconUrl;
    public int installSrc;
    public long lastLaunchTime;
    public int launchCount;
    public long maxAge;
    public int orientation;
    public String paNumber;
    public int payProtected;
    public int pendingErrCode;
    public long pkgSize;
    public String pluginInfo;
    public String quickAppKey;
    public int rank;
    public String resumeDate;
    public String serverExt;
    public String serviceCategory;
    public String statusDesc;
    public String statusDetail;
    public String subjectInfo;
    public int type;
    public String userActionApis;
    public long versionCode;
    public String versionName;
    public String webAction;
    public int webPermit;
    public String webUrl;
    public String webViewDomains;

    /* loaded from: classes2.dex */
    public static class a implements Parcelable.Creator<PMSAppInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PMSAppInfo createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) ? new PMSAppInfo(parcel) : (PMSAppInfo) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public PMSAppInfo[] newArray(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? new PMSAppInfo[i] : (PMSAppInfo[]) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1205388723, "Lcom/baidu/swan/pms/model/PMSAppInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1205388723, "Lcom/baidu/swan/pms/model/PMSAppInfo;");
                return;
            }
        }
        CREATOR = new a();
    }

    public PMSAppInfo() {
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
        this.orientation = -1;
        this.maxAge = DEFAULT_SWAN_APP_PKG_MAX_AGE;
        this.lastLaunchTime = 0L;
        this.launchCount = 0;
        this.installSrc = 0;
        this.webPermit = 0;
    }

    public boolean checkValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !TextUtils.isEmpty(this.appKey) && this.appSign > 0 : invokeV.booleanValue;
    }

    public void copyLocalAppInfoData(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSAppInfo) == null) && pMSAppInfo != null && TextUtils.equals(this.appId, pMSAppInfo.appId)) {
            this.versionCode = pMSAppInfo.versionCode;
            this.versionName = pMSAppInfo.versionName;
            this.type = pMSAppInfo.type;
            this.pkgSize = pMSAppInfo.pkgSize;
            this.createTime = pMSAppInfo.createTime;
            updateLastLaunchTime(this.lastLaunchTime);
            updateLaunchCount(this.launchCount);
            setOrientation(pMSAppInfo.getOrientation());
            updateInstallSrc(pMSAppInfo.getInstallSrc());
        }
    }

    public void copyMainPkgInfo(e84 e84Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, e84Var) == null) || e84Var == null) {
            return;
        }
        this.appId = e84Var.g;
        this.versionCode = e84Var.i;
        this.versionName = e84Var.j;
        this.type = e84Var.o;
        this.pkgSize = e84Var.k;
    }

    public void copySubPkgInfo(f84 f84Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, f84Var) == null) || f84Var == null) {
            return;
        }
        this.appId = f84Var.o;
        this.versionCode = f84Var.i;
        this.versionName = f84Var.j;
        this.type = f84Var.q;
        this.pkgSize = f84Var.k;
    }

    public void countLaunch(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            if (0 >= j) {
                j = System.currentTimeMillis();
            }
            updateLastLaunchTime(j);
            this.launchCount++;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public int getInstallSrc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.installSrc : invokeV.intValue;
    }

    public long getLastLaunchTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.lastLaunchTime : invokeV.longValue;
    }

    public int getLaunchCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.launchCount : invokeV.intValue;
    }

    public int getOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.orientation : invokeV.intValue;
    }

    public boolean hasPendingErrCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.pendingErrCode != 0 : invokeV.booleanValue;
    }

    public void initMaxAgeInfo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (this.maxAge <= 0) {
                this.maxAge = DEFAULT_SWAN_APP_PKG_MAX_AGE;
            }
            this.createTime = System.currentTimeMillis();
        }
    }

    public boolean isForbiddenApp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.appStatus != 0 : invokeV.booleanValue;
    }

    public boolean isMaxAgeExpires() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (System.currentTimeMillis() - this.createTime) / 1000 > this.maxAge : invokeV.booleanValue;
    }

    public void setOrientation(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i) == null) || -1 >= i) {
            return;
        }
        this.orientation = i;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return "{appId=" + this.appId + ", appKey=" + this.appKey + ", appSign=" + this.appSign + ", versionCode=" + this.versionCode + ", versionName=" + this.versionName + ", description=" + this.description + ", appStatus=" + this.appStatus + ", statusDetail=" + this.statusDetail + ", statusDesc=" + this.statusDesc + ", resumeDate=" + this.resumeDate + ", iconUrl=" + this.iconUrl + ", appName=" + this.appName + ", serviceCategory=" + this.serviceCategory + ", subjectInfo=" + this.subjectInfo + ", type=" + this.type + ", pkgSize=" + this.pkgSize + ", pendingErrCode=" + this.pendingErrCode + ", appCategory=" + this.appCategory + ", orientation=" + this.orientation + ", maxAge=" + this.maxAge + ", createTime=" + this.createTime + ", webViewDomains=" + this.webViewDomains + ", webAction=" + this.webAction + ", domains=" + this.domains + ", bearInfo=" + this.bearInfo + ", serverExt=" + this.serverExt + ", payProtected=" + this.payProtected + ", customerService=" + this.customerService + ", globalNotice=" + this.globalNotice + ", globalPrivate=" + this.globalPrivate + ", paNumber=" + this.paNumber + ", pluginInfo=" + this.pluginInfo + ", brandsInfo=" + this.brandsInfo + ", lastLaunchTime=" + this.lastLaunchTime + ", launchCount=" + this.launchCount + ", installSrc=" + this.installSrc + ", quickAppKey=" + this.quickAppKey + ", webUrl=" + this.webUrl + ", webPermit=" + this.webPermit + ", csProtocolVersion=" + this.csProtocolVersion + ", userActionApis=" + this.userActionApis + "}";
        }
        return (String) invokeV.objValue;
    }

    public void updateInstallSrc(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048592, this, i) == null) && this.installSrc == 0 && i > 0) {
            this.installSrc = i;
        }
    }

    public void updateLastLaunchTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048593, this, j) == null) {
            this.lastLaunchTime = Math.max(j, this.lastLaunchTime);
        }
    }

    public void updateLaunchCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.launchCount = Math.max(i, this.launchCount);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048595, this, parcel, i) == null) {
            parcel.writeString(this.appId);
            parcel.writeString(this.appKey);
            parcel.writeLong(this.appSign);
            parcel.writeLong(this.versionCode);
            parcel.writeString(this.versionName);
            parcel.writeString(this.description);
            parcel.writeInt(this.appStatus);
            parcel.writeString(this.statusDetail);
            parcel.writeString(this.statusDesc);
            parcel.writeString(this.resumeDate);
            parcel.writeString(this.iconUrl);
            parcel.writeString(this.appName);
            parcel.writeString(this.serviceCategory);
            parcel.writeString(this.subjectInfo);
            parcel.writeInt(this.type);
            parcel.writeLong(this.pkgSize);
            parcel.writeInt(this.pendingErrCode);
            parcel.writeInt(this.appCategory);
            parcel.writeInt(getOrientation());
            parcel.writeLong(this.maxAge);
            parcel.writeLong(this.createTime);
            parcel.writeString(this.webViewDomains);
            parcel.writeString(this.webAction);
            parcel.writeString(this.domains);
            parcel.writeString(this.bearInfo);
            parcel.writeString(this.serverExt);
            parcel.writeInt(this.payProtected);
            parcel.writeInt(this.customerService);
            parcel.writeInt(this.globalNotice);
            parcel.writeInt(this.globalPrivate);
            parcel.writeString(this.paNumber);
            parcel.writeString(this.pluginInfo);
            parcel.writeString(this.brandsInfo);
            parcel.writeLong(this.lastLaunchTime);
            parcel.writeInt(this.launchCount);
            parcel.writeInt(this.installSrc);
            parcel.writeString(this.quickAppKey);
            parcel.writeString(this.webUrl);
            parcel.writeInt(this.webPermit);
            parcel.writeInt(this.csProtocolVersion);
            parcel.writeInt(this.rank);
            parcel.writeString(this.userActionApis);
        }
    }

    public PMSAppInfo(Parcel parcel) {
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
        this.orientation = -1;
        this.maxAge = DEFAULT_SWAN_APP_PKG_MAX_AGE;
        this.lastLaunchTime = 0L;
        this.launchCount = 0;
        this.installSrc = 0;
        this.webPermit = 0;
        this.appId = parcel.readString();
        this.appKey = parcel.readString();
        this.appSign = parcel.readLong();
        this.versionCode = parcel.readLong();
        this.versionName = parcel.readString();
        this.description = parcel.readString();
        this.appStatus = parcel.readInt();
        this.statusDetail = parcel.readString();
        this.statusDesc = parcel.readString();
        this.resumeDate = parcel.readString();
        this.iconUrl = parcel.readString();
        this.appName = parcel.readString();
        this.serviceCategory = parcel.readString();
        this.subjectInfo = parcel.readString();
        this.type = parcel.readInt();
        this.pkgSize = parcel.readLong();
        this.pendingErrCode = parcel.readInt();
        this.appCategory = parcel.readInt();
        setOrientation(parcel.readInt());
        this.maxAge = parcel.readLong();
        this.createTime = parcel.readLong();
        this.webViewDomains = parcel.readString();
        this.webAction = parcel.readString();
        this.domains = parcel.readString();
        this.bearInfo = parcel.readString();
        this.serverExt = parcel.readString();
        this.payProtected = parcel.readInt();
        this.customerService = parcel.readInt();
        this.globalNotice = parcel.readInt();
        this.globalPrivate = parcel.readInt();
        this.paNumber = parcel.readString();
        this.pluginInfo = parcel.readString();
        this.brandsInfo = parcel.readString();
        this.lastLaunchTime = parcel.readLong();
        this.launchCount = parcel.readInt();
        this.installSrc = parcel.readInt();
        this.quickAppKey = parcel.readString();
        this.webUrl = parcel.readString();
        this.webPermit = parcel.readInt();
        this.csProtocolVersion = parcel.readInt();
        this.rank = parcel.readInt();
        this.userActionApis = parcel.readString();
    }
}
