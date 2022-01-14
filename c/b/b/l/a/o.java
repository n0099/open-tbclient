package c.b.b.l.a;

import android.view.MotionEvent;
import c.b.b.l.a.z;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f27048b;

    public o() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.f27048b = 0;
    }

    public boolean a(MotionEvent motionEvent, z zVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, motionEvent, zVar)) == null) {
            if ((motionEvent.getSource() & 2) == 0) {
                return false;
            }
            int action = motionEvent.getAction() & 255;
            long nanoTime = System.nanoTime();
            synchronized (zVar) {
                if (action == 7) {
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    if (x != this.a || y != this.f27048b) {
                        b(zVar, 4, x, y, 0, 0, nanoTime);
                        this.a = x;
                        this.f27048b = y;
                    }
                } else if (action == 8) {
                    b(zVar, 3, 0, 0, (int) (-Math.signum(motionEvent.getAxisValue(10))), (int) (-Math.signum(motionEvent.getAxisValue(9))), nanoTime);
                }
            }
            c.b.b.f.a.getGraphics().c();
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final void b(z zVar, int i2, int i3, int i4, int i5, int i6, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{zVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Long.valueOf(j2)}) == null) {
            z.f e2 = zVar.k.e();
            e2.a = j2;
            e2.f27074c = i3;
            e2.f27075d = i4;
            e2.f27073b = i2;
            e2.f27076e = i5;
            e2.f27077f = i6;
            zVar.n.add(e2);
        }
    }
}
