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
import com.baidu.mobstat.Config;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.d22;
import com.baidu.tieba.f22;
import com.baidu.tieba.g22;
import com.baidu.tieba.gm3;
import com.baidu.tieba.qp4;
import com.baidu.tieba.v12;
import com.baidu.tieba.wp1;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
/* loaded from: classes3.dex */
public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {
    public static final boolean h = wp1.a;
    public static Camera i;
    public Context a;
    public MediaRecorder b;
    public SurfaceHolder c;
    public String d;
    public String e;
    public String f;
    public g22 g;

    /* loaded from: classes3.dex */
    public class a implements Camera.PictureCallback {
        public final /* synthetic */ String a;
        public final /* synthetic */ d22 b;

        /* renamed from: com.baidu.swan.apps.camera.view.CameraPreview$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0183a implements Runnable {
            public final /* synthetic */ byte[] a;

            public RunnableC0183a(byte[] bArr) {
                this.a = bArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                boolean z2;
                int i;
                int i2;
                int quality = Quality.getQuality(CameraPreview.this.d);
                if (CameraPreview.this.getResources().getConfiguration().orientation == 1) {
                    z = true;
                } else {
                    z = false;
                }
                if (CameraPreview.this.getFrontOrBackCameraId() == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z) {
                    if (z2) {
                        i2 = 90;
                    } else {
                        i2 = -90;
                    }
                    i = i2;
                } else {
                    i = 0;
                }
                boolean h = v12.b().h(this.a, a.this.a, quality, i, !z2);
                a aVar = a.this;
                d22 d22Var = aVar.b;
                if (d22Var != null) {
                    if (h) {
                        d22Var.onSuccess(aVar.a);
                    } else {
                        d22Var.onFailure();
                    }
                }
            }
        }

        public a(String str, d22 d22Var) {
            this.a = str;
            this.b = d22Var;
        }

        @Override // android.hardware.Camera.PictureCallback
        public void onPictureTaken(byte[] bArr, Camera camera) {
            try {
                camera.startPreview();
                CameraPreview.this.setCameraDisplayOrientation();
            } catch (RuntimeException e) {
                if (CameraPreview.this.g != null) {
                    v12.b().e(CameraPreview.this.g.c, CameraPreview.this.g.b, false);
                }
                CameraPreview.this.p();
                if (CameraPreview.h) {
                    e.printStackTrace();
                }
            }
            gm3.k(new RunnableC0183a(bArr), CommonTbJsBridge.SAVE_IMAGE);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Camera.AutoFocusCallback {
        public b() {
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z, Camera camera) {
            if (CameraPreview.h) {
                Log.i("SwanAppCameraManager", "camera auto focus result : " + z);
            }
        }
    }

    private CamcorderProfile getCamcorderProfile() {
        int i2 = 5;
        if (!CamcorderProfile.hasProfile(5)) {
            if (CamcorderProfile.hasProfile(4)) {
                i2 = 4;
            } else {
                i2 = 1;
            }
        }
        return CamcorderProfile.get(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getFrontOrBackCameraId() {
        g22 g22Var = this.g;
        if (g22Var != null && g22Var.k()) {
            return 1;
        }
        return 0;
    }

    public static void r() {
        Camera camera = i;
        if (camera != null) {
            camera.setPreviewCallback(null);
            i.stopPreview();
            i.release();
            i = null;
        }
    }

    public String getSlaveId() {
        g22 g22Var = this.g;
        if (g22Var == null) {
            return "";
        }
        return g22Var.c;
    }

    public String getThumbPath() {
        return this.f;
    }

    public String getVideoPath() {
        return this.e;
    }

    public void m() {
        this.e = "";
        this.f = "";
    }

    public void p() {
        s();
        m();
        SurfaceHolder surfaceHolder = this.c;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this);
        }
        r();
    }

    public final void s() {
        MediaRecorder mediaRecorder = this.b;
        if (mediaRecorder == null) {
            return;
        }
        try {
            try {
                mediaRecorder.stop();
            } catch (Exception e) {
                if (h) {
                    e.printStackTrace();
                }
            }
        } finally {
            this.b.reset();
            this.b.release();
            this.b = null;
        }
    }

    public void setCameraDisplayOrientation() {
        i.setDisplayOrientation(getDegree());
    }

    public boolean v() {
        s();
        Camera camera = i;
        if (camera != null) {
            camera.lock();
        }
        ThumbnailUtils.createVideoThumbnail(getThumbPath(), 1);
        return true;
    }

    /* loaded from: classes3.dex */
    public enum Quality {
        HIGH("high", 100),
        NORMAL("normal", 70),
        LOW(Config.EXCEPTION_MEMORY_LOW, 40);
        
        public int qualityInt;
        public String qualityName;

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

        public int getQualityInt() {
            return this.qualityInt;
        }

        public String getQualityName() {
            return this.qualityName;
        }
    }

    public CameraPreview(Context context) {
        super(context);
        this.d = Quality.NORMAL.getQualityName();
        this.e = "";
        this.f = "";
    }

    public String o(String str) {
        return str + File.separator + "IMG_" + Calendar.getInstance().getTimeInMillis() + ".jpg";
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() == 1) {
            try {
                f22.d(motionEvent, i, getWidth(), getHeight());
            } catch (Exception e) {
                if (h) {
                    Log.d("SwanAppCameraManager", Log.getStackTraceString(e));
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setQuality(String str) {
        this.d = str;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (h) {
            Log.d("SwanAppCameraManager", "camera surfaceDestroyed");
        }
    }

    public boolean u(String str) {
        setSaveMediaPath(str);
        if (q()) {
            this.b.start();
            return true;
        }
        m();
        return false;
    }

    public CameraPreview(Context context, g22 g22Var) {
        super(context);
        this.d = Quality.NORMAL.getQualityName();
        this.e = "";
        this.f = "";
        this.a = context;
        this.g = g22Var;
        SurfaceHolder holder = getHolder();
        this.c = holder;
        holder.addCallback(this);
    }

    public void w(String str, d22 d22Var) {
        i.takePicture(null, null, new a(str, d22Var));
    }

    private int getDegree() {
        Context context = getContext();
        int i2 = 0;
        if (!(context instanceof Activity)) {
            return 0;
        }
        int rotation = ((Activity) context).getWindowManager().getDefaultDisplay().getRotation();
        if (rotation != 0) {
            if (rotation != 1) {
                if (rotation != 2) {
                    if (rotation == 3) {
                        i2 = 270;
                    }
                } else {
                    i2 = 180;
                }
            } else {
                i2 = 90;
            }
        }
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(getFrontOrBackCameraId(), cameraInfo);
        if (cameraInfo.facing == 1) {
            return (360 - ((cameraInfo.orientation + i2) % 360)) % 360;
        }
        return ((cameraInfo.orientation - i2) + 360) % 360;
    }

    private void setSaveMediaPath(String str) {
        this.e = str + File.separator + "VID_" + Calendar.getInstance().getTimeInMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION;
        this.f = str + File.separator + "IMG_" + Calendar.getInstance().getTimeInMillis() + ".jpg";
        qp4.h(new File(this.e));
    }

    public Camera getCameraInstance() {
        try {
            r();
            Camera open = Camera.open(getFrontOrBackCameraId());
            i = open;
            if (this.g != null) {
                Camera.Parameters parameters = open.getParameters();
                t(i, parameters, this.g.h());
                int j = this.g.j();
                int i2 = this.g.i();
                Camera.Size n = n(parameters.getSupportedPreviewSizes(), j, i2);
                if (n != null) {
                    parameters.setPreviewSize(n.width, n.height);
                }
                Camera.Size n2 = n(parameters.getSupportedPictureSizes(), j, i2);
                if (n2 != null) {
                    parameters.setPictureSize(n2.width, n2.height);
                }
                boolean z = true;
                if (getFrontOrBackCameraId() != 1) {
                    z = false;
                }
                if (z) {
                    parameters.set("video-flip", "flip-h");
                }
                i.setParameters(parameters);
            }
        } catch (Exception e) {
            if (h) {
                Log.d("SwanAppCameraManager", "camera is not available");
                e.printStackTrace();
            }
        }
        return i;
    }

    public final Camera.Size n(List<Camera.Size> list, int i2, int i3) {
        boolean z;
        float f;
        float f2;
        int i4;
        float f3;
        int i5;
        int i6;
        float f4;
        int i7;
        Camera.Size size = null;
        if (list != null && !list.isEmpty() && i3 != 0) {
            float f5 = i2 / i3;
            float f6 = -1.0f;
            if (getDegree() % 180 == 0) {
                z = true;
            } else {
                z = false;
            }
            Camera.Size size2 = null;
            for (Camera.Size size3 : list) {
                if (size3 != null) {
                    if (z) {
                        f3 = size3.width;
                        i5 = size3.height;
                    } else {
                        f3 = size3.height;
                        i5 = size3.width;
                    }
                    float f7 = (f3 / i5) - f5;
                    float abs = Math.abs(f7);
                    if (f6 < 0.0f) {
                        size = size3;
                        f6 = abs;
                    }
                    if (abs < f6) {
                        size = size3;
                        f6 = abs;
                    }
                    if (z) {
                        i6 = size3.width;
                    } else {
                        i6 = size3.height;
                    }
                    if (i6 == i2) {
                        if (size2 != null) {
                            if (z) {
                                f4 = size2.width;
                                i7 = size2.height;
                            } else {
                                f4 = size2.height;
                                i7 = size2.width;
                            }
                            if (Math.abs(f7) < Math.abs((f4 / i7) - f5)) {
                            }
                        }
                        size2 = size3;
                    }
                }
            }
            if (size != null && size2 != null) {
                if (z) {
                    f = size2.width / size2.height;
                    f2 = size.width;
                    i4 = size.height;
                } else {
                    f = size2.height / size2.width;
                    f2 = size.height;
                    i4 = size.width;
                }
                if (Math.abs(f - f5) < Math.abs((f2 / i4) - f5) + 0.2f) {
                    return size2;
                }
            }
        }
        return size;
    }

    public final boolean q() {
        boolean z;
        s();
        this.b = new MediaRecorder();
        i = getCameraInstance();
        setCameraDisplayOrientation();
        if (getResources().getConfiguration().orientation == 1) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.b.setOrientationHint(90);
        }
        i.unlock();
        this.b.setCamera(i);
        this.b.setAudioSource(1);
        this.b.setVideoSource(1);
        this.b.setProfile(getCamcorderProfile());
        this.b.setOutputFile(getVideoPath());
        this.b.setVideoEncodingBitRate(8388608);
        this.b.setPreviewDisplay(this.c.getSurface());
        try {
            this.b.prepare();
            return true;
        } catch (IOException e) {
            if (h) {
                Log.d("SwanAppCameraManager", "IOException preparing MediaRecorder: " + e.getMessage());
                e.printStackTrace();
            }
            return false;
        } catch (IllegalStateException e2) {
            if (h) {
                Log.d("SwanAppCameraManager", "IllegalStateException preparing MediaRecorder: " + e2.getMessage());
                e2.printStackTrace();
            }
            return false;
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        if (h) {
            Log.d("SwanAppCameraManager", "camera surfaceChanged");
        }
        x(this.g);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (h) {
            Log.d("SwanAppCameraManager", "camera surfaceCreated");
        }
        getCameraInstance();
        try {
            if (i == null) {
                return;
            }
            i.setPreviewDisplay(surfaceHolder);
            i.startPreview();
            setCameraDisplayOrientation();
        } catch (IOException | RuntimeException e) {
            if (h) {
                Log.d("SwanAppCameraManager", "Error setting camera preview: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public void x(g22 g22Var) {
        try {
            this.g = g22Var;
            r();
            getCameraInstance();
            if (i != null) {
                i.setPreviewDisplay(this.c);
                i.startPreview();
                setCameraDisplayOrientation();
                i.autoFocus(new b());
            }
        } catch (IOException | RuntimeException e) {
            v12.b().e(g22Var.c, g22Var.b, false);
            if (h) {
                e.printStackTrace();
            }
        }
    }

    public final void t(Camera camera, Camera.Parameters parameters, String str) {
        List<String> supportedFlashModes;
        if (camera != null && parameters != null && (supportedFlashModes = parameters.getSupportedFlashModes()) != null && !supportedFlashModes.isEmpty() && !TextUtils.equals(str, parameters.getFlashMode()) && supportedFlashModes.contains(str)) {
            parameters.setFlashMode(str);
            camera.setParameters(parameters);
        }
    }
}
