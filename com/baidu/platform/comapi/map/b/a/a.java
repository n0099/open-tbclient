package com.baidu.platform.comapi.map.b.a;

import android.graphics.Point;
import android.view.MotionEvent;
import com.baidu.mapsdkplatform.comapi.map.x;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.al;
import com.baidu.platform.comapi.map.b.a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public boolean b;
    public a.C0125a c;
    public MapController d;
    public InterfaceC0126a e;

    /* renamed from: com.baidu.platform.comapi.map.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0126a {
        boolean a(a aVar);
    }

    public a(InterfaceC0126a interfaceC0126a, MapController mapController) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {interfaceC0126a, mapController};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0L;
        this.b = false;
        this.e = interfaceC0126a;
        this.d = mapController;
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.b = false;
            this.c = null;
            this.a = 0L;
        }
    }

    private void b(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, this, motionEvent) == null) && motionEvent.getPointerCount() == 2 && this.c != null) {
            a.C0125a a = a.C0125a.a(motionEvent);
            a.C0125a c0125a = new a.C0125a(this.c.a, a.a);
            a.C0125a c0125a2 = new a.C0125a(this.c.b, a.b);
            if (Math.abs(c0125a.b()) < 20.0d && Math.abs(c0125a2.b()) < 20.0d) {
                z = true;
            } else {
                z = false;
            }
            if (System.currentTimeMillis() - this.a < 200) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (this.d != null) {
                float x = motionEvent.getX(1) - motionEvent.getX(0);
                float y = motionEvent.getY(1) - motionEvent.getY();
                Point point = new Point((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
                Point point2 = new Point((int) (motionEvent.getRawX() + x), (int) (motionEvent.getRawY() + y));
                this.d.getMapView();
                if (z && z2 && this.b) {
                    List<al> listeners = this.d.getListeners();
                    x mapStatusInner = this.d.getMapStatusInner();
                    if (listeners != null) {
                        for (int i = 0; i < listeners.size(); i++) {
                            al alVar = listeners.get(i);
                            if (alVar != null && alVar.d(point, point2, mapStatusInner)) {
                                return;
                            }
                        }
                    }
                    this.e.a(this);
                }
            }
        }
    }

    private void c(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, this, motionEvent) != null) || motionEvent.getPointerCount() != 2) {
            return;
        }
        this.c = a.C0125a.a(motionEvent);
        this.b = true;
    }

    public void a(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, motionEvent) == null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 5) {
                    if (action != 6) {
                        if (action != 261) {
                            if (action != 262) {
                                return;
                            }
                        }
                    }
                    b(motionEvent);
                    a();
                    return;
                }
                c(motionEvent);
                return;
            }
            this.a = System.currentTimeMillis();
        }
    }
}
