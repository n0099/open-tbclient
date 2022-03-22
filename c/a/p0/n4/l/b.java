package c.a.p0.n4.l;

import android.hardware.Camera;
import android.view.MotionEvent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public float f16738b;

    /* renamed from: c  reason: collision with root package name */
    public int f16739c;

    /* renamed from: d  reason: collision with root package name */
    public Camera f16740d;

    /* renamed from: e  reason: collision with root package name */
    public h f16741e;

    public b(Camera camera) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {camera};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.f16740d = camera;
    }

    public final int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Camera camera = this.f16740d;
            if (camera == null) {
                return -1;
            }
            Camera.Parameters parameters = camera.getParameters();
            if (parameters.isZoomSupported()) {
                if (parameters.getMaxZoom() > 40) {
                    return 40;
                }
                return parameters.getMaxZoom();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public boolean b(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            h hVar = this.f16741e;
            if (hVar == null || !hVar.j()) {
                int action = motionEvent.getAction() & 255;
                if (action == 0) {
                    this.a = 0;
                } else if (action != 2) {
                    if (action == 5) {
                        this.a = 1;
                        this.f16738b = e(motionEvent);
                    }
                } else if (this.a != 1 || motionEvent.getPointerCount() < 2) {
                    return true;
                } else {
                    float e2 = e(motionEvent);
                    int i = (int) ((e2 - this.f16738b) / 10.0f);
                    if (i >= 1 || i <= -1) {
                        int i2 = this.f16739c + i;
                        if (i2 > a()) {
                            i2 = a();
                        }
                        d(i2 >= 0 ? i2 : 0);
                        this.f16738b = e2;
                    }
                }
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void c(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hVar) == null) {
            this.f16741e = hVar;
        }
    }

    public final void d(int i) {
        Camera camera;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i) == null) || (camera = this.f16740d) == null) {
            return;
        }
        Camera.Parameters parameters = camera.getParameters();
        if (parameters.isZoomSupported()) {
            parameters.setZoom(i);
            this.f16740d.setParameters(parameters);
            this.f16739c = i;
        }
    }

    public final float e(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            if (motionEvent == null) {
                return 0.0f;
            }
            double x = motionEvent.getX(0) - motionEvent.getX(1);
            double y = motionEvent.getY(0) - motionEvent.getY(1);
            return (float) Math.sqrt((x * x) + (y * y));
        }
        return invokeL.floatValue;
    }
}
