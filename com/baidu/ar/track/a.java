package com.baidu.ar.track;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.ar.algo.a.c.c;
import com.baidu.ar.base.MsgField;
import com.baidu.ar.base.d;
import com.baidu.ar.bean.TrackRes;
import com.baidu.ar.bean.f;
import com.baidu.ar.imu.b;
import com.baidu.ar.msghandler.e;
import com.baidu.ar.parser.ParserJson;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.ar.statistic.StatisticHelper;
import com.baidu.ar.track.TrackStateMachine;
import com.baidu.ar.util.ARFileUtils;
import com.baidu.ar.util.ARLog;
import com.baidu.ar.util.MsgConstants;
import java.io.File;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends com.baidu.ar.base.b {
    protected b s;
    protected com.baidu.ar.algo.a.c.b t;
    protected boolean u;
    private boolean v;
    private String w;
    private C0047a x;

    /* renamed from: com.baidu.ar.track.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0047a implements com.baidu.ar.algo.b.a.a {
        @Override // com.baidu.ar.algo.b.a.a
        public void a(Bundle bundle) {
            if (bundle == null || bundle.getInt("track2D_method_type") == 0) {
                return;
            }
            boolean z = bundle.getBoolean("isTracked");
            bundle.getBoolean("isTrackStatusValid");
            boolean z2 = bundle.getBoolean("trackedFromTrackLost");
            boolean z3 = bundle.getBoolean("trackLostFromTracked");
            StatisticHelper.getInstance().statisticTrackedStatus(z);
            if (z) {
                if (z2) {
                    d.a((int) MsgField.IMSG_TRACK_FOUND, MsgField.SMSG_TRACK_FOUND);
                    TrackStateMachine.getInstance().processEvent(TrackStateMachine.EVENT.TRACK_SUCCESS);
                }
            } else if (z3) {
                d.a((int) MsgField.IMSG_TRACK_LOST, MsgField.SMSG_TRACK_LOST);
                TrackStateMachine.getInstance().processEvent(TrackStateMachine.EVENT.TRACK_FAILED);
            }
            TrackStateMachine.getInstance().processRtMatrix(bundle);
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes3.dex */
    public static class b extends Handler {
        private WeakReference<a> a;

        public b(a aVar) {
            super(Looper.getMainLooper());
            this.a = new WeakReference<>(aVar);
        }

        public void a() {
            if (this.a != null) {
                this.a.clear();
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar = this.a.get();
            if (aVar == null) {
                return;
            }
            switch (message.what) {
                case 301:
                    Log.e("qatest", "加载资源: " + (System.currentTimeMillis() - aVar.r) + " ms");
                    d.a((int) MsgField.IMSG_MODEL_LOADED, MsgField.SMSG_MODEL_LOADED);
                    return;
                case 302:
                    aVar.a(message.getData());
                    if (aVar.v) {
                        return;
                    }
                    aVar.v = true;
                    return;
                case MsgConstants.TRACK_MODEL_SHOWING /* 306 */:
                    StatisticConstants.setIsRenderModel(true);
                    if (!aVar.j) {
                        StatisticHelper.getInstance().statisticInfo(StatisticConstants.START_AR_ANIM);
                        aVar.j = true;
                    }
                    d.a(2101, MsgField.SMSG_MODE_SHOWING);
                    return;
                case 307:
                    d.a((int) MsgField.IMSG_TRACK_MODEL_NOT_SHOWING, " track model disapper!");
                    return;
                case MsgConstants.TRACK_HIDE_LOST_INFO /* 309 */:
                    d.a((int) MsgField.IMSG_TRACK_HIDE_LOST_INFO, " track model disapper!");
                    return;
                case MsgConstants.TRACK_MSG_ID_TRACK_LOST /* 310 */:
                    d.a(2105, MsgField.SMSG_TRACK_MSG_ID_TRACK_LOST);
                    return;
                case MsgConstants.TRACK_MODEL_CAN_DISAPPEARING /* 312 */:
                    d.a(2104, Boolean.valueOf(message.getData() != null ? message.getData().getInt("show_immediately") == 1 : false));
                    return;
                case MsgConstants.TRACK_IMU_OPEN /* 313 */:
                    if (message.getData().getInt("type") == 1) {
                        aVar.a();
                        return;
                    }
                    return;
                case MsgConstants.TRACK_SHOW_CAPTURE /* 314 */:
                default:
                    return;
                case MsgConstants.TRACK_OPEN_TRACK_ALGO /* 318 */:
                    aVar.n();
                    return;
                case MsgConstants.TRACK_CLOSE_TRACK_ALGO /* 319 */:
                    aVar.m();
                    return;
                case 30000:
                    aVar.c(message.getData());
                    return;
            }
        }
    }

    public a(Context context) {
        super(context);
        this.s = null;
        this.v = false;
        this.u = true;
        this.x = new C0047a();
        this.g = new com.baidu.ar.algo.a.c.a();
        TrackStateMachine.getInstance().init();
        TrackStateMachine.getInstance().setIMUController(this.k);
        this.k.a(new b.InterfaceC0039b() { // from class: com.baidu.ar.track.a.1
            @Override // com.baidu.ar.imu.b.InterfaceC0039b
            public void a(float[] fArr) {
                Bundle bundle = new Bundle();
                bundle.putFloatArray("RMatrix", fArr);
                TrackStateMachine.getInstance().processRMatrix(bundle);
            }
        });
        if (this.s == null) {
            this.s = new b(this);
        }
        TrackStateMachine.getInstance().setMainThreadHandler(this.s);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Bitmap a(TrackRes trackRes, String str) {
        Bitmap a;
        boolean z;
        Bitmap bitmap = null;
        if (trackRes == null) {
            return null;
        }
        try {
            if (trackRes.getTipBean() == null) {
                return null;
            }
            String trackTargePicPath = trackRes.getTipBean().getTrackTargePicPath();
            if (TextUtils.isEmpty(trackTargePicPath)) {
                return null;
            }
            String str2 = str + File.separator + trackTargePicPath;
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            Bitmap decodeFile = BitmapFactory.decodeFile(str2, options);
            try {
                int i = options.outWidth;
                int i2 = options.outHeight;
                if (i2 > i) {
                    if (i2 > 900) {
                        options.inJustDecodeBounds = false;
                        a = a(options, false, str2);
                        z = true;
                        if (z) {
                            options.inJustDecodeBounds = false;
                            return BitmapFactory.decodeFile(str2, options);
                        }
                        return a;
                    }
                    a = decodeFile;
                    z = false;
                    if (z) {
                    }
                } else {
                    if (i > 500) {
                        options.inJustDecodeBounds = false;
                        a = a(options, true, str2);
                        z = true;
                        if (z) {
                        }
                    }
                    a = decodeFile;
                    z = false;
                    if (z) {
                    }
                }
            } catch (Exception e) {
                bitmap = decodeFile;
                e = e;
                e.printStackTrace();
                return bitmap;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    private c a(f fVar) {
        c cVar = new c();
        String str = fVar.a() + File.separator + fVar.b();
        ARLog.d("szModelFile = " + str);
        int c = fVar.c();
        int d = fVar.d();
        int[] iArr = {(int) (fVar.e().a - (fVar.c() / 2)), (int) (fVar.e().b - (fVar.d() / 2)), fVar.c(), fVar.d()};
        cVar.c = c;
        cVar.d = d;
        cVar.b = str;
        cVar.a = iArr;
        return cVar;
    }

    private void a(TrackRes trackRes) {
        if (trackRes == null || !this.u) {
            return;
        }
        if (trackRes.getTargetBeanList() == null) {
            throw new NullPointerException("track target info is null !!!");
        }
        ARLog.d("enableArTracking");
        c a = a(trackRes.getTargetBeanList().get(0));
        if (this.t == null) {
            this.t = new com.baidu.ar.algo.a.c.b(a);
        }
    }

    private void o() {
        if (this.s != null) {
            this.s.removeCallbacksAndMessages(null);
            this.s.a();
            this.s = null;
        }
        TrackStateMachine.getInstance().setMainThreadHandler(null);
    }

    public Bitmap a(BitmapFactory.Options options, boolean z, String str) {
        float f;
        int i;
        int i2;
        float f2 = ((options.outWidth * 1.0f) / options.outHeight) * 1.0f;
        if (z) {
            f = options.outWidth / 500;
            i2 = 500;
            i = (int) (500 / f2);
        } else {
            f = options.outHeight / 900;
            i = 900;
            i2 = (int) (900 * f2);
        }
        options.outWidth = i2;
        options.outHeight = i;
        options.inSampleSize = (int) f;
        return BitmapFactory.decodeFile(str, options);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.base.b
    public void a(Bundle bundle) {
        super.a(bundle);
        if (this.v) {
            return;
        }
        this.v = true;
    }

    @Override // com.baidu.ar.base.b
    public void b(String str) {
        super.b(str);
        if (!TextUtils.isEmpty(this.w) && TextUtils.equals(this.w, str)) {
            TrackStateMachine.getInstance().processEvent(TrackStateMachine.EVENT.DOWNLOAD_RES_FINISH);
        } else if (TextUtils.isEmpty(str)) {
            d.a((int) MsgField.MSG_ON_PARSE_RESOURCE_UNZIP_ERROR);
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String str2 = (String) jSONObject.opt("unzip_path");
                String str3 = (String) jSONObject.opt("defalt_json");
                String str4 = (String) jSONObject.opt("target_json");
                String str5 = (String) jSONObject.opt("res_config");
                TrackRes parseCaseConfig = ParserJson.parseCaseConfig(str2, str3, str4);
                String str6 = str2 + File.separator + ARFileUtils.AR_UNZIP_ROOT_DIR;
                if (parseCaseConfig == null) {
                    d.a((int) MsgField.MSG_ON_PARSE_RESOURCE_JSON_ERROR);
                    return;
                }
                com.baidu.ar.bean.c a = com.baidu.ar.parser.a.a(str2, str5);
                this.h = parseCaseConfig;
                this.q = a;
                if (this.i != null) {
                    this.i.a(this.q);
                } else {
                    ARLog.e("ARMessageHandler is null");
                }
                d.a((int) MsgField.IMSG_TRACKED_TIPS_INFO, parseCaseConfig);
                d.a((int) MsgField.IMSG_TRACKED_TARGET_BITMAP_RES, a(this.h, str6));
                if (this.h != null) {
                    if (this.h.getService() != null) {
                        this.u = this.h.getService().a() == 1;
                    }
                    a(str6);
                    a(this.h);
                }
                TrackStateMachine.getInstance().processEvent(TrackStateMachine.EVENT.DOWNLOAD_RES_FINISH);
                this.w = str;
                a(true);
            } catch (JSONException e) {
                d.a((int) MsgField.MSG_ON_PARSE_RESOURCE_UNZIP_ERROR);
            }
        }
    }

    @Override // com.baidu.ar.base.b
    protected void c(byte[] bArr, com.baidu.ar.d.a aVar) {
        StatisticHelper.getInstance().statisticFrameRate(StatisticConstants.TRACK_FRAME_AVG_TIME);
        try {
            int i = this.f.a;
            int i2 = this.f.b;
            if (!this.u || this.t == null) {
                return;
            }
            com.baidu.ar.algo.a.a(bArr, i, i2, this.t, this.x);
        } catch (NullPointerException e) {
            ARLog.e("bdar: mPreviewSize is null!!!!");
        }
    }

    @Override // com.baidu.ar.base.b
    public void d() {
        super.d();
        TrackStateMachine.setAppState(TrackStateMachine.STATE.RESUME);
        if (this.j) {
            StatisticHelper.getInstance().statisticInfo(StatisticConstants.RESUME_AR);
        }
        e.a().a(this.s);
    }

    @Override // com.baidu.ar.base.b
    public void e() {
        super.e();
        TrackStateMachine.setAppState(TrackStateMachine.STATE.PAUSE);
        if (this.j) {
            StatisticHelper.getInstance().statisticInfo(StatisticConstants.INTERRUPT_AR);
        }
    }

    @Override // com.baidu.ar.base.b
    public void f() {
        super.f();
        o();
        TrackStateMachine.setAppState(TrackStateMachine.STATE.DESTROY);
        TrackStateMachine.destroy();
        if (this.t != null) {
            com.baidu.ar.algo.a.a(this.t);
        }
        this.t = null;
        e();
    }

    @Override // com.baidu.ar.base.b
    public void j() {
        super.j();
        o();
        if (this.t != null) {
            this.t.a();
            this.t = null;
        }
        com.baidu.ar.algo.a.a();
        h();
    }

    public void m() {
        this.u = false;
        if (this.t != null) {
            com.baidu.ar.algo.a.a(this.t);
            this.t = null;
        }
    }

    public void n() {
        if (this.u) {
            return;
        }
        this.u = true;
        a(this.h);
    }
}
