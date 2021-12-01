package c.a.p0.r.a.b;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes5.dex */
public class d<D> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public b<D> f10957b;

    /* renamed from: c  reason: collision with root package name */
    public a<D> f10958c;

    /* renamed from: d  reason: collision with root package name */
    public Context f10959d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f10960e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f10961f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f10962g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f10963h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f10964i;

    /* loaded from: classes5.dex */
    public interface a<D> {
    }

    /* loaded from: classes5.dex */
    public interface b<D> {
    }

    public String a(D d2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, d2)) == null) {
            StringBuilder sb = new StringBuilder(64);
            c.a.p0.r.a.c.c.a(d2, sb);
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
            printWriter.print(this.a);
            printWriter.print(" mListener=");
            printWriter.println(this.f10957b);
            if (this.f10960e || this.f10963h || this.f10964i) {
                printWriter.print(str);
                printWriter.print("mStarted=");
                printWriter.print(this.f10960e);
                printWriter.print(" mContentChanged=");
                printWriter.print(this.f10963h);
                printWriter.print(" mProcessingChange=");
                printWriter.println(this.f10964i);
            }
            if (this.f10961f || this.f10962g) {
                printWriter.print(str);
                printWriter.print("mAbandoned=");
                printWriter.print(this.f10961f);
                printWriter.print(" mReset=");
                printWriter.println(this.f10962g);
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
            if (this.f10957b == null) {
                this.f10957b = bVar;
                this.a = i2;
                return;
            }
            throw new IllegalStateException("There is already a listener registered");
        }
    }

    public void g(a<D> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            if (this.f10958c == null) {
                this.f10958c = aVar;
                return;
            }
            throw new IllegalStateException("There is already a listener registered");
        }
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f10959d : (Context) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c();
            this.f10962g = true;
            this.f10960e = false;
            this.f10961f = false;
            this.f10963h = false;
            this.f10964i = false;
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f10960e = true;
            this.f10962g = false;
            this.f10961f = false;
            d();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f10960e = false;
            e();
        }
    }

    public void k(b<D> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            b<D> bVar2 = this.f10957b;
            if (bVar2 == null) {
                throw new IllegalStateException("No listener register");
            }
            if (bVar2 == bVar) {
                this.f10957b = null;
                return;
            }
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
    }

    public void l(a<D> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
            a<D> aVar2 = this.f10958c;
            if (aVar2 == null) {
                throw new IllegalStateException("No listener register");
            }
            if (aVar2 == aVar) {
                this.f10958c = null;
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
            c.a.p0.r.a.c.c.a(this, sb);
            sb.append(" id=");
            sb.append(this.a);
            sb.append("}");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
