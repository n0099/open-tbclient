package com.baidu.pass.biometrics.face.liveness.view.face;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.baidu.pass.biometrics.base.utils.PassBioDisplayUtil;
import com.baidu.pass.biometrics.face.liveness.b.a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {
    public static final String k = "CameraPreview";
    public static final int l = 480;
    public static final int m = 640;
    public static final /* synthetic */ boolean n = !CameraPreview.class.desiredAssertionStatus();

    /* renamed from: a  reason: collision with root package name */
    public Camera f9260a;

    /* renamed from: b  reason: collision with root package name */
    public SurfaceHolder f9261b;

    /* renamed from: c  reason: collision with root package name */
    public Activity f9262c;

    /* renamed from: d  reason: collision with root package name */
    public int f9263d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f9264e;

    /* renamed from: f  reason: collision with root package name */
    public a.C0115a f9265f;

    /* renamed from: g  reason: collision with root package name */
    public Point f9266g;

    /* renamed from: h  reason: collision with root package name */
    public Path f9267h;
    public boolean i;
    public boolean j;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f9268a;

        /* renamed from: b  reason: collision with root package name */
        public int f9269b;

        public a(int i, int i2) {
            this.f9268a = i;
            this.f9269b = i2;
        }
    }

    public CameraPreview(Context context) {
        super(context);
        this.f9264e = true;
        this.i = false;
        this.j = false;
        a(context);
    }

    private void a(Context context) {
        this.f9262c = (Activity) context;
        this.f9267h = new Path();
        this.f9266g = new Point();
        this.f9263d = getCameraID();
    }

    private int getCameraID() {
        for (int i = 0; i < Camera.getNumberOfCameras(); i++) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing == 1) {
                return i;
            }
        }
        return 0;
    }

    private int getRotateAngle() {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(this.f9263d, cameraInfo);
        int rotation = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getRotation();
        int i = 0;
        if (rotation != 0) {
            if (rotation == 1) {
                i = 90;
            } else if (rotation == 2) {
                i = 180;
            } else if (rotation == 3) {
                i = 270;
            }
        }
        if (cameraInfo.facing == 1) {
            return (360 - ((cameraInfo.orientation + i) % 360)) % 360;
        }
        return ((cameraInfo.orientation - i) + 360) % 360;
    }

    public synchronized void b() {
        try {
            if (this.f9260a != null) {
                this.f9260a.setPreviewCallback(null);
                this.f9260a.stopPreview();
                this.f9260a.release();
                this.f9260a = null;
            }
            if (this.f9261b != null) {
                this.f9261b.removeCallback(this);
                this.f9261b = null;
            }
            this.j = false;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void c() {
        try {
            setVisibility(0);
            if (this.f9260a == null) {
                this.f9260a = Camera.open(this.f9263d);
            }
            SurfaceHolder holder = getHolder();
            this.f9261b = holder;
            holder.setFormat(-2);
            this.f9261b.setType(3);
            this.f9261b.addCallback(this);
            this.f9260a.setPreviewDisplay(this.f9261b);
            Camera.Parameters parameters = this.f9260a.getParameters();
            a.C0115a a2 = a(this.f9262c, parameters);
            parameters.setPreviewSize(a2.f9209a, a2.f9210b);
            a(parameters, a2);
            parameters.setJpegQuality(100);
            int rotateAngle = getRotateAngle();
            a(rotateAngle);
            this.f9260a.setDisplayOrientation(rotateAngle);
            this.f9260a.setParameters(parameters);
            this.f9260a.startPreview();
            this.j = true;
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    public void draw(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 26) {
            canvas.clipPath(this.f9267h);
        } else {
            canvas.clipPath(this.f9267h, Region.Op.REPLACE);
        }
        super.draw(canvas);
    }

    @TargetApi(9)
    public int getCameraNum() {
        return Camera.getNumberOfCameras();
    }

    public a getCameraSize() {
        Camera camera = this.f9260a;
        if (camera != null) {
            return com.baidu.pass.biometrics.face.liveness.view.face.a.a(this.f9262c, camera.getParameters());
        }
        return null;
    }

    public Camera.Size getPreviewSize() {
        Camera camera = this.f9260a;
        if (camera != null) {
            return camera.getParameters().getPreviewSize();
        }
        return null;
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        Point point = this.f9266g;
        int i3 = size >> 1;
        point.x = i3;
        int i4 = size2 >> 1;
        point.y = i4;
        int min = Math.min(i3, i4);
        this.f9267h.reset();
        Path path = this.f9267h;
        Point point2 = this.f9266g;
        path.addCircle(point2.x, point2.y, min, Path.Direction.CCW);
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Camera camera = this.f9260a;
        if (camera != null && this.j) {
            camera.autoFocus(null);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setPreviewCallback(Camera.PreviewCallback previewCallback) {
        Camera camera = this.f9260a;
        if (camera != null) {
            camera.setPreviewCallback(previewCallback);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (this.f9261b.getSurface() != null && (getContext() instanceof Activity)) {
            c();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        b();
    }

    private void a(int i) {
        if (this.i) {
            return;
        }
        this.i = true;
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getMetrics(new DisplayMetrics());
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (i == 0) {
            layoutParams.height = (layoutParams.width * 3) / 4;
        } else {
            layoutParams.width = (layoutParams.width * 3) / 4;
        }
        setLayoutParams(layoutParams);
    }

    public CameraPreview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9264e = true;
        this.i = false;
        this.j = false;
        a(context);
    }

    public CameraPreview(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9264e = true;
        this.i = false;
        this.j = false;
        a(context);
    }

    private a.C0115a b(Activity activity, Camera.Parameters parameters) {
        a.C0115a c0115a = this.f9265f;
        if (c0115a != null) {
            return c0115a;
        }
        List<a.C0115a> c2 = c(activity, parameters);
        this.f9265f = new a.C0115a(640, 480);
        if (c2 != null && c2.size() != 0) {
            Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
            a.C0115a c0115a2 = new a.C0115a(defaultDisplay.getWidth(), defaultDisplay.getHeight() + PassBioDisplayUtil.getNavigationBarHeight(activity));
            float f2 = c0115a2.f9210b / c0115a2.f9209a;
            a.C0115a c0115a3 = this.f9265f;
            float f3 = c0115a3.f9209a / c0115a3.f9210b;
            for (int i = 0; i < c2.size(); i++) {
                a.C0115a c0115a4 = c2.get(i);
                float abs = Math.abs((c0115a4.f9209a / c0115a4.f9210b) - f2);
                if (abs < f3) {
                    this.f9265f = c0115a4;
                    f3 = abs;
                }
            }
            return this.f9265f;
        }
        return this.f9265f;
    }

    @TargetApi(5)
    public void a(Camera.Parameters parameters, a.C0115a c0115a) {
        int i;
        int i2;
        float f2 = c0115a != null ? c0115a.f9209a / c0115a.f9210b : 0.0f;
        List<Camera.Size> supportedPictureSizes = parameters.getSupportedPictureSizes();
        if (supportedPictureSizes == null) {
            return;
        }
        int size = supportedPictureSizes.size();
        Camera.Size size2 = null;
        Camera.Size size3 = null;
        for (int i3 = 0; i3 < size; i3++) {
            Camera.Size size4 = supportedPictureSizes.get(i3);
            if (size3 == null || ((i = size4.width) >= size3.width && (i2 = size4.height) >= size3.height && i * i2 < 5000000)) {
                size3 = size4;
            }
            if (f2 > 0.0f && Math.abs((size4.width / size4.height) - f2) < 0.15f) {
                int i4 = size4.width;
                int i5 = size4.height;
                if (i4 * i5 < 7000000 && (size2 == null || (i4 > size2.width && i5 > size2.height))) {
                    size2 = size4;
                }
            }
        }
        if (size2 == null) {
            size2 = size3;
        }
        if (!n && size2 == null) {
            throw new AssertionError();
        }
        parameters.setPictureSize(size2.width, size2.height);
    }

    @TargetApi(5)
    private List<a.C0115a> c(Activity activity, Camera.Parameters parameters) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedPreviewSizes == null || supportedPreviewSizes.size() == 0) {
            return null;
        }
        Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
        a.C0115a c0115a = new a.C0115a(defaultDisplay.getWidth(), defaultDisplay.getHeight() + PassBioDisplayUtil.getNavigationBarHeight(activity));
        int i = 153600;
        int i2 = 921600;
        int i3 = c0115a.f9209a * c0115a.f9210b;
        if (i3 / 4 > 921600) {
            i2 = 2073600;
            i = i3 / 8;
        }
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < supportedPreviewSizes.size(); i4++) {
            Camera.Size size = supportedPreviewSizes.get(i4);
            int i5 = size.width;
            int i6 = size.height;
            int i7 = i5 * i6;
            if (i7 >= i && i7 <= i2) {
                arrayList.add(new a.C0115a(i5, i6));
            }
        }
        return arrayList;
    }

    public a.C0115a a(Activity activity, Camera.Parameters parameters) {
        return b(activity, parameters);
    }

    public boolean a() {
        if (getCameraNum() == 1) {
            this.f9264e = false;
        }
        return this.f9264e;
    }

    public Bitmap a(byte[] bArr) {
        Camera.Size previewSize = this.f9260a.getParameters().getPreviewSize();
        YuvImage yuvImage = new YuvImage(bArr, 17, previewSize.width, previewSize.height, null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        yuvImage.compressToJpeg(new Rect(0, 0, previewSize.width, previewSize.height), 80, byteArrayOutputStream);
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
        Matrix matrix = new Matrix();
        matrix.reset();
        matrix.setRotate(-90.0f);
        matrix.postScale(-1.0f, 1.0f);
        Bitmap copy = Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix, true).copy(Bitmap.Config.RGB_565, true);
        try {
            byteArrayOutputStream.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return copy;
    }
}
