package b.a.p0.a.l2.e;

import android.util.Log;
import b.a.p0.a.e0.d;
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
    public boolean f6605g;

    /* renamed from: b.a.p0.a.l2.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0282a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ArrayList f6606e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f6607f;

        public RunnableC0282a(a aVar, ArrayList arrayList) {
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
            this.f6607f = aVar;
            this.f6606e = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f6607f.m(this.f6606e);
                this.f6607f.j();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(b.a.p0.a.l2.b bVar) {
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
                super((b.a.p0.a.l2.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // b.a.p0.a.l2.e.b
    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f6610b.a()) {
            long currentTimeMillis = b.f6608f ? System.currentTimeMillis() : 0L;
            this.f6609a.g(new RunnableC0282a(this, this.f6610b.n()));
            if (b.f6608f) {
                String str = "saveCacheToDatabase costTime:" + (System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f6605g) {
            return;
        }
        long currentTimeMillis = b.f6608f ? System.currentTimeMillis() : 0L;
        this.f6609a.b();
        this.f6605g = true;
        if (b.f6608f) {
            String str = "clearExpiredCookies costTime:" + (System.currentTimeMillis() - currentTimeMillis);
        }
    }

    public ArrayList<b.a.p0.a.l2.a> k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            long currentTimeMillis = b.f6608f ? System.currentTimeMillis() : 0L;
            ArrayList<b.a.p0.a.l2.a> arrayList = new ArrayList<>();
            try {
                arrayList = this.f6609a.e(str);
            } catch (Exception e2) {
                d.h("SwanCookieSyncPolicy", Log.getStackTraceString(e2));
            }
            if (b.f6608f) {
                String str2 = "getCookiesForDomain costTime:" + (System.currentTimeMillis() - currentTimeMillis);
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            long currentTimeMillis = b.f6608f ? System.currentTimeMillis() : 0L;
            this.f6609a.h();
            if (b.f6608f) {
                String str = "preInitDatabase costTime:" + (System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    public final void m(ArrayList<b.a.p0.a.l2.a> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, arrayList) == null) || arrayList == null || arrayList.isEmpty()) {
            return;
        }
        boolean z = b.f6608f;
        Iterator<b.a.p0.a.l2.a> it = arrayList.iterator();
        while (it.hasNext()) {
            b.a.p0.a.l2.a next = it.next();
            if (next != null) {
                if (b.f6608f) {
                    String str = "syncFromRamToFlash result cookie:" + next.toString();
                }
                int i2 = next.f6585i;
                if (i2 == 0) {
                    this.f6609a.a(next);
                    this.f6610b.y(next);
                } else if (i2 == 2) {
                    this.f6609a.d(next.f6577a, next.f6578b, next.f6579c);
                    this.f6610b.g(next);
                } else if (i2 == 3) {
                    this.f6609a.d(next.f6577a, next.f6578b, next.f6579c);
                    this.f6609a.a(next);
                    this.f6610b.y(next);
                }
            }
        }
    }
}
