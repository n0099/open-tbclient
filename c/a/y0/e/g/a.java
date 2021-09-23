package c.a.y0.e.g;

import android.content.Context;
import c.a.y0.e.f.d;
import c.m.a.a;
import com.baidu.adp.plugin.PluginCenter;
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
    public class C1438a implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f31258a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Object f31259b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f31260c;

        public C1438a(a aVar, AtomicBoolean atomicBoolean, Object obj) {
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
            this.f31260c = aVar;
            this.f31258a = atomicBoolean;
            this.f31259b = obj;
        }

        @Override // c.m.a.a.c
        public void a(int i2, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, exc) == null) {
                this.f31260c.f31257g = i2;
                this.f31258a.set(true);
                synchronized (this.f31259b) {
                    this.f31259b.notifyAll();
                }
            }
        }

        @Override // c.m.a.a.c
        public void b(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z) == null) {
                this.f31260c.f31254d = str;
                this.f31260c.f31252b = z;
                this.f31260c.f31253c = true;
                this.f31260c.f31257g = 0;
                this.f31258a.set(true);
                synchronized (this.f31259b) {
                    this.f31259b.notifyAll();
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
        this.f31254d = "";
        this.f31252b = false;
        this.f31253c = false;
        this.f31257g = -200;
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
            c.m.a.a.d(this.f31251a, new C1438a(this, atomicBoolean, obj));
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
        return (c.a.y0.e.f.c) invokeV.objValue;
    }
}
