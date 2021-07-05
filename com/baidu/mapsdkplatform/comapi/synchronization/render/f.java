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
/* loaded from: classes3.dex */
public class f {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f7935a = "f";

    /* renamed from: d  reason: collision with root package name */
    public static HandlerThread f7936d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f7937b;

    /* renamed from: c  reason: collision with root package name */
    public int f7938c;

    /* renamed from: e  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comapi.synchronization.render.b f7939e;

    /* renamed from: f  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comapi.synchronization.data.g f7940f;

    /* renamed from: g  reason: collision with root package name */
    public i f7941g;

    /* loaded from: classes3.dex */
    public class a implements i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f7942a;

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
            this.f7942a = fVar;
        }

        public /* synthetic */ a(f fVar, g gVar) {
            this(fVar);
        }

        @Override // com.baidu.mapsdkplatform.comapi.synchronization.data.i
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7942a.j();
                f fVar = this.f7942a;
                fVar.e(fVar.f7937b);
            }
        }

        @Override // com.baidu.mapsdkplatform.comapi.synchronization.data.i
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f7942a.i();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final f f7943a;
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
            f7943a = new f(null);
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
        this.f7937b = 0;
        this.f7938c = 5;
    }

    public /* synthetic */ f(g gVar) {
        this();
    }

    public static f a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.f7943a : (f) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65544, this, i2) == null) {
            String str = f7935a;
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.c(str, "The order state is: " + i2);
            if (i2 == 0 || i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5) {
                f(i2);
                return;
            }
            String str2 = f7935a;
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.c(str2, "Undefined order state: " + i2);
        }
    }

    private void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65545, this, i2) == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7939e;
            if (bVar == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7935a, "SyncRenderHandler is null");
                return;
            }
            Message obtainMessage = bVar.obtainMessage();
            obtainMessage.what = i2;
            this.f7939e.sendMessage(obtainMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            RoleOptions e2 = this.f7940f.e();
            DisplayOptions f2 = this.f7940f.f();
            com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7939e;
            if (bVar == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7935a, "SyncRenderHandler is null");
            } else {
                bVar.a(e2, f2, (SyncResponseResult) null, this.f7938c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        SyncResponseResult syncResponseResult;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            RoleOptions e2 = this.f7940f.e();
            DisplayOptions f2 = this.f7940f.f();
            try {
                syncResponseResult = this.f7940f.g().take();
            } catch (InterruptedException e3) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7935a, "Get result when InterruptedException happened.", e3);
                syncResponseResult = null;
            }
            com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7939e;
            if (bVar == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7935a, "SyncRenderHandler is null");
            } else {
                bVar.a(e2, f2, syncResponseResult, this.f7938c);
            }
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f7937b = i2;
            e(i2);
        }
    }

    public void a(int i2, int i3, int i4, int i5) {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, i4, i5) == null) || (bVar = this.f7939e) == null) {
            return;
        }
        bVar.a(i2, i3, i4, i5);
    }

    public void a(BaiduMap baiduMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, baiduMap) == null) {
            this.f7940f = com.baidu.mapsdkplatform.comapi.synchronization.data.g.a();
            a aVar = new a(this, null);
            this.f7941g = aVar;
            this.f7940f.a(aVar);
            HandlerThread handlerThread = new HandlerThread("SynchronizationRenderStrategy");
            f7936d = handlerThread;
            handlerThread.start();
            com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = new com.baidu.mapsdkplatform.comapi.synchronization.render.b(f7936d.getLooper());
            this.f7939e = bVar;
            bVar.a(baiduMap, this.f7940f.e(), this.f7940f.f());
        }
    }

    public void a(d dVar) {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) || (bVar = this.f7939e) == null) {
            return;
        }
        bVar.a(dVar);
    }

    public Marker b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7939e;
            if (bVar == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7935a, "SyncRenderHandler created failed");
                return null;
            }
            return bVar.a();
        }
        return (Marker) invokeV.objValue;
    }

    public void b(int i2) {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (bVar = this.f7939e) == null) {
            return;
        }
        bVar.a(i2);
    }

    public Marker c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7939e;
            if (bVar == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7935a, "SyncRenderHandler created failed");
                return null;
            }
            return bVar.b();
        }
        return (Marker) invokeV.objValue;
    }

    public void c(int i2) {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || (bVar = this.f7939e) == null) {
            return;
        }
        bVar.b(i2);
    }

    public Marker d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7939e;
            if (bVar == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7935a, "SyncRenderHandler created failed");
                return null;
            }
            return bVar.c();
        }
        return (Marker) invokeV.objValue;
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f7938c = i2;
        }
    }

    public void e() {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (bVar = this.f7939e) == null) {
            return;
        }
        bVar.d();
    }

    public void f() {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (bVar = this.f7939e) == null) {
            return;
        }
        bVar.e();
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.data.g gVar = this.f7940f;
            if (gVar != null) {
                gVar.c();
            }
            if (this.f7941g != null) {
                this.f7941g = null;
            }
            com.baidu.mapsdkplatform.comapi.synchronization.data.g gVar2 = this.f7940f;
            if (gVar2 != null) {
                gVar2.h();
                this.f7940f = null;
            }
            com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar = this.f7939e;
            if (bVar != null) {
                bVar.f();
                this.f7939e.removeCallbacksAndMessages(null);
                this.f7939e = null;
            }
            HandlerThread handlerThread = f7936d;
            if (handlerThread != null) {
                handlerThread.quit();
                f7936d = null;
            }
        }
    }

    public void h() {
        com.baidu.mapsdkplatform.comapi.synchronization.render.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (bVar = this.f7939e) == null) {
            return;
        }
        bVar.g();
    }
}
