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
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes5.dex */
public class CameraSurfaceView extends SurfaceView {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: e  reason: collision with root package name */
    public static final String f44137e = "CameraPreview";

    /* renamed from: f  reason: collision with root package name */
    public static final int f44138f = 480;

    /* renamed from: g  reason: collision with root package name */
    public static final int f44139g = 640;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f44140a;

    /* renamed from: b  reason: collision with root package name */
    public a f44141b;

    /* renamed from: c  reason: collision with root package name */
    public Point f44142c;

    /* renamed from: d  reason: collision with root package name */
    public Path f44143d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraSurfaceView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a(context);
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, context) == null) {
            this.f44143d = new Path();
            this.f44142c = new Point();
        }
    }

    @TargetApi(5)
    private List<a> b(Camera.Parameters parameters) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, parameters)) == null) {
            List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
            if (supportedPreviewSizes == null || supportedPreviewSizes.size() == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < supportedPreviewSizes.size(); i2++) {
                Camera.Size size = supportedPreviewSizes.get(i2);
                if (size.height <= 1000 && size.width <= 1000) {
                    arrayList.add(new a(size));
                }
            }
            if (arrayList.isEmpty()) {
                for (int i3 = 0; i3 < supportedPreviewSizes.size(); i3++) {
                    arrayList.add(new a(supportedPreviewSizes.get(i3)));
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Override // android.view.SurfaceView, android.view.View
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                canvas.clipPath(this.f44143d);
            } else {
                canvas.clipPath(this.f44143d, Region.Op.REPLACE);
            }
            super.draw(canvas);
        }
    }

    public int getRotateAngle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(this.f44140a, cameraInfo);
            int rotation = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getRotation();
            int i2 = 0;
            if (rotation != 0) {
                if (rotation == 1) {
                    i2 = 90;
                } else if (rotation == 2) {
                    i2 = 180;
                } else if (rotation == 3) {
                    i2 = 270;
                }
            }
            if (cameraInfo.facing == 1) {
                return (360 - ((cameraInfo.orientation + i2) % 360)) % 360;
            }
            return ((cameraInfo.orientation - i2) + 360) % 360;
        }
        return invokeV.intValue;
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            int size = View.MeasureSpec.getSize(i2);
            int size2 = View.MeasureSpec.getSize(i3);
            Point point = this.f44142c;
            int i4 = size >> 1;
            point.x = i4;
            int i5 = size2 >> 1;
            point.y = i5;
            int min = Math.min(i4, i5);
            this.f44143d.reset();
            Path path = this.f44143d;
            Point point2 = this.f44142c;
            path.addCircle(point2.x, point2.y, min, Path.Direction.CCW);
            setMeasuredDimension(size, size2);
        }
    }

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f44144a;

        /* renamed from: b  reason: collision with root package name */
        public int f44145b;

        public a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44144a = i2;
            this.f44145b = i3;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "CameraSize{width=" + this.f44144a + ", height=" + this.f44145b + ExtendedMessageFormat.END_FE;
            }
            return (String) invokeV.objValue;
        }

        public a(Camera.Size size) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {size};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f44144a = size.width;
            this.f44145b = size.height;
        }
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a(context);
    }

    public a a(Camera.Parameters parameters) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parameters)) == null) {
            a aVar = this.f44141b;
            if (aVar != null) {
                return aVar;
            }
            List<a> b2 = b(parameters);
            this.f44141b = new a(640, 480);
            if (b2 != null && b2.size() != 0) {
                float f2 = 2.0f;
                float f3 = 1.0f;
                for (a aVar2 : b2) {
                    ViewGroup.LayoutParams layoutParams = getLayoutParams();
                    float f4 = aVar2.f44145b;
                    float f5 = f4 / layoutParams.width;
                    float f6 = aVar2.f44144a / f4;
                    if (f6 >= 1.0f && f6 <= f2 && f5 >= f3) {
                        this.f44141b = aVar2;
                        f3 = f5;
                        f2 = f6;
                    }
                }
                if (this.f44141b == null) {
                    this.f44141b = new a(640, 480);
                }
                return this.f44141b;
            }
            return this.f44141b;
        }
        return (a) invokeL.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraSurfaceView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        a(context);
    }
}
