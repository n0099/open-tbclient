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
    private static volatile a cPX;
    private String cPY;
    private int cPZ;
    private com.baidu.swan.apps.media.a.b.b cQb;
    private long cQc;
    private long cQd;
    private com.baidu.swan.apps.media.a.b cQf;
    private com.baidu.swan.apps.media.a.b.a cQg;
    private String mAppId;
    private AudioRecord mAudioRecord;
    private Context mContext;
    private boolean mIsBackground;
    private TelephonyManager mTelephonyManager;
    private Timer mTimer;
    private int cQa = -1;
    private com.baidu.swan.apps.media.a.a cQe = new com.baidu.swan.apps.media.a.a();
    private boolean cQh = false;

    private a() {
    }

    public static a awS() {
        if (cPX == null) {
            synchronized (a.class) {
                if (cPX == null) {
                    cPX = new a();
                }
            }
        }
        return cPX;
    }

    public void a(String str, com.baidu.swan.apps.media.a.a aVar, Context context, com.baidu.swan.apps.media.a.b bVar, String str2) {
        int i;
        if (this.cQa != -1 && this.cQa != 3) {
            c.e("recorder", "wrong state, can't init");
            return;
        }
        this.cQe = aVar;
        pC(str);
        this.cQf = bVar;
        this.cPZ = AudioRecord.getMinBufferSize(aVar.sampleRate, aVar.channel, 2);
        if (this.cPZ <= 0) {
            awZ();
            c.e("recorder", "wrong buffer size");
            awW();
            return;
        }
        if (aVar.channel == 1) {
            i = 16;
        } else {
            i = 12;
        }
        this.mAudioRecord = new AudioRecord(aVar.audioSource, aVar.sampleRate, i, 2, this.cPZ);
        this.cQa = 0;
        this.mContext = context;
        this.mAppId = str2;
        axb();
    }

    private void pC(String str) {
        String str2;
        if (TextUtils.equals(this.cQe.cPJ, "mp3")) {
            str2 = ".mp3";
        } else if (TextUtils.equals(this.cQe.cPJ, "pcm")) {
            str2 = ".pcm";
        } else {
            str2 = ".aac";
        }
        this.cPY = str + File.separator + "AUDIO_" + Calendar.getInstance().getTimeInMillis() + str2;
    }

    public void fj(boolean z) {
        if (this.mContext == null) {
            awZ();
            c.e("recorder", "start error, context is null");
            awW();
        } else if (this.cQa == -1 || TextUtils.isEmpty(this.cPY)) {
            awZ();
            c.e("recorder", "start error, wrong state");
            awW();
        } else {
            if (z) {
                String str = null;
                if (this.cQa == 1) {
                    str = "start fail: recorder is recording";
                } else if (this.cQa != 0 && this.cQa != 3) {
                    str = "start fail: recorder is paused";
                }
                if (str != null) {
                    ae(2003, str);
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
                    awZ();
                    c.e("recorder", "start error, no real permission");
                    awW();
                    return;
                }
                if (z) {
                    a(new com.baidu.swan.apps.media.a.b.b() { // from class: com.baidu.swan.apps.media.a.c.a.1
                        @Override // com.baidu.swan.apps.media.a.b.b
                        public void afY() {
                            if (a.DEBUG) {
                                Log.d("AudioRecorderManager", "record --- timeOut");
                            }
                            c.i("recorder", "time out");
                            a.this.stopRecord();
                            a.this.awW();
                        }
                    });
                    bR(com.baidu.swan.apps.media.a.b.cPL, "recorderStart");
                } else {
                    bR(com.baidu.swan.apps.media.a.b.cPN, "recorderResume");
                }
                d.bZ("").d(Schedulers.io()).d(new f<String, Boolean>() { // from class: com.baidu.swan.apps.media.a.c.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.f
                    /* renamed from: pF */
                    public Boolean call(String str2) {
                        return Boolean.valueOf(a.this.awV());
                    }
                }).c(rx.a.b.a.erM()).c(new rx.functions.b<Boolean>() { // from class: com.baidu.swan.apps.media.a.c.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.b
                    /* renamed from: i */
                    public void call(Boolean bool) {
                        if (!bool.booleanValue()) {
                            a.this.awZ();
                            c.e("recorder", "record error");
                            a.this.awW();
                        }
                    }
                });
            } catch (IllegalStateException e) {
                awZ();
                c.e("recorder", "can't start", e);
                awW();
            }
        }
    }

    public void pauseRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "pause record");
        }
        if (this.mAudioRecord == null) {
            awZ();
            c.e("recorder", "none audio record");
            awW();
            return;
        }
        try {
            this.mAudioRecord.stop();
            this.cQa = 2;
            avq();
            bR(com.baidu.swan.apps.media.a.b.cPM, "recorderPause");
        } catch (IllegalStateException e) {
            awZ();
            c.e("recorder", "pause error", e);
            awW();
        }
    }

    public void resumeRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "resume record");
        }
        fj(false);
        avp();
    }

    public void stopRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "stop record");
        }
        if (this.mAudioRecord == null) {
            awZ();
            c.e("recorder", "none audioRecord");
            awW();
            return;
        }
        try {
            this.mAudioRecord.stop();
            afW();
            this.cQa = 3;
            axa();
            axc();
        } catch (IllegalStateException e) {
            awZ();
            c.e("recorder", "stop error", e);
            awW();
        }
    }

    public void awT() {
        if (this.cQa == 0 || this.cQa == 1) {
            if (!this.cQh) {
                this.cQh = true;
                bR(com.baidu.swan.apps.media.a.b.cPQ, "recorderInterruptionBegin");
            }
            pauseRecord();
        }
    }

    public void awU() {
        if (this.cQh) {
            this.cQh = false;
            bR(com.baidu.swan.apps.media.a.b.cPR, "recorderInterruptionEnd");
        }
    }

    public boolean awV() {
        byte[] bArr = new byte[this.cPZ];
        com.baidu.swan.apps.media.a.d.a aVar = new com.baidu.swan.apps.media.a.d.a(this.cQe.cPJ, this.cQe.channel, this.cQe.sampleRate, this.cQe.bitRate);
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
                File file = new File(this.cPY);
                if (this.cQa == 0) {
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
            this.cQa = 1;
            while (this.cQa == 1) {
                if (this.mAudioRecord.read(bArr, 0, this.cPZ) >= 0) {
                    byte[] K = TextUtils.equals(this.cQe.cPJ, "pcm") ? bArr : aVar.K(bArr);
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
            if (this.cQa == 1) {
                this.cQa = 3;
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
            Log.d("AudioRecorderManager", "start timer:" + this.cQe.cPI);
        }
        c.i("recorder", "start timer, totalTime:" + this.cQe.cPI);
        this.cQb = bVar;
        this.mTimer = new Timer();
        this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.a.c.a.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (bVar != null) {
                    bVar.afY();
                }
                a.this.afW();
            }
        }, this.cQe.cPI);
        this.cQc = System.currentTimeMillis();
    }

    public void afW() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "stop timer");
        }
        c.i("recorder", "stop timer");
        this.cQb = null;
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
    }

    public void avq() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "pause timer, lastTime:" + this.cQd);
        }
        c.i("recorder", "pause timer, lastTime:" + this.cQd);
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        this.cQd = this.cQe.cPI - (System.currentTimeMillis() - this.cQc);
    }

    public void avp() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "resume timer");
        }
        c.i("recorder", "resume timer");
        if (this.cQb != null) {
            if (this.cQd <= 0) {
                this.cQb.afY();
                return;
            }
            this.mTimer = new Timer();
            this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.a.c.a.5
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (a.this.cQb != null) {
                        a.this.cQb.afY();
                    }
                    a.this.afW();
                }
            }, this.cQd);
            this.cQc = System.currentTimeMillis();
        }
    }

    public void dX(boolean z) {
        if (z && this.cQa == 1) {
            pauseRecord();
        }
        this.mIsBackground = z;
    }

    public static void fk(boolean z) {
        if (cPX != null) {
            cPX.dX(z);
        }
    }

    public static void release() {
        if (cPX != null) {
            cPX.awW();
            cPX.axc();
            cPX.awU();
        }
    }

    public static void releaseAll() {
        release();
        cPX = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awW() {
        afW();
        this.mContext = null;
        this.cQa = -1;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
            this.mAudioRecord = null;
        }
    }

    public com.baidu.swan.apps.media.a.a awX() {
        return this.cQe;
    }

    public com.baidu.swan.apps.media.a.b awY() {
        return this.cQf;
    }

    public boolean pD(String str) {
        String str2 = null;
        if (TextUtils.equals(str, "/swanAPI/recorder/pause")) {
            if (this.cQa != 1) {
                str2 = "pause fail: recorder is not recording";
            }
        } else if (TextUtils.equals(str, "/swanAPI/recorder/resume")) {
            if (this.cQa != 2) {
                str2 = "resume fail: recorder is not paused";
            }
        } else if (TextUtils.equals(str, "/swanAPI/recorder/stop") && this.cQa != 2 && this.cQa != 1) {
            str2 = "stop fail: recorder is not started";
        }
        if (str2 != null) {
            ae(2003, str2);
            c.e("recorder", str2);
            return false;
        }
        return true;
    }

    public boolean pE(String str) {
        if (this.mIsBackground) {
            return TextUtils.equals(str, "/swanAPI/recorder/start") || TextUtils.equals(str, "/swanAPI/recorder/resume");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awZ() {
        ae(2002, "error execute");
    }

    private void ae(int i, String str) {
        if (this.cQf == null || TextUtils.isEmpty(com.baidu.swan.apps.media.a.b.cPP)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errCode", i);
                jSONObject.put("errMsg", str);
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                com.baidu.swan.apps.v.f.avu().b(new com.baidu.swan.apps.event.a.b("recorderError", hashMap));
                return;
            } catch (JSONException e) {
                c.e("recorder", "json error", e);
                awW();
                return;
            }
        }
        this.cQf.ae(i, str);
    }

    private void bR(String str, String str2) {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "dispatchCallback: " + str + " " + str2);
        }
        if (this.cQf != null && !TextUtils.isEmpty(str)) {
            this.cQf.pp(str);
            return;
        }
        com.baidu.swan.apps.v.f.avu().b(new com.baidu.swan.apps.event.a.b(str2));
    }

    private void axa() {
        long j;
        long j2 = -1;
        String cv = com.baidu.swan.apps.storage.b.cv(this.cPY, this.mAppId);
        if (TextUtils.isEmpty(this.cPY)) {
            j = -1;
        } else {
            j = com.baidu.swan.c.d.yC(this.cPY);
            j2 = new File(this.cPY).length();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(cv)) {
                jSONObject.put("tempFilePath", cv);
            }
            if (j >= 0) {
                jSONObject.put("duration", j);
            }
            if (j2 >= 0) {
                jSONObject.put("fileSize", j2);
            }
            if (this.cQf != null && !TextUtils.isEmpty(com.baidu.swan.apps.media.a.b.cPO)) {
                this.cQf.e(com.baidu.swan.apps.media.a.b.cPO, jSONObject);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            com.baidu.swan.apps.v.f.avu().b(new com.baidu.swan.apps.event.a.b("recorderStop", hashMap));
        } catch (JSONException e) {
            awZ();
            c.e("recorder", "json error", e);
            awW();
        }
    }

    private void axb() {
        if (this.mContext != null) {
            this.mTelephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
            this.cQg = new com.baidu.swan.apps.media.a.b.a();
            this.mTelephonyManager.listen(this.cQg, 32);
        }
    }

    private void axc() {
        if (this.mTelephonyManager != null && this.cQg != null) {
            this.mTelephonyManager.listen(this.cQg, 0);
            this.mTelephonyManager = null;
            this.cQg = null;
        }
    }
}
