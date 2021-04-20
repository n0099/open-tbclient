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
import d.b.g0.a.i2.p;
import d.b.g0.a.k;
import d.b.g0.p.d;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
/* loaded from: classes2.dex */
public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {
    public static final boolean l = k.f45443a;
    public static Camera m;

    /* renamed from: e  reason: collision with root package name */
    public Context f11769e;

    /* renamed from: f  reason: collision with root package name */
    public MediaRecorder f11770f;

    /* renamed from: g  reason: collision with root package name */
    public SurfaceHolder f11771g;

    /* renamed from: h  reason: collision with root package name */
    public String f11772h;
    public String i;
    public String j;
    public d.b.g0.a.x.e.a k;

    /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    public class a implements Camera.PictureCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f11773a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.x.c.a f11774b;

        /* renamed from: com.baidu.swan.apps.camera.view.CameraPreview$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0169a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ byte[] f11776e;

            public RunnableC0169a(byte[] bArr) {
                this.f11776e = bArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i;
                int quality = Quality.getQuality(CameraPreview.this.f11772h);
                boolean z = CameraPreview.this.getResources().getConfiguration().orientation == 1;
                boolean z2 = CameraPreview.this.getFrontOrBackCameraId() == 0;
                if (z) {
                    i = z2 ? 90 : -90;
                } else {
                    i = 0;
                }
                boolean h2 = d.b.g0.a.x.a.b().h(this.f11776e, a.this.f11773a, quality, i, !z2);
                a aVar = a.this;
                d.b.g0.a.x.c.a aVar2 = aVar.f11774b;
                if (aVar2 != null) {
                    if (h2) {
                        aVar2.onSuccess(aVar.f11773a);
                    } else {
                        aVar2.onFailure();
                    }
                }
            }
        }

        public a(String str, d.b.g0.a.x.c.a aVar) {
            this.f11773a = str;
            this.f11774b = aVar;
        }

        @Override // android.hardware.Camera.PictureCallback
        public void onPictureTaken(byte[] bArr, Camera camera) {
            try {
                camera.startPreview();
                CameraPreview.this.setCameraDisplayOrientation();
            } catch (RuntimeException e2) {
                if (CameraPreview.this.k != null) {
                    d.b.g0.a.x.a.b().e(CameraPreview.this.k.f43506g, CameraPreview.this.k.p, false);
                }
                CameraPreview.this.h();
                if (CameraPreview.l) {
                    e2.printStackTrace();
                }
            }
            p.k(new RunnableC0169a(bArr), CommonTbJsBridge.SAVE_IMAGE);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Camera.AutoFocusCallback {
        public b() {
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z, Camera camera) {
            if (CameraPreview.l) {
                Log.i("SwanAppCameraManager", "camera auto focus result : " + z);
            }
        }
    }

    public CameraPreview(Context context) {
        super(context);
        this.f11772h = Quality.NORMAL.getQualityName();
        this.i = "";
        this.j = "";
    }

    private CamcorderProfile getCamcorderProfile() {
        int i = 5;
        if (!CamcorderProfile.hasProfile(5)) {
            i = CamcorderProfile.hasProfile(4) ? 4 : 1;
        }
        return CamcorderProfile.get(i);
    }

    private int getDegree() {
        Context context = getContext();
        int i = 0;
        if (context instanceof Activity) {
            int rotation = ((Activity) context).getWindowManager().getDefaultDisplay().getRotation();
            if (rotation != 0) {
                if (rotation == 1) {
                    i = 90;
                } else if (rotation == 2) {
                    i = 180;
                } else if (rotation == 3) {
                    i = 270;
                }
            }
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(getFrontOrBackCameraId(), cameraInfo);
            if (cameraInfo.facing == 1) {
                return (360 - ((cameraInfo.orientation + i) % 360)) % 360;
            }
            return ((cameraInfo.orientation - i) + 360) % 360;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getFrontOrBackCameraId() {
        d.b.g0.a.x.e.a aVar = this.k;
        return (aVar == null || !aVar.k()) ? 0 : 1;
    }

    public static void j() {
        Camera camera = m;
        if (camera != null) {
            camera.setPreviewCallback(null);
            m.stopPreview();
            m.release();
            m = null;
        }
    }

    private void setSaveMediaPath(String str) {
        this.i = str + File.separator + "VID_" + Calendar.getInstance().getTimeInMillis() + ".mp4";
        this.j = str + File.separator + "IMG_" + Calendar.getInstance().getTimeInMillis() + ".jpg";
        d.e(new File(this.i));
    }

    public void e() {
        this.i = "";
        this.j = "";
    }

    public final Camera.Size f(List<Camera.Size> list, int i, int i2) {
        float f2;
        float f3;
        int i3;
        float f4;
        int i4;
        float f5;
        int i5;
        Camera.Size size = null;
        if (list != null && !list.isEmpty() && i2 != 0) {
            float f6 = i / i2;
            float f7 = -1.0f;
            boolean z = getDegree() % 180 == 0;
            Camera.Size size2 = null;
            for (Camera.Size size3 : list) {
                if (size3 != null) {
                    if (z) {
                        f4 = size3.width;
                        i4 = size3.height;
                    } else {
                        f4 = size3.height;
                        i4 = size3.width;
                    }
                    float f8 = (f4 / i4) - f6;
                    float abs = Math.abs(f8);
                    if (f7 < 0.0f) {
                        size = size3;
                        f7 = abs;
                    }
                    if (abs < f7) {
                        size = size3;
                        f7 = abs;
                    }
                    if ((z ? size3.width : size3.height) == i) {
                        if (size2 != null) {
                            if (z) {
                                f5 = size2.width;
                                i5 = size2.height;
                            } else {
                                f5 = size2.height;
                                i5 = size2.width;
                            }
                            if (Math.abs(f8) < Math.abs((f5 / i5) - f6)) {
                            }
                        }
                        size2 = size3;
                    }
                }
            }
            if (size != null && size2 != null) {
                if (z) {
                    f2 = size2.width / size2.height;
                    f3 = size.width;
                    i3 = size.height;
                } else {
                    f2 = size2.height / size2.width;
                    f3 = size.height;
                    i3 = size.width;
                }
                if (Math.abs(f2 - f6) < Math.abs((f3 / i3) - f6) + 0.2f) {
                    return size2;
                }
            }
        }
        return size;
    }

    public String g(String str) {
        return str + File.separator + "IMG_" + Calendar.getInstance().getTimeInMillis() + ".jpg";
    }

    public Camera getCameraInstance() {
        try {
            j();
            Camera open = Camera.open(getFrontOrBackCameraId());
            m = open;
            if (this.k != null) {
                Camera.Parameters parameters = open.getParameters();
                l(m, parameters, this.k.h());
                int j = this.k.j();
                int i = this.k.i();
                Camera.Size f2 = f(parameters.getSupportedPreviewSizes(), j, i);
                if (f2 != null) {
                    parameters.setPreviewSize(f2.width, f2.height);
                }
                Camera.Size f3 = f(parameters.getSupportedPictureSizes(), j, i);
                if (f3 != null) {
                    parameters.setPictureSize(f3.width, f3.height);
                }
                boolean z = true;
                if (getFrontOrBackCameraId() != 1) {
                    z = false;
                }
                if (z) {
                    parameters.set("video-flip", "flip-h");
                }
                m.setParameters(parameters);
            }
        } catch (Exception e2) {
            if (l) {
                Log.d("SwanAppCameraManager", "camera is not available");
                e2.printStackTrace();
            }
        }
        return m;
    }

    public String getSlaveId() {
        d.b.g0.a.x.e.a aVar = this.k;
        return aVar == null ? "" : aVar.f43506g;
    }

    public String getThumbPath() {
        return this.j;
    }

    public String getVideoPath() {
        return this.i;
    }

    public void h() {
        k();
        e();
        SurfaceHolder surfaceHolder = this.f11771g;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this);
        }
        j();
    }

    public final boolean i() {
        k();
        this.f11770f = new MediaRecorder();
        m = getCameraInstance();
        setCameraDisplayOrientation();
        if (getResources().getConfiguration().orientation == 1) {
            this.f11770f.setOrientationHint(90);
        }
        m.unlock();
        this.f11770f.setCamera(m);
        this.f11770f.setAudioSource(1);
        this.f11770f.setVideoSource(1);
        this.f11770f.setProfile(getCamcorderProfile());
        this.f11770f.setOutputFile(getVideoPath());
        this.f11770f.setVideoEncodingBitRate(8388608);
        this.f11770f.setPreviewDisplay(this.f11771g.getSurface());
        try {
            this.f11770f.prepare();
            return true;
        } catch (IOException e2) {
            if (l) {
                Log.d("SwanAppCameraManager", "IOException preparing MediaRecorder: " + e2.getMessage());
                e2.printStackTrace();
            }
            return false;
        } catch (IllegalStateException e3) {
            if (l) {
                Log.d("SwanAppCameraManager", "IllegalStateException preparing MediaRecorder: " + e3.getMessage());
                e3.printStackTrace();
            }
            return false;
        }
    }

    public final void k() {
        MediaRecorder mediaRecorder = this.f11770f;
        if (mediaRecorder == null) {
            return;
        }
        try {
            try {
                mediaRecorder.stop();
            } catch (Exception e2) {
                if (l) {
                    e2.printStackTrace();
                }
            }
        } finally {
            this.f11770f.reset();
            this.f11770f.release();
            this.f11770f = null;
        }
    }

    public final void l(Camera camera, Camera.Parameters parameters, String str) {
        List<String> supportedFlashModes;
        if (camera == null || parameters == null || (supportedFlashModes = parameters.getSupportedFlashModes()) == null || supportedFlashModes.isEmpty() || TextUtils.equals(str, parameters.getFlashMode()) || !supportedFlashModes.contains(str)) {
            return;
        }
        parameters.setFlashMode(str);
        camera.setParameters(parameters);
    }

    public boolean m(String str) {
        setSaveMediaPath(str);
        if (i()) {
            this.f11770f.start();
            return true;
        }
        e();
        return false;
    }

    public boolean n() {
        k();
        Camera camera = m;
        if (camera != null) {
            camera.lock();
        }
        ThumbnailUtils.createVideoThumbnail(getThumbPath(), 1);
        return true;
    }

    public void o(String str, d.b.g0.a.x.c.a aVar) {
        m.takePicture(null, null, new a(str, aVar));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() == 1) {
            try {
                d.b.g0.a.x.d.a.d(motionEvent, m, getWidth(), getHeight());
            } catch (Exception e2) {
                if (l) {
                    Log.d("SwanAppCameraManager", Log.getStackTraceString(e2));
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void p(d.b.g0.a.x.e.a aVar) {
        try {
            this.k = aVar;
            j();
            getCameraInstance();
            if (m != null) {
                m.setPreviewDisplay(this.f11771g);
                m.startPreview();
                setCameraDisplayOrientation();
                m.autoFocus(new b());
            }
        } catch (IOException | RuntimeException e2) {
            d.b.g0.a.x.a.b().e(aVar.f43506g, aVar.p, false);
            if (l) {
                e2.printStackTrace();
            }
        }
    }

    public void setCameraDisplayOrientation() {
        m.setDisplayOrientation(getDegree());
    }

    public void setQuality(String str) {
        this.f11772h = str;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (l) {
            Log.d("SwanAppCameraManager", "camera surfaceChanged");
        }
        p(this.k);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (l) {
            Log.d("SwanAppCameraManager", "camera surfaceCreated");
        }
        getCameraInstance();
        try {
            if (m == null) {
                return;
            }
            m.setPreviewDisplay(surfaceHolder);
            m.startPreview();
            setCameraDisplayOrientation();
        } catch (IOException | RuntimeException e2) {
            if (l) {
                Log.d("SwanAppCameraManager", "Error setting camera preview: " + e2.getMessage());
                e2.printStackTrace();
            }
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (l) {
            Log.d("SwanAppCameraManager", "camera surfaceDestroyed");
        }
    }

    public CameraPreview(Context context, d.b.g0.a.x.e.a aVar) {
        super(context);
        this.f11772h = Quality.NORMAL.getQualityName();
        this.i = "";
        this.j = "";
        this.f11769e = context;
        this.k = aVar;
        SurfaceHolder holder = getHolder();
        this.f11771g = holder;
        holder.addCallback(this);
    }
}
