package com.baidu.ar.component.b;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.ar.ARController;
import com.baidu.ar.ARPermissionManager;
import com.baidu.ar.audio.AudioParams;
import com.baidu.ar.audio.easy.EasyAudio;
import com.baidu.ar.audio.easy.EasyAudioCallback;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.bean.DuMixARConfig;
import com.baidu.ar.permissions.PermissionAction;
import com.baidu.ar.speech.AudioInputStream;
import com.baidu.ar.speech.SpeechDataFactory;
import com.baidu.ar.speech.SpeechManager;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.ar.statistic.StatisticHelper;
import com.baidu.ar.ui.ToastCustom;
import com.baidu.ar.util.NetworkUtil;
import com.baidu.ar.util.Res;
import com.baidu.ar.util.UiThreadUtil;
import com.baidu.ar.util.sputil.SPUtils;
import com.baidu.baiduarsdk.util.MsgParamsUtil;
import com.baidu.fsg.base.armor.RimArmor;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c implements View.OnClickListener, EasyAudioCallback {
    public com.baidu.ar.ui.speech.a a;
    protected b b;
    public Timer c;
    public TimerTask d;
    private ARController e;
    private Context f;
    private LinearLayout g;
    private AudioParams h;
    private AudioInputStream i;
    private com.baidu.ar.component.b.a j;
    private com.baidu.ar.component.b.b k;
    private a l;
    private boolean m;
    private boolean n;
    private ARPermissionManager o;
    private View.OnClickListener p;
    private com.baidu.ar.b q;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a implements com.baidu.ar.speech.a.a {
        private WeakReference<c> a;

        private a(c cVar) {
            this.a = new WeakReference<>(cVar);
        }

        @Override // com.baidu.ar.speech.a.a
        public void a() {
            if (this.a.get() != null) {
                this.a.get().n = false;
                SpeechManager.getInstance(this.a.get().f).setSpeechStatus(SpeechManager.SpeechStatus.SPEECH_OPEN);
                this.a.get().a(true);
                this.a.get().a.e();
                this.a.get().b(Res.getString("bdar_voice_listening"));
            }
        }

        @Override // com.baidu.ar.speech.a.a
        public void a(double d) {
            if (this.a.get() != null) {
                this.a.get().a(d);
            }
        }

        @Override // com.baidu.ar.speech.a.a
        public void a(int i, String str) {
            if (this.a.get() != null) {
                this.a.get().a.e(false);
                this.a.get().a(3, null, i);
                if (!TextUtils.isEmpty(str)) {
                    this.a.get().b(str);
                }
                b();
            }
        }

        @Override // com.baidu.ar.speech.a.a
        public void a(boolean z, String str) {
            if (TextUtils.isEmpty(str) || str.trim().equals("") || this.a.get() == null) {
                return;
            }
            this.a.get().b(str);
            this.a.get().m = z;
            this.a.get().c(str);
        }

        @Override // com.baidu.ar.speech.a.a
        public void b() {
            if (this.a.get() != null) {
                SpeechManager.getInstance(this.a.get().f).setSpeechStatus(SpeechManager.SpeechStatus.SPEECH_IDLE);
                this.a.get().a(false);
                this.a.get().l();
                if (this.a.get().n) {
                    this.a.get().b("");
                    return;
                }
                if (this.a.get().c == null) {
                    this.a.get().c = new Timer();
                }
                this.a.get().d = new TimerTask() { // from class: com.baidu.ar.component.b.c.a.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        if (a.this.a.get() != null) {
                            ((c) a.this.a.get()).b("");
                        }
                    }
                };
                this.a.get().c.schedule(this.a.get().d, 3000L);
            }
        }

        @Override // com.baidu.ar.speech.a.a
        public void c() {
            if (this.a.get() != null) {
                StatisticHelper.getInstance().statisticInfo(StatisticConstants.SPEECH_TYPE_LISTENER);
                this.a.get().a.c(true);
            }
        }

        @Override // com.baidu.ar.speech.a.a
        public void d() {
            if (this.a.get() != null) {
                this.a.get().a.c(false);
                b();
            }
        }

        @Override // com.baidu.ar.speech.a.a
        public void e() {
            if (this.a.get() != null) {
                this.a.get().a.c(false);
                b();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 100) {
                if (c.this.a != null) {
                    c.this.a.a(((Float) message.obj).floatValue());
                }
            } else if (message.what != 101 || c.this.a == null) {
            } else {
                c.this.a.a((String) message.obj);
            }
        }
    }

    public c(Context context, ARController aRController, com.baidu.ar.b bVar) {
        this.b = null;
        this.e = aRController;
        this.q = bVar;
        this.f = context;
        if (this.b == null) {
            this.b = new b(this.f.getMainLooper());
        }
        if (this.l == null) {
            this.l = new a();
        }
        a(this.q.h().getARPermissionManager());
        this.p = this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(double d) {
        Message message = new Message();
        message.what = 100;
        message.obj = Float.valueOf((float) d);
        if (this.b != null) {
            this.b.sendMessage(message);
        }
    }

    private void a(int i, String str) {
        a(i, str, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, int i2) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", 2001);
        hashMap.put(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(i));
        if (str != null) {
            hashMap.put("voice_result", str);
        }
        if (i2 != -1) {
            hashMap.put("error_id", Integer.valueOf(i2));
        }
        if (this.e != null) {
            this.e.sendMessage2Lua(hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str) {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.component.b.c.5
            @Override // java.lang.Runnable
            public void run() {
                ToastCustom toastCustom = new ToastCustom(c.this.f.getApplicationContext());
                toastCustom.makeText(str, 0);
                toastCustom.setGravity(2);
                toastCustom.show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z) {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.component.b.c.7
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.a == null) {
                    return;
                }
                if (z) {
                    if (c.this.a.f() != null) {
                        c.this.a.f().setImageDrawable(Res.getDrawable("bdar_drawable_btn_open_record_audio_selector"));
                    }
                    c.this.a.b(Res.getString("bdar_click_to_stop_speak"));
                    return;
                }
                if (c.this.a.f() != null) {
                    c.this.a.f().setImageDrawable(Res.getDrawable("bdar_drawable_btn_close_record_audio_selector"));
                }
                c.this.a.b(Res.getString("bdar_click_to_open_speak"));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        Message message = new Message();
        message.what = 101;
        message.obj = str;
        if (this.b != null) {
            this.b.sendMessage(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (this.a == null) {
            return;
        }
        int isShowRecordAudioTipCount = SPUtils.getIsShowRecordAudioTipCount(this.f, ARConfig.getARKey());
        String aRKey = ARConfig.getARKey();
        if (isShowRecordAudioTipCount >= 3 || !SPUtils.getIsShowRecordAudioTip(this.f, aRKey)) {
            return;
        }
        if (this.a.f() != null && this.a.f().isShown()) {
            this.a.g(true);
        }
        if (z) {
            SPUtils.putIsShowRecordAudioTip(this.f, aRKey, false);
            SPUtils.putIsShowRecordAudioTipCount(this.f, aRKey, isShowRecordAudioTipCount + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        if (this.n) {
            return;
        }
        JSONObject a2 = d.a(this.f).a();
        if (a2 == null) {
            b(Res.getString("bdar_speech_error_unknow"));
            if (this.l != null) {
                this.l.b();
                return;
            }
            return;
        }
        Iterator<String> keys = a2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                JSONArray jSONArray = new JSONArray(a2.getString(next));
                for (int i = 0; i < jSONArray.length(); i++) {
                    String string = jSONArray.getString(i);
                    if (string != null && str.contains(string)) {
                        this.n = true;
                        a(4, next);
                        StatisticHelper.getInstance().statisticInfo(StatisticConstants.SPEECH_TYPE_HIT);
                        if (this.c == null) {
                            this.c = new Timer();
                        }
                        this.d = new TimerTask() { // from class: com.baidu.ar.component.b.c.6
                            @Override // java.util.TimerTask, java.lang.Runnable
                            public void run() {
                                if (c.this.l != null) {
                                    c.this.l.b();
                                }
                                c.this.b();
                            }
                        };
                        this.c.schedule(this.d, 1000L);
                        return;
                    }
                }
                continue;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (this.m || this.n) {
            return;
        }
        b(Res.getString("bdar_speech_error_unknow"));
        if (!SpeechManager.getInstance(this.f).isShowErrorTips()) {
            a(4, str);
            return;
        }
        a(5, str);
        if (this.l != null) {
            this.l.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.h = new AudioParams();
        if (this.i == null) {
            this.i = new AudioInputStream(this.h.getFrameSize(), this.h.getFrameBufferCount());
        }
        SpeechDataFactory.setAudioInputStream(this.i);
        EasyAudio.getInstance().startAudio(this.h, this);
    }

    private void k() {
        StatisticHelper.getInstance().statisticInfo(StatisticConstants.SPEECH_TYPE_OPEN);
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.component.b.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.a.a(true);
                c.this.a.b(true);
                SpeechManager.getInstance(c.this.f).setSpeechStatus(SpeechManager.SpeechStatus.SPEECH_INIT);
                if (ARConfig.isBox()) {
                    c.this.j = new com.baidu.ar.component.b.a(c.this.l);
                    SpeechManager.getInstance(c.this.f).setARRecognitionListener(c.this.j);
                } else {
                    if (c.this.k == null) {
                        c.this.k = new com.baidu.ar.component.b.b(c.this.l);
                    }
                    SpeechManager.getInstance(c.this.f).setARRecognitionListener(c.this.k);
                    HashMap hashMap = new HashMap();
                    hashMap.put("accept-audio-data", true);
                    hashMap.put("infile", "#com.baidu.ar.speech.SpeechDataFactory.create8kInputStream()");
                    if (ARConfig.isAipAuth()) {
                        hashMap.put("appid", DuMixARConfig.getAipAppId());
                        hashMap.put(RimArmor.KEY, DuMixARConfig.getAPIKey());
                        hashMap.put("secret", DuMixARConfig.getSecretKey());
                    } else {
                        hashMap.put("appid", "10315470");
                        hashMap.put(RimArmor.KEY, "bgW5575sEj5m9CHEatxTGln6");
                        hashMap.put("secret", "kD9VCx8q56s3lAaAk0juQtkFfXj3Xsp4");
                    }
                    SpeechManager.getInstance(c.this.f).startARListener(hashMap);
                }
                c.this.b(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        EasyAudio.getInstance().stopAudio(this);
    }

    public void a() {
        if (SpeechManager.getInstance(this.f).getSpeechStatus() == SpeechManager.SpeechStatus.SPEECH_IDLE) {
            this.o.request("android.permission.RECORD_AUDIO", new PermissionAction() { // from class: com.baidu.ar.component.b.c.1
                @Override // com.baidu.ar.permissions.PermissionAction
                public void onDenied() {
                    StatisticHelper.getInstance().statisticInfo(StatisticConstants.SYSTEM_MIC_PERMISSION_TYPE_DENIED);
                }

                @Override // com.baidu.ar.permissions.PermissionAction
                public void onGranted() {
                    c.this.j();
                    StatisticHelper.getInstance().statisticInfo(StatisticConstants.SYSTEM_MIC_PERMISSION_TYPE_GRANTED);
                }
            });
            return;
        }
        SpeechManager.getInstance(this.f).setSpeechStatus(SpeechManager.SpeechStatus.SPEECH_IDLE);
        c();
    }

    public void a(LinearLayout linearLayout) {
        this.g = linearLayout;
        this.a = new com.baidu.ar.ui.speech.a(this.f, this.g);
        this.a.a(this.p);
    }

    public void a(ARPermissionManager aRPermissionManager) {
        this.o = aRPermissionManager;
    }

    public void a(HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            switch (MsgParamsUtil.obj2Int(hashMap.get("id"), -1)) {
                case 2001:
                    a();
                    return;
                case 2002:
                    c();
                    return;
                case PushConstants.NOTIFICATIONSERVICE_SEND_MESSAGE /* 2003 */:
                    if (this.a != null) {
                        this.a.f(true);
                        b(true);
                        return;
                    }
                    return;
                case PushConstants.NOTIFICATIONSERVICE_SEND_MESSAGE_ERROR /* 2004 */:
                    if (this.a != null) {
                        this.a.f(false);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void b() {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.component.b.c.3
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.a != null) {
                    c.this.a.a(false);
                    c.this.a.b(false);
                }
                c.this.a(false);
                SpeechManager.getInstance(c.this.f).cancel(c.this.j);
            }
        });
    }

    public void c() {
        l();
        b();
    }

    public void d() {
        EasyAudio.getInstance().release();
        if (this.c != null) {
            this.c.cancel();
            this.c.purge();
            this.c = null;
        }
        if (this.d != null) {
            this.d.cancel();
            this.d = null;
        }
        if (this.q != null) {
            this.q = null;
        }
        if (this.a != null) {
            this.a.f(false);
            this.a.d();
        }
        SpeechManager.getInstance(this.f).destroy();
        this.j = null;
        this.k = null;
        this.l = null;
    }

    public void e() {
        if (this.a != null) {
            this.a.a();
        }
    }

    public void f() {
        if (this.a != null) {
            this.a.c();
        }
    }

    public void g() {
        if (this.a != null) {
            this.a.b();
        }
    }

    public SpeechManager.SpeechStatus h() {
        return SpeechManager.getInstance(this.f).getSpeechStatus();
    }

    public boolean i() {
        return this.n;
    }

    @Override // com.baidu.ar.audio.easy.EasyAudioCallback
    public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
        if (this.i != null) {
            this.i.writeFrameData(byteBuffer);
        }
    }

    @Override // com.baidu.ar.audio.easy.EasyAudioCallback
    public void onAudioStart(boolean z, AudioParams audioParams) {
        if (!z || this.h == null || !this.h.equals(audioParams)) {
            a(Res.getString("bdar_mic_read_error"));
            return;
        }
        k();
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.component.b.c.4
            @Override // java.lang.Runnable
            public void run() {
                if (!NetworkUtil.isNetworkConnected(c.this.f)) {
                    c.this.a(Res.getString("bdar_speech_error_network"));
                } else if (c.this.a == null || c.this.a.g == null) {
                } else {
                    c.this.b(Res.getString("bdar_speech_wait"));
                    c.this.a.e();
                }
            }
        });
    }

    @Override // com.baidu.ar.audio.easy.EasyAudioCallback
    public void onAudioStop(boolean z) {
        if (this.i != null) {
            this.i.closeByUser();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.a == null || view != this.a.f()) {
            return;
        }
        a();
        if (this.a.f() == null || !this.a.f().isShown()) {
            return;
        }
        this.a.g(false);
    }
}
