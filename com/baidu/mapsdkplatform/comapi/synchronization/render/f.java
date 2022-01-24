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
/* loaded from: classes10.dex */
public class f {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "f";

    /* renamed from: d  reason: collision with root package name */
    public static HandlerThread f36086d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f36087b;

    /* renamed from: c  reason: collision with root package name */
    public int f36088c;

    /* renamed from: e  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comapi.synchronization.render.b f36089e;

    /* renamed from: f  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comapi.synchronization.data.g f36090f;

    /* renamed from: g  reason: collision with root package name */
    public i f36091g;

    /* loaded from: classes10.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                fVar.e(fVar.f36087b);
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

    /* loaded from: classes10.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f36087b = 0;
        this.f36088c = 5;
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
    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65544, this, i2) == null) {
            String str = a;
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.c(str, "The order state is: " + i2);
            if (i2 == 0 || i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5) {
                f(i2);
                return;
            }
            String str2 = a;
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.c(str2, "Undefined order state: " + i2);
        }
    }

    private void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65545, this, i2) == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f36089e;
            if (bVar == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "SyncRenderHandler is null");
                return;
            }
            Message obtainMessage = bVar.obtainMessage();
            obtainMessage.what = i2;
            this.f36089e.sendMessage(obtainMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            RoleOptions e2 = this.f36090f.e();
            DisplayOptions f2 = this.f36090f.f();
            com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f36089e;
            if (bVar == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "SyncRenderHandler is null");
            } else {
                bVar.a(e2, f2, (SyncResponseResult) null, this.f36088c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        SyncResponseResult syncResponseResult;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            RoleOptions e2 = this.f36090f.e();
            DisplayOptions f2 = this.f36090f.f();
            try {
                syncResponseResult = this.f36090f.g().take();
            } catch (InterruptedException e3) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "Get result when InterruptedException happened.", e3);
                syncResponseResult = null;
            }
            com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f36089e;
            if (bVar == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "SyncRenderHandler is null");
            } else {
                bVar.a(e2, f2, syncResponseResult, this.f36088c);
            }
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f36087b = i2;
            e(i2);
        }
    }

    public void a(int i2, int i3, int i4, int i5) {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, i4, i5) == null) || (bVar = this.f36089e) == null) {
            return;
        }
        bVar.a(i2, i3, i4, i5);
    }

    public void a(BaiduMap baiduMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, baiduMap) == null) {
            this.f36090f = com.baidu.mapsdkplatform.comapi.synchronization.data.g.a();
            a aVar = new a(this, null);
            this.f36091g = aVar;
            this.f36090f.a(aVar);
            HandlerThread handlerThread = new HandlerThread("SynchronizationRenderStrategy");
            f36086d = handlerThread;
            handlerThread.start();
            com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = new com.baidu.mapsdkplatform.comapi.synchronization.render.b(f36086d.getLooper());
            this.f36089e = bVar;
            bVar.a(baiduMap, this.f36090f.e(), this.f36090f.f());
        }
    }

    public void a(d dVar) {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) || (bVar = this.f36089e) == null) {
            return;
        }
        bVar.a(dVar);
    }

    public Marker b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f36089e;
            if (bVar == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "SyncRenderHandler created failed");
                return null;
            }
            return bVar.a();
        }
        return (Marker) invokeV.objValue;
    }

    public void b(int i2) {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (bVar = this.f36089e) == null) {
            return;
        }
        bVar.a(i2);
    }

    public Marker c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f36089e;
            if (bVar == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "SyncRenderHandler created failed");
                return null;
            }
            return bVar.b();
        }
        return (Marker) invokeV.objValue;
    }

    public void c(int i2) {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || (bVar = this.f36089e) == null) {
            return;
        }
        bVar.b(i2);
    }

    public Marker d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f36089e;
            if (bVar == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "SyncRenderHandler created failed");
                return null;
            }
            return bVar.c();
        }
        return (Marker) invokeV.objValue;
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f36088c = i2;
        }
    }

    public void e() {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (bVar = this.f36089e) == null) {
            return;
        }
        bVar.d();
    }

    public void f() {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (bVar = this.f36089e) == null) {
            return;
        }
        bVar.e();
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.data.g gVar = this.f36090f;
            if (gVar != null) {
                gVar.c();
            }
            if (this.f36091g != null) {
                this.f36091g = null;
            }
            com.baidu.mapsdkplatform.comapi.synchronization.data.g gVar2 = this.f36090f;
            if (gVar2 != null) {
                gVar2.h();
                this.f36090f = null;
            }
            com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f36089e;
            if (bVar != null) {
                bVar.f();
                this.f36089e.removeCallbacksAndMessages(null);
                this.f36089e = null;
            }
            HandlerThread handlerThread = f36086d;
            if (handlerThread != null) {
                handlerThread.quit();
                f36086d = null;
            }
        }
    }

    public void h() {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (bVar = this.f36089e) == null) {
            return;
        }
        bVar.g();
    }
}
