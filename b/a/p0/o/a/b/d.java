package b.a.p0.o.a.b;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes4.dex */
public class d<D> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f11346a;

    /* renamed from: b  reason: collision with root package name */
    public b<D> f11347b;

    /* renamed from: c  reason: collision with root package name */
    public a<D> f11348c;

    /* renamed from: d  reason: collision with root package name */
    public Context f11349d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f11350e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f11351f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f11352g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f11353h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f11354i;

    /* loaded from: classes4.dex */
    public interface a<D> {
    }

    /* loaded from: classes4.dex */
    public interface b<D> {
    }

    public String a(D d2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, d2)) == null) {
            StringBuilder sb = new StringBuilder(64);
            b.a.p0.o.a.c.c.a(d2, sb);
            sb.append("}");
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public void b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, fileDescriptor, printWriter, strArr) == null) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f11346a);
            printWriter.print(" mListener=");
            printWriter.println(this.f11347b);
            if (this.f11350e || this.f11353h || this.f11354i) {
                printWriter.print(str);
                printWriter.print("mStarted=");
                printWriter.print(this.f11350e);
                printWriter.print(" mContentChanged=");
                printWriter.print(this.f11353h);
                printWriter.print(" mProcessingChange=");
                printWriter.println(this.f11354i);
            }
            if (this.f11351f || this.f11352g) {
                printWriter.print(str);
                printWriter.print("mAbandoned=");
                printWriter.print(this.f11351f);
                printWriter.print(" mReset=");
                printWriter.println(this.f11352g);
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public void f(int i2, b<D> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, bVar) == null) {
            if (this.f11347b == null) {
                this.f11347b = bVar;
                this.f11346a = i2;
                return;
            }
            throw new IllegalStateException("There is already a listener registered");
        }
    }

    public void g(a<D> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            if (this.f11348c == null) {
                this.f11348c = aVar;
                return;
            }
            throw new IllegalStateException("There is already a listener registered");
        }
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f11349d : (Context) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c();
            this.f11352g = true;
            this.f11350e = false;
            this.f11351f = false;
            this.f11353h = false;
            this.f11354i = false;
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f11350e = true;
            this.f11352g = false;
            this.f11351f = false;
            d();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f11350e = false;
            e();
        }
    }

    public void k(b<D> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            b<D> bVar2 = this.f11347b;
            if (bVar2 == null) {
                throw new IllegalStateException("No listener register");
            }
            if (bVar2 == bVar) {
                this.f11347b = null;
                return;
            }
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
    }

    public void l(a<D> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
            a<D> aVar2 = this.f11348c;
            if (aVar2 == null) {
                throw new IllegalStateException("No listener register");
            }
            if (aVar2 == aVar) {
                this.f11348c = null;
                return;
            }
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            StringBuilder sb = new StringBuilder(64);
            b.a.p0.o.a.c.c.a(this, sb);
            sb.append(" id=");
            sb.append(this.f11346a);
            sb.append("}");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
