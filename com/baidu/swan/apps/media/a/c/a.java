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
    private static volatile a dep;
    private String deq;
    private int der;
    private com.baidu.swan.apps.media.a.b.b deu;
    private long dev;
    private long dew;
    private com.baidu.swan.apps.media.a.b dey;
    private com.baidu.swan.apps.media.a.b.a dez;
    private String mAppId;
    private AudioRecord mAudioRecord;
    private Context mContext;
    private boolean mIsBackground;
    private TelephonyManager mTelephonyManager;
    private Timer mTimer;
    private int det = -1;
    private com.baidu.swan.apps.media.a.a dex = new com.baidu.swan.apps.media.a.a();
    private boolean deA = false;

    private a() {
    }

    public static a aBm() {
        if (dep == null) {
            synchronized (a.class) {
                if (dep == null) {
                    dep = new a();
                }
            }
        }
        return dep;
    }

    public void a(String str, com.baidu.swan.apps.media.a.a aVar, Context context, com.baidu.swan.apps.media.a.b bVar, String str2) {
        int i;
        if (this.det != -1 && this.det != 3) {
            c.e("recorder", "wrong state, can't init");
            return;
        }
        this.dex = aVar;
        qj(str);
        this.dey = bVar;
        this.der = AudioRecord.getMinBufferSize(aVar.sampleRate, aVar.channel, 2);
        if (this.der <= 0) {
            aBt();
            c.e("recorder", "wrong buffer size");
            aBq();
            return;
        }
        if (aVar.channel == 1) {
            i = 16;
        } else {
            i = 12;
        }
        this.mAudioRecord = new AudioRecord(aVar.audioSource, aVar.sampleRate, i, 2, this.der);
        this.det = 0;
        this.mContext = context;
        this.mAppId = str2;
        aBv();
    }

    private void qj(String str) {
        String str2;
        if (TextUtils.equals(this.dex.deb, "mp3")) {
            str2 = ".mp3";
        } else if (TextUtils.equals(this.dex.deb, "pcm")) {
            str2 = ".pcm";
        } else {
            str2 = ".aac";
        }
        this.deq = str + File.separator + "AUDIO_" + Calendar.getInstance().getTimeInMillis() + str2;
    }

    public void fF(boolean z) {
        if (this.mContext == null) {
            aBt();
            c.e("recorder", "start error, context is null");
            aBq();
        } else if (this.det == -1 || TextUtils.isEmpty(this.deq)) {
            aBt();
            c.e("recorder", "start error, wrong state");
            aBq();
        } else {
            if (z) {
                String str = null;
                if (this.det == 1) {
                    str = "start fail: recorder is recording";
                } else if (this.det != 0 && this.det != 3) {
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
                    aBt();
                    c.e("recorder", "start error, no real permission");
                    aBq();
                    return;
                }
                if (z) {
                    a(new com.baidu.swan.apps.media.a.b.b() { // from class: com.baidu.swan.apps.media.a.c.a.1
                        @Override // com.baidu.swan.apps.media.a.b.b
                        public void aks() {
                            if (a.DEBUG) {
                                Log.d("AudioRecorderManager", "record --- timeOut");
                            }
                            c.i("recorder", "time out");
                            a.this.stopRecord();
                            a.this.aBq();
                        }
                    });
                    bY(com.baidu.swan.apps.media.a.b.ded, "recorderStart");
                } else {
                    bY(com.baidu.swan.apps.media.a.b.def, "recorderResume");
                }
                d.cd("").d(Schedulers.io()).d(new f<String, Boolean>() { // from class: com.baidu.swan.apps.media.a.c.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.f
                    /* renamed from: qm */
                    public Boolean call(String str2) {
                        return Boolean.valueOf(a.this.aBp());
                    }
                }).c(rx.a.b.a.eFz()).c(new rx.functions.b<Boolean>() { // from class: com.baidu.swan.apps.media.a.c.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.b
                    /* renamed from: i */
                    public void call(Boolean bool) {
                        if (!bool.booleanValue()) {
                            a.this.aBt();
                            c.e("recorder", "record error");
                            a.this.aBq();
                        }
                    }
                });
            } catch (IllegalStateException e) {
                aBt();
                c.e("recorder", "can't start", e);
                aBq();
            }
        }
    }

    public void pauseRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "pause record");
        }
        if (this.mAudioRecord == null) {
            aBt();
            c.e("recorder", "none audio record");
            aBq();
            return;
        }
        try {
            this.mAudioRecord.stop();
            this.det = 2;
            azK();
            bY(com.baidu.swan.apps.media.a.b.dee, "recorderPause");
        } catch (IllegalStateException e) {
            aBt();
            c.e("recorder", "pause error", e);
            aBq();
        }
    }

    public void resumeRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "resume record");
        }
        fF(false);
        azJ();
    }

    public void stopRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "stop record");
        }
        if (this.mAudioRecord == null) {
            aBt();
            c.e("recorder", "none audioRecord");
            aBq();
            return;
        }
        try {
            this.mAudioRecord.stop();
            akq();
            this.det = 3;
            aBu();
            aBw();
        } catch (IllegalStateException e) {
            aBt();
            c.e("recorder", "stop error", e);
            aBq();
        }
    }

    public void aBn() {
        if (this.det == 0 || this.det == 1) {
            if (!this.deA) {
                this.deA = true;
                bY(com.baidu.swan.apps.media.a.b.dei, "recorderInterruptionBegin");
            }
            pauseRecord();
        }
    }

    public void aBo() {
        if (this.deA) {
            this.deA = false;
            bY(com.baidu.swan.apps.media.a.b.dej, "recorderInterruptionEnd");
        }
    }

    public boolean aBp() {
        byte[] bArr = new byte[this.der];
        com.baidu.swan.apps.media.a.d.a aVar = new com.baidu.swan.apps.media.a.d.a(this.dex.deb, this.dex.channel, this.dex.sampleRate, this.dex.bitRate);
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
                File file = new File(this.deq);
                if (this.det == 0) {
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
            this.det = 1;
            while (this.det == 1) {
                if (this.mAudioRecord.read(bArr, 0, this.der) >= 0) {
                    byte[] K = TextUtils.equals(this.dex.deb, "pcm") ? bArr : aVar.K(bArr);
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
            if (this.det == 1) {
                this.det = 3;
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
            Log.d("AudioRecorderManager", "start timer:" + this.dex.dea);
        }
        c.i("recorder", "start timer, totalTime:" + this.dex.dea);
        this.deu = bVar;
        this.mTimer = new Timer();
        this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.a.c.a.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (bVar != null) {
                    bVar.aks();
                }
                a.this.akq();
            }
        }, this.dex.dea);
        this.dev = System.currentTimeMillis();
    }

    public void akq() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "stop timer");
        }
        c.i("recorder", "stop timer");
        this.deu = null;
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
    }

    public void azK() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "pause timer, lastTime:" + this.dew);
        }
        c.i("recorder", "pause timer, lastTime:" + this.dew);
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        this.dew = this.dex.dea - (System.currentTimeMillis() - this.dev);
    }

    public void azJ() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "resume timer");
        }
        c.i("recorder", "resume timer");
        if (this.deu != null) {
            if (this.dew <= 0) {
                this.deu.aks();
                return;
            }
            this.mTimer = new Timer();
            this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.a.c.a.5
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (a.this.deu != null) {
                        a.this.deu.aks();
                    }
                    a.this.akq();
                }
            }, this.dew);
            this.dev = System.currentTimeMillis();
        }
    }

    public void et(boolean z) {
        if (z && this.det == 1) {
            pauseRecord();
        }
        this.mIsBackground = z;
    }

    public static void fG(boolean z) {
        if (dep != null) {
            dep.et(z);
        }
    }

    public static void release() {
        if (dep != null) {
            dep.aBq();
            dep.aBw();
            dep.aBo();
        }
    }

    public static void releaseAll() {
        release();
        dep = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBq() {
        akq();
        this.mContext = null;
        this.det = -1;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
            this.mAudioRecord = null;
        }
    }

    public com.baidu.swan.apps.media.a.a aBr() {
        return this.dex;
    }

    public com.baidu.swan.apps.media.a.b aBs() {
        return this.dey;
    }

    public boolean qk(String str) {
        String str2 = null;
        if (TextUtils.equals(str, "/swanAPI/recorder/pause")) {
            if (this.det != 1) {
                str2 = "pause fail: recorder is not recording";
            }
        } else if (TextUtils.equals(str, "/swanAPI/recorder/resume")) {
            if (this.det != 2) {
                str2 = "resume fail: recorder is not paused";
            }
        } else if (TextUtils.equals(str, "/swanAPI/recorder/stop") && this.det != 2 && this.det != 1) {
            str2 = "stop fail: recorder is not started";
        }
        if (str2 != null) {
            ak(2003, str2);
            c.e("recorder", str2);
            return false;
        }
        return true;
    }

    public boolean ql(String str) {
        if (this.mIsBackground) {
            return TextUtils.equals(str, "/swanAPI/recorder/start") || TextUtils.equals(str, "/swanAPI/recorder/resume");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBt() {
        ak(2002, "error execute");
    }

    private void ak(int i, String str) {
        if (this.dey == null || TextUtils.isEmpty(com.baidu.swan.apps.media.a.b.deh)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errCode", i);
                jSONObject.put("errMsg", str);
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                com.baidu.swan.apps.v.f.azO().b(new com.baidu.swan.apps.event.a.b("recorderError", hashMap));
                return;
            } catch (JSONException e) {
                c.e("recorder", "json error", e);
                aBq();
                return;
            }
        }
        this.dey.ak(i, str);
    }

    private void bY(String str, String str2) {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "dispatchCallback: " + str + " " + str2);
        }
        if (this.dey != null && !TextUtils.isEmpty(str)) {
            this.dey.pW(str);
            return;
        }
        com.baidu.swan.apps.v.f.azO().b(new com.baidu.swan.apps.event.a.b(str2));
    }

    private void aBu() {
        long j;
        long j2 = -1;
        String cC = com.baidu.swan.apps.storage.b.cC(this.deq, this.mAppId);
        if (TextUtils.isEmpty(this.deq)) {
            j = -1;
        } else {
            j = com.baidu.swan.c.d.zj(this.deq);
            j2 = new File(this.deq).length();
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
            if (this.dey != null && !TextUtils.isEmpty(com.baidu.swan.apps.media.a.b.deg)) {
                this.dey.g(com.baidu.swan.apps.media.a.b.deg, jSONObject);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            com.baidu.swan.apps.v.f.azO().b(new com.baidu.swan.apps.event.a.b("recorderStop", hashMap));
        } catch (JSONException e) {
            aBt();
            c.e("recorder", "json error", e);
            aBq();
        }
    }

    private void aBv() {
        if (this.mContext != null) {
            this.mTelephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
            this.dez = new com.baidu.swan.apps.media.a.b.a();
            this.mTelephonyManager.listen(this.dez, 32);
        }
    }

    private void aBw() {
        if (this.mTelephonyManager != null && this.dez != null) {
            this.mTelephonyManager.listen(this.dez, 0);
            this.mTelephonyManager = null;
            this.dez = null;
        }
    }
}
