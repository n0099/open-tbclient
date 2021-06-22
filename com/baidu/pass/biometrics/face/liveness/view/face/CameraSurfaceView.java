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

    /* renamed from: e  reason: collision with root package name */
    public static final String f9179e = "CameraPreview";

    /* renamed from: f  reason: collision with root package name */
    public static final int f9180f = 480;

    /* renamed from: g  reason: collision with root package name */
    public static final int f9181g = 640;

    /* renamed from: a  reason: collision with root package name */
    public int f9182a;

    /* renamed from: b  reason: collision with root package name */
    public a f9183b;

    /* renamed from: c  reason: collision with root package name */
    public Point f9184c;

    /* renamed from: d  reason: collision with root package name */
    public Path f9185d;

    public CameraSurfaceView(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        this.f9185d = new Path();
        this.f9184c = new Point();
    }

    @TargetApi(5)
    private List<a> b(Camera.Parameters parameters) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedPreviewSizes == null || supportedPreviewSizes.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < supportedPreviewSizes.size(); i2++) {
            arrayList.add(new a(supportedPreviewSizes.get(i2)));
        }
        return arrayList;
    }

    @Override // android.view.SurfaceView, android.view.View
    public void draw(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 26) {
            canvas.clipPath(this.f9185d);
        } else {
            canvas.clipPath(this.f9185d, Region.Op.REPLACE);
        }
        super.draw(canvas);
    }

    public int getRotateAngle() {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(this.f9182a, cameraInfo);
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

    @Override // android.view.SurfaceView, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        Point point = this.f9184c;
        int i4 = size >> 1;
        point.x = i4;
        int i5 = size2 >> 1;
        point.y = i5;
        int min = Math.min(i4, i5);
        this.f9185d.reset();
        Path path = this.f9185d;
        Point point2 = this.f9184c;
        path.addCircle(point2.x, point2.y, min, Path.Direction.CCW);
        setMeasuredDimension(size, size2);
    }

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f9186a;

        /* renamed from: b  reason: collision with root package name */
        public int f9187b;

        public a(int i2, int i3) {
            this.f9186a = i2;
            this.f9187b = i3;
        }

        public a(Camera.Size size) {
            this.f9186a = size.width;
            this.f9187b = size.height;
        }
    }

    public CameraSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public a a(Camera.Parameters parameters) {
        a aVar = this.f9183b;
        if (aVar != null) {
            return aVar;
        }
        List<a> b2 = b(parameters);
        this.f9183b = new a(640, 480);
        if (b2 != null && b2.size() != 0) {
            float f2 = 2.0f;
            float f3 = 1.0f;
            for (a aVar2 : b2) {
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                float f4 = aVar2.f9187b;
                float f5 = f4 / layoutParams.width;
                float f6 = aVar2.f9186a / f4;
                if (f6 >= 1.0f && f6 <= f2 && f5 >= f3) {
                    this.f9183b = aVar2;
                    f3 = f5;
                    f2 = f6;
                }
            }
            if (this.f9183b == null) {
                this.f9183b = new a(640, 480);
            }
            return this.f9183b;
        }
        return this.f9183b;
    }

    public CameraSurfaceView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }
}
