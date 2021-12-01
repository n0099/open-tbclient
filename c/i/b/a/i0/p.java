package c.i.b.a.i0;

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
import java.util.Comparator;
/* loaded from: classes7.dex */
public class p {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final Comparator<c> f30237h;

    /* renamed from: i  reason: collision with root package name */
    public static final Comparator<c> f30238i;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<c> f30239b;

    /* renamed from: c  reason: collision with root package name */
    public final c[] f30240c;

    /* renamed from: d  reason: collision with root package name */
    public int f30241d;

    /* renamed from: e  reason: collision with root package name */
    public int f30242e;

    /* renamed from: f  reason: collision with root package name */
    public int f30243f;

    /* renamed from: g  reason: collision with root package name */
    public int f30244g;

    /* loaded from: classes7.dex */
    public static class a implements Comparator<c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(c cVar, c cVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, cVar, cVar2)) == null) ? cVar.a - cVar2.a : invokeLL.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements Comparator<c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(c cVar, c cVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, cVar, cVar2)) == null) {
                float f2 = cVar.f30246c;
                float f3 = cVar2.f30246c;
                if (f2 < f3) {
                    return -1;
                }
                return f3 < f2 ? 1 : 0;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f30245b;

        /* renamed from: c  reason: collision with root package name */
        public float f30246c;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-717096582, "Lc/i/b/a/i0/p;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-717096582, "Lc/i/b/a/i0/p;");
                return;
            }
        }
        f30237h = new a();
        f30238i = new b();
    }

    public p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = i2;
        this.f30240c = new c[5];
        this.f30239b = new ArrayList<>();
        this.f30241d = -1;
    }

    public void a(int i2, float f2) {
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) != null) {
            return;
        }
        b();
        int i3 = this.f30244g;
        if (i3 > 0) {
            c[] cVarArr = this.f30240c;
            int i4 = i3 - 1;
            this.f30244g = i4;
            cVar = cVarArr[i4];
        } else {
            cVar = new c(null);
        }
        int i5 = this.f30242e;
        this.f30242e = i5 + 1;
        cVar.a = i5;
        cVar.f30245b = i2;
        cVar.f30246c = f2;
        this.f30239b.add(cVar);
        this.f30243f += i2;
        while (true) {
            int i6 = this.f30243f;
            int i7 = this.a;
            if (i6 <= i7) {
                return;
            }
            int i8 = i6 - i7;
            c cVar2 = this.f30239b.get(0);
            int i9 = cVar2.f30245b;
            if (i9 <= i8) {
                this.f30243f -= i9;
                this.f30239b.remove(0);
                int i10 = this.f30244g;
                if (i10 < 5) {
                    c[] cVarArr2 = this.f30240c;
                    this.f30244g = i10 + 1;
                    cVarArr2[i10] = cVar2;
                }
            } else {
                cVar2.f30245b = i9 - i8;
                this.f30243f -= i8;
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f30241d == 1) {
            return;
        }
        Collections.sort(this.f30239b, f30237h);
        this.f30241d = 1;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f30241d == 0) {
            return;
        }
        Collections.sort(this.f30239b, f30238i);
        this.f30241d = 0;
    }

    public float d(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048579, this, f2)) == null) {
            c();
            float f3 = f2 * this.f30243f;
            int i2 = 0;
            for (int i3 = 0; i3 < this.f30239b.size(); i3++) {
                c cVar = this.f30239b.get(i3);
                i2 += cVar.f30245b;
                if (i2 >= f3) {
                    return cVar.f30246c;
                }
            }
            if (this.f30239b.isEmpty()) {
                return Float.NaN;
            }
            ArrayList<c> arrayList = this.f30239b;
            return arrayList.get(arrayList.size() - 1).f30246c;
        }
        return invokeF.floatValue;
    }
}
