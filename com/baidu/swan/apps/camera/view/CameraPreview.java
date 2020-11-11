package com.baidu.swan.apps.camera.view;

import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.media.ThumbnailUtils;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.ap.p;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.camera.d.a;
import com.baidu.swan.c.d;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
/* loaded from: classes10.dex */
public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {
    private static final boolean DEBUG = b.DEBUG;
    private static Camera cBC;
    private SurfaceHolder bOj;
    private MediaRecorder cBB;
    private String cBD;
    private String cBE;
    private a cBF;
    public Context mContext;
    private String mVideoPath;

    public CameraPreview(Context context) {
        super(context);
        this.cBD = Quality.NORMAL.getQualityName();
        this.mVideoPath = "";
        this.cBE = "";
    }

    public CameraPreview(Context context, a aVar) {
        super(context);
        this.cBD = Quality.NORMAL.getQualityName();
        this.mVideoPath = "";
        this.cBE = "";
        this.mContext = context;
        this.cBF = aVar;
        this.bOj = getHolder();
        this.bOj.addCallback(this);
    }

    public Camera getCameraInstance() {
        try {
            releaseCamera();
            cBC = Camera.open(getFrontOrBackCameraId());
            if (this.cBF != null) {
                Camera.Parameters parameters = cBC.getParameters();
                a(cBC, parameters, this.cBF.akt());
                int width = this.cBF.getWidth();
                int height = this.cBF.getHeight();
                Camera.Size c = c(parameters.getSupportedPreviewSizes(), width, height);
                if (c != null) {
                    parameters.setPreviewSize(c.width, c.height);
                }
                Camera.Size c2 = c(parameters.getSupportedPictureSizes(), width, height);
                if (c2 != null) {
                    parameters.setPictureSize(c2.width, c2.height);
                }
                if (getFrontOrBackCameraId() == 1) {
                    parameters.set("video-flip", "flip-h");
                }
                cBC.setParameters(parameters);
            }
        } catch (Exception e) {
            if (DEBUG) {
                Log.d("SwanAppCameraManager", "camera is not available");
                e.printStackTrace();
            }
        }
        return cBC;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("SwanAppCameraManager", "camera surfaceCreated");
        }
        getCameraInstance();
        try {
            if (cBC != null) {
                cBC.setPreviewDisplay(surfaceHolder);
                cBC.startPreview();
                setCameraDisplayOrientation();
            }
        } catch (IOException | RuntimeException e) {
            if (DEBUG) {
                Log.d("SwanAppCameraManager", "Error setting camera preview: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("SwanAppCameraManager", "camera surfaceDestroyed");
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (DEBUG) {
            Log.d("SwanAppCameraManager", "camera surfaceChanged");
        }
        b(this.cBF);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() == 1) {
            try {
                com.baidu.swan.apps.camera.c.a.a(motionEvent, cBC, getWidth(), getHeight());
            } catch (Exception e) {
                if (DEBUG) {
                    Log.d("SwanAppCameraManager", Log.getStackTraceString(e));
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void onRelease() {
        akv();
        akw();
        if (this.bOj != null) {
            this.bOj.removeCallback(this);
        }
        releaseCamera();
    }

    public void a(final String str, final com.baidu.swan.apps.camera.b.a aVar) {
        cBC.takePicture(null, null, new Camera.PictureCallback() { // from class: com.baidu.swan.apps.camera.view.CameraPreview.1
            @Override // android.hardware.Camera.PictureCallback
            public void onPictureTaken(final byte[] bArr, Camera camera) {
                try {
                    camera.startPreview();
                    CameraPreview.this.setCameraDisplayOrientation();
                } catch (RuntimeException e) {
                    if (CameraPreview.this.cBF != null) {
                        com.baidu.swan.apps.camera.a.akp().j(CameraPreview.this.cBF.cDL, CameraPreview.this.cBF.cameraId, false);
                    }
                    CameraPreview.this.onRelease();
                    if (CameraPreview.DEBUG) {
                        e.printStackTrace();
                    }
                }
                p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.camera.view.CameraPreview.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int i;
                        int quality = Quality.getQuality(CameraPreview.this.cBD);
                        boolean z = CameraPreview.this.getResources().getConfiguration().orientation == 1;
                        boolean z2 = CameraPreview.this.getFrontOrBackCameraId() == 0;
                        if (z) {
                            i = z2 ? 90 : -90;
                        } else {
                            i = 0;
                        }
                        boolean a2 = com.baidu.swan.apps.camera.a.akp().a(bArr, str, quality, i, z2 ? false : true);
                        if (aVar != null) {
                            if (a2) {
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

    public boolean mf(String str) {
        setSaveMediaPath(str);
        if (aku()) {
            this.cBB.start();
            return true;
        }
        akw();
        return false;
    }

    public boolean stopRecording() {
        akv();
        if (cBC != null) {
            cBC.lock();
        }
        ThumbnailUtils.createVideoThumbnail(getThumbPath(), 1);
        return true;
    }

    private boolean aku() {
        akv();
        this.cBB = new MediaRecorder();
        cBC = getCameraInstance();
        setCameraDisplayOrientation();
        if (getResources().getConfiguration().orientation == 1) {
            this.cBB.setOrientationHint(90);
        }
        cBC.unlock();
        this.cBB.setCamera(cBC);
        this.cBB.setAudioSource(1);
        this.cBB.setVideoSource(1);
        this.cBB.setProfile(getCamcorderProfile());
        this.cBB.setOutputFile(getVideoPath());
        this.cBB.setVideoEncodingBitRate(8388608);
        this.cBB.setPreviewDisplay(this.bOj.getSurface());
        try {
            this.cBB.prepare();
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

    private void akv() {
        if (this.cBB != null) {
            try {
                this.cBB.stop();
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            } finally {
                this.cBB.reset();
                this.cBB.release();
                this.cBB = null;
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

    /* JADX WARN: Code restructure failed: missing block: B:36:0x007c, code lost:
        if (java.lang.Math.abs(r5 - r7) >= java.lang.Math.abs(r6 - r7)) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Camera.Size c(List<Camera.Size> list, int i, int i2) {
        float f;
        float f2;
        float f3;
        float f4;
        if (list == null || list.isEmpty() || i2 == 0) {
            return null;
        }
        float f5 = i / i2;
        boolean z = getDegree() % 180 == 0;
        Camera.Size size = null;
        float f6 = -1.0f;
        Camera.Size size2 = null;
        for (Camera.Size size3 : list) {
            if (size3 != null) {
                if (z) {
                    f3 = size3.width / size3.height;
                } else {
                    f3 = size3.height / size3.width;
                }
                float abs = Math.abs(f3 - f5);
                if (f6 < 0.0f) {
                    f6 = abs;
                    size = size3;
                }
                if (abs < f6) {
                    f6 = abs;
                    size = size3;
                }
                if ((z ? size3.width : size3.height) == i) {
                    if (size2 != null) {
                        if (z) {
                            f4 = size2.width / size2.height;
                        } else {
                            f4 = size2.height / size2.width;
                        }
                    }
                    size2 = size3;
                }
                size3 = size2;
                size2 = size3;
            }
        }
        if (size != null && size2 != null) {
            if (z) {
                f = size2.width / size2.height;
                f2 = size.width / size.height;
            } else {
                f = size2.height / size2.width;
                f2 = size.height / size.width;
            }
            if (Math.abs(f - f5) < Math.abs(f2 - f5) + 0.2f) {
                return size2;
            }
        }
        return size;
    }

    private CamcorderProfile getCamcorderProfile() {
        int i = 5;
        if (!CamcorderProfile.hasProfile(5)) {
            i = CamcorderProfile.hasProfile(4) ? 4 : 1;
        }
        return CamcorderProfile.get(i);
    }

    public void b(a aVar) {
        try {
            this.cBF = aVar;
            releaseCamera();
            getCameraInstance();
            if (cBC != null) {
                cBC.setPreviewDisplay(this.bOj);
                cBC.startPreview();
                setCameraDisplayOrientation();
                cBC.autoFocus(new Camera.AutoFocusCallback() { // from class: com.baidu.swan.apps.camera.view.CameraPreview.2
                    @Override // android.hardware.Camera.AutoFocusCallback
                    public void onAutoFocus(boolean z, Camera camera) {
                        if (CameraPreview.DEBUG) {
                            Log.i("SwanAppCameraManager", "camera auto focus result : " + z);
                        }
                    }
                });
            }
        } catch (IOException | RuntimeException e) {
            com.baidu.swan.apps.camera.a.akp().j(aVar.cDL, aVar.cameraId, false);
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void setQuality(String str) {
        this.cBD = str;
    }

    public String mg(String str) {
        return str + File.separator + "IMG_" + Calendar.getInstance().getTimeInMillis() + ".jpg";
    }

    private void setSaveMediaPath(String str) {
        this.mVideoPath = str + File.separator + "VID_" + Calendar.getInstance().getTimeInMillis() + ".mp4";
        this.cBE = str + File.separator + "IMG_" + Calendar.getInstance().getTimeInMillis() + ".jpg";
        d.createNewFileSafely(new File(this.mVideoPath));
    }

    public void akw() {
        this.mVideoPath = "";
        this.cBE = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getFrontOrBackCameraId() {
        return (this.cBF == null || !this.cBF.isFrontCamera()) ? 0 : 1;
    }

    public String getVideoPath() {
        return this.mVideoPath;
    }

    public String getThumbPath() {
        return this.cBE;
    }

    public String getSlaveId() {
        return this.cBF == null ? "" : this.cBF.cDL;
    }

    public void setCameraDisplayOrientation() {
        cBC.setDisplayOrientation(getDegree());
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
                    i = 180;
                    break;
                case 3:
                    i = 270;
                    break;
                default:
                    i = 0;
                    break;
            }
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(getFrontOrBackCameraId(), cameraInfo);
            if (cameraInfo.facing == 1) {
                i2 = (360 - ((i + cameraInfo.orientation) % EncoderTextureDrawer.X264_WIDTH)) % EncoderTextureDrawer.X264_WIDTH;
            } else {
                i2 = ((cameraInfo.orientation - i) + EncoderTextureDrawer.X264_WIDTH) % EncoderTextureDrawer.X264_WIDTH;
            }
            return i2;
        }
        return 0;
    }

    public static void releaseCamera() {
        if (cBC != null) {
            cBC.setPreviewCallback(null);
            cBC.stopPreview();
            cBC.release();
            cBC = null;
        }
    }

    /* loaded from: classes10.dex */
    public enum Quality {
        HIGH("high", 100),
        NORMAL("normal", 70),
        LOW(Config.EXCEPTION_MEMORY_LOW, 40);
        
        private int qualityInt;
        private String qualityName;

        Quality(String str, int i) {
            this.qualityName = str;
            this.qualityInt = i;
        }

        public static int getQuality(String str) {
            Quality[] values;
            int qualityInt = NORMAL.getQualityInt();
            for (Quality quality : values()) {
                if (TextUtils.equals(quality.getQualityName(), str)) {
                    return quality.qualityInt;
                }
            }
            return qualityInt;
        }

        public String getQualityName() {
            return this.qualityName;
        }

        public int getQualityInt() {
            return this.qualityInt;
        }
    }
}
