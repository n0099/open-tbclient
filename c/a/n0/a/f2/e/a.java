package c.a.n0.a.f2.e;

import android.util.Log;
import c.a.n0.a.u.d;
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
    public boolean f4503g;

    /* renamed from: c.a.n0.a.f2.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0280a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ArrayList a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f4504b;

        public RunnableC0280a(a aVar, ArrayList arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, arrayList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4504b = aVar;
            this.a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f4504b.m(this.a);
                this.f4504b.j();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.n0.a.f2.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((c.a.n0.a.f2.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.n0.a.f2.e.b
    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f4506b.a()) {
            long currentTimeMillis = b.f4505f ? System.currentTimeMillis() : 0L;
            this.a.g(new RunnableC0280a(this, this.f4506b.n()));
            if (b.f4505f) {
                Log.d("SwanCookieSyncPolicy", "saveCacheToDatabase costTime:" + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f4503g) {
            return;
        }
        long currentTimeMillis = b.f4505f ? System.currentTimeMillis() : 0L;
        this.a.b();
        this.f4503g = true;
        if (b.f4505f) {
            Log.d("SwanCookieSyncPolicy", "clearExpiredCookies costTime:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public ArrayList<c.a.n0.a.f2.a> k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            long currentTimeMillis = b.f4505f ? System.currentTimeMillis() : 0L;
            ArrayList<c.a.n0.a.f2.a> arrayList = new ArrayList<>();
            try {
                arrayList = this.a.e(str);
            } catch (Exception e2) {
                d.k("SwanCookieSyncPolicy", Log.getStackTraceString(e2));
            }
            if (b.f4505f) {
                Log.d("SwanCookieSyncPolicy", "getCookiesForDomain costTime:" + (System.currentTimeMillis() - currentTimeMillis));
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            long currentTimeMillis = b.f4505f ? System.currentTimeMillis() : 0L;
            this.a.h();
            if (b.f4505f) {
                Log.d("SwanCookieSyncPolicy", "preInitDatabase costTime:" + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    public final void m(ArrayList<c.a.n0.a.f2.a> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, arrayList) == null) || arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (b.f4505f) {
            Log.d("SwanCookieSyncPolicy", "syncFromRamToFlash start");
        }
        Iterator<c.a.n0.a.f2.a> it = arrayList.iterator();
        while (it.hasNext()) {
            c.a.n0.a.f2.a next = it.next();
            if (next != null) {
                if (b.f4505f) {
                    Log.d("SwanCookieSyncPolicy", "syncFromRamToFlash result cookie:" + next.toString());
                }
                int i = next.i;
                if (i == 0) {
                    this.a.a(next);
                    this.f4506b.y(next);
                } else if (i == 2) {
                    this.a.d(next.a, next.f4482b, next.f4483c);
                    this.f4506b.g(next);
                } else if (i == 3) {
                    this.a.d(next.a, next.f4482b, next.f4483c);
                    this.a.a(next);
                    this.f4506b.y(next);
                }
            }
        }
    }
}
