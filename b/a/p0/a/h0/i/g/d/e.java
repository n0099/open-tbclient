package b.a.p0.a.h0.i.g.d;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.launchtips.monitor.request.RequestStatus;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<b.a.p0.a.h0.i.g.d.a> f5627a;

    /* renamed from: b  reason: collision with root package name */
    public final List<b.a.p0.a.h0.i.g.d.a> f5628b;

    /* renamed from: c  reason: collision with root package name */
    public final List<b.a.p0.a.h0.i.g.d.a> f5629c;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f5630a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1335404445, "Lb/a/p0/a/h0/i/g/d/e$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1335404445, "Lb/a/p0/a/h0/i/g/d/e$a;");
                    return;
                }
            }
            int[] iArr = new int[RequestStatus.values().length];
            f5630a = iArr;
            try {
                iArr[RequestStatus.STATUS_SEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5630a[RequestStatus.STATUS_SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5630a[RequestStatus.STATUS_FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

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
        this.f5627a = new ArrayList();
        this.f5628b = new ArrayList();
        this.f5629c = new ArrayList();
    }

    public synchronized void a(b.a.p0.a.h0.i.g.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            synchronized (this) {
                if (aVar == null) {
                    return;
                }
                int i2 = a.f5630a[aVar.f5610e.ordinal()];
                if (i2 == 1) {
                    this.f5627a.add(aVar);
                } else if (i2 == 2) {
                    this.f5628b.add(aVar);
                    c(this.f5627a, aVar);
                } else if (i2 == 3) {
                    this.f5629c.add(aVar);
                    c(this.f5627a, aVar);
                }
            }
        }
    }

    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                this.f5629c.clear();
                this.f5627a.clear();
                this.f5628b.clear();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0024, code lost:
        r5.remove();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void c(List<b.a.p0.a.h0.i.g.d.a> list, b.a.p0.a.h0.i.g.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, list, aVar) == null) {
            synchronized (this) {
                if (list != null) {
                    if (!list.isEmpty() && aVar != null) {
                        Iterator<b.a.p0.a.h0.i.g.d.a> it = list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            } else if (aVar.equals(it.next())) {
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public synchronized List<b.a.p0.a.h0.i.g.d.a> d() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                arrayList = new ArrayList();
                for (b.a.p0.a.h0.i.g.d.a aVar : this.f5629c) {
                    if (aVar != null && aVar.g(true)) {
                        arrayList.add(aVar);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public synchronized int e() {
        InterceptResult invokeV;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                size = this.f5629c.size();
            }
            return size;
        }
        return invokeV.intValue;
    }

    public synchronized List<b.a.p0.a.h0.i.g.d.a> f() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                arrayList = new ArrayList();
                for (b.a.p0.a.h0.i.g.d.a aVar : this.f5629c) {
                    if (aVar != null && aVar.f()) {
                        arrayList.add(aVar);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public synchronized List<b.a.p0.a.h0.i.g.d.a> g() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                arrayList = new ArrayList();
                for (b.a.p0.a.h0.i.g.d.a aVar : this.f5628b) {
                    if (aVar != null && aVar.h()) {
                        arrayList.add(aVar);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public synchronized int h() {
        InterceptResult invokeV;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this) {
                size = this.f5628b.size();
            }
            return size;
        }
        return invokeV.intValue;
    }

    public synchronized int i() {
        InterceptResult invokeV;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            synchronized (this) {
                size = this.f5627a.size() + h() + e();
            }
            return size;
        }
        return invokeV.intValue;
    }
}
