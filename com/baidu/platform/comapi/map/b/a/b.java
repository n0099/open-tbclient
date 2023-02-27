package com.baidu.platform.comapi.map.b.a;

import android.util.Pair;
import android.view.MotionEvent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.platform.comapi.map.b.a;
import com.baidu.platform.comapi.map.b.f;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a.C0124a a;
    public a.C0124a b;
    public a.C0124a c;
    public MotionEvent d;
    public f e;
    public a f;
    public boolean g;

    /* loaded from: classes2.dex */
    public interface a {
        boolean a(b bVar);

        boolean a(b bVar, MotionEvent motionEvent);

        boolean b(b bVar);
    }

    public b(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new f();
        this.g = false;
        this.f = aVar;
    }

    public void a(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, motionEvent) == null) {
            this.d = motionEvent;
            int action = motionEvent.getAction();
            if (action != 2) {
                if (action != 6) {
                    if (action != 261) {
                        if (action != 262) {
                            return;
                        }
                    } else if (!this.g) {
                        a();
                        return;
                    } else {
                        return;
                    }
                }
                if (this.g) {
                    b();
                }
            } else if (this.g) {
                b(motionEvent);
            } else if (motionEvent.getPointerCount() == 2) {
                a();
            }
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.e.a();
            this.a = null;
            this.b = null;
            this.c = null;
            this.g = true;
            this.f.a(this);
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.e.b();
            this.g = false;
            this.f.b(this);
        }
    }

    private void b(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, motionEvent) == null) {
            this.e.a(motionEvent);
            Pair<a.d, a.d> c = this.e.c();
            if (motionEvent.getPointerCount() == 2) {
                if (Math.abs(((a.d) c.first).a) > 0.0d || Math.abs(((a.d) c.first).b) > 0.0d || Math.abs(((a.d) c.second).a) > 0.0d || Math.abs(((a.d) c.second).b) > 0.0d) {
                    c(motionEvent);
                    this.f.a(this, motionEvent);
                }
            }
        }
    }

    private void c(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, motionEvent) == null) {
            a.C0124a a2 = a.C0124a.a(motionEvent);
            a.C0124a c0124a = this.c;
            if (c0124a == null) {
                c0124a = a2;
            }
            this.b = c0124a;
            this.c = a2;
            if (this.a == null) {
                this.a = a2;
            }
        }
    }
}
