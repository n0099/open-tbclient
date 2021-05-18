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
    public Camera f9223a;

    /* renamed from: b  reason: collision with root package name */
    public SurfaceHolder f9224b;

    /* renamed from: c  reason: collision with root package name */
    public Activity f9225c;

    /* renamed from: d  reason: collision with root package name */
    public int f9226d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f9227e;

    /* renamed from: f  reason: collision with root package name */
    public a.C0113a f9228f;

    /* renamed from: g  reason: collision with root package name */
    public Point f9229g;

    /* renamed from: h  reason: collision with root package name */
    public Path f9230h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f9231i;
    public boolean j;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f9232a;

        /* renamed from: b  reason: collision with root package name */
        public int f9233b;

        public a(int i2, int i3) {
            this.f9232a = i2;
            this.f9233b = i3;
        }
    }

    public CameraPreview(Context context) {
        super(context);
        this.f9227e = true;
        this.f9231i = false;
        this.j = false;
        a(context);
    }

    private void a(Context context) {
        this.f9225c = (Activity) context;
        this.f9230h = new Path();
        this.f9229g = new Point();
        this.f9226d = getCameraID();
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
        Camera.getCameraInfo(this.f9226d, cameraInfo);
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
            if (this.f9223a != null) {
                this.f9223a.setPreviewCallback(null);
                this.f9223a.stopPreview();
                this.f9223a.release();
                this.f9223a = null;
            }
            if (this.f9224b != null) {
                this.f9224b.removeCallback(this);
                this.f9224b = null;
            }
            this.j = false;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void c() {
        try {
            setVisibility(0);
            if (this.f9223a == null) {
                this.f9223a = Camera.open(this.f9226d);
            }
            SurfaceHolder holder = getHolder();
            this.f9224b = holder;
            holder.setFormat(-2);
            this.f9224b.setType(3);
            this.f9224b.addCallback(this);
            this.f9223a.setPreviewDisplay(this.f9224b);
            Camera.Parameters parameters = this.f9223a.getParameters();
            a.C0113a a2 = a(this.f9225c, parameters);
            parameters.setPreviewSize(a2.f9169a, a2.f9170b);
            a(parameters, a2);
            parameters.setJpegQuality(100);
            this.f9223a.setDisplayOrientation(getRotateAngle());
            this.f9223a.setParameters(parameters);
            this.f9223a.startPreview();
            this.j = true;
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    public void draw(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 26) {
            canvas.clipPath(this.f9230h);
        } else {
            canvas.clipPath(this.f9230h, Region.Op.REPLACE);
        }
        super.draw(canvas);
    }

    @TargetApi(9)
    public int getCameraNum() {
        return Camera.getNumberOfCameras();
    }

    public a getCameraSize() {
        Camera camera = this.f9223a;
        if (camera != null) {
            return com.baidu.pass.biometrics.face.liveness.view.face.a.a(this.f9225c, camera.getParameters());
        }
        return null;
    }

    public Camera.Size getPreviewSize() {
        Camera camera = this.f9223a;
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
        Point point = this.f9229g;
        int i4 = size >> 1;
        point.x = i4;
        int i5 = size2 >> 1;
        point.y = i5;
        int min = Math.min(i4, i5);
        this.f9230h.reset();
        Path path = this.f9230h;
        Point point2 = this.f9229g;
        path.addCircle(point2.x, point2.y, min, Path.Direction.CCW);
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Camera camera = this.f9223a;
        if (camera != null && this.j) {
            camera.autoFocus(null);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setPreviewCallback(Camera.PreviewCallback previewCallback) {
        Camera camera = this.f9223a;
        if (camera != null) {
            camera.setPreviewCallback(previewCallback);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        if (this.f9224b.getSurface() != null && (getContext() instanceof Activity)) {
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
    public void a(Camera.Parameters parameters, a.C0113a c0113a) {
        int i2;
        int i3;
        float f2 = c0113a != null ? c0113a.f9169a / c0113a.f9170b : 0.0f;
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
        this.f9227e = true;
        this.f9231i = false;
        this.j = false;
        a(context);
    }

    public CameraPreview(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f9227e = true;
        this.f9231i = false;
        this.j = false;
        a(context);
    }

    private a.C0113a b(Activity activity, Camera.Parameters parameters) {
        a.C0113a c0113a = this.f9228f;
        if (c0113a != null) {
            return c0113a;
        }
        List<a.C0113a> c2 = c(activity, parameters);
        this.f9228f = new a.C0113a(640, 480);
        if (c2 != null && c2.size() != 0) {
            ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
            a.C0113a c0113a2 = new a.C0113a(300, 300);
            float f2 = c0113a2.f9170b / c0113a2.f9169a;
            a.C0113a c0113a3 = this.f9228f;
            float f3 = c0113a3.f9169a / c0113a3.f9170b;
            for (int i2 = 0; i2 < c2.size(); i2++) {
                a.C0113a c0113a4 = c2.get(i2);
                float abs = Math.abs((c0113a4.f9169a / c0113a4.f9170b) - f2);
                if (abs < f3) {
                    this.f9228f = c0113a4;
                    f3 = abs;
                }
            }
            return this.f9228f;
        }
        return this.f9228f;
    }

    public a.C0113a a(Activity activity, Camera.Parameters parameters) {
        return b(activity, parameters);
    }

    public boolean a() {
        if (getCameraNum() == 1) {
            this.f9227e = false;
        }
        return this.f9227e;
    }

    public Bitmap a(byte[] bArr) {
        Camera.Size previewSize = this.f9223a.getParameters().getPreviewSize();
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
    private List<a.C0113a> c(Activity activity, Camera.Parameters parameters) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedPreviewSizes == null || supportedPreviewSizes.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < supportedPreviewSizes.size(); i2++) {
            Camera.Size size = supportedPreviewSizes.get(i2);
            arrayList.add(new a.C0113a(size.width, size.height));
        }
        return arrayList;
    }
}
