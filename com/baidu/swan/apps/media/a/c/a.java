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
/* loaded from: classes8.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a cBT;
    private String cBU;
    private int cBV;
    private com.baidu.swan.apps.media.a.b.b cBX;
    private long cBY;
    private long cBZ;
    private com.baidu.swan.apps.media.a.b cCb;
    private com.baidu.swan.apps.media.a.b.a cCc;
    private String mAppId;
    private AudioRecord mAudioRecord;
    private Context mContext;
    private boolean mIsBackground;
    private TelephonyManager mTelephonyManager;
    private Timer mTimer;
    private int cBW = -1;
    private com.baidu.swan.apps.media.a.a cCa = new com.baidu.swan.apps.media.a.a();
    private boolean cCd = false;

    private a() {
    }

    public static a aty() {
        if (cBT == null) {
            synchronized (a.class) {
                if (cBT == null) {
                    cBT = new a();
                }
            }
        }
        return cBT;
    }

    public void a(String str, com.baidu.swan.apps.media.a.a aVar, Context context, com.baidu.swan.apps.media.a.b bVar, String str2) {
        int i;
        if (this.cBW != -1 && this.cBW != 3) {
            c.e("recorder", "wrong state, can't init");
            return;
        }
        this.cCa = aVar;
        ox(str);
        this.cCb = bVar;
        this.cBV = AudioRecord.getMinBufferSize(aVar.sampleRate, aVar.channel, 2);
        if (this.cBV <= 0) {
            atF();
            c.e("recorder", "wrong buffer size");
            atC();
            return;
        }
        if (aVar.channel == 1) {
            i = 16;
        } else {
            i = 12;
        }
        this.mAudioRecord = new AudioRecord(aVar.cBF, aVar.sampleRate, i, 2, this.cBV);
        this.cBW = 0;
        this.mContext = context;
        this.mAppId = str2;
        atH();
    }

    private void ox(String str) {
        String str2;
        if (TextUtils.equals(this.cCa.cBE, "mp3")) {
            str2 = ".mp3";
        } else if (TextUtils.equals(this.cCa.cBE, "pcm")) {
            str2 = ".pcm";
        } else {
            str2 = ".aac";
        }
        this.cBU = str + File.separator + "AUDIO_" + Calendar.getInstance().getTimeInMillis() + str2;
    }

    public void eP(boolean z) {
        if (this.mContext == null) {
            atF();
            c.e("recorder", "start error, context is null");
            atC();
        } else if (this.cBW == -1 || TextUtils.isEmpty(this.cBU)) {
            atF();
            c.e("recorder", "start error, wrong state");
            atC();
        } else {
            if (z) {
                String str = null;
                if (this.cBW == 1) {
                    str = "start fail: recorder is recording";
                } else if (this.cBW != 0 && this.cBW != 3) {
                    str = "start fail: recorder is paused";
                }
                if (str != null) {
                    S(2003, str);
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
                    atF();
                    c.e("recorder", "start error, no real permission");
                    atC();
                    return;
                }
                if (z) {
                    a(new com.baidu.swan.apps.media.a.b.b() { // from class: com.baidu.swan.apps.media.a.c.a.1
                        @Override // com.baidu.swan.apps.media.a.b.b
                        public void acD() {
                            if (a.DEBUG) {
                                Log.d("AudioRecorderManager", "record --- timeOut");
                            }
                            c.i("recorder", "time out");
                            a.this.stopRecord();
                            a.this.atC();
                        }
                    });
                    bM(com.baidu.swan.apps.media.a.b.cBH, "recorderStart");
                } else {
                    bM(com.baidu.swan.apps.media.a.b.cBJ, "recorderResume");
                }
                d.bW("").d(Schedulers.io()).d(new f<String, Boolean>() { // from class: com.baidu.swan.apps.media.a.c.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.f
                    /* renamed from: oA */
                    public Boolean call(String str2) {
                        return Boolean.valueOf(a.this.atB());
                    }
                }).c(rx.a.b.a.ekd()).c(new rx.functions.b<Boolean>() { // from class: com.baidu.swan.apps.media.a.c.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.b
                    /* renamed from: h */
                    public void call(Boolean bool) {
                        if (!bool.booleanValue()) {
                            a.this.atF();
                            c.e("recorder", "record error");
                            a.this.atC();
                        }
                    }
                });
            } catch (IllegalStateException e) {
                atF();
                c.e("recorder", "can't start", e);
                atC();
            }
        }
    }

    public void pauseRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "pause record");
        }
        if (this.mAudioRecord == null) {
            atF();
            c.e("recorder", "none audio record");
            atC();
            return;
        }
        try {
            this.mAudioRecord.stop();
            this.cBW = 2;
            arU();
            bM(com.baidu.swan.apps.media.a.b.cBI, "recorderPause");
        } catch (IllegalStateException e) {
            atF();
            c.e("recorder", "pause error", e);
            atC();
        }
    }

    public void resumeRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "resume record");
        }
        eP(false);
        arT();
    }

    public void stopRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "stop record");
        }
        if (this.mAudioRecord == null) {
            atF();
            c.e("recorder", "none audioRecord");
            atC();
            return;
        }
        try {
            this.mAudioRecord.stop();
            acB();
            this.cBW = 3;
            atG();
            atI();
        } catch (IllegalStateException e) {
            atF();
            c.e("recorder", "stop error", e);
            atC();
        }
    }

    public void atz() {
        if (this.cBW == 0 || this.cBW == 1) {
            if (!this.cCd) {
                this.cCd = true;
                bM(com.baidu.swan.apps.media.a.b.cBM, "recorderInterruptionBegin");
            }
            pauseRecord();
        }
    }

    public void atA() {
        if (this.cCd) {
            this.cCd = false;
            bM(com.baidu.swan.apps.media.a.b.cBN, "recorderInterruptionEnd");
        }
    }

    public boolean atB() {
        byte[] bArr = new byte[this.cBV];
        com.baidu.swan.apps.media.a.d.a aVar = new com.baidu.swan.apps.media.a.d.a(this.cCa.cBE, this.cCa.channel, this.cCa.sampleRate, this.cCa.bitRate);
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
                File file = new File(this.cBU);
                if (this.cBW == 0) {
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
            this.cBW = 1;
            while (this.cBW == 1) {
                if (this.mAudioRecord.read(bArr, 0, this.cBV) >= 0) {
                    byte[] K = TextUtils.equals(this.cCa.cBE, "pcm") ? bArr : aVar.K(bArr);
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
            if (this.cBW == 1) {
                this.cBW = 3;
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
            Log.d("AudioRecorderManager", "start timer:" + this.cCa.cBD);
        }
        c.i("recorder", "start timer, totalTime:" + this.cCa.cBD);
        this.cBX = bVar;
        this.mTimer = new Timer();
        this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.a.c.a.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (bVar != null) {
                    bVar.acD();
                }
                a.this.acB();
            }
        }, this.cCa.cBD);
        this.cBY = System.currentTimeMillis();
    }

    public void acB() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "stop timer");
        }
        c.i("recorder", "stop timer");
        this.cBX = null;
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
    }

    public void arU() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "pause timer, lastTime:" + this.cBZ);
        }
        c.i("recorder", "pause timer, lastTime:" + this.cBZ);
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        this.cBZ = this.cCa.cBD - (System.currentTimeMillis() - this.cBY);
    }

    public void arT() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "resume timer");
        }
        c.i("recorder", "resume timer");
        if (this.cBX != null) {
            if (this.cBZ <= 0) {
                this.cBX.acD();
                return;
            }
            this.mTimer = new Timer();
            this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.a.c.a.5
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (a.this.cBX != null) {
                        a.this.cBX.acD();
                    }
                    a.this.acB();
                }
            }, this.cBZ);
            this.cBY = System.currentTimeMillis();
        }
    }

    public void dD(boolean z) {
        if (z && this.cBW == 1) {
            pauseRecord();
        }
        this.mIsBackground = z;
    }

    public static void eQ(boolean z) {
        if (cBT != null) {
            cBT.dD(z);
        }
    }

    public static void release() {
        if (cBT != null) {
            cBT.atC();
            cBT.atI();
            cBT.atA();
        }
    }

    public static void releaseAll() {
        release();
        cBT = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atC() {
        acB();
        this.mContext = null;
        this.cBW = -1;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
            this.mAudioRecord = null;
        }
    }

    public com.baidu.swan.apps.media.a.a atD() {
        return this.cCa;
    }

    public com.baidu.swan.apps.media.a.b atE() {
        return this.cCb;
    }

    public boolean oy(String str) {
        String str2 = null;
        if (TextUtils.equals(str, "/swanAPI/recorder/pause")) {
            if (this.cBW != 1) {
                str2 = "pause fail: recorder is not recording";
            }
        } else if (TextUtils.equals(str, "/swanAPI/recorder/resume")) {
            if (this.cBW != 2) {
                str2 = "resume fail: recorder is not paused";
            }
        } else if (TextUtils.equals(str, "/swanAPI/recorder/stop") && this.cBW != 2 && this.cBW != 1) {
            str2 = "stop fail: recorder is not started";
        }
        if (str2 != null) {
            S(2003, str2);
            c.e("recorder", str2);
            return false;
        }
        return true;
    }

    public boolean oz(String str) {
        if (this.mIsBackground) {
            return TextUtils.equals(str, "/swanAPI/recorder/start") || TextUtils.equals(str, "/swanAPI/recorder/resume");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atF() {
        S(2002, "error execute");
    }

    private void S(int i, String str) {
        if (this.cCb == null || TextUtils.isEmpty(com.baidu.swan.apps.media.a.b.cBL)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errCode", i);
                jSONObject.put("errMsg", str);
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                com.baidu.swan.apps.v.f.arY().b(new com.baidu.swan.apps.event.a.b("recorderError", hashMap));
                return;
            } catch (JSONException e) {
                c.e("recorder", "json error", e);
                atC();
                return;
            }
        }
        this.cCb.S(i, str);
    }

    private void bM(String str, String str2) {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "dispatchCallback: " + str + " " + str2);
        }
        if (this.cCb != null && !TextUtils.isEmpty(str)) {
            this.cCb.oj(str);
            return;
        }
        com.baidu.swan.apps.v.f.arY().b(new com.baidu.swan.apps.event.a.b(str2));
    }

    private void atG() {
        long j;
        long j2 = -1;
        String cq = com.baidu.swan.apps.storage.b.cq(this.cBU, this.mAppId);
        if (TextUtils.isEmpty(this.cBU)) {
            j = -1;
        } else {
            j = com.baidu.swan.c.d.xx(this.cBU);
            j2 = new File(this.cBU).length();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(cq)) {
                jSONObject.put("tempFilePath", cq);
            }
            if (j >= 0) {
                jSONObject.put("duration", j);
            }
            if (j2 >= 0) {
                jSONObject.put("fileSize", j2);
            }
            if (this.cCb != null && !TextUtils.isEmpty(com.baidu.swan.apps.media.a.b.cBK)) {
                this.cCb.e(com.baidu.swan.apps.media.a.b.cBK, jSONObject);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            com.baidu.swan.apps.v.f.arY().b(new com.baidu.swan.apps.event.a.b("recorderStop", hashMap));
        } catch (JSONException e) {
            atF();
            c.e("recorder", "json error", e);
            atC();
        }
    }

    private void atH() {
        if (this.mContext != null) {
            this.mTelephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
            this.cCc = new com.baidu.swan.apps.media.a.b.a();
            this.mTelephonyManager.listen(this.cCc, 32);
        }
    }

    private void atI() {
        if (this.mTelephonyManager != null && this.cCc != null) {
            this.mTelephonyManager.listen(this.cCc, 0);
            this.mTelephonyManager = null;
            this.cCc = null;
        }
    }
}
