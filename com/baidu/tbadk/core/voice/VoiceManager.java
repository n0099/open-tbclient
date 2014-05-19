package com.baidu.tbadk.core.voice;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.voice.service.MediaService;
import java.io.File;
/* loaded from: classes.dex */
public class VoiceManager extends BroadcastReceiver implements SensorEventListener {
    private static Boolean J;
    private static Integer K;
    private static Integer L;
    private x A;
    private Boolean D;
    private com.baidu.tbadk.core.voice.a.a F;
    y a;
    Activity d;
    AudioManager g;
    private WindowManager.LayoutParams n;
    private WindowManager o;
    private View p;
    private boolean q;
    private Handler s;
    private Boolean t;
    private boolean u;
    private x z;
    private static boolean l = false;
    private static boolean m = false;
    private static boolean r = false;
    private static float E = 0.5f;
    public static int h = 3;
    String b = null;
    private boolean v = false;
    private final Runnable w = new m(this);
    private VoiceData.VoiceModel x = null;
    private VoiceData.VoiceModel y = null;
    private aa B = null;
    private ac C = null;
    Runnable c = new n(this);
    SensorManager e = null;
    Sensor f = null;
    private boolean G = true;
    private int H = 1;
    private l I = null;
    private boolean M = false;
    Runnable i = new o(this);
    Runnable j = new p(this);
    private final Runnable N = new q(this);
    boolean k = false;
    private final BroadcastReceiver O = new r(this);

    /* loaded from: classes.dex */
    public enum PlayMode {
        SPEAKER,
        HEADSET;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static PlayMode[] valuesCustom() {
            PlayMode[] valuesCustom = values();
            int length = valuesCustom.length;
            PlayMode[] playModeArr = new PlayMode[length];
            System.arraycopy(valuesCustom, 0, playModeArr, 0, length);
            return playModeArr;
        }
    }

    public static synchronized void a() {
        synchronized (VoiceManager.class) {
            if (!m) {
                r = com.baidu.tbadk.core.sharedPref.b.a().a("voice_use_soft_decoder", ae.a());
            }
        }
    }

    public static boolean b() {
        return r;
    }

    public static void a(boolean z) {
        r = true;
        com.baidu.tbadk.core.sharedPref.b.a().b("voice_use_soft_decoder", r);
    }

    public static VoiceManager c() {
        return new VoiceManager();
    }

    public VoiceManager() {
        a();
        l = b() ? false : true;
    }

