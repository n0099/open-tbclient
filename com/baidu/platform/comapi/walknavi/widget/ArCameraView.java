package com.baidu.platform.comapi.walknavi.widget;

import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;
import com.baidu.platform.comapi.wnplatform.o.g;
import java.util.List;
/* loaded from: classes2.dex */
public class ArCameraView extends SurfaceView implements SurfaceHolder.Callback {
    public static final int WALK_AR_PERMISSION = 3001;

    /* renamed from: a  reason: collision with root package name */
    public SurfaceHolder f10136a;

    /* renamed from: b  reason: collision with root package name */
    public Camera f10137b;

    /* renamed from: c  reason: collision with root package name */
    public Context f10138c;

    public ArCameraView(Context context) {
        super(context);
        initCameraView(context);
    }

    public static int getBackCameraId() {
        try {
            int numberOfCameras = Camera.getNumberOfCameras();
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i2 = 0; i2 < numberOfCameras; i2++) {
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == 0) {
                    return i2;
                }
            }
            return -1;
        } catch (Exception e2) {
            e2.printStackTrace();
            Log.d("ARCamera", "GetBackCameraID error!");
            return -1;
        }
    }

    private void initCameraView(Context context) {
        try {
            this.f10138c = context;
            SurfaceHolder holder = getHolder();
            this.f10136a = holder;
            holder.addCallback(this);
            this.f10136a.setType(3);
        } catch (Exception e2) {
            e2.printStackTrace();
            Toast.makeText(com.baidu.platform.comapi.wnplatform.o.b.a.a(), "相机出现错误", 0).show();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0033 A[Catch: Exception -> 0x0049, TryCatch #0 {Exception -> 0x0049, blocks: (B:6:0x0006, B:18:0x002f, B:20:0x0033, B:22:0x0044, B:21:0x003d), top: B:27:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003d A[Catch: Exception -> 0x0049, TryCatch #0 {Exception -> 0x0049, blocks: (B:6:0x0006, B:18:0x002f, B:20:0x0033, B:22:0x0044, B:21:0x003d), top: B:27:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean setCameraDisplayOrientation(Activity activity, int i2, Camera camera) {
        int i3;
        int i4;
        if (i2 == -1) {
            return false;
        }
        try {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i2, cameraInfo);
            int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
            if (rotation != 0) {
                if (rotation == 1) {
                    i3 = 90;
                } else if (rotation == 2) {
                    i3 = 180;
                } else if (rotation == 3) {
                    i3 = 270;
                }
                if (cameraInfo.facing != 1) {
                    i4 = (360 - ((cameraInfo.orientation + i3) % 360)) % 360;
                } else {
                    i4 = ((cameraInfo.orientation - i3) + 360) % 360;
                }
                camera.setDisplayOrientation(i4);
                return true;
            }
            i3 = 0;
            if (cameraInfo.facing != 1) {
            }
            camera.setDisplayOrientation(i4);
            return true;
        } catch (Exception e2) {
            Log.d("ARCamera", e2.getMessage());
            return false;
        }
    }

    private void setDisplayOrientation(int i2) {
        try {
            if (this.f10137b != null) {
                this.f10137b.setDisplayOrientation(i2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Camera.Size getBestPreSize(int i2, int i3, List<Camera.Size> list) {
        for (Camera.Size size : list) {
            if (size.width == i2 && size.height == i3) {
                return size;
            }
        }
        float f2 = i2 / i3;
        float f3 = 0.1f;
        Camera.Size size2 = null;
        for (Camera.Size size3 : list) {
            float abs = Math.abs(f2 - (size3.width / size3.height));
            if (abs < f3) {
                size2 = size3;
                f3 = abs;
            }
        }
        if (size2 == null) {
            double d2 = Double.MAX_VALUE;
            for (Camera.Size size4 : list) {
                if (Math.abs(size4.height - i3) < d2) {
                    d2 = Math.abs(size4.height - i3);
                    size2 = size4;
                }
            }
        }
        return size2;
    }

    public void pauseCamera() {
        try {
            if (this.f10137b != null) {
                this.f10137b.stopPreview();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void releaseCamera() {
        try {
            if (this.f10137b != null) {
                try {
                    this.f10137b.setPreviewCallback(null);
                    this.f10137b.stopPreview();
                } catch (Exception unused) {
                }
                try {
                    this.f10137b.release();
                } catch (Exception unused2) {
                }
                this.f10137b = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void resumeCamera() {
        try {
            if (this.f10137b != null) {
                this.f10137b.startPreview();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            Toast.makeText(com.baidu.platform.comapi.wnplatform.o.b.a.a(), "相机出现错误", 0).show();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        if (!setCameraDisplayOrientation((Activity) this.f10138c, getBackCameraId(), this.f10137b)) {
            setDisplayOrientation(90);
        }
        resumeCamera();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Log.e("CameraView", "surfaceCreated");
        try {
            if (this.f10137b == null) {
                this.f10137b = Camera.open();
            }
            Camera.Parameters parameters = this.f10137b.getParameters();
            Camera.Size bestPreSize = getBestPreSize(g.c(this.f10138c), g.b(this.f10138c), parameters.getSupportedPreviewSizes());
            parameters.setPreviewSize(bestPreSize.width, bestPreSize.height);
            if (this.f10137b != null) {
                this.f10137b.setParameters(parameters);
                this.f10137b.setPreviewDisplay(surfaceHolder);
            }
            resumeCamera();
        } catch (Exception e2) {
            e2.printStackTrace();
            Toast.makeText(com.baidu.platform.comapi.wnplatform.o.b.a.a(), "相机出现错误", 0).show();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Log.e("CameraView", "surfaceDestroyed");
        releaseCamera();
    }

    public ArCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initCameraView(context);
    }
}
