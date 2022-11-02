package com.baidu.pass.biometrics.face.liveness.view.face;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Region;
import android.hardware.Camera;
import android.os.Build;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class CameraSurfaceView extends SurfaceView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String e = "CameraPreview";
    public static final int f = 480;
    public static final int g = 640;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public a b;
    public Point c;
    public Path d;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;

        public a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.b = i2;
        }

        public a(Camera.Size size) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {size};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = size.width;
            this.b = size.height;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "CameraSize{width=" + this.a + ", height=" + this.b + '}';
            }
            return (String) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraSurfaceView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a(context);
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            super.onMeasure(i, i2);
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            Point point = this.c;
            int i3 = size >> 1;
            point.x = i3;
            int i4 = size2 >> 1;
            point.y = i4;
            int min = Math.min(i3, i4);
            this.d.reset();
            Path path = this.d;
            Point point2 = this.c;
            path.addCircle(point2.x, point2.y, min, Path.Direction.CCW);
            setMeasuredDimension(size, size2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        a(context);
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, context) == null) {
            this.d = new Path();
            this.c = new Point();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                canvas.clipPath(this.d);
            } else {
                canvas.clipPath(this.d, Region.Op.REPLACE);
            }
            super.draw(canvas);
        }
    }

    @TargetApi(5)
    private List<a> b(Camera.Parameters parameters) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, parameters)) == null) {
            List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
            if (supportedPreviewSizes != null && supportedPreviewSizes.size() != 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < supportedPreviewSizes.size(); i++) {
                    Camera.Size size = supportedPreviewSizes.get(i);
                    if (size.height <= 1000 && size.width <= 1000) {
                        arrayList.add(new a(size));
                    }
                }
                if (arrayList.isEmpty()) {
                    for (int i2 = 0; i2 < supportedPreviewSizes.size(); i2++) {
                        arrayList.add(new a(supportedPreviewSizes.get(i2)));
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public a a(Camera.Parameters parameters) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parameters)) == null) {
            a aVar = this.b;
            if (aVar != null) {
                return aVar;
            }
            List<a> b = b(parameters);
            this.b = new a(640, 480);
            if (b != null && b.size() != 0) {
                float f2 = 2.0f;
                float f3 = 1.0f;
                for (a aVar2 : b) {
                    ViewGroup.LayoutParams layoutParams = getLayoutParams();
                    float f4 = aVar2.b;
                    float f5 = f4 / layoutParams.width;
                    float f6 = aVar2.a / f4;
                    if (f6 >= 1.0f && f6 <= f2 && f5 >= f3) {
                        this.b = aVar2;
                        f3 = f5;
                        f2 = f6;
                    }
                }
                if (this.b == null) {
                    this.b = new a(640, 480);
                }
                return this.b;
            }
            return this.b;
        }
        return (a) invokeL.objValue;
    }

    public int getRotateAngle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(this.a, cameraInfo);
            int rotation = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getRotation();
            int i = 0;
            if (rotation != 0) {
                if (rotation != 1) {
                    if (rotation != 2) {
                        if (rotation == 3) {
                            i = 270;
                        }
                    } else {
                        i = 180;
                    }
                } else {
                    i = 90;
                }
            }
            if (cameraInfo.facing == 1) {
                return (360 - ((cameraInfo.orientation + i) % 360)) % 360;
            }
            return ((cameraInfo.orientation - i) + 360) % 360;
        }
        return invokeV.intValue;
    }
}
