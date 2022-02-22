package c.a.s0.a.p2.e;

import android.util.Log;
import c.a.s0.a.e0.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class a extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public boolean f8598g;

    /* renamed from: c.a.s0.a.p2.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0535a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ArrayList f8599e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f8600f;

        public RunnableC0535a(a aVar, ArrayList arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, arrayList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8600f = aVar;
            this.f8599e = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8600f.m(this.f8599e);
                this.f8600f.j();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.s0.a.p2.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.s0.a.p2.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.s0.a.p2.e.b
    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f8602b.a()) {
            long currentTimeMillis = b.f8601f ? System.currentTimeMillis() : 0L;
            this.a.g(new RunnableC0535a(this, this.f8602b.n()));
            if (b.f8601f) {
                String str = "saveCacheToDatabase costTime:" + (System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f8598g) {
            return;
        }
        long currentTimeMillis = b.f8601f ? System.currentTimeMillis() : 0L;
        this.a.b();
        this.f8598g = true;
        if (b.f8601f) {
            String str = "clearExpiredCookies costTime:" + (System.currentTimeMillis() - currentTimeMillis);
        }
    }

    public ArrayList<c.a.s0.a.p2.a> k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            long currentTimeMillis = b.f8601f ? System.currentTimeMillis() : 0L;
            ArrayList<c.a.s0.a.p2.a> arrayList = new ArrayList<>();
            try {
                arrayList = this.a.e(str);
            } catch (Exception e2) {
                d.k("SwanCookieSyncPolicy", Log.getStackTraceString(e2));
            }
            if (b.f8601f) {
                String str2 = "getCookiesForDomain costTime:" + (System.currentTimeMillis() - currentTimeMillis);
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            long currentTimeMillis = b.f8601f ? System.currentTimeMillis() : 0L;
            this.a.h();
            if (b.f8601f) {
                String str = "preInitDatabase costTime:" + (System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    public final void m(ArrayList<c.a.s0.a.p2.a> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, arrayList) == null) || arrayList == null || arrayList.isEmpty()) {
            return;
        }
        boolean z = b.f8601f;
        Iterator<c.a.s0.a.p2.a> it = arrayList.iterator();
        while (it.hasNext()) {
            c.a.s0.a.p2.a next = it.next();
            if (next != null) {
                if (b.f8601f) {
                    String str = "syncFromRamToFlash result cookie:" + next.toString();
                }
                int i2 = next.f8581i;
                if (i2 == 0) {
                    this.a.a(next);
                    this.f8602b.y(next);
                } else if (i2 == 2) {
                    this.a.d(next.a, next.f8574b, next.f8575c);
                    this.f8602b.g(next);
                } else if (i2 == 3) {
                    this.a.d(next.a, next.f8574b, next.f8575c);
                    this.a.a(next);
                    this.f8602b.y(next);
                }
            }
        }
    }
}
