package c.a.x0.e.g;

import android.content.Context;
import c.a.x0.e.f.d;
import c.m.a.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public class a extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.x0.e.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1439a implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f31118a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Object f31119b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f31120c;

        public C1439a(a aVar, AtomicBoolean atomicBoolean, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, atomicBoolean, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31120c = aVar;
            this.f31118a = atomicBoolean;
            this.f31119b = obj;
        }

        @Override // c.m.a.a.c
        public void a(int i2, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, exc) == null) {
                this.f31120c.f31117g = i2;
                this.f31118a.set(true);
                synchronized (this.f31119b) {
                    this.f31119b.notifyAll();
                }
            }
        }

        @Override // c.m.a.a.c
        public void b(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z) == null) {
                this.f31120c.f31114d = str;
                this.f31120c.f31112b = z;
                this.f31120c.f31113c = true;
                this.f31120c.f31117g = 0;
                this.f31118a.set(true);
                synchronized (this.f31119b) {
                    this.f31119b.notifyAll();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31114d = "";
        this.f31112b = false;
        this.f31113c = false;
        this.f31117g = -200;
    }

    @Override // c.a.x0.e.f.c
    public c.a.x0.e.f.c d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            o();
            return this;
        }
        return (c.a.x0.e.f.c) invokeV.objValue;
    }

    public c.a.x0.e.f.c o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Object obj = new Object();
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            c.m.a.a.d(this.f31111a, new C1439a(this, atomicBoolean, obj));
            synchronized (obj) {
                if (!atomicBoolean.get()) {
                    try {
                        obj.wait(4000L);
                    } catch (InterruptedException unused) {
                    }
                }
            }
            return this;
        }
        return (c.a.x0.e.f.c) invokeV.objValue;
    }
}
