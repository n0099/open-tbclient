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
import android.os.PowerManager;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.io.File;
import java.util.UUID;
/* loaded from: classes.dex */
public final class VoiceManager extends BroadcastReceiver implements SensorEventListener {
    private static Boolean G;
    private static Integer H;
    private static Integer I;
    private Boolean A;
    private com.baidu.tbadk.core.voice.cache.a C;
    y a;
    Activity d;
    AudioManager g;
    private Handler p;
    private Boolean q;
    private boolean r;
    private x w;
    private x x;
    private static boolean m = false;
    private static boolean n = false;
    private static boolean o = false;
    private static float B = 0.5f;
    public static int i = 3;
    String b = null;
    private boolean s = false;
    private final Runnable t = new m(this);
    private VoiceData.VoiceModel u = null;
    private VoiceData.VoiceModel v = null;
    private aa y = null;
    private ac z = null;
    Runnable c = new n(this);
    SensorManager e = null;
    Sensor f = null;
    private boolean D = true;
    PowerManager.WakeLock h = null;
    private int E = 1;
    private l F = null;
    private boolean J = false;
    Runnable j = new o(this);
    Runnable k = new p(this);
    private final Runnable K = new q(this);
    boolean l = false;
    private final BroadcastReceiver L = new r(this);

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

    private static synchronized void n() {
        synchronized (VoiceManager.class) {
            if (!n) {
                o = com.baidu.tbadk.core.sharedPref.b.a().a("voice_use_soft_decoder", ae.a());
            }
        }
    }

    public static void a() {
        o = true;
        com.baidu.tbadk.core.sharedPref.b.a().b("voice_use_soft_decoder", o);
    }

    public static VoiceManager b() {
        return new VoiceManager();
    }

    public VoiceManager() {
        n();
        m = o ? false : true;
    }

    public final boolean a(y yVar, int i2) {
        if (yVar == null) {
            return false;
        }
        this.a = yVar;
        if (!com.baidu.tbadk.core.util.w.a()) {
            String b = com.baidu.tbadk.core.util.w.b();
            if (b == null) {
                b = this.d.getString(com.baidu.tbadk.l.voice_error_sdcard);
            }
            this.a.a(0, b);
            return false;
        }
        f();
        this.b = UUID.randomUUID().toString();
        String a = ad.a(this.b);
        if (this.F == null) {
            this.F = new ab(this, (byte) 0);
        }
        f.a();
        q();
        boolean a2 = f.a(a, -1, this.F);
        if (a2) {
            this.a.a(true);
            this.E = 2;
            p();
            return a2;
        }
        this.E = 1;
        f.a();
        com.baidu.adp.lib.util.f.b("VoiceManager", "onTouch-getBtnMsgsendVoice", "user click too often");
        com.baidu.tbadk.core.util.v vVar = new com.baidu.tbadk.core.util.v();
        vVar.a("voiceType", -1);
        TiebaStatic.b("", -1101, "onTouch-getBtnMsgsendVoice: user click too often", vVar.toString());
        this.a.a(false);
        return a2;
    }

    public static void c() {
        f.b();
    }

    public final void a(String str) {
        e();
        f();
        if (this.a != null) {
            this.a.a();
        }
        if (this.p != null) {
            this.p.postDelayed(new s(this, str), 200L);
        }
    }

    private static boolean c(int i2) {
        return i2 == 3;
    }

    public static boolean a(int i2) {
        return i2 == 2;
    }

    public final boolean d() {
        return this.u != null && c(this.u.voice_status.intValue());
    }

