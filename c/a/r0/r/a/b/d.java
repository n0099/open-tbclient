package c.a.r0.r.a.b;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes6.dex */
public class d<D> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public b<D> f11866b;

    /* renamed from: c  reason: collision with root package name */
    public a<D> f11867c;

    /* renamed from: d  reason: collision with root package name */
    public Context f11868d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f11869e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f11870f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f11871g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f11872h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f11873i;

    /* loaded from: classes6.dex */
    public interface a<D> {
    }

    /* loaded from: classes6.dex */
    public interface b<D> {
    }

    public String a(D d2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, d2)) == null) {
            StringBuilder sb = new StringBuilder(64);
            c.a.r0.r.a.c.c.a(d2, sb);
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
            printWriter.println(this.f11866b);
            if (this.f11869e || this.f11872h || this.f11873i) {
                printWriter.print(str);
                printWriter.print("mStarted=");
                printWriter.print(this.f11869e);
                printWriter.print(" mContentChanged=");
                printWriter.print(this.f11872h);
                printWriter.print(" mProcessingChange=");
                printWriter.println(this.f11873i);
            }
            if (this.f11870f || this.f11871g) {
                printWriter.print(str);
                printWriter.print("mAbandoned=");
                printWriter.print(this.f11870f);
                printWriter.print(" mReset=");
                printWriter.println(this.f11871g);
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
            if (this.f11866b == null) {
                this.f11866b = bVar;
                this.a = i2;
                return;
            }
            throw new IllegalStateException("There is already a listener registered");
        }
    }

    public void g(a<D> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            if (this.f11867c == null) {
                this.f11867c = aVar;
                return;
            }
            throw new IllegalStateException("There is already a listener registered");
        }
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f11868d : (Context) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c();
            this.f11871g = true;
            this.f11869e = false;
            this.f11870f = false;
            this.f11872h = false;
            this.f11873i = false;
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f11869e = true;
            this.f11871g = false;
            this.f11870f = false;
            d();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f11869e = false;
            e();
        }
    }

    public void k(b<D> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            b<D> bVar2 = this.f11866b;
            if (bVar2 == null) {
                throw new IllegalStateException("No listener register");
            }
            if (bVar2 == bVar) {
                this.f11866b = null;
                return;
            }
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
    }

    public void l(a<D> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
            a<D> aVar2 = this.f11867c;
            if (aVar2 == null) {
                throw new IllegalStateException("No listener register");
            }
            if (aVar2 == aVar) {
                this.f11867c = null;
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
            c.a.r0.r.a.c.c.a(this, sb);
            sb.append(" id=");
            sb.append(this.a);
            sb.append("}");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
