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
    private static volatile a doH;
    private String doI;
    private int doJ;
    private com.baidu.swan.apps.media.a.b.b doL;
    private long doM;
    private long doN;
    private com.baidu.swan.apps.media.a.b doP;
    private com.baidu.swan.apps.media.a.b.a doQ;
    private String mAppId;
    private AudioRecord mAudioRecord;
    private Context mContext;
    private boolean mIsBackground;
    private TelephonyManager mTelephonyManager;
    private Timer mTimer;
    private int doK = -1;
    private com.baidu.swan.apps.media.a.a doO = new com.baidu.swan.apps.media.a.a();
    private boolean doR = false;

    private a() {
    }

    public static a aFh() {
        if (doH == null) {
            synchronized (a.class) {
                if (doH == null) {
                    doH = new a();
                }
            }
        }
        return doH;
    }

    public void a(String str, com.baidu.swan.apps.media.a.a aVar, Context context, com.baidu.swan.apps.media.a.b bVar, String str2) {
        int i;
        if (this.doK != -1 && this.doK != 3) {
            c.e("recorder", "wrong state, can't init");
            return;
        }
        this.doO = aVar;
        qE(str);
        this.doP = bVar;
        this.doJ = AudioRecord.getMinBufferSize(aVar.sampleRate, aVar.channel, 2);
        if (this.doJ <= 0) {
            aFo();
            c.e("recorder", "wrong buffer size");
            aFl();
            return;
        }
        if (aVar.channel == 1) {
            i = 16;
        } else {
            i = 12;
        }
        this.mAudioRecord = new AudioRecord(aVar.audioSource, aVar.sampleRate, i, 2, this.doJ);
        this.doK = 0;
        this.mContext = context;
        this.mAppId = str2;
        aFq();
    }

    private void qE(String str) {
        String str2;
        if (TextUtils.equals(this.doO.dos, "mp3")) {
            str2 = ".mp3";
        } else if (TextUtils.equals(this.doO.dos, "pcm")) {
            str2 = ".pcm";
        } else {
            str2 = ".aac";
        }
        this.doI = str + File.separator + "AUDIO_" + Calendar.getInstance().getTimeInMillis() + str2;
    }

    public void gg(boolean z) {
        if (this.mContext == null) {
            aFo();
            c.e("recorder", "start error, context is null");
            aFl();
        } else if (this.doK == -1 || TextUtils.isEmpty(this.doI)) {
            aFo();
            c.e("recorder", "start error, wrong state");
            aFl();
        } else {
            if (z) {
                String str = null;
                if (this.doK == 1) {
                    str = "start fail: recorder is recording";
                } else if (this.doK != 0 && this.doK != 3) {
                    str = "start fail: recorder is paused";
                }
                if (str != null) {
                    am(2003, str);
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
                    aFo();
                    c.e("recorder", "start error, no real permission");
                    aFl();
                    return;
                }
                if (z) {
                    a(new com.baidu.swan.apps.media.a.b.b() { // from class: com.baidu.swan.apps.media.a.c.a.1
                        @Override // com.baidu.swan.apps.media.a.b.b
                        public void aod() {
                            if (a.DEBUG) {
                                Log.d("AudioRecorderManager", "record --- timeOut");
                            }
                            c.i("recorder", "time out");
                            a.this.stopRecord();
                            a.this.aFl();
                        }
                    });
                    cd(com.baidu.swan.apps.media.a.b.dov, "recorderStart");
                } else {
                    cd(com.baidu.swan.apps.media.a.b.dox, "recorderResume");
                }
                d.bX("").d(Schedulers.io()).d(new f<String, Boolean>() { // from class: com.baidu.swan.apps.media.a.c.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.f
                    /* renamed from: qH */
                    public Boolean call(String str2) {
                        return Boolean.valueOf(a.this.aFk());
                    }
                }).c(rx.a.b.a.eOm()).c(new rx.functions.b<Boolean>() { // from class: com.baidu.swan.apps.media.a.c.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.b
                    /* renamed from: j */
                    public void call(Boolean bool) {
                        if (!bool.booleanValue()) {
                            a.this.aFo();
                            c.e("recorder", "record error");
                            a.this.aFl();
                        }
                    }
                });
            } catch (IllegalStateException e) {
                aFo();
                c.e("recorder", "can't start", e);
                aFl();
            }
        }
    }

    public void pauseRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "pause record");
        }
        if (this.mAudioRecord == null) {
            aFo();
            c.e("recorder", "none audio record");
            aFl();
            return;
        }
        try {
            this.mAudioRecord.stop();
            this.doK = 2;
            aDD();
            cd(com.baidu.swan.apps.media.a.b.dow, "recorderPause");
        } catch (IllegalStateException e) {
            aFo();
            c.e("recorder", "pause error", e);
            aFl();
        }
    }

    public void resumeRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "resume record");
        }
        gg(false);
        aDC();
    }

    public void stopRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "stop record");
        }
        if (this.mAudioRecord == null) {
            aFo();
            c.e("recorder", "none audioRecord");
            aFl();
            return;
        }
        try {
            this.mAudioRecord.stop();
            aob();
            this.doK = 3;
            aFp();
            aFr();
        } catch (IllegalStateException e) {
            aFo();
            c.e("recorder", "stop error", e);
            aFl();
        }
    }

    public void aFi() {
        if (this.doK == 0 || this.doK == 1) {
            if (!this.doR) {
                this.doR = true;
                cd(com.baidu.swan.apps.media.a.b.doA, "recorderInterruptionBegin");
            }
            pauseRecord();
        }
    }

    public void aFj() {
        if (this.doR) {
            this.doR = false;
            cd(com.baidu.swan.apps.media.a.b.doB, "recorderInterruptionEnd");
        }
    }

    public boolean aFk() {
        byte[] bArr = new byte[this.doJ];
        com.baidu.swan.apps.media.a.d.a aVar = new com.baidu.swan.apps.media.a.d.a(this.doO.dos, this.doO.channel, this.doO.sampleRate, this.doO.bitRate);
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
                File file = new File(this.doI);
                if (this.doK == 0) {
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
            this.doK = 1;
            while (this.doK == 1) {
                if (this.mAudioRecord.read(bArr, 0, this.doJ) >= 0) {
                    byte[] J = TextUtils.equals(this.doO.dos, "pcm") ? bArr : aVar.J(bArr);
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
            if (this.doK == 1) {
                this.doK = 3;
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
            Log.d("AudioRecorderManager", "start timer:" + this.doO.dor);
        }
        c.i("recorder", "start timer, totalTime:" + this.doO.dor);
        this.doL = bVar;
        this.mTimer = new Timer();
        this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.a.c.a.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (bVar != null) {
                    bVar.aod();
                }
                a.this.aob();
            }
        }, this.doO.dor);
        this.doM = System.currentTimeMillis();
    }

    public void aob() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "stop timer");
        }
        c.i("recorder", "stop timer");
        this.doL = null;
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
    }

    public void aDD() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "pause timer, lastTime:" + this.doN);
        }
        c.i("recorder", "pause timer, lastTime:" + this.doN);
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        this.doN = this.doO.dor - (System.currentTimeMillis() - this.doM);
    }

    public void aDC() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "resume timer");
        }
        c.i("recorder", "resume timer");
        if (this.doL != null) {
            if (this.doN <= 0) {
                this.doL.aod();
                return;
            }
            this.mTimer = new Timer();
            this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.a.c.a.5
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (a.this.doL != null) {
                        a.this.doL.aod();
                    }
                    a.this.aob();
                }
            }, this.doN);
            this.doM = System.currentTimeMillis();
        }
    }

    public void eU(boolean z) {
        if (z && this.doK == 1) {
            pauseRecord();
        }
        this.mIsBackground = z;
    }

    public static void gh(boolean z) {
        if (doH != null) {
            doH.eU(z);
        }
    }

    public static void release() {
        if (doH != null) {
            doH.aFl();
            doH.aFr();
            doH.aFj();
        }
    }

    public static void releaseAll() {
        release();
        doH = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFl() {
        aob();
        this.mContext = null;
        this.doK = -1;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
            this.mAudioRecord = null;
        }
    }

    public com.baidu.swan.apps.media.a.a aFm() {
        return this.doO;
    }

    public com.baidu.swan.apps.media.a.b aFn() {
        return this.doP;
    }

    public boolean qF(String str) {
        String str2 = null;
        if (TextUtils.equals(str, "/swanAPI/recorder/pause")) {
            if (this.doK != 1) {
                str2 = "pause fail: recorder is not recording";
            }
        } else if (TextUtils.equals(str, "/swanAPI/recorder/resume")) {
            if (this.doK != 2) {
                str2 = "resume fail: recorder is not paused";
            }
        } else if (TextUtils.equals(str, "/swanAPI/recorder/stop") && this.doK != 2 && this.doK != 1) {
            str2 = "stop fail: recorder is not started";
        }
        if (str2 != null) {
            am(2003, str2);
            c.e("recorder", str2);
            return false;
        }
        return true;
    }

    public boolean qG(String str) {
        if (this.mIsBackground) {
            return TextUtils.equals(str, "/swanAPI/recorder/start") || TextUtils.equals(str, "/swanAPI/recorder/resume");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFo() {
        am(2002, "error execute");
    }

    private void am(int i, String str) {
        if (this.doP == null || TextUtils.isEmpty(com.baidu.swan.apps.media.a.b.doz)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errCode", i);
                jSONObject.put("errMsg", str);
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                com.baidu.swan.apps.v.f.aDH().b(new com.baidu.swan.apps.event.a.b("recorderError", hashMap));
                return;
            } catch (JSONException e) {
                c.e("recorder", "json error", e);
                aFl();
                return;
            }
        }
        this.doP.am(i, str);
    }

    private void cd(String str, String str2) {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "dispatchCallback: " + str + " " + str2);
        }
        if (this.doP != null && !TextUtils.isEmpty(str)) {
            this.doP.qq(str);
            return;
        }
        com.baidu.swan.apps.v.f.aDH().b(new com.baidu.swan.apps.event.a.b(str2));
    }

    private void aFp() {
        long j;
        long j2;
        String cH = com.baidu.swan.apps.storage.b.cH(this.doI, this.mAppId);
        if (TextUtils.isEmpty(this.doI)) {
            j = -1;
            j2 = -1;
        } else {
            long zK = com.baidu.swan.c.d.zK(this.doI);
            j = new File(this.doI).length();
            j2 = zK;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(cH)) {
                jSONObject.put("tempFilePath", cH);
            }
            if (j2 >= 0) {
                jSONObject.put("duration", j2);
            }
            if (j >= 0) {
                jSONObject.put("fileSize", j);
            }
            if (this.doP != null && !TextUtils.isEmpty(com.baidu.swan.apps.media.a.b.doy)) {
                this.doP.h(com.baidu.swan.apps.media.a.b.doy, jSONObject);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            com.baidu.swan.apps.v.f.aDH().b(new com.baidu.swan.apps.event.a.b("recorderStop", hashMap));
        } catch (JSONException e) {
            aFo();
            c.e("recorder", "json error", e);
            aFl();
        }
    }

    private void aFq() {
        if (this.mContext != null) {
            this.mTelephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
            this.doQ = new com.baidu.swan.apps.media.a.b.a();
            this.mTelephonyManager.listen(this.doQ, 32);
        }
    }

    private void aFr() {
        if (this.mTelephonyManager != null && this.doQ != null) {
            this.mTelephonyManager.listen(this.doQ, 0);
            this.mTelephonyManager = null;
            this.doQ = null;
        }
    }
}
