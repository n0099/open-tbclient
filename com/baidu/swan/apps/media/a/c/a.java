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
    private static volatile a djS;
    private String djT;
    private int djU;
    private com.baidu.swan.apps.media.a.b.b djW;
    private long djX;
    private long djY;
    private com.baidu.swan.apps.media.a.b dka;
    private com.baidu.swan.apps.media.a.b.a dkb;
    private String mAppId;
    private AudioRecord mAudioRecord;
    private Context mContext;
    private boolean mIsBackground;
    private TelephonyManager mTelephonyManager;
    private Timer mTimer;
    private int djV = -1;
    private com.baidu.swan.apps.media.a.a djZ = new com.baidu.swan.apps.media.a.a();
    private boolean dkc = false;

    private a() {
    }

    public static a aBn() {
        if (djS == null) {
            synchronized (a.class) {
                if (djS == null) {
                    djS = new a();
                }
            }
        }
        return djS;
    }

    public void a(String str, com.baidu.swan.apps.media.a.a aVar, Context context, com.baidu.swan.apps.media.a.b bVar, String str2) {
        int i;
        if (this.djV != -1 && this.djV != 3) {
            c.e("recorder", "wrong state, can't init");
            return;
        }
        this.djZ = aVar;
        pt(str);
        this.dka = bVar;
        this.djU = AudioRecord.getMinBufferSize(aVar.sampleRate, aVar.channel, 2);
        if (this.djU <= 0) {
            aBu();
            c.e("recorder", "wrong buffer size");
            aBr();
            return;
        }
        if (aVar.channel == 1) {
            i = 16;
        } else {
            i = 12;
        }
        this.mAudioRecord = new AudioRecord(aVar.audioSource, aVar.sampleRate, i, 2, this.djU);
        this.djV = 0;
        this.mContext = context;
        this.mAppId = str2;
        aBw();
    }

    private void pt(String str) {
        String str2;
        if (TextUtils.equals(this.djZ.djE, "mp3")) {
            str2 = ".mp3";
        } else if (TextUtils.equals(this.djZ.djE, "pcm")) {
            str2 = ".pcm";
        } else {
            str2 = ".aac";
        }
        this.djT = str + File.separator + "AUDIO_" + Calendar.getInstance().getTimeInMillis() + str2;
    }

    public void gc(boolean z) {
        if (this.mContext == null) {
            aBu();
            c.e("recorder", "start error, context is null");
            aBr();
        } else if (this.djV == -1 || TextUtils.isEmpty(this.djT)) {
            aBu();
            c.e("recorder", "start error, wrong state");
            aBr();
        } else {
            if (z) {
                String str = null;
                if (this.djV == 1) {
                    str = "start fail: recorder is recording";
                } else if (this.djV != 0 && this.djV != 3) {
                    str = "start fail: recorder is paused";
                }
                if (str != null) {
                    an(2003, str);
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
                    aBu();
                    c.e("recorder", "start error, no real permission");
                    aBr();
                    return;
                }
                if (z) {
                    a(new com.baidu.swan.apps.media.a.b.b() { // from class: com.baidu.swan.apps.media.a.c.a.1
                        @Override // com.baidu.swan.apps.media.a.b.b
                        public void akj() {
                            if (a.DEBUG) {
                                Log.d("AudioRecorderManager", "record --- timeOut");
                            }
                            c.i("recorder", "time out");
                            a.this.stopRecord();
                            a.this.aBr();
                        }
                    });
                    cc(com.baidu.swan.apps.media.a.b.djG, "recorderStart");
                } else {
                    cc(com.baidu.swan.apps.media.a.b.djI, "recorderResume");
                }
                d.bX("").d(Schedulers.io()).d(new f<String, Boolean>() { // from class: com.baidu.swan.apps.media.a.c.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.f
                    /* renamed from: pw */
                    public Boolean call(String str2) {
                        return Boolean.valueOf(a.this.aBq());
                    }
                }).c(rx.a.b.a.eKw()).c(new rx.functions.b<Boolean>() { // from class: com.baidu.swan.apps.media.a.c.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.b
                    /* renamed from: j */
                    public void call(Boolean bool) {
                        if (!bool.booleanValue()) {
                            a.this.aBu();
                            c.e("recorder", "record error");
                            a.this.aBr();
                        }
                    }
                });
            } catch (IllegalStateException e) {
                aBu();
                c.e("recorder", "can't start", e);
                aBr();
            }
        }
    }

    public void pauseRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "pause record");
        }
        if (this.mAudioRecord == null) {
            aBu();
            c.e("recorder", "none audio record");
            aBr();
            return;
        }
        try {
            this.mAudioRecord.stop();
            this.djV = 2;
            azJ();
            cc(com.baidu.swan.apps.media.a.b.djH, "recorderPause");
        } catch (IllegalStateException e) {
            aBu();
            c.e("recorder", "pause error", e);
            aBr();
        }
    }

    public void resumeRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "resume record");
        }
        gc(false);
        azI();
    }

    public void stopRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "stop record");
        }
        if (this.mAudioRecord == null) {
            aBu();
            c.e("recorder", "none audioRecord");
            aBr();
            return;
        }
        try {
            this.mAudioRecord.stop();
            akh();
            this.djV = 3;
            aBv();
            aBx();
        } catch (IllegalStateException e) {
            aBu();
            c.e("recorder", "stop error", e);
            aBr();
        }
    }

    public void aBo() {
        if (this.djV == 0 || this.djV == 1) {
            if (!this.dkc) {
                this.dkc = true;
                cc(com.baidu.swan.apps.media.a.b.djL, "recorderInterruptionBegin");
            }
            pauseRecord();
        }
    }

    public void aBp() {
        if (this.dkc) {
            this.dkc = false;
            cc(com.baidu.swan.apps.media.a.b.djM, "recorderInterruptionEnd");
        }
    }

    public boolean aBq() {
        byte[] bArr = new byte[this.djU];
        com.baidu.swan.apps.media.a.d.a aVar = new com.baidu.swan.apps.media.a.d.a(this.djZ.djE, this.djZ.channel, this.djZ.sampleRate, this.djZ.bitRate);
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
                File file = new File(this.djT);
                if (this.djV == 0) {
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
            this.djV = 1;
            while (this.djV == 1) {
                if (this.mAudioRecord.read(bArr, 0, this.djU) >= 0) {
                    byte[] I = TextUtils.equals(this.djZ.djE, "pcm") ? bArr : aVar.I(bArr);
                    if (I != null && I.length > 0) {
                        fileOutputStream.write(I);
                    }
                }
            }
            com.baidu.swan.c.d.closeSafely(fileOutputStream);
            return true;
        } catch (Exception e2) {
            e = e2;
            fileOutputStream2 = fileOutputStream;
            c.e("recorder", "save record error", e);
            if (this.djV == 1) {
                this.djV = 3;
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
            Log.d("AudioRecorderManager", "start timer:" + this.djZ.djD);
        }
        c.i("recorder", "start timer, totalTime:" + this.djZ.djD);
        this.djW = bVar;
        this.mTimer = new Timer();
        this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.a.c.a.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (bVar != null) {
                    bVar.akj();
                }
                a.this.akh();
            }
        }, this.djZ.djD);
        this.djX = System.currentTimeMillis();
    }

    public void akh() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "stop timer");
        }
        c.i("recorder", "stop timer");
        this.djW = null;
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
    }

    public void azJ() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "pause timer, lastTime:" + this.djY);
        }
        c.i("recorder", "pause timer, lastTime:" + this.djY);
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        this.djY = this.djZ.djD - (System.currentTimeMillis() - this.djX);
    }

    public void azI() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "resume timer");
        }
        c.i("recorder", "resume timer");
        if (this.djW != null) {
            if (this.djY <= 0) {
                this.djW.akj();
                return;
            }
            this.mTimer = new Timer();
            this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.a.c.a.5
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (a.this.djW != null) {
                        a.this.djW.akj();
                    }
                    a.this.akh();
                }
            }, this.djY);
            this.djX = System.currentTimeMillis();
        }
    }

    public void eQ(boolean z) {
        if (z && this.djV == 1) {
            pauseRecord();
        }
        this.mIsBackground = z;
    }

    public static void gd(boolean z) {
        if (djS != null) {
            djS.eQ(z);
        }
    }

    public static void release() {
        if (djS != null) {
            djS.aBr();
            djS.aBx();
            djS.aBp();
        }
    }

    public static void releaseAll() {
        release();
        djS = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBr() {
        akh();
        this.mContext = null;
        this.djV = -1;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
            this.mAudioRecord = null;
        }
    }

    public com.baidu.swan.apps.media.a.a aBs() {
        return this.djZ;
    }

    public com.baidu.swan.apps.media.a.b aBt() {
        return this.dka;
    }

    public boolean pu(String str) {
        String str2 = null;
        if (TextUtils.equals(str, "/swanAPI/recorder/pause")) {
            if (this.djV != 1) {
                str2 = "pause fail: recorder is not recording";
            }
        } else if (TextUtils.equals(str, "/swanAPI/recorder/resume")) {
            if (this.djV != 2) {
                str2 = "resume fail: recorder is not paused";
            }
        } else if (TextUtils.equals(str, "/swanAPI/recorder/stop") && this.djV != 2 && this.djV != 1) {
            str2 = "stop fail: recorder is not started";
        }
        if (str2 != null) {
            an(2003, str2);
            c.e("recorder", str2);
            return false;
        }
        return true;
    }

    public boolean pv(String str) {
        if (this.mIsBackground) {
            return TextUtils.equals(str, "/swanAPI/recorder/start") || TextUtils.equals(str, "/swanAPI/recorder/resume");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBu() {
        an(2002, "error execute");
    }

    private void an(int i, String str) {
        if (this.dka == null || TextUtils.isEmpty(com.baidu.swan.apps.media.a.b.djK)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errCode", i);
                jSONObject.put("errMsg", str);
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                com.baidu.swan.apps.v.f.azN().b(new com.baidu.swan.apps.event.a.b("recorderError", hashMap));
                return;
            } catch (JSONException e) {
                c.e("recorder", "json error", e);
                aBr();
                return;
            }
        }
        this.dka.an(i, str);
    }

    private void cc(String str, String str2) {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "dispatchCallback: " + str + " " + str2);
        }
        if (this.dka != null && !TextUtils.isEmpty(str)) {
            this.dka.pf(str);
            return;
        }
        com.baidu.swan.apps.v.f.azN().b(new com.baidu.swan.apps.event.a.b(str2));
    }

    private void aBv() {
        long j;
        long j2;
        String cG = com.baidu.swan.apps.storage.b.cG(this.djT, this.mAppId);
        if (TextUtils.isEmpty(this.djT)) {
            j = -1;
            j2 = -1;
        } else {
            long yz = com.baidu.swan.c.d.yz(this.djT);
            j = new File(this.djT).length();
            j2 = yz;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(cG)) {
                jSONObject.put("tempFilePath", cG);
            }
            if (j2 >= 0) {
                jSONObject.put("duration", j2);
            }
            if (j >= 0) {
                jSONObject.put("fileSize", j);
            }
            if (this.dka != null && !TextUtils.isEmpty(com.baidu.swan.apps.media.a.b.djJ)) {
                this.dka.h(com.baidu.swan.apps.media.a.b.djJ, jSONObject);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            com.baidu.swan.apps.v.f.azN().b(new com.baidu.swan.apps.event.a.b("recorderStop", hashMap));
        } catch (JSONException e) {
            aBu();
            c.e("recorder", "json error", e);
            aBr();
        }
    }

    private void aBw() {
        if (this.mContext != null) {
            this.mTelephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
            this.dkb = new com.baidu.swan.apps.media.a.b.a();
            this.mTelephonyManager.listen(this.dkb, 32);
        }
    }

    private void aBx() {
        if (this.mTelephonyManager != null && this.dkb != null) {
            this.mTelephonyManager.listen(this.dkb, 0);
            this.mTelephonyManager = null;
            this.dkb = null;
        }
    }
}
