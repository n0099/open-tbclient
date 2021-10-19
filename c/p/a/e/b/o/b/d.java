package c.p.a.e.b.o.b;

import androidx.core.view.InputDeviceCompat;
import c.p.a.e.b.o.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
/* loaded from: classes4.dex */
public class d implements k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Object f35429a;

    /* renamed from: b  reason: collision with root package name */
    public final List<com.ss.android.socialbase.downloader.model.c> f35430b;

    /* renamed from: c  reason: collision with root package name */
    public k f35431c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f35432d;

    /* renamed from: e  reason: collision with root package name */
    public long f35433e;

    /* renamed from: f  reason: collision with root package name */
    public InputStream f35434f;

    @Override // c.p.a.e.b.o.k
    public InputStream a() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            InputStream inputStream = this.f35434f;
            if (inputStream != null) {
                return inputStream;
            }
            return null;
        }
        return (InputStream) invokeV.objValue;
    }

    @Override // c.p.a.e.b.o.i
    public int b() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            k kVar = this.f35431c;
            if (kVar != null) {
                return kVar.b();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? i2 >= 200 && i2 < 300 : invokeI.booleanValue;
    }

    @Override // c.p.a.e.b.o.i
    public void c() {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (kVar = this.f35431c) == null) {
            return;
        }
        kVar.c();
    }

    @Override // c.p.a.e.b.o.k
    public void d() {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (kVar = this.f35431c) == null) {
            return;
        }
        kVar.d();
    }

    public void e() throws InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            synchronized (this.f35429a) {
                if (this.f35432d && this.f35431c == null) {
                    this.f35429a.wait();
                }
            }
        }
    }

    public List<com.ss.android.socialbase.downloader.model.c> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f35430b : (List) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            try {
                if (this.f35431c != null) {
                    return b(this.f35431c.b());
                }
                return false;
            } catch (IOException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? System.currentTimeMillis() - this.f35433e < b.f35415c : invokeV.booleanValue;
    }

    @Override // c.p.a.e.b.o.i
    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            k kVar = this.f35431c;
            if (kVar != null) {
                return kVar.a(str);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }
}
