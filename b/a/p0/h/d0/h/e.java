package b.a.p0.h.d0.h;

import b.a.p0.a.k;
import b.a.p0.a.v2.q;
import b.a.p0.h.d0.h.a;
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
    public static final boolean f10369e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<b.a.p0.h.d0.h.a> f10370a;

    /* renamed from: b  reason: collision with root package name */
    public String f10371b;

    /* renamed from: c  reason: collision with root package name */
    public String f10372c;

    /* renamed from: d  reason: collision with root package name */
    public int f10373d;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f10374e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f10375f;

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
            this.f10375f = eVar;
            this.f10374e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ArrayList<long[]> e2 = this.f10375f.e();
                d dVar = new d();
                dVar.f10366a = this.f10375f.f10371b;
                dVar.f10367b = e2;
                dVar.f10368c = this.f10375f.f10372c;
                b.a.p0.h.t.a.h().b(dVar, this.f10374e);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1719861327, "Lb/a/p0/h/d0/h/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1719861327, "Lb/a/p0/h/d0/h/e;");
                return;
            }
        }
        f10369e = k.f6397a;
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
        if (f10369e) {
            String str3 = "videoPath=" + str + "clipList=" + arrayList;
        }
        ArrayList<b.a.p0.h.d0.h.a> d2 = d(arrayList);
        this.f10370a = d2;
        this.f10371b = str;
        this.f10372c = str2;
        this.f10373d = d2.size();
    }

    public void c(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null) {
            return;
        }
        q.k(new a(this, cVar), "clipVideo");
    }

    public final ArrayList<b.a.p0.h.d0.h.a> d(ArrayList<b> arrayList) {
        InterceptResult invokeL;
        b.a.p0.h.d0.h.a a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList)) == null) {
            ArrayList<b.a.p0.h.d0.h.a> arrayList2 = new ArrayList<>();
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
            if (this.f10373d == 0) {
                return arrayList;
            }
            if (f10369e) {
                String str = "mergeRange mRangeList = " + this.f10370a;
            }
            Collections.sort(this.f10370a, new a.C0561a());
            b.a.p0.h.d0.h.a aVar = this.f10370a.get(0);
            for (int i2 = 1; i2 < this.f10373d; i2++) {
                b.a.p0.h.d0.h.a aVar2 = this.f10370a.get(i2);
                if (!aVar.b(aVar2)) {
                    arrayList.add(b.a.p0.h.d0.h.a.a(aVar));
                    aVar = aVar2;
                }
            }
            arrayList.add(b.a.p0.h.d0.h.a.a(aVar));
            if (f10369e) {
                String str2 = "mergeRange mergeList = " + arrayList;
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }
}
