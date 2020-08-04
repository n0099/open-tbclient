package com.baidu.swan.apps.media.a.c;

import android.content.Context;
import android.media.AudioRecord;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.console.c;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
import rx.d;
import rx.functions.f;
import rx.schedulers.Schedulers;
/* loaded from: classes7.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a cud;
    private String cue;
    private int cuf;
    private com.baidu.swan.apps.media.a.b.b cuh;
    private long cui;
    private long cuj;
    private com.baidu.swan.apps.media.a.b cul;
    private com.baidu.swan.apps.media.a.b.a cum;
    private String mAppId;
    private AudioRecord mAudioRecord;
    private Context mContext;
    private boolean mIsBackground;
    private TelephonyManager mTelephonyManager;
    private Timer mTimer;
    private int cug = -1;
    private com.baidu.swan.apps.media.a.a cuk = new com.baidu.swan.apps.media.a.a();
    private boolean cun = false;

    private a() {
    }

    public static a alL() {
        if (cud == null) {
            synchronized (a.class) {
                if (cud == null) {
                    cud = new a();
                }
            }
        }
        return cud;
    }

    public void a(String str, com.baidu.swan.apps.media.a.a aVar, Context context, com.baidu.swan.apps.media.a.b bVar, String str2) {
        int i;
        if (this.cug != -1 && this.cug != 3) {
            c.e("recorder", "wrong state, can't init");
            return;
        }
        this.cuk = aVar;
        mx(str);
        this.cul = bVar;
        this.cuf = AudioRecord.getMinBufferSize(aVar.sampleRate, aVar.channel, 2);
        if (this.cuf <= 0) {
            alS();
            c.e("recorder", "wrong buffer size");
            alP();
            return;
        }
        if (aVar.channel == 1) {
            i = 16;
        } else {
            i = 12;
        }
        this.mAudioRecord = new AudioRecord(aVar.ctP, aVar.sampleRate, i, 2, this.cuf);
        this.cug = 0;
        this.mContext = context;
        this.mAppId = str2;
        alU();
    }

    private void mx(String str) {
        String str2;
        if (TextUtils.equals(this.cuk.ctO, "mp3")) {
            str2 = ".mp3";
        } else if (TextUtils.equals(this.cuk.ctO, "pcm")) {
            str2 = ".pcm";
        } else {
            str2 = ".aac";
        }
        this.cue = str + File.separator + "AUDIO_" + Calendar.getInstance().getTimeInMillis() + str2;
    }

    public void ey(boolean z) {
        if (this.mContext == null) {
            alS();
            c.e("recorder", "start error, context is null");
            alP();
        } else if (this.cug == -1 || TextUtils.isEmpty(this.cue)) {
            alS();
            c.e("recorder", "start error, wrong state");
            alP();
        } else {
            if (z) {
                String str = null;
                if (this.cug == 1) {
                    str = "start fail: recorder is recording";
                } else if (this.cug != 0 && this.cug != 3) {
                    str = "start fail: recorder is paused";
                }
                if (str != null) {
                    T(2003, str);
                    c.e("recorder", str);
                    return;
                }
            }
            if (DEBUG) {
                Log.d("AudioRecorderManager", "start record");
            }
            try {
                this.mAudioRecord.startRecording();
                if (this.mAudioRecord.getRecordingState() != 3) {
                    alS();
                    c.e("recorder", "start error, no real permission");
                    alP();
                    return;
                }
                if (z) {
                    a(new com.baidu.swan.apps.media.a.b.b() { // from class: com.baidu.swan.apps.media.a.c.a.1
                        @Override // com.baidu.swan.apps.media.a.b.b
                        public void Wx() {
                            if (a.DEBUG) {
                                Log.d("AudioRecorderManager", "record --- timeOut");
                            }
                            c.i("recorder", "time out");
                            a.this.stopRecord();
                            a.this.alP();
                        }
                    });
                    bz(com.baidu.swan.apps.media.a.b.ctR, "recorderStart");
                } else {
                    bz(com.baidu.swan.apps.media.a.b.ctT, "recorderResume");
                }
                d.bS("").d(Schedulers.io()).d(new f<String, Boolean>() { // from class: com.baidu.swan.apps.media.a.c.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.f
                    /* renamed from: mA */
                    public Boolean call(String str2) {
                        return Boolean.valueOf(a.this.alO());
                    }
                }).c(rx.a.b.a.dXQ()).c(new rx.functions.b<Boolean>() { // from class: com.baidu.swan.apps.media.a.c.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.b
                    /* renamed from: f */
                    public void call(Boolean bool) {
                        if (!bool.booleanValue()) {
                            a.this.alS();
                            c.e("recorder", "record error");
                            a.this.alP();
                        }
                    }
                });
            } catch (IllegalStateException e) {
                alS();
                c.e("recorder", "can't start", e);
                alP();
            }
        }
    }

    public void pauseRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "pause record");
        }
        if (this.mAudioRecord == null) {
            alS();
            c.e("recorder", "none audio record");
            alP();
            return;
        }
        try {
            this.mAudioRecord.stop();
            this.cug = 2;
            akn();
            bz(com.baidu.swan.apps.media.a.b.ctS, "recorderPause");
        } catch (IllegalStateException e) {
            alS();
            c.e("recorder", "pause error", e);
            alP();
        }
    }

    public void resumeRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "resume record");
        }
        ey(false);
        akm();
    }

    public void stopRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "stop record");
        }
        if (this.mAudioRecord == null) {
            alS();
            c.e("recorder", "none audioRecord");
            alP();
            return;
        }
        try {
            this.mAudioRecord.stop();
            Wv();
            this.cug = 3;
            alT();
            alV();
        } catch (IllegalStateException e) {
            alS();
            c.e("recorder", "stop error", e);
            alP();
        }
    }

    public void alM() {
        if (this.cug == 0 || this.cug == 1) {
            if (!this.cun) {
                this.cun = true;
                bz(com.baidu.swan.apps.media.a.b.ctW, "recorderInterruptionBegin");
            }
            pauseRecord();
        }
    }

    public void alN() {
        if (this.cun) {
            this.cun = false;
            bz(com.baidu.swan.apps.media.a.b.ctX, "recorderInterruptionEnd");
        }
    }

    public boolean alO() {
        byte[] bArr = new byte[this.cuf];
        com.baidu.swan.apps.media.a.d.a aVar = new com.baidu.swan.apps.media.a.d.a(this.cuk.ctO, this.cuk.channel, this.cuk.sampleRate, this.cuk.bitRate);
        if (this.mAudioRecord == null) {
            return false;
        }
        return a(bArr, aVar);
    }

    private boolean a(byte[] bArr, com.baidu.swan.apps.media.a.d.a aVar) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                File file = new File(this.cue);
                if (this.cug == 0) {
                    if (file.exists()) {
                        file.delete();
                    }
                    com.baidu.swan.d.d.createNewFileSafely(file);
                }
                fileOutputStream = new FileOutputStream(file, true);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            this.cug = 1;
            while (this.cug == 1) {
                if (this.mAudioRecord.read(bArr, 0, this.cuf) >= 0) {
                    byte[] J = TextUtils.equals(this.cuk.ctO, "pcm") ? bArr : aVar.J(bArr);
                    if (J != null && J.length > 0) {
                        fileOutputStream.write(J);
                    }
                }
            }
            com.baidu.swan.d.d.closeSafely(fileOutputStream);
            return true;
        } catch (Exception e2) {
            e = e2;
            fileOutputStream2 = fileOutputStream;
            c.e("recorder", "save record error", e);
            if (this.cug == 1) {
                this.cug = 3;
            }
            com.baidu.swan.d.d.closeSafely(fileOutputStream2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            com.baidu.swan.d.d.closeSafely(fileOutputStream2);
            throw th;
        }
    }

    public void a(final com.baidu.swan.apps.media.a.b.b bVar) {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "start timer:" + this.cuk.ctN);
        }
        c.i("recorder", "start timer, totalTime:" + this.cuk.ctN);
        this.cuh = bVar;
        this.mTimer = new Timer();
        this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.a.c.a.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (bVar != null) {
                    bVar.Wx();
                }
                a.this.Wv();
            }
        }, this.cuk.ctN);
        this.cui = System.currentTimeMillis();
    }

    public void Wv() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "stop timer");
        }
        c.i("recorder", "stop timer");
        this.cuh = null;
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
    }

    public void akn() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "pause timer, lastTime:" + this.cuj);
        }
        c.i("recorder", "pause timer, lastTime:" + this.cuj);
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        this.cuj = this.cuk.ctN - (System.currentTimeMillis() - this.cui);
    }

    public void akm() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "resume timer");
        }
        c.i("recorder", "resume timer");
        if (this.cuh != null) {
            if (this.cuj <= 0) {
                this.cuh.Wx();
                return;
            }
            this.mTimer = new Timer();
            this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.a.c.a.5
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (a.this.cuh != null) {
                        a.this.cuh.Wx();
                    }
                    a.this.Wv();
                }
            }, this.cuj);
            this.cui = System.currentTimeMillis();
        }
    }

    public void dt(boolean z) {
        if (z && this.cug == 1) {
            pauseRecord();
        }
        this.mIsBackground = z;
    }

    public static void ez(boolean z) {
        if (cud != null) {
            cud.dt(z);
        }
    }

    public static void release() {
        if (cud != null) {
            cud.alP();
            cud.alV();
            cud.alN();
        }
    }

    public static void releaseAll() {
        release();
        cud = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alP() {
        Wv();
        this.mContext = null;
        this.cug = -1;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
            this.mAudioRecord = null;
        }
    }

    public com.baidu.swan.apps.media.a.a alQ() {
        return this.cuk;
    }

    public com.baidu.swan.apps.media.a.b alR() {
        return this.cul;
    }

    public boolean my(String str) {
        String str2 = null;
        if (TextUtils.equals(str, "/swanAPI/recorder/pause")) {
            if (this.cug != 1) {
                str2 = "pause fail: recorder is not recording";
            }
        } else if (TextUtils.equals(str, "/swanAPI/recorder/resume")) {
            if (this.cug != 2) {
                str2 = "resume fail: recorder is not paused";
            }
        } else if (TextUtils.equals(str, "/swanAPI/recorder/stop") && this.cug != 2 && this.cug != 1) {
            str2 = "stop fail: recorder is not started";
        }
        if (str2 != null) {
            T(2003, str2);
            c.e("recorder", str2);
            return false;
        }
        return true;
    }

    public boolean mz(String str) {
        if (this.mIsBackground) {
            return TextUtils.equals(str, "/swanAPI/recorder/start") || TextUtils.equals(str, "/swanAPI/recorder/resume");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alS() {
        T(2002, "error execute");
    }

    private void T(int i, String str) {
        if (this.cul == null || TextUtils.isEmpty(com.baidu.swan.apps.media.a.b.ctV)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errCode", i);
                jSONObject.put("errMsg", str);
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                com.baidu.swan.apps.v.f.akr().a(new com.baidu.swan.apps.event.a.b("recorderError", hashMap));
                return;
            } catch (JSONException e) {
                c.e("recorder", "json error", e);
                alP();
                return;
            }
        }
        this.cul.T(i, str);
    }

    private void bz(String str, String str2) {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "dispatchCallback: " + str + " " + str2);
        }
        if (this.cul != null && !TextUtils.isEmpty(str)) {
            this.cul.mk(str);
            return;
        }
        com.baidu.swan.apps.v.f.akr().a(new com.baidu.swan.apps.event.a.b(str2));
    }

    private void alT() {
        long j;
        long j2 = -1;
        String bZ = com.baidu.swan.apps.storage.b.bZ(this.cue, this.mAppId);
        if (TextUtils.isEmpty(this.cue)) {
            j = -1;
        } else {
            j = com.baidu.swan.d.d.vl(this.cue);
            j2 = new File(this.cue).length();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(bZ)) {
                jSONObject.put("tempFilePath", bZ);
            }
            if (j >= 0) {
                jSONObject.put("duration", j);
            }
            if (j2 >= 0) {
                jSONObject.put("fileSize", j2);
            }
            if (this.cul != null && !TextUtils.isEmpty(com.baidu.swan.apps.media.a.b.ctU)) {
                this.cul.e(com.baidu.swan.apps.media.a.b.ctU, jSONObject);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            com.baidu.swan.apps.v.f.akr().a(new com.baidu.swan.apps.event.a.b("recorderStop", hashMap));
        } catch (JSONException e) {
            alS();
            c.e("recorder", "json error", e);
            alP();
        }
    }

    private void alU() {
        if (this.mContext != null) {
            this.mTelephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
            this.cum = new com.baidu.swan.apps.media.a.b.a();
            this.mTelephonyManager.listen(this.cum, 32);
        }
    }

    private void alV() {
        if (this.mTelephonyManager != null && this.cum != null) {
            this.mTelephonyManager.listen(this.cum, 0);
            this.mTelephonyManager = null;
            this.cum = null;
        }
    }
}
