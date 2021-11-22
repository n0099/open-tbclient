package b.a.r0.i3.b;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class f implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final BaseFragment f19447a;

    /* renamed from: b  reason: collision with root package name */
    public final BaseFragmentActivity f19448b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ViewGroup f19449c;

    /* renamed from: d  reason: collision with root package name */
    public int f19450d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f19451e;

    /* renamed from: f  reason: collision with root package name */
    public int f19452f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f19453g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f19454h;

    public f(@NonNull BaseFragment baseFragment, @NonNull ViewGroup viewGroup, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, viewGroup, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19450d = -1;
        this.f19451e = true;
        this.f19452f = 0;
        this.f19453g = false;
        this.f19454h = false;
        this.f19447a = baseFragment;
        this.f19449c = viewGroup;
        this.f19450d = i2;
        this.f19448b = baseFragment.getBaseFragmentActivity();
    }

    @Override // b.a.r0.i3.b.c
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19454h : invokeV.booleanValue;
    }

    @Override // b.a.r0.i3.b.c
    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f19451e = z;
        }
    }

    @Override // b.a.r0.i3.b.c
    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f19452f = i2;
        }
    }

    @Override // b.a.r0.i3.b.c
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f19454h = true;
        }
    }

    @Override // b.a.r0.i3.b.c
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f19451e : invokeV.booleanValue;
    }

    @Override // b.a.r0.i3.b.c
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f19453g = true;
        }
    }

    @Override // b.a.r0.i3.b.c
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f19453g : invokeV.booleanValue;
    }

    @Override // b.a.r0.i3.b.c
    @NonNull
    public BaseFragmentActivity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f19448b : (BaseFragmentActivity) invokeV.objValue;
    }

    @Override // b.a.r0.i3.b.c
    public int getAdSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f19452f : invokeV.intValue;
    }

    @Override // b.a.r0.i3.b.c
    @NonNull
    public ViewGroup getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f19449c : (ViewGroup) invokeV.objValue;
    }

    @Override // b.a.r0.i3.b.c
    public BdUniqueId getUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f19447a.getUniqueId() : (BdUniqueId) invokeV.objValue;
    }

    @Override // b.a.r0.i3.b.c
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f19450d : invokeV.intValue;
    }

    @Override // b.a.r0.i3.b.c
    public boolean isFromHotSplash() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.f19447a.getActivity() instanceof b) {
                return ((b) this.f19447a.getActivity()).isFromHotSplash();
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
