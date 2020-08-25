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
    private static volatile a cBP;
    private String cBQ;
    private int cBR;
    private com.baidu.swan.apps.media.a.b.b cBT;
    private long cBU;
    private long cBV;
    private com.baidu.swan.apps.media.a.b cBX;
    private com.baidu.swan.apps.media.a.b.a cBY;
    private String mAppId;
    private AudioRecord mAudioRecord;
    private Context mContext;
    private boolean mIsBackground;
    private TelephonyManager mTelephonyManager;
    private Timer mTimer;
    private int cBS = -1;
    private com.baidu.swan.apps.media.a.a cBW = new com.baidu.swan.apps.media.a.a();
    private boolean cBZ = false;

    private a() {
    }

    public static a aty() {
        if (cBP == null) {
            synchronized (a.class) {
                if (cBP == null) {
                    cBP = new a();
                }
            }
        }
        return cBP;
    }

    public void a(String str, com.baidu.swan.apps.media.a.a aVar, Context context, com.baidu.swan.apps.media.a.b bVar, String str2) {
        int i;
        if (this.cBS != -1 && this.cBS != 3) {
            c.e("recorder", "wrong state, can't init");
            return;
        }
        this.cBW = aVar;
        ow(str);
        this.cBX = bVar;
        this.cBR = AudioRecord.getMinBufferSize(aVar.sampleRate, aVar.channel, 2);
        if (this.cBR <= 0) {
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
        this.mAudioRecord = new AudioRecord(aVar.cBB, aVar.sampleRate, i, 2, this.cBR);
        this.cBS = 0;
        this.mContext = context;
        this.mAppId = str2;
        atH();
    }

    private void ow(String str) {
        String str2;
        if (TextUtils.equals(this.cBW.cBA, "mp3")) {
            str2 = ".mp3";
        } else if (TextUtils.equals(this.cBW.cBA, "pcm")) {
            str2 = ".pcm";
        } else {
            str2 = ".aac";
        }
        this.cBQ = str + File.separator + "AUDIO_" + Calendar.getInstance().getTimeInMillis() + str2;
    }

    public void eO(boolean z) {
        if (this.mContext == null) {
            atF();
            c.e("recorder", "start error, context is null");
            atC();
        } else if (this.cBS == -1 || TextUtils.isEmpty(this.cBQ)) {
            atF();
            c.e("recorder", "start error, wrong state");
            atC();
        } else {
            if (z) {
                String str = null;
                if (this.cBS == 1) {
                    str = "start fail: recorder is recording";
                } else if (this.cBS != 0 && this.cBS != 3) {
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
                    bM(com.baidu.swan.apps.media.a.b.cBD, "recorderStart");
                } else {
                    bM(com.baidu.swan.apps.media.a.b.cBF, "recorderResume");
                }
                d.bW("").d(Schedulers.io()).d(new f<String, Boolean>() { // from class: com.baidu.swan.apps.media.a.c.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.f
                    /* renamed from: oz */
                    public Boolean call(String str2) {
                        return Boolean.valueOf(a.this.atB());
                    }
                }).c(rx.a.b.a.ejU()).c(new rx.functions.b<Boolean>() { // from class: com.baidu.swan.apps.media.a.c.a.2
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
            this.cBS = 2;
            arU();
            bM(com.baidu.swan.apps.media.a.b.cBE, "recorderPause");
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
        eO(false);
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
            this.cBS = 3;
            atG();
            atI();
        } catch (IllegalStateException e) {
            atF();
            c.e("recorder", "stop error", e);
            atC();
        }
    }

    public void atz() {
        if (this.cBS == 0 || this.cBS == 1) {
            if (!this.cBZ) {
                this.cBZ = true;
                bM(com.baidu.swan.apps.media.a.b.cBI, "recorderInterruptionBegin");
            }
            pauseRecord();
        }
    }

    public void atA() {
        if (this.cBZ) {
            this.cBZ = false;
            bM(com.baidu.swan.apps.media.a.b.cBJ, "recorderInterruptionEnd");
        }
    }

    public boolean atB() {
        byte[] bArr = new byte[this.cBR];
        com.baidu.swan.apps.media.a.d.a aVar = new com.baidu.swan.apps.media.a.d.a(this.cBW.cBA, this.cBW.channel, this.cBW.sampleRate, this.cBW.bitRate);
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
                File file = new File(this.cBQ);
                if (this.cBS == 0) {
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
            this.cBS = 1;
            while (this.cBS == 1) {
                if (this.mAudioRecord.read(bArr, 0, this.cBR) >= 0) {
                    byte[] K = TextUtils.equals(this.cBW.cBA, "pcm") ? bArr : aVar.K(bArr);
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
            if (this.cBS == 1) {
                this.cBS = 3;
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
            Log.d("AudioRecorderManager", "start timer:" + this.cBW.cBz);
        }
        c.i("recorder", "start timer, totalTime:" + this.cBW.cBz);
        this.cBT = bVar;
        this.mTimer = new Timer();
        this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.a.c.a.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (bVar != null) {
                    bVar.acD();
                }
                a.this.acB();
            }
        }, this.cBW.cBz);
        this.cBU = System.currentTimeMillis();
    }

    public void acB() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "stop timer");
        }
        c.i("recorder", "stop timer");
        this.cBT = null;
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
    }

    public void arU() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "pause timer, lastTime:" + this.cBV);
        }
        c.i("recorder", "pause timer, lastTime:" + this.cBV);
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        this.cBV = this.cBW.cBz - (System.currentTimeMillis() - this.cBU);
    }

    public void arT() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "resume timer");
        }
        c.i("recorder", "resume timer");
        if (this.cBT != null) {
            if (this.cBV <= 0) {
                this.cBT.acD();
                return;
            }
            this.mTimer = new Timer();
            this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.a.c.a.5
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (a.this.cBT != null) {
                        a.this.cBT.acD();
                    }
                    a.this.acB();
                }
            }, this.cBV);
            this.cBU = System.currentTimeMillis();
        }
    }

    public void dC(boolean z) {
        if (z && this.cBS == 1) {
            pauseRecord();
        }
        this.mIsBackground = z;
    }

    public static void eP(boolean z) {
        if (cBP != null) {
            cBP.dC(z);
        }
    }

    public static void release() {
        if (cBP != null) {
            cBP.atC();
            cBP.atI();
            cBP.atA();
        }
    }

    public static void releaseAll() {
        release();
        cBP = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atC() {
        acB();
        this.mContext = null;
        this.cBS = -1;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
            this.mAudioRecord = null;
        }
    }

    public com.baidu.swan.apps.media.a.a atD() {
        return this.cBW;
    }

    public com.baidu.swan.apps.media.a.b atE() {
        return this.cBX;
    }

    public boolean ox(String str) {
        String str2 = null;
        if (TextUtils.equals(str, "/swanAPI/recorder/pause")) {
            if (this.cBS != 1) {
                str2 = "pause fail: recorder is not recording";
            }
        } else if (TextUtils.equals(str, "/swanAPI/recorder/resume")) {
            if (this.cBS != 2) {
                str2 = "resume fail: recorder is not paused";
            }
        } else if (TextUtils.equals(str, "/swanAPI/recorder/stop") && this.cBS != 2 && this.cBS != 1) {
            str2 = "stop fail: recorder is not started";
        }
        if (str2 != null) {
            S(2003, str2);
            c.e("recorder", str2);
            return false;
        }
        return true;
    }

    public boolean oy(String str) {
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
        if (this.cBX == null || TextUtils.isEmpty(com.baidu.swan.apps.media.a.b.cBH)) {
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
        this.cBX.S(i, str);
    }

    private void bM(String str, String str2) {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "dispatchCallback: " + str + " " + str2);
        }
        if (this.cBX != null && !TextUtils.isEmpty(str)) {
            this.cBX.oi(str);
            return;
        }
        com.baidu.swan.apps.v.f.arY().b(new com.baidu.swan.apps.event.a.b(str2));
    }

    private void atG() {
        long j;
        long j2 = -1;
        String cq = com.baidu.swan.apps.storage.b.cq(this.cBQ, this.mAppId);
        if (TextUtils.isEmpty(this.cBQ)) {
            j = -1;
        } else {
            j = com.baidu.swan.c.d.xw(this.cBQ);
            j2 = new File(this.cBQ).length();
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
            if (this.cBX != null && !TextUtils.isEmpty(com.baidu.swan.apps.media.a.b.cBG)) {
                this.cBX.e(com.baidu.swan.apps.media.a.b.cBG, jSONObject);
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
            this.cBY = new com.baidu.swan.apps.media.a.b.a();
            this.mTelephonyManager.listen(this.cBY, 32);
        }
    }

    private void atI() {
        if (this.mTelephonyManager != null && this.cBY != null) {
            this.mTelephonyManager.listen(this.cBY, 0);
            this.mTelephonyManager = null;
            this.cBY = null;
        }
    }
}
