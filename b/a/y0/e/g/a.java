package b.a.y0.e.g;

import android.content.Context;
import b.a.y0.e.f.d;
import b.m.a.a;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class a extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.y0.e.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1441a implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f30000a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Object f30001b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f30002c;

        public C1441a(a aVar, AtomicBoolean atomicBoolean, Object obj) {
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
            this.f30002c = aVar;
            this.f30000a = atomicBoolean;
            this.f30001b = obj;
        }

        @Override // b.m.a.a.c
        public void a(int i2, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, exc) == null) {
                this.f30002c.f29999g = i2;
                this.f30000a.set(true);
                synchronized (this.f30001b) {
                    this.f30001b.notifyAll();
                }
            }
        }

        @Override // b.m.a.a.c
        public void b(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z) == null) {
                this.f30002c.f29996d = str;
                this.f30002c.f29994b = z;
                this.f30002c.f29995c = true;
                this.f30002c.f29999g = 0;
                this.f30000a.set(true);
                synchronized (this.f30001b) {
                    this.f30001b.notifyAll();
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
        this.f29996d = "";
        this.f29994b = false;
        this.f29995c = false;
        this.f29999g = -200;
    }

    @Override // b.a.y0.e.f.c
    public b.a.y0.e.f.c d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            o();
            return this;
        }
        return (b.a.y0.e.f.c) invokeV.objValue;
    }

    public b.a.y0.e.f.c o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Object obj = new Object();
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            b.m.a.a.d(this.f29993a, new C1441a(this, atomicBoolean, obj));
            synchronized (obj) {
                if (!atomicBoolean.get()) {
                    try {
                        obj.wait(PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
                    } catch (InterruptedException unused) {
                    }
                }
            }
            return this;
        }
        return (b.a.y0.e.f.c) invokeV.objValue;
    }
}
