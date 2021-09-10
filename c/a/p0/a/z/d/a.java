package c.a.p0.a.z.d;

import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.view.MotionEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlinx.coroutines.DebugKt;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.a.z.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0478a implements Camera.AutoFocusCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f9931a;

        public C0478a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9931a = str;
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z, Camera camera) {
            Camera.Parameters parameters;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZL(1048576, this, z, camera) == null) || camera == null || (parameters = camera.getParameters()) == null) {
                return;
            }
            parameters.setFocusMode(this.f9931a);
            camera.setParameters(parameters);
        }
    }

    public static Rect a(float f2, float f3, float f4, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            int i4 = (int) (((f2 / i2) * 2000.0f) - 1000.0f);
            int i5 = (int) (((f3 / i3) * 2000.0f) - 1000.0f);
            int intValue = Float.valueOf(f4 * 300.0f).intValue() / 2;
            RectF rectF = new RectF(b(i4 - intValue, -1000, 1000), b(i5 - intValue, -1000, 1000), b(i4 + intValue, -1000, 1000), b(i5 + intValue, -1000, 1000));
            return new Rect(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
        }
        return (Rect) invokeCommon.objValue;
    }

    public static int b(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(65537, null, i2, i3, i4)) == null) ? i2 > i4 ? i4 : i2 < i3 ? i3 : i2 : invokeIII.intValue;
    }

    public static String c(Camera.Parameters parameters) {
        InterceptResult invokeL;
        List<String> supportedFocusModes;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, parameters)) == null) {
            if (parameters != null && (supportedFocusModes = parameters.getSupportedFocusModes()) != null) {
                if (supportedFocusModes.contains("macro")) {
                    return "macro";
                }
                if (supportedFocusModes.contains("continuous-picture")) {
                    return "continuous-picture";
                }
            }
            return DebugKt.DEBUG_PROPERTY_VALUE_AUTO;
        }
        return (String) invokeL.objValue;
    }

    public static void d(MotionEvent motionEvent, Camera camera, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLII(65539, null, motionEvent, camera, i2, i3) == null) || motionEvent == null || camera == null) {
            return;
        }
        Rect a2 = a(motionEvent.getX(), motionEvent.getY(), 1.0f, i2, i3);
        camera.cancelAutoFocus();
        Camera.Parameters parameters = camera.getParameters();
        if (parameters == null) {
            return;
        }
        if (parameters.getMaxNumFocusAreas() > 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Camera.Area(a2, 800));
            parameters.setFocusAreas(arrayList);
        }
        String focusMode = parameters.getFocusMode();
        parameters.setFocusMode(c(parameters));
        camera.setParameters(parameters);
        camera.autoFocus(new C0478a(focusMode));
    }
}
