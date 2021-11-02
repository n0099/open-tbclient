package b.a.r0.g0.b;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.coreExtra.data.TbMultiMediaData;
import com.baidu.tbadk.data.TbMusicData;
import com.baidu.tieba.core.edit.TbMediaTrackConfig;
import com.baidu.tieba.external.filter.TbFilterValue;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbMultiMediaData f16667a;

    /* renamed from: b  reason: collision with root package name */
    public TbFilterValue f16668b;

    /* renamed from: c  reason: collision with root package name */
    public TbMediaTrackConfig f16669c;

    /* renamed from: d  reason: collision with root package name */
    public float f16670d;

    /* renamed from: e  reason: collision with root package name */
    public TbMusicData f16671e;

    /* renamed from: f  reason: collision with root package name */
    public int f16672f;

    /* renamed from: g  reason: collision with root package name */
    public int f16673g;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public TbFilterValue a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f16668b : (TbFilterValue) invokeV.objValue;
    }

    public TbMediaTrackConfig b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f16669c : (TbMediaTrackConfig) invokeV.objValue;
    }

    public TbMultiMediaData c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f16667a : (TbMultiMediaData) invokeV.objValue;
    }

    public TbMusicData d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f16671e : (TbMusicData) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f16673g : invokeV.intValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f16672f : invokeV.intValue;
    }

    public float g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f16670d : invokeV.floatValue;
    }

    public void h(TbFilterValue tbFilterValue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, tbFilterValue) == null) {
            this.f16668b = tbFilterValue;
        }
    }

    public void i(TbMediaTrackConfig tbMediaTrackConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tbMediaTrackConfig) == null) {
            this.f16669c = tbMediaTrackConfig;
        }
    }

    public void j(TbMultiMediaData tbMultiMediaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, tbMultiMediaData) == null) {
            this.f16667a = tbMultiMediaData;
        }
    }

    public void k(TbMusicData tbMusicData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, tbMusicData) == null) {
            this.f16671e = tbMusicData;
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f16673g = i2;
        }
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f16672f = i2;
        }
    }

    public void n(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048589, this, f2) == null) {
            this.f16670d = f2;
        }
    }
}
