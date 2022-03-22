package com.baidu.mapsdkplatform.comapi.synchronization.render;

import android.os.HandlerThread;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.synchronization.DisplayOptions;
import com.baidu.mapapi.synchronization.RoleOptions;
import com.baidu.mapsdkplatform.comapi.synchronization.data.SyncResponseResult;
import com.baidu.mapsdkplatform.comapi.synchronization.data.i;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class f {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "f";

    /* renamed from: d  reason: collision with root package name */
    public static HandlerThread f26875d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f26876b;

    /* renamed from: c  reason: collision with root package name */
    public int f26877c;

    /* renamed from: e  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comapi.synchronization.render.b f26878e;

    /* renamed from: f  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comapi.synchronization.data.g f26879f;

    /* renamed from: g  reason: collision with root package name */
    public i f26880g;

    /* loaded from: classes4.dex */
    public class a implements i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        public /* synthetic */ a(f fVar, g gVar) {
            this(fVar);
        }

        @Override // com.baidu.mapsdkplatform.comapi.synchronization.data.i
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.j();
                f fVar = this.a;
                fVar.e(fVar.f26876b);
            }
        }

        @Override // com.baidu.mapsdkplatform.comapi.synchronization.data.i
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.i();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final f a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-750338469, "Lcom/baidu/mapsdkplatform/comapi/synchronization/render/f$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-750338469, "Lcom/baidu/mapsdkplatform/comapi/synchronization/render/f$b;");
                    return;
                }
            }
            a = new f(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1502455079, "Lcom/baidu/mapsdkplatform/comapi/synchronization/render/f;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1502455079, "Lcom/baidu/mapsdkplatform/comapi/synchronization/render/f;");
        }
    }

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f26876b = 0;
        this.f26877c = 5;
    }

    public /* synthetic */ f(g gVar) {
        this();
    }

    public static f a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.a : (f) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65544, this, i) == null) {
            String str = a;
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.c(str, "The order state is: " + i);
            if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4 || i == 5) {
                f(i);
                return;
            }
            String str2 = a;
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.c(str2, "Undefined order state: " + i);
        }
    }

    private void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65545, this, i) == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f26878e;
            if (bVar == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "SyncRenderHandler is null");
                return;
            }
            Message obtainMessage = bVar.obtainMessage();
            obtainMessage.what = i;
            this.f26878e.sendMessage(obtainMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            RoleOptions e2 = this.f26879f.e();
            DisplayOptions f2 = this.f26879f.f();
            com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f26878e;
            if (bVar == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "SyncRenderHandler is null");
            } else {
                bVar.a(e2, f2, (SyncResponseResult) null, this.f26877c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        SyncResponseResult syncResponseResult;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            RoleOptions e2 = this.f26879f.e();
            DisplayOptions f2 = this.f26879f.f();
            try {
                syncResponseResult = this.f26879f.g().take();
            } catch (InterruptedException e3) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "Get result when InterruptedException happened.", e3);
                syncResponseResult = null;
            }
            com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f26878e;
            if (bVar == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "SyncRenderHandler is null");
            } else {
                bVar.a(e2, f2, syncResponseResult, this.f26877c);
            }
        }
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.f26876b = i;
            e(i);
        }
    }

    public void a(int i, int i2, int i3, int i4) {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, i3, i4) == null) || (bVar = this.f26878e) == null) {
            return;
        }
        bVar.a(i, i2, i3, i4);
    }

    public void a(BaiduMap baiduMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, baiduMap) == null) {
            this.f26879f = com.baidu.mapsdkplatform.comapi.synchronization.data.g.a();
            a aVar = new a(this, null);
            this.f26880g = aVar;
            this.f26879f.a(aVar);
            HandlerThread handlerThread = new HandlerThread("SynchronizationRenderStrategy");
            f26875d = handlerThread;
            handlerThread.start();
            com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = new com.baidu.mapsdkplatform.comapi.synchronization.render.b(f26875d.getLooper());
            this.f26878e = bVar;
            bVar.a(baiduMap, this.f26879f.e(), this.f26879f.f());
        }
    }

    public void a(d dVar) {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) || (bVar = this.f26878e) == null) {
            return;
        }
        bVar.a(dVar);
    }

    public Marker b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f26878e;
            if (bVar == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "SyncRenderHandler created failed");
                return null;
            }
            return bVar.a();
        }
        return (Marker) invokeV.objValue;
    }

    public void b(int i) {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i) == null) || (bVar = this.f26878e) == null) {
            return;
        }
        bVar.a(i);
    }

    public Marker c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f26878e;
            if (bVar == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "SyncRenderHandler created failed");
                return null;
            }
            return bVar.b();
        }
        return (Marker) invokeV.objValue;
    }

    public void c(int i) {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i) == null) || (bVar = this.f26878e) == null) {
            return;
        }
        bVar.b(i);
    }

    public Marker d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f26878e;
            if (bVar == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "SyncRenderHandler created failed");
                return null;
            }
            return bVar.c();
        }
        return (Marker) invokeV.objValue;
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.f26877c = i;
        }
    }

    public void e() {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (bVar = this.f26878e) == null) {
            return;
        }
        bVar.d();
    }

    public void f() {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (bVar = this.f26878e) == null) {
            return;
        }
        bVar.e();
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.data.g gVar = this.f26879f;
            if (gVar != null) {
                gVar.c();
            }
            if (this.f26880g != null) {
                this.f26880g = null;
            }
            com.baidu.mapsdkplatform.comapi.synchronization.data.g gVar2 = this.f26879f;
            if (gVar2 != null) {
                gVar2.h();
                this.f26879f = null;
            }
            com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f26878e;
            if (bVar != null) {
                bVar.f();
                this.f26878e.removeCallbacksAndMessages(null);
                this.f26878e = null;
            }
            HandlerThread handlerThread = f26875d;
            if (handlerThread != null) {
                handlerThread.quit();
                f26875d = null;
            }
        }
    }

    public void h() {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (bVar = this.f26878e) == null) {
            return;
        }
        bVar.g();
    }
}
