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
import android.view.WindowManager;
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
    public Camera f9602a;

    /* renamed from: b  reason: collision with root package name */
    public SurfaceHolder f9603b;

    /* renamed from: c  reason: collision with root package name */
    public Activity f9604c;

    /* renamed from: d  reason: collision with root package name */
    public int f9605d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f9606e;

    /* renamed from: f  reason: collision with root package name */
    public a.C0115a f9607f;

    /* renamed from: g  reason: collision with root package name */
    public Point f9608g;

    /* renamed from: h  reason: collision with root package name */
    public Path f9609h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f9610i;
    public boolean j;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f9611a;

        /* renamed from: b  reason: collision with root package name */
        public int f9612b;

        public a(int i2, int i3) {
            this.f9611a = i2;
            this.f9612b = i3;
        }
    }

    public CameraPreview(Context context) {
        super(context);
        this.f9606e = true;
        this.f9610i = false;
        this.j = false;
        a(context);
    }

    private void a(Context context) {
        this.f9604c = (Activity) context;
        this.f9609h = new Path();
        this.f9608g = new Point();
        this.f9605d = getCameraID();
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
        Camera.getCameraInfo(this.f9605d, cameraInfo);
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
            if (this.f9602a != null) {
                this.f9602a.setPreviewCallback(null);
                this.f9602a.stopPreview();
                this.f9602a.release();
                this.f9602a = null;
            }
            if (this.f9603b != null) {
                this.f9603b.removeCallback(this);
                this.f9603b = null;
            }
            this.j = false;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void c() {
        try {
            setVisibility(0);
            if (this.f9602a == null) {
                this.f9602a = Camera.open(this.f9605d);
            }
            SurfaceHolder holder = getHolder();
            this.f9603b = holder;
            holder.setFormat(-2);
            this.f9603b.setType(3);
            this.f9603b.addCallback(this);
            this.f9602a.setPreviewDisplay(this.f9603b);
            Camera.Parameters parameters = this.f9602a.getParameters();
            a.C0115a a2 = a(this.f9604c, parameters);
            parameters.setPreviewSize(a2.f9548a, a2.f9549b);
            a(parameters, a2);
            parameters.setJpegQuality(100);
            this.f9602a.setDisplayOrientation(getRotateAngle());
            this.f9602a.setParameters(parameters);
            this.f9602a.startPreview();
            this.j = true;
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    public void draw(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 26) {
            canvas.clipPath(this.f9609h);
        } else {
            canvas.clipPath(this.f9609h, Region.Op.REPLACE);
        }
        super.draw(canvas);
    }

    @TargetApi(9)
    public int getCameraNum() {
        return Camera.getNumberOfCameras();
    }

    public a getCameraSize() {
        Camera camera = this.f9602a;
        if (camera != null) {
            return com.baidu.pass.biometrics.face.liveness.view.face.a.a(this.f9604c, camera.getParameters());
        }
        return null;
    }

    public Camera.Size getPreviewSize() {
        Camera camera = this.f9602a;
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
        Point point = this.f9608g;
        int i4 = size >> 1;
        point.x = i4;
        int i5 = size2 >> 1;
        point.y = i5;
        int min = Math.min(i4, i5);
        this.f9609h.reset();
        Path path = this.f9609h;
        Point point2 = this.f9608g;
        path.addCircle(point2.x, point2.y, min, Path.Direction.CCW);
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Camera camera = this.f9602a;
        if (camera != null && this.j) {
            camera.autoFocus(null);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setPreviewCallback(Camera.PreviewCallback previewCallback) {
        Camera camera = this.f9602a;
        if (camera != null) {
            camera.setPreviewCallback(previewCallback);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        if (this.f9603b.getSurface() != null && (getContext() instanceof Activity)) {
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

    @TargetApi(5)
    public void a(Camera.Parameters parameters, a.C0115a c0115a) {
        int i2;
        int i3;
        float f2 = c0115a != null ? c0115a.f9548a / c0115a.f9549b : 0.0f;
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
        this.f9606e = true;
        this.f9610i = false;
        this.j = false;
        a(context);
    }

    public CameraPreview(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f9606e = true;
        this.f9610i = false;
        this.j = false;
        a(context);
    }

    private a.C0115a b(Activity activity, Camera.Parameters parameters) {
        a.C0115a c0115a = this.f9607f;
        if (c0115a != null) {
            return c0115a;
        }
        List<a.C0115a> c2 = c(activity, parameters);
        this.f9607f = new a.C0115a(640, 480);
        if (c2 != null && c2.size() != 0) {
            ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
            a.C0115a c0115a2 = new a.C0115a(300, 300);
            float f2 = c0115a2.f9549b / c0115a2.f9548a;
            a.C0115a c0115a3 = this.f9607f;
            float f3 = c0115a3.f9548a / c0115a3.f9549b;
            for (int i2 = 0; i2 < c2.size(); i2++) {
                a.C0115a c0115a4 = c2.get(i2);
                float abs = Math.abs((c0115a4.f9548a / c0115a4.f9549b) - f2);
                if (abs < f3) {
                    this.f9607f = c0115a4;
                    f3 = abs;
                }
            }
            return this.f9607f;
        }
        return this.f9607f;
    }

    public a.C0115a a(Activity activity, Camera.Parameters parameters) {
        return b(activity, parameters);
    }

    public boolean a() {
        if (getCameraNum() == 1) {
            this.f9606e = false;
        }
        return this.f9606e;
    }

    public Bitmap a(byte[] bArr) {
        Camera.Size previewSize = this.f9602a.getParameters().getPreviewSize();
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
    private List<a.C0115a> c(Activity activity, Camera.Parameters parameters) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedPreviewSizes == null || supportedPreviewSizes.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < supportedPreviewSizes.size(); i2++) {
            Camera.Size size = supportedPreviewSizes.get(i2);
            arrayList.add(new a.C0115a(size.width, size.height));
        }
        return arrayList;
    }
}
