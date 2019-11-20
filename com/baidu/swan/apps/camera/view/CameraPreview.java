package com.baidu.swan.apps.camera.view;

import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.media.ThumbnailUtils;
import android.text.TextUtils;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.an.j;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.camera.d.a;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
/* loaded from: classes2.dex */
public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {
    private static final boolean DEBUG = b.DEBUG;
    private MediaRecorder aFe;
    private String aFf;
    private String aFg;
    private String aFh;
    private a aFi;
    private SurfaceHolder atI;
    private Camera mCamera;
    public Context mContext;

    public CameraPreview(Context context) {
        super(context);
        this.aFf = Quality.NORMAL.getQualityName();
        this.aFg = "";
        this.aFh = "";
    }

    public CameraPreview(Context context, a aVar) {
        super(context);
        this.aFf = Quality.NORMAL.getQualityName();
        this.aFg = "";
        this.aFh = "";
        this.mContext = context;
        this.aFi = aVar;
        this.atI = getHolder();
        this.atI.addCallback(this);
    }

    public Camera getCameraInstance() {
        try {
            this.mCamera = Camera.open(getFrontOrBackCameraId());
            if (this.aFi != null) {
                Camera.Parameters parameters = this.mCamera.getParameters();
                a(this.mCamera, parameters, this.aFi.CJ());
                int width = this.aFi.getWidth();
                int height = this.aFi.getHeight();
                Camera.Size c = c(parameters.getSupportedPreviewSizes(), width, height);
                if (c != null) {
                    parameters.setPreviewSize(c.width, c.height);
                }
                Camera.Size c2 = c(parameters.getSupportedPictureSizes(), width, height);
                if (c2 != null) {
                    parameters.setPictureSize(c2.width, c2.height);
                }
                this.mCamera.setParameters(parameters);
            }
        } catch (Exception e) {
            if (DEBUG) {
                Log.d("SwanAppCameraManager", "camera is not available");
                e.printStackTrace();
            }
        }
        return this.mCamera;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        getCameraInstance();
        try {
            if (this.mCamera != null) {
                this.mCamera.setPreviewDisplay(surfaceHolder);
                this.mCamera.startPreview();
                setCameraDisplayOrientation();
            }
        } catch (IOException e) {
            if (DEBUG) {
                Log.d("SwanAppCameraManager", "Error setting camera preview: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        b(this.aFi);
    }

    public void CK() {
        CN();
        CO();
        if (this.atI != null) {
            this.atI.removeCallback(this);
        }
        if (this.mCamera != null) {
            this.mCamera.setPreviewCallback(null);
            this.mCamera.stopPreview();
            this.mCamera.release();
            this.mCamera = null;
        }
    }

    public void a(final String str, final com.baidu.swan.apps.camera.b.a aVar) {
        this.mCamera.takePicture(null, null, new Camera.PictureCallback() { // from class: com.baidu.swan.apps.camera.view.CameraPreview.1
            @Override // android.hardware.Camera.PictureCallback
            public void onPictureTaken(final byte[] bArr, Camera camera) {
                camera.startPreview();
                CameraPreview.this.setCameraDisplayOrientation();
                j.a(new Runnable() { // from class: com.baidu.swan.apps.camera.view.CameraPreview.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int i;
                        int quality = Quality.getQuality(CameraPreview.this.aFf);
                        boolean z = CameraPreview.this.getResources().getConfiguration().orientation == 1;
                        boolean z2 = CameraPreview.this.getFrontOrBackCameraId() == 0;
                        if (z) {
                            i = z2 ? 90 : -90;
                        } else {
                            i = 0;
                        }
                        boolean a = com.baidu.swan.apps.camera.a.CE().a(bArr, str, quality, i);
                        if (aVar != null) {
                            if (a) {
                                aVar.onSuccess(str);
                            } else {
                                aVar.onFailure();
                            }
                        }
                    }
                }, "saveImage");
            }
        });
    }

    public boolean dX(String str) {
        setSaveMediaPath(str);
        if (CM()) {
            this.aFe.start();
            return true;
        }
        CO();
        return false;
    }

    public boolean CL() {
        CN();
        if (this.mCamera != null) {
            this.mCamera.lock();
        }
        ThumbnailUtils.createVideoThumbnail(getThumbPath(), 1);
        return true;
    }

    private boolean CM() {
        CN();
        this.aFe = new MediaRecorder();
        this.mCamera = getCameraInstance();
        setCameraDisplayOrientation();
        this.mCamera.unlock();
        this.aFe.setCamera(this.mCamera);
        this.aFe.setAudioSource(5);
        this.aFe.setVideoSource(1);
        this.aFe.setProfile(getCamcorderProfile());
        this.aFe.setOutputFile(getVideoPath());
        this.aFe.setPreviewDisplay(this.atI.getSurface());
        try {
            this.aFe.prepare();
            return true;
        } catch (IOException e) {
            if (DEBUG) {
                Log.d("SwanAppCameraManager", "IOException preparing MediaRecorder: " + e.getMessage());
                e.printStackTrace();
            }
            return false;
        } catch (IllegalStateException e2) {
            if (DEBUG) {
                Log.d("SwanAppCameraManager", "IllegalStateException preparing MediaRecorder: " + e2.getMessage());
                e2.printStackTrace();
            }
            return false;
        }
    }

    private void CN() {
        if (this.aFe != null) {
            try {
                this.aFe.stop();
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            } finally {
                this.aFe.reset();
                this.aFe.release();
                this.aFe = null;
            }
        }
    }

    private void a(Camera camera, Camera.Parameters parameters, String str) {
        List<String> supportedFlashModes;
        if (camera != null && parameters != null && (supportedFlashModes = parameters.getSupportedFlashModes()) != null && !supportedFlashModes.isEmpty() && !TextUtils.equals(str, parameters.getFlashMode()) && supportedFlashModes.contains(str)) {
            parameters.setFlashMode(str);
            camera.setParameters(parameters);
        }
    }

    private Camera.Size c(List<Camera.Size> list, int i, int i2) {
        float f;
        float f2;
        if (list == null || list.isEmpty()) {
            return null;
        }
        float f3 = i / i2;
        boolean z = getDegree() % SubsamplingScaleImageView.ORIENTATION_180 == 0;
        Camera.Size size = null;
        float f4 = -1.0f;
        Camera.Size size2 = null;
        for (Camera.Size size3 : list) {
            if (z) {
                f = size3.width / size3.height;
            } else {
                f = size3.height / size3.width;
            }
            float abs = Math.abs(f - f3);
            if (f4 < 0.0f) {
                f4 = abs;
                size = size3;
            }
            if (abs < f4) {
                f4 = abs;
                size = size3;
            }
            if ((!z ? size3.height : size3.width) == i) {
                if (size2 != null) {
                    if (z) {
                        f2 = size2.width / size2.height;
                    } else {
                        f2 = size2.height / size2.width;
                    }
                    if (Math.abs(f - f3) < Math.abs(f2 - f3)) {
                    }
                }
                size2 = size3;
            }
            size3 = size2;
            size2 = size3;
        }
        return (size2 == null || size.width == size2.width || Math.abs((((float) size2.width) / ((float) size2.height)) - (((float) size.width) / ((float) size.height))) >= 0.2f) ? size : size2;
    }

    private CamcorderProfile getCamcorderProfile() {
        int i = 6;
        if (!CamcorderProfile.hasProfile(6)) {
            if (CamcorderProfile.hasProfile(5)) {
                i = 5;
            } else {
                i = CamcorderProfile.hasProfile(4) ? 4 : 1;
            }
        }
        return CamcorderProfile.get(i);
    }

    public void b(a aVar) {
        try {
            this.aFi = aVar;
            if (this.mCamera != null) {
                this.mCamera.stopPreview();
                this.mCamera.release();
                this.mCamera = null;
            }
            getCameraInstance();
            if (this.mCamera != null) {
                this.mCamera.setPreviewDisplay(this.atI);
                this.mCamera.startPreview();
                setCameraDisplayOrientation();
            }
            this.mCamera.autoFocus(new Camera.AutoFocusCallback() { // from class: com.baidu.swan.apps.camera.view.CameraPreview.2
                @Override // android.hardware.Camera.AutoFocusCallback
                public void onAutoFocus(boolean z, Camera camera) {
                    if (CameraPreview.DEBUG) {
                        Log.i("SwanAppCameraManager", "camera auto focus result : " + z);
                    }
                }
            });
        } catch (IOException | RuntimeException e) {
            com.baidu.swan.apps.camera.a.CE().f(aVar.aXp, aVar.aFc, false);
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void setQuality(String str) {
        this.aFf = str;
    }

    public String dY(String str) {
        return str + File.separator + "IMG_" + Calendar.getInstance().getTimeInMillis() + ".jpg";
    }

    private void setSaveMediaPath(String str) {
        this.aFg = str + File.separator + "VID_" + Calendar.getInstance().getTimeInMillis() + ".mp4";
        this.aFh = str + File.separator + "IMG_" + Calendar.getInstance().getTimeInMillis() + ".jpg";
        com.baidu.swan.c.a.n(new File(this.aFg));
    }

    public void CO() {
        this.aFg = "";
        this.aFh = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getFrontOrBackCameraId() {
        return (this.aFi == null || !this.aFi.isFrontCamera()) ? 0 : 1;
    }

    public String getVideoPath() {
        return this.aFg;
    }

    public String getThumbPath() {
        return this.aFh;
    }

    public String getSlaveId() {
        return this.aFi == null ? "" : this.aFi.aXp;
    }

    public void setCameraDisplayOrientation() {
        this.mCamera.setDisplayOrientation(getDegree());
    }

    private int getDegree() {
        int i;
        int i2;
        Context context = getContext();
        if (context instanceof Activity) {
            switch (((Activity) context).getWindowManager().getDefaultDisplay().getRotation()) {
                case 0:
                    i = 0;
                    break;
                case 1:
                    i = 90;
                    break;
                case 2:
                    i = SubsamplingScaleImageView.ORIENTATION_180;
                    break;
                case 3:
                    i = SubsamplingScaleImageView.ORIENTATION_270;
                    break;
                default:
                    i = 0;
                    break;
            }
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(getFrontOrBackCameraId(), cameraInfo);
            if (cameraInfo.facing == 1) {
                i2 = (360 - ((i + cameraInfo.orientation) % 360)) % 360;
            } else {
                i2 = ((cameraInfo.orientation - i) + 360) % 360;
            }
            return i2;
        }
        return 0;
    }

    /* loaded from: classes2.dex */
    public enum Quality {
        HIGH("high", 100),
        NORMAL("normal", 80),
        LOW(Config.EXCEPTION_MEMORY_LOW, 60);
        
        private int qualityInt;
        private String qualityName;

        Quality(String str, int i) {
            this.qualityName = str;
            this.qualityInt = i;
        }

        public static int getQuality(String str) {
            Quality[] values;
            int qualityInt = NORMAL.getQualityInt();
            int i = qualityInt;
            for (Quality quality : values()) {
                if (TextUtils.equals(quality.getQualityName(), str)) {
                    i = quality.qualityInt;
                }
            }
            return i;
        }

        public String getQualityName() {
            return this.qualityName;
        }

        public int getQualityInt() {
            return this.qualityInt;
        }
    }
}
