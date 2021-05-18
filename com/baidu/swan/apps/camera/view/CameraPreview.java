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
import d.a.i0.a.k;
import d.a.i0.a.v2.q;
import d.a.i0.t.d;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
/* loaded from: classes2.dex */
public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {
    public static final boolean l = k.f43025a;
    public static Camera m;

    /* renamed from: e  reason: collision with root package name */
    public Context f10752e;

    /* renamed from: f  reason: collision with root package name */
    public MediaRecorder f10753f;

    /* renamed from: g  reason: collision with root package name */
    public SurfaceHolder f10754g;

    /* renamed from: h  reason: collision with root package name */
    public String f10755h;

    /* renamed from: i  reason: collision with root package name */
    public String f10756i;
    public String j;
    public d.a.i0.a.z.e.a k;

    /* loaded from: classes2.dex */
    public enum Quality {
        HIGH("high", 100),
        NORMAL("normal", 70),
        LOW(Config.EXCEPTION_MEMORY_LOW, 40);
        
        public int qualityInt;
        public String qualityName;

        Quality(String str, int i2) {
            this.qualityName = str;
            this.qualityInt = i2;
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
        public final /* synthetic */ String f10757a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.z.c.a f10758b;

        /* renamed from: com.baidu.swan.apps.camera.view.CameraPreview$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0151a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ byte[] f10760e;

            public RunnableC0151a(byte[] bArr) {
                this.f10760e = bArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i2;
                int quality = Quality.getQuality(CameraPreview.this.f10755h);
                boolean z = CameraPreview.this.getResources().getConfiguration().orientation == 1;
                boolean z2 = CameraPreview.this.getFrontOrBackCameraId() == 0;
                if (z) {
                    i2 = z2 ? 90 : -90;
                } else {
                    i2 = 0;
                }
                boolean h2 = d.a.i0.a.z.a.b().h(this.f10760e, a.this.f10757a, quality, i2, !z2);
                a aVar = a.this;
                d.a.i0.a.z.c.a aVar2 = aVar.f10758b;
                if (aVar2 != null) {
                    if (h2) {
                        aVar2.onSuccess(aVar.f10757a);
                    } else {
                        aVar2.onFailure();
                    }
                }
            }
        }

        public a(String str, d.a.i0.a.z.c.a aVar) {
            this.f10757a = str;
            this.f10758b = aVar;
        }

        @Override // android.hardware.Camera.PictureCallback
        public void onPictureTaken(byte[] bArr, Camera camera) {
            try {
                camera.startPreview();
                CameraPreview.this.setCameraDisplayOrientation();
            } catch (RuntimeException e2) {
                if (CameraPreview.this.k != null) {
                    d.a.i0.a.z.a.b().e(CameraPreview.this.k.f40672g, CameraPreview.this.k.f40671f, false);
                }
                CameraPreview.this.h();
                if (CameraPreview.l) {
                    e2.printStackTrace();
                }
            }
            q.j(new RunnableC0151a(bArr), CommonTbJsBridge.SAVE_IMAGE);
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
        this.f10755h = Quality.NORMAL.getQualityName();
        this.f10756i = "";
        this.j = "";
    }

    private CamcorderProfile getCamcorderProfile() {
        int i2 = 5;
        if (!CamcorderProfile.hasProfile(5)) {
            i2 = CamcorderProfile.hasProfile(4) ? 4 : 1;
        }
        return CamcorderProfile.get(i2);
    }

    private int getDegree() {
        Context context = getContext();
        int i2 = 0;
        if (context instanceof Activity) {
            int rotation = ((Activity) context).getWindowManager().getDefaultDisplay().getRotation();
            if (rotation != 0) {
                if (rotation == 1) {
                    i2 = 90;
                } else if (rotation == 2) {
                    i2 = 180;
                } else if (rotation == 3) {
                    i2 = 270;
                }
            }
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(getFrontOrBackCameraId(), cameraInfo);
            if (cameraInfo.facing == 1) {
                return (360 - ((cameraInfo.orientation + i2) % 360)) % 360;
            }
            return ((cameraInfo.orientation - i2) + 360) % 360;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getFrontOrBackCameraId() {
        d.a.i0.a.z.e.a aVar = this.k;
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
        this.f10756i = str + File.separator + "VID_" + Calendar.getInstance().getTimeInMillis() + ".mp4";
        this.j = str + File.separator + "IMG_" + Calendar.getInstance().getTimeInMillis() + ".jpg";
        d.h(new File(this.f10756i));
    }

    public void e() {
        this.f10756i = "";
        this.j = "";
    }

    public final Camera.Size f(List<Camera.Size> list, int i2, int i3) {
        float f2;
        float f3;
        int i4;
        float f4;
        int i5;
        float f5;
        int i6;
        Camera.Size size = null;
        if (list != null && !list.isEmpty() && i3 != 0) {
            float f6 = i2 / i3;
            float f7 = -1.0f;
            boolean z = getDegree() % 180 == 0;
            Camera.Size size2 = null;
            for (Camera.Size size3 : list) {
                if (size3 != null) {
                    if (z) {
                        f4 = size3.width;
                        i5 = size3.height;
                    } else {
                        f4 = size3.height;
                        i5 = size3.width;
                    }
                    float f8 = (f4 / i5) - f6;
                    float abs = Math.abs(f8);
                    if (f7 < 0.0f) {
                        size = size3;
                        f7 = abs;
                    }
                    if (abs < f7) {
                        size = size3;
                        f7 = abs;
                    }
                    if ((z ? size3.width : size3.height) == i2) {
                        if (size2 != null) {
                            if (z) {
                                f5 = size2.width;
                                i6 = size2.height;
                            } else {
                                f5 = size2.height;
                                i6 = size2.width;
                            }
                            if (Math.abs(f8) < Math.abs((f5 / i6) - f6)) {
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
                    i4 = size.height;
                } else {
                    f2 = size2.height / size2.width;
                    f3 = size.height;
                    i4 = size.width;
                }
                if (Math.abs(f2 - f6) < Math.abs((f3 / i4) - f6) + 0.2f) {
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
                int i2 = this.k.i();
                Camera.Size f2 = f(parameters.getSupportedPreviewSizes(), j, i2);
                if (f2 != null) {
                    parameters.setPreviewSize(f2.width, f2.height);
                }
                Camera.Size f3 = f(parameters.getSupportedPictureSizes(), j, i2);
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
        d.a.i0.a.z.e.a aVar = this.k;
        return aVar == null ? "" : aVar.f40672g;
    }

    public String getThumbPath() {
        return this.j;
    }

    public String getVideoPath() {
        return this.f10756i;
    }

    public void h() {
        k();
        e();
        SurfaceHolder surfaceHolder = this.f10754g;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this);
        }
        j();
    }

    public final boolean i() {
        k();
        this.f10753f = new MediaRecorder();
        m = getCameraInstance();
        setCameraDisplayOrientation();
        if (getResources().getConfiguration().orientation == 1) {
            this.f10753f.setOrientationHint(90);
        }
        m.unlock();
        this.f10753f.setCamera(m);
        this.f10753f.setAudioSource(1);
        this.f10753f.setVideoSource(1);
        this.f10753f.setProfile(getCamcorderProfile());
        this.f10753f.setOutputFile(getVideoPath());
        this.f10753f.setVideoEncodingBitRate(8388608);
        this.f10753f.setPreviewDisplay(this.f10754g.getSurface());
        try {
            this.f10753f.prepare();
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
        MediaRecorder mediaRecorder = this.f10753f;
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
            this.f10753f.reset();
            this.f10753f.release();
            this.f10753f = null;
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
            this.f10753f.start();
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

    public void o(String str, d.a.i0.a.z.c.a aVar) {
        m.takePicture(null, null, new a(str, aVar));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() == 1) {
            try {
                d.a.i0.a.z.d.a.d(motionEvent, m, getWidth(), getHeight());
            } catch (Exception e2) {
                if (l) {
                    Log.d("SwanAppCameraManager", Log.getStackTraceString(e2));
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void p(d.a.i0.a.z.e.a aVar) {
        try {
            this.k = aVar;
            j();
            getCameraInstance();
            if (m != null) {
                m.setPreviewDisplay(this.f10754g);
                m.startPreview();
                setCameraDisplayOrientation();
                m.autoFocus(new b());
            }
        } catch (IOException | RuntimeException e2) {
            d.a.i0.a.z.a.b().e(aVar.f40672g, aVar.f40671f, false);
            if (l) {
                e2.printStackTrace();
            }
        }
    }

    public void setCameraDisplayOrientation() {
        m.setDisplayOrientation(getDegree());
    }

    public void setQuality(String str) {
        this.f10755h = str;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
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

    public CameraPreview(Context context, d.a.i0.a.z.e.a aVar) {
        super(context);
        this.f10755h = Quality.NORMAL.getQualityName();
        this.f10756i = "";
        this.j = "";
        this.f10752e = context;
        this.k = aVar;
        SurfaceHolder holder = getHolder();
        this.f10754g = holder;
        holder.addCallback(this);
    }
}
