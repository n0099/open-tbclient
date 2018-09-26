package com.baidu.ar.base;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.ar.ARController;
import com.baidu.ar.DuMixCallback;
import com.baidu.ar.bean.ARResource;
import com.baidu.ar.bean.TipBean;
import com.baidu.ar.bean.TrackRes;
import com.baidu.ar.logo.IttRecognitionManager;
import com.baidu.ar.msghandler.DownloadMsgHandler;
import com.baidu.ar.msghandler.f;
import com.baidu.ar.paddle.PaddleManager;
import com.baidu.ar.rotate.OrientationManager;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.ar.statistic.StatisticHelper;
import com.baidu.ar.track.TrackStateMachine;
import com.baidu.ar.util.ARFileUtils;
import com.baidu.ar.util.ARLog;
import com.baidu.ar.util.Constants;
import com.baidu.ar.util.ImageUtils;
import com.baidu.ar.util.MsgConstants;
import com.baidu.ar.util.UiThreadUtil;
import com.baidu.baiduarsdk.ArBridge;
import java.io.File;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class b {
    private static volatile boolean u = false;
    private f A;
    protected Context a;
    protected ARResource c;
    protected DuMixCallback d;
    protected ARController e;
    protected com.baidu.ar.d.a f;
    protected com.baidu.ar.algo.a.c.a g;
    protected TrackRes h;
    protected com.baidu.ar.msghandler.a i;
    protected boolean j;
    protected com.baidu.ar.imu.b k;
    protected int l;
    protected int m;
    protected com.baidu.baiduarsdk.a.c p;
    protected com.baidu.ar.bean.c q;
    protected long r;
    private Timer s;
    private TimerTask t;
    private String w;
    private DownloadMsgHandler z;
    protected boolean b = true;
    protected boolean n = false;
    protected boolean o = false;
    private boolean v = false;
    private boolean x = false;
    private boolean y = false;

    public b(Context context) {
        this.a = context.getApplicationContext();
        this.i = new com.baidu.ar.msghandler.a(context);
        this.k = new com.baidu.ar.imu.b(this.a);
        this.p = new com.baidu.baiduarsdk.a.c(this.a);
    }

    private void b(final com.baidu.ar.d.a aVar) {
        ARLog.e("onFirstPreviewFrameBack !!!!");
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.base.b.3
            @Override // java.lang.Runnable
            public void run() {
                b.this.a(aVar);
            }
        });
    }

    private void e(byte[] bArr, com.baidu.ar.d.a aVar) {
        if (u) {
            u = false;
            File file = new File("/sdcard/DCIM/camera/" + ("YUVImage-" + System.currentTimeMillis() + ".jpg"));
            ImageUtils.saveYUVImage2Jpg(file.getPath(), bArr, aVar.a, aVar.b);
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(Uri.fromFile(file));
            this.a.sendBroadcast(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        this.r = System.currentTimeMillis();
        this.v = true;
        ArBridge.getInstance().createCase(this.w, null, this.m, this.l);
        StatisticHelper.getInstance().statisticInfo(StatisticConstants.START_LOADING_3D_MODEL);
        k();
    }

    private void n() {
        if (this.s != null) {
            this.s.cancel();
            this.s.purge();
            this.s = null;
        }
        if (this.t != null) {
            this.t.cancel();
            this.t = null;
        }
    }

    private void o() {
        if (this.c.getType() == 0 || this.c.getType() == 8) {
            String str = this.h.getPaddle() != null ? ARFileUtils.getARCaseFullPath(this.c.getKey()) + File.separator + this.h.getPaddle().a() : null;
            HashMap hashMap = new HashMap();
            hashMap.put("path", str);
            hashMap.put("secretKey", "bai@!duA84$[|secu&^rity*");
            if (this.d != null) {
                this.d.onStateChange(MsgField.MSG_PADDLE_INIT, hashMap);
            }
        }
    }

    public void a() {
        if (this.p != null) {
            this.p.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Bundle bundle) {
        b(bundle);
    }

    public void a(ARController aRController) {
        this.e = aRController;
    }

    public void a(DuMixCallback duMixCallback) {
        this.d = duMixCallback;
        this.i.a(duMixCallback);
    }

    public void a(ARResource aRResource) {
        this.c = aRResource;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.ar.d.a aVar) {
        boolean b = b();
        ARLog.e("onFirstPreviewFrameBack !!!!");
        if (b) {
            com.baidu.ar.msghandler.a.a(OrientationManager.getGlobalOrientation().getDegree());
        }
        b(this.c.getCaseConfigJsonInfo());
    }

    public void a(String str) {
        this.o = true;
        this.w = str;
        if (this.x) {
            return;
        }
        if (this.n) {
            m();
        }
        o();
    }

    public void a(HashMap<String, Object> hashMap) {
        ArBridge.getInstance().sendMessage(ArBridge.MessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
    }

    public void a(boolean z) {
        this.e.setUserInteractionEnabled(z);
    }

    protected void a(byte[] bArr, com.baidu.ar.d.a aVar) {
        ARLog.d("previewFrame mIsResumed = " + this.b);
        if (this.b && bArr != null) {
            if (this.f == null) {
                ARLog.e("previewFrame mPreviewSize = " + (this.f != null));
                try {
                    this.f = aVar;
                    this.l = this.f.a;
                    this.m = this.f.b;
                    ARLog.i("bdar: width = " + this.f.a + ", height = " + this.f.b);
                    b(this.f);
                    com.baidu.ar.algo.a.a(this.f.a, this.f.b, bArr.length);
                } catch (Exception e) {
                    ARLog.e("previewFrame error!!!");
                    e.printStackTrace();
                    return;
                }
            }
            if (Constants.DEBUG_PREVIEW_FRAME) {
                e(bArr, aVar);
            }
            b(bArr, aVar);
            if (this.n && this.o && !this.v) {
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.base.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.x) {
                            return;
                        }
                        b.this.m();
                    }
                });
            }
        }
    }

    protected void b(Bundle bundle) {
        ARLog.w(StatisticConstants.TRACKED);
        if (bundle == null) {
            ARLog.e("track result is null!");
        } else if (TrackStateMachine.getInstance().getTrackState() == TrackStateMachine.STATE.TRACKED) {
            float f = bundle.getFloat("distance");
            try {
                TipBean tipBean = this.h.getTipBean();
                if (!Float.isNaN(tipBean.getFarThreshold()) && !Float.isNaN(tipBean.getNearThreshold())) {
                    if (f > tipBean.getFarThreshold()) {
                        d.a((int) MsgField.IMSG_TRACK_DISTANCE_TOO_FAR, MsgField.SMSG_TRACK_DISTANCE_TOO_FAR);
                    } else if (f < tipBean.getNearThreshold()) {
                        d.a((int) MsgField.IMSG_TRACK_DISTANCE_TOO_NEAR, MsgField.SMSG_TRACK_DISTANCE_TOO_NEAR);
                    } else {
                        d.a((int) MsgField.IMSG_TRACK_DISTANCE_NORMAL, MsgField.SMSG_TRACK_DISTANCE_NORMAL);
                    }
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String str2 = (String) new JSONObject(str).opt("unzip_path");
            IttRecognitionManager.getInstance().parseRecognition((str2 + File.separator + ARFileUtils.AR_UNZIP_ROOT_DIR).concat(File.separator).concat("res/logo.json"));
            if (TextUtils.isEmpty(str2) || this.i == null) {
                return;
            }
            this.i.a(new com.baidu.ar.msghandler.c(str2.concat(File.separator).concat(ARFileUtils.AR_UNZIP_ROOT_DIR), this.e.getBlender()));
        } catch (JSONException e) {
        }
    }

    public void b(boolean z) {
        this.n = z;
        if (z) {
            c();
            g();
        }
    }

    protected void b(byte[] bArr, com.baidu.ar.d.a aVar) {
        long currentTimeMillis = Constants.DEBUG_PREVIEW_FRAME ? System.currentTimeMillis() : 0L;
        if (this.n) {
            c(bArr, aVar);
            if (PaddleManager.getInstance().isValid()) {
                PaddleManager.getInstance().detectGesture(bArr, aVar.a, aVar.b);
            }
            if (Constants.DEBUG_PREVIEW_FRAME) {
                ARLog.e("bdar: processPreviewFrame time = " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    public boolean b() {
        return this.e != null && this.e.isEnginSoLoaded();
    }

    public void c() {
        if (this.i != null) {
            this.i.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        switch (((Integer) bundle.get(MsgConstants.MSG_EXTRA_VIEW_VISIBLE_ID)).intValue()) {
            case 0:
                d.a(100);
                return;
            case 1:
                d.a(101);
                return;
            case 2:
                d.a(110);
                return;
            case 3:
                d.a(111);
                return;
            case 4:
                d.a(102);
                return;
            case 5:
                d.a(103);
                return;
            default:
                return;
        }
    }

    public void c(boolean z) {
        this.y = z;
    }

    protected void c(byte[] bArr, com.baidu.ar.d.a aVar) {
    }

    public void d() {
        this.b = true;
        com.baidu.ar.a.b.a(this.a).a(true);
        try {
            this.p.a();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public void d(byte[] bArr, com.baidu.ar.d.a aVar) {
        a(bArr, aVar);
    }

    public void e() {
        this.b = false;
        this.f = null;
        com.baidu.ar.a.b.a(this.a).a(false);
        n();
        if (this.p != null) {
            this.p.c();
        }
    }

    public void f() {
        if (this.p != null) {
            this.p.c();
            this.p = null;
        }
        if (b()) {
            ArBridge.getInstance().destroyCase();
            ARLog.e("bdar:destroyCase");
        }
        if (this.p != null) {
            this.p.c();
            this.p = null;
        }
        this.x = true;
        PaddleManager.getInstance().release();
        if (this.i != null) {
            this.i.a();
            this.i = null;
        }
        if (this.d != null) {
            this.d = null;
        }
        if (this.z != null) {
            this.z.release();
            this.z = null;
        }
        if (this.A != null) {
            this.A.a();
            this.A = null;
        }
        n();
        this.k.a();
        com.baidu.ar.a.b.a(this.a).a();
        com.baidu.ar.algo.a.a();
        if (this.k != null) {
            this.k.b();
        }
        ArBridge.getInstance().release();
    }

    protected void g() {
        if (Constants.AR_IS_NEED_PRINT_FRAME_LOG) {
            this.s = new Timer();
            this.t = new TimerTask() { // from class: com.baidu.ar.base.b.2
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    ARLog.d("the engine fps is : " + ArBridge.getInstance().getFps());
                }
            };
            this.s.schedule(this.t, 0L, Constants.PRINT_FPS_INTERVAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h() {
        ArBridge.getInstance().removeMessageHandeler(this.i);
        if (this.i != null) {
            this.i.a();
            this.i = null;
        }
        ArBridge.getInstance().onPauseByUser();
        ArBridge.getInstance().clearScreen();
        if (ArBridge.getInstance().getArGLEngineCtl() != null) {
            ArBridge.getInstance().getArGLEngineCtl().a(1);
        }
        ArBridge.getInstance().destroyCase();
    }

    protected void i() {
        if (this.k != null) {
            this.k.a();
            this.k.b();
        }
    }

    public void j() {
        this.x = true;
        i();
        n();
        com.baidu.ar.a.b.a(this.a).a();
        f();
    }

    protected void k() {
        ArBridge.getInstance().executeOnGLThread(new Runnable() { // from class: com.baidu.ar.base.b.4
            @Override // java.lang.Runnable
            public void run() {
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.base.b.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.a(2201, b.this.c);
                    }
                });
            }
        });
    }

    public void l() {
        try {
            this.z = new DownloadMsgHandler(this.c.getKey(), this.a);
            this.i.a(this.z);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        try {
            this.A = new f(this.c.getKey(), this.a);
            this.i.a(this.A);
        } catch (NullPointerException e2) {
            e2.printStackTrace();
        }
    }
}
