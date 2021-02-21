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
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a dmd;
    private String dme;
    private int dmf;
    private com.baidu.swan.apps.media.a.b.b dmh;
    private long dmi;
    private long dmj;
    private com.baidu.swan.apps.media.a.b dml;
    private com.baidu.swan.apps.media.a.b.a dmm;
    private String mAppId;
    private AudioRecord mAudioRecord;
    private Context mContext;
    private boolean mIsBackground;
    private TelephonyManager mTelephonyManager;
    private Timer mTimer;
    private int dmg = -1;
    private com.baidu.swan.apps.media.a.a dmk = new com.baidu.swan.apps.media.a.a();
    private boolean dmn = false;

    private a() {
    }

    public static a aBK() {
        if (dmd == null) {
            synchronized (a.class) {
                if (dmd == null) {
                    dmd = new a();
                }
            }
        }
        return dmd;
    }

    public void a(String str, com.baidu.swan.apps.media.a.a aVar, Context context, com.baidu.swan.apps.media.a.b bVar, String str2) {
        int i;
        if (this.dmg != -1 && this.dmg != 3) {
            c.e("recorder", "wrong state, can't init");
            return;
        }
        this.dmk = aVar;
        pL(str);
        this.dml = bVar;
        this.dmf = AudioRecord.getMinBufferSize(aVar.sampleRate, aVar.channel, 2);
        if (this.dmf <= 0) {
            aBR();
            c.e("recorder", "wrong buffer size");
            aBO();
            return;
        }
        if (aVar.channel == 1) {
            i = 16;
        } else {
            i = 12;
        }
        this.mAudioRecord = new AudioRecord(aVar.audioSource, aVar.sampleRate, i, 2, this.dmf);
        this.dmg = 0;
        this.mContext = context;
        this.mAppId = str2;
        aBT();
    }

    private void pL(String str) {
        String str2;
        if (TextUtils.equals(this.dmk.dlP, "mp3")) {
            str2 = ".mp3";
        } else if (TextUtils.equals(this.dmk.dlP, "pcm")) {
            str2 = ".pcm";
        } else {
            str2 = ".aac";
        }
        this.dme = str + File.separator + "AUDIO_" + Calendar.getInstance().getTimeInMillis() + str2;
    }

    public void ge(boolean z) {
        if (this.mContext == null) {
            aBR();
            c.e("recorder", "start error, context is null");
            aBO();
        } else if (this.dmg == -1 || TextUtils.isEmpty(this.dme)) {
            aBR();
            c.e("recorder", "start error, wrong state");
            aBO();
        } else {
            if (z) {
                String str = null;
                if (this.dmg == 1) {
                    str = "start fail: recorder is recording";
                } else if (this.dmg != 0 && this.dmg != 3) {
                    str = "start fail: recorder is paused";
                }
                if (str != null) {
                    ar(2003, str);
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
                    aBR();
                    c.e("recorder", "start error, no real permission");
                    aBO();
                    return;
                }
                if (z) {
                    a(new com.baidu.swan.apps.media.a.b.b() { // from class: com.baidu.swan.apps.media.a.c.a.1
                        @Override // com.baidu.swan.apps.media.a.b.b
                        public void akH() {
                            if (a.DEBUG) {
                                Log.d("AudioRecorderManager", "record --- timeOut");
                            }
                            c.i("recorder", "time out");
                            a.this.stopRecord();
                            a.this.aBO();
                        }
                    });
                    bW(com.baidu.swan.apps.media.a.b.dlR, "recorderStart");
                } else {
                    bW(com.baidu.swan.apps.media.a.b.dlT, "recorderResume");
                }
                d.bX("").d(Schedulers.io()).d(new f<String, Boolean>() { // from class: com.baidu.swan.apps.media.a.c.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.f
                    /* renamed from: pO */
                    public Boolean call(String str2) {
                        return Boolean.valueOf(a.this.aBN());
                    }
                }).c(rx.a.b.a.eMU()).c(new rx.functions.b<Boolean>() { // from class: com.baidu.swan.apps.media.a.c.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.b
                    /* renamed from: j */
                    public void call(Boolean bool) {
                        if (!bool.booleanValue()) {
                            a.this.aBR();
                            c.e("recorder", "record error");
                            a.this.aBO();
                        }
                    }
                });
            } catch (IllegalStateException e) {
                aBR();
                c.e("recorder", "can't start", e);
                aBO();
            }
        }
    }

    public void pauseRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "pause record");
        }
        if (this.mAudioRecord == null) {
            aBR();
            c.e("recorder", "none audio record");
            aBO();
            return;
        }
        try {
            this.mAudioRecord.stop();
            this.dmg = 2;
            aAh();
            bW(com.baidu.swan.apps.media.a.b.dlS, "recorderPause");
        } catch (IllegalStateException e) {
            aBR();
            c.e("recorder", "pause error", e);
            aBO();
        }
    }

    public void resumeRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "resume record");
        }
        ge(false);
        aAg();
    }

    public void stopRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "stop record");
        }
        if (this.mAudioRecord == null) {
            aBR();
            c.e("recorder", "none audioRecord");
            aBO();
            return;
        }
        try {
            this.mAudioRecord.stop();
            akF();
            this.dmg = 3;
            aBS();
            aBU();
        } catch (IllegalStateException e) {
            aBR();
            c.e("recorder", "stop error", e);
            aBO();
        }
    }

    public void aBL() {
        if (this.dmg == 0 || this.dmg == 1) {
            if (!this.dmn) {
                this.dmn = true;
                bW(com.baidu.swan.apps.media.a.b.dlW, "recorderInterruptionBegin");
            }
            pauseRecord();
        }
    }

    public void aBM() {
        if (this.dmn) {
            this.dmn = false;
            bW(com.baidu.swan.apps.media.a.b.dlX, "recorderInterruptionEnd");
        }
    }

    public boolean aBN() {
        byte[] bArr = new byte[this.dmf];
        com.baidu.swan.apps.media.a.d.a aVar = new com.baidu.swan.apps.media.a.d.a(this.dmk.dlP, this.dmk.channel, this.dmk.sampleRate, this.dmk.bitRate);
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
                File file = new File(this.dme);
                if (this.dmg == 0) {
                    if (file.exists()) {
                        file.delete();
                    }
                    com.baidu.swan.c.d.createNewFileSafely(file);
                }
                fileOutputStream = new FileOutputStream(file, true);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            this.dmg = 1;
            while (this.dmg == 1) {
                if (this.mAudioRecord.read(bArr, 0, this.dmf) >= 0) {
                    byte[] H = TextUtils.equals(this.dmk.dlP, "pcm") ? bArr : aVar.H(bArr);
                    if (H != null && H.length > 0) {
                        fileOutputStream.write(H);
                    }
                }
            }
            com.baidu.swan.c.d.closeSafely(fileOutputStream);
            return true;
        } catch (Exception e2) {
            e = e2;
            fileOutputStream2 = fileOutputStream;
            c.e("recorder", "save record error", e);
            if (this.dmg == 1) {
                this.dmg = 3;
            }
            com.baidu.swan.c.d.closeSafely(fileOutputStream2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            com.baidu.swan.c.d.closeSafely(fileOutputStream2);
            throw th;
        }
    }

    public void a(final com.baidu.swan.apps.media.a.b.b bVar) {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "start timer:" + this.dmk.dlO);
        }
        c.i("recorder", "start timer, totalTime:" + this.dmk.dlO);
        this.dmh = bVar;
        this.mTimer = new Timer();
        this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.a.c.a.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (bVar != null) {
                    bVar.akH();
                }
                a.this.akF();
            }
        }, this.dmk.dlO);
        this.dmi = System.currentTimeMillis();
    }

    public void akF() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "stop timer");
        }
        c.i("recorder", "stop timer");
        this.dmh = null;
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
    }

    public void aAh() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "pause timer, lastTime:" + this.dmj);
        }
        c.i("recorder", "pause timer, lastTime:" + this.dmj);
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        this.dmj = this.dmk.dlO - (System.currentTimeMillis() - this.dmi);
    }

    public void aAg() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "resume timer");
        }
        c.i("recorder", "resume timer");
        if (this.dmh != null) {
            if (this.dmj <= 0) {
                this.dmh.akH();
                return;
            }
            this.mTimer = new Timer();
            this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.a.c.a.5
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (a.this.dmh != null) {
                        a.this.dmh.akH();
                    }
                    a.this.akF();
                }
            }, this.dmj);
            this.dmi = System.currentTimeMillis();
        }
    }

    public void eS(boolean z) {
        if (z && this.dmg == 1) {
            pauseRecord();
        }
        this.mIsBackground = z;
    }

    public static void gf(boolean z) {
        if (dmd != null) {
            dmd.eS(z);
        }
    }

    public static void release() {
        if (dmd != null) {
            dmd.aBO();
            dmd.aBU();
            dmd.aBM();
        }
    }

    public static void releaseAll() {
        release();
        dmd = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBO() {
        akF();
        this.mContext = null;
        this.dmg = -1;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
            this.mAudioRecord = null;
        }
    }

    public com.baidu.swan.apps.media.a.a aBP() {
        return this.dmk;
    }

    public com.baidu.swan.apps.media.a.b aBQ() {
        return this.dml;
    }

    public boolean pM(String str) {
        String str2 = null;
        if (TextUtils.equals(str, "/swanAPI/recorder/pause")) {
            if (this.dmg != 1) {
                str2 = "pause fail: recorder is not recording";
            }
        } else if (TextUtils.equals(str, "/swanAPI/recorder/resume")) {
            if (this.dmg != 2) {
                str2 = "resume fail: recorder is not paused";
            }
        } else if (TextUtils.equals(str, "/swanAPI/recorder/stop") && this.dmg != 2 && this.dmg != 1) {
            str2 = "stop fail: recorder is not started";
        }
        if (str2 != null) {
            ar(2003, str2);
            c.e("recorder", str2);
            return false;
        }
        return true;
    }

    public boolean pN(String str) {
        if (this.mIsBackground) {
            return TextUtils.equals(str, "/swanAPI/recorder/start") || TextUtils.equals(str, "/swanAPI/recorder/resume");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBR() {
        ar(2002, "error execute");
    }

    private void ar(int i, String str) {
        if (this.dml == null || TextUtils.isEmpty(com.baidu.swan.apps.media.a.b.dlV)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errCode", i);
                jSONObject.put("errMsg", str);
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                com.baidu.swan.apps.v.f.aAl().b(new com.baidu.swan.apps.event.a.b("recorderError", hashMap));
                return;
            } catch (JSONException e) {
                c.e("recorder", "json error", e);
                aBO();
                return;
            }
        }
        this.dml.ar(i, str);
    }

    private void bW(String str, String str2) {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "dispatchCallback: " + str + " " + str2);
        }
        if (this.dml != null && !TextUtils.isEmpty(str)) {
            this.dml.px(str);
            return;
        }
        com.baidu.swan.apps.v.f.aAl().b(new com.baidu.swan.apps.event.a.b(str2));
    }

    private void aBS() {
        long j;
        long j2;
        String cA = com.baidu.swan.apps.storage.b.cA(this.dme, this.mAppId);
        if (TextUtils.isEmpty(this.dme)) {
            j = -1;
            j2 = -1;
        } else {
            long yR = com.baidu.swan.c.d.yR(this.dme);
            j = new File(this.dme).length();
            j2 = yR;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(cA)) {
                jSONObject.put("tempFilePath", cA);
            }
            if (j2 >= 0) {
                jSONObject.put("duration", j2);
            }
            if (j >= 0) {
                jSONObject.put("fileSize", j);
            }
            if (this.dml != null && !TextUtils.isEmpty(com.baidu.swan.apps.media.a.b.dlU)) {
                this.dml.h(com.baidu.swan.apps.media.a.b.dlU, jSONObject);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            com.baidu.swan.apps.v.f.aAl().b(new com.baidu.swan.apps.event.a.b("recorderStop", hashMap));
        } catch (JSONException e) {
            aBR();
            c.e("recorder", "json error", e);
            aBO();
        }
    }

    private void aBT() {
        if (this.mContext != null) {
            this.mTelephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
            this.dmm = new com.baidu.swan.apps.media.a.b.a();
            this.mTelephonyManager.listen(this.dmm, 32);
        }
    }

    private void aBU() {
        if (this.mTelephonyManager != null && this.dmm != null) {
            this.mTelephonyManager.listen(this.dmm, 0);
            this.mTelephonyManager = null;
            this.dmm = null;
        }
    }
}
