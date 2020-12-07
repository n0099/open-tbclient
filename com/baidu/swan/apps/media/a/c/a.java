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
/* loaded from: classes25.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a djH;
    private String djI;
    private int djJ;
    private com.baidu.swan.apps.media.a.b.b djL;
    private long djM;
    private long djN;
    private com.baidu.swan.apps.media.a.b djP;
    private com.baidu.swan.apps.media.a.b.a djQ;
    private String mAppId;
    private AudioRecord mAudioRecord;
    private Context mContext;
    private boolean mIsBackground;
    private TelephonyManager mTelephonyManager;
    private Timer mTimer;
    private int djK = -1;
    private com.baidu.swan.apps.media.a.a djO = new com.baidu.swan.apps.media.a.a();
    private boolean djR = false;

    private a() {
    }

    public static a aDN() {
        if (djH == null) {
            synchronized (a.class) {
                if (djH == null) {
                    djH = new a();
                }
            }
        }
        return djH;
    }

    public void a(String str, com.baidu.swan.apps.media.a.a aVar, Context context, com.baidu.swan.apps.media.a.b bVar, String str2) {
        int i;
        if (this.djK != -1 && this.djK != 3) {
            c.e("recorder", "wrong state, can't init");
            return;
        }
        this.djO = aVar;
        qK(str);
        this.djP = bVar;
        this.djJ = AudioRecord.getMinBufferSize(aVar.sampleRate, aVar.channel, 2);
        if (this.djJ <= 0) {
            aDU();
            c.e("recorder", "wrong buffer size");
            aDR();
            return;
        }
        if (aVar.channel == 1) {
            i = 16;
        } else {
            i = 12;
        }
        this.mAudioRecord = new AudioRecord(aVar.audioSource, aVar.sampleRate, i, 2, this.djJ);
        this.djK = 0;
        this.mContext = context;
        this.mAppId = str2;
        aDW();
    }

    private void qK(String str) {
        String str2;
        if (TextUtils.equals(this.djO.djt, "mp3")) {
            str2 = ".mp3";
        } else if (TextUtils.equals(this.djO.djt, "pcm")) {
            str2 = ".pcm";
        } else {
            str2 = ".aac";
        }
        this.djI = str + File.separator + "AUDIO_" + Calendar.getInstance().getTimeInMillis() + str2;
    }

    public void fX(boolean z) {
        if (this.mContext == null) {
            aDU();
            c.e("recorder", "start error, context is null");
            aDR();
        } else if (this.djK == -1 || TextUtils.isEmpty(this.djI)) {
            aDU();
            c.e("recorder", "start error, wrong state");
            aDR();
        } else {
            if (z) {
                String str = null;
                if (this.djK == 1) {
                    str = "start fail: recorder is recording";
                } else if (this.djK != 0 && this.djK != 3) {
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
                    aDU();
                    c.e("recorder", "start error, no real permission");
                    aDR();
                    return;
                }
                if (z) {
                    a(new com.baidu.swan.apps.media.a.b.b() { // from class: com.baidu.swan.apps.media.a.c.a.1
                        @Override // com.baidu.swan.apps.media.a.b.b
                        public void amS() {
                            if (a.DEBUG) {
                                Log.d("AudioRecorderManager", "record --- timeOut");
                            }
                            c.i("recorder", "time out");
                            a.this.stopRecord();
                            a.this.aDR();
                        }
                    });
                    ce(com.baidu.swan.apps.media.a.b.djv, "recorderStart");
                } else {
                    ce(com.baidu.swan.apps.media.a.b.djx, "recorderResume");
                }
                d.bU("").d(Schedulers.io()).d(new f<String, Boolean>() { // from class: com.baidu.swan.apps.media.a.c.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.f
                    /* renamed from: qN */
                    public Boolean call(String str2) {
                        return Boolean.valueOf(a.this.aDQ());
                    }
                }).c(rx.a.b.a.eFz()).c(new rx.functions.b<Boolean>() { // from class: com.baidu.swan.apps.media.a.c.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.b
                    /* renamed from: i */
                    public void call(Boolean bool) {
                        if (!bool.booleanValue()) {
                            a.this.aDU();
                            c.e("recorder", "record error");
                            a.this.aDR();
                        }
                    }
                });
            } catch (IllegalStateException e) {
                aDU();
                c.e("recorder", "can't start", e);
                aDR();
            }
        }
    }

    public void pauseRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "pause record");
        }
        if (this.mAudioRecord == null) {
            aDU();
            c.e("recorder", "none audio record");
            aDR();
            return;
        }
        try {
            this.mAudioRecord.stop();
            this.djK = 2;
            aCl();
            ce(com.baidu.swan.apps.media.a.b.djw, "recorderPause");
        } catch (IllegalStateException e) {
            aDU();
            c.e("recorder", "pause error", e);
            aDR();
        }
    }

    public void resumeRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "resume record");
        }
        fX(false);
        aCk();
    }

    public void stopRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "stop record");
        }
        if (this.mAudioRecord == null) {
            aDU();
            c.e("recorder", "none audioRecord");
            aDR();
            return;
        }
        try {
            this.mAudioRecord.stop();
            amQ();
            this.djK = 3;
            aDV();
            aDX();
        } catch (IllegalStateException e) {
            aDU();
            c.e("recorder", "stop error", e);
            aDR();
        }
    }

    public void aDO() {
        if (this.djK == 0 || this.djK == 1) {
            if (!this.djR) {
                this.djR = true;
                ce(com.baidu.swan.apps.media.a.b.djA, "recorderInterruptionBegin");
            }
            pauseRecord();
        }
    }

    public void aDP() {
        if (this.djR) {
            this.djR = false;
            ce(com.baidu.swan.apps.media.a.b.djB, "recorderInterruptionEnd");
        }
    }

    public boolean aDQ() {
        byte[] bArr = new byte[this.djJ];
        com.baidu.swan.apps.media.a.d.a aVar = new com.baidu.swan.apps.media.a.d.a(this.djO.djt, this.djO.channel, this.djO.sampleRate, this.djO.bitRate);
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
                File file = new File(this.djI);
                if (this.djK == 0) {
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
            this.djK = 1;
            while (this.djK == 1) {
                if (this.mAudioRecord.read(bArr, 0, this.djJ) >= 0) {
                    byte[] M = TextUtils.equals(this.djO.djt, "pcm") ? bArr : aVar.M(bArr);
                    if (M != null && M.length > 0) {
                        fileOutputStream.write(M);
                    }
                }
            }
            com.baidu.swan.c.d.closeSafely(fileOutputStream);
            return true;
        } catch (Exception e2) {
            e = e2;
            fileOutputStream2 = fileOutputStream;
            c.e("recorder", "save record error", e);
            if (this.djK == 1) {
                this.djK = 3;
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
            Log.d("AudioRecorderManager", "start timer:" + this.djO.djs);
        }
        c.i("recorder", "start timer, totalTime:" + this.djO.djs);
        this.djL = bVar;
        this.mTimer = new Timer();
        this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.a.c.a.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (bVar != null) {
                    bVar.amS();
                }
                a.this.amQ();
            }
        }, this.djO.djs);
        this.djM = System.currentTimeMillis();
    }

    public void amQ() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "stop timer");
        }
        c.i("recorder", "stop timer");
        this.djL = null;
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
    }

    public void aCl() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "pause timer, lastTime:" + this.djN);
        }
        c.i("recorder", "pause timer, lastTime:" + this.djN);
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        this.djN = this.djO.djs - (System.currentTimeMillis() - this.djM);
    }

    public void aCk() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "resume timer");
        }
        c.i("recorder", "resume timer");
        if (this.djL != null) {
            if (this.djN <= 0) {
                this.djL.amS();
                return;
            }
            this.mTimer = new Timer();
            this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.a.c.a.5
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (a.this.djL != null) {
                        a.this.djL.amS();
                    }
                    a.this.amQ();
                }
            }, this.djN);
            this.djM = System.currentTimeMillis();
        }
    }

    public void eL(boolean z) {
        if (z && this.djK == 1) {
            pauseRecord();
        }
        this.mIsBackground = z;
    }

    public static void fY(boolean z) {
        if (djH != null) {
            djH.eL(z);
        }
    }

    public static void release() {
        if (djH != null) {
            djH.aDR();
            djH.aDX();
            djH.aDP();
        }
    }

    public static void releaseAll() {
        release();
        djH = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDR() {
        amQ();
        this.mContext = null;
        this.djK = -1;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
            this.mAudioRecord = null;
        }
    }

    public com.baidu.swan.apps.media.a.a aDS() {
        return this.djO;
    }

    public com.baidu.swan.apps.media.a.b aDT() {
        return this.djP;
    }

    public boolean qL(String str) {
        String str2 = null;
        if (TextUtils.equals(str, "/swanAPI/recorder/pause")) {
            if (this.djK != 1) {
                str2 = "pause fail: recorder is not recording";
            }
        } else if (TextUtils.equals(str, "/swanAPI/recorder/resume")) {
            if (this.djK != 2) {
                str2 = "resume fail: recorder is not paused";
            }
        } else if (TextUtils.equals(str, "/swanAPI/recorder/stop") && this.djK != 2 && this.djK != 1) {
            str2 = "stop fail: recorder is not started";
        }
        if (str2 != null) {
            ak(2003, str2);
            c.e("recorder", str2);
            return false;
        }
        return true;
    }

    public boolean qM(String str) {
        if (this.mIsBackground) {
            return TextUtils.equals(str, "/swanAPI/recorder/start") || TextUtils.equals(str, "/swanAPI/recorder/resume");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDU() {
        ak(2002, "error execute");
    }

    private void ak(int i, String str) {
        if (this.djP == null || TextUtils.isEmpty(com.baidu.swan.apps.media.a.b.djz)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errCode", i);
                jSONObject.put("errMsg", str);
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                com.baidu.swan.apps.v.f.aCp().b(new com.baidu.swan.apps.event.a.b("recorderError", hashMap));
                return;
            } catch (JSONException e) {
                c.e("recorder", "json error", e);
                aDR();
                return;
            }
        }
        this.djP.ak(i, str);
    }

    private void ce(String str, String str2) {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "dispatchCallback: " + str + " " + str2);
        }
        if (this.djP != null && !TextUtils.isEmpty(str)) {
            this.djP.qx(str);
            return;
        }
        com.baidu.swan.apps.v.f.aCp().b(new com.baidu.swan.apps.event.a.b(str2));
    }

    private void aDV() {
        long j;
        long j2 = -1;
        String cI = com.baidu.swan.apps.storage.b.cI(this.djI, this.mAppId);
        if (TextUtils.isEmpty(this.djI)) {
            j = -1;
        } else {
            j = com.baidu.swan.c.d.zL(this.djI);
            j2 = new File(this.djI).length();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(cI)) {
                jSONObject.put("tempFilePath", cI);
            }
            if (j >= 0) {
                jSONObject.put("duration", j);
            }
            if (j2 >= 0) {
                jSONObject.put("fileSize", j2);
            }
            if (this.djP != null && !TextUtils.isEmpty(com.baidu.swan.apps.media.a.b.djy)) {
                this.djP.g(com.baidu.swan.apps.media.a.b.djy, jSONObject);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            com.baidu.swan.apps.v.f.aCp().b(new com.baidu.swan.apps.event.a.b("recorderStop", hashMap));
        } catch (JSONException e) {
            aDU();
            c.e("recorder", "json error", e);
            aDR();
        }
    }

    private void aDW() {
        if (this.mContext != null) {
            this.mTelephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
            this.djQ = new com.baidu.swan.apps.media.a.b.a();
            this.mTelephonyManager.listen(this.djQ, 32);
        }
    }

    private void aDX() {
        if (this.mTelephonyManager != null && this.djQ != null) {
            this.mTelephonyManager.listen(this.djQ, 0);
            this.mTelephonyManager = null;
            this.djQ = null;
        }
    }
}
