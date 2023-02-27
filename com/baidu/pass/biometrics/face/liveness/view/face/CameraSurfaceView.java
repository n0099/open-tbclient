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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class CameraSurfaceView extends SurfaceView {
    public static final String e = "CameraPreview";
    public static final int f = 480;
    public static final int g = 640;
    public int a;
    public a b;
    public Point c;
    public Path d;

    /* loaded from: classes2.dex */
    public static class a {
        public int a;
        public int b;

        public a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        public a(Camera.Size size) {
            this.a = size.width;
            this.b = size.height;
        }

        public String toString() {
            return "CameraSize{width=" + this.a + ", height=" + this.b + '}';
        }
    }

    public CameraSurfaceView(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        this.d = new Path();
        this.c = new Point();
    }

    @Override // android.view.SurfaceView, android.view.View
    public void draw(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 26) {
            canvas.clipPath(this.d);
        } else {
            canvas.clipPath(this.d, Region.Op.REPLACE);
        }
        super.draw(canvas);
    }

    public CameraSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onMeasure(int i, int i2) {
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

    public CameraSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    @TargetApi(5)
    private List<a> b(Camera.Parameters parameters) {
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

    public a a(Camera.Parameters parameters) {
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

    public int getRotateAngle() {
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
}
