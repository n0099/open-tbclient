package c.a.n0.a.h0.i;

import c.a.n0.a.v2.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<C0208a> f5727a;

    /* renamed from: c.a.n0.a.h0.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0208a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f5728a;

        /* renamed from: b  reason: collision with root package name */
        public String f5729b;

        /* renamed from: c  reason: collision with root package name */
        public String f5730c;

        public C0208a(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5728a = str;
            this.f5729b = str2;
            this.f5730c = str3;
        }

        public static C0208a a(String str, String str2, String str3) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, str, str2, str3)) == null) ? new C0208a(str, str2, str3) : (C0208a) invokeLLL.objValue;
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "1".equals(this.f5728a) : invokeV.booleanValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "1".equals(this.f5730c) : invokeV.booleanValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return "JSErrorModel{mType='" + this.f5728a + ExtendedMessageFormat.QUOTE + ", mContent='" + this.f5729b + ExtendedMessageFormat.QUOTE + ", mSource='" + this.f5730c + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
            }
            return (String) invokeV.objValue;
        }
    }

    public a() {
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
        this.f5727a = new ArrayList();
    }

    public synchronized boolean a(C0208a c0208a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, c0208a)) == null) {
            synchronized (this) {
                if (c0208a != null) {
                    return this.f5727a.add(c0208a);
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public synchronized String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                String g2 = k.g(System.currentTimeMillis(), "【HH:mm:ss】");
                if (d()) {
                    return String.format("\n%s jserror：共0个；", g2);
                }
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                for (C0208a c0208a : this.f5727a) {
                    if (c0208a.b()) {
                        i2++;
                        if (c0208a.c()) {
                            i4++;
                        } else {
                            i3++;
                        }
                    }
                }
                return String.format("\n%s jserror：共%d个，影响渲染%d个（框架%d个，开发者%d个）；", g2, Integer.valueOf(e()), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i3));
            }
        }
        return (String) invokeV.objValue;
    }

    public synchronized boolean c() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                z = false;
                Iterator<C0208a> it = this.f5727a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (it.next().b()) {
                        z = true;
                        break;
                    }
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public synchronized boolean d() {
        InterceptResult invokeV;
        boolean isEmpty;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                isEmpty = this.f5727a.isEmpty();
            }
            return isEmpty;
        }
        return invokeV.booleanValue;
    }

    public synchronized int e() {
        InterceptResult invokeV;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                size = this.f5727a.size();
            }
            return size;
        }
        return invokeV.intValue;
    }
}
