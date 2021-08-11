package c.a.e.e.i;

import android.location.Address;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
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
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static a m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f2216a;

    /* renamed from: b  reason: collision with root package name */
    public long f2217b;

    /* renamed from: c  reason: collision with root package name */
    public long f2218c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f2219d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2220e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f2221f;

    /* renamed from: g  reason: collision with root package name */
    public int f2222g;

    /* renamed from: h  reason: collision with root package name */
    public Address f2223h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<SoftReference<c>> f2224i;

    /* renamed from: j  reason: collision with root package name */
    public ArrayList<c.a.e.e.i.b> f2225j;
    public Handler k;
    public d l;

    /* renamed from: c.a.e.e.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0044a implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f2226a;

        public C0044a(a aVar) {
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
            this.f2226a = aVar;
        }

        @Override // c.a.e.e.i.a.d
        public void a(int i2, String str, Address address, long j2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, address, Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
                a aVar = this.f2226a;
                aVar.f2217b = j2;
                aVar.f2223h = address;
                this.f2226a.f2219d = z;
                this.f2226a.f2222g = i2;
                this.f2226a.s();
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
                this.f2226a.g(i2, str, address);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f2227e;

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
            this.f2227e = aVar;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            String string;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what != 0) {
                    return false;
                }
                this.f2227e.s();
                int i2 = this.f2227e.f2222g;
                if (i2 == 1) {
                    string = BdBaseApplication.getInst().getResources().getString(R.string.location_gps_offline);
                } else if (i2 == 2) {
                    string = BdBaseApplication.getInst().getResources().getString(R.string.location_net_offline);
                } else if (i2 == 3) {
                    string = BdBaseApplication.getInst().getResources().getString(R.string.location_all_offline);
                } else if (i2 != 4) {
                    string = i2 != 6 ? "" : BdBaseApplication.getInst().getResources().getString(R.string.location_out_time);
                } else {
                    string = BdBaseApplication.getInst().getResources().getString(R.string.location_out_time);
                }
                a aVar = this.f2227e;
                aVar.g(aVar.f2222g, string, null);
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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1211483418, "Lc/a/e/e/i/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1211483418, "Lc/a/e/e/i/a;");
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
        this.f2216a = 10000L;
        this.f2217b = 0L;
        this.f2218c = 300000L;
        this.f2219d = false;
        this.f2220e = false;
        this.f2221f = false;
        this.f2222g = 4;
        this.f2223h = null;
        this.f2224i = null;
        this.f2225j = new ArrayList<>();
        this.k = null;
        this.l = new C0044a(this);
    }

    public static a l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (m == null) {
                synchronized (a.class) {
                    if (m == null) {
                        m = new a();
                    }
                }
            }
            return m;
        }
        return (a) invokeV.objValue;
    }

    public final void g(int i2, String str, Address address) {
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, address) == null) {
            if (this.k.hasMessages(0)) {
                this.k.removeMessages(0);
            }
            ArrayList<SoftReference<c>> arrayList = this.f2224i;
            if (arrayList != null) {
                synchronized (arrayList) {
                    for (int i3 = 0; i3 < this.f2224i.size(); i3++) {
                        SoftReference<c> softReference = this.f2224i.get(i3);
                        if (softReference != null && (cVar = softReference.get()) != null) {
                            cVar.onLocationGeted(i2, str, address);
                        }
                    }
                    this.f2224i.clear();
                }
            }
        }
    }

    public Address h(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? j(z, false) : (Address) invokeZ.objValue;
    }

    public Address i(boolean z, c cVar) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZL = interceptable.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, cVar)) == null) ? k(z, false, cVar) : (Address) invokeZL.objValue;
    }

    public Address j(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (System.currentTimeMillis() - this.f2217b > this.f2218c) {
                this.f2223h = null;
            }
            if (this.f2223h != null && !z && ((z2 && this.f2219d) || !z2)) {
                return this.f2223h;
            }
            this.f2223h = null;
            boolean z3 = this.f2221f;
            if (!z3) {
                r(z2);
                return null;
            }
            if (z3 && z2 && !this.f2220e) {
                s();
                r(z2);
            }
            return null;
        }
        return (Address) invokeCommon.objValue;
    }

    public Address k(boolean z, boolean z2, c cVar) {
        InterceptResult invokeCommon;
        boolean z3;
        c cVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), cVar})) == null) {
            if (System.currentTimeMillis() - this.f2217b > this.f2218c) {
                this.f2223h = null;
            }
            if (this.f2223h != null && !z && ((z2 && this.f2219d) || !z2)) {
                if (cVar != null) {
                    cVar.onLocationGeted(0, "", this.f2223h);
                }
                return this.f2223h;
            }
            if (cVar != null) {
                synchronized (this.f2224i) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= this.f2224i.size()) {
                            z3 = false;
                            break;
                        }
                        SoftReference<c> softReference = this.f2224i.get(i2);
                        if (softReference != null && (cVar2 = softReference.get()) != null && cVar2.equals(cVar)) {
                            z3 = true;
                            break;
                        }
                        i2++;
                    }
                    if (!z3) {
                        if (this.f2224i.size() >= 100) {
                            this.f2224i.remove(0);
                        }
                        this.f2224i.add(new SoftReference<>(cVar));
                    }
                }
                boolean z4 = this.f2221f;
                if (!z4) {
                    r(z2);
                    return null;
                } else if (z4 && z2 && !this.f2220e) {
                    s();
                    r(z2);
                    return null;
                }
            }
            return null;
        }
        return (Address) invokeCommon.objValue;
    }

    public long m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f2216a : invokeV.longValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.k = new Handler(Looper.getMainLooper(), new b(this));
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f2224i = new ArrayList<>();
            n();
        }
    }

    public void p(c.a.e.e.i.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) || bVar == null) {
            return;
        }
        synchronized (this.f2225j) {
            if (!this.f2225j.contains(bVar)) {
                bVar.b(this.l);
                this.f2225j.add(bVar);
            }
        }
    }

    public void q(c cVar) {
        c cVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            synchronized (this.f2224i) {
                int i2 = 0;
                while (true) {
                    if (i2 < this.f2224i.size()) {
                        SoftReference<c> softReference = this.f2224i.get(i2);
                        if (softReference != null && (cVar2 = softReference.get()) != null && cVar2.equals(cVar)) {
                            this.f2224i.remove(softReference);
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

    public final void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            if (this.k.hasMessages(0)) {
                this.k.removeMessages(0);
            }
            this.f2222g = 4;
            this.f2220e = z;
            this.f2221f = true;
            ArrayList<c.a.e.e.i.b> arrayList = this.f2225j;
            if (arrayList != null && !arrayList.isEmpty()) {
                Iterator<c.a.e.e.i.b> it = this.f2225j.iterator();
                while (it.hasNext()) {
                    c.a.e.e.i.b next = it.next();
                    if (next != null) {
                        try {
                            next.a(z);
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                }
                Handler handler = this.k;
                handler.sendMessageDelayed(handler.obtainMessage(0), this.f2216a);
                return;
            }
            this.f2222g = 6;
            Handler handler2 = this.k;
            handler2.sendMessage(handler2.obtainMessage(0));
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (this.k.hasMessages(0)) {
                this.k.removeMessages(0);
            }
            this.f2221f = false;
            Iterator<c.a.e.e.i.b> it = this.f2225j.iterator();
            while (it.hasNext()) {
                c.a.e.e.i.b next = it.next();
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

    public void t(c.a.e.e.i.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) || bVar == null) {
            return;
        }
        synchronized (this.f2225j) {
            bVar.destroy();
            this.f2225j.remove(bVar);
        }
    }
}
