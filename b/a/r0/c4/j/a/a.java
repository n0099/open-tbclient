package b.a.r0.c4.j.a;

import android.graphics.SurfaceTexture;
import b.a.x0.p.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public abstract class a implements b.InterfaceC1429b {
    public static /* synthetic */ Interceptable $ic;
    public static boolean o;
    public static boolean p;
    public static String q;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f15419a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f15420b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f15421c;

    /* renamed from: d  reason: collision with root package name */
    public int f15422d;

    /* renamed from: e  reason: collision with root package name */
    public int f15423e;

    /* renamed from: f  reason: collision with root package name */
    public int f15424f;

    /* renamed from: g  reason: collision with root package name */
    public int f15425g;

    /* renamed from: h  reason: collision with root package name */
    public int f15426h;

    /* renamed from: i  reason: collision with root package name */
    public int f15427i;
    public int j;
    public int k;
    public SurfaceTexture l;
    public volatile boolean m;
    public volatile boolean n;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(976986177, "Lb/a/r0/c4/j/a/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(976986177, "Lb/a/r0/c4/j/a/a;");
        }
    }

    public a() {
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
        this.j = -1;
        this.m = false;
        this.n = false;
    }

    @Override // b.a.x0.p.b.InterfaceC1429b
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.m : invokeV.booleanValue;
    }

    @Override // b.a.x0.p.b.InterfaceC1429b
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.n = z;
        }
    }

    @Override // b.a.x0.p.b.InterfaceC1429b
    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.m = z;
        }
    }

    @Override // b.a.x0.p.b.InterfaceC1429b
    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.n : invokeV.booleanValue;
    }

    @Override // b.a.x0.p.b.InterfaceC1429b
    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f15427i : invokeV.intValue;
    }

    @Override // b.a.x0.p.b.InterfaceC1429b
    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f15426h : invokeV.intValue;
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? p : invokeV.booleanValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? o : invokeV.booleanValue;
    }
}
