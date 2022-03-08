package com.baidu.searchbox.logsystem.logsys;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class LogExtra implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<LogExtra> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public String mCrashThreadName;
    public String mCrashThreadPriority;
    public String mCrashTime;
    public String mForeground;
    public String mHeapMem;
    public String mJSONAttach;
    public String mLaunchTime;
    public String mPSS;
    public String mPage;
    public String mProcessLifeTime;
    public int mSysLowMem;
    public String mSysMem;
    public String mTraceID;
    public String mVSSRSS;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-322272385, "Lcom/baidu/searchbox/logsystem/logsys/LogExtra;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-322272385, "Lcom/baidu/searchbox/logsystem/logsys/LogExtra;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<LogExtra>() { // from class: com.baidu.searchbox.logsystem.logsys.LogExtra.1
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
            public LogExtra createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new LogExtra(parcel) : (LogExtra) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public LogExtra[] newArray(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                    if (i2 <= 0) {
                        return null;
                    }
                    return new LogExtra[i2];
                }
                return (LogExtra[]) invokeI.objValue;
            }
        };
    }

    public LogExtra() {
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
        this.mPage = null;
        this.mCrashTime = null;
        this.mLaunchTime = null;
        this.mProcessLifeTime = null;
        this.mCrashThreadName = null;
        this.mCrashThreadPriority = null;
        this.mForeground = null;
        this.mTraceID = null;
        this.mJSONAttach = null;
        this.mHeapMem = null;
        this.mVSSRSS = null;
        this.mPSS = null;
        this.mSysMem = null;
        this.mSysLowMem = 1;
    }

    public static void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
        }
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

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, i2) == null) {
            parcel.writeString(this.mPage);
            parcel.writeString(this.mCrashTime);
            parcel.writeString(this.mLaunchTime);
            parcel.writeString(this.mProcessLifeTime);
            parcel.writeString(this.mCrashThreadName);
            parcel.writeString(this.mCrashThreadPriority);
            parcel.writeString(this.mForeground);
            parcel.writeString(this.mTraceID);
            parcel.writeString(this.mJSONAttach);
            parcel.writeString(this.mHeapMem);
            parcel.writeString(this.mVSSRSS);
            parcel.writeString(this.mPSS);
            parcel.writeString(this.mSysMem);
            parcel.writeInt(this.mSysLowMem);
        }
    }

    public LogExtra(Parcel parcel) {
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
        this.mPage = null;
        this.mCrashTime = null;
        this.mLaunchTime = null;
        this.mProcessLifeTime = null;
        this.mCrashThreadName = null;
        this.mCrashThreadPriority = null;
        this.mForeground = null;
        this.mTraceID = null;
        this.mJSONAttach = null;
        this.mHeapMem = null;
        this.mVSSRSS = null;
        this.mPSS = null;
        this.mSysMem = null;
        this.mSysLowMem = 1;
        this.mPage = parcel.readString();
        this.mCrashTime = parcel.readString();
        this.mLaunchTime = parcel.readString();
        this.mProcessLifeTime = parcel.readString();
        this.mCrashThreadName = parcel.readString();
        this.mCrashThreadPriority = parcel.readString();
        this.mForeground = parcel.readString();
        this.mTraceID = parcel.readString();
        this.mJSONAttach = parcel.readString();
        this.mHeapMem = parcel.readString();
        this.mVSSRSS = parcel.readString();
        this.mPSS = parcel.readString();
        this.mSysMem = parcel.readString();
        this.mSysLowMem = parcel.readInt();
    }
}
