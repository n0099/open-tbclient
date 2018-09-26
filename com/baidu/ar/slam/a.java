package com.baidu.ar.slam;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.ar.algo.TrackModel;
import com.baidu.ar.algo.a.b.b;
import com.baidu.ar.base.MsgField;
import com.baidu.ar.base.d;
import com.baidu.ar.bean.TrackRes;
import com.baidu.ar.bean.e;
import com.baidu.ar.msghandler.ComponentMessageType;
import com.baidu.ar.parser.ParserJson;
import com.baidu.ar.slam.SlamStateMachine;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.ar.statistic.StatisticHelper;
import com.baidu.ar.test.PerformanceTest;
import com.baidu.ar.util.ARFileUtils;
import com.baidu.ar.util.ARLog;
import com.baidu.ar.util.MsgConstants;
import com.baidu.baiduarsdk.ArBridge;
import com.baidu.mobstat.Config;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends com.baidu.ar.base.b {
    private static boolean x = false;
    private static int y = 2;
    private b A;
    private String B;
    private boolean C;
    private c s;
    private com.baidu.ar.algo.a.b.b t;
    private C0043a u;
    private boolean v;
    private e w;
    private float[] z;

    /* renamed from: com.baidu.ar.slam.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0043a implements b.a {
        com.baidu.ar.imu.b a;

        C0043a(com.baidu.ar.imu.b bVar) {
            this.a = bVar;
        }

        @Override // com.baidu.ar.algo.a.b.b.a
        public float[] a() {
            if (this.a != null) {
                return this.a.c();
            }
            return null;
        }

        @Override // com.baidu.ar.algo.a.b.b.a
        public float b() {
            return com.baidu.ar.imu.b.k;
        }

        public void c() {
            if (this.a != null) {
                this.a.b();
                this.a = null;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements com.baidu.ar.algo.b.a.a {
        private int a = 0;

        @Override // com.baidu.ar.algo.b.a.a
        public void a(Bundle bundle) {
            if (bundle == null) {
                ARLog.e("bdar:slam imu data error!!!!!");
            } else if (this.a >= 3) {
                a.e(bundle);
            } else {
                this.a++;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends Handler {
        private WeakReference<a> a;

        public c(a aVar) {
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
            super.handleMessage(message);
            a aVar = this.a.get();
            if (aVar == null) {
                return;
            }
            switch (message.what) {
                case 501:
                    aVar.m();
                    d.a((int) MsgField.IMSG_MODEL_LOADED, MsgField.SMSG_MODEL_LOADED);
                    return;
                case MsgConstants.SLAM_MODEL_SHOWING /* 506 */:
                case 512:
                default:
                    return;
                case MsgConstants.SLAM_GESTURE_INTERACTION /* 524 */:
                    aVar.d(message.getData());
                    return;
                case MsgConstants.SLAM_START_FROM_LUA /* 525 */:
                    aVar.C = true;
                    return;
                case 30000:
                    aVar.c(message.getData());
                    return;
            }
        }
    }

    public a(Context context) {
        super(context);
        this.z = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        this.A = new b();
        this.C = true;
        SlamStateMachine.a().b();
        SlamStateMachine.a().a(this.k);
        if (PerformanceTest.isOpenSlam()) {
            this.k.a(0);
        }
        this.u = new C0043a(this.k);
        if (this.s == null) {
            this.s = new c(this);
        }
        SlamStateMachine.a().a(this.s);
    }

    private int a(float[] fArr, int i) {
        return 90.0f - ((float) (((Math.acos((double) (-fArr[10])) * 180.0d) * 1.0d) / 3.141592653589793d)) > ((float) i) ? 0 : 1;
    }

    private void a(int i, int i2) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", 4101);
        hashMap.put(ComponentMessageType.MSG_TYPE_SLAM_PLACE_GUIDE_DIRCTION, Integer.valueOf(i2));
        hashMap.put(ComponentMessageType.MSG_TYPE_SLAM_PLACE_GUIDE_DATA, Integer.valueOf(i));
        ArBridge.getInstance().sendMessage(ArBridge.MessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
    }

    private void c(String str) {
        if (this.h != null) {
            a(str);
        }
    }

    public static void e(Bundle bundle) {
        ArrayList parcelableArrayList;
        if (bundle == null || (parcelableArrayList = bundle.getParcelableArrayList("slam_track_result")) == null || parcelableArrayList.size() <= 0) {
            return;
        }
        if (x) {
            ArBridge.getInstance().setSlamRelocationType(y);
            x = false;
        }
        SlamStateMachine.a().a(bundle, ((TrackModel) parcelableArrayList.get(0)).pose);
    }

    private void o() {
        if (this.s != null) {
            this.s.removeCallbacksAndMessages(null);
            this.s.a();
            this.s = null;
        }
        SlamStateMachine.a().a((Handler) null);
    }

    private void p() {
        try {
            int i = this.f.a;
            int i2 = this.f.b;
            if (this.w == null) {
                com.baidu.ar.algo.a.a((this.w == null || TextUtils.isEmpty(this.w.a())) ? "slam_model_1" : this.w.a(), i / 2, i2 / 2, this.z, 1000, this.t);
                this.v = true;
                StatisticHelper.getInstance().statisticInfo(StatisticConstants.SLAM_TRACK_ON);
                this.j = true;
                return;
            }
            int i3 = i / 2;
            int i4 = i2 / 2;
            if (this.w.b() != 1) {
                if (this.w.b() == 0) {
                    String[] split = this.w.c().split(",");
                    try {
                        int[] a = a(Float.parseFloat(split[0].trim()), Float.parseFloat(split[1].trim()));
                        i3 = a[0];
                        i4 = a[1];
                    } catch (NumberFormatException e) {
                        ARLog.e("model position is not number !!!");
                    }
                    com.baidu.ar.algo.a.a((this.w == null || TextUtils.isEmpty(this.w.a())) ? "slam_model_1" : this.w.a(), i3, i4, this.z, this.w.d(), this.t);
                    this.v = true;
                    StatisticHelper.getInstance().statisticInfo(StatisticConstants.SLAM_TRACK_ON);
                    this.j = true;
                    return;
                }
                return;
            }
            float[] a2 = com.baidu.ar.algo.a.a(this.w.e(), this.k.c(), this.t);
            if (a2 != null) {
                int i5 = (int) a2[0];
                if (i5 == 0) {
                    int a3 = a(this.k.c(), this.w.e());
                    if (a3 == 0) {
                        a(1, 0);
                    } else if (a3 == 1) {
                        a(1, 1);
                    }
                } else if (i5 == 1) {
                    com.baidu.ar.algo.a.a((this.w == null || TextUtils.isEmpty(this.w.a())) ? "slam_model_1" : this.w.a(), (int) a2[1], (int) a2[2], this.z, this.w.d(), this.t);
                    this.v = true;
                    StatisticHelper.getInstance().statisticInfo(StatisticConstants.SLAM_TRACK_ON);
                    this.j = true;
                    a(0, 1);
                }
            }
        } catch (NullPointerException e2) {
            ARLog.w("bdar: mPreviewSize is null!!!!");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.base.b
    public void a(com.baidu.ar.d.a aVar) {
        super.a(aVar);
    }

    public int[] a(float f, float f2) {
        int[] iArr = new int[2];
        if (this.f != null) {
            iArr[1] = this.f.b - ((int) (720.0f * f));
            iArr[0] = (int) (1280.0f * f2);
        } else {
            iArr[1] = 640;
            iArr[0] = 360;
        }
        return iArr;
    }

    @Override // com.baidu.ar.base.b
    public void b(String str) {
        super.b(str);
        if (!TextUtils.isEmpty(this.B) && TextUtils.equals(this.B, str)) {
            SlamStateMachine.a().a(SlamStateMachine.EVENT.DOWNLOAD_RES_FINISH);
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
                if (parseCaseConfig == null) {
                    d.a((int) MsgField.MSG_ON_PARSE_RESOURCE_JSON_ERROR);
                    return;
                }
                com.baidu.ar.bean.c a = com.baidu.ar.parser.a.a(str2, str5);
                String str6 = str2 + File.separator + ARFileUtils.AR_UNZIP_ROOT_DIR;
                this.h = parseCaseConfig;
                this.q = a;
                if (this.i != null) {
                    this.i.a(this.q);
                } else {
                    ARLog.e("ARMessageHandler is null");
                }
                d.a((int) MsgField.IMSG_TRACKED_TIPS_INFO, parseCaseConfig);
                this.w = this.h.getSlamModel();
                if (this.w != null) {
                    this.C = this.w.f();
                }
                c(str6);
                SlamStateMachine.a().a(SlamStateMachine.EVENT.DOWNLOAD_RES_FINISH);
                this.B = str;
            } catch (JSONException e) {
                d.a((int) MsgField.MSG_ON_PARSE_RESOURCE_UNZIP_ERROR);
            }
        }
    }

    @Override // com.baidu.ar.base.b
    public void c(boolean z) {
        super.c(z);
        SlamStateMachine.a().a(z);
    }

    @Override // com.baidu.ar.base.b
    protected void c(byte[] bArr, com.baidu.ar.d.a aVar) {
        try {
            int i = this.f.a;
            int i2 = this.f.b;
            if (PerformanceTest.isOpenSlam() && this.C && this.t != null) {
                if (!this.v) {
                    p();
                    return;
                }
                com.baidu.ar.algo.a.a(bArr, i, i2, this.t, this.A);
                StatisticHelper.getInstance().statisticFrameRate(StatisticConstants.SLAM_TRACK_FRAME_AVG_TIME);
            }
        } catch (NullPointerException e) {
            ARLog.w("bdar: mPreviewSize is null!!!!");
        }
    }

    @Override // com.baidu.ar.base.b
    public void d() {
        super.d();
        SlamStateMachine.a(SlamStateMachine.STATE.RESUME);
        com.baidu.ar.msghandler.e.a().a(this.s);
        if (this.j) {
            StatisticHelper.getInstance().statisticInfo(StatisticConstants.RESUME_AR);
        }
    }

    public void d(Bundle bundle) {
        float f;
        float f2;
        if (bundle.getBoolean("is_from_lua", false)) {
            int[] a = a(bundle.getFloat(Config.EVENT_HEAT_X, 0.5f), bundle.getFloat("y", 0.5f));
            f = a[0];
            f2 = a[1];
        } else {
            f = bundle.getFloat(Config.EVENT_HEAT_X, 640.0f);
            f2 = bundle.getFloat("y", 360.0f);
        }
        y = ((Integer) bundle.get("type")).intValue();
        float floatValue = ((Float) bundle.get("distance")).floatValue();
        x = true;
        com.baidu.ar.algo.a.c(this.t);
        com.baidu.ar.algo.a.a((this.w == null || TextUtils.isEmpty(this.w.a())) ? "slam_model_1" : this.w.a(), (int) f, (int) f2, (float[]) null, (int) floatValue, this.t);
    }

    @Override // com.baidu.ar.base.b
    public void e() {
        super.e();
        SlamStateMachine.a(SlamStateMachine.STATE.PAUSE);
        if (this.j) {
            StatisticHelper.getInstance().statisticInfo(StatisticConstants.INTERRUPT_AR);
        }
    }

    @Override // com.baidu.ar.base.b
    public void f() {
        super.f();
        if (this.t != null) {
            com.baidu.ar.algo.a.b(this.t);
            this.t = null;
        }
        SlamStateMachine.a(SlamStateMachine.STATE.DESTROY);
        SlamStateMachine.c();
        o();
        this.u.c();
    }

    @Override // com.baidu.ar.base.b
    public void j() {
        super.j();
        SlamStateMachine.a(SlamStateMachine.STATE.PAUSE);
        if (this.t != null) {
            com.baidu.ar.algo.a.b(this.t);
            this.t = null;
        }
        SlamStateMachine.a(SlamStateMachine.STATE.DESTROY);
        SlamStateMachine.c();
        o();
        this.u.c();
        com.baidu.ar.algo.a.a();
        h();
    }

    public void m() {
        n();
    }

    public void n() {
        try {
            int i = this.f.a;
            int i2 = this.f.b;
            if (this.t == null) {
                this.t = new com.baidu.ar.algo.a.b.b(i, i2, false);
                com.baidu.ar.algo.a.a(this.t, this.u);
            }
            com.baidu.ar.algo.a.a(this.t);
        } catch (NullPointerException e) {
            ARLog.w("bdar: mPreviewSize is null!!!!");
        }
    }
}
