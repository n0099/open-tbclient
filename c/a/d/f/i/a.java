package c.a.d.f.i;

import android.location.Address;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static a n;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f1949b;

    /* renamed from: c  reason: collision with root package name */
    public long f1950c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1951d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1952e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1953f;

    /* renamed from: g  reason: collision with root package name */
    public int f1954g;

    /* renamed from: h  reason: collision with root package name */
    public Address f1955h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<SoftReference<c>> f1956i;

    /* renamed from: j  reason: collision with root package name */
    public ArrayList<c.a.d.f.i.b> f1957j;
    public Handler k;
    @NonNull
    public e l;
    public d m;

    /* renamed from: c.a.d.f.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0046a implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0046a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.d.f.i.a.d
        public void a(int i2, String str, Address address, long j2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, address, Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
                a aVar = this.a;
                aVar.f1949b = j2;
                aVar.f1955h = address;
                this.a.f1951d = z;
                this.a.f1954g = i2;
                this.a.u();
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 == 4 && StringUtils.isNull(str)) {
                                str = BdBaseApplication.getInst().getResources().getString(R.string.location_out_time);
                            }
                        } else if (StringUtils.isNull(str)) {
                            str = BdBaseApplication.getInst().getResources().getString(R.string.location_all_offline);
                        }
                    } else if (StringUtils.isNull(str)) {
                        str = BdBaseApplication.getInst().getResources().getString(R.string.location_net_offline);
                    }
                } else if (StringUtils.isNull(str)) {
                    str = BdBaseApplication.getInst().getResources().getString(R.string.location_gps_offline);
                }
                this.a.i(i2, str, address);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f1958e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1958e = aVar;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what != 0) {
                    return false;
                }
                this.f1958e.u();
                int i2 = this.f1958e.f1954g;
                String str = "";
                if (i2 == 1) {
                    str = BdBaseApplication.getInst().getResources().getString(R.string.location_gps_offline);
                } else if (i2 == 2) {
                    str = BdBaseApplication.getInst().getResources().getString(R.string.location_net_offline);
                } else if (i2 == 3) {
                    str = BdBaseApplication.getInst().getResources().getString(R.string.location_all_offline);
                } else if (i2 == 4) {
                    str = BdBaseApplication.getInst().getResources().getString(R.string.location_out_time);
                } else if (i2 == 6) {
                    str = BdBaseApplication.getInst().getResources().getString(R.string.location_out_time);
                }
                a aVar = this.f1958e;
                aVar.i(aVar.f1954g, str, null);
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void onLocationGeted(int i2, String str, Address address);
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(int i2, String str, Address address, long j2, boolean z);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-502697766, "Lc/a/d/f/i/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-502697766, "Lc/a/d/f/i/a;");
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
        this.a = 10000L;
        this.f1949b = 0L;
        this.f1950c = 300000L;
        this.f1951d = false;
        this.f1952e = false;
        this.f1953f = false;
        this.f1954g = 4;
        this.f1955h = null;
        this.f1956i = new ArrayList<>();
        this.f1957j = new ArrayList<>();
        this.k = null;
        this.l = new e(null);
        this.m = new C0046a(this);
    }

    public static a n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (n == null) {
                synchronized (a.class) {
                    if (n == null) {
                        n = new a();
                    }
                }
            }
            return n;
        }
        return (a) invokeV.objValue;
    }

    public void g(@NonNull Class<?> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cls) == null) {
            this.l.a(cls.getName());
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l.b() : invokeV.booleanValue;
    }

    public final void i(int i2, String str, Address address) {
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, str, address) == null) {
            Handler handler = this.k;
            if (handler != null && handler.hasMessages(0)) {
                this.k.removeMessages(0);
            }
            ArrayList<SoftReference<c>> arrayList = this.f1956i;
            if (arrayList != null) {
                synchronized (arrayList) {
                    for (int i3 = 0; i3 < this.f1956i.size(); i3++) {
                        SoftReference<c> softReference = this.f1956i.get(i3);
                        if (softReference != null && (cVar = softReference.get()) != null) {
                            cVar.onLocationGeted(i2, str, address);
                        }
                    }
                    this.f1956i.clear();
                }
            }
        }
    }

    public Address j(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) ? l(z, false) : (Address) invokeZ.objValue;
    }

    public Address k(boolean z, c cVar) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZL = interceptable.invokeZL(1048580, this, z, cVar)) == null) ? m(z, false, cVar) : (Address) invokeZL.objValue;
    }

    public Address l(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (System.currentTimeMillis() - this.f1949b > this.f1950c) {
                this.f1955h = null;
            }
            if (this.f1955h != null && !z && ((z2 && this.f1951d) || !z2)) {
                return this.f1955h;
            }
            this.f1955h = null;
            boolean z3 = this.f1953f;
            if (!z3) {
                t(z2);
                return null;
            }
            if (z3 && z2 && !this.f1952e) {
                u();
                t(z2);
            }
            return null;
        }
        return (Address) invokeCommon.objValue;
    }

    public Address m(boolean z, boolean z2, c cVar) {
        InterceptResult invokeCommon;
        boolean z3;
        c cVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), cVar})) == null) {
            if (System.currentTimeMillis() - this.f1949b > this.f1950c) {
                this.f1955h = null;
            }
            if (this.f1955h != null && !z && ((z2 && this.f1951d) || !z2)) {
                if (cVar != null) {
                    cVar.onLocationGeted(0, "", this.f1955h);
                }
                return this.f1955h;
            }
            if (cVar != null) {
                synchronized (this.f1956i) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= this.f1956i.size()) {
                            z3 = false;
                            break;
                        }
                        SoftReference<c> softReference = this.f1956i.get(i2);
                        if (softReference != null && (cVar2 = softReference.get()) != null && cVar2.equals(cVar)) {
                            z3 = true;
                            break;
                        }
                        i2++;
                    }
                    if (!z3) {
                        if (this.f1956i.size() >= 100) {
                            this.f1956i.remove(0);
                        }
                        this.f1956i.add(new SoftReference<>(cVar));
                    }
                }
                boolean z4 = this.f1953f;
                if (!z4) {
                    t(z2);
                    return null;
                } else if (z4 && z2 && !this.f1952e) {
                    u();
                    t(z2);
                    return null;
                }
            }
            return null;
        }
        return (Address) invokeCommon.objValue;
    }

    public long o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a : invokeV.longValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.k = new Handler(Looper.getMainLooper(), new b(this));
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            p();
        }
    }

    public void r(c.a.d.f.i.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) || bVar == null) {
            return;
        }
        synchronized (this.f1957j) {
            if (!this.f1957j.contains(bVar)) {
                bVar.b(this.m);
                this.f1957j.add(bVar);
            }
        }
    }

    public void s(c cVar) {
        c cVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) {
            synchronized (this.f1956i) {
                int i2 = 0;
                while (true) {
                    if (i2 < this.f1956i.size()) {
                        SoftReference<c> softReference = this.f1956i.get(i2);
                        if (softReference != null && (cVar2 = softReference.get()) != null && cVar2.equals(cVar)) {
                            this.f1956i.remove(softReference);
                            break;
                        }
                        i2++;
                    } else {
                        break;
                    }
                }
            }
        }
    }

    public final void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            Handler handler = this.k;
            if (handler != null && handler.hasMessages(0)) {
                this.k.removeMessages(0);
            }
            this.f1954g = 4;
            this.f1952e = z;
            this.f1953f = true;
            ArrayList<c.a.d.f.i.b> arrayList = this.f1957j;
            if (arrayList != null && !arrayList.isEmpty()) {
                if (!this.l.b()) {
                    this.f1954g = 7;
                    Handler handler2 = this.k;
                    if (handler2 != null) {
                        handler2.sendMessage(handler2.obtainMessage(0));
                        return;
                    }
                    return;
                }
                Iterator<c.a.d.f.i.b> it = this.f1957j.iterator();
                while (it.hasNext()) {
                    c.a.d.f.i.b next = it.next();
                    if (next != null) {
                        try {
                            next.a(z);
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                }
                Handler handler3 = this.k;
                if (handler3 != null) {
                    handler3.sendMessageDelayed(handler3.obtainMessage(0), this.a);
                    return;
                }
                return;
            }
            this.f1954g = 6;
            Handler handler4 = this.k;
            if (handler4 != null) {
                handler4.sendMessage(handler4.obtainMessage(0));
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            Handler handler = this.k;
            if (handler != null && handler.hasMessages(0)) {
                this.k.removeMessages(0);
            }
            this.f1953f = false;
            Iterator<c.a.d.f.i.b> it = this.f1957j.iterator();
            while (it.hasNext()) {
                c.a.d.f.i.b next = it.next();
                if (next != null) {
                    try {
                        next.c();
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                }
            }
        }
    }

    public void v(c.a.d.f.i.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, bVar) == null) || bVar == null) {
            return;
        }
        synchronized (this.f1957j) {
            bVar.destroy();
            this.f1957j.remove(bVar);
        }
    }

    /* loaded from: classes.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public final Set<String> a;

        public e() {
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
            this.a = new HashSet();
        }

        public void a(@NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.add(str);
            }
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                StackTraceElement[] stackTrace = new Throwable().getStackTrace();
                int min = Math.min(stackTrace.length, 20);
                for (int i2 = 0; i2 < min; i2++) {
                    if (this.a.contains(stackTrace[i2].getClassName())) {
                        return true;
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public /* synthetic */ e(C0046a c0046a) {
            this();
        }
    }
}