    public boolean a(y yVar, int i) {
        if (yVar == null) {
            return false;
        }
        this.a = yVar;
        if (!com.baidu.tbadk.core.util.x.a()) {
            String b = com.baidu.tbadk.core.util.x.b();
            if (b == null) {
                b = this.d.getString(com.baidu.tieba.u.voice_error_sdcard);
            }
            this.a.a(0, b);
            return false;
        }
        g();
        this.b = ad.a();
        String a = ad.a(this.b);
        if (this.I == null) {
            this.I = new ab(this, null);
        }
        f.a();
        q();
        boolean a2 = f.a(a, i, this.I);
        if (a2) {
            this.a.a(true);
            this.H = 2;
            p();
            return a2;
        }
        this.H = 1;
        f.a();
        BdLog.e("VoiceManager", "onTouch-getBtnMsgsendVoice", "user click too often");
        com.baidu.tbadk.core.util.w wVar = new com.baidu.tbadk.core.util.w();
        wVar.a("voiceType", Integer.valueOf(i));
        TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_START, "onTouch-getBtnMsgsendVoice: user click too often", wVar.toString());
        this.a.a(false);
        return a2;
    }

    public void d() {
        f.b();
    }

    public void a(String str) {
        f();
        g();
        if (this.a != null) {
            this.a.a(str);
        }
        if (this.s != null) {
            this.s.postDelayed(new s(this, str), 200L);
        }
    }

    public static boolean a(int i) {
        return i == 3;
    }

    public static boolean b(int i) {
        return i == 2;
    }

    public boolean e() {
        return this.x != null && a(this.x.voice_status.intValue());
    }

    public boolean a(VoiceData.VoiceModel voiceModel) {
        return (this.x == null || voiceModel == null || this.x != voiceModel) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(VoiceData.VoiceModel voiceModel) {
        x();
        voiceModel.voice_status = 1;
        x m2 = m();
        if (m2 != null) {
            m2.a(voiceModel);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(VoiceData.VoiceModel voiceModel) {
        if (l) {
            if (a(voiceModel.voice_status.intValue())) {
                b(voiceModel);
                MediaService.b(this.d);
                return;
            }
            b(voiceModel);
            return;
        }
        try {
            if (a(voiceModel.voice_status.intValue())) {
                b(voiceModel);
                a.a();
            } else {
                b(voiceModel);
            }
        } catch (Exception e) {
            BdLog.e("VoiceManager", "setMsgWaiting", "error:" + e.getMessage());
            com.baidu.tbadk.core.util.w wVar = new com.baidu.tbadk.core.util.w();
            if (voiceModel != null) {
                wVar.a("id", voiceModel.getId());
                wVar.a("from", voiceModel.from);
            }
            TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_PAUSE, "VoiceManager.setPlayWaiting() error : " + e.toString(), wVar.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(VoiceData.VoiceModel voiceModel) {
        try {
            if (this.C == null) {
                this.C = new ac(this, null);
            }
            String b = ad.b(voiceModel.getId());
            if (b == null) {
                b = this.F.a(voiceModel.getId(), voiceModel.from, this.C);
            }
            if (voiceModel.isLocal && b == null) {
                if (this.B == null) {
                    this.B = new aa(this, null);
                }
                this.B.a(5, ae.a(com.baidu.tieba.u.voice_err_no_file));
                com.baidu.tbadk.core.util.w wVar = new com.baidu.tbadk.core.util.w();
                if (voiceModel != null) {
                    wVar.a("id", voiceModel.getId());
                    wVar.a("from", voiceModel.from);
                }
                TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_FILE, "VoiceManager.setDownloading() error : record file not exists", wVar.toString());
            } else if (b != null) {
                a(voiceModel, b);
            } else {
                voiceModel.voice_status = 2;
                x m2 = m();
                if (m2 != null) {
                    m2.a(voiceModel);
                }
            }
        } catch (Exception e) {
            com.baidu.tbadk.core.util.w wVar2 = new com.baidu.tbadk.core.util.w();
            if (voiceModel != null) {
                wVar2.a("id", voiceModel.getId());
                wVar2.a("from", voiceModel.from);
            }
            TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_DOWN, "setMsgDownloading error: " + e.getMessage(), wVar2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public x m() {
        if (this.A == null) {
            return null;
        }
        x realView = this.A.getRealView();
        if (realView == null) {
            return this.A;
        }
        return realView;
    }

    private void c(x xVar) {
        this.A = xVar;
    }

    public void a(x xVar) {
        if (xVar != null && a(xVar.getVoiceModel())) {
            c(xVar);
        }
    }

    public void b(x xVar) {
        if (xVar != null) {
            if (this.s != null) {
                this.s.removeCallbacks(this.i);
            }
            this.M = false;
            VoiceData.VoiceModel voiceModel = xVar.getVoiceModel();
            if (voiceModel != null) {
                if (this.t != null && this.t.booleanValue()) {
                    d(this.t.booleanValue());
                    this.t = null;
                }
                this.z = xVar;
                this.y = voiceModel;
                int i = 1;
                if (this.y.voice_status != null) {
                    i = this.y.voice_status.intValue();
                }
                if (this.x != null) {
                    this.x.curr_time = 0;
                    if (this.x == this.y) {
                        c(xVar);
                        this.x = this.y;
                        switch (i) {
                            case 1:
                                d(this.x);
                                return;
                            case 2:
                            case 3:
                                c(this.x);
                                return;
                            default:
                                return;
                        }
                    }
                    c(this.x);
                    b(this.x);
                    if (this.s != null) {
                        this.s.removeCallbacks(this.w);
                        this.s.postDelayed(this.w, 300L);
                        return;
                    }
                    return;
                }
                c(xVar);
                this.x = this.y;
                d(this.x);
            }
        }
    }

    private void n() {
        if (this.u) {
            if (TbadkApplication.m252getInst().isHeadsetModeOn()) {
                k();
            } else {
                j();
            }
            this.u = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(VoiceData.VoiceModel voiceModel, String str) {
        try {
            if (this.B == null) {
                this.B = new aa(this, null);
            }
            if (!new File(str).exists()) {
                this.B.a(5, ae.a(com.baidu.tieba.u.voice_err_no_file));
                return;
            }
            v();
            p();
            n();
            if (l) {
                MediaService.a(this.d, str, voiceModel.duration, voiceModel.curr_time);
                voiceModel.curr_time = 0;
                return;
            }
            boolean a = a.a(str, this.B, voiceModel.curr_time);
            voiceModel.curr_time = 0;
            if (!a) {
                BdLog.e("VoiceManager", "setMsgPlaying", "error: AmrAudioPlayer.start");
                com.baidu.tbadk.core.util.w wVar = new com.baidu.tbadk.core.util.w();
                wVar.a("file", str);
                if (voiceModel != null) {
                    wVar.a("id", voiceModel.getId());
                    wVar.a("from", voiceModel.from);
                }
                TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_START, "setMsgPlaying error: AmrAudioPlayer.start", wVar.toString());
                return;
            }
            voiceModel.voice_status = 3;
            x m2 = m();
            if (m2 != null) {
                m2.a(voiceModel);
            }
            t();
        } catch (Exception e) {
            BdLog.e("VoiceManager", "setMsgPlaying", "error:" + e.getMessage());
            com.baidu.tbadk.core.util.w wVar2 = new com.baidu.tbadk.core.util.w();
            wVar2.a("file", str);
            if (voiceModel != null) {
                wVar2.a("id", voiceModel.getId());
                wVar2.a("from", voiceModel.from);
            }
            TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_START, "setMsgPlaying error: " + e.getMessage(), wVar2.toString());
        }
    }

    private void o() {
        f();
        g();
        l();
        MediaService.c(this.d);
        b((Context) this.d);
        if (this.F != null) {
            this.F.a();
        }
        if (this.s != null) {
            this.s.removeCallbacks(this.c);
            this.s.removeCallbacks(this.w);
            this.s.removeCallbacks(this.i);
            this.s.removeCallbacks(this.j);
        }
        if (this.x != null) {
            this.x.init();
        }
        if (this.y != null) {
            this.y.init();
        }
        this.d = null;
        this.a = null;
        this.A = null;
        this.z = null;
        this.x = null;
        this.y = null;
        this.s = null;
        this.g = null;
    }

    public void f() {
        f.a();
        if (this.s != null) {
            this.s.postDelayed(this.c, 100L);
        }
        q();
    }

    public void g() {
        if (this.x != null) {
            c(this.x);
        }
        if (!this.M) {
            q();
        }
    }

    private void p() {
        if (this.d == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        A();
    }

    public void b(boolean z) {
        this.G = z;
    }

    public void a(Activity activity) {
        this.d = activity;
        this.s = new Handler();
        this.g = (AudioManager) activity.getSystemService("audio");
        this.e = (SensorManager) activity.getSystemService("sensor");
        this.f = this.e.getDefaultSensor(8);
        this.F = new com.baidu.tbadk.core.voice.a.a(activity);
        this.x = null;
        this.y = null;
        if (l) {
            MediaService.a(activity, this.O);
            MediaService.a(activity, (Intent) null);
        }
        y();
    }

    public void b(Activity activity) {
    }

    public void c(Activity activity) {
        this.u = true;
        a((Context) activity);
    }

    public void d(Activity activity) {
        a(activity, true);
    }

    public void a(Activity activity, boolean z) {
        if (z) {
            h();
        }
    }

    public void h() {
        b((Context) this.d);
        if (l) {
            if (this.x != null) {
                b(this.x);
                this.x = null;
            }
            MediaService.b(this.d);
            return;
        }
        g();
    }

    public void e(Activity activity) {
    }

    public void f(Activity activity) {
        h();
        l();
    }

    public void g(Activity activity) {
        o();
        if (l) {
            MediaService.b(activity, this.O);
        }
    }

    public boolean i() {
        return this.H == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i) {
        if (str != null && i >= 1) {
            this.H = 3;
            new Thread(new t(this, str, i)).start();
        }
    }

    private void r() {
        if (this.g != null) {
            if (J == null) {
                J = Boolean.valueOf(s());
            }
            if (K == null) {
                K = Integer.valueOf(this.g.getMode());
            }
            if (L == null) {
                if (K.intValue() == 3) {
                    L = Integer.valueOf(this.g.getStreamVolume(3));
                } else {
                    L = Integer.valueOf(this.g.getStreamVolume(0));
                }
            }
        }
    }

    private boolean s() {
        if (this.g == null) {
            return false;
        }
        try {
            return this.g.isSpeakerphoneOn();
        } catch (Throwable th) {
            TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_SPEAKER, "audioManager.isSpeakerphoneOn() exception: " + th.getMessage(), "");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z) {
        if (this.g != null) {
            try {
                this.g.setSpeakerphoneOn(z);
            } catch (Throwable th) {
                TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_SPEAKER, "audioManager.setSpeakerphoneOn() exception: " + th.getMessage(), "");
            }
        }
    }

    public void j() {
        if (this.g != null && this.H != 2) {
            if (TbadkApplication.m252getInst().isHeadsetModeOn()) {
                d(false);
                return;
            }
            try {
                r();
                d(true);
                h = 3;
                u();
            } catch (Exception e) {
                e.printStackTrace();
                TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_SPEAKER, "openSpeaker exception: " + e.getMessage(), "");
            }
        }
    }

    public void k() {
        if (this.g != null) {
            r();
            try {
                d(false);
                h = 0;
                u();
            } catch (Exception e) {
                e.printStackTrace();
                TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_SPEAKER, "closeSpeaker exception: " + e.getMessage(), "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        try {
            if (this.d != null && (this.d instanceof Activity)) {
                this.d.setVolumeControlStream(h);
            }
        } catch (Exception e) {
            TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_VOLUME, "setVolumeControlStream exception: " + e.getMessage(), "");
        }
    }

    private void u() {
        if (this.d != null) {
            if (this.s != null) {
                this.s.removeCallbacks(this.i);
            }
            x m2 = m();
            if (!this.M && this.x != null && a(this.x.voice_status.intValue()) && m2 != null) {
                this.M = true;
                if (l) {
                    MediaService.b(this.d);
                } else {
                    g();
                }
            }
        }
    }

    public void l() {
        this.M = false;
        if (this.g != null && ae.b()) {
            try {
                if (J != null && K != null && L != null) {
                    d(J.booleanValue());
                    h = 3;
                    J = null;
                    K = null;
                    L = null;
                }
            } catch (Exception e) {
                e.printStackTrace();
                TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_SPEAKER, "restoreVoiceMode exception: " + e.getMessage(), "");
            }
        }
    }

    public void c(boolean z) {
        if (this.g != null && ae.b()) {
            if (this.D == null || this.D.booleanValue() != z) {
                this.D = Boolean.valueOf(z);
                if (this.s != null) {
                    this.s.removeCallbacks(this.j);
                    this.s.postDelayed(this.j, 300L);
                }
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (!this.k && this.G) {
            float[] fArr = sensorEvent.values;
            if (sensorEvent.sensor.getType() == 8 && fArr.length > 0) {
                float f = fArr[0];
                if (f < E || f < this.f.getMaximumRange()) {
                    c(false);
                    z();
                } else if (f > E) {
                    A();
                    c(true);
                }
            }
        }
    }

    private void v() {
        if (!TbadkApplication.m252getInst().isHeadsetModeOn() && !this.v && this.f != null && ae.b()) {
            if (this.s != null) {
                this.s.removeCallbacks(this.N);
            }
            this.v = true;
            this.e.registerListener(this, this.f, 3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        if (this.v) {
            try {
                if (this.e != null) {
                    this.e.unregisterListener(this, this.f);
                    this.e.unregisterListener(this);
                }
            } catch (Exception e) {
                TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_UNREGISTSENSOR, "unRegistSensor exception: " + e.getMessage(), "");
            }
            this.v = false;
        }
    }

    private void x() {
        if (this.s != null) {
            this.s.removeCallbacks(this.N);
            this.s.postDelayed(this.N, 1000L);
        }
    }

    private void a(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        context.registerReceiver(this, intentFilter);
    }

    private void b(Context context) {
        if (context != null) {
            try {
                context.unregisterReceiver(this);
                d(false);
                this.s.removeCallbacks(this.N);
                w();
            } catch (IllegalArgumentException e) {
            } catch (Exception e2) {
                TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_UNREGISTPLUGIN, "unRegistPlugin exception: " + e2.getMessage(), "");
            }
        }
    }

    private void y() {
        if (this.g != null) {
            try {
                this.k = this.g.isWiredHeadsetOn();
                if (this.k) {
                    d(false);
                }
            } catch (Throwable th) {
                w wVar = new w(this, null);
                wVar.setSelfExecute(true);
                wVar.execute(new Void[0]);
                TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_HEADSET, "checkHeadsetPlug exception: " + th.getMessage(), "");
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.HEADSET_PLUG")) {
            this.k = intent.getIntExtra("state", 0) == 1;
            if (this.k) {
                d(false);
            }
        }
    }

    public static String c(int i) {
        StringBuffer stringBuffer = new StringBuffer(10);
        if (i <= 0) {
            return "0\"";
        }
        int i2 = i % 60;
        int i3 = i / 60;
        if (i3 > 0) {
            stringBuffer.append(i3).append("'");
        }
        stringBuffer.append(i2).append("\"");
        return stringBuffer.toString();
    }

    private void z() {
        if (this.n == null) {
            this.n = new WindowManager.LayoutParams();
            this.n.width = -1;
            this.n.height = -1;
        }
        if (this.p == null) {
            this.p = new View(this.d);
            this.p.setBackgroundColor(-16777216);
        }
        if (this.o == null) {
            this.o = (WindowManager) this.d.getSystemService("window");
        }
        if (!this.q) {
            this.o.addView(this.p, this.n);
        }
        this.q = true;
    }

    private void A() {
        if (this.o != null && this.p != null && this.q) {
            this.o.removeView(this.p);
        }
        this.q = false;
    }
}
