package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.os.Build;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class CanvasUtils {
    public static /* synthetic */ Interceptable $ic;
    public static Method sInorderBarrierMethod;
    public static boolean sOrderMethodsFetched;
    public static Method sReorderBarrierMethod;
    public transient /* synthetic */ FieldHolder $fh;

    public CanvasUtils() {
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

    @SuppressLint({"SoonBlockedPrivateApi"})
    public static void enableZ(@NonNull Canvas canvas, boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65537, null, canvas, z) == null) || (i2 = Build.VERSION.SDK_INT) < 21) {
            return;
        }
        if (i2 >= 29) {
            if (z) {
                canvas.enableZ();
            } else {
                canvas.disableZ();
            }
        } else if (i2 != 28) {
            if (!sOrderMethodsFetched) {
                try {
                    Method declaredMethod = Canvas.class.getDeclaredMethod("insertReorderBarrier", new Class[0]);
                    sReorderBarrierMethod = declaredMethod;
                    declaredMethod.setAccessible(true);
                    Method declaredMethod2 = Canvas.class.getDeclaredMethod("insertInorderBarrier", new Class[0]);
                    sInorderBarrierMethod = declaredMethod2;
                    declaredMethod2.setAccessible(true);
                } catch (NoSuchMethodException unused) {
                }
                sOrderMethodsFetched = true;
            }
            if (z) {
                try {
                    if (sReorderBarrierMethod != null) {
                        sReorderBarrierMethod.invoke(canvas, new Object[0]);
                    }
                } catch (IllegalAccessException unused2) {
                    return;
                } catch (InvocationTargetException e2) {
                    throw new RuntimeException(e2.getCause());
                }
            }
            if (z || sInorderBarrierMethod == null) {
                return;
            }
            sInorderBarrierMethod.invoke(canvas, new Object[0]);
        } else {
            throw new IllegalStateException("This method doesn't work on Pie!");
        }
    }
}
