package com.baidu.swan.apps.scheme.actions.forbidden;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.lb3;
import com.repackage.pk2;
/* loaded from: classes2.dex */
public class ForbiddenInfo implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<ForbiddenInfo> CREATOR;
    public static final int ENABLE_SLIDING_DEFAULT_FLAG = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public String appId;
    public String appKey;
    public String appTitle;
    public int enableSlidingFlag;
    public lb3 errCode;
    public String forbiddenDetail;
    public String forbiddenInformation;
    public String forbiddenReason;
    public String launchPath;
    public String launchSource;

    /* loaded from: classes2.dex */
    public static class a implements Parcelable.Creator<ForbiddenInfo> {
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
        public ForbiddenInfo createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) ? new ForbiddenInfo(parcel, null) : (ForbiddenInfo) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ForbiddenInfo[] newArray(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? new ForbiddenInfo[i] : (ForbiddenInfo[]) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1569076839, "Lcom/baidu/swan/apps/scheme/actions/forbidden/ForbiddenInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1569076839, "Lcom/baidu/swan/apps/scheme/actions/forbidden/ForbiddenInfo;");
                return;
            }
        }
        CREATOR = new a();
    }

    public /* synthetic */ ForbiddenInfo(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void convertToForbiddenModel(pk2 pk2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, this, pk2Var) == null) || pk2Var == null) {
            return;
        }
        this.appId = pk2Var.H();
        this.appKey = pk2Var.I();
        this.appTitle = pk2Var.K();
        this.launchPath = pk2Var.e0();
        this.launchSource = pk2Var.T();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean enableSliding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.enableSlidingFlag == 0 : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "ForbiddenInfo{appId='" + this.appId + "', appKey='" + this.appKey + "', forbiddenReason='" + this.forbiddenReason + "', forbiddenDetail='" + this.forbiddenDetail + "', appTitle='" + this.appTitle + "', launchPath='" + this.launchPath + "', launchSource='" + this.launchSource + "', enableSlidingFlag='" + enableSliding() + "'}";
        }
        return (String) invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, parcel, i) == null) {
            parcel.writeString(this.appId);
            parcel.writeString(this.appKey);
            parcel.writeString(this.forbiddenReason);
            parcel.writeString(this.forbiddenDetail);
            parcel.writeString(this.appTitle);
            parcel.writeString(this.launchPath);
            parcel.writeString(this.launchSource);
            parcel.writeInt(this.enableSlidingFlag);
        }
    }

    public ForbiddenInfo() {
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
        this.enableSlidingFlag = 0;
    }

    public ForbiddenInfo(pk2 pk2Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pk2Var, str, str2};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.enableSlidingFlag = 0;
        convertToForbiddenModel(pk2Var);
        this.forbiddenReason = str;
        this.forbiddenDetail = str2;
    }

    public ForbiddenInfo(Parcel parcel) {
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
        this.enableSlidingFlag = 0;
        this.appId = parcel.readString();
        this.appKey = parcel.readString();
        this.forbiddenReason = parcel.readString();
        this.forbiddenDetail = parcel.readString();
        this.appTitle = parcel.readString();
        this.launchPath = parcel.readString();
        this.launchSource = parcel.readString();
        this.enableSlidingFlag = parcel.readInt();
    }
}
