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
/* loaded from: classes3.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a cDT;
    private String cDU;
    private int cDV;
    private com.baidu.swan.apps.media.a.b.b cDX;
    private long cDY;
    private long cDZ;
    private com.baidu.swan.apps.media.a.b cEb;
    private com.baidu.swan.apps.media.a.b.a cEc;
    private String mAppId;
    private AudioRecord mAudioRecord;
    private Context mContext;
    private boolean mIsBackground;
    private TelephonyManager mTelephonyManager;
    private Timer mTimer;
    private int cDW = -1;
    private com.baidu.swan.apps.media.a.a cEa = new com.baidu.swan.apps.media.a.a();
    private boolean cEd = false;

    private a() {
    }

    public static a auh() {
        if (cDT == null) {
            synchronized (a.class) {
                if (cDT == null) {
                    cDT = new a();
                }
            }
        }
        return cDT;
    }

    public void a(String str, com.baidu.swan.apps.media.a.a aVar, Context context, com.baidu.swan.apps.media.a.b bVar, String str2) {
        int i;
        if (this.cDW != -1 && this.cDW != 3) {
            c.e("recorder", "wrong state, can't init");
            return;
        }
        this.cEa = aVar;
        oQ(str);
        this.cEb = bVar;
        this.cDV = AudioRecord.getMinBufferSize(aVar.sampleRate, aVar.channel, 2);
        if (this.cDV <= 0) {
            auo();
            c.e("recorder", "wrong buffer size");
            aul();
            return;
        }
        if (aVar.channel == 1) {
            i = 16;
        } else {
            i = 12;
        }
        this.mAudioRecord = new AudioRecord(aVar.cDF, aVar.sampleRate, i, 2, this.cDV);
        this.cDW = 0;
        this.mContext = context;
        this.mAppId = str2;
        auq();
    }

    private void oQ(String str) {
        String str2;
        if (TextUtils.equals(this.cEa.cDE, "mp3")) {
            str2 = ".mp3";
        } else if (TextUtils.equals(this.cEa.cDE, "pcm")) {
            str2 = ".pcm";
        } else {
            str2 = ".aac";
        }
        this.cDU = str + File.separator + "AUDIO_" + Calendar.getInstance().getTimeInMillis() + str2;
    }

    public void eN(boolean z) {
        if (this.mContext == null) {
            auo();
            c.e("recorder", "start error, context is null");
            aul();
        } else if (this.cDW == -1 || TextUtils.isEmpty(this.cDU)) {
            auo();
            c.e("recorder", "start error, wrong state");
            aul();
        } else {
            if (z) {
                String str = null;
                if (this.cDW == 1) {
                    str = "start fail: recorder is recording";
                } else if (this.cDW != 0 && this.cDW != 3) {
                    str = "start fail: recorder is paused";
                }
                if (str != null) {
                    T(2003, str);
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
                    auo();
                    c.e("recorder", "start error, no real permission");
                    aul();
                    return;
                }
                if (z) {
                    a(new com.baidu.swan.apps.media.a.b.b() { // from class: com.baidu.swan.apps.media.a.c.a.1
                        @Override // com.baidu.swan.apps.media.a.b.b
                        public void adm() {
                            if (a.DEBUG) {
                                Log.d("AudioRecorderManager", "record --- timeOut");
                            }
                            c.i("recorder", "time out");
                            a.this.stopRecord();
                            a.this.aul();
                        }
                    });
                    bM(com.baidu.swan.apps.media.a.b.cDH, "recorderStart");
                } else {
                    bM(com.baidu.swan.apps.media.a.b.cDJ, "recorderResume");
                }
                d.bW("").d(Schedulers.io()).d(new f<String, Boolean>() { // from class: com.baidu.swan.apps.media.a.c.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.f
                    /* renamed from: oT */
                    public Boolean call(String str2) {
                        return Boolean.valueOf(a.this.auk());
                    }
                }).c(rx.a.b.a.eoa()).c(new rx.functions.b<Boolean>() { // from class: com.baidu.swan.apps.media.a.c.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.b
                    /* renamed from: h */
                    public void call(Boolean bool) {
                        if (!bool.booleanValue()) {
                            a.this.auo();
                            c.e("recorder", "record error");
                            a.this.aul();
                        }
                    }
                });
            } catch (IllegalStateException e) {
                auo();
                c.e("recorder", "can't start", e);
                aul();
            }
        }
    }

    public void pauseRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "pause record");
        }
        if (this.mAudioRecord == null) {
            auo();
            c.e("recorder", "none audio record");
            aul();
            return;
        }
        try {
            this.mAudioRecord.stop();
            this.cDW = 2;
            asF();
            bM(com.baidu.swan.apps.media.a.b.cDI, "recorderPause");
        } catch (IllegalStateException e) {
            auo();
            c.e("recorder", "pause error", e);
            aul();
        }
    }

    public void resumeRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "resume record");
        }
        eN(false);
        asE();
    }

    public void stopRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "stop record");
        }
        if (this.mAudioRecord == null) {
            auo();
            c.e("recorder", "none audioRecord");
            aul();
            return;
        }
        try {
            this.mAudioRecord.stop();
            adk();
            this.cDW = 3;
            aup();
            aur();
        } catch (IllegalStateException e) {
            auo();
            c.e("recorder", "stop error", e);
            aul();
        }
    }

    public void aui() {
        if (this.cDW == 0 || this.cDW == 1) {
            if (!this.cEd) {
                this.cEd = true;
                bM(com.baidu.swan.apps.media.a.b.cDM, "recorderInterruptionBegin");
            }
            pauseRecord();
        }
    }

    public void auj() {
        if (this.cEd) {
            this.cEd = false;
            bM(com.baidu.swan.apps.media.a.b.cDN, "recorderInterruptionEnd");
        }
    }

    public boolean auk() {
        byte[] bArr = new byte[this.cDV];
        com.baidu.swan.apps.media.a.d.a aVar = new com.baidu.swan.apps.media.a.d.a(this.cEa.cDE, this.cEa.channel, this.cEa.sampleRate, this.cEa.bitRate);
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
                File file = new File(this.cDU);
                if (this.cDW == 0) {
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
            this.cDW = 1;
            while (this.cDW == 1) {
                if (this.mAudioRecord.read(bArr, 0, this.cDV) >= 0) {
                    byte[] K = TextUtils.equals(this.cEa.cDE, "pcm") ? bArr : aVar.K(bArr);
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
            if (this.cDW == 1) {
                this.cDW = 3;
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
            Log.d("AudioRecorderManager", "start timer:" + this.cEa.cDD);
        }
        c.i("recorder", "start timer, totalTime:" + this.cEa.cDD);
        this.cDX = bVar;
        this.mTimer = new Timer();
        this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.a.c.a.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (bVar != null) {
                    bVar.adm();
                }
                a.this.adk();
            }
        }, this.cEa.cDD);
        this.cDY = System.currentTimeMillis();
    }

    public void adk() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "stop timer");
        }
        c.i("recorder", "stop timer");
        this.cDX = null;
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
    }

    public void asF() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "pause timer, lastTime:" + this.cDZ);
        }
        c.i("recorder", "pause timer, lastTime:" + this.cDZ);
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        this.cDZ = this.cEa.cDD - (System.currentTimeMillis() - this.cDY);
    }

    public void asE() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "resume timer");
        }
        c.i("recorder", "resume timer");
        if (this.cDX != null) {
            if (this.cDZ <= 0) {
                this.cDX.adm();
                return;
            }
            this.mTimer = new Timer();
            this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.a.c.a.5
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (a.this.cDX != null) {
                        a.this.cDX.adm();
                    }
                    a.this.adk();
                }
            }, this.cDZ);
            this.cDY = System.currentTimeMillis();
        }
    }

    public void dB(boolean z) {
        if (z && this.cDW == 1) {
            pauseRecord();
        }
        this.mIsBackground = z;
    }

    public static void eO(boolean z) {
        if (cDT != null) {
            cDT.dB(z);
        }
    }

    public static void release() {
        if (cDT != null) {
            cDT.aul();
            cDT.aur();
            cDT.auj();
        }
    }

    public static void releaseAll() {
        release();
        cDT = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aul() {
        adk();
        this.mContext = null;
        this.cDW = -1;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
            this.mAudioRecord = null;
        }
    }

    public com.baidu.swan.apps.media.a.a aum() {
        return this.cEa;
    }

    public com.baidu.swan.apps.media.a.b aun() {
        return this.cEb;
    }

    public boolean oR(String str) {
        String str2 = null;
        if (TextUtils.equals(str, "/swanAPI/recorder/pause")) {
            if (this.cDW != 1) {
                str2 = "pause fail: recorder is not recording";
            }
        } else if (TextUtils.equals(str, "/swanAPI/recorder/resume")) {
            if (this.cDW != 2) {
                str2 = "resume fail: recorder is not paused";
            }
        } else if (TextUtils.equals(str, "/swanAPI/recorder/stop") && this.cDW != 2 && this.cDW != 1) {
            str2 = "stop fail: recorder is not started";
        }
        if (str2 != null) {
            T(2003, str2);
            c.e("recorder", str2);
            return false;
        }
        return true;
    }

    public boolean oS(String str) {
        if (this.mIsBackground) {
            return TextUtils.equals(str, "/swanAPI/recorder/start") || TextUtils.equals(str, "/swanAPI/recorder/resume");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auo() {
        T(2002, "error execute");
    }

    private void T(int i, String str) {
        if (this.cEb == null || TextUtils.isEmpty(com.baidu.swan.apps.media.a.b.cDL)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errCode", i);
                jSONObject.put("errMsg", str);
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                com.baidu.swan.apps.v.f.asJ().b(new com.baidu.swan.apps.event.a.b("recorderError", hashMap));
                return;
            } catch (JSONException e) {
                c.e("recorder", "json error", e);
                aul();
                return;
            }
        }
        this.cEb.T(i, str);
    }

    private void bM(String str, String str2) {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "dispatchCallback: " + str + " " + str2);
        }
        if (this.cEb != null && !TextUtils.isEmpty(str)) {
            this.cEb.oD(str);
            return;
        }
        com.baidu.swan.apps.v.f.asJ().b(new com.baidu.swan.apps.event.a.b(str2));
    }

    private void aup() {
        long j;
        long j2 = -1;
        String cq = com.baidu.swan.apps.storage.b.cq(this.cDU, this.mAppId);
        if (TextUtils.isEmpty(this.cDU)) {
            j = -1;
        } else {
            j = com.baidu.swan.c.d.xQ(this.cDU);
            j2 = new File(this.cDU).length();
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
            if (this.cEb != null && !TextUtils.isEmpty(com.baidu.swan.apps.media.a.b.cDK)) {
                this.cEb.e(com.baidu.swan.apps.media.a.b.cDK, jSONObject);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            com.baidu.swan.apps.v.f.asJ().b(new com.baidu.swan.apps.event.a.b("recorderStop", hashMap));
        } catch (JSONException e) {
            auo();
            c.e("recorder", "json error", e);
            aul();
        }
    }

    private void auq() {
        if (this.mContext != null) {
            this.mTelephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
            this.cEc = new com.baidu.swan.apps.media.a.b.a();
            this.mTelephonyManager.listen(this.cEc, 32);
        }
    }

    private void aur() {
        if (this.mTelephonyManager != null && this.cEc != null) {
            this.mTelephonyManager.listen(this.cEc, 0);
            this.mTelephonyManager = null;
            this.cEc = null;
        }
    }
}
