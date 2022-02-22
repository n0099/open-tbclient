package c.a.s0.j.e0.h;

import c.a.s0.a.k;
import c.a.s0.a.z2.q;
import c.a.s0.j.e0.h.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f11207e;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<c.a.s0.j.e0.h.a> a;

    /* renamed from: b  reason: collision with root package name */
    public String f11208b;

    /* renamed from: c  reason: collision with root package name */
    public String f11209c;

    /* renamed from: d  reason: collision with root package name */
    public int f11210d;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f11211e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f11212f;

        public a(e eVar, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11212f = eVar;
            this.f11211e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ArrayList<long[]> e2 = this.f11212f.e();
                d dVar = new d();
                dVar.a = this.f11212f.f11208b;
                dVar.f11205b = e2;
                dVar.f11206c = this.f11212f.f11209c;
                c.a.s0.j.u.a.i().b(dVar, this.f11211e);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-275585296, "Lc/a/s0/j/e0/h/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-275585296, "Lc/a/s0/j/e0/h/e;");
                return;
            }
        }
        f11207e = k.a;
    }

    public e(ArrayList<b> arrayList, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {arrayList, str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (f11207e) {
            String str3 = "videoPath=" + str + "clipList=" + arrayList;
        }
        ArrayList<c.a.s0.j.e0.h.a> d2 = d(arrayList);
        this.a = d2;
        this.f11208b = str;
        this.f11209c = str2;
        this.f11210d = d2.size();
    }

    public void c(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null) {
            return;
        }
        q.l(new a(this, cVar), "clipVideo");
    }

    public final ArrayList<c.a.s0.j.e0.h.a> d(ArrayList<b> arrayList) {
        InterceptResult invokeL;
        c.a.s0.j.e0.h.a a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList)) == null) {
            ArrayList<c.a.s0.j.e0.h.a> arrayList2 = new ArrayList<>();
            if (arrayList != null && arrayList.size() != 0) {
                Iterator<b> it = arrayList.iterator();
                while (it.hasNext()) {
                    b next = it.next();
                    if (next != null && (a2 = next.a()) != null) {
                        arrayList2.add(a2);
                    }
                }
            }
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    public ArrayList<long[]> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ArrayList<long[]> arrayList = new ArrayList<>();
            if (this.f11210d == 0) {
                return arrayList;
            }
            if (f11207e) {
                String str = "mergeRange mRangeList = " + this.a;
            }
            Collections.sort(this.a, new a.C0763a());
            c.a.s0.j.e0.h.a aVar = this.a.get(0);
            for (int i2 = 1; i2 < this.f11210d; i2++) {
                c.a.s0.j.e0.h.a aVar2 = this.a.get(i2);
                if (!aVar.b(aVar2)) {
                    arrayList.add(c.a.s0.j.e0.h.a.a(aVar));
                    aVar = aVar2;
                }
            }
            arrayList.add(c.a.s0.j.e0.h.a.a(aVar));
            if (f11207e) {
                String str2 = "mergeRange mergeList = " + arrayList;
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }
}
