package com.baidu.platform.comapi.walknavi.widget;

import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;
import com.baidu.searchbox.ng.ai.apps.view.container.AiAppsNAViewType;
/* loaded from: classes4.dex */
public class ArCameraView extends SurfaceView implements SurfaceHolder.Callback {
    public static final int WALK_AR_PERMISSION = 3001;
    SurfaceHolder a;
    Camera b;
    private Context c;

    public ArCameraView(Context context) {
        super(context);
        initCameraView(context);
    }

    public ArCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initCameraView(context);
    }

    private void initCameraView(Context context) {
        try {
            this.c = context;
            this.a = getHolder();
            this.a.addCallback(this);
            this.a.setType(3);
            long currentTimeMillis = System.currentTimeMillis();
            this.b = Camera.open();
            Log.e("CameraView", "open end:" + (System.currentTimeMillis() - currentTimeMillis));
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(com.baidu.platform.comapi.wnplatform.o.b.a.a(), "相机出现错误", 0).show();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Log.e("CameraView", "surfaceCreated");
        try {
            if (this.b == null) {
                this.b = Camera.open();
            }
            if (this.b != null) {
                this.b.setPreviewDisplay(surfaceHolder);
            }
            resumeCamera();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(com.baidu.platform.comapi.wnplatform.o.b.a.a(), "相机出现错误", 0).show();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (!setCameraDisplayOrientation((Activity) this.c, getBackCameraId(), this.b)) {
            setDisplayOrientation(90);
        }
        resumeCamera();
    }

    public static boolean setCameraDisplayOrientation(Activity activity, int i, Camera camera) {
        int i2;
        int i3;
        boolean z = true;
        if (i == -1) {
            return false;
        }
        try {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i, cameraInfo);
            switch (activity.getWindowManager().getDefaultDisplay().getRotation()) {
                case 0:
                    i2 = 0;
                    break;
                case 1:
                    i2 = 90;
                    break;
                case 2:
                    i2 = 180;
                    break;
                case 3:
                    i2 = 270;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            if (cameraInfo.facing == 1) {
                i3 = (360 - ((i2 + cameraInfo.orientation) % 360)) % 360;
            } else {
                i3 = ((cameraInfo.orientation - i2) + 360) % 360;
            }
            camera.setDisplayOrientation(i3);
        } catch (Exception e) {
            Log.d(AiAppsNAViewType.ARCAMERA, e.getMessage());
            z = false;
        }
        return z;
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
        } catch (Exception e) {
            e.printStackTrace();
            Log.d(AiAppsNAViewType.ARCAMERA, "GetBackCameraID error!");
        }
        return -1;
    }

    private void setDisplayOrientation(int i) {
        try {
            if (this.b != null) {
                this.b.setDisplayOrientation(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Log.e("CameraView", "surfaceDestroyed");
        releaseCamera();
    }

    public void resumeCamera() {
        try {
            if (this.b != null) {
                this.b.startPreview();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(com.baidu.platform.comapi.wnplatform.o.b.a.a(), "相机出现错误", 0).show();
        }
    }

    public void pauseCamera() {
        try {
            if (this.b != null) {
                this.b.stopPreview();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void releaseCamera() {
        try {
            if (this.b != null) {
                try {
                    this.b.setPreviewCallback(null);
                    this.b.stopPreview();
                } catch (Exception e) {
                }
                try {
                    this.b.release();
                } catch (Exception e2) {
                }
                this.b = null;
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }
}
