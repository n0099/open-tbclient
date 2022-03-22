package c.b.b.l.a;

import android.content.Context;
import android.view.MotionEvent;
import c.b.b.l.a.z;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class t {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public t() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a(MotionEvent motionEvent, z zVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, motionEvent, zVar) == null) {
            int action = motionEvent.getAction() & 255;
            int action2 = (motionEvent.getAction() & 65280) >> 8;
            int pointerId = motionEvent.getPointerId(action2);
            long nanoTime = System.nanoTime();
            synchronized (zVar) {
                int i9 = 20;
                switch (action) {
                    case 0:
                    case 5:
                        int d2 = zVar.d();
                        if (d2 >= 20) {
                            break;
                        } else {
                            zVar.q[d2] = pointerId;
                            int x = (int) motionEvent.getX(action2);
                            int y = (int) motionEvent.getY(action2);
                            int d3 = d(motionEvent.getButtonState());
                            if (d3 != -1) {
                                i = d3;
                                i2 = x;
                                i3 = y;
                                b(zVar, 0, x, y, d2, i, nanoTime);
                            } else {
                                i = d3;
                                i2 = x;
                                i3 = y;
                            }
                            zVar.k[d2] = i2;
                            zVar.l[d2] = i3;
                            zVar.m[d2] = 0;
                            zVar.n[d2] = 0;
                            int i10 = i;
                            zVar.o[d2] = i10 != -1;
                            zVar.p[d2] = i10;
                            zVar.r[d2] = motionEvent.getPressure(action2);
                            break;
                        }
                    case 1:
                    case 4:
                    case 6:
                        int f2 = zVar.f(pointerId);
                        if (f2 != -1 && f2 < 20) {
                            zVar.q[f2] = -1;
                            int x2 = (int) motionEvent.getX(action2);
                            int y2 = (int) motionEvent.getY(action2);
                            int i11 = zVar.p[f2];
                            if (i11 != -1) {
                                i4 = x2;
                                b(zVar, 1, x2, y2, f2, i11, nanoTime);
                            } else {
                                i4 = x2;
                            }
                            zVar.k[f2] = i4;
                            zVar.l[f2] = y2;
                            zVar.m[f2] = 0;
                            zVar.n[f2] = 0;
                            zVar.o[f2] = false;
                            zVar.p[f2] = 0;
                            zVar.r[f2] = 0.0f;
                            break;
                        }
                        break;
                    case 2:
                        int pointerCount = motionEvent.getPointerCount();
                        int i12 = 0;
                        while (i12 < pointerCount) {
                            int pointerId2 = motionEvent.getPointerId(i12);
                            int x3 = (int) motionEvent.getX(i12);
                            int y3 = (int) motionEvent.getY(i12);
                            int f3 = zVar.f(pointerId2);
                            if (f3 == -1) {
                                i7 = i12;
                            } else if (f3 >= i9) {
                                break;
                            } else {
                                int i13 = zVar.p[f3];
                                if (i13 != -1) {
                                    i5 = f3;
                                    i6 = y3;
                                    i7 = i12;
                                    i8 = x3;
                                    b(zVar, 2, x3, y3, f3, i13, nanoTime);
                                } else {
                                    i5 = f3;
                                    i6 = y3;
                                    i7 = i12;
                                    i8 = x3;
                                    b(zVar, 4, i8, i6, f3, 0, nanoTime);
                                }
                                zVar.m[i5] = i8 - zVar.k[i5];
                                zVar.n[i5] = i6 - zVar.l[i5];
                                zVar.k[i5] = i8;
                                zVar.l[i5] = i6;
                                zVar.r[i5] = motionEvent.getPressure(i7);
                            }
                            i12 = i7 + 1;
                            i9 = 20;
                        }
                        break;
                    case 3:
                        for (int i14 = 0; i14 < zVar.q.length; i14++) {
                            zVar.q[i14] = -1;
                            zVar.k[i14] = 0;
                            zVar.l[i14] = 0;
                            zVar.m[i14] = 0;
                            zVar.n[i14] = 0;
                            zVar.o[i14] = false;
                            zVar.p[i14] = 0;
                            zVar.r[i14] = 0.0f;
                        }
                        break;
                }
            }
            c.b.b.f.a.getGraphics().c();
        }
    }

    public final void b(z zVar, int i, int i2, int i3, int i4, int i5, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{zVar, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Long.valueOf(j)}) == null) {
            z.f e2 = zVar.f22455g.e();
            e2.a = j;
            e2.f22466h = i4;
            e2.f22461c = i2;
            e2.f22462d = i3;
            e2.f22460b = i;
            e2.f22465g = i5;
            zVar.j.add(e2);
        }
    }

    public boolean c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) ? context.getPackageManager().hasSystemFeature("android.hardware.touchscreen.multitouch") : invokeL.booleanValue;
    }

    public final int d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            if (i == 0 || i == 1) {
                return 0;
            }
            if (i == 2) {
                return 1;
            }
            if (i == 4) {
                return 2;
            }
            if (i == 8) {
                return 3;
            }
            return i == 16 ? 4 : -1;
        }
        return invokeI.intValue;
    }
}
