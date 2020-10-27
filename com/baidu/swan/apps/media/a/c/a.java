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
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a cYt;
    private com.baidu.swan.apps.media.a.b cYB;
    private com.baidu.swan.apps.media.a.b.a cYC;
    private String cYu;
    private int cYv;
    private com.baidu.swan.apps.media.a.b.b cYx;
    private long cYy;
    private long cYz;
    private String mAppId;
    private AudioRecord mAudioRecord;
    private Context mContext;
    private boolean mIsBackground;
    private TelephonyManager mTelephonyManager;
    private Timer mTimer;
    private int cYw = -1;
    private com.baidu.swan.apps.media.a.a cYA = new com.baidu.swan.apps.media.a.a();
    private boolean cYD = false;

    private a() {
    }

    public static a ayM() {
        if (cYt == null) {
            synchronized (a.class) {
                if (cYt == null) {
                    cYt = new a();
                }
            }
        }
        return cYt;
    }

    public void a(String str, com.baidu.swan.apps.media.a.a aVar, Context context, com.baidu.swan.apps.media.a.b bVar, String str2) {
        int i;
        if (this.cYw != -1 && this.cYw != 3) {
            c.e("recorder", "wrong state, can't init");
            return;
        }
        this.cYA = aVar;
        pV(str);
        this.cYB = bVar;
        this.cYv = AudioRecord.getMinBufferSize(aVar.sampleRate, aVar.channel, 2);
        if (this.cYv <= 0) {
            ayT();
            c.e("recorder", "wrong buffer size");
            ayQ();
            return;
        }
        if (aVar.channel == 1) {
            i = 16;
        } else {
            i = 12;
        }
        this.mAudioRecord = new AudioRecord(aVar.audioSource, aVar.sampleRate, i, 2, this.cYv);
        this.cYw = 0;
        this.mContext = context;
        this.mAppId = str2;
        ayV();
    }

    private void pV(String str) {
        String str2;
        if (TextUtils.equals(this.cYA.cYf, "mp3")) {
            str2 = ".mp3";
        } else if (TextUtils.equals(this.cYA.cYf, "pcm")) {
            str2 = ".pcm";
        } else {
            str2 = ".aac";
        }
        this.cYu = str + File.separator + "AUDIO_" + Calendar.getInstance().getTimeInMillis() + str2;
    }

    public void fw(boolean z) {
        if (this.mContext == null) {
            ayT();
            c.e("recorder", "start error, context is null");
            ayQ();
        } else if (this.cYw == -1 || TextUtils.isEmpty(this.cYu)) {
            ayT();
            c.e("recorder", "start error, wrong state");
            ayQ();
        } else {
            if (z) {
                String str = null;
                if (this.cYw == 1) {
                    str = "start fail: recorder is recording";
                } else if (this.cYw != 0 && this.cYw != 3) {
                    str = "start fail: recorder is paused";
                }
                if (str != null) {
                    ag(2003, str);
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
                    ayT();
                    c.e("recorder", "start error, no real permission");
                    ayQ();
                    return;
                }
                if (z) {
                    a(new com.baidu.swan.apps.media.a.b.b() { // from class: com.baidu.swan.apps.media.a.c.a.1
                        @Override // com.baidu.swan.apps.media.a.b.b
                        public void ahS() {
                            if (a.DEBUG) {
                                Log.d("AudioRecorderManager", "record --- timeOut");
                            }
                            c.i("recorder", "time out");
                            a.this.stopRecord();
                            a.this.ayQ();
                        }
                    });
                    bY(com.baidu.swan.apps.media.a.b.cYh, "recorderStart");
                } else {
                    bY(com.baidu.swan.apps.media.a.b.cYj, "recorderResume");
                }
                d.cd("").d(Schedulers.io()).d(new f<String, Boolean>() { // from class: com.baidu.swan.apps.media.a.c.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.f
                    /* renamed from: pY */
                    public Boolean call(String str2) {
                        return Boolean.valueOf(a.this.ayP());
                    }
                }).c(rx.a.b.a.eBK()).c(new rx.functions.b<Boolean>() { // from class: com.baidu.swan.apps.media.a.c.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.b
                    /* renamed from: i */
                    public void call(Boolean bool) {
                        if (!bool.booleanValue()) {
                            a.this.ayT();
                            c.e("recorder", "record error");
                            a.this.ayQ();
                        }
                    }
                });
            } catch (IllegalStateException e) {
                ayT();
                c.e("recorder", "can't start", e);
                ayQ();
            }
        }
    }

    public void pauseRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "pause record");
        }
        if (this.mAudioRecord == null) {
            ayT();
            c.e("recorder", "none audio record");
            ayQ();
            return;
        }
        try {
            this.mAudioRecord.stop();
            this.cYw = 2;
            axk();
            bY(com.baidu.swan.apps.media.a.b.cYi, "recorderPause");
        } catch (IllegalStateException e) {
            ayT();
            c.e("recorder", "pause error", e);
            ayQ();
        }
    }

    public void resumeRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "resume record");
        }
        fw(false);
        axj();
    }

    public void stopRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "stop record");
        }
        if (this.mAudioRecord == null) {
            ayT();
            c.e("recorder", "none audioRecord");
            ayQ();
            return;
        }
        try {
            this.mAudioRecord.stop();
            ahQ();
            this.cYw = 3;
            ayU();
            ayW();
        } catch (IllegalStateException e) {
            ayT();
            c.e("recorder", "stop error", e);
            ayQ();
        }
    }

    public void ayN() {
        if (this.cYw == 0 || this.cYw == 1) {
            if (!this.cYD) {
                this.cYD = true;
                bY(com.baidu.swan.apps.media.a.b.cYm, "recorderInterruptionBegin");
            }
            pauseRecord();
        }
    }

    public void ayO() {
        if (this.cYD) {
            this.cYD = false;
            bY(com.baidu.swan.apps.media.a.b.cYn, "recorderInterruptionEnd");
        }
    }

    public boolean ayP() {
        byte[] bArr = new byte[this.cYv];
        com.baidu.swan.apps.media.a.d.a aVar = new com.baidu.swan.apps.media.a.d.a(this.cYA.cYf, this.cYA.channel, this.cYA.sampleRate, this.cYA.bitRate);
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
                File file = new File(this.cYu);
                if (this.cYw == 0) {
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
            this.cYw = 1;
            while (this.cYw == 1) {
                if (this.mAudioRecord.read(bArr, 0, this.cYv) >= 0) {
                    byte[] K = TextUtils.equals(this.cYA.cYf, "pcm") ? bArr : aVar.K(bArr);
                    if (K != null && K.length > 0) {
                        fileOutputStream.write(K);
                    }
                }
            }
            com.baidu.swan.c.d.closeSafely(fileOutputStream);
            return true;
        } catch (Exception e2) {
            e = e2;
            fileOutputStream2 = fileOutputStream;
            c.e("recorder", "save record error", e);
            if (this.cYw == 1) {
                this.cYw = 3;
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
            Log.d("AudioRecorderManager", "start timer:" + this.cYA.cYe);
        }
        c.i("recorder", "start timer, totalTime:" + this.cYA.cYe);
        this.cYx = bVar;
        this.mTimer = new Timer();
        this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.a.c.a.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (bVar != null) {
                    bVar.ahS();
                }
                a.this.ahQ();
            }
        }, this.cYA.cYe);
        this.cYy = System.currentTimeMillis();
    }

    public void ahQ() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "stop timer");
        }
        c.i("recorder", "stop timer");
        this.cYx = null;
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
    }

    public void axk() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "pause timer, lastTime:" + this.cYz);
        }
        c.i("recorder", "pause timer, lastTime:" + this.cYz);
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        this.cYz = this.cYA.cYe - (System.currentTimeMillis() - this.cYy);
    }

    public void axj() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "resume timer");
        }
        c.i("recorder", "resume timer");
        if (this.cYx != null) {
            if (this.cYz <= 0) {
                this.cYx.ahS();
                return;
            }
            this.mTimer = new Timer();
            this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.a.c.a.5
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (a.this.cYx != null) {
                        a.this.cYx.ahS();
                    }
                    a.this.ahQ();
                }
            }, this.cYz);
            this.cYy = System.currentTimeMillis();
        }
    }

    public void ek(boolean z) {
        if (z && this.cYw == 1) {
            pauseRecord();
        }
        this.mIsBackground = z;
    }

    public static void fx(boolean z) {
        if (cYt != null) {
            cYt.ek(z);
        }
    }

    public static void release() {
        if (cYt != null) {
            cYt.ayQ();
            cYt.ayW();
            cYt.ayO();
        }
    }

    public static void releaseAll() {
        release();
        cYt = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayQ() {
        ahQ();
        this.mContext = null;
        this.cYw = -1;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
            this.mAudioRecord = null;
        }
    }

    public com.baidu.swan.apps.media.a.a ayR() {
        return this.cYA;
    }

    public com.baidu.swan.apps.media.a.b ayS() {
        return this.cYB;
    }

    public boolean pW(String str) {
        String str2 = null;
        if (TextUtils.equals(str, "/swanAPI/recorder/pause")) {
            if (this.cYw != 1) {
                str2 = "pause fail: recorder is not recording";
            }
        } else if (TextUtils.equals(str, "/swanAPI/recorder/resume")) {
            if (this.cYw != 2) {
                str2 = "resume fail: recorder is not paused";
            }
        } else if (TextUtils.equals(str, "/swanAPI/recorder/stop") && this.cYw != 2 && this.cYw != 1) {
            str2 = "stop fail: recorder is not started";
        }
        if (str2 != null) {
            ag(2003, str2);
            c.e("recorder", str2);
            return false;
        }
        return true;
    }

    public boolean pX(String str) {
        if (this.mIsBackground) {
            return TextUtils.equals(str, "/swanAPI/recorder/start") || TextUtils.equals(str, "/swanAPI/recorder/resume");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayT() {
        ag(2002, "error execute");
    }

    private void ag(int i, String str) {
        if (this.cYB == null || TextUtils.isEmpty(com.baidu.swan.apps.media.a.b.cYl)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errCode", i);
                jSONObject.put("errMsg", str);
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                com.baidu.swan.apps.v.f.axo().b(new com.baidu.swan.apps.event.a.b("recorderError", hashMap));
                return;
            } catch (JSONException e) {
                c.e("recorder", "json error", e);
                ayQ();
                return;
            }
        }
        this.cYB.ag(i, str);
    }

    private void bY(String str, String str2) {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "dispatchCallback: " + str + " " + str2);
        }
        if (this.cYB != null && !TextUtils.isEmpty(str)) {
            this.cYB.pI(str);
            return;
        }
        com.baidu.swan.apps.v.f.axo().b(new com.baidu.swan.apps.event.a.b(str2));
    }

    private void ayU() {
        long j;
        long j2 = -1;
        String cC = com.baidu.swan.apps.storage.b.cC(this.cYu, this.mAppId);
        if (TextUtils.isEmpty(this.cYu)) {
            j = -1;
        } else {
            j = com.baidu.swan.c.d.yV(this.cYu);
            j2 = new File(this.cYu).length();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(cC)) {
                jSONObject.put("tempFilePath", cC);
            }
            if (j >= 0) {
                jSONObject.put("duration", j);
            }
            if (j2 >= 0) {
                jSONObject.put("fileSize", j2);
            }
            if (this.cYB != null && !TextUtils.isEmpty(com.baidu.swan.apps.media.a.b.cYk)) {
                this.cYB.e(com.baidu.swan.apps.media.a.b.cYk, jSONObject);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            com.baidu.swan.apps.v.f.axo().b(new com.baidu.swan.apps.event.a.b("recorderStop", hashMap));
        } catch (JSONException e) {
            ayT();
            c.e("recorder", "json error", e);
            ayQ();
        }
    }

    private void ayV() {
        if (this.mContext != null) {
            this.mTelephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
            this.cYC = new com.baidu.swan.apps.media.a.b.a();
            this.mTelephonyManager.listen(this.cYC, 32);
        }
    }

    private void ayW() {
        if (this.mTelephonyManager != null && this.cYC != null) {
            this.mTelephonyManager.listen(this.cYC, 0);
            this.mTelephonyManager = null;
            this.cYC = null;
        }
    }
}
