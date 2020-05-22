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
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a cnn;
    private String cno;
    private int cnp;
    private com.baidu.swan.apps.media.a.b.b cnr;
    private long cns;
    private long cnu;
    private com.baidu.swan.apps.media.a.b cnw;
    private com.baidu.swan.apps.media.a.b.a cnx;
    private String mAppId;
    private AudioRecord mAudioRecord;
    private Context mContext;
    private boolean mIsBackground;
    private TelephonyManager mTelephonyManager;
    private Timer mTimer;
    private int cnq = -1;
    private com.baidu.swan.apps.media.a.a cnv = new com.baidu.swan.apps.media.a.a();
    private boolean cny = false;

    private a() {
    }

    public static a ajp() {
        if (cnn == null) {
            synchronized (a.class) {
                if (cnn == null) {
                    cnn = new a();
                }
            }
        }
        return cnn;
    }

    public void a(String str, com.baidu.swan.apps.media.a.a aVar, Context context, com.baidu.swan.apps.media.a.b bVar, String str2) {
        int i;
        if (this.cnq != -1 && this.cnq != 3) {
            c.e("recorder", "wrong state, can't init");
            return;
        }
        this.cnv = aVar;
        lO(str);
        this.cnw = bVar;
        this.cnp = AudioRecord.getMinBufferSize(aVar.sampleRate, aVar.channel, 2);
        if (this.cnp <= 0) {
            ajw();
            c.e("recorder", "wrong buffer size");
            ajt();
            return;
        }
        if (aVar.channel == 1) {
            i = 16;
        } else {
            i = 12;
        }
        this.mAudioRecord = new AudioRecord(aVar.cmZ, aVar.sampleRate, i, 2, this.cnp);
        this.cnq = 0;
        this.mContext = context;
        this.mAppId = str2;
        ajy();
    }

    private void lO(String str) {
        String str2;
        if (TextUtils.equals(this.cnv.cmY, "mp3")) {
            str2 = ".mp3";
        } else if (TextUtils.equals(this.cnv.cmY, "pcm")) {
            str2 = ".pcm";
        } else {
            str2 = ".aac";
        }
        this.cno = str + File.separator + "AUDIO_" + Calendar.getInstance().getTimeInMillis() + str2;
    }

    public void el(boolean z) {
        if (this.mContext == null) {
            ajw();
            c.e("recorder", "start error, context is null");
            ajt();
        } else if (this.cnq == -1 || TextUtils.isEmpty(this.cno)) {
            ajw();
            c.e("recorder", "start error, wrong state");
            ajt();
        } else {
            if (z) {
                String str = null;
                if (this.cnq == 1) {
                    str = "start fail: recorder is recording";
                } else if (this.cnq != 0 && this.cnq != 3) {
                    str = "start fail: recorder is paused";
                }
                if (str != null) {
                    R(2003, str);
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
                    ajw();
                    c.e("recorder", "start error, no real permission");
                    ajt();
                    return;
                }
                if (z) {
                    a(new com.baidu.swan.apps.media.a.b.b() { // from class: com.baidu.swan.apps.media.a.c.a.1
                        @Override // com.baidu.swan.apps.media.a.b.b
                        public void UK() {
                            if (a.DEBUG) {
                                Log.d("AudioRecorderManager", "record --- timeOut");
                            }
                            c.i("recorder", "time out");
                            a.this.stopRecord();
                            a.this.ajt();
                        }
                    });
                    bv(com.baidu.swan.apps.media.a.b.cnb, "recorderStart");
                } else {
                    bv(com.baidu.swan.apps.media.a.b.cnd, "recorderResume");
                }
                d.bR("").d(Schedulers.io()).d(new f<String, Boolean>() { // from class: com.baidu.swan.apps.media.a.c.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.f
                    /* renamed from: lR */
                    public Boolean call(String str2) {
                        return Boolean.valueOf(a.this.ajs());
                    }
                }).c(rx.a.b.a.dPv()).c(new rx.functions.b<Boolean>() { // from class: com.baidu.swan.apps.media.a.c.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.b
                    /* renamed from: e */
                    public void call(Boolean bool) {
                        if (!bool.booleanValue()) {
                            a.this.ajw();
                            c.e("recorder", "record error");
                            a.this.ajt();
                        }
                    }
                });
            } catch (IllegalStateException e) {
                ajw();
                c.e("recorder", "can't start", e);
                ajt();
            }
        }
    }

    public void pauseRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "pause record");
        }
        if (this.mAudioRecord == null) {
            ajw();
            c.e("recorder", "none audio record");
            ajt();
            return;
        }
        try {
            this.mAudioRecord.stop();
            this.cnq = 2;
            ahR();
            bv(com.baidu.swan.apps.media.a.b.cnc, "recorderPause");
        } catch (IllegalStateException e) {
            ajw();
            c.e("recorder", "pause error", e);
            ajt();
        }
    }

    public void resumeRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "resume record");
        }
        el(false);
        ahQ();
    }

    public void stopRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "stop record");
        }
        if (this.mAudioRecord == null) {
            ajw();
            c.e("recorder", "none audioRecord");
            ajt();
            return;
        }
        try {
            this.mAudioRecord.stop();
            UI();
            this.cnq = 3;
            ajx();
            ajz();
        } catch (IllegalStateException e) {
            ajw();
            c.e("recorder", "stop error", e);
            ajt();
        }
    }

    public void ajq() {
        if (this.cnq == 0 || this.cnq == 1) {
            if (!this.cny) {
                this.cny = true;
                bv(com.baidu.swan.apps.media.a.b.cng, "recorderInterruptionBegin");
            }
            pauseRecord();
        }
    }

    public void ajr() {
        if (this.cny) {
            this.cny = false;
            bv(com.baidu.swan.apps.media.a.b.cnh, "recorderInterruptionEnd");
        }
    }

    public boolean ajs() {
        byte[] bArr = new byte[this.cnp];
        com.baidu.swan.apps.media.a.d.a aVar = new com.baidu.swan.apps.media.a.d.a(this.cnv.cmY, this.cnv.channel, this.cnv.sampleRate, this.cnv.bitRate);
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
                File file = new File(this.cno);
                if (this.cnq == 0) {
                    if (file.exists()) {
                        file.delete();
                    }
                    com.baidu.swan.e.d.createNewFileSafely(file);
                }
                fileOutputStream = new FileOutputStream(file, true);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            this.cnq = 1;
            while (this.cnq == 1) {
                if (this.mAudioRecord.read(bArr, 0, this.cnp) >= 0) {
                    byte[] H = TextUtils.equals(this.cnv.cmY, "pcm") ? bArr : aVar.H(bArr);
                    if (H != null && H.length > 0) {
                        fileOutputStream.write(H);
                    }
                }
            }
            com.baidu.swan.e.d.closeSafely(fileOutputStream);
            return true;
        } catch (Exception e2) {
            e = e2;
            fileOutputStream2 = fileOutputStream;
            c.e("recorder", "save record error", e);
            if (this.cnq == 1) {
                this.cnq = 3;
            }
            com.baidu.swan.e.d.closeSafely(fileOutputStream2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            com.baidu.swan.e.d.closeSafely(fileOutputStream2);
            throw th;
        }
    }

    public void a(final com.baidu.swan.apps.media.a.b.b bVar) {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "start timer:" + this.cnv.cmX);
        }
        c.i("recorder", "start timer, totalTime:" + this.cnv.cmX);
        this.cnr = bVar;
        this.mTimer = new Timer();
        this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.a.c.a.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (bVar != null) {
                    bVar.UK();
                }
                a.this.UI();
            }
        }, this.cnv.cmX);
        this.cns = System.currentTimeMillis();
    }

    public void UI() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "stop timer");
        }
        c.i("recorder", "stop timer");
        this.cnr = null;
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
    }

    public void ahR() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "pause timer, lastTime:" + this.cnu);
        }
        c.i("recorder", "pause timer, lastTime:" + this.cnu);
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        this.cnu = this.cnv.cmX - (System.currentTimeMillis() - this.cns);
    }

    public void ahQ() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "resume timer");
        }
        c.i("recorder", "resume timer");
        if (this.cnr != null) {
            if (this.cnu <= 0) {
                this.cnr.UK();
                return;
            }
            this.mTimer = new Timer();
            this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.a.c.a.5
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (a.this.cnr != null) {
                        a.this.cnr.UK();
                    }
                    a.this.UI();
                }
            }, this.cnu);
            this.cns = System.currentTimeMillis();
        }
    }

    public void dl(boolean z) {
        if (z && this.cnq == 1) {
            pauseRecord();
        }
        this.mIsBackground = z;
    }

    public static void em(boolean z) {
        if (cnn != null) {
            cnn.dl(z);
        }
    }

    public static void release() {
        if (cnn != null) {
            cnn.ajt();
            cnn.ajz();
            cnn.ajr();
        }
    }

    public static void releaseAll() {
        release();
        cnn = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajt() {
        UI();
        this.mContext = null;
        this.cnq = -1;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
            this.mAudioRecord = null;
        }
    }

    public com.baidu.swan.apps.media.a.a aju() {
        return this.cnv;
    }

    public com.baidu.swan.apps.media.a.b ajv() {
        return this.cnw;
    }

    public boolean lP(String str) {
        String str2 = null;
        if (TextUtils.equals(str, "/swanAPI/recorder/pause")) {
            if (this.cnq != 1) {
                str2 = "pause fail: recorder is not recording";
            }
        } else if (TextUtils.equals(str, "/swanAPI/recorder/resume")) {
            if (this.cnq != 2) {
                str2 = "resume fail: recorder is not paused";
            }
        } else if (TextUtils.equals(str, "/swanAPI/recorder/stop") && this.cnq != 2 && this.cnq != 1) {
            str2 = "stop fail: recorder is not started";
        }
        if (str2 != null) {
            R(2003, str2);
            c.e("recorder", str2);
            return false;
        }
        return true;
    }

    public boolean lQ(String str) {
        if (this.mIsBackground) {
            return TextUtils.equals(str, "/swanAPI/recorder/start") || TextUtils.equals(str, "/swanAPI/recorder/resume");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajw() {
        R(2002, "error execute");
    }

    private void R(int i, String str) {
        if (this.cnw == null || TextUtils.isEmpty(com.baidu.swan.apps.media.a.b.cnf)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errCode", i);
                jSONObject.put("errMsg", str);
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                com.baidu.swan.apps.w.f.ahV().a(new com.baidu.swan.apps.event.a.b("recorderError", hashMap));
                return;
            } catch (JSONException e) {
                c.e("recorder", "json error", e);
                ajt();
                return;
            }
        }
        this.cnw.R(i, str);
    }

    private void bv(String str, String str2) {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "dispatchCallback: " + str + " " + str2);
        }
        if (this.cnw != null && !TextUtils.isEmpty(str)) {
            this.cnw.lB(str);
            return;
        }
        com.baidu.swan.apps.w.f.ahV().a(new com.baidu.swan.apps.event.a.b(str2));
    }

    private void ajx() {
        long j;
        long j2 = -1;
        String bW = com.baidu.swan.apps.storage.b.bW(this.cno, this.mAppId);
        if (TextUtils.isEmpty(this.cno)) {
            j = -1;
        } else {
            j = com.baidu.swan.e.d.ua(this.cno);
            j2 = new File(this.cno).length();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(bW)) {
                jSONObject.put("tempFilePath", bW);
            }
            if (j >= 0) {
                jSONObject.put("duration", j);
            }
            if (j2 >= 0) {
                jSONObject.put("fileSize", j2);
            }
            if (this.cnw != null && !TextUtils.isEmpty(com.baidu.swan.apps.media.a.b.cne)) {
                this.cnw.e(com.baidu.swan.apps.media.a.b.cne, jSONObject);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            com.baidu.swan.apps.w.f.ahV().a(new com.baidu.swan.apps.event.a.b("recorderStop", hashMap));
        } catch (JSONException e) {
            ajw();
            c.e("recorder", "json error", e);
            ajt();
        }
    }

    private void ajy() {
        if (this.mContext != null) {
            this.mTelephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
            this.cnx = new com.baidu.swan.apps.media.a.b.a();
            this.mTelephonyManager.listen(this.cnx, 32);
        }
    }

    private void ajz() {
        if (this.mTelephonyManager != null && this.cnx != null) {
            this.mTelephonyManager.listen(this.cnx, 0);
            this.mTelephonyManager = null;
            this.cnx = null;
        }
    }
}
