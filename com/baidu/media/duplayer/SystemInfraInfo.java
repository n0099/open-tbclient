package com.baidu.media.duplayer;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class SystemInfraInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f42396a;
    @Keep
    public long mBuildDateUTC;
    @Keep
    public long mMaxCpuFreq;
    @Keep
    public long mNumProcessors;
    @Keep
    public long mPmSizeAvailable;
    @Keep
    public long mVmMaxSlice;
    @Keep
    public long mVmPeak;
    @Keep
    public long mVmSize;
    @Keep
    public long mVmSizeAvailable;
    @Keep
    public long mVmSizeInSmaps;

    public SystemInfraInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mVmSize = 0L;
        this.mVmPeak = 0L;
        this.mVmSizeInSmaps = 0L;
        this.mVmSizeAvailable = 0L;
        this.mVmMaxSlice = 0L;
        this.mNumProcessors = 0L;
        this.mMaxCpuFreq = 0L;
        this.mBuildDateUTC = 0L;
        this.mPmSizeAvailable = 0L;
        this.f42396a = false;
        this.mVmSize = -1L;
        this.mVmPeak = -1L;
        this.mVmSizeInSmaps = -1L;
        this.mVmSizeAvailable = -1L;
        this.mVmMaxSlice = -1L;
        this.mNumProcessors = -1L;
        this.mMaxCpuFreq = -1L;
        this.mBuildDateUTC = -1L;
        this.mPmSizeAvailable = -1L;
    }

    private native void nativeGetConstInfo();

    private native void nativeGetCurrentInfoVm();

    private native void nativeGetCurrentInfoVmInSmaps();

    private native void nativeGetCurrentMemInfo();

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            nativeGetCurrentInfoVm();
            CyberLog.i("", "SystemInfraInfo mVmSize:" + this.mVmSize + " mVmPeak:" + this.mVmPeak);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            nativeGetCurrentMemInfo();
            CyberLog.i("", "SystemInfraInfo mPmSizeAvailable:" + this.mPmSizeAvailable);
        }
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mVmSize : invokeV.longValue;
    }

    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mVmPeak : invokeV.longValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            i();
            return this.mNumProcessors;
        }
        return invokeV.longValue;
    }

    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            i();
            return this.mMaxCpuFreq;
        }
        return invokeV.longValue;
    }

    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            i();
            return this.mBuildDateUTC;
        }
        return invokeV.longValue;
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mPmSizeAvailable : invokeV.longValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f42396a) {
            return;
        }
        nativeGetConstInfo();
        CyberLog.i("", "SystemInfraInfo mNumProcessors:" + this.mNumProcessors + " \nmMaxCpuFreq:" + this.mMaxCpuFreq + " \nmBuildDateUTC" + this.mBuildDateUTC);
        this.f42396a = true;
    }
}
