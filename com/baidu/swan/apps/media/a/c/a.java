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
    private static volatile a dnF;
    private String dnG;
    private int dnH;
    private com.baidu.swan.apps.media.a.b.b dnJ;
    private long dnK;
    private long dnL;
    private com.baidu.swan.apps.media.a.b dnN;
    private com.baidu.swan.apps.media.a.b.a dnO;
    private String mAppId;
    private AudioRecord mAudioRecord;
    private Context mContext;
    private boolean mIsBackground;
    private TelephonyManager mTelephonyManager;
    private Timer mTimer;
    private int dnI = -1;
    private com.baidu.swan.apps.media.a.a dnM = new com.baidu.swan.apps.media.a.a();
    private boolean dnP = false;

    private a() {
    }

    public static a aBN() {
        if (dnF == null) {
            synchronized (a.class) {
                if (dnF == null) {
                    dnF = new a();
                }
            }
        }
        return dnF;
    }

    public void a(String str, com.baidu.swan.apps.media.a.a aVar, Context context, com.baidu.swan.apps.media.a.b bVar, String str2) {
        int i;
        if (this.dnI != -1 && this.dnI != 3) {
            c.e("recorder", "wrong state, can't init");
            return;
        }
        this.dnM = aVar;
        pS(str);
        this.dnN = bVar;
        this.dnH = AudioRecord.getMinBufferSize(aVar.sampleRate, aVar.channel, 2);
        if (this.dnH <= 0) {
            aBU();
            c.e("recorder", "wrong buffer size");
            aBR();
            return;
        }
        if (aVar.channel == 1) {
            i = 16;
        } else {
            i = 12;
        }
        this.mAudioRecord = new AudioRecord(aVar.audioSource, aVar.sampleRate, i, 2, this.dnH);
        this.dnI = 0;
        this.mContext = context;
        this.mAppId = str2;
        aBW();
    }

    private void pS(String str) {
        String str2;
        if (TextUtils.equals(this.dnM.dnq, "mp3")) {
            str2 = ".mp3";
        } else if (TextUtils.equals(this.dnM.dnq, "pcm")) {
            str2 = ".pcm";
        } else {
            str2 = ".aac";
        }
        this.dnG = str + File.separator + "AUDIO_" + Calendar.getInstance().getTimeInMillis() + str2;
    }

    public void ge(boolean z) {
        if (this.mContext == null) {
            aBU();
            c.e("recorder", "start error, context is null");
            aBR();
        } else if (this.dnI == -1 || TextUtils.isEmpty(this.dnG)) {
            aBU();
            c.e("recorder", "start error, wrong state");
            aBR();
        } else {
            if (z) {
                String str = null;
                if (this.dnI == 1) {
                    str = "start fail: recorder is recording";
                } else if (this.dnI != 0 && this.dnI != 3) {
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
                    aBU();
                    c.e("recorder", "start error, no real permission");
                    aBR();
                    return;
                }
                if (z) {
                    a(new com.baidu.swan.apps.media.a.b.b() { // from class: com.baidu.swan.apps.media.a.c.a.1
                        @Override // com.baidu.swan.apps.media.a.b.b
                        public void akK() {
                            if (a.DEBUG) {
                                Log.d("AudioRecorderManager", "record --- timeOut");
                            }
                            c.i("recorder", "time out");
                            a.this.stopRecord();
                            a.this.aBR();
                        }
                    });
                    bW(com.baidu.swan.apps.media.a.b.dnt, "recorderStart");
                } else {
                    bW(com.baidu.swan.apps.media.a.b.dnv, "recorderResume");
                }
                d.bY("").d(Schedulers.io()).d(new f<String, Boolean>() { // from class: com.baidu.swan.apps.media.a.c.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.f
                    /* renamed from: pV */
                    public Boolean call(String str2) {
                        return Boolean.valueOf(a.this.aBQ());
                    }
                }).c(rx.a.b.a.eMC()).c(new rx.functions.b<Boolean>() { // from class: com.baidu.swan.apps.media.a.c.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.b
                    /* renamed from: j */
                    public void call(Boolean bool) {
                        if (!bool.booleanValue()) {
                            a.this.aBU();
                            c.e("recorder", "record error");
                            a.this.aBR();
                        }
                    }
                });
            } catch (IllegalStateException e) {
                aBU();
                c.e("recorder", "can't start", e);
                aBR();
            }
        }
    }

    public void pauseRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "pause record");
        }
        if (this.mAudioRecord == null) {
            aBU();
            c.e("recorder", "none audio record");
            aBR();
            return;
        }
        try {
            this.mAudioRecord.stop();
            this.dnI = 2;
            aAk();
            bW(com.baidu.swan.apps.media.a.b.dnu, "recorderPause");
        } catch (IllegalStateException e) {
            aBU();
            c.e("recorder", "pause error", e);
            aBR();
        }
    }

    public void resumeRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "resume record");
        }
        ge(false);
        aAj();
    }

    public void stopRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "stop record");
        }
        if (this.mAudioRecord == null) {
            aBU();
            c.e("recorder", "none audioRecord");
            aBR();
            return;
        }
        try {
            this.mAudioRecord.stop();
            akI();
            this.dnI = 3;
            aBV();
            aBX();
        } catch (IllegalStateException e) {
            aBU();
            c.e("recorder", "stop error", e);
            aBR();
        }
    }

    public void aBO() {
        if (this.dnI == 0 || this.dnI == 1) {
            if (!this.dnP) {
                this.dnP = true;
                bW(com.baidu.swan.apps.media.a.b.dny, "recorderInterruptionBegin");
            }
            pauseRecord();
        }
    }

    public void aBP() {
        if (this.dnP) {
            this.dnP = false;
            bW(com.baidu.swan.apps.media.a.b.dnz, "recorderInterruptionEnd");
        }
    }

    public boolean aBQ() {
        byte[] bArr = new byte[this.dnH];
        com.baidu.swan.apps.media.a.d.a aVar = new com.baidu.swan.apps.media.a.d.a(this.dnM.dnq, this.dnM.channel, this.dnM.sampleRate, this.dnM.bitRate);
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
                File file = new File(this.dnG);
                if (this.dnI == 0) {
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
            this.dnI = 1;
            while (this.dnI == 1) {
                if (this.mAudioRecord.read(bArr, 0, this.dnH) >= 0) {
                    byte[] J = TextUtils.equals(this.dnM.dnq, "pcm") ? bArr : aVar.J(bArr);
                    if (J != null && J.length > 0) {
                        fileOutputStream.write(J);
                    }
                }
            }
            com.baidu.swan.c.d.closeSafely(fileOutputStream);
            return true;
        } catch (Exception e2) {
            e = e2;
            fileOutputStream2 = fileOutputStream;
            c.e("recorder", "save record error", e);
            if (this.dnI == 1) {
                this.dnI = 3;
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
            Log.d("AudioRecorderManager", "start timer:" + this.dnM.dnp);
        }
        c.i("recorder", "start timer, totalTime:" + this.dnM.dnp);
        this.dnJ = bVar;
        this.mTimer = new Timer();
        this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.a.c.a.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (bVar != null) {
                    bVar.akK();
                }
                a.this.akI();
            }
        }, this.dnM.dnp);
        this.dnK = System.currentTimeMillis();
    }

    public void akI() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "stop timer");
        }
        c.i("recorder", "stop timer");
        this.dnJ = null;
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
    }

    public void aAk() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "pause timer, lastTime:" + this.dnL);
        }
        c.i("recorder", "pause timer, lastTime:" + this.dnL);
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        this.dnL = this.dnM.dnp - (System.currentTimeMillis() - this.dnK);
    }

    public void aAj() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "resume timer");
        }
        c.i("recorder", "resume timer");
        if (this.dnJ != null) {
            if (this.dnL <= 0) {
                this.dnJ.akK();
                return;
            }
            this.mTimer = new Timer();
            this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.a.c.a.5
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (a.this.dnJ != null) {
                        a.this.dnJ.akK();
                    }
                    a.this.akI();
                }
            }, this.dnL);
            this.dnK = System.currentTimeMillis();
        }
    }

    public void eS(boolean z) {
        if (z && this.dnI == 1) {
            pauseRecord();
        }
        this.mIsBackground = z;
    }

    public static void gf(boolean z) {
        if (dnF != null) {
            dnF.eS(z);
        }
    }

    public static void release() {
        if (dnF != null) {
            dnF.aBR();
            dnF.aBX();
            dnF.aBP();
        }
    }

    public static void releaseAll() {
        release();
        dnF = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBR() {
        akI();
        this.mContext = null;
        this.dnI = -1;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
            this.mAudioRecord = null;
        }
    }

    public com.baidu.swan.apps.media.a.a aBS() {
        return this.dnM;
    }

    public com.baidu.swan.apps.media.a.b aBT() {
        return this.dnN;
    }

    public boolean pT(String str) {
        String str2 = null;
        if (TextUtils.equals(str, "/swanAPI/recorder/pause")) {
            if (this.dnI != 1) {
                str2 = "pause fail: recorder is not recording";
            }
        } else if (TextUtils.equals(str, "/swanAPI/recorder/resume")) {
            if (this.dnI != 2) {
                str2 = "resume fail: recorder is not paused";
            }
        } else if (TextUtils.equals(str, "/swanAPI/recorder/stop") && this.dnI != 2 && this.dnI != 1) {
            str2 = "stop fail: recorder is not started";
        }
        if (str2 != null) {
            ar(2003, str2);
            c.e("recorder", str2);
            return false;
        }
        return true;
    }

    public boolean pU(String str) {
        if (this.mIsBackground) {
            return TextUtils.equals(str, "/swanAPI/recorder/start") || TextUtils.equals(str, "/swanAPI/recorder/resume");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBU() {
        ar(2002, "error execute");
    }

    private void ar(int i, String str) {
        if (this.dnN == null || TextUtils.isEmpty(com.baidu.swan.apps.media.a.b.dnx)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errCode", i);
                jSONObject.put("errMsg", str);
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                com.baidu.swan.apps.v.f.aAo().b(new com.baidu.swan.apps.event.a.b("recorderError", hashMap));
                return;
            } catch (JSONException e) {
                c.e("recorder", "json error", e);
                aBR();
                return;
            }
        }
        this.dnN.ar(i, str);
    }

    private void bW(String str, String str2) {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "dispatchCallback: " + str + " " + str2);
        }
        if (this.dnN != null && !TextUtils.isEmpty(str)) {
            this.dnN.pE(str);
            return;
        }
        com.baidu.swan.apps.v.f.aAo().b(new com.baidu.swan.apps.event.a.b(str2));
    }

    private void aBV() {
        long j;
        long j2;
        String cA = com.baidu.swan.apps.storage.b.cA(this.dnG, this.mAppId);
        if (TextUtils.isEmpty(this.dnG)) {
            j = -1;
            j2 = -1;
        } else {
            long yY = com.baidu.swan.c.d.yY(this.dnG);
            j = new File(this.dnG).length();
            j2 = yY;
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
            if (this.dnN != null && !TextUtils.isEmpty(com.baidu.swan.apps.media.a.b.dnw)) {
                this.dnN.i(com.baidu.swan.apps.media.a.b.dnw, jSONObject);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            com.baidu.swan.apps.v.f.aAo().b(new com.baidu.swan.apps.event.a.b("recorderStop", hashMap));
        } catch (JSONException e) {
            aBU();
            c.e("recorder", "json error", e);
            aBR();
        }
    }

    private void aBW() {
        if (this.mContext != null) {
            this.mTelephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
            this.dnO = new com.baidu.swan.apps.media.a.b.a();
            this.mTelephonyManager.listen(this.dnO, 32);
        }
    }

    private void aBX() {
        if (this.mTelephonyManager != null && this.dnO != null) {
            this.mTelephonyManager.listen(this.dnO, 0);
            this.mTelephonyManager = null;
            this.dnO = null;
        }
    }
}
