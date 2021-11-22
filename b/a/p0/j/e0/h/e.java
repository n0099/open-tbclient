package b.a.p0.j.e0.h;

import b.a.p0.a.k;
import b.a.p0.a.z2.q;
import b.a.p0.j.e0.h.a;
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
/* loaded from: classes4.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f11091e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<b.a.p0.j.e0.h.a> f11092a;

    /* renamed from: b  reason: collision with root package name */
    public String f11093b;

    /* renamed from: c  reason: collision with root package name */
    public String f11094c;

    /* renamed from: d  reason: collision with root package name */
    public int f11095d;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f11096e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f11097f;

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
            this.f11097f = eVar;
            this.f11096e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ArrayList<long[]> e2 = this.f11097f.e();
                d dVar = new d();
                dVar.f11088a = this.f11097f.f11093b;
                dVar.f11089b = e2;
                dVar.f11090c = this.f11097f.f11094c;
                b.a.p0.j.u.a.i().b(dVar, this.f11096e);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-152299276, "Lb/a/p0/j/e0/h/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-152299276, "Lb/a/p0/j/e0/h/e;");
                return;
            }
        }
        f11091e = k.f6863a;
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
        if (f11091e) {
            String str3 = "videoPath=" + str + "clipList=" + arrayList;
        }
        ArrayList<b.a.p0.j.e0.h.a> d2 = d(arrayList);
        this.f11092a = d2;
        this.f11093b = str;
        this.f11094c = str2;
        this.f11095d = d2.size();
    }

    public void c(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null) {
            return;
        }
        q.l(new a(this, cVar), "clipVideo");
    }

    public final ArrayList<b.a.p0.j.e0.h.a> d(ArrayList<b> arrayList) {
        InterceptResult invokeL;
        b.a.p0.j.e0.h.a a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList)) == null) {
            ArrayList<b.a.p0.j.e0.h.a> arrayList2 = new ArrayList<>();
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
            if (this.f11095d == 0) {
                return arrayList;
            }
            if (f11091e) {
                String str = "mergeRange mRangeList = " + this.f11092a;
            }
            Collections.sort(this.f11092a, new a.C0594a());
            b.a.p0.j.e0.h.a aVar = this.f11092a.get(0);
            for (int i2 = 1; i2 < this.f11095d; i2++) {
                b.a.p0.j.e0.h.a aVar2 = this.f11092a.get(i2);
                if (!aVar.b(aVar2)) {
                    arrayList.add(b.a.p0.j.e0.h.a.a(aVar));
                    aVar = aVar2;
                }
            }
            arrayList.add(b.a.p0.j.e0.h.a.a(aVar));
            if (f11091e) {
                String str2 = "mergeRange mergeList = " + arrayList;
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }
}