    public final boolean a(VoiceData.VoiceModel voiceModel) {
        return (this.u == null || voiceModel == null || this.u != voiceModel) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(VoiceData.VoiceModel voiceModel) {
        if (this.p != null) {
            this.p.removeCallbacks(this.K);
            this.p.postDelayed(this.K, 1000L);
        }
        voiceModel.voice_status = 1;
        x o2 = o();
        if (o2 != null) {
            o2.a(voiceModel);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(VoiceData.VoiceModel voiceModel) {
        if (m) {
            if (c(voiceModel.voice_status.intValue())) {
                b(voiceModel);
                com.baidu.tbadk.core.voice.service.a.b(this.d);
                return;
            }
            b(voiceModel);
            return;
        }
        try {
            if (c(voiceModel.voice_status.intValue())) {
                b(voiceModel);
                a.a();
            } else {
                b(voiceModel);
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("VoiceManager", "setMsgWaiting", "error:" + e.getMessage());
            com.baidu.tbadk.core.util.v vVar = new com.baidu.tbadk.core.util.v();
            if (voiceModel != null) {
                vVar.a("id", voiceModel.getId());
                vVar.a("from", voiceModel.from);
            }
            TiebaStatic.b("", -1102, "VoiceManager.setPlayWaiting() error : " + e.toString(), vVar.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(VoiceData.VoiceModel voiceModel) {
        try {
            if (this.z == null) {
                this.z = new ac(this, (byte) 0);
            }
            String a = com.baidu.tbadk.core.util.w.a(voiceModel.getId(), 1);
            if (a == null) {
                a = this.C.a(voiceModel.getId(), voiceModel.from, this.z);
            }
            if (voiceModel.isLocal && a == null) {
                if (this.y == null) {
                    this.y = new aa(this, (byte) 0);
                }
                this.y.a(5, ae.a(com.baidu.tbadk.l.voice_err_no_file));
                com.baidu.tbadk.core.util.v vVar = new com.baidu.tbadk.core.util.v();
                if (voiceModel != null) {
                    vVar.a("id", voiceModel.getId());
                    vVar.a("from", voiceModel.from);
                }
                TiebaStatic.b("", -1103, "VoiceManager.setDownloading() error : record file not exists", vVar.toString());
            } else if (a != null) {
                a(voiceModel, a);
            } else {
                voiceModel.voice_status = 2;
                x o2 = o();
                if (o2 != null) {
                    o2.a(voiceModel);
                }
            }
        } catch (Exception e) {
            com.baidu.tbadk.core.util.v vVar2 = new com.baidu.tbadk.core.util.v();
            if (voiceModel != null) {
                vVar2.a("id", voiceModel.getId());
                vVar2.a("from", voiceModel.from);
            }
            TiebaStatic.b("", -1104, "setMsgDownloading error: " + e.getMessage(), vVar2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public x o() {
        if (this.x == null) {
            return null;
        }
        x realView = this.x.getRealView();
        if (realView == null) {
            return this.x;
        }
        return realView;
    }

    public final void a(x xVar) {
        if (xVar != null && a(xVar.getVoiceModel())) {
            this.x = xVar;
        }
    }

    public final void b(x xVar) {
        if (xVar != null) {
            if (this.p != null) {
                this.p.removeCallbacks(this.j);
            }
            this.J = false;
            VoiceData.VoiceModel voiceModel = xVar.getVoiceModel();
            if (voiceModel != null) {
                if (this.q != null && this.q.booleanValue()) {
                    c(this.q.booleanValue());
                    this.q = null;
                }
                this.w = xVar;
                this.v = voiceModel;
                int i2 = 1;
                if (this.v.voice_status != null) {
                    i2 = this.v.voice_status.intValue();
                }
                if (this.u != null) {
                    this.u.curr_time = 0;
                    if (this.u == this.v) {
                        this.x = xVar;
                        this.u = this.v;
                        switch (i2) {
                            case 1:
                                d(this.u);
                                return;
                            case 2:
                            case 3:
                                c(this.u);
                                return;
                            default:
                                return;
                        }
                    }
                    c(this.u);
                    b(this.u);
                    if (this.p != null) {
                        this.p.removeCallbacks(this.t);
                        this.p.postDelayed(this.t, 300L);
                        return;
                    }
                    return;
                }
                this.x = xVar;
                this.u = this.v;
                d(this.u);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(VoiceData.VoiceModel voiceModel, String str) {
        try {
            if (this.y == null) {
                this.y = new aa(this, (byte) 0);
            }
            if (!new File(str).exists()) {
                this.y.a(5, ae.a(com.baidu.tbadk.l.voice_err_no_file));
                return;
            }
            if (!TbadkApplication.j().V() && !this.s && this.f != null && ae.b()) {
                if (this.p != null) {
                    this.p.removeCallbacks(this.K);
                }
                this.s = true;
                this.e.registerListener(this, this.f, 3);
            }
            p();
            if (this.r) {
                if (TbadkApplication.j().V()) {
                    m();
                } else {
                    l();
                }
                this.r = false;
            }
            if (m) {
                com.baidu.tbadk.core.voice.service.a.a(this.d, str, voiceModel.duration, voiceModel.curr_time);
                voiceModel.curr_time = 0;
                return;
            }
            boolean a = a.a(str, this.y, voiceModel.curr_time);
            voiceModel.curr_time = 0;
            if (!a) {
                com.baidu.adp.lib.util.f.b("VoiceManager", "setMsgPlaying", "error: AmrAudioPlayer.start");
                com.baidu.tbadk.core.util.v vVar = new com.baidu.tbadk.core.util.v();
                vVar.a("file", str);
                if (voiceModel != null) {
                    vVar.a("id", voiceModel.getId());
                    vVar.a("from", voiceModel.from);
                }
                TiebaStatic.b("", -1101, "setMsgPlaying error: AmrAudioPlayer.start", vVar.toString());
                return;
            }
            voiceModel.voice_status = 3;
            x o2 = o();
            if (o2 != null) {
                o2.a(voiceModel);
            }
            t();
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("VoiceManager", "setMsgPlaying", "error:" + e.getMessage());
            com.baidu.tbadk.core.util.v vVar2 = new com.baidu.tbadk.core.util.v();
            vVar2.a("file", str);
            if (voiceModel != null) {
                vVar2.a("id", voiceModel.getId());
                vVar2.a("from", voiceModel.from);
            }
            TiebaStatic.b("", -1101, "setMsgPlaying error: " + e.getMessage(), vVar2.toString());
        }
    }

    public final void e() {
        f.a();
        if (this.p != null) {
            this.p.postDelayed(this.c, 100L);
        }
        q();
    }

    public final void f() {
        if (this.u != null) {
            c(this.u);
        }
        if (!this.J) {
            q();
        }
    }

    private void p() {
        if (this.d != null) {
            if (this.h == null) {
                PowerManager powerManager = (PowerManager) this.d.getSystemService("power");
                if (this.A == null || this.A.booleanValue()) {
                    this.h = powerManager.newWakeLock(6, "cn");
                } else {
                    this.h = powerManager.newWakeLock(32, "cn");
                }
            }
            if (this.h != null && !this.h.isHeld()) {
                this.h.acquire();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (this.h != null && this.h.isHeld()) {
            this.h.release();
            this.h = null;
        }
    }

    public final void a(boolean z) {
        this.D = z;
    }

    public final void a(Activity activity) {
        this.d = activity;
        this.p = new Handler();
        this.g = (AudioManager) activity.getSystemService("audio");
        this.e = (SensorManager) activity.getSystemService("sensor");
        this.f = this.e.getDefaultSensor(8);
        this.C = new com.baidu.tbadk.core.voice.cache.a(activity);
        this.u = null;
        this.v = null;
        if (m) {
            com.baidu.tbadk.core.voice.service.a.a(activity, this.L);
            com.baidu.tbadk.core.voice.service.a.a(activity, (Intent) null);
        }
        if (this.g != null) {
            try {
                this.l = this.g.isWiredHeadsetOn();
                if (this.l) {
                    c(false);
                }
            } catch (Throwable th) {
                w wVar = new w(this, (byte) 0);
                wVar.setSelfExecute(true);
                wVar.execute(new Void[0]);
                TiebaStatic.b("", -1111, "checkHeadsetPlug exception: " + th.getMessage(), "");
            }
        }
    }

    public static void g() {
    }

    public final void b(Activity activity) {
        this.r = true;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        activity.registerReceiver(this, intentFilter);
    }

    public final void c(Activity activity) {
    }

    public final void h() {
        a((Context) this.d);
        if (m) {
            if (this.u != null) {
                b(this.u);
                this.u = null;
            }
            com.baidu.tbadk.core.voice.service.a.b(this.d);
            return;
        }
        f();
    }

    public static void i() {
    }

    public final void j() {
        h();
        v();
    }

    public final void d(Activity activity) {
        e();
        f();
        v();
        com.baidu.tbadk.core.voice.service.a.c(this.d);
        a((Context) this.d);
        if (this.C != null) {
            this.C.a();
        }
        if (this.p != null) {
            this.p.removeCallbacks(this.c);
            this.p.removeCallbacks(this.t);
            this.p.removeCallbacks(this.j);
            this.p.removeCallbacks(this.k);
        }
        if (this.u != null) {
            this.u.init();
        }
        if (this.v != null) {
            this.v.init();
        }
        this.d = null;
        this.a = null;
        this.x = null;
        this.w = null;
        this.u = null;
        this.v = null;
        this.p = null;
        this.g = null;
        if (m) {
            com.baidu.tbadk.core.voice.service.a.b(activity, this.L);
        }
    }

    public final boolean k() {
        return this.E == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(VoiceManager voiceManager, String str, int i2) {
        if (str == null || i2 <= 0) {
            return;
        }
        voiceManager.E = 3;
        new Thread(new t(voiceManager, str, i2)).start();
    }

    private void r() {
        if (this.g != null) {
            if (G == null) {
                G = Boolean.valueOf(s());
            }
            if (H == null) {
                H = Integer.valueOf(this.g.getMode());
            }
            if (I == null) {
                if (H.intValue() == 3) {
                    I = Integer.valueOf(this.g.getStreamVolume(3));
                } else {
                    I = Integer.valueOf(this.g.getStreamVolume(0));
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
            TiebaStatic.b("", -1107, "audioManager.isSpeakerphoneOn() exception: " + th.getMessage(), "");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        if (this.g != null) {
            try {
                this.g.setSpeakerphoneOn(z);
            } catch (Throwable th) {
                TiebaStatic.b("", -1107, "audioManager.setSpeakerphoneOn() exception: " + th.getMessage(), "");
            }
        }
    }

    public final void l() {
        if (this.g != null && this.E != 2) {
            if (TbadkApplication.j().V()) {
                c(false);
                return;
            }
            try {
                r();
                c(true);
                i = 3;
                u();
            } catch (Exception e) {
                e.printStackTrace();
                TiebaStatic.b("", -1107, "openSpeaker exception: " + e.getMessage(), "");
            }
        }
    }

    public final void m() {
        if (this.g != null) {
            r();
            try {
                c(false);
                i = 0;
                u();
            } catch (Exception e) {
                e.printStackTrace();
                TiebaStatic.b("", -1107, "closeSpeaker exception: " + e.getMessage(), "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        try {
            if (this.d != null && (this.d instanceof Activity)) {
                this.d.setVolumeControlStream(i);
            }
        } catch (Exception e) {
            TiebaStatic.b("", -1108, "setVolumeControlStream exception: " + e.getMessage(), "");
        }
    }

    private void u() {
        if (this.d != null) {
            if (this.p != null) {
                this.p.removeCallbacks(this.j);
            }
            x o2 = o();
            if (!this.J && this.u != null && c(this.u.voice_status.intValue()) && o2 != null) {
                this.J = true;
                if (m) {
                    com.baidu.tbadk.core.voice.service.a.b(this.d);
                } else {
                    f();
                }
            }
            q();
        }
    }

    private void v() {
        this.J = false;
        if (this.g != null && ae.b()) {
            try {
                if (G != null && H != null && I != null) {
                    c(G.booleanValue());
                    i = 3;
                    G = null;
                    H = null;
                    I = null;
                }
            } catch (Exception e) {
                e.printStackTrace();
                TiebaStatic.b("", -1107, "restoreVoiceMode exception: " + e.getMessage(), "");
            }
        }
    }

    public final void b(boolean z) {
        if (this.g != null && ae.b()) {
            if (this.A == null || this.A.booleanValue() != z) {
                this.A = Boolean.valueOf(z);
                if (this.p != null) {
                    this.p.removeCallbacks(this.k);
                    this.p.postDelayed(this.k, 300L);
                }
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i2) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        if (!this.l && this.D) {
            float[] fArr = sensorEvent.values;
            if (sensorEvent.sensor.getType() == 8 && fArr.length > 0) {
                float f = fArr[0];
                if (f < B || f < this.f.getMaximumRange()) {
                    b(false);
                } else if (f > B) {
                    b(true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        if (this.s) {
            try {
                if (this.e != null) {
                    this.e.unregisterListener(this, this.f);
                    this.e.unregisterListener(this);
                }
            } catch (Exception e) {
                TiebaStatic.b("", -1109, "unRegistSensor exception: " + e.getMessage(), "");
            }
            this.s = false;
        }
    }

    private void a(Context context) {
        if (context != null) {
            try {
                context.unregisterReceiver(this);
                c(false);
                this.p.removeCallbacks(this.K);
                w();
            } catch (IllegalArgumentException e) {
            } catch (Exception e2) {
                TiebaStatic.b("", -1110, "unRegistPlugin exception: " + e2.getMessage(), "");
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.HEADSET_PLUG")) {
            this.l = intent.getIntExtra("state", 0) == 1;
            if (this.l) {
                c(false);
            }
        }
    }

    public static String b(int i2) {
        StringBuffer stringBuffer = new StringBuffer(10);
        if (i2 <= 0) {
            return "0\"";
        }
        int i3 = i2 % 60;
        int i4 = i2 / 60;
        if (i4 > 0) {
            stringBuffer.append(i4).append("'");
        }
        stringBuffer.append(i3).append("\"");
        return stringBuffer.toString();
    }
}
