package com.baidu.fsg.face.liveness.camera;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Display;
import android.view.SurfaceView;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.baidu.fsg.face.base.d.f;
import com.baidu.fsg.face.liveness.camera.a;
import com.baidu.fsg.face.liveness.camera.b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class LivenessCameraSurfaceView extends SurfaceView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LivenessCameraSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private b.a a(Activity activity, a.C1729a c1729a) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, activity, c1729a)) == null) {
            if (c1729a == null) {
                return null;
            }
            a.C1729a a = a(activity);
            b.a aVar = new b.a(c1729a.a, c1729a.f34824b);
            float f2 = c1729a.a / c1729a.f34824b;
            float f3 = a.f34824b / a.a;
            if (Math.abs(f2 - f3) <= 0.02d) {
                return aVar;
            }
            if (f2 < f3) {
                int i2 = a.f34824b;
                aVar.a = (c1729a.f34824b * i2) / c1729a.a;
                aVar.f34835b = i2;
            } else {
                int i3 = a.a;
                aVar.a = i3;
                aVar.f34835b = (i3 * c1729a.a) / c1729a.f34824b;
            }
            return aVar;
        }
        return (b.a) invokeLL.objValue;
    }

    public void bindSurfaceView(Activity activity, a.C1729a c1729a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, activity, c1729a) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getLayoutParams());
            b.a a = a(activity, c1729a);
            if (a != null && (a.a != c1729a.a || a.f34835b != c1729a.f34824b)) {
                layoutParams.width = a.a;
                layoutParams.height = a.f34835b;
            } else {
                layoutParams.width = -2;
                layoutParams.height = -1;
            }
            setLayoutParams(layoutParams);
        }
    }

    private a.C1729a a(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, activity)) == null) {
            Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
            return new a.C1729a(defaultDisplay.getWidth(), defaultDisplay.getHeight() + f.a(activity));
        }
        return (a.C1729a) invokeL.objValue;
    }
}
