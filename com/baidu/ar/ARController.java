package com.baidu.ar;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import com.baidu.ar.base.MsgField;
import com.baidu.ar.base.RequestController;
import com.baidu.ar.base.d;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.bean.ARResource;
import com.baidu.ar.imu.e;
import com.baidu.ar.load.FileManageTask;
import com.baidu.ar.load.downloader.DownloadManager;
import com.baidu.ar.load.util.ResponseUtil;
import com.baidu.ar.logo.CameraPreViewCallback;
import com.baidu.ar.parser.ParserJson;
import com.baidu.ar.recorder.MovieRecorderCallback;
import com.baidu.ar.resloader.ArCaseDownloadListener;
import com.baidu.ar.resloader.d;
import com.baidu.ar.rotate.Orientation;
import com.baidu.ar.rotate.OrientationManager;
import com.baidu.ar.task.ActionResponseListener;
import com.baidu.ar.test.PerformanceTest;
import com.baidu.ar.util.ARFileUtils;
import com.baidu.ar.util.ARLog;
import com.baidu.ar.util.ArResourceUtils;
import com.baidu.ar.util.Constants;
import com.baidu.ar.util.FileUtils;
import com.baidu.ar.util.SystemInfoUtil;
import com.baidu.ar.util.UiThreadUtil;
import com.baidu.baiduarsdk.ArBridge;
import com.baidu.baiduarsdk.ArTouchEvent;
import com.baidu.baiduarsdk.blend.TextureParams;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class ARController implements IDuMix {
    private static final String b = ARController.class.getSimpleName();
    private com.baidu.ar.base.b c;
    private com.baidu.baiduarsdk.blend.b d;
    private RequestController e;
    private Context f;
    private Context g;
    private DuMixSource h;
    private DuMixTarget i;
    private DuMixCallback j;
    private com.baidu.ar.base.a m;
    private AudioManager p;
    private boolean r;
    private CameraPreViewCallback t;
    private byte[] u;
    private com.baidu.ar.resloader.a x;
    private FileManageTask y;
    boolean a = false;
    private boolean k = true;
    private com.baidu.ar.d.a l = null;
    private TextureParams.SourceType o = TextureParams.SourceType.NONE;
    private boolean q = false;
    private int s = 0;
    private boolean v = true;
    private Runnable w = new Runnable() { // from class: com.baidu.ar.ARController.1
        @Override // java.lang.Runnable
        public void run() {
            ARController.this.v = true;
        }
    };
    private ArTouchEvent n = new ArTouchEvent(Looper.getMainLooper());

    public ARController(Context context, boolean z) {
        this.r = false;
        this.f = context;
        this.g = this.f.getApplicationContext();
        this.r = z;
        if (this.g != null) {
            ARFileUtils.setPackageName(this.g.getApplicationContext().getPackageName());
        }
        if (!this.r) {
            d();
        }
        f();
    }

    private TextureParams a(boolean z, boolean z2, DuMixSource duMixSource, DuMixTarget duMixTarget) {
        float f;
        boolean z3;
        int sourceWidth = duMixSource.getSourceWidth();
        int sourceHeight = duMixSource.getSourceHeight();
        int targetWidth = duMixTarget.getTargetWidth();
        int targetHeight = duMixTarget.getTargetHeight();
        int min = Math.min(sourceWidth, sourceHeight);
        int max = Math.max(sourceWidth, sourceHeight);
        float min2 = (Math.min(targetWidth, targetHeight) * 1.0f) / min;
        float max2 = (Math.max(targetWidth, targetHeight) * 1.0f) / max;
        if (Float.compare(max2, min2) < 0) {
            f = max2 / min2;
            z3 = true;
        } else {
            f = min2 / max2;
            z3 = false;
        }
        TextureParams textureParams = new TextureParams();
        textureParams.a(z2);
        textureParams.a(z3, (1.0f - f) / 2.0f);
        if (z) {
            textureParams.a(0, 90.0f, 1.0f, 1.0f, this.o);
            if (SystemInfoUtil.isNexus6P()) {
                textureParams.a(0, -90.0f, 1.0f, 1.0f, this.o);
            }
        } else {
            textureParams.a(1, -90.0f, 1.0f, 1.0f, this.o);
        }
        return textureParams;
    }

    private static String a(String str) {
        return FileUtils.readFileText(ARFileUtils.getDumixResJsonPath(str));
    }

    private void a() {
        if (this.c != null) {
            this.c.f();
            this.c = null;
        }
    }

    private void a(DuMixSource duMixSource) {
        if (!FileUtils.existsDir(duMixSource.getResFilePath())) {
            d.a((int) MsgField.IMSG_LOCAL_RES_NOT_EXIST, MsgField.SMSG_LOCAL_RES_NOT_EXIST);
        }
        com.baidu.ar.resloader.b.a();
        b();
        e();
        if (this.n != null) {
            this.n.a();
        }
        if (PerformanceTest.isTestOpen() && this.d != null) {
            Log.e(b, "loadLocalSO PerformanceTest PerformanceTest.getMaxFrameRate = " + PerformanceTest.getMaxFrameRate());
            this.d.a(PerformanceTest.getMaxFrameRate());
        }
        d.a((int) MsgField.IMSG_SO_LOAD_SUCCESS, MsgField.SMSG_SO_LOAD_SUCCESS);
        com.baidu.ar.resloader.b.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ARResource aRResource) {
        int type = aRResource.getType();
        ARConfig.setARType(type);
        switch (type) {
            case 0:
                this.c = new com.baidu.ar.track.a(this.f);
                break;
            case 1:
            case 2:
            case 4:
            default:
                ARLog.e("Resource Type error, not defined!");
                this.c = new com.baidu.ar.track.a(this.f);
                break;
            case 3:
                return;
            case 5:
                this.c = new com.baidu.ar.slam.a(this.f);
                break;
            case 6:
                this.c = new com.baidu.ar.recg.a(this.f);
                break;
            case 7:
                this.c = new com.baidu.ar.cloud.a(this.f);
                break;
            case 8:
                this.c = new e(this.f);
                break;
        }
        this.c.a(this);
        this.c.a(aRResource);
        this.c.l();
        if (this.j != null) {
            this.j.onCaseCreated(aRResource);
        }
        this.c.a(this.j);
        this.c.b(true);
        if (this.a) {
            this.c.d();
        }
    }

    private void a(String str, int i) {
        ARConfig.setARKey(str);
        ARConfig.setARType(i);
    }

    private void a(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        if (this.g == null) {
            Log.d("bdar", "bdar:mContext is Destoryed, so release mPreviewData!");
            this.u = null;
            return;
        }
        if (this.u == null || this.u.length != bArr.length) {
            this.u = new byte[bArr.length];
        }
        System.arraycopy(bArr, 0, this.u, 0, bArr.length);
    }

    private void a(byte[] bArr, com.baidu.ar.d.a aVar) {
        try {
            com.baidu.baiduarsdk.blend.b.a(bArr, aVar.a, aVar.b);
            this.d.d().d();
        } catch (NullPointerException e) {
            Log.e(b, "bdar: ARBlender object is null!");
            com.baidu.baiduarsdk.blend.b.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.d != null) {
            this.d.a(true);
        }
        if (this.n != null) {
            this.n.a(true);
        }
    }

    private void b(DuMixSource duMixSource) {
        com.baidu.ar.bean.a parseDuMixRes;
        if (!this.r || TextUtils.isEmpty(duMixSource.getResFilePath()) || (parseDuMixRes = ParserJson.parseDuMixRes(a(duMixSource.getResFilePath()))) == null) {
            return;
        }
        duMixSource.setArType(parseDuMixRes.a());
    }

    private void b(final ARResource aRResource) {
        d.a(2200, aRResource);
        this.y = new FileManageTask(aRResource.getZipFilePath(), aRResource.getResFilePath(), FileManageTask.FileMergeStrategy.SKIP, new ActionResponseListener<String>() { // from class: com.baidu.ar.ARController.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.ar.task.HttpResponseListener
            /* renamed from: a */
            public void onResponse(String str) {
                ARController.this.y = null;
                if (ResponseUtil.getIdFromResponse(str) == 0) {
                    ARController.this.c(aRResource);
                } else {
                    Log.d("unzip", "unzip error!");
                }
            }

            @Override // com.baidu.ar.task.HttpResponseListener
            public void onErrorResponse(String str) {
            }

            @Override // com.baidu.ar.task.ActionResponseListener
            public void onProgress(int i) {
            }

            @Override // com.baidu.ar.task.ActionResponseListener
            public void onUpdate(boolean z, float f) {
            }
        }, new FileManageTask.ExtraOperateListener() { // from class: com.baidu.ar.ARController.6
            @Override // com.baidu.ar.load.FileManageTask.ExtraOperateListener
            public String excuteChangeResult(String str) {
                Log.d("excuteChangeResult", "input:" + str);
                aRResource.setCaseConfigJsonInfo(ArResourceUtils.generateResult(str));
                return null;
            }
        });
        this.y.executeOnExecutor(com.baidu.ar.load.util.a.a(), new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ARResource aRResource) {
        ARConfig.setARKey(aRResource.getKey());
        if (this.c != null) {
            this.c.j();
            this.c = null;
        }
        a(aRResource);
    }

    private boolean c() {
        return (TextUtils.isEmpty(ARConfig.getARKey()) && ARConfig.getARType() == -1) ? false : true;
    }

    private boolean c(DuMixSource duMixSource) {
        if (duMixSource == null) {
            return false;
        }
        if (this.r) {
            return !TextUtils.isEmpty(duMixSource.getResFilePath());
        } else if (TextUtils.isEmpty(duMixSource.getArKey())) {
            int arType = duMixSource.getArType();
            return arType == 7 || arType == 6;
        } else {
            return true;
        }
    }

    private void d() {
        this.e = new RequestController(this.g);
        this.e.setOnSoLoadCallback(new d.a() { // from class: com.baidu.ar.ARController.3
            @Override // com.baidu.ar.resloader.d.a
            public void a(boolean z) {
                if (ARController.this.e == null) {
                    return;
                }
                if (!z) {
                    com.baidu.ar.base.d.a((int) MsgField.IMSG_SO_LOAD_FAILED, MsgField.SMSG_SO_LOAD_FAILED);
                    return;
                }
                ARController.this.b();
                if (ARController.this.n != null) {
                    ARController.this.n.a();
                }
                com.baidu.ar.base.d.a((int) MsgField.IMSG_SO_LOAD_SUCCESS, MsgField.SMSG_SO_LOAD_SUCCESS);
            }
        });
        this.e.setOnARResourceRequestListener(new RequestController.b() { // from class: com.baidu.ar.ARController.4
            @Override // com.baidu.ar.base.RequestController.b
            public void a(ARResource aRResource) {
                if (ARController.this.e == null || aRResource == null) {
                    return;
                }
                ARController.this.a(aRResource);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        ArBridge.getInstance().setDensity(this.g.getApplicationContext().getResources().getDisplayMetrics().density);
    }

    private void f() {
        ArBridge.getInstance().setScreenOrientationLandscape(SystemInfoUtil.isScreenOrientationLandscape(this.g));
        new DisplayMetrics();
        DisplayMetrics displayMetrics = this.g.getResources().getDisplayMetrics();
        ArBridge.getInstance().setScreenWidthHight(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    public static boolean isContainMisic(String str) {
        com.baidu.ar.bean.a parseDuMixRes;
        if (TextUtils.isEmpty(str) || (parseDuMixRes = ParserJson.parseDuMixRes(a(str))) == null) {
            return false;
        }
        return parseDuMixRes.c();
    }

    public static boolean isSupportFrontCamera(String str) {
        com.baidu.ar.bean.a parseDuMixRes;
        if (TextUtils.isEmpty(str) || (parseDuMixRes = ParserJson.parseDuMixRes(a(str))) == null) {
            return false;
        }
        return parseDuMixRes.b();
    }

    @Override // com.baidu.ar.IDuMix
    public void cancelDownloadCase(String str) {
        ARResource aRResource = new ARResource();
        if (TextUtils.isEmpty(str)) {
            Log.e("error", "null arKey");
            return;
        }
        aRResource.setKey(str);
        if (this.x != null) {
            this.x.a(aRResource);
        }
    }

    @Override // com.baidu.ar.IDuMix
    public void changeCase(DuMixSource duMixSource) {
        if (this.g == null) {
            return;
        }
        if (TextUtils.isEmpty(duMixSource.getResFilePath())) {
            if (TextUtils.equals(ARConfig.getARKey(), duMixSource.getArKey()) && !ProjectParams.isHuaweiProject()) {
                return;
            }
        } else if (TextUtils.equals(this.h.getResFilePath(), duMixSource.getResFilePath())) {
            return;
        }
        if (this.c != null) {
            if (Constants.DEBUG) {
                Log.e(b, "changeCase releaseForSwitchCase!!!");
            }
            this.c.j();
            this.c = null;
        }
        this.h = duMixSource;
        if (!c(duMixSource)) {
            Log.e(b, "changeCase DuMixSource is illegal!!!");
            return;
        }
        b(duMixSource);
        a(duMixSource.getArKey(), duMixSource.getArType());
        if (TextUtils.isEmpty(duMixSource.getResFilePath())) {
            d();
        } else {
            a(duMixSource);
            if (this.j != null) {
                this.j.onCaseChange(true);
            }
        }
        this.k = true;
    }

    public void changeCloudArState(int i) {
        if (this.c == null || !(this.c instanceof com.baidu.ar.cloud.a)) {
            return;
        }
        ((com.baidu.ar.cloud.a) this.c).a(i);
    }

    @Override // com.baidu.ar.IDuMix
    public void closeVolume() {
        if (this.p == null && this.g != null) {
            this.p = (AudioManager) this.g.getSystemService("audio");
        }
        if (this.p != null) {
            if (Build.VERSION.SDK_INT >= 23) {
                this.q = this.p.isStreamMute(3);
            }
            if (this.q) {
                return;
            }
            this.p.adjustStreamVolume(3, -100, 0);
        }
    }

    @Override // com.baidu.ar.IDuMix
    public void downloadCase(String str, ArCaseDownloadListener arCaseDownloadListener) {
        if (this.x == null) {
            this.x = new com.baidu.ar.resloader.a();
            DownloadManager.getInstance().onActivityResumed();
        }
        ARResource aRResource = new ARResource();
        if (TextUtils.isEmpty(str)) {
            Log.e("error", "null arKey");
            return;
        }
        aRResource.setKey(str);
        this.x.a(arCaseDownloadListener);
        this.x.a(this.g, aRResource);
    }

    public com.baidu.baiduarsdk.blend.b getBlender() {
        return this.d;
    }

    public RequestController getRequestController() {
        return this.e;
    }

    public boolean isEnginSoLoaded() {
        if (this.d != null) {
            return this.d.f();
        }
        return false;
    }

    @Override // com.baidu.ar.IDuMix
    public void onCameraPreviewFrame(byte[] bArr, int i, int i2) {
        if (bArr == null || this.j == null) {
            return;
        }
        if (this.k) {
            this.k = false;
            if (Constants.DEBUG) {
                Log.e(b, "onCameraPreviewFrame mFirstFrame = true");
            }
            if (this.h != null && !TextUtils.isEmpty(this.h.getResFilePath()) && FileUtils.existsDir(this.h.getResFilePath())) {
                ARResource aRResource = new ARResource();
                aRResource.setKey(this.h.getArKey());
                aRResource.setType(this.h.getArType());
                aRResource.setResFilePath(this.h.getResFilePath());
                aRResource.setCaseConfigJsonInfo(ArResourceUtils.generateResult(this.h.getResFilePath()));
                if (Constants.DEBUG) {
                    Log.e(b, "onCameraPreviewFrame arResource = " + aRResource.getCaseConfigJsonInfo());
                }
                a(aRResource);
            }
        }
        if (this.l == null) {
            this.l = new com.baidu.ar.d.a(i, i2);
        }
        if (this.o == TextureParams.SourceType.YUV_DATA) {
            if (this.v) {
                a(this.u, this.l);
            } else {
                a(bArr, this.l);
            }
            a(bArr);
        } else if (this.o == TextureParams.SourceType.SURFACE_TEXTURE) {
            try {
                this.d.d().d();
            } catch (NullPointerException e) {
                com.baidu.baiduarsdk.blend.b.i();
            }
        }
        if (this.c != null) {
            this.c.d(bArr, this.l);
        }
        if (this.t != null) {
            this.t.onPreviewCallback(bArr, i, i2);
        }
    }

    @Override // com.baidu.ar.IDuMix
    public void onClickCameraButton() {
        this.v = false;
    }

    public void onCreate(Bundle bundle) {
    }

    public void onDestroy() {
    }

    public void onPause() {
        pause();
    }

    public void onResume() {
        resume();
    }

    public void onStart() {
    }

    public void onStop() {
    }

    @Override // com.baidu.ar.IDuMix
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.n != null) {
            this.n.a(motionEvent);
            return true;
        }
        return false;
    }

    @Override // com.baidu.ar.IDuMix
    public void openVolume() {
        if (this.p == null && this.g != null) {
            this.p = (AudioManager) this.g.getSystemService("audio");
        }
        if (this.p != null) {
            this.p.adjustStreamVolume(3, 100, 0);
        }
    }

    @Override // com.baidu.ar.IDuMix
    public void orientationChange(int i) {
        Orientation calcOrientation;
        int degree;
        if (i == -1 || (calcOrientation = OrientationManager.calcOrientation(i, Orientation.valueOf(this.s))) == null || this.s == (degree = calcOrientation.getDegree())) {
            return;
        }
        this.s = degree;
        if (isEnginSoLoaded()) {
            com.baidu.ar.msghandler.a.a(this.s);
        }
    }

    @Override // com.baidu.ar.IDuMix
    public void pause() {
        this.a = false;
        if (this.c != null) {
            this.c.e();
        }
        if (this.n != null) {
            this.n.b();
        }
        if (this.e != null) {
            this.e.onPause();
            this.e.cancelQueryRes();
            this.e.cancelDownloadTask();
        }
        if (this.d != null) {
            this.d.b();
            ArBridge.getInstance().onPauseByUser();
        }
    }

    public void reSetup(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.d != null) {
            this.d.a(surfaceTexture, i, i2);
        }
    }

    @Override // com.baidu.ar.IDuMix
    public void release() {
        this.p = null;
        DownloadManager.getInstance().cancelAll();
        if (this.e != null) {
            this.e.release();
            this.e = null;
        }
        if (this.m != null) {
            this.m.c();
            this.m = null;
        }
        a();
        if (this.d != null) {
            this.d.c();
            this.d = null;
        }
        com.baidu.baiduarsdk.blend.b.i();
        com.baidu.ar.base.d.a();
        if (!this.q && this.p != null) {
            this.p.adjustStreamVolume(3, 100, 0);
        }
        if (this.j != null) {
            this.j.onRelease(true);
            this.j = null;
        }
        this.h = null;
        this.i = null;
        this.g = null;
        this.f = null;
        this.u = null;
        this.w = null;
    }

    @Override // com.baidu.ar.IDuMix
    public void reset() {
    }

    @Override // com.baidu.ar.IDuMix
    public void resume() {
        if (this.a) {
            return;
        }
        DownloadManager.getInstance().onActivityResumed();
        this.a = true;
        if (c()) {
            if (this.c != null) {
                this.c.d();
            }
            if (this.n != null) {
                this.n.a();
            }
            if (this.e != null) {
                this.e.onResume();
                if (this.c == null) {
                    this.e.start();
                }
            }
            if (this.d != null) {
                this.d.a();
            }
        }
    }

    @Override // com.baidu.ar.IDuMix
    public boolean sendMessage2Lua(HashMap<String, Object> hashMap) {
        if (this.c != null) {
            this.c.a(hashMap);
            return true;
        }
        return true;
    }

    public void setCameraPreViewCallback(CameraPreViewCallback cameraPreViewCallback) {
        this.t = cameraPreViewCallback;
    }

    public void setRecgArRetry() {
        if (this.c == null || !(this.c instanceof com.baidu.ar.recg.a)) {
            return;
        }
        ((com.baidu.ar.recg.a) this.c).m();
    }

    public void setRecgProcess(boolean z) {
        if (this.c == null || !(this.c instanceof com.baidu.ar.recg.a)) {
            return;
        }
        ((com.baidu.ar.recg.a) this.c).d(z);
    }

    public void setUserInteractionEnabled(boolean z) {
        if (this.n != null) {
            this.n.b(z);
        }
    }

    @Override // com.baidu.ar.IDuMix
    public void setup(DuMixSource duMixSource, DuMixTarget duMixTarget, DuMixCallback duMixCallback) {
        if (duMixCallback == null) {
            Log.e(b, "setup DuMixCallback is NULLLLL!!!");
        }
        if (!c(duMixSource)) {
            Log.e(b, "setup DuMixSource is illegal!!!");
            return;
        }
        this.h = duMixSource;
        this.i = duMixTarget;
        this.j = duMixCallback;
        this.o = duMixSource.getCameraSource() != null ? TextureParams.SourceType.SURFACE_TEXTURE : TextureParams.SourceType.YUV_DATA;
        com.baidu.ar.base.d.a(duMixCallback);
        b(duMixSource);
        a(duMixSource.getArKey(), duMixSource.getArType());
        boolean isOpen3DEngine = PerformanceTest.isOpen3DEngine();
        boolean isDrawCamera = PerformanceTest.isDrawCamera();
        this.d = new com.baidu.baiduarsdk.blend.b();
        if (isOpen3DEngine) {
            this.d.e();
            this.d.a(30);
        }
        this.d.d().a(0);
        this.d.a(duMixSource.getCameraSource(), a(this.h.isFrontCamera(), isDrawCamera, duMixSource, duMixTarget));
        this.d.a(duMixTarget.getDrawTarget(), duMixTarget.getTargetWidth(), duMixTarget.getTargetHeight());
        duMixTarget.getDrawTarget().setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: com.baidu.ar.ARController.2
            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                try {
                    if (1 == ArBridge.getInstance().getArGLEngineCtl().e() && !ArBridge.getInstance().getArGLEngineCtl().f()) {
                        ArBridge.getInstance().getArGLEngineCtl().b();
                    }
                } catch (Exception e) {
                }
                if (ARController.this.i == null || ARController.this.i.getTargetFrameAvailableListener() == null) {
                    return;
                }
                ARController.this.i.getTargetFrameAvailableListener().onFrameAvailable(surfaceTexture);
            }
        });
        if (this.r && !TextUtils.isEmpty(duMixSource.getResFilePath())) {
            a(duMixSource);
            if (this.j != null) {
                this.j.onSetup(true);
            }
        }
        Log.i(b, "setup end!!!");
    }

    @Override // com.baidu.ar.IDuMix
    public void startRecord(String str, long j, MovieRecorderCallback movieRecorderCallback) {
        int i = 1280;
        int i2 = 720;
        if (TextUtils.isEmpty(str) || j <= 0) {
            Log.e(b, "startRecord outputFile or totalTimeMs is error!!!");
            return;
        }
        com.baidu.ar.recorder.d.d dVar = new com.baidu.ar.recorder.d.d();
        dVar.a(str);
        int i3 = 0;
        Log.e(b, "startRecord mOrientation =" + this.s);
        if (this.s == 90 || this.s == -90) {
            i3 = this.s;
            i2 = 1280;
            i = 720;
        }
        dVar.a(i2);
        dVar.b(i);
        dVar.a(j);
        if (this.m == null && this.g != null) {
            this.m = new com.baidu.ar.base.a(this.g);
        }
        if (this.m != null) {
            this.m.a(dVar, movieRecorderCallback);
            this.m.b(i3);
        }
        if (this.d != null) {
            this.d.a(this.m);
        }
    }

    @Override // com.baidu.ar.IDuMix
    public void stopRecord() {
        if (this.d == null || this.m == null) {
            return;
        }
        this.d.b(this.m);
    }

    @Override // com.baidu.ar.IDuMix
    public void switchCamera(boolean z) {
        UiThreadUtil.removeCallbacks(this.w);
        UiThreadUtil.postDelayed(this.w, 3000L);
        if (z && this.r && !isSupportFrontCamera(this.h.getResFilePath())) {
            Log.e(b, "switchCamera not support front camera!!!");
            return;
        }
        this.d.a(a(z, PerformanceTest.isDrawCamera(), this.h, this.i));
        if (this.c != null) {
            this.c.c(z);
        }
    }

    public void switchCase(String str, int i) {
        if (TextUtils.equals(ARConfig.getARKey(), str) || this.g == null) {
            return;
        }
        if (this.c != null) {
            this.c.j();
            this.c = null;
        }
        a(str, i);
        this.e = new RequestController(this.g);
        this.e.setOnSoLoadCallback(new d.a() { // from class: com.baidu.ar.ARController.7
            @Override // com.baidu.ar.resloader.d.a
            public void a(boolean z) {
                if (ARController.this.g == null) {
                    return;
                }
                if (!z) {
                    com.baidu.ar.base.d.a((int) MsgField.IMSG_SO_LOAD_FAILED, MsgField.SMSG_SO_LOAD_FAILED);
                    return;
                }
                ARController.this.b();
                ARController.this.e();
                com.baidu.ar.base.d.a((int) MsgField.IMSG_SO_LOAD_SUCCESS, MsgField.SMSG_SO_LOAD_SUCCESS);
            }
        });
        this.e.setOnARResourceRequestListener(new RequestController.b() { // from class: com.baidu.ar.ARController.8
            @Override // com.baidu.ar.base.RequestController.b
            public void a(ARResource aRResource) {
                if (ARController.this.e == null || aRResource == null) {
                    return;
                }
                ARController.this.a(aRResource);
            }
        });
        this.k = true;
        this.e.start();
    }

    public boolean switchCaseForRecommend(ARResource aRResource) {
        if (TextUtils.equals(ARConfig.getARKey(), aRResource.getKey())) {
            return true;
        }
        if (this.y != null) {
            return false;
        }
        ARConfig.setARKey(aRResource.getKey());
        b(aRResource);
        return true;
    }

    @Override // com.baidu.ar.IDuMix
    public void takePicture(TakePictureCallback2 takePictureCallback2) {
        this.d.a(new com.baidu.ar.base.e(this.s, takePictureCallback2));
    }

    @Override // com.baidu.ar.IDuMix
    public void takePicture(String str, TakePictureCallback takePictureCallback) {
        if (TextUtils.isEmpty(str)) {
            Log.e(b, "takePicture outputFile is empty!!!");
            return;
        }
        this.d.a(new com.baidu.ar.base.e(str, this.s, takePictureCallback));
    }
}
