package c.a.z0.e.g;

import android.content.Context;
import c.a.z0.e.f.d;
import c.l.a.a;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.schemeaction.deeplink.DeepLinkCode;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public class a extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.z0.e.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1589a implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtomicBoolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Object f27637b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f27638c;

        public C1589a(a aVar, AtomicBoolean atomicBoolean, Object obj) {
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
            this.f27638c = aVar;
            this.a = atomicBoolean;
            this.f27637b = obj;
        }

        @Override // c.l.a.a.c
        public void a(int i2, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, exc) == null) {
                this.f27638c.f27636g = i2;
                this.a.set(true);
                synchronized (this.f27637b) {
                    this.f27637b.notifyAll();
                }
            }
        }

        @Override // c.l.a.a.c
        public void b(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z) == null) {
                this.f27638c.f27633d = str;
                this.f27638c.f27631b = z;
                this.f27638c.f27632c = true;
                this.f27638c.f27636g = 0;
                this.a.set(true);
                synchronized (this.f27637b) {
                    this.f27637b.notifyAll();
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
        this.f27633d = "";
        this.f27631b = false;
        this.f27632c = false;
        this.f27636g = DeepLinkCode.ERROR_LINK_NOT_MATCH;
    }

    @Override // c.a.z0.e.f.c
    public c.a.z0.e.f.c d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            n();
            return this;
        }
        return (c.a.z0.e.f.c) invokeV.objValue;
    }

    public c.a.z0.e.f.c n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Object obj = new Object();
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            c.l.a.a.d(this.a, new C1589a(this, atomicBoolean, obj));
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
        return (c.a.z0.e.f.c) invokeV.objValue;
    }
}
