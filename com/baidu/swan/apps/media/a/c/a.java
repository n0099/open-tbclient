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
    private static volatile a dcH;
    private String dcI;
    private int dcJ;
    private com.baidu.swan.apps.media.a.b.b dcL;
    private long dcM;
    private long dcN;
    private com.baidu.swan.apps.media.a.b dcP;
    private com.baidu.swan.apps.media.a.b.a dcQ;
    private String mAppId;
    private AudioRecord mAudioRecord;
    private Context mContext;
    private boolean mIsBackground;
    private TelephonyManager mTelephonyManager;
    private Timer mTimer;
    private int dcK = -1;
    private com.baidu.swan.apps.media.a.a dcO = new com.baidu.swan.apps.media.a.a();
    private boolean dcR = false;

    private a() {
    }

    public static a aAE() {
        if (dcH == null) {
            synchronized (a.class) {
                if (dcH == null) {
                    dcH = new a();
                }
            }
        }
        return dcH;
    }

    public void a(String str, com.baidu.swan.apps.media.a.a aVar, Context context, com.baidu.swan.apps.media.a.b bVar, String str2) {
        int i;
        if (this.dcK != -1 && this.dcK != 3) {
            c.e("recorder", "wrong state, can't init");
            return;
        }
        this.dcO = aVar;
        qd(str);
        this.dcP = bVar;
        this.dcJ = AudioRecord.getMinBufferSize(aVar.sampleRate, aVar.channel, 2);
        if (this.dcJ <= 0) {
            aAL();
            c.e("recorder", "wrong buffer size");
            aAI();
            return;
        }
        if (aVar.channel == 1) {
            i = 16;
        } else {
            i = 12;
        }
        this.mAudioRecord = new AudioRecord(aVar.audioSource, aVar.sampleRate, i, 2, this.dcJ);
        this.dcK = 0;
        this.mContext = context;
        this.mAppId = str2;
        aAN();
    }

    private void qd(String str) {
        String str2;
        if (TextUtils.equals(this.dcO.dcs, "mp3")) {
            str2 = ".mp3";
        } else if (TextUtils.equals(this.dcO.dcs, "pcm")) {
            str2 = ".pcm";
        } else {
            str2 = ".aac";
        }
        this.dcI = str + File.separator + "AUDIO_" + Calendar.getInstance().getTimeInMillis() + str2;
    }

    public void fI(boolean z) {
        if (this.mContext == null) {
            aAL();
            c.e("recorder", "start error, context is null");
            aAI();
        } else if (this.dcK == -1 || TextUtils.isEmpty(this.dcI)) {
            aAL();
            c.e("recorder", "start error, wrong state");
            aAI();
        } else {
            if (z) {
                String str = null;
                if (this.dcK == 1) {
                    str = "start fail: recorder is recording";
                } else if (this.dcK != 0 && this.dcK != 3) {
                    str = "start fail: recorder is paused";
                }
                if (str != null) {
                    ak(2003, str);
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
                    aAL();
                    c.e("recorder", "start error, no real permission");
                    aAI();
                    return;
                }
                if (z) {
                    a(new com.baidu.swan.apps.media.a.b.b() { // from class: com.baidu.swan.apps.media.a.c.a.1
                        @Override // com.baidu.swan.apps.media.a.b.b
                        public void ajK() {
                            if (a.DEBUG) {
                                Log.d("AudioRecorderManager", "record --- timeOut");
                            }
                            c.i("recorder", "time out");
                            a.this.stopRecord();
                            a.this.aAI();
                        }
                    });
                    bX(com.baidu.swan.apps.media.a.b.dcv, "recorderStart");
                } else {
                    bX(com.baidu.swan.apps.media.a.b.dcx, "recorderResume");
                }
                d.ce("").d(Schedulers.io()).d(new f<String, Boolean>() { // from class: com.baidu.swan.apps.media.a.c.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.f
                    /* renamed from: qg */
                    public Boolean call(String str2) {
                        return Boolean.valueOf(a.this.aAH());
                    }
                }).c(rx.a.b.a.eFA()).c(new rx.functions.b<Boolean>() { // from class: com.baidu.swan.apps.media.a.c.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.b
                    /* renamed from: i */
                    public void call(Boolean bool) {
                        if (!bool.booleanValue()) {
                            a.this.aAL();
                            c.e("recorder", "record error");
                            a.this.aAI();
                        }
                    }
                });
            } catch (IllegalStateException e) {
                aAL();
                c.e("recorder", "can't start", e);
                aAI();
            }
        }
    }

    public void pauseRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "pause record");
        }
        if (this.mAudioRecord == null) {
            aAL();
            c.e("recorder", "none audio record");
            aAI();
            return;
        }
        try {
            this.mAudioRecord.stop();
            this.dcK = 2;
            azc();
            bX(com.baidu.swan.apps.media.a.b.dcw, "recorderPause");
        } catch (IllegalStateException e) {
            aAL();
            c.e("recorder", "pause error", e);
            aAI();
        }
    }

    public void resumeRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "resume record");
        }
        fI(false);
        azb();
    }

    public void stopRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "stop record");
        }
        if (this.mAudioRecord == null) {
            aAL();
            c.e("recorder", "none audioRecord");
            aAI();
            return;
        }
        try {
            this.mAudioRecord.stop();
            ajI();
            this.dcK = 3;
            aAM();
            aAO();
        } catch (IllegalStateException e) {
            aAL();
            c.e("recorder", "stop error", e);
            aAI();
        }
    }

    public void aAF() {
        if (this.dcK == 0 || this.dcK == 1) {
            if (!this.dcR) {
                this.dcR = true;
                bX(com.baidu.swan.apps.media.a.b.dcA, "recorderInterruptionBegin");
            }
            pauseRecord();
        }
    }

    public void aAG() {
        if (this.dcR) {
            this.dcR = false;
            bX(com.baidu.swan.apps.media.a.b.dcB, "recorderInterruptionEnd");
        }
    }

    public boolean aAH() {
        byte[] bArr = new byte[this.dcJ];
        com.baidu.swan.apps.media.a.d.a aVar = new com.baidu.swan.apps.media.a.d.a(this.dcO.dcs, this.dcO.channel, this.dcO.sampleRate, this.dcO.bitRate);
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
                File file = new File(this.dcI);
                if (this.dcK == 0) {
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
            this.dcK = 1;
            while (this.dcK == 1) {
                if (this.mAudioRecord.read(bArr, 0, this.dcJ) >= 0) {
                    byte[] K = TextUtils.equals(this.dcO.dcs, "pcm") ? bArr : aVar.K(bArr);
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
            if (this.dcK == 1) {
                this.dcK = 3;
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
            Log.d("AudioRecorderManager", "start timer:" + this.dcO.dcr);
        }
        c.i("recorder", "start timer, totalTime:" + this.dcO.dcr);
        this.dcL = bVar;
        this.mTimer = new Timer();
        this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.a.c.a.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (bVar != null) {
                    bVar.ajK();
                }
                a.this.ajI();
            }
        }, this.dcO.dcr);
        this.dcM = System.currentTimeMillis();
    }

    public void ajI() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "stop timer");
        }
        c.i("recorder", "stop timer");
        this.dcL = null;
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
    }

    public void azc() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "pause timer, lastTime:" + this.dcN);
        }
        c.i("recorder", "pause timer, lastTime:" + this.dcN);
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        this.dcN = this.dcO.dcr - (System.currentTimeMillis() - this.dcM);
    }

    public void azb() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "resume timer");
        }
        c.i("recorder", "resume timer");
        if (this.dcL != null) {
            if (this.dcN <= 0) {
                this.dcL.ajK();
                return;
            }
            this.mTimer = new Timer();
            this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.a.c.a.5
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (a.this.dcL != null) {
                        a.this.dcL.ajK();
                    }
                    a.this.ajI();
                }
            }, this.dcN);
            this.dcM = System.currentTimeMillis();
        }
    }

    public void ew(boolean z) {
        if (z && this.dcK == 1) {
            pauseRecord();
        }
        this.mIsBackground = z;
    }

    public static void fJ(boolean z) {
        if (dcH != null) {
            dcH.ew(z);
        }
    }

    public static void release() {
        if (dcH != null) {
            dcH.aAI();
            dcH.aAO();
            dcH.aAG();
        }
    }

    public static void releaseAll() {
        release();
        dcH = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAI() {
        ajI();
        this.mContext = null;
        this.dcK = -1;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
            this.mAudioRecord = null;
        }
    }

    public com.baidu.swan.apps.media.a.a aAJ() {
        return this.dcO;
    }

    public com.baidu.swan.apps.media.a.b aAK() {
        return this.dcP;
    }

    public boolean qe(String str) {
        String str2 = null;
        if (TextUtils.equals(str, "/swanAPI/recorder/pause")) {
            if (this.dcK != 1) {
                str2 = "pause fail: recorder is not recording";
            }
        } else if (TextUtils.equals(str, "/swanAPI/recorder/resume")) {
            if (this.dcK != 2) {
                str2 = "resume fail: recorder is not paused";
            }
        } else if (TextUtils.equals(str, "/swanAPI/recorder/stop") && this.dcK != 2 && this.dcK != 1) {
            str2 = "stop fail: recorder is not started";
        }
        if (str2 != null) {
            ak(2003, str2);
            c.e("recorder", str2);
            return false;
        }
        return true;
    }

    public boolean qf(String str) {
        if (this.mIsBackground) {
            return TextUtils.equals(str, "/swanAPI/recorder/start") || TextUtils.equals(str, "/swanAPI/recorder/resume");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAL() {
        ak(2002, "error execute");
    }

    private void ak(int i, String str) {
        if (this.dcP == null || TextUtils.isEmpty(com.baidu.swan.apps.media.a.b.dcz)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errCode", i);
                jSONObject.put("errMsg", str);
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                com.baidu.swan.apps.v.f.azg().b(new com.baidu.swan.apps.event.a.b("recorderError", hashMap));
                return;
            } catch (JSONException e) {
                c.e("recorder", "json error", e);
                aAI();
                return;
            }
        }
        this.dcP.ak(i, str);
    }

    private void bX(String str, String str2) {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "dispatchCallback: " + str + " " + str2);
        }
        if (this.dcP != null && !TextUtils.isEmpty(str)) {
            this.dcP.pQ(str);
            return;
        }
        com.baidu.swan.apps.v.f.azg().b(new com.baidu.swan.apps.event.a.b(str2));
    }

    private void aAM() {
        long j;
        long j2 = -1;
        String cB = com.baidu.swan.apps.storage.b.cB(this.dcI, this.mAppId);
        if (TextUtils.isEmpty(this.dcI)) {
            j = -1;
        } else {
            j = com.baidu.swan.c.d.ze(this.dcI);
            j2 = new File(this.dcI).length();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(cB)) {
                jSONObject.put("tempFilePath", cB);
            }
            if (j >= 0) {
                jSONObject.put("duration", j);
            }
            if (j2 >= 0) {
                jSONObject.put("fileSize", j2);
            }
            if (this.dcP != null && !TextUtils.isEmpty(com.baidu.swan.apps.media.a.b.dcy)) {
                this.dcP.g(com.baidu.swan.apps.media.a.b.dcy, jSONObject);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            com.baidu.swan.apps.v.f.azg().b(new com.baidu.swan.apps.event.a.b("recorderStop", hashMap));
        } catch (JSONException e) {
            aAL();
            c.e("recorder", "json error", e);
            aAI();
        }
    }

    private void aAN() {
        if (this.mContext != null) {
            this.mTelephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
            this.dcQ = new com.baidu.swan.apps.media.a.b.a();
            this.mTelephonyManager.listen(this.dcQ, 32);
        }
    }

    private void aAO() {
        if (this.mTelephonyManager != null && this.dcQ != null) {
            this.mTelephonyManager.listen(this.dcQ, 0);
            this.mTelephonyManager = null;
            this.dcQ = null;
        }
    }
}
