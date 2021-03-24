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
    public SurfaceHolder f10214a;

    /* renamed from: b  reason: collision with root package name */
    public Camera f10215b;

    /* renamed from: c  reason: collision with root package name */
    public Context f10216c;

    public ArCameraView(Context context) {
        super(context);
        initCameraView(context);
    }

    public static int getBackCameraId() {
        try {
            int numberOfCameras = Camera.getNumberOfCameras();
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i = 0; i < numberOfCameras; i++) {
                Camera.getCameraInfo(i, cameraInfo);
                if (cameraInfo.facing == 0) {
                    return i;
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
            this.f10216c = context;
            SurfaceHolder holder = getHolder();
            this.f10214a = holder;
            holder.addCallback(this);
            this.f10214a.setType(3);
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
    public static boolean setCameraDisplayOrientation(Activity activity, int i, Camera camera) {
        int i2;
        int i3;
        if (i == -1) {
            return false;
        }
        try {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i, cameraInfo);
            int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
            if (rotation != 0) {
                if (rotation == 1) {
                    i2 = 90;
                } else if (rotation == 2) {
                    i2 = 180;
                } else if (rotation == 3) {
                    i2 = 270;
                }
                if (cameraInfo.facing != 1) {
                    i3 = (360 - ((cameraInfo.orientation + i2) % 360)) % 360;
                } else {
                    i3 = ((cameraInfo.orientation - i2) + 360) % 360;
                }
                camera.setDisplayOrientation(i3);
                return true;
            }
            i2 = 0;
            if (cameraInfo.facing != 1) {
            }
            camera.setDisplayOrientation(i3);
            return true;
        } catch (Exception e2) {
            Log.d("ARCamera", e2.getMessage());
            return false;
        }
    }

    private void setDisplayOrientation(int i) {
        try {
            if (this.f10215b != null) {
                this.f10215b.setDisplayOrientation(i);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Camera.Size getBestPreSize(int i, int i2, List<Camera.Size> list) {
        for (Camera.Size size : list) {
            if (size.width == i && size.height == i2) {
                return size;
            }
        }
        float f2 = i / i2;
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
                if (Math.abs(size4.height - i2) < d2) {
                    d2 = Math.abs(size4.height - i2);
                    size2 = size4;
                }
            }
        }
        return size2;
    }

    public void pauseCamera() {
        try {
            if (this.f10215b != null) {
                this.f10215b.stopPreview();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void releaseCamera() {
        try {
            if (this.f10215b != null) {
                try {
                    this.f10215b.setPreviewCallback(null);
                    this.f10215b.stopPreview();
                } catch (Exception unused) {
                }
                try {
                    this.f10215b.release();
                } catch (Exception unused2) {
                }
                this.f10215b = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void resumeCamera() {
        try {
            if (this.f10215b != null) {
                this.f10215b.startPreview();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            Toast.makeText(com.baidu.platform.comapi.wnplatform.o.b.a.a(), "相机出现错误", 0).show();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (!setCameraDisplayOrientation((Activity) this.f10216c, getBackCameraId(), this.f10215b)) {
            setDisplayOrientation(90);
        }
        resumeCamera();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Log.e("CameraView", "surfaceCreated");
        try {
            if (this.f10215b == null) {
                this.f10215b = Camera.open();
            }
            Camera.Parameters parameters = this.f10215b.getParameters();
            Camera.Size bestPreSize = getBestPreSize(g.c(this.f10216c), g.b(this.f10216c), parameters.getSupportedPreviewSizes());
            parameters.setPreviewSize(bestPreSize.width, bestPreSize.height);
            if (this.f10215b != null) {
                this.f10215b.setParameters(parameters);
                this.f10215b.setPreviewDisplay(surfaceHolder);
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
