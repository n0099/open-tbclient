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
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
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
    public Camera f9182a;

    /* renamed from: b  reason: collision with root package name */
    public SurfaceHolder f9183b;

    /* renamed from: c  reason: collision with root package name */
    public Activity f9184c;

    /* renamed from: d  reason: collision with root package name */
    public int f9185d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f9186e;

    /* renamed from: f  reason: collision with root package name */
    public a f9187f;

    /* renamed from: g  reason: collision with root package name */
    public Point f9188g;

    /* renamed from: h  reason: collision with root package name */
    public Path f9189h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f9190i;
    public boolean j;

    public CameraPreview(Context context) {
        super(context);
        this.f9186e = true;
        this.f9190i = false;
        this.j = false;
        a(context);
    }

    private void a(Context context) {
        this.f9184c = (Activity) context;
        this.f9189h = new Path();
        this.f9188g = new Point();
        this.f9185d = getCameraID();
    }

    private int getCameraID() {
        for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i2, cameraInfo);
            if (cameraInfo.facing == 1) {
                return i2;
            }
        }
        return 0;
    }

    private int getRotateAngle() {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(this.f9185d, cameraInfo);
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

    public synchronized void b() {
        try {
            if (this.f9182a != null) {
                this.f9182a.setPreviewCallback(null);
                this.f9182a.stopPreview();
                this.f9182a.release();
                this.f9182a = null;
            }
            if (this.f9183b != null) {
                this.f9183b.removeCallback(this);
                this.f9183b = null;
            }
            this.j = false;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void c() {
        try {
            setVisibility(0);
            if (this.f9182a == null) {
                this.f9182a = Camera.open(this.f9185d);
            }
            SurfaceHolder holder = getHolder();
            this.f9183b = holder;
            holder.setFormat(-2);
            this.f9183b.setType(3);
            this.f9183b.addCallback(this);
            this.f9182a.setPreviewDisplay(this.f9183b);
            Camera.Parameters parameters = this.f9182a.getParameters();
            a a2 = a(this.f9184c, parameters);
            parameters.setPreviewSize(a2.f9191a, a2.f9192b);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            layoutParams.height = (int) (a2.f9191a * (layoutParams.width / a2.f9192b));
            setLayoutParams(layoutParams);
            parameters.setJpegQuality(100);
            this.f9182a.setDisplayOrientation(getRotateAngle());
            this.f9182a.setParameters(parameters);
            this.f9182a.startPreview();
            this.j = true;
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    public void draw(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 26) {
            canvas.clipPath(this.f9189h);
        } else {
            canvas.clipPath(this.f9189h, Region.Op.REPLACE);
        }
        super.draw(canvas);
    }

    @TargetApi(9)
    public int getCameraNum() {
        return Camera.getNumberOfCameras();
    }

    public Camera.Size getPreviewSize() {
        Camera camera = this.f9182a;
        if (camera != null) {
            return camera.getParameters().getPreviewSize();
        }
        return null;
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        Point point = this.f9188g;
        int i4 = size >> 1;
        point.x = i4;
        int i5 = size2 >> 1;
        point.y = i5;
        int min = Math.min(i4, i5);
        this.f9189h.reset();
        Path path = this.f9189h;
        Point point2 = this.f9188g;
        path.addCircle(point2.x, point2.y, min, Path.Direction.CCW);
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Camera camera = this.f9182a;
        if (camera != null && this.j) {
            camera.autoFocus(null);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setPreviewCallback(Camera.PreviewCallback previewCallback) {
        Camera camera = this.f9182a;
        if (camera != null) {
            camera.setPreviewCallback(previewCallback);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        if (this.f9183b.getSurface() != null && (getContext() instanceof Activity)) {
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

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f9191a;

        /* renamed from: b  reason: collision with root package name */
        public int f9192b;

        public a(int i2, int i3) {
            this.f9191a = i2;
            this.f9192b = i3;
        }

        public a(Camera.Size size) {
            this.f9191a = size.width;
            this.f9192b = size.height;
        }
    }

    @TargetApi(5)
    public void a(Camera.Parameters parameters, a aVar) {
        int i2;
        int i3;
        float f2 = aVar != null ? aVar.f9191a / aVar.f9192b : 0.0f;
        List<Camera.Size> supportedPictureSizes = parameters.getSupportedPictureSizes();
        if (supportedPictureSizes == null) {
            return;
        }
        int size = supportedPictureSizes.size();
        Camera.Size size2 = null;
        Camera.Size size3 = null;
        for (int i4 = 0; i4 < size; i4++) {
            Camera.Size size4 = supportedPictureSizes.get(i4);
            if (size3 == null || ((i2 = size4.width) >= size3.width && (i3 = size4.height) >= size3.height && i2 * i3 < 5000000)) {
                size3 = size4;
            }
            if (f2 > 0.0f && Math.abs((size4.width / size4.height) - f2) < 0.15f) {
                int i5 = size4.width;
                int i6 = size4.height;
                if (i5 * i6 < 7000000 && (size2 == null || (i5 > size2.width && i6 > size2.height))) {
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

    public CameraPreview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9186e = true;
        this.f9190i = false;
        this.j = false;
        a(context);
    }

    public CameraPreview(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f9186e = true;
        this.f9190i = false;
        this.j = false;
        a(context);
    }

    private a b(Activity activity, Camera.Parameters parameters) {
        a aVar = this.f9187f;
        if (aVar != null) {
            return aVar;
        }
        List<a> c2 = c(activity, parameters);
        this.f9187f = new a(640, 480);
        if (c2 != null && c2.size() != 0) {
            float f2 = 2.0f;
            float f3 = 1.0f;
            for (a aVar2 : c2) {
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                float f4 = aVar2.f9192b;
                float f5 = f4 / layoutParams.width;
                float f6 = aVar2.f9191a / f4;
                if (f6 >= 1.0f && f6 <= f2 && f5 >= f3) {
                    this.f9187f = aVar2;
                    f3 = f5;
                    f2 = f6;
                }
            }
            if (this.f9187f == null) {
                this.f9187f = new a(640, 480);
            }
            return this.f9187f;
        }
        return this.f9187f;
    }

    public a a(Activity activity, Camera.Parameters parameters) {
        return b(activity, parameters);
    }

    public boolean a() {
        if (getCameraNum() == 1) {
            this.f9186e = false;
        }
        return this.f9186e;
    }

    public Bitmap a(byte[] bArr) {
        Camera.Size previewSize = this.f9182a.getParameters().getPreviewSize();
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

    @TargetApi(5)
    private List<a> c(Activity activity, Camera.Parameters parameters) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedPreviewSizes == null || supportedPreviewSizes.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < supportedPreviewSizes.size(); i2++) {
            Camera.Size size = supportedPreviewSizes.get(i2);
            arrayList.add(new a(size.width, size.height));
        }
        return arrayList;
    }
}
