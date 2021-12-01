package c.a.r0.p3.b;

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
/* loaded from: classes6.dex */
public class f implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final BaseFragment a;

    /* renamed from: b  reason: collision with root package name */
    public final BaseFragmentActivity f21299b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ViewGroup f21300c;

    /* renamed from: d  reason: collision with root package name */
    public int f21301d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f21302e;

    /* renamed from: f  reason: collision with root package name */
    public int f21303f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f21304g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f21305h;

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
        this.f21301d = -1;
        this.f21302e = true;
        this.f21303f = 0;
        this.f21304g = false;
        this.f21305h = false;
        this.a = baseFragment;
        this.f21300c = viewGroup;
        this.f21301d = i2;
        this.f21299b = baseFragment.getBaseFragmentActivity();
    }

    @Override // c.a.r0.p3.b.b
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f21305h : invokeV.booleanValue;
    }

    @Override // c.a.r0.p3.b.b
    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f21302e = z;
        }
    }

    @Override // c.a.r0.p3.b.b
    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f21303f = i2;
        }
    }

    @Override // c.a.r0.p3.b.b
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f21305h = true;
        }
    }

    @Override // c.a.r0.p3.b.b
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f21302e : invokeV.booleanValue;
    }

    @Override // c.a.r0.p3.b.b
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f21304g = true;
        }
    }

    @Override // c.a.r0.p3.b.b
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f21304g : invokeV.booleanValue;
    }

    @Override // c.a.r0.p3.b.b
    @NonNull
    public BaseFragmentActivity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f21299b : (BaseFragmentActivity) invokeV.objValue;
    }

    @Override // c.a.r0.p3.b.b
    public int getAdSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f21303f : invokeV.intValue;
    }

    @Override // c.a.r0.p3.b.b
    @NonNull
    public ViewGroup getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f21300c : (ViewGroup) invokeV.objValue;
    }

    @Override // c.a.r0.p3.b.b
    public BdUniqueId getUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.a.getUniqueId() : (BdUniqueId) invokeV.objValue;
    }

    @Override // c.a.r0.p3.b.b
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f21301d : invokeV.intValue;
    }

    @Override // c.a.r0.p3.b.b
    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? d.a(this.f21299b.getIntent()) : invokeV.booleanValue;
    }
}
