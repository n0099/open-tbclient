package c.a.y0.e.g;

import android.content.Context;
import c.a.y0.e.f.d;
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

    /* renamed from: c.a.y0.e.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1440a implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f31237a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Object f31238b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f31239c;

        public C1440a(a aVar, AtomicBoolean atomicBoolean, Object obj) {
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
            this.f31239c = aVar;
            this.f31237a = atomicBoolean;
            this.f31238b = obj;
        }

        @Override // c.m.a.a.c
        public void a(int i2, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, exc) == null) {
                this.f31239c.f31236g = i2;
                this.f31237a.set(true);
                synchronized (this.f31238b) {
                    this.f31238b.notifyAll();
                }
            }
        }

        @Override // c.m.a.a.c
        public void b(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z) == null) {
                this.f31239c.f31233d = str;
                this.f31239c.f31231b = z;
                this.f31239c.f31232c = true;
                this.f31239c.f31236g = 0;
                this.f31237a.set(true);
                synchronized (this.f31238b) {
                    this.f31238b.notifyAll();
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
        this.f31233d = "";
        this.f31231b = false;
        this.f31232c = false;
        this.f31236g = -200;
    }

    @Override // c.a.y0.e.f.c
    public c.a.y0.e.f.c d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            o();
            return this;
        }
        return (c.a.y0.e.f.c) invokeV.objValue;
    }

    public c.a.y0.e.f.c o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Object obj = new Object();
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            c.m.a.a.d(this.f31230a, new C1440a(this, atomicBoolean, obj));
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
        return (c.a.y0.e.f.c) invokeV.objValue;
    }
}
