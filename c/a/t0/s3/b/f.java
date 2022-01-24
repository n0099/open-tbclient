package c.a.t0.s3.b;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class f implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final BaseFragmentActivity a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final ViewGroup f22170b;

    /* renamed from: c  reason: collision with root package name */
    public int f22171c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f22172d;

    /* renamed from: e  reason: collision with root package name */
    public int f22173e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f22174f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f22175g;

    /* renamed from: h  reason: collision with root package name */
    public final long f22176h;

    public f(@NonNull BaseFragmentActivity baseFragmentActivity, @NonNull ViewGroup viewGroup, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22171c = -1;
        this.f22172d = true;
        this.f22173e = 0;
        this.f22174f = false;
        this.f22175g = false;
        this.f22170b = viewGroup;
        this.f22171c = i2;
        this.f22176h = j2;
        this.a = baseFragmentActivity;
    }

    @Override // c.a.t0.s3.b.b
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f22175g : invokeV.booleanValue;
    }

    @Override // c.a.t0.s3.b.b
    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f22172d = z;
        }
    }

    @Override // c.a.t0.s3.b.b
    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f22173e = i2;
        }
    }

    @Override // c.a.t0.s3.b.b
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f22175g = true;
        }
    }

    @Override // c.a.t0.s3.b.b
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f22172d : invokeV.booleanValue;
    }

    @Override // c.a.t0.s3.b.b
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f22174f = true;
        }
    }

    @Override // c.a.t0.s3.b.b
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f22174f : invokeV.booleanValue;
    }

    @Override // c.a.t0.s3.b.b
    @NonNull
    public BaseFragmentActivity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a : (BaseFragmentActivity) invokeV.objValue;
    }

    @Override // c.a.t0.s3.b.b
    public int getAdSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f22173e : invokeV.intValue;
    }

    @Override // c.a.t0.s3.b.b
    @NonNull
    public ViewGroup getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f22170b : (ViewGroup) invokeV.objValue;
    }

    @Override // c.a.t0.s3.b.b
    public BdUniqueId getUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.a.getUniqueId() : (BdUniqueId) invokeV.objValue;
    }

    @Override // c.a.t0.s3.b.b
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f22171c : invokeV.intValue;
    }

    @Override // c.a.t0.s3.b.b
    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? d.a(this.a.getIntent()) : invokeV.booleanValue;
    }

    @Override // c.a.t0.s3.b.b
    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f22176h : invokeV.longValue;
    }
}
