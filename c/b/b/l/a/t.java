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
/* loaded from: classes9.dex */
public class t {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public t() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a(MotionEvent motionEvent, z zVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, motionEvent, zVar) == null) {
            int action = motionEvent.getAction() & 255;
            int action2 = (motionEvent.getAction() & 65280) >> 8;
            int pointerId = motionEvent.getPointerId(action2);
            long nanoTime = System.nanoTime();
            synchronized (zVar) {
                int i10 = 20;
                switch (action) {
                    case 0:
                    case 5:
                        int e2 = zVar.e();
                        if (e2 >= 20) {
                            break;
                        } else {
                            zVar.u[e2] = pointerId;
                            int x = (int) motionEvent.getX(action2);
                            int y = (int) motionEvent.getY(action2);
                            int d2 = d(motionEvent.getButtonState());
                            if (d2 != -1) {
                                i2 = d2;
                                i3 = x;
                                i4 = y;
                                b(zVar, 0, x, y, e2, i2, nanoTime);
                            } else {
                                i2 = d2;
                                i3 = x;
                                i4 = y;
                            }
                            zVar.o[e2] = i3;
                            zVar.p[e2] = i4;
                            zVar.q[e2] = 0;
                            zVar.r[e2] = 0;
                            int i11 = i2;
                            zVar.s[e2] = i11 != -1;
                            zVar.t[e2] = i11;
                            zVar.v[e2] = motionEvent.getPressure(action2);
                            break;
                        }
                    case 1:
                    case 4:
                    case 6:
                        int i12 = zVar.i(pointerId);
                        if (i12 != -1 && i12 < 20) {
                            zVar.u[i12] = -1;
                            int x2 = (int) motionEvent.getX(action2);
                            int y2 = (int) motionEvent.getY(action2);
                            int i13 = zVar.t[i12];
                            if (i13 != -1) {
                                i5 = x2;
                                b(zVar, 1, x2, y2, i12, i13, nanoTime);
                            } else {
                                i5 = x2;
                            }
                            zVar.o[i12] = i5;
                            zVar.p[i12] = y2;
                            zVar.q[i12] = 0;
                            zVar.r[i12] = 0;
                            zVar.s[i12] = false;
                            zVar.t[i12] = 0;
                            zVar.v[i12] = 0.0f;
                            break;
                        }
                        break;
                    case 2:
                        int pointerCount = motionEvent.getPointerCount();
                        int i14 = 0;
                        while (i14 < pointerCount) {
                            int pointerId2 = motionEvent.getPointerId(i14);
                            int x3 = (int) motionEvent.getX(i14);
                            int y3 = (int) motionEvent.getY(i14);
                            int i15 = zVar.i(pointerId2);
                            if (i15 == -1) {
                                i8 = i14;
                            } else if (i15 >= i10) {
                                break;
                            } else {
                                int i16 = zVar.t[i15];
                                if (i16 != -1) {
                                    i6 = i15;
                                    i7 = y3;
                                    i8 = i14;
                                    i9 = x3;
                                    b(zVar, 2, x3, y3, i15, i16, nanoTime);
                                } else {
                                    i6 = i15;
                                    i7 = y3;
                                    i8 = i14;
                                    i9 = x3;
                                    b(zVar, 4, i9, i7, i15, 0, nanoTime);
                                }
                                zVar.q[i6] = i9 - zVar.o[i6];
                                zVar.r[i6] = i7 - zVar.p[i6];
                                zVar.o[i6] = i9;
                                zVar.p[i6] = i7;
                                zVar.v[i6] = motionEvent.getPressure(i8);
                            }
                            i14 = i8 + 1;
                            i10 = 20;
                        }
                        break;
                    case 3:
                        for (int i17 = 0; i17 < zVar.u.length; i17++) {
                            zVar.u[i17] = -1;
                            zVar.o[i17] = 0;
                            zVar.p[i17] = 0;
                            zVar.q[i17] = 0;
                            zVar.r[i17] = 0;
                            zVar.s[i17] = false;
                            zVar.t[i17] = 0;
                            zVar.v[i17] = 0.0f;
                        }
                        break;
                }
            }
            c.b.b.f.a.getGraphics().c();
        }
    }

    public final void b(z zVar, int i2, int i3, int i4, int i5, int i6, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{zVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Long.valueOf(j2)}) == null) {
            z.f e2 = zVar.k.e();
            e2.a = j2;
            e2.f27313h = i5;
            e2.f27308c = i3;
            e2.f27309d = i4;
            e2.f27307b = i2;
            e2.f27312g = i6;
            zVar.n.add(e2);
        }
    }

    public boolean c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) ? context.getPackageManager().hasSystemFeature("android.hardware.touchscreen.multitouch") : invokeL.booleanValue;
    }

    public final int d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            if (i2 == 0 || i2 == 1) {
                return 0;
            }
            if (i2 == 2) {
                return 1;
            }
            if (i2 == 4) {
                return 2;
            }
            if (i2 == 8) {
                return 3;
            }
            return i2 == 16 ? 4 : -1;
        }
        return invokeI.intValue;
    }
}
