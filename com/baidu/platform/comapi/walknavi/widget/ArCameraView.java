package com.baidu.platform.comapi.walknavi.widget;

import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;
import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.baidu.platform.comapi.wnplatform.p.h;
import java.util.List;
/* loaded from: classes26.dex */
public class ArCameraView extends SurfaceView implements SurfaceHolder.Callback {
    public static final int WALK_AR_PERMISSION = 3001;

    /* renamed from: a  reason: collision with root package name */
    SurfaceHolder f3093a;
    Camera b;
    private Context c;

    public ArCameraView(Context context) {
        super(context);
        a(context);
    }

    public ArCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    private void a(Context context) {
        try {
            this.c = context;
            this.f3093a = getHolder();
            this.f3093a.addCallback(this);
            this.f3093a.setType(3);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(com.baidu.platform.comapi.wnplatform.p.b.a.a(), "相机出现错误", 0).show();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Log.e("CameraView", "surfaceCreated");
        try {
            if (this.b == null) {
                this.b = Camera.open();
            }
            Camera.Parameters parameters = this.b.getParameters();
            Camera.Size bestPreSize = getBestPreSize(h.c(this.c), h.b(this.c), parameters.getSupportedPreviewSizes());
            parameters.setPreviewSize(bestPreSize.width, bestPreSize.height);
            if (this.b != null) {
                this.b.setParameters(parameters);
                this.b.setPreviewDisplay(surfaceHolder);
            }
            resumeCamera();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(com.baidu.platform.comapi.wnplatform.p.b.a.a(), "相机出现错误", 0).show();
        }
    }

    protected Camera.Size getBestPreSize(int i, int i2, List<Camera.Size> list) {
        double d;
        Camera.Size size;
        float f;
        for (Camera.Size size2 : list) {
            if (size2.width == i && size2.height == i2) {
                return size2;
            }
        }
        float f2 = i / i2;
        float f3 = 0.1f;
        Camera.Size size3 = null;
        for (Camera.Size size4 : list) {
            float abs = Math.abs(f2 - (size4.width / size4.height));
            if (abs < f3) {
                f = abs;
            } else {
                size4 = size3;
                f = f3;
            }
            f3 = f;
            size3 = size4;
        }
        if (size3 == null) {
            double d2 = Double.MAX_VALUE;
            for (Camera.Size size5 : list) {
                if (Math.abs(size5.height - i2) < d2) {
                    d = Math.abs(size5.height - i2);
                    size = size5;
                } else {
                    d = d2;
                    size = size3;
                }
                size3 = size;
                d2 = d;
            }
        }
        return size3;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (!setCameraDisplayOrientation((Activity) this.c, getBackCameraId(), this.b)) {
            a(90);
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
                i3 = (360 - ((i2 + cameraInfo.orientation) % EncoderTextureDrawer.X264_WIDTH)) % EncoderTextureDrawer.X264_WIDTH;
            } else {
                i3 = ((cameraInfo.orientation - i2) + EncoderTextureDrawer.X264_WIDTH) % EncoderTextureDrawer.X264_WIDTH;
            }
            camera.setDisplayOrientation(i3);
        } catch (Exception e) {
            Log.d("ARCamera", e.getMessage());
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
            Log.d("ARCamera", "GetBackCameraID error!");
        }
        return -1;
    }

    private void a(int i) {
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
            Toast.makeText(com.baidu.platform.comapi.wnplatform.p.b.a.a(), "相机出现错误", 0).show();
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
